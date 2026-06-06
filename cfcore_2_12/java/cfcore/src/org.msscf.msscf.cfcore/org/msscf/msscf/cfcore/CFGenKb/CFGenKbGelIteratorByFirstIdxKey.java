// Description: Java 11 implementation of a GelIterator by FirstIdx index key object.

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

public class CFGenKbGelIteratorByFirstIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected String optionalExpandFirst;
	public CFGenKbGelIteratorByFirstIdxKey() {
		optionalExpandFirst = null;
	}

	public String getOptionalExpandFirst() {
		return( optionalExpandFirst );
	}

	public void setOptionalExpandFirst( String value ) {
		if( value == null ) {
			optionalExpandFirst = null;
		}
		else if( value.length() > 127 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalExpandFirst",
				1,
				"value.length()",
				value.length(),
				127 );
		}
		else {
			optionalExpandFirst = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGelIteratorByFirstIdxKey ) {
			CFGenKbGelIteratorByFirstIdxKey rhs = (CFGenKbGelIteratorByFirstIdxKey)obj;
			if( getOptionalExpandFirst() != null ) {
				if( rhs.getOptionalExpandFirst() != null ) {
					if( ! getOptionalExpandFirst().equals( rhs.getOptionalExpandFirst() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpandFirst() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGelIteratorBuff ) {
			CFGenKbGelIteratorBuff rhs = (CFGenKbGelIteratorBuff)obj;
			if( getOptionalExpandFirst() != null ) {
				if( rhs.getOptionalExpandFirst() != null ) {
					if( ! getOptionalExpandFirst().equals( rhs.getOptionalExpandFirst() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpandFirst() != null ) {
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
		if( getOptionalExpandFirst() != null ) {
			hashCode = hashCode + getOptionalExpandFirst().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbGelIteratorByFirstIdxKey ) {
			CFGenKbGelIteratorByFirstIdxKey rhs = (CFGenKbGelIteratorByFirstIdxKey)obj;
			if( getOptionalExpandFirst() != null ) {
				if( rhs.getOptionalExpandFirst() != null ) {
					int cmp = getOptionalExpandFirst().compareTo( rhs.getOptionalExpandFirst() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpandFirst() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGelIteratorBuff ) {
			CFGenKbGelIteratorBuff rhs = (CFGenKbGelIteratorBuff)obj;
			if( getOptionalExpandFirst() != null ) {
				if( rhs.getOptionalExpandFirst() != null ) {
					int cmp = getOptionalExpandFirst().compareTo( rhs.getOptionalExpandFirst() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpandFirst() != null ) {
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
		String ret = "<CFGenKbGelIteratorByFirstIdx"
			+ " OptionalExpandFirst=" + ( ( getOptionalExpandFirst() == null ) ? "null" : "\"" + CFGenKbSchema.xmlEncodeString( getOptionalExpandFirst() ) + "\"" )
			+ "/>";
		return( ret );
	}
}
