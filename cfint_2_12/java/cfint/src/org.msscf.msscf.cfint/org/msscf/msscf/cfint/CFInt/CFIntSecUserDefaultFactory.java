
// Description: Java 11 Default Factory implementation for SecUser.

/*
 *	org.msscf.msscf.CFInt
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
	 *	CFIntSecUserFactory implementation for SecUser
	 */
public class CFIntSecUserDefaultFactory
	extends CFSecSecUserDefaultFactory
	implements ICFIntSecUserFactory
{
	public CFIntSecUserDefaultFactory() {
		super();
	}

	public CFSecSecUserPKey newPKey() {
		CFSecSecUserPKey pkey =
			new CFSecSecUserPKey();
		return( pkey );
	}

	public CFSecSecUserHPKey newHPKey() {
		CFSecSecUserHPKey hpkey =
			new CFSecSecUserHPKey();
		return( hpkey );
	}

	public CFSecSecUserByULoginIdxKey newULoginIdxKey() {
		CFSecSecUserByULoginIdxKey key =
			new CFSecSecUserByULoginIdxKey();
		return( key );
	}

	public CFSecSecUserByEMConfIdxKey newEMConfIdxKey() {
		CFSecSecUserByEMConfIdxKey key =
			new CFSecSecUserByEMConfIdxKey();
		return( key );
	}

	public CFSecSecUserByPwdResetIdxKey newPwdResetIdxKey() {
		CFSecSecUserByPwdResetIdxKey key =
			new CFSecSecUserByPwdResetIdxKey();
		return( key );
	}

	public CFSecSecUserByDefDevIdxKey newDefDevIdxKey() {
		CFSecSecUserByDefDevIdxKey key =
			new CFSecSecUserByDefDevIdxKey();
		return( key );
	}

	public CFSecSecUserBuff newBuff() {
		CFSecSecUserBuff buff =
			new CFSecSecUserBuff();
		return( buff );
	}

	public CFSecSecUserHBuff newHBuff() {
		CFSecSecUserHBuff hbuff =
			new CFSecSecUserHBuff();
		return( hbuff );
	}
}
