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

public interface ICFBamUuidTypeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new UuidType instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamUuidTypeObj newInstance();

	/**
	 *	Instantiate a new UuidType edition of the specified UuidType instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamUuidTypeEditObj newEditInstance( ICFBamUuidTypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamUuidTypeObj realiseUuidType( ICFBamUuidTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetUuidType( ICFBamUuidTypeObj Obj );
	void forgetUuidType( ICFBamUuidTypeObj Obj, boolean forgetSubObjects );
	void forgetUuidTypeByIdIdx( long TenantId,
		long Id );

	void forgetUuidTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetUuidTypeByValTentIdx( long TenantId );

	void forgetUuidTypeByScopeIdx( long TenantId,
		long ScopeId );

	void forgetUuidTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetUuidTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetUuidTypeByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetUuidTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetUuidTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetUuidTypeBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamUuidTypeObj createUuidType( ICFBamUuidTypeObj Obj );

	/**
	 *	Read a UuidType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UuidType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamUuidTypeObj readUuidType( CFBamValuePKey pkey );

	/**
	 *	Read a UuidType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UuidType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamUuidTypeObj readUuidType( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamUuidTypeObj lockUuidType( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the UuidType-derived instances in the database.
	 *
	 *	@return	List of ICFBamUuidTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamUuidTypeObj> readAllUuidType();

	/**
	 *	Return a sorted map of all the UuidType-derived instances in the database.
	 *
	 *	@return	List of ICFBamUuidTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamUuidTypeObj> readAllUuidType( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamUuidTypeObj readUuidTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamUuidTypeObj readUuidTypeByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamUuidTypeObj readUuidTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamUuidTypeObj readUuidTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidTypeObj> readUuidTypeByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamUuidTypeObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidTypeObj> readUuidTypeByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidTypeObj> readUuidTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamUuidTypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidTypeObj> readUuidTypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidTypeObj> readUuidTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamUuidTypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidTypeObj> readUuidTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidTypeObj> readUuidTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamUuidTypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidTypeObj> readUuidTypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidTypeObj> readUuidTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamUuidTypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidTypeObj> readUuidTypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidTypeObj> readUuidTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamUuidTypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidTypeObj> readUuidTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidTypeObj> readUuidTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamUuidTypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidTypeObj> readUuidTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamUuidTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidTypeObj> readUuidTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamUuidTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidTypeObj> readUuidTypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamUuidTypeObj updateUuidType( ICFBamUuidTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteUuidType( ICFBamUuidTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UuidType key attribute of the instance generating the id.
	 */
	void deleteUuidTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UuidType key attribute of the instance generating the id.
	 */
	void deleteUuidTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 */
	void deleteUuidTypeByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidType key attribute of the instance generating the id.
	 */
	void deleteUuidTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UuidType key attribute of the instance generating the id.
	 */
	void deleteUuidTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidType key attribute of the instance generating the id.
	 */
	void deleteUuidTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidType key attribute of the instance generating the id.
	 */
	void deleteUuidTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidType key attribute of the instance generating the id.
	 */
	void deleteUuidTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidType key attribute of the instance generating the id.
	 */
	void deleteUuidTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The UuidType key attribute of the instance generating the id.
	 */
	void deleteUuidTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamUuidTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamUuidTypeObj refreshed cache instance.
	 */
	ICFBamUuidTypeObj moveUpUuidType( ICFBamUuidTypeObj Obj );

	/**
	 *	Move the CFBamUuidTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamUuidTypeObj refreshed cache instance.
	 */
	ICFBamUuidTypeObj moveDownUuidType( ICFBamUuidTypeObj Obj );
}
