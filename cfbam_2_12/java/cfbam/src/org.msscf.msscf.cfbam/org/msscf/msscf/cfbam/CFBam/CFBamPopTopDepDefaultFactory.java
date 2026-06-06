
// Description: Java 11 Default Factory implementation for PopTopDep.

/*
 *	org.msscf.msscf.CFBam
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
	 *	CFBamPopTopDepFactory implementation for PopTopDep
	 */
public class CFBamPopTopDepDefaultFactory
	implements ICFBamPopTopDepFactory
{
	public CFBamPopTopDepDefaultFactory() {
	}

	public CFBamPopTopDepByContRelIdxKey newContRelIdxKey() {
		CFBamPopTopDepByContRelIdxKey key =
			new CFBamPopTopDepByContRelIdxKey();
		return( key );
	}

	public CFBamPopTopDepByUNameIdxKey newUNameIdxKey() {
		CFBamPopTopDepByUNameIdxKey key =
			new CFBamPopTopDepByUNameIdxKey();
		return( key );
	}

	public CFBamPopTopDepBuff newBuff() {
		CFBamPopTopDepBuff buff =
			new CFBamPopTopDepBuff();
		return( buff );
	}

	public CFBamPopTopDepHBuff newHBuff() {
		CFBamPopTopDepHBuff hbuff =
			new CFBamPopTopDepHBuff();
		return( hbuff );
	}
}
