// Description: Java 11 implementation of a PopSubDep2 by UNameIdx index key object.

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

public class CFBamPopSubDep2ByUNameIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredPopSubDep1TenantId;
	protected long requiredPopSubDep1Id;
	protected String requiredName;
	public CFBamPopSubDep2ByUNameIdxKey() {
		requiredPopSubDep1TenantId = CFBamPopSubDep2Buff.POPSUBDEP1TENANTID_INIT_VALUE;
		requiredPopSubDep1Id = CFBamPopSubDep2Buff.POPSUBDEP1ID_INIT_VALUE;
		requiredName = new String( CFBamPopSubDep2Buff.NAME_INIT_VALUE );
	}

	public long getRequiredPopSubDep1TenantId() {
		return( requiredPopSubDep1TenantId );
	}

	public void setRequiredPopSubDep1TenantId( long value ) {
		if( value < CFBamPopSubDep2Buff.POPSUBDEP1TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredPopSubDep1TenantId",
				1,
				"value",
				value,
				CFBamPopSubDep2Buff.POPSUBDEP1TENANTID_MIN_VALUE );
		}
		requiredPopSubDep1TenantId = value;
	}

	public long getRequiredPopSubDep1Id() {
		return( requiredPopSubDep1Id );
	}

	public void setRequiredPopSubDep1Id( long value ) {
		if( value < CFBamPopSubDep2Buff.POPSUBDEP1ID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredPopSubDep1Id",
				1,
				"value",
				value,
				CFBamPopSubDep2Buff.POPSUBDEP1ID_MIN_VALUE );
		}
		requiredPopSubDep1Id = value;
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
		else if( obj instanceof CFBamPopSubDep2ByUNameIdxKey ) {
			CFBamPopSubDep2ByUNameIdxKey rhs = (CFBamPopSubDep2ByUNameIdxKey)obj;
			if( getRequiredPopSubDep1TenantId() != rhs.getRequiredPopSubDep1TenantId() ) {
				return( false );
			}
			if( getRequiredPopSubDep1Id() != rhs.getRequiredPopSubDep1Id() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamPopSubDep2Buff ) {
			CFBamPopSubDep2Buff rhs = (CFBamPopSubDep2Buff)obj;
			if( getRequiredPopSubDep1TenantId() != rhs.getRequiredPopSubDep1TenantId() ) {
				return( false );
			}
			if( getRequiredPopSubDep1Id() != rhs.getRequiredPopSubDep1Id() ) {
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
		hashCode = hashCode + (int)( getRequiredPopSubDep1TenantId() );
		hashCode = hashCode + (int)( getRequiredPopSubDep1Id() );
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamPopSubDep2ByUNameIdxKey ) {
			CFBamPopSubDep2ByUNameIdxKey rhs = (CFBamPopSubDep2ByUNameIdxKey)obj;
			if( getRequiredPopSubDep1TenantId() < rhs.getRequiredPopSubDep1TenantId() ) {
				return( -1 );
			}
			else if( getRequiredPopSubDep1TenantId() > rhs.getRequiredPopSubDep1TenantId() ) {
				return( 1 );
			}
			if( getRequiredPopSubDep1Id() < rhs.getRequiredPopSubDep1Id() ) {
				return( -1 );
			}
			else if( getRequiredPopSubDep1Id() > rhs.getRequiredPopSubDep1Id() ) {
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
		else if( obj instanceof CFBamPopSubDep2Buff ) {
			CFBamPopSubDep2Buff rhs = (CFBamPopSubDep2Buff)obj;
			if( getRequiredPopSubDep1TenantId() < rhs.getRequiredPopSubDep1TenantId() ) {
				return( -1 );
			}
			else if( getRequiredPopSubDep1TenantId() > rhs.getRequiredPopSubDep1TenantId() ) {
				return( 1 );
			}
			if( getRequiredPopSubDep1Id() < rhs.getRequiredPopSubDep1Id() ) {
				return( -1 );
			}
			else if( getRequiredPopSubDep1Id() > rhs.getRequiredPopSubDep1Id() ) {
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
		String ret = "<CFBamPopSubDep2ByUNameIdx"
			+ " RequiredPopSubDep1TenantId=" + "\"" + Long.toString( getRequiredPopSubDep1TenantId() ) + "\""
			+ " RequiredPopSubDep1Id=" + "\"" + Long.toString( getRequiredPopSubDep1Id() ) + "\""
			+ " RequiredName=" + "\"" + CFBamSchema.xmlEncodeString( getRequiredName() ) + "\""
			+ "/>";
		return( ret );
	}
}
