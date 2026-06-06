// Description: Java 11 implementation of a GelCache by AltIdx index key object.

/*
 *	org.msscf.msscf.CFCore
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

public class CFGenKbGelCacheByAltIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredTenantId;
	protected String requiredCacheName;
	public CFGenKbGelCacheByAltIdxKey() {
		requiredTenantId = CFGenKbGelCacheBuff.TENANTID_INIT_VALUE;
		requiredCacheName = new String( CFGenKbGelCacheBuff.CACHENAME_INIT_VALUE );
	}

	public long getRequiredTenantId() {
		return( requiredTenantId );
	}

	public void setRequiredTenantId( long value ) {
		if( value < CFGenKbGelCacheBuff.TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTenantId",
				1,
				"value",
				value,
				CFGenKbGelCacheBuff.TENANTID_MIN_VALUE );
		}
		requiredTenantId = value;
	}

	public String getRequiredCacheName() {
		return( requiredCacheName );
	}

	public void setRequiredCacheName( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredCacheName",
				1,
				"value" );
		}
		if( value.length() > 511 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredCacheName",
				1,
				"value.length()",
				value.length(),
				511 );
		}
		requiredCacheName = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGelCacheByAltIdxKey ) {
			CFGenKbGelCacheByAltIdxKey rhs = (CFGenKbGelCacheByAltIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( ! getRequiredCacheName().equals( rhs.getRequiredCacheName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGelCacheBuff ) {
			CFGenKbGelCacheBuff rhs = (CFGenKbGelCacheBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( ! getRequiredCacheName().equals( rhs.getRequiredCacheName() ) ) {
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
		if( getRequiredCacheName() != null ) {
			hashCode = hashCode + getRequiredCacheName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbGelCacheByAltIdxKey ) {
			CFGenKbGelCacheByAltIdxKey rhs = (CFGenKbGelCacheByAltIdxKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredCacheName().compareTo( rhs.getRequiredCacheName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGelCacheBuff ) {
			CFGenKbGelCacheBuff rhs = (CFGenKbGelCacheBuff)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredCacheName().compareTo( rhs.getRequiredCacheName() );
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
		String ret = "<CFGenKbGelCacheByAltIdx"
			+ " RequiredTenantId=" + "\"" + Long.toString( getRequiredTenantId() ) + "\""
			+ " RequiredCacheName=" + "\"" + CFGenKbSchema.xmlEncodeString( getRequiredCacheName() ) + "\""
			+ "/>";
		return( ret );
	}
}
