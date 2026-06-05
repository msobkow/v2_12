// Description: Java 11 implementation of a DelSubDep1 by DelTopDepIdx index key object.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamDelSubDep1ByDelTopDepIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredDelTopDepTenantId;
	protected long requiredDelTopDepId;
	public CFBamDelSubDep1ByDelTopDepIdxKey() {
		requiredDelTopDepTenantId = CFBamDelSubDep1Buff.DELTOPDEPTENANTID_INIT_VALUE;
		requiredDelTopDepId = CFBamDelSubDep1Buff.DELTOPDEPID_INIT_VALUE;
	}

	public long getRequiredDelTopDepTenantId() {
		return( requiredDelTopDepTenantId );
	}

	public void setRequiredDelTopDepTenantId( long value ) {
		if( value < CFBamDelSubDep1Buff.DELTOPDEPTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredDelTopDepTenantId",
				1,
				"value",
				value,
				CFBamDelSubDep1Buff.DELTOPDEPTENANTID_MIN_VALUE );
		}
		requiredDelTopDepTenantId = value;
	}

	public long getRequiredDelTopDepId() {
		return( requiredDelTopDepId );
	}

	public void setRequiredDelTopDepId( long value ) {
		if( value < CFBamDelSubDep1Buff.DELTOPDEPID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredDelTopDepId",
				1,
				"value",
				value,
				CFBamDelSubDep1Buff.DELTOPDEPID_MIN_VALUE );
		}
		requiredDelTopDepId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamDelSubDep1ByDelTopDepIdxKey ) {
			CFBamDelSubDep1ByDelTopDepIdxKey rhs = (CFBamDelSubDep1ByDelTopDepIdxKey)obj;
			if( getRequiredDelTopDepTenantId() != rhs.getRequiredDelTopDepTenantId() ) {
				return( false );
			}
			if( getRequiredDelTopDepId() != rhs.getRequiredDelTopDepId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamDelSubDep1Buff ) {
			CFBamDelSubDep1Buff rhs = (CFBamDelSubDep1Buff)obj;
			if( getRequiredDelTopDepTenantId() != rhs.getRequiredDelTopDepTenantId() ) {
				return( false );
			}
			if( getRequiredDelTopDepId() != rhs.getRequiredDelTopDepId() ) {
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
		hashCode = hashCode + (int)( getRequiredDelTopDepTenantId() );
		hashCode = hashCode + (int)( getRequiredDelTopDepId() );
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamDelSubDep1ByDelTopDepIdxKey ) {
			CFBamDelSubDep1ByDelTopDepIdxKey rhs = (CFBamDelSubDep1ByDelTopDepIdxKey)obj;
			if( getRequiredDelTopDepTenantId() < rhs.getRequiredDelTopDepTenantId() ) {
				return( -1 );
			}
			else if( getRequiredDelTopDepTenantId() > rhs.getRequiredDelTopDepTenantId() ) {
				return( 1 );
			}
			if( getRequiredDelTopDepId() < rhs.getRequiredDelTopDepId() ) {
				return( -1 );
			}
			else if( getRequiredDelTopDepId() > rhs.getRequiredDelTopDepId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamDelSubDep1Buff ) {
			CFBamDelSubDep1Buff rhs = (CFBamDelSubDep1Buff)obj;
			if( getRequiredDelTopDepTenantId() < rhs.getRequiredDelTopDepTenantId() ) {
				return( -1 );
			}
			else if( getRequiredDelTopDepTenantId() > rhs.getRequiredDelTopDepTenantId() ) {
				return( 1 );
			}
			if( getRequiredDelTopDepId() < rhs.getRequiredDelTopDepId() ) {
				return( -1 );
			}
			else if( getRequiredDelTopDepId() > rhs.getRequiredDelTopDepId() ) {
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
		String ret = "<CFBamDelSubDep1ByDelTopDepIdx"
			+ " RequiredDelTopDepTenantId=" + "\"" + Long.toString( getRequiredDelTopDepTenantId() ) + "\""
			+ " RequiredDelTopDepId=" + "\"" + Long.toString( getRequiredDelTopDepId() ) + "\""
			+ "/>";
		return( ret );
	}
}
