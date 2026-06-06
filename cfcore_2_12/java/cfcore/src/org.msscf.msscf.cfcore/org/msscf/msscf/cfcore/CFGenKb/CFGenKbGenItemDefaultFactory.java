
// Description: Java 11 Default Factory implementation for GenItem.

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
	 *	CFGenKbGenItemFactory implementation for GenItem
	 */
public class CFGenKbGenItemDefaultFactory
	implements ICFGenKbGenItemFactory
{
	public CFGenKbGenItemDefaultFactory() {
	}

	public CFGenKbGenItemPKey newPKey() {
		CFGenKbGenItemPKey pkey =
			new CFGenKbGenItemPKey();
		return( pkey );
	}

	public CFGenKbGenItemByTenantIdxKey newTenantIdxKey() {
		CFGenKbGenItemByTenantIdxKey key =
			new CFGenKbGenItemByTenantIdxKey();
		return( key );
	}

	public CFGenKbGenItemByCartIdxKey newCartIdxKey() {
		CFGenKbGenItemByCartIdxKey key =
			new CFGenKbGenItemByCartIdxKey();
		return( key );
	}

	public CFGenKbGenItemByRuleTypeIdxKey newRuleTypeIdxKey() {
		CFGenKbGenItemByRuleTypeIdxKey key =
			new CFGenKbGenItemByRuleTypeIdxKey();
		return( key );
	}

	public CFGenKbGenItemByToolSetIdxKey newToolSetIdxKey() {
		CFGenKbGenItemByToolSetIdxKey key =
			new CFGenKbGenItemByToolSetIdxKey();
		return( key );
	}

	public CFGenKbGenItemByScopeIdxKey newScopeIdxKey() {
		CFGenKbGenItemByScopeIdxKey key =
			new CFGenKbGenItemByScopeIdxKey();
		return( key );
	}

	public CFGenKbGenItemByGenDefIdxKey newGenDefIdxKey() {
		CFGenKbGenItemByGenDefIdxKey key =
			new CFGenKbGenItemByGenDefIdxKey();
		return( key );
	}

	public CFGenKbGenItemByAltIdxKey newAltIdxKey() {
		CFGenKbGenItemByAltIdxKey key =
			new CFGenKbGenItemByAltIdxKey();
		return( key );
	}

	public CFGenKbGenItemByGelExecIdxKey newGelExecIdxKey() {
		CFGenKbGenItemByGelExecIdxKey key =
			new CFGenKbGenItemByGelExecIdxKey();
		return( key );
	}

	public CFGenKbGenItemByProbeIdxKey newProbeIdxKey() {
		CFGenKbGenItemByProbeIdxKey key =
			new CFGenKbGenItemByProbeIdxKey();
		return( key );
	}

	public CFGenKbGenItemBuff newBuff() {
		CFGenKbGenItemBuff buff =
			new CFGenKbGenItemBuff();
		return( buff );
	}
}
