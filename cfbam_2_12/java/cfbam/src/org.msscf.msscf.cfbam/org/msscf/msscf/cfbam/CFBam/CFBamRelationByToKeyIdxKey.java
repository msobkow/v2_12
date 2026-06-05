// Description: Java 11 implementation of a Relation by ToKeyIdx index key object.

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

public class CFBamRelationByToKeyIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredTenantId;
	protected long requiredToIndexId;
	public CFBamRelationByToKeyIdxKey() {
		requiredTenantId = CFBamRelationBuff.TENANTID_INIT_VALUE;
		requiredToIndexId = CFBamRelationBuff.TOINDEXID_INIT_VALUE;
	}

	public long getRequiredTenantId() {
		return( requiredTenantId );
	}

	public void setRequiredTenantId( long value ) {
		if( value < CFBamRelationBuff.TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTenantId",
				1,
				"value",
				value,
				CFBamRelationBuff.TENANTID_MIN_VALUE );
		}
		requiredTenantId = value;
	}

	public long getRequiredToIndexId() {
		return( requiredToIndexId );
	}

	public void setRequiredToIndexId( long value ) {
		if( value < CFBamRelationBuff.TOINDEXID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredToIndexId",
				1,
				"value",
				value,
				CFBamRelationBuff.TOINDEXID_MIN_VALUE );
		}
		requiredToIndexId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamRelationByToKeyIdxKey ) {
			CFBamRelationByToKeyIdxKey rhs = (CFBamRelationByToKeyIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredToIndexId() != rhs.getRequiredToIndexId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamRelationBuff ) {
			CFBamRelationBuff rhs = (CFBamRelationBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredToIndexId() != rhs.getRequiredToIndexId() ) {
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
		hashCode = hashCode + (int)( getRequiredToIndexId() );
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamRelationByToKeyIdxKey ) {
			CFBamRelationByToKeyIdxKey rhs = (CFBamRelationByToKeyIdxKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredToIndexId() < rhs.getRequiredToIndexId() ) {
				return( -1 );
			}
			else if( getRequiredToIndexId() > rhs.getRequiredToIndexId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamRelationBuff ) {
			CFBamRelationBuff rhs = (CFBamRelationBuff)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredToIndexId() < rhs.getRequiredToIndexId() ) {
				return( -1 );
			}
			else if( getRequiredToIndexId() > rhs.getRequiredToIndexId() ) {
				return( 1 );
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
		String ret = "<CFBamRelationByToKeyIdx"
			+ " RequiredTenantId=" + "\"" + Long.toString( getRequiredTenantId() ) + "\""
			+ " RequiredToIndexId=" + "\"" + Long.toString( getRequiredToIndexId() ) + "\""
			+ "/>";
		return( ret );
	}
}
