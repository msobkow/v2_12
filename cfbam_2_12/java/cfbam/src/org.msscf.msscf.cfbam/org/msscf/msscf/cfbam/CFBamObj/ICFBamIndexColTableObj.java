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

public interface ICFBamIndexColTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new IndexCol instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamIndexColObj newInstance();

	/**
	 *	Instantiate a new IndexCol edition of the specified IndexCol instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamIndexColEditObj newEditInstance( ICFBamIndexColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamIndexColObj realiseIndexCol( ICFBamIndexColObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetIndexCol( ICFBamIndexColObj Obj );
	void forgetIndexCol( ICFBamIndexColObj Obj, boolean forgetSubObjects );
	void forgetIndexColByIdIdx( long TenantId,
		long Id );

	void forgetIndexColByUNameIdx( long TenantId,
		long IndexId,
		String Name );

	void forgetIndexColByIdxColTenantIdx( long TenantId );

	void forgetIndexColByIndexIdx( long TenantId,
		long IndexId );

	void forgetIndexColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetIndexColByColIdx( long TenantId,
		long ColumnId );

	void forgetIndexColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetIndexColByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetIndexColByIdxPrevIdx( long TenantId,
		long IndexId,
		Long PrevId );

	void forgetIndexColByIdxNextIdx( long TenantId,
		long IndexId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamIndexColObj createIndexCol( ICFBamIndexColObj Obj );

	/**
	 *	Read a IndexCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The IndexCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamIndexColObj readIndexCol( CFBamIndexColPKey pkey );

	/**
	 *	Read a IndexCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The IndexCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamIndexColObj readIndexCol( CFBamIndexColPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamIndexColObj lockIndexCol( CFBamIndexColPKey pkey );

	/**
	 *	Return a sorted list of all the IndexCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamIndexColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamIndexColObj> readAllIndexCol();

	/**
	 *	Return a sorted map of all the IndexCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamIndexColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamIndexColObj> readAllIndexCol( boolean forceRead );

	/**
	 *	Get the CFBamIndexColObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamIndexColObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamIndexColObj readIndexColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamIndexColObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamIndexColObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamIndexColObj readIndexColByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamIndexColObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argIndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamIndexColObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamIndexColObj readIndexColByUNameIdx(long TenantId,
		long IndexId,
		String Name );

	/**
	 *	Get the CFBamIndexColObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argIndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamIndexColObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamIndexColObj readIndexColByUNameIdx(long TenantId,
		long IndexId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamIndexColObj instances sorted by their primary keys for the duplicate IdxColTenantIdx key.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexColObj cached instances sorted by their primary keys for the duplicate IdxColTenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexColObj> readIndexColByIdxColTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamIndexColObj instances sorted by their primary keys for the duplicate IdxColTenantIdx key.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexColObj cached instances sorted by their primary keys for the duplicate IdxColTenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexColObj> readIndexColByIdxColTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamIndexColObj instances sorted by their primary keys for the duplicate IndexIdx key.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argIndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexColObj cached instances sorted by their primary keys for the duplicate IndexIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexColObj> readIndexColByIndexIdx( long TenantId,
		long IndexId );

	/**
	 *	Get the map of CFBamIndexColObj instances sorted by their primary keys for the duplicate IndexIdx key.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argIndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexColObj cached instances sorted by their primary keys for the duplicate IndexIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexColObj> readIndexColByIndexIdx( long TenantId,
		long IndexId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamIndexColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexColObj> readIndexColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamIndexColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexColObj> readIndexColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamIndexColObj instances sorted by their primary keys for the duplicate ColIdx key.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argColumnId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexColObj cached instances sorted by their primary keys for the duplicate ColIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexColObj> readIndexColByColIdx( long TenantId,
		long ColumnId );

	/**
	 *	Get the map of CFBamIndexColObj instances sorted by their primary keys for the duplicate ColIdx key.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argColumnId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexColObj cached instances sorted by their primary keys for the duplicate ColIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexColObj> readIndexColByColIdx( long TenantId,
		long ColumnId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamIndexColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexColObj> readIndexColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamIndexColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexColObj> readIndexColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamIndexColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexColObj> readIndexColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamIndexColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexColObj> readIndexColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamIndexColObj instances sorted by their primary keys for the duplicate IdxPrevIdx key.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argIndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexColObj cached instances sorted by their primary keys for the duplicate IdxPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexColObj> readIndexColByIdxPrevIdx( long TenantId,
		long IndexId,
		Long PrevId );

	/**
	 *	Get the map of CFBamIndexColObj instances sorted by their primary keys for the duplicate IdxPrevIdx key.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argIndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexColObj cached instances sorted by their primary keys for the duplicate IdxPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexColObj> readIndexColByIdxPrevIdx( long TenantId,
		long IndexId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamIndexColObj instances sorted by their primary keys for the duplicate IdxNextIdx key.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argIndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexColObj cached instances sorted by their primary keys for the duplicate IdxNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexColObj> readIndexColByIdxNextIdx( long TenantId,
		long IndexId,
		Long NextId );

	/**
	 *	Get the map of CFBamIndexColObj instances sorted by their primary keys for the duplicate IdxNextIdx key.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argIndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexColObj cached instances sorted by their primary keys for the duplicate IdxNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexColObj> readIndexColByIdxNextIdx( long TenantId,
		long IndexId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamIndexColObj updateIndexCol( ICFBamIndexColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteIndexCol( ICFBamIndexColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argIndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByUNameIdx(long TenantId,
		long IndexId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByIdxColTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argIndexId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByIndexIdx( long TenantId,
		long IndexId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argColumnId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByColIdx( long TenantId,
		long ColumnId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argIndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByIdxPrevIdx( long TenantId,
		long IndexId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argIndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByIdxNextIdx( long TenantId,
		long IndexId,
		Long NextId );

	/**
	 *	Move the CFBamIndexColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamIndexColObj refreshed cache instance.
	 */
	ICFBamIndexColObj moveUpIndexCol( ICFBamIndexColObj Obj );

	/**
	 *	Move the CFBamIndexColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamIndexColObj refreshed cache instance.
	 */
	ICFBamIndexColObj moveDownIndexCol( ICFBamIndexColObj Obj );
}
