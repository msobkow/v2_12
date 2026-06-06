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

public interface ICFBamTokenColTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TokenCol instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTokenColObj newInstance();

	/**
	 *	Instantiate a new TokenCol edition of the specified TokenCol instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTokenColEditObj newEditInstance( ICFBamTokenColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTokenColObj realiseTokenCol( ICFBamTokenColObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTokenCol( ICFBamTokenColObj Obj );
	void forgetTokenCol( ICFBamTokenColObj Obj, boolean forgetSubObjects );
	void forgetTokenColByIdIdx( long TenantId,
		long Id );

	void forgetTokenColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetTokenColByValTentIdx( long TenantId );

	void forgetTokenColByScopeIdx( long TenantId,
		long ScopeId );

	void forgetTokenColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTokenColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetTokenColByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetTokenColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetTokenColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetTokenColByTableIdx( long TenantId,
		long TableId );


	/**
	 *	Internal use only.
	 */
	ICFBamTokenColObj createTokenCol( ICFBamTokenColObj Obj );

	/**
	 *	Read a TokenCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TokenCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTokenColObj readTokenCol( CFBamValuePKey pkey );

	/**
	 *	Read a TokenCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TokenCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTokenColObj readTokenCol( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTokenColObj lockTokenCol( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the TokenCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamTokenColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTokenColObj> readAllTokenCol();

	/**
	 *	Return a sorted map of all the TokenCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamTokenColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTokenColObj> readAllTokenCol( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTokenColObj readTokenColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTokenColObj readTokenColByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTokenColObj readTokenColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTokenColObj readTokenColByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenColObj> readTokenColByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamTokenColObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenColObj> readTokenColByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenColObj> readTokenColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamTokenColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenColObj> readTokenColByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenColObj> readTokenColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamTokenColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenColObj> readTokenColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenColObj> readTokenColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTokenColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenColObj> readTokenColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenColObj> readTokenColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamTokenColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenColObj> readTokenColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenColObj> readTokenColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTokenColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenColObj> readTokenColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenColObj> readTokenColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamTokenColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenColObj> readTokenColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTokenColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenColObj> readTokenColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamTokenColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenColObj> readTokenColByTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTokenColObj updateTokenCol( ICFBamTokenColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTokenCol( ICFBamTokenColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TokenCol key attribute of the instance generating the id.
	 */
	void deleteTokenColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TokenCol key attribute of the instance generating the id.
	 */
	void deleteTokenColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 */
	void deleteTokenColByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenCol key attribute of the instance generating the id.
	 */
	void deleteTokenColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TokenCol key attribute of the instance generating the id.
	 */
	void deleteTokenColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenCol key attribute of the instance generating the id.
	 */
	void deleteTokenColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenCol key attribute of the instance generating the id.
	 */
	void deleteTokenColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenCol key attribute of the instance generating the id.
	 */
	void deleteTokenColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenCol key attribute of the instance generating the id.
	 */
	void deleteTokenColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The TokenCol key attribute of the instance generating the id.
	 */
	void deleteTokenColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Move the CFBamTokenColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTokenColObj refreshed cache instance.
	 */
	ICFBamTokenColObj moveUpTokenCol( ICFBamTokenColObj Obj );

	/**
	 *	Move the CFBamTokenColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTokenColObj refreshed cache instance.
	 */
	ICFBamTokenColObj moveDownTokenCol( ICFBamTokenColObj Obj );
}
