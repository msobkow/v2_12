// Description: Java 11 implementation of a SecGrpInc primary key object.

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
import org.apache.commons.codec.binary.Base64;

/*
 *	CFGenKbSecGrpIncPKey Primary Key for SecGrpInc

 *		requiredClusterId	Required object attribute ClusterId.
 *		requiredSecGrpIncId	Required object attribute SecGrpIncId. */
public class CFGenKbSecGrpIncPKey
	implements Comparable<Object>,
		Serializable
{

	protected long requiredClusterId;
	protected long requiredSecGrpIncId;
	public CFGenKbSecGrpIncPKey() {
		requiredClusterId = CFGenKbSecGrpIncBuff.CLUSTERID_INIT_VALUE;
		requiredSecGrpIncId = CFGenKbSecGrpIncBuff.SECGRPINCID_INIT_VALUE;
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

	public long getRequiredSecGrpIncId() {
		return( requiredSecGrpIncId );
	}

	public void setRequiredSecGrpIncId( long value ) {
		if( value < CFGenKbSecGrpIncBuff.SECGRPINCID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredSecGrpIncId",
				1,
				"value",
				value,
				CFGenKbSecGrpIncBuff.SECGRPINCID_MIN_VALUE );
		}
		requiredSecGrpIncId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbSecGrpIncPKey ) {
			CFGenKbSecGrpIncPKey rhs = (CFGenKbSecGrpIncPKey)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecGrpIncId() != rhs.getRequiredSecGrpIncId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbSecGrpIncBuff ) {
			CFGenKbSecGrpIncBuff rhs = (CFGenKbSecGrpIncBuff)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecGrpIncId() != rhs.getRequiredSecGrpIncId() ) {
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
		hashCode = hashCode + (int)( getRequiredSecGrpIncId() );
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFGenKbSecGrpIncPKey ) {
			CFGenKbSecGrpIncPKey rhs = (CFGenKbSecGrpIncPKey)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecGrpIncId() < rhs.getRequiredSecGrpIncId() ) {
				return( -1 );
			}
			else if( getRequiredSecGrpIncId() > rhs.getRequiredSecGrpIncId() ) {
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
			if( getRequiredSecGrpIncId() < rhs.getRequiredSecGrpIncId() ) {
				return( -1 );
			}
			else if( getRequiredSecGrpIncId() > rhs.getRequiredSecGrpIncId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				"CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff" );
		}
	}

	public String toString() {
		String ret = "<CFGenKbSecGrpIncPKey"
			+ " RequiredClusterId=" + "\"" + Long.toString( getRequiredClusterId() ) + "\""
			+ " RequiredSecGrpIncId=" + "\"" + Long.toString( getRequiredSecGrpIncId() ) + "\""
			+ "/>";
		return( ret );
	}
}
