
// Description: Java 11 Default Factory implementation for TSecGroup.

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
	 *	CFIntTSecGroupFactory implementation for TSecGroup
	 */
public class CFIntTSecGroupDefaultFactory
	extends CFSecTSecGroupDefaultFactory
	implements ICFIntTSecGroupFactory
{
	public CFIntTSecGroupDefaultFactory() {
		super();
	}

	public CFSecTSecGroupPKey newPKey() {
		CFSecTSecGroupPKey pkey =
			new CFSecTSecGroupPKey();
		return( pkey );
	}

	public CFSecTSecGroupHPKey newHPKey() {
		CFSecTSecGroupHPKey hpkey =
			new CFSecTSecGroupHPKey();
		return( hpkey );
	}

	public CFSecTSecGroupByTenantIdxKey newTenantIdxKey() {
		CFSecTSecGroupByTenantIdxKey key =
			new CFSecTSecGroupByTenantIdxKey();
		return( key );
	}

	public CFSecTSecGroupByTenantVisIdxKey newTenantVisIdxKey() {
		CFSecTSecGroupByTenantVisIdxKey key =
			new CFSecTSecGroupByTenantVisIdxKey();
		return( key );
	}

	public CFSecTSecGroupByUNameIdxKey newUNameIdxKey() {
		CFSecTSecGroupByUNameIdxKey key =
			new CFSecTSecGroupByUNameIdxKey();
		return( key );
	}

	public CFSecTSecGroupBuff newBuff() {
		CFSecTSecGroupBuff buff =
			new CFSecTSecGroupBuff();
		return( buff );
	}

	public CFSecTSecGroupHBuff newHBuff() {
		CFSecTSecGroupHBuff hbuff =
			new CFSecTSecGroupHBuff();
		return( hbuff );
	}
}
