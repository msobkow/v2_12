// Description: Java 11 implementation of a TSecGrpMemb by UUserIdx index key object.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKb;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;

public class CFGenKbTSecGrpMembByUUserIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredTenantId;
	protected int requiredTSecGroupId;
	protected UUID requiredSecUserId;
	public CFGenKbTSecGrpMembByUUserIdxKey() {
		requiredTenantId = CFGenKbTSecGrpMembBuff.TENANTID_INIT_VALUE;
		requiredTSecGroupId = CFGenKbTSecGrpMembBuff.TSECGROUPID_INIT_VALUE;
		requiredSecUserId = UUID.fromString( CFGenKbTSecGrpMembBuff.SECUSERID_INIT_VALUE.toString() );
	}

	public long getRequiredTenantId() {
		return( requiredTenantId );
	}

	public void setRequiredTenantId( long value ) {
		if( value < CFGenKbTSecGrpMembBuff.TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTenantId",
				1,
				"value",
				value,
				CFGenKbTSecGrpMembBuff.TENANTID_MIN_VALUE );
		}
		requiredTenantId = value;
	}

	public int getRequiredTSecGroupId() {
		return( requiredTSecGroupId );
	}

	public void setRequiredTSecGroupId( int value ) {
		if( value < CFGenKbTSecGrpMembBuff.TSECGROUPID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTSecGroupId",
				1,
				"value",
				value,
				CFGenKbTSecGrpMembBuff.TSECGROUPID_MIN_VALUE );
		}
		requiredTSecGroupId = value;
	}

	public UUID getRequiredSecUserId() {
		return( requiredSecUserId );
	}

	public void setRequiredSecUserId( UUID value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredSecUserId",
				1,
				"value" );
		}
		requiredSecUserId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbTSecGrpMembByUUserIdxKey ) {
			CFGenKbTSecGrpMembByUUserIdxKey rhs = (CFGenKbTSecGrpMembByUUserIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTSecGroupId() != rhs.getRequiredTSecGroupId() ) {
				return( false );
			}
			if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbTSecGrpMembBuff ) {
			CFGenKbTSecGrpMembBuff rhs = (CFGenKbTSecGrpMembBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTSecGroupId() != rhs.getRequiredTSecGroupId() ) {
				return( false );
			}
			if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
				return( false );
			}
			return( true );
		}
		else {
			return( false );
		}
	}

	public int hashCode() {
		int hashCode = 0;
		hashCode = hashCode + (int)( getRequiredTenantId() );
		hashCode = hashCode + getRequiredTSecGroupId();
		hashCode = hashCode + getRequiredSecUserId().hashCode();
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbTSecGrpMembByUUserIdxKey ) {
			CFGenKbTSecGrpMembByUUserIdxKey rhs = (CFGenKbTSecGrpMembByUUserIdxKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredTSecGroupId() < rhs.getRequiredTSecGroupId() ) {
				return( -1 );
			}
			else if( getRequiredTSecGroupId() > rhs.getRequiredTSecGroupId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbTSecGrpMembBuff ) {
			CFGenKbTSecGrpMembBuff rhs = (CFGenKbTSecGrpMembBuff)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredTSecGroupId() < rhs.getRequiredTSecGroupId() ) {
				return( -1 );
			}
			else if( getRequiredTSecGroupId() > rhs.getRequiredTSecGroupId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			return( 0 );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	public String toString() {
		String ret = "<CFGenKbTSecGrpMembByUUserIdx"
			+ " RequiredTenantId=" + "\"" + Long.toString( getRequiredTenantId() ) + "\""
			+ " RequiredTSecGroupId=" + "\"" + Integer.toString( getRequiredTSecGroupId() ) + "\""
			+ " RequiredSecUserId=" + "\"" + getRequiredSecUserId().toString() + "\""
			+ "/>";
		return( ret );
	}
}
