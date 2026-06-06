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

public interface ICFBamTimestampColTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TimestampCol instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTimestampColObj newInstance();

	/**
	 *	Instantiate a new TimestampCol edition of the specified TimestampCol instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTimestampColEditObj newEditInstance( ICFBamTimestampColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTimestampColObj realiseTimestampCol( ICFBamTimestampColObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTimestampCol( ICFBamTimestampColObj Obj );
	void forgetTimestampCol( ICFBamTimestampColObj Obj, boolean forgetSubObjects );
	void forgetTimestampColByIdIdx( long TenantId,
		long Id );

	void forgetTimestampColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetTimestampColByValTentIdx( long TenantId );

	void forgetTimestampColByScopeIdx( long TenantId,
		long ScopeId );

	void forgetTimestampColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTimestampColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetTimestampColByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetTimestampColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetTimestampColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetTimestampColByTableIdx( long TenantId,
		long TableId );


	/**
	 *	Internal use only.
	 */
	ICFBamTimestampColObj createTimestampCol( ICFBamTimestampColObj Obj );

	/**
	 *	Read a TimestampCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TimestampCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTimestampColObj readTimestampCol( CFBamValuePKey pkey );

	/**
	 *	Read a TimestampCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TimestampCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTimestampColObj readTimestampCol( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTimestampColObj lockTimestampCol( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the TimestampCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamTimestampColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTimestampColObj> readAllTimestampCol();

	/**
	 *	Return a sorted map of all the TimestampCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamTimestampColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTimestampColObj> readAllTimestampCol( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTimestampColObj readTimestampColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTimestampColObj readTimestampColByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTimestampColObj readTimestampColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTimestampColObj readTimestampColByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimestampColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimestampColObj> readTimestampColByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamTimestampColObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimestampColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimestampColObj> readTimestampColByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimestampColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimestampColObj> readTimestampColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamTimestampColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimestampColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimestampColObj> readTimestampColByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimestampColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimestampColObj> readTimestampColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamTimestampColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimestampColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimestampColObj> readTimestampColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimestampColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimestampColObj> readTimestampColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTimestampColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimestampColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimestampColObj> readTimestampColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimestampColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimestampColObj> readTimestampColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamTimestampColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimestampColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimestampColObj> readTimestampColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimestampColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimestampColObj> readTimestampColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTimestampColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimestampColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimestampColObj> readTimestampColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimestampColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimestampColObj> readTimestampColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamTimestampColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimestampColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimestampColObj> readTimestampColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTimestampColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimestampColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimestampColObj> readTimestampColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamTimestampColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimestampColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimestampColObj> readTimestampColByTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTimestampColObj updateTimestampCol( ICFBamTimestampColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTimestampCol( ICFBamTimestampColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TimestampCol key attribute of the instance generating the id.
	 */
	void deleteTimestampColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TimestampCol key attribute of the instance generating the id.
	 */
	void deleteTimestampColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 */
	void deleteTimestampColByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimestampCol key attribute of the instance generating the id.
	 */
	void deleteTimestampColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TimestampCol key attribute of the instance generating the id.
	 */
	void deleteTimestampColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimestampCol key attribute of the instance generating the id.
	 */
	void deleteTimestampColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimestampCol key attribute of the instance generating the id.
	 */
	void deleteTimestampColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimestampCol key attribute of the instance generating the id.
	 */
	void deleteTimestampColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimestampCol key attribute of the instance generating the id.
	 */
	void deleteTimestampColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimestampCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The TimestampCol key attribute of the instance generating the id.
	 */
	void deleteTimestampColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Move the CFBamTimestampColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTimestampColObj refreshed cache instance.
	 */
	ICFBamTimestampColObj moveUpTimestampCol( ICFBamTimestampColObj Obj );

	/**
	 *	Move the CFBamTimestampColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTimestampColObj refreshed cache instance.
	 */
	ICFBamTimestampColObj moveDownTimestampCol( ICFBamTimestampColObj Obj );
}
