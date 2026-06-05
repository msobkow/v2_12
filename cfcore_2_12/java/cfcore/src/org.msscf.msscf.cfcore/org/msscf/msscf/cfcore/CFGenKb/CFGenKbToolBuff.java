// Description: Java 11 implementation of a Tool buffer object.

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

public class CFGenKbToolBuff
{
	public final static String CLASS_CODE = "TOL";
	public static final short ID_INIT_VALUE = (short)0;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final short REPLACESID_INIT_VALUE = (short)0;
	public static final short ID_MIN_VALUE = (short)0;
	public static final short REPLACESID_MIN_VALUE = (short)0;
	public static final short ID_MAX_VALUE = (short)32767;
	public static final short REPLACESID_MAX_VALUE = (short)32767;
	protected short requiredId;
	protected String requiredName;
	protected Short optionalReplacesId;
	protected boolean requiredIsSupported;
	protected int requiredRevision;
	public CFGenKbToolBuff() {
		requiredId = CFGenKbToolBuff.ID_INIT_VALUE;
		requiredName = new String( CFGenKbToolBuff.NAME_INIT_VALUE );
		optionalReplacesId = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public short getRequiredId() {
		return( requiredId );
	}

	public void setRequiredId( short value ) {
		if( value < CFGenKbToolBuff.ID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredId",
				1,
				"value",
				value,
				CFGenKbToolBuff.ID_MIN_VALUE );
		}
		if( value > CFGenKbToolBuff.ID_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredId",
				1,
				"value",
				value,
				CFGenKbToolBuff.ID_MAX_VALUE );
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

	public Short getOptionalReplacesId() {
		return( optionalReplacesId );
	}

	public void setOptionalReplacesId( Short value ) {
		if( value == null ) {
			optionalReplacesId = null;
		}
		else if( value < CFGenKbToolBuff.REPLACESID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalReplacesId",
				1,
				"value",
				value,
				CFGenKbToolBuff.REPLACESID_MIN_VALUE );
		}
		else if( value > CFGenKbToolBuff.REPLACESID_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalReplacesId",
				1,
				"value",
				value,
				CFGenKbToolBuff.REPLACESID_MAX_VALUE );
		}
		else {
			optionalReplacesId = value;
		}
	}

	public boolean getRequiredIsSupported() {
		return( requiredIsSupported );
	}

	public void setRequiredIsSupported( boolean value ) {
		requiredIsSupported = value;
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
		else if( obj instanceof CFGenKbToolBuff ) {
			CFGenKbToolBuff rhs = (CFGenKbToolBuff)obj;
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( getOptionalReplacesId() != null ) {
				if( rhs.getOptionalReplacesId() != null ) {
					if( ! getOptionalReplacesId().equals( rhs.getOptionalReplacesId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalReplacesId() != null ) {
					return( false );
				}
			}
			if( getRequiredIsSupported() != rhs.getRequiredIsSupported() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbToolPKey ) {
			CFGenKbToolPKey rhs = (CFGenKbToolPKey)obj;
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbToolByNameIdxKey ) {
			CFGenKbToolByNameIdxKey rhs = (CFGenKbToolByNameIdxKey)obj;
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbToolByReplacesIdxKey ) {
			CFGenKbToolByReplacesIdxKey rhs = (CFGenKbToolByReplacesIdxKey)obj;
			if( getOptionalReplacesId() != null ) {
				if( rhs.getOptionalReplacesId() != null ) {
					if( ! getOptionalReplacesId().equals( rhs.getOptionalReplacesId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalReplacesId() != null ) {
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
		if( getOptionalReplacesId() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalReplacesId();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getRequiredIsSupported() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFGenKbToolBuff ) {
			CFGenKbToolBuff rhs = (CFGenKbToolBuff)obj;
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
			if( getOptionalReplacesId() != null ) {
				Short lhsReplacesId = getOptionalReplacesId();
				if( rhs.getOptionalReplacesId() != null ) {
					Short rhsReplacesId = rhs.getOptionalReplacesId();
					int cmp = lhsReplacesId.compareTo( rhsReplacesId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalReplacesId() != null ) {
					return( -1 );
				}
			}
			if( getRequiredIsSupported() ) {
				if( ! rhs.getRequiredIsSupported() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsSupported() ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbToolPKey ) {
			CFGenKbToolPKey rhs = (CFGenKbToolPKey)obj;
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbToolByNameIdxKey ) {
			CFGenKbToolByNameIdxKey rhs = (CFGenKbToolByNameIdxKey)obj;

			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbToolByReplacesIdxKey ) {
			CFGenKbToolByReplacesIdxKey rhs = (CFGenKbToolByReplacesIdxKey)obj;

			if( getOptionalReplacesId() != null ) {
				Short lhsReplacesId = getOptionalReplacesId();
				if( rhs.getOptionalReplacesId() != null ) {
					Short rhsReplacesId = rhs.getOptionalReplacesId();
					int cmp = lhsReplacesId.compareTo( rhsReplacesId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalReplacesId() != null ) {
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

	public void set( CFGenKbToolBuff src ) {
		setToolBuff( src );
	}

	public void setToolBuff( CFGenKbToolBuff src ) {
		setRequiredId( src.getRequiredId() );
		setRequiredName( src.getRequiredName() );
		setOptionalReplacesId( src.getOptionalReplacesId() );
		setRequiredIsSupported( src.getRequiredIsSupported() );
		setRequiredRevision( src.getRequiredRevision() );
	}
}
