// Description: Java 11 implementation of a TopDomain by TldIdx index key object.

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
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;

public class CFIntTopDomainByTldIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredTenantId;
	protected long requiredTldId;
	public CFIntTopDomainByTldIdxKey() {
		requiredTenantId = CFIntTopDomainBuff.TENANTID_INIT_VALUE;
		requiredTldId = CFIntTopDomainBuff.TLDID_INIT_VALUE;
	}

	public long getRequiredTenantId() {
		return( requiredTenantId );
	}

	public void setRequiredTenantId( long value ) {
		if( value < CFIntTopDomainBuff.TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTenantId",
				1,
				"value",
				value,
				CFIntTopDomainBuff.TENANTID_MIN_VALUE );
		}
		requiredTenantId = value;
	}

	public long getRequiredTldId() {
		return( requiredTldId );
	}

	public void setRequiredTldId( long value ) {
		if( value < CFIntTopDomainBuff.TLDID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTldId",
				1,
				"value",
				value,
				CFIntTopDomainBuff.TLDID_MIN_VALUE );
		}
		requiredTldId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFIntTopDomainByTldIdxKey ) {
			CFIntTopDomainByTldIdxKey rhs = (CFIntTopDomainByTldIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTldId() != rhs.getRequiredTldId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFIntTopDomainBuff ) {
			CFIntTopDomainBuff rhs = (CFIntTopDomainBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTldId() != rhs.getRequiredTldId() ) {
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
		hashCode = hashCode + (int)( getRequiredTldId() );
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFIntTopDomainByTldIdxKey ) {
			CFIntTopDomainByTldIdxKey rhs = (CFIntTopDomainByTldIdxKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredTldId() < rhs.getRequiredTldId() ) {
				return( -1 );
			}
			else if( getRequiredTldId() > rhs.getRequiredTldId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFIntTopDomainBuff ) {
			CFIntTopDomainBuff rhs = (CFIntTopDomainBuff)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredTldId() < rhs.getRequiredTldId() ) {
				return( -1 );
			}
			else if( getRequiredTldId() > rhs.getRequiredTldId() ) {
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
		String ret = "<CFIntTopDomainByTldIdx"
			+ " RequiredTenantId=" + "\"" + Long.toString( getRequiredTenantId() ) + "\""
			+ " RequiredTldId=" + "\"" + Long.toString( getRequiredTldId() ) + "\""
			+ "/>";
		return( ret );
	}
}
