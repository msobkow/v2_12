// Description: Java 11 implementation of a SecSession by SecDevIdx index key object.

/*
 *	org.msscf.msscf.CFCore
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

public class CFGenKbSecSessionBySecDevIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected UUID requiredSecUserId;
	protected String optionalSecDevName;
	public CFGenKbSecSessionBySecDevIdxKey() {
		requiredSecUserId = UUID.fromString( CFGenKbSecSessionBuff.SECUSERID_INIT_VALUE.toString() );
		optionalSecDevName = null;
	}

	public UUID getRequiredSecUserId() {
		return( requiredSecUserId );
	}

	public void setRequiredSecUserId( UUID value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredSecUserId",
				1,
				"value" );
		}
		requiredSecUserId = value;
	}

	public String getOptionalSecDevName() {
		return( optionalSecDevName );
	}

	public void setOptionalSecDevName( String value ) {
		if( value == null ) {
			optionalSecDevName = null;
		}
		else if( value.length() > 127 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalSecDevName",
				1,
				"value.length()",
				value.length(),
				127 );
		}
		else {
			optionalSecDevName = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbSecSessionBySecDevIdxKey ) {
			CFGenKbSecSessionBySecDevIdxKey rhs = (CFGenKbSecSessionBySecDevIdxKey)obj;
			if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
				return( false );
			}
			if( getOptionalSecDevName() != null ) {
				if( rhs.getOptionalSecDevName() != null ) {
					if( ! getOptionalSecDevName().equals( rhs.getOptionalSecDevName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSecDevName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbSecSessionBuff ) {
			CFGenKbSecSessionBuff rhs = (CFGenKbSecSessionBuff)obj;
			if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
				return( false );
			}
			if( getOptionalSecDevName() != null ) {
				if( rhs.getOptionalSecDevName() != null ) {
					if( ! getOptionalSecDevName().equals( rhs.getOptionalSecDevName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSecDevName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			return( false );
		}
	}

	public int hashCode() {
		int hashCode = 0;
		hashCode = hashCode + getRequiredSecUserId().hashCode();
		if( getOptionalSecDevName() != null ) {
			hashCode = hashCode + getOptionalSecDevName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbSecSessionBySecDevIdxKey ) {
			CFGenKbSecSessionBySecDevIdxKey rhs = (CFGenKbSecSessionBySecDevIdxKey)obj;
			{
				int cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalSecDevName() != null ) {
				if( rhs.getOptionalSecDevName() != null ) {
					int cmp = getOptionalSecDevName().compareTo( rhs.getOptionalSecDevName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSecDevName() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbSecSessionBuff ) {
			CFGenKbSecSessionBuff rhs = (CFGenKbSecSessionBuff)obj;
			{
				int cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalSecDevName() != null ) {
				if( rhs.getOptionalSecDevName() != null ) {
					int cmp = getOptionalSecDevName().compareTo( rhs.getOptionalSecDevName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSecDevName() != null ) {
					return( -1 );
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
		String ret = "<CFGenKbSecSessionBySecDevIdx"
			+ " RequiredSecUserId=" + "\"" + getRequiredSecUserId().toString() + "\""
			+ " OptionalSecDevName=" + ( ( getOptionalSecDevName() == null ) ? "null" : "\"" + CFGenKbSchema.xmlEncodeString( getOptionalSecDevName() ) + "\"" )
			+ "/>";
		return( ret );
	}
}
