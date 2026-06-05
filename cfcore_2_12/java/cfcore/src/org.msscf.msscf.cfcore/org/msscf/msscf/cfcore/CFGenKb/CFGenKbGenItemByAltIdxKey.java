// Description: Java 11 implementation of a GenItem by AltIdx index key object.

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

public class CFGenKbGenItemByAltIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected String requiredName;
	protected short requiredToolSetId;
	protected Short optionalScopeDefId;
	protected short requiredGenDefId;
	public CFGenKbGenItemByAltIdxKey() {
		requiredName = new String( CFGenKbGenItemBuff.NAME_INIT_VALUE );
		requiredToolSetId = CFGenKbGenItemBuff.TOOLSETID_INIT_VALUE;
		optionalScopeDefId = null;
		requiredGenDefId = CFGenKbGenItemBuff.GENDEFID_INIT_VALUE;
	}

	public String getRequiredName() {
		return( requiredName );
	}

	public void setRequiredName( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredName",
				1,
				"value" );
		}
		if( value.length() > 127 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				127 );
		}
		requiredName = value;
	}

	public short getRequiredToolSetId() {
		return( requiredToolSetId );
	}

	public void setRequiredToolSetId( short value ) {
		if( value < CFGenKbGenItemBuff.TOOLSETID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredToolSetId",
				1,
				"value",
				value,
				CFGenKbGenItemBuff.TOOLSETID_MIN_VALUE );
		}
		if( value > CFGenKbGenItemBuff.TOOLSETID_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredToolSetId",
				1,
				"value",
				value,
				CFGenKbGenItemBuff.TOOLSETID_MAX_VALUE );
		}
		requiredToolSetId = value;
	}

	public Short getOptionalScopeDefId() {
		return( optionalScopeDefId );
	}

	public void setOptionalScopeDefId( Short value ) {
		if( value == null ) {
			optionalScopeDefId = null;
		}
		else if( value < CFGenKbGenItemBuff.SCOPEDEFID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalScopeDefId",
				1,
				"value",
				value,
				CFGenKbGenItemBuff.SCOPEDEFID_MIN_VALUE );
		}
		else if( value > CFGenKbGenItemBuff.SCOPEDEFID_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalScopeDefId",
				1,
				"value",
				value,
				CFGenKbGenItemBuff.SCOPEDEFID_MAX_VALUE );
		}
		else {
			optionalScopeDefId = value;
		}
	}

	public short getRequiredGenDefId() {
		return( requiredGenDefId );
	}

	public void setRequiredGenDefId( short value ) {
		if( value < CFGenKbGenItemBuff.GENDEFID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredGenDefId",
				1,
				"value",
				value,
				CFGenKbGenItemBuff.GENDEFID_MIN_VALUE );
		}
		if( value > CFGenKbGenItemBuff.GENDEFID_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredGenDefId",
				1,
				"value",
				value,
				CFGenKbGenItemBuff.GENDEFID_MAX_VALUE );
		}
		requiredGenDefId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGenItemByAltIdxKey ) {
			CFGenKbGenItemByAltIdxKey rhs = (CFGenKbGenItemByAltIdxKey)obj;
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( getRequiredToolSetId() != rhs.getRequiredToolSetId() ) {
				return( false );
			}
			if( getOptionalScopeDefId() != null ) {
				if( rhs.getOptionalScopeDefId() != null ) {
					if( ! getOptionalScopeDefId().equals( rhs.getOptionalScopeDefId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalScopeDefId() != null ) {
					return( false );
				}
			}
			if( getRequiredGenDefId() != rhs.getRequiredGenDefId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGenItemBuff ) {
			CFGenKbGenItemBuff rhs = (CFGenKbGenItemBuff)obj;
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( getRequiredToolSetId() != rhs.getRequiredToolSetId() ) {
				return( false );
			}
			if( getOptionalScopeDefId() != null ) {
				if( rhs.getOptionalScopeDefId() != null ) {
					if( ! getOptionalScopeDefId().equals( rhs.getOptionalScopeDefId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalScopeDefId() != null ) {
					return( false );
				}
			}
			if( getRequiredGenDefId() != rhs.getRequiredGenDefId() ) {
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
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		hashCode = ( hashCode * 0x10000 ) + getRequiredToolSetId();
		if( getOptionalScopeDefId() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalScopeDefId();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		hashCode = ( hashCode * 0x10000 ) + getRequiredGenDefId();
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbGenItemByAltIdxKey ) {
			CFGenKbGenItemByAltIdxKey rhs = (CFGenKbGenItemByAltIdxKey)obj;
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getRequiredToolSetId() < rhs.getRequiredToolSetId() ) {
				return( -1 );
			}
			else if( getRequiredToolSetId() > rhs.getRequiredToolSetId() ) {
				return( 1 );
			}
			if( getOptionalScopeDefId() != null ) {
				Short lhsScopeDefId = getOptionalScopeDefId();
				if( rhs.getOptionalScopeDefId() != null ) {
					Short rhsScopeDefId = rhs.getOptionalScopeDefId();
					int cmp = lhsScopeDefId.compareTo( rhsScopeDefId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalScopeDefId() != null ) {
					return( -1 );
				}
			}
			if( getRequiredGenDefId() < rhs.getRequiredGenDefId() ) {
				return( -1 );
			}
			else if( getRequiredGenDefId() > rhs.getRequiredGenDefId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGenItemBuff ) {
			CFGenKbGenItemBuff rhs = (CFGenKbGenItemBuff)obj;
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getRequiredToolSetId() < rhs.getRequiredToolSetId() ) {
				return( -1 );
			}
			else if( getRequiredToolSetId() > rhs.getRequiredToolSetId() ) {
				return( 1 );
			}
			if( getOptionalScopeDefId() != null ) {
				Short lhsScopeDefId = getOptionalScopeDefId();
				if( rhs.getOptionalScopeDefId() != null ) {
					Short rhsScopeDefId = rhs.getOptionalScopeDefId();
					int cmp = lhsScopeDefId.compareTo( rhsScopeDefId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalScopeDefId() != null ) {
					return( -1 );
				}
			}
			if( getRequiredGenDefId() < rhs.getRequiredGenDefId() ) {
				return( -1 );
			}
			else if( getRequiredGenDefId() > rhs.getRequiredGenDefId() ) {
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
		String ret = "<CFGenKbGenItemByAltIdx"
			+ " RequiredName=" + "\"" + CFGenKbSchema.xmlEncodeString( getRequiredName() ) + "\""
			+ " RequiredToolSetId=" + "\"" + Short.toString( getRequiredToolSetId() ) + "\""
			+ " OptionalScopeDefId=" + ( ( getOptionalScopeDefId() == null ) ? "null" : "\"" + getOptionalScopeDefId().toString() + "\"" )
			+ " RequiredGenDefId=" + "\"" + Short.toString( getRequiredGenDefId() ) + "\""
			+ "/>";
		return( ret );
	}
}
