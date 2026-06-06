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

public interface ICFBamInt16ColTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new Int16Col instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamInt16ColObj newInstance();

	/**
	 *	Instantiate a new Int16Col edition of the specified Int16Col instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamInt16ColEditObj newEditInstance( ICFBamInt16ColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamInt16ColObj realiseInt16Col( ICFBamInt16ColObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetInt16Col( ICFBamInt16ColObj Obj );
	void forgetInt16Col( ICFBamInt16ColObj Obj, boolean forgetSubObjects );
	void forgetInt16ColByIdIdx( long TenantId,
		long Id );

	void forgetInt16ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetInt16ColByValTentIdx( long TenantId );

	void forgetInt16ColByScopeIdx( long TenantId,
		long ScopeId );

	void forgetInt16ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetInt16ColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetInt16ColByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetInt16ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetInt16ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetInt16ColByTableIdx( long TenantId,
		long TableId );


	/**
	 *	Internal use only.
	 */
	ICFBamInt16ColObj createInt16Col( ICFBamInt16ColObj Obj );

	/**
	 *	Read a Int16Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int16Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamInt16ColObj readInt16Col( CFBamValuePKey pkey );

	/**
	 *	Read a Int16Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int16Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamInt16ColObj readInt16Col( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamInt16ColObj lockInt16Col( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the Int16Col-derived instances in the database.
	 *
	 *	@return	List of ICFBamInt16ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamInt16ColObj> readAllInt16Col();

	/**
	 *	Return a sorted map of all the Int16Col-derived instances in the database.
	 *
	 *	@return	List of ICFBamInt16ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamInt16ColObj> readAllInt16Col( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt16ColObj readInt16ColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt16ColObj readInt16ColByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt16ColObj readInt16ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt16ColObj readInt16ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16ColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16ColObj> readInt16ColByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamInt16ColObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16ColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16ColObj> readInt16ColByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16ColObj> readInt16ColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamInt16ColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16ColObj> readInt16ColByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16ColObj> readInt16ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamInt16ColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16ColObj> readInt16ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16ColObj> readInt16ColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamInt16ColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16ColObj> readInt16ColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16ColObj> readInt16ColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamInt16ColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16ColObj> readInt16ColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16ColObj> readInt16ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamInt16ColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16ColObj> readInt16ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16ColObj> readInt16ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamInt16ColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16ColObj> readInt16ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamInt16ColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16ColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16ColObj> readInt16ColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamInt16ColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16ColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16ColObj> readInt16ColByTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamInt16ColObj updateInt16Col( ICFBamInt16ColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteInt16Col( ICFBamInt16ColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Move the CFBamInt16ColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamInt16ColObj refreshed cache instance.
	 */
	ICFBamInt16ColObj moveUpInt16Col( ICFBamInt16ColObj Obj );

	/**
	 *	Move the CFBamInt16ColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamInt16ColObj refreshed cache instance.
	 */
	ICFBamInt16ColObj moveDownInt16Col( ICFBamInt16ColObj Obj );
}
