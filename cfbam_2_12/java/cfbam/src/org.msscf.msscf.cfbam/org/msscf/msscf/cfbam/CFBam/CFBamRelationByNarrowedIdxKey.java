// Description: Java 11 implementation of a Relation by NarrowedIdx index key object.

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

public class CFBamRelationByNarrowedIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected Long optionalNarrowedTenantId;
	protected Long optionalNarrowedId;
	public CFBamRelationByNarrowedIdxKey() {
		optionalNarrowedTenantId = null;
		optionalNarrowedId = null;
	}

	public Long getOptionalNarrowedTenantId() {
		return( optionalNarrowedTenantId );
	}

	public void setOptionalNarrowedTenantId( Long value ) {
		if( value == null ) {
			optionalNarrowedTenantId = null;
		}
		else if( value < CFBamRelationBuff.NARROWEDTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalNarrowedTenantId",
				1,
				"value",
				value,
				CFBamRelationBuff.NARROWEDTENANTID_MIN_VALUE );
		}
		else {
			optionalNarrowedTenantId = value;
		}
	}

	public Long getOptionalNarrowedId() {
		return( optionalNarrowedId );
	}

	public void setOptionalNarrowedId( Long value ) {
		if( value == null ) {
			optionalNarrowedId = null;
		}
		else if( value < CFBamRelationBuff.NARROWEDID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalNarrowedId",
				1,
				"value",
				value,
				CFBamRelationBuff.NARROWEDID_MIN_VALUE );
		}
		else {
			optionalNarrowedId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamRelationByNarrowedIdxKey ) {
			CFBamRelationByNarrowedIdxKey rhs = (CFBamRelationByNarrowedIdxKey)obj;
			if( getOptionalNarrowedTenantId() != null ) {
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					if( ! getOptionalNarrowedTenantId().equals( rhs.getOptionalNarrowedTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalNarrowedId() != null ) {
				if( rhs.getOptionalNarrowedId() != null ) {
					if( ! getOptionalNarrowedId().equals( rhs.getOptionalNarrowedId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamRelationBuff ) {
			CFBamRelationBuff rhs = (CFBamRelationBuff)obj;
			if( getOptionalNarrowedTenantId() != null ) {
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					if( ! getOptionalNarrowedTenantId().equals( rhs.getOptionalNarrowedTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalNarrowedId() != null ) {
				if( rhs.getOptionalNarrowedId() != null ) {
					if( ! getOptionalNarrowedId().equals( rhs.getOptionalNarrowedId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
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
		if( getOptionalNarrowedTenantId() != null ) {
			hashCode = hashCode + getOptionalNarrowedTenantId().hashCode();
		}
		if( getOptionalNarrowedId() != null ) {
			hashCode = hashCode + getOptionalNarrowedId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamRelationByNarrowedIdxKey ) {
			CFBamRelationByNarrowedIdxKey rhs = (CFBamRelationByNarrowedIdxKey)obj;
			if( getOptionalNarrowedTenantId() != null ) {
				Long lhsNarrowedTenantId = getOptionalNarrowedTenantId();
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					Long rhsNarrowedTenantId = rhs.getOptionalNarrowedTenantId();
					int cmp = lhsNarrowedTenantId.compareTo( rhsNarrowedTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNarrowedId() != null ) {
				Long lhsNarrowedId = getOptionalNarrowedId();
				if( rhs.getOptionalNarrowedId() != null ) {
					Long rhsNarrowedId = rhs.getOptionalNarrowedId();
					int cmp = lhsNarrowedId.compareTo( rhsNarrowedId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamRelationBuff ) {
			CFBamRelationBuff rhs = (CFBamRelationBuff)obj;
			if( getOptionalNarrowedTenantId() != null ) {
				Long lhsNarrowedTenantId = getOptionalNarrowedTenantId();
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					Long rhsNarrowedTenantId = rhs.getOptionalNarrowedTenantId();
					int cmp = lhsNarrowedTenantId.compareTo( rhsNarrowedTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNarrowedId() != null ) {
				Long lhsNarrowedId = getOptionalNarrowedId();
				if( rhs.getOptionalNarrowedId() != null ) {
					Long rhsNarrowedId = rhs.getOptionalNarrowedId();
					int cmp = lhsNarrowedId.compareTo( rhsNarrowedId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
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
		String ret = "<CFBamRelationByNarrowedIdx"
			+ " OptionalNarrowedTenantId=" + ( ( getOptionalNarrowedTenantId() == null ) ? "null" : "\"" + getOptionalNarrowedTenantId().toString() + "\"" )
			+ " OptionalNarrowedId=" + ( ( getOptionalNarrowedId() == null ) ? "null" : "\"" + getOptionalNarrowedId().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
