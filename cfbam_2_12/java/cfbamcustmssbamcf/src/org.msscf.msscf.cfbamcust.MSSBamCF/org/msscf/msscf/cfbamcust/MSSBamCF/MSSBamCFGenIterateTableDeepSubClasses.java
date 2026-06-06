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

import java.util.*;

import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.MssCF.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfbam.CFBamObj.*;

public class MSSBamCFGenIterateTableDeepSubClasses
	extends MssCFGenIteratorObj
{
	private static final long serialVersionUID = 1L;

	public MSSBamCFGenIterateTableDeepSubClasses() {
		super();
	}

	public MSSBamCFGenIterateTableDeepSubClasses(
		MSSBamCFEngine argSchema,
		String toolset,
		String scopeDefClassName,
		String genDefClassName,
		String itemName)
	{
		super( argSchema, toolset, scopeDefClassName, genDefClassName, itemName, "Table");
	}

	protected void walkSubClasses( List<ICFLibAnyObj> list, ICFBamTableObj tableObj ) {
		List<ICFBamRelationObj> reverseRelations = tableObj.getOptionalChildrenReverseRelations();
		ICFBamRelationObj relation;
		Iterator<ICFBamRelationObj> almostDone = reverseRelations.iterator();
		while (almostDone.hasNext()) {
			relation = almostDone.next();
			if( relation.getRequiredRelationType() == ICFBamSchema.RelationTypeEnum.Superclass ) {
				list.add( relation.getRequiredContainerFromTable() );
				walkSubClasses( list, relation.getRequiredContainerFromTable() );
			}
		}
	}

	public ListIterator<ICFLibAnyObj> enumerateDetails( MssCFGenContext genContext)
	{
		ICFLibAnyObj genDef;
		final String S_ProcName = "enumerateDetails";

		if( genContext == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"genContext" );
		}

		genDef = genContext.getGenDef();
		if( genDef == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				0,
				"genContext.GenDef" );
		}

		if( ! (genDef instanceof ICFBamTableObj) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"genContext.GenDef",
				genDef,
				"ICFBamTableObj" );
		}

		ICFBamTableObj tableObj = (ICFBamTableObj)genDef;
		List<ICFLibAnyObj> list = new LinkedList<ICFLibAnyObj>();
		walkSubClasses( list, tableObj );

		return (list.listIterator());
	}
}
