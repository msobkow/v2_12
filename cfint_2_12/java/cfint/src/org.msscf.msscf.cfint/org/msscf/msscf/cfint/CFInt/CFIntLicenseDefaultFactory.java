
// Description: Java 11 Default Factory implementation for License.

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
	 *	CFIntLicenseFactory implementation for License
	 */
public class CFIntLicenseDefaultFactory
	implements ICFIntLicenseFactory
{
	public CFIntLicenseDefaultFactory() {
	}

	public CFIntLicensePKey newPKey() {
		CFIntLicensePKey pkey =
			new CFIntLicensePKey();
		return( pkey );
	}

	public CFIntLicenseHPKey newHPKey() {
		CFIntLicenseHPKey hpkey =
			new CFIntLicenseHPKey();
		return( hpkey );
	}

	public CFIntLicenseByLicnTenantIdxKey newLicnTenantIdxKey() {
		CFIntLicenseByLicnTenantIdxKey key =
			new CFIntLicenseByLicnTenantIdxKey();
		return( key );
	}

	public CFIntLicenseByDomainIdxKey newDomainIdxKey() {
		CFIntLicenseByDomainIdxKey key =
			new CFIntLicenseByDomainIdxKey();
		return( key );
	}

	public CFIntLicenseByUNameIdxKey newUNameIdxKey() {
		CFIntLicenseByUNameIdxKey key =
			new CFIntLicenseByUNameIdxKey();
		return( key );
	}

	public CFIntLicenseBuff newBuff() {
		CFIntLicenseBuff buff =
			new CFIntLicenseBuff();
		return( buff );
	}

	public CFIntLicenseHBuff newHBuff() {
		CFIntLicenseHBuff hbuff =
			new CFIntLicenseHBuff();
		return( hbuff );
	}
}
