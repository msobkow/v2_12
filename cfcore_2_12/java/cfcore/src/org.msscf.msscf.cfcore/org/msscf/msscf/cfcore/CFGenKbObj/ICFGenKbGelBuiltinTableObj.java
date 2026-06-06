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

public interface ICFGenKbGelBuiltinTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new GelBuiltin instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbGelBuiltinObj newInstance();

	/**
	 *	Instantiate a new GelBuiltin edition of the specified GelBuiltin instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbGelBuiltinEditObj newEditInstance( ICFGenKbGelBuiltinObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelBuiltinObj realiseGelBuiltin( ICFGenKbGelBuiltinObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetGelBuiltin( ICFGenKbGelBuiltinObj Obj );
	void forgetGelBuiltin( ICFGenKbGelBuiltinObj Obj, boolean forgetSubObjects );
	void forgetGelBuiltinByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	void forgetGelBuiltinByTenantIdx( long TenantId );

	void forgetGelBuiltinByGelCacheIdx( long TenantId,
		long GelCacheId );

	void forgetGelBuiltinByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );


	/**
	 *	Internal use only.
	 */
	ICFGenKbGelBuiltinObj createGelBuiltin( ICFGenKbGelBuiltinObj Obj );

	/**
	 *	Read a GelBuiltin-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GelBuiltin-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGelBuiltinObj readGelBuiltin( CFGenKbGelInstructionPKey pkey );

	/**
	 *	Read a GelBuiltin-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GelBuiltin-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGelBuiltinObj readGelBuiltin( CFGenKbGelInstructionPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelBuiltinObj lockGelBuiltin( CFGenKbGelInstructionPKey pkey );

	/**
	 *	Return a sorted list of all the GelBuiltin-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGelBuiltinObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGelBuiltinObj> readAllGelBuiltin();

	/**
	 *	Return a sorted map of all the GelBuiltin-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGelBuiltinObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGelBuiltinObj> readAllGelBuiltin( boolean forceRead );

	/**
	 *	Get the CFGenKbGelInstructionObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGelInstructionObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGelBuiltinObj readGelBuiltinByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Get the CFGenKbGelInstructionObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGelInstructionObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGelBuiltinObj readGelBuiltinByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelBuiltinObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelBuiltinObj> readGelBuiltinByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFGenKbGelBuiltinObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelBuiltinObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelBuiltinObj> readGelBuiltinByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate GelCacheIdx key.
	 *
	 *	@param	argTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelBuiltinObj cached instances sorted by their primary keys for the duplicate GelCacheIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelBuiltinObj> readGelBuiltinByGelCacheIdx( long TenantId,
		long GelCacheId );

	/**
	 *	Get the map of CFGenKbGelBuiltinObj instances sorted by their primary keys for the duplicate GelCacheIdx key.
	 *
	 *	@param	argTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelBuiltinObj cached instances sorted by their primary keys for the duplicate GelCacheIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelBuiltinObj> readGelBuiltinByGelCacheIdx( long TenantId,
		long GelCacheId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate ChainIdx key.
	 *
	 *	@param	argChainInstTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelBuiltinObj cached instances sorted by their primary keys for the duplicate ChainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelBuiltinObj> readGelBuiltinByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Get the map of CFGenKbGelBuiltinObj instances sorted by their primary keys for the duplicate ChainIdx key.
	 *
	 *	@param	argChainInstTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelBuiltinObj cached instances sorted by their primary keys for the duplicate ChainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelBuiltinObj> readGelBuiltinByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelBuiltinObj updateGelBuiltin( ICFGenKbGelBuiltinObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteGelBuiltin( ICFGenKbGelBuiltinObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelBuiltin key attribute of the instance generating the id.
	 */
	void deleteGelBuiltinByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelBuiltin key attribute of the instance generating the id.
	 */
	void deleteGelBuiltinByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelBuiltin key attribute of the instance generating the id.
	 */
	void deleteGelBuiltinByGelCacheIdx( long TenantId,
		long GelCacheId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argChainInstTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelBuiltin key attribute of the instance generating the id.
	 */
	void deleteGelBuiltinByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );
}
