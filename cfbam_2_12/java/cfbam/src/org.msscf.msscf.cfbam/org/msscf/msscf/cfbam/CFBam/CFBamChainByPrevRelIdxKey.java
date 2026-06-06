// Description: Java 11 implementation of a Chain by PrevRelIdx index key object.

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

public class CFBamChainByPrevRelIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredPrevRelationTenantId;
	protected long requiredPrevRelationId;
	public CFBamChainByPrevRelIdxKey() {
		requiredPrevRelationTenantId = CFBamChainBuff.PREVRELATIONTENANTID_INIT_VALUE;
		requiredPrevRelationId = CFBamChainBuff.PREVRELATIONID_INIT_VALUE;
	}

	public long getRequiredPrevRelationTenantId() {
		return( requiredPrevRelationTenantId );
	}

	public void setRequiredPrevRelationTenantId( long value ) {
		if( value < CFBamChainBuff.PREVRELATIONTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredPrevRelationTenantId",
				1,
				"value",
				value,
				CFBamChainBuff.PREVRELATIONTENANTID_MIN_VALUE );
		}
		requiredPrevRelationTenantId = value;
	}

	public long getRequiredPrevRelationId() {
		return( requiredPrevRelationId );
	}

	public void setRequiredPrevRelationId( long value ) {
		if( value < CFBamChainBuff.PREVRELATIONID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredPrevRelationId",
				1,
				"value",
				value,
				CFBamChainBuff.PREVRELATIONID_MIN_VALUE );
		}
		requiredPrevRelationId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamChainByPrevRelIdxKey ) {
			CFBamChainByPrevRelIdxKey rhs = (CFBamChainByPrevRelIdxKey)obj;
			if( getRequiredPrevRelationTenantId() != rhs.getRequiredPrevRelationTenantId() ) {
				return( false );
			}
			if( getRequiredPrevRelationId() != rhs.getRequiredPrevRelationId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamChainBuff ) {
			CFBamChainBuff rhs = (CFBamChainBuff)obj;
			if( getRequiredPrevRelationTenantId() != rhs.getRequiredPrevRelationTenantId() ) {
				return( false );
			}
			if( getRequiredPrevRelationId() != rhs.getRequiredPrevRelationId() ) {
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
		hashCode = hashCode + (int)( getRequiredPrevRelationTenantId() );
		hashCode = hashCode + (int)( getRequiredPrevRelationId() );
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamChainByPrevRelIdxKey ) {
			CFBamChainByPrevRelIdxKey rhs = (CFBamChainByPrevRelIdxKey)obj;
			if( getRequiredPrevRelationTenantId() < rhs.getRequiredPrevRelationTenantId() ) {
				return( -1 );
			}
			else if( getRequiredPrevRelationTenantId() > rhs.getRequiredPrevRelationTenantId() ) {
				return( 1 );
			}
			if( getRequiredPrevRelationId() < rhs.getRequiredPrevRelationId() ) {
				return( -1 );
			}
			else if( getRequiredPrevRelationId() > rhs.getRequiredPrevRelationId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamChainBuff ) {
			CFBamChainBuff rhs = (CFBamChainBuff)obj;
			if( getRequiredPrevRelationTenantId() < rhs.getRequiredPrevRelationTenantId() ) {
				return( -1 );
			}
			else if( getRequiredPrevRelationTenantId() > rhs.getRequiredPrevRelationTenantId() ) {
				return( 1 );
			}
			if( getRequiredPrevRelationId() < rhs.getRequiredPrevRelationId() ) {
				return( -1 );
			}
			else if( getRequiredPrevRelationId() > rhs.getRequiredPrevRelationId() ) {
				return( 1 );
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
		String ret = "<CFBamChainByPrevRelIdx"
			+ " RequiredPrevRelationTenantId=" + "\"" + Long.toString( getRequiredPrevRelationTenantId() ) + "\""
			+ " RequiredPrevRelationId=" + "\"" + Long.toString( getRequiredPrevRelationId() ) + "\""
			+ "/>";
		return( ret );
	}
}
