// Description: Java 11 implementation of a GenFile by XExpKeyName index key object.

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

public class CFGenKbGenFileByXExpKeyNameKey
	implements Comparable<Object>,
		Serializable
{
	protected Long optionalExpansionKeyNameTenantId;
	protected Long optionalExpansionKeyNameGelCacheId;
	protected Long optionalExpansionKeyNameGelId;
	public CFGenKbGenFileByXExpKeyNameKey() {
		optionalExpansionKeyNameTenantId = null;
		optionalExpansionKeyNameGelCacheId = null;
		optionalExpansionKeyNameGelId = null;
	}

	public Long getOptionalExpansionKeyNameTenantId() {
		return( optionalExpansionKeyNameTenantId );
	}

	public void setOptionalExpansionKeyNameTenantId( Long value ) {
		if( value == null ) {
			optionalExpansionKeyNameTenantId = null;
		}
		else if( value < CFGenKbGenFileBuff.EXPANSIONKEYNAMETENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalExpansionKeyNameTenantId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.EXPANSIONKEYNAMETENANTID_MIN_VALUE );
		}
		else {
			optionalExpansionKeyNameTenantId = value;
		}
	}

	public Long getOptionalExpansionKeyNameGelCacheId() {
		return( optionalExpansionKeyNameGelCacheId );
	}

	public void setOptionalExpansionKeyNameGelCacheId( Long value ) {
		if( value == null ) {
			optionalExpansionKeyNameGelCacheId = null;
		}
		else if( value < CFGenKbGenFileBuff.EXPANSIONKEYNAMEGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalExpansionKeyNameGelCacheId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.EXPANSIONKEYNAMEGELCACHEID_MIN_VALUE );
		}
		else {
			optionalExpansionKeyNameGelCacheId = value;
		}
	}

	public Long getOptionalExpansionKeyNameGelId() {
		return( optionalExpansionKeyNameGelId );
	}

	public void setOptionalExpansionKeyNameGelId( Long value ) {
		if( value == null ) {
			optionalExpansionKeyNameGelId = null;
		}
		else if( value < CFGenKbGenFileBuff.EXPANSIONKEYNAMEGELID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalExpansionKeyNameGelId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.EXPANSIONKEYNAMEGELID_MIN_VALUE );
		}
		else {
			optionalExpansionKeyNameGelId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGenFileByXExpKeyNameKey ) {
			CFGenKbGenFileByXExpKeyNameKey rhs = (CFGenKbGenFileByXExpKeyNameKey)obj;
			if( getOptionalExpansionKeyNameTenantId() != null ) {
				if( rhs.getOptionalExpansionKeyNameTenantId() != null ) {
					if( ! getOptionalExpansionKeyNameTenantId().equals( rhs.getOptionalExpansionKeyNameTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionKeyNameGelCacheId() != null ) {
				if( rhs.getOptionalExpansionKeyNameGelCacheId() != null ) {
					if( ! getOptionalExpansionKeyNameGelCacheId().equals( rhs.getOptionalExpansionKeyNameGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionKeyNameGelId() != null ) {
				if( rhs.getOptionalExpansionKeyNameGelId() != null ) {
					if( ! getOptionalExpansionKeyNameGelId().equals( rhs.getOptionalExpansionKeyNameGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameGelId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGenFileBuff ) {
			CFGenKbGenFileBuff rhs = (CFGenKbGenFileBuff)obj;
			if( getOptionalExpansionKeyNameTenantId() != null ) {
				if( rhs.getOptionalExpansionKeyNameTenantId() != null ) {
					if( ! getOptionalExpansionKeyNameTenantId().equals( rhs.getOptionalExpansionKeyNameTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionKeyNameGelCacheId() != null ) {
				if( rhs.getOptionalExpansionKeyNameGelCacheId() != null ) {
					if( ! getOptionalExpansionKeyNameGelCacheId().equals( rhs.getOptionalExpansionKeyNameGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionKeyNameGelId() != null ) {
				if( rhs.getOptionalExpansionKeyNameGelId() != null ) {
					if( ! getOptionalExpansionKeyNameGelId().equals( rhs.getOptionalExpansionKeyNameGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameGelId() != null ) {
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
		if( getOptionalExpansionKeyNameTenantId() != null ) {
			hashCode = hashCode + getOptionalExpansionKeyNameTenantId().hashCode();
		}
		if( getOptionalExpansionKeyNameGelCacheId() != null ) {
			hashCode = hashCode + getOptionalExpansionKeyNameGelCacheId().hashCode();
		}
		if( getOptionalExpansionKeyNameGelId() != null ) {
			hashCode = hashCode + getOptionalExpansionKeyNameGelId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFGenKbGenFileByXExpKeyNameKey ) {
			CFGenKbGenFileByXExpKeyNameKey rhs = (CFGenKbGenFileByXExpKeyNameKey)obj;
			if( getOptionalExpansionKeyNameTenantId() != null ) {
				Long lhsExpansionKeyNameTenantId = getOptionalExpansionKeyNameTenantId();
				if( rhs.getOptionalExpansionKeyNameTenantId() != null ) {
					Long rhsExpansionKeyNameTenantId = rhs.getOptionalExpansionKeyNameTenantId();
					int cmp = lhsExpansionKeyNameTenantId.compareTo( rhsExpansionKeyNameTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionKeyNameGelCacheId() != null ) {
				Long lhsExpansionKeyNameGelCacheId = getOptionalExpansionKeyNameGelCacheId();
				if( rhs.getOptionalExpansionKeyNameGelCacheId() != null ) {
					Long rhsExpansionKeyNameGelCacheId = rhs.getOptionalExpansionKeyNameGelCacheId();
					int cmp = lhsExpansionKeyNameGelCacheId.compareTo( rhsExpansionKeyNameGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionKeyNameGelId() != null ) {
				Long lhsExpansionKeyNameGelId = getOptionalExpansionKeyNameGelId();
				if( rhs.getOptionalExpansionKeyNameGelId() != null ) {
					Long rhsExpansionKeyNameGelId = rhs.getOptionalExpansionKeyNameGelId();
					int cmp = lhsExpansionKeyNameGelId.compareTo( rhsExpansionKeyNameGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameGelId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGenFileBuff ) {
			CFGenKbGenFileBuff rhs = (CFGenKbGenFileBuff)obj;
			if( getOptionalExpansionKeyNameTenantId() != null ) {
				Long lhsExpansionKeyNameTenantId = getOptionalExpansionKeyNameTenantId();
				if( rhs.getOptionalExpansionKeyNameTenantId() != null ) {
					Long rhsExpansionKeyNameTenantId = rhs.getOptionalExpansionKeyNameTenantId();
					int cmp = lhsExpansionKeyNameTenantId.compareTo( rhsExpansionKeyNameTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionKeyNameGelCacheId() != null ) {
				Long lhsExpansionKeyNameGelCacheId = getOptionalExpansionKeyNameGelCacheId();
				if( rhs.getOptionalExpansionKeyNameGelCacheId() != null ) {
					Long rhsExpansionKeyNameGelCacheId = rhs.getOptionalExpansionKeyNameGelCacheId();
					int cmp = lhsExpansionKeyNameGelCacheId.compareTo( rhsExpansionKeyNameGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionKeyNameGelId() != null ) {
				Long lhsExpansionKeyNameGelId = getOptionalExpansionKeyNameGelId();
				if( rhs.getOptionalExpansionKeyNameGelId() != null ) {
					Long rhsExpansionKeyNameGelId = rhs.getOptionalExpansionKeyNameGelId();
					int cmp = lhsExpansionKeyNameGelId.compareTo( rhsExpansionKeyNameGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameGelId() != null ) {
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
		String ret = "<CFGenKbGenFileByXExpKeyName"
			+ " OptionalExpansionKeyNameTenantId=" + ( ( getOptionalExpansionKeyNameTenantId() == null ) ? "null" : "\"" + getOptionalExpansionKeyNameTenantId().toString() + "\"" )
			+ " OptionalExpansionKeyNameGelCacheId=" + ( ( getOptionalExpansionKeyNameGelCacheId() == null ) ? "null" : "\"" + getOptionalExpansionKeyNameGelCacheId().toString() + "\"" )
			+ " OptionalExpansionKeyNameGelId=" + ( ( getOptionalExpansionKeyNameGelId() == null ) ? "null" : "\"" + getOptionalExpansionKeyNameGelId().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
