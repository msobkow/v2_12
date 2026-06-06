/*
 *	MSS Code Factory CFCore 2.12
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

package org.msscf.msscf.cfcore.MssCF;

import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cfcore.CFGenKbObj.*;
import org.msscf.msscf.cfcore.CFGenKbObj.*;

public class MssCFGenReferenceContainer
extends MssCFGenReferenceObj
{
	public MssCFGenReferenceContainer()
	{
		super();
	}

	public MssCFGenReferenceContainer(MssCFEngine schema)
	{
		super( schema );
	}

	public MssCFGenReferenceContainer(
		MssCFEngine engine,
		String toolset,
		String scopeDefClassName,
		String genDefClassName,
		String itemName,
		String detailClassName )
	{
		super( engine );
		requiredLookupToolSet = schema.getToolSetTableObj().readToolSetByNameIdx(toolset);
		CFGenKbGenItemBuff genItemBuff = getGenItemBuff();

		genItemBuff.setRequiredToolSetId( requiredLookupToolSet.getRequiredId() );

		if (scopeDefClassName != null && scopeDefClassName.length() > 0) {
			if (scopeDefClassName.equals("*")) {
				scopeDefClassName = "Object";
			}
			else {
				scopeDefClassName = engine.fixGenDefName( scopeDefClassName );
			}
			optionalLookupScopeDef = schema.getDefClassTableObj().readDefClassByNameIdx(scopeDefClassName);
			genItemBuff.setOptionalScopeDefId( optionalLookupScopeDef.getRequiredId() );
		}
		else {
			optionalLookupScopeDef = null;
			genItemBuff.setOptionalScopeDefId( null );
		}

		genDefClassName = engine.fixGenDefName( genDefClassName );
		requiredLookupGenDef = schema.getDefClassTableObj().readDefClassByNameIdx(genDefClassName);
		genItemBuff.setRequiredGenDefId( requiredLookupGenDef.getRequiredId() );

		genItemBuff.setRequiredName( itemName );

		detailClass = schema.getDefClassTableObj().readDefClassByNameIdx(detailClassName);
	}

	public String expandBody(MssCFGenContext genContext)
	{
		final String S_ProcName = "MssCFGenReferenceObj.expandBody() ";
		throw new RuntimeException( S_ProcName + "Cannot directly expand a reference" );
	}

	public ICFLibAnyObj dereference(MssCFGenContext genContext)
	{
		ICFLibAnyObj ofInterest = genContext.getGenDef();
		if( ofInterest != null ) {
			ofInterest = ofInterest.getObjScope();
		}
		return( ofInterest );
	}
}
