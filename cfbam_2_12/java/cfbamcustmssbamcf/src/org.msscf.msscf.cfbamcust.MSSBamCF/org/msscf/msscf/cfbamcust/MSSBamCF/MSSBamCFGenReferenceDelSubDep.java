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
import org.msscf.msscf.cfbam.CFBamObj.*;

public class MSSBamCFGenReferenceDelSubDep
	extends MssCFGenReferenceObj
{
	private static final long serialVersionUID = 1L;

	public MSSBamCFGenReferenceDelSubDep() {
		super();
	}

	public MSSBamCFGenReferenceDelSubDep(
		MSSBamCFEngine argSchema,
		String toolset,
		String scopeDefClassName,
		String genDefClassName,
		String itemName)
	{
		super(argSchema, toolset, scopeDefClassName, genDefClassName, itemName, "Chain");
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

		ICFLibAnyObj ret = null;
		if( genDef instanceof ICFBamDelTopDepObj ) {
			ICFBamDelTopDepObj topDep = (ICFBamDelTopDepObj)genDef;
			Iterator<ICFBamDelSubDep1Obj> iter = topDep.getOptionalComponentsDelDep().iterator();
			if( iter.hasNext() ) {
				ret = iter.next();
			}
		}
		else if( genDef instanceof ICFBamDelSubDep1Obj ) {
			ICFBamDelSubDep1Obj subDep = (ICFBamDelSubDep1Obj)genDef;
			Iterator<ICFBamDelSubDep2Obj> iter = subDep.getOptionalComponentsDelDep().iterator();
			if( iter.hasNext() ) {
				ret = iter.next();
			}
		}
		else if( genDef instanceof ICFBamDelSubDep2Obj ) {
			ICFBamDelSubDep2Obj subDep = (ICFBamDelSubDep2Obj)genDef;
			Iterator<ICFBamDelSubDep3Obj> iter = subDep.getOptionalComponentsDelDep().iterator();
			if( iter.hasNext() ) {
				ret = iter.next();
			}
		}
		else if( genDef instanceof ICFBamDelSubDep3Obj ) {
			ret = null;
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"genContext.GenDef",
				genDef,
				"ICFBamDelTopDepObj, ICFBamDelSubDep1Obj, ICFBamDelSubDep2Obj, ICFBamDelSubDep3Obj" );
		}

		return (ret);
	}
}
