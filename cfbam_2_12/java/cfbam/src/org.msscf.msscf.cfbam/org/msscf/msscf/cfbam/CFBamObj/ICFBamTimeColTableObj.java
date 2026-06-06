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

public interface ICFBamTimeColTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TimeCol instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTimeColObj newInstance();

	/**
	 *	Instantiate a new TimeCol edition of the specified TimeCol instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTimeColEditObj newEditInstance( ICFBamTimeColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTimeColObj realiseTimeCol( ICFBamTimeColObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTimeCol( ICFBamTimeColObj Obj );
	void forgetTimeCol( ICFBamTimeColObj Obj, boolean forgetSubObjects );
	void forgetTimeColByIdIdx( long TenantId,
		long Id );

	void forgetTimeColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetTimeColByValTentIdx( long TenantId );

	void forgetTimeColByScopeIdx( long TenantId,
		long ScopeId );

	void forgetTimeColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTimeColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetTimeColByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetTimeColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetTimeColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetTimeColByTableIdx( long TenantId,
		long TableId );


	/**
	 *	Internal use only.
	 */
	ICFBamTimeColObj createTimeCol( ICFBamTimeColObj Obj );

	/**
	 *	Read a TimeCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TimeCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTimeColObj readTimeCol( CFBamValuePKey pkey );

	/**
	 *	Read a TimeCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TimeCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTimeColObj readTimeCol( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTimeColObj lockTimeCol( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the TimeCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamTimeColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTimeColObj> readAllTimeCol();

	/**
	 *	Return a sorted map of all the TimeCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamTimeColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTimeColObj> readAllTimeCol( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTimeColObj readTimeColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTimeColObj readTimeColByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTimeColObj readTimeColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTimeColObj readTimeColByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeColObj> readTimeColByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamTimeColObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeColObj> readTimeColByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeColObj> readTimeColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamTimeColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeColObj> readTimeColByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeColObj> readTimeColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamTimeColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeColObj> readTimeColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeColObj> readTimeColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTimeColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeColObj> readTimeColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeColObj> readTimeColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamTimeColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeColObj> readTimeColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeColObj> readTimeColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTimeColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeColObj> readTimeColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeColObj> readTimeColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamTimeColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeColObj> readTimeColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTimeColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeColObj> readTimeColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamTimeColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeColObj> readTimeColByTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTimeColObj updateTimeCol( ICFBamTimeColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTimeCol( ICFBamTimeColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TimeCol key attribute of the instance generating the id.
	 */
	void deleteTimeColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TimeCol key attribute of the instance generating the id.
	 */
	void deleteTimeColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 */
	void deleteTimeColByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeCol key attribute of the instance generating the id.
	 */
	void deleteTimeColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TimeCol key attribute of the instance generating the id.
	 */
	void deleteTimeColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimeCol key attribute of the instance generating the id.
	 */
	void deleteTimeColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimeCol key attribute of the instance generating the id.
	 */
	void deleteTimeColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimeCol key attribute of the instance generating the id.
	 */
	void deleteTimeColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimeCol key attribute of the instance generating the id.
	 */
	void deleteTimeColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The TimeCol key attribute of the instance generating the id.
	 */
	void deleteTimeColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Move the CFBamTimeColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTimeColObj refreshed cache instance.
	 */
	ICFBamTimeColObj moveUpTimeCol( ICFBamTimeColObj Obj );

	/**
	 *	Move the CFBamTimeColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTimeColObj refreshed cache instance.
	 */
	ICFBamTimeColObj moveDownTimeCol( ICFBamTimeColObj Obj );
}
