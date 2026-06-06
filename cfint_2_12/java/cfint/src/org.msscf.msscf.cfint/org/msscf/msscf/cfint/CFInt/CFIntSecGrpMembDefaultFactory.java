
// Description: Java 11 Default Factory implementation for SecGrpMemb.

/*
 *	org.msscf.msscf.CFInt
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
	 *	CFIntSecGrpMembFactory implementation for SecGrpMemb
	 */
public class CFIntSecGrpMembDefaultFactory
	extends CFSecSecGrpMembDefaultFactory
	implements ICFIntSecGrpMembFactory
{
	public CFIntSecGrpMembDefaultFactory() {
		super();
	}

	public CFSecSecGrpMembPKey newPKey() {
		CFSecSecGrpMembPKey pkey =
			new CFSecSecGrpMembPKey();
		return( pkey );
	}

	public CFSecSecGrpMembHPKey newHPKey() {
		CFSecSecGrpMembHPKey hpkey =
			new CFSecSecGrpMembHPKey();
		return( hpkey );
	}

	public CFSecSecGrpMembByClusterIdxKey newClusterIdxKey() {
		CFSecSecGrpMembByClusterIdxKey key =
			new CFSecSecGrpMembByClusterIdxKey();
		return( key );
	}

	public CFSecSecGrpMembByGroupIdxKey newGroupIdxKey() {
		CFSecSecGrpMembByGroupIdxKey key =
			new CFSecSecGrpMembByGroupIdxKey();
		return( key );
	}

	public CFSecSecGrpMembByUserIdxKey newUserIdxKey() {
		CFSecSecGrpMembByUserIdxKey key =
			new CFSecSecGrpMembByUserIdxKey();
		return( key );
	}

	public CFSecSecGrpMembByUUserIdxKey newUUserIdxKey() {
		CFSecSecGrpMembByUUserIdxKey key =
			new CFSecSecGrpMembByUUserIdxKey();
		return( key );
	}

	public CFSecSecGrpMembBuff newBuff() {
		CFSecSecGrpMembBuff buff =
			new CFSecSecGrpMembBuff();
		return( buff );
	}

	public CFSecSecGrpMembHBuff newHBuff() {
		CFSecSecGrpMembHBuff hbuff =
			new CFSecSecGrpMembHBuff();
		return( hbuff );
	}
}
