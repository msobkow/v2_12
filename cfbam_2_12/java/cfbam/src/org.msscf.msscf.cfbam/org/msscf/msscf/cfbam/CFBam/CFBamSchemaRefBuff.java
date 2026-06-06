// Description: Java 11 implementation of a SchemaRef buffer object.

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

public class CFBamSchemaRefBuff
	extends CFBamScopeBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "SCRF";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final long SCHEMAID_INIT_VALUE = 0L;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final String REFMODELNAME_INIT_VALUE = new String( "" );
	public static final String INCLUDEROOT_INIT_VALUE = new String( "" );
	public static final long REFSCHEMATENANTID_INIT_VALUE = 0L;
	public static final long REFSCHEMAID_INIT_VALUE = 0L;
	public static final long PREVTENANTID_INIT_VALUE = 0L;
	public static final long PREVID_INIT_VALUE = 0L;
	public static final long NEXTTENANTID_INIT_VALUE = 0L;
	public static final long NEXTID_INIT_VALUE = 0L;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final long SCHEMAID_MIN_VALUE = 0L;
	public static final long REFSCHEMATENANTID_MIN_VALUE = 0L;
	public static final long REFSCHEMAID_MIN_VALUE = 0L;
	public static final long PREVTENANTID_MIN_VALUE = 0L;
	public static final long PREVID_MIN_VALUE = 0L;
	public static final long NEXTTENANTID_MIN_VALUE = 0L;
	public static final long NEXTID_MIN_VALUE = 0L;
	protected long requiredSchemaId;
	protected String requiredName;
	protected String requiredRefModelName;
	protected String requiredIncludeRoot;
	protected Long optionalRefSchemaTenantId;
	protected Long optionalRefSchemaId;
	protected Long optionalPrevTenantId;
	protected Long optionalPrevId;
	protected Long optionalNextTenantId;
	protected Long optionalNextId;
	public CFBamSchemaRefBuff() {
		super();
		requiredSchemaId = CFBamSchemaRefBuff.SCHEMAID_INIT_VALUE;
		requiredName = new String( CFBamSchemaRefBuff.NAME_INIT_VALUE );
		requiredRefModelName = new String( CFBamSchemaRefBuff.REFMODELNAME_INIT_VALUE );
		requiredIncludeRoot = new String( CFBamSchemaRefBuff.INCLUDEROOT_INIT_VALUE );
		optionalRefSchemaTenantId = null;
		optionalRefSchemaId = null;
		optionalPrevTenantId = null;
		optionalPrevId = null;
		optionalNextTenantId = null;
		optionalNextId = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public long getRequiredSchemaId() {
		return( requiredSchemaId );
	}

	public void setRequiredSchemaId( long value ) {
		if( value < CFBamSchemaRefBuff.SCHEMAID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredSchemaId",
				1,
				"value",
				value,
				CFBamSchemaRefBuff.SCHEMAID_MIN_VALUE );
		}
		requiredSchemaId = value;
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

	public String getRequiredRefModelName() {
		return( requiredRefModelName );
	}

	public void setRequiredRefModelName( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredRefModelName",
				1,
				"value" );
		}
		if( value.length() > 1024 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredRefModelName",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		requiredRefModelName = value;
	}

	public String getRequiredIncludeRoot() {
		return( requiredIncludeRoot );
	}

	public void setRequiredIncludeRoot( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredIncludeRoot",
				1,
				"value" );
		}
		if( value.length() > 1024 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredIncludeRoot",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		requiredIncludeRoot = value;
	}

	public Long getOptionalRefSchemaTenantId() {
		return( optionalRefSchemaTenantId );
	}

	public void setOptionalRefSchemaTenantId( Long value ) {
		if( value == null ) {
			optionalRefSchemaTenantId = null;
		}
		else if( value < CFBamSchemaRefBuff.REFSCHEMATENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalRefSchemaTenantId",
				1,
				"value",
				value,
				CFBamSchemaRefBuff.REFSCHEMATENANTID_MIN_VALUE );
		}
		else {
			optionalRefSchemaTenantId = value;
		}
	}

	public Long getOptionalRefSchemaId() {
		return( optionalRefSchemaId );
	}

	public void setOptionalRefSchemaId( Long value ) {
		if( value == null ) {
			optionalRefSchemaId = null;
		}
		else if( value < CFBamSchemaRefBuff.REFSCHEMAID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalRefSchemaId",
				1,
				"value",
				value,
				CFBamSchemaRefBuff.REFSCHEMAID_MIN_VALUE );
		}
		else {
			optionalRefSchemaId = value;
		}
	}

	public Long getOptionalPrevTenantId() {
		return( optionalPrevTenantId );
	}

	public void setOptionalPrevTenantId( Long value ) {
		if( value == null ) {
			optionalPrevTenantId = null;
		}
		else if( value < CFBamSchemaRefBuff.PREVTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalPrevTenantId",
				1,
				"value",
				value,
				CFBamSchemaRefBuff.PREVTENANTID_MIN_VALUE );
		}
		else {
			optionalPrevTenantId = value;
		}
	}

	public Long getOptionalPrevId() {
		return( optionalPrevId );
	}

	public void setOptionalPrevId( Long value ) {
		if( value == null ) {
			optionalPrevId = null;
		}
		else if( value < CFBamSchemaRefBuff.PREVID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalPrevId",
				1,
				"value",
				value,
				CFBamSchemaRefBuff.PREVID_MIN_VALUE );
		}
		else {
			optionalPrevId = value;
		}
	}

	public Long getOptionalNextTenantId() {
		return( optionalNextTenantId );
	}

	public void setOptionalNextTenantId( Long value ) {
		if( value == null ) {
			optionalNextTenantId = null;
		}
		else if( value < CFBamSchemaRefBuff.NEXTTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalNextTenantId",
				1,
				"value",
				value,
				CFBamSchemaRefBuff.NEXTTENANTID_MIN_VALUE );
		}
		else {
			optionalNextTenantId = value;
		}
	}

	public Long getOptionalNextId() {
		return( optionalNextId );
	}

	public void setOptionalNextId( Long value ) {
		if( value == null ) {
			optionalNextId = null;
		}
		else if( value < CFBamSchemaRefBuff.NEXTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalNextId",
				1,
				"value",
				value,
				CFBamSchemaRefBuff.NEXTID_MIN_VALUE );
		}
		else {
			optionalNextId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamSchemaRefBuff ) {
			CFBamSchemaRefBuff rhs = (CFBamSchemaRefBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredSchemaId() != rhs.getRequiredSchemaId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( ! getRequiredRefModelName().equals( rhs.getRequiredRefModelName() ) ) {
				return( false );
			}
			if( ! getRequiredIncludeRoot().equals( rhs.getRequiredIncludeRoot() ) ) {
				return( false );
			}
			if( getOptionalRefSchemaTenantId() != null ) {
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					if( ! getOptionalRefSchemaTenantId().equals( rhs.getOptionalRefSchemaTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					if( ! getOptionalRefSchemaId().equals( rhs.getOptionalRefSchemaId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( false );
				}
			}
			if( getOptionalPrevTenantId() != null ) {
				if( rhs.getOptionalPrevTenantId() != null ) {
					if( ! getOptionalPrevTenantId().equals( rhs.getOptionalPrevTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrevTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					if( ! getOptionalPrevId().equals( rhs.getOptionalPrevId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextTenantId() != null ) {
				if( rhs.getOptionalNextTenantId() != null ) {
					if( ! getOptionalNextTenantId().equals( rhs.getOptionalNextTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNextTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
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
		else if( obj instanceof CFBamSchemaRefHBuff ) {
			CFBamSchemaRefHBuff rhs = (CFBamSchemaRefHBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredSchemaId() != rhs.getRequiredSchemaId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( ! getRequiredRefModelName().equals( rhs.getRequiredRefModelName() ) ) {
				return( false );
			}
			if( ! getRequiredIncludeRoot().equals( rhs.getRequiredIncludeRoot() ) ) {
				return( false );
			}
			if( getOptionalRefSchemaTenantId() != null ) {
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					if( ! getOptionalRefSchemaTenantId().equals( rhs.getOptionalRefSchemaTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					if( ! getOptionalRefSchemaId().equals( rhs.getOptionalRefSchemaId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( false );
				}
			}
			if( getOptionalPrevTenantId() != null ) {
				if( rhs.getOptionalPrevTenantId() != null ) {
					if( ! getOptionalPrevTenantId().equals( rhs.getOptionalPrevTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrevTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					if( ! getOptionalPrevId().equals( rhs.getOptionalPrevId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextTenantId() != null ) {
				if( rhs.getOptionalNextTenantId() != null ) {
					if( ! getOptionalNextTenantId().equals( rhs.getOptionalNextTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNextTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
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
		else if( obj instanceof CFBamSchemaRefBySchemaIdxKey ) {
			CFBamSchemaRefBySchemaIdxKey rhs = (CFBamSchemaRefBySchemaIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredSchemaId() != rhs.getRequiredSchemaId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaRefByUNameIdxKey ) {
			CFBamSchemaRefByUNameIdxKey rhs = (CFBamSchemaRefByUNameIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredSchemaId() != rhs.getRequiredSchemaId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaRefByRefSchemaIdxKey ) {
			CFBamSchemaRefByRefSchemaIdxKey rhs = (CFBamSchemaRefByRefSchemaIdxKey)obj;
			if( getOptionalRefSchemaTenantId() != null ) {
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					if( ! getOptionalRefSchemaTenantId().equals( rhs.getOptionalRefSchemaTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					if( ! getOptionalRefSchemaId().equals( rhs.getOptionalRefSchemaId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaRefByPrevIdxKey ) {
			CFBamSchemaRefByPrevIdxKey rhs = (CFBamSchemaRefByPrevIdxKey)obj;
			if( getOptionalPrevTenantId() != null ) {
				if( rhs.getOptionalPrevTenantId() != null ) {
					if( ! getOptionalPrevTenantId().equals( rhs.getOptionalPrevTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrevTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					if( ! getOptionalPrevId().equals( rhs.getOptionalPrevId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaRefByNextIdxKey ) {
			CFBamSchemaRefByNextIdxKey rhs = (CFBamSchemaRefByNextIdxKey)obj;
			if( getOptionalNextTenantId() != null ) {
				if( rhs.getOptionalNextTenantId() != null ) {
					if( ! getOptionalNextTenantId().equals( rhs.getOptionalNextTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNextTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
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
		hashCode = hashCode + (int)( getRequiredSchemaId() );
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getRequiredRefModelName() != null ) {
			hashCode = hashCode + getRequiredRefModelName().hashCode();
		}
		if( getRequiredIncludeRoot() != null ) {
			hashCode = hashCode + getRequiredIncludeRoot().hashCode();
		}
		if( getOptionalRefSchemaTenantId() != null ) {
			hashCode = hashCode + getOptionalRefSchemaTenantId().hashCode();
		}
		if( getOptionalRefSchemaId() != null ) {
			hashCode = hashCode + getOptionalRefSchemaId().hashCode();
		}
		if( getOptionalPrevTenantId() != null ) {
			hashCode = hashCode + getOptionalPrevTenantId().hashCode();
		}
		if( getOptionalPrevId() != null ) {
			hashCode = hashCode + getOptionalPrevId().hashCode();
		}
		if( getOptionalNextTenantId() != null ) {
			hashCode = hashCode + getOptionalNextTenantId().hashCode();
		}
		if( getOptionalNextId() != null ) {
			hashCode = hashCode + getOptionalNextId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamSchemaRefBuff ) {
			CFBamSchemaRefBuff rhs = (CFBamSchemaRefBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getRequiredSchemaId() < rhs.getRequiredSchemaId() ) {
				return( -1 );
			}
			else if( getRequiredSchemaId() > rhs.getRequiredSchemaId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredRefModelName().compareTo( rhs.getRequiredRefModelName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredIncludeRoot().compareTo( rhs.getRequiredIncludeRoot() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalRefSchemaTenantId() != null ) {
				Long lhsRefSchemaTenantId = getOptionalRefSchemaTenantId();
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					Long rhsRefSchemaTenantId = rhs.getOptionalRefSchemaTenantId();
					int cmp = lhsRefSchemaTenantId.compareTo( rhsRefSchemaTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalRefSchemaId() != null ) {
				Long lhsRefSchemaId = getOptionalRefSchemaId();
				if( rhs.getOptionalRefSchemaId() != null ) {
					Long rhsRefSchemaId = rhs.getOptionalRefSchemaId();
					int cmp = lhsRefSchemaId.compareTo( rhsRefSchemaId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrevTenantId() != null ) {
				Long lhsPrevTenantId = getOptionalPrevTenantId();
				if( rhs.getOptionalPrevTenantId() != null ) {
					Long rhsPrevTenantId = rhs.getOptionalPrevTenantId();
					int cmp = lhsPrevTenantId.compareTo( rhsPrevTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrevId() != null ) {
				Long lhsPrevId = getOptionalPrevId();
				if( rhs.getOptionalPrevId() != null ) {
					Long rhsPrevId = rhs.getOptionalPrevId();
					int cmp = lhsPrevId.compareTo( rhsPrevId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextTenantId() != null ) {
				Long lhsNextTenantId = getOptionalNextTenantId();
				if( rhs.getOptionalNextTenantId() != null ) {
					Long rhsNextTenantId = rhs.getOptionalNextTenantId();
					int cmp = lhsNextTenantId.compareTo( rhsNextTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextId() != null ) {
				Long lhsNextId = getOptionalNextId();
				if( rhs.getOptionalNextId() != null ) {
					Long rhsNextId = rhs.getOptionalNextId();
					int cmp = lhsNextId.compareTo( rhsNextId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
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
		else if( obj instanceof CFBamSchemaRefHBuff ) {
			CFBamSchemaRefHBuff rhs = (CFBamSchemaRefHBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getRequiredSchemaId() < rhs.getRequiredSchemaId() ) {
				return( -1 );
			}
			else if( getRequiredSchemaId() > rhs.getRequiredSchemaId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredRefModelName().compareTo( rhs.getRequiredRefModelName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredIncludeRoot().compareTo( rhs.getRequiredIncludeRoot() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalRefSchemaTenantId() != null ) {
				Long lhsRefSchemaTenantId = getOptionalRefSchemaTenantId();
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					Long rhsRefSchemaTenantId = rhs.getOptionalRefSchemaTenantId();
					int cmp = lhsRefSchemaTenantId.compareTo( rhsRefSchemaTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalRefSchemaId() != null ) {
				Long lhsRefSchemaId = getOptionalRefSchemaId();
				if( rhs.getOptionalRefSchemaId() != null ) {
					Long rhsRefSchemaId = rhs.getOptionalRefSchemaId();
					int cmp = lhsRefSchemaId.compareTo( rhsRefSchemaId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrevTenantId() != null ) {
				Long lhsPrevTenantId = getOptionalPrevTenantId();
				if( rhs.getOptionalPrevTenantId() != null ) {
					Long rhsPrevTenantId = rhs.getOptionalPrevTenantId();
					int cmp = lhsPrevTenantId.compareTo( rhsPrevTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrevId() != null ) {
				Long lhsPrevId = getOptionalPrevId();
				if( rhs.getOptionalPrevId() != null ) {
					Long rhsPrevId = rhs.getOptionalPrevId();
					int cmp = lhsPrevId.compareTo( rhsPrevId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextTenantId() != null ) {
				Long lhsNextTenantId = getOptionalNextTenantId();
				if( rhs.getOptionalNextTenantId() != null ) {
					Long rhsNextTenantId = rhs.getOptionalNextTenantId();
					int cmp = lhsNextTenantId.compareTo( rhsNextTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextId() != null ) {
				Long lhsNextId = getOptionalNextId();
				if( rhs.getOptionalNextId() != null ) {
					Long rhsNextId = rhs.getOptionalNextId();
					int cmp = lhsNextId.compareTo( rhsNextId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSchemaRefBySchemaIdxKey ) {
			CFBamSchemaRefBySchemaIdxKey rhs = (CFBamSchemaRefBySchemaIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredSchemaId() < rhs.getRequiredSchemaId() ) {
				return( -1 );
			}
			else if( getRequiredSchemaId() > rhs.getRequiredSchemaId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamSchemaRefByUNameIdxKey ) {
			CFBamSchemaRefByUNameIdxKey rhs = (CFBamSchemaRefByUNameIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredSchemaId() < rhs.getRequiredSchemaId() ) {
				return( -1 );
			}
			else if( getRequiredSchemaId() > rhs.getRequiredSchemaId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSchemaRefByRefSchemaIdxKey ) {
			CFBamSchemaRefByRefSchemaIdxKey rhs = (CFBamSchemaRefByRefSchemaIdxKey)obj;

			if( getOptionalRefSchemaTenantId() != null ) {
				Long lhsRefSchemaTenantId = getOptionalRefSchemaTenantId();
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					Long rhsRefSchemaTenantId = rhs.getOptionalRefSchemaTenantId();
					int cmp = lhsRefSchemaTenantId.compareTo( rhsRefSchemaTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalRefSchemaId() != null ) {
				Long lhsRefSchemaId = getOptionalRefSchemaId();
				if( rhs.getOptionalRefSchemaId() != null ) {
					Long rhsRefSchemaId = rhs.getOptionalRefSchemaId();
					int cmp = lhsRefSchemaId.compareTo( rhsRefSchemaId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSchemaRefByPrevIdxKey ) {
			CFBamSchemaRefByPrevIdxKey rhs = (CFBamSchemaRefByPrevIdxKey)obj;

			if( getOptionalPrevTenantId() != null ) {
				Long lhsPrevTenantId = getOptionalPrevTenantId();
				if( rhs.getOptionalPrevTenantId() != null ) {
					Long rhsPrevTenantId = rhs.getOptionalPrevTenantId();
					int cmp = lhsPrevTenantId.compareTo( rhsPrevTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrevId() != null ) {
				Long lhsPrevId = getOptionalPrevId();
				if( rhs.getOptionalPrevId() != null ) {
					Long rhsPrevId = rhs.getOptionalPrevId();
					int cmp = lhsPrevId.compareTo( rhsPrevId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSchemaRefByNextIdxKey ) {
			CFBamSchemaRefByNextIdxKey rhs = (CFBamSchemaRefByNextIdxKey)obj;

			if( getOptionalNextTenantId() != null ) {
				Long lhsNextTenantId = getOptionalNextTenantId();
				if( rhs.getOptionalNextTenantId() != null ) {
					Long rhsNextTenantId = rhs.getOptionalNextTenantId();
					int cmp = lhsNextTenantId.compareTo( rhsNextTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextId() != null ) {
				Long lhsNextId = getOptionalNextId();
				if( rhs.getOptionalNextId() != null ) {
					Long rhsNextId = rhs.getOptionalNextId();
					int cmp = lhsNextId.compareTo( rhsNextId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
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
		if( src instanceof CFBamSchemaRefBuff ) {
			setSchemaRefBuff( (CFBamSchemaRefBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamSchemaRefBuff" );
		}
	}

	public void setSchemaRefBuff( CFBamSchemaRefBuff src ) {
		super.setScopeBuff( src );
		setRequiredSchemaId( src.getRequiredSchemaId() );
		setRequiredName( src.getRequiredName() );
		setRequiredRefModelName( src.getRequiredRefModelName() );
		setRequiredIncludeRoot( src.getRequiredIncludeRoot() );
		setOptionalRefSchemaTenantId( src.getOptionalRefSchemaTenantId() );
		setOptionalRefSchemaId( src.getOptionalRefSchemaId() );
		setOptionalPrevTenantId( src.getOptionalPrevTenantId() );
		setOptionalPrevId( src.getOptionalPrevId() );
		setOptionalNextTenantId( src.getOptionalNextTenantId() );
		setOptionalNextId( src.getOptionalNextId() );
	}

	public void set( CFBamScopeHBuff src ) {
		if( src instanceof CFBamSchemaRefHBuff ) {
			setSchemaRefBuff( (CFBamSchemaRefHBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamSchemaRefHBuff" );
		}
	}

	public void setSchemaRefBuff( CFBamSchemaRefHBuff src ) {
		super.setScopeBuff( src );
		setRequiredSchemaId( src.getRequiredSchemaId() );
		setRequiredName( src.getRequiredName() );
		setRequiredRefModelName( src.getRequiredRefModelName() );
		setRequiredIncludeRoot( src.getRequiredIncludeRoot() );
		setOptionalRefSchemaTenantId( src.getOptionalRefSchemaTenantId() );
		setOptionalRefSchemaId( src.getOptionalRefSchemaId() );
		setOptionalPrevTenantId( src.getOptionalPrevTenantId() );
		setOptionalPrevId( src.getOptionalPrevId() );
		setOptionalNextTenantId( src.getOptionalNextTenantId() );
		setOptionalNextId( src.getOptionalNextId() );
	}
}
