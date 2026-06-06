
// Description: Java 11 Default Factory implementation for TSecGrpInc.

/*
 *	org.msscf.msscf.CFSec
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

package org.msscf.msscf.cfsec.CFSec;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;

	/*
	 *	CFSecTSecGrpIncFactory implementation for TSecGrpInc
	 */
public class CFSecTSecGrpIncDefaultFactory
	implements ICFSecTSecGrpIncFactory
{
	public CFSecTSecGrpIncDefaultFactory() {
	}

	public CFSecTSecGrpIncPKey newPKey() {
		CFSecTSecGrpIncPKey pkey =
			new CFSecTSecGrpIncPKey();
		return( pkey );
	}

	public CFSecTSecGrpIncHPKey newHPKey() {
		CFSecTSecGrpIncHPKey hpkey =
			new CFSecTSecGrpIncHPKey();
		return( hpkey );
	}

	public CFSecTSecGrpIncByTenantIdxKey newTenantIdxKey() {
		CFSecTSecGrpIncByTenantIdxKey key =
			new CFSecTSecGrpIncByTenantIdxKey();
		return( key );
	}

	public CFSecTSecGrpIncByGroupIdxKey newGroupIdxKey() {
		CFSecTSecGrpIncByGroupIdxKey key =
			new CFSecTSecGrpIncByGroupIdxKey();
		return( key );
	}

	public CFSecTSecGrpIncByIncludeIdxKey newIncludeIdxKey() {
		CFSecTSecGrpIncByIncludeIdxKey key =
			new CFSecTSecGrpIncByIncludeIdxKey();
		return( key );
	}

	public CFSecTSecGrpIncByUIncludeIdxKey newUIncludeIdxKey() {
		CFSecTSecGrpIncByUIncludeIdxKey key =
			new CFSecTSecGrpIncByUIncludeIdxKey();
		return( key );
	}

	public CFSecTSecGrpIncBuff newBuff() {
		CFSecTSecGrpIncBuff buff =
			new CFSecTSecGrpIncBuff();
		return( buff );
	}

	public CFSecTSecGrpIncHBuff newHBuff() {
		CFSecTSecGrpIncHBuff hbuff =
			new CFSecTSecGrpIncHBuff();
		return( hbuff );
	}
}
