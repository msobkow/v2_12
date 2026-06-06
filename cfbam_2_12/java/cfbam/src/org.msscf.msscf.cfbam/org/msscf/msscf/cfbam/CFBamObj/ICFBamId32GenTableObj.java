// Description: Java 11 Table Object interface for CFBam.

/*
 *	org.msscf.msscf.CFBam
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

public interface ICFBamId32GenTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new Id32Gen instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamId32GenObj newInstance();

	/**
	 *	Instantiate a new Id32Gen edition of the specified Id32Gen instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamId32GenEditObj newEditInstance( ICFBamId32GenObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamId32GenObj realiseId32Gen( ICFBamId32GenObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetId32Gen( ICFBamId32GenObj Obj );
	void forgetId32Gen( ICFBamId32GenObj Obj, boolean forgetSubObjects );
	void forgetId32GenByIdIdx( long TenantId,
		long Id );

	void forgetId32GenByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetId32GenByValTentIdx( long TenantId );

	void forgetId32GenByScopeIdx( long TenantId,
		long ScopeId );

	void forgetId32GenByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetId32GenByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetId32GenByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetId32GenByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetId32GenByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetId32GenBySchemaIdx( long TenantId,
		long SchemaDefId );

	void forgetId32GenByDispIdx( Long DispenserTenantId,
		Long DispenserId );


	/**
	 *	Internal use only.
	 */
	ICFBamId32GenObj createId32Gen( ICFBamId32GenObj Obj );

	/**
	 *	Read a Id32Gen-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Id32Gen-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamId32GenObj readId32Gen( CFBamValuePKey pkey );

	/**
	 *	Read a Id32Gen-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Id32Gen-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamId32GenObj readId32Gen( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamId32GenObj lockId32Gen( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the Id32Gen-derived instances in the database.
	 *
	 *	@return	List of ICFBamId32GenObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamId32GenObj> readAllId32Gen();

	/**
	 *	Return a sorted map of all the Id32Gen-derived instances in the database.
	 *
	 *	@return	List of ICFBamId32GenObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamId32GenObj> readAllId32Gen( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamId32GenObj readId32GenByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamId32GenObj readId32GenByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamId32GenObj readId32GenByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamId32GenObj readId32GenByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId32GenObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId32GenObj> readId32GenByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamId32GenObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId32GenObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId32GenObj> readId32GenByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId32GenObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId32GenObj> readId32GenByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamId32GenObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId32GenObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId32GenObj> readId32GenByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId32GenObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId32GenObj> readId32GenByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamId32GenObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId32GenObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId32GenObj> readId32GenByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId32GenObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId32GenObj> readId32GenByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamId32GenObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId32GenObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId32GenObj> readId32GenByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId32GenObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId32GenObj> readId32GenByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamId32GenObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId32GenObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId32GenObj> readId32GenByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId32GenObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId32GenObj> readId32GenByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamId32GenObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId32GenObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId32GenObj> readId32GenByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId32GenObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId32GenObj> readId32GenByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamId32GenObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId32GenObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId32GenObj> readId32GenByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamInt32TypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId32GenObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId32GenObj> readId32GenBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamId32GenObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId32GenObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId32GenObj> readId32GenBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamId32GenObj instances sorted by their primary keys for the duplicate DispIdx key.
	 *
	 *	@param	argDispenserTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argDispenserId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId32GenObj cached instances sorted by their primary keys for the duplicate DispIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId32GenObj> readId32GenByDispIdx( Long DispenserTenantId,
		Long DispenserId );

	/**
	 *	Get the map of CFBamId32GenObj instances sorted by their primary keys for the duplicate DispIdx key.
	 *
	 *	@param	argDispenserTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argDispenserId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamId32GenObj cached instances sorted by their primary keys for the duplicate DispIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamId32GenObj> readId32GenByDispIdx( Long DispenserTenantId,
		Long DispenserId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamId32GenObj updateId32Gen( ICFBamId32GenObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteId32Gen( ICFBamId32GenObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Id32Gen key attribute of the instance generating the id.
	 */
	void deleteId32GenByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Id32Gen key attribute of the instance generating the id.
	 */
	void deleteId32GenByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 */
	void deleteId32GenByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id32Gen key attribute of the instance generating the id.
	 */
	void deleteId32GenByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Id32Gen key attribute of the instance generating the id.
	 */
	void deleteId32GenByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Id32Gen key attribute of the instance generating the id.
	 */
	void deleteId32GenByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Id32Gen key attribute of the instance generating the id.
	 */
	void deleteId32GenByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Id32Gen key attribute of the instance generating the id.
	 */
	void deleteId32GenByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Id32Gen key attribute of the instance generating the id.
	 */
	void deleteId32GenByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Id32Gen key attribute of the instance generating the id.
	 */
	void deleteId32GenBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDispenserTenantId	The Id32Gen key attribute of the instance generating the id.
	 *
	 *	@param	argDispenserId	The Id32Gen key attribute of the instance generating the id.
	 */
	void deleteId32GenByDispIdx( Long DispenserTenantId,
		Long DispenserId );

	/**
	 *	Move the CFBamId32GenObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamId32GenObj refreshed cache instance.
	 */
	ICFBamId32GenObj moveUpId32Gen( ICFBamId32GenObj Obj );

	/**
	 *	Move the CFBamId32GenObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamId32GenObj refreshed cache instance.
	 */
	ICFBamId32GenObj moveDownId32Gen( ICFBamId32GenObj Obj );
}
