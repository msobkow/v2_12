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

public class MSSBamCFGenIterateReverseDelDeps
	extends MssCFGenIteratorObj
{
	private static final long serialVersionUID = 1L;

	public MSSBamCFGenIterateReverseDelDeps() {
		super();
	}

	public MSSBamCFGenIterateReverseDelDeps(
		MSSBamCFEngine argSchema,
		String toolset,
		String scopeDefClassName,
		String genDefClassName,
		String itemName)
	{
		super( argSchema, toolset, scopeDefClassName, genDefClassName, itemName, "DelTopDep");
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

		ICFBamTableObj table = (ICFBamTableObj)genDef;

		int sz = table.getOptionalComponentsDelDep().size();
		ICFBamDelTopDepObj asIs[] = new ICFBamDelTopDepObj[ sz ];
		int idx = 0;
		Iterator<ICFBamDelTopDepObj> childDeps = ((ICFBamTableObj)genDef).getOptionalComponentsDelDep().iterator();
		while( childDeps.hasNext() ) {
			asIs[idx] = childDeps.next();
			idx ++;
		}
		List<ICFLibAnyObj> list = new LinkedList<ICFLibAnyObj>();
		idx --;
		while( idx >= 0 ) {
			list.add( asIs[idx] );
			idx --;
		}

		return( list.listIterator() );
	}
}
