// Description: Java 11 implementation of a GelInstruction buffer object.

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

public class CFGenKbGelInstructionBuff
{
	public final static String CLASS_CODE = "GINS";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long GELCACHEID_INIT_VALUE = 0L;
	public static final long GELINSTID_INIT_VALUE = 0L;
	public static final long CHAININSTTENANTID_INIT_VALUE = 0L;
	public static final long CHAININSTGELCACHEID_INIT_VALUE = 0L;
	public static final long CHAININSTGELINSTID_INIT_VALUE = 0L;
	public static final String SOURCETEXT_INIT_VALUE = new String( "" );
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long GELCACHEID_MIN_VALUE = 0L;
	public static final long GELINSTID_MIN_VALUE = 0L;
	public static final long CHAININSTTENANTID_MIN_VALUE = 0L;
	public static final long CHAININSTGELCACHEID_MIN_VALUE = 0L;
	public static final long CHAININSTGELINSTID_MIN_VALUE = 0L;
	protected long requiredTenantId;
	protected long requiredGelCacheId;
	protected long requiredGelInstId;
	protected Long optionalChainInstTenantId;
	protected Long optionalChainInstGelCacheId;
	protected Long optionalChainInstGelInstId;
	protected String requiredSourceText;
	protected int requiredRevision;
	public CFGenKbGelInstructionBuff() {
		requiredTenantId = CFGenKbGelInstructionBuff.TENANTID_INIT_VALUE;
		requiredGelCacheId = CFGenKbGelInstructionBuff.GELCACHEID_INIT_VALUE;
		requiredGelInstId = CFGenKbGelInstructionBuff.GELINSTID_INIT_VALUE;
		optionalChainInstTenantId = null;
		optionalChainInstGelCacheId = null;
		optionalChainInstGelInstId = null;
		requiredSourceText = new String( CFGenKbGelInstructionBuff.SOURCETEXT_INIT_VALUE );
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public long getRequiredTenantId() {
		return( requiredTenantId );
	}

	public void setRequiredTenantId( long value ) {
		if( value < CFGenKbGelInstructionBuff.TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTenantId",
				1,
				"value",
				value,
				CFGenKbGelInstructionBuff.TENANTID_MIN_VALUE );
		}
		requiredTenantId = value;
	}

	public long getRequiredGelCacheId() {
		return( requiredGelCacheId );
	}

	public void setRequiredGelCacheId( long value ) {
		if( value < CFGenKbGelInstructionBuff.GELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredGelCacheId",
				1,
				"value",
				value,
				CFGenKbGelInstructionBuff.GELCACHEID_MIN_VALUE );
		}
		requiredGelCacheId = value;
	}

	public long getRequiredGelInstId() {
		return( requiredGelInstId );
	}

	public void setRequiredGelInstId( long value ) {
		if( value < CFGenKbGelInstructionBuff.GELINSTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredGelInstId",
				1,
				"value",
				value,
				CFGenKbGelInstructionBuff.GELINSTID_MIN_VALUE );
		}
		requiredGelInstId = value;
	}

	public Long getOptionalChainInstTenantId() {
		return( optionalChainInstTenantId );
	}

	public void setOptionalChainInstTenantId( Long value ) {
		if( value == null ) {
			optionalChainInstTenantId = null;
		}
		else if( value < CFGenKbGelInstructionBuff.CHAININSTTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalChainInstTenantId",
				1,
				"value",
				value,
				CFGenKbGelInstructionBuff.CHAININSTTENANTID_MIN_VALUE );
		}
		else {
			optionalChainInstTenantId = value;
		}
	}

	public Long getOptionalChainInstGelCacheId() {
		return( optionalChainInstGelCacheId );
	}

	public void setOptionalChainInstGelCacheId( Long value ) {
		if( value == null ) {
			optionalChainInstGelCacheId = null;
		}
		else if( value < CFGenKbGelInstructionBuff.CHAININSTGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalChainInstGelCacheId",
				1,
				"value",
				value,
				CFGenKbGelInstructionBuff.CHAININSTGELCACHEID_MIN_VALUE );
		}
		else {
			optionalChainInstGelCacheId = value;
		}
	}

	public Long getOptionalChainInstGelInstId() {
		return( optionalChainInstGelInstId );
	}

	public void setOptionalChainInstGelInstId( Long value ) {
		if( value == null ) {
			optionalChainInstGelInstId = null;
		}
		else if( value < CFGenKbGelInstructionBuff.CHAININSTGELINSTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalChainInstGelInstId",
				1,
				"value",
				value,
				CFGenKbGelInstructionBuff.CHAININSTGELINSTID_MIN_VALUE );
		}
		else {
			optionalChainInstGelInstId = value;
		}
	}

	public String getRequiredSourceText() {
		return( requiredSourceText );
	}

	public void setRequiredSourceText( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredSourceText",
				1,
				"value" );
		}
		if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredSourceText",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		requiredSourceText = value;
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
		else if( obj instanceof CFGenKbGelInstructionBuff ) {
			CFGenKbGelInstructionBuff rhs = (CFGenKbGelInstructionBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredGelCacheId() != rhs.getRequiredGelCacheId() ) {
				return( false );
			}
			if( getRequiredGelInstId() != rhs.getRequiredGelInstId() ) {
				return( false );
			}
			if( getOptionalChainInstTenantId() != null ) {
				if( rhs.getOptionalChainInstTenantId() != null ) {
					if( ! getOptionalChainInstTenantId().equals( rhs.getOptionalChainInstTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalChainInstTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalChainInstGelCacheId() != null ) {
				if( rhs.getOptionalChainInstGelCacheId() != null ) {
					if( ! getOptionalChainInstGelCacheId().equals( rhs.getOptionalChainInstGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalChainInstGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalChainInstGelInstId() != null ) {
				if( rhs.getOptionalChainInstGelInstId() != null ) {
					if( ! getOptionalChainInstGelInstId().equals( rhs.getOptionalChainInstGelInstId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalChainInstGelInstId() != null ) {
					return( false );
				}
			}
			if( ! getRequiredSourceText().equals( rhs.getRequiredSourceText() ) ) {
				return( false );
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
		else if( obj instanceof CFGenKbGelInstructionByTenantIdxKey ) {
			CFGenKbGelInstructionByTenantIdxKey rhs = (CFGenKbGelInstructionByTenantIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGelInstructionByGelCacheIdxKey ) {
			CFGenKbGelInstructionByGelCacheIdxKey rhs = (CFGenKbGelInstructionByGelCacheIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredGelCacheId() != rhs.getRequiredGelCacheId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGelInstructionByChainIdxKey ) {
			CFGenKbGelInstructionByChainIdxKey rhs = (CFGenKbGelInstructionByChainIdxKey)obj;
			if( getOptionalChainInstTenantId() != null ) {
				if( rhs.getOptionalChainInstTenantId() != null ) {
					if( ! getOptionalChainInstTenantId().equals( rhs.getOptionalChainInstTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalChainInstTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalChainInstGelCacheId() != null ) {
				if( rhs.getOptionalChainInstGelCacheId() != null ) {
					if( ! getOptionalChainInstGelCacheId().equals( rhs.getOptionalChainInstGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalChainInstGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalChainInstGelInstId() != null ) {
				if( rhs.getOptionalChainInstGelInstId() != null ) {
					if( ! getOptionalChainInstGelInstId().equals( rhs.getOptionalChainInstGelInstId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalChainInstGelInstId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			return( false );
		}
	}

	public int hashCode() {
		int hashCode = 0;
		hashCode = hashCode + (int)( getRequiredTenantId() );
		hashCode = hashCode + (int)( getRequiredGelCacheId() );
		hashCode = hashCode + (int)( getRequiredGelInstId() );
		if( getOptionalChainInstTenantId() != null ) {
			hashCode = hashCode + getOptionalChainInstTenantId().hashCode();
		}
		if( getOptionalChainInstGelCacheId() != null ) {
			hashCode = hashCode + getOptionalChainInstGelCacheId().hashCode();
		}
		if( getOptionalChainInstGelInstId() != null ) {
			hashCode = hashCode + getOptionalChainInstGelInstId().hashCode();
		}
		if( getRequiredSourceText() != null ) {
			hashCode = hashCode + getRequiredSourceText().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFGenKbGelInstructionBuff ) {
			CFGenKbGelInstructionBuff rhs = (CFGenKbGelInstructionBuff)obj;
			int retval = 0;
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
			if( getOptionalChainInstTenantId() != null ) {
				Long lhsChainInstTenantId = getOptionalChainInstTenantId();
				if( rhs.getOptionalChainInstTenantId() != null ) {
					Long rhsChainInstTenantId = rhs.getOptionalChainInstTenantId();
					int cmp = lhsChainInstTenantId.compareTo( rhsChainInstTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalChainInstTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalChainInstGelCacheId() != null ) {
				Long lhsChainInstGelCacheId = getOptionalChainInstGelCacheId();
				if( rhs.getOptionalChainInstGelCacheId() != null ) {
					Long rhsChainInstGelCacheId = rhs.getOptionalChainInstGelCacheId();
					int cmp = lhsChainInstGelCacheId.compareTo( rhsChainInstGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalChainInstGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalChainInstGelInstId() != null ) {
				Long lhsChainInstGelInstId = getOptionalChainInstGelInstId();
				if( rhs.getOptionalChainInstGelInstId() != null ) {
					Long rhsChainInstGelInstId = rhs.getOptionalChainInstGelInstId();
					int cmp = lhsChainInstGelInstId.compareTo( rhsChainInstGelInstId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalChainInstGelInstId() != null ) {
					return( -1 );
				}
			}
			{
				int cmp = getRequiredSourceText().compareTo( rhs.getRequiredSourceText() );
				if( cmp != 0 ) {
					return( cmp );
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
		else if( obj instanceof CFGenKbGelInstructionByTenantIdxKey ) {
			CFGenKbGelInstructionByTenantIdxKey rhs = (CFGenKbGelInstructionByTenantIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbGelInstructionByGelCacheIdxKey ) {
			CFGenKbGelInstructionByGelCacheIdxKey rhs = (CFGenKbGelInstructionByGelCacheIdxKey)obj;

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
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbGelInstructionByChainIdxKey ) {
			CFGenKbGelInstructionByChainIdxKey rhs = (CFGenKbGelInstructionByChainIdxKey)obj;

			if( getOptionalChainInstTenantId() != null ) {
				Long lhsChainInstTenantId = getOptionalChainInstTenantId();
				if( rhs.getOptionalChainInstTenantId() != null ) {
					Long rhsChainInstTenantId = rhs.getOptionalChainInstTenantId();
					int cmp = lhsChainInstTenantId.compareTo( rhsChainInstTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalChainInstTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalChainInstGelCacheId() != null ) {
				Long lhsChainInstGelCacheId = getOptionalChainInstGelCacheId();
				if( rhs.getOptionalChainInstGelCacheId() != null ) {
					Long rhsChainInstGelCacheId = rhs.getOptionalChainInstGelCacheId();
					int cmp = lhsChainInstGelCacheId.compareTo( rhsChainInstGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalChainInstGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalChainInstGelInstId() != null ) {
				Long lhsChainInstGelInstId = getOptionalChainInstGelInstId();
				if( rhs.getOptionalChainInstGelInstId() != null ) {
					Long rhsChainInstGelInstId = rhs.getOptionalChainInstGelInstId();
					int cmp = lhsChainInstGelInstId.compareTo( rhsChainInstGelInstId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalChainInstGelInstId() != null ) {
					return( -1 );
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

	public void set( CFGenKbGelInstructionBuff src ) {
		setGelInstructionBuff( src );
	}

	public void setGelInstructionBuff( CFGenKbGelInstructionBuff src ) {
		setRequiredTenantId( src.getRequiredTenantId() );
		setRequiredGelCacheId( src.getRequiredGelCacheId() );
		setRequiredGelInstId( src.getRequiredGelInstId() );
		setOptionalChainInstTenantId( src.getOptionalChainInstTenantId() );
		setOptionalChainInstGelCacheId( src.getOptionalChainInstGelCacheId() );
		setOptionalChainInstGelInstId( src.getOptionalChainInstGelInstId() );
		setRequiredSourceText( src.getRequiredSourceText() );
		setRequiredRevision( src.getRequiredRevision() );
	}
}
