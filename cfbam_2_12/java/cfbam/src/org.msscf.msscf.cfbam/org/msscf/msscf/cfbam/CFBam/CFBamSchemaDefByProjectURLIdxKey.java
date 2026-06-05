// Description: Java 11 implementation of a SchemaDef by ProjectURLIdx index key object.

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

public class CFBamSchemaDefByProjectURLIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredTenantId;
	protected String requiredProjectURL;
	public CFBamSchemaDefByProjectURLIdxKey() {
		requiredTenantId = CFBamSchemaDefBuff.TENANTID_INIT_VALUE;
		requiredProjectURL = new String( CFBamSchemaDefBuff.PROJECTURL_INIT_VALUE );
	}

	public long getRequiredTenantId() {
		return( requiredTenantId );
	}

	public void setRequiredTenantId( long value ) {
		if( value < CFBamSchemaDefBuff.TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTenantId",
				1,
				"value",
				value,
				CFBamSchemaDefBuff.TENANTID_MIN_VALUE );
		}
		requiredTenantId = value;
	}

	public String getRequiredProjectURL() {
		return( requiredProjectURL );
	}

	public void setRequiredProjectURL( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredProjectURL",
				1,
				"value" );
		}
		if( value.length() > 1024 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredProjectURL",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		requiredProjectURL = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamSchemaDefByProjectURLIdxKey ) {
			CFBamSchemaDefByProjectURLIdxKey rhs = (CFBamSchemaDefByProjectURLIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( ! getRequiredProjectURL().equals( rhs.getRequiredProjectURL() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaDefBuff ) {
			CFBamSchemaDefBuff rhs = (CFBamSchemaDefBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( ! getRequiredProjectURL().equals( rhs.getRequiredProjectURL() ) ) {
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
		if( getRequiredProjectURL() != null ) {
			hashCode = hashCode + getRequiredProjectURL().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamSchemaDefByProjectURLIdxKey ) {
			CFBamSchemaDefByProjectURLIdxKey rhs = (CFBamSchemaDefByProjectURLIdxKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredProjectURL().compareTo( rhs.getRequiredProjectURL() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSchemaDefBuff ) {
			CFBamSchemaDefBuff rhs = (CFBamSchemaDefBuff)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredProjectURL().compareTo( rhs.getRequiredProjectURL() );
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
		String ret = "<CFBamSchemaDefByProjectURLIdx"
			+ " RequiredTenantId=" + "\"" + Long.toString( getRequiredTenantId() ) + "\""
			+ " RequiredProjectURL=" + "\"" + CFBamSchema.xmlEncodeString( getRequiredProjectURL() ) + "\""
			+ "/>";
		return( ret );
	}
}
