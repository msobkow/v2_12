// Description: Java 11 implementation of a GenFile by XSrcBundle index key object.

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

public class CFGenKbGenFileByXSrcBundleKey
	implements Comparable<Object>,
		Serializable
{
	protected Long optionalSourceBundleTenantId;
	protected Long optionalSourceBundleGelCacheId;
	protected Long optionalSourceBundleGelId;
	public CFGenKbGenFileByXSrcBundleKey() {
		optionalSourceBundleTenantId = null;
		optionalSourceBundleGelCacheId = null;
		optionalSourceBundleGelId = null;
	}

	public Long getOptionalSourceBundleTenantId() {
		return( optionalSourceBundleTenantId );
	}

	public void setOptionalSourceBundleTenantId( Long value ) {
		if( value == null ) {
			optionalSourceBundleTenantId = null;
		}
		else if( value < CFGenKbGenFileBuff.SOURCEBUNDLETENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalSourceBundleTenantId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.SOURCEBUNDLETENANTID_MIN_VALUE );
		}
		else {
			optionalSourceBundleTenantId = value;
		}
	}

	public Long getOptionalSourceBundleGelCacheId() {
		return( optionalSourceBundleGelCacheId );
	}

	public void setOptionalSourceBundleGelCacheId( Long value ) {
		if( value == null ) {
			optionalSourceBundleGelCacheId = null;
		}
		else if( value < CFGenKbGenFileBuff.SOURCEBUNDLEGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalSourceBundleGelCacheId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.SOURCEBUNDLEGELCACHEID_MIN_VALUE );
		}
		else {
			optionalSourceBundleGelCacheId = value;
		}
	}

	public Long getOptionalSourceBundleGelId() {
		return( optionalSourceBundleGelId );
	}

	public void setOptionalSourceBundleGelId( Long value ) {
		if( value == null ) {
			optionalSourceBundleGelId = null;
		}
		else if( value < CFGenKbGenFileBuff.SOURCEBUNDLEGELID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalSourceBundleGelId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.SOURCEBUNDLEGELID_MIN_VALUE );
		}
		else {
			optionalSourceBundleGelId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGenFileByXSrcBundleKey ) {
			CFGenKbGenFileByXSrcBundleKey rhs = (CFGenKbGenFileByXSrcBundleKey)obj;
			if( getOptionalSourceBundleTenantId() != null ) {
				if( rhs.getOptionalSourceBundleTenantId() != null ) {
					if( ! getOptionalSourceBundleTenantId().equals( rhs.getOptionalSourceBundleTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSourceBundleTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalSourceBundleGelCacheId() != null ) {
				if( rhs.getOptionalSourceBundleGelCacheId() != null ) {
					if( ! getOptionalSourceBundleGelCacheId().equals( rhs.getOptionalSourceBundleGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSourceBundleGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalSourceBundleGelId() != null ) {
				if( rhs.getOptionalSourceBundleGelId() != null ) {
					if( ! getOptionalSourceBundleGelId().equals( rhs.getOptionalSourceBundleGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSourceBundleGelId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGenFileBuff ) {
			CFGenKbGenFileBuff rhs = (CFGenKbGenFileBuff)obj;
			if( getOptionalSourceBundleTenantId() != null ) {
				if( rhs.getOptionalSourceBundleTenantId() != null ) {
					if( ! getOptionalSourceBundleTenantId().equals( rhs.getOptionalSourceBundleTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSourceBundleTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalSourceBundleGelCacheId() != null ) {
				if( rhs.getOptionalSourceBundleGelCacheId() != null ) {
					if( ! getOptionalSourceBundleGelCacheId().equals( rhs.getOptionalSourceBundleGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSourceBundleGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalSourceBundleGelId() != null ) {
				if( rhs.getOptionalSourceBundleGelId() != null ) {
					if( ! getOptionalSourceBundleGelId().equals( rhs.getOptionalSourceBundleGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSourceBundleGelId() != null ) {
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
		if( getOptionalSourceBundleTenantId() != null ) {
			hashCode = hashCode + getOptionalSourceBundleTenantId().hashCode();
		}
		if( getOptionalSourceBundleGelCacheId() != null ) {
			hashCode = hashCode + getOptionalSourceBundleGelCacheId().hashCode();
		}
		if( getOptionalSourceBundleGelId() != null ) {
			hashCode = hashCode + getOptionalSourceBundleGelId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbGenFileByXSrcBundleKey ) {
			CFGenKbGenFileByXSrcBundleKey rhs = (CFGenKbGenFileByXSrcBundleKey)obj;
			if( getOptionalSourceBundleTenantId() != null ) {
				Long lhsSourceBundleTenantId = getOptionalSourceBundleTenantId();
				if( rhs.getOptionalSourceBundleTenantId() != null ) {
					Long rhsSourceBundleTenantId = rhs.getOptionalSourceBundleTenantId();
					int cmp = lhsSourceBundleTenantId.compareTo( rhsSourceBundleTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSourceBundleTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSourceBundleGelCacheId() != null ) {
				Long lhsSourceBundleGelCacheId = getOptionalSourceBundleGelCacheId();
				if( rhs.getOptionalSourceBundleGelCacheId() != null ) {
					Long rhsSourceBundleGelCacheId = rhs.getOptionalSourceBundleGelCacheId();
					int cmp = lhsSourceBundleGelCacheId.compareTo( rhsSourceBundleGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSourceBundleGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSourceBundleGelId() != null ) {
				Long lhsSourceBundleGelId = getOptionalSourceBundleGelId();
				if( rhs.getOptionalSourceBundleGelId() != null ) {
					Long rhsSourceBundleGelId = rhs.getOptionalSourceBundleGelId();
					int cmp = lhsSourceBundleGelId.compareTo( rhsSourceBundleGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSourceBundleGelId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGenFileBuff ) {
			CFGenKbGenFileBuff rhs = (CFGenKbGenFileBuff)obj;
			if( getOptionalSourceBundleTenantId() != null ) {
				Long lhsSourceBundleTenantId = getOptionalSourceBundleTenantId();
				if( rhs.getOptionalSourceBundleTenantId() != null ) {
					Long rhsSourceBundleTenantId = rhs.getOptionalSourceBundleTenantId();
					int cmp = lhsSourceBundleTenantId.compareTo( rhsSourceBundleTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSourceBundleTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSourceBundleGelCacheId() != null ) {
				Long lhsSourceBundleGelCacheId = getOptionalSourceBundleGelCacheId();
				if( rhs.getOptionalSourceBundleGelCacheId() != null ) {
					Long rhsSourceBundleGelCacheId = rhs.getOptionalSourceBundleGelCacheId();
					int cmp = lhsSourceBundleGelCacheId.compareTo( rhsSourceBundleGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSourceBundleGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSourceBundleGelId() != null ) {
				Long lhsSourceBundleGelId = getOptionalSourceBundleGelId();
				if( rhs.getOptionalSourceBundleGelId() != null ) {
					Long rhsSourceBundleGelId = rhs.getOptionalSourceBundleGelId();
					int cmp = lhsSourceBundleGelId.compareTo( rhsSourceBundleGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSourceBundleGelId() != null ) {
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
		String ret = "<CFGenKbGenFileByXSrcBundle"
			+ " OptionalSourceBundleTenantId=" + ( ( getOptionalSourceBundleTenantId() == null ) ? "null" : "\"" + getOptionalSourceBundleTenantId().toString() + "\"" )
			+ " OptionalSourceBundleGelCacheId=" + ( ( getOptionalSourceBundleGelCacheId() == null ) ? "null" : "\"" + getOptionalSourceBundleGelCacheId().toString() + "\"" )
			+ " OptionalSourceBundleGelId=" + ( ( getOptionalSourceBundleGelId() == null ) ? "null" : "\"" + getOptionalSourceBundleGelId().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
