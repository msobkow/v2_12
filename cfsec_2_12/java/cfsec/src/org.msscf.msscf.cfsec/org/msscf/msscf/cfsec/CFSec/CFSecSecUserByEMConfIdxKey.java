// Description: Java 11 implementation of a SecUser by EMConfIdx index key object.

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

public class CFSecSecUserByEMConfIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected UUID optionalEMailConfirmUuid;
	public CFSecSecUserByEMConfIdxKey() {
		optionalEMailConfirmUuid = null;
	}

	public UUID getOptionalEMailConfirmUuid() {
		return( optionalEMailConfirmUuid );
	}

	public void setOptionalEMailConfirmUuid( UUID value ) {
		if( value == null ) {
			optionalEMailConfirmUuid = null;
		}
		else {
			optionalEMailConfirmUuid = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFSecSecUserByEMConfIdxKey ) {
			CFSecSecUserByEMConfIdxKey rhs = (CFSecSecUserByEMConfIdxKey)obj;
			if( getOptionalEMailConfirmUuid() != null ) {
				if( rhs.getOptionalEMailConfirmUuid() != null ) {
					if( ! getOptionalEMailConfirmUuid().equals( rhs.getOptionalEMailConfirmUuid() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmUuid() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFSecSecUserBuff ) {
			CFSecSecUserBuff rhs = (CFSecSecUserBuff)obj;
			if( getOptionalEMailConfirmUuid() != null ) {
				if( rhs.getOptionalEMailConfirmUuid() != null ) {
					if( ! getOptionalEMailConfirmUuid().equals( rhs.getOptionalEMailConfirmUuid() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmUuid() != null ) {
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
		if( getOptionalEMailConfirmUuid() != null ) {
			hashCode = hashCode + getOptionalEMailConfirmUuid().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFSecSecUserByEMConfIdxKey ) {
			CFSecSecUserByEMConfIdxKey rhs = (CFSecSecUserByEMConfIdxKey)obj;
			if( getOptionalEMailConfirmUuid() != null ) {
				if( rhs.getOptionalEMailConfirmUuid() != null ) {
					int cmp = getOptionalEMailConfirmUuid().compareTo( rhs.getOptionalEMailConfirmUuid() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmUuid() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFSecSecUserBuff ) {
			CFSecSecUserBuff rhs = (CFSecSecUserBuff)obj;
			if( getOptionalEMailConfirmUuid() != null ) {
				if( rhs.getOptionalEMailConfirmUuid() != null ) {
					int cmp = getOptionalEMailConfirmUuid().compareTo( rhs.getOptionalEMailConfirmUuid() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmUuid() != null ) {
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
		String ret = "<CFSecSecUserByEMConfIdx"
			+ " OptionalEMailConfirmUuid=" + ( ( getOptionalEMailConfirmUuid() == null ) ? "null" : "\"" + getOptionalEMailConfirmUuid().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
