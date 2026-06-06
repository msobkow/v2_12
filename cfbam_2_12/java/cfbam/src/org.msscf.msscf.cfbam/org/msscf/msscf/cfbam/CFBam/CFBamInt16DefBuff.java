// Description: Java 11 implementation of a Int16Def buffer object.

/*
 *	org.msscf.msscf.CFBam
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

package org.msscf.msscf.cfbam.CFBam;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;

public class CFBamInt16DefBuff
	extends CFBamAtomBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "I16D";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final short INITVALUE_INIT_VALUE = (short)0;
	public static final short MINVALUE_INIT_VALUE = (short)0;
	public static final short MAXVALUE_INIT_VALUE = (short)0;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final short INITVALUE_MIN_VALUE = (short)-32768;
	public static final short MINVALUE_MIN_VALUE = (short)-32768;
	public static final short MAXVALUE_MIN_VALUE = (short)-32768;
	public static final short INITVALUE_MAX_VALUE = (short)32767;
	public static final short MINVALUE_MAX_VALUE = (short)32767;
	public static final short MAXVALUE_MAX_VALUE = (short)32767;
	protected Short optionalInitValue;
	protected Short optionalMinValue;
	protected Short optionalMaxValue;
	public CFBamInt16DefBuff() {
		super();
		optionalInitValue = null;
		optionalMinValue = null;
		optionalMaxValue = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public Short getOptionalInitValue() {
		return( optionalInitValue );
	}

	public void setOptionalInitValue( Short value ) {
		if( value == null ) {
			optionalInitValue = null;
		}
		else if( value < CFBamInt16DefBuff.INITVALUE_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalInitValue",
				1,
				"value",
				value,
				CFBamInt16DefBuff.INITVALUE_MIN_VALUE );
		}
		else if( value > CFBamInt16DefBuff.INITVALUE_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalInitValue",
				1,
				"value",
				value,
				CFBamInt16DefBuff.INITVALUE_MAX_VALUE );
		}
		else {
			optionalInitValue = value;
		}
	}

	public Short getOptionalMinValue() {
		return( optionalMinValue );
	}

	public void setOptionalMinValue( Short value ) {
		if( value == null ) {
			optionalMinValue = null;
		}
		else if( value < CFBamInt16DefBuff.MINVALUE_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalMinValue",
				1,
				"value",
				value,
				CFBamInt16DefBuff.MINVALUE_MIN_VALUE );
		}
		else if( value > CFBamInt16DefBuff.MINVALUE_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalMinValue",
				1,
				"value",
				value,
				CFBamInt16DefBuff.MINVALUE_MAX_VALUE );
		}
		else {
			optionalMinValue = value;
		}
	}

	public Short getOptionalMaxValue() {
		return( optionalMaxValue );
	}

	public void setOptionalMaxValue( Short value ) {
		if( value == null ) {
			optionalMaxValue = null;
		}
		else if( value < CFBamInt16DefBuff.MAXVALUE_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalMaxValue",
				1,
				"value",
				value,
				CFBamInt16DefBuff.MAXVALUE_MIN_VALUE );
		}
		else if( value > CFBamInt16DefBuff.MAXVALUE_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalMaxValue",
				1,
				"value",
				value,
				CFBamInt16DefBuff.MAXVALUE_MAX_VALUE );
		}
		else {
			optionalMaxValue = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamInt16DefBuff ) {
			CFBamInt16DefBuff rhs = (CFBamInt16DefBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getOptionalInitValue() != null ) {
				if( rhs.getOptionalInitValue() != null ) {
					if( ! getOptionalInitValue().equals( rhs.getOptionalInitValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalInitValue() != null ) {
					return( false );
				}
			}
			if( getOptionalMinValue() != null ) {
				if( rhs.getOptionalMinValue() != null ) {
					if( ! getOptionalMinValue().equals( rhs.getOptionalMinValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalMinValue() != null ) {
					return( false );
				}
			}
			if( getOptionalMaxValue() != null ) {
				if( rhs.getOptionalMaxValue() != null ) {
					if( ! getOptionalMaxValue().equals( rhs.getOptionalMaxValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalMaxValue() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamValuePKey ) {
			CFBamValuePKey rhs = (CFBamValuePKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamInt16DefHBuff ) {
			CFBamInt16DefHBuff rhs = (CFBamInt16DefHBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getOptionalInitValue() != null ) {
				if( rhs.getOptionalInitValue() != null ) {
					if( ! getOptionalInitValue().equals( rhs.getOptionalInitValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalInitValue() != null ) {
					return( false );
				}
			}
			if( getOptionalMinValue() != null ) {
				if( rhs.getOptionalMinValue() != null ) {
					if( ! getOptionalMinValue().equals( rhs.getOptionalMinValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalMinValue() != null ) {
					return( false );
				}
			}
			if( getOptionalMaxValue() != null ) {
				if( rhs.getOptionalMaxValue() != null ) {
					if( ! getOptionalMaxValue().equals( rhs.getOptionalMaxValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalMaxValue() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamValueHPKey ) {
			CFBamValueHPKey rhs = (CFBamValueHPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
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
		if( getOptionalInitValue() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalInitValue();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalMinValue() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalMinValue();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalMaxValue() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalMaxValue();
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
		else if( obj instanceof CFBamInt16DefBuff ) {
			CFBamInt16DefBuff rhs = (CFBamInt16DefBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalInitValue() != null ) {
				Short lhsInitValue = getOptionalInitValue();
				if( rhs.getOptionalInitValue() != null ) {
					Short rhsInitValue = rhs.getOptionalInitValue();
					int cmp = lhsInitValue.compareTo( rhsInitValue );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalInitValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalMinValue() != null ) {
				Short lhsMinValue = getOptionalMinValue();
				if( rhs.getOptionalMinValue() != null ) {
					Short rhsMinValue = rhs.getOptionalMinValue();
					int cmp = lhsMinValue.compareTo( rhsMinValue );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalMinValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalMaxValue() != null ) {
				Short lhsMaxValue = getOptionalMaxValue();
				if( rhs.getOptionalMaxValue() != null ) {
					Short rhsMaxValue = rhs.getOptionalMaxValue();
					int cmp = lhsMaxValue.compareTo( rhsMaxValue );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalMaxValue() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamValuePKey ) {
			CFBamValuePKey rhs = (CFBamValuePKey)obj;
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
		else if( obj instanceof CFBamValueHPKey ) {
			CFBamValueHPKey rhs = (CFBamValueHPKey)obj;
			{
				int lhsRequiredRevision = getRequiredRevision();
				int rhsRequiredRevision = rhs.getRequiredRevision();
				if( lhsRequiredRevision < rhsRequiredRevision ) {
					return( -1 );
				}
				else if( lhsRequiredRevision > rhsRequiredRevision ) {
					return( 1 );
				}
			}
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
		else if( obj instanceof CFBamInt16DefHBuff ) {
			CFBamInt16DefHBuff rhs = (CFBamInt16DefHBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalInitValue() != null ) {
				Short lhsInitValue = getOptionalInitValue();
				if( rhs.getOptionalInitValue() != null ) {
					Short rhsInitValue = rhs.getOptionalInitValue();
					int cmp = lhsInitValue.compareTo( rhsInitValue );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalInitValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalMinValue() != null ) {
				Short lhsMinValue = getOptionalMinValue();
				if( rhs.getOptionalMinValue() != null ) {
					Short rhsMinValue = rhs.getOptionalMinValue();
					int cmp = lhsMinValue.compareTo( rhsMinValue );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalMinValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalMaxValue() != null ) {
				Short lhsMaxValue = getOptionalMaxValue();
				if( rhs.getOptionalMaxValue() != null ) {
					Short rhsMaxValue = rhs.getOptionalMaxValue();
					int cmp = lhsMaxValue.compareTo( rhsMaxValue );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalMaxValue() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else {
			int retval = super.compareTo( obj );
			return( retval );
		}
	}

	public void set( CFBamValueBuff src ) {
		if( src instanceof CFBamInt16DefBuff ) {
			setInt16DefBuff( (CFBamInt16DefBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamInt16DefBuff" );
		}
	}

	public void setInt16DefBuff( CFBamInt16DefBuff src ) {
		super.setAtomBuff( src );
		setOptionalInitValue( src.getOptionalInitValue() );
		setOptionalMinValue( src.getOptionalMinValue() );
		setOptionalMaxValue( src.getOptionalMaxValue() );
	}

	public void set( CFBamValueHBuff src ) {
		if( src instanceof CFBamInt16DefHBuff ) {
			setInt16DefBuff( (CFBamInt16DefHBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamInt16DefHBuff" );
		}
	}

	public void setInt16DefBuff( CFBamInt16DefHBuff src ) {
		super.setAtomBuff( src );
		setOptionalInitValue( src.getOptionalInitValue() );
		setOptionalMinValue( src.getOptionalMinValue() );
		setOptionalMaxValue( src.getOptionalMaxValue() );
	}
}
