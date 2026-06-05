// Description: Java 11 implementation of a GelSwitch buffer object.

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

public class CFGenKbGelSwitchBuff
	extends CFGenKbGelInstructionBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "GSWT";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long GELCACHEID_INIT_VALUE = 0L;
	public static final long GELINSTID_INIT_VALUE = 0L;
	public static final String VALUEEXPANSION_INIT_VALUE = new String( "" );
	public static final String NILEXPANSION_INIT_VALUE = new String( "" );
	public static final String EMPTYEXPANSION_INIT_VALUE = new String( "" );
	public static final String DEFAULTEXPANSION_INIT_VALUE = new String( "" );
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long GELCACHEID_MIN_VALUE = 0L;
	public static final long GELINSTID_MIN_VALUE = 0L;
	protected String requiredValueExpansion;
	protected String optionalNilExpansion;
	protected String optionalEmptyExpansion;
	protected String requiredDefaultExpansion;
	public CFGenKbGelSwitchBuff() {
		super();
		requiredValueExpansion = new String( CFGenKbGelSwitchBuff.VALUEEXPANSION_INIT_VALUE );
		optionalNilExpansion = null;
		optionalEmptyExpansion = null;
		requiredDefaultExpansion = new String( CFGenKbGelSwitchBuff.DEFAULTEXPANSION_INIT_VALUE );
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getRequiredValueExpansion() {
		return( requiredValueExpansion );
	}

	public void setRequiredValueExpansion( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredValueExpansion",
				1,
				"value" );
		}
		if( value.length() > 127 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredValueExpansion",
				1,
				"value.length()",
				value.length(),
				127 );
		}
		requiredValueExpansion = value;
	}

	public String getOptionalNilExpansion() {
		return( optionalNilExpansion );
	}

	public void setOptionalNilExpansion( String value ) {
		if( value == null ) {
			optionalNilExpansion = null;
		}
		else if( value.length() > 127 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalNilExpansion",
				1,
				"value.length()",
				value.length(),
				127 );
		}
		else {
			optionalNilExpansion = value;
		}
	}

	public String getOptionalEmptyExpansion() {
		return( optionalEmptyExpansion );
	}

	public void setOptionalEmptyExpansion( String value ) {
		if( value == null ) {
			optionalEmptyExpansion = null;
		}
		else if( value.length() > 127 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalEmptyExpansion",
				1,
				"value.length()",
				value.length(),
				127 );
		}
		else {
			optionalEmptyExpansion = value;
		}
	}

	public String getRequiredDefaultExpansion() {
		return( requiredDefaultExpansion );
	}

	public void setRequiredDefaultExpansion( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredDefaultExpansion",
				1,
				"value" );
		}
		if( value.length() > 127 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredDefaultExpansion",
				1,
				"value.length()",
				value.length(),
				127 );
		}
		requiredDefaultExpansion = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGelSwitchBuff ) {
			CFGenKbGelSwitchBuff rhs = (CFGenKbGelSwitchBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredGelCacheId() != rhs.getRequiredGelCacheId() ) {
				return( false );
			}
			if( getRequiredGelInstId() != rhs.getRequiredGelInstId() ) {
				return( false );
			}
			if( ! getRequiredValueExpansion().equals( rhs.getRequiredValueExpansion() ) ) {
				return( false );
			}
			if( getOptionalNilExpansion() != null ) {
				if( rhs.getOptionalNilExpansion() != null ) {
					if( ! getOptionalNilExpansion().equals( rhs.getOptionalNilExpansion() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNilExpansion() != null ) {
					return( false );
				}
			}
			if( getOptionalEmptyExpansion() != null ) {
				if( rhs.getOptionalEmptyExpansion() != null ) {
					if( ! getOptionalEmptyExpansion().equals( rhs.getOptionalEmptyExpansion() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalEmptyExpansion() != null ) {
					return( false );
				}
			}
			if( ! getRequiredDefaultExpansion().equals( rhs.getRequiredDefaultExpansion() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGelInstructionPKey ) {
			CFGenKbGelInstructionPKey rhs = (CFGenKbGelInstructionPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredGelCacheId() != rhs.getRequiredGelCacheId() ) {
				return( false );
			}
			if( getRequiredGelInstId() != rhs.getRequiredGelInstId() ) {
				return( false );
			}
			return( true );
		}
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	public int hashCode() {
		int hashCode = super.hashCode();
		if( getRequiredValueExpansion() != null ) {
			hashCode = hashCode + getRequiredValueExpansion().hashCode();
		}
		if( getOptionalNilExpansion() != null ) {
			hashCode = hashCode + getOptionalNilExpansion().hashCode();
		}
		if( getOptionalEmptyExpansion() != null ) {
			hashCode = hashCode + getOptionalEmptyExpansion().hashCode();
		}
		if( getRequiredDefaultExpansion() != null ) {
			hashCode = hashCode + getRequiredDefaultExpansion().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFGenKbGelSwitchBuff ) {
			CFGenKbGelSwitchBuff rhs = (CFGenKbGelSwitchBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			{
				int cmp = getRequiredValueExpansion().compareTo( rhs.getRequiredValueExpansion() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalNilExpansion() != null ) {
				if( rhs.getOptionalNilExpansion() != null ) {
					int cmp = getOptionalNilExpansion().compareTo( rhs.getOptionalNilExpansion() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNilExpansion() != null ) {
					return( -1 );
				}
			}
			if( getOptionalEmptyExpansion() != null ) {
				if( rhs.getOptionalEmptyExpansion() != null ) {
					int cmp = getOptionalEmptyExpansion().compareTo( rhs.getOptionalEmptyExpansion() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEmptyExpansion() != null ) {
					return( -1 );
				}
			}
			{
				int cmp = getRequiredDefaultExpansion().compareTo( rhs.getRequiredDefaultExpansion() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGelInstructionPKey ) {
			CFGenKbGelInstructionPKey rhs = (CFGenKbGelInstructionPKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredGelCacheId() < rhs.getRequiredGelCacheId() ) {
				return( -1 );
			}
			else if( getRequiredGelCacheId() > rhs.getRequiredGelCacheId() ) {
				return( 1 );
			}
			if( getRequiredGelInstId() < rhs.getRequiredGelInstId() ) {
				return( -1 );
			}
			else if( getRequiredGelInstId() > rhs.getRequiredGelInstId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else {
			int retval = super.compareTo( obj );
			return( retval );
		}
	}

	public void set( CFGenKbGelInstructionBuff src ) {
		if( src instanceof CFGenKbGelSwitchBuff ) {
			setGelSwitchBuff( (CFGenKbGelSwitchBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFGenKbGelSwitchBuff" );
		}
	}

	public void setGelSwitchBuff( CFGenKbGelSwitchBuff src ) {
		super.setGelInstructionBuff( src );
		setRequiredValueExpansion( src.getRequiredValueExpansion() );
		setOptionalNilExpansion( src.getOptionalNilExpansion() );
		setOptionalEmptyExpansion( src.getOptionalEmptyExpansion() );
		setRequiredDefaultExpansion( src.getRequiredDefaultExpansion() );
	}
}
