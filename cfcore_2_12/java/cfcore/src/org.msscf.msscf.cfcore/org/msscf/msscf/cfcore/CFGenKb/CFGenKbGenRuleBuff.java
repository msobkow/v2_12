// Description: Java 11 implementation of a GenRule buffer object.

/*
 *	org.msscf.msscf.CFCore
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

public class CFGenKbGenRuleBuff
	extends CFGenKbGenItemBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "RUL";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long CARTRIDGEID_INIT_VALUE = 0L;
	public static final long ITEMID_INIT_VALUE = 0L;
	public static final String DEFINEDNEAR_INIT_VALUE = new String( "internal" );
	public static final String BODY_INIT_VALUE = new String( "" );
	public static final long BODYTENANTID_INIT_VALUE = 0L;
	public static final long BODYGELCACHEID_INIT_VALUE = 0L;
	public static final long BODYGELID_INIT_VALUE = 0L;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long CARTRIDGEID_MIN_VALUE = 0L;
	public static final long ITEMID_MIN_VALUE = 0L;
	public static final long BODYTENANTID_MIN_VALUE = 0L;
	public static final long BODYGELCACHEID_MIN_VALUE = 0L;
	public static final long BODYGELID_MIN_VALUE = 0L;
	public static final long ITEMID_MAX_VALUE = 2147483647L;
	protected String requiredDefinedNear;
	protected String requiredBody;
	protected Long optionalBodyTenantId;
	protected Long optionalBodyGelCacheId;
	protected Long optionalBodyGelId;
	public CFGenKbGenRuleBuff() {
		super();
		requiredDefinedNear = new String( CFGenKbGenRuleBuff.DEFINEDNEAR_INIT_VALUE );
		requiredBody = new String( CFGenKbGenRuleBuff.BODY_INIT_VALUE );
		optionalBodyTenantId = null;
		optionalBodyGelCacheId = null;
		optionalBodyGelId = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getRequiredDefinedNear() {
		return( requiredDefinedNear );
	}

	public void setRequiredDefinedNear( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredDefinedNear",
				1,
				"value" );
		}
		if( value.length() > 2000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredDefinedNear",
				1,
				"value.length()",
				value.length(),
				2000 );
		}
		requiredDefinedNear = value;
	}

	public String getRequiredBody() {
		return( requiredBody );
	}

	public void setRequiredBody( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredBody",
				1,
				"value" );
		}
		if( value.length() > 999999 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredBody",
				1,
				"value.length()",
				value.length(),
				999999 );
		}
		requiredBody = value;
	}

	public Long getOptionalBodyTenantId() {
		return( optionalBodyTenantId );
	}

	public void setOptionalBodyTenantId( Long value ) {
		if( value == null ) {
			optionalBodyTenantId = null;
		}
		else if( value < CFGenKbGenRuleBuff.BODYTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalBodyTenantId",
				1,
				"value",
				value,
				CFGenKbGenRuleBuff.BODYTENANTID_MIN_VALUE );
		}
		else {
			optionalBodyTenantId = value;
		}
	}

	public Long getOptionalBodyGelCacheId() {
		return( optionalBodyGelCacheId );
	}

	public void setOptionalBodyGelCacheId( Long value ) {
		if( value == null ) {
			optionalBodyGelCacheId = null;
		}
		else if( value < CFGenKbGenRuleBuff.BODYGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalBodyGelCacheId",
				1,
				"value",
				value,
				CFGenKbGenRuleBuff.BODYGELCACHEID_MIN_VALUE );
		}
		else {
			optionalBodyGelCacheId = value;
		}
	}

	public Long getOptionalBodyGelId() {
		return( optionalBodyGelId );
	}

	public void setOptionalBodyGelId( Long value ) {
		if( value == null ) {
			optionalBodyGelId = null;
		}
		else if( value < CFGenKbGenRuleBuff.BODYGELID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalBodyGelId",
				1,
				"value",
				value,
				CFGenKbGenRuleBuff.BODYGELID_MIN_VALUE );
		}
		else {
			optionalBodyGelId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGenRuleBuff ) {
			CFGenKbGenRuleBuff rhs = (CFGenKbGenRuleBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredCartridgeId() != rhs.getRequiredCartridgeId() ) {
				return( false );
			}
			if( getRequiredItemId() != rhs.getRequiredItemId() ) {
				return( false );
			}
			if( ! getRequiredDefinedNear().equals( rhs.getRequiredDefinedNear() ) ) {
				return( false );
			}
			if( ! getRequiredBody().equals( rhs.getRequiredBody() ) ) {
				return( false );
			}
			if( getOptionalBodyTenantId() != null ) {
				if( rhs.getOptionalBodyTenantId() != null ) {
					if( ! getOptionalBodyTenantId().equals( rhs.getOptionalBodyTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalBodyTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalBodyGelCacheId() != null ) {
				if( rhs.getOptionalBodyGelCacheId() != null ) {
					if( ! getOptionalBodyGelCacheId().equals( rhs.getOptionalBodyGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalBodyGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalBodyGelId() != null ) {
				if( rhs.getOptionalBodyGelId() != null ) {
					if( ! getOptionalBodyGelId().equals( rhs.getOptionalBodyGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalBodyGelId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGenItemPKey ) {
			CFGenKbGenItemPKey rhs = (CFGenKbGenItemPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredCartridgeId() != rhs.getRequiredCartridgeId() ) {
				return( false );
			}
			if( getRequiredItemId() != rhs.getRequiredItemId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGenRuleByBodyIdxKey ) {
			CFGenKbGenRuleByBodyIdxKey rhs = (CFGenKbGenRuleByBodyIdxKey)obj;
			if( getOptionalBodyTenantId() != null ) {
				if( rhs.getOptionalBodyTenantId() != null ) {
					if( ! getOptionalBodyTenantId().equals( rhs.getOptionalBodyTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalBodyTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalBodyGelCacheId() != null ) {
				if( rhs.getOptionalBodyGelCacheId() != null ) {
					if( ! getOptionalBodyGelCacheId().equals( rhs.getOptionalBodyGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalBodyGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalBodyGelId() != null ) {
				if( rhs.getOptionalBodyGelId() != null ) {
					if( ! getOptionalBodyGelId().equals( rhs.getOptionalBodyGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalBodyGelId() != null ) {
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
		if( getRequiredDefinedNear() != null ) {
			hashCode = hashCode + getRequiredDefinedNear().hashCode();
		}
		if( getRequiredBody() != null ) {
			hashCode = hashCode + getRequiredBody().hashCode();
		}
		if( getOptionalBodyTenantId() != null ) {
			hashCode = hashCode + getOptionalBodyTenantId().hashCode();
		}
		if( getOptionalBodyGelCacheId() != null ) {
			hashCode = hashCode + getOptionalBodyGelCacheId().hashCode();
		}
		if( getOptionalBodyGelId() != null ) {
			hashCode = hashCode + getOptionalBodyGelId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFGenKbGenRuleBuff ) {
			CFGenKbGenRuleBuff rhs = (CFGenKbGenRuleBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			{
				int cmp = getRequiredDefinedNear().compareTo( rhs.getRequiredDefinedNear() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredBody().compareTo( rhs.getRequiredBody() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalBodyTenantId() != null ) {
				Long lhsBodyTenantId = getOptionalBodyTenantId();
				if( rhs.getOptionalBodyTenantId() != null ) {
					Long rhsBodyTenantId = rhs.getOptionalBodyTenantId();
					int cmp = lhsBodyTenantId.compareTo( rhsBodyTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalBodyTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalBodyGelCacheId() != null ) {
				Long lhsBodyGelCacheId = getOptionalBodyGelCacheId();
				if( rhs.getOptionalBodyGelCacheId() != null ) {
					Long rhsBodyGelCacheId = rhs.getOptionalBodyGelCacheId();
					int cmp = lhsBodyGelCacheId.compareTo( rhsBodyGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalBodyGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalBodyGelId() != null ) {
				Long lhsBodyGelId = getOptionalBodyGelId();
				if( rhs.getOptionalBodyGelId() != null ) {
					Long rhsBodyGelId = rhs.getOptionalBodyGelId();
					int cmp = lhsBodyGelId.compareTo( rhsBodyGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalBodyGelId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGenItemPKey ) {
			CFGenKbGenItemPKey rhs = (CFGenKbGenItemPKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredCartridgeId() < rhs.getRequiredCartridgeId() ) {
				return( -1 );
			}
			else if( getRequiredCartridgeId() > rhs.getRequiredCartridgeId() ) {
				return( 1 );
			}
			if( getRequiredItemId() < rhs.getRequiredItemId() ) {
				return( -1 );
			}
			else if( getRequiredItemId() > rhs.getRequiredItemId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGenRuleByBodyIdxKey ) {
			CFGenKbGenRuleByBodyIdxKey rhs = (CFGenKbGenRuleByBodyIdxKey)obj;

			if( getOptionalBodyTenantId() != null ) {
				Long lhsBodyTenantId = getOptionalBodyTenantId();
				if( rhs.getOptionalBodyTenantId() != null ) {
					Long rhsBodyTenantId = rhs.getOptionalBodyTenantId();
					int cmp = lhsBodyTenantId.compareTo( rhsBodyTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalBodyTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalBodyGelCacheId() != null ) {
				Long lhsBodyGelCacheId = getOptionalBodyGelCacheId();
				if( rhs.getOptionalBodyGelCacheId() != null ) {
					Long rhsBodyGelCacheId = rhs.getOptionalBodyGelCacheId();
					int cmp = lhsBodyGelCacheId.compareTo( rhsBodyGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalBodyGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalBodyGelId() != null ) {
				Long lhsBodyGelId = getOptionalBodyGelId();
				if( rhs.getOptionalBodyGelId() != null ) {
					Long rhsBodyGelId = rhs.getOptionalBodyGelId();
					int cmp = lhsBodyGelId.compareTo( rhsBodyGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalBodyGelId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else {
			int retval = super.compareTo( obj );
			return( retval );
		}
	}

	public void set( CFGenKbGenItemBuff src ) {
		if( src instanceof CFGenKbGenRuleBuff ) {
			setGenRuleBuff( (CFGenKbGenRuleBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFGenKbGenRuleBuff" );
		}
	}

	public void setGenRuleBuff( CFGenKbGenRuleBuff src ) {
		super.setGenItemBuff( src );
		setRequiredDefinedNear( src.getRequiredDefinedNear() );
		setRequiredBody( src.getRequiredBody() );
		setOptionalBodyTenantId( src.getOptionalBodyTenantId() );
		setOptionalBodyGelCacheId( src.getOptionalBodyGelCacheId() );
		setOptionalBodyGelId( src.getOptionalBodyGelId() );
	}
}
