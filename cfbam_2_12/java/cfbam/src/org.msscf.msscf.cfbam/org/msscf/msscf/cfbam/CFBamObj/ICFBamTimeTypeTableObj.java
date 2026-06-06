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

public interface ICFBamTimeTypeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TimeType instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTimeTypeObj newInstance();

	/**
	 *	Instantiate a new TimeType edition of the specified TimeType instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTimeTypeEditObj newEditInstance( ICFBamTimeTypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTimeTypeObj realiseTimeType( ICFBamTimeTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTimeType( ICFBamTimeTypeObj Obj );
	void forgetTimeType( ICFBamTimeTypeObj Obj, boolean forgetSubObjects );
	void forgetTimeTypeByIdIdx( long TenantId,
		long Id );

	void forgetTimeTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetTimeTypeByValTentIdx( long TenantId );

	void forgetTimeTypeByScopeIdx( long TenantId,
		long ScopeId );

	void forgetTimeTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTimeTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetTimeTypeByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetTimeTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetTimeTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetTimeTypeBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamTimeTypeObj createTimeType( ICFBamTimeTypeObj Obj );

	/**
	 *	Read a TimeType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TimeType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTimeTypeObj readTimeType( CFBamValuePKey pkey );

	/**
	 *	Read a TimeType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TimeType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTimeTypeObj readTimeType( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTimeTypeObj lockTimeType( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the TimeType-derived instances in the database.
	 *
	 *	@return	List of ICFBamTimeTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTimeTypeObj> readAllTimeType();

	/**
	 *	Return a sorted map of all the TimeType-derived instances in the database.
	 *
	 *	@return	List of ICFBamTimeTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTimeTypeObj> readAllTimeType( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTimeTypeObj readTimeTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTimeTypeObj readTimeTypeByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTimeTypeObj readTimeTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTimeTypeObj readTimeTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeTypeObj> readTimeTypeByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamTimeTypeObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeTypeObj> readTimeTypeByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeTypeObj> readTimeTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamTimeTypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeTypeObj> readTimeTypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeTypeObj> readTimeTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamTimeTypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeTypeObj> readTimeTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeTypeObj> readTimeTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTimeTypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeTypeObj> readTimeTypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeTypeObj> readTimeTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamTimeTypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeTypeObj> readTimeTypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeTypeObj> readTimeTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTimeTypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeTypeObj> readTimeTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeTypeObj> readTimeTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamTimeTypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeTypeObj> readTimeTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTimeTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeTypeObj> readTimeTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamTimeTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeTypeObj> readTimeTypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTimeTypeObj updateTimeType( ICFBamTimeTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTimeType( ICFBamTimeTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TimeType key attribute of the instance generating the id.
	 */
	void deleteTimeTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TimeType key attribute of the instance generating the id.
	 */
	void deleteTimeTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 */
	void deleteTimeTypeByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeType key attribute of the instance generating the id.
	 */
	void deleteTimeTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TimeType key attribute of the instance generating the id.
	 */
	void deleteTimeTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimeType key attribute of the instance generating the id.
	 */
	void deleteTimeTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimeType key attribute of the instance generating the id.
	 */
	void deleteTimeTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimeType key attribute of the instance generating the id.
	 */
	void deleteTimeTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimeType key attribute of the instance generating the id.
	 */
	void deleteTimeTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The TimeType key attribute of the instance generating the id.
	 */
	void deleteTimeTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamTimeTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTimeTypeObj refreshed cache instance.
	 */
	ICFBamTimeTypeObj moveUpTimeType( ICFBamTimeTypeObj Obj );

	/**
	 *	Move the CFBamTimeTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTimeTypeObj refreshed cache instance.
	 */
	ICFBamTimeTypeObj moveDownTimeType( ICFBamTimeTypeObj Obj );
}
