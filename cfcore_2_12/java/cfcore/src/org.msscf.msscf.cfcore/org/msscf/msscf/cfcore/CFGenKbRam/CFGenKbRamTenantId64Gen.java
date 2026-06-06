// Description: Java 11 implementation of a Tenant 64-bit RAM Id Generator object.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbRam;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

/*
 *	CFGenKbRamTenantId64Gen RAM 64-bit Id Generator for Tenant
 */
public class CFGenKbRamTenantId64Gen
	implements Comparable<Object>,
		Serializable
{

	protected long requiredId;
	protected short sliceId = 0;
	protected long nextId = 1L;

	public CFGenKbRamTenantId64Gen() {
		requiredId = CFGenKbTenantBuff.ID_INIT_VALUE;
		sliceId = 0;
		nextId = 1L;
	}

	public long getNextId() {
		long retNext = nextId ++;
		return( retNext );
	}

	public long getRequiredId() {
		return( requiredId );
	}

	public void setRequiredId( long value ) {
		if( value < CFGenKbTenantBuff.ID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredId",
				1,
				"value",
				value,
				CFGenKbTenantBuff.ID_MIN_VALUE );
		}
		requiredId = value;
	}

	public short getRequiredSliceId() {
		return( sliceId );
	}

	public void setRequiredSliceId( short value ) {
		sliceId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbRamTenantId64Gen ) {
			CFGenKbRamTenantId64Gen rhs = (CFGenKbRamTenantId64Gen)obj;
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredSliceId() != rhs.getRequiredSliceId() ) {
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
		hashCode = ( hashCode * 0x10000 ) + getRequiredSliceId();
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFGenKbRamTenantId64Gen ) {
			CFGenKbRamTenantId64Gen rhs = (CFGenKbRamTenantId64Gen)obj;
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			{
				short lhsSliceId = getRequiredSliceId();
				short rhsSliceId = rhs.getRequiredSliceId();
				if( lhsSliceId < rhsSliceId ) {
					return( -1 );
				}
				else if( lhsSliceId > rhsSliceId ) {
					return( 1 );
				}
			}
			return( 0 );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				"CFGenKbTenantId64Gen" );
		}
	}

	public String toString() {
		String ret = "<CFGenKbTenantId64Gen"
			+ " RequiredId=" + "\"" + Long.toString( getRequiredId() ) + "\""
			+ ", SliceId=\"" + Short.toString( getRequiredSliceId() ) + "\""
			+ ", NextId=\"" + Long.toString( nextId ) + "\"/>";
		return( ret );
	}
}
