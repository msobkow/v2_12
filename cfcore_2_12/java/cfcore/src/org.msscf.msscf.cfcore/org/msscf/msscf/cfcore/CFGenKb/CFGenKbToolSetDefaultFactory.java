
// Description: Java 11 Default Factory implementation for ToolSet.

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
	 *	CFGenKbToolSetFactory implementation for ToolSet
	 */
public class CFGenKbToolSetDefaultFactory
	implements ICFGenKbToolSetFactory
{
	public CFGenKbToolSetDefaultFactory() {
	}

	public CFGenKbToolSetPKey newPKey() {
		CFGenKbToolSetPKey pkey =
			new CFGenKbToolSetPKey();
		return( pkey );
	}

	public CFGenKbToolSetByNameIdxKey newNameIdxKey() {
		CFGenKbToolSetByNameIdxKey key =
			new CFGenKbToolSetByNameIdxKey();
		return( key );
	}

	public CFGenKbToolSetByTool0IdxKey newTool0IdxKey() {
		CFGenKbToolSetByTool0IdxKey key =
			new CFGenKbToolSetByTool0IdxKey();
		return( key );
	}

	public CFGenKbToolSetByTool1IdxKey newTool1IdxKey() {
		CFGenKbToolSetByTool1IdxKey key =
			new CFGenKbToolSetByTool1IdxKey();
		return( key );
	}

	public CFGenKbToolSetByTool2IdxKey newTool2IdxKey() {
		CFGenKbToolSetByTool2IdxKey key =
			new CFGenKbToolSetByTool2IdxKey();
		return( key );
	}

	public CFGenKbToolSetByTool3IdxKey newTool3IdxKey() {
		CFGenKbToolSetByTool3IdxKey key =
			new CFGenKbToolSetByTool3IdxKey();
		return( key );
	}

	public CFGenKbToolSetByTool4IdxKey newTool4IdxKey() {
		CFGenKbToolSetByTool4IdxKey key =
			new CFGenKbToolSetByTool4IdxKey();
		return( key );
	}

	public CFGenKbToolSetByTool5IdxKey newTool5IdxKey() {
		CFGenKbToolSetByTool5IdxKey key =
			new CFGenKbToolSetByTool5IdxKey();
		return( key );
	}

	public CFGenKbToolSetByTool6IdxKey newTool6IdxKey() {
		CFGenKbToolSetByTool6IdxKey key =
			new CFGenKbToolSetByTool6IdxKey();
		return( key );
	}

	public CFGenKbToolSetByTool7IdxKey newTool7IdxKey() {
		CFGenKbToolSetByTool7IdxKey key =
			new CFGenKbToolSetByTool7IdxKey();
		return( key );
	}

	public CFGenKbToolSetBuff newBuff() {
		CFGenKbToolSetBuff buff =
			new CFGenKbToolSetBuff();
		return( buff );
	}
}
