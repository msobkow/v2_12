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

import java.lang.reflect.*;
import java.io.*;
import java.net.*;
import java.security.cert.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cfcore.CFGenKbObj.*;
import org.msscf.msscf.cfcore.CFGenKbObj.*;

public class MssCFGenBindObj
extends CFGenKbGenBindObj
{
	public MssCFGenBindObj()
	{
		super();
	}

	public MssCFGenBindObj( MssCFEngine engine )
	{
		super( engine );
	}

	public MssCFGenBindObj(
		MssCFEngine engine,
		String toolset,
		String scopeDefClassName,
		String genDefClassName,
		String itemName)
	{
		super( engine );

		requiredLookupToolSet = schema.getToolSetTableObj().readToolSetByNameIdx(toolset);
		CFGenKbGenItemBuff genItemBuff = getGenItemBuff();

		genItemBuff.setRequiredToolSetId( requiredLookupToolSet.getRequiredId() );

		if (scopeDefClassName != null && scopeDefClassName.length() > 0)
		{
			if (scopeDefClassName.equals("*"))
			{
				scopeDefClassName = "Object";
			}
			else {
				scopeDefClassName = engine.fixGenDefName( scopeDefClassName );
			}
			optionalLookupScopeDef = schema.getDefClassTableObj().readDefClassByNameIdx(scopeDefClassName);
			genItemBuff.setOptionalScopeDefId( optionalLookupScopeDef.getRequiredId() );
		}
		else
		{
			optionalLookupScopeDef = null;
			genItemBuff.setOptionalScopeDefId( null );
		}

		genDefClassName = engine.fixGenDefName( genDefClassName );
		requiredLookupGenDef = schema.getDefClassTableObj().readDefClassByNameIdx(genDefClassName);
		genItemBuff.setRequiredGenDefId( requiredLookupGenDef.getRequiredId() );

		genItemBuff.setRequiredName( itemName );
	}

	public String expandBody(MssCFGenContext genContext)
	{
		final String S_ProcName = "MssCFGenBindObj.expandBody() ";
		throw new RuntimeException( S_ProcName + "Not implemented" );
	}

	public Object getValueObject(MssCFGenContext genContext)
	{
		Object obj = expandBody( genContext );
		return( obj );
	}
}
