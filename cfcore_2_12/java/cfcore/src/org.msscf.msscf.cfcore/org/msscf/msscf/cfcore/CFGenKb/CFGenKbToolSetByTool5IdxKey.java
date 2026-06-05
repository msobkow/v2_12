// Description: Java 11 implementation of a ToolSet by Tool5Idx index key object.

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

public class CFGenKbToolSetByTool5IdxKey
	implements Comparable<Object>,
		Serializable
{
	protected Short optionalToolId5;
	public CFGenKbToolSetByTool5IdxKey() {
		optionalToolId5 = null;
	}

	public Short getOptionalToolId5() {
		return( optionalToolId5 );
	}

	public void setOptionalToolId5( Short value ) {
		if( value == null ) {
			optionalToolId5 = null;
		}
		else if( value < CFGenKbToolSetBuff.TOOLID5_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalToolId5",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID5_MIN_VALUE );
		}
		else if( value > CFGenKbToolSetBuff.TOOLID5_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalToolId5",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID5_MAX_VALUE );
		}
		else {
			optionalToolId5 = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbToolSetByTool5IdxKey ) {
			CFGenKbToolSetByTool5IdxKey rhs = (CFGenKbToolSetByTool5IdxKey)obj;
			if( getOptionalToolId5() != null ) {
				if( rhs.getOptionalToolId5() != null ) {
					if( ! getOptionalToolId5().equals( rhs.getOptionalToolId5() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalToolId5() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbToolSetBuff ) {
			CFGenKbToolSetBuff rhs = (CFGenKbToolSetBuff)obj;
			if( getOptionalToolId5() != null ) {
				if( rhs.getOptionalToolId5() != null ) {
					if( ! getOptionalToolId5().equals( rhs.getOptionalToolId5() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalToolId5() != null ) {
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
		if( getOptionalToolId5() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalToolId5();
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
		else if( obj instanceof CFGenKbToolSetByTool5IdxKey ) {
			CFGenKbToolSetByTool5IdxKey rhs = (CFGenKbToolSetByTool5IdxKey)obj;
			if( getOptionalToolId5() != null ) {
				Short lhsToolId5 = getOptionalToolId5();
				if( rhs.getOptionalToolId5() != null ) {
					Short rhsToolId5 = rhs.getOptionalToolId5();
					int cmp = lhsToolId5.compareTo( rhsToolId5 );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalToolId5() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbToolSetBuff ) {
			CFGenKbToolSetBuff rhs = (CFGenKbToolSetBuff)obj;
			if( getOptionalToolId5() != null ) {
				Short lhsToolId5 = getOptionalToolId5();
				if( rhs.getOptionalToolId5() != null ) {
					Short rhsToolId5 = rhs.getOptionalToolId5();
					int cmp = lhsToolId5.compareTo( rhsToolId5 );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalToolId5() != null ) {
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
		String ret = "<CFGenKbToolSetByTool5Idx"
			+ " OptionalToolId5=" + ( ( getOptionalToolId5() == null ) ? "null" : "\"" + getOptionalToolId5().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
