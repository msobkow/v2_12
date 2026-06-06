// Description: Java 11 Table Object interface for CFGenKb.

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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public interface ICFGenKbSecAppTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new SecApp instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbSecAppObj newInstance();

	/**
	 *	Instantiate a new SecApp edition of the specified SecApp instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbSecAppEditObj newEditInstance( ICFGenKbSecAppObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSecAppObj realiseSecApp( ICFGenKbSecAppObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetSecApp( ICFGenKbSecAppObj Obj );
	void forgetSecApp( ICFGenKbSecAppObj Obj, boolean forgetSubObjects );
	void forgetSecAppByIdIdx( long ClusterId,
		int SecAppId );

	void forgetSecAppByClusterIdx( long ClusterId );

	void forgetSecAppByUJEEMountIdx( long ClusterId,
		String JEEMountName );


	/**
	 *	Internal use only.
	 */
	ICFGenKbSecAppObj createSecApp( ICFGenKbSecAppObj Obj );

	/**
	 *	Read a SecApp-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecApp-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbSecAppObj readSecApp( CFGenKbSecAppPKey pkey );

	/**
	 *	Read a SecApp-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecApp-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbSecAppObj readSecApp( CFGenKbSecAppPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSecAppObj lockSecApp( CFGenKbSecAppPKey pkey );

	/**
	 *	Return a sorted list of all the SecApp-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecAppObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSecAppObj> readAllSecApp();

	/**
	 *	Return a sorted map of all the SecApp-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecAppObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSecAppObj> readAllSecApp( boolean forceRead );

	/**
	 *	Return a sorted map of a page of the SecApp-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecAppObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSecAppObj> pageAllSecApp(Long priorClusterId,
		Integer priorSecAppId );

	/**
	 *	Get the CFGenKbSecAppObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The SecApp key attribute of the instance generating the id.
	 *
	 *	@param	argSecAppId	The SecApp key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecAppObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecAppObj readSecAppByIdIdx( long ClusterId,
		int SecAppId );

	/**
	 *	Get the CFGenKbSecAppObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The SecApp key attribute of the instance generating the id.
	 *
	 *	@param	argSecAppId	The SecApp key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecAppObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecAppObj readSecAppByIdIdx( long ClusterId,
		int SecAppId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbSecAppObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The SecApp key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecAppObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecAppObj> readSecAppByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFGenKbSecAppObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The SecApp key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecAppObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecAppObj> readSecAppByClusterIdx( long ClusterId,
		boolean forceRead );

	/**
	 *	Get the CFGenKbSecAppObj instance for the unique UJEEMountIdx key.
	 *
	 *	@param	argClusterId	The SecApp key attribute of the instance generating the id.
	 *
	 *	@param	argJEEMountName	The SecApp key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecAppObj cached instance for the unique UJEEMountIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecAppObj readSecAppByUJEEMountIdx(long ClusterId,
		String JEEMountName );

	/**
	 *	Get the CFGenKbSecAppObj instance for the unique UJEEMountIdx key.
	 *
	 *	@param	argClusterId	The SecApp key attribute of the instance generating the id.
	 *
	 *	@param	argJEEMountName	The SecApp key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecAppObj refreshed instance for the unique UJEEMountIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecAppObj readSecAppByUJEEMountIdx(long ClusterId,
		String JEEMountName,
		boolean forceRead );

	/**
	 *	Read a page of data as a List of SecApp-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	argClusterId	The SecApp key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecApp-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFGenKbSecAppObj> pageSecAppByClusterIdx( long ClusterId,
		Long priorClusterId,
		Integer priorSecAppId );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSecAppObj updateSecApp( ICFGenKbSecAppObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecApp( ICFGenKbSecAppObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecApp key attribute of the instance generating the id.
	 *
	 *	@param	argSecAppId	The SecApp key attribute of the instance generating the id.
	 */
	void deleteSecAppByIdIdx( long ClusterId,
		int SecAppId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecApp key attribute of the instance generating the id.
	 */
	void deleteSecAppByClusterIdx( long ClusterId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecApp key attribute of the instance generating the id.
	 *
	 *	@param	argJEEMountName	The SecApp key attribute of the instance generating the id.
	 */
	void deleteSecAppByUJEEMountIdx(long ClusterId,
		String JEEMountName );
}
