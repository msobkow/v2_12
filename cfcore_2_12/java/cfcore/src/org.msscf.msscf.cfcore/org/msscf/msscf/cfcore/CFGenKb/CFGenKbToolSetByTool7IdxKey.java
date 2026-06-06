// Description: Java 11 implementation of a ToolSet by Tool7Idx index key object.

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

public class CFGenKbToolSetByTool7IdxKey
	implements Comparable<Object>,
		Serializable
{
	protected Short optionalToolId7;
	public CFGenKbToolSetByTool7IdxKey() {
		optionalToolId7 = null;
	}

	public Short getOptionalToolId7() {
		return( optionalToolId7 );
	}

	public void setOptionalToolId7( Short value ) {
		if( value == null ) {
			optionalToolId7 = null;
		}
		else if( value < CFGenKbToolSetBuff.TOOLID7_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalToolId7",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID7_MIN_VALUE );
		}
		else if( value > CFGenKbToolSetBuff.TOOLID7_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalToolId7",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID7_MAX_VALUE );
		}
		else {
			optionalToolId7 = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbToolSetByTool7IdxKey ) {
			CFGenKbToolSetByTool7IdxKey rhs = (CFGenKbToolSetByTool7IdxKey)obj;
			if( getOptionalToolId7() != null ) {
				if( rhs.getOptionalToolId7() != null ) {
					if( ! getOptionalToolId7().equals( rhs.getOptionalToolId7() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalToolId7() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbToolSetBuff ) {
			CFGenKbToolSetBuff rhs = (CFGenKbToolSetBuff)obj;
			if( getOptionalToolId7() != null ) {
				if( rhs.getOptionalToolId7() != null ) {
					if( ! getOptionalToolId7().equals( rhs.getOptionalToolId7() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalToolId7() != null ) {
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
		if( getOptionalToolId7() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalToolId7();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbToolSetByTool7IdxKey ) {
			CFGenKbToolSetByTool7IdxKey rhs = (CFGenKbToolSetByTool7IdxKey)obj;
			if( getOptionalToolId7() != null ) {
				Short lhsToolId7 = getOptionalToolId7();
				if( rhs.getOptionalToolId7() != null ) {
					Short rhsToolId7 = rhs.getOptionalToolId7();
					int cmp = lhsToolId7.compareTo( rhsToolId7 );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalToolId7() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbToolSetBuff ) {
			CFGenKbToolSetBuff rhs = (CFGenKbToolSetBuff)obj;
			if( getOptionalToolId7() != null ) {
				Short lhsToolId7 = getOptionalToolId7();
				if( rhs.getOptionalToolId7() != null ) {
					Short rhsToolId7 = rhs.getOptionalToolId7();
					int cmp = lhsToolId7.compareTo( rhsToolId7 );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalToolId7() != null ) {
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
		String ret = "<CFGenKbToolSetByTool7Idx"
			+ " OptionalToolId7=" + ( ( getOptionalToolId7() == null ) ? "null" : "\"" + getOptionalToolId7().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
