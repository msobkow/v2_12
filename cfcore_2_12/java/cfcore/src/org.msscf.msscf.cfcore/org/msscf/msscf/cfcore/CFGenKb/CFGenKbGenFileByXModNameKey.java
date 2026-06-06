// Description: Java 11 implementation of a GenFile by XModName index key object.

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

public class CFGenKbGenFileByXModNameKey
	implements Comparable<Object>,
		Serializable
{
	protected Long optionalModuleNameTenantId;
	protected Long optionalModuleNameGelCacheId;
	protected Long optionalModuleNameGelId;
	public CFGenKbGenFileByXModNameKey() {
		optionalModuleNameTenantId = null;
		optionalModuleNameGelCacheId = null;
		optionalModuleNameGelId = null;
	}

	public Long getOptionalModuleNameTenantId() {
		return( optionalModuleNameTenantId );
	}

	public void setOptionalModuleNameTenantId( Long value ) {
		if( value == null ) {
			optionalModuleNameTenantId = null;
		}
		else if( value < CFGenKbGenFileBuff.MODULENAMETENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalModuleNameTenantId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.MODULENAMETENANTID_MIN_VALUE );
		}
		else {
			optionalModuleNameTenantId = value;
		}
	}

	public Long getOptionalModuleNameGelCacheId() {
		return( optionalModuleNameGelCacheId );
	}

	public void setOptionalModuleNameGelCacheId( Long value ) {
		if( value == null ) {
			optionalModuleNameGelCacheId = null;
		}
		else if( value < CFGenKbGenFileBuff.MODULENAMEGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalModuleNameGelCacheId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.MODULENAMEGELCACHEID_MIN_VALUE );
		}
		else {
			optionalModuleNameGelCacheId = value;
		}
	}

	public Long getOptionalModuleNameGelId() {
		return( optionalModuleNameGelId );
	}

	public void setOptionalModuleNameGelId( Long value ) {
		if( value == null ) {
			optionalModuleNameGelId = null;
		}
		else if( value < CFGenKbGenFileBuff.MODULENAMEGELID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalModuleNameGelId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.MODULENAMEGELID_MIN_VALUE );
		}
		else {
			optionalModuleNameGelId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGenFileByXModNameKey ) {
			CFGenKbGenFileByXModNameKey rhs = (CFGenKbGenFileByXModNameKey)obj;
			if( getOptionalModuleNameTenantId() != null ) {
				if( rhs.getOptionalModuleNameTenantId() != null ) {
					if( ! getOptionalModuleNameTenantId().equals( rhs.getOptionalModuleNameTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalModuleNameTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalModuleNameGelCacheId() != null ) {
				if( rhs.getOptionalModuleNameGelCacheId() != null ) {
					if( ! getOptionalModuleNameGelCacheId().equals( rhs.getOptionalModuleNameGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalModuleNameGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalModuleNameGelId() != null ) {
				if( rhs.getOptionalModuleNameGelId() != null ) {
					if( ! getOptionalModuleNameGelId().equals( rhs.getOptionalModuleNameGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalModuleNameGelId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGenFileBuff ) {
			CFGenKbGenFileBuff rhs = (CFGenKbGenFileBuff)obj;
			if( getOptionalModuleNameTenantId() != null ) {
				if( rhs.getOptionalModuleNameTenantId() != null ) {
					if( ! getOptionalModuleNameTenantId().equals( rhs.getOptionalModuleNameTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalModuleNameTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalModuleNameGelCacheId() != null ) {
				if( rhs.getOptionalModuleNameGelCacheId() != null ) {
					if( ! getOptionalModuleNameGelCacheId().equals( rhs.getOptionalModuleNameGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalModuleNameGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalModuleNameGelId() != null ) {
				if( rhs.getOptionalModuleNameGelId() != null ) {
					if( ! getOptionalModuleNameGelId().equals( rhs.getOptionalModuleNameGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalModuleNameGelId() != null ) {
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
		if( getOptionalModuleNameTenantId() != null ) {
			hashCode = hashCode + getOptionalModuleNameTenantId().hashCode();
		}
		if( getOptionalModuleNameGelCacheId() != null ) {
			hashCode = hashCode + getOptionalModuleNameGelCacheId().hashCode();
		}
		if( getOptionalModuleNameGelId() != null ) {
			hashCode = hashCode + getOptionalModuleNameGelId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbGenFileByXModNameKey ) {
			CFGenKbGenFileByXModNameKey rhs = (CFGenKbGenFileByXModNameKey)obj;
			if( getOptionalModuleNameTenantId() != null ) {
				Long lhsModuleNameTenantId = getOptionalModuleNameTenantId();
				if( rhs.getOptionalModuleNameTenantId() != null ) {
					Long rhsModuleNameTenantId = rhs.getOptionalModuleNameTenantId();
					int cmp = lhsModuleNameTenantId.compareTo( rhsModuleNameTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalModuleNameTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalModuleNameGelCacheId() != null ) {
				Long lhsModuleNameGelCacheId = getOptionalModuleNameGelCacheId();
				if( rhs.getOptionalModuleNameGelCacheId() != null ) {
					Long rhsModuleNameGelCacheId = rhs.getOptionalModuleNameGelCacheId();
					int cmp = lhsModuleNameGelCacheId.compareTo( rhsModuleNameGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalModuleNameGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalModuleNameGelId() != null ) {
				Long lhsModuleNameGelId = getOptionalModuleNameGelId();
				if( rhs.getOptionalModuleNameGelId() != null ) {
					Long rhsModuleNameGelId = rhs.getOptionalModuleNameGelId();
					int cmp = lhsModuleNameGelId.compareTo( rhsModuleNameGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalModuleNameGelId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGenFileBuff ) {
			CFGenKbGenFileBuff rhs = (CFGenKbGenFileBuff)obj;
			if( getOptionalModuleNameTenantId() != null ) {
				Long lhsModuleNameTenantId = getOptionalModuleNameTenantId();
				if( rhs.getOptionalModuleNameTenantId() != null ) {
					Long rhsModuleNameTenantId = rhs.getOptionalModuleNameTenantId();
					int cmp = lhsModuleNameTenantId.compareTo( rhsModuleNameTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalModuleNameTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalModuleNameGelCacheId() != null ) {
				Long lhsModuleNameGelCacheId = getOptionalModuleNameGelCacheId();
				if( rhs.getOptionalModuleNameGelCacheId() != null ) {
					Long rhsModuleNameGelCacheId = rhs.getOptionalModuleNameGelCacheId();
					int cmp = lhsModuleNameGelCacheId.compareTo( rhsModuleNameGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalModuleNameGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalModuleNameGelId() != null ) {
				Long lhsModuleNameGelId = getOptionalModuleNameGelId();
				if( rhs.getOptionalModuleNameGelId() != null ) {
					Long rhsModuleNameGelId = rhs.getOptionalModuleNameGelId();
					int cmp = lhsModuleNameGelId.compareTo( rhsModuleNameGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalModuleNameGelId() != null ) {
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
		String ret = "<CFGenKbGenFileByXModName"
			+ " OptionalModuleNameTenantId=" + ( ( getOptionalModuleNameTenantId() == null ) ? "null" : "\"" + getOptionalModuleNameTenantId().toString() + "\"" )
			+ " OptionalModuleNameGelCacheId=" + ( ( getOptionalModuleNameGelCacheId() == null ) ? "null" : "\"" + getOptionalModuleNameGelCacheId().toString() + "\"" )
			+ " OptionalModuleNameGelId=" + ( ( getOptionalModuleNameGelId() == null ) ? "null" : "\"" + getOptionalModuleNameGelId().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
