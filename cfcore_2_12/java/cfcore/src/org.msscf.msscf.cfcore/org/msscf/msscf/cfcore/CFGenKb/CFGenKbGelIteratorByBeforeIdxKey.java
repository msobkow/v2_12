// Description: Java 11 implementation of a GelIterator by BeforeIdx index key object.

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

public class CFGenKbGelIteratorByBeforeIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected String optionalExpandBefore;
	public CFGenKbGelIteratorByBeforeIdxKey() {
		optionalExpandBefore = null;
	}

	public String getOptionalExpandBefore() {
		return( optionalExpandBefore );
	}

	public void setOptionalExpandBefore( String value ) {
		if( value == null ) {
			optionalExpandBefore = null;
		}
		else if( value.length() > 127 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalExpandBefore",
				1,
				"value.length()",
				value.length(),
				127 );
		}
		else {
			optionalExpandBefore = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGelIteratorByBeforeIdxKey ) {
			CFGenKbGelIteratorByBeforeIdxKey rhs = (CFGenKbGelIteratorByBeforeIdxKey)obj;
			if( getOptionalExpandBefore() != null ) {
				if( rhs.getOptionalExpandBefore() != null ) {
					if( ! getOptionalExpandBefore().equals( rhs.getOptionalExpandBefore() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpandBefore() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGelIteratorBuff ) {
			CFGenKbGelIteratorBuff rhs = (CFGenKbGelIteratorBuff)obj;
			if( getOptionalExpandBefore() != null ) {
				if( rhs.getOptionalExpandBefore() != null ) {
					if( ! getOptionalExpandBefore().equals( rhs.getOptionalExpandBefore() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpandBefore() != null ) {
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
		if( getOptionalExpandBefore() != null ) {
			hashCode = hashCode + getOptionalExpandBefore().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbGelIteratorByBeforeIdxKey ) {
			CFGenKbGelIteratorByBeforeIdxKey rhs = (CFGenKbGelIteratorByBeforeIdxKey)obj;
			if( getOptionalExpandBefore() != null ) {
				if( rhs.getOptionalExpandBefore() != null ) {
					int cmp = getOptionalExpandBefore().compareTo( rhs.getOptionalExpandBefore() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpandBefore() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGelIteratorBuff ) {
			CFGenKbGelIteratorBuff rhs = (CFGenKbGelIteratorBuff)obj;
			if( getOptionalExpandBefore() != null ) {
				if( rhs.getOptionalExpandBefore() != null ) {
					int cmp = getOptionalExpandBefore().compareTo( rhs.getOptionalExpandBefore() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpandBefore() != null ) {
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
		String ret = "<CFGenKbGelIteratorByBeforeIdx"
			+ " OptionalExpandBefore=" + ( ( getOptionalExpandBefore() == null ) ? "null" : "\"" + CFGenKbSchema.xmlEncodeString( getOptionalExpandBefore() ) + "\"" )
			+ "/>";
		return( ret );
	}
}
