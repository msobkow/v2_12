// Description: Java 11 Table Object interface for CFGenKb.

/*
 *	org.msscf.msscf.CFCore
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

public interface ICFGenKbGelSpreadTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new GelSpread instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbGelSpreadObj newInstance();

	/**
	 *	Instantiate a new GelSpread edition of the specified GelSpread instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbGelSpreadEditObj newEditInstance( ICFGenKbGelSpreadObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelSpreadObj realiseGelSpread( ICFGenKbGelSpreadObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetGelSpread( ICFGenKbGelSpreadObj Obj );
	void forgetGelSpread( ICFGenKbGelSpreadObj Obj, boolean forgetSubObjects );
	void forgetGelSpreadByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	void forgetGelSpreadByTenantIdx( long TenantId );

	void forgetGelSpreadByGelCacheIdx( long TenantId,
		long GelCacheId );

	void forgetGelSpreadByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	void forgetGelSpreadByBetweenIdx( String ExpandBetween );

	void forgetGelSpreadByBeforeIdx( String ExpandBefore );

	void forgetGelSpreadByFirstIdx( String ExpandFirst );

	void forgetGelSpreadByEachIdx( String ExpandEach );

	void forgetGelSpreadByLastIdx( String ExpandLast );

	void forgetGelSpreadByLoneIdx( String ExpandLone );

	void forgetGelSpreadByEmptyIdx( String ExpandEmpty );


	/**
	 *	Internal use only.
	 */
	ICFGenKbGelSpreadObj createGelSpread( ICFGenKbGelSpreadObj Obj );

	/**
	 *	Read a GelSpread-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GelSpread-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGelSpreadObj readGelSpread( CFGenKbGelInstructionPKey pkey );

	/**
	 *	Read a GelSpread-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GelSpread-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGelSpreadObj readGelSpread( CFGenKbGelInstructionPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelSpreadObj lockGelSpread( CFGenKbGelInstructionPKey pkey );

	/**
	 *	Return a sorted list of all the GelSpread-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGelSpreadObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readAllGelSpread();

	/**
	 *	Return a sorted map of all the GelSpread-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGelSpreadObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readAllGelSpread( boolean forceRead );

	/**
	 *	Get the CFGenKbGelInstructionObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGelInstructionObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGelSpreadObj readGelSpreadByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Get the CFGenKbGelInstructionObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGelInstructionObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGelSpreadObj readGelSpreadByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFGenKbGelSpreadObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate GelCacheIdx key.
	 *
	 *	@param	argTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate GelCacheIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByGelCacheIdx( long TenantId,
		long GelCacheId );

	/**
	 *	Get the map of CFGenKbGelSpreadObj instances sorted by their primary keys for the duplicate GelCacheIdx key.
	 *
	 *	@param	argTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate GelCacheIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByGelCacheIdx( long TenantId,
		long GelCacheId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate ChainIdx key.
	 *
	 *	@param	argChainInstTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate ChainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Get the map of CFGenKbGelSpreadObj instances sorted by their primary keys for the duplicate ChainIdx key.
	 *
	 *	@param	argChainInstTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate ChainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelSpreadObj instances sorted by their primary keys for the duplicate BetweenIdx key.
	 *
	 *	@param	argExpandBetween	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate BetweenIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByBetweenIdx( String ExpandBetween );

	/**
	 *	Get the map of CFGenKbGelSpreadObj instances sorted by their primary keys for the duplicate BetweenIdx key.
	 *
	 *	@param	argExpandBetween	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate BetweenIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByBetweenIdx( String ExpandBetween,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelSpreadObj instances sorted by their primary keys for the duplicate BeforeIdx key.
	 *
	 *	@param	argExpandBefore	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate BeforeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByBeforeIdx( String ExpandBefore );

	/**
	 *	Get the map of CFGenKbGelSpreadObj instances sorted by their primary keys for the duplicate BeforeIdx key.
	 *
	 *	@param	argExpandBefore	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate BeforeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByBeforeIdx( String ExpandBefore,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelSpreadObj instances sorted by their primary keys for the duplicate FirstIdx key.
	 *
	 *	@param	argExpandFirst	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate FirstIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByFirstIdx( String ExpandFirst );

	/**
	 *	Get the map of CFGenKbGelSpreadObj instances sorted by their primary keys for the duplicate FirstIdx key.
	 *
	 *	@param	argExpandFirst	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate FirstIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByFirstIdx( String ExpandFirst,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelSpreadObj instances sorted by their primary keys for the duplicate EachIdx key.
	 *
	 *	@param	argExpandEach	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate EachIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByEachIdx( String ExpandEach );

	/**
	 *	Get the map of CFGenKbGelSpreadObj instances sorted by their primary keys for the duplicate EachIdx key.
	 *
	 *	@param	argExpandEach	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate EachIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByEachIdx( String ExpandEach,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelSpreadObj instances sorted by their primary keys for the duplicate LastIdx key.
	 *
	 *	@param	argExpandLast	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate LastIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByLastIdx( String ExpandLast );

	/**
	 *	Get the map of CFGenKbGelSpreadObj instances sorted by their primary keys for the duplicate LastIdx key.
	 *
	 *	@param	argExpandLast	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate LastIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByLastIdx( String ExpandLast,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelSpreadObj instances sorted by their primary keys for the duplicate LoneIdx key.
	 *
	 *	@param	argExpandLone	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate LoneIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByLoneIdx( String ExpandLone );

	/**
	 *	Get the map of CFGenKbGelSpreadObj instances sorted by their primary keys for the duplicate LoneIdx key.
	 *
	 *	@param	argExpandLone	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate LoneIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByLoneIdx( String ExpandLone,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelSpreadObj instances sorted by their primary keys for the duplicate EmptyIdx key.
	 *
	 *	@param	argExpandEmpty	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate EmptyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByEmptyIdx( String ExpandEmpty );

	/**
	 *	Get the map of CFGenKbGelSpreadObj instances sorted by their primary keys for the duplicate EmptyIdx key.
	 *
	 *	@param	argExpandEmpty	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSpreadObj cached instances sorted by their primary keys for the duplicate EmptyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSpreadObj> readGelSpreadByEmptyIdx( String ExpandEmpty,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelSpreadObj updateGelSpread( ICFGenKbGelSpreadObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteGelSpread( ICFGenKbGelSpreadObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByGelCacheIdx( long TenantId,
		long GelCacheId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argChainInstTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argExpandBetween	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByBetweenIdx( String ExpandBetween );

	/**
	 *	Internal use only.
	 *
	 *	@param	argExpandBefore	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByBeforeIdx( String ExpandBefore );

	/**
	 *	Internal use only.
	 *
	 *	@param	argExpandFirst	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByFirstIdx( String ExpandFirst );

	/**
	 *	Internal use only.
	 *
	 *	@param	argExpandEach	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByEachIdx( String ExpandEach );

	/**
	 *	Internal use only.
	 *
	 *	@param	argExpandLast	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByLastIdx( String ExpandLast );

	/**
	 *	Internal use only.
	 *
	 *	@param	argExpandLone	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByLoneIdx( String ExpandLone );

	/**
	 *	Internal use only.
	 *
	 *	@param	argExpandEmpty	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByEmptyIdx( String ExpandEmpty );
}
