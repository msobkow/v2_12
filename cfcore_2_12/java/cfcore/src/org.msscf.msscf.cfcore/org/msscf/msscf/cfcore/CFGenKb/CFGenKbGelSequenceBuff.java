// Description: Java 11 implementation of a GelSequence buffer object.

/*
 *	org.msscf.msscf.CFCore
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

public class CFGenKbGelSequenceBuff
	extends CFGenKbGelInstructionBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "GSEQ";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long GELCACHEID_INIT_VALUE = 0L;
	public static final long GELINSTID_INIT_VALUE = 0L;
	public static final long FIRSTINSTTENANTID_INIT_VALUE = 0L;
	public static final long FIRSTINSTGELCACHEID_INIT_VALUE = 0L;
	public static final long FIRSTINSTID_INIT_VALUE = 0L;
	public static final long LASTINSTTENANTID_INIT_VALUE = 0L;
	public static final long LASTINSTGELCACHEID_INIT_VALUE = 0L;
	public static final long LASTINSTID_INIT_VALUE = 0L;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long GELCACHEID_MIN_VALUE = 0L;
	public static final long GELINSTID_MIN_VALUE = 0L;
	public static final long FIRSTINSTTENANTID_MIN_VALUE = 0L;
	public static final long FIRSTINSTGELCACHEID_MIN_VALUE = 0L;
	public static final long FIRSTINSTID_MIN_VALUE = 0L;
	public static final long LASTINSTTENANTID_MIN_VALUE = 0L;
	public static final long LASTINSTGELCACHEID_MIN_VALUE = 0L;
	public static final long LASTINSTID_MIN_VALUE = 0L;
	protected Long optionalFirstInstTenantId;
	protected Long optionalFirstInstGelCacheId;
	protected Long optionalFirstInstId;
	protected Long optionalLastInstTenantId;
	protected Long optionalLastInstGelCacheId;
	protected Long optionalLastInstId;
	public CFGenKbGelSequenceBuff() {
		super();
		optionalFirstInstTenantId = null;
		optionalFirstInstGelCacheId = null;
		optionalFirstInstId = null;
		optionalLastInstTenantId = null;
		optionalLastInstGelCacheId = null;
		optionalLastInstId = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public Long getOptionalFirstInstTenantId() {
		return( optionalFirstInstTenantId );
	}

	public void setOptionalFirstInstTenantId( Long value ) {
		if( value == null ) {
			optionalFirstInstTenantId = null;
		}
		else if( value < CFGenKbGelSequenceBuff.FIRSTINSTTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalFirstInstTenantId",
				1,
				"value",
				value,
				CFGenKbGelSequenceBuff.FIRSTINSTTENANTID_MIN_VALUE );
		}
		else {
			optionalFirstInstTenantId = value;
		}
	}

	public Long getOptionalFirstInstGelCacheId() {
		return( optionalFirstInstGelCacheId );
	}

	public void setOptionalFirstInstGelCacheId( Long value ) {
		if( value == null ) {
			optionalFirstInstGelCacheId = null;
		}
		else if( value < CFGenKbGelSequenceBuff.FIRSTINSTGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalFirstInstGelCacheId",
				1,
				"value",
				value,
				CFGenKbGelSequenceBuff.FIRSTINSTGELCACHEID_MIN_VALUE );
		}
		else {
			optionalFirstInstGelCacheId = value;
		}
	}

	public Long getOptionalFirstInstId() {
		return( optionalFirstInstId );
	}

	public void setOptionalFirstInstId( Long value ) {
		if( value == null ) {
			optionalFirstInstId = null;
		}
		else if( value < CFGenKbGelSequenceBuff.FIRSTINSTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalFirstInstId",
				1,
				"value",
				value,
				CFGenKbGelSequenceBuff.FIRSTINSTID_MIN_VALUE );
		}
		else {
			optionalFirstInstId = value;
		}
	}

	public Long getOptionalLastInstTenantId() {
		return( optionalLastInstTenantId );
	}

	public void setOptionalLastInstTenantId( Long value ) {
		if( value == null ) {
			optionalLastInstTenantId = null;
		}
		else if( value < CFGenKbGelSequenceBuff.LASTINSTTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalLastInstTenantId",
				1,
				"value",
				value,
				CFGenKbGelSequenceBuff.LASTINSTTENANTID_MIN_VALUE );
		}
		else {
			optionalLastInstTenantId = value;
		}
	}

	public Long getOptionalLastInstGelCacheId() {
		return( optionalLastInstGelCacheId );
	}

	public void setOptionalLastInstGelCacheId( Long value ) {
		if( value == null ) {
			optionalLastInstGelCacheId = null;
		}
		else if( value < CFGenKbGelSequenceBuff.LASTINSTGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalLastInstGelCacheId",
				1,
				"value",
				value,
				CFGenKbGelSequenceBuff.LASTINSTGELCACHEID_MIN_VALUE );
		}
		else {
			optionalLastInstGelCacheId = value;
		}
	}

	public Long getOptionalLastInstId() {
		return( optionalLastInstId );
	}

	public void setOptionalLastInstId( Long value ) {
		if( value == null ) {
			optionalLastInstId = null;
		}
		else if( value < CFGenKbGelSequenceBuff.LASTINSTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalLastInstId",
				1,
				"value",
				value,
				CFGenKbGelSequenceBuff.LASTINSTID_MIN_VALUE );
		}
		else {
			optionalLastInstId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGelSequenceBuff ) {
			CFGenKbGelSequenceBuff rhs = (CFGenKbGelSequenceBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredGelCacheId() != rhs.getRequiredGelCacheId() ) {
				return( false );
			}
			if( getRequiredGelInstId() != rhs.getRequiredGelInstId() ) {
				return( false );
			}
			if( getOptionalFirstInstTenantId() != null ) {
				if( rhs.getOptionalFirstInstTenantId() != null ) {
					if( ! getOptionalFirstInstTenantId().equals( rhs.getOptionalFirstInstTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalFirstInstTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalFirstInstGelCacheId() != null ) {
				if( rhs.getOptionalFirstInstGelCacheId() != null ) {
					if( ! getOptionalFirstInstGelCacheId().equals( rhs.getOptionalFirstInstGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalFirstInstGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalFirstInstId() != null ) {
				if( rhs.getOptionalFirstInstId() != null ) {
					if( ! getOptionalFirstInstId().equals( rhs.getOptionalFirstInstId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalFirstInstId() != null ) {
					return( false );
				}
			}
			if( getOptionalLastInstTenantId() != null ) {
				if( rhs.getOptionalLastInstTenantId() != null ) {
					if( ! getOptionalLastInstTenantId().equals( rhs.getOptionalLastInstTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLastInstTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalLastInstGelCacheId() != null ) {
				if( rhs.getOptionalLastInstGelCacheId() != null ) {
					if( ! getOptionalLastInstGelCacheId().equals( rhs.getOptionalLastInstGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLastInstGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalLastInstId() != null ) {
				if( rhs.getOptionalLastInstId() != null ) {
					if( ! getOptionalLastInstId().equals( rhs.getOptionalLastInstId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLastInstId() != null ) {
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
		else if( obj instanceof CFGenKbGelSequenceByFirstInstIdxKey ) {
			CFGenKbGelSequenceByFirstInstIdxKey rhs = (CFGenKbGelSequenceByFirstInstIdxKey)obj;
			if( getOptionalFirstInstTenantId() != null ) {
				if( rhs.getOptionalFirstInstTenantId() != null ) {
					if( ! getOptionalFirstInstTenantId().equals( rhs.getOptionalFirstInstTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalFirstInstTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalFirstInstGelCacheId() != null ) {
				if( rhs.getOptionalFirstInstGelCacheId() != null ) {
					if( ! getOptionalFirstInstGelCacheId().equals( rhs.getOptionalFirstInstGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalFirstInstGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalFirstInstId() != null ) {
				if( rhs.getOptionalFirstInstId() != null ) {
					if( ! getOptionalFirstInstId().equals( rhs.getOptionalFirstInstId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalFirstInstId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGelSequenceByLastInstIdxKey ) {
			CFGenKbGelSequenceByLastInstIdxKey rhs = (CFGenKbGelSequenceByLastInstIdxKey)obj;
			if( getOptionalLastInstTenantId() != null ) {
				if( rhs.getOptionalLastInstTenantId() != null ) {
					if( ! getOptionalLastInstTenantId().equals( rhs.getOptionalLastInstTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLastInstTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalLastInstGelCacheId() != null ) {
				if( rhs.getOptionalLastInstGelCacheId() != null ) {
					if( ! getOptionalLastInstGelCacheId().equals( rhs.getOptionalLastInstGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLastInstGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalLastInstId() != null ) {
				if( rhs.getOptionalLastInstId() != null ) {
					if( ! getOptionalLastInstId().equals( rhs.getOptionalLastInstId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLastInstId() != null ) {
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
		if( getOptionalFirstInstTenantId() != null ) {
			hashCode = hashCode + getOptionalFirstInstTenantId().hashCode();
		}
		if( getOptionalFirstInstGelCacheId() != null ) {
			hashCode = hashCode + getOptionalFirstInstGelCacheId().hashCode();
		}
		if( getOptionalFirstInstId() != null ) {
			hashCode = hashCode + getOptionalFirstInstId().hashCode();
		}
		if( getOptionalLastInstTenantId() != null ) {
			hashCode = hashCode + getOptionalLastInstTenantId().hashCode();
		}
		if( getOptionalLastInstGelCacheId() != null ) {
			hashCode = hashCode + getOptionalLastInstGelCacheId().hashCode();
		}
		if( getOptionalLastInstId() != null ) {
			hashCode = hashCode + getOptionalLastInstId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFGenKbGelSequenceBuff ) {
			CFGenKbGelSequenceBuff rhs = (CFGenKbGelSequenceBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalFirstInstTenantId() != null ) {
				Long lhsFirstInstTenantId = getOptionalFirstInstTenantId();
				if( rhs.getOptionalFirstInstTenantId() != null ) {
					Long rhsFirstInstTenantId = rhs.getOptionalFirstInstTenantId();
					int cmp = lhsFirstInstTenantId.compareTo( rhsFirstInstTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFirstInstTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalFirstInstGelCacheId() != null ) {
				Long lhsFirstInstGelCacheId = getOptionalFirstInstGelCacheId();
				if( rhs.getOptionalFirstInstGelCacheId() != null ) {
					Long rhsFirstInstGelCacheId = rhs.getOptionalFirstInstGelCacheId();
					int cmp = lhsFirstInstGelCacheId.compareTo( rhsFirstInstGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFirstInstGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalFirstInstId() != null ) {
				Long lhsFirstInstId = getOptionalFirstInstId();
				if( rhs.getOptionalFirstInstId() != null ) {
					Long rhsFirstInstId = rhs.getOptionalFirstInstId();
					int cmp = lhsFirstInstId.compareTo( rhsFirstInstId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFirstInstId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLastInstTenantId() != null ) {
				Long lhsLastInstTenantId = getOptionalLastInstTenantId();
				if( rhs.getOptionalLastInstTenantId() != null ) {
					Long rhsLastInstTenantId = rhs.getOptionalLastInstTenantId();
					int cmp = lhsLastInstTenantId.compareTo( rhsLastInstTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLastInstTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLastInstGelCacheId() != null ) {
				Long lhsLastInstGelCacheId = getOptionalLastInstGelCacheId();
				if( rhs.getOptionalLastInstGelCacheId() != null ) {
					Long rhsLastInstGelCacheId = rhs.getOptionalLastInstGelCacheId();
					int cmp = lhsLastInstGelCacheId.compareTo( rhsLastInstGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLastInstGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLastInstId() != null ) {
				Long lhsLastInstId = getOptionalLastInstId();
				if( rhs.getOptionalLastInstId() != null ) {
					Long rhsLastInstId = rhs.getOptionalLastInstId();
					int cmp = lhsLastInstId.compareTo( rhsLastInstId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLastInstId() != null ) {
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
		else if( obj instanceof CFGenKbGelSequenceByFirstInstIdxKey ) {
			CFGenKbGelSequenceByFirstInstIdxKey rhs = (CFGenKbGelSequenceByFirstInstIdxKey)obj;

			if( getOptionalFirstInstTenantId() != null ) {
				Long lhsFirstInstTenantId = getOptionalFirstInstTenantId();
				if( rhs.getOptionalFirstInstTenantId() != null ) {
					Long rhsFirstInstTenantId = rhs.getOptionalFirstInstTenantId();
					int cmp = lhsFirstInstTenantId.compareTo( rhsFirstInstTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFirstInstTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalFirstInstGelCacheId() != null ) {
				Long lhsFirstInstGelCacheId = getOptionalFirstInstGelCacheId();
				if( rhs.getOptionalFirstInstGelCacheId() != null ) {
					Long rhsFirstInstGelCacheId = rhs.getOptionalFirstInstGelCacheId();
					int cmp = lhsFirstInstGelCacheId.compareTo( rhsFirstInstGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFirstInstGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalFirstInstId() != null ) {
				Long lhsFirstInstId = getOptionalFirstInstId();
				if( rhs.getOptionalFirstInstId() != null ) {
					Long rhsFirstInstId = rhs.getOptionalFirstInstId();
					int cmp = lhsFirstInstId.compareTo( rhsFirstInstId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFirstInstId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbGelSequenceByLastInstIdxKey ) {
			CFGenKbGelSequenceByLastInstIdxKey rhs = (CFGenKbGelSequenceByLastInstIdxKey)obj;

			if( getOptionalLastInstTenantId() != null ) {
				Long lhsLastInstTenantId = getOptionalLastInstTenantId();
				if( rhs.getOptionalLastInstTenantId() != null ) {
					Long rhsLastInstTenantId = rhs.getOptionalLastInstTenantId();
					int cmp = lhsLastInstTenantId.compareTo( rhsLastInstTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLastInstTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLastInstGelCacheId() != null ) {
				Long lhsLastInstGelCacheId = getOptionalLastInstGelCacheId();
				if( rhs.getOptionalLastInstGelCacheId() != null ) {
					Long rhsLastInstGelCacheId = rhs.getOptionalLastInstGelCacheId();
					int cmp = lhsLastInstGelCacheId.compareTo( rhsLastInstGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLastInstGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLastInstId() != null ) {
				Long lhsLastInstId = getOptionalLastInstId();
				if( rhs.getOptionalLastInstId() != null ) {
					Long rhsLastInstId = rhs.getOptionalLastInstId();
					int cmp = lhsLastInstId.compareTo( rhsLastInstId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLastInstId() != null ) {
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
		if( src instanceof CFGenKbGelSequenceBuff ) {
			setGelSequenceBuff( (CFGenKbGelSequenceBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFGenKbGelSequenceBuff" );
		}
	}

	public void setGelSequenceBuff( CFGenKbGelSequenceBuff src ) {
		super.setGelInstructionBuff( src );
		setOptionalFirstInstTenantId( src.getOptionalFirstInstTenantId() );
		setOptionalFirstInstGelCacheId( src.getOptionalFirstInstGelCacheId() );
		setOptionalFirstInstId( src.getOptionalFirstInstId() );
		setOptionalLastInstTenantId( src.getOptionalLastInstTenantId() );
		setOptionalLastInstGelCacheId( src.getOptionalLastInstGelCacheId() );
		setOptionalLastInstId( src.getOptionalLastInstId() );
	}
}
