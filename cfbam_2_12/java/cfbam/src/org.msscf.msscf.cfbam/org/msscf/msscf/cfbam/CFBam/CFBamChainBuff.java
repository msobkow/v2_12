// Description: Java 11 implementation of a Chain buffer object.

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

public class CFBamChainBuff
{
	public final static String CLASS_CODE = "CHN";
	public final static String S_INIT_CREATEDBY = "654dbba0-eda7-11e1-aff1-0800200c9a66";
	public final static UUID INIT_CREATEDBY = UUID.fromString( S_INIT_CREATEDBY );
	public final static String S_INIT_UPDATEDBY = "654dbba0-eda7-11e1-aff1-0800200c9a66";
	public final static UUID INIT_UPDATEDBY = UUID.fromString( S_INIT_UPDATEDBY );
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final long DEFSCHEMATENANTID_INIT_VALUE = 0L;
	public static final long DEFSCHEMAID_INIT_VALUE = 0L;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final long TABLEID_INIT_VALUE = 0L;
	public static final long PREVRELATIONTENANTID_INIT_VALUE = 0L;
	public static final long PREVRELATIONID_INIT_VALUE = 0L;
	public static final long NEXTRELATIONTENANTID_INIT_VALUE = 0L;
	public static final long NEXTRELATIONID_INIT_VALUE = 0L;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final long DEFSCHEMATENANTID_MIN_VALUE = 0L;
	public static final long DEFSCHEMAID_MIN_VALUE = 0L;
	public static final long TABLEID_MIN_VALUE = 0L;
	public static final long PREVRELATIONTENANTID_MIN_VALUE = 0L;
	public static final long PREVRELATIONID_MIN_VALUE = 0L;
	public static final long NEXTRELATIONTENANTID_MIN_VALUE = 0L;
	public static final long NEXTRELATIONID_MIN_VALUE = 0L;
	protected UUID createdByUserId = CFBamChainBuff.INIT_CREATEDBY;
	protected Calendar createdAt = Calendar.getInstance();
	protected UUID updatedByUserId = CFBamChainBuff.INIT_UPDATEDBY;
	protected Calendar updatedAt = Calendar.getInstance();
	protected long requiredTenantId;
	protected long requiredId;
	protected Long optionalDefSchemaTenantId;
	protected Long optionalDefSchemaId;
	protected String requiredName;
	protected String optionalShortName;
	protected String optionalLabel;
	protected String optionalShortDescription;
	protected String optionalDescription;
	protected long requiredTableId;
	protected String optionalSuffix;
	protected long requiredPrevRelationTenantId;
	protected long requiredPrevRelationId;
	protected long requiredNextRelationTenantId;
	protected long requiredNextRelationId;
	protected int requiredRevision;
	public CFBamChainBuff() {
		requiredTenantId = CFBamChainBuff.TENANTID_INIT_VALUE;
		requiredId = CFBamChainBuff.ID_INIT_VALUE;
		optionalDefSchemaTenantId = null;
		optionalDefSchemaId = null;
		requiredName = new String( CFBamChainBuff.NAME_INIT_VALUE );
		optionalShortName = null;
		optionalLabel = null;
		optionalShortDescription = null;
		optionalDescription = null;
		requiredTableId = CFBamChainBuff.TABLEID_INIT_VALUE;
		optionalSuffix = null;
		requiredPrevRelationTenantId = CFBamChainBuff.PREVRELATIONTENANTID_INIT_VALUE;
		requiredPrevRelationId = CFBamChainBuff.PREVRELATIONID_INIT_VALUE;
		requiredNextRelationTenantId = CFBamChainBuff.NEXTRELATIONTENANTID_INIT_VALUE;
		requiredNextRelationId = CFBamChainBuff.NEXTRELATIONID_INIT_VALUE;
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
		if( value < CFBamChainBuff.TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTenantId",
				1,
				"value",
				value,
				CFBamChainBuff.TENANTID_MIN_VALUE );
		}
		requiredTenantId = value;
	}

	public long getRequiredId() {
		return( requiredId );
	}

	public void setRequiredId( long value ) {
		if( value < CFBamChainBuff.ID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredId",
				1,
				"value",
				value,
				CFBamChainBuff.ID_MIN_VALUE );
		}
		requiredId = value;
	}

	public Long getOptionalDefSchemaTenantId() {
		return( optionalDefSchemaTenantId );
	}

	public void setOptionalDefSchemaTenantId( Long value ) {
		if( value == null ) {
			optionalDefSchemaTenantId = null;
		}
		else if( value < CFBamChainBuff.DEFSCHEMATENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalDefSchemaTenantId",
				1,
				"value",
				value,
				CFBamChainBuff.DEFSCHEMATENANTID_MIN_VALUE );
		}
		else {
			optionalDefSchemaTenantId = value;
		}
	}

	public Long getOptionalDefSchemaId() {
		return( optionalDefSchemaId );
	}

	public void setOptionalDefSchemaId( Long value ) {
		if( value == null ) {
			optionalDefSchemaId = null;
		}
		else if( value < CFBamChainBuff.DEFSCHEMAID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalDefSchemaId",
				1,
				"value",
				value,
				CFBamChainBuff.DEFSCHEMAID_MIN_VALUE );
		}
		else {
			optionalDefSchemaId = value;
		}
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

	public String getOptionalShortName() {
		return( optionalShortName );
	}

	public void setOptionalShortName( String value ) {
		if( value == null ) {
			optionalShortName = null;
		}
		else if( value.length() > 16 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalShortName",
				1,
				"value.length()",
				value.length(),
				16 );
		}
		else {
			optionalShortName = value;
		}
	}

	public String getOptionalLabel() {
		return( optionalLabel );
	}

	public void setOptionalLabel( String value ) {
		if( value == null ) {
			optionalLabel = null;
		}
		else if( value.length() > 64 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalLabel",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		else {
			optionalLabel = value;
		}
	}

	public String getOptionalShortDescription() {
		return( optionalShortDescription );
	}

	public void setOptionalShortDescription( String value ) {
		if( value == null ) {
			optionalShortDescription = null;
		}
		else if( value.length() > 128 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalShortDescription",
				1,
				"value.length()",
				value.length(),
				128 );
		}
		else {
			optionalShortDescription = value;
		}
	}

	public String getOptionalDescription() {
		return( optionalDescription );
	}

	public void setOptionalDescription( String value ) {
		if( value == null ) {
			optionalDescription = null;
		}
		else if( value.length() > 1023 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalDescription",
				1,
				"value.length()",
				value.length(),
				1023 );
		}
		else {
			optionalDescription = value;
		}
	}

	public long getRequiredTableId() {
		return( requiredTableId );
	}

	public void setRequiredTableId( long value ) {
		if( value < CFBamChainBuff.TABLEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTableId",
				1,
				"value",
				value,
				CFBamChainBuff.TABLEID_MIN_VALUE );
		}
		requiredTableId = value;
	}

	public String getOptionalSuffix() {
		return( optionalSuffix );
	}

	public void setOptionalSuffix( String value ) {
		if( value == null ) {
			optionalSuffix = null;
		}
		else if( value.length() > 16 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalSuffix",
				1,
				"value.length()",
				value.length(),
				16 );
		}
		else {
			optionalSuffix = value;
		}
	}

	public long getRequiredPrevRelationTenantId() {
		return( requiredPrevRelationTenantId );
	}

	public void setRequiredPrevRelationTenantId( long value ) {
		if( value < CFBamChainBuff.PREVRELATIONTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredPrevRelationTenantId",
				1,
				"value",
				value,
				CFBamChainBuff.PREVRELATIONTENANTID_MIN_VALUE );
		}
		requiredPrevRelationTenantId = value;
	}

	public long getRequiredPrevRelationId() {
		return( requiredPrevRelationId );
	}

	public void setRequiredPrevRelationId( long value ) {
		if( value < CFBamChainBuff.PREVRELATIONID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredPrevRelationId",
				1,
				"value",
				value,
				CFBamChainBuff.PREVRELATIONID_MIN_VALUE );
		}
		requiredPrevRelationId = value;
	}

	public long getRequiredNextRelationTenantId() {
		return( requiredNextRelationTenantId );
	}

	public void setRequiredNextRelationTenantId( long value ) {
		if( value < CFBamChainBuff.NEXTRELATIONTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredNextRelationTenantId",
				1,
				"value",
				value,
				CFBamChainBuff.NEXTRELATIONTENANTID_MIN_VALUE );
		}
		requiredNextRelationTenantId = value;
	}

	public long getRequiredNextRelationId() {
		return( requiredNextRelationId );
	}

	public void setRequiredNextRelationId( long value ) {
		if( value < CFBamChainBuff.NEXTRELATIONID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredNextRelationId",
				1,
				"value",
				value,
				CFBamChainBuff.NEXTRELATIONID_MIN_VALUE );
		}
		requiredNextRelationId = value;
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
		else if( obj instanceof CFBamChainBuff ) {
			CFBamChainBuff rhs = (CFBamChainBuff)obj;
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
			if( getOptionalDefSchemaTenantId() != null ) {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					if( ! getOptionalDefSchemaTenantId().equals( rhs.getOptionalDefSchemaTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
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
			if( getRequiredTableId() != rhs.getRequiredTableId() ) {
				return( false );
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					if( ! getOptionalSuffix().equals( rhs.getOptionalSuffix() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( false );
				}
			}
			if( getRequiredPrevRelationTenantId() != rhs.getRequiredPrevRelationTenantId() ) {
				return( false );
			}
			if( getRequiredPrevRelationId() != rhs.getRequiredPrevRelationId() ) {
				return( false );
			}
			if( getRequiredNextRelationTenantId() != rhs.getRequiredNextRelationTenantId() ) {
				return( false );
			}
			if( getRequiredNextRelationId() != rhs.getRequiredNextRelationId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamChainPKey ) {
			CFBamChainPKey rhs = (CFBamChainPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamChainHBuff ) {
			CFBamChainHBuff rhs = (CFBamChainHBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getOptionalDefSchemaTenantId() != null ) {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					if( ! getOptionalDefSchemaTenantId().equals( rhs.getOptionalDefSchemaTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
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
			if( getRequiredTableId() != rhs.getRequiredTableId() ) {
				return( false );
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					if( ! getOptionalSuffix().equals( rhs.getOptionalSuffix() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( false );
				}
			}
			if( getRequiredPrevRelationTenantId() != rhs.getRequiredPrevRelationTenantId() ) {
				return( false );
			}
			if( getRequiredPrevRelationId() != rhs.getRequiredPrevRelationId() ) {
				return( false );
			}
			if( getRequiredNextRelationTenantId() != rhs.getRequiredNextRelationTenantId() ) {
				return( false );
			}
			if( getRequiredNextRelationId() != rhs.getRequiredNextRelationId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamChainHPKey ) {
			CFBamChainHPKey rhs = (CFBamChainHPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamChainByTenantIdxKey ) {
			CFBamChainByTenantIdxKey rhs = (CFBamChainByTenantIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamChainByChainTableIdxKey ) {
			CFBamChainByChainTableIdxKey rhs = (CFBamChainByChainTableIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTableId() != rhs.getRequiredTableId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamChainByDefSchemaIdxKey ) {
			CFBamChainByDefSchemaIdxKey rhs = (CFBamChainByDefSchemaIdxKey)obj;
			if( getOptionalDefSchemaTenantId() != null ) {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					if( ! getOptionalDefSchemaTenantId().equals( rhs.getOptionalDefSchemaTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamChainByUNameIdxKey ) {
			CFBamChainByUNameIdxKey rhs = (CFBamChainByUNameIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTableId() != rhs.getRequiredTableId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamChainByPrevRelIdxKey ) {
			CFBamChainByPrevRelIdxKey rhs = (CFBamChainByPrevRelIdxKey)obj;
			if( getRequiredPrevRelationTenantId() != rhs.getRequiredPrevRelationTenantId() ) {
				return( false );
			}
			if( getRequiredPrevRelationId() != rhs.getRequiredPrevRelationId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamChainByNextRelIdxKey ) {
			CFBamChainByNextRelIdxKey rhs = (CFBamChainByNextRelIdxKey)obj;
			if( getRequiredNextRelationTenantId() != rhs.getRequiredNextRelationTenantId() ) {
				return( false );
			}
			if( getRequiredNextRelationId() != rhs.getRequiredNextRelationId() ) {
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
		if( getOptionalDefSchemaTenantId() != null ) {
			hashCode = hashCode + getOptionalDefSchemaTenantId().hashCode();
		}
		if( getOptionalDefSchemaId() != null ) {
			hashCode = hashCode + getOptionalDefSchemaId().hashCode();
		}
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalShortName() != null ) {
			hashCode = hashCode + getOptionalShortName().hashCode();
		}
		if( getOptionalLabel() != null ) {
			hashCode = hashCode + getOptionalLabel().hashCode();
		}
		if( getOptionalShortDescription() != null ) {
			hashCode = hashCode + getOptionalShortDescription().hashCode();
		}
		if( getOptionalDescription() != null ) {
			hashCode = hashCode + getOptionalDescription().hashCode();
		}
		hashCode = hashCode + (int)( getRequiredTableId() );
		if( getOptionalSuffix() != null ) {
			hashCode = hashCode + getOptionalSuffix().hashCode();
		}
		hashCode = hashCode + (int)( getRequiredPrevRelationTenantId() );
		hashCode = hashCode + (int)( getRequiredPrevRelationId() );
		hashCode = hashCode + (int)( getRequiredNextRelationTenantId() );
		hashCode = hashCode + (int)( getRequiredNextRelationId() );
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamChainBuff ) {
			CFBamChainBuff rhs = (CFBamChainBuff)obj;
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
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					int cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					int cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					int cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
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
			if( getRequiredTableId() < rhs.getRequiredTableId() ) {
				return( -1 );
			}
			else if( getRequiredTableId() > rhs.getRequiredTableId() ) {
				return( 1 );
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					int cmp = getOptionalSuffix().compareTo( rhs.getOptionalSuffix() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( -1 );
				}
			}
			if( getRequiredPrevRelationTenantId() < rhs.getRequiredPrevRelationTenantId() ) {
				return( -1 );
			}
			else if( getRequiredPrevRelationTenantId() > rhs.getRequiredPrevRelationTenantId() ) {
				return( 1 );
			}
			if( getRequiredPrevRelationId() < rhs.getRequiredPrevRelationId() ) {
				return( -1 );
			}
			else if( getRequiredPrevRelationId() > rhs.getRequiredPrevRelationId() ) {
				return( 1 );
			}
			if( getRequiredNextRelationTenantId() < rhs.getRequiredNextRelationTenantId() ) {
				return( -1 );
			}
			else if( getRequiredNextRelationTenantId() > rhs.getRequiredNextRelationTenantId() ) {
				return( 1 );
			}
			if( getRequiredNextRelationId() < rhs.getRequiredNextRelationId() ) {
				return( -1 );
			}
			else if( getRequiredNextRelationId() > rhs.getRequiredNextRelationId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamChainPKey ) {
			CFBamChainPKey rhs = (CFBamChainPKey)obj;
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
		else if( obj instanceof CFBamChainHPKey ) {
			CFBamChainHPKey rhs = (CFBamChainHPKey)obj;
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
		else if( obj instanceof CFBamChainHBuff ) {
			CFBamChainHBuff rhs = (CFBamChainHBuff)obj;
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
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					int cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					int cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					int cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
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
			if( getRequiredTableId() < rhs.getRequiredTableId() ) {
				return( -1 );
			}
			else if( getRequiredTableId() > rhs.getRequiredTableId() ) {
				return( 1 );
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					int cmp = getOptionalSuffix().compareTo( rhs.getOptionalSuffix() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( -1 );
				}
			}
			if( getRequiredPrevRelationTenantId() < rhs.getRequiredPrevRelationTenantId() ) {
				return( -1 );
			}
			else if( getRequiredPrevRelationTenantId() > rhs.getRequiredPrevRelationTenantId() ) {
				return( 1 );
			}
			if( getRequiredPrevRelationId() < rhs.getRequiredPrevRelationId() ) {
				return( -1 );
			}
			else if( getRequiredPrevRelationId() > rhs.getRequiredPrevRelationId() ) {
				return( 1 );
			}
			if( getRequiredNextRelationTenantId() < rhs.getRequiredNextRelationTenantId() ) {
				return( -1 );
			}
			else if( getRequiredNextRelationTenantId() > rhs.getRequiredNextRelationTenantId() ) {
				return( 1 );
			}
			if( getRequiredNextRelationId() < rhs.getRequiredNextRelationId() ) {
				return( -1 );
			}
			else if( getRequiredNextRelationId() > rhs.getRequiredNextRelationId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamChainByTenantIdxKey ) {
			CFBamChainByTenantIdxKey rhs = (CFBamChainByTenantIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamChainByChainTableIdxKey ) {
			CFBamChainByChainTableIdxKey rhs = (CFBamChainByChainTableIdxKey)obj;

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
		else if( obj instanceof CFBamChainByDefSchemaIdxKey ) {
			CFBamChainByDefSchemaIdxKey rhs = (CFBamChainByDefSchemaIdxKey)obj;

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
			}			return( 0 );
		}
		else if( obj instanceof CFBamChainByUNameIdxKey ) {
			CFBamChainByUNameIdxKey rhs = (CFBamChainByUNameIdxKey)obj;

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
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamChainByPrevRelIdxKey ) {
			CFBamChainByPrevRelIdxKey rhs = (CFBamChainByPrevRelIdxKey)obj;

			if( getRequiredPrevRelationTenantId() < rhs.getRequiredPrevRelationTenantId() ) {
				return( -1 );
			}
			else if( getRequiredPrevRelationTenantId() > rhs.getRequiredPrevRelationTenantId() ) {
				return( 1 );
			}
			if( getRequiredPrevRelationId() < rhs.getRequiredPrevRelationId() ) {
				return( -1 );
			}
			else if( getRequiredPrevRelationId() > rhs.getRequiredPrevRelationId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamChainByNextRelIdxKey ) {
			CFBamChainByNextRelIdxKey rhs = (CFBamChainByNextRelIdxKey)obj;

			if( getRequiredNextRelationTenantId() < rhs.getRequiredNextRelationTenantId() ) {
				return( -1 );
			}
			else if( getRequiredNextRelationTenantId() > rhs.getRequiredNextRelationTenantId() ) {
				return( 1 );
			}
			if( getRequiredNextRelationId() < rhs.getRequiredNextRelationId() ) {
				return( -1 );
			}
			else if( getRequiredNextRelationId() > rhs.getRequiredNextRelationId() ) {
				return( 1 );
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

	public void set( CFBamChainBuff src ) {
		setChainBuff( src );
	}

	public void setChainBuff( CFBamChainBuff src ) {
		setRequiredTenantId( src.getRequiredTenantId() );
		setRequiredId( src.getRequiredId() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setOptionalDefSchemaTenantId( src.getOptionalDefSchemaTenantId() );
		setOptionalDefSchemaId( src.getOptionalDefSchemaId() );
		setRequiredName( src.getRequiredName() );
		setOptionalShortName( src.getOptionalShortName() );
		setOptionalLabel( src.getOptionalLabel() );
		setOptionalShortDescription( src.getOptionalShortDescription() );
		setOptionalDescription( src.getOptionalDescription() );
		setRequiredTableId( src.getRequiredTableId() );
		setOptionalSuffix( src.getOptionalSuffix() );
		setRequiredPrevRelationTenantId( src.getRequiredPrevRelationTenantId() );
		setRequiredPrevRelationId( src.getRequiredPrevRelationId() );
		setRequiredNextRelationTenantId( src.getRequiredNextRelationTenantId() );
		setRequiredNextRelationId( src.getRequiredNextRelationId() );
		setRequiredRevision( src.getRequiredRevision() );
	}

	public void set( CFBamChainHBuff src ) {
		setChainBuff( src );
	}

	public void setChainBuff( CFBamChainHBuff src ) {
		setRequiredTenantId( src.getRequiredTenantId() );
		setRequiredId( src.getRequiredId() );
		setOptionalDefSchemaTenantId( src.getOptionalDefSchemaTenantId() );
		setOptionalDefSchemaId( src.getOptionalDefSchemaId() );
		setRequiredName( src.getRequiredName() );
		setOptionalShortName( src.getOptionalShortName() );
		setOptionalLabel( src.getOptionalLabel() );
		setOptionalShortDescription( src.getOptionalShortDescription() );
		setOptionalDescription( src.getOptionalDescription() );
		setRequiredTableId( src.getRequiredTableId() );
		setOptionalSuffix( src.getOptionalSuffix() );
		setRequiredPrevRelationTenantId( src.getRequiredPrevRelationTenantId() );
		setRequiredPrevRelationId( src.getRequiredPrevRelationId() );
		setRequiredNextRelationTenantId( src.getRequiredNextRelationTenantId() );
		setRequiredNextRelationId( src.getRequiredNextRelationId() );
	}
}
