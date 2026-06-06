// Description: Java 11 implementation of a GenFile by XExpClsName index key object.

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

public class CFGenKbGenFileByXExpClsNameKey
	implements Comparable<Object>,
		Serializable
{
	protected Long optionalExpansionClassNameTenantId;
	protected Long optionalExpansionClassNameGelCacheId;
	protected Long optionalExpansionClassNameGelId;
	public CFGenKbGenFileByXExpClsNameKey() {
		optionalExpansionClassNameTenantId = null;
		optionalExpansionClassNameGelCacheId = null;
		optionalExpansionClassNameGelId = null;
	}

	public Long getOptionalExpansionClassNameTenantId() {
		return( optionalExpansionClassNameTenantId );
	}

	public void setOptionalExpansionClassNameTenantId( Long value ) {
		if( value == null ) {
			optionalExpansionClassNameTenantId = null;
		}
		else if( value < CFGenKbGenFileBuff.EXPANSIONCLASSNAMETENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalExpansionClassNameTenantId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.EXPANSIONCLASSNAMETENANTID_MIN_VALUE );
		}
		else {
			optionalExpansionClassNameTenantId = value;
		}
	}

	public Long getOptionalExpansionClassNameGelCacheId() {
		return( optionalExpansionClassNameGelCacheId );
	}

	public void setOptionalExpansionClassNameGelCacheId( Long value ) {
		if( value == null ) {
			optionalExpansionClassNameGelCacheId = null;
		}
		else if( value < CFGenKbGenFileBuff.EXPANSIONCLASSNAMEGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalExpansionClassNameGelCacheId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.EXPANSIONCLASSNAMEGELCACHEID_MIN_VALUE );
		}
		else {
			optionalExpansionClassNameGelCacheId = value;
		}
	}

	public Long getOptionalExpansionClassNameGelId() {
		return( optionalExpansionClassNameGelId );
	}

	public void setOptionalExpansionClassNameGelId( Long value ) {
		if( value == null ) {
			optionalExpansionClassNameGelId = null;
		}
		else if( value < CFGenKbGenFileBuff.EXPANSIONCLASSNAMEGELID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalExpansionClassNameGelId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.EXPANSIONCLASSNAMEGELID_MIN_VALUE );
		}
		else {
			optionalExpansionClassNameGelId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGenFileByXExpClsNameKey ) {
			CFGenKbGenFileByXExpClsNameKey rhs = (CFGenKbGenFileByXExpClsNameKey)obj;
			if( getOptionalExpansionClassNameTenantId() != null ) {
				if( rhs.getOptionalExpansionClassNameTenantId() != null ) {
					if( ! getOptionalExpansionClassNameTenantId().equals( rhs.getOptionalExpansionClassNameTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionClassNameGelCacheId() != null ) {
				if( rhs.getOptionalExpansionClassNameGelCacheId() != null ) {
					if( ! getOptionalExpansionClassNameGelCacheId().equals( rhs.getOptionalExpansionClassNameGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionClassNameGelId() != null ) {
				if( rhs.getOptionalExpansionClassNameGelId() != null ) {
					if( ! getOptionalExpansionClassNameGelId().equals( rhs.getOptionalExpansionClassNameGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameGelId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGenFileBuff ) {
			CFGenKbGenFileBuff rhs = (CFGenKbGenFileBuff)obj;
			if( getOptionalExpansionClassNameTenantId() != null ) {
				if( rhs.getOptionalExpansionClassNameTenantId() != null ) {
					if( ! getOptionalExpansionClassNameTenantId().equals( rhs.getOptionalExpansionClassNameTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionClassNameGelCacheId() != null ) {
				if( rhs.getOptionalExpansionClassNameGelCacheId() != null ) {
					if( ! getOptionalExpansionClassNameGelCacheId().equals( rhs.getOptionalExpansionClassNameGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionClassNameGelId() != null ) {
				if( rhs.getOptionalExpansionClassNameGelId() != null ) {
					if( ! getOptionalExpansionClassNameGelId().equals( rhs.getOptionalExpansionClassNameGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameGelId() != null ) {
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
		if( getOptionalExpansionClassNameTenantId() != null ) {
			hashCode = hashCode + getOptionalExpansionClassNameTenantId().hashCode();
		}
		if( getOptionalExpansionClassNameGelCacheId() != null ) {
			hashCode = hashCode + getOptionalExpansionClassNameGelCacheId().hashCode();
		}
		if( getOptionalExpansionClassNameGelId() != null ) {
			hashCode = hashCode + getOptionalExpansionClassNameGelId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbGenFileByXExpClsNameKey ) {
			CFGenKbGenFileByXExpClsNameKey rhs = (CFGenKbGenFileByXExpClsNameKey)obj;
			if( getOptionalExpansionClassNameTenantId() != null ) {
				Long lhsExpansionClassNameTenantId = getOptionalExpansionClassNameTenantId();
				if( rhs.getOptionalExpansionClassNameTenantId() != null ) {
					Long rhsExpansionClassNameTenantId = rhs.getOptionalExpansionClassNameTenantId();
					int cmp = lhsExpansionClassNameTenantId.compareTo( rhsExpansionClassNameTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionClassNameGelCacheId() != null ) {
				Long lhsExpansionClassNameGelCacheId = getOptionalExpansionClassNameGelCacheId();
				if( rhs.getOptionalExpansionClassNameGelCacheId() != null ) {
					Long rhsExpansionClassNameGelCacheId = rhs.getOptionalExpansionClassNameGelCacheId();
					int cmp = lhsExpansionClassNameGelCacheId.compareTo( rhsExpansionClassNameGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionClassNameGelId() != null ) {
				Long lhsExpansionClassNameGelId = getOptionalExpansionClassNameGelId();
				if( rhs.getOptionalExpansionClassNameGelId() != null ) {
					Long rhsExpansionClassNameGelId = rhs.getOptionalExpansionClassNameGelId();
					int cmp = lhsExpansionClassNameGelId.compareTo( rhsExpansionClassNameGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameGelId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGenFileBuff ) {
			CFGenKbGenFileBuff rhs = (CFGenKbGenFileBuff)obj;
			if( getOptionalExpansionClassNameTenantId() != null ) {
				Long lhsExpansionClassNameTenantId = getOptionalExpansionClassNameTenantId();
				if( rhs.getOptionalExpansionClassNameTenantId() != null ) {
					Long rhsExpansionClassNameTenantId = rhs.getOptionalExpansionClassNameTenantId();
					int cmp = lhsExpansionClassNameTenantId.compareTo( rhsExpansionClassNameTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionClassNameGelCacheId() != null ) {
				Long lhsExpansionClassNameGelCacheId = getOptionalExpansionClassNameGelCacheId();
				if( rhs.getOptionalExpansionClassNameGelCacheId() != null ) {
					Long rhsExpansionClassNameGelCacheId = rhs.getOptionalExpansionClassNameGelCacheId();
					int cmp = lhsExpansionClassNameGelCacheId.compareTo( rhsExpansionClassNameGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionClassNameGelId() != null ) {
				Long lhsExpansionClassNameGelId = getOptionalExpansionClassNameGelId();
				if( rhs.getOptionalExpansionClassNameGelId() != null ) {
					Long rhsExpansionClassNameGelId = rhs.getOptionalExpansionClassNameGelId();
					int cmp = lhsExpansionClassNameGelId.compareTo( rhsExpansionClassNameGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameGelId() != null ) {
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
		String ret = "<CFGenKbGenFileByXExpClsName"
			+ " OptionalExpansionClassNameTenantId=" + ( ( getOptionalExpansionClassNameTenantId() == null ) ? "null" : "\"" + getOptionalExpansionClassNameTenantId().toString() + "\"" )
			+ " OptionalExpansionClassNameGelCacheId=" + ( ( getOptionalExpansionClassNameGelCacheId() == null ) ? "null" : "\"" + getOptionalExpansionClassNameGelCacheId().toString() + "\"" )
			+ " OptionalExpansionClassNameGelId=" + ( ( getOptionalExpansionClassNameGelId() == null ) ? "null" : "\"" + getOptionalExpansionClassNameGelId().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
