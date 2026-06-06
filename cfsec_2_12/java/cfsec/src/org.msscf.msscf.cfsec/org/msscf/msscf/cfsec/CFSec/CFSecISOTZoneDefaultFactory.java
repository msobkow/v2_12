
// Description: Java 11 Default Factory implementation for ISOTZone.

/*
 *	org.msscf.msscf.CFSec
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
	 *	CFSecISOTZoneFactory implementation for ISOTZone
	 */
public class CFSecISOTZoneDefaultFactory
	implements ICFSecISOTZoneFactory
{
	public CFSecISOTZoneDefaultFactory() {
	}

	public CFSecISOTZonePKey newPKey() {
		CFSecISOTZonePKey pkey =
			new CFSecISOTZonePKey();
		return( pkey );
	}

	public CFSecISOTZoneHPKey newHPKey() {
		CFSecISOTZoneHPKey hpkey =
			new CFSecISOTZoneHPKey();
		return( hpkey );
	}

	public CFSecISOTZoneByOffsetIdxKey newOffsetIdxKey() {
		CFSecISOTZoneByOffsetIdxKey key =
			new CFSecISOTZoneByOffsetIdxKey();
		return( key );
	}

	public CFSecISOTZoneByUTZNameIdxKey newUTZNameIdxKey() {
		CFSecISOTZoneByUTZNameIdxKey key =
			new CFSecISOTZoneByUTZNameIdxKey();
		return( key );
	}

	public CFSecISOTZoneByIso8601IdxKey newIso8601IdxKey() {
		CFSecISOTZoneByIso8601IdxKey key =
			new CFSecISOTZoneByIso8601IdxKey();
		return( key );
	}

	public CFSecISOTZoneBuff newBuff() {
		CFSecISOTZoneBuff buff =
			new CFSecISOTZoneBuff();
		return( buff );
	}

	public CFSecISOTZoneHBuff newHBuff() {
		CFSecISOTZoneHBuff hbuff =
			new CFSecISOTZoneHBuff();
		return( hbuff );
	}
}
