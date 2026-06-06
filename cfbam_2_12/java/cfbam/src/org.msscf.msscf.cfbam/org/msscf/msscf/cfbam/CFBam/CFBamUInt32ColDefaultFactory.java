
// Description: Java 11 Default Factory implementation for UInt32Col.

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
	 *	CFBamUInt32ColFactory implementation for UInt32Col
	 */
public class CFBamUInt32ColDefaultFactory
	implements ICFBamUInt32ColFactory
{
	public CFBamUInt32ColDefaultFactory() {
	}

	public CFBamUInt32ColByTableIdxKey newTableIdxKey() {
		CFBamUInt32ColByTableIdxKey key =
			new CFBamUInt32ColByTableIdxKey();
		return( key );
	}

	public CFBamUInt32ColBuff newBuff() {
		CFBamUInt32ColBuff buff =
			new CFBamUInt32ColBuff();
		return( buff );
	}

	public CFBamUInt32ColHBuff newHBuff() {
		CFBamUInt32ColHBuff hbuff =
			new CFBamUInt32ColHBuff();
		return( hbuff );
	}
}
