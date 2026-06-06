
// Description: Java 11 Default Factory implementation for ClearSubDep1.

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
	 *	CFBamClearSubDep1Factory implementation for ClearSubDep1
	 */
public class CFBamClearSubDep1DefaultFactory
	implements ICFBamClearSubDep1Factory
{
	public CFBamClearSubDep1DefaultFactory() {
	}

	public CFBamClearSubDep1ByClearTopDepIdxKey newClearTopDepIdxKey() {
		CFBamClearSubDep1ByClearTopDepIdxKey key =
			new CFBamClearSubDep1ByClearTopDepIdxKey();
		return( key );
	}

	public CFBamClearSubDep1ByUNameIdxKey newUNameIdxKey() {
		CFBamClearSubDep1ByUNameIdxKey key =
			new CFBamClearSubDep1ByUNameIdxKey();
		return( key );
	}

	public CFBamClearSubDep1Buff newBuff() {
		CFBamClearSubDep1Buff buff =
			new CFBamClearSubDep1Buff();
		return( buff );
	}

	public CFBamClearSubDep1HBuff newHBuff() {
		CFBamClearSubDep1HBuff hbuff =
			new CFBamClearSubDep1HBuff();
		return( hbuff );
	}
}
