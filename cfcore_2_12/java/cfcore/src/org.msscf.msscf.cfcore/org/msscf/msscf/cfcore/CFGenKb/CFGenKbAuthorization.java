// Description: Java 11 CFGenKb Authorization Interface.

/*
 *	org.msscf.msscf.CFCore
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
import java.net.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKbObj.ICFGenKbClusterObj;
import org.msscf.msscf.cfcore.CFGenKbObj.ICFGenKbTenantObj;
import org.msscf.msscf.cfcore.CFGenKbObj.ICFGenKbSecSessionObj;

/*
 *	A CFGenKbAuthorization is an authorization ticket
 *	for the system providing services.  For example, a
 *	database layer implements an Authorization that
 *	resolves a database connection (which may be under the
 *	control of an active cursor).
 */
public class CFGenKbAuthorization
	implements Serializable
{
	protected UUID authUUID;
	protected String authUUIDStr;

	protected long secClusterId = 0L;
	protected long secTenantId = 0L;
	protected UUID secSessionId = UUID.randomUUID();
	protected UUID secUserId = UUID.randomUUID();

	public CFGenKbAuthorization() {
		authUUID = UUID.randomUUID();
		authUUIDStr = authUUID.toString();
	}

	public UUID getAuthUUID() {
		return( authUUID );
	}

	public void setAuthUUID( UUID value ) {
		authUUID = value;
		authUUIDStr = authUUID.toString();
	}

	public String getAuthUUIDStr() {
		return( authUUIDStr );
	}

	public long getSecClusterId() {
		return( secClusterId );
	}

	public void setSecClusterId( long clusterId ) {
		secClusterId = clusterId;
	}

	public void setSecCluster( ICFGenKbClusterObj value ) {
		// The cluster id is never cleared to 0 after it's been set
		if( value != null ) {
			secClusterId = value.getRequiredId();
		}
	}

	public long getSecTenantId() {
		return( secTenantId );
	}

	public void setSecTenantId( long tenantId ) {
		secTenantId = tenantId;
	}

	public void setSecTenant( ICFGenKbTenantObj value ) {
		// The tenant id is never cleared to 0 after it's been set
		if( value != null ) {
			secTenantId = value.getRequiredId();
		}
	}

	public UUID getSecSessionId() {
		return( secSessionId );
	}

	public void setSecSessionId( UUID sessionId ) {
		secSessionId = sessionId;
	}

	public void setSecSession( ICFGenKbSecSessionObj value )
	{
		// The session and user id are never cleared after they've been set
		if( value != null ) {
			secSessionId = value.getRequiredSecSessionId();
			secUserId = value.getRequiredSecUserId();
		}
	}

	public UUID getSecUserId() {
		return( secUserId );
	}

	public void setSecUserId( UUID userId ) {
		secUserId = userId;
	}
}
