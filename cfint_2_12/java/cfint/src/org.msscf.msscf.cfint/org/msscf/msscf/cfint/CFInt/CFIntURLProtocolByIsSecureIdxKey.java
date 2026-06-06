// Description: Java 11 implementation of a URLProtocol by IsSecureIdx index key object.

/*
 *	org.msscf.msscf.CFInt
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

public class CFIntURLProtocolByIsSecureIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected boolean requiredIsSecure;
	public CFIntURLProtocolByIsSecureIdxKey() {
		requiredIsSecure = CFIntURLProtocolBuff.ISSECURE_INIT_VALUE;
	}

	public boolean getRequiredIsSecure() {
		return( requiredIsSecure );
	}

	public void setRequiredIsSecure( boolean value ) {
		requiredIsSecure = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFIntURLProtocolByIsSecureIdxKey ) {
			CFIntURLProtocolByIsSecureIdxKey rhs = (CFIntURLProtocolByIsSecureIdxKey)obj;
			if( getRequiredIsSecure() != rhs.getRequiredIsSecure() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFIntURLProtocolBuff ) {
			CFIntURLProtocolBuff rhs = (CFIntURLProtocolBuff)obj;
			if( getRequiredIsSecure() != rhs.getRequiredIsSecure() ) {
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
		if( getRequiredIsSecure() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFIntURLProtocolByIsSecureIdxKey ) {
			CFIntURLProtocolByIsSecureIdxKey rhs = (CFIntURLProtocolByIsSecureIdxKey)obj;
			if( getRequiredIsSecure() ) {
				if( ! rhs.getRequiredIsSecure() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsSecure() ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFIntURLProtocolBuff ) {
			CFIntURLProtocolBuff rhs = (CFIntURLProtocolBuff)obj;
			if( getRequiredIsSecure() ) {
				if( ! rhs.getRequiredIsSecure() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsSecure() ) {
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
		String ret = "<CFIntURLProtocolByIsSecureIdx"
			+ " RequiredIsSecure=" + (( getRequiredIsSecure() ) ? "\"true\"" : "\"false\"" )
			+ "/>";
		return( ret );
	}
}
