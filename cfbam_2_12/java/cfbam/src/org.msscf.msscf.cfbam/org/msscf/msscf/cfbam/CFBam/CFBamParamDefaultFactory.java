
// Description: Java 11 Default Factory implementation for Param.

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

package org.msscf.msscf.cfbam.CFBam;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;

	/*
	 *	CFBamParamFactory implementation for Param
	 */
public class CFBamParamDefaultFactory
	implements ICFBamParamFactory
{
	public CFBamParamDefaultFactory() {
	}

	public CFBamParamPKey newPKey() {
		CFBamParamPKey pkey =
			new CFBamParamPKey();
		return( pkey );
	}

	public CFBamParamHPKey newHPKey() {
		CFBamParamHPKey hpkey =
			new CFBamParamHPKey();
		return( hpkey );
	}

	public CFBamParamByUNameIdxKey newUNameIdxKey() {
		CFBamParamByUNameIdxKey key =
			new CFBamParamByUNameIdxKey();
		return( key );
	}

	public CFBamParamByValTentIdxKey newValTentIdxKey() {
		CFBamParamByValTentIdxKey key =
			new CFBamParamByValTentIdxKey();
		return( key );
	}

	public CFBamParamByServerMethodIdxKey newServerMethodIdxKey() {
		CFBamParamByServerMethodIdxKey key =
			new CFBamParamByServerMethodIdxKey();
		return( key );
	}

	public CFBamParamByDefSchemaIdxKey newDefSchemaIdxKey() {
		CFBamParamByDefSchemaIdxKey key =
			new CFBamParamByDefSchemaIdxKey();
		return( key );
	}

	public CFBamParamByServerTypeIdxKey newServerTypeIdxKey() {
		CFBamParamByServerTypeIdxKey key =
			new CFBamParamByServerTypeIdxKey();
		return( key );
	}

	public CFBamParamByPrevIdxKey newPrevIdxKey() {
		CFBamParamByPrevIdxKey key =
			new CFBamParamByPrevIdxKey();
		return( key );
	}

	public CFBamParamByNextIdxKey newNextIdxKey() {
		CFBamParamByNextIdxKey key =
			new CFBamParamByNextIdxKey();
		return( key );
	}

	public CFBamParamByContPrevIdxKey newContPrevIdxKey() {
		CFBamParamByContPrevIdxKey key =
			new CFBamParamByContPrevIdxKey();
		return( key );
	}

	public CFBamParamByContNextIdxKey newContNextIdxKey() {
		CFBamParamByContNextIdxKey key =
			new CFBamParamByContNextIdxKey();
		return( key );
	}

	public CFBamParamBuff newBuff() {
		CFBamParamBuff buff =
			new CFBamParamBuff();
		return( buff );
	}

	public CFBamParamHBuff newHBuff() {
		CFBamParamHBuff hbuff =
			new CFBamParamHBuff();
		return( hbuff );
	}
}
