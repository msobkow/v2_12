// Description: Java 11 implementation of a SecSession by StartIdx index key object.

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

public class CFSecSecSessionByStartIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected UUID requiredSecUserId;
	protected Calendar requiredStart;
	public CFSecSecSessionByStartIdxKey() {
		requiredSecUserId = UUID.fromString( CFSecSecSessionBuff.SECUSERID_INIT_VALUE.toString() );
		requiredStart = CFLib.getUTCGregorianCalendar( 2020, 0, 1, 0, 0, 0 );
	}

	public UUID getRequiredSecUserId() {
		return( requiredSecUserId );
	}

	public void setRequiredSecUserId( UUID value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredSecUserId",
				1,
				"value" );
		}
		requiredSecUserId = value;
	}

	public Calendar getRequiredStart() {
		return( requiredStart );
	}

	public void setRequiredStart( Calendar value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredStart",
				1,
				"value" );
		}
		requiredStart = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFSecSecSessionByStartIdxKey ) {
			CFSecSecSessionByStartIdxKey rhs = (CFSecSecSessionByStartIdxKey)obj;
			if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
				return( false );
			}
			if( ! getRequiredStart().equals( rhs.getRequiredStart() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFSecSecSessionBuff ) {
			CFSecSecSessionBuff rhs = (CFSecSecSessionBuff)obj;
			if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
				return( false );
			}
			if( ! getRequiredStart().equals( rhs.getRequiredStart() ) ) {
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
		hashCode = hashCode + getRequiredSecUserId().hashCode();
		if( getRequiredStart() != null ) {
			hashCode = hashCode + getRequiredStart().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFSecSecSessionByStartIdxKey ) {
			CFSecSecSessionByStartIdxKey rhs = (CFSecSecSessionByStartIdxKey)obj;
			{
				int cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredStart().compareTo( rhs.getRequiredStart() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFSecSecSessionBuff ) {
			CFSecSecSessionBuff rhs = (CFSecSecSessionBuff)obj;
			{
				int cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredStart().compareTo( rhs.getRequiredStart() );
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
		String ret = "<CFSecSecSessionByStartIdx"
			+ " RequiredSecUserId=" + "\"" + getRequiredSecUserId().toString() + "\""
			+ " RequiredStart=" + "\"" + getRequiredStart().toString() + "\""
			+ "/>";
		return( ret );
	}
}
