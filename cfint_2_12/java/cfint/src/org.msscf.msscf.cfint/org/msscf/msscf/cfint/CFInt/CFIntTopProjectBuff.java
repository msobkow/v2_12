// Description: Java 11 implementation of a TopProject buffer object.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFInt;

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

public class CFIntTopProjectBuff
{
	public final static String CLASS_CODE = "TPRJ";
	public final static String S_INIT_CREATEDBY = "654dbba0-eda7-11e1-aff1-0800200c9a66";
	public final static UUID INIT_CREATEDBY = UUID.fromString( S_INIT_CREATEDBY );
	public final static String S_INIT_UPDATEDBY = "654dbba0-eda7-11e1-aff1-0800200c9a66";
	public final static UUID INIT_UPDATEDBY = UUID.fromString( S_INIT_UPDATEDBY );
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final long TOPDOMAINID_INIT_VALUE = 0L;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final String DESCRIPTION_INIT_VALUE = new String( "" );
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final long TOPDOMAINID_MIN_VALUE = 0L;
	protected UUID createdByUserId = CFIntTopProjectBuff.INIT_CREATEDBY;
	protected Calendar createdAt = Calendar.getInstance();
	protected UUID updatedByUserId = CFIntTopProjectBuff.INIT_UPDATEDBY;
	protected Calendar updatedAt = Calendar.getInstance();
	protected long requiredTenantId;
	protected long requiredId;
	protected long requiredTopDomainId;
	protected String requiredName;
	protected String optionalDescription;
	protected int requiredRevision;
	public CFIntTopProjectBuff() {
		requiredTenantId = CFIntTopProjectBuff.TENANTID_INIT_VALUE;
		requiredId = CFIntTopProjectBuff.ID_INIT_VALUE;
		requiredTopDomainId = CFIntTopProjectBuff.TOPDOMAINID_INIT_VALUE;
		requiredName = new String( CFIntTopProjectBuff.NAME_INIT_VALUE );
		optionalDescription = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public UUID getCreatedByUserId() {
		return( createdByUserId );
	}

	public void setCreatedByUserId( UUID value ) {
		createdByUserId = value;
	}

	public Calendar getCreatedAt() {
		return( createdAt );
	}

	public void setCreatedAt( Calendar value ) {
		createdAt = value;
	}

	public UUID getUpdatedByUserId() {
		return( updatedByUserId );
	}

	public void setUpdatedByUserId( UUID value ) {
		updatedByUserId = value;
	}

	public Calendar getUpdatedAt() {
		return( updatedAt );
	}

	public void setUpdatedAt( Calendar value ) {
		updatedAt = value;
	}
	public long getRequiredTenantId() {
		return( requiredTenantId );
	}

	public void setRequiredTenantId( long value ) {
		if( value < CFIntTopProjectBuff.TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTenantId",
				1,
				"value",
				value,
				CFIntTopProjectBuff.TENANTID_MIN_VALUE );
		}
		requiredTenantId = value;
	}

	public long getRequiredId() {
		return( requiredId );
	}

	public void setRequiredId( long value ) {
		if( value < CFIntTopProjectBuff.ID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredId",
				1,
				"value",
				value,
				CFIntTopProjectBuff.ID_MIN_VALUE );
		}
		requiredId = value;
	}

	public long getRequiredTopDomainId() {
		return( requiredTopDomainId );
	}

	public void setRequiredTopDomainId( long value ) {
		if( value < CFIntTopProjectBuff.TOPDOMAINID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTopDomainId",
				1,
				"value",
				value,
				CFIntTopProjectBuff.TOPDOMAINID_MIN_VALUE );
		}
		requiredTopDomainId = value;
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
		if( value.length() > 64 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		requiredName = value;
	}

	public String getOptionalDescription() {
		return( optionalDescription );
	}

	public void setOptionalDescription( String value ) {
		if( value == null ) {
			optionalDescription = null;
		}
		else if( value.length() > 1024 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalDescription",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		else {
			optionalDescription = value;
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
		else if( obj instanceof CFIntTopProjectBuff ) {
			CFIntTopProjectBuff rhs = (CFIntTopProjectBuff)obj;
			if( ! getCreatedByUserId().equals( rhs.getCreatedByUserId() ) ) {
				return( false );
			}
			if( ! getCreatedAt().equals( rhs.getCreatedAt() ) ) {
				return( false );
			}
			if( ! getUpdatedByUserId().equals( rhs.getUpdatedByUserId() ) ) {
				return( false );
			}
			if( ! getUpdatedAt().equals( rhs.getUpdatedAt() ) ) {
				return( false );
			}
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredTopDomainId() != rhs.getRequiredTopDomainId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFIntTopProjectPKey ) {
			CFIntTopProjectPKey rhs = (CFIntTopProjectPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFIntTopProjectHBuff ) {
			CFIntTopProjectHBuff rhs = (CFIntTopProjectHBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredTopDomainId() != rhs.getRequiredTopDomainId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFIntTopProjectHPKey ) {
			CFIntTopProjectHPKey rhs = (CFIntTopProjectHPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFIntTopProjectByTenantIdxKey ) {
			CFIntTopProjectByTenantIdxKey rhs = (CFIntTopProjectByTenantIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFIntTopProjectByTopDomainIdxKey ) {
			CFIntTopProjectByTopDomainIdxKey rhs = (CFIntTopProjectByTopDomainIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTopDomainId() != rhs.getRequiredTopDomainId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFIntTopProjectByNameIdxKey ) {
			CFIntTopProjectByNameIdxKey rhs = (CFIntTopProjectByNameIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTopDomainId() != rhs.getRequiredTopDomainId() ) {
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
		int hashCode = 0;
		hashCode = hashCode + getCreatedByUserId().hashCode();
		hashCode = hashCode + getCreatedAt().hashCode();
		hashCode = hashCode + getUpdatedByUserId().hashCode();
		hashCode = hashCode + getUpdatedAt().hashCode();
		hashCode = hashCode + (int)( getRequiredTenantId() );
		hashCode = hashCode + (int)( getRequiredId() );
		hashCode = hashCode + (int)( getRequiredTopDomainId() );
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalDescription() != null ) {
			hashCode = hashCode + getOptionalDescription().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFIntTopProjectBuff ) {
			CFIntTopProjectBuff rhs = (CFIntTopProjectBuff)obj;
			int retval = 0;
			{
				int cmp = getCreatedByUserId().compareTo( rhs.getCreatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getCreatedAt().compareTo( rhs.getCreatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedByUserId().compareTo( rhs.getUpdatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedAt().compareTo( rhs.getUpdatedAt() );
				if( cmp != 0 ) {
					return( cmp );
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
			if( getRequiredTopDomainId() < rhs.getRequiredTopDomainId() ) {
				return( -1 );
			}
			else if( getRequiredTopDomainId() > rhs.getRequiredTopDomainId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					int cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFIntTopProjectPKey ) {
			CFIntTopProjectPKey rhs = (CFIntTopProjectPKey)obj;
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
		else if( obj instanceof CFIntTopProjectHPKey ) {
			CFIntTopProjectHPKey rhs = (CFIntTopProjectHPKey)obj;
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
		else if( obj instanceof CFIntTopProjectHBuff ) {
			CFIntTopProjectHBuff rhs = (CFIntTopProjectHBuff)obj;
			int retval = 0;
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
			if( getRequiredTopDomainId() < rhs.getRequiredTopDomainId() ) {
				return( -1 );
			}
			else if( getRequiredTopDomainId() > rhs.getRequiredTopDomainId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					int cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFIntTopProjectByTenantIdxKey ) {
			CFIntTopProjectByTenantIdxKey rhs = (CFIntTopProjectByTenantIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFIntTopProjectByTopDomainIdxKey ) {
			CFIntTopProjectByTopDomainIdxKey rhs = (CFIntTopProjectByTopDomainIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredTopDomainId() < rhs.getRequiredTopDomainId() ) {
				return( -1 );
			}
			else if( getRequiredTopDomainId() > rhs.getRequiredTopDomainId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFIntTopProjectByNameIdxKey ) {
			CFIntTopProjectByNameIdxKey rhs = (CFIntTopProjectByNameIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredTopDomainId() < rhs.getRequiredTopDomainId() ) {
				return( -1 );
			}
			else if( getRequiredTopDomainId() > rhs.getRequiredTopDomainId() ) {
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
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	public void set( CFIntTopProjectBuff src ) {
		setTopProjectBuff( src );
	}

	public void setTopProjectBuff( CFIntTopProjectBuff src ) {
		setRequiredTenantId( src.getRequiredTenantId() );
		setRequiredId( src.getRequiredId() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredTopDomainId( src.getRequiredTopDomainId() );
		setRequiredName( src.getRequiredName() );
		setOptionalDescription( src.getOptionalDescription() );
		setRequiredRevision( src.getRequiredRevision() );
	}

	public void set( CFIntTopProjectHBuff src ) {
		setTopProjectBuff( src );
	}

	public void setTopProjectBuff( CFIntTopProjectHBuff src ) {
		setRequiredTenantId( src.getRequiredTenantId() );
		setRequiredId( src.getRequiredId() );
		setRequiredTopDomainId( src.getRequiredTopDomainId() );
		setRequiredName( src.getRequiredName() );
		setOptionalDescription( src.getOptionalDescription() );
	}
}
