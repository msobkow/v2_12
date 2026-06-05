// Description: Java 11 implementation of a GelCache buffer object.

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

public class CFGenKbGelCacheBuff
{
	public final static String CLASS_CODE = "GLCH";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long GELCACHEID_INIT_VALUE = 0L;
	public static final String CACHENAME_INIT_VALUE = new String( "" );
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long GELCACHEID_MIN_VALUE = 0L;
	protected long requiredTenantId;
	protected long requiredGelCacheId;
	protected String requiredCacheName;
	protected int requiredRevision;
	public CFGenKbGelCacheBuff() {
		requiredTenantId = CFGenKbGelCacheBuff.TENANTID_INIT_VALUE;
		requiredGelCacheId = CFGenKbGelCacheBuff.GELCACHEID_INIT_VALUE;
		requiredCacheName = new String( CFGenKbGelCacheBuff.CACHENAME_INIT_VALUE );
	}

	public String getClassCode() {
		return( CLASS_CODE );
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

	public long getRequiredGelCacheId() {
		return( requiredGelCacheId );
	}

	public void setRequiredGelCacheId( long value ) {
		if( value < CFGenKbGelCacheBuff.GELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredGelCacheId",
				1,
				"value",
				value,
				CFGenKbGelCacheBuff.GELCACHEID_MIN_VALUE );
		}
		requiredGelCacheId = value;
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

	public int getRequiredRevision() {
		return( requiredRevision );
	}

	public void setRequiredRevision( int value ) {
		requiredRevision = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGelCacheBuff ) {
			CFGenKbGelCacheBuff rhs = (CFGenKbGelCacheBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredGelCacheId() != rhs.getRequiredGelCacheId() ) {
				return( false );
			}
			if( ! getRequiredCacheName().equals( rhs.getRequiredCacheName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGelCachePKey ) {
			CFGenKbGelCachePKey rhs = (CFGenKbGelCachePKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredGelCacheId() != rhs.getRequiredGelCacheId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGelCacheByTenantIdxKey ) {
			CFGenKbGelCacheByTenantIdxKey rhs = (CFGenKbGelCacheByTenantIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			return( true );
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
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	public int hashCode() {
		int hashCode = 0;
		hashCode = hashCode + (int)( getRequiredTenantId() );
		hashCode = hashCode + (int)( getRequiredGelCacheId() );
		if( getRequiredCacheName() != null ) {
			hashCode = hashCode + getRequiredCacheName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFGenKbGelCacheBuff ) {
			CFGenKbGelCacheBuff rhs = (CFGenKbGelCacheBuff)obj;
			int retval = 0;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredGelCacheId() < rhs.getRequiredGelCacheId() ) {
				return( -1 );
			}
			else if( getRequiredGelCacheId() > rhs.getRequiredGelCacheId() ) {
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
		else if( obj instanceof CFGenKbGelCachePKey ) {
			CFGenKbGelCachePKey rhs = (CFGenKbGelCachePKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredGelCacheId() < rhs.getRequiredGelCacheId() ) {
				return( -1 );
			}
			else if( getRequiredGelCacheId() > rhs.getRequiredGelCacheId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGelCacheByTenantIdxKey ) {
			CFGenKbGelCacheByTenantIdxKey rhs = (CFGenKbGelCacheByTenantIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}			return( 0 );
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
			}			return( 0 );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	public void set( CFGenKbGelCacheBuff src ) {
		setGelCacheBuff( src );
	}

	public void setGelCacheBuff( CFGenKbGelCacheBuff src ) {
		setRequiredTenantId( src.getRequiredTenantId() );
		setRequiredGelCacheId( src.getRequiredGelCacheId() );
		setRequiredCacheName( src.getRequiredCacheName() );
		setRequiredRevision( src.getRequiredRevision() );
	}
}
