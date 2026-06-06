// Description: Java 11 implementation of a SecGroupForm by GroupIdx index key object.

/*
 *	org.msscf.msscf.CFCore
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
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

public class CFGenKbSecGroupFormByGroupIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredClusterId;
	protected int requiredSecGroupId;
	public CFGenKbSecGroupFormByGroupIdxKey() {
		requiredClusterId = CFGenKbSecGroupFormBuff.CLUSTERID_INIT_VALUE;
		requiredSecGroupId = CFGenKbSecGroupFormBuff.SECGROUPID_INIT_VALUE;
	}

	public long getRequiredClusterId() {
		return( requiredClusterId );
	}

	public void setRequiredClusterId( long value ) {
		if( value < CFGenKbSecGroupFormBuff.CLUSTERID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredClusterId",
				1,
				"value",
				value,
				CFGenKbSecGroupFormBuff.CLUSTERID_MIN_VALUE );
		}
		requiredClusterId = value;
	}

	public int getRequiredSecGroupId() {
		return( requiredSecGroupId );
	}

	public void setRequiredSecGroupId( int value ) {
		if( value < CFGenKbSecGroupFormBuff.SECGROUPID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredSecGroupId",
				1,
				"value",
				value,
				CFGenKbSecGroupFormBuff.SECGROUPID_MIN_VALUE );
		}
		requiredSecGroupId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbSecGroupFormByGroupIdxKey ) {
			CFGenKbSecGroupFormByGroupIdxKey rhs = (CFGenKbSecGroupFormByGroupIdxKey)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecGroupId() != rhs.getRequiredSecGroupId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbSecGroupFormBuff ) {
			CFGenKbSecGroupFormBuff rhs = (CFGenKbSecGroupFormBuff)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecGroupId() != rhs.getRequiredSecGroupId() ) {
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
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbSecGroupFormByGroupIdxKey ) {
			CFGenKbSecGroupFormByGroupIdxKey rhs = (CFGenKbSecGroupFormByGroupIdxKey)obj;
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
			return( 0 );
		}
		else if( obj instanceof CFGenKbSecGroupFormBuff ) {
			CFGenKbSecGroupFormBuff rhs = (CFGenKbSecGroupFormBuff)obj;
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
		String ret = "<CFGenKbSecGroupFormByGroupIdx"
			+ " RequiredClusterId=" + "\"" + Long.toString( getRequiredClusterId() ) + "\""
			+ " RequiredSecGroupId=" + "\"" + Integer.toString( getRequiredSecGroupId() ) + "\""
			+ "/>";
		return( ret );
	}
}
