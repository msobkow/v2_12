// Description: Java 11 XML SAX Parser for CFInt.

/*
 *	org.msscf.msscf.CFInt
 *
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *
 *	These files are part of MSS Code Factory Version 2.12.
 *
 *	MSS Code Factory is available under the terms of the GNU General Public License,
 *	Version 3 or later.
 *
 *	MSS Code Factory is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 */

package org.msscf.msscf.cfint.CFIntSaxRamLdr;

import org.apache.log4j.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;

import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfint.CFIntRam.*;
import org.msscf.msscf.cfint.CFIntSaxLoader.*;

public class CFIntSaxRamLdr
	extends CFIntSaxLdr
{
	private static ICFLibMessageLog log = new CFLibConsoleMessageLog();

	// Constructors

	public CFIntSaxRamLdr() {
		super( log );
	}

	// main() entry point

	public static void main( String args[] ) {
		final String S_ProcName = "CFIntSaxRamLdr.main() ";
		initConsoleLog();
		int numArgs = args.length;
		if( numArgs >= 2 ) {
			ICFIntSchema cFIntSchema = new CFIntRamSchema();
			ICFIntSchemaObj cFIntSchemaObj = new CFIntSchemaObj();
			cFIntSchemaObj.setBackingStore( cFIntSchema );
			CFIntSaxLdr cli = new CFIntSaxRamLdr();
			CFIntSaxLoader loader = cli.getSaxLoader();
			loader.setSchemaObj( cFIntSchemaObj );
			String url = args[1];
			try {
				cFIntSchema.connect( "system", "system", "system", "system" );
				cFIntSchema.rollback();
				cFIntSchema.beginTransaction();
				cFIntSchemaObj.setSecCluster( cFIntSchemaObj.getClusterTableObj().getSystemCluster() );
				cFIntSchemaObj.setSecTenant( cFIntSchemaObj.getTenantTableObj().getSystemTenant() );
				cFIntSchemaObj.setSecSession( cFIntSchemaObj.getSecSessionTableObj().getSystemSession() );
				CFSecAuthorization auth = new CFSecAuthorization();
				auth.setSecCluster( cFIntSchemaObj.getSecCluster() );
				auth.setSecTenant( cFIntSchemaObj.getSecTenant() );
				auth.setSecSession( cFIntSchemaObj.getSecSession() );
				cFIntSchemaObj.setAuthorization( auth );
				loader.setUseCluster( cFIntSchemaObj.getSecCluster() );
				loader.setUseTenant( cFIntSchemaObj.getSecTenant() );
				applyLoaderOptions( loader, args[0] );
				cli.evaluateRemainingArgs( args, 2 );
				loader.parseFile( url );
				cFIntSchema.commit();
				cFIntSchema.disconnect( true );
			}
			catch( Exception e ) {
				log.message( S_ProcName + "EXCEPTION: Could not parse XML file \"" + url + "\": " + e.getMessage() );
				e.printStackTrace( System.out );
			}
			catch( Error e ) {
				log.message( S_ProcName + "ERROR: Could not parse XML file \"" + url + "\": " + e.getMessage() );
				e.printStackTrace( System.out );
			}
			finally {
				if( cFIntSchema.isConnected() ) {
					cFIntSchema.rollback();
					cFIntSchema.disconnect( false );
				}
			}
		}
		else {
			log.message( S_ProcName + "ERROR: Expected at least two argument specifying the loader options and the name of the XML file to parse.  The first argument may be empty." );
		}
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

	// Evaluate remaining arguments

	public void evaluateRemainingArgs( String[] args, int consumed ) {
		// There are no extra arguments for the RAM "database" instance
		if( args.length > consumed ) {
			log.message( "CFIntSaxRamLdr.evaluateRemainingArgs() WARNING No extra arguments are expected for a RAM database instance, but "
				+ Integer.toString( args.length - consumed )
				+ " extra arguments were specified.  Extra arguments ignored." );
		}
	}

}
