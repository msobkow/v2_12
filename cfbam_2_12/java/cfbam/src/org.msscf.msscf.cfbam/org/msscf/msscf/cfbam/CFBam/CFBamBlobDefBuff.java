// Description: Java 11 implementation of a BlobDef buffer object.

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

public class CFBamBlobDefBuff
	extends CFBamAtomBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "BLBD";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final int MAXLEN_INIT_VALUE = 100000000;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final int MAXLEN_MIN_VALUE = 1;
	public static final int MAXLEN_MAX_VALUE = 2147483647;
	protected int requiredMaxLen;
	protected byte[] optionalInitValue;
	public CFBamBlobDefBuff() {
		super();
		requiredMaxLen = CFBamBlobDefBuff.MAXLEN_INIT_VALUE;
		optionalInitValue = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public int getRequiredMaxLen() {
		return( requiredMaxLen );
	}

	public void setRequiredMaxLen( int value ) {
		if( value < CFBamBlobDefBuff.MAXLEN_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredMaxLen",
				1,
				"value",
				value,
				CFBamBlobDefBuff.MAXLEN_MIN_VALUE );
		}
		if( value > CFBamBlobDefBuff.MAXLEN_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredMaxLen",
				1,
				"value",
				value,
				CFBamBlobDefBuff.MAXLEN_MAX_VALUE );
		}
		requiredMaxLen = value;
	}

	public byte[] getOptionalInitValue() {
		return( optionalInitValue );
	}

	public void setOptionalInitValue( byte[] value ) {
		if( value == null ) {
			optionalInitValue = null;
		}
		else if( value.length > 16384 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalInitValue",
				1,
				"value.length",
				value.length,
				16384 );
		}
		else {
			optionalInitValue = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamBlobDefBuff ) {
			CFBamBlobDefBuff rhs = (CFBamBlobDefBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredMaxLen() != rhs.getRequiredMaxLen() ) {
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
		else if( obj instanceof CFBamBlobDefHBuff ) {
			CFBamBlobDefHBuff rhs = (CFBamBlobDefHBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredMaxLen() != rhs.getRequiredMaxLen() ) {
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
		hashCode = hashCode + getRequiredMaxLen();
		if( getOptionalInitValue() != null ) {
			hashCode = hashCode + getOptionalInitValue().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamBlobDefBuff ) {
			CFBamBlobDefBuff rhs = (CFBamBlobDefBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getRequiredMaxLen() < rhs.getRequiredMaxLen() ) {
				return( -1 );
			}
			else if( getRequiredMaxLen() > rhs.getRequiredMaxLen() ) {
				return( 1 );
			}
			if( getOptionalInitValue() != null ) {
				if( rhs.getOptionalInitValue() != null ) {
					byte[] larr = getOptionalInitValue();
					byte[] rarr = rhs.getOptionalInitValue();
					int llen = larr.length;
					int rlen = rarr.length;
					int idx = 0;
					byte lval;
					byte rval;
					while( ( idx < llen ) && ( idx < rlen ) ) {
						lval = larr[idx];
						rval = rarr[idx];
						if( lval < rval ) {
							return( -1 );
						}
						else if( lval > rval ) {
							return( 1 );
						}
						idx ++;
					}
					if( llen < rlen ) {
						return( -1 );
					}
					else if( llen > rlen ) {
						return( 1 );
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
		else if( obj instanceof CFBamBlobDefHBuff ) {
			CFBamBlobDefHBuff rhs = (CFBamBlobDefHBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getRequiredMaxLen() < rhs.getRequiredMaxLen() ) {
				return( -1 );
			}
			else if( getRequiredMaxLen() > rhs.getRequiredMaxLen() ) {
				return( 1 );
			}
			if( getOptionalInitValue() != null ) {
				if( rhs.getOptionalInitValue() != null ) {
					byte[] larr = getOptionalInitValue();
					byte[] rarr = rhs.getOptionalInitValue();
					int llen = larr.length;
					int rlen = rarr.length;
					int idx = 0;
					byte lval;
					byte rval;
					while( ( idx < llen ) && ( idx < rlen ) ) {
						lval = larr[idx];
						rval = rarr[idx];
						if( lval < rval ) {
							return( -1 );
						}
						else if( lval > rval ) {
							return( 1 );
						}
						idx ++;
					}
					if( llen < rlen ) {
						return( -1 );
					}
					else if( llen > rlen ) {
						return( 1 );
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
			return( 0 );
		}
		else {
			int retval = super.compareTo( obj );
			return( retval );
		}
	}

	public void set( CFBamValueBuff src ) {
		if( src instanceof CFBamBlobDefBuff ) {
			setBlobDefBuff( (CFBamBlobDefBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamBlobDefBuff" );
		}
	}

	public void setBlobDefBuff( CFBamBlobDefBuff src ) {
		super.setAtomBuff( src );
		setRequiredMaxLen( src.getRequiredMaxLen() );
		setOptionalInitValue( src.getOptionalInitValue() );
	}

	public void set( CFBamValueHBuff src ) {
		if( src instanceof CFBamBlobDefHBuff ) {
			setBlobDefBuff( (CFBamBlobDefHBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamBlobDefHBuff" );
		}
	}

	public void setBlobDefBuff( CFBamBlobDefHBuff src ) {
		super.setAtomBuff( src );
		setRequiredMaxLen( src.getRequiredMaxLen() );
		setOptionalInitValue( src.getOptionalInitValue() );
	}
}
