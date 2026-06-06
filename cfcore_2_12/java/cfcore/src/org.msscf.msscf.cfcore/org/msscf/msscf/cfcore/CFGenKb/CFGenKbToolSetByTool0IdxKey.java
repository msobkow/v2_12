// Description: Java 11 implementation of a ToolSet by Tool0Idx index key object.

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

public class CFGenKbToolSetByTool0IdxKey
	implements Comparable<Object>,
		Serializable
{
	protected short requiredToolId0;
	public CFGenKbToolSetByTool0IdxKey() {
		requiredToolId0 = CFGenKbToolSetBuff.TOOLID0_INIT_VALUE;
	}

	public short getRequiredToolId0() {
		return( requiredToolId0 );
	}

	public void setRequiredToolId0( short value ) {
		if( value < CFGenKbToolSetBuff.TOOLID0_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredToolId0",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID0_MIN_VALUE );
		}
		if( value > CFGenKbToolSetBuff.TOOLID0_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredToolId0",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID0_MAX_VALUE );
		}
		requiredToolId0 = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbToolSetByTool0IdxKey ) {
			CFGenKbToolSetByTool0IdxKey rhs = (CFGenKbToolSetByTool0IdxKey)obj;
			if( getRequiredToolId0() != rhs.getRequiredToolId0() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbToolSetBuff ) {
			CFGenKbToolSetBuff rhs = (CFGenKbToolSetBuff)obj;
			if( getRequiredToolId0() != rhs.getRequiredToolId0() ) {
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
		hashCode = ( hashCode * 0x10000 ) + getRequiredToolId0();
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbToolSetByTool0IdxKey ) {
			CFGenKbToolSetByTool0IdxKey rhs = (CFGenKbToolSetByTool0IdxKey)obj;
			if( getRequiredToolId0() < rhs.getRequiredToolId0() ) {
				return( -1 );
			}
			else if( getRequiredToolId0() > rhs.getRequiredToolId0() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbToolSetBuff ) {
			CFGenKbToolSetBuff rhs = (CFGenKbToolSetBuff)obj;
			if( getRequiredToolId0() < rhs.getRequiredToolId0() ) {
				return( -1 );
			}
			else if( getRequiredToolId0() > rhs.getRequiredToolId0() ) {
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
		String ret = "<CFGenKbToolSetByTool0Idx"
			+ " RequiredToolId0=" + "\"" + Short.toString( getRequiredToolId0() ) + "\""
			+ "/>";
		return( ret );
	}
}
