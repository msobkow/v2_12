// Description: Java 11 implementation of a GenFile by XExpFileName index key object.

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

public class CFGenKbGenFileByXExpFileNameKey
	implements Comparable<Object>,
		Serializable
{
	protected Long optionalExpansionFileNameTenantId;
	protected Long optionalExpansionFileNameGelCacheId;
	protected Long optionalExpansionFileNameGelId;
	public CFGenKbGenFileByXExpFileNameKey() {
		optionalExpansionFileNameTenantId = null;
		optionalExpansionFileNameGelCacheId = null;
		optionalExpansionFileNameGelId = null;
	}

	public Long getOptionalExpansionFileNameTenantId() {
		return( optionalExpansionFileNameTenantId );
	}

	public void setOptionalExpansionFileNameTenantId( Long value ) {
		if( value == null ) {
			optionalExpansionFileNameTenantId = null;
		}
		else if( value < CFGenKbGenFileBuff.EXPANSIONFILENAMETENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalExpansionFileNameTenantId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.EXPANSIONFILENAMETENANTID_MIN_VALUE );
		}
		else {
			optionalExpansionFileNameTenantId = value;
		}
	}

	public Long getOptionalExpansionFileNameGelCacheId() {
		return( optionalExpansionFileNameGelCacheId );
	}

	public void setOptionalExpansionFileNameGelCacheId( Long value ) {
		if( value == null ) {
			optionalExpansionFileNameGelCacheId = null;
		}
		else if( value < CFGenKbGenFileBuff.EXPANSIONFILENAMEGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalExpansionFileNameGelCacheId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.EXPANSIONFILENAMEGELCACHEID_MIN_VALUE );
		}
		else {
			optionalExpansionFileNameGelCacheId = value;
		}
	}

	public Long getOptionalExpansionFileNameGelId() {
		return( optionalExpansionFileNameGelId );
	}

	public void setOptionalExpansionFileNameGelId( Long value ) {
		if( value == null ) {
			optionalExpansionFileNameGelId = null;
		}
		else if( value < CFGenKbGenFileBuff.EXPANSIONFILENAMEGELID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalExpansionFileNameGelId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.EXPANSIONFILENAMEGELID_MIN_VALUE );
		}
		else {
			optionalExpansionFileNameGelId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGenFileByXExpFileNameKey ) {
			CFGenKbGenFileByXExpFileNameKey rhs = (CFGenKbGenFileByXExpFileNameKey)obj;
			if( getOptionalExpansionFileNameTenantId() != null ) {
				if( rhs.getOptionalExpansionFileNameTenantId() != null ) {
					if( ! getOptionalExpansionFileNameTenantId().equals( rhs.getOptionalExpansionFileNameTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionFileNameGelCacheId() != null ) {
				if( rhs.getOptionalExpansionFileNameGelCacheId() != null ) {
					if( ! getOptionalExpansionFileNameGelCacheId().equals( rhs.getOptionalExpansionFileNameGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionFileNameGelId() != null ) {
				if( rhs.getOptionalExpansionFileNameGelId() != null ) {
					if( ! getOptionalExpansionFileNameGelId().equals( rhs.getOptionalExpansionFileNameGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameGelId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGenFileBuff ) {
			CFGenKbGenFileBuff rhs = (CFGenKbGenFileBuff)obj;
			if( getOptionalExpansionFileNameTenantId() != null ) {
				if( rhs.getOptionalExpansionFileNameTenantId() != null ) {
					if( ! getOptionalExpansionFileNameTenantId().equals( rhs.getOptionalExpansionFileNameTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionFileNameGelCacheId() != null ) {
				if( rhs.getOptionalExpansionFileNameGelCacheId() != null ) {
					if( ! getOptionalExpansionFileNameGelCacheId().equals( rhs.getOptionalExpansionFileNameGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionFileNameGelId() != null ) {
				if( rhs.getOptionalExpansionFileNameGelId() != null ) {
					if( ! getOptionalExpansionFileNameGelId().equals( rhs.getOptionalExpansionFileNameGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameGelId() != null ) {
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
		if( getOptionalExpansionFileNameTenantId() != null ) {
			hashCode = hashCode + getOptionalExpansionFileNameTenantId().hashCode();
		}
		if( getOptionalExpansionFileNameGelCacheId() != null ) {
			hashCode = hashCode + getOptionalExpansionFileNameGelCacheId().hashCode();
		}
		if( getOptionalExpansionFileNameGelId() != null ) {
			hashCode = hashCode + getOptionalExpansionFileNameGelId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbGenFileByXExpFileNameKey ) {
			CFGenKbGenFileByXExpFileNameKey rhs = (CFGenKbGenFileByXExpFileNameKey)obj;
			if( getOptionalExpansionFileNameTenantId() != null ) {
				Long lhsExpansionFileNameTenantId = getOptionalExpansionFileNameTenantId();
				if( rhs.getOptionalExpansionFileNameTenantId() != null ) {
					Long rhsExpansionFileNameTenantId = rhs.getOptionalExpansionFileNameTenantId();
					int cmp = lhsExpansionFileNameTenantId.compareTo( rhsExpansionFileNameTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionFileNameGelCacheId() != null ) {
				Long lhsExpansionFileNameGelCacheId = getOptionalExpansionFileNameGelCacheId();
				if( rhs.getOptionalExpansionFileNameGelCacheId() != null ) {
					Long rhsExpansionFileNameGelCacheId = rhs.getOptionalExpansionFileNameGelCacheId();
					int cmp = lhsExpansionFileNameGelCacheId.compareTo( rhsExpansionFileNameGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionFileNameGelId() != null ) {
				Long lhsExpansionFileNameGelId = getOptionalExpansionFileNameGelId();
				if( rhs.getOptionalExpansionFileNameGelId() != null ) {
					Long rhsExpansionFileNameGelId = rhs.getOptionalExpansionFileNameGelId();
					int cmp = lhsExpansionFileNameGelId.compareTo( rhsExpansionFileNameGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameGelId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGenFileBuff ) {
			CFGenKbGenFileBuff rhs = (CFGenKbGenFileBuff)obj;
			if( getOptionalExpansionFileNameTenantId() != null ) {
				Long lhsExpansionFileNameTenantId = getOptionalExpansionFileNameTenantId();
				if( rhs.getOptionalExpansionFileNameTenantId() != null ) {
					Long rhsExpansionFileNameTenantId = rhs.getOptionalExpansionFileNameTenantId();
					int cmp = lhsExpansionFileNameTenantId.compareTo( rhsExpansionFileNameTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionFileNameGelCacheId() != null ) {
				Long lhsExpansionFileNameGelCacheId = getOptionalExpansionFileNameGelCacheId();
				if( rhs.getOptionalExpansionFileNameGelCacheId() != null ) {
					Long rhsExpansionFileNameGelCacheId = rhs.getOptionalExpansionFileNameGelCacheId();
					int cmp = lhsExpansionFileNameGelCacheId.compareTo( rhsExpansionFileNameGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionFileNameGelId() != null ) {
				Long lhsExpansionFileNameGelId = getOptionalExpansionFileNameGelId();
				if( rhs.getOptionalExpansionFileNameGelId() != null ) {
					Long rhsExpansionFileNameGelId = rhs.getOptionalExpansionFileNameGelId();
					int cmp = lhsExpansionFileNameGelId.compareTo( rhsExpansionFileNameGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameGelId() != null ) {
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
		String ret = "<CFGenKbGenFileByXExpFileName"
			+ " OptionalExpansionFileNameTenantId=" + ( ( getOptionalExpansionFileNameTenantId() == null ) ? "null" : "\"" + getOptionalExpansionFileNameTenantId().toString() + "\"" )
			+ " OptionalExpansionFileNameGelCacheId=" + ( ( getOptionalExpansionFileNameGelCacheId() == null ) ? "null" : "\"" + getOptionalExpansionFileNameGelCacheId().toString() + "\"" )
			+ " OptionalExpansionFileNameGelId=" + ( ( getOptionalExpansionFileNameGelId() == null ) ? "null" : "\"" + getOptionalExpansionFileNameGelId().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
