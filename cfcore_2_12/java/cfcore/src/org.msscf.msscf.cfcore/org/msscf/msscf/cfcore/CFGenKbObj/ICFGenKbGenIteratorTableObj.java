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

public interface ICFGenKbGenIteratorTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new GenIterator instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbGenIteratorObj newInstance();

	/**
	 *	Instantiate a new GenIterator edition of the specified GenIterator instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbGenIteratorEditObj newEditInstance( ICFGenKbGenIteratorObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGenIteratorObj realiseGenIterator( ICFGenKbGenIteratorObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetGenIterator( ICFGenKbGenIteratorObj Obj );
	void forgetGenIterator( ICFGenKbGenIteratorObj Obj, boolean forgetSubObjects );
	void forgetGenIteratorByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId );

	void forgetGenIteratorByTenantIdx( long TenantId );

	void forgetGenIteratorByCartIdx( long TenantId,
		long CartridgeId );

	void forgetGenIteratorByRuleTypeIdx( short RuleTypeId );

	void forgetGenIteratorByToolSetIdx( short ToolSetId );

	void forgetGenIteratorByScopeIdx( Short ScopeDefId );

	void forgetGenIteratorByGenDefIdx( short GenDefId );

	void forgetGenIteratorByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId );

	void forgetGenIteratorByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId );

	void forgetGenIteratorByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId );


	/**
	 *	Internal use only.
	 */
	ICFGenKbGenIteratorObj createGenIterator( ICFGenKbGenIteratorObj Obj );

	/**
	 *	Read a GenIterator-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GenIterator-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGenIteratorObj readGenIterator( CFGenKbGenItemPKey pkey );

	/**
	 *	Read a GenIterator-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GenIterator-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGenIteratorObj readGenIterator( CFGenKbGenItemPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGenIteratorObj lockGenIterator( CFGenKbGenItemPKey pkey );

	/**
	 *	Return a sorted list of all the GenIterator-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGenIteratorObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGenIteratorObj> readAllGenIterator();

	/**
	 *	Return a sorted map of all the GenIterator-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGenIteratorObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGenIteratorObj> readAllGenIterator( boolean forceRead );

	/**
	 *	Get the CFGenKbGenItemObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGenItemObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGenIteratorObj readGenIteratorByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId );

	/**
	 *	Get the CFGenKbGenItemObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGenItemObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGenIteratorObj readGenIteratorByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenIteratorObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenIteratorObj> readGenIteratorByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFGenKbGenIteratorObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenIteratorObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenIteratorObj> readGenIteratorByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate CartIdx key.
	 *
	 *	@param	argTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenIteratorObj cached instances sorted by their primary keys for the duplicate CartIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenIteratorObj> readGenIteratorByCartIdx( long TenantId,
		long CartridgeId );

	/**
	 *	Get the map of CFGenKbGenIteratorObj instances sorted by their primary keys for the duplicate CartIdx key.
	 *
	 *	@param	argTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenIteratorObj cached instances sorted by their primary keys for the duplicate CartIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenIteratorObj> readGenIteratorByCartIdx( long TenantId,
		long CartridgeId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate RuleTypeIdx key.
	 *
	 *	@param	argRuleTypeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenIteratorObj cached instances sorted by their primary keys for the duplicate RuleTypeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenIteratorObj> readGenIteratorByRuleTypeIdx( short RuleTypeId );

	/**
	 *	Get the map of CFGenKbGenIteratorObj instances sorted by their primary keys for the duplicate RuleTypeIdx key.
	 *
	 *	@param	argRuleTypeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenIteratorObj cached instances sorted by their primary keys for the duplicate RuleTypeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenIteratorObj> readGenIteratorByRuleTypeIdx( short RuleTypeId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate ToolSetIdx key.
	 *
	 *	@param	argToolSetId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenIteratorObj cached instances sorted by their primary keys for the duplicate ToolSetIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenIteratorObj> readGenIteratorByToolSetIdx( short ToolSetId );

	/**
	 *	Get the map of CFGenKbGenIteratorObj instances sorted by their primary keys for the duplicate ToolSetIdx key.
	 *
	 *	@param	argToolSetId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenIteratorObj cached instances sorted by their primary keys for the duplicate ToolSetIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenIteratorObj> readGenIteratorByToolSetIdx( short ToolSetId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argScopeDefId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenIteratorObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenIteratorObj> readGenIteratorByScopeIdx( Short ScopeDefId );

	/**
	 *	Get the map of CFGenKbGenIteratorObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argScopeDefId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenIteratorObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenIteratorObj> readGenIteratorByScopeIdx( Short ScopeDefId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate GenDefIdx key.
	 *
	 *	@param	argGenDefId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenIteratorObj cached instances sorted by their primary keys for the duplicate GenDefIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenIteratorObj> readGenIteratorByGenDefIdx( short GenDefId );

	/**
	 *	Get the map of CFGenKbGenIteratorObj instances sorted by their primary keys for the duplicate GenDefIdx key.
	 *
	 *	@param	argGenDefId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenIteratorObj cached instances sorted by their primary keys for the duplicate GenDefIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenIteratorObj> readGenIteratorByGenDefIdx( short GenDefId,
		boolean forceRead );

	/**
	 *	Get the CFGenKbGenItemObj instance for the unique AltIdx key.
	 *
	 *	@param	argName	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGenItemObj cached instance for the unique AltIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGenIteratorObj readGenIteratorByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId );

	/**
	 *	Get the CFGenKbGenItemObj instance for the unique AltIdx key.
	 *
	 *	@param	argName	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGenItemObj refreshed instance for the unique AltIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGenIteratorObj readGenIteratorByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate GelExecIdx key.
	 *
	 *	@param	argGelExecutableTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenIteratorObj cached instances sorted by their primary keys for the duplicate GelExecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenIteratorObj> readGenIteratorByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId );

	/**
	 *	Get the map of CFGenKbGenIteratorObj instances sorted by their primary keys for the duplicate GelExecIdx key.
	 *
	 *	@param	argGelExecutableTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenIteratorObj cached instances sorted by their primary keys for the duplicate GelExecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenIteratorObj> readGenIteratorByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate ProbeIdx key.
	 *
	 *	@param	argProbeTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenIteratorObj cached instances sorted by their primary keys for the duplicate ProbeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenIteratorObj> readGenIteratorByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId );

	/**
	 *	Get the map of CFGenKbGenIteratorObj instances sorted by their primary keys for the duplicate ProbeIdx key.
	 *
	 *	@param	argProbeTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenIteratorObj cached instances sorted by their primary keys for the duplicate ProbeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenIteratorObj> readGenIteratorByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGenIteratorObj updateGenIterator( ICFGenKbGenIteratorObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteGenIterator( ICFGenKbGenIteratorObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByCartIdx( long TenantId,
		long CartridgeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argRuleTypeId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByRuleTypeIdx( short RuleTypeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argToolSetId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByToolSetIdx( short ToolSetId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argScopeDefId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByScopeIdx( Short ScopeDefId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argGenDefId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByGenDefIdx( short GenDefId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argName	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argGelExecutableTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argProbeTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId );
}
