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

public interface ICFBamTZDateDefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TZDateDef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTZDateDefObj newInstance();

	/**
	 *	Instantiate a new TZDateDef edition of the specified TZDateDef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTZDateDefEditObj newEditInstance( ICFBamTZDateDefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTZDateDefObj realiseTZDateDef( ICFBamTZDateDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTZDateDef( ICFBamTZDateDefObj Obj );
	void forgetTZDateDef( ICFBamTZDateDefObj Obj, boolean forgetSubObjects );
	void forgetTZDateDefByIdIdx( long TenantId,
		long Id );

	void forgetTZDateDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetTZDateDefByValTentIdx( long TenantId );

	void forgetTZDateDefByScopeIdx( long TenantId,
		long ScopeId );

	void forgetTZDateDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTZDateDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetTZDateDefByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetTZDateDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetTZDateDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamTZDateDefObj createTZDateDef( ICFBamTZDateDefObj Obj );

	/**
	 *	Read a TZDateDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TZDateDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTZDateDefObj readTZDateDef( CFBamValuePKey pkey );

	/**
	 *	Read a TZDateDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TZDateDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTZDateDefObj readTZDateDef( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTZDateDefObj lockTZDateDef( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the TZDateDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamTZDateDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTZDateDefObj> readAllTZDateDef();

	/**
	 *	Return a sorted map of all the TZDateDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamTZDateDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTZDateDefObj> readAllTZDateDef( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZDateDefObj readTZDateDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZDateDefObj readTZDateDefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZDateDefObj readTZDateDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZDateDefObj readTZDateDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateDefObj> readTZDateDefByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamTZDateDefObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateDefObj> readTZDateDefByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateDefObj> readTZDateDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamTZDateDefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateDefObj> readTZDateDefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateDefObj> readTZDateDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamTZDateDefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateDefObj> readTZDateDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateDefObj> readTZDateDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTZDateDefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateDefObj> readTZDateDefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateDefObj> readTZDateDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamTZDateDefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateDefObj> readTZDateDefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateDefObj> readTZDateDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTZDateDefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateDefObj> readTZDateDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateDefObj> readTZDateDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamTZDateDefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateDefObj> readTZDateDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTZDateDefObj updateTZDateDef( ICFBamTZDateDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTZDateDef( ICFBamTZDateDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZDateDef key attribute of the instance generating the id.
	 */
	void deleteTZDateDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZDateDef key attribute of the instance generating the id.
	 */
	void deleteTZDateDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 */
	void deleteTZDateDefByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 */
	void deleteTZDateDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZDateDef key attribute of the instance generating the id.
	 */
	void deleteTZDateDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZDateDef key attribute of the instance generating the id.
	 */
	void deleteTZDateDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZDateDef key attribute of the instance generating the id.
	 */
	void deleteTZDateDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZDateDef key attribute of the instance generating the id.
	 */
	void deleteTZDateDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZDateDef key attribute of the instance generating the id.
	 */
	void deleteTZDateDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the CFBamTZDateDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZDateDefObj refreshed cache instance.
	 */
	ICFBamTZDateDefObj moveUpTZDateDef( ICFBamTZDateDefObj Obj );

	/**
	 *	Move the CFBamTZDateDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZDateDefObj refreshed cache instance.
	 */
	ICFBamTZDateDefObj moveDownTZDateDef( ICFBamTZDateDefObj Obj );
}
