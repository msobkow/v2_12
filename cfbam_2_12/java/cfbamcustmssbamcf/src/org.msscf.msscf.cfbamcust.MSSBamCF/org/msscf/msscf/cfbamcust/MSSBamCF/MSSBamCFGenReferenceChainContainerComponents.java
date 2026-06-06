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

import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfbam.CFBamObj.ICFBamChainObj;
import org.msscf.msscf.cfbam.CFBamObj.ICFBamRelationObj;
import org.msscf.msscf.cfbam.CFBamObj.ICFBamTableObj;
import org.msscf.msscf.cfcore.MssCF.*;

public class MSSBamCFGenReferenceChainContainerComponents
	extends MssCFGenReferenceObj
{
	private static final long serialVersionUID = 1L;

	public MSSBamCFGenReferenceChainContainerComponents() {
		super();
	}

	public MSSBamCFGenReferenceChainContainerComponents(
		MSSBamCFEngine argSchema,
		String toolset,
		String scopeDefClassName,
		String genDefClassName,
		String itemName)
	{
		super(argSchema, toolset, scopeDefClassName, genDefClassName, itemName, "Relation");
	}

	public ICFLibAnyObj dereference( MssCFGenContext genContext) {
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

		if ( ! ( genDef instanceof ICFBamTableObj ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"genContext.GenDef",
				genDef,
				"ICFBamTableObj" );
		}

		ICFBamTableObj table = (ICFBamTableObj)genDef;

		ICFBamChainObj chain = null;
		Iterator<ICFBamChainObj> optionalChildrenChains;
		ICFBamRelationObj superClassRelation;
		while( ( chain == null ) && ( table != null ) ) {
			optionalChildrenChains = table.getOptionalComponentsChains().iterator();
			if( optionalChildrenChains.hasNext() ) {
				chain = optionalChildrenChains.next();
			}
			else {
				superClassRelation = MSSBamCFTableObj.getSuperClassRelation( table );
				if( superClassRelation != null ) {
					table = superClassRelation.getRequiredLookupToTable();
				}
				else {
					table = null;
				}
			}
		}

		if( chain == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				0,
				"genDef.Chain" );
		}

		ICFBamTableObj chainTable = chain.getRequiredContainerTable();

		table = (ICFBamTableObj)genDef;

		ICFBamRelationObj containerComponentsRelation = null;
		ICFBamRelationObj containerRelation = MSSBamCFTableObj.getInheritedContainerRelation( table );
		ICFBamTableObj containerTable = containerRelation.getRequiredLookupToTable();
		ICFBamRelationObj relation;
		Iterator<ICFBamRelationObj> tableRelations;
		ICFBamTableObj componentTable;

		while( ( containerComponentsRelation == null ) && ( containerTable != null ) ) {
			tableRelations = containerTable.getChildrenRelations().iterator();
			while( tableRelations.hasNext() ) {
				relation = tableRelations.next();
				if( relation.getRequiredRelationType() == ICFBamSchema.RelationTypeEnum.Components ) {
					componentTable = relation.getRequiredLookupToTable();
					if( chainTable == componentTable ) {
						containerComponentsRelation = relation;
					}
				}
			}
			if( containerComponentsRelation == null ) {
				relation = MSSBamCFTableObj.getSuperClassRelation( containerTable );
				if( relation != null ) {
					containerTable = relation.getRequiredLookupToTable();
				}
				else {
					containerTable = null;
				}
			}
		}

		if( containerComponentsRelation == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				0,
				"containerComponentsRelation" );
		}

		return( containerComponentsRelation );
	}
}
