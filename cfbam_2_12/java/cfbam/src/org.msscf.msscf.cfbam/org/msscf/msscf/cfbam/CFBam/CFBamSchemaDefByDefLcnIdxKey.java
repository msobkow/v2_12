// Description: Java 11 implementation of a SchemaDef by DefLcnIdx index key object.

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

public class CFBamSchemaDefByDefLcnIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected Long optionalDefaultLicenseTenantId;
	protected Long optionalDefaultLicenseId;
	public CFBamSchemaDefByDefLcnIdxKey() {
		optionalDefaultLicenseTenantId = null;
		optionalDefaultLicenseId = null;
	}

	public Long getOptionalDefaultLicenseTenantId() {
		return( optionalDefaultLicenseTenantId );
	}

	public void setOptionalDefaultLicenseTenantId( Long value ) {
		if( value == null ) {
			optionalDefaultLicenseTenantId = null;
		}
		else if( value < CFBamSchemaDefBuff.DEFAULTLICENSETENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalDefaultLicenseTenantId",
				1,
				"value",
				value,
				CFBamSchemaDefBuff.DEFAULTLICENSETENANTID_MIN_VALUE );
		}
		else {
			optionalDefaultLicenseTenantId = value;
		}
	}

	public Long getOptionalDefaultLicenseId() {
		return( optionalDefaultLicenseId );
	}

	public void setOptionalDefaultLicenseId( Long value ) {
		if( value == null ) {
			optionalDefaultLicenseId = null;
		}
		else if( value < CFBamSchemaDefBuff.DEFAULTLICENSEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalDefaultLicenseId",
				1,
				"value",
				value,
				CFBamSchemaDefBuff.DEFAULTLICENSEID_MIN_VALUE );
		}
		else {
			optionalDefaultLicenseId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamSchemaDefByDefLcnIdxKey ) {
			CFBamSchemaDefByDefLcnIdxKey rhs = (CFBamSchemaDefByDefLcnIdxKey)obj;
			if( getOptionalDefaultLicenseTenantId() != null ) {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					if( ! getOptionalDefaultLicenseTenantId().equals( rhs.getOptionalDefaultLicenseTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					if( ! getOptionalDefaultLicenseId().equals( rhs.getOptionalDefaultLicenseId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaDefBuff ) {
			CFBamSchemaDefBuff rhs = (CFBamSchemaDefBuff)obj;
			if( getOptionalDefaultLicenseTenantId() != null ) {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					if( ! getOptionalDefaultLicenseTenantId().equals( rhs.getOptionalDefaultLicenseTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					if( ! getOptionalDefaultLicenseId().equals( rhs.getOptionalDefaultLicenseId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
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
		if( getOptionalDefaultLicenseTenantId() != null ) {
			hashCode = hashCode + getOptionalDefaultLicenseTenantId().hashCode();
		}
		if( getOptionalDefaultLicenseId() != null ) {
			hashCode = hashCode + getOptionalDefaultLicenseId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamSchemaDefByDefLcnIdxKey ) {
			CFBamSchemaDefByDefLcnIdxKey rhs = (CFBamSchemaDefByDefLcnIdxKey)obj;
			if( getOptionalDefaultLicenseTenantId() != null ) {
				Long lhsDefaultLicenseTenantId = getOptionalDefaultLicenseTenantId();
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					Long rhsDefaultLicenseTenantId = rhs.getOptionalDefaultLicenseTenantId();
					int cmp = lhsDefaultLicenseTenantId.compareTo( rhsDefaultLicenseTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				Long lhsDefaultLicenseId = getOptionalDefaultLicenseId();
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					Long rhsDefaultLicenseId = rhs.getOptionalDefaultLicenseId();
					int cmp = lhsDefaultLicenseId.compareTo( rhsDefaultLicenseId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSchemaDefBuff ) {
			CFBamSchemaDefBuff rhs = (CFBamSchemaDefBuff)obj;
			if( getOptionalDefaultLicenseTenantId() != null ) {
				Long lhsDefaultLicenseTenantId = getOptionalDefaultLicenseTenantId();
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					Long rhsDefaultLicenseTenantId = rhs.getOptionalDefaultLicenseTenantId();
					int cmp = lhsDefaultLicenseTenantId.compareTo( rhsDefaultLicenseTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				Long lhsDefaultLicenseId = getOptionalDefaultLicenseId();
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					Long rhsDefaultLicenseId = rhs.getOptionalDefaultLicenseId();
					int cmp = lhsDefaultLicenseId.compareTo( rhsDefaultLicenseId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
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
		String ret = "<CFBamSchemaDefByDefLcnIdx"
			+ " OptionalDefaultLicenseTenantId=" + ( ( getOptionalDefaultLicenseTenantId() == null ) ? "null" : "\"" + getOptionalDefaultLicenseTenantId().toString() + "\"" )
			+ " OptionalDefaultLicenseId=" + ( ( getOptionalDefaultLicenseId() == null ) ? "null" : "\"" + getOptionalDefaultLicenseId().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
