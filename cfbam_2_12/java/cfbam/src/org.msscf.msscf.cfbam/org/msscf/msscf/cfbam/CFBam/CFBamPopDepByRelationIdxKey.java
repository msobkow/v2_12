// Description: Java 11 implementation of a PopDep by RelationIdx index key object.

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

public class CFBamPopDepByRelationIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredRelationTenantId;
	protected long requiredRelationId;
	public CFBamPopDepByRelationIdxKey() {
		requiredRelationTenantId = CFBamPopDepBuff.RELATIONTENANTID_INIT_VALUE;
		requiredRelationId = CFBamPopDepBuff.RELATIONID_INIT_VALUE;
	}

	public long getRequiredRelationTenantId() {
		return( requiredRelationTenantId );
	}

	public void setRequiredRelationTenantId( long value ) {
		if( value < CFBamPopDepBuff.RELATIONTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredRelationTenantId",
				1,
				"value",
				value,
				CFBamPopDepBuff.RELATIONTENANTID_MIN_VALUE );
		}
		requiredRelationTenantId = value;
	}

	public long getRequiredRelationId() {
		return( requiredRelationId );
	}

	public void setRequiredRelationId( long value ) {
		if( value < CFBamPopDepBuff.RELATIONID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredRelationId",
				1,
				"value",
				value,
				CFBamPopDepBuff.RELATIONID_MIN_VALUE );
		}
		requiredRelationId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamPopDepByRelationIdxKey ) {
			CFBamPopDepByRelationIdxKey rhs = (CFBamPopDepByRelationIdxKey)obj;
			if( getRequiredRelationTenantId() != rhs.getRequiredRelationTenantId() ) {
				return( false );
			}
			if( getRequiredRelationId() != rhs.getRequiredRelationId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamPopDepBuff ) {
			CFBamPopDepBuff rhs = (CFBamPopDepBuff)obj;
			if( getRequiredRelationTenantId() != rhs.getRequiredRelationTenantId() ) {
				return( false );
			}
			if( getRequiredRelationId() != rhs.getRequiredRelationId() ) {
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
		hashCode = hashCode + (int)( getRequiredRelationTenantId() );
		hashCode = hashCode + (int)( getRequiredRelationId() );
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamPopDepByRelationIdxKey ) {
			CFBamPopDepByRelationIdxKey rhs = (CFBamPopDepByRelationIdxKey)obj;
			if( getRequiredRelationTenantId() < rhs.getRequiredRelationTenantId() ) {
				return( -1 );
			}
			else if( getRequiredRelationTenantId() > rhs.getRequiredRelationTenantId() ) {
				return( 1 );
			}
			if( getRequiredRelationId() < rhs.getRequiredRelationId() ) {
				return( -1 );
			}
			else if( getRequiredRelationId() > rhs.getRequiredRelationId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamPopDepBuff ) {
			CFBamPopDepBuff rhs = (CFBamPopDepBuff)obj;
			if( getRequiredRelationTenantId() < rhs.getRequiredRelationTenantId() ) {
				return( -1 );
			}
			else if( getRequiredRelationTenantId() > rhs.getRequiredRelationTenantId() ) {
				return( 1 );
			}
			if( getRequiredRelationId() < rhs.getRequiredRelationId() ) {
				return( -1 );
			}
			else if( getRequiredRelationId() > rhs.getRequiredRelationId() ) {
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
		String ret = "<CFBamPopDepByRelationIdx"
			+ " RequiredRelationTenantId=" + "\"" + Long.toString( getRequiredRelationTenantId() ) + "\""
			+ " RequiredRelationId=" + "\"" + Long.toString( getRequiredRelationId() ) + "\""
			+ "/>";
		return( ret );
	}
}
