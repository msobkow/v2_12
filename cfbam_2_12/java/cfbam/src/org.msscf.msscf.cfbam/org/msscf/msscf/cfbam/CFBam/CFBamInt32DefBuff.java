// Description: Java 11 implementation of a Int32Def buffer object.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamInt32DefBuff
	extends CFBamAtomBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "I32D";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final int INITVALUE_INIT_VALUE = 0;
	public static final int MINVALUE_INIT_VALUE = 0;
	public static final int MAXVALUE_INIT_VALUE = 0;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final int INITVALUE_MIN_VALUE = -2147483648;
	public static final int MINVALUE_MIN_VALUE = -2147483648;
	public static final int MAXVALUE_MIN_VALUE = -2147483648;
	public static final int INITVALUE_MAX_VALUE = 2147483647;
	public static final int MINVALUE_MAX_VALUE = 2147483647;
	public static final int MAXVALUE_MAX_VALUE = 2147483647;
	protected Integer optionalInitValue;
	protected Integer optionalMinValue;
	protected Integer optionalMaxValue;
	public CFBamInt32DefBuff() {
		super();
		optionalInitValue = null;
		optionalMinValue = null;
		optionalMaxValue = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public Integer getOptionalInitValue() {
		return( optionalInitValue );
	}

	public void setOptionalInitValue( Integer value ) {
		if( value == null ) {
			optionalInitValue = null;
		}
		else if( value < CFBamInt32DefBuff.INITVALUE_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalInitValue",
				1,
				"value",
				value,
				CFBamInt32DefBuff.INITVALUE_MIN_VALUE );
		}
		else if( value > CFBamInt32DefBuff.INITVALUE_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalInitValue",
				1,
				"value",
				value,
				CFBamInt32DefBuff.INITVALUE_MAX_VALUE );
		}
		else {
			optionalInitValue = value;
		}
	}

	public Integer getOptionalMinValue() {
		return( optionalMinValue );
	}

	public void setOptionalMinValue( Integer value ) {
		if( value == null ) {
			optionalMinValue = null;
		}
		else if( value < CFBamInt32DefBuff.MINVALUE_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalMinValue",
				1,
				"value",
				value,
				CFBamInt32DefBuff.MINVALUE_MIN_VALUE );
		}
		else if( value > CFBamInt32DefBuff.MINVALUE_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalMinValue",
				1,
				"value",
				value,
				CFBamInt32DefBuff.MINVALUE_MAX_VALUE );
		}
		else {
			optionalMinValue = value;
		}
	}

	public Integer getOptionalMaxValue() {
		return( optionalMaxValue );
	}

	public void setOptionalMaxValue( Integer value ) {
		if( value == null ) {
			optionalMaxValue = null;
		}
		else if( value < CFBamInt32DefBuff.MAXVALUE_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalMaxValue",
				1,
				"value",
				value,
				CFBamInt32DefBuff.MAXVALUE_MIN_VALUE );
		}
		else if( value > CFBamInt32DefBuff.MAXVALUE_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalMaxValue",
				1,
				"value",
				value,
				CFBamInt32DefBuff.MAXVALUE_MAX_VALUE );
		}
		else {
			optionalMaxValue = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamInt32DefBuff ) {
			CFBamInt32DefBuff rhs = (CFBamInt32DefBuff)obj;
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
		else if( obj instanceof CFBamInt32DefHBuff ) {
			CFBamInt32DefHBuff rhs = (CFBamInt32DefHBuff)obj;
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
			hashCode = hashCode + getOptionalInitValue();
		}
		if( getOptionalMinValue() != null ) {
			hashCode = hashCode + getOptionalMinValue();
		}
		if( getOptionalMaxValue() != null ) {
			hashCode = hashCode + getOptionalMaxValue();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamInt32DefBuff ) {
			CFBamInt32DefBuff rhs = (CFBamInt32DefBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalInitValue() != null ) {
				Integer lhsInitValue = getOptionalInitValue();
				if( rhs.getOptionalInitValue() != null ) {
					Integer rhsInitValue = rhs.getOptionalInitValue();
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
				Integer lhsMinValue = getOptionalMinValue();
				if( rhs.getOptionalMinValue() != null ) {
					Integer rhsMinValue = rhs.getOptionalMinValue();
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
				Integer lhsMaxValue = getOptionalMaxValue();
				if( rhs.getOptionalMaxValue() != null ) {
					Integer rhsMaxValue = rhs.getOptionalMaxValue();
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
		else if( obj instanceof CFBamInt32DefHBuff ) {
			CFBamInt32DefHBuff rhs = (CFBamInt32DefHBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalInitValue() != null ) {
				Integer lhsInitValue = getOptionalInitValue();
				if( rhs.getOptionalInitValue() != null ) {
					Integer rhsInitValue = rhs.getOptionalInitValue();
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
				Integer lhsMinValue = getOptionalMinValue();
				if( rhs.getOptionalMinValue() != null ) {
					Integer rhsMinValue = rhs.getOptionalMinValue();
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
				Integer lhsMaxValue = getOptionalMaxValue();
				if( rhs.getOptionalMaxValue() != null ) {
					Integer rhsMaxValue = rhs.getOptionalMaxValue();
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
		if( src instanceof CFBamInt32DefBuff ) {
			setInt32DefBuff( (CFBamInt32DefBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamInt32DefBuff" );
		}
	}

	public void setInt32DefBuff( CFBamInt32DefBuff src ) {
		super.setAtomBuff( src );
		setOptionalInitValue( src.getOptionalInitValue() );
		setOptionalMinValue( src.getOptionalMinValue() );
		setOptionalMaxValue( src.getOptionalMaxValue() );
	}

	public void set( CFBamValueHBuff src ) {
		if( src instanceof CFBamInt32DefHBuff ) {
			setInt32DefBuff( (CFBamInt32DefHBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamInt32DefHBuff" );
		}
	}

	public void setInt32DefBuff( CFBamInt32DefHBuff src ) {
		super.setAtomBuff( src );
		setOptionalInitValue( src.getOptionalInitValue() );
		setOptionalMinValue( src.getOptionalMinValue() );
		setOptionalMaxValue( src.getOptionalMaxValue() );
	}
}
