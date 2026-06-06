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

public interface ICFGenKbSecSessionTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new SecSession instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbSecSessionObj newInstance();

	/**
	 *	Instantiate a new SecSession edition of the specified SecSession instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbSecSessionEditObj newEditInstance( ICFGenKbSecSessionObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSecSessionObj realiseSecSession( ICFGenKbSecSessionObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetSecSession( ICFGenKbSecSessionObj Obj );
	void forgetSecSession( ICFGenKbSecSessionObj Obj, boolean forgetSubObjects );
	void forgetSecSessionByIdIdx( UUID SecSessionId );

	void forgetSecSessionBySecUserIdx( UUID SecUserId );

	void forgetSecSessionBySecDevIdx( UUID SecUserId,
		String SecDevName );

	void forgetSecSessionByStartIdx( UUID SecUserId,
		Calendar Start );

	void forgetSecSessionByFinishIdx( UUID SecUserId,
		Calendar Finish );

	void forgetSecSessionBySecProxyIdx( UUID SecProxyId );


	/**
	 *	Internal use only.
	 */
	ICFGenKbSecSessionObj createSecSession( ICFGenKbSecSessionObj Obj );

	/**
	 *	Read a SecSession-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecSession-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbSecSessionObj readSecSession( CFGenKbSecSessionPKey pkey );

	/**
	 *	Read a SecSession-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecSession-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbSecSessionObj readSecSession( CFGenKbSecSessionPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSecSessionObj lockSecSession( CFGenKbSecSessionPKey pkey );

	/**
	 *	Return a sorted list of all the SecSession-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecSessionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSecSessionObj> readAllSecSession();

	/**
	 *	Return a sorted map of all the SecSession-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecSessionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSecSessionObj> readAllSecSession( boolean forceRead );

	/**
	 *	Return a sorted map of a page of the SecSession-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecSessionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSecSessionObj> pageAllSecSession(UUID priorSecSessionId );

	/**
	 *	Get the CFGenKbSecSessionObj instance for the primary key attributes.
	 *
	 *	@param	argSecSessionId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecSessionObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecSessionObj readSecSessionByIdIdx( UUID SecSessionId );

	/**
	 *	Get the CFGenKbSecSessionObj instance for the primary key attributes.
	 *
	 *	@param	argSecSessionId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecSessionObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecSessionObj readSecSessionByIdIdx( UUID SecSessionId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbSecSessionObj instances sorted by their primary keys for the duplicate SecUserIdx key.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecSessionObj cached instances sorted by their primary keys for the duplicate SecUserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecSessionObj> readSecSessionBySecUserIdx( UUID SecUserId );

	/**
	 *	Get the map of CFGenKbSecSessionObj instances sorted by their primary keys for the duplicate SecUserIdx key.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecSessionObj cached instances sorted by their primary keys for the duplicate SecUserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecSessionObj> readSecSessionBySecUserIdx( UUID SecUserId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbSecSessionObj instances sorted by their primary keys for the duplicate SecDevIdx key.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	argSecDevName	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecSessionObj cached instances sorted by their primary keys for the duplicate SecDevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecSessionObj> readSecSessionBySecDevIdx( UUID SecUserId,
		String SecDevName );

	/**
	 *	Get the map of CFGenKbSecSessionObj instances sorted by their primary keys for the duplicate SecDevIdx key.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	argSecDevName	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecSessionObj cached instances sorted by their primary keys for the duplicate SecDevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecSessionObj> readSecSessionBySecDevIdx( UUID SecUserId,
		String SecDevName,
		boolean forceRead );

	/**
	 *	Get the CFGenKbSecSessionObj instance for the unique StartIdx key.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	argStart	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecSessionObj cached instance for the unique StartIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecSessionObj readSecSessionByStartIdx(UUID SecUserId,
		Calendar Start );

	/**
	 *	Get the CFGenKbSecSessionObj instance for the unique StartIdx key.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	argStart	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecSessionObj refreshed instance for the unique StartIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecSessionObj readSecSessionByStartIdx(UUID SecUserId,
		Calendar Start,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbSecSessionObj instances sorted by their primary keys for the duplicate FinishIdx key.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	argFinish	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecSessionObj cached instances sorted by their primary keys for the duplicate FinishIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecSessionObj> readSecSessionByFinishIdx( UUID SecUserId,
		Calendar Finish );

	/**
	 *	Get the map of CFGenKbSecSessionObj instances sorted by their primary keys for the duplicate FinishIdx key.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	argFinish	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecSessionObj cached instances sorted by their primary keys for the duplicate FinishIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecSessionObj> readSecSessionByFinishIdx( UUID SecUserId,
		Calendar Finish,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbSecSessionObj instances sorted by their primary keys for the duplicate SecProxyIdx key.
	 *
	 *	@param	argSecProxyId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecSessionObj cached instances sorted by their primary keys for the duplicate SecProxyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecSessionObj> readSecSessionBySecProxyIdx( UUID SecProxyId );

	/**
	 *	Get the map of CFGenKbSecSessionObj instances sorted by their primary keys for the duplicate SecProxyIdx key.
	 *
	 *	@param	argSecProxyId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecSessionObj cached instances sorted by their primary keys for the duplicate SecProxyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecSessionObj> readSecSessionBySecProxyIdx( UUID SecProxyId,
		boolean forceRead );

	/**
	 *	Read a page of data as a List of SecSession-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SecUserIdx key attributes.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSession-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFGenKbSecSessionObj> pageSecSessionBySecUserIdx( UUID SecUserId,
		UUID priorSecSessionId );

	/**
	 *	Read a page of data as a List of SecSession-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SecDevIdx key attributes.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	argSecDevName	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSession-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFGenKbSecSessionObj> pageSecSessionBySecDevIdx( UUID SecUserId,
		String SecDevName,
		UUID priorSecSessionId );

	/**
	 *	Read a page of data as a List of SecSession-derived instances sorted by their primary keys,
	 *	as identified by the duplicate FinishIdx key attributes.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	argFinish	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSession-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFGenKbSecSessionObj> pageSecSessionByFinishIdx( UUID SecUserId,
		Calendar Finish,
		UUID priorSecSessionId );

	/**
	 *	Read a page of data as a List of SecSession-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SecProxyIdx key attributes.
	 *
	 *	@param	argSecProxyId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSession-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFGenKbSecSessionObj> pageSecSessionBySecProxyIdx( UUID SecProxyId,
		UUID priorSecSessionId );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSecSessionObj updateSecSession( ICFGenKbSecSessionObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecSession( ICFGenKbSecSessionObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argSecSessionId	The SecSession key attribute of the instance generating the id.
	 */
	void deleteSecSessionByIdIdx( UUID SecSessionId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 */
	void deleteSecSessionBySecUserIdx( UUID SecUserId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	argSecDevName	The SecSession key attribute of the instance generating the id.
	 */
	void deleteSecSessionBySecDevIdx( UUID SecUserId,
		String SecDevName );

	/**
	 *	Internal use only.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	argStart	The SecSession key attribute of the instance generating the id.
	 */
	void deleteSecSessionByStartIdx(UUID SecUserId,
		Calendar Start );

	/**
	 *	Internal use only.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	argFinish	The SecSession key attribute of the instance generating the id.
	 */
	void deleteSecSessionByFinishIdx( UUID SecUserId,
		Calendar Finish );

	/**
	 *	Internal use only.
	 *
	 *	@param	argSecProxyId	The SecSession key attribute of the instance generating the id.
	 */
	void deleteSecSessionBySecProxyIdx( UUID SecProxyId );

	ICFGenKbSecSessionObj getSystemSession();
}
