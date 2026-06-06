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

public interface ICFBamInt64DefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new Int64Def instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamInt64DefObj newInstance();

	/**
	 *	Instantiate a new Int64Def edition of the specified Int64Def instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamInt64DefEditObj newEditInstance( ICFBamInt64DefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamInt64DefObj realiseInt64Def( ICFBamInt64DefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetInt64Def( ICFBamInt64DefObj Obj );
	void forgetInt64Def( ICFBamInt64DefObj Obj, boolean forgetSubObjects );
	void forgetInt64DefByIdIdx( long TenantId,
		long Id );

	void forgetInt64DefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetInt64DefByValTentIdx( long TenantId );

	void forgetInt64DefByScopeIdx( long TenantId,
		long ScopeId );

	void forgetInt64DefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetInt64DefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetInt64DefByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetInt64DefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetInt64DefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamInt64DefObj createInt64Def( ICFBamInt64DefObj Obj );

	/**
	 *	Read a Int64Def-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int64Def-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamInt64DefObj readInt64Def( CFBamValuePKey pkey );

	/**
	 *	Read a Int64Def-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int64Def-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamInt64DefObj readInt64Def( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamInt64DefObj lockInt64Def( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the Int64Def-derived instances in the database.
	 *
	 *	@return	List of ICFBamInt64DefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamInt64DefObj> readAllInt64Def();

	/**
	 *	Return a sorted map of all the Int64Def-derived instances in the database.
	 *
	 *	@return	List of ICFBamInt64DefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamInt64DefObj> readAllInt64Def( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt64DefObj readInt64DefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt64DefObj readInt64DefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt64DefObj readInt64DefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt64DefObj readInt64DefByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64DefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64DefObj> readInt64DefByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamInt64DefObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64DefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64DefObj> readInt64DefByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64DefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64DefObj> readInt64DefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamInt64DefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64DefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64DefObj> readInt64DefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64DefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64DefObj> readInt64DefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamInt64DefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64DefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64DefObj> readInt64DefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64DefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64DefObj> readInt64DefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamInt64DefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64DefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64DefObj> readInt64DefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64DefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64DefObj> readInt64DefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamInt64DefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64DefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64DefObj> readInt64DefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64DefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64DefObj> readInt64DefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamInt64DefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64DefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64DefObj> readInt64DefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64DefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64DefObj> readInt64DefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamInt64DefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64DefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64DefObj> readInt64DefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamInt64DefObj updateInt64Def( ICFBamInt64DefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteInt64Def( ICFBamInt64DefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Int64Def key attribute of the instance generating the id.
	 */
	void deleteInt64DefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Int64Def key attribute of the instance generating the id.
	 */
	void deleteInt64DefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Def key attribute of the instance generating the id.
	 */
	void deleteInt64DefByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Def key attribute of the instance generating the id.
	 */
	void deleteInt64DefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Int64Def key attribute of the instance generating the id.
	 */
	void deleteInt64DefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int64Def key attribute of the instance generating the id.
	 */
	void deleteInt64DefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int64Def key attribute of the instance generating the id.
	 */
	void deleteInt64DefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int64Def key attribute of the instance generating the id.
	 */
	void deleteInt64DefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int64Def key attribute of the instance generating the id.
	 */
	void deleteInt64DefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the CFBamInt64DefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamInt64DefObj refreshed cache instance.
	 */
	ICFBamInt64DefObj moveUpInt64Def( ICFBamInt64DefObj Obj );

	/**
	 *	Move the CFBamInt64DefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamInt64DefObj refreshed cache instance.
	 */
	ICFBamInt64DefObj moveDownInt64Def( ICFBamInt64DefObj Obj );
}
