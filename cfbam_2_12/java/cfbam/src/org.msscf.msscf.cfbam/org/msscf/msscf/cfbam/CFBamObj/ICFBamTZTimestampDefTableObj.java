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

public interface ICFBamTZTimestampDefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TZTimestampDef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTZTimestampDefObj newInstance();

	/**
	 *	Instantiate a new TZTimestampDef edition of the specified TZTimestampDef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTZTimestampDefEditObj newEditInstance( ICFBamTZTimestampDefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTZTimestampDefObj realiseTZTimestampDef( ICFBamTZTimestampDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTZTimestampDef( ICFBamTZTimestampDefObj Obj );
	void forgetTZTimestampDef( ICFBamTZTimestampDefObj Obj, boolean forgetSubObjects );
	void forgetTZTimestampDefByIdIdx( long TenantId,
		long Id );

	void forgetTZTimestampDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetTZTimestampDefByValTentIdx( long TenantId );

	void forgetTZTimestampDefByScopeIdx( long TenantId,
		long ScopeId );

	void forgetTZTimestampDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTZTimestampDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetTZTimestampDefByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetTZTimestampDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetTZTimestampDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamTZTimestampDefObj createTZTimestampDef( ICFBamTZTimestampDefObj Obj );

	/**
	 *	Read a TZTimestampDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TZTimestampDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTZTimestampDefObj readTZTimestampDef( CFBamValuePKey pkey );

	/**
	 *	Read a TZTimestampDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TZTimestampDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTZTimestampDefObj readTZTimestampDef( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTZTimestampDefObj lockTZTimestampDef( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the TZTimestampDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamTZTimestampDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTZTimestampDefObj> readAllTZTimestampDef();

	/**
	 *	Return a sorted map of all the TZTimestampDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamTZTimestampDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTZTimestampDefObj> readAllTZTimestampDef( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZTimestampDefObj readTZTimestampDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZTimestampDefObj readTZTimestampDefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZTimestampDefObj readTZTimestampDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZTimestampDefObj readTZTimestampDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampDefObj> readTZTimestampDefByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamTZTimestampDefObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampDefObj> readTZTimestampDefByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampDefObj> readTZTimestampDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamTZTimestampDefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampDefObj> readTZTimestampDefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampDefObj> readTZTimestampDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamTZTimestampDefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampDefObj> readTZTimestampDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampDefObj> readTZTimestampDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTZTimestampDefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampDefObj> readTZTimestampDefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampDefObj> readTZTimestampDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamTZTimestampDefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampDefObj> readTZTimestampDefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampDefObj> readTZTimestampDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTZTimestampDefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampDefObj> readTZTimestampDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampDefObj> readTZTimestampDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamTZTimestampDefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampDefObj> readTZTimestampDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTZTimestampDefObj updateTZTimestampDef( ICFBamTZTimestampDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTZTimestampDef( ICFBamTZTimestampDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZTimestampDef key attribute of the instance generating the id.
	 */
	void deleteTZTimestampDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZTimestampDef key attribute of the instance generating the id.
	 */
	void deleteTZTimestampDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 */
	void deleteTZTimestampDefByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampDef key attribute of the instance generating the id.
	 */
	void deleteTZTimestampDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZTimestampDef key attribute of the instance generating the id.
	 */
	void deleteTZTimestampDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimestampDef key attribute of the instance generating the id.
	 */
	void deleteTZTimestampDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimestampDef key attribute of the instance generating the id.
	 */
	void deleteTZTimestampDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimestampDef key attribute of the instance generating the id.
	 */
	void deleteTZTimestampDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimestampDef key attribute of the instance generating the id.
	 */
	void deleteTZTimestampDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the CFBamTZTimestampDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZTimestampDefObj refreshed cache instance.
	 */
	ICFBamTZTimestampDefObj moveUpTZTimestampDef( ICFBamTZTimestampDefObj Obj );

	/**
	 *	Move the CFBamTZTimestampDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZTimestampDefObj refreshed cache instance.
	 */
	ICFBamTZTimestampDefObj moveDownTZTimestampDef( ICFBamTZTimestampDefObj Obj );
}
