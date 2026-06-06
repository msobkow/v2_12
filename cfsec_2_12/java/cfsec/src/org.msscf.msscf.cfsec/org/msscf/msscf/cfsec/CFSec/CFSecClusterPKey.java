// Description: Java 11 implementation of a Cluster primary key object.

/*
 *	org.msscf.msscf.CFSec
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
import org.apache.commons.codec.binary.Base64;

/*
 *	CFSecClusterPKey Primary Key for Cluster

 *		requiredId	Required object attribute Id. */
public class CFSecClusterPKey
	implements Comparable<Object>,
		Serializable
{

	protected long requiredId;
	public CFSecClusterPKey() {
		requiredId = CFSecClusterBuff.ID_INIT_VALUE;
	}

	public long getRequiredId() {
		return( requiredId );
	}

	public void setRequiredId( long value ) {
		if( value < CFSecClusterBuff.ID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredId",
				1,
				"value",
				value,
				CFSecClusterBuff.ID_MIN_VALUE );
		}
		requiredId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFSecClusterHPKey ) {
			CFSecClusterHPKey rhs = (CFSecClusterHPKey)obj;
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFSecClusterPKey ) {
			CFSecClusterPKey rhs = (CFSecClusterPKey)obj;
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFSecClusterHBuff ) {
			CFSecClusterHBuff rhs = (CFSecClusterHBuff)obj;
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFSecClusterBuff ) {
			CFSecClusterBuff rhs = (CFSecClusterBuff)obj;
			if( getRequiredId() != rhs.getRequiredId() ) {
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
		hashCode = hashCode + (int)( getRequiredId() );
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFSecClusterHPKey ) {
			CFSecClusterHPKey rhs = (CFSecClusterHPKey)obj;
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFSecClusterPKey ) {
			CFSecClusterPKey rhs = (CFSecClusterPKey)obj;
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFSecClusterBuff ) {
			CFSecClusterBuff rhs = (CFSecClusterBuff)obj;
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFSecClusterHBuff ) {
			CFSecClusterHBuff rhs = (CFSecClusterHBuff)obj;
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				"CFSecClusterPKey, CFSecClusterBuff" );
		}
	}

	public String toString() {
		String ret = "<CFSecClusterPKey"
			+ " RequiredId=" + "\"" + Long.toString( getRequiredId() ) + "\""
			+ "/>";
		return( ret );
	}
}
