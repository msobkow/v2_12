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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class CFBamCustEditorTableEntry
{
	protected ICFBamTableObj table = null;
	protected String name = null;

	public CFBamCustEditorTableEntry( ICFBamTableObj argTable, String argName ) {
		final String S_ProcName="construct";
		if( argName == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				2,
				"argName" );
		}
		table = argTable;
		name = argName;
	}

	public ICFBamTableObj getTable() {
		return( table );
	}

	public String getName() {
		return( name );
	}

	public String toString() {
		return( name );
	}

	public static ObservableList<CFBamCustEditorTableEntry> getObservableListOfTableEntryForSchemaDef( ICFBamSchemaDefObj schema ) {
		final String S_ProcName = "getObservableListOfTableEntryForSchemaDef";
		ArrayList<CFBamCustEditorTableEntry> arrayList = new ArrayList<CFBamCustEditorTableEntry>();

		CFBamCustEditorTableEntry entry = new CFBamCustEditorTableEntry( null, "" );
		arrayList.add( entry );

		ICFBamTableObj table;
		Iterator<ICFBamTableObj> tableIter;
		tableIter = schema.getOptionalComponentsTables().iterator();
		while( tableIter.hasNext() ) {
			table = tableIter.next();
			if( table.getOptionalLookupDefSchema() == null ) {
				entry = new CFBamCustEditorTableEntry( table, table.getObjName() );
				arrayList.add( entry );
			}
		}

		ObservableList<CFBamCustEditorTableEntry> observableList = FXCollections.observableList( arrayList );

		observableList.sort( compareName );

		return( observableList );
	}

	public static ObservableList<CFBamCustEditorTableEntry> getObservableListOfTableEntryForClusterTenant( ICFBamSchemaDefObj schema ) {
		final String S_ProcName = "getObservableListOfTableEntryForClusterTenant";
		ArrayList<CFBamCustEditorTableEntry> arrayList = new ArrayList<CFBamCustEditorTableEntry>();

		CFBamCustEditorTableEntry entry = new CFBamCustEditorTableEntry( null, "" );
		arrayList.add( entry );

		ICFBamTableObj table;
		String tableName;
		Iterator<ICFBamTableObj> tableIter;
		tableIter = schema.getOptionalComponentsTables().iterator();
		while( tableIter.hasNext() ) {
			table = tableIter.next();
			tableName = table.getObjName();
			if( tableName.equals( "Cluster" ) || tableName.equals( "Tenant" ) ) {
				entry = new CFBamCustEditorTableEntry( table, table.getObjName() );
				arrayList.add( entry );
			}
		}

		ObservableList<CFBamCustEditorTableEntry> observableList = FXCollections.observableList( arrayList );

		observableList.sort( compareName );

		return( observableList );
	}

	public static class CompareByName
	implements Comparator<CFBamCustEditorTableEntry>
	{
		public CompareByName() {
		}

		public int compare( CFBamCustEditorTableEntry lhs, CFBamCustEditorTableEntry rhs ) {
			if( lhs == null ) {
				if( rhs == null ) {
					return( 0 );
				}
				else {
					return( -1 );
				}
			}
			else if( rhs == null ) {
				return( 1 );
			}
			else {
				String lhsName = lhs.getName();
				String rhsName = rhs.getName();
				if( lhsName == null ) {
					if( rhsName == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhsName == null ) {
					return( 1 );
				}
				else {
					return( lhsName.compareTo( rhsName ) );
				}
			}
		}
	}

	protected static CompareByName compareName = new CompareByName();
}
