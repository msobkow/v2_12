// Description: Java 11 implementation of a SecApp by UJEEMountIdx index key object.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKb;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;

public class CFGenKbSecAppByUJEEMountIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredClusterId;
	protected String requiredJEEMountName;
	public CFGenKbSecAppByUJEEMountIdxKey() {
		requiredClusterId = CFGenKbSecAppBuff.CLUSTERID_INIT_VALUE;
		requiredJEEMountName = new String( CFGenKbSecAppBuff.JEEMOUNTNAME_INIT_VALUE );
	}

	public long getRequiredClusterId() {
		return( requiredClusterId );
	}

	public void setRequiredClusterId( long value ) {
		if( value < CFGenKbSecAppBuff.CLUSTERID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredClusterId",
				1,
				"value",
				value,
				CFGenKbSecAppBuff.CLUSTERID_MIN_VALUE );
		}
		requiredClusterId = value;
	}

	public String getRequiredJEEMountName() {
		return( requiredJEEMountName );
	}

	public void setRequiredJEEMountName( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredJEEMountName",
				1,
				"value" );
		}
		if( value.length() > 192 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredJEEMountName",
				1,
				"value.length()",
				value.length(),
				192 );
		}
		requiredJEEMountName = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbSecAppByUJEEMountIdxKey ) {
			CFGenKbSecAppByUJEEMountIdxKey rhs = (CFGenKbSecAppByUJEEMountIdxKey)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( ! getRequiredJEEMountName().equals( rhs.getRequiredJEEMountName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbSecAppBuff ) {
			CFGenKbSecAppBuff rhs = (CFGenKbSecAppBuff)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( ! getRequiredJEEMountName().equals( rhs.getRequiredJEEMountName() ) ) {
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
		hashCode = hashCode + (int)( getRequiredClusterId() );
		if( getRequiredJEEMountName() != null ) {
			hashCode = hashCode + getRequiredJEEMountName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbSecAppByUJEEMountIdxKey ) {
			CFGenKbSecAppByUJEEMountIdxKey rhs = (CFGenKbSecAppByUJEEMountIdxKey)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredJEEMountName().compareTo( rhs.getRequiredJEEMountName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbSecAppBuff ) {
			CFGenKbSecAppBuff rhs = (CFGenKbSecAppBuff)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredJEEMountName().compareTo( rhs.getRequiredJEEMountName() );
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
		String ret = "<CFGenKbSecAppByUJEEMountIdx"
			+ " RequiredClusterId=" + "\"" + Long.toString( getRequiredClusterId() ) + "\""
			+ " RequiredJEEMountName=" + "\"" + CFGenKbSchema.xmlEncodeString( getRequiredJEEMountName() ) + "\""
			+ "/>";
		return( ret );
	}
}
