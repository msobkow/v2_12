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

public interface ICFBamEnumTypeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new EnumType instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamEnumTypeObj newInstance();

	/**
	 *	Instantiate a new EnumType edition of the specified EnumType instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamEnumTypeEditObj newEditInstance( ICFBamEnumTypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamEnumTypeObj realiseEnumType( ICFBamEnumTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetEnumType( ICFBamEnumTypeObj Obj );
	void forgetEnumType( ICFBamEnumTypeObj Obj, boolean forgetSubObjects );
	void forgetEnumTypeByIdIdx( long TenantId,
		long Id );

	void forgetEnumTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetEnumTypeByValTentIdx( long TenantId );

	void forgetEnumTypeByScopeIdx( long TenantId,
		long ScopeId );

	void forgetEnumTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetEnumTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetEnumTypeByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetEnumTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetEnumTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetEnumTypeBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamEnumTypeObj createEnumType( ICFBamEnumTypeObj Obj );

	/**
	 *	Read a EnumType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The EnumType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamEnumTypeObj readEnumType( CFBamValuePKey pkey );

	/**
	 *	Read a EnumType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The EnumType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamEnumTypeObj readEnumType( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamEnumTypeObj lockEnumType( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the EnumType-derived instances in the database.
	 *
	 *	@return	List of ICFBamEnumTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamEnumTypeObj> readAllEnumType();

	/**
	 *	Return a sorted map of all the EnumType-derived instances in the database.
	 *
	 *	@return	List of ICFBamEnumTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamEnumTypeObj> readAllEnumType( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamEnumTypeObj readEnumTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamEnumTypeObj readEnumTypeByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamEnumTypeObj readEnumTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamEnumTypeObj readEnumTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTypeObj> readEnumTypeByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamEnumTypeObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTypeObj> readEnumTypeByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTypeObj> readEnumTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamEnumTypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTypeObj> readEnumTypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTypeObj> readEnumTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamEnumTypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTypeObj> readEnumTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTypeObj> readEnumTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamEnumTypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTypeObj> readEnumTypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTypeObj> readEnumTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamEnumTypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTypeObj> readEnumTypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTypeObj> readEnumTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamEnumTypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTypeObj> readEnumTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTypeObj> readEnumTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamEnumTypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTypeObj> readEnumTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamEnumTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTypeObj> readEnumTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamEnumTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTypeObj> readEnumTypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamEnumTypeObj updateEnumType( ICFBamEnumTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteEnumType( ICFBamEnumTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The EnumType key attribute of the instance generating the id.
	 */
	void deleteEnumTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The EnumType key attribute of the instance generating the id.
	 */
	void deleteEnumTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 */
	void deleteEnumTypeByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumType key attribute of the instance generating the id.
	 */
	void deleteEnumTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The EnumType key attribute of the instance generating the id.
	 */
	void deleteEnumTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumType key attribute of the instance generating the id.
	 */
	void deleteEnumTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumType key attribute of the instance generating the id.
	 */
	void deleteEnumTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumType key attribute of the instance generating the id.
	 */
	void deleteEnumTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumType key attribute of the instance generating the id.
	 */
	void deleteEnumTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The EnumType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The EnumType key attribute of the instance generating the id.
	 */
	void deleteEnumTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamEnumTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamEnumTypeObj refreshed cache instance.
	 */
	ICFBamEnumTypeObj moveUpEnumType( ICFBamEnumTypeObj Obj );

	/**
	 *	Move the CFBamEnumTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamEnumTypeObj refreshed cache instance.
	 */
	ICFBamEnumTypeObj moveDownEnumType( ICFBamEnumTypeObj Obj );
}
