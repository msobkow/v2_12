// Description: Java 11 implementation of a ToolSet by Tool4Idx index key object.

/*
 *	org.msscf.msscf.CFCore
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
 *	
 *	MSS Code Factory is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with MSS Code Factory.  If not, see https://www.gnu.org/licenses/.
 *	
 *	Donations to support MSS Code Factory can be made at
 *	https://www.paypal.com/paypalme2/MarkSobkow
 *	
 *	Contact Mark Stephen Sobkow at msobkow@sasktel.net for commercial licensing.
 *
 *	Manufactured by MSS Code Factory 2.11
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

public class CFGenKbToolSetByTool4IdxKey
	implements Comparable<Object>,
		Serializable
{
	protected Short optionalToolId4;
	public CFGenKbToolSetByTool4IdxKey() {
		optionalToolId4 = null;
	}

	public Short getOptionalToolId4() {
		return( optionalToolId4 );
	}

	public void setOptionalToolId4( Short value ) {
		if( value == null ) {
			optionalToolId4 = null;
		}
		else if( value < CFGenKbToolSetBuff.TOOLID4_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalToolId4",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID4_MIN_VALUE );
		}
		else if( value > CFGenKbToolSetBuff.TOOLID4_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalToolId4",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID4_MAX_VALUE );
		}
		else {
			optionalToolId4 = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbToolSetByTool4IdxKey ) {
			CFGenKbToolSetByTool4IdxKey rhs = (CFGenKbToolSetByTool4IdxKey)obj;
			if( getOptionalToolId4() != null ) {
				if( rhs.getOptionalToolId4() != null ) {
					if( ! getOptionalToolId4().equals( rhs.getOptionalToolId4() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalToolId4() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbToolSetBuff ) {
			CFGenKbToolSetBuff rhs = (CFGenKbToolSetBuff)obj;
			if( getOptionalToolId4() != null ) {
				if( rhs.getOptionalToolId4() != null ) {
					if( ! getOptionalToolId4().equals( rhs.getOptionalToolId4() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalToolId4() != null ) {
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
		if( getOptionalToolId4() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalToolId4();
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
		else if( obj instanceof CFGenKbToolSetByTool4IdxKey ) {
			CFGenKbToolSetByTool4IdxKey rhs = (CFGenKbToolSetByTool4IdxKey)obj;
			if( getOptionalToolId4() != null ) {
				Short lhsToolId4 = getOptionalToolId4();
				if( rhs.getOptionalToolId4() != null ) {
					Short rhsToolId4 = rhs.getOptionalToolId4();
					int cmp = lhsToolId4.compareTo( rhsToolId4 );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalToolId4() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbToolSetBuff ) {
			CFGenKbToolSetBuff rhs = (CFGenKbToolSetBuff)obj;
			if( getOptionalToolId4() != null ) {
				Short lhsToolId4 = getOptionalToolId4();
				if( rhs.getOptionalToolId4() != null ) {
					Short rhsToolId4 = rhs.getOptionalToolId4();
					int cmp = lhsToolId4.compareTo( rhsToolId4 );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalToolId4() != null ) {
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
		String ret = "<CFGenKbToolSetByTool4Idx"
			+ " OptionalToolId4=" + ( ( getOptionalToolId4() == null ) ? "null" : "\"" + getOptionalToolId4().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
