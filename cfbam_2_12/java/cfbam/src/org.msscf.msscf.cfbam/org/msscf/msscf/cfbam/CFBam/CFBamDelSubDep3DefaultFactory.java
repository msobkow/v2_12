
// Description: Java 11 Default Factory implementation for DelSubDep3.

/*
 *	org.msscf.msscf.CFBam
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
 *	
 *	MSS Code Factory is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with MSS Code Factory.  If not, see https://www.gnu.org/licenses/.
 *	
 *	Donations to support MSS Code Factory can be made at
 *	https://www.paypal.com/paypalme2/MarkSobkow
 *	
 *	Contact Mark Stephen Sobkow at msobkow@sasktel.net for commercial licensing.
 *
 *	Manufactured by MSS Code Factory 2.11
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
	 *	CFBamDelSubDep3Factory implementation for DelSubDep3
	 */
public class CFBamDelSubDep3DefaultFactory
	implements ICFBamDelSubDep3Factory
{
	public CFBamDelSubDep3DefaultFactory() {
	}

	public CFBamDelSubDep3ByDelSubDep2IdxKey newDelSubDep2IdxKey() {
		CFBamDelSubDep3ByDelSubDep2IdxKey key =
			new CFBamDelSubDep3ByDelSubDep2IdxKey();
		return( key );
	}

	public CFBamDelSubDep3ByUNameIdxKey newUNameIdxKey() {
		CFBamDelSubDep3ByUNameIdxKey key =
			new CFBamDelSubDep3ByUNameIdxKey();
		return( key );
	}

	public CFBamDelSubDep3Buff newBuff() {
		CFBamDelSubDep3Buff buff =
			new CFBamDelSubDep3Buff();
		return( buff );
	}

	public CFBamDelSubDep3HBuff newHBuff() {
		CFBamDelSubDep3HBuff hbuff =
			new CFBamDelSubDep3HBuff();
		return( hbuff );
	}
}
