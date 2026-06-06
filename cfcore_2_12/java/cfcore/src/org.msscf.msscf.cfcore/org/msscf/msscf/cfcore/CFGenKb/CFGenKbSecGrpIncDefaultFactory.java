
// Description: Java 11 Default Factory implementation for SecGrpInc.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKb;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;

	/*
	 *	CFGenKbSecGrpIncFactory implementation for SecGrpInc
	 */
public class CFGenKbSecGrpIncDefaultFactory
	implements ICFGenKbSecGrpIncFactory
{
	public CFGenKbSecGrpIncDefaultFactory() {
	}

	public CFGenKbSecGrpIncPKey newPKey() {
		CFGenKbSecGrpIncPKey pkey =
			new CFGenKbSecGrpIncPKey();
		return( pkey );
	}

	public CFGenKbSecGrpIncByClusterIdxKey newClusterIdxKey() {
		CFGenKbSecGrpIncByClusterIdxKey key =
			new CFGenKbSecGrpIncByClusterIdxKey();
		return( key );
	}

	public CFGenKbSecGrpIncByGroupIdxKey newGroupIdxKey() {
		CFGenKbSecGrpIncByGroupIdxKey key =
			new CFGenKbSecGrpIncByGroupIdxKey();
		return( key );
	}

	public CFGenKbSecGrpIncByIncludeIdxKey newIncludeIdxKey() {
		CFGenKbSecGrpIncByIncludeIdxKey key =
			new CFGenKbSecGrpIncByIncludeIdxKey();
		return( key );
	}

	public CFGenKbSecGrpIncByUIncludeIdxKey newUIncludeIdxKey() {
		CFGenKbSecGrpIncByUIncludeIdxKey key =
			new CFGenKbSecGrpIncByUIncludeIdxKey();
		return( key );
	}

	public CFGenKbSecGrpIncBuff newBuff() {
		CFGenKbSecGrpIncBuff buff =
			new CFGenKbSecGrpIncBuff();
		return( buff );
	}
}
