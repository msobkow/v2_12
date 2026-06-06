// Description: Java 11 implementation of a BoolDef buffer object.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamBoolDefBuff
	extends CFBamAtomBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "BOLD";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	protected Boolean optionalInitValue;
	protected String optionalFalseString;
	protected String optionalTrueString;
	protected String optionalNullString;
	public CFBamBoolDefBuff() {
		super();
		optionalInitValue = null;
		optionalFalseString = null;
		optionalTrueString = null;
		optionalNullString = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public Boolean getOptionalInitValue() {
		return( optionalInitValue );
	}

	public void setOptionalInitValue( Boolean value ) {
		optionalInitValue = value;
	}

	public String getOptionalFalseString() {
		return( optionalFalseString );
	}

	public void setOptionalFalseString( String value ) {
		if( value == null ) {
			optionalFalseString = null;
		}
		else if( value.length() > 32 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalFalseString",
				1,
				"value.length()",
				value.length(),
				32 );
		}
		else {
			optionalFalseString = value;
		}
	}

	public String getOptionalTrueString() {
		return( optionalTrueString );
	}

	public void setOptionalTrueString( String value ) {
		if( value == null ) {
			optionalTrueString = null;
		}
		else if( value.length() > 32 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalTrueString",
				1,
				"value.length()",
				value.length(),
				32 );
		}
		else {
			optionalTrueString = value;
		}
	}

	public String getOptionalNullString() {
		return( optionalNullString );
	}

	public void setOptionalNullString( String value ) {
		if( value == null ) {
			optionalNullString = null;
		}
		else if( value.length() > 32 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalNullString",
				1,
				"value.length()",
				value.length(),
				32 );
		}
		else {
			optionalNullString = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamBoolDefBuff ) {
			CFBamBoolDefBuff rhs = (CFBamBoolDefBuff)obj;
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
			if( getOptionalFalseString() != null ) {
				if( rhs.getOptionalFalseString() != null ) {
					if( ! getOptionalFalseString().equals( rhs.getOptionalFalseString() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalFalseString() != null ) {
					return( false );
				}
			}
			if( getOptionalTrueString() != null ) {
				if( rhs.getOptionalTrueString() != null ) {
					if( ! getOptionalTrueString().equals( rhs.getOptionalTrueString() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalTrueString() != null ) {
					return( false );
				}
			}
			if( getOptionalNullString() != null ) {
				if( rhs.getOptionalNullString() != null ) {
					if( ! getOptionalNullString().equals( rhs.getOptionalNullString() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNullString() != null ) {
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
		else if( obj instanceof CFBamBoolDefHBuff ) {
			CFBamBoolDefHBuff rhs = (CFBamBoolDefHBuff)obj;
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
			if( getOptionalFalseString() != null ) {
				if( rhs.getOptionalFalseString() != null ) {
					if( ! getOptionalFalseString().equals( rhs.getOptionalFalseString() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalFalseString() != null ) {
					return( false );
				}
			}
			if( getOptionalTrueString() != null ) {
				if( rhs.getOptionalTrueString() != null ) {
					if( ! getOptionalTrueString().equals( rhs.getOptionalTrueString() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalTrueString() != null ) {
					return( false );
				}
			}
			if( getOptionalNullString() != null ) {
				if( rhs.getOptionalNullString() != null ) {
					if( ! getOptionalNullString().equals( rhs.getOptionalNullString() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNullString() != null ) {
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
			if( getOptionalInitValue() ) {
				hashCode = ( hashCode * 4 ) + 1;
			}
			else {
				hashCode = hashCode * 4;
			}
		}
		else {
			hashCode = (hashCode * 4 ) + 3;
		}
		if( getOptionalFalseString() != null ) {
			hashCode = hashCode + getOptionalFalseString().hashCode();
		}
		if( getOptionalTrueString() != null ) {
			hashCode = hashCode + getOptionalTrueString().hashCode();
		}
		if( getOptionalNullString() != null ) {
			hashCode = hashCode + getOptionalNullString().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamBoolDefBuff ) {
			CFBamBoolDefBuff rhs = (CFBamBoolDefBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalInitValue() != null ) {
				Boolean lhsInitValue = getOptionalInitValue();
				if( rhs.getOptionalInitValue() ) {
					Boolean rhsInitValue = rhs.getOptionalInitValue();
					if( lhsInitValue ) {
						if( ! rhsInitValue ) {
							return( 1 );
						}
					}
					else {
						if( rhsInitValue ) {
							return( -1 );
						}
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
			if( getOptionalFalseString() != null ) {
				if( rhs.getOptionalFalseString() != null ) {
					int cmp = getOptionalFalseString().compareTo( rhs.getOptionalFalseString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFalseString() != null ) {
					return( -1 );
				}
			}
			if( getOptionalTrueString() != null ) {
				if( rhs.getOptionalTrueString() != null ) {
					int cmp = getOptionalTrueString().compareTo( rhs.getOptionalTrueString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalTrueString() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNullString() != null ) {
				if( rhs.getOptionalNullString() != null ) {
					int cmp = getOptionalNullString().compareTo( rhs.getOptionalNullString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNullString() != null ) {
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
		else if( obj instanceof CFBamBoolDefHBuff ) {
			CFBamBoolDefHBuff rhs = (CFBamBoolDefHBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalInitValue() != null ) {
				Boolean lhsInitValue = getOptionalInitValue();
				if( rhs.getOptionalInitValue() ) {
					Boolean rhsInitValue = rhs.getOptionalInitValue();
					if( lhsInitValue ) {
						if( ! rhsInitValue ) {
							return( 1 );
						}
					}
					else {
						if( rhsInitValue ) {
							return( -1 );
						}
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
			if( getOptionalFalseString() != null ) {
				if( rhs.getOptionalFalseString() != null ) {
					int cmp = getOptionalFalseString().compareTo( rhs.getOptionalFalseString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFalseString() != null ) {
					return( -1 );
				}
			}
			if( getOptionalTrueString() != null ) {
				if( rhs.getOptionalTrueString() != null ) {
					int cmp = getOptionalTrueString().compareTo( rhs.getOptionalTrueString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalTrueString() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNullString() != null ) {
				if( rhs.getOptionalNullString() != null ) {
					int cmp = getOptionalNullString().compareTo( rhs.getOptionalNullString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNullString() != null ) {
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
		if( src instanceof CFBamBoolDefBuff ) {
			setBoolDefBuff( (CFBamBoolDefBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamBoolDefBuff" );
		}
	}

	public void setBoolDefBuff( CFBamBoolDefBuff src ) {
		super.setAtomBuff( src );
		setOptionalInitValue( src.getOptionalInitValue() );
		setOptionalFalseString( src.getOptionalFalseString() );
		setOptionalTrueString( src.getOptionalTrueString() );
		setOptionalNullString( src.getOptionalNullString() );
	}

	public void set( CFBamValueHBuff src ) {
		if( src instanceof CFBamBoolDefHBuff ) {
			setBoolDefBuff( (CFBamBoolDefHBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamBoolDefHBuff" );
		}
	}

	public void setBoolDefBuff( CFBamBoolDefHBuff src ) {
		super.setAtomBuff( src );
		setOptionalInitValue( src.getOptionalInitValue() );
		setOptionalFalseString( src.getOptionalFalseString() );
		setOptionalTrueString( src.getOptionalTrueString() );
		setOptionalNullString( src.getOptionalNullString() );
	}
}
