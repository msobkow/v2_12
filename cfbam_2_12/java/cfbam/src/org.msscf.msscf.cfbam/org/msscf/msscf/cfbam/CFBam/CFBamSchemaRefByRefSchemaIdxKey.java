// Description: Java 11 implementation of a SchemaRef by RefSchemaIdx index key object.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamSchemaRefByRefSchemaIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected Long optionalRefSchemaTenantId;
	protected Long optionalRefSchemaId;
	public CFBamSchemaRefByRefSchemaIdxKey() {
		optionalRefSchemaTenantId = null;
		optionalRefSchemaId = null;
	}

	public Long getOptionalRefSchemaTenantId() {
		return( optionalRefSchemaTenantId );
	}

	public void setOptionalRefSchemaTenantId( Long value ) {
		if( value == null ) {
			optionalRefSchemaTenantId = null;
		}
		else if( value < CFBamSchemaRefBuff.REFSCHEMATENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalRefSchemaTenantId",
				1,
				"value",
				value,
				CFBamSchemaRefBuff.REFSCHEMATENANTID_MIN_VALUE );
		}
		else {
			optionalRefSchemaTenantId = value;
		}
	}

	public Long getOptionalRefSchemaId() {
		return( optionalRefSchemaId );
	}

	public void setOptionalRefSchemaId( Long value ) {
		if( value == null ) {
			optionalRefSchemaId = null;
		}
		else if( value < CFBamSchemaRefBuff.REFSCHEMAID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalRefSchemaId",
				1,
				"value",
				value,
				CFBamSchemaRefBuff.REFSCHEMAID_MIN_VALUE );
		}
		else {
			optionalRefSchemaId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamSchemaRefByRefSchemaIdxKey ) {
			CFBamSchemaRefByRefSchemaIdxKey rhs = (CFBamSchemaRefByRefSchemaIdxKey)obj;
			if( getOptionalRefSchemaTenantId() != null ) {
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					if( ! getOptionalRefSchemaTenantId().equals( rhs.getOptionalRefSchemaTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					if( ! getOptionalRefSchemaId().equals( rhs.getOptionalRefSchemaId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaRefBuff ) {
			CFBamSchemaRefBuff rhs = (CFBamSchemaRefBuff)obj;
			if( getOptionalRefSchemaTenantId() != null ) {
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					if( ! getOptionalRefSchemaTenantId().equals( rhs.getOptionalRefSchemaTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					if( ! getOptionalRefSchemaId().equals( rhs.getOptionalRefSchemaId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
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
		if( getOptionalRefSchemaTenantId() != null ) {
			hashCode = hashCode + getOptionalRefSchemaTenantId().hashCode();
		}
		if( getOptionalRefSchemaId() != null ) {
			hashCode = hashCode + getOptionalRefSchemaId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamSchemaRefByRefSchemaIdxKey ) {
			CFBamSchemaRefByRefSchemaIdxKey rhs = (CFBamSchemaRefByRefSchemaIdxKey)obj;
			if( getOptionalRefSchemaTenantId() != null ) {
				Long lhsRefSchemaTenantId = getOptionalRefSchemaTenantId();
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					Long rhsRefSchemaTenantId = rhs.getOptionalRefSchemaTenantId();
					int cmp = lhsRefSchemaTenantId.compareTo( rhsRefSchemaTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalRefSchemaId() != null ) {
				Long lhsRefSchemaId = getOptionalRefSchemaId();
				if( rhs.getOptionalRefSchemaId() != null ) {
					Long rhsRefSchemaId = rhs.getOptionalRefSchemaId();
					int cmp = lhsRefSchemaId.compareTo( rhsRefSchemaId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSchemaRefBuff ) {
			CFBamSchemaRefBuff rhs = (CFBamSchemaRefBuff)obj;
			if( getOptionalRefSchemaTenantId() != null ) {
				Long lhsRefSchemaTenantId = getOptionalRefSchemaTenantId();
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					Long rhsRefSchemaTenantId = rhs.getOptionalRefSchemaTenantId();
					int cmp = lhsRefSchemaTenantId.compareTo( rhsRefSchemaTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalRefSchemaId() != null ) {
				Long lhsRefSchemaId = getOptionalRefSchemaId();
				if( rhs.getOptionalRefSchemaId() != null ) {
					Long rhsRefSchemaId = rhs.getOptionalRefSchemaId();
					int cmp = lhsRefSchemaId.compareTo( rhsRefSchemaId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
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
		String ret = "<CFBamSchemaRefByRefSchemaIdx"
			+ " OptionalRefSchemaTenantId=" + ( ( getOptionalRefSchemaTenantId() == null ) ? "null" : "\"" + getOptionalRefSchemaTenantId().toString() + "\"" )
			+ " OptionalRefSchemaId=" + ( ( getOptionalRefSchemaId() == null ) ? "null" : "\"" + getOptionalRefSchemaId().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
