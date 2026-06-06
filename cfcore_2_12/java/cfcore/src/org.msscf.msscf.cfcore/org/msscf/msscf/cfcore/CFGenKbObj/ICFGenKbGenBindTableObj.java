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

public interface ICFGenKbGenBindTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new GenBind instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbGenBindObj newInstance();

	/**
	 *	Instantiate a new GenBind edition of the specified GenBind instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbGenBindEditObj newEditInstance( ICFGenKbGenBindObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGenBindObj realiseGenBind( ICFGenKbGenBindObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetGenBind( ICFGenKbGenBindObj Obj );
	void forgetGenBind( ICFGenKbGenBindObj Obj, boolean forgetSubObjects );
	void forgetGenBindByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId );

	void forgetGenBindByTenantIdx( long TenantId );

	void forgetGenBindByCartIdx( long TenantId,
		long CartridgeId );

	void forgetGenBindByRuleTypeIdx( short RuleTypeId );

	void forgetGenBindByToolSetIdx( short ToolSetId );

	void forgetGenBindByScopeIdx( Short ScopeDefId );

	void forgetGenBindByGenDefIdx( short GenDefId );

	void forgetGenBindByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId );

	void forgetGenBindByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId );

	void forgetGenBindByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId );


	/**
	 *	Internal use only.
	 */
	ICFGenKbGenBindObj createGenBind( ICFGenKbGenBindObj Obj );

	/**
	 *	Read a GenBind-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GenBind-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGenBindObj readGenBind( CFGenKbGenItemPKey pkey );

	/**
	 *	Read a GenBind-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GenBind-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGenBindObj readGenBind( CFGenKbGenItemPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGenBindObj lockGenBind( CFGenKbGenItemPKey pkey );

	/**
	 *	Return a sorted list of all the GenBind-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGenBindObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGenBindObj> readAllGenBind();

	/**
	 *	Return a sorted map of all the GenBind-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGenBindObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGenBindObj> readAllGenBind( boolean forceRead );

	/**
	 *	Get the CFGenKbGenItemObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGenItemObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGenBindObj readGenBindByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId );

	/**
	 *	Get the CFGenKbGenItemObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGenItemObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGenBindObj readGenBindByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenBindObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenBindObj> readGenBindByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFGenKbGenBindObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenBindObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenBindObj> readGenBindByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate CartIdx key.
	 *
	 *	@param	argTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenBindObj cached instances sorted by their primary keys for the duplicate CartIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenBindObj> readGenBindByCartIdx( long TenantId,
		long CartridgeId );

	/**
	 *	Get the map of CFGenKbGenBindObj instances sorted by their primary keys for the duplicate CartIdx key.
	 *
	 *	@param	argTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenBindObj cached instances sorted by their primary keys for the duplicate CartIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenBindObj> readGenBindByCartIdx( long TenantId,
		long CartridgeId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate RuleTypeIdx key.
	 *
	 *	@param	argRuleTypeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenBindObj cached instances sorted by their primary keys for the duplicate RuleTypeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenBindObj> readGenBindByRuleTypeIdx( short RuleTypeId );

	/**
	 *	Get the map of CFGenKbGenBindObj instances sorted by their primary keys for the duplicate RuleTypeIdx key.
	 *
	 *	@param	argRuleTypeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenBindObj cached instances sorted by their primary keys for the duplicate RuleTypeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenBindObj> readGenBindByRuleTypeIdx( short RuleTypeId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate ToolSetIdx key.
	 *
	 *	@param	argToolSetId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenBindObj cached instances sorted by their primary keys for the duplicate ToolSetIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenBindObj> readGenBindByToolSetIdx( short ToolSetId );

	/**
	 *	Get the map of CFGenKbGenBindObj instances sorted by their primary keys for the duplicate ToolSetIdx key.
	 *
	 *	@param	argToolSetId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenBindObj cached instances sorted by their primary keys for the duplicate ToolSetIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenBindObj> readGenBindByToolSetIdx( short ToolSetId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argScopeDefId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenBindObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenBindObj> readGenBindByScopeIdx( Short ScopeDefId );

	/**
	 *	Get the map of CFGenKbGenBindObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argScopeDefId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenBindObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenBindObj> readGenBindByScopeIdx( Short ScopeDefId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate GenDefIdx key.
	 *
	 *	@param	argGenDefId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenBindObj cached instances sorted by their primary keys for the duplicate GenDefIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenBindObj> readGenBindByGenDefIdx( short GenDefId );

	/**
	 *	Get the map of CFGenKbGenBindObj instances sorted by their primary keys for the duplicate GenDefIdx key.
	 *
	 *	@param	argGenDefId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenBindObj cached instances sorted by their primary keys for the duplicate GenDefIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenBindObj> readGenBindByGenDefIdx( short GenDefId,
		boolean forceRead );

	/**
	 *	Get the CFGenKbGenItemObj instance for the unique AltIdx key.
	 *
	 *	@param	argName	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGenItemObj cached instance for the unique AltIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGenBindObj readGenBindByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId );

	/**
	 *	Get the CFGenKbGenItemObj instance for the unique AltIdx key.
	 *
	 *	@param	argName	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGenItemObj refreshed instance for the unique AltIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGenBindObj readGenBindByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate GelExecIdx key.
	 *
	 *	@param	argGelExecutableTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenBindObj cached instances sorted by their primary keys for the duplicate GelExecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenBindObj> readGenBindByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId );

	/**
	 *	Get the map of CFGenKbGenBindObj instances sorted by their primary keys for the duplicate GelExecIdx key.
	 *
	 *	@param	argGelExecutableTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenBindObj cached instances sorted by their primary keys for the duplicate GelExecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenBindObj> readGenBindByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate ProbeIdx key.
	 *
	 *	@param	argProbeTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenBindObj cached instances sorted by their primary keys for the duplicate ProbeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenBindObj> readGenBindByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId );

	/**
	 *	Get the map of CFGenKbGenBindObj instances sorted by their primary keys for the duplicate ProbeIdx key.
	 *
	 *	@param	argProbeTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenBindObj cached instances sorted by their primary keys for the duplicate ProbeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenBindObj> readGenBindByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGenBindObj updateGenBind( ICFGenKbGenBindObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteGenBind( ICFGenKbGenBindObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByCartIdx( long TenantId,
		long CartridgeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argRuleTypeId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByRuleTypeIdx( short RuleTypeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argToolSetId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByToolSetIdx( short ToolSetId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argScopeDefId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByScopeIdx( Short ScopeDefId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argGenDefId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByGenDefIdx( short GenDefId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argName	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argGelExecutableTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argProbeTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId );
}
