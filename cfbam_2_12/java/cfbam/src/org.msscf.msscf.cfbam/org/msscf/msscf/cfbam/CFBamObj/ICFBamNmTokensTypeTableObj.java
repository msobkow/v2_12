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

public interface ICFBamNmTokensTypeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new NmTokensType instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamNmTokensTypeObj newInstance();

	/**
	 *	Instantiate a new NmTokensType edition of the specified NmTokensType instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamNmTokensTypeEditObj newEditInstance( ICFBamNmTokensTypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamNmTokensTypeObj realiseNmTokensType( ICFBamNmTokensTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetNmTokensType( ICFBamNmTokensTypeObj Obj );
	void forgetNmTokensType( ICFBamNmTokensTypeObj Obj, boolean forgetSubObjects );
	void forgetNmTokensTypeByIdIdx( long TenantId,
		long Id );

	void forgetNmTokensTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetNmTokensTypeByValTentIdx( long TenantId );

	void forgetNmTokensTypeByScopeIdx( long TenantId,
		long ScopeId );

	void forgetNmTokensTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetNmTokensTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetNmTokensTypeByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetNmTokensTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetNmTokensTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetNmTokensTypeBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamNmTokensTypeObj createNmTokensType( ICFBamNmTokensTypeObj Obj );

	/**
	 *	Read a NmTokensType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The NmTokensType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamNmTokensTypeObj readNmTokensType( CFBamValuePKey pkey );

	/**
	 *	Read a NmTokensType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The NmTokensType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamNmTokensTypeObj readNmTokensType( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamNmTokensTypeObj lockNmTokensType( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the NmTokensType-derived instances in the database.
	 *
	 *	@return	List of ICFBamNmTokensTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamNmTokensTypeObj> readAllNmTokensType();

	/**
	 *	Return a sorted map of all the NmTokensType-derived instances in the database.
	 *
	 *	@return	List of ICFBamNmTokensTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamNmTokensTypeObj> readAllNmTokensType( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamNmTokensTypeObj readNmTokensTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamNmTokensTypeObj readNmTokensTypeByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamNmTokensTypeObj readNmTokensTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamNmTokensTypeObj readNmTokensTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensTypeObj> readNmTokensTypeByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamNmTokensTypeObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensTypeObj> readNmTokensTypeByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensTypeObj> readNmTokensTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamNmTokensTypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensTypeObj> readNmTokensTypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensTypeObj> readNmTokensTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamNmTokensTypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensTypeObj> readNmTokensTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensTypeObj> readNmTokensTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamNmTokensTypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensTypeObj> readNmTokensTypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensTypeObj> readNmTokensTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamNmTokensTypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensTypeObj> readNmTokensTypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensTypeObj> readNmTokensTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamNmTokensTypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensTypeObj> readNmTokensTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensTypeObj> readNmTokensTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamNmTokensTypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensTypeObj> readNmTokensTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamNmTokensTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensTypeObj> readNmTokensTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamNmTokensTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensTypeObj> readNmTokensTypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamNmTokensTypeObj updateNmTokensType( ICFBamNmTokensTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteNmTokensType( ICFBamNmTokensTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The NmTokensType key attribute of the instance generating the id.
	 */
	void deleteNmTokensTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The NmTokensType key attribute of the instance generating the id.
	 */
	void deleteNmTokensTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 */
	void deleteNmTokensTypeByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensType key attribute of the instance generating the id.
	 */
	void deleteNmTokensTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The NmTokensType key attribute of the instance generating the id.
	 */
	void deleteNmTokensTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokensType key attribute of the instance generating the id.
	 */
	void deleteNmTokensTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokensType key attribute of the instance generating the id.
	 */
	void deleteNmTokensTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokensType key attribute of the instance generating the id.
	 */
	void deleteNmTokensTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokensType key attribute of the instance generating the id.
	 */
	void deleteNmTokensTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokensType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The NmTokensType key attribute of the instance generating the id.
	 */
	void deleteNmTokensTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamNmTokensTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamNmTokensTypeObj refreshed cache instance.
	 */
	ICFBamNmTokensTypeObj moveUpNmTokensType( ICFBamNmTokensTypeObj Obj );

	/**
	 *	Move the CFBamNmTokensTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamNmTokensTypeObj refreshed cache instance.
	 */
	ICFBamNmTokensTypeObj moveDownNmTokensType( ICFBamNmTokensTypeObj Obj );
}
