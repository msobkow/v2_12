// Description: Java 11 implementation of a SecGroup by ClusterVisIdx index key object.

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

public class CFGenKbSecGroupByClusterVisIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredClusterId;
	protected boolean requiredIsVisible;
	public CFGenKbSecGroupByClusterVisIdxKey() {
		requiredClusterId = CFGenKbSecGroupBuff.CLUSTERID_INIT_VALUE;
		requiredIsVisible = CFGenKbSecGroupBuff.ISVISIBLE_INIT_VALUE;
	}

	public long getRequiredClusterId() {
		return( requiredClusterId );
	}

	public void setRequiredClusterId( long value ) {
		if( value < CFGenKbSecGroupBuff.CLUSTERID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredClusterId",
				1,
				"value",
				value,
				CFGenKbSecGroupBuff.CLUSTERID_MIN_VALUE );
		}
		requiredClusterId = value;
	}

	public boolean getRequiredIsVisible() {
		return( requiredIsVisible );
	}

	public void setRequiredIsVisible( boolean value ) {
		requiredIsVisible = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbSecGroupByClusterVisIdxKey ) {
			CFGenKbSecGroupByClusterVisIdxKey rhs = (CFGenKbSecGroupByClusterVisIdxKey)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredIsVisible() != rhs.getRequiredIsVisible() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbSecGroupBuff ) {
			CFGenKbSecGroupBuff rhs = (CFGenKbSecGroupBuff)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredIsVisible() != rhs.getRequiredIsVisible() ) {
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
		if( getRequiredIsVisible() ) {
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
		else if( obj instanceof CFGenKbSecGroupByClusterVisIdxKey ) {
			CFGenKbSecGroupByClusterVisIdxKey rhs = (CFGenKbSecGroupByClusterVisIdxKey)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredIsVisible() ) {
				if( ! rhs.getRequiredIsVisible() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsVisible() ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbSecGroupBuff ) {
			CFGenKbSecGroupBuff rhs = (CFGenKbSecGroupBuff)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredIsVisible() ) {
				if( ! rhs.getRequiredIsVisible() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsVisible() ) {
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
		String ret = "<CFGenKbSecGroupByClusterVisIdx"
			+ " RequiredClusterId=" + "\"" + Long.toString( getRequiredClusterId() ) + "\""
			+ " RequiredIsVisible=" + (( getRequiredIsVisible() ) ? "\"true\"" : "\"false\"" )
			+ "/>";
		return( ret );
	}
}
