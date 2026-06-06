// Description: Java 11 Table Object interface for CFSec.

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

package org.msscf.msscf.cfsec.CFSecObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;

public interface ICFSecTenantTableObj
{
	ICFSecSchemaObj getSchema();
	void setSchema( ICFSecSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new Tenant instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecTenantObj newInstance();

	/**
	 *	Instantiate a new Tenant edition of the specified Tenant instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecTenantEditObj newEditInstance( ICFSecTenantObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecTenantObj realiseTenant( ICFSecTenantObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTenant( ICFSecTenantObj Obj );
	void forgetTenant( ICFSecTenantObj Obj, boolean forgetSubObjects );
	void forgetTenantByIdIdx( long Id );

	void forgetTenantByClusterIdx( long ClusterId );

	void forgetTenantByUNameIdx( long ClusterId,
		String TenantName );


	/**
	 *	Internal use only.
	 */
	ICFSecTenantObj createTenant( ICFSecTenantObj Obj );

	/**
	 *	Read a Tenant-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Tenant-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecTenantObj readTenant( CFSecTenantPKey pkey );

	/**
	 *	Read a Tenant-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Tenant-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecTenantObj readTenant( CFSecTenantPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFSecTenantObj lockTenant( CFSecTenantPKey pkey );

	/**
	 *	Return a sorted list of all the Tenant-derived instances in the database.
	 *
	 *	@return	List of ICFSecTenantObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecTenantObj> readAllTenant();

	/**
	 *	Return a sorted map of all the Tenant-derived instances in the database.
	 *
	 *	@return	List of ICFSecTenantObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecTenantObj> readAllTenant( boolean forceRead );

	/**
	 *	Return a sorted map of a page of the Tenant-derived instances in the database.
	 *
	 *	@return	List of ICFSecTenantObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecTenantObj> pageAllTenant(Long priorId );

	/**
	 *	Get the CFSecTenantObj instance for the primary key attributes.
	 *
	 *	@param	argId	The Tenant key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTenantObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecTenantObj readTenantByIdIdx( long Id );

	/**
	 *	Get the CFSecTenantObj instance for the primary key attributes.
	 *
	 *	@param	argId	The Tenant key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTenantObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecTenantObj readTenantByIdIdx( long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFSecTenantObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The Tenant key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTenantObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTenantObj> readTenantByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFSecTenantObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The Tenant key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTenantObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTenantObj> readTenantByClusterIdx( long ClusterId,
		boolean forceRead );

	/**
	 *	Get the CFSecTenantObj instance for the unique UNameIdx key.
	 *
	 *	@param	argClusterId	The Tenant key attribute of the instance generating the id.
	 *
	 *	@param	argTenantName	The Tenant key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTenantObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecTenantObj readTenantByUNameIdx(long ClusterId,
		String TenantName );

	/**
	 *	Get the CFSecTenantObj instance for the unique UNameIdx key.
	 *
	 *	@param	argClusterId	The Tenant key attribute of the instance generating the id.
	 *
	 *	@param	argTenantName	The Tenant key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTenantObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecTenantObj readTenantByUNameIdx(long ClusterId,
		String TenantName,
		boolean forceRead );

	/**
	 *	Read a page of data as a List of Tenant-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	argClusterId	The Tenant key attribute of the instance generating the id.
	 *
	 *	@return	A List of Tenant-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecTenantObj> pageTenantByClusterIdx( long ClusterId,
		Long priorId );

	/**
	 *	Internal use only.
	 */
	ICFSecTenantObj updateTenant( ICFSecTenantObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTenant( ICFSecTenantObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argId	The Tenant key attribute of the instance generating the id.
	 */
	void deleteTenantByIdIdx( long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The Tenant key attribute of the instance generating the id.
	 */
	void deleteTenantByClusterIdx( long ClusterId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The Tenant key attribute of the instance generating the id.
	 *
	 *	@param	argTenantName	The Tenant key attribute of the instance generating the id.
	 */
	void deleteTenantByUNameIdx(long ClusterId,
		String TenantName );

	ICFSecTenantObj getSystemTenant();
}
