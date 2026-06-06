
// Description: Java 11 Default Factory implementation for MajorVersion.

/*
 *	org.msscf.msscf.CFBam
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
	 *	CFBamMajorVersionFactory implementation for MajorVersion
	 */
public class CFBamMajorVersionDefaultFactory
	extends CFIntMajorVersionDefaultFactory
	implements ICFBamMajorVersionFactory
{
	public CFBamMajorVersionDefaultFactory() {
		super();
	}

	public CFIntMajorVersionPKey newPKey() {
		CFIntMajorVersionPKey pkey =
			new CFIntMajorVersionPKey();
		return( pkey );
	}

	public CFIntMajorVersionHPKey newHPKey() {
		CFIntMajorVersionHPKey hpkey =
			new CFIntMajorVersionHPKey();
		return( hpkey );
	}

	public CFIntMajorVersionByTenantIdxKey newTenantIdxKey() {
		CFIntMajorVersionByTenantIdxKey key =
			new CFIntMajorVersionByTenantIdxKey();
		return( key );
	}

	public CFIntMajorVersionBySubProjectIdxKey newSubProjectIdxKey() {
		CFIntMajorVersionBySubProjectIdxKey key =
			new CFIntMajorVersionBySubProjectIdxKey();
		return( key );
	}

	public CFIntMajorVersionByNameIdxKey newNameIdxKey() {
		CFIntMajorVersionByNameIdxKey key =
			new CFIntMajorVersionByNameIdxKey();
		return( key );
	}

	public CFIntMajorVersionBuff newBuff() {
		CFIntMajorVersionBuff buff =
			new CFIntMajorVersionBuff();
		return( buff );
	}

	public CFIntMajorVersionHBuff newHBuff() {
		CFIntMajorVersionHBuff hbuff =
			new CFIntMajorVersionHBuff();
		return( hbuff );
	}
}
