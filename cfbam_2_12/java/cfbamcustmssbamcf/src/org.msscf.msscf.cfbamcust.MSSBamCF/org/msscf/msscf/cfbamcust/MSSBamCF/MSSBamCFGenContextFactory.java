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

import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.MssCF.*;

public class MSSBamCFGenContextFactory
extends MssCFGenContextFactory
{
	public MSSBamCFGenContextFactory()
	{
		super();
	}

	public MssCFGenContext newGenContext(
		String				generatingBuild,
		MssCFGenContext		genContext,
		String				subClassGenDefName,
		ICFLibAnyObj		subObject )
	{
		return( new MSSBamCFGenContext( generatingBuild, genContext, subClassGenDefName, subObject ) );
	}

	public MssCFGenContext newGenContext(
		String				generatingBuild,
		MssCFEngine			engine,
		String				argRootGenDir,
		String				toolset,
		String				scopeDefClassName,
		String				genDefClassName,
		String				itemName )
	{
		return( new MSSBamCFGenContext( generatingBuild,
			engine,
			argRootGenDir,
			toolset,
			scopeDefClassName,
			genDefClassName,
			itemName ) );
	}

	public MssCFGenContext newGenContext(
		String				generatingBuild,
		MssCFEngine			engine,
		String				argRootGenDir,
		String				toolset,
		String				scopeDefClassName,
		String				genDefClassName,
		String				itemName,
		ICFLibAnyObj		argGenDef,
		ICFLibAnyObj		argScopeDef )
	{
		return( new MSSBamCFGenContext( generatingBuild,
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
