
// Description: Java 11 Default Factory implementation for SecGrpInc.

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
	 *	CFIntSecGrpIncFactory implementation for SecGrpInc
	 */
public class CFIntSecGrpIncDefaultFactory
	extends CFSecSecGrpIncDefaultFactory
	implements ICFIntSecGrpIncFactory
{
	public CFIntSecGrpIncDefaultFactory() {
		super();
	}

	public CFSecSecGrpIncPKey newPKey() {
		CFSecSecGrpIncPKey pkey =
			new CFSecSecGrpIncPKey();
		return( pkey );
	}

	public CFSecSecGrpIncHPKey newHPKey() {
		CFSecSecGrpIncHPKey hpkey =
			new CFSecSecGrpIncHPKey();
		return( hpkey );
	}

	public CFSecSecGrpIncByClusterIdxKey newClusterIdxKey() {
		CFSecSecGrpIncByClusterIdxKey key =
			new CFSecSecGrpIncByClusterIdxKey();
		return( key );
	}

	public CFSecSecGrpIncByGroupIdxKey newGroupIdxKey() {
		CFSecSecGrpIncByGroupIdxKey key =
			new CFSecSecGrpIncByGroupIdxKey();
		return( key );
	}

	public CFSecSecGrpIncByIncludeIdxKey newIncludeIdxKey() {
		CFSecSecGrpIncByIncludeIdxKey key =
			new CFSecSecGrpIncByIncludeIdxKey();
		return( key );
	}

	public CFSecSecGrpIncByUIncludeIdxKey newUIncludeIdxKey() {
		CFSecSecGrpIncByUIncludeIdxKey key =
			new CFSecSecGrpIncByUIncludeIdxKey();
		return( key );
	}

	public CFSecSecGrpIncBuff newBuff() {
		CFSecSecGrpIncBuff buff =
			new CFSecSecGrpIncBuff();
		return( buff );
	}

	public CFSecSecGrpIncHBuff newHBuff() {
		CFSecSecGrpIncHBuff hbuff =
			new CFSecSecGrpIncHBuff();
		return( hbuff );
	}
}
