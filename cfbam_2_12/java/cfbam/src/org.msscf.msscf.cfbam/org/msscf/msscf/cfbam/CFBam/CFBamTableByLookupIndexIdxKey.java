// Description: Java 11 implementation of a Table by LookupIndexIdx index key object.

/*
 *	org.msscf.msscf.CFBam
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

package org.msscf.msscf.cfbam.CFBam;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;

public class CFBamTableByLookupIndexIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected Long optionalLookupIndexTenantId;
	protected Long optionalLookupIndexId;
	public CFBamTableByLookupIndexIdxKey() {
		optionalLookupIndexTenantId = null;
		optionalLookupIndexId = null;
	}

	public Long getOptionalLookupIndexTenantId() {
		return( optionalLookupIndexTenantId );
	}

	public void setOptionalLookupIndexTenantId( Long value ) {
		if( value == null ) {
			optionalLookupIndexTenantId = null;
		}
		else if( value < CFBamTableBuff.LOOKUPINDEXTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalLookupIndexTenantId",
				1,
				"value",
				value,
				CFBamTableBuff.LOOKUPINDEXTENANTID_MIN_VALUE );
		}
		else {
			optionalLookupIndexTenantId = value;
		}
	}

	public Long getOptionalLookupIndexId() {
		return( optionalLookupIndexId );
	}

	public void setOptionalLookupIndexId( Long value ) {
		if( value == null ) {
			optionalLookupIndexId = null;
		}
		else if( value < CFBamTableBuff.LOOKUPINDEXID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalLookupIndexId",
				1,
				"value",
				value,
				CFBamTableBuff.LOOKUPINDEXID_MIN_VALUE );
		}
		else {
			optionalLookupIndexId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamTableByLookupIndexIdxKey ) {
			CFBamTableByLookupIndexIdxKey rhs = (CFBamTableByLookupIndexIdxKey)obj;
			if( getOptionalLookupIndexTenantId() != null ) {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					if( ! getOptionalLookupIndexTenantId().equals( rhs.getOptionalLookupIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					if( ! getOptionalLookupIndexId().equals( rhs.getOptionalLookupIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamTableBuff ) {
			CFBamTableBuff rhs = (CFBamTableBuff)obj;
			if( getOptionalLookupIndexTenantId() != null ) {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					if( ! getOptionalLookupIndexTenantId().equals( rhs.getOptionalLookupIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					if( ! getOptionalLookupIndexId().equals( rhs.getOptionalLookupIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
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
		if( getOptionalLookupIndexTenantId() != null ) {
			hashCode = hashCode + getOptionalLookupIndexTenantId().hashCode();
		}
		if( getOptionalLookupIndexId() != null ) {
			hashCode = hashCode + getOptionalLookupIndexId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamTableByLookupIndexIdxKey ) {
			CFBamTableByLookupIndexIdxKey rhs = (CFBamTableByLookupIndexIdxKey)obj;
			if( getOptionalLookupIndexTenantId() != null ) {
				Long lhsLookupIndexTenantId = getOptionalLookupIndexTenantId();
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					Long rhsLookupIndexTenantId = rhs.getOptionalLookupIndexTenantId();
					int cmp = lhsLookupIndexTenantId.compareTo( rhsLookupIndexTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLookupIndexId() != null ) {
				Long lhsLookupIndexId = getOptionalLookupIndexId();
				if( rhs.getOptionalLookupIndexId() != null ) {
					Long rhsLookupIndexId = rhs.getOptionalLookupIndexId();
					int cmp = lhsLookupIndexId.compareTo( rhsLookupIndexId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamTableBuff ) {
			CFBamTableBuff rhs = (CFBamTableBuff)obj;
			if( getOptionalLookupIndexTenantId() != null ) {
				Long lhsLookupIndexTenantId = getOptionalLookupIndexTenantId();
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					Long rhsLookupIndexTenantId = rhs.getOptionalLookupIndexTenantId();
					int cmp = lhsLookupIndexTenantId.compareTo( rhsLookupIndexTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLookupIndexId() != null ) {
				Long lhsLookupIndexId = getOptionalLookupIndexId();
				if( rhs.getOptionalLookupIndexId() != null ) {
					Long rhsLookupIndexId = rhs.getOptionalLookupIndexId();
					int cmp = lhsLookupIndexId.compareTo( rhsLookupIndexId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
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
		String ret = "<CFBamTableByLookupIndexIdx"
			+ " OptionalLookupIndexTenantId=" + ( ( getOptionalLookupIndexTenantId() == null ) ? "null" : "\"" + getOptionalLookupIndexTenantId().toString() + "\"" )
			+ " OptionalLookupIndexId=" + ( ( getOptionalLookupIndexId() == null ) ? "null" : "\"" + getOptionalLookupIndexId().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
