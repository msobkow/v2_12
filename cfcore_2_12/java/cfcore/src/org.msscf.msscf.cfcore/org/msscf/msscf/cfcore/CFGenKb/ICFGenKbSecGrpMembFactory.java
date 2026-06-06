
// Description: Java 11 Factory interface for SecGrpMemb.

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
 *	CFGenKbSecGrpMembFactory interface for SecGrpMemb
 */
public interface ICFGenKbSecGrpMembFactory
{

	/**
	 *	Allocate a primary key for SecGrpMemb instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbSecGrpMembPKey newPKey();

	/**
	 *	Allocate a ClusterIdx key over SecGrpMemb instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbSecGrpMembByClusterIdxKey newClusterIdxKey();

	/**
	 *	Allocate a GroupIdx key over SecGrpMemb instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbSecGrpMembByGroupIdxKey newGroupIdxKey();

	/**
	 *	Allocate a UserIdx key over SecGrpMemb instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbSecGrpMembByUserIdxKey newUserIdxKey();

	/**
	 *	Allocate a UUserIdx key over SecGrpMemb instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbSecGrpMembByUUserIdxKey newUUserIdxKey();

	/**
	 *	Allocate a SecGrpMemb instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbSecGrpMembBuff newBuff();

}
