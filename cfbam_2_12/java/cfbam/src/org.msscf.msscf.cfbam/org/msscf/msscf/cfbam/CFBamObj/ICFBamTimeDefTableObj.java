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

public interface ICFBamTimeDefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TimeDef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTimeDefObj newInstance();

	/**
	 *	Instantiate a new TimeDef edition of the specified TimeDef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTimeDefEditObj newEditInstance( ICFBamTimeDefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTimeDefObj realiseTimeDef( ICFBamTimeDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTimeDef( ICFBamTimeDefObj Obj );
	void forgetTimeDef( ICFBamTimeDefObj Obj, boolean forgetSubObjects );
	void forgetTimeDefByIdIdx( long TenantId,
		long Id );

	void forgetTimeDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetTimeDefByValTentIdx( long TenantId );

	void forgetTimeDefByScopeIdx( long TenantId,
		long ScopeId );

	void forgetTimeDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTimeDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetTimeDefByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetTimeDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetTimeDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamTimeDefObj createTimeDef( ICFBamTimeDefObj Obj );

	/**
	 *	Read a TimeDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TimeDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTimeDefObj readTimeDef( CFBamValuePKey pkey );

	/**
	 *	Read a TimeDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TimeDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTimeDefObj readTimeDef( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTimeDefObj lockTimeDef( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the TimeDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamTimeDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTimeDefObj> readAllTimeDef();

	/**
	 *	Return a sorted map of all the TimeDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamTimeDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTimeDefObj> readAllTimeDef( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTimeDefObj readTimeDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTimeDefObj readTimeDefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTimeDefObj readTimeDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTimeDefObj readTimeDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeDefObj> readTimeDefByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamTimeDefObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeDefObj> readTimeDefByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeDefObj> readTimeDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamTimeDefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeDefObj> readTimeDefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeDefObj> readTimeDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamTimeDefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeDefObj> readTimeDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeDefObj> readTimeDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTimeDefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeDefObj> readTimeDefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeDefObj> readTimeDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamTimeDefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeDefObj> readTimeDefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeDefObj> readTimeDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTimeDefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeDefObj> readTimeDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeDefObj> readTimeDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamTimeDefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTimeDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTimeDefObj> readTimeDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTimeDefObj updateTimeDef( ICFBamTimeDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTimeDef( ICFBamTimeDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TimeDef key attribute of the instance generating the id.
	 */
	void deleteTimeDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TimeDef key attribute of the instance generating the id.
	 */
	void deleteTimeDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeDef key attribute of the instance generating the id.
	 */
	void deleteTimeDefByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeDef key attribute of the instance generating the id.
	 */
	void deleteTimeDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TimeDef key attribute of the instance generating the id.
	 */
	void deleteTimeDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimeDef key attribute of the instance generating the id.
	 */
	void deleteTimeDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimeDef key attribute of the instance generating the id.
	 */
	void deleteTimeDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TimeDef key attribute of the instance generating the id.
	 */
	void deleteTimeDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TimeDef key attribute of the instance generating the id.
	 */
	void deleteTimeDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the CFBamTimeDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTimeDefObj refreshed cache instance.
	 */
	ICFBamTimeDefObj moveUpTimeDef( ICFBamTimeDefObj Obj );

	/**
	 *	Move the CFBamTimeDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTimeDefObj refreshed cache instance.
	 */
	ICFBamTimeDefObj moveDownTimeDef( ICFBamTimeDefObj Obj );
}
