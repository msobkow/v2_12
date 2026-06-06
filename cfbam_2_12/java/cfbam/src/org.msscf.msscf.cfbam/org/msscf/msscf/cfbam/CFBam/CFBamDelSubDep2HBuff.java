// Description: Java 11 implementation of a DelSubDep2 history buffer object.

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

public class CFBamDelSubDep2HBuff
	extends CFBamDelDepHBuff
	implements Comparable<Object>,
		Serializable
{
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final long DELSUBDEP1TENANTID_INIT_VALUE = 0L;
	public static final long DELSUBDEP1ID_INIT_VALUE = 0L;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final long DELSUBDEP1TENANTID_MIN_VALUE = 0L;
	public static final long DELSUBDEP1ID_MIN_VALUE = 0L;

	protected long requiredDelSubDep1TenantId;
	protected long requiredDelSubDep1Id;
	protected String requiredName;
	public CFBamDelSubDep2HBuff() {
		super();
		requiredDelSubDep1TenantId = CFBamDelSubDep2Buff.DELSUBDEP1TENANTID_INIT_VALUE;
		requiredDelSubDep1Id = CFBamDelSubDep2Buff.DELSUBDEP1ID_INIT_VALUE;
		requiredName = new String( CFBamDelSubDep2Buff.NAME_INIT_VALUE );
	}

	public String getClassCode() {
		return( CFBamDelSubDep2Buff.CLASS_CODE );
	}

	public long getRequiredDelSubDep1TenantId() {
		return( requiredDelSubDep1TenantId );
	}

	public void setRequiredDelSubDep1TenantId( long value ) {
		if( value < CFBamDelSubDep2Buff.DELSUBDEP1TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredDelSubDep1TenantId",
				1,
				"value",
				value,
				CFBamDelSubDep2Buff.DELSUBDEP1TENANTID_MIN_VALUE );
		}
		requiredDelSubDep1TenantId = value;
	}

	public long getRequiredDelSubDep1Id() {
		return( requiredDelSubDep1Id );
	}

	public void setRequiredDelSubDep1Id( long value ) {
		if( value < CFBamDelSubDep2Buff.DELSUBDEP1ID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredDelSubDep1Id",
				1,
				"value",
				value,
				CFBamDelSubDep2Buff.DELSUBDEP1ID_MIN_VALUE );
		}
		requiredDelSubDep1Id = value;
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
		else if( obj instanceof CFBamDelSubDep2HBuff ) {
			CFBamDelSubDep2HBuff rhs = (CFBamDelSubDep2HBuff)obj;
			if( ! super.equals( obj ) ) {
				return( false );
			}
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredDelSubDep1TenantId() != rhs.getRequiredDelSubDep1TenantId() ) {
				return( false );
			}
			if( getRequiredDelSubDep1Id() != rhs.getRequiredDelSubDep1Id() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamDelSubDep2Buff ) {
			CFBamDelSubDep2Buff rhs = (CFBamDelSubDep2Buff)obj;
			if( ! super.equals( obj ) ) {
				return( false );
			}
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredDelSubDep1TenantId() != rhs.getRequiredDelSubDep1TenantId() ) {
				return( false );
			}
			if( getRequiredDelSubDep1Id() != rhs.getRequiredDelSubDep1Id() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamDelSubDep2ByContDelDep1IdxKey ) {
			CFBamDelSubDep2ByContDelDep1IdxKey rhs = (CFBamDelSubDep2ByContDelDep1IdxKey)obj;
			if( getRequiredDelSubDep1TenantId() != rhs.getRequiredDelSubDep1TenantId() ) {
				return( false );
			}
			if( getRequiredDelSubDep1Id() != rhs.getRequiredDelSubDep1Id() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamDelSubDep2ByUNameIdxKey ) {
			CFBamDelSubDep2ByUNameIdxKey rhs = (CFBamDelSubDep2ByUNameIdxKey)obj;
			if( getRequiredDelSubDep1TenantId() != rhs.getRequiredDelSubDep1TenantId() ) {
				return( false );
			}
			if( getRequiredDelSubDep1Id() != rhs.getRequiredDelSubDep1Id() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else {
			return( super.equals( obj ) );
		}
	}

	public int hashCode() {
		int hashCode = super.hashCode();
		hashCode = hashCode + (int)( getRequiredDelSubDep1TenantId() );
		hashCode = hashCode + (int)( getRequiredDelSubDep1Id() );
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamDelSubDep2Buff ) {
			CFBamDelSubDep2Buff rhs = (CFBamDelSubDep2Buff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamDelSubDep2ByContDelDep1IdxKey ) {
			CFBamDelSubDep2ByContDelDep1IdxKey rhs = (CFBamDelSubDep2ByContDelDep1IdxKey)obj;

			if( getRequiredDelSubDep1TenantId() < rhs.getRequiredDelSubDep1TenantId() ) {
				return( -1 );
			}
			else if( getRequiredDelSubDep1TenantId() > rhs.getRequiredDelSubDep1TenantId() ) {
				return( 1 );
			}
			if( getRequiredDelSubDep1Id() < rhs.getRequiredDelSubDep1Id() ) {
				return( -1 );
			}
			else if( getRequiredDelSubDep1Id() > rhs.getRequiredDelSubDep1Id() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamDelSubDep2ByUNameIdxKey ) {
			CFBamDelSubDep2ByUNameIdxKey rhs = (CFBamDelSubDep2ByUNameIdxKey)obj;

			if( getRequiredDelSubDep1TenantId() < rhs.getRequiredDelSubDep1TenantId() ) {
				return( -1 );
			}
			else if( getRequiredDelSubDep1TenantId() > rhs.getRequiredDelSubDep1TenantId() ) {
				return( 1 );
			}
			if( getRequiredDelSubDep1Id() < rhs.getRequiredDelSubDep1Id() ) {
				return( -1 );
			}
			else if( getRequiredDelSubDep1Id() > rhs.getRequiredDelSubDep1Id() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamDelSubDep2HBuff ) {
			CFBamDelSubDep2HBuff rhs = (CFBamDelSubDep2HBuff)obj;

			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			{
				long lhsAuditClusterId = getAuditClusterId();
				long rhsAuditClusterId = rhs.getAuditClusterId();
				if( lhsAuditClusterId < rhsAuditClusterId ) {
					return( -1 );
				}
				else if( lhsAuditClusterId > rhsAuditClusterId ) {
					return( 1 );
				}
			}
			{
				Calendar lhsAuditStamp = getAuditStamp();
				Calendar rhsAuditStamp = rhs.getAuditStamp();
				if( lhsAuditStamp == null ) {
					if( rhsAuditStamp != null ) {
						return( -1 );
					}
				}
				else if( rhsAuditStamp == null ) {
					return( 1 );
				}
				else {
					int cmpstat = lhsAuditStamp.compareTo( rhsAuditStamp );
					if( cmpstat != 0 ) {
						return( cmpstat );
					}
				}
			}
			{
				short lhsAuditActionId = getAuditActionId();
				short rhsAuditActionId = rhs.getAuditActionId();
				if( lhsAuditActionId < rhsAuditActionId ) {
					return( -1 );
				}
				else if( lhsAuditActionId > rhsAuditActionId ) {
					return( 1 );
				}
			}
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
			{
				UUID lhsAuditSessionId = getAuditSessionId();
				UUID rhsAuditSessionId = rhs.getAuditSessionId();
				if( lhsAuditSessionId == null ) {
					if( rhsAuditSessionId != null ) {
						return( -1 );
					}
				}
				else if( rhsAuditSessionId == null ) {
					return( 1 );
				}
				else {
					int cmpstat = lhsAuditSessionId.compareTo( rhsAuditSessionId );
					if( cmpstat != 0 ) {
						return( cmpstat );
					}
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
			if( getOptionalDefSchemaTenantId() != null ) {
				Long lhsDefSchemaTenantId = getOptionalDefSchemaTenantId();
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					Long rhsDefSchemaTenantId = rhs.getOptionalDefSchemaTenantId();
					int cmp = lhsDefSchemaTenantId.compareTo( rhsDefSchemaTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				Long lhsDefSchemaId = getOptionalDefSchemaId();
				if( rhs.getOptionalDefSchemaId() != null ) {
					Long rhsDefSchemaId = rhs.getOptionalDefSchemaId();
					int cmp = lhsDefSchemaId.compareTo( rhsDefSchemaId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			if( getRequiredRelationTenantId() < rhs.getRequiredRelationTenantId() ) {
				return( -1 );
			}
			else if( getRequiredRelationTenantId() > rhs.getRequiredRelationTenantId() ) {
				return( 1 );
			}
			if( getRequiredRelationId() < rhs.getRequiredRelationId() ) {
				return( -1 );
			}
			else if( getRequiredRelationId() > rhs.getRequiredRelationId() ) {
				return( 1 );
			}
			if( getRequiredDelSubDep1TenantId() < rhs.getRequiredDelSubDep1TenantId() ) {
				return( -1 );
			}
			else if( getRequiredDelSubDep1TenantId() > rhs.getRequiredDelSubDep1TenantId() ) {
				return( 1 );
			}
			if( getRequiredDelSubDep1Id() < rhs.getRequiredDelSubDep1Id() ) {
				return( -1 );
			}
			else if( getRequiredDelSubDep1Id() > rhs.getRequiredDelSubDep1Id() ) {
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
		else {
			return( super.compareTo( obj ) );
		}
	}

	public void set( CFBamScopeBuff src ) {
		if( src instanceof CFBamDelSubDep2Buff ) {
			setDelSubDep2Buff( (CFBamDelSubDep2Buff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamDelSubDep2Buff" );
		}
	}

	public void setDelSubDep2Buff( CFBamDelSubDep2Buff src ) {
		super.setDelDepBuff( src );
		setRequiredDelSubDep1TenantId( src.getRequiredDelSubDep1TenantId() );
		setRequiredDelSubDep1Id( src.getRequiredDelSubDep1Id() );
		setRequiredName( src.getRequiredName() );
	}

	public void set( CFBamScopeHBuff src ) {
		if( src instanceof CFBamDelSubDep2HBuff ) {
			setDelSubDep2Buff( (CFBamDelSubDep2HBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamDelSubDep2HBuff" );
		}
	}

	public void setDelSubDep2Buff( CFBamDelSubDep2HBuff src ) {
		super.setDelDepBuff( src );
		setRequiredDelSubDep1TenantId( src.getRequiredDelSubDep1TenantId() );
		setRequiredDelSubDep1Id( src.getRequiredDelSubDep1Id() );
		setRequiredName( src.getRequiredName() );
	}
}
