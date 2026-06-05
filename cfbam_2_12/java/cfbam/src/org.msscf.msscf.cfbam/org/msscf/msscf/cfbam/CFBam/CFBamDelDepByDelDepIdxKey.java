// Description: Java 11 implementation of a DelDep by DelDepIdx index key object.

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

public class CFBamDelDepByDelDepIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredRelationTenantId;
	protected long requiredRelationId;
	public CFBamDelDepByDelDepIdxKey() {
		requiredRelationTenantId = CFBamDelDepBuff.RELATIONTENANTID_INIT_VALUE;
		requiredRelationId = CFBamDelDepBuff.RELATIONID_INIT_VALUE;
	}

	public long getRequiredRelationTenantId() {
		return( requiredRelationTenantId );
	}

	public void setRequiredRelationTenantId( long value ) {
		if( value < CFBamDelDepBuff.RELATIONTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredRelationTenantId",
				1,
				"value",
				value,
				CFBamDelDepBuff.RELATIONTENANTID_MIN_VALUE );
		}
		requiredRelationTenantId = value;
	}

	public long getRequiredRelationId() {
		return( requiredRelationId );
	}

	public void setRequiredRelationId( long value ) {
		if( value < CFBamDelDepBuff.RELATIONID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredRelationId",
				1,
				"value",
				value,
				CFBamDelDepBuff.RELATIONID_MIN_VALUE );
		}
		requiredRelationId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamDelDepByDelDepIdxKey ) {
			CFBamDelDepByDelDepIdxKey rhs = (CFBamDelDepByDelDepIdxKey)obj;
			if( getRequiredRelationTenantId() != rhs.getRequiredRelationTenantId() ) {
				return( false );
			}
			if( getRequiredRelationId() != rhs.getRequiredRelationId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamDelDepBuff ) {
			CFBamDelDepBuff rhs = (CFBamDelDepBuff)obj;
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
		else if( obj instanceof CFBamDelDepByDelDepIdxKey ) {
			CFBamDelDepByDelDepIdxKey rhs = (CFBamDelDepByDelDepIdxKey)obj;
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
		else if( obj instanceof CFBamDelDepBuff ) {
			CFBamDelDepBuff rhs = (CFBamDelDepBuff)obj;
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
		String ret = "<CFBamDelDepByDelDepIdx"
			+ " RequiredRelationTenantId=" + "\"" + Long.toString( getRequiredRelationTenantId() ) + "\""
			+ " RequiredRelationId=" + "\"" + Long.toString( getRequiredRelationId() ) + "\""
			+ "/>";
		return( ret );
	}
}
