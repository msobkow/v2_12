// Description: Java 11 implementation of a SchemaDef by PubURIIdx index key object.

/*
 *	org.msscf.msscf.CFBam
 *
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *
 *	These files are part of MSS Code Factory Version 2.12.
 *
 *	MSS Code Factory is available under the terms of the GNU General Public License,
 *	Version 3 or later.
 *
 *	MSS Code Factory is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
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

public class CFBamSchemaDefByPubURIIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredTenantId;
	protected String requiredPublishURI;
	public CFBamSchemaDefByPubURIIdxKey() {
		requiredTenantId = CFBamSchemaDefBuff.TENANTID_INIT_VALUE;
		requiredPublishURI = new String( CFBamSchemaDefBuff.PUBLISHURI_INIT_VALUE );
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

	public String getRequiredPublishURI() {
		return( requiredPublishURI );
	}

	public void setRequiredPublishURI( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredPublishURI",
				1,
				"value" );
		}
		if( value.length() > 512 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredPublishURI",
				1,
				"value.length()",
				value.length(),
				512 );
		}
		requiredPublishURI = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamSchemaDefByPubURIIdxKey ) {
			CFBamSchemaDefByPubURIIdxKey rhs = (CFBamSchemaDefByPubURIIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( ! getRequiredPublishURI().equals( rhs.getRequiredPublishURI() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaDefBuff ) {
			CFBamSchemaDefBuff rhs = (CFBamSchemaDefBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( ! getRequiredPublishURI().equals( rhs.getRequiredPublishURI() ) ) {
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
		if( getRequiredPublishURI() != null ) {
			hashCode = hashCode + getRequiredPublishURI().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamSchemaDefByPubURIIdxKey ) {
			CFBamSchemaDefByPubURIIdxKey rhs = (CFBamSchemaDefByPubURIIdxKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredPublishURI().compareTo( rhs.getRequiredPublishURI() );
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
				int cmp = getRequiredPublishURI().compareTo( rhs.getRequiredPublishURI() );
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
		String ret = "<CFBamSchemaDefByPubURIIdx"
			+ " RequiredTenantId=" + "\"" + Long.toString( getRequiredTenantId() ) + "\""
			+ " RequiredPublishURI=" + "\"" + CFBamSchema.xmlEncodeString( getRequiredPublishURI() ) + "\""
			+ "/>";
		return( ret );
	}
}
