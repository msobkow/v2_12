// Description: Java 11 implementation of a GelCall by SeqIdx index key object.

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

public class CFGenKbGelCallBySeqIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected Long optionalSeqInstTenantId;
	protected Long optionalSeqInstGelCacheId;
	protected Long optionalSeqInstId;
	public CFGenKbGelCallBySeqIdxKey() {
		optionalSeqInstTenantId = null;
		optionalSeqInstGelCacheId = null;
		optionalSeqInstId = null;
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

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
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
		else if( obj instanceof CFGenKbGelCallBuff ) {
			CFGenKbGelCallBuff rhs = (CFGenKbGelCallBuff)obj;
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
		else {
			return( false );
		}
	}

	public int hashCode() {
		int hashCode = 0;
		if( getOptionalSeqInstTenantId() != null ) {
			hashCode = hashCode + getOptionalSeqInstTenantId().hashCode();
		}
		if( getOptionalSeqInstGelCacheId() != null ) {
			hashCode = hashCode + getOptionalSeqInstGelCacheId().hashCode();
		}
		if( getOptionalSeqInstId() != null ) {
			hashCode = hashCode + getOptionalSeqInstId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
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
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGelCallBuff ) {
			CFGenKbGelCallBuff rhs = (CFGenKbGelCallBuff)obj;
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
			return( 0 );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	public String toString() {
		String ret = "<CFGenKbGelCallBySeqIdx"
			+ " OptionalSeqInstTenantId=" + ( ( getOptionalSeqInstTenantId() == null ) ? "null" : "\"" + getOptionalSeqInstTenantId().toString() + "\"" )
			+ " OptionalSeqInstGelCacheId=" + ( ( getOptionalSeqInstGelCacheId() == null ) ? "null" : "\"" + getOptionalSeqInstGelCacheId().toString() + "\"" )
			+ " OptionalSeqInstId=" + ( ( getOptionalSeqInstId() == null ) ? "null" : "\"" + getOptionalSeqInstId().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
