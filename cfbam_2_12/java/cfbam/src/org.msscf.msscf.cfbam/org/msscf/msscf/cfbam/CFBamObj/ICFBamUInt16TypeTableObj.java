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

public interface ICFBamUInt16TypeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new UInt16Type instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamUInt16TypeObj newInstance();

	/**
	 *	Instantiate a new UInt16Type edition of the specified UInt16Type instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamUInt16TypeEditObj newEditInstance( ICFBamUInt16TypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamUInt16TypeObj realiseUInt16Type( ICFBamUInt16TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetUInt16Type( ICFBamUInt16TypeObj Obj );
	void forgetUInt16Type( ICFBamUInt16TypeObj Obj, boolean forgetSubObjects );
	void forgetUInt16TypeByIdIdx( long TenantId,
		long Id );

	void forgetUInt16TypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetUInt16TypeByValTentIdx( long TenantId );

	void forgetUInt16TypeByScopeIdx( long TenantId,
		long ScopeId );

	void forgetUInt16TypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetUInt16TypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetUInt16TypeByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetUInt16TypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetUInt16TypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetUInt16TypeBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamUInt16TypeObj createUInt16Type( ICFBamUInt16TypeObj Obj );

	/**
	 *	Read a UInt16Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UInt16Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamUInt16TypeObj readUInt16Type( CFBamValuePKey pkey );

	/**
	 *	Read a UInt16Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UInt16Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamUInt16TypeObj readUInt16Type( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamUInt16TypeObj lockUInt16Type( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the UInt16Type-derived instances in the database.
	 *
	 *	@return	List of ICFBamUInt16TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamUInt16TypeObj> readAllUInt16Type();

	/**
	 *	Return a sorted map of all the UInt16Type-derived instances in the database.
	 *
	 *	@return	List of ICFBamUInt16TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamUInt16TypeObj> readAllUInt16Type( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt16TypeObj readUInt16TypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt16TypeObj readUInt16TypeByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt16TypeObj readUInt16TypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt16TypeObj readUInt16TypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16TypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16TypeObj> readUInt16TypeByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamUInt16TypeObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16TypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16TypeObj> readUInt16TypeByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16TypeObj> readUInt16TypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamUInt16TypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16TypeObj> readUInt16TypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16TypeObj> readUInt16TypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamUInt16TypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16TypeObj> readUInt16TypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16TypeObj> readUInt16TypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamUInt16TypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16TypeObj> readUInt16TypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16TypeObj> readUInt16TypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamUInt16TypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16TypeObj> readUInt16TypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16TypeObj> readUInt16TypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamUInt16TypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16TypeObj> readUInt16TypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16TypeObj> readUInt16TypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamUInt16TypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16TypeObj> readUInt16TypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamUInt16TypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16TypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16TypeObj> readUInt16TypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamUInt16TypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16TypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16TypeObj> readUInt16TypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamUInt16TypeObj updateUInt16Type( ICFBamUInt16TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteUInt16Type( ICFBamUInt16TypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UInt16Type key attribute of the instance generating the id.
	 */
	void deleteUInt16TypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UInt16Type key attribute of the instance generating the id.
	 */
	void deleteUInt16TypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 */
	void deleteUInt16TypeByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Type key attribute of the instance generating the id.
	 */
	void deleteUInt16TypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UInt16Type key attribute of the instance generating the id.
	 */
	void deleteUInt16TypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt16Type key attribute of the instance generating the id.
	 */
	void deleteUInt16TypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt16Type key attribute of the instance generating the id.
	 */
	void deleteUInt16TypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt16Type key attribute of the instance generating the id.
	 */
	void deleteUInt16TypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt16Type key attribute of the instance generating the id.
	 */
	void deleteUInt16TypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Type key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The UInt16Type key attribute of the instance generating the id.
	 */
	void deleteUInt16TypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamUInt16TypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamUInt16TypeObj refreshed cache instance.
	 */
	ICFBamUInt16TypeObj moveUpUInt16Type( ICFBamUInt16TypeObj Obj );

	/**
	 *	Move the CFBamUInt16TypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamUInt16TypeObj refreshed cache instance.
	 */
	ICFBamUInt16TypeObj moveDownUInt16Type( ICFBamUInt16TypeObj Obj );
}
