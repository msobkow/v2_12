
// Description: Java 11 Default Factory implementation for URLProtocol.

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
	 *	CFIntURLProtocolFactory implementation for URLProtocol
	 */
public class CFIntURLProtocolDefaultFactory
	implements ICFIntURLProtocolFactory
{
	public CFIntURLProtocolDefaultFactory() {
	}

	public CFIntURLProtocolPKey newPKey() {
		CFIntURLProtocolPKey pkey =
			new CFIntURLProtocolPKey();
		return( pkey );
	}

	public CFIntURLProtocolHPKey newHPKey() {
		CFIntURLProtocolHPKey hpkey =
			new CFIntURLProtocolHPKey();
		return( hpkey );
	}

	public CFIntURLProtocolByUNameIdxKey newUNameIdxKey() {
		CFIntURLProtocolByUNameIdxKey key =
			new CFIntURLProtocolByUNameIdxKey();
		return( key );
	}

	public CFIntURLProtocolByIsSecureIdxKey newIsSecureIdxKey() {
		CFIntURLProtocolByIsSecureIdxKey key =
			new CFIntURLProtocolByIsSecureIdxKey();
		return( key );
	}

	public CFIntURLProtocolBuff newBuff() {
		CFIntURLProtocolBuff buff =
			new CFIntURLProtocolBuff();
		return( buff );
	}

	public CFIntURLProtocolHBuff newHBuff() {
		CFIntURLProtocolHBuff hbuff =
			new CFIntURLProtocolHBuff();
		return( hbuff );
	}
}
