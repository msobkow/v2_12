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
import org.msscf.msscf.cfbam.CFBamObj.*;

public class MSSBamCFGenContext
extends MssCFGenContext
{
	protected volatile static ICFBamSchemaDefObj manufacturingSchema = null;

	public static void setManufacturingSchema( ICFBamSchemaDefObj value ) {
		manufacturingSchema = value;
	}

	public static ICFBamSchemaDefObj getManufacturingSchema() {
		return( manufacturingSchema );
	}

	/**
	 *	Construct an expansion context for the stack that pushes a sub class and definition.
	 */
	public MSSBamCFGenContext(
		String				generatingBuild,
		MssCFGenContext		genContext,
		String				subClassGenDefName,
		ICFLibAnyObj		subObject )
	{
		super( generatingBuild,
			genContext,
			genContext.getGenEngine().fixGenDefName( subClassGenDefName ),
			subObject );
//		setManufacturingSchema( ((MSSBamCFGenContext)genContext).getManufacturingSchema() );
		if( subObject instanceof ICFBamSchemaDefObj ) {
			if( manufacturingSchema == null ) {
				manufacturingSchema = (ICFBamSchemaDefObj)subObject;
			}
		}
	}

	/**
	 *	Construct an instance.  Only invoked to create binding entries.
	 */
	public MSSBamCFGenContext(
		String				generatingBuild,
		MssCFEngine			engine,
		String				argRootGenDir,
		String				toolset,
		String				scopeDefClassName,
		String				genDefClassName,
		String				itemName )
	{
		super( generatingBuild,
			engine,
			argRootGenDir,
			toolset,
			engine.fixGenDefName( scopeDefClassName ),
			engine.fixGenDefName( genDefClassName ),
			itemName );
	}

	/**
	 *	Construct an expansion context for the stack.
	 */
	public MSSBamCFGenContext(
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
		super( generatingBuild,
			engine,
			argRootGenDir,
			toolset,
			engine.fixGenDefName( scopeDefClassName ),
			engine.fixGenDefName( genDefClassName ),
			itemName,
			argGenDef,
			argScopeDef );
		if( argGenDef instanceof ICFBamSchemaDefObj ) {
			if( manufacturingSchema == null ) {
				manufacturingSchema = (ICFBamSchemaDefObj)argGenDef;
			}
		}
		else if( argScopeDef instanceof ICFBamSchemaDefObj ) {
			if( manufacturingSchema == null ) {
				manufacturingSchema = (ICFBamSchemaDefObj)argScopeDef;
			}
		}
	}

	/**
	 *	Build a reference context
	 */
	public MssCFGenContext buildRefContext( String generatingBuild, ICFLibAnyObj genDef ) {
		if( genDef instanceof ICFBamSchemaDefObj ) {
			if( manufacturingSchema == null ) {
				manufacturingSchema = (ICFBamSchemaDefObj)genDef;
			}
		}
		return( super.buildRefContext( generatingBuild, genDef ) );
	}
}
