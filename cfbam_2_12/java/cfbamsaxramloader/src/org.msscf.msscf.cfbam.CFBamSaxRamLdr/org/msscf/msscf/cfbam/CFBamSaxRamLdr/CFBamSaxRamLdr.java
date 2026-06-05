// Description: Java 11 XML SAX Parser for CFBam.

/*
 *	org.msscf.msscf.CFBam
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
 *
 *	Manufactured by MSS Code Factory 2.11
 */

package org.msscf.msscf.cfbam.CFBamSaxRamLdr;

import org.apache.log4j.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfbam.CFBam.*;

import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBamObj.*;
import org.msscf.msscf.cfbam.CFBamRam.*;
import org.msscf.msscf.cfbam.CFBamSaxLoader.*;

public class CFBamSaxRamLdr
	extends CFBamSaxLdr
{
	private static ICFLibMessageLog log = new CFLibConsoleMessageLog();

	// Constructors

	public CFBamSaxRamLdr() {
		super( log );
	}

	// main() entry point

	public static void main( String args[] ) {
		final String S_ProcName = "CFBamSaxRamLdr.main() ";
		initConsoleLog();
		int numArgs = args.length;
		if( numArgs >= 2 ) {
			ICFBamSchema cFBamSchema = new CFBamRamSchema();
			ICFBamSchemaObj cFBamSchemaObj = new CFBamSchemaObj();
			cFBamSchemaObj.setBackingStore( cFBamSchema );
			CFBamSaxLdr cli = new CFBamSaxRamLdr();
			CFBamSaxLoader loader = cli.getSaxLoader();
			loader.setSchemaObj( cFBamSchemaObj );
			String url = args[1];
			try {
				cFBamSchema.connect( "system", "system", "system", "system" );
				cFBamSchema.rollback();
				cFBamSchema.beginTransaction();
				cFBamSchemaObj.setSecCluster( cFBamSchemaObj.getClusterTableObj().getSystemCluster() );
				cFBamSchemaObj.setSecTenant( cFBamSchemaObj.getTenantTableObj().getSystemTenant() );
				cFBamSchemaObj.setSecSession( cFBamSchemaObj.getSecSessionTableObj().getSystemSession() );
				CFSecAuthorization auth = new CFSecAuthorization();
				auth.setSecCluster( cFBamSchemaObj.getSecCluster() );
				auth.setSecTenant( cFBamSchemaObj.getSecTenant() );
				auth.setSecSession( cFBamSchemaObj.getSecSession() );
				cFBamSchemaObj.setAuthorization( auth );
				loader.setUseCluster( cFBamSchemaObj.getSecCluster() );
				loader.setUseTenant( cFBamSchemaObj.getSecTenant() );
				applyLoaderOptions( loader, args[0] );
				cli.evaluateRemainingArgs( args, 2 );
				loader.parseFile( url );
				cFBamSchema.commit();
				cFBamSchema.disconnect( true );
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
				if( cFBamSchema.isConnected() ) {
					cFBamSchema.rollback();
					cFBamSchema.disconnect( false );
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
			log.message( "CFBamSaxRamLdr.evaluateRemainingArgs() WARNING No extra arguments are expected for a RAM database instance, but "
				+ Integer.toString( args.length - consumed )
				+ " extra arguments were specified.  Extra arguments ignored." );
		}
	}

}
