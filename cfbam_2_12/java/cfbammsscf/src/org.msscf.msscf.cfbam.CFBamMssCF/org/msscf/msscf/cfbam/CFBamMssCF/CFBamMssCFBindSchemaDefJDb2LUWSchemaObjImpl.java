
// Description: Java 11 MssCF Binding for SchemaDef Column JDb2LUWSchemaObjImpl.

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
 *	CFBamMssCFBindSchemaDefJDb2LUWSchemaObjImpl binds SchemaDef.JDb2LUWSchemaObjImpl
 *	as an instance of MssCFGenBindObj.
 */
public class CFBamMssCFBindSchemaDefJDb2LUWSchemaObjImpl
	extends MssCFGenBindObj
{
	private static final long serialVersionUID = 1L;

	public CFBamMssCFBindSchemaDefJDb2LUWSchemaObjImpl() {
		super();
	}

	public CFBamMssCFBindSchemaDefJDb2LUWSchemaObjImpl( MssCFEngine argEngine ) {
		super( argEngine,
			"any",
			null,
			"SchemaDef",
			"JDb2LUWSchemaObjImpl" );
	}
	public Object getValueObject( MssCFGenContext genContext ) {
		final String S_ProcName = "CFBamMssCFBindSchemaDefJDb2LUWSchemaObjImpl.getValueObject() ";

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

		String jDb2LUWSchemaObjImpl;
		if( genDef instanceof ICFBamSchemaDefObj ) {
			jDb2LUWSchemaObjImpl = ((ICFBamSchemaDefObj)genDef).getOptionalJDb2LUWSchemaObjImpl();
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"expandBody",
				"genContext.getGenDef()",
				genDef,
				"ICFBamSchemaDefObj" );
		}

		return( jDb2LUWSchemaObjImpl );
	}

	public String expandBody( MssCFGenContext genContext ) {
		final String S_ProcName = "CFBamMssCFBindSchemaDefJDb2LUWSchemaObjImpl.expandBody() ";

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

		if( genDef instanceof ICFBamSchemaDefObj ) {
			String jDb2LUWSchemaObjImpl = ((ICFBamSchemaDefObj)genDef).getOptionalJDb2LUWSchemaObjImpl();
			ret = jDb2LUWSchemaObjImpl;
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"expandBody",
				"genContext.getGenDef()",
				genDef,
				"ICFBamSchemaDefObj" );
		}

		return( ret );
	}

}
