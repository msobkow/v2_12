
// Description: Java 11 MssCF Binding for DelSubDep1 Column DelTopDepId.

/*
 *	org.msscf.msscf.CFBam
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
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

package org.msscf.msscf.cfbam.CFBamMssCF;

import java.math.*;
import java.sql.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.MssCF.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfbam.CFBamObj.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.apache.commons.codec.binary.Base64;

/**
 *	CFBamMssCFBindDelSubDep1DelTopDepId binds DelSubDep1.DelTopDepId
 *	as an instance of MssCFGenBindObj.
 */
public class CFBamMssCFBindDelSubDep1DelTopDepId
	extends MssCFGenBindObj
{
	private static final long serialVersionUID = 1L;

	public CFBamMssCFBindDelSubDep1DelTopDepId() {
		super();
	}

	public CFBamMssCFBindDelSubDep1DelTopDepId( MssCFEngine argEngine ) {
		super( argEngine,
			"any",
			null,
			"DelSubDep1",
			"DelTopDepId" );
	}
	public Object getValueObject( MssCFGenContext genContext ) {
		final String S_ProcName = "CFBamMssCFBindDelSubDep1DelTopDepId.getValueObject() ";

		if( genContext == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"expandBody",
				1,
				"genContext" );
		}

		ICFLibAnyObj genDef = genContext.getGenDef();
		if( genDef == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"expandBody",
				1,
				"genContext.getGenDef()" );
		}

		long delTopDepId;
		if( genDef instanceof ICFBamDelSubDep1Obj ) {
			delTopDepId = ((ICFBamDelSubDep1Obj)genDef).getRequiredDelTopDepId();
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"expandBody",
				"genContext.getGenDef()",
				genDef,
				"ICFBamDelSubDep1Obj" );
		}

		return( delTopDepId );
	}

	public String expandBody( MssCFGenContext genContext ) {
		final String S_ProcName = "CFBamMssCFBindDelSubDep1DelTopDepId.expandBody() ";

		if( genContext == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"expandBody",
				1,
				"genContext" );
		}

		ICFLibAnyObj genDef = genContext.getGenDef();
		if( genDef == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"expandBody",
				1,
				"genContext.getGenDef()" );
		}

		String ret;

		if( genDef instanceof ICFBamDelSubDep1Obj ) {
			long delTopDepId = ((ICFBamDelSubDep1Obj)genDef).getRequiredDelTopDepId();
			ret = Long.toString( delTopDepId );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"expandBody",
				"genContext.getGenDef()",
				genDef,
				"ICFBamDelSubDep1Obj" );
		}

		return( ret );
	}

}
