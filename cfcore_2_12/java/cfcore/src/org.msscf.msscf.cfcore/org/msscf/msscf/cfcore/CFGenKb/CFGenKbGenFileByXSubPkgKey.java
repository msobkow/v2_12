// Description: Java 11 implementation of a GenFile by XSubPkg index key object.

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

public class CFGenKbGenFileByXSubPkgKey
	implements Comparable<Object>,
		Serializable
{
	protected Long optionalSubPackageTenantId;
	protected Long optionalSubPackageGelCacheId;
	protected Long optionalSubPackageGelId;
	public CFGenKbGenFileByXSubPkgKey() {
		optionalSubPackageTenantId = null;
		optionalSubPackageGelCacheId = null;
		optionalSubPackageGelId = null;
	}

	public Long getOptionalSubPackageTenantId() {
		return( optionalSubPackageTenantId );
	}

	public void setOptionalSubPackageTenantId( Long value ) {
		if( value == null ) {
			optionalSubPackageTenantId = null;
		}
		else if( value < CFGenKbGenFileBuff.SUBPACKAGETENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalSubPackageTenantId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.SUBPACKAGETENANTID_MIN_VALUE );
		}
		else {
			optionalSubPackageTenantId = value;
		}
	}

	public Long getOptionalSubPackageGelCacheId() {
		return( optionalSubPackageGelCacheId );
	}

	public void setOptionalSubPackageGelCacheId( Long value ) {
		if( value == null ) {
			optionalSubPackageGelCacheId = null;
		}
		else if( value < CFGenKbGenFileBuff.SUBPACKAGEGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalSubPackageGelCacheId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.SUBPACKAGEGELCACHEID_MIN_VALUE );
		}
		else {
			optionalSubPackageGelCacheId = value;
		}
	}

	public Long getOptionalSubPackageGelId() {
		return( optionalSubPackageGelId );
	}

	public void setOptionalSubPackageGelId( Long value ) {
		if( value == null ) {
			optionalSubPackageGelId = null;
		}
		else if( value < CFGenKbGenFileBuff.SUBPACKAGEGELID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalSubPackageGelId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.SUBPACKAGEGELID_MIN_VALUE );
		}
		else {
			optionalSubPackageGelId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGenFileByXSubPkgKey ) {
			CFGenKbGenFileByXSubPkgKey rhs = (CFGenKbGenFileByXSubPkgKey)obj;
			if( getOptionalSubPackageTenantId() != null ) {
				if( rhs.getOptionalSubPackageTenantId() != null ) {
					if( ! getOptionalSubPackageTenantId().equals( rhs.getOptionalSubPackageTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSubPackageTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalSubPackageGelCacheId() != null ) {
				if( rhs.getOptionalSubPackageGelCacheId() != null ) {
					if( ! getOptionalSubPackageGelCacheId().equals( rhs.getOptionalSubPackageGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSubPackageGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalSubPackageGelId() != null ) {
				if( rhs.getOptionalSubPackageGelId() != null ) {
					if( ! getOptionalSubPackageGelId().equals( rhs.getOptionalSubPackageGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSubPackageGelId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGenFileBuff ) {
			CFGenKbGenFileBuff rhs = (CFGenKbGenFileBuff)obj;
			if( getOptionalSubPackageTenantId() != null ) {
				if( rhs.getOptionalSubPackageTenantId() != null ) {
					if( ! getOptionalSubPackageTenantId().equals( rhs.getOptionalSubPackageTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSubPackageTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalSubPackageGelCacheId() != null ) {
				if( rhs.getOptionalSubPackageGelCacheId() != null ) {
					if( ! getOptionalSubPackageGelCacheId().equals( rhs.getOptionalSubPackageGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSubPackageGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalSubPackageGelId() != null ) {
				if( rhs.getOptionalSubPackageGelId() != null ) {
					if( ! getOptionalSubPackageGelId().equals( rhs.getOptionalSubPackageGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSubPackageGelId() != null ) {
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
		if( getOptionalSubPackageTenantId() != null ) {
			hashCode = hashCode + getOptionalSubPackageTenantId().hashCode();
		}
		if( getOptionalSubPackageGelCacheId() != null ) {
			hashCode = hashCode + getOptionalSubPackageGelCacheId().hashCode();
		}
		if( getOptionalSubPackageGelId() != null ) {
			hashCode = hashCode + getOptionalSubPackageGelId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbGenFileByXSubPkgKey ) {
			CFGenKbGenFileByXSubPkgKey rhs = (CFGenKbGenFileByXSubPkgKey)obj;
			if( getOptionalSubPackageTenantId() != null ) {
				Long lhsSubPackageTenantId = getOptionalSubPackageTenantId();
				if( rhs.getOptionalSubPackageTenantId() != null ) {
					Long rhsSubPackageTenantId = rhs.getOptionalSubPackageTenantId();
					int cmp = lhsSubPackageTenantId.compareTo( rhsSubPackageTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSubPackageTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSubPackageGelCacheId() != null ) {
				Long lhsSubPackageGelCacheId = getOptionalSubPackageGelCacheId();
				if( rhs.getOptionalSubPackageGelCacheId() != null ) {
					Long rhsSubPackageGelCacheId = rhs.getOptionalSubPackageGelCacheId();
					int cmp = lhsSubPackageGelCacheId.compareTo( rhsSubPackageGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSubPackageGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSubPackageGelId() != null ) {
				Long lhsSubPackageGelId = getOptionalSubPackageGelId();
				if( rhs.getOptionalSubPackageGelId() != null ) {
					Long rhsSubPackageGelId = rhs.getOptionalSubPackageGelId();
					int cmp = lhsSubPackageGelId.compareTo( rhsSubPackageGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSubPackageGelId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGenFileBuff ) {
			CFGenKbGenFileBuff rhs = (CFGenKbGenFileBuff)obj;
			if( getOptionalSubPackageTenantId() != null ) {
				Long lhsSubPackageTenantId = getOptionalSubPackageTenantId();
				if( rhs.getOptionalSubPackageTenantId() != null ) {
					Long rhsSubPackageTenantId = rhs.getOptionalSubPackageTenantId();
					int cmp = lhsSubPackageTenantId.compareTo( rhsSubPackageTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSubPackageTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSubPackageGelCacheId() != null ) {
				Long lhsSubPackageGelCacheId = getOptionalSubPackageGelCacheId();
				if( rhs.getOptionalSubPackageGelCacheId() != null ) {
					Long rhsSubPackageGelCacheId = rhs.getOptionalSubPackageGelCacheId();
					int cmp = lhsSubPackageGelCacheId.compareTo( rhsSubPackageGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSubPackageGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSubPackageGelId() != null ) {
				Long lhsSubPackageGelId = getOptionalSubPackageGelId();
				if( rhs.getOptionalSubPackageGelId() != null ) {
					Long rhsSubPackageGelId = rhs.getOptionalSubPackageGelId();
					int cmp = lhsSubPackageGelId.compareTo( rhsSubPackageGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSubPackageGelId() != null ) {
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
		String ret = "<CFGenKbGenFileByXSubPkg"
			+ " OptionalSubPackageTenantId=" + ( ( getOptionalSubPackageTenantId() == null ) ? "null" : "\"" + getOptionalSubPackageTenantId().toString() + "\"" )
			+ " OptionalSubPackageGelCacheId=" + ( ( getOptionalSubPackageGelCacheId() == null ) ? "null" : "\"" + getOptionalSubPackageGelCacheId().toString() + "\"" )
			+ " OptionalSubPackageGelId=" + ( ( getOptionalSubPackageGelId() == null ) ? "null" : "\"" + getOptionalSubPackageGelId().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
