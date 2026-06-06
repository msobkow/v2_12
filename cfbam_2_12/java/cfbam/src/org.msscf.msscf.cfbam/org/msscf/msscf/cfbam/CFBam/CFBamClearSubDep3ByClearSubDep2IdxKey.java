// Description: Java 11 implementation of a ClearSubDep3 by ClearSubDep2Idx index key object.

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

public class CFBamClearSubDep3ByClearSubDep2IdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredClearSubDep2TenantId;
	protected long requiredClearSubDep2Id;
	public CFBamClearSubDep3ByClearSubDep2IdxKey() {
		requiredClearSubDep2TenantId = CFBamClearSubDep3Buff.CLEARSUBDEP2TENANTID_INIT_VALUE;
		requiredClearSubDep2Id = CFBamClearSubDep3Buff.CLEARSUBDEP2ID_INIT_VALUE;
	}

	public long getRequiredClearSubDep2TenantId() {
		return( requiredClearSubDep2TenantId );
	}

	public void setRequiredClearSubDep2TenantId( long value ) {
		if( value < CFBamClearSubDep3Buff.CLEARSUBDEP2TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredClearSubDep2TenantId",
				1,
				"value",
				value,
				CFBamClearSubDep3Buff.CLEARSUBDEP2TENANTID_MIN_VALUE );
		}
		requiredClearSubDep2TenantId = value;
	}

	public long getRequiredClearSubDep2Id() {
		return( requiredClearSubDep2Id );
	}

	public void setRequiredClearSubDep2Id( long value ) {
		if( value < CFBamClearSubDep3Buff.CLEARSUBDEP2ID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredClearSubDep2Id",
				1,
				"value",
				value,
				CFBamClearSubDep3Buff.CLEARSUBDEP2ID_MIN_VALUE );
		}
		requiredClearSubDep2Id = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamClearSubDep3ByClearSubDep2IdxKey ) {
			CFBamClearSubDep3ByClearSubDep2IdxKey rhs = (CFBamClearSubDep3ByClearSubDep2IdxKey)obj;
			if( getRequiredClearSubDep2TenantId() != rhs.getRequiredClearSubDep2TenantId() ) {
				return( false );
			}
			if( getRequiredClearSubDep2Id() != rhs.getRequiredClearSubDep2Id() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamClearSubDep3Buff ) {
			CFBamClearSubDep3Buff rhs = (CFBamClearSubDep3Buff)obj;
			if( getRequiredClearSubDep2TenantId() != rhs.getRequiredClearSubDep2TenantId() ) {
				return( false );
			}
			if( getRequiredClearSubDep2Id() != rhs.getRequiredClearSubDep2Id() ) {
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
		hashCode = hashCode + (int)( getRequiredClearSubDep2TenantId() );
		hashCode = hashCode + (int)( getRequiredClearSubDep2Id() );
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamClearSubDep3ByClearSubDep2IdxKey ) {
			CFBamClearSubDep3ByClearSubDep2IdxKey rhs = (CFBamClearSubDep3ByClearSubDep2IdxKey)obj;
			if( getRequiredClearSubDep2TenantId() < rhs.getRequiredClearSubDep2TenantId() ) {
				return( -1 );
			}
			else if( getRequiredClearSubDep2TenantId() > rhs.getRequiredClearSubDep2TenantId() ) {
				return( 1 );
			}
			if( getRequiredClearSubDep2Id() < rhs.getRequiredClearSubDep2Id() ) {
				return( -1 );
			}
			else if( getRequiredClearSubDep2Id() > rhs.getRequiredClearSubDep2Id() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamClearSubDep3Buff ) {
			CFBamClearSubDep3Buff rhs = (CFBamClearSubDep3Buff)obj;
			if( getRequiredClearSubDep2TenantId() < rhs.getRequiredClearSubDep2TenantId() ) {
				return( -1 );
			}
			else if( getRequiredClearSubDep2TenantId() > rhs.getRequiredClearSubDep2TenantId() ) {
				return( 1 );
			}
			if( getRequiredClearSubDep2Id() < rhs.getRequiredClearSubDep2Id() ) {
				return( -1 );
			}
			else if( getRequiredClearSubDep2Id() > rhs.getRequiredClearSubDep2Id() ) {
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
		String ret = "<CFBamClearSubDep3ByClearSubDep2Idx"
			+ " RequiredClearSubDep2TenantId=" + "\"" + Long.toString( getRequiredClearSubDep2TenantId() ) + "\""
			+ " RequiredClearSubDep2Id=" + "\"" + Long.toString( getRequiredClearSubDep2Id() ) + "\""
			+ "/>";
		return( ret );
	}
}
