// Description: Java 11 implementation of a DelSubDep1 buffer object.

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

public class CFBamDelSubDep1Buff
	extends CFBamDelDepBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "DEL1";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final long DELTOPDEPTENANTID_INIT_VALUE = 0L;
	public static final long DELTOPDEPID_INIT_VALUE = 0L;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final long DELTOPDEPTENANTID_MIN_VALUE = 0L;
	public static final long DELTOPDEPID_MIN_VALUE = 0L;
	protected long requiredDelTopDepTenantId;
	protected long requiredDelTopDepId;
	protected String requiredName;
	public CFBamDelSubDep1Buff() {
		super();
		requiredDelTopDepTenantId = CFBamDelSubDep1Buff.DELTOPDEPTENANTID_INIT_VALUE;
		requiredDelTopDepId = CFBamDelSubDep1Buff.DELTOPDEPID_INIT_VALUE;
		requiredName = new String( CFBamDelSubDep1Buff.NAME_INIT_VALUE );
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public long getRequiredDelTopDepTenantId() {
		return( requiredDelTopDepTenantId );
	}

	public void setRequiredDelTopDepTenantId( long value ) {
		if( value < CFBamDelSubDep1Buff.DELTOPDEPTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredDelTopDepTenantId",
				1,
				"value",
				value,
				CFBamDelSubDep1Buff.DELTOPDEPTENANTID_MIN_VALUE );
		}
		requiredDelTopDepTenantId = value;
	}

	public long getRequiredDelTopDepId() {
		return( requiredDelTopDepId );
	}

	public void setRequiredDelTopDepId( long value ) {
		if( value < CFBamDelSubDep1Buff.DELTOPDEPID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredDelTopDepId",
				1,
				"value",
				value,
				CFBamDelSubDep1Buff.DELTOPDEPID_MIN_VALUE );
		}
		requiredDelTopDepId = value;
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
		if( value.length() > 192 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				192 );
		}
		requiredName = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamDelSubDep1Buff ) {
			CFBamDelSubDep1Buff rhs = (CFBamDelSubDep1Buff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredDelTopDepTenantId() != rhs.getRequiredDelTopDepTenantId() ) {
				return( false );
			}
			if( getRequiredDelTopDepId() != rhs.getRequiredDelTopDepId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamScopePKey ) {
			CFBamScopePKey rhs = (CFBamScopePKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamDelSubDep1HBuff ) {
			CFBamDelSubDep1HBuff rhs = (CFBamDelSubDep1HBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredDelTopDepTenantId() != rhs.getRequiredDelTopDepTenantId() ) {
				return( false );
			}
			if( getRequiredDelTopDepId() != rhs.getRequiredDelTopDepId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamScopeHPKey ) {
			CFBamScopeHPKey rhs = (CFBamScopeHPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamDelSubDep1ByDelTopDepIdxKey ) {
			CFBamDelSubDep1ByDelTopDepIdxKey rhs = (CFBamDelSubDep1ByDelTopDepIdxKey)obj;
			if( getRequiredDelTopDepTenantId() != rhs.getRequiredDelTopDepTenantId() ) {
				return( false );
			}
			if( getRequiredDelTopDepId() != rhs.getRequiredDelTopDepId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamDelSubDep1ByUNameIdxKey ) {
			CFBamDelSubDep1ByUNameIdxKey rhs = (CFBamDelSubDep1ByUNameIdxKey)obj;
			if( getRequiredDelTopDepTenantId() != rhs.getRequiredDelTopDepTenantId() ) {
				return( false );
			}
			if( getRequiredDelTopDepId() != rhs.getRequiredDelTopDepId() ) {
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
		int hashCode = super.hashCode();
		hashCode = hashCode + (int)( getRequiredDelTopDepTenantId() );
		hashCode = hashCode + (int)( getRequiredDelTopDepId() );
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamDelSubDep1Buff ) {
			CFBamDelSubDep1Buff rhs = (CFBamDelSubDep1Buff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getRequiredDelTopDepTenantId() < rhs.getRequiredDelTopDepTenantId() ) {
				return( -1 );
			}
			else if( getRequiredDelTopDepTenantId() > rhs.getRequiredDelTopDepTenantId() ) {
				return( 1 );
			}
			if( getRequiredDelTopDepId() < rhs.getRequiredDelTopDepId() ) {
				return( -1 );
			}
			else if( getRequiredDelTopDepId() > rhs.getRequiredDelTopDepId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamScopePKey ) {
			CFBamScopePKey rhs = (CFBamScopePKey)obj;
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
		else if( obj instanceof CFBamScopeHPKey ) {
			CFBamScopeHPKey rhs = (CFBamScopeHPKey)obj;
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
		else if( obj instanceof CFBamDelSubDep1HBuff ) {
			CFBamDelSubDep1HBuff rhs = (CFBamDelSubDep1HBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getRequiredDelTopDepTenantId() < rhs.getRequiredDelTopDepTenantId() ) {
				return( -1 );
			}
			else if( getRequiredDelTopDepTenantId() > rhs.getRequiredDelTopDepTenantId() ) {
				return( 1 );
			}
			if( getRequiredDelTopDepId() < rhs.getRequiredDelTopDepId() ) {
				return( -1 );
			}
			else if( getRequiredDelTopDepId() > rhs.getRequiredDelTopDepId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamDelSubDep1ByDelTopDepIdxKey ) {
			CFBamDelSubDep1ByDelTopDepIdxKey rhs = (CFBamDelSubDep1ByDelTopDepIdxKey)obj;

			if( getRequiredDelTopDepTenantId() < rhs.getRequiredDelTopDepTenantId() ) {
				return( -1 );
			}
			else if( getRequiredDelTopDepTenantId() > rhs.getRequiredDelTopDepTenantId() ) {
				return( 1 );
			}
			if( getRequiredDelTopDepId() < rhs.getRequiredDelTopDepId() ) {
				return( -1 );
			}
			else if( getRequiredDelTopDepId() > rhs.getRequiredDelTopDepId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamDelSubDep1ByUNameIdxKey ) {
			CFBamDelSubDep1ByUNameIdxKey rhs = (CFBamDelSubDep1ByUNameIdxKey)obj;

			if( getRequiredDelTopDepTenantId() < rhs.getRequiredDelTopDepTenantId() ) {
				return( -1 );
			}
			else if( getRequiredDelTopDepTenantId() > rhs.getRequiredDelTopDepTenantId() ) {
				return( 1 );
			}
			if( getRequiredDelTopDepId() < rhs.getRequiredDelTopDepId() ) {
				return( -1 );
			}
			else if( getRequiredDelTopDepId() > rhs.getRequiredDelTopDepId() ) {
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
			int retval = super.compareTo( obj );
			return( retval );
		}
	}

	public void set( CFBamScopeBuff src ) {
		if( src instanceof CFBamDelSubDep1Buff ) {
			setDelSubDep1Buff( (CFBamDelSubDep1Buff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamDelSubDep1Buff" );
		}
	}

	public void setDelSubDep1Buff( CFBamDelSubDep1Buff src ) {
		super.setDelDepBuff( src );
		setRequiredDelTopDepTenantId( src.getRequiredDelTopDepTenantId() );
		setRequiredDelTopDepId( src.getRequiredDelTopDepId() );
		setRequiredName( src.getRequiredName() );
	}

	public void set( CFBamScopeHBuff src ) {
		if( src instanceof CFBamDelSubDep1HBuff ) {
			setDelSubDep1Buff( (CFBamDelSubDep1HBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamDelSubDep1HBuff" );
		}
	}

	public void setDelSubDep1Buff( CFBamDelSubDep1HBuff src ) {
		super.setDelDepBuff( src );
		setRequiredDelTopDepTenantId( src.getRequiredDelTopDepTenantId() );
		setRequiredDelTopDepId( src.getRequiredDelTopDepId() );
		setRequiredName( src.getRequiredName() );
	}
}
