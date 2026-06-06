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

public interface ICFSecSecGrpIncTableObj
{
	ICFSecSchemaObj getSchema();
	void setSchema( ICFSecSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new SecGrpInc instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecSecGrpIncObj newInstance();

	/**
	 *	Instantiate a new SecGrpInc edition of the specified SecGrpInc instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecSecGrpIncEditObj newEditInstance( ICFSecSecGrpIncObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecSecGrpIncObj realiseSecGrpInc( ICFSecSecGrpIncObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetSecGrpInc( ICFSecSecGrpIncObj Obj );
	void forgetSecGrpInc( ICFSecSecGrpIncObj Obj, boolean forgetSubObjects );
	void forgetSecGrpIncByIdIdx( long ClusterId,
		long SecGrpIncId );

	void forgetSecGrpIncByClusterIdx( long ClusterId );

	void forgetSecGrpIncByGroupIdx( long ClusterId,
		int SecGroupId );

	void forgetSecGrpIncByIncludeIdx( long ClusterId,
		int IncludeGroupId );

	void forgetSecGrpIncByUIncludeIdx( long ClusterId,
		int SecGroupId,
		int IncludeGroupId );


	/**
	 *	Internal use only.
	 */
	ICFSecSecGrpIncObj createSecGrpInc( ICFSecSecGrpIncObj Obj );

	/**
	 *	Read a SecGrpInc-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecGrpInc-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecGrpIncObj readSecGrpInc( CFSecSecGrpIncPKey pkey );

	/**
	 *	Read a SecGrpInc-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecGrpInc-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecGrpIncObj readSecGrpInc( CFSecSecGrpIncPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFSecSecGrpIncObj lockSecGrpInc( CFSecSecGrpIncPKey pkey );

	/**
	 *	Return a sorted list of all the SecGrpInc-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecGrpIncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecGrpIncObj> readAllSecGrpInc();

	/**
	 *	Return a sorted map of all the SecGrpInc-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecGrpIncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecGrpIncObj> readAllSecGrpInc( boolean forceRead );

	/**
	 *	Return a sorted map of a page of the SecGrpInc-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecGrpIncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecGrpIncObj> pageAllSecGrpInc(Long priorClusterId,
		Long priorSecGrpIncId );

	/**
	 *	Get the CFSecSecGrpIncObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGrpIncId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecGrpIncObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecGrpIncObj readSecGrpIncByIdIdx( long ClusterId,
		long SecGrpIncId );

	/**
	 *	Get the CFSecSecGrpIncObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGrpIncId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecGrpIncObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecGrpIncObj readSecGrpIncByIdIdx( long ClusterId,
		long SecGrpIncId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecGrpIncObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGrpIncObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGrpIncObj> readSecGrpIncByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFSecSecGrpIncObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGrpIncObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGrpIncObj> readSecGrpIncByClusterIdx( long ClusterId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecGrpIncObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGrpIncObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGrpIncObj> readSecGrpIncByGroupIdx( long ClusterId,
		int SecGroupId );

	/**
	 *	Get the map of CFSecSecGrpIncObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGrpIncObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGrpIncObj> readSecGrpIncByGroupIdx( long ClusterId,
		int SecGroupId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecGrpIncObj instances sorted by their primary keys for the duplicate IncludeIdx key.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGrpIncObj cached instances sorted by their primary keys for the duplicate IncludeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGrpIncObj> readSecGrpIncByIncludeIdx( long ClusterId,
		int IncludeGroupId );

	/**
	 *	Get the map of CFSecSecGrpIncObj instances sorted by their primary keys for the duplicate IncludeIdx key.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGrpIncObj cached instances sorted by their primary keys for the duplicate IncludeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGrpIncObj> readSecGrpIncByIncludeIdx( long ClusterId,
		int IncludeGroupId,
		boolean forceRead );

	/**
	 *	Get the CFSecSecGrpIncObj instance for the unique UIncludeIdx key.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecGrpIncObj cached instance for the unique UIncludeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecGrpIncObj readSecGrpIncByUIncludeIdx(long ClusterId,
		int SecGroupId,
		int IncludeGroupId );

	/**
	 *	Get the CFSecSecGrpIncObj instance for the unique UIncludeIdx key.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecGrpIncObj refreshed instance for the unique UIncludeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecGrpIncObj readSecGrpIncByUIncludeIdx(long ClusterId,
		int SecGroupId,
		int IncludeGroupId,
		boolean forceRead );

	/**
	 *	Read a page of data as a List of SecGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecGrpIncObj> pageSecGrpIncByClusterIdx( long ClusterId,
		Long priorClusterId,
		Long priorSecGrpIncId );

	/**
	 *	Read a page of data as a List of SecGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate GroupIdx key attributes.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecGrpIncObj> pageSecGrpIncByGroupIdx( long ClusterId,
		int SecGroupId,
		Long priorClusterId,
		Long priorSecGrpIncId );

	/**
	 *	Read a page of data as a List of SecGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate IncludeIdx key attributes.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecGrpIncObj> pageSecGrpIncByIncludeIdx( long ClusterId,
		int IncludeGroupId,
		Long priorClusterId,
		Long priorSecGrpIncId );

	/**
	 *	Internal use only.
	 */
	ICFSecSecGrpIncObj updateSecGrpInc( ICFSecSecGrpIncObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecGrpInc( ICFSecSecGrpIncObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGrpIncId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByIdIdx( long ClusterId,
		long SecGrpIncId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByClusterIdx( long ClusterId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByGroupIdx( long ClusterId,
		int SecGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByIncludeIdx( long ClusterId,
		int IncludeGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByUIncludeIdx(long ClusterId,
		int SecGroupId,
		int IncludeGroupId );
}
