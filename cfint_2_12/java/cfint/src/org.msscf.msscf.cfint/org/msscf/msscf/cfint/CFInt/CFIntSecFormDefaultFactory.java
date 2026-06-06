
// Description: Java 11 Default Factory implementation for SecForm.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFInt;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;

	/*
	 *	CFIntSecFormFactory implementation for SecForm
	 */
public class CFIntSecFormDefaultFactory
	extends CFSecSecFormDefaultFactory
	implements ICFIntSecFormFactory
{
	public CFIntSecFormDefaultFactory() {
		super();
	}

	public CFSecSecFormPKey newPKey() {
		CFSecSecFormPKey pkey =
			new CFSecSecFormPKey();
		return( pkey );
	}

	public CFSecSecFormHPKey newHPKey() {
		CFSecSecFormHPKey hpkey =
			new CFSecSecFormHPKey();
		return( hpkey );
	}

	public CFSecSecFormByClusterIdxKey newClusterIdxKey() {
		CFSecSecFormByClusterIdxKey key =
			new CFSecSecFormByClusterIdxKey();
		return( key );
	}

	public CFSecSecFormBySecAppIdxKey newSecAppIdxKey() {
		CFSecSecFormBySecAppIdxKey key =
			new CFSecSecFormBySecAppIdxKey();
		return( key );
	}

	public CFSecSecFormByUJEEServletIdxKey newUJEEServletIdxKey() {
		CFSecSecFormByUJEEServletIdxKey key =
			new CFSecSecFormByUJEEServletIdxKey();
		return( key );
	}

	public CFSecSecFormBuff newBuff() {
		CFSecSecFormBuff buff =
			new CFSecSecFormBuff();
		return( buff );
	}

	public CFSecSecFormHBuff newHBuff() {
		CFSecSecFormHBuff hbuff =
			new CFSecSecFormHBuff();
		return( hbuff );
	}
}
