// Description: Java 11 implementation of a PopSubDep1 by PopTopDepIdx index key object.

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

public class CFBamPopSubDep1ByPopTopDepIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredPopTopDepTenantId;
	protected long requiredPopTopDepId;
	public CFBamPopSubDep1ByPopTopDepIdxKey() {
		requiredPopTopDepTenantId = CFBamPopSubDep1Buff.POPTOPDEPTENANTID_INIT_VALUE;
		requiredPopTopDepId = CFBamPopSubDep1Buff.POPTOPDEPID_INIT_VALUE;
	}

	public long getRequiredPopTopDepTenantId() {
		return( requiredPopTopDepTenantId );
	}

	public void setRequiredPopTopDepTenantId( long value ) {
		if( value < CFBamPopSubDep1Buff.POPTOPDEPTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredPopTopDepTenantId",
				1,
				"value",
				value,
				CFBamPopSubDep1Buff.POPTOPDEPTENANTID_MIN_VALUE );
		}
		requiredPopTopDepTenantId = value;
	}

	public long getRequiredPopTopDepId() {
		return( requiredPopTopDepId );
	}

	public void setRequiredPopTopDepId( long value ) {
		if( value < CFBamPopSubDep1Buff.POPTOPDEPID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredPopTopDepId",
				1,
				"value",
				value,
				CFBamPopSubDep1Buff.POPTOPDEPID_MIN_VALUE );
		}
		requiredPopTopDepId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamPopSubDep1ByPopTopDepIdxKey ) {
			CFBamPopSubDep1ByPopTopDepIdxKey rhs = (CFBamPopSubDep1ByPopTopDepIdxKey)obj;
			if( getRequiredPopTopDepTenantId() != rhs.getRequiredPopTopDepTenantId() ) {
				return( false );
			}
			if( getRequiredPopTopDepId() != rhs.getRequiredPopTopDepId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamPopSubDep1Buff ) {
			CFBamPopSubDep1Buff rhs = (CFBamPopSubDep1Buff)obj;
			if( getRequiredPopTopDepTenantId() != rhs.getRequiredPopTopDepTenantId() ) {
				return( false );
			}
			if( getRequiredPopTopDepId() != rhs.getRequiredPopTopDepId() ) {
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
		hashCode = hashCode + (int)( getRequiredPopTopDepTenantId() );
		hashCode = hashCode + (int)( getRequiredPopTopDepId() );
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamPopSubDep1ByPopTopDepIdxKey ) {
			CFBamPopSubDep1ByPopTopDepIdxKey rhs = (CFBamPopSubDep1ByPopTopDepIdxKey)obj;
			if( getRequiredPopTopDepTenantId() < rhs.getRequiredPopTopDepTenantId() ) {
				return( -1 );
			}
			else if( getRequiredPopTopDepTenantId() > rhs.getRequiredPopTopDepTenantId() ) {
				return( 1 );
			}
			if( getRequiredPopTopDepId() < rhs.getRequiredPopTopDepId() ) {
				return( -1 );
			}
			else if( getRequiredPopTopDepId() > rhs.getRequiredPopTopDepId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamPopSubDep1Buff ) {
			CFBamPopSubDep1Buff rhs = (CFBamPopSubDep1Buff)obj;
			if( getRequiredPopTopDepTenantId() < rhs.getRequiredPopTopDepTenantId() ) {
				return( -1 );
			}
			else if( getRequiredPopTopDepTenantId() > rhs.getRequiredPopTopDepTenantId() ) {
				return( 1 );
			}
			if( getRequiredPopTopDepId() < rhs.getRequiredPopTopDepId() ) {
				return( -1 );
			}
			else if( getRequiredPopTopDepId() > rhs.getRequiredPopTopDepId() ) {
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
		String ret = "<CFBamPopSubDep1ByPopTopDepIdx"
			+ " RequiredPopTopDepTenantId=" + "\"" + Long.toString( getRequiredPopTopDepTenantId() ) + "\""
			+ " RequiredPopTopDepId=" + "\"" + Long.toString( getRequiredPopTopDepId() ) + "\""
			+ "/>";
		return( ret );
	}
}
