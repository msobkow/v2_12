
// Description: Java 11 MssCF Binding for SchemaDef Column CsMySqlSchemaObjMembers.

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
 *	CFBamMssCFBindSchemaDefCsMySqlSchemaObjMembers binds SchemaDef.CsMySqlSchemaObjMembers
 *	as an instance of MssCFGenBindObj.
 */
public class CFBamMssCFBindSchemaDefCsMySqlSchemaObjMembers
	extends MssCFGenBindObj
{
	private static final long serialVersionUID = 1L;

	public CFBamMssCFBindSchemaDefCsMySqlSchemaObjMembers() {
		super();
	}

	public CFBamMssCFBindSchemaDefCsMySqlSchemaObjMembers( MssCFEngine argEngine ) {
		super( argEngine,
			"any",
			null,
			"SchemaDef",
			"CsMySqlSchemaObjMembers" );
	}
	public Object getValueObject( MssCFGenContext genContext ) {
		final String S_ProcName = "CFBamMssCFBindSchemaDefCsMySqlSchemaObjMembers.getValueObject() ";

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

		String csMySqlSchemaObjMembers;
		if( genDef instanceof ICFBamSchemaDefObj ) {
			csMySqlSchemaObjMembers = ((ICFBamSchemaDefObj)genDef).getOptionalCsMySqlSchemaObjMembers();
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"expandBody",
				"genContext.getGenDef()",
				genDef,
				"ICFBamSchemaDefObj" );
		}

		return( csMySqlSchemaObjMembers );
	}

	public String expandBody( MssCFGenContext genContext ) {
		final String S_ProcName = "CFBamMssCFBindSchemaDefCsMySqlSchemaObjMembers.expandBody() ";

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
			String csMySqlSchemaObjMembers = ((ICFBamSchemaDefObj)genDef).getOptionalCsMySqlSchemaObjMembers();
			ret = csMySqlSchemaObjMembers;
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
