
// Description: Java 11 Default Factory implementation for PopSubDep3.

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
	 *	CFBamPopSubDep3Factory implementation for PopSubDep3
	 */
public class CFBamPopSubDep3DefaultFactory
	implements ICFBamPopSubDep3Factory
{
	public CFBamPopSubDep3DefaultFactory() {
	}

	public CFBamPopSubDep3ByPopSubDep2IdxKey newPopSubDep2IdxKey() {
		CFBamPopSubDep3ByPopSubDep2IdxKey key =
			new CFBamPopSubDep3ByPopSubDep2IdxKey();
		return( key );
	}

	public CFBamPopSubDep3ByUNameIdxKey newUNameIdxKey() {
		CFBamPopSubDep3ByUNameIdxKey key =
			new CFBamPopSubDep3ByUNameIdxKey();
		return( key );
	}

	public CFBamPopSubDep3Buff newBuff() {
		CFBamPopSubDep3Buff buff =
			new CFBamPopSubDep3Buff();
		return( buff );
	}

	public CFBamPopSubDep3HBuff newHBuff() {
		CFBamPopSubDep3HBuff hbuff =
			new CFBamPopSubDep3HBuff();
		return( hbuff );
	}
}
