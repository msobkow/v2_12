
// Description: Java 11 Default Factory implementation for DelTopDep.

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
	 *	CFBamDelTopDepFactory implementation for DelTopDep
	 */
public class CFBamDelTopDepDefaultFactory
	implements ICFBamDelTopDepFactory
{
	public CFBamDelTopDepDefaultFactory() {
	}

	public CFBamDelTopDepByDelTopDepTblIdxKey newDelTopDepTblIdxKey() {
		CFBamDelTopDepByDelTopDepTblIdxKey key =
			new CFBamDelTopDepByDelTopDepTblIdxKey();
		return( key );
	}

	public CFBamDelTopDepByUNameIdxKey newUNameIdxKey() {
		CFBamDelTopDepByUNameIdxKey key =
			new CFBamDelTopDepByUNameIdxKey();
		return( key );
	}

	public CFBamDelTopDepByPrevIdxKey newPrevIdxKey() {
		CFBamDelTopDepByPrevIdxKey key =
			new CFBamDelTopDepByPrevIdxKey();
		return( key );
	}

	public CFBamDelTopDepByNextIdxKey newNextIdxKey() {
		CFBamDelTopDepByNextIdxKey key =
			new CFBamDelTopDepByNextIdxKey();
		return( key );
	}

	public CFBamDelTopDepBuff newBuff() {
		CFBamDelTopDepBuff buff =
			new CFBamDelTopDepBuff();
		return( buff );
	}

	public CFBamDelTopDepHBuff newHBuff() {
		CFBamDelTopDepHBuff hbuff =
			new CFBamDelTopDepHBuff();
		return( hbuff );
	}
}
