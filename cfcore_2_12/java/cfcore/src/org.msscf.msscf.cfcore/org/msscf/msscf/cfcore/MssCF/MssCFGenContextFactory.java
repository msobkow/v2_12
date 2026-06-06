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

public class MssCFGenContextFactory
{
	public MssCFGenContextFactory()
	{
	}

	public MssCFGenContext newGenContext(
		String				buildString,
		MssCFGenContext		genContext,
		String				subClassGenDefName,
		ICFLibAnyObj		subObject )
	{
		return( new MssCFGenContext( buildString, genContext, subClassGenDefName, subObject ) );
	}

	public MssCFGenContext newGenContext(
		String				buildString,
		MssCFEngine			engine,
		String				argRootGenDir,
		String				toolset,
		String				scopeDefClassName,
		String				genDefClassName,
		String				itemName )
	{
		return( new MssCFGenContext( buildString,
			engine,
			argRootGenDir,
			toolset,
			scopeDefClassName,
			genDefClassName,
			itemName ) );
	}

	public MssCFGenContext newGenContext(
		String				buildString,
		MssCFEngine			engine,
		String				argRootGenDir,
		String				toolset,
		String				scopeDefClassName,
		String				genDefClassName,
		String				itemName,
		ICFLibAnyObj		argGenDef,
		ICFLibAnyObj		argScopeDef )
	{
		return( new MssCFGenContext( buildString,
			engine,
			argRootGenDir,
			toolset,
			scopeDefClassName,
			genDefClassName,
			itemName,
			argGenDef,
			argScopeDef ) );
	}
}
