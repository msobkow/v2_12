// Description: Java 11 implementation of a RuleCart buffer object.

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

public class CFGenKbRuleCartBuff
{
	public final static String CLASS_CODE = "RCT";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	protected long requiredTenantId;
	protected long requiredId;
	protected String requiredName;
	protected String optionalDescr;
	protected String optionalRevisionString;
	protected int requiredRevision;
	public CFGenKbRuleCartBuff() {
		requiredTenantId = CFGenKbRuleCartBuff.TENANTID_INIT_VALUE;
		requiredId = CFGenKbRuleCartBuff.ID_INIT_VALUE;
		requiredName = new String( CFGenKbRuleCartBuff.NAME_INIT_VALUE );
		optionalDescr = null;
		optionalRevisionString = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public long getRequiredTenantId() {
		return( requiredTenantId );
	}

	public void setRequiredTenantId( long value ) {
		if( value < CFGenKbRuleCartBuff.TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTenantId",
				1,
				"value",
				value,
				CFGenKbRuleCartBuff.TENANTID_MIN_VALUE );
		}
		requiredTenantId = value;
	}

	public long getRequiredId() {
		return( requiredId );
	}

	public void setRequiredId( long value ) {
		if( value < CFGenKbRuleCartBuff.ID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredId",
				1,
				"value",
				value,
				CFGenKbRuleCartBuff.ID_MIN_VALUE );
		}
		requiredId = value;
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

	public String getOptionalDescr() {
		return( optionalDescr );
	}

	public void setOptionalDescr( String value ) {
		if( value == null ) {
			optionalDescr = null;
		}
		else if( value.length() > 255 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalDescr",
				1,
				"value.length()",
				value.length(),
				255 );
		}
		else {
			optionalDescr = value;
		}
	}

	public String getOptionalRevisionString() {
		return( optionalRevisionString );
	}

	public void setOptionalRevisionString( String value ) {
		if( value == null ) {
			optionalRevisionString = null;
		}
		else if( value.length() > 255 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalRevisionString",
				1,
				"value.length()",
				value.length(),
				255 );
		}
		else {
			optionalRevisionString = value;
		}
	}

	public int getRequiredRevision() {
		return( requiredRevision );
	}

	public void setRequiredRevision( int value ) {
		requiredRevision = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbRuleCartBuff ) {
			CFGenKbRuleCartBuff rhs = (CFGenKbRuleCartBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( getOptionalDescr() != null ) {
				if( rhs.getOptionalDescr() != null ) {
					if( ! getOptionalDescr().equals( rhs.getOptionalDescr() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDescr() != null ) {
					return( false );
				}
			}
			if( getOptionalRevisionString() != null ) {
				if( rhs.getOptionalRevisionString() != null ) {
					if( ! getOptionalRevisionString().equals( rhs.getOptionalRevisionString() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRevisionString() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbRuleCartPKey ) {
			CFGenKbRuleCartPKey rhs = (CFGenKbRuleCartPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbRuleCartByTenantIdxKey ) {
			CFGenKbRuleCartByTenantIdxKey rhs = (CFGenKbRuleCartByTenantIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbRuleCartByNameIdxKey ) {
			CFGenKbRuleCartByNameIdxKey rhs = (CFGenKbRuleCartByNameIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
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
		int hashCode = 0;
		hashCode = hashCode + (int)( getRequiredTenantId() );
		hashCode = hashCode + (int)( getRequiredId() );
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalDescr() != null ) {
			hashCode = hashCode + getOptionalDescr().hashCode();
		}
		if( getOptionalRevisionString() != null ) {
			hashCode = hashCode + getOptionalRevisionString().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFGenKbRuleCartBuff ) {
			CFGenKbRuleCartBuff rhs = (CFGenKbRuleCartBuff)obj;
			int retval = 0;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalDescr() != null ) {
				if( rhs.getOptionalDescr() != null ) {
					int cmp = getOptionalDescr().compareTo( rhs.getOptionalDescr() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescr() != null ) {
					return( -1 );
				}
			}
			if( getOptionalRevisionString() != null ) {
				if( rhs.getOptionalRevisionString() != null ) {
					int cmp = getOptionalRevisionString().compareTo( rhs.getOptionalRevisionString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRevisionString() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbRuleCartPKey ) {
			CFGenKbRuleCartPKey rhs = (CFGenKbRuleCartPKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbRuleCartByTenantIdxKey ) {
			CFGenKbRuleCartByTenantIdxKey rhs = (CFGenKbRuleCartByTenantIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbRuleCartByNameIdxKey ) {
			CFGenKbRuleCartByNameIdxKey rhs = (CFGenKbRuleCartByNameIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	public void set( CFGenKbRuleCartBuff src ) {
		setRuleCartBuff( src );
	}

	public void setRuleCartBuff( CFGenKbRuleCartBuff src ) {
		setRequiredTenantId( src.getRequiredTenantId() );
		setRequiredId( src.getRequiredId() );
		setRequiredName( src.getRequiredName() );
		setOptionalDescr( src.getOptionalDescr() );
		setOptionalRevisionString( src.getOptionalRevisionString() );
		setRequiredRevision( src.getRequiredRevision() );
	}
}
