
// Description: Java 11 Default Factory implementation for GelCall.

/*
 *	org.msscf.msscf.CFCore
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
	 *	CFGenKbGelCallFactory implementation for GelCall
	 */
public class CFGenKbGelCallDefaultFactory
	implements ICFGenKbGelCallFactory
{
	public CFGenKbGelCallDefaultFactory() {
	}

	public CFGenKbGelCallByCacheIdxKey newCacheIdxKey() {
		CFGenKbGelCallByCacheIdxKey key =
			new CFGenKbGelCallByCacheIdxKey();
		return( key );
	}

	public CFGenKbGelCallBySeqIdxKey newSeqIdxKey() {
		CFGenKbGelCallBySeqIdxKey key =
			new CFGenKbGelCallBySeqIdxKey();
		return( key );
	}

	public CFGenKbGelCallByCallInstIdxKey newCallInstIdxKey() {
		CFGenKbGelCallByCallInstIdxKey key =
			new CFGenKbGelCallByCallInstIdxKey();
		return( key );
	}

	public CFGenKbGelCallByPrevInstIdxKey newPrevInstIdxKey() {
		CFGenKbGelCallByPrevInstIdxKey key =
			new CFGenKbGelCallByPrevInstIdxKey();
		return( key );
	}

	public CFGenKbGelCallByNextInstIdxKey newNextInstIdxKey() {
		CFGenKbGelCallByNextInstIdxKey key =
			new CFGenKbGelCallByNextInstIdxKey();
		return( key );
	}

	public CFGenKbGelCallBuff newBuff() {
		CFGenKbGelCallBuff buff =
			new CFGenKbGelCallBuff();
		return( buff );
	}
}
