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

public interface ICFBamUInt32TypeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new UInt32Type instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamUInt32TypeObj newInstance();

	/**
	 *	Instantiate a new UInt32Type edition of the specified UInt32Type instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamUInt32TypeEditObj newEditInstance( ICFBamUInt32TypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamUInt32TypeObj realiseUInt32Type( ICFBamUInt32TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetUInt32Type( ICFBamUInt32TypeObj Obj );
	void forgetUInt32Type( ICFBamUInt32TypeObj Obj, boolean forgetSubObjects );
	void forgetUInt32TypeByIdIdx( long TenantId,
		long Id );

	void forgetUInt32TypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetUInt32TypeByValTentIdx( long TenantId );

	void forgetUInt32TypeByScopeIdx( long TenantId,
		long ScopeId );

	void forgetUInt32TypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetUInt32TypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetUInt32TypeByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetUInt32TypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetUInt32TypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetUInt32TypeBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamUInt32TypeObj createUInt32Type( ICFBamUInt32TypeObj Obj );

	/**
	 *	Read a UInt32Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UInt32Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamUInt32TypeObj readUInt32Type( CFBamValuePKey pkey );

	/**
	 *	Read a UInt32Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UInt32Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamUInt32TypeObj readUInt32Type( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamUInt32TypeObj lockUInt32Type( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the UInt32Type-derived instances in the database.
	 *
	 *	@return	List of ICFBamUInt32TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamUInt32TypeObj> readAllUInt32Type();

	/**
	 *	Return a sorted map of all the UInt32Type-derived instances in the database.
	 *
	 *	@return	List of ICFBamUInt32TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamUInt32TypeObj> readAllUInt32Type( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt32TypeObj readUInt32TypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt32TypeObj readUInt32TypeByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt32TypeObj readUInt32TypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt32TypeObj readUInt32TypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt32TypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt32TypeObj> readUInt32TypeByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamUInt32TypeObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt32TypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt32TypeObj> readUInt32TypeByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt32TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt32TypeObj> readUInt32TypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamUInt32TypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt32TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt32TypeObj> readUInt32TypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt32TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt32TypeObj> readUInt32TypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamUInt32TypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt32TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt32TypeObj> readUInt32TypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt32TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt32TypeObj> readUInt32TypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamUInt32TypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt32TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt32TypeObj> readUInt32TypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt32TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt32TypeObj> readUInt32TypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamUInt32TypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt32TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt32TypeObj> readUInt32TypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt32TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt32TypeObj> readUInt32TypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamUInt32TypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt32TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt32TypeObj> readUInt32TypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt32TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt32TypeObj> readUInt32TypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamUInt32TypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt32TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt32TypeObj> readUInt32TypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamUInt32TypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt32TypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt32TypeObj> readUInt32TypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamUInt32TypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt32TypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt32TypeObj> readUInt32TypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamUInt32TypeObj updateUInt32Type( ICFBamUInt32TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteUInt32Type( ICFBamUInt32TypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UInt32Type key attribute of the instance generating the id.
	 */
	void deleteUInt32TypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UInt32Type key attribute of the instance generating the id.
	 */
	void deleteUInt32TypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 */
	void deleteUInt32TypeByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt32Type key attribute of the instance generating the id.
	 */
	void deleteUInt32TypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UInt32Type key attribute of the instance generating the id.
	 */
	void deleteUInt32TypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt32Type key attribute of the instance generating the id.
	 */
	void deleteUInt32TypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt32Type key attribute of the instance generating the id.
	 */
	void deleteUInt32TypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt32Type key attribute of the instance generating the id.
	 */
	void deleteUInt32TypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt32Type key attribute of the instance generating the id.
	 */
	void deleteUInt32TypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt32Type key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The UInt32Type key attribute of the instance generating the id.
	 */
	void deleteUInt32TypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamUInt32TypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamUInt32TypeObj refreshed cache instance.
	 */
	ICFBamUInt32TypeObj moveUpUInt32Type( ICFBamUInt32TypeObj Obj );

	/**
	 *	Move the CFBamUInt32TypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamUInt32TypeObj refreshed cache instance.
	 */
	ICFBamUInt32TypeObj moveDownUInt32Type( ICFBamUInt32TypeObj Obj );
}
