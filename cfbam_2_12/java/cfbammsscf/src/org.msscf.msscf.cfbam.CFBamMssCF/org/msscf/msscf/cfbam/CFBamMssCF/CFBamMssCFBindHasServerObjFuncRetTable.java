
// Description: Java 11 MssCF Binding for ServerObjFunc Has RetTable.

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

import java.sql.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.MssCF.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfbam.CFBamObj.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;

public class CFBamMssCFBindHasServerObjFuncRetTable
	extends MssCFGenBindObj
{
	private static final long serialVersionUID = 1L;

	public CFBamMssCFBindHasServerObjFuncRetTable() {
		super();
	}

	public CFBamMssCFBindHasServerObjFuncRetTable( MssCFEngine argEngine ) {
		super( argEngine,
			"any",
			null,
			"ServerObjFunc",
			"HasRetTable" );
	}

	public String expandBody( MssCFGenContext genContext ) {
		final String S_ProcName = "expandBody";

		if( genContext == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"genContext" );
		}

		ICFLibAnyObj genDef = genContext.getGenDef();
		if( genDef == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"genContext.getGenDef()" );
		}

		ICFBamTableObj obj;

		if( genDef instanceof ICFBamServerObjFuncObj ) {
			obj = (ICFBamTableObj)((ICFBamServerObjFuncObj)genDef).getOptionalLookupRetTable();
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"genContext.getGenDef()",
				genDef,
				"ICFBamServerObjFuncObj" );
		}

		if( obj != null ) {
			return( "yes" );
		}
		else {
			return( "no" );
		}
	}
}
