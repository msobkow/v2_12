// Description: Java 11 implementation of a DefClass buffer object.

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

public class CFGenKbDefClassBuff
{
	public final static String CLASS_CODE = "DCL";
	public static final short ID_INIT_VALUE = (short)0;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final short BASEID_INIT_VALUE = (short)0;
	public static final short ID_MIN_VALUE = (short)0;
	public static final short BASEID_MIN_VALUE = (short)0;
	public static final short ID_MAX_VALUE = (short)32767;
	public static final short BASEID_MAX_VALUE = (short)32767;
	protected short requiredId;
	protected String requiredName;
	protected Short optionalBaseId;
	protected int requiredRevision;
	public CFGenKbDefClassBuff() {
		requiredId = CFGenKbDefClassBuff.ID_INIT_VALUE;
		requiredName = new String( CFGenKbDefClassBuff.NAME_INIT_VALUE );
		optionalBaseId = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public short getRequiredId() {
		return( requiredId );
	}

	public void setRequiredId( short value ) {
		if( value < CFGenKbDefClassBuff.ID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredId",
				1,
				"value",
				value,
				CFGenKbDefClassBuff.ID_MIN_VALUE );
		}
		if( value > CFGenKbDefClassBuff.ID_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredId",
				1,
				"value",
				value,
				CFGenKbDefClassBuff.ID_MAX_VALUE );
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
		if( value.length() > 32 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				32 );
		}
		requiredName = value;
	}

	public Short getOptionalBaseId() {
		return( optionalBaseId );
	}

	public void setOptionalBaseId( Short value ) {
		if( value == null ) {
			optionalBaseId = null;
		}
		else if( value < CFGenKbDefClassBuff.BASEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalBaseId",
				1,
				"value",
				value,
				CFGenKbDefClassBuff.BASEID_MIN_VALUE );
		}
		else if( value > CFGenKbDefClassBuff.BASEID_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalBaseId",
				1,
				"value",
				value,
				CFGenKbDefClassBuff.BASEID_MAX_VALUE );
		}
		else {
			optionalBaseId = value;
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
		else if( obj instanceof CFGenKbDefClassBuff ) {
			CFGenKbDefClassBuff rhs = (CFGenKbDefClassBuff)obj;
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( getOptionalBaseId() != null ) {
				if( rhs.getOptionalBaseId() != null ) {
					if( ! getOptionalBaseId().equals( rhs.getOptionalBaseId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalBaseId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbDefClassPKey ) {
			CFGenKbDefClassPKey rhs = (CFGenKbDefClassPKey)obj;
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbDefClassByNameIdxKey ) {
			CFGenKbDefClassByNameIdxKey rhs = (CFGenKbDefClassByNameIdxKey)obj;
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbDefClassByBaseIdxKey ) {
			CFGenKbDefClassByBaseIdxKey rhs = (CFGenKbDefClassByBaseIdxKey)obj;
			if( getOptionalBaseId() != null ) {
				if( rhs.getOptionalBaseId() != null ) {
					if( ! getOptionalBaseId().equals( rhs.getOptionalBaseId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalBaseId() != null ) {
					return( false );
				}
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
		hashCode = ( hashCode * 0x10000 ) + getRequiredId();
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalBaseId() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalBaseId();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFGenKbDefClassBuff ) {
			CFGenKbDefClassBuff rhs = (CFGenKbDefClassBuff)obj;
			int retval = 0;
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
			if( getOptionalBaseId() != null ) {
				Short lhsBaseId = getOptionalBaseId();
				if( rhs.getOptionalBaseId() != null ) {
					Short rhsBaseId = rhs.getOptionalBaseId();
					int cmp = lhsBaseId.compareTo( rhsBaseId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalBaseId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbDefClassPKey ) {
			CFGenKbDefClassPKey rhs = (CFGenKbDefClassPKey)obj;
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbDefClassByNameIdxKey ) {
			CFGenKbDefClassByNameIdxKey rhs = (CFGenKbDefClassByNameIdxKey)obj;

			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbDefClassByBaseIdxKey ) {
			CFGenKbDefClassByBaseIdxKey rhs = (CFGenKbDefClassByBaseIdxKey)obj;

			if( getOptionalBaseId() != null ) {
				Short lhsBaseId = getOptionalBaseId();
				if( rhs.getOptionalBaseId() != null ) {
					Short rhsBaseId = rhs.getOptionalBaseId();
					int cmp = lhsBaseId.compareTo( rhsBaseId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalBaseId() != null ) {
					return( -1 );
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

	public void set( CFGenKbDefClassBuff src ) {
		setDefClassBuff( src );
	}

	public void setDefClassBuff( CFGenKbDefClassBuff src ) {
		setRequiredId( src.getRequiredId() );
		setRequiredName( src.getRequiredName() );
		setOptionalBaseId( src.getOptionalBaseId() );
		setRequiredRevision( src.getRequiredRevision() );
	}
}
