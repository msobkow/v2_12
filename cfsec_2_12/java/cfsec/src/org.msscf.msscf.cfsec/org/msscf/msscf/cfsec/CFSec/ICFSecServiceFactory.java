
// Description: Java 11 Factory interface for Service.

/*
 *	org.msscf.msscf.CFSec
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

package org.msscf.msscf.cfsec.CFSec;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;

/*
 *	CFSecServiceFactory interface for Service
 */
public interface ICFSecServiceFactory
{

	/**
	 *	Allocate a primary key for Service instances.
	 *
	 *	@return	The new instance.
	 */
	CFSecServicePKey newPKey();

	/**
	 *	Allocate a primary history key for Service instances.
	 *
	 *	@return	The new instance.
	 */
	CFSecServiceHPKey newHPKey();

	/**
	 *	Allocate a ClusterIdx key over Service instances.
	 *
	 *	@return	The new instance.
	 */
	CFSecServiceByClusterIdxKey newClusterIdxKey();

	/**
	 *	Allocate a HostIdx key over Service instances.
	 *
	 *	@return	The new instance.
	 */
	CFSecServiceByHostIdxKey newHostIdxKey();

	/**
	 *	Allocate a TypeIdx key over Service instances.
	 *
	 *	@return	The new instance.
	 */
	CFSecServiceByTypeIdxKey newTypeIdxKey();

	/**
	 *	Allocate a UTypeIdx key over Service instances.
	 *
	 *	@return	The new instance.
	 */
	CFSecServiceByUTypeIdxKey newUTypeIdxKey();

	/**
	 *	Allocate a UHostPortIdx key over Service instances.
	 *
	 *	@return	The new instance.
	 */
	CFSecServiceByUHostPortIdxKey newUHostPortIdxKey();

	/**
	 *	Allocate a Service instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFSecServiceBuff newBuff();

	/**
	 *	Allocate a Service history instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFSecServiceHBuff newHBuff();

}
