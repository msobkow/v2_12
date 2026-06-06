
// Description: Java 11 Default Factory implementation for SecSession.

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
	 *	CFIntSecSessionFactory implementation for SecSession
	 */
public class CFIntSecSessionDefaultFactory
	extends CFSecSecSessionDefaultFactory
	implements ICFIntSecSessionFactory
{
	public CFIntSecSessionDefaultFactory() {
		super();
	}

	public CFSecSecSessionPKey newPKey() {
		CFSecSecSessionPKey pkey =
			new CFSecSecSessionPKey();
		return( pkey );
	}

	public CFSecSecSessionHPKey newHPKey() {
		CFSecSecSessionHPKey hpkey =
			new CFSecSecSessionHPKey();
		return( hpkey );
	}

	public CFSecSecSessionBySecUserIdxKey newSecUserIdxKey() {
		CFSecSecSessionBySecUserIdxKey key =
			new CFSecSecSessionBySecUserIdxKey();
		return( key );
	}

	public CFSecSecSessionBySecDevIdxKey newSecDevIdxKey() {
		CFSecSecSessionBySecDevIdxKey key =
			new CFSecSecSessionBySecDevIdxKey();
		return( key );
	}

	public CFSecSecSessionByStartIdxKey newStartIdxKey() {
		CFSecSecSessionByStartIdxKey key =
			new CFSecSecSessionByStartIdxKey();
		return( key );
	}

	public CFSecSecSessionByFinishIdxKey newFinishIdxKey() {
		CFSecSecSessionByFinishIdxKey key =
			new CFSecSecSessionByFinishIdxKey();
		return( key );
	}

	public CFSecSecSessionBySecProxyIdxKey newSecProxyIdxKey() {
		CFSecSecSessionBySecProxyIdxKey key =
			new CFSecSecSessionBySecProxyIdxKey();
		return( key );
	}

	public CFSecSecSessionBuff newBuff() {
		CFSecSecSessionBuff buff =
			new CFSecSecSessionBuff();
		return( buff );
	}

	public CFSecSecSessionHBuff newHBuff() {
		CFSecSecSessionHBuff hbuff =
			new CFSecSecSessionHBuff();
		return( hbuff );
	}
}
