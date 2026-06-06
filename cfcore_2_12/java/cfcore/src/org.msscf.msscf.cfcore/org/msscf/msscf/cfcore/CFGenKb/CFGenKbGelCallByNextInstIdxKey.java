// Description: Java 11 implementation of a GelCall by NextInstIdx index key object.

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

public class CFGenKbGelCallByNextInstIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected Long optionalNextInstTenantId;
	protected Long optionalNextInstGelCacheId;
	protected Long optionalNextInstGelInstId;
	public CFGenKbGelCallByNextInstIdxKey() {
		optionalNextInstTenantId = null;
		optionalNextInstGelCacheId = null;
		optionalNextInstGelInstId = null;
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
		else if( obj instanceof CFGenKbGelCallBuff ) {
			CFGenKbGelCallBuff rhs = (CFGenKbGelCallBuff)obj;
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
			return( false );
		}
	}

	public int hashCode() {
		int hashCode = 0;
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
			return( 1 );
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
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGelCallBuff ) {
			CFGenKbGelCallBuff rhs = (CFGenKbGelCallBuff)obj;
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
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	public String toString() {
		String ret = "<CFGenKbGelCallByNextInstIdx"
			+ " OptionalNextInstTenantId=" + ( ( getOptionalNextInstTenantId() == null ) ? "null" : "\"" + getOptionalNextInstTenantId().toString() + "\"" )
			+ " OptionalNextInstGelCacheId=" + ( ( getOptionalNextInstGelCacheId() == null ) ? "null" : "\"" + getOptionalNextInstGelCacheId().toString() + "\"" )
			+ " OptionalNextInstGelInstId=" + ( ( getOptionalNextInstGelInstId() == null ) ? "null" : "\"" + getOptionalNextInstGelInstId().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
