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

public interface ICFBamUuidColTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new UuidCol instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamUuidColObj newInstance();

	/**
	 *	Instantiate a new UuidCol edition of the specified UuidCol instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamUuidColEditObj newEditInstance( ICFBamUuidColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamUuidColObj realiseUuidCol( ICFBamUuidColObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetUuidCol( ICFBamUuidColObj Obj );
	void forgetUuidCol( ICFBamUuidColObj Obj, boolean forgetSubObjects );
	void forgetUuidColByIdIdx( long TenantId,
		long Id );

	void forgetUuidColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetUuidColByValTentIdx( long TenantId );

	void forgetUuidColByScopeIdx( long TenantId,
		long ScopeId );

	void forgetUuidColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetUuidColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetUuidColByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetUuidColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetUuidColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetUuidColByTableIdx( long TenantId,
		long TableId );


	/**
	 *	Internal use only.
	 */
	ICFBamUuidColObj createUuidCol( ICFBamUuidColObj Obj );

	/**
	 *	Read a UuidCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UuidCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamUuidColObj readUuidCol( CFBamValuePKey pkey );

	/**
	 *	Read a UuidCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UuidCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamUuidColObj readUuidCol( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamUuidColObj lockUuidCol( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the UuidCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamUuidColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamUuidColObj> readAllUuidCol();

	/**
	 *	Return a sorted map of all the UuidCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamUuidColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamUuidColObj> readAllUuidCol( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamUuidColObj readUuidColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamUuidColObj readUuidColByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamUuidColObj readUuidColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamUuidColObj readUuidColByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidColObj> readUuidColByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamUuidColObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidColObj> readUuidColByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidColObj> readUuidColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamUuidColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidColObj> readUuidColByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidColObj> readUuidColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamUuidColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidColObj> readUuidColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidColObj> readUuidColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamUuidColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidColObj> readUuidColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidColObj> readUuidColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamUuidColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidColObj> readUuidColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidColObj> readUuidColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamUuidColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidColObj> readUuidColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidColObj> readUuidColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamUuidColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidColObj> readUuidColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamUuidColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidColObj> readUuidColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamUuidColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidColObj> readUuidColByTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamUuidColObj updateUuidCol( ICFBamUuidColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteUuidCol( ICFBamUuidColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UuidCol key attribute of the instance generating the id.
	 */
	void deleteUuidColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UuidCol key attribute of the instance generating the id.
	 */
	void deleteUuidColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 */
	void deleteUuidColByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidCol key attribute of the instance generating the id.
	 */
	void deleteUuidColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UuidCol key attribute of the instance generating the id.
	 */
	void deleteUuidColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidCol key attribute of the instance generating the id.
	 */
	void deleteUuidColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidCol key attribute of the instance generating the id.
	 */
	void deleteUuidColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidCol key attribute of the instance generating the id.
	 */
	void deleteUuidColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidCol key attribute of the instance generating the id.
	 */
	void deleteUuidColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The UuidCol key attribute of the instance generating the id.
	 */
	void deleteUuidColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Move the CFBamUuidColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamUuidColObj refreshed cache instance.
	 */
	ICFBamUuidColObj moveUpUuidCol( ICFBamUuidColObj Obj );

	/**
	 *	Move the CFBamUuidColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamUuidColObj refreshed cache instance.
	 */
	ICFBamUuidColObj moveDownUuidCol( ICFBamUuidColObj Obj );
}
