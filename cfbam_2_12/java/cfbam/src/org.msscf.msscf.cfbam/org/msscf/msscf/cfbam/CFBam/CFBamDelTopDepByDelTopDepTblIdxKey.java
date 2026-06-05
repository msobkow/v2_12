// Description: Java 11 implementation of a DelTopDep by DelTopDepTblIdx index key object.

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

public class CFBamDelTopDepByDelTopDepTblIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredTableTenantId;
	protected long requiredTableId;
	public CFBamDelTopDepByDelTopDepTblIdxKey() {
		requiredTableTenantId = CFBamDelTopDepBuff.TABLETENANTID_INIT_VALUE;
		requiredTableId = CFBamDelTopDepBuff.TABLEID_INIT_VALUE;
	}

	public long getRequiredTableTenantId() {
		return( requiredTableTenantId );
	}

	public void setRequiredTableTenantId( long value ) {
		if( value < CFBamDelTopDepBuff.TABLETENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTableTenantId",
				1,
				"value",
				value,
				CFBamDelTopDepBuff.TABLETENANTID_MIN_VALUE );
		}
		requiredTableTenantId = value;
	}

	public long getRequiredTableId() {
		return( requiredTableId );
	}

	public void setRequiredTableId( long value ) {
		if( value < CFBamDelTopDepBuff.TABLEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTableId",
				1,
				"value",
				value,
				CFBamDelTopDepBuff.TABLEID_MIN_VALUE );
		}
		requiredTableId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamDelTopDepByDelTopDepTblIdxKey ) {
			CFBamDelTopDepByDelTopDepTblIdxKey rhs = (CFBamDelTopDepByDelTopDepTblIdxKey)obj;
			if( getRequiredTableTenantId() != rhs.getRequiredTableTenantId() ) {
				return( false );
			}
			if( getRequiredTableId() != rhs.getRequiredTableId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamDelTopDepBuff ) {
			CFBamDelTopDepBuff rhs = (CFBamDelTopDepBuff)obj;
			if( getRequiredTableTenantId() != rhs.getRequiredTableTenantId() ) {
				return( false );
			}
			if( getRequiredTableId() != rhs.getRequiredTableId() ) {
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
		hashCode = hashCode + (int)( getRequiredTableTenantId() );
		hashCode = hashCode + (int)( getRequiredTableId() );
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamDelTopDepByDelTopDepTblIdxKey ) {
			CFBamDelTopDepByDelTopDepTblIdxKey rhs = (CFBamDelTopDepByDelTopDepTblIdxKey)obj;
			if( getRequiredTableTenantId() < rhs.getRequiredTableTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTableTenantId() > rhs.getRequiredTableTenantId() ) {
				return( 1 );
			}
			if( getRequiredTableId() < rhs.getRequiredTableId() ) {
				return( -1 );
			}
			else if( getRequiredTableId() > rhs.getRequiredTableId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamDelTopDepBuff ) {
			CFBamDelTopDepBuff rhs = (CFBamDelTopDepBuff)obj;
			if( getRequiredTableTenantId() < rhs.getRequiredTableTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTableTenantId() > rhs.getRequiredTableTenantId() ) {
				return( 1 );
			}
			if( getRequiredTableId() < rhs.getRequiredTableId() ) {
				return( -1 );
			}
			else if( getRequiredTableId() > rhs.getRequiredTableId() ) {
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
		String ret = "<CFBamDelTopDepByDelTopDepTblIdx"
			+ " RequiredTableTenantId=" + "\"" + Long.toString( getRequiredTableTenantId() ) + "\""
			+ " RequiredTableId=" + "\"" + Long.toString( getRequiredTableId() ) + "\""
			+ "/>";
		return( ret );
	}
}
