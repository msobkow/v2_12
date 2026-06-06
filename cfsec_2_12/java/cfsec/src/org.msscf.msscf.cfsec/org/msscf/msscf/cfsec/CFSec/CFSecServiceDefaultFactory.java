
// Description: Java 11 Default Factory implementation for Service.

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
	 *	CFSecServiceFactory implementation for Service
	 */
public class CFSecServiceDefaultFactory
	implements ICFSecServiceFactory
{
	public CFSecServiceDefaultFactory() {
	}

	public CFSecServicePKey newPKey() {
		CFSecServicePKey pkey =
			new CFSecServicePKey();
		return( pkey );
	}

	public CFSecServiceHPKey newHPKey() {
		CFSecServiceHPKey hpkey =
			new CFSecServiceHPKey();
		return( hpkey );
	}

	public CFSecServiceByClusterIdxKey newClusterIdxKey() {
		CFSecServiceByClusterIdxKey key =
			new CFSecServiceByClusterIdxKey();
		return( key );
	}

	public CFSecServiceByHostIdxKey newHostIdxKey() {
		CFSecServiceByHostIdxKey key =
			new CFSecServiceByHostIdxKey();
		return( key );
	}

	public CFSecServiceByTypeIdxKey newTypeIdxKey() {
		CFSecServiceByTypeIdxKey key =
			new CFSecServiceByTypeIdxKey();
		return( key );
	}

	public CFSecServiceByUTypeIdxKey newUTypeIdxKey() {
		CFSecServiceByUTypeIdxKey key =
			new CFSecServiceByUTypeIdxKey();
		return( key );
	}

	public CFSecServiceByUHostPortIdxKey newUHostPortIdxKey() {
		CFSecServiceByUHostPortIdxKey key =
			new CFSecServiceByUHostPortIdxKey();
		return( key );
	}

	public CFSecServiceBuff newBuff() {
		CFSecServiceBuff buff =
			new CFSecServiceBuff();
		return( buff );
	}

	public CFSecServiceHBuff newHBuff() {
		CFSecServiceHBuff hbuff =
			new CFSecServiceHBuff();
		return( hbuff );
	}
}
