// Description: Java 11 implementation of a GelPop buffer object.

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

public class CFGenKbGelPopBuff
	extends CFGenKbGelInstructionBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "GPOP";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long GELCACHEID_INIT_VALUE = 0L;
	public static final long GELINSTID_INIT_VALUE = 0L;
	public static final String GOALTYPENAME_INIT_VALUE = new String( "" );
	public static final long REMAINDERTENANTID_INIT_VALUE = 0L;
	public static final long REMAINDERGELCACHEID_INIT_VALUE = 0L;
	public static final long REMAINDERINSTID_INIT_VALUE = 0L;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long GELCACHEID_MIN_VALUE = 0L;
	public static final long GELINSTID_MIN_VALUE = 0L;
	public static final long REMAINDERTENANTID_MIN_VALUE = 0L;
	public static final long REMAINDERGELCACHEID_MIN_VALUE = 0L;
	public static final long REMAINDERINSTID_MIN_VALUE = 0L;
	protected String requiredGoalTypeName;
	protected Long optionalRemainderTenantId;
	protected long requiredRemainderGelCacheId;
	protected Long optionalRemainderInstId;
	public CFGenKbGelPopBuff() {
		super();
		requiredGoalTypeName = new String( CFGenKbGelPopBuff.GOALTYPENAME_INIT_VALUE );
		optionalRemainderTenantId = null;
		requiredRemainderGelCacheId = CFGenKbGelPopBuff.REMAINDERGELCACHEID_INIT_VALUE;
		optionalRemainderInstId = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getRequiredGoalTypeName() {
		return( requiredGoalTypeName );
	}

	public void setRequiredGoalTypeName( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredGoalTypeName",
				1,
				"value" );
		}
		if( value.length() > 127 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredGoalTypeName",
				1,
				"value.length()",
				value.length(),
				127 );
		}
		requiredGoalTypeName = value;
	}

	public Long getOptionalRemainderTenantId() {
		return( optionalRemainderTenantId );
	}

	public void setOptionalRemainderTenantId( Long value ) {
		if( value == null ) {
			optionalRemainderTenantId = null;
		}
		else if( value < CFGenKbGelPopBuff.REMAINDERTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalRemainderTenantId",
				1,
				"value",
				value,
				CFGenKbGelPopBuff.REMAINDERTENANTID_MIN_VALUE );
		}
		else {
			optionalRemainderTenantId = value;
		}
	}

	public long getRequiredRemainderGelCacheId() {
		return( requiredRemainderGelCacheId );
	}

	public void setRequiredRemainderGelCacheId( long value ) {
		if( value < CFGenKbGelPopBuff.REMAINDERGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredRemainderGelCacheId",
				1,
				"value",
				value,
				CFGenKbGelPopBuff.REMAINDERGELCACHEID_MIN_VALUE );
		}
		requiredRemainderGelCacheId = value;
	}

	public Long getOptionalRemainderInstId() {
		return( optionalRemainderInstId );
	}

	public void setOptionalRemainderInstId( Long value ) {
		if( value == null ) {
			optionalRemainderInstId = null;
		}
		else if( value < CFGenKbGelPopBuff.REMAINDERINSTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalRemainderInstId",
				1,
				"value",
				value,
				CFGenKbGelPopBuff.REMAINDERINSTID_MIN_VALUE );
		}
		else {
			optionalRemainderInstId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGelPopBuff ) {
			CFGenKbGelPopBuff rhs = (CFGenKbGelPopBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredGelCacheId() != rhs.getRequiredGelCacheId() ) {
				return( false );
			}
			if( getRequiredGelInstId() != rhs.getRequiredGelInstId() ) {
				return( false );
			}
			if( ! getRequiredGoalTypeName().equals( rhs.getRequiredGoalTypeName() ) ) {
				return( false );
			}
			if( getOptionalRemainderTenantId() != null ) {
				if( rhs.getOptionalRemainderTenantId() != null ) {
					if( ! getOptionalRemainderTenantId().equals( rhs.getOptionalRemainderTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRemainderTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredRemainderGelCacheId() != rhs.getRequiredRemainderGelCacheId() ) {
				return( false );
			}
			if( getOptionalRemainderInstId() != null ) {
				if( rhs.getOptionalRemainderInstId() != null ) {
					if( ! getOptionalRemainderInstId().equals( rhs.getOptionalRemainderInstId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRemainderInstId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGelInstructionPKey ) {
			CFGenKbGelInstructionPKey rhs = (CFGenKbGelInstructionPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredGelCacheId() != rhs.getRequiredGelCacheId() ) {
				return( false );
			}
			if( getRequiredGelInstId() != rhs.getRequiredGelInstId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGelPopByRemainderIdxKey ) {
			CFGenKbGelPopByRemainderIdxKey rhs = (CFGenKbGelPopByRemainderIdxKey)obj;
			if( getOptionalRemainderTenantId() != null ) {
				if( rhs.getOptionalRemainderTenantId() != null ) {
					if( ! getOptionalRemainderTenantId().equals( rhs.getOptionalRemainderTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRemainderTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredRemainderGelCacheId() != rhs.getRequiredRemainderGelCacheId() ) {
				return( false );
			}
			if( getOptionalRemainderInstId() != null ) {
				if( rhs.getOptionalRemainderInstId() != null ) {
					if( ! getOptionalRemainderInstId().equals( rhs.getOptionalRemainderInstId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRemainderInstId() != null ) {
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
		if( getRequiredGoalTypeName() != null ) {
			hashCode = hashCode + getRequiredGoalTypeName().hashCode();
		}
		if( getOptionalRemainderTenantId() != null ) {
			hashCode = hashCode + getOptionalRemainderTenantId().hashCode();
		}
		hashCode = hashCode + (int)( getRequiredRemainderGelCacheId() );
		if( getOptionalRemainderInstId() != null ) {
			hashCode = hashCode + getOptionalRemainderInstId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFGenKbGelPopBuff ) {
			CFGenKbGelPopBuff rhs = (CFGenKbGelPopBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			{
				int cmp = getRequiredGoalTypeName().compareTo( rhs.getRequiredGoalTypeName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalRemainderTenantId() != null ) {
				Long lhsRemainderTenantId = getOptionalRemainderTenantId();
				if( rhs.getOptionalRemainderTenantId() != null ) {
					Long rhsRemainderTenantId = rhs.getOptionalRemainderTenantId();
					int cmp = lhsRemainderTenantId.compareTo( rhsRemainderTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRemainderTenantId() != null ) {
					return( -1 );
				}
			}
			if( getRequiredRemainderGelCacheId() < rhs.getRequiredRemainderGelCacheId() ) {
				return( -1 );
			}
			else if( getRequiredRemainderGelCacheId() > rhs.getRequiredRemainderGelCacheId() ) {
				return( 1 );
			}
			if( getOptionalRemainderInstId() != null ) {
				Long lhsRemainderInstId = getOptionalRemainderInstId();
				if( rhs.getOptionalRemainderInstId() != null ) {
					Long rhsRemainderInstId = rhs.getOptionalRemainderInstId();
					int cmp = lhsRemainderInstId.compareTo( rhsRemainderInstId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRemainderInstId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGelInstructionPKey ) {
			CFGenKbGelInstructionPKey rhs = (CFGenKbGelInstructionPKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredGelCacheId() < rhs.getRequiredGelCacheId() ) {
				return( -1 );
			}
			else if( getRequiredGelCacheId() > rhs.getRequiredGelCacheId() ) {
				return( 1 );
			}
			if( getRequiredGelInstId() < rhs.getRequiredGelInstId() ) {
				return( -1 );
			}
			else if( getRequiredGelInstId() > rhs.getRequiredGelInstId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGelPopByRemainderIdxKey ) {
			CFGenKbGelPopByRemainderIdxKey rhs = (CFGenKbGelPopByRemainderIdxKey)obj;

			if( getOptionalRemainderTenantId() != null ) {
				Long lhsRemainderTenantId = getOptionalRemainderTenantId();
				if( rhs.getOptionalRemainderTenantId() != null ) {
					Long rhsRemainderTenantId = rhs.getOptionalRemainderTenantId();
					int cmp = lhsRemainderTenantId.compareTo( rhsRemainderTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRemainderTenantId() != null ) {
					return( -1 );
				}
			}
			if( getRequiredRemainderGelCacheId() < rhs.getRequiredRemainderGelCacheId() ) {
				return( -1 );
			}
			else if( getRequiredRemainderGelCacheId() > rhs.getRequiredRemainderGelCacheId() ) {
				return( 1 );
			}
			if( getOptionalRemainderInstId() != null ) {
				Long lhsRemainderInstId = getOptionalRemainderInstId();
				if( rhs.getOptionalRemainderInstId() != null ) {
					Long rhsRemainderInstId = rhs.getOptionalRemainderInstId();
					int cmp = lhsRemainderInstId.compareTo( rhsRemainderInstId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRemainderInstId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else {
			int retval = super.compareTo( obj );
			return( retval );
		}
	}

	public void set( CFGenKbGelInstructionBuff src ) {
		if( src instanceof CFGenKbGelPopBuff ) {
			setGelPopBuff( (CFGenKbGelPopBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFGenKbGelPopBuff" );
		}
	}

	public void setGelPopBuff( CFGenKbGelPopBuff src ) {
		super.setGelInstructionBuff( src );
		setRequiredGoalTypeName( src.getRequiredGoalTypeName() );
		setOptionalRemainderTenantId( src.getOptionalRemainderTenantId() );
		setRequiredRemainderGelCacheId( src.getRequiredRemainderGelCacheId() );
		setOptionalRemainderInstId( src.getOptionalRemainderInstId() );
	}
}
