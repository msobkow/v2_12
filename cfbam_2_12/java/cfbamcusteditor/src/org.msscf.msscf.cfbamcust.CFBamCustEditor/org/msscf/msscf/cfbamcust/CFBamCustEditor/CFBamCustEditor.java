// Description: Java 13 Custom JavaFX in-memory CFBam editor

/*
 *  MSS Code Factory CFBam 2.12 Cust Editor
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *
 *	This file is part of MSS Code Factory.
 *
 *	MSS Code Factory is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *
 *	You should have received a copy of the GNU General Public License
 *	along with MSS Code Factory.  If not, see https://www.gnu.org/licenses/.
 *
 *	Donations to support MSS Code Factory can be made at
 *	https://www.paypal.com/paypalme2/MarkSobkow
 *
 *	Contact Mark Stephen Sobkow at msobkow@sasktel.net for commercial licensing.
 */

package org.msscf.msscf.cfbamcust.CFBamCustEditor;

import org.apache.log4j.*;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Properties;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.CFReferenceEditor.ICFReferenceCallback;
import org.msscf.msscf.cfcore.MssCF.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfsec.CFSecSaxLoader.*;
import org.msscf.msscf.cfsec.CFSecJavaFX.*;
import org.msscf.msscf.cfseccust.CFSecCust.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfint.CFIntSaxLoader.*;
import org.msscf.msscf.cfint.CFIntJavaFX.*;
import org.msscf.msscf.cfintcust.CFIntCust.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfbam.CFBamObj.*;
import org.msscf.msscf.cfbam.CFBamSaxLoader.*;
import org.msscf.msscf.cfbam.CFBamJavaFX.*;
import org.msscf.msscf.cfbam.CFBamMssCF.*;
import org.msscf.msscf.cfbam.CFBamRam.*;
import org.msscf.msscf.cfbamcust.MSSBamCF.*;
import org.msscf.msscf.cfbamcust.CFBamXmlLoader.*;
import org.msscf.msscf.cfbamcust.CFBamCust.*;

public class CFBamCustEditor
extends Application
{
	private static ICFLibMessageLog log = new CFLibConsoleMessageLog();
	protected static ICFBamSchemaObj schema = null;
	protected static ICFBamCustEditorSchema customSchema = null;
	protected static String modelName = "";
	protected static CFBamRamSchema ramSchema = null;

	// Constructors

	public CFBamCustEditor() {
	}

	@Override public void start( Stage stage ) {

		//CFBamCustMainWindow mainWindow = new CFBamCustMainWindow( customSchema );

		//mainWindow.requestFocus();

		CFBamCustEditorMainPane mainPane = new CFBamCustEditorMainPane( customSchema, modelName );
		mainPane.setCustomSchema( customSchema );
		Scene scene = new Scene( mainPane );

		stage.setTitle( "MSS Code Factory JavaFX BAM Editor" );
		stage.setMinHeight( 640.0 );
		stage.setMinWidth( 1000.0 );
		stage.setScene( scene );
		stage.sizeToScene();
		stage.show();
		stage.requestFocus();
	}

	// Bamessors

	public static ICFBamCustSchema getCustomSchema() {
		return( customSchema );
	}

	public static void setCustomSchema( ICFBamCustEditorSchema argSchema ) {
		customSchema = argSchema;
	}

	// CFBamRamSchema accessors are needed to complete the wiring of the direct request invoker instance
	// that has been bound by the main() to a PostgreSQL persistance implementation.

	public static CFBamRamSchema getRamSchema() {
		return( ramSchema );
	}

	public static void setRamSchema( CFBamRamSchema invoker ) {
		ramSchema = invoker;
	}

	public static ICFBamSchemaObj getSchema() {
		return( schema );
	}

	public static void setSchema( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
	}

	// main() entry point

	public static void main( String args[] ) {
		final String S_ProcName = "CFBamCustEditor.main() ";
		initConsoleLog();

		if( args.length >= 1 ) {
			modelName = args[0];
		}

		if( args.length >= 2 ) {
			if( args[1].equals( "trace" ) ) {
				CFConsole.setLogExceptionsToSystem( true );
			}
			else if( args[1].equals( "notrace" ) ) {
				CFConsole.setLogExceptionsToSystem( false );
			}
			else {
				log.message( S_ProcName + "ERROR: Second argument if specified must be either \"trace\" or \"notrace\"" );
				return;
			}
		}
		else {
			CFConsole.setLogExceptionsToSystem( false );
		}

		if( args.length > 2 ) {
			log.message( S_ProcName + "ERROR: A maximum of two arguments may be specified -- the model name to load and either trace or notrace" );
			return;
		}

		String homeDirName = System.getProperty( "HOME" );
		if( homeDirName == null ) {
			homeDirName = System.getProperty( "user.home" );
			if( homeDirName == null ) {
				log.message( S_ProcName + "ERROR: Home directory not set" );
				return;
			}
		}
		File homeDir = new File( homeDirName );
		if( ! homeDir.exists() ) {
			log.message( S_ProcName + "ERROR: Home directory \"" + homeDirName + "\" does not exist" );
			return;
		}
		if( ! homeDir.isDirectory() ) {
			log.message( S_ProcName + "ERROR: Home directory \"" + homeDirName + "\" is not a directory" );
			return;
		}

		// Configure logging
		Properties sysProps = System.getProperties();
		sysProps.setProperty( "log4j.rootCategory", "WARN" );
		sysProps.setProperty( "org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Log4JLogger" );

		Logger httpLogger = Logger.getLogger( CFBamCustEditor.class );
		httpLogger.setLevel( Level.WARN );

		// The Invoker and it's implementation
		CFBamRamSchema invoker = new CFBamRamSchema();

		// And now for the client side cache implementation that invokes it
		ICFBamSchemaObj clientSchemaObj = new CFBamSchemaObj() {
			public void logout() {
			}
		};
		clientSchemaObj.setBackingStore( invoker );

		ICFSecClusterObj cluster = clientSchemaObj.getClusterTableObj().newInstance();
		ICFSecClusterEditObj editCluster = cluster.beginEdit();
		editCluster.setRequiredFullDomName( "system" );
		editCluster.setRequiredDescription( "system" );
		cluster = editCluster.create();
		editCluster = null;

		ICFSecTenantObj tenant = clientSchemaObj.getTenantTableObj().newInstance();
		ICFSecTenantEditObj editTenant = tenant.beginEdit();
		editTenant.setRequiredContainerCluster( cluster );
		editTenant.setRequiredTenantName( "system" );
		tenant = editTenant.create();
		editTenant = null;

		ICFSecSecUserObj sysuser = clientSchemaObj.getSecUserTableObj().newInstance();
		ICFSecSecUserEditObj editSysuser = sysuser.beginEdit();
		editSysuser.setRequiredEMailAddress( "system" );
		editSysuser.setRequiredLoginId( "system" );
		editSysuser.setRequiredPasswordHash( "" );
		sysuser = editSysuser.create();
		editSysuser = null;

		ICFSecSecSessionObj session = clientSchemaObj.getSecSessionTableObj().newInstance();
		ICFSecSecSessionEditObj editSession = session.beginEdit();
		editSession.setRequiredContainerSecUser( sysuser );
		editSession.setRequiredStart( Calendar.getInstance() );
		session = editSession.create();
		editSession = null;

		CFSecAuthorization authorization = new CFSecAuthorization();
		authorization.setSecCluster( cluster );
		authorization.setSecTenant( tenant );
		authorization.setSecSession( session );
		clientSchemaObj.setAuthorization( authorization );

		// And now we can stitch together the CLI to the SAX loader code
		CFBamCustEditor cli = new CFBamCustEditor();
		cli.setRamSchema( invoker );
		cli.setSchema( clientSchemaObj );

		ICFBamCustEditorSchema myCustomSchema = new CFBamCustEditorSchema();
		myCustomSchema.setSchema( clientSchemaObj );
		myCustomSchema.setClusterName( "system" );
		myCustomSchema.setTenantName( "system" );
		myCustomSchema.setSecUserName( "system" );
		cli.setCustomSchema( myCustomSchema );

		Application.launch( args );
	}

	// Initialize the console log

	protected static void initConsoleLog() {
//		Layout layout = new PatternLayout(
//				"%d{ISO8601}"		// Start with a timestamp
//			+	" %-5p"				// Include the severity
//			+	" %C.%M"			// pkg.class.method()
//			+	" %F[%L]"			// File[lineNumber]
//			+	": %m\n" );			// Message text
//		BasicConfigurator.configure( new ConsoleAppender( layout, "System.out" ) );
	}

}
