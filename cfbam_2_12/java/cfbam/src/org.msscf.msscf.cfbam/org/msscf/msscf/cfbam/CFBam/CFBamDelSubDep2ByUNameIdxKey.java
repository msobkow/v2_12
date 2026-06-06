// Description: Java 11 implementation of a DelSubDep2 by UNameIdx index key object.

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

public class CFBamDelSubDep2ByUNameIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredDelSubDep1TenantId;
	protected long requiredDelSubDep1Id;
	protected String requiredName;
	public CFBamDelSubDep2ByUNameIdxKey() {
		requiredDelSubDep1TenantId = CFBamDelSubDep2Buff.DELSUBDEP1TENANTID_INIT_VALUE;
		requiredDelSubDep1Id = CFBamDelSubDep2Buff.DELSUBDEP1ID_INIT_VALUE;
		requiredName = new String( CFBamDelSubDep2Buff.NAME_INIT_VALUE );
	}

	public long getRequiredDelSubDep1TenantId() {
		return( requiredDelSubDep1TenantId );
	}

	public void setRequiredDelSubDep1TenantId( long value ) {
		if( value < CFBamDelSubDep2Buff.DELSUBDEP1TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredDelSubDep1TenantId",
				1,
				"value",
				value,
				CFBamDelSubDep2Buff.DELSUBDEP1TENANTID_MIN_VALUE );
		}
		requiredDelSubDep1TenantId = value;
	}

	public long getRequiredDelSubDep1Id() {
		return( requiredDelSubDep1Id );
	}

	public void setRequiredDelSubDep1Id( long value ) {
		if( value < CFBamDelSubDep2Buff.DELSUBDEP1ID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredDelSubDep1Id",
				1,
				"value",
				value,
				CFBamDelSubDep2Buff.DELSUBDEP1ID_MIN_VALUE );
		}
		requiredDelSubDep1Id = value;
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
		else if( obj instanceof CFBamDelSubDep2ByUNameIdxKey ) {
			CFBamDelSubDep2ByUNameIdxKey rhs = (CFBamDelSubDep2ByUNameIdxKey)obj;
			if( getRequiredDelSubDep1TenantId() != rhs.getRequiredDelSubDep1TenantId() ) {
				return( false );
			}
			if( getRequiredDelSubDep1Id() != rhs.getRequiredDelSubDep1Id() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamDelSubDep2Buff ) {
			CFBamDelSubDep2Buff rhs = (CFBamDelSubDep2Buff)obj;
			if( getRequiredDelSubDep1TenantId() != rhs.getRequiredDelSubDep1TenantId() ) {
				return( false );
			}
			if( getRequiredDelSubDep1Id() != rhs.getRequiredDelSubDep1Id() ) {
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
		hashCode = hashCode + (int)( getRequiredDelSubDep1TenantId() );
		hashCode = hashCode + (int)( getRequiredDelSubDep1Id() );
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamDelSubDep2ByUNameIdxKey ) {
			CFBamDelSubDep2ByUNameIdxKey rhs = (CFBamDelSubDep2ByUNameIdxKey)obj;
			if( getRequiredDelSubDep1TenantId() < rhs.getRequiredDelSubDep1TenantId() ) {
				return( -1 );
			}
			else if( getRequiredDelSubDep1TenantId() > rhs.getRequiredDelSubDep1TenantId() ) {
				return( 1 );
			}
			if( getRequiredDelSubDep1Id() < rhs.getRequiredDelSubDep1Id() ) {
				return( -1 );
			}
			else if( getRequiredDelSubDep1Id() > rhs.getRequiredDelSubDep1Id() ) {
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
		else if( obj instanceof CFBamDelSubDep2Buff ) {
			CFBamDelSubDep2Buff rhs = (CFBamDelSubDep2Buff)obj;
			if( getRequiredDelSubDep1TenantId() < rhs.getRequiredDelSubDep1TenantId() ) {
				return( -1 );
			}
			else if( getRequiredDelSubDep1TenantId() > rhs.getRequiredDelSubDep1TenantId() ) {
				return( 1 );
			}
			if( getRequiredDelSubDep1Id() < rhs.getRequiredDelSubDep1Id() ) {
				return( -1 );
			}
			else if( getRequiredDelSubDep1Id() > rhs.getRequiredDelSubDep1Id() ) {
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
		String ret = "<CFBamDelSubDep2ByUNameIdx"
			+ " RequiredDelSubDep1TenantId=" + "\"" + Long.toString( getRequiredDelSubDep1TenantId() ) + "\""
			+ " RequiredDelSubDep1Id=" + "\"" + Long.toString( getRequiredDelSubDep1Id() ) + "\""
			+ " RequiredName=" + "\"" + CFBamSchema.xmlEncodeString( getRequiredName() ) + "\""
			+ "/>";
		return( ret );
	}
}
