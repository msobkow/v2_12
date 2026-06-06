
// Description: Java 11 Default Factory implementation for HostNode.

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
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;

	/*
	 *	CFGenKbHostNodeFactory implementation for HostNode
	 */
public class CFGenKbHostNodeDefaultFactory
	implements ICFGenKbHostNodeFactory
{
	public CFGenKbHostNodeDefaultFactory() {
	}

	public CFGenKbHostNodePKey newPKey() {
		CFGenKbHostNodePKey pkey =
			new CFGenKbHostNodePKey();
		return( pkey );
	}

	public CFGenKbHostNodeByClusterIdxKey newClusterIdxKey() {
		CFGenKbHostNodeByClusterIdxKey key =
			new CFGenKbHostNodeByClusterIdxKey();
		return( key );
	}

	public CFGenKbHostNodeByUDescrIdxKey newUDescrIdxKey() {
		CFGenKbHostNodeByUDescrIdxKey key =
			new CFGenKbHostNodeByUDescrIdxKey();
		return( key );
	}

	public CFGenKbHostNodeByHostNameIdxKey newHostNameIdxKey() {
		CFGenKbHostNodeByHostNameIdxKey key =
			new CFGenKbHostNodeByHostNameIdxKey();
		return( key );
	}

	public CFGenKbHostNodeBuff newBuff() {
		CFGenKbHostNodeBuff buff =
			new CFGenKbHostNodeBuff();
		return( buff );
	}
}
