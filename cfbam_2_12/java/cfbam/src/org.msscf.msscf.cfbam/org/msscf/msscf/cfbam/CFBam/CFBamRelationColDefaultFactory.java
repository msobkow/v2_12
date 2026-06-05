
// Description: Java 11 Default Factory implementation for RelationCol.

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
	 *	CFBamRelationColFactory implementation for RelationCol
	 */
public class CFBamRelationColDefaultFactory
	implements ICFBamRelationColFactory
{
	public CFBamRelationColDefaultFactory() {
	}

	public CFBamRelationColPKey newPKey() {
		CFBamRelationColPKey pkey =
			new CFBamRelationColPKey();
		return( pkey );
	}

	public CFBamRelationColHPKey newHPKey() {
		CFBamRelationColHPKey hpkey =
			new CFBamRelationColHPKey();
		return( hpkey );
	}

	public CFBamRelationColByUNameIdxKey newUNameIdxKey() {
		CFBamRelationColByUNameIdxKey key =
			new CFBamRelationColByUNameIdxKey();
		return( key );
	}

	public CFBamRelationColByRelColTenantIdxKey newRelColTenantIdxKey() {
		CFBamRelationColByRelColTenantIdxKey key =
			new CFBamRelationColByRelColTenantIdxKey();
		return( key );
	}

	public CFBamRelationColByRelationIdxKey newRelationIdxKey() {
		CFBamRelationColByRelationIdxKey key =
			new CFBamRelationColByRelationIdxKey();
		return( key );
	}

	public CFBamRelationColByDefSchemaIdxKey newDefSchemaIdxKey() {
		CFBamRelationColByDefSchemaIdxKey key =
			new CFBamRelationColByDefSchemaIdxKey();
		return( key );
	}

	public CFBamRelationColByFromColIdxKey newFromColIdxKey() {
		CFBamRelationColByFromColIdxKey key =
			new CFBamRelationColByFromColIdxKey();
		return( key );
	}

	public CFBamRelationColByToColIdxKey newToColIdxKey() {
		CFBamRelationColByToColIdxKey key =
			new CFBamRelationColByToColIdxKey();
		return( key );
	}

	public CFBamRelationColByPrevIdxKey newPrevIdxKey() {
		CFBamRelationColByPrevIdxKey key =
			new CFBamRelationColByPrevIdxKey();
		return( key );
	}

	public CFBamRelationColByNextIdxKey newNextIdxKey() {
		CFBamRelationColByNextIdxKey key =
			new CFBamRelationColByNextIdxKey();
		return( key );
	}

	public CFBamRelationColByRelPrevIdxKey newRelPrevIdxKey() {
		CFBamRelationColByRelPrevIdxKey key =
			new CFBamRelationColByRelPrevIdxKey();
		return( key );
	}

	public CFBamRelationColByRelNextIdxKey newRelNextIdxKey() {
		CFBamRelationColByRelNextIdxKey key =
			new CFBamRelationColByRelNextIdxKey();
		return( key );
	}

	public CFBamRelationColBuff newBuff() {
		CFBamRelationColBuff buff =
			new CFBamRelationColBuff();
		return( buff );
	}

	public CFBamRelationColHBuff newHBuff() {
		CFBamRelationColHBuff hbuff =
			new CFBamRelationColHBuff();
		return( hbuff );
	}
}
