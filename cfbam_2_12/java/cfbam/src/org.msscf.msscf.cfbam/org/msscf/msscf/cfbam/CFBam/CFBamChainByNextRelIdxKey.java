// Description: Java 11 implementation of a Chain by NextRelIdx index key object.

/*
 *	org.msscf.msscf.CFBam
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
 *	
 *	MSS Code Factory is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with MSS Code Factory.  If not, see https://www.gnu.org/licenses/.
 *	
 *	Donations to support MSS Code Factory can be made at
 *	https://www.paypal.com/paypalme2/MarkSobkow
 *	
 *	Contact Mark Stephen Sobkow at msobkow@sasktel.net for commercial licensing.
 *
 *	Manufactured by MSS Code Factory 2.11
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

public class CFBamChainByNextRelIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredNextRelationTenantId;
	protected long requiredNextRelationId;
	public CFBamChainByNextRelIdxKey() {
		requiredNextRelationTenantId = CFBamChainBuff.NEXTRELATIONTENANTID_INIT_VALUE;
		requiredNextRelationId = CFBamChainBuff.NEXTRELATIONID_INIT_VALUE;
	}

	public long getRequiredNextRelationTenantId() {
		return( requiredNextRelationTenantId );
	}

	public void setRequiredNextRelationTenantId( long value ) {
		if( value < CFBamChainBuff.NEXTRELATIONTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredNextRelationTenantId",
				1,
				"value",
				value,
				CFBamChainBuff.NEXTRELATIONTENANTID_MIN_VALUE );
		}
		requiredNextRelationTenantId = value;
	}

	public long getRequiredNextRelationId() {
		return( requiredNextRelationId );
	}

	public void setRequiredNextRelationId( long value ) {
		if( value < CFBamChainBuff.NEXTRELATIONID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredNextRelationId",
				1,
				"value",
				value,
				CFBamChainBuff.NEXTRELATIONID_MIN_VALUE );
		}
		requiredNextRelationId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamChainByNextRelIdxKey ) {
			CFBamChainByNextRelIdxKey rhs = (CFBamChainByNextRelIdxKey)obj;
			if( getRequiredNextRelationTenantId() != rhs.getRequiredNextRelationTenantId() ) {
				return( false );
			}
			if( getRequiredNextRelationId() != rhs.getRequiredNextRelationId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamChainBuff ) {
			CFBamChainBuff rhs = (CFBamChainBuff)obj;
			if( getRequiredNextRelationTenantId() != rhs.getRequiredNextRelationTenantId() ) {
				return( false );
			}
			if( getRequiredNextRelationId() != rhs.getRequiredNextRelationId() ) {
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
		hashCode = hashCode + (int)( getRequiredNextRelationTenantId() );
		hashCode = hashCode + (int)( getRequiredNextRelationId() );
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamChainByNextRelIdxKey ) {
			CFBamChainByNextRelIdxKey rhs = (CFBamChainByNextRelIdxKey)obj;
			if( getRequiredNextRelationTenantId() < rhs.getRequiredNextRelationTenantId() ) {
				return( -1 );
			}
			else if( getRequiredNextRelationTenantId() > rhs.getRequiredNextRelationTenantId() ) {
				return( 1 );
			}
			if( getRequiredNextRelationId() < rhs.getRequiredNextRelationId() ) {
				return( -1 );
			}
			else if( getRequiredNextRelationId() > rhs.getRequiredNextRelationId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamChainBuff ) {
			CFBamChainBuff rhs = (CFBamChainBuff)obj;
			if( getRequiredNextRelationTenantId() < rhs.getRequiredNextRelationTenantId() ) {
				return( -1 );
			}
			else if( getRequiredNextRelationTenantId() > rhs.getRequiredNextRelationTenantId() ) {
				return( 1 );
			}
			if( getRequiredNextRelationId() < rhs.getRequiredNextRelationId() ) {
				return( -1 );
			}
			else if( getRequiredNextRelationId() > rhs.getRequiredNextRelationId() ) {
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
		String ret = "<CFBamChainByNextRelIdx"
			+ " RequiredNextRelationTenantId=" + "\"" + Long.toString( getRequiredNextRelationTenantId() ) + "\""
			+ " RequiredNextRelationId=" + "\"" + Long.toString( getRequiredNextRelationId() ) + "\""
			+ "/>";
		return( ret );
	}
}
