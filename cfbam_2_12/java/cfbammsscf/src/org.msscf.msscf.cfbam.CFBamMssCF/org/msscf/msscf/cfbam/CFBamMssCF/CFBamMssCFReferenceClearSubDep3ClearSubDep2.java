
// Description: Java 11 MssCF Reference for ClearSubDep3 Relationship ClearSubDep2.

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

/**
 *	CFBamMssCFReferenceClearSubDep3ClearSubDep2 binds ClearSubDep3.ClearSubDep2
 *	as an instance of MssCFGenReferenceObj.
 */
public class CFBamMssCFReferenceClearSubDep3ClearSubDep2
	extends MssCFGenReferenceObj
{
	private static final long serialVersionUID = 1L;

	public CFBamMssCFReferenceClearSubDep3ClearSubDep2() {
		super();
	}

	public CFBamMssCFReferenceClearSubDep3ClearSubDep2( MssCFEngine argEngine ) {
		super( argEngine,
			"any",
			null,
			"ClearSubDep3",
			"ClearSubDep2",
			"ClearSubDep2" );
	}

	public ICFLibAnyObj dereference( MssCFGenContext genContext ) {
		final String S_ProcName = "CFBamMssCFReferenceClearSubDep3ClearSubDep2.dereference() ";

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

		ICFBamClearSubDep2Obj obj;

		if( genDef instanceof ICFBamClearSubDep3Obj ) {
			obj = (ICFBamClearSubDep2Obj)((ICFBamClearSubDep3Obj)genDef).getRequiredContainerClearSubDep2();
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"genContext.getGenDef()",
				genDef,
				"ICFBamClearSubDep3Obj" );
		}

		return( obj );
	}
}
