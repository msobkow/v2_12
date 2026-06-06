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

public interface ICFGenKbGelBoilerplateTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new GelBoilerplate instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbGelBoilerplateObj newInstance();

	/**
	 *	Instantiate a new GelBoilerplate edition of the specified GelBoilerplate instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbGelBoilerplateEditObj newEditInstance( ICFGenKbGelBoilerplateObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelBoilerplateObj realiseGelBoilerplate( ICFGenKbGelBoilerplateObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetGelBoilerplate( ICFGenKbGelBoilerplateObj Obj );
	void forgetGelBoilerplate( ICFGenKbGelBoilerplateObj Obj, boolean forgetSubObjects );
	void forgetGelBoilerplateByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	void forgetGelBoilerplateByTenantIdx( long TenantId );

	void forgetGelBoilerplateByGelCacheIdx( long TenantId,
		long GelCacheId );

	void forgetGelBoilerplateByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );


	/**
	 *	Internal use only.
	 */
	ICFGenKbGelBoilerplateObj createGelBoilerplate( ICFGenKbGelBoilerplateObj Obj );

	/**
	 *	Read a GelBoilerplate-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GelBoilerplate-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGelBoilerplateObj readGelBoilerplate( CFGenKbGelInstructionPKey pkey );

	/**
	 *	Read a GelBoilerplate-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GelBoilerplate-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGelBoilerplateObj readGelBoilerplate( CFGenKbGelInstructionPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelBoilerplateObj lockGelBoilerplate( CFGenKbGelInstructionPKey pkey );

	/**
	 *	Return a sorted list of all the GelBoilerplate-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGelBoilerplateObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGelBoilerplateObj> readAllGelBoilerplate();

	/**
	 *	Return a sorted map of all the GelBoilerplate-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGelBoilerplateObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGelBoilerplateObj> readAllGelBoilerplate( boolean forceRead );

	/**
	 *	Get the CFGenKbGelInstructionObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGelInstructionObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGelBoilerplateObj readGelBoilerplateByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Get the CFGenKbGelInstructionObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGelInstructionObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGelBoilerplateObj readGelBoilerplateByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelBoilerplateObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelBoilerplateObj> readGelBoilerplateByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFGenKbGelBoilerplateObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelBoilerplateObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelBoilerplateObj> readGelBoilerplateByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate GelCacheIdx key.
	 *
	 *	@param	argTenantId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelBoilerplateObj cached instances sorted by their primary keys for the duplicate GelCacheIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelBoilerplateObj> readGelBoilerplateByGelCacheIdx( long TenantId,
		long GelCacheId );

	/**
	 *	Get the map of CFGenKbGelBoilerplateObj instances sorted by their primary keys for the duplicate GelCacheIdx key.
	 *
	 *	@param	argTenantId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelBoilerplateObj cached instances sorted by their primary keys for the duplicate GelCacheIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelBoilerplateObj> readGelBoilerplateByGelCacheIdx( long TenantId,
		long GelCacheId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate ChainIdx key.
	 *
	 *	@param	argChainInstTenantId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelBoilerplateObj cached instances sorted by their primary keys for the duplicate ChainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelBoilerplateObj> readGelBoilerplateByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Get the map of CFGenKbGelBoilerplateObj instances sorted by their primary keys for the duplicate ChainIdx key.
	 *
	 *	@param	argChainInstTenantId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelBoilerplateObj cached instances sorted by their primary keys for the duplicate ChainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelBoilerplateObj> readGelBoilerplateByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelBoilerplateObj updateGelBoilerplate( ICFGenKbGelBoilerplateObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteGelBoilerplate( ICFGenKbGelBoilerplateObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelBoilerplate key attribute of the instance generating the id.
	 */
	void deleteGelBoilerplateByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelBoilerplate key attribute of the instance generating the id.
	 */
	void deleteGelBoilerplateByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelBoilerplate key attribute of the instance generating the id.
	 */
	void deleteGelBoilerplateByGelCacheIdx( long TenantId,
		long GelCacheId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argChainInstTenantId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelBoilerplate key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelBoilerplate key attribute of the instance generating the id.
	 */
	void deleteGelBoilerplateByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );
}
