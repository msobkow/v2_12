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

public interface ICFBamTokenDefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TokenDef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTokenDefObj newInstance();

	/**
	 *	Instantiate a new TokenDef edition of the specified TokenDef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTokenDefEditObj newEditInstance( ICFBamTokenDefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTokenDefObj realiseTokenDef( ICFBamTokenDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTokenDef( ICFBamTokenDefObj Obj );
	void forgetTokenDef( ICFBamTokenDefObj Obj, boolean forgetSubObjects );
	void forgetTokenDefByIdIdx( long TenantId,
		long Id );

	void forgetTokenDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetTokenDefByValTentIdx( long TenantId );

	void forgetTokenDefByScopeIdx( long TenantId,
		long ScopeId );

	void forgetTokenDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTokenDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetTokenDefByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetTokenDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetTokenDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamTokenDefObj createTokenDef( ICFBamTokenDefObj Obj );

	/**
	 *	Read a TokenDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TokenDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTokenDefObj readTokenDef( CFBamValuePKey pkey );

	/**
	 *	Read a TokenDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TokenDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTokenDefObj readTokenDef( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTokenDefObj lockTokenDef( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the TokenDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamTokenDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTokenDefObj> readAllTokenDef();

	/**
	 *	Return a sorted map of all the TokenDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamTokenDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTokenDefObj> readAllTokenDef( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTokenDefObj readTokenDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTokenDefObj readTokenDefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTokenDefObj readTokenDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTokenDefObj readTokenDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenDefObj> readTokenDefByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamTokenDefObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenDefObj> readTokenDefByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenDefObj> readTokenDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamTokenDefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenDefObj> readTokenDefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenDefObj> readTokenDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamTokenDefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenDefObj> readTokenDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenDefObj> readTokenDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTokenDefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenDefObj> readTokenDefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenDefObj> readTokenDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamTokenDefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenDefObj> readTokenDefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenDefObj> readTokenDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTokenDefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenDefObj> readTokenDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenDefObj> readTokenDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamTokenDefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenDefObj> readTokenDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTokenDefObj updateTokenDef( ICFBamTokenDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTokenDef( ICFBamTokenDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TokenDef key attribute of the instance generating the id.
	 */
	void deleteTokenDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TokenDef key attribute of the instance generating the id.
	 */
	void deleteTokenDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenDef key attribute of the instance generating the id.
	 */
	void deleteTokenDefByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenDef key attribute of the instance generating the id.
	 */
	void deleteTokenDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TokenDef key attribute of the instance generating the id.
	 */
	void deleteTokenDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenDef key attribute of the instance generating the id.
	 */
	void deleteTokenDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenDef key attribute of the instance generating the id.
	 */
	void deleteTokenDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenDef key attribute of the instance generating the id.
	 */
	void deleteTokenDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenDef key attribute of the instance generating the id.
	 */
	void deleteTokenDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the CFBamTokenDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTokenDefObj refreshed cache instance.
	 */
	ICFBamTokenDefObj moveUpTokenDef( ICFBamTokenDefObj Obj );

	/**
	 *	Move the CFBamTokenDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTokenDefObj refreshed cache instance.
	 */
	ICFBamTokenDefObj moveDownTokenDef( ICFBamTokenDefObj Obj );
}
