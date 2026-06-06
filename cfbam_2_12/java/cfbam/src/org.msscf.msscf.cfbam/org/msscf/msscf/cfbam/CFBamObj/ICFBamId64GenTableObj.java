// Description: Java 11 Table Object interface for CFBam.

/*
 *	org.msscf.msscf.CFBam
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

package org.msscf.msscf.cfbam.CFBamObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBam.*;

public interface ICFBamId64GenTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new Id64Gen instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamId64GenObj newInstance();

	/**
	 *	Instantiate a new Id64Gen edition of the specified Id64Gen instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamId64GenEditObj newEditInstance( ICFBamId64GenObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamId64GenObj realiseId64Gen( ICFBamId64GenObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetId64Gen( ICFBamId64GenObj Obj );
	void forgetId64Gen( ICFBamId64GenObj Obj, boolean forgetSubObjects );
	void forgetId64GenByIdIdx( long TenantId,
		long Id );

	void forgetId64GenByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetId64GenByValTentIdx( long TenantId );

	void forgetId64GenByScopeIdx( long TenantId,
		long ScopeId );

	void forgetId64GenByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetId64GenByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetId64GenByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetId64GenByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetId64GenByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetId64GenBySchemaIdx( long TenantId,
		long SchemaDefId );

	void forgetId64GenByDispIdx( Long DispenserTenantId,
		Long DispenserId );


	/**
	 *	Internal use only.
	 */
	ICFBamId64GenObj createId64Gen( ICFBamId64GenObj Obj );

	/**
	 *	Read a Id64Gen-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Id64Gen-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamId64GenObj readId64Gen( CFBamValuePKey pkey );

	/**
	 *	Read a Id64Gen-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Id64Gen-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamId64GenObj readId64Gen( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamId64GenObj lockId64Gen( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the Id64Gen-derived instances in the database.
	 *
	 *	@return	List of ICFBamId64GenObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamId64GenObj> readAllId64Gen();

	/**
	 *	Return a sorted map of all the Id64Gen-derived instances in the database.
	 *
	 *	@return	List of ICFBamId64GenObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamId64GenObj> readAllId64Gen( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamId64GenObj readId64GenByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamId64GenObj readId64GenByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamId64GenObj readId64GenByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamId64GenObj readId64GenByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId64GenObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId64GenObj> readId64GenByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamId64GenObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId64GenObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId64GenObj> readId64GenByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId64GenObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId64GenObj> readId64GenByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamId64GenObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId64GenObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId64GenObj> readId64GenByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId64GenObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId64GenObj> readId64GenByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamId64GenObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId64GenObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId64GenObj> readId64GenByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId64GenObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId64GenObj> readId64GenByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamId64GenObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId64GenObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId64GenObj> readId64GenByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId64GenObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId64GenObj> readId64GenByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamId64GenObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId64GenObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId64GenObj> readId64GenByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId64GenObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId64GenObj> readId64GenByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamId64GenObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId64GenObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId64GenObj> readId64GenByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId64GenObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId64GenObj> readId64GenByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamId64GenObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId64GenObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId64GenObj> readId64GenByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamInt64TypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId64GenObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId64GenObj> readId64GenBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamId64GenObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId64GenObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId64GenObj> readId64GenBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamId64GenObj instances sorted by their primary keys for the duplicate DispIdx key.
	 *
	 *	@param	argDispenserTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argDispenserId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId64GenObj cached instances sorted by their primary keys for the duplicate DispIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId64GenObj> readId64GenByDispIdx( Long DispenserTenantId,
		Long DispenserId );

	/**
	 *	Get the map of CFBamId64GenObj instances sorted by their primary keys for the duplicate DispIdx key.
	 *
	 *	@param	argDispenserTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argDispenserId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId64GenObj cached instances sorted by their primary keys for the duplicate DispIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId64GenObj> readId64GenByDispIdx( Long DispenserTenantId,
		Long DispenserId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamId64GenObj updateId64Gen( ICFBamId64GenObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteId64Gen( ICFBamId64GenObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Id64Gen key attribute of the instance generating the id.
	 */
	void deleteId64GenByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Id64Gen key attribute of the instance generating the id.
	 */
	void deleteId64GenByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 */
	void deleteId64GenByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id64Gen key attribute of the instance generating the id.
	 */
	void deleteId64GenByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Id64Gen key attribute of the instance generating the id.
	 */
	void deleteId64GenByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Id64Gen key attribute of the instance generating the id.
	 */
	void deleteId64GenByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Id64Gen key attribute of the instance generating the id.
	 */
	void deleteId64GenByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Id64Gen key attribute of the instance generating the id.
	 */
	void deleteId64GenByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Id64Gen key attribute of the instance generating the id.
	 */
	void deleteId64GenByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Id64Gen key attribute of the instance generating the id.
	 */
	void deleteId64GenBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDispenserTenantId	The Id64Gen key attribute of the instance generating the id.
	 *
	 *	@param	argDispenserId	The Id64Gen key attribute of the instance generating the id.
	 */
	void deleteId64GenByDispIdx( Long DispenserTenantId,
		Long DispenserId );

	/**
	 *	Move the CFBamId64GenObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamId64GenObj refreshed cache instance.
	 */
	ICFBamId64GenObj moveUpId64Gen( ICFBamId64GenObj Obj );

	/**
	 *	Move the CFBamId64GenObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamId64GenObj refreshed cache instance.
	 */
	ICFBamId64GenObj moveDownId64Gen( ICFBamId64GenObj Obj );
}
