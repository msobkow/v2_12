// Description: Java 11 implementation of a RelationCol by NextIdx index key object.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamRelationColByNextIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected Long optionalNextTenantId;
	protected Long optionalNextId;
	public CFBamRelationColByNextIdxKey() {
		optionalNextTenantId = null;
		optionalNextId = null;
	}

	public Long getOptionalNextTenantId() {
		return( optionalNextTenantId );
	}

	public void setOptionalNextTenantId( Long value ) {
		if( value == null ) {
			optionalNextTenantId = null;
		}
		else if( value < CFBamRelationColBuff.NEXTTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalNextTenantId",
				1,
				"value",
				value,
				CFBamRelationColBuff.NEXTTENANTID_MIN_VALUE );
		}
		else {
			optionalNextTenantId = value;
		}
	}

	public Long getOptionalNextId() {
		return( optionalNextId );
	}

	public void setOptionalNextId( Long value ) {
		if( value == null ) {
			optionalNextId = null;
		}
		else if( value < CFBamRelationColBuff.NEXTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalNextId",
				1,
				"value",
				value,
				CFBamRelationColBuff.NEXTID_MIN_VALUE );
		}
		else {
			optionalNextId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamRelationColByNextIdxKey ) {
			CFBamRelationColByNextIdxKey rhs = (CFBamRelationColByNextIdxKey)obj;
			if( getOptionalNextTenantId() != null ) {
				if( rhs.getOptionalNextTenantId() != null ) {
					if( ! getOptionalNextTenantId().equals( rhs.getOptionalNextTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNextTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamRelationColBuff ) {
			CFBamRelationColBuff rhs = (CFBamRelationColBuff)obj;
			if( getOptionalNextTenantId() != null ) {
				if( rhs.getOptionalNextTenantId() != null ) {
					if( ! getOptionalNextTenantId().equals( rhs.getOptionalNextTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNextTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
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
		if( getOptionalNextTenantId() != null ) {
			hashCode = hashCode + getOptionalNextTenantId().hashCode();
		}
		if( getOptionalNextId() != null ) {
			hashCode = hashCode + getOptionalNextId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamRelationColByNextIdxKey ) {
			CFBamRelationColByNextIdxKey rhs = (CFBamRelationColByNextIdxKey)obj;
			if( getOptionalNextTenantId() != null ) {
				Long lhsNextTenantId = getOptionalNextTenantId();
				if( rhs.getOptionalNextTenantId() != null ) {
					Long rhsNextTenantId = rhs.getOptionalNextTenantId();
					int cmp = lhsNextTenantId.compareTo( rhsNextTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextId() != null ) {
				Long lhsNextId = getOptionalNextId();
				if( rhs.getOptionalNextId() != null ) {
					Long rhsNextId = rhs.getOptionalNextId();
					int cmp = lhsNextId.compareTo( rhsNextId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamRelationColBuff ) {
			CFBamRelationColBuff rhs = (CFBamRelationColBuff)obj;
			if( getOptionalNextTenantId() != null ) {
				Long lhsNextTenantId = getOptionalNextTenantId();
				if( rhs.getOptionalNextTenantId() != null ) {
					Long rhsNextTenantId = rhs.getOptionalNextTenantId();
					int cmp = lhsNextTenantId.compareTo( rhsNextTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextId() != null ) {
				Long lhsNextId = getOptionalNextId();
				if( rhs.getOptionalNextId() != null ) {
					Long rhsNextId = rhs.getOptionalNextId();
					int cmp = lhsNextId.compareTo( rhsNextId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
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
		String ret = "<CFBamRelationColByNextIdx"
			+ " OptionalNextTenantId=" + ( ( getOptionalNextTenantId() == null ) ? "null" : "\"" + getOptionalNextTenantId().toString() + "\"" )
			+ " OptionalNextId=" + ( ( getOptionalNextId() == null ) ? "null" : "\"" + getOptionalNextId().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
