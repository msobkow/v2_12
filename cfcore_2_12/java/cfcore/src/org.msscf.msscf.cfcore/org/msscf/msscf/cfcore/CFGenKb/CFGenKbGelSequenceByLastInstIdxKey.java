// Description: Java 11 implementation of a GelSequence by LastInstIdx index key object.

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

public class CFGenKbGelSequenceByLastInstIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected Long optionalLastInstTenantId;
	protected Long optionalLastInstGelCacheId;
	protected Long optionalLastInstId;
	public CFGenKbGelSequenceByLastInstIdxKey() {
		optionalLastInstTenantId = null;
		optionalLastInstGelCacheId = null;
		optionalLastInstId = null;
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
		else if( obj instanceof CFGenKbGelSequenceBuff ) {
			CFGenKbGelSequenceBuff rhs = (CFGenKbGelSequenceBuff)obj;
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
			return( false );
		}
	}

	public int hashCode() {
		int hashCode = 0;
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
			return( 1 );
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
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGelSequenceBuff ) {
			CFGenKbGelSequenceBuff rhs = (CFGenKbGelSequenceBuff)obj;
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
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	public String toString() {
		String ret = "<CFGenKbGelSequenceByLastInstIdx"
			+ " OptionalLastInstTenantId=" + ( ( getOptionalLastInstTenantId() == null ) ? "null" : "\"" + getOptionalLastInstTenantId().toString() + "\"" )
			+ " OptionalLastInstGelCacheId=" + ( ( getOptionalLastInstGelCacheId() == null ) ? "null" : "\"" + getOptionalLastInstGelCacheId().toString() + "\"" )
			+ " OptionalLastInstId=" + ( ( getOptionalLastInstId() == null ) ? "null" : "\"" + getOptionalLastInstId().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
