// Description: Java 11 implementation of a ClearSubDep1 by ClearTopDepIdx index key object.

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

public class CFBamClearSubDep1ByClearTopDepIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredClearTopDepTenantId;
	protected long requiredClearTopDepId;
	public CFBamClearSubDep1ByClearTopDepIdxKey() {
		requiredClearTopDepTenantId = CFBamClearSubDep1Buff.CLEARTOPDEPTENANTID_INIT_VALUE;
		requiredClearTopDepId = CFBamClearSubDep1Buff.CLEARTOPDEPID_INIT_VALUE;
	}

	public long getRequiredClearTopDepTenantId() {
		return( requiredClearTopDepTenantId );
	}

	public void setRequiredClearTopDepTenantId( long value ) {
		if( value < CFBamClearSubDep1Buff.CLEARTOPDEPTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredClearTopDepTenantId",
				1,
				"value",
				value,
				CFBamClearSubDep1Buff.CLEARTOPDEPTENANTID_MIN_VALUE );
		}
		requiredClearTopDepTenantId = value;
	}

	public long getRequiredClearTopDepId() {
		return( requiredClearTopDepId );
	}

	public void setRequiredClearTopDepId( long value ) {
		if( value < CFBamClearSubDep1Buff.CLEARTOPDEPID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredClearTopDepId",
				1,
				"value",
				value,
				CFBamClearSubDep1Buff.CLEARTOPDEPID_MIN_VALUE );
		}
		requiredClearTopDepId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamClearSubDep1ByClearTopDepIdxKey ) {
			CFBamClearSubDep1ByClearTopDepIdxKey rhs = (CFBamClearSubDep1ByClearTopDepIdxKey)obj;
			if( getRequiredClearTopDepTenantId() != rhs.getRequiredClearTopDepTenantId() ) {
				return( false );
			}
			if( getRequiredClearTopDepId() != rhs.getRequiredClearTopDepId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamClearSubDep1Buff ) {
			CFBamClearSubDep1Buff rhs = (CFBamClearSubDep1Buff)obj;
			if( getRequiredClearTopDepTenantId() != rhs.getRequiredClearTopDepTenantId() ) {
				return( false );
			}
			if( getRequiredClearTopDepId() != rhs.getRequiredClearTopDepId() ) {
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
		hashCode = hashCode + (int)( getRequiredClearTopDepTenantId() );
		hashCode = hashCode + (int)( getRequiredClearTopDepId() );
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamClearSubDep1ByClearTopDepIdxKey ) {
			CFBamClearSubDep1ByClearTopDepIdxKey rhs = (CFBamClearSubDep1ByClearTopDepIdxKey)obj;
			if( getRequiredClearTopDepTenantId() < rhs.getRequiredClearTopDepTenantId() ) {
				return( -1 );
			}
			else if( getRequiredClearTopDepTenantId() > rhs.getRequiredClearTopDepTenantId() ) {
				return( 1 );
			}
			if( getRequiredClearTopDepId() < rhs.getRequiredClearTopDepId() ) {
				return( -1 );
			}
			else if( getRequiredClearTopDepId() > rhs.getRequiredClearTopDepId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamClearSubDep1Buff ) {
			CFBamClearSubDep1Buff rhs = (CFBamClearSubDep1Buff)obj;
			if( getRequiredClearTopDepTenantId() < rhs.getRequiredClearTopDepTenantId() ) {
				return( -1 );
			}
			else if( getRequiredClearTopDepTenantId() > rhs.getRequiredClearTopDepTenantId() ) {
				return( 1 );
			}
			if( getRequiredClearTopDepId() < rhs.getRequiredClearTopDepId() ) {
				return( -1 );
			}
			else if( getRequiredClearTopDepId() > rhs.getRequiredClearTopDepId() ) {
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
		String ret = "<CFBamClearSubDep1ByClearTopDepIdx"
			+ " RequiredClearTopDepTenantId=" + "\"" + Long.toString( getRequiredClearTopDepTenantId() ) + "\""
			+ " RequiredClearTopDepId=" + "\"" + Long.toString( getRequiredClearTopDepId() ) + "\""
			+ "/>";
		return( ret );
	}
}
