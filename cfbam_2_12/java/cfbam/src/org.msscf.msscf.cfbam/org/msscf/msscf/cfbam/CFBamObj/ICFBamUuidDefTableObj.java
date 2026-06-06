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

public interface ICFBamUuidDefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new UuidDef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamUuidDefObj newInstance();

	/**
	 *	Instantiate a new UuidDef edition of the specified UuidDef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamUuidDefEditObj newEditInstance( ICFBamUuidDefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamUuidDefObj realiseUuidDef( ICFBamUuidDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetUuidDef( ICFBamUuidDefObj Obj );
	void forgetUuidDef( ICFBamUuidDefObj Obj, boolean forgetSubObjects );
	void forgetUuidDefByIdIdx( long TenantId,
		long Id );

	void forgetUuidDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetUuidDefByValTentIdx( long TenantId );

	void forgetUuidDefByScopeIdx( long TenantId,
		long ScopeId );

	void forgetUuidDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetUuidDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetUuidDefByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetUuidDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetUuidDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamUuidDefObj createUuidDef( ICFBamUuidDefObj Obj );

	/**
	 *	Read a UuidDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UuidDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamUuidDefObj readUuidDef( CFBamValuePKey pkey );

	/**
	 *	Read a UuidDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UuidDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamUuidDefObj readUuidDef( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamUuidDefObj lockUuidDef( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the UuidDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamUuidDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamUuidDefObj> readAllUuidDef();

	/**
	 *	Return a sorted map of all the UuidDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamUuidDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamUuidDefObj> readAllUuidDef( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamUuidDefObj readUuidDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamUuidDefObj readUuidDefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamUuidDefObj readUuidDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamUuidDefObj readUuidDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidDefObj> readUuidDefByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamUuidDefObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidDefObj> readUuidDefByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidDefObj> readUuidDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamUuidDefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidDefObj> readUuidDefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidDefObj> readUuidDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamUuidDefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidDefObj> readUuidDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidDefObj> readUuidDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamUuidDefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidDefObj> readUuidDefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidDefObj> readUuidDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamUuidDefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidDefObj> readUuidDefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidDefObj> readUuidDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamUuidDefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidDefObj> readUuidDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidDefObj> readUuidDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamUuidDefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidDefObj> readUuidDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamUuidDefObj updateUuidDef( ICFBamUuidDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteUuidDef( ICFBamUuidDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UuidDef key attribute of the instance generating the id.
	 */
	void deleteUuidDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UuidDef key attribute of the instance generating the id.
	 */
	void deleteUuidDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidDef key attribute of the instance generating the id.
	 */
	void deleteUuidDefByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidDef key attribute of the instance generating the id.
	 */
	void deleteUuidDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UuidDef key attribute of the instance generating the id.
	 */
	void deleteUuidDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidDef key attribute of the instance generating the id.
	 */
	void deleteUuidDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidDef key attribute of the instance generating the id.
	 */
	void deleteUuidDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidDef key attribute of the instance generating the id.
	 */
	void deleteUuidDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidDef key attribute of the instance generating the id.
	 */
	void deleteUuidDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the CFBamUuidDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamUuidDefObj refreshed cache instance.
	 */
	ICFBamUuidDefObj moveUpUuidDef( ICFBamUuidDefObj Obj );

	/**
	 *	Move the CFBamUuidDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamUuidDefObj refreshed cache instance.
	 */
	ICFBamUuidDefObj moveDownUuidDef( ICFBamUuidDefObj Obj );
}
