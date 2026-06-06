// Description: Java 11 implementation of a ServerListFunc buffer object.

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

public class CFBamServerListFuncBuff
	extends CFBamServerMethodBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "SRVL";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final long RETTENANTID_INIT_VALUE = 0L;
	public static final long RETTABLEID_INIT_VALUE = 0L;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final long RETTENANTID_MIN_VALUE = 0L;
	public static final long RETTABLEID_MIN_VALUE = 0L;
	protected Long optionalRetTenantId;
	protected Long optionalRetTableId;
	public CFBamServerListFuncBuff() {
		super();
		optionalRetTenantId = null;
		optionalRetTableId = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public Long getOptionalRetTenantId() {
		return( optionalRetTenantId );
	}

	public void setOptionalRetTenantId( Long value ) {
		if( value == null ) {
			optionalRetTenantId = null;
		}
		else if( value < CFBamServerListFuncBuff.RETTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalRetTenantId",
				1,
				"value",
				value,
				CFBamServerListFuncBuff.RETTENANTID_MIN_VALUE );
		}
		else {
			optionalRetTenantId = value;
		}
	}

	public Long getOptionalRetTableId() {
		return( optionalRetTableId );
	}

	public void setOptionalRetTableId( Long value ) {
		if( value == null ) {
			optionalRetTableId = null;
		}
		else if( value < CFBamServerListFuncBuff.RETTABLEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalRetTableId",
				1,
				"value",
				value,
				CFBamServerListFuncBuff.RETTABLEID_MIN_VALUE );
		}
		else {
			optionalRetTableId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamServerListFuncBuff ) {
			CFBamServerListFuncBuff rhs = (CFBamServerListFuncBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getOptionalRetTenantId() != null ) {
				if( rhs.getOptionalRetTenantId() != null ) {
					if( ! getOptionalRetTenantId().equals( rhs.getOptionalRetTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRetTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalRetTableId() != null ) {
				if( rhs.getOptionalRetTableId() != null ) {
					if( ! getOptionalRetTableId().equals( rhs.getOptionalRetTableId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRetTableId() != null ) {
					return( false );
				}
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
		else if( obj instanceof CFBamServerListFuncHBuff ) {
			CFBamServerListFuncHBuff rhs = (CFBamServerListFuncHBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getOptionalRetTenantId() != null ) {
				if( rhs.getOptionalRetTenantId() != null ) {
					if( ! getOptionalRetTenantId().equals( rhs.getOptionalRetTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRetTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalRetTableId() != null ) {
				if( rhs.getOptionalRetTableId() != null ) {
					if( ! getOptionalRetTableId().equals( rhs.getOptionalRetTableId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRetTableId() != null ) {
					return( false );
				}
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
		else if( obj instanceof CFBamServerListFuncByRetTblIdxKey ) {
			CFBamServerListFuncByRetTblIdxKey rhs = (CFBamServerListFuncByRetTblIdxKey)obj;
			if( getOptionalRetTenantId() != null ) {
				if( rhs.getOptionalRetTenantId() != null ) {
					if( ! getOptionalRetTenantId().equals( rhs.getOptionalRetTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRetTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalRetTableId() != null ) {
				if( rhs.getOptionalRetTableId() != null ) {
					if( ! getOptionalRetTableId().equals( rhs.getOptionalRetTableId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRetTableId() != null ) {
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
		if( getOptionalRetTenantId() != null ) {
			hashCode = hashCode + getOptionalRetTenantId().hashCode();
		}
		if( getOptionalRetTableId() != null ) {
			hashCode = hashCode + getOptionalRetTableId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamServerListFuncBuff ) {
			CFBamServerListFuncBuff rhs = (CFBamServerListFuncBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalRetTenantId() != null ) {
				Long lhsRetTenantId = getOptionalRetTenantId();
				if( rhs.getOptionalRetTenantId() != null ) {
					Long rhsRetTenantId = rhs.getOptionalRetTenantId();
					int cmp = lhsRetTenantId.compareTo( rhsRetTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRetTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalRetTableId() != null ) {
				Long lhsRetTableId = getOptionalRetTableId();
				if( rhs.getOptionalRetTableId() != null ) {
					Long rhsRetTableId = rhs.getOptionalRetTableId();
					int cmp = lhsRetTableId.compareTo( rhsRetTableId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRetTableId() != null ) {
					return( -1 );
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
		else if( obj instanceof CFBamServerListFuncHBuff ) {
			CFBamServerListFuncHBuff rhs = (CFBamServerListFuncHBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalRetTenantId() != null ) {
				Long lhsRetTenantId = getOptionalRetTenantId();
				if( rhs.getOptionalRetTenantId() != null ) {
					Long rhsRetTenantId = rhs.getOptionalRetTenantId();
					int cmp = lhsRetTenantId.compareTo( rhsRetTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRetTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalRetTableId() != null ) {
				Long lhsRetTableId = getOptionalRetTableId();
				if( rhs.getOptionalRetTableId() != null ) {
					Long rhsRetTableId = rhs.getOptionalRetTableId();
					int cmp = lhsRetTableId.compareTo( rhsRetTableId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRetTableId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamServerListFuncByRetTblIdxKey ) {
			CFBamServerListFuncByRetTblIdxKey rhs = (CFBamServerListFuncByRetTblIdxKey)obj;

			if( getOptionalRetTenantId() != null ) {
				Long lhsRetTenantId = getOptionalRetTenantId();
				if( rhs.getOptionalRetTenantId() != null ) {
					Long rhsRetTenantId = rhs.getOptionalRetTenantId();
					int cmp = lhsRetTenantId.compareTo( rhsRetTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRetTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalRetTableId() != null ) {
				Long lhsRetTableId = getOptionalRetTableId();
				if( rhs.getOptionalRetTableId() != null ) {
					Long rhsRetTableId = rhs.getOptionalRetTableId();
					int cmp = lhsRetTableId.compareTo( rhsRetTableId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRetTableId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else {
			int retval = super.compareTo( obj );
			return( retval );
		}
	}

	public void set( CFBamScopeBuff src ) {
		if( src instanceof CFBamServerListFuncBuff ) {
			setServerListFuncBuff( (CFBamServerListFuncBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamServerListFuncBuff" );
		}
	}

	public void setServerListFuncBuff( CFBamServerListFuncBuff src ) {
		super.setServerMethodBuff( src );
		setOptionalRetTenantId( src.getOptionalRetTenantId() );
		setOptionalRetTableId( src.getOptionalRetTableId() );
	}

	public void set( CFBamScopeHBuff src ) {
		if( src instanceof CFBamServerListFuncHBuff ) {
			setServerListFuncBuff( (CFBamServerListFuncHBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamServerListFuncHBuff" );
		}
	}

	public void setServerListFuncBuff( CFBamServerListFuncHBuff src ) {
		super.setServerMethodBuff( src );
		setOptionalRetTenantId( src.getOptionalRetTenantId() );
		setOptionalRetTableId( src.getOptionalRetTableId() );
	}
}
