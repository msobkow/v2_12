/*
 *  MSS Code Factory CFBam 2.12 MSSBamCF
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

package org.msscf.msscf.cfbamcust.MSSBamCF;

import java.util.Iterator;
import java.util.SortedMap;

import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.MssCF.*;
import org.msscf.msscf.cfbam.CFBam.ICFBamSchema;
import org.msscf.msscf.cfbam.CFBamObj.*;

public class MSSBamCFGenBindHasSubObjectLookup
	extends MssCFGenBindObj
{
	private static final long serialVersionUID = 1L;

	public MSSBamCFGenBindHasSubObjectLookup() {
		super();
	}

	public MSSBamCFGenBindHasSubObjectLookup(
		MSSBamCFEngine argSchema,
		String toolset,
		String scopeDefClassName,
		String genDefClassName,
		String itemName)
	{
		super( argSchema, toolset, scopeDefClassName, genDefClassName, itemName);
	}

	public String expandBody( MssCFGenContext genContext ) {
		ICFLibAnyObj genDef;
		final String S_ProcName = "expandBody";

		if (genContext == null) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"genContext" );
		}

		genDef = genContext.getGenDef();
		if (genDef == null) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				0,
				"genContext.GenDef" );
		}

		if( ! ( genDef instanceof ICFBamTableObj ) ) { 
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"genDef",
				genDef,
				"ICFBamTableObj" );
		}
		ICFBamTableObj tableObj = (ICFBamTableObj)genDef;

		ICFBamRelationObj relationDef = null;
		Iterator<ICFBamRelationObj> iter;
		Iterator<ICFBamRelationObj> iterTableRelations;
		ICFBamRelationObj scanRelation;
		ICFBamTableObj targetTable;
		ICFBamTableObj scanTable;
		ICFBamSchema.RelationTypeEnum relationType;
		ICFBamRelationObj superRelation;

		iterTableRelations = tableObj.getOptionalComponentsRelation().iterator();
		while( iterTableRelations.hasNext() ) {
			relationDef = iterTableRelations.next();
			relationType = relationDef.getRequiredRelationType();
			if( relationType == ICFBamSchema.RelationTypeEnum.Lookup ) {
				targetTable = relationDef.getRequiredLookupToTable();
				scanTable = relationDef.getRequiredContainerFromTable();
				while( scanTable != null ) {
					iter = scanTable.getOptionalComponentsRelation().iterator();
					while( iter.hasNext() ) {
						scanRelation = iter.next();
						relationType = scanRelation.getRequiredRelationType();
						if( ( relationType == ICFBamSchema.RelationTypeEnum.Components )
						 || ( relationType == ICFBamSchema.RelationTypeEnum.Children )
						 || ( relationType == ICFBamSchema.RelationTypeEnum.Components ) )
						{
							if( targetTable == scanRelation.getRequiredLookupToTable() ) {
								return( "yes" );
							}
						}
					}

					superRelation = MSSBamCFTableObj.getSuperClassRelation( scanTable );
					if( superRelation != null ) {
						scanTable = superRelation.getRequiredLookupToTable();
					}
					else {
						scanTable = null;
					}
				}
			}
		}

		return( "no" );
	}
}
