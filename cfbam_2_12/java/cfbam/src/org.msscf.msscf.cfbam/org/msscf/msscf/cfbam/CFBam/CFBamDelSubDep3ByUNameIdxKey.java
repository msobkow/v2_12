// Description: Java 11 implementation of a DelSubDep3 by UNameIdx index key object.

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
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;

public class CFBamDelSubDep3ByUNameIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredDelSubDep2TenantId;
	protected long requiredDelSubDep2Id;
	protected String requiredName;
	public CFBamDelSubDep3ByUNameIdxKey() {
		requiredDelSubDep2TenantId = CFBamDelSubDep3Buff.DELSUBDEP2TENANTID_INIT_VALUE;
		requiredDelSubDep2Id = CFBamDelSubDep3Buff.DELSUBDEP2ID_INIT_VALUE;
		requiredName = new String( CFBamDelSubDep3Buff.NAME_INIT_VALUE );
	}

	public long getRequiredDelSubDep2TenantId() {
		return( requiredDelSubDep2TenantId );
	}

	public void setRequiredDelSubDep2TenantId( long value ) {
		if( value < CFBamDelSubDep3Buff.DELSUBDEP2TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredDelSubDep2TenantId",
				1,
				"value",
				value,
				CFBamDelSubDep3Buff.DELSUBDEP2TENANTID_MIN_VALUE );
		}
		requiredDelSubDep2TenantId = value;
	}

	public long getRequiredDelSubDep2Id() {
		return( requiredDelSubDep2Id );
	}

	public void setRequiredDelSubDep2Id( long value ) {
		if( value < CFBamDelSubDep3Buff.DELSUBDEP2ID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredDelSubDep2Id",
				1,
				"value",
				value,
				CFBamDelSubDep3Buff.DELSUBDEP2ID_MIN_VALUE );
		}
		requiredDelSubDep2Id = value;
	}

	public String getRequiredName() {
		return( requiredName );
	}

	public void setRequiredName( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredName",
				1,
				"value" );
		}
		if( value.length() > 192 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				192 );
		}
		requiredName = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamDelSubDep3ByUNameIdxKey ) {
			CFBamDelSubDep3ByUNameIdxKey rhs = (CFBamDelSubDep3ByUNameIdxKey)obj;
			if( getRequiredDelSubDep2TenantId() != rhs.getRequiredDelSubDep2TenantId() ) {
				return( false );
			}
			if( getRequiredDelSubDep2Id() != rhs.getRequiredDelSubDep2Id() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamDelSubDep3Buff ) {
			CFBamDelSubDep3Buff rhs = (CFBamDelSubDep3Buff)obj;
			if( getRequiredDelSubDep2TenantId() != rhs.getRequiredDelSubDep2TenantId() ) {
				return( false );
			}
			if( getRequiredDelSubDep2Id() != rhs.getRequiredDelSubDep2Id() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
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
		hashCode = hashCode + (int)( getRequiredDelSubDep2TenantId() );
		hashCode = hashCode + (int)( getRequiredDelSubDep2Id() );
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamDelSubDep3ByUNameIdxKey ) {
			CFBamDelSubDep3ByUNameIdxKey rhs = (CFBamDelSubDep3ByUNameIdxKey)obj;
			if( getRequiredDelSubDep2TenantId() < rhs.getRequiredDelSubDep2TenantId() ) {
				return( -1 );
			}
			else if( getRequiredDelSubDep2TenantId() > rhs.getRequiredDelSubDep2TenantId() ) {
				return( 1 );
			}
			if( getRequiredDelSubDep2Id() < rhs.getRequiredDelSubDep2Id() ) {
				return( -1 );
			}
			else if( getRequiredDelSubDep2Id() > rhs.getRequiredDelSubDep2Id() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamDelSubDep3Buff ) {
			CFBamDelSubDep3Buff rhs = (CFBamDelSubDep3Buff)obj;
			if( getRequiredDelSubDep2TenantId() < rhs.getRequiredDelSubDep2TenantId() ) {
				return( -1 );
			}
			else if( getRequiredDelSubDep2TenantId() > rhs.getRequiredDelSubDep2TenantId() ) {
				return( 1 );
			}
			if( getRequiredDelSubDep2Id() < rhs.getRequiredDelSubDep2Id() ) {
				return( -1 );
			}
			else if( getRequiredDelSubDep2Id() > rhs.getRequiredDelSubDep2Id() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
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
		String ret = "<CFBamDelSubDep3ByUNameIdx"
			+ " RequiredDelSubDep2TenantId=" + "\"" + Long.toString( getRequiredDelSubDep2TenantId() ) + "\""
			+ " RequiredDelSubDep2Id=" + "\"" + Long.toString( getRequiredDelSubDep2Id() ) + "\""
			+ " RequiredName=" + "\"" + CFBamSchema.xmlEncodeString( getRequiredName() ) + "\""
			+ "/>";
		return( ret );
	}
}
