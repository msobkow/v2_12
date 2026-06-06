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

public interface ICFBamDateDefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new DateDef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamDateDefObj newInstance();

	/**
	 *	Instantiate a new DateDef edition of the specified DateDef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamDateDefEditObj newEditInstance( ICFBamDateDefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamDateDefObj realiseDateDef( ICFBamDateDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetDateDef( ICFBamDateDefObj Obj );
	void forgetDateDef( ICFBamDateDefObj Obj, boolean forgetSubObjects );
	void forgetDateDefByIdIdx( long TenantId,
		long Id );

	void forgetDateDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetDateDefByValTentIdx( long TenantId );

	void forgetDateDefByScopeIdx( long TenantId,
		long ScopeId );

	void forgetDateDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetDateDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetDateDefByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetDateDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetDateDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamDateDefObj createDateDef( ICFBamDateDefObj Obj );

	/**
	 *	Read a DateDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DateDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamDateDefObj readDateDef( CFBamValuePKey pkey );

	/**
	 *	Read a DateDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DateDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamDateDefObj readDateDef( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamDateDefObj lockDateDef( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the DateDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamDateDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamDateDefObj> readAllDateDef();

	/**
	 *	Return a sorted map of all the DateDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamDateDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamDateDefObj> readAllDateDef( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamDateDefObj readDateDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamDateDefObj readDateDefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DateDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamDateDefObj readDateDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DateDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamDateDefObj readDateDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateDefObj> readDateDefByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamDateDefObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateDefObj> readDateDefByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateDefObj> readDateDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamDateDefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateDefObj> readDateDefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateDefObj> readDateDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamDateDefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateDefObj> readDateDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateDefObj> readDateDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamDateDefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateDefObj> readDateDefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateDefObj> readDateDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamDateDefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateDefObj> readDateDefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateDefObj> readDateDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamDateDefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateDefObj> readDateDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateDefObj> readDateDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamDateDefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateDefObj> readDateDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamDateDefObj updateDateDef( ICFBamDateDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDateDef( ICFBamDateDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DateDef key attribute of the instance generating the id.
	 */
	void deleteDateDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DateDef key attribute of the instance generating the id.
	 */
	void deleteDateDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateDef key attribute of the instance generating the id.
	 */
	void deleteDateDefByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateDef key attribute of the instance generating the id.
	 */
	void deleteDateDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DateDef key attribute of the instance generating the id.
	 */
	void deleteDateDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DateDef key attribute of the instance generating the id.
	 */
	void deleteDateDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DateDef key attribute of the instance generating the id.
	 */
	void deleteDateDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DateDef key attribute of the instance generating the id.
	 */
	void deleteDateDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DateDef key attribute of the instance generating the id.
	 */
	void deleteDateDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the CFBamDateDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamDateDefObj refreshed cache instance.
	 */
	ICFBamDateDefObj moveUpDateDef( ICFBamDateDefObj Obj );

	/**
	 *	Move the CFBamDateDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamDateDefObj refreshed cache instance.
	 */
	ICFBamDateDefObj moveDownDateDef( ICFBamDateDefObj Obj );
}
