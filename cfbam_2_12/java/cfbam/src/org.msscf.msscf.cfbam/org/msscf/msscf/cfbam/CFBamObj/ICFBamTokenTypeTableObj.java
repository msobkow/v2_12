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

public interface ICFBamTokenTypeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TokenType instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTokenTypeObj newInstance();

	/**
	 *	Instantiate a new TokenType edition of the specified TokenType instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTokenTypeEditObj newEditInstance( ICFBamTokenTypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTokenTypeObj realiseTokenType( ICFBamTokenTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTokenType( ICFBamTokenTypeObj Obj );
	void forgetTokenType( ICFBamTokenTypeObj Obj, boolean forgetSubObjects );
	void forgetTokenTypeByIdIdx( long TenantId,
		long Id );

	void forgetTokenTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetTokenTypeByValTentIdx( long TenantId );

	void forgetTokenTypeByScopeIdx( long TenantId,
		long ScopeId );

	void forgetTokenTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTokenTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetTokenTypeByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetTokenTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetTokenTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetTokenTypeBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamTokenTypeObj createTokenType( ICFBamTokenTypeObj Obj );

	/**
	 *	Read a TokenType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TokenType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTokenTypeObj readTokenType( CFBamValuePKey pkey );

	/**
	 *	Read a TokenType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TokenType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTokenTypeObj readTokenType( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTokenTypeObj lockTokenType( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the TokenType-derived instances in the database.
	 *
	 *	@return	List of ICFBamTokenTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTokenTypeObj> readAllTokenType();

	/**
	 *	Return a sorted map of all the TokenType-derived instances in the database.
	 *
	 *	@return	List of ICFBamTokenTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTokenTypeObj> readAllTokenType( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTokenTypeObj readTokenTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTokenTypeObj readTokenTypeByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTokenTypeObj readTokenTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTokenTypeObj readTokenTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamTokenTypeObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamTokenTypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamTokenTypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTokenTypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamTokenTypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTokenTypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamTokenTypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTokenTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamTokenTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTokenTypeObj updateTokenType( ICFBamTokenTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTokenType( ICFBamTokenTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamTokenTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTokenTypeObj refreshed cache instance.
	 */
	ICFBamTokenTypeObj moveUpTokenType( ICFBamTokenTypeObj Obj );

	/**
	 *	Move the CFBamTokenTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTokenTypeObj refreshed cache instance.
	 */
	ICFBamTokenTypeObj moveDownTokenType( ICFBamTokenTypeObj Obj );
}
