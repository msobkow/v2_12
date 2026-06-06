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

public interface ICFBamClearTopDepTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new ClearTopDep instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamClearTopDepObj newInstance();

	/**
	 *	Instantiate a new ClearTopDep edition of the specified ClearTopDep instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamClearTopDepEditObj newEditInstance( ICFBamClearTopDepObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamClearTopDepObj realiseClearTopDep( ICFBamClearTopDepObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetClearTopDep( ICFBamClearTopDepObj Obj );
	void forgetClearTopDep( ICFBamClearTopDepObj Obj, boolean forgetSubObjects );
	void forgetClearTopDepByIdIdx( long TenantId,
		long Id );

	void forgetClearTopDepByTenantIdx( long TenantId );

	void forgetClearTopDepByClearDepIdx( long TenantId,
		long RelationId );

	void forgetClearTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetClearTopDepByClrTopDepTblIdx( long TableTenantId,
		long TableId );

	void forgetClearTopDepByUNameIdx( long TableTenantId,
		long TableId,
		String Name );

	void forgetClearTopDepByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetClearTopDepByNextIdx( Long NextTenantId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamClearTopDepObj createClearTopDep( ICFBamClearTopDepObj Obj );

	/**
	 *	Read a ClearTopDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ClearTopDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamClearTopDepObj readClearTopDep( CFBamScopePKey pkey );

	/**
	 *	Read a ClearTopDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ClearTopDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamClearTopDepObj readClearTopDep( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamClearTopDepObj lockClearTopDep( CFBamScopePKey pkey );

	/**
	 *	Return a sorted list of all the ClearTopDep-derived instances in the database.
	 *
	 *	@return	List of ICFBamClearTopDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamClearTopDepObj> readAllClearTopDep();

	/**
	 *	Return a sorted map of all the ClearTopDep-derived instances in the database.
	 *
	 *	@return	List of ICFBamClearTopDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamClearTopDepObj> readAllClearTopDep( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamClearTopDepObj readClearTopDepByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamClearTopDepObj readClearTopDepByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearTopDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearTopDepObj> readClearTopDepByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamClearTopDepObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearTopDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearTopDepObj> readClearTopDepByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamClearDepObj instances sorted by their primary keys for the duplicate ClearDepIdx key.
	 *
	 *	@param	argTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearTopDepObj cached instances sorted by their primary keys for the duplicate ClearDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearTopDepObj> readClearTopDepByClearDepIdx( long TenantId,
		long RelationId );

	/**
	 *	Get the map of CFBamClearTopDepObj instances sorted by their primary keys for the duplicate ClearDepIdx key.
	 *
	 *	@param	argTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearTopDepObj cached instances sorted by their primary keys for the duplicate ClearDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearTopDepObj> readClearTopDepByClearDepIdx( long TenantId,
		long RelationId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamClearDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearTopDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearTopDepObj> readClearTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamClearTopDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearTopDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearTopDepObj> readClearTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamClearTopDepObj instances sorted by their primary keys for the duplicate ClrTopDepTblIdx key.
	 *
	 *	@param	argTableTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearTopDepObj cached instances sorted by their primary keys for the duplicate ClrTopDepTblIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearTopDepObj> readClearTopDepByClrTopDepTblIdx( long TableTenantId,
		long TableId );

	/**
	 *	Get the map of CFBamClearTopDepObj instances sorted by their primary keys for the duplicate ClrTopDepTblIdx key.
	 *
	 *	@param	argTableTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearTopDepObj cached instances sorted by their primary keys for the duplicate ClrTopDepTblIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearTopDepObj> readClearTopDepByClrTopDepTblIdx( long TableTenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Get the CFBamClearTopDepObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTableTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamClearTopDepObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamClearTopDepObj readClearTopDepByUNameIdx(long TableTenantId,
		long TableId,
		String Name );

	/**
	 *	Get the CFBamClearTopDepObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTableTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamClearTopDepObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamClearTopDepObj readClearTopDepByUNameIdx(long TableTenantId,
		long TableId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamClearTopDepObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearTopDepObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearTopDepObj> readClearTopDepByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamClearTopDepObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearTopDepObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearTopDepObj> readClearTopDepByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamClearTopDepObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearTopDepObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearTopDepObj> readClearTopDepByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamClearTopDepObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearTopDepObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearTopDepObj> readClearTopDepByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamClearTopDepObj updateClearTopDep( ICFBamClearTopDepObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteClearTopDep( ICFBamClearTopDepObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByClearDepIdx( long TenantId,
		long RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTableTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByClrTopDepTblIdx( long TableTenantId,
		long TableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTableTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByUNameIdx(long TableTenantId,
		long TableId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Move the CFBamClearTopDepObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamClearTopDepObj refreshed cache instance.
	 */
	ICFBamClearTopDepObj moveUpClearTopDep( ICFBamClearTopDepObj Obj );

	/**
	 *	Move the CFBamClearTopDepObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamClearTopDepObj refreshed cache instance.
	 */
	ICFBamClearTopDepObj moveDownClearTopDep( ICFBamClearTopDepObj Obj );
}
