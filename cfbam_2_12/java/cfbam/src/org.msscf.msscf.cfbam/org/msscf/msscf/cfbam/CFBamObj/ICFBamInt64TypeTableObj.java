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

public interface ICFBamInt64TypeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new Int64Type instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamInt64TypeObj newInstance();

	/**
	 *	Instantiate a new Int64Type edition of the specified Int64Type instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamInt64TypeEditObj newEditInstance( ICFBamInt64TypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamInt64TypeObj realiseInt64Type( ICFBamInt64TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetInt64Type( ICFBamInt64TypeObj Obj );
	void forgetInt64Type( ICFBamInt64TypeObj Obj, boolean forgetSubObjects );
	void forgetInt64TypeByIdIdx( long TenantId,
		long Id );

	void forgetInt64TypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetInt64TypeByValTentIdx( long TenantId );

	void forgetInt64TypeByScopeIdx( long TenantId,
		long ScopeId );

	void forgetInt64TypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetInt64TypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetInt64TypeByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetInt64TypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetInt64TypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetInt64TypeBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamInt64TypeObj createInt64Type( ICFBamInt64TypeObj Obj );

	/**
	 *	Read a Int64Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int64Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamInt64TypeObj readInt64Type( CFBamValuePKey pkey );

	/**
	 *	Read a Int64Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int64Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamInt64TypeObj readInt64Type( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamInt64TypeObj lockInt64Type( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the Int64Type-derived instances in the database.
	 *
	 *	@return	List of ICFBamInt64TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamInt64TypeObj> readAllInt64Type();

	/**
	 *	Return a sorted map of all the Int64Type-derived instances in the database.
	 *
	 *	@return	List of ICFBamInt64TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamInt64TypeObj> readAllInt64Type( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt64TypeObj readInt64TypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt64TypeObj readInt64TypeByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt64TypeObj readInt64TypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt64TypeObj readInt64TypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64TypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64TypeObj> readInt64TypeByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamInt64TypeObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64TypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64TypeObj> readInt64TypeByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64TypeObj> readInt64TypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamInt64TypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64TypeObj> readInt64TypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64TypeObj> readInt64TypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamInt64TypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64TypeObj> readInt64TypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64TypeObj> readInt64TypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamInt64TypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64TypeObj> readInt64TypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64TypeObj> readInt64TypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamInt64TypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64TypeObj> readInt64TypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64TypeObj> readInt64TypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamInt64TypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64TypeObj> readInt64TypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64TypeObj> readInt64TypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamInt64TypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64TypeObj> readInt64TypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamInt64TypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64TypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64TypeObj> readInt64TypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamInt64TypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64TypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64TypeObj> readInt64TypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamInt64TypeObj updateInt64Type( ICFBamInt64TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteInt64Type( ICFBamInt64TypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Int64Type key attribute of the instance generating the id.
	 */
	void deleteInt64TypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Int64Type key attribute of the instance generating the id.
	 */
	void deleteInt64TypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 */
	void deleteInt64TypeByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Type key attribute of the instance generating the id.
	 */
	void deleteInt64TypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Int64Type key attribute of the instance generating the id.
	 */
	void deleteInt64TypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int64Type key attribute of the instance generating the id.
	 */
	void deleteInt64TypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int64Type key attribute of the instance generating the id.
	 */
	void deleteInt64TypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int64Type key attribute of the instance generating the id.
	 */
	void deleteInt64TypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int64Type key attribute of the instance generating the id.
	 */
	void deleteInt64TypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Type key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Int64Type key attribute of the instance generating the id.
	 */
	void deleteInt64TypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamInt64TypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamInt64TypeObj refreshed cache instance.
	 */
	ICFBamInt64TypeObj moveUpInt64Type( ICFBamInt64TypeObj Obj );

	/**
	 *	Move the CFBamInt64TypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamInt64TypeObj refreshed cache instance.
	 */
	ICFBamInt64TypeObj moveDownInt64Type( ICFBamInt64TypeObj Obj );
}
