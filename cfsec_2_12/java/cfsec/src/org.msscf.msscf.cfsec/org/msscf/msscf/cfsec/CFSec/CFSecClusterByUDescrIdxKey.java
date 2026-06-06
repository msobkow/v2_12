// Description: Java 11 implementation of a Cluster by UDescrIdx index key object.

/*
 *	org.msscf.msscf.CFSec
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

package org.msscf.msscf.cfsec.CFSec;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;

public class CFSecClusterByUDescrIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected String requiredDescription;
	public CFSecClusterByUDescrIdxKey() {
		requiredDescription = new String( CFSecClusterBuff.DESCRIPTION_INIT_VALUE );
	}

	public String getRequiredDescription() {
		return( requiredDescription );
	}

	public void setRequiredDescription( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredDescription",
				1,
				"value" );
		}
		if( value.length() > 128 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredDescription",
				1,
				"value.length()",
				value.length(),
				128 );
		}
		requiredDescription = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFSecClusterByUDescrIdxKey ) {
			CFSecClusterByUDescrIdxKey rhs = (CFSecClusterByUDescrIdxKey)obj;
			if( ! getRequiredDescription().equals( rhs.getRequiredDescription() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFSecClusterBuff ) {
			CFSecClusterBuff rhs = (CFSecClusterBuff)obj;
			if( ! getRequiredDescription().equals( rhs.getRequiredDescription() ) ) {
				return( false );
			}
			return( true );
		}
		else {
			return( false );
		}
	}

	public int hashCode() {
		int hashCode = 0;
		if( getRequiredDescription() != null ) {
			hashCode = hashCode + getRequiredDescription().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFSecClusterByUDescrIdxKey ) {
			CFSecClusterByUDescrIdxKey rhs = (CFSecClusterByUDescrIdxKey)obj;
			{
				int cmp = getRequiredDescription().compareTo( rhs.getRequiredDescription() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFSecClusterBuff ) {
			CFSecClusterBuff rhs = (CFSecClusterBuff)obj;
			{
				int cmp = getRequiredDescription().compareTo( rhs.getRequiredDescription() );
				if( cmp != 0 ) {
					return( cmp );
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
		String ret = "<CFSecClusterByUDescrIdx"
			+ " RequiredDescription=" + "\"" + CFSecSchema.xmlEncodeString( getRequiredDescription() ) + "\""
			+ "/>";
		return( ret );
	}
}
