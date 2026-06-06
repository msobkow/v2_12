// Description: Java 11 implementation of a TableCol buffer object.

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

public class CFBamTableColBuff
	extends CFBamValueBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "TBLC";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final long TABLEID_INIT_VALUE = 0L;
	public static final long DATATENANTID_INIT_VALUE = 0L;
	public static final long DATAID_INIT_VALUE = 0L;
	public static final String XMLELEMENTNAME_INIT_VALUE = new String( "" );
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final long TABLEID_MIN_VALUE = 0L;
	public static final long DATATENANTID_MIN_VALUE = 0L;
	public static final long DATAID_MIN_VALUE = 0L;
	protected long requiredTableId;
	protected String optionalDbName;
	protected Long optionalDataTenantId;
	protected Long optionalDataId;
	protected String optionalXmlElementName;
	public CFBamTableColBuff() {
		super();
		requiredTableId = CFBamTableColBuff.TABLEID_INIT_VALUE;
		optionalDbName = null;
		optionalDataTenantId = null;
		optionalDataId = null;
		optionalXmlElementName = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public long getRequiredTableId() {
		return( requiredTableId );
	}

	public void setRequiredTableId( long value ) {
		if( value < CFBamTableColBuff.TABLEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTableId",
				1,
				"value",
				value,
				CFBamTableColBuff.TABLEID_MIN_VALUE );
		}
		requiredTableId = value;
	}

	public String getOptionalDbName() {
		return( optionalDbName );
	}

	public void setOptionalDbName( String value ) {
		if( value == null ) {
			optionalDbName = null;
		}
		else if( value.length() > 32 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalDbName",
				1,
				"value.length()",
				value.length(),
				32 );
		}
		else {
			optionalDbName = value;
		}
	}

	public Long getOptionalDataTenantId() {
		return( optionalDataTenantId );
	}

	public void setOptionalDataTenantId( Long value ) {
		if( value == null ) {
			optionalDataTenantId = null;
		}
		else if( value < CFBamTableColBuff.DATATENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalDataTenantId",
				1,
				"value",
				value,
				CFBamTableColBuff.DATATENANTID_MIN_VALUE );
		}
		else {
			optionalDataTenantId = value;
		}
	}

	public Long getOptionalDataId() {
		return( optionalDataId );
	}

	public void setOptionalDataId( Long value ) {
		if( value == null ) {
			optionalDataId = null;
		}
		else if( value < CFBamTableColBuff.DATAID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalDataId",
				1,
				"value",
				value,
				CFBamTableColBuff.DATAID_MIN_VALUE );
		}
		else {
			optionalDataId = value;
		}
	}

	public String getOptionalXmlElementName() {
		return( optionalXmlElementName );
	}

	public void setOptionalXmlElementName( String value ) {
		if( value == null ) {
			optionalXmlElementName = null;
		}
		else if( value.length() > 192 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalXmlElementName",
				1,
				"value.length()",
				value.length(),
				192 );
		}
		else {
			optionalXmlElementName = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamTableColBuff ) {
			CFBamTableColBuff rhs = (CFBamTableColBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredTableId() != rhs.getRequiredTableId() ) {
				return( false );
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					if( ! getOptionalDbName().equals( rhs.getOptionalDbName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( false );
				}
			}
			if( getOptionalDataTenantId() != null ) {
				if( rhs.getOptionalDataTenantId() != null ) {
					if( ! getOptionalDataTenantId().equals( rhs.getOptionalDataTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDataTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDataId() != null ) {
				if( rhs.getOptionalDataId() != null ) {
					if( ! getOptionalDataId().equals( rhs.getOptionalDataId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDataId() != null ) {
					return( false );
				}
			}
			if( getOptionalXmlElementName() != null ) {
				if( rhs.getOptionalXmlElementName() != null ) {
					if( ! getOptionalXmlElementName().equals( rhs.getOptionalXmlElementName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalXmlElementName() != null ) {
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
		else if( obj instanceof CFBamTableColHBuff ) {
			CFBamTableColHBuff rhs = (CFBamTableColHBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredTableId() != rhs.getRequiredTableId() ) {
				return( false );
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					if( ! getOptionalDbName().equals( rhs.getOptionalDbName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( false );
				}
			}
			if( getOptionalDataTenantId() != null ) {
				if( rhs.getOptionalDataTenantId() != null ) {
					if( ! getOptionalDataTenantId().equals( rhs.getOptionalDataTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDataTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDataId() != null ) {
				if( rhs.getOptionalDataId() != null ) {
					if( ! getOptionalDataId().equals( rhs.getOptionalDataId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDataId() != null ) {
					return( false );
				}
			}
			if( getOptionalXmlElementName() != null ) {
				if( rhs.getOptionalXmlElementName() != null ) {
					if( ! getOptionalXmlElementName().equals( rhs.getOptionalXmlElementName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalXmlElementName() != null ) {
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
		else if( obj instanceof CFBamTableColByTableIdxKey ) {
			CFBamTableColByTableIdxKey rhs = (CFBamTableColByTableIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTableId() != rhs.getRequiredTableId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTableColByDataIdxKey ) {
			CFBamTableColByDataIdxKey rhs = (CFBamTableColByDataIdxKey)obj;
			if( getOptionalDataTenantId() != null ) {
				if( rhs.getOptionalDataTenantId() != null ) {
					if( ! getOptionalDataTenantId().equals( rhs.getOptionalDataTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDataTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDataId() != null ) {
				if( rhs.getOptionalDataId() != null ) {
					if( ! getOptionalDataId().equals( rhs.getOptionalDataId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDataId() != null ) {
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
		int hashCode = super.hashCode();
		hashCode = hashCode + (int)( getRequiredTableId() );
		if( getOptionalDbName() != null ) {
			hashCode = hashCode + getOptionalDbName().hashCode();
		}
		if( getOptionalDataTenantId() != null ) {
			hashCode = hashCode + getOptionalDataTenantId().hashCode();
		}
		if( getOptionalDataId() != null ) {
			hashCode = hashCode + getOptionalDataId().hashCode();
		}
		if( getOptionalXmlElementName() != null ) {
			hashCode = hashCode + getOptionalXmlElementName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamTableColBuff ) {
			CFBamTableColBuff rhs = (CFBamTableColBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getRequiredTableId() < rhs.getRequiredTableId() ) {
				return( -1 );
			}
			else if( getRequiredTableId() > rhs.getRequiredTableId() ) {
				return( 1 );
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					int cmp = getOptionalDbName().compareTo( rhs.getOptionalDbName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDataTenantId() != null ) {
				Long lhsDataTenantId = getOptionalDataTenantId();
				if( rhs.getOptionalDataTenantId() != null ) {
					Long rhsDataTenantId = rhs.getOptionalDataTenantId();
					int cmp = lhsDataTenantId.compareTo( rhsDataTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDataTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDataId() != null ) {
				Long lhsDataId = getOptionalDataId();
				if( rhs.getOptionalDataId() != null ) {
					Long rhsDataId = rhs.getOptionalDataId();
					int cmp = lhsDataId.compareTo( rhsDataId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDataId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalXmlElementName() != null ) {
				if( rhs.getOptionalXmlElementName() != null ) {
					int cmp = getOptionalXmlElementName().compareTo( rhs.getOptionalXmlElementName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalXmlElementName() != null ) {
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
		else if( obj instanceof CFBamTableColHBuff ) {
			CFBamTableColHBuff rhs = (CFBamTableColHBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getRequiredTableId() < rhs.getRequiredTableId() ) {
				return( -1 );
			}
			else if( getRequiredTableId() > rhs.getRequiredTableId() ) {
				return( 1 );
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					int cmp = getOptionalDbName().compareTo( rhs.getOptionalDbName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDataTenantId() != null ) {
				Long lhsDataTenantId = getOptionalDataTenantId();
				if( rhs.getOptionalDataTenantId() != null ) {
					Long rhsDataTenantId = rhs.getOptionalDataTenantId();
					int cmp = lhsDataTenantId.compareTo( rhsDataTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDataTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDataId() != null ) {
				Long lhsDataId = getOptionalDataId();
				if( rhs.getOptionalDataId() != null ) {
					Long rhsDataId = rhs.getOptionalDataId();
					int cmp = lhsDataId.compareTo( rhsDataId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDataId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalXmlElementName() != null ) {
				if( rhs.getOptionalXmlElementName() != null ) {
					int cmp = getOptionalXmlElementName().compareTo( rhs.getOptionalXmlElementName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalXmlElementName() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamTableColByTableIdxKey ) {
			CFBamTableColByTableIdxKey rhs = (CFBamTableColByTableIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredTableId() < rhs.getRequiredTableId() ) {
				return( -1 );
			}
			else if( getRequiredTableId() > rhs.getRequiredTableId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableColByDataIdxKey ) {
			CFBamTableColByDataIdxKey rhs = (CFBamTableColByDataIdxKey)obj;

			if( getOptionalDataTenantId() != null ) {
				Long lhsDataTenantId = getOptionalDataTenantId();
				if( rhs.getOptionalDataTenantId() != null ) {
					Long rhsDataTenantId = rhs.getOptionalDataTenantId();
					int cmp = lhsDataTenantId.compareTo( rhsDataTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDataTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDataId() != null ) {
				Long lhsDataId = getOptionalDataId();
				if( rhs.getOptionalDataId() != null ) {
					Long rhsDataId = rhs.getOptionalDataId();
					int cmp = lhsDataId.compareTo( rhsDataId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDataId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else {
			int retval = super.compareTo( obj );
			return( retval );
		}
	}

	public void set( CFBamValueBuff src ) {
		if( src instanceof CFBamTableColBuff ) {
			setTableColBuff( (CFBamTableColBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamTableColBuff" );
		}
	}

	public void setTableColBuff( CFBamTableColBuff src ) {
		super.setValueBuff( src );
		setRequiredTableId( src.getRequiredTableId() );
		setOptionalDbName( src.getOptionalDbName() );
		setOptionalDataTenantId( src.getOptionalDataTenantId() );
		setOptionalDataId( src.getOptionalDataId() );
		setOptionalXmlElementName( src.getOptionalXmlElementName() );
	}

	public void set( CFBamValueHBuff src ) {
		if( src instanceof CFBamTableColHBuff ) {
			setTableColBuff( (CFBamTableColHBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamTableColHBuff" );
		}
	}

	public void setTableColBuff( CFBamTableColHBuff src ) {
		super.setValueBuff( src );
		setRequiredTableId( src.getRequiredTableId() );
		setOptionalDbName( src.getOptionalDbName() );
		setOptionalDataTenantId( src.getOptionalDataTenantId() );
		setOptionalDataId( src.getOptionalDataId() );
		setOptionalXmlElementName( src.getOptionalXmlElementName() );
	}
}
