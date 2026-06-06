// Description: Java 11 Table Object interface for CFSec.

/*
 *	org.msscf.msscf.CFSec
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

package org.msscf.msscf.cfsec.CFSecObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;

public interface ICFSecHostNodeTableObj
{
	ICFSecSchemaObj getSchema();
	void setSchema( ICFSecSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new HostNode instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecHostNodeObj newInstance();

	/**
	 *	Instantiate a new HostNode edition of the specified HostNode instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecHostNodeEditObj newEditInstance( ICFSecHostNodeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecHostNodeObj realiseHostNode( ICFSecHostNodeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetHostNode( ICFSecHostNodeObj Obj );
	void forgetHostNode( ICFSecHostNodeObj Obj, boolean forgetSubObjects );
	void forgetHostNodeByIdIdx( long ClusterId,
		long HostNodeId );

	void forgetHostNodeByClusterIdx( long ClusterId );

	void forgetHostNodeByUDescrIdx( long ClusterId,
		String Description );

	void forgetHostNodeByHostNameIdx( long ClusterId,
		String HostName );


	/**
	 *	Internal use only.
	 */
	ICFSecHostNodeObj createHostNode( ICFSecHostNodeObj Obj );

	/**
	 *	Read a HostNode-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The HostNode-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecHostNodeObj readHostNode( CFSecHostNodePKey pkey );

	/**
	 *	Read a HostNode-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The HostNode-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecHostNodeObj readHostNode( CFSecHostNodePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFSecHostNodeObj lockHostNode( CFSecHostNodePKey pkey );

	/**
	 *	Return a sorted list of all the HostNode-derived instances in the database.
	 *
	 *	@return	List of ICFSecHostNodeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecHostNodeObj> readAllHostNode();

	/**
	 *	Return a sorted map of all the HostNode-derived instances in the database.
	 *
	 *	@return	List of ICFSecHostNodeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecHostNodeObj> readAllHostNode( boolean forceRead );

	/**
	 *	Return a sorted map of a page of the HostNode-derived instances in the database.
	 *
	 *	@return	List of ICFSecHostNodeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecHostNodeObj> pageAllHostNode(Long priorClusterId,
		Long priorHostNodeId );

	/**
	 *	Get the CFSecHostNodeObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	CFSecHostNodeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecHostNodeObj readHostNodeByIdIdx( long ClusterId,
		long HostNodeId );

	/**
	 *	Get the CFSecHostNodeObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	CFSecHostNodeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecHostNodeObj readHostNodeByIdIdx( long ClusterId,
		long HostNodeId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecHostNodeObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecHostNodeObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecHostNodeObj> readHostNodeByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFSecHostNodeObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecHostNodeObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecHostNodeObj> readHostNodeByClusterIdx( long ClusterId,
		boolean forceRead );

	/**
	 *	Get the CFSecHostNodeObj instance for the unique UDescrIdx key.
	 *
	 *	@param	argClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	argDescription	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	CFSecHostNodeObj cached instance for the unique UDescrIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecHostNodeObj readHostNodeByUDescrIdx(long ClusterId,
		String Description );

	/**
	 *	Get the CFSecHostNodeObj instance for the unique UDescrIdx key.
	 *
	 *	@param	argClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	argDescription	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	CFSecHostNodeObj refreshed instance for the unique UDescrIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecHostNodeObj readHostNodeByUDescrIdx(long ClusterId,
		String Description,
		boolean forceRead );

	/**
	 *	Get the CFSecHostNodeObj instance for the unique HostNameIdx key.
	 *
	 *	@param	argClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	argHostName	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	CFSecHostNodeObj cached instance for the unique HostNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecHostNodeObj readHostNodeByHostNameIdx(long ClusterId,
		String HostName );

	/**
	 *	Get the CFSecHostNodeObj instance for the unique HostNameIdx key.
	 *
	 *	@param	argClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	argHostName	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	CFSecHostNodeObj refreshed instance for the unique HostNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecHostNodeObj readHostNodeByHostNameIdx(long ClusterId,
		String HostName,
		boolean forceRead );

	/**
	 *	Read a page of data as a List of HostNode-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	argClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	A List of HostNode-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecHostNodeObj> pageHostNodeByClusterIdx( long ClusterId,
		Long priorClusterId,
		Long priorHostNodeId );

	/**
	 *	Internal use only.
	 */
	ICFSecHostNodeObj updateHostNode( ICFSecHostNodeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteHostNode( ICFSecHostNodeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The HostNode key attribute of the instance generating the id.
	 */
	void deleteHostNodeByIdIdx( long ClusterId,
		long HostNodeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The HostNode key attribute of the instance generating the id.
	 */
	void deleteHostNodeByClusterIdx( long ClusterId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	argDescription	The HostNode key attribute of the instance generating the id.
	 */
	void deleteHostNodeByUDescrIdx(long ClusterId,
		String Description );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	argHostName	The HostNode key attribute of the instance generating the id.
	 */
	void deleteHostNodeByHostNameIdx(long ClusterId,
		String HostName );
}
