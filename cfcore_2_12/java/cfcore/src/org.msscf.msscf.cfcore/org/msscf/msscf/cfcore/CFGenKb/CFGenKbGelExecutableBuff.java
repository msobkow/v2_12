// Description: Java 11 implementation of a GelExecutable buffer object.

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

package org.msscf.msscf.cfcore.CFGenKb;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;

public class CFGenKbGelExecutableBuff
	extends CFGenKbGelSequenceBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "GEXE";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long GELCACHEID_INIT_VALUE = 0L;
	public static final long GELINSTID_INIT_VALUE = 0L;
	public static final long GENITEMID_INIT_VALUE = 0L;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long GELCACHEID_MIN_VALUE = 0L;
	public static final long GELINSTID_MIN_VALUE = 0L;
	public static final long GENITEMID_MIN_VALUE = 0L;
	public static final long GENITEMID_MAX_VALUE = 2147483647L;
	protected long requiredGenItemId;
	public CFGenKbGelExecutableBuff() {
		super();
		requiredGenItemId = CFGenKbGelExecutableBuff.GENITEMID_INIT_VALUE;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public long getRequiredGenItemId() {
		return( requiredGenItemId );
	}

	public void setRequiredGenItemId( long value ) {
		if( value < CFGenKbGelExecutableBuff.GENITEMID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredGenItemId",
				1,
				"value",
				value,
				CFGenKbGelExecutableBuff.GENITEMID_MIN_VALUE );
		}
		if( value > CFGenKbGelExecutableBuff.GENITEMID_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredGenItemId",
				1,
				"value",
				value,
				CFGenKbGelExecutableBuff.GENITEMID_MAX_VALUE );
		}
		requiredGenItemId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGelExecutableBuff ) {
			CFGenKbGelExecutableBuff rhs = (CFGenKbGelExecutableBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredGelCacheId() != rhs.getRequiredGelCacheId() ) {
				return( false );
			}
			if( getRequiredGelInstId() != rhs.getRequiredGelInstId() ) {
				return( false );
			}
			if( getRequiredGenItemId() != rhs.getRequiredGenItemId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGelInstructionPKey ) {
			CFGenKbGelInstructionPKey rhs = (CFGenKbGelInstructionPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredGelCacheId() != rhs.getRequiredGelCacheId() ) {
				return( false );
			}
			if( getRequiredGelInstId() != rhs.getRequiredGelInstId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGelExecutableByGenItemIdxKey ) {
			CFGenKbGelExecutableByGenItemIdxKey rhs = (CFGenKbGelExecutableByGenItemIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredGelCacheId() != rhs.getRequiredGelCacheId() ) {
				return( false );
			}
			return( true );
		}
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	public int hashCode() {
		int hashCode = super.hashCode();
		hashCode = hashCode + (int)( getRequiredGenItemId() );
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFGenKbGelExecutableBuff ) {
			CFGenKbGelExecutableBuff rhs = (CFGenKbGelExecutableBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getRequiredGenItemId() < rhs.getRequiredGenItemId() ) {
				return( -1 );
			}
			else if( getRequiredGenItemId() > rhs.getRequiredGenItemId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGelInstructionPKey ) {
			CFGenKbGelInstructionPKey rhs = (CFGenKbGelInstructionPKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredGelCacheId() < rhs.getRequiredGelCacheId() ) {
				return( -1 );
			}
			else if( getRequiredGelCacheId() > rhs.getRequiredGelCacheId() ) {
				return( 1 );
			}
			if( getRequiredGelInstId() < rhs.getRequiredGelInstId() ) {
				return( -1 );
			}
			else if( getRequiredGelInstId() > rhs.getRequiredGelInstId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGelExecutableByGenItemIdxKey ) {
			CFGenKbGelExecutableByGenItemIdxKey rhs = (CFGenKbGelExecutableByGenItemIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredGelCacheId() < rhs.getRequiredGelCacheId() ) {
				return( -1 );
			}
			else if( getRequiredGelCacheId() > rhs.getRequiredGelCacheId() ) {
				return( 1 );
			}			return( 0 );
		}
		else {
			int retval = super.compareTo( obj );
			return( retval );
		}
	}

	public void set( CFGenKbGelInstructionBuff src ) {
		if( src instanceof CFGenKbGelExecutableBuff ) {
			setGelExecutableBuff( (CFGenKbGelExecutableBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFGenKbGelExecutableBuff" );
		}
	}

	public void setGelExecutableBuff( CFGenKbGelExecutableBuff src ) {
		super.setGelSequenceBuff( src );
		setRequiredGenItemId( src.getRequiredGenItemId() );
	}
}
