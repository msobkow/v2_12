// Description: Java 11 implementation of a ToolSet buffer object.

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

public class CFGenKbToolSetBuff
{
	public final static String CLASS_CODE = "TLS";
	public static final short ID_INIT_VALUE = (short)0;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final short TOOLID0_INIT_VALUE = (short)0;
	public static final short TOOLID1_INIT_VALUE = (short)0;
	public static final short TOOLID2_INIT_VALUE = (short)0;
	public static final short TOOLID3_INIT_VALUE = (short)0;
	public static final short TOOLID4_INIT_VALUE = (short)0;
	public static final short TOOLID5_INIT_VALUE = (short)0;
	public static final short TOOLID6_INIT_VALUE = (short)0;
	public static final short TOOLID7_INIT_VALUE = (short)0;
	public static final short ID_MIN_VALUE = (short)0;
	public static final short TOOLID0_MIN_VALUE = (short)0;
	public static final short TOOLID1_MIN_VALUE = (short)0;
	public static final short TOOLID2_MIN_VALUE = (short)0;
	public static final short TOOLID3_MIN_VALUE = (short)0;
	public static final short TOOLID4_MIN_VALUE = (short)0;
	public static final short TOOLID5_MIN_VALUE = (short)0;
	public static final short TOOLID6_MIN_VALUE = (short)0;
	public static final short TOOLID7_MIN_VALUE = (short)0;
	public static final short ID_MAX_VALUE = (short)32767;
	public static final short TOOLID0_MAX_VALUE = (short)32767;
	public static final short TOOLID1_MAX_VALUE = (short)32767;
	public static final short TOOLID2_MAX_VALUE = (short)32767;
	public static final short TOOLID3_MAX_VALUE = (short)32767;
	public static final short TOOLID4_MAX_VALUE = (short)32767;
	public static final short TOOLID5_MAX_VALUE = (short)32767;
	public static final short TOOLID6_MAX_VALUE = (short)32767;
	public static final short TOOLID7_MAX_VALUE = (short)32767;
	protected short requiredId;
	protected String requiredName;
	protected String optionalDescr;
	protected String optionalRevisionString;
	protected boolean requiredIsSupported;
	protected boolean requiredGenerate;
	protected short requiredToolId0;
	protected Short optionalToolId1;
	protected Short optionalToolId2;
	protected Short optionalToolId3;
	protected Short optionalToolId4;
	protected Short optionalToolId5;
	protected Short optionalToolId6;
	protected Short optionalToolId7;
	protected int requiredRevision;
	public CFGenKbToolSetBuff() {
		requiredId = CFGenKbToolSetBuff.ID_INIT_VALUE;
		requiredName = new String( CFGenKbToolSetBuff.NAME_INIT_VALUE );
		optionalDescr = null;
		optionalRevisionString = null;
		requiredToolId0 = CFGenKbToolSetBuff.TOOLID0_INIT_VALUE;
		optionalToolId1 = null;
		optionalToolId2 = null;
		optionalToolId3 = null;
		optionalToolId4 = null;
		optionalToolId5 = null;
		optionalToolId6 = null;
		optionalToolId7 = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public short getRequiredId() {
		return( requiredId );
	}

	public void setRequiredId( short value ) {
		if( value < CFGenKbToolSetBuff.ID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredId",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.ID_MIN_VALUE );
		}
		if( value > CFGenKbToolSetBuff.ID_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredId",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.ID_MAX_VALUE );
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
		if( value.length() > 511 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				511 );
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

	public boolean getRequiredIsSupported() {
		return( requiredIsSupported );
	}

	public void setRequiredIsSupported( boolean value ) {
		requiredIsSupported = value;
	}

	public boolean getRequiredGenerate() {
		return( requiredGenerate );
	}

	public void setRequiredGenerate( boolean value ) {
		requiredGenerate = value;
	}

	public short getRequiredToolId0() {
		return( requiredToolId0 );
	}

	public void setRequiredToolId0( short value ) {
		if( value < CFGenKbToolSetBuff.TOOLID0_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredToolId0",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID0_MIN_VALUE );
		}
		if( value > CFGenKbToolSetBuff.TOOLID0_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredToolId0",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID0_MAX_VALUE );
		}
		requiredToolId0 = value;
	}

	public Short getOptionalToolId1() {
		return( optionalToolId1 );
	}

	public void setOptionalToolId1( Short value ) {
		if( value == null ) {
			optionalToolId1 = null;
		}
		else if( value < CFGenKbToolSetBuff.TOOLID1_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalToolId1",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID1_MIN_VALUE );
		}
		else if( value > CFGenKbToolSetBuff.TOOLID1_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalToolId1",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID1_MAX_VALUE );
		}
		else {
			optionalToolId1 = value;
		}
	}

	public Short getOptionalToolId2() {
		return( optionalToolId2 );
	}

	public void setOptionalToolId2( Short value ) {
		if( value == null ) {
			optionalToolId2 = null;
		}
		else if( value < CFGenKbToolSetBuff.TOOLID2_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalToolId2",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID2_MIN_VALUE );
		}
		else if( value > CFGenKbToolSetBuff.TOOLID2_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalToolId2",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID2_MAX_VALUE );
		}
		else {
			optionalToolId2 = value;
		}
	}

	public Short getOptionalToolId3() {
		return( optionalToolId3 );
	}

	public void setOptionalToolId3( Short value ) {
		if( value == null ) {
			optionalToolId3 = null;
		}
		else if( value < CFGenKbToolSetBuff.TOOLID3_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalToolId3",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID3_MIN_VALUE );
		}
		else if( value > CFGenKbToolSetBuff.TOOLID3_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalToolId3",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID3_MAX_VALUE );
		}
		else {
			optionalToolId3 = value;
		}
	}

	public Short getOptionalToolId4() {
		return( optionalToolId4 );
	}

	public void setOptionalToolId4( Short value ) {
		if( value == null ) {
			optionalToolId4 = null;
		}
		else if( value < CFGenKbToolSetBuff.TOOLID4_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalToolId4",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID4_MIN_VALUE );
		}
		else if( value > CFGenKbToolSetBuff.TOOLID4_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalToolId4",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID4_MAX_VALUE );
		}
		else {
			optionalToolId4 = value;
		}
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

	public Short getOptionalToolId6() {
		return( optionalToolId6 );
	}

	public void setOptionalToolId6( Short value ) {
		if( value == null ) {
			optionalToolId6 = null;
		}
		else if( value < CFGenKbToolSetBuff.TOOLID6_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalToolId6",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID6_MIN_VALUE );
		}
		else if( value > CFGenKbToolSetBuff.TOOLID6_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalToolId6",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID6_MAX_VALUE );
		}
		else {
			optionalToolId6 = value;
		}
	}

	public Short getOptionalToolId7() {
		return( optionalToolId7 );
	}

	public void setOptionalToolId7( Short value ) {
		if( value == null ) {
			optionalToolId7 = null;
		}
		else if( value < CFGenKbToolSetBuff.TOOLID7_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalToolId7",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID7_MIN_VALUE );
		}
		else if( value > CFGenKbToolSetBuff.TOOLID7_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalToolId7",
				1,
				"value",
				value,
				CFGenKbToolSetBuff.TOOLID7_MAX_VALUE );
		}
		else {
			optionalToolId7 = value;
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
		else if( obj instanceof CFGenKbToolSetBuff ) {
			CFGenKbToolSetBuff rhs = (CFGenKbToolSetBuff)obj;
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
			if( getRequiredIsSupported() != rhs.getRequiredIsSupported() ) {
				return( false );
			}
			if( getRequiredGenerate() != rhs.getRequiredGenerate() ) {
				return( false );
			}
			if( getRequiredToolId0() != rhs.getRequiredToolId0() ) {
				return( false );
			}
			if( getOptionalToolId1() != null ) {
				if( rhs.getOptionalToolId1() != null ) {
					if( ! getOptionalToolId1().equals( rhs.getOptionalToolId1() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalToolId1() != null ) {
					return( false );
				}
			}
			if( getOptionalToolId2() != null ) {
				if( rhs.getOptionalToolId2() != null ) {
					if( ! getOptionalToolId2().equals( rhs.getOptionalToolId2() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalToolId2() != null ) {
					return( false );
				}
			}
			if( getOptionalToolId3() != null ) {
				if( rhs.getOptionalToolId3() != null ) {
					if( ! getOptionalToolId3().equals( rhs.getOptionalToolId3() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalToolId3() != null ) {
					return( false );
				}
			}
			if( getOptionalToolId4() != null ) {
				if( rhs.getOptionalToolId4() != null ) {
					if( ! getOptionalToolId4().equals( rhs.getOptionalToolId4() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalToolId4() != null ) {
					return( false );
				}
			}
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
			if( getOptionalToolId6() != null ) {
				if( rhs.getOptionalToolId6() != null ) {
					if( ! getOptionalToolId6().equals( rhs.getOptionalToolId6() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalToolId6() != null ) {
					return( false );
				}
			}
			if( getOptionalToolId7() != null ) {
				if( rhs.getOptionalToolId7() != null ) {
					if( ! getOptionalToolId7().equals( rhs.getOptionalToolId7() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalToolId7() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbToolSetPKey ) {
			CFGenKbToolSetPKey rhs = (CFGenKbToolSetPKey)obj;
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbToolSetByNameIdxKey ) {
			CFGenKbToolSetByNameIdxKey rhs = (CFGenKbToolSetByNameIdxKey)obj;
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbToolSetByTool0IdxKey ) {
			CFGenKbToolSetByTool0IdxKey rhs = (CFGenKbToolSetByTool0IdxKey)obj;
			if( getRequiredToolId0() != rhs.getRequiredToolId0() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbToolSetByTool1IdxKey ) {
			CFGenKbToolSetByTool1IdxKey rhs = (CFGenKbToolSetByTool1IdxKey)obj;
			if( getOptionalToolId1() != null ) {
				if( rhs.getOptionalToolId1() != null ) {
					if( ! getOptionalToolId1().equals( rhs.getOptionalToolId1() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalToolId1() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbToolSetByTool2IdxKey ) {
			CFGenKbToolSetByTool2IdxKey rhs = (CFGenKbToolSetByTool2IdxKey)obj;
			if( getOptionalToolId2() != null ) {
				if( rhs.getOptionalToolId2() != null ) {
					if( ! getOptionalToolId2().equals( rhs.getOptionalToolId2() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalToolId2() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbToolSetByTool3IdxKey ) {
			CFGenKbToolSetByTool3IdxKey rhs = (CFGenKbToolSetByTool3IdxKey)obj;
			if( getOptionalToolId3() != null ) {
				if( rhs.getOptionalToolId3() != null ) {
					if( ! getOptionalToolId3().equals( rhs.getOptionalToolId3() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalToolId3() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbToolSetByTool4IdxKey ) {
			CFGenKbToolSetByTool4IdxKey rhs = (CFGenKbToolSetByTool4IdxKey)obj;
			if( getOptionalToolId4() != null ) {
				if( rhs.getOptionalToolId4() != null ) {
					if( ! getOptionalToolId4().equals( rhs.getOptionalToolId4() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalToolId4() != null ) {
					return( false );
				}
			}
			return( true );
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
		else if( obj instanceof CFGenKbToolSetByTool6IdxKey ) {
			CFGenKbToolSetByTool6IdxKey rhs = (CFGenKbToolSetByTool6IdxKey)obj;
			if( getOptionalToolId6() != null ) {
				if( rhs.getOptionalToolId6() != null ) {
					if( ! getOptionalToolId6().equals( rhs.getOptionalToolId6() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalToolId6() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbToolSetByTool7IdxKey ) {
			CFGenKbToolSetByTool7IdxKey rhs = (CFGenKbToolSetByTool7IdxKey)obj;
			if( getOptionalToolId7() != null ) {
				if( rhs.getOptionalToolId7() != null ) {
					if( ! getOptionalToolId7().equals( rhs.getOptionalToolId7() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalToolId7() != null ) {
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
		if( getOptionalDescr() != null ) {
			hashCode = hashCode + getOptionalDescr().hashCode();
		}
		if( getOptionalRevisionString() != null ) {
			hashCode = hashCode + getOptionalRevisionString().hashCode();
		}
		if( getRequiredIsSupported() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getRequiredGenerate() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		hashCode = ( hashCode * 0x10000 ) + getRequiredToolId0();
		if( getOptionalToolId1() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalToolId1();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalToolId2() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalToolId2();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalToolId3() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalToolId3();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalToolId4() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalToolId4();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalToolId5() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalToolId5();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalToolId6() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalToolId6();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalToolId7() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalToolId7();
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
		else if( obj instanceof CFGenKbToolSetBuff ) {
			CFGenKbToolSetBuff rhs = (CFGenKbToolSetBuff)obj;
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
			if( getRequiredGenerate() ) {
				if( ! rhs.getRequiredGenerate() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredGenerate() ) {
					return( -1 );
				}
			}
			if( getRequiredToolId0() < rhs.getRequiredToolId0() ) {
				return( -1 );
			}
			else if( getRequiredToolId0() > rhs.getRequiredToolId0() ) {
				return( 1 );
			}
			if( getOptionalToolId1() != null ) {
				Short lhsToolId1 = getOptionalToolId1();
				if( rhs.getOptionalToolId1() != null ) {
					Short rhsToolId1 = rhs.getOptionalToolId1();
					int cmp = lhsToolId1.compareTo( rhsToolId1 );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalToolId1() != null ) {
					return( -1 );
				}
			}
			if( getOptionalToolId2() != null ) {
				Short lhsToolId2 = getOptionalToolId2();
				if( rhs.getOptionalToolId2() != null ) {
					Short rhsToolId2 = rhs.getOptionalToolId2();
					int cmp = lhsToolId2.compareTo( rhsToolId2 );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalToolId2() != null ) {
					return( -1 );
				}
			}
			if( getOptionalToolId3() != null ) {
				Short lhsToolId3 = getOptionalToolId3();
				if( rhs.getOptionalToolId3() != null ) {
					Short rhsToolId3 = rhs.getOptionalToolId3();
					int cmp = lhsToolId3.compareTo( rhsToolId3 );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalToolId3() != null ) {
					return( -1 );
				}
			}
			if( getOptionalToolId4() != null ) {
				Short lhsToolId4 = getOptionalToolId4();
				if( rhs.getOptionalToolId4() != null ) {
					Short rhsToolId4 = rhs.getOptionalToolId4();
					int cmp = lhsToolId4.compareTo( rhsToolId4 );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalToolId4() != null ) {
					return( -1 );
				}
			}
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
			if( getOptionalToolId6() != null ) {
				Short lhsToolId6 = getOptionalToolId6();
				if( rhs.getOptionalToolId6() != null ) {
					Short rhsToolId6 = rhs.getOptionalToolId6();
					int cmp = lhsToolId6.compareTo( rhsToolId6 );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalToolId6() != null ) {
					return( -1 );
				}
			}
			if( getOptionalToolId7() != null ) {
				Short lhsToolId7 = getOptionalToolId7();
				if( rhs.getOptionalToolId7() != null ) {
					Short rhsToolId7 = rhs.getOptionalToolId7();
					int cmp = lhsToolId7.compareTo( rhsToolId7 );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalToolId7() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbToolSetPKey ) {
			CFGenKbToolSetPKey rhs = (CFGenKbToolSetPKey)obj;
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbToolSetByNameIdxKey ) {
			CFGenKbToolSetByNameIdxKey rhs = (CFGenKbToolSetByNameIdxKey)obj;

			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbToolSetByTool0IdxKey ) {
			CFGenKbToolSetByTool0IdxKey rhs = (CFGenKbToolSetByTool0IdxKey)obj;

			if( getRequiredToolId0() < rhs.getRequiredToolId0() ) {
				return( -1 );
			}
			else if( getRequiredToolId0() > rhs.getRequiredToolId0() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbToolSetByTool1IdxKey ) {
			CFGenKbToolSetByTool1IdxKey rhs = (CFGenKbToolSetByTool1IdxKey)obj;

			if( getOptionalToolId1() != null ) {
				Short lhsToolId1 = getOptionalToolId1();
				if( rhs.getOptionalToolId1() != null ) {
					Short rhsToolId1 = rhs.getOptionalToolId1();
					int cmp = lhsToolId1.compareTo( rhsToolId1 );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalToolId1() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbToolSetByTool2IdxKey ) {
			CFGenKbToolSetByTool2IdxKey rhs = (CFGenKbToolSetByTool2IdxKey)obj;

			if( getOptionalToolId2() != null ) {
				Short lhsToolId2 = getOptionalToolId2();
				if( rhs.getOptionalToolId2() != null ) {
					Short rhsToolId2 = rhs.getOptionalToolId2();
					int cmp = lhsToolId2.compareTo( rhsToolId2 );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalToolId2() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbToolSetByTool3IdxKey ) {
			CFGenKbToolSetByTool3IdxKey rhs = (CFGenKbToolSetByTool3IdxKey)obj;

			if( getOptionalToolId3() != null ) {
				Short lhsToolId3 = getOptionalToolId3();
				if( rhs.getOptionalToolId3() != null ) {
					Short rhsToolId3 = rhs.getOptionalToolId3();
					int cmp = lhsToolId3.compareTo( rhsToolId3 );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalToolId3() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbToolSetByTool4IdxKey ) {
			CFGenKbToolSetByTool4IdxKey rhs = (CFGenKbToolSetByTool4IdxKey)obj;

			if( getOptionalToolId4() != null ) {
				Short lhsToolId4 = getOptionalToolId4();
				if( rhs.getOptionalToolId4() != null ) {
					Short rhsToolId4 = rhs.getOptionalToolId4();
					int cmp = lhsToolId4.compareTo( rhsToolId4 );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalToolId4() != null ) {
					return( -1 );
				}
			}			return( 0 );
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
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbToolSetByTool6IdxKey ) {
			CFGenKbToolSetByTool6IdxKey rhs = (CFGenKbToolSetByTool6IdxKey)obj;

			if( getOptionalToolId6() != null ) {
				Short lhsToolId6 = getOptionalToolId6();
				if( rhs.getOptionalToolId6() != null ) {
					Short rhsToolId6 = rhs.getOptionalToolId6();
					int cmp = lhsToolId6.compareTo( rhsToolId6 );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalToolId6() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbToolSetByTool7IdxKey ) {
			CFGenKbToolSetByTool7IdxKey rhs = (CFGenKbToolSetByTool7IdxKey)obj;

			if( getOptionalToolId7() != null ) {
				Short lhsToolId7 = getOptionalToolId7();
				if( rhs.getOptionalToolId7() != null ) {
					Short rhsToolId7 = rhs.getOptionalToolId7();
					int cmp = lhsToolId7.compareTo( rhsToolId7 );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalToolId7() != null ) {
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

	public void set( CFGenKbToolSetBuff src ) {
		setToolSetBuff( src );
	}

	public void setToolSetBuff( CFGenKbToolSetBuff src ) {
		setRequiredId( src.getRequiredId() );
		setRequiredName( src.getRequiredName() );
		setOptionalDescr( src.getOptionalDescr() );
		setOptionalRevisionString( src.getOptionalRevisionString() );
		setRequiredIsSupported( src.getRequiredIsSupported() );
		setRequiredGenerate( src.getRequiredGenerate() );
		setRequiredToolId0( src.getRequiredToolId0() );
		setOptionalToolId1( src.getOptionalToolId1() );
		setOptionalToolId2( src.getOptionalToolId2() );
		setOptionalToolId3( src.getOptionalToolId3() );
		setOptionalToolId4( src.getOptionalToolId4() );
		setOptionalToolId5( src.getOptionalToolId5() );
		setOptionalToolId6( src.getOptionalToolId6() );
		setOptionalToolId7( src.getOptionalToolId7() );
		setRequiredRevision( src.getRequiredRevision() );
	}
}
