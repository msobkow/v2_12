// Description: Java 11 implementation of a GelSpread by LoneIdx index key object.

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

public class CFGenKbGelSpreadByLoneIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected String optionalExpandLone;
	public CFGenKbGelSpreadByLoneIdxKey() {
		optionalExpandLone = null;
	}

	public String getOptionalExpandLone() {
		return( optionalExpandLone );
	}

	public void setOptionalExpandLone( String value ) {
		if( value == null ) {
			optionalExpandLone = null;
		}
		else if( value.length() > 127 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalExpandLone",
				1,
				"value.length()",
				value.length(),
				127 );
		}
		else {
			optionalExpandLone = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGelSpreadByLoneIdxKey ) {
			CFGenKbGelSpreadByLoneIdxKey rhs = (CFGenKbGelSpreadByLoneIdxKey)obj;
			if( getOptionalExpandLone() != null ) {
				if( rhs.getOptionalExpandLone() != null ) {
					if( ! getOptionalExpandLone().equals( rhs.getOptionalExpandLone() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpandLone() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGelSpreadBuff ) {
			CFGenKbGelSpreadBuff rhs = (CFGenKbGelSpreadBuff)obj;
			if( getOptionalExpandLone() != null ) {
				if( rhs.getOptionalExpandLone() != null ) {
					if( ! getOptionalExpandLone().equals( rhs.getOptionalExpandLone() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpandLone() != null ) {
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
		if( getOptionalExpandLone() != null ) {
			hashCode = hashCode + getOptionalExpandLone().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbGelSpreadByLoneIdxKey ) {
			CFGenKbGelSpreadByLoneIdxKey rhs = (CFGenKbGelSpreadByLoneIdxKey)obj;
			if( getOptionalExpandLone() != null ) {
				if( rhs.getOptionalExpandLone() != null ) {
					int cmp = getOptionalExpandLone().compareTo( rhs.getOptionalExpandLone() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpandLone() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGelSpreadBuff ) {
			CFGenKbGelSpreadBuff rhs = (CFGenKbGelSpreadBuff)obj;
			if( getOptionalExpandLone() != null ) {
				if( rhs.getOptionalExpandLone() != null ) {
					int cmp = getOptionalExpandLone().compareTo( rhs.getOptionalExpandLone() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpandLone() != null ) {
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
		String ret = "<CFGenKbGelSpreadByLoneIdx"
			+ " OptionalExpandLone=" + ( ( getOptionalExpandLone() == null ) ? "null" : "\"" + CFGenKbSchema.xmlEncodeString( getOptionalExpandLone() ) + "\"" )
			+ "/>";
		return( ret );
	}
}
