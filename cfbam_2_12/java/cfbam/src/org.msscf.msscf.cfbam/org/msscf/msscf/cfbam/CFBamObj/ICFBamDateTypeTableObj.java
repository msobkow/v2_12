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

public interface ICFBamDateTypeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new DateType instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamDateTypeObj newInstance();

	/**
	 *	Instantiate a new DateType edition of the specified DateType instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamDateTypeEditObj newEditInstance( ICFBamDateTypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamDateTypeObj realiseDateType( ICFBamDateTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetDateType( ICFBamDateTypeObj Obj );
	void forgetDateType( ICFBamDateTypeObj Obj, boolean forgetSubObjects );
	void forgetDateTypeByIdIdx( long TenantId,
		long Id );

	void forgetDateTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetDateTypeByValTentIdx( long TenantId );

	void forgetDateTypeByScopeIdx( long TenantId,
		long ScopeId );

	void forgetDateTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetDateTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetDateTypeByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetDateTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetDateTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetDateTypeBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamDateTypeObj createDateType( ICFBamDateTypeObj Obj );

	/**
	 *	Read a DateType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DateType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamDateTypeObj readDateType( CFBamValuePKey pkey );

	/**
	 *	Read a DateType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DateType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamDateTypeObj readDateType( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamDateTypeObj lockDateType( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the DateType-derived instances in the database.
	 *
	 *	@return	List of ICFBamDateTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamDateTypeObj> readAllDateType();

	/**
	 *	Return a sorted map of all the DateType-derived instances in the database.
	 *
	 *	@return	List of ICFBamDateTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamDateTypeObj> readAllDateType( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamDateTypeObj readDateTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamDateTypeObj readDateTypeByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamDateTypeObj readDateTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamDateTypeObj readDateTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateTypeObj> readDateTypeByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamDateTypeObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateTypeObj> readDateTypeByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateTypeObj> readDateTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamDateTypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateTypeObj> readDateTypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateTypeObj> readDateTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamDateTypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateTypeObj> readDateTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateTypeObj> readDateTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamDateTypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateTypeObj> readDateTypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateTypeObj> readDateTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamDateTypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateTypeObj> readDateTypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateTypeObj> readDateTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamDateTypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateTypeObj> readDateTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateTypeObj> readDateTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamDateTypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateTypeObj> readDateTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamDateTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateTypeObj> readDateTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamDateTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The DateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateTypeObj> readDateTypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamDateTypeObj updateDateType( ICFBamDateTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDateType( ICFBamDateTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DateType key attribute of the instance generating the id.
	 */
	void deleteDateTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DateType key attribute of the instance generating the id.
	 */
	void deleteDateTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 */
	void deleteDateTypeByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateType key attribute of the instance generating the id.
	 */
	void deleteDateTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DateType key attribute of the instance generating the id.
	 */
	void deleteDateTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DateType key attribute of the instance generating the id.
	 */
	void deleteDateTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DateType key attribute of the instance generating the id.
	 */
	void deleteDateTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DateType key attribute of the instance generating the id.
	 */
	void deleteDateTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DateType key attribute of the instance generating the id.
	 */
	void deleteDateTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The DateType key attribute of the instance generating the id.
	 */
	void deleteDateTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamDateTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamDateTypeObj refreshed cache instance.
	 */
	ICFBamDateTypeObj moveUpDateType( ICFBamDateTypeObj Obj );

	/**
	 *	Move the CFBamDateTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamDateTypeObj refreshed cache instance.
	 */
	ICFBamDateTypeObj moveDownDateType( ICFBamDateTypeObj Obj );
}
