// Description: Java 13 Custom JavaFX in-memory CFBam editor

/*
 *  MSS Code Factory CFBam 2.12 Cust Editor
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
import org.msscf.msscf.cfbam.CFBam.ICFBamSchema.RelationTypeEnum;
import org.msscf.msscf.cfbam.CFBamObj.*;
import org.msscf.msscf.cfbam.CFBamSaxLoader.*;
import org.msscf.msscf.cfbam.CFBamJavaFX.*;
import org.msscf.msscf.cfbam.CFBamMssCF.*;
import org.msscf.msscf.cfbam.CFBamRam.*;
import org.msscf.msscf.cfbamcust.MSSBamCF.*;
import org.msscf.msscf.cfbamcust.CFBamXmlLoader.*;
import org.msscf.msscf.cfbamcust.CFBamCust.*;

public class CFBamCustEditorRelationEntry
{
	protected ICFBamRelationObj relation = null;
	protected String name = null;

	public CFBamCustEditorRelationEntry( ICFBamRelationObj argRelation, String argName ) {
		final String S_ProcName="construct";
		if( argName == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				2,
				"argName" );
		}
		relation = argRelation;
		name = argName;
	}

	public ICFBamRelationObj getRelation() {
		return( relation );
	}

	public String getName() {
		return( name );
	}

	public String toString() {
		return( name );
	}

	public static ObservableList<CFBamCustEditorRelationEntry> getObservableListOfRelationEntryForTable( ICFBamTableObj table ) {
		final String S_ProcName = "getObservableListOfRelationEntryForTable";
		ArrayList<CFBamCustEditorRelationEntry> arrayList = new ArrayList<CFBamCustEditorRelationEntry>();

		CFBamCustEditorRelationEntry entry = new CFBamCustEditorRelationEntry( null, "" );
		arrayList.add( entry );

		RelationTypeEnum relationType;
		ICFBamRelationObj relation;
		ICFBamRelationObj superclassRelation;
		Iterator<ICFBamRelationObj> tableRelationIter;
		while( table != null ) {
			superclassRelation = null;
			tableRelationIter = table.getOptionalComponentsRelation().iterator();
			while( tableRelationIter.hasNext() ) {
				relation = tableRelationIter.next();
				relationType = relation.getRequiredRelationType();
				if( relationType == ICFBamSchema.RelationTypeEnum.Superclass ) {
					if( superclassRelation != null ) {
						throw new CFLibRuntimeException( CFBamCustEditorRelationEntry.class,
							S_ProcName,
							"Superclass relation specified more than once for Table \"" + table.getObjName() + "\"" );
					}
					superclassRelation = relation;
				}
				else if( relationType != ICFBamSchema.RelationTypeEnum.Unknown ) {
					entry = new CFBamCustEditorRelationEntry( relation, relation.getObjName() );
					arrayList.add( entry );
				}
			}
			if( superclassRelation != null ) {
				table = superclassRelation.getRequiredLookupToTable();
			}
			else {
				table = null;
			}
		}

		ObservableList<CFBamCustEditorRelationEntry> observableList = FXCollections.observableList( arrayList );

		observableList.sort( compareName );

		return( observableList );
	}

	public static ObservableList<CFBamCustEditorRelationEntry> getObservableListOfInheritedRelationEntryForTable( ICFBamTableObj table ) {
		final String S_ProcName = "getObservableListOfInheritedRelationEntryForTable";
		if( table == null ) {
			throw new CFLibNullArgumentException( CFBamCustEditorRelationEntry.class,
				S_ProcName,
				1,
				"table" );
		}
		ArrayList<CFBamCustEditorRelationEntry> arrayList = new ArrayList<CFBamCustEditorRelationEntry>();

		CFBamCustEditorRelationEntry entry = new CFBamCustEditorRelationEntry( null, "" );
		arrayList.add( entry );

		RelationTypeEnum relationType;
		ICFBamRelationObj relation;
		ICFBamRelationObj superclassRelation;
		Iterator<ICFBamRelationObj> tableRelationIter;

		superclassRelation = null;
		tableRelationIter = table.getOptionalComponentsRelation().iterator();
		while( ( superclassRelation == null ) && tableRelationIter.hasNext() ) {
			relation = tableRelationIter.next();
			relationType = relation.getRequiredRelationType();
			if( relationType == ICFBamSchema.RelationTypeEnum.Superclass ) {
				superclassRelation = relation;
			}
		}
		if( superclassRelation != null ) {
			table = superclassRelation.getRequiredLookupToTable();
		}
		else {
			table = null;
		}
		while( table != null ) {
			superclassRelation = null;
			tableRelationIter = table.getOptionalComponentsRelation().iterator();
			while( tableRelationIter.hasNext() ) {
				relation = tableRelationIter.next();
				relationType = relation.getRequiredRelationType();
				if( relationType == ICFBamSchema.RelationTypeEnum.Superclass ) {
					if( superclassRelation != null ) {
						throw new CFLibRuntimeException( CFBamCustEditorRelationEntry.class,
							S_ProcName,
							"Superclass relation specified more than once for Table \"" + table.getObjName() + "\"" );
					}
					superclassRelation = relation;
				}
				else if( relationType != ICFBamSchema.RelationTypeEnum.Unknown ) {
					entry = new CFBamCustEditorRelationEntry( relation, table.getObjName() + "." + relation.getObjName() );
					arrayList.add( entry );
				}
			}
			if( superclassRelation != null ) {
				table = superclassRelation.getRequiredLookupToTable();
			}
			else {
				table = null;
			}
		}

		ObservableList<CFBamCustEditorRelationEntry> observableList = FXCollections.observableList( arrayList );

		observableList.sort( compareName );

		return( observableList );
	}

	public static class CompareByName
	implements Comparator<CFBamCustEditorRelationEntry>
	{
		public CompareByName() {
		}

		public int compare( CFBamCustEditorRelationEntry lhs, CFBamCustEditorRelationEntry rhs ) {
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
