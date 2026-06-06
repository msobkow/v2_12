// Description: Java 11 implementation of a MajorVersion by SubProjectIdx index key object.

/*
 *	org.msscf.msscf.CFInt
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

public class CFIntMajorVersionBySubProjectIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredTenantId;
	protected long requiredSubProjectId;
	public CFIntMajorVersionBySubProjectIdxKey() {
		requiredTenantId = CFIntMajorVersionBuff.TENANTID_INIT_VALUE;
		requiredSubProjectId = CFIntMajorVersionBuff.SUBPROJECTID_INIT_VALUE;
	}

	public long getRequiredTenantId() {
		return( requiredTenantId );
	}

	public void setRequiredTenantId( long value ) {
		if( value < CFIntMajorVersionBuff.TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTenantId",
				1,
				"value",
				value,
				CFIntMajorVersionBuff.TENANTID_MIN_VALUE );
		}
		requiredTenantId = value;
	}

	public long getRequiredSubProjectId() {
		return( requiredSubProjectId );
	}

	public void setRequiredSubProjectId( long value ) {
		if( value < CFIntMajorVersionBuff.SUBPROJECTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredSubProjectId",
				1,
				"value",
				value,
				CFIntMajorVersionBuff.SUBPROJECTID_MIN_VALUE );
		}
		requiredSubProjectId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFIntMajorVersionBySubProjectIdxKey ) {
			CFIntMajorVersionBySubProjectIdxKey rhs = (CFIntMajorVersionBySubProjectIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredSubProjectId() != rhs.getRequiredSubProjectId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFIntMajorVersionBuff ) {
			CFIntMajorVersionBuff rhs = (CFIntMajorVersionBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredSubProjectId() != rhs.getRequiredSubProjectId() ) {
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
		hashCode = hashCode + (int)( getRequiredSubProjectId() );
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFIntMajorVersionBySubProjectIdxKey ) {
			CFIntMajorVersionBySubProjectIdxKey rhs = (CFIntMajorVersionBySubProjectIdxKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredSubProjectId() < rhs.getRequiredSubProjectId() ) {
				return( -1 );
			}
			else if( getRequiredSubProjectId() > rhs.getRequiredSubProjectId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFIntMajorVersionBuff ) {
			CFIntMajorVersionBuff rhs = (CFIntMajorVersionBuff)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredSubProjectId() < rhs.getRequiredSubProjectId() ) {
				return( -1 );
			}
			else if( getRequiredSubProjectId() > rhs.getRequiredSubProjectId() ) {
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
		String ret = "<CFIntMajorVersionBySubProjectIdx"
			+ " RequiredTenantId=" + "\"" + Long.toString( getRequiredTenantId() ) + "\""
			+ " RequiredSubProjectId=" + "\"" + Long.toString( getRequiredSubProjectId() ) + "\""
			+ "/>";
		return( ret );
	}
}
