// Description: Java 11 implementation of a SecForm primary key object.

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
import org.apache.commons.codec.binary.Base64;

/*
 *	CFSecSecFormPKey Primary Key for SecForm

 *		requiredClusterId	Required object attribute ClusterId.
 *		requiredSecFormId	Required object attribute SecFormId. */
public class CFSecSecFormPKey
	implements Comparable<Object>,
		Serializable
{

	protected long requiredClusterId;
	protected int requiredSecFormId;
	public CFSecSecFormPKey() {
		requiredClusterId = CFSecSecFormBuff.CLUSTERID_INIT_VALUE;
		requiredSecFormId = CFSecSecFormBuff.SECFORMID_INIT_VALUE;
	}

	public long getRequiredClusterId() {
		return( requiredClusterId );
	}

	public void setRequiredClusterId( long value ) {
		if( value < CFSecSecFormBuff.CLUSTERID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredClusterId",
				1,
				"value",
				value,
				CFSecSecFormBuff.CLUSTERID_MIN_VALUE );
		}
		requiredClusterId = value;
	}

	public int getRequiredSecFormId() {
		return( requiredSecFormId );
	}

	public void setRequiredSecFormId( int value ) {
		if( value < CFSecSecFormBuff.SECFORMID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredSecFormId",
				1,
				"value",
				value,
				CFSecSecFormBuff.SECFORMID_MIN_VALUE );
		}
		requiredSecFormId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFSecSecFormHPKey ) {
			CFSecSecFormHPKey rhs = (CFSecSecFormHPKey)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecFormId() != rhs.getRequiredSecFormId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFSecSecFormPKey ) {
			CFSecSecFormPKey rhs = (CFSecSecFormPKey)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecFormId() != rhs.getRequiredSecFormId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFSecSecFormHBuff ) {
			CFSecSecFormHBuff rhs = (CFSecSecFormHBuff)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecFormId() != rhs.getRequiredSecFormId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFSecSecFormBuff ) {
			CFSecSecFormBuff rhs = (CFSecSecFormBuff)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecFormId() != rhs.getRequiredSecFormId() ) {
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
		hashCode = hashCode + (int)( getRequiredClusterId() );
		hashCode = hashCode + getRequiredSecFormId();
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFSecSecFormHPKey ) {
			CFSecSecFormHPKey rhs = (CFSecSecFormHPKey)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecFormId() < rhs.getRequiredSecFormId() ) {
				return( -1 );
			}
			else if( getRequiredSecFormId() > rhs.getRequiredSecFormId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFSecSecFormPKey ) {
			CFSecSecFormPKey rhs = (CFSecSecFormPKey)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecFormId() < rhs.getRequiredSecFormId() ) {
				return( -1 );
			}
			else if( getRequiredSecFormId() > rhs.getRequiredSecFormId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFSecSecFormBuff ) {
			CFSecSecFormBuff rhs = (CFSecSecFormBuff)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecFormId() < rhs.getRequiredSecFormId() ) {
				return( -1 );
			}
			else if( getRequiredSecFormId() > rhs.getRequiredSecFormId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFSecSecFormHBuff ) {
			CFSecSecFormHBuff rhs = (CFSecSecFormHBuff)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecFormId() < rhs.getRequiredSecFormId() ) {
				return( -1 );
			}
			else if( getRequiredSecFormId() > rhs.getRequiredSecFormId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				"CFSecSecFormPKey, CFSecSecFormBuff" );
		}
	}

	public String toString() {
		String ret = "<CFSecSecFormPKey"
			+ " RequiredClusterId=" + "\"" + Long.toString( getRequiredClusterId() ) + "\""
			+ " RequiredSecFormId=" + "\"" + Integer.toString( getRequiredSecFormId() ) + "\""
			+ "/>";
		return( ret );
	}
}
