
// Description: Java 11 Default Factory implementation for Id16Gen.

/*
 *	org.msscf.msscf.CFBam
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

package org.msscf.msscf.cfbam.CFBam;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;

	/*
	 *	CFBamId16GenFactory implementation for Id16Gen
	 */
public class CFBamId16GenDefaultFactory
	implements ICFBamId16GenFactory
{
	public CFBamId16GenDefaultFactory() {
	}

	public CFBamId16GenByDispIdxKey newDispIdxKey() {
		CFBamId16GenByDispIdxKey key =
			new CFBamId16GenByDispIdxKey();
		return( key );
	}

	public CFBamId16GenBuff newBuff() {
		CFBamId16GenBuff buff =
			new CFBamId16GenBuff();
		return( buff );
	}

	public CFBamId16GenHBuff newHBuff() {
		CFBamId16GenHBuff hbuff =
			new CFBamId16GenHBuff();
		return( hbuff );
	}
}
