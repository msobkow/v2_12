
// Description: Java 11 Factory interface for GenItem.

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
import org.msscf.msscf.cfcore.CFGenKb.*;

/*
 *	CFGenKbGenItemFactory interface for GenItem
 */
public interface ICFGenKbGenItemFactory
{

	/**
	 *	Allocate a primary key for GenItem instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenItemPKey newPKey();

	/**
	 *	Allocate a TenantIdx key over GenItem instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenItemByTenantIdxKey newTenantIdxKey();

	/**
	 *	Allocate a CartIdx key over GenItem instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenItemByCartIdxKey newCartIdxKey();

	/**
	 *	Allocate a RuleTypeIdx key over GenItem instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenItemByRuleTypeIdxKey newRuleTypeIdxKey();

	/**
	 *	Allocate a ToolSetIdx key over GenItem instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenItemByToolSetIdxKey newToolSetIdxKey();

	/**
	 *	Allocate a ScopeIdx key over GenItem instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenItemByScopeIdxKey newScopeIdxKey();

	/**
	 *	Allocate a GenDefIdx key over GenItem instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenItemByGenDefIdxKey newGenDefIdxKey();

	/**
	 *	Allocate a AltIdx key over GenItem instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenItemByAltIdxKey newAltIdxKey();

	/**
	 *	Allocate a GelExecIdx key over GenItem instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenItemByGelExecIdxKey newGelExecIdxKey();

	/**
	 *	Allocate a ProbeIdx key over GenItem instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenItemByProbeIdxKey newProbeIdxKey();

	/**
	 *	Allocate a GenItem instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenItemBuff newBuff();

}
