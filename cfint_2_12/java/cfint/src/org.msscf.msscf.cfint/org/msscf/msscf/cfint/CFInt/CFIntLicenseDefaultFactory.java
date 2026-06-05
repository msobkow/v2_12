
// Description: Java 11 Default Factory implementation for License.

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
	 *	CFIntLicenseFactory implementation for License
	 */
public class CFIntLicenseDefaultFactory
	implements ICFIntLicenseFactory
{
	public CFIntLicenseDefaultFactory() {
	}

	public CFIntLicensePKey newPKey() {
		CFIntLicensePKey pkey =
			new CFIntLicensePKey();
		return( pkey );
	}

	public CFIntLicenseHPKey newHPKey() {
		CFIntLicenseHPKey hpkey =
			new CFIntLicenseHPKey();
		return( hpkey );
	}

	public CFIntLicenseByLicnTenantIdxKey newLicnTenantIdxKey() {
		CFIntLicenseByLicnTenantIdxKey key =
			new CFIntLicenseByLicnTenantIdxKey();
		return( key );
	}

	public CFIntLicenseByDomainIdxKey newDomainIdxKey() {
		CFIntLicenseByDomainIdxKey key =
			new CFIntLicenseByDomainIdxKey();
		return( key );
	}

	public CFIntLicenseByUNameIdxKey newUNameIdxKey() {
		CFIntLicenseByUNameIdxKey key =
			new CFIntLicenseByUNameIdxKey();
		return( key );
	}

	public CFIntLicenseBuff newBuff() {
		CFIntLicenseBuff buff =
			new CFIntLicenseBuff();
		return( buff );
	}

	public CFIntLicenseHBuff newHBuff() {
		CFIntLicenseHBuff hbuff =
			new CFIntLicenseHBuff();
		return( hbuff );
	}
}
