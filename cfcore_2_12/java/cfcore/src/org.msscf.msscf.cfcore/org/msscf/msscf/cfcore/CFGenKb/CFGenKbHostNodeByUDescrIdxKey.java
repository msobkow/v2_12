// Description: Java 11 implementation of a HostNode by UDescrIdx index key object.

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

public class CFGenKbHostNodeByUDescrIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredClusterId;
	protected String requiredDescription;
	public CFGenKbHostNodeByUDescrIdxKey() {
		requiredClusterId = CFGenKbHostNodeBuff.CLUSTERID_INIT_VALUE;
		requiredDescription = new String( CFGenKbHostNodeBuff.DESCRIPTION_INIT_VALUE );
	}

	public long getRequiredClusterId() {
		return( requiredClusterId );
	}

	public void setRequiredClusterId( long value ) {
		if( value < CFGenKbHostNodeBuff.CLUSTERID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredClusterId",
				1,
				"value",
				value,
				CFGenKbHostNodeBuff.CLUSTERID_MIN_VALUE );
		}
		requiredClusterId = value;
	}

	public String getRequiredDescription() {
		return( requiredDescription );
	}

	public void setRequiredDescription( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredDescription",
				1,
				"value" );
		}
		if( value.length() > 255 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredDescription",
				1,
				"value.length()",
				value.length(),
				255 );
		}
		requiredDescription = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbHostNodeByUDescrIdxKey ) {
			CFGenKbHostNodeByUDescrIdxKey rhs = (CFGenKbHostNodeByUDescrIdxKey)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( ! getRequiredDescription().equals( rhs.getRequiredDescription() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbHostNodeBuff ) {
			CFGenKbHostNodeBuff rhs = (CFGenKbHostNodeBuff)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( ! getRequiredDescription().equals( rhs.getRequiredDescription() ) ) {
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
		if( getRequiredDescription() != null ) {
			hashCode = hashCode + getRequiredDescription().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbHostNodeByUDescrIdxKey ) {
			CFGenKbHostNodeByUDescrIdxKey rhs = (CFGenKbHostNodeByUDescrIdxKey)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredDescription().compareTo( rhs.getRequiredDescription() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbHostNodeBuff ) {
			CFGenKbHostNodeBuff rhs = (CFGenKbHostNodeBuff)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredDescription().compareTo( rhs.getRequiredDescription() );
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
		String ret = "<CFGenKbHostNodeByUDescrIdx"
			+ " RequiredClusterId=" + "\"" + Long.toString( getRequiredClusterId() ) + "\""
			+ " RequiredDescription=" + "\"" + CFGenKbSchema.xmlEncodeString( getRequiredDescription() ) + "\""
			+ "/>";
		return( ret );
	}
}
