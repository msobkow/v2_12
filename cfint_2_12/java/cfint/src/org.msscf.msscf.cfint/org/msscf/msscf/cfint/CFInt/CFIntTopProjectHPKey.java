// Description: Java 11 implementation of a TopProject history primary key object.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFInt;

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
import org.apache.commons.codec.binary.Base64;

/*
 *	CFIntTopProjectHPKey History Primary Key for TopProject

 *		requiredTenantId	Required object attribute TenantId.
 *		requiredId	Required object attribute Id. */
public class CFIntTopProjectHPKey
	extends CFIntHPKey
	implements Comparable<Object>,
		Serializable
{

	protected long requiredTenantId;
	protected long requiredId;
	public CFIntTopProjectHPKey()
	{
		super();
		requiredTenantId = CFIntTopProjectBuff.TENANTID_INIT_VALUE;
		requiredId = CFIntTopProjectBuff.ID_INIT_VALUE;
	}

	public long getRequiredTenantId() {
		return( requiredTenantId );
	}

	public void setRequiredTenantId( long value ) {
		if( value < CFIntTopProjectBuff.TENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTenantId",
				1,
				"value",
				value,
				CFIntTopProjectBuff.TENANTID_MIN_VALUE );
		}
		requiredTenantId = value;
	}

	public long getRequiredId() {
		return( requiredId );
	}

	public void setRequiredId( long value ) {
		if( value < CFIntTopProjectBuff.ID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredId",
				1,
				"value",
				value,
				CFIntTopProjectBuff.ID_MIN_VALUE );
		}
		requiredId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFIntTopProjectHPKey ) {
			CFIntTopProjectHPKey rhs = (CFIntTopProjectHPKey)obj;
			{
				long lhsClusterId = getAuditClusterId();
				long rhsClusterId = rhs.getAuditClusterId();
				if( lhsClusterId != rhsClusterId ) {
					return( false );
				}
			}
			{
				Calendar lhsAuditStamp = getAuditStamp();
				Calendar rhsAuditStamp = rhs.getAuditStamp();
				if( lhsAuditStamp != null ) {
					if( rhsAuditStamp != null ) {
						if( ! lhsAuditStamp.equals( rhsAuditStamp ) ) {
							return( false );
						}
					}
					else {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			{
				short lhsActionId = getAuditActionId();
				short rhsActionId = rhs.getAuditActionId();
				if( lhsActionId != rhsActionId ) {
					return( false );
				}
			}
			{
				int lhsRevision = getRequiredRevision();
				int rhsRevision = rhs.getRequiredRevision();
				if( lhsRevision != rhsRevision ) {
					return( false );
				}
			}
			{
				UUID lhsAuditSessionId = getAuditSessionId();
				UUID rhsAuditSessionId = rhs.getAuditSessionId();
				if( lhsAuditSessionId != null ) {
					if( rhsAuditSessionId != null ) {
						if( ! lhsAuditSessionId.equals( rhsAuditSessionId ) ) {
							return( false );
						}
					}
					else {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFIntHPKey ) {
			CFIntHPKey rhs = (CFIntHPKey)obj;
			{
				long lhsClusterId = getAuditClusterId();
				long rhsClusterId = rhs.getAuditClusterId();
				if( lhsClusterId != rhsClusterId ) {
					return( false );
				}
			}
			{
				Calendar lhsAuditStamp = getAuditStamp();
				Calendar rhsAuditStamp = rhs.getAuditStamp();
				if( lhsAuditStamp != null ) {
					if( rhsAuditStamp != null ) {
						if( ! lhsAuditStamp.equals( rhsAuditStamp ) ) {
							return( false );
						}
					}
					else {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			{
				short lhsActionId = getAuditActionId();
				short rhsActionId = rhs.getAuditActionId();
				if( lhsActionId != rhsActionId ) {
					return( false );
				}
			}
			{
				int lhsRevision = getRequiredRevision();
				int rhsRevision = rhs.getRequiredRevision();
				if( lhsRevision != rhsRevision ) {
					return( false );
				}
			}
			{
				UUID lhsAuditSessionId = getAuditSessionId();
				UUID rhsAuditSessionId = rhs.getAuditSessionId();
				if( lhsAuditSessionId != null ) {
					if( rhsAuditSessionId != null ) {
						if( ! lhsAuditSessionId.equals( rhsAuditSessionId ) ) {
							return( false );
						}
					}
					else {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFIntTopProjectPKey ) {
			CFIntTopProjectPKey rhs = (CFIntTopProjectPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFIntTopProjectHBuff ) {
			CFIntTopProjectHBuff rhs = (CFIntTopProjectHBuff)obj;
			{
				long lhsClusterId = getAuditClusterId();
				long rhsClusterId = rhs.getAuditClusterId();
				if( lhsClusterId != rhsClusterId ) {
					return( false );
				}
			}
			{
				Calendar lhsAuditStamp = getAuditStamp();
				Calendar rhsAuditStamp = rhs.getAuditStamp();
				if( lhsAuditStamp != null ) {
					if( rhsAuditStamp != null ) {
						if( ! lhsAuditStamp.equals( rhsAuditStamp ) ) {
							return( false );
						}
					}
					else {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			{
				short lhsActionId = getAuditActionId();
				short rhsActionId = rhs.getAuditActionId();
				if( lhsActionId != rhsActionId ) {
					return( false );
				}
			}
			{
				int lhsRevision = getRequiredRevision();
				int rhsRevision = rhs.getRequiredRevision();
				if( lhsRevision != rhsRevision ) {
					return( false );
				}
			}
			{
				UUID lhsAuditSessionId = getAuditSessionId();
				UUID rhsAuditSessionId = rhs.getAuditSessionId();
				if( lhsAuditSessionId != null ) {
					if( rhsAuditSessionId != null ) {
						if( ! lhsAuditSessionId.equals( rhsAuditSessionId ) ) {
							return( false );
						}
					}
					else {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFIntTopProjectBuff ) {
			CFIntTopProjectBuff rhs = (CFIntTopProjectBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
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
		int hashCode = super.hashCode();
		hashCode = hashCode + (int)( getRequiredTenantId() );
		hashCode = hashCode + (int)( getRequiredId() );
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFIntTopProjectHBuff ) {
			CFIntTopProjectHBuff rhs = (CFIntTopProjectHBuff)obj;
			int retval = 0;
			{
				long lhsAuditClusterId = getAuditClusterId();
				long rhsAuditClusterId = rhs.getAuditClusterId();
				if( lhsAuditClusterId < rhsAuditClusterId ) {
					return( -1 );
				}
				else if( lhsAuditClusterId > rhsAuditClusterId ) {
					return( 1 );
				}
			}
			{
				Calendar lhsAuditStamp = getAuditStamp();
				Calendar rhsAuditStamp = rhs.getAuditStamp();
				if( lhsAuditStamp == null ) {
					if( rhsAuditStamp != null ) {
						return( -1 );
					}
				}
				else if( rhsAuditStamp == null ) {
					return( 1 );
				}
				else {
					int cmpstat = lhsAuditStamp.compareTo( rhsAuditStamp );
					if( cmpstat != 0 ) {
						return( cmpstat );
					}
				}
			}
			{
				short lhsAuditActionId = getAuditActionId();
				short rhsAuditActionId = rhs.getAuditActionId();
				if( lhsAuditActionId < rhsAuditActionId ) {
					return( -1 );
				}
				else if( lhsAuditActionId > rhsAuditActionId ) {
					return( 1 );
				}
			}
			{
				int lhsRequiredRevision = getRequiredRevision();
				int rhsRequiredRevision = rhs.getRequiredRevision();
				if( lhsRequiredRevision < rhsRequiredRevision ) {
					return( -1 );
				}
				else if( lhsRequiredRevision > rhsRequiredRevision ) {
					return( 1 );
				}
			}
			{
				UUID lhsAuditSessionId = getAuditSessionId();
				UUID rhsAuditSessionId = rhs.getAuditSessionId();
				if( lhsAuditSessionId == null ) {
					if( rhsAuditSessionId != null ) {
						return( -1 );
					}
				}
				else if( rhsAuditSessionId == null ) {
					return( 1 );
				}
				else {
					int cmpstat = lhsAuditSessionId.compareTo( rhsAuditSessionId );
					if( cmpstat != 0 ) {
						return( cmpstat );
					}
				}
			}
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFIntTopProjectHPKey ) {
			CFIntTopProjectHPKey rhs = (CFIntTopProjectHPKey)obj;
			{
				long lhsAuditClusterId = getAuditClusterId();
				long rhsAuditClusterId = rhs.getAuditClusterId();
				if( lhsAuditClusterId < rhsAuditClusterId ) {
					return( -1 );
				}
				else if( lhsAuditClusterId > rhsAuditClusterId ) {
					return( 1 );
				}
			}
			{
				Calendar lhsAuditStamp = getAuditStamp();
				Calendar rhsAuditStamp = rhs.getAuditStamp();
				if( lhsAuditStamp == null ) {
					if( rhsAuditStamp != null ) {
						return( -1 );
					}
				}
				else if( rhsAuditStamp == null ) {
					return( 1 );
				}
				else {
					int cmpstat = lhsAuditStamp.compareTo( rhsAuditStamp );
					if( cmpstat != 0 ) {
						return( cmpstat );
					}
				}
			}
			{
				short lhsAuditActionId = getAuditActionId();
				short rhsAuditActionId = rhs.getAuditActionId();
				if( lhsAuditActionId < rhsAuditActionId ) {
					return( -1 );
				}
				else if( lhsAuditActionId > rhsAuditActionId ) {
					return( 1 );
				}
			}
			{
				int lhsRequiredRevision = getRequiredRevision();
				int rhsRequiredRevision = rhs.getRequiredRevision();
				if( lhsRequiredRevision < rhsRequiredRevision ) {
					return( -1 );
				}
				else if( lhsRequiredRevision > rhsRequiredRevision ) {
					return( 1 );
				}
			}
			{
				UUID lhsAuditSessionId = getAuditSessionId();
				UUID rhsAuditSessionId = rhs.getAuditSessionId();
				if( lhsAuditSessionId == null ) {
					if( rhsAuditSessionId != null ) {
						return( -1 );
					}
				}
				else if( rhsAuditSessionId == null ) {
					return( 1 );
				}
				else {
					int cmpstat = lhsAuditSessionId.compareTo( rhsAuditSessionId );
					if( cmpstat != 0 ) {
						return( cmpstat );
					}
				}
			}
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFIntHPKey ) {
			CFIntHPKey rhs = (CFIntHPKey)obj;
			{
				long lhsAuditClusterId = getAuditClusterId();
				long rhsAuditClusterId = rhs.getAuditClusterId();
				if( lhsAuditClusterId < rhsAuditClusterId ) {
					return( -1 );
				}
				else if( lhsAuditClusterId > rhsAuditClusterId ) {
					return( 1 );
				}
			}
			{
				Calendar lhsAuditStamp = getAuditStamp();
				Calendar rhsAuditStamp = rhs.getAuditStamp();
				if( lhsAuditStamp == null ) {
					if( rhsAuditStamp != null ) {
						return( -1 );
					}
				}
				else if( rhsAuditStamp == null ) {
					return( 1 );
				}
				else {
					int cmpstat = lhsAuditStamp.compareTo( rhsAuditStamp );
					if( cmpstat != 0 ) {
						return( cmpstat );
					}
				}
			}
			{
				short lhsAuditActionId = getAuditActionId();
				short rhsAuditActionId = rhs.getAuditActionId();
				if( lhsAuditActionId < rhsAuditActionId ) {
					return( -1 );
				}
				else if( lhsAuditActionId > rhsAuditActionId ) {
					return( 1 );
				}
			}
			{
				int lhsRequiredRevision = getRequiredRevision();
				int rhsRequiredRevision = rhs.getRequiredRevision();
				if( lhsRequiredRevision < rhsRequiredRevision ) {
					return( -1 );
				}
				else if( lhsRequiredRevision > rhsRequiredRevision ) {
					return( 1 );
				}
			}
			{
				UUID lhsAuditSessionId = getAuditSessionId();
				UUID rhsAuditSessionId = rhs.getAuditSessionId();
				if( lhsAuditSessionId == null ) {
					if( rhsAuditSessionId != null ) {
						return( -1 );
					}
				}
				else if( rhsAuditSessionId == null ) {
					return( 1 );
				}
				else {
					int cmpstat = lhsAuditSessionId.compareTo( rhsAuditSessionId );
					if( cmpstat != 0 ) {
						return( cmpstat );
					}
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFIntTopProjectPKey ) {
			CFIntTopProjectPKey rhs = (CFIntTopProjectPKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFIntTopProjectBuff ) {
			CFIntTopProjectBuff rhs = (CFIntTopProjectBuff)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
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
				"CFIntTopProjectHPKey, CFIntTopProjectPKey, CFIntTopProjectBuff" );
		}
	}

	public String toString() {
		String ret = "<CFIntTopProjectHPKey"
			+ " RequiredTenantId=" + "\"" + Long.toString( getRequiredTenantId() ) + "\""
			+ " RequiredId=" + "\"" + Long.toString( getRequiredId() ) + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ "/>";
		return( ret );
	}

}
