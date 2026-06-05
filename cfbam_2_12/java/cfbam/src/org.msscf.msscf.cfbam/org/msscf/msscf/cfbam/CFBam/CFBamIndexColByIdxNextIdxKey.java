// Description: Java 11 implementation of a IndexCol by IdxNextIdx index key object.

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

public class CFBamIndexColByIdxNextIdxKey
	implements Comparable<Object>,
		Serializable
{
	protected long requiredTenantId;
	protected long requiredIndexId;
	protected Long optionalNextId;
	public CFBamIndexColByIdxNextIdxKey() {
		requiredTenantId = CFBamIndexColBuff.TENANTID_INIT_VALUE;
		requiredIndexId = CFBamIndexColBuff.INDEXID_INIT_VALUE;
		optionalNextId = null;
	}

	public long getRequiredTenantId() {
		return( requiredTenantId );
	}

	public void setRequiredTenantId( long value ) {
		if( value < CFBamIndexColBuff.TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTenantId",
				1,
				"value",
				value,
				CFBamIndexColBuff.TENANTID_MIN_VALUE );
		}
		requiredTenantId = value;
	}

	public long getRequiredIndexId() {
		return( requiredIndexId );
	}

	public void setRequiredIndexId( long value ) {
		if( value < CFBamIndexColBuff.INDEXID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredIndexId",
				1,
				"value",
				value,
				CFBamIndexColBuff.INDEXID_MIN_VALUE );
		}
		requiredIndexId = value;
	}

	public Long getOptionalNextId() {
		return( optionalNextId );
	}

	public void setOptionalNextId( Long value ) {
		if( value == null ) {
			optionalNextId = null;
		}
		else if( value < CFBamIndexColBuff.NEXTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalNextId",
				1,
				"value",
				value,
				CFBamIndexColBuff.NEXTID_MIN_VALUE );
		}
		else {
			optionalNextId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamIndexColByIdxNextIdxKey ) {
			CFBamIndexColByIdxNextIdxKey rhs = (CFBamIndexColByIdxNextIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredIndexId() != rhs.getRequiredIndexId() ) {
				return( false );
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamIndexColBuff ) {
			CFBamIndexColBuff rhs = (CFBamIndexColBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredIndexId() != rhs.getRequiredIndexId() ) {
				return( false );
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
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
		hashCode = hashCode + (int)( getRequiredTenantId() );
		hashCode = hashCode + (int)( getRequiredIndexId() );
		if( getOptionalNextId() != null ) {
			hashCode = hashCode + getOptionalNextId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamIndexColByIdxNextIdxKey ) {
			CFBamIndexColByIdxNextIdxKey rhs = (CFBamIndexColByIdxNextIdxKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredIndexId() < rhs.getRequiredIndexId() ) {
				return( -1 );
			}
			else if( getRequiredIndexId() > rhs.getRequiredIndexId() ) {
				return( 1 );
			}
			if( getOptionalNextId() != null ) {
				Long lhsNextId = getOptionalNextId();
				if( rhs.getOptionalNextId() != null ) {
					Long rhsNextId = rhs.getOptionalNextId();
					int cmp = lhsNextId.compareTo( rhsNextId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamIndexColBuff ) {
			CFBamIndexColBuff rhs = (CFBamIndexColBuff)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredIndexId() < rhs.getRequiredIndexId() ) {
				return( -1 );
			}
			else if( getRequiredIndexId() > rhs.getRequiredIndexId() ) {
				return( 1 );
			}
			if( getOptionalNextId() != null ) {
				Long lhsNextId = getOptionalNextId();
				if( rhs.getOptionalNextId() != null ) {
					Long rhsNextId = rhs.getOptionalNextId();
					int cmp = lhsNextId.compareTo( rhsNextId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
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
		String ret = "<CFBamIndexColByIdxNextIdx"
			+ " RequiredTenantId=" + "\"" + Long.toString( getRequiredTenantId() ) + "\""
			+ " RequiredIndexId=" + "\"" + Long.toString( getRequiredIndexId() ) + "\""
			+ " OptionalNextId=" + ( ( getOptionalNextId() == null ) ? "null" : "\"" + getOptionalNextId().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
