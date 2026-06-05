// Description: Java 11 implementation of a ClearSubDep3 history buffer object.

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

public class CFBamClearSubDep3HBuff
	extends CFBamClearDepHBuff
	implements Comparable<Object>,
		Serializable
{
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final long CLEARSUBDEP2TENANTID_INIT_VALUE = 0L;
	public static final long CLEARSUBDEP2ID_INIT_VALUE = 0L;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final long CLEARSUBDEP2TENANTID_MIN_VALUE = 0L;
	public static final long CLEARSUBDEP2ID_MIN_VALUE = 0L;

	protected long requiredClearSubDep2TenantId;
	protected long requiredClearSubDep2Id;
	protected String requiredName;
	public CFBamClearSubDep3HBuff() {
		super();
		requiredClearSubDep2TenantId = CFBamClearSubDep3Buff.CLEARSUBDEP2TENANTID_INIT_VALUE;
		requiredClearSubDep2Id = CFBamClearSubDep3Buff.CLEARSUBDEP2ID_INIT_VALUE;
		requiredName = new String( CFBamClearSubDep3Buff.NAME_INIT_VALUE );
	}

	public String getClassCode() {
		return( CFBamClearSubDep3Buff.CLASS_CODE );
	}

	public long getRequiredClearSubDep2TenantId() {
		return( requiredClearSubDep2TenantId );
	}

	public void setRequiredClearSubDep2TenantId( long value ) {
		if( value < CFBamClearSubDep3Buff.CLEARSUBDEP2TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredClearSubDep2TenantId",
				1,
				"value",
				value,
				CFBamClearSubDep3Buff.CLEARSUBDEP2TENANTID_MIN_VALUE );
		}
		requiredClearSubDep2TenantId = value;
	}

	public long getRequiredClearSubDep2Id() {
		return( requiredClearSubDep2Id );
	}

	public void setRequiredClearSubDep2Id( long value ) {
		if( value < CFBamClearSubDep3Buff.CLEARSUBDEP2ID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredClearSubDep2Id",
				1,
				"value",
				value,
				CFBamClearSubDep3Buff.CLEARSUBDEP2ID_MIN_VALUE );
		}
		requiredClearSubDep2Id = value;
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
		else if( obj instanceof CFBamClearSubDep3HBuff ) {
			CFBamClearSubDep3HBuff rhs = (CFBamClearSubDep3HBuff)obj;
			if( ! super.equals( obj ) ) {
				return( false );
			}
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredClearSubDep2TenantId() != rhs.getRequiredClearSubDep2TenantId() ) {
				return( false );
			}
			if( getRequiredClearSubDep2Id() != rhs.getRequiredClearSubDep2Id() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamClearSubDep3Buff ) {
			CFBamClearSubDep3Buff rhs = (CFBamClearSubDep3Buff)obj;
			if( ! super.equals( obj ) ) {
				return( false );
			}
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredClearSubDep2TenantId() != rhs.getRequiredClearSubDep2TenantId() ) {
				return( false );
			}
			if( getRequiredClearSubDep2Id() != rhs.getRequiredClearSubDep2Id() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamClearSubDep3ByClearSubDep2IdxKey ) {
			CFBamClearSubDep3ByClearSubDep2IdxKey rhs = (CFBamClearSubDep3ByClearSubDep2IdxKey)obj;
			if( getRequiredClearSubDep2TenantId() != rhs.getRequiredClearSubDep2TenantId() ) {
				return( false );
			}
			if( getRequiredClearSubDep2Id() != rhs.getRequiredClearSubDep2Id() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamClearSubDep3ByUNameIdxKey ) {
			CFBamClearSubDep3ByUNameIdxKey rhs = (CFBamClearSubDep3ByUNameIdxKey)obj;
			if( getRequiredClearSubDep2TenantId() != rhs.getRequiredClearSubDep2TenantId() ) {
				return( false );
			}
			if( getRequiredClearSubDep2Id() != rhs.getRequiredClearSubDep2Id() ) {
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
		hashCode = hashCode + (int)( getRequiredClearSubDep2TenantId() );
		hashCode = hashCode + (int)( getRequiredClearSubDep2Id() );
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamClearSubDep3Buff ) {
			CFBamClearSubDep3Buff rhs = (CFBamClearSubDep3Buff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamClearSubDep3ByClearSubDep2IdxKey ) {
			CFBamClearSubDep3ByClearSubDep2IdxKey rhs = (CFBamClearSubDep3ByClearSubDep2IdxKey)obj;

			if( getRequiredClearSubDep2TenantId() < rhs.getRequiredClearSubDep2TenantId() ) {
				return( -1 );
			}
			else if( getRequiredClearSubDep2TenantId() > rhs.getRequiredClearSubDep2TenantId() ) {
				return( 1 );
			}
			if( getRequiredClearSubDep2Id() < rhs.getRequiredClearSubDep2Id() ) {
				return( -1 );
			}
			else if( getRequiredClearSubDep2Id() > rhs.getRequiredClearSubDep2Id() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamClearSubDep3ByUNameIdxKey ) {
			CFBamClearSubDep3ByUNameIdxKey rhs = (CFBamClearSubDep3ByUNameIdxKey)obj;

			if( getRequiredClearSubDep2TenantId() < rhs.getRequiredClearSubDep2TenantId() ) {
				return( -1 );
			}
			else if( getRequiredClearSubDep2TenantId() > rhs.getRequiredClearSubDep2TenantId() ) {
				return( 1 );
			}
			if( getRequiredClearSubDep2Id() < rhs.getRequiredClearSubDep2Id() ) {
				return( -1 );
			}
			else if( getRequiredClearSubDep2Id() > rhs.getRequiredClearSubDep2Id() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamClearSubDep3HBuff ) {
			CFBamClearSubDep3HBuff rhs = (CFBamClearSubDep3HBuff)obj;

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
			if( getRequiredRelationId() < rhs.getRequiredRelationId() ) {
				return( -1 );
			}
			else if( getRequiredRelationId() > rhs.getRequiredRelationId() ) {
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
			if( getRequiredClearSubDep2TenantId() < rhs.getRequiredClearSubDep2TenantId() ) {
				return( -1 );
			}
			else if( getRequiredClearSubDep2TenantId() > rhs.getRequiredClearSubDep2TenantId() ) {
				return( 1 );
			}
			if( getRequiredClearSubDep2Id() < rhs.getRequiredClearSubDep2Id() ) {
				return( -1 );
			}
			else if( getRequiredClearSubDep2Id() > rhs.getRequiredClearSubDep2Id() ) {
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
		if( src instanceof CFBamClearSubDep3Buff ) {
			setClearSubDep3Buff( (CFBamClearSubDep3Buff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamClearSubDep3Buff" );
		}
	}

	public void setClearSubDep3Buff( CFBamClearSubDep3Buff src ) {
		super.setClearDepBuff( src );
		setRequiredClearSubDep2TenantId( src.getRequiredClearSubDep2TenantId() );
		setRequiredClearSubDep2Id( src.getRequiredClearSubDep2Id() );
		setRequiredName( src.getRequiredName() );
	}

	public void set( CFBamScopeHBuff src ) {
		if( src instanceof CFBamClearSubDep3HBuff ) {
			setClearSubDep3Buff( (CFBamClearSubDep3HBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamClearSubDep3HBuff" );
		}
	}

	public void setClearSubDep3Buff( CFBamClearSubDep3HBuff src ) {
		super.setClearDepBuff( src );
		setRequiredClearSubDep2TenantId( src.getRequiredClearSubDep2TenantId() );
		setRequiredClearSubDep2Id( src.getRequiredClearSubDep2Id() );
		setRequiredName( src.getRequiredName() );
	}
}
