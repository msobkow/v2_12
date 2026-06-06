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

public interface ICFSecServiceTableObj
{
	ICFSecSchemaObj getSchema();
	void setSchema( ICFSecSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new Service instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecServiceObj newInstance();

	/**
	 *	Instantiate a new Service edition of the specified Service instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecServiceEditObj newEditInstance( ICFSecServiceObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecServiceObj realiseService( ICFSecServiceObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetService( ICFSecServiceObj Obj );
	void forgetService( ICFSecServiceObj Obj, boolean forgetSubObjects );
	void forgetServiceByIdIdx( long ClusterId,
		long ServiceId );

	void forgetServiceByClusterIdx( long ClusterId );

	void forgetServiceByHostIdx( long ClusterId,
		long HostNodeId );

	void forgetServiceByTypeIdx( int ServiceTypeId );

	void forgetServiceByUTypeIdx( long ClusterId,
		long HostNodeId,
		int ServiceTypeId );

	void forgetServiceByUHostPortIdx( long ClusterId,
		long HostNodeId,
		short HostPort );


	/**
	 *	Internal use only.
	 */
	ICFSecServiceObj createService( ICFSecServiceObj Obj );

	/**
	 *	Read a Service-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Service-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecServiceObj readService( CFSecServicePKey pkey );

	/**
	 *	Read a Service-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Service-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecServiceObj readService( CFSecServicePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFSecServiceObj lockService( CFSecServicePKey pkey );

	/**
	 *	Return a sorted list of all the Service-derived instances in the database.
	 *
	 *	@return	List of ICFSecServiceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecServiceObj> readAllService();

	/**
	 *	Return a sorted map of all the Service-derived instances in the database.
	 *
	 *	@return	List of ICFSecServiceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecServiceObj> readAllService( boolean forceRead );

	/**
	 *	Return a sorted map of a page of the Service-derived instances in the database.
	 *
	 *	@return	List of ICFSecServiceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecServiceObj> pageAllService(Long priorClusterId,
		Long priorServiceId );

	/**
	 *	Get the CFSecServiceObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argServiceId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	CFSecServiceObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecServiceObj readServiceByIdIdx( long ClusterId,
		long ServiceId );

	/**
	 *	Get the CFSecServiceObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argServiceId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	CFSecServiceObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecServiceObj readServiceByIdIdx( long ClusterId,
		long ServiceId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecServiceObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecServiceObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecServiceObj> readServiceByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFSecServiceObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecServiceObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecServiceObj> readServiceByClusterIdx( long ClusterId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecServiceObj instances sorted by their primary keys for the duplicate HostIdx key.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecServiceObj cached instances sorted by their primary keys for the duplicate HostIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecServiceObj> readServiceByHostIdx( long ClusterId,
		long HostNodeId );

	/**
	 *	Get the map of CFSecServiceObj instances sorted by their primary keys for the duplicate HostIdx key.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecServiceObj cached instances sorted by their primary keys for the duplicate HostIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecServiceObj> readServiceByHostIdx( long ClusterId,
		long HostNodeId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecServiceObj instances sorted by their primary keys for the duplicate TypeIdx key.
	 *
	 *	@param	argServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecServiceObj cached instances sorted by their primary keys for the duplicate TypeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecServiceObj> readServiceByTypeIdx( int ServiceTypeId );

	/**
	 *	Get the map of CFSecServiceObj instances sorted by their primary keys for the duplicate TypeIdx key.
	 *
	 *	@param	argServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecServiceObj cached instances sorted by their primary keys for the duplicate TypeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecServiceObj> readServiceByTypeIdx( int ServiceTypeId,
		boolean forceRead );

	/**
	 *	Get the CFSecServiceObj instance for the unique UTypeIdx key.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	CFSecServiceObj cached instance for the unique UTypeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecServiceObj readServiceByUTypeIdx(long ClusterId,
		long HostNodeId,
		int ServiceTypeId );

	/**
	 *	Get the CFSecServiceObj instance for the unique UTypeIdx key.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	CFSecServiceObj refreshed instance for the unique UTypeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecServiceObj readServiceByUTypeIdx(long ClusterId,
		long HostNodeId,
		int ServiceTypeId,
		boolean forceRead );

	/**
	 *	Get the CFSecServiceObj instance for the unique UHostPortIdx key.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostPort	The Service key attribute of the instance generating the id.
	 *
	 *	@return	CFSecServiceObj cached instance for the unique UHostPortIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecServiceObj readServiceByUHostPortIdx(long ClusterId,
		long HostNodeId,
		short HostPort );

	/**
	 *	Get the CFSecServiceObj instance for the unique UHostPortIdx key.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostPort	The Service key attribute of the instance generating the id.
	 *
	 *	@return	CFSecServiceObj refreshed instance for the unique UHostPortIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecServiceObj readServiceByUHostPortIdx(long ClusterId,
		long HostNodeId,
		short HostPort,
		boolean forceRead );

	/**
	 *	Read a page of data as a List of Service-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	A List of Service-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecServiceObj> pageServiceByClusterIdx( long ClusterId,
		Long priorClusterId,
		Long priorServiceId );

	/**
	 *	Read a page of data as a List of Service-derived instances sorted by their primary keys,
	 *	as identified by the duplicate HostIdx key attributes.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	A List of Service-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecServiceObj> pageServiceByHostIdx( long ClusterId,
		long HostNodeId,
		Long priorClusterId,
		Long priorServiceId );

	/**
	 *	Read a page of data as a List of Service-derived instances sorted by their primary keys,
	 *	as identified by the duplicate TypeIdx key attributes.
	 *
	 *	@param	argServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	A List of Service-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecServiceObj> pageServiceByTypeIdx( int ServiceTypeId,
		Long priorClusterId,
		Long priorServiceId );

	/**
	 *	Internal use only.
	 */
	ICFSecServiceObj updateService( ICFSecServiceObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteService( ICFSecServiceObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argServiceId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByIdIdx( long ClusterId,
		long ServiceId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByClusterIdx( long ClusterId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByHostIdx( long ClusterId,
		long HostNodeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argServiceTypeId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByTypeIdx( int ServiceTypeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argServiceTypeId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByUTypeIdx(long ClusterId,
		long HostNodeId,
		int ServiceTypeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostPort	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByUHostPortIdx(long ClusterId,
		long HostNodeId,
		short HostPort );
}
