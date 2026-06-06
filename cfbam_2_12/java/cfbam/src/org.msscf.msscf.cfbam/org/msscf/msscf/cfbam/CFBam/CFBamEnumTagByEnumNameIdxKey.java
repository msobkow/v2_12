// Description: Java 11 implementation of a EnumTag by EnumNameIdx index key object.

/*
 *	org.msscf.msscf.CFBam
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
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

public class CFBamEnumTagByEnumNameIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredTenantId;
	protected long requiredEnumId;
	protected String requiredName;
	public CFBamEnumTagByEnumNameIdxKey() {
		requiredTenantId = CFBamEnumTagBuff.TENANTID_INIT_VALUE;
		requiredEnumId = CFBamEnumTagBuff.ENUMID_INIT_VALUE;
		requiredName = new String( CFBamEnumTagBuff.NAME_INIT_VALUE );
	}

	public long getRequiredTenantId() {
		return( requiredTenantId );
	}

	public void setRequiredTenantId( long value ) {
		if( value < CFBamEnumTagBuff.TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTenantId",
				1,
				"value",
				value,
				CFBamEnumTagBuff.TENANTID_MIN_VALUE );
		}
		requiredTenantId = value;
	}

	public long getRequiredEnumId() {
		return( requiredEnumId );
	}

	public void setRequiredEnumId( long value ) {
		if( value < CFBamEnumTagBuff.ENUMID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredEnumId",
				1,
				"value",
				value,
				CFBamEnumTagBuff.ENUMID_MIN_VALUE );
		}
		requiredEnumId = value;
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
		if( value.length() > 64 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		requiredName = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamEnumTagByEnumNameIdxKey ) {
			CFBamEnumTagByEnumNameIdxKey rhs = (CFBamEnumTagByEnumNameIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredEnumId() != rhs.getRequiredEnumId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamEnumTagBuff ) {
			CFBamEnumTagBuff rhs = (CFBamEnumTagBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredEnumId() != rhs.getRequiredEnumId() ) {
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
		hashCode = hashCode + (int)( getRequiredTenantId() );
		hashCode = hashCode + (int)( getRequiredEnumId() );
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamEnumTagByEnumNameIdxKey ) {
			CFBamEnumTagByEnumNameIdxKey rhs = (CFBamEnumTagByEnumNameIdxKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredEnumId() < rhs.getRequiredEnumId() ) {
				return( -1 );
			}
			else if( getRequiredEnumId() > rhs.getRequiredEnumId() ) {
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
		else if( obj instanceof CFBamEnumTagBuff ) {
			CFBamEnumTagBuff rhs = (CFBamEnumTagBuff)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredEnumId() < rhs.getRequiredEnumId() ) {
				return( -1 );
			}
			else if( getRequiredEnumId() > rhs.getRequiredEnumId() ) {
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
		String ret = "<CFBamEnumTagByEnumNameIdx"
			+ " RequiredTenantId=" + "\"" + Long.toString( getRequiredTenantId() ) + "\""
			+ " RequiredEnumId=" + "\"" + Long.toString( getRequiredEnumId() ) + "\""
			+ " RequiredName=" + "\"" + CFBamSchema.xmlEncodeString( getRequiredName() ) + "\""
			+ "/>";
		return( ret );
	}
}
