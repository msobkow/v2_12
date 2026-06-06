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

public interface ICFGenKbGelSequenceTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new GelSequence instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbGelSequenceObj newInstance();

	/**
	 *	Instantiate a new GelSequence edition of the specified GelSequence instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbGelSequenceEditObj newEditInstance( ICFGenKbGelSequenceObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelSequenceObj realiseGelSequence( ICFGenKbGelSequenceObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetGelSequence( ICFGenKbGelSequenceObj Obj );
	void forgetGelSequence( ICFGenKbGelSequenceObj Obj, boolean forgetSubObjects );
	void forgetGelSequenceByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	void forgetGelSequenceByTenantIdx( long TenantId );

	void forgetGelSequenceByGelCacheIdx( long TenantId,
		long GelCacheId );

	void forgetGelSequenceByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	void forgetGelSequenceByFirstInstIdx( Long FirstInstTenantId,
		Long FirstInstGelCacheId,
		Long FirstInstId );

	void forgetGelSequenceByLastInstIdx( Long LastInstTenantId,
		Long LastInstGelCacheId,
		Long LastInstId );


	/**
	 *	Internal use only.
	 */
	ICFGenKbGelSequenceObj createGelSequence( ICFGenKbGelSequenceObj Obj );

	/**
	 *	Read a GelSequence-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GelSequence-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGelSequenceObj readGelSequence( CFGenKbGelInstructionPKey pkey );

	/**
	 *	Read a GelSequence-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GelSequence-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGelSequenceObj readGelSequence( CFGenKbGelInstructionPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelSequenceObj lockGelSequence( CFGenKbGelInstructionPKey pkey );

	/**
	 *	Return a sorted list of all the GelSequence-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGelSequenceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGelSequenceObj> readAllGelSequence();

	/**
	 *	Return a sorted map of all the GelSequence-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGelSequenceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGelSequenceObj> readAllGelSequence( boolean forceRead );

	/**
	 *	Get the CFGenKbGelInstructionObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGelInstructionObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGelSequenceObj readGelSequenceByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Get the CFGenKbGelInstructionObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGelInstructionObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGelSequenceObj readGelSequenceByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSequenceObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSequenceObj> readGelSequenceByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFGenKbGelSequenceObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSequenceObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSequenceObj> readGelSequenceByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate GelCacheIdx key.
	 *
	 *	@param	argTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSequenceObj cached instances sorted by their primary keys for the duplicate GelCacheIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSequenceObj> readGelSequenceByGelCacheIdx( long TenantId,
		long GelCacheId );

	/**
	 *	Get the map of CFGenKbGelSequenceObj instances sorted by their primary keys for the duplicate GelCacheIdx key.
	 *
	 *	@param	argTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSequenceObj cached instances sorted by their primary keys for the duplicate GelCacheIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSequenceObj> readGelSequenceByGelCacheIdx( long TenantId,
		long GelCacheId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate ChainIdx key.
	 *
	 *	@param	argChainInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSequenceObj cached instances sorted by their primary keys for the duplicate ChainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSequenceObj> readGelSequenceByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Get the map of CFGenKbGelSequenceObj instances sorted by their primary keys for the duplicate ChainIdx key.
	 *
	 *	@param	argChainInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSequenceObj cached instances sorted by their primary keys for the duplicate ChainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSequenceObj> readGelSequenceByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelSequenceObj instances sorted by their primary keys for the duplicate FirstInstIdx key.
	 *
	 *	@param	argFirstInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argFirstInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argFirstInstId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSequenceObj cached instances sorted by their primary keys for the duplicate FirstInstIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSequenceObj> readGelSequenceByFirstInstIdx( Long FirstInstTenantId,
		Long FirstInstGelCacheId,
		Long FirstInstId );

	/**
	 *	Get the map of CFGenKbGelSequenceObj instances sorted by their primary keys for the duplicate FirstInstIdx key.
	 *
	 *	@param	argFirstInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argFirstInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argFirstInstId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSequenceObj cached instances sorted by their primary keys for the duplicate FirstInstIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSequenceObj> readGelSequenceByFirstInstIdx( Long FirstInstTenantId,
		Long FirstInstGelCacheId,
		Long FirstInstId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelSequenceObj instances sorted by their primary keys for the duplicate LastInstIdx key.
	 *
	 *	@param	argLastInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argLastInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argLastInstId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSequenceObj cached instances sorted by their primary keys for the duplicate LastInstIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSequenceObj> readGelSequenceByLastInstIdx( Long LastInstTenantId,
		Long LastInstGelCacheId,
		Long LastInstId );

	/**
	 *	Get the map of CFGenKbGelSequenceObj instances sorted by their primary keys for the duplicate LastInstIdx key.
	 *
	 *	@param	argLastInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argLastInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argLastInstId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSequenceObj cached instances sorted by their primary keys for the duplicate LastInstIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSequenceObj> readGelSequenceByLastInstIdx( Long LastInstTenantId,
		Long LastInstGelCacheId,
		Long LastInstId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelSequenceObj updateGelSequence( ICFGenKbGelSequenceObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteGelSequence( ICFGenKbGelSequenceObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSequence key attribute of the instance generating the id.
	 */
	void deleteGelSequenceByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelSequence key attribute of the instance generating the id.
	 */
	void deleteGelSequenceByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSequence key attribute of the instance generating the id.
	 */
	void deleteGelSequenceByGelCacheIdx( long TenantId,
		long GelCacheId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argChainInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelSequence key attribute of the instance generating the id.
	 */
	void deleteGelSequenceByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argFirstInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argFirstInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argFirstInstId	The GelSequence key attribute of the instance generating the id.
	 */
	void deleteGelSequenceByFirstInstIdx( Long FirstInstTenantId,
		Long FirstInstGelCacheId,
		Long FirstInstId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argLastInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argLastInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argLastInstId	The GelSequence key attribute of the instance generating the id.
	 */
	void deleteGelSequenceByLastInstIdx( Long LastInstTenantId,
		Long LastInstGelCacheId,
		Long LastInstId );
}
