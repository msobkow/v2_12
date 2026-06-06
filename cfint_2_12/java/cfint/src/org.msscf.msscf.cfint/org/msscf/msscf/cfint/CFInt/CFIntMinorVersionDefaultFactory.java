
// Description: Java 11 Default Factory implementation for MinorVersion.

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
	 *	CFIntMinorVersionFactory implementation for MinorVersion
	 */
public class CFIntMinorVersionDefaultFactory
	implements ICFIntMinorVersionFactory
{
	public CFIntMinorVersionDefaultFactory() {
	}

	public CFIntMinorVersionPKey newPKey() {
		CFIntMinorVersionPKey pkey =
			new CFIntMinorVersionPKey();
		return( pkey );
	}

	public CFIntMinorVersionHPKey newHPKey() {
		CFIntMinorVersionHPKey hpkey =
			new CFIntMinorVersionHPKey();
		return( hpkey );
	}

	public CFIntMinorVersionByTenantIdxKey newTenantIdxKey() {
		CFIntMinorVersionByTenantIdxKey key =
			new CFIntMinorVersionByTenantIdxKey();
		return( key );
	}

	public CFIntMinorVersionByMajorVerIdxKey newMajorVerIdxKey() {
		CFIntMinorVersionByMajorVerIdxKey key =
			new CFIntMinorVersionByMajorVerIdxKey();
		return( key );
	}

	public CFIntMinorVersionByNameIdxKey newNameIdxKey() {
		CFIntMinorVersionByNameIdxKey key =
			new CFIntMinorVersionByNameIdxKey();
		return( key );
	}

	public CFIntMinorVersionBuff newBuff() {
		CFIntMinorVersionBuff buff =
			new CFIntMinorVersionBuff();
		return( buff );
	}

	public CFIntMinorVersionHBuff newHBuff() {
		CFIntMinorVersionHBuff hbuff =
			new CFIntMinorVersionHBuff();
		return( hbuff );
	}
}
