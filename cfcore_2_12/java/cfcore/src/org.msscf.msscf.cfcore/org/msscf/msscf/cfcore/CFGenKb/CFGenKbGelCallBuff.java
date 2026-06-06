// Description: Java 11 implementation of a GelCall buffer object.

/*
 *	org.msscf.msscf.CFCore
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

public class CFGenKbGelCallBuff
	extends CFGenKbGelInstructionBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "GCAL";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long GELCACHEID_INIT_VALUE = 0L;
	public static final long GELINSTID_INIT_VALUE = 0L;
	public static final long SEQINSTTENANTID_INIT_VALUE = 0L;
	public static final long SEQINSTGELCACHEID_INIT_VALUE = 0L;
	public static final long SEQINSTID_INIT_VALUE = 0L;
	public static final long CALLINSTTENANTID_INIT_VALUE = 0L;
	public static final long CALLINSTGELCACHEID_INIT_VALUE = 0L;
	public static final long CALLINSTID_INIT_VALUE = 0L;
	public static final long PREVINSTTENANTID_INIT_VALUE = 0L;
	public static final long PREVINSTGELCACHEID_INIT_VALUE = 0L;
	public static final long PREVINSTGELINSTID_INIT_VALUE = 0L;
	public static final long NEXTINSTTENANTID_INIT_VALUE = 0L;
	public static final long NEXTINSTGELCACHEID_INIT_VALUE = 0L;
	public static final long NEXTINSTGELINSTID_INIT_VALUE = 0L;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long GELCACHEID_MIN_VALUE = 0L;
	public static final long GELINSTID_MIN_VALUE = 0L;
	public static final long SEQINSTTENANTID_MIN_VALUE = 0L;
	public static final long SEQINSTGELCACHEID_MIN_VALUE = 0L;
	public static final long SEQINSTID_MIN_VALUE = 0L;
	public static final long CALLINSTTENANTID_MIN_VALUE = 0L;
	public static final long CALLINSTGELCACHEID_MIN_VALUE = 0L;
	public static final long CALLINSTID_MIN_VALUE = 0L;
	public static final long PREVINSTTENANTID_MIN_VALUE = 0L;
	public static final long PREVINSTGELCACHEID_MIN_VALUE = 0L;
	public static final long PREVINSTGELINSTID_MIN_VALUE = 0L;
	public static final long NEXTINSTTENANTID_MIN_VALUE = 0L;
	public static final long NEXTINSTGELCACHEID_MIN_VALUE = 0L;
	public static final long NEXTINSTGELINSTID_MIN_VALUE = 0L;
	protected Long optionalSeqInstTenantId;
	protected Long optionalSeqInstGelCacheId;
	protected Long optionalSeqInstId;
	protected Long optionalCallInstTenantId;
	protected Long optionalCallInstGelCacheId;
	protected Long optionalCallInstId;
	protected Long optionalPrevInstTenantId;
	protected Long optionalPrevInstGelCacheId;
	protected Long optionalPrevInstGelInstId;
	protected Long optionalNextInstTenantId;
	protected Long optionalNextInstGelCacheId;
	protected Long optionalNextInstGelInstId;
	public CFGenKbGelCallBuff() {
		super();
		optionalSeqInstTenantId = null;
		optionalSeqInstGelCacheId = null;
		optionalSeqInstId = null;
		optionalCallInstTenantId = null;
		optionalCallInstGelCacheId = null;
		optionalCallInstId = null;
		optionalPrevInstTenantId = null;
		optionalPrevInstGelCacheId = null;
		optionalPrevInstGelInstId = null;
		optionalNextInstTenantId = null;
		optionalNextInstGelCacheId = null;
		optionalNextInstGelInstId = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public Long getOptionalSeqInstTenantId() {
		return( optionalSeqInstTenantId );
	}

	public void setOptionalSeqInstTenantId( Long value ) {
		if( value == null ) {
			optionalSeqInstTenantId = null;
		}
		else if( value < CFGenKbGelCallBuff.SEQINSTTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalSeqInstTenantId",
				1,
				"value",
				value,
				CFGenKbGelCallBuff.SEQINSTTENANTID_MIN_VALUE );
		}
		else {
			optionalSeqInstTenantId = value;
		}
	}

	public Long getOptionalSeqInstGelCacheId() {
		return( optionalSeqInstGelCacheId );
	}

	public void setOptionalSeqInstGelCacheId( Long value ) {
		if( value == null ) {
			optionalSeqInstGelCacheId = null;
		}
		else if( value < CFGenKbGelCallBuff.SEQINSTGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalSeqInstGelCacheId",
				1,
				"value",
				value,
				CFGenKbGelCallBuff.SEQINSTGELCACHEID_MIN_VALUE );
		}
		else {
			optionalSeqInstGelCacheId = value;
		}
	}

	public Long getOptionalSeqInstId() {
		return( optionalSeqInstId );
	}

	public void setOptionalSeqInstId( Long value ) {
		if( value == null ) {
			optionalSeqInstId = null;
		}
		else if( value < CFGenKbGelCallBuff.SEQINSTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalSeqInstId",
				1,
				"value",
				value,
				CFGenKbGelCallBuff.SEQINSTID_MIN_VALUE );
		}
		else {
			optionalSeqInstId = value;
		}
	}

	public Long getOptionalCallInstTenantId() {
		return( optionalCallInstTenantId );
	}

	public void setOptionalCallInstTenantId( Long value ) {
		if( value == null ) {
			optionalCallInstTenantId = null;
		}
		else if( value < CFGenKbGelCallBuff.CALLINSTTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalCallInstTenantId",
				1,
				"value",
				value,
				CFGenKbGelCallBuff.CALLINSTTENANTID_MIN_VALUE );
		}
		else {
			optionalCallInstTenantId = value;
		}
	}

	public Long getOptionalCallInstGelCacheId() {
		return( optionalCallInstGelCacheId );
	}

	public void setOptionalCallInstGelCacheId( Long value ) {
		if( value == null ) {
			optionalCallInstGelCacheId = null;
		}
		else if( value < CFGenKbGelCallBuff.CALLINSTGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalCallInstGelCacheId",
				1,
				"value",
				value,
				CFGenKbGelCallBuff.CALLINSTGELCACHEID_MIN_VALUE );
		}
		else {
			optionalCallInstGelCacheId = value;
		}
	}

	public Long getOptionalCallInstId() {
		return( optionalCallInstId );
	}

	public void setOptionalCallInstId( Long value ) {
		if( value == null ) {
			optionalCallInstId = null;
		}
		else if( value < CFGenKbGelCallBuff.CALLINSTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalCallInstId",
				1,
				"value",
				value,
				CFGenKbGelCallBuff.CALLINSTID_MIN_VALUE );
		}
		else {
			optionalCallInstId = value;
		}
	}

	public Long getOptionalPrevInstTenantId() {
		return( optionalPrevInstTenantId );
	}

	public void setOptionalPrevInstTenantId( Long value ) {
		if( value == null ) {
			optionalPrevInstTenantId = null;
		}
		else if( value < CFGenKbGelCallBuff.PREVINSTTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalPrevInstTenantId",
				1,
				"value",
				value,
				CFGenKbGelCallBuff.PREVINSTTENANTID_MIN_VALUE );
		}
		else {
			optionalPrevInstTenantId = value;
		}
	}

	public Long getOptionalPrevInstGelCacheId() {
		return( optionalPrevInstGelCacheId );
	}

	public void setOptionalPrevInstGelCacheId( Long value ) {
		if( value == null ) {
			optionalPrevInstGelCacheId = null;
		}
		else if( value < CFGenKbGelCallBuff.PREVINSTGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalPrevInstGelCacheId",
				1,
				"value",
				value,
				CFGenKbGelCallBuff.PREVINSTGELCACHEID_MIN_VALUE );
		}
		else {
			optionalPrevInstGelCacheId = value;
		}
	}

	public Long getOptionalPrevInstGelInstId() {
		return( optionalPrevInstGelInstId );
	}

	public void setOptionalPrevInstGelInstId( Long value ) {
		if( value == null ) {
			optionalPrevInstGelInstId = null;
		}
		else if( value < CFGenKbGelCallBuff.PREVINSTGELINSTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalPrevInstGelInstId",
				1,
				"value",
				value,
				CFGenKbGelCallBuff.PREVINSTGELINSTID_MIN_VALUE );
		}
		else {
			optionalPrevInstGelInstId = value;
		}
	}

	public Long getOptionalNextInstTenantId() {
		return( optionalNextInstTenantId );
	}

	public void setOptionalNextInstTenantId( Long value ) {
		if( value == null ) {
			optionalNextInstTenantId = null;
		}
		else if( value < CFGenKbGelCallBuff.NEXTINSTTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalNextInstTenantId",
				1,
				"value",
				value,
				CFGenKbGelCallBuff.NEXTINSTTENANTID_MIN_VALUE );
		}
		else {
			optionalNextInstTenantId = value;
		}
	}

	public Long getOptionalNextInstGelCacheId() {
		return( optionalNextInstGelCacheId );
	}

	public void setOptionalNextInstGelCacheId( Long value ) {
		if( value == null ) {
			optionalNextInstGelCacheId = null;
		}
		else if( value < CFGenKbGelCallBuff.NEXTINSTGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalNextInstGelCacheId",
				1,
				"value",
				value,
				CFGenKbGelCallBuff.NEXTINSTGELCACHEID_MIN_VALUE );
		}
		else {
			optionalNextInstGelCacheId = value;
		}
	}

	public Long getOptionalNextInstGelInstId() {
		return( optionalNextInstGelInstId );
	}

	public void setOptionalNextInstGelInstId( Long value ) {
		if( value == null ) {
			optionalNextInstGelInstId = null;
		}
		else if( value < CFGenKbGelCallBuff.NEXTINSTGELINSTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalNextInstGelInstId",
				1,
				"value",
				value,
				CFGenKbGelCallBuff.NEXTINSTGELINSTID_MIN_VALUE );
		}
		else {
			optionalNextInstGelInstId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGelCallBuff ) {
			CFGenKbGelCallBuff rhs = (CFGenKbGelCallBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredGelCacheId() != rhs.getRequiredGelCacheId() ) {
				return( false );
			}
			if( getRequiredGelInstId() != rhs.getRequiredGelInstId() ) {
				return( false );
			}
			if( getOptionalSeqInstTenantId() != null ) {
				if( rhs.getOptionalSeqInstTenantId() != null ) {
					if( ! getOptionalSeqInstTenantId().equals( rhs.getOptionalSeqInstTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSeqInstTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalSeqInstGelCacheId() != null ) {
				if( rhs.getOptionalSeqInstGelCacheId() != null ) {
					if( ! getOptionalSeqInstGelCacheId().equals( rhs.getOptionalSeqInstGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSeqInstGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalSeqInstId() != null ) {
				if( rhs.getOptionalSeqInstId() != null ) {
					if( ! getOptionalSeqInstId().equals( rhs.getOptionalSeqInstId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSeqInstId() != null ) {
					return( false );
				}
			}
			if( getOptionalCallInstTenantId() != null ) {
				if( rhs.getOptionalCallInstTenantId() != null ) {
					if( ! getOptionalCallInstTenantId().equals( rhs.getOptionalCallInstTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCallInstTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalCallInstGelCacheId() != null ) {
				if( rhs.getOptionalCallInstGelCacheId() != null ) {
					if( ! getOptionalCallInstGelCacheId().equals( rhs.getOptionalCallInstGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCallInstGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalCallInstId() != null ) {
				if( rhs.getOptionalCallInstId() != null ) {
					if( ! getOptionalCallInstId().equals( rhs.getOptionalCallInstId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCallInstId() != null ) {
					return( false );
				}
			}
			if( getOptionalPrevInstTenantId() != null ) {
				if( rhs.getOptionalPrevInstTenantId() != null ) {
					if( ! getOptionalPrevInstTenantId().equals( rhs.getOptionalPrevInstTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrevInstTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalPrevInstGelCacheId() != null ) {
				if( rhs.getOptionalPrevInstGelCacheId() != null ) {
					if( ! getOptionalPrevInstGelCacheId().equals( rhs.getOptionalPrevInstGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrevInstGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalPrevInstGelInstId() != null ) {
				if( rhs.getOptionalPrevInstGelInstId() != null ) {
					if( ! getOptionalPrevInstGelInstId().equals( rhs.getOptionalPrevInstGelInstId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrevInstGelInstId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextInstTenantId() != null ) {
				if( rhs.getOptionalNextInstTenantId() != null ) {
					if( ! getOptionalNextInstTenantId().equals( rhs.getOptionalNextInstTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNextInstTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextInstGelCacheId() != null ) {
				if( rhs.getOptionalNextInstGelCacheId() != null ) {
					if( ! getOptionalNextInstGelCacheId().equals( rhs.getOptionalNextInstGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNextInstGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextInstGelInstId() != null ) {
				if( rhs.getOptionalNextInstGelInstId() != null ) {
					if( ! getOptionalNextInstGelInstId().equals( rhs.getOptionalNextInstGelInstId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNextInstGelInstId() != null ) {
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
		else if( obj instanceof CFGenKbGelCallByCacheIdxKey ) {
			CFGenKbGelCallByCacheIdxKey rhs = (CFGenKbGelCallByCacheIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredGelCacheId() != rhs.getRequiredGelCacheId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGelCallBySeqIdxKey ) {
			CFGenKbGelCallBySeqIdxKey rhs = (CFGenKbGelCallBySeqIdxKey)obj;
			if( getOptionalSeqInstTenantId() != null ) {
				if( rhs.getOptionalSeqInstTenantId() != null ) {
					if( ! getOptionalSeqInstTenantId().equals( rhs.getOptionalSeqInstTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSeqInstTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalSeqInstGelCacheId() != null ) {
				if( rhs.getOptionalSeqInstGelCacheId() != null ) {
					if( ! getOptionalSeqInstGelCacheId().equals( rhs.getOptionalSeqInstGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSeqInstGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalSeqInstId() != null ) {
				if( rhs.getOptionalSeqInstId() != null ) {
					if( ! getOptionalSeqInstId().equals( rhs.getOptionalSeqInstId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSeqInstId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGelCallByCallInstIdxKey ) {
			CFGenKbGelCallByCallInstIdxKey rhs = (CFGenKbGelCallByCallInstIdxKey)obj;
			if( getOptionalCallInstTenantId() != null ) {
				if( rhs.getOptionalCallInstTenantId() != null ) {
					if( ! getOptionalCallInstTenantId().equals( rhs.getOptionalCallInstTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCallInstTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalCallInstGelCacheId() != null ) {
				if( rhs.getOptionalCallInstGelCacheId() != null ) {
					if( ! getOptionalCallInstGelCacheId().equals( rhs.getOptionalCallInstGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCallInstGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalCallInstId() != null ) {
				if( rhs.getOptionalCallInstId() != null ) {
					if( ! getOptionalCallInstId().equals( rhs.getOptionalCallInstId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCallInstId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGelCallByPrevInstIdxKey ) {
			CFGenKbGelCallByPrevInstIdxKey rhs = (CFGenKbGelCallByPrevInstIdxKey)obj;
			if( getOptionalPrevInstTenantId() != null ) {
				if( rhs.getOptionalPrevInstTenantId() != null ) {
					if( ! getOptionalPrevInstTenantId().equals( rhs.getOptionalPrevInstTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrevInstTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalPrevInstGelCacheId() != null ) {
				if( rhs.getOptionalPrevInstGelCacheId() != null ) {
					if( ! getOptionalPrevInstGelCacheId().equals( rhs.getOptionalPrevInstGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrevInstGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalPrevInstGelInstId() != null ) {
				if( rhs.getOptionalPrevInstGelInstId() != null ) {
					if( ! getOptionalPrevInstGelInstId().equals( rhs.getOptionalPrevInstGelInstId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrevInstGelInstId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGelCallByNextInstIdxKey ) {
			CFGenKbGelCallByNextInstIdxKey rhs = (CFGenKbGelCallByNextInstIdxKey)obj;
			if( getOptionalNextInstTenantId() != null ) {
				if( rhs.getOptionalNextInstTenantId() != null ) {
					if( ! getOptionalNextInstTenantId().equals( rhs.getOptionalNextInstTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNextInstTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextInstGelCacheId() != null ) {
				if( rhs.getOptionalNextInstGelCacheId() != null ) {
					if( ! getOptionalNextInstGelCacheId().equals( rhs.getOptionalNextInstGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNextInstGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextInstGelInstId() != null ) {
				if( rhs.getOptionalNextInstGelInstId() != null ) {
					if( ! getOptionalNextInstGelInstId().equals( rhs.getOptionalNextInstGelInstId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNextInstGelInstId() != null ) {
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
		if( getOptionalSeqInstTenantId() != null ) {
			hashCode = hashCode + getOptionalSeqInstTenantId().hashCode();
		}
		if( getOptionalSeqInstGelCacheId() != null ) {
			hashCode = hashCode + getOptionalSeqInstGelCacheId().hashCode();
		}
		if( getOptionalSeqInstId() != null ) {
			hashCode = hashCode + getOptionalSeqInstId().hashCode();
		}
		if( getOptionalCallInstTenantId() != null ) {
			hashCode = hashCode + getOptionalCallInstTenantId().hashCode();
		}
		if( getOptionalCallInstGelCacheId() != null ) {
			hashCode = hashCode + getOptionalCallInstGelCacheId().hashCode();
		}
		if( getOptionalCallInstId() != null ) {
			hashCode = hashCode + getOptionalCallInstId().hashCode();
		}
		if( getOptionalPrevInstTenantId() != null ) {
			hashCode = hashCode + getOptionalPrevInstTenantId().hashCode();
		}
		if( getOptionalPrevInstGelCacheId() != null ) {
			hashCode = hashCode + getOptionalPrevInstGelCacheId().hashCode();
		}
		if( getOptionalPrevInstGelInstId() != null ) {
			hashCode = hashCode + getOptionalPrevInstGelInstId().hashCode();
		}
		if( getOptionalNextInstTenantId() != null ) {
			hashCode = hashCode + getOptionalNextInstTenantId().hashCode();
		}
		if( getOptionalNextInstGelCacheId() != null ) {
			hashCode = hashCode + getOptionalNextInstGelCacheId().hashCode();
		}
		if( getOptionalNextInstGelInstId() != null ) {
			hashCode = hashCode + getOptionalNextInstGelInstId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFGenKbGelCallBuff ) {
			CFGenKbGelCallBuff rhs = (CFGenKbGelCallBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalSeqInstTenantId() != null ) {
				Long lhsSeqInstTenantId = getOptionalSeqInstTenantId();
				if( rhs.getOptionalSeqInstTenantId() != null ) {
					Long rhsSeqInstTenantId = rhs.getOptionalSeqInstTenantId();
					int cmp = lhsSeqInstTenantId.compareTo( rhsSeqInstTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSeqInstTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSeqInstGelCacheId() != null ) {
				Long lhsSeqInstGelCacheId = getOptionalSeqInstGelCacheId();
				if( rhs.getOptionalSeqInstGelCacheId() != null ) {
					Long rhsSeqInstGelCacheId = rhs.getOptionalSeqInstGelCacheId();
					int cmp = lhsSeqInstGelCacheId.compareTo( rhsSeqInstGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSeqInstGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSeqInstId() != null ) {
				Long lhsSeqInstId = getOptionalSeqInstId();
				if( rhs.getOptionalSeqInstId() != null ) {
					Long rhsSeqInstId = rhs.getOptionalSeqInstId();
					int cmp = lhsSeqInstId.compareTo( rhsSeqInstId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSeqInstId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCallInstTenantId() != null ) {
				Long lhsCallInstTenantId = getOptionalCallInstTenantId();
				if( rhs.getOptionalCallInstTenantId() != null ) {
					Long rhsCallInstTenantId = rhs.getOptionalCallInstTenantId();
					int cmp = lhsCallInstTenantId.compareTo( rhsCallInstTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCallInstTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCallInstGelCacheId() != null ) {
				Long lhsCallInstGelCacheId = getOptionalCallInstGelCacheId();
				if( rhs.getOptionalCallInstGelCacheId() != null ) {
					Long rhsCallInstGelCacheId = rhs.getOptionalCallInstGelCacheId();
					int cmp = lhsCallInstGelCacheId.compareTo( rhsCallInstGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCallInstGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCallInstId() != null ) {
				Long lhsCallInstId = getOptionalCallInstId();
				if( rhs.getOptionalCallInstId() != null ) {
					Long rhsCallInstId = rhs.getOptionalCallInstId();
					int cmp = lhsCallInstId.compareTo( rhsCallInstId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCallInstId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrevInstTenantId() != null ) {
				Long lhsPrevInstTenantId = getOptionalPrevInstTenantId();
				if( rhs.getOptionalPrevInstTenantId() != null ) {
					Long rhsPrevInstTenantId = rhs.getOptionalPrevInstTenantId();
					int cmp = lhsPrevInstTenantId.compareTo( rhsPrevInstTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevInstTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrevInstGelCacheId() != null ) {
				Long lhsPrevInstGelCacheId = getOptionalPrevInstGelCacheId();
				if( rhs.getOptionalPrevInstGelCacheId() != null ) {
					Long rhsPrevInstGelCacheId = rhs.getOptionalPrevInstGelCacheId();
					int cmp = lhsPrevInstGelCacheId.compareTo( rhsPrevInstGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevInstGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrevInstGelInstId() != null ) {
				Long lhsPrevInstGelInstId = getOptionalPrevInstGelInstId();
				if( rhs.getOptionalPrevInstGelInstId() != null ) {
					Long rhsPrevInstGelInstId = rhs.getOptionalPrevInstGelInstId();
					int cmp = lhsPrevInstGelInstId.compareTo( rhsPrevInstGelInstId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevInstGelInstId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextInstTenantId() != null ) {
				Long lhsNextInstTenantId = getOptionalNextInstTenantId();
				if( rhs.getOptionalNextInstTenantId() != null ) {
					Long rhsNextInstTenantId = rhs.getOptionalNextInstTenantId();
					int cmp = lhsNextInstTenantId.compareTo( rhsNextInstTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextInstTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextInstGelCacheId() != null ) {
				Long lhsNextInstGelCacheId = getOptionalNextInstGelCacheId();
				if( rhs.getOptionalNextInstGelCacheId() != null ) {
					Long rhsNextInstGelCacheId = rhs.getOptionalNextInstGelCacheId();
					int cmp = lhsNextInstGelCacheId.compareTo( rhsNextInstGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextInstGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextInstGelInstId() != null ) {
				Long lhsNextInstGelInstId = getOptionalNextInstGelInstId();
				if( rhs.getOptionalNextInstGelInstId() != null ) {
					Long rhsNextInstGelInstId = rhs.getOptionalNextInstGelInstId();
					int cmp = lhsNextInstGelInstId.compareTo( rhsNextInstGelInstId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextInstGelInstId() != null ) {
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
		else if( obj instanceof CFGenKbGelCallByCacheIdxKey ) {
			CFGenKbGelCallByCacheIdxKey rhs = (CFGenKbGelCallByCacheIdxKey)obj;

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
		else if( obj instanceof CFGenKbGelCallBySeqIdxKey ) {
			CFGenKbGelCallBySeqIdxKey rhs = (CFGenKbGelCallBySeqIdxKey)obj;

			if( getOptionalSeqInstTenantId() != null ) {
				Long lhsSeqInstTenantId = getOptionalSeqInstTenantId();
				if( rhs.getOptionalSeqInstTenantId() != null ) {
					Long rhsSeqInstTenantId = rhs.getOptionalSeqInstTenantId();
					int cmp = lhsSeqInstTenantId.compareTo( rhsSeqInstTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSeqInstTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSeqInstGelCacheId() != null ) {
				Long lhsSeqInstGelCacheId = getOptionalSeqInstGelCacheId();
				if( rhs.getOptionalSeqInstGelCacheId() != null ) {
					Long rhsSeqInstGelCacheId = rhs.getOptionalSeqInstGelCacheId();
					int cmp = lhsSeqInstGelCacheId.compareTo( rhsSeqInstGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSeqInstGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSeqInstId() != null ) {
				Long lhsSeqInstId = getOptionalSeqInstId();
				if( rhs.getOptionalSeqInstId() != null ) {
					Long rhsSeqInstId = rhs.getOptionalSeqInstId();
					int cmp = lhsSeqInstId.compareTo( rhsSeqInstId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSeqInstId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbGelCallByCallInstIdxKey ) {
			CFGenKbGelCallByCallInstIdxKey rhs = (CFGenKbGelCallByCallInstIdxKey)obj;

			if( getOptionalCallInstTenantId() != null ) {
				Long lhsCallInstTenantId = getOptionalCallInstTenantId();
				if( rhs.getOptionalCallInstTenantId() != null ) {
					Long rhsCallInstTenantId = rhs.getOptionalCallInstTenantId();
					int cmp = lhsCallInstTenantId.compareTo( rhsCallInstTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCallInstTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCallInstGelCacheId() != null ) {
				Long lhsCallInstGelCacheId = getOptionalCallInstGelCacheId();
				if( rhs.getOptionalCallInstGelCacheId() != null ) {
					Long rhsCallInstGelCacheId = rhs.getOptionalCallInstGelCacheId();
					int cmp = lhsCallInstGelCacheId.compareTo( rhsCallInstGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCallInstGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCallInstId() != null ) {
				Long lhsCallInstId = getOptionalCallInstId();
				if( rhs.getOptionalCallInstId() != null ) {
					Long rhsCallInstId = rhs.getOptionalCallInstId();
					int cmp = lhsCallInstId.compareTo( rhsCallInstId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCallInstId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbGelCallByPrevInstIdxKey ) {
			CFGenKbGelCallByPrevInstIdxKey rhs = (CFGenKbGelCallByPrevInstIdxKey)obj;

			if( getOptionalPrevInstTenantId() != null ) {
				Long lhsPrevInstTenantId = getOptionalPrevInstTenantId();
				if( rhs.getOptionalPrevInstTenantId() != null ) {
					Long rhsPrevInstTenantId = rhs.getOptionalPrevInstTenantId();
					int cmp = lhsPrevInstTenantId.compareTo( rhsPrevInstTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevInstTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrevInstGelCacheId() != null ) {
				Long lhsPrevInstGelCacheId = getOptionalPrevInstGelCacheId();
				if( rhs.getOptionalPrevInstGelCacheId() != null ) {
					Long rhsPrevInstGelCacheId = rhs.getOptionalPrevInstGelCacheId();
					int cmp = lhsPrevInstGelCacheId.compareTo( rhsPrevInstGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevInstGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrevInstGelInstId() != null ) {
				Long lhsPrevInstGelInstId = getOptionalPrevInstGelInstId();
				if( rhs.getOptionalPrevInstGelInstId() != null ) {
					Long rhsPrevInstGelInstId = rhs.getOptionalPrevInstGelInstId();
					int cmp = lhsPrevInstGelInstId.compareTo( rhsPrevInstGelInstId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevInstGelInstId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbGelCallByNextInstIdxKey ) {
			CFGenKbGelCallByNextInstIdxKey rhs = (CFGenKbGelCallByNextInstIdxKey)obj;

			if( getOptionalNextInstTenantId() != null ) {
				Long lhsNextInstTenantId = getOptionalNextInstTenantId();
				if( rhs.getOptionalNextInstTenantId() != null ) {
					Long rhsNextInstTenantId = rhs.getOptionalNextInstTenantId();
					int cmp = lhsNextInstTenantId.compareTo( rhsNextInstTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextInstTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextInstGelCacheId() != null ) {
				Long lhsNextInstGelCacheId = getOptionalNextInstGelCacheId();
				if( rhs.getOptionalNextInstGelCacheId() != null ) {
					Long rhsNextInstGelCacheId = rhs.getOptionalNextInstGelCacheId();
					int cmp = lhsNextInstGelCacheId.compareTo( rhsNextInstGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextInstGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextInstGelInstId() != null ) {
				Long lhsNextInstGelInstId = getOptionalNextInstGelInstId();
				if( rhs.getOptionalNextInstGelInstId() != null ) {
					Long rhsNextInstGelInstId = rhs.getOptionalNextInstGelInstId();
					int cmp = lhsNextInstGelInstId.compareTo( rhsNextInstGelInstId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextInstGelInstId() != null ) {
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
		if( src instanceof CFGenKbGelCallBuff ) {
			setGelCallBuff( (CFGenKbGelCallBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFGenKbGelCallBuff" );
		}
	}

	public void setGelCallBuff( CFGenKbGelCallBuff src ) {
		super.setGelInstructionBuff( src );
		setOptionalSeqInstTenantId( src.getOptionalSeqInstTenantId() );
		setOptionalSeqInstGelCacheId( src.getOptionalSeqInstGelCacheId() );
		setOptionalSeqInstId( src.getOptionalSeqInstId() );
		setOptionalCallInstTenantId( src.getOptionalCallInstTenantId() );
		setOptionalCallInstGelCacheId( src.getOptionalCallInstGelCacheId() );
		setOptionalCallInstId( src.getOptionalCallInstId() );
		setOptionalPrevInstTenantId( src.getOptionalPrevInstTenantId() );
		setOptionalPrevInstGelCacheId( src.getOptionalPrevInstGelCacheId() );
		setOptionalPrevInstGelInstId( src.getOptionalPrevInstGelInstId() );
		setOptionalNextInstTenantId( src.getOptionalNextInstTenantId() );
		setOptionalNextInstGelCacheId( src.getOptionalNextInstGelCacheId() );
		setOptionalNextInstGelInstId( src.getOptionalNextInstGelInstId() );
	}
}
