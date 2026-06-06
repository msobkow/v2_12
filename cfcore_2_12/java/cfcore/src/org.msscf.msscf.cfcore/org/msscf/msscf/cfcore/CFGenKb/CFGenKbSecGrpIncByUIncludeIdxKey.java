// Description: Java 11 implementation of a SecGrpInc by UIncludeIdx index key object.

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

public class CFGenKbSecGrpIncByUIncludeIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredClusterId;
	protected int requiredSecGroupId;
	protected int requiredIncludeGroupId;
	public CFGenKbSecGrpIncByUIncludeIdxKey() {
		requiredClusterId = CFGenKbSecGrpIncBuff.CLUSTERID_INIT_VALUE;
		requiredSecGroupId = CFGenKbSecGrpIncBuff.SECGROUPID_INIT_VALUE;
		requiredIncludeGroupId = CFGenKbSecGrpIncBuff.INCLUDEGROUPID_INIT_VALUE;
	}

	public long getRequiredClusterId() {
		return( requiredClusterId );
	}

	public void setRequiredClusterId( long value ) {
		if( value < CFGenKbSecGrpIncBuff.CLUSTERID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredClusterId",
				1,
				"value",
				value,
				CFGenKbSecGrpIncBuff.CLUSTERID_MIN_VALUE );
		}
		requiredClusterId = value;
	}

	public int getRequiredSecGroupId() {
		return( requiredSecGroupId );
	}

	public void setRequiredSecGroupId( int value ) {
		if( value < CFGenKbSecGrpIncBuff.SECGROUPID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredSecGroupId",
				1,
				"value",
				value,
				CFGenKbSecGrpIncBuff.SECGROUPID_MIN_VALUE );
		}
		requiredSecGroupId = value;
	}

	public int getRequiredIncludeGroupId() {
		return( requiredIncludeGroupId );
	}

	public void setRequiredIncludeGroupId( int value ) {
		if( value < CFGenKbSecGrpIncBuff.INCLUDEGROUPID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredIncludeGroupId",
				1,
				"value",
				value,
				CFGenKbSecGrpIncBuff.INCLUDEGROUPID_MIN_VALUE );
		}
		requiredIncludeGroupId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbSecGrpIncByUIncludeIdxKey ) {
			CFGenKbSecGrpIncByUIncludeIdxKey rhs = (CFGenKbSecGrpIncByUIncludeIdxKey)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecGroupId() != rhs.getRequiredSecGroupId() ) {
				return( false );
			}
			if( getRequiredIncludeGroupId() != rhs.getRequiredIncludeGroupId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbSecGrpIncBuff ) {
			CFGenKbSecGrpIncBuff rhs = (CFGenKbSecGrpIncBuff)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecGroupId() != rhs.getRequiredSecGroupId() ) {
				return( false );
			}
			if( getRequiredIncludeGroupId() != rhs.getRequiredIncludeGroupId() ) {
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
		hashCode = hashCode + getRequiredSecGroupId();
		hashCode = hashCode + getRequiredIncludeGroupId();
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbSecGrpIncByUIncludeIdxKey ) {
			CFGenKbSecGrpIncByUIncludeIdxKey rhs = (CFGenKbSecGrpIncByUIncludeIdxKey)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecGroupId() < rhs.getRequiredSecGroupId() ) {
				return( -1 );
			}
			else if( getRequiredSecGroupId() > rhs.getRequiredSecGroupId() ) {
				return( 1 );
			}
			if( getRequiredIncludeGroupId() < rhs.getRequiredIncludeGroupId() ) {
				return( -1 );
			}
			else if( getRequiredIncludeGroupId() > rhs.getRequiredIncludeGroupId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbSecGrpIncBuff ) {
			CFGenKbSecGrpIncBuff rhs = (CFGenKbSecGrpIncBuff)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecGroupId() < rhs.getRequiredSecGroupId() ) {
				return( -1 );
			}
			else if( getRequiredSecGroupId() > rhs.getRequiredSecGroupId() ) {
				return( 1 );
			}
			if( getRequiredIncludeGroupId() < rhs.getRequiredIncludeGroupId() ) {
				return( -1 );
			}
			else if( getRequiredIncludeGroupId() > rhs.getRequiredIncludeGroupId() ) {
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
		String ret = "<CFGenKbSecGrpIncByUIncludeIdx"
			+ " RequiredClusterId=" + "\"" + Long.toString( getRequiredClusterId() ) + "\""
			+ " RequiredSecGroupId=" + "\"" + Integer.toString( getRequiredSecGroupId() ) + "\""
			+ " RequiredIncludeGroupId=" + "\"" + Integer.toString( getRequiredIncludeGroupId() ) + "\""
			+ "/>";
		return( ret );
	}
}
