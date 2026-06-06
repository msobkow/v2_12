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

public interface ICFBamNmTokenDefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new NmTokenDef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamNmTokenDefObj newInstance();

	/**
	 *	Instantiate a new NmTokenDef edition of the specified NmTokenDef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamNmTokenDefEditObj newEditInstance( ICFBamNmTokenDefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamNmTokenDefObj realiseNmTokenDef( ICFBamNmTokenDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetNmTokenDef( ICFBamNmTokenDefObj Obj );
	void forgetNmTokenDef( ICFBamNmTokenDefObj Obj, boolean forgetSubObjects );
	void forgetNmTokenDefByIdIdx( long TenantId,
		long Id );

	void forgetNmTokenDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetNmTokenDefByValTentIdx( long TenantId );

	void forgetNmTokenDefByScopeIdx( long TenantId,
		long ScopeId );

	void forgetNmTokenDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetNmTokenDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetNmTokenDefByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetNmTokenDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetNmTokenDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamNmTokenDefObj createNmTokenDef( ICFBamNmTokenDefObj Obj );

	/**
	 *	Read a NmTokenDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The NmTokenDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamNmTokenDefObj readNmTokenDef( CFBamValuePKey pkey );

	/**
	 *	Read a NmTokenDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The NmTokenDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamNmTokenDefObj readNmTokenDef( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamNmTokenDefObj lockNmTokenDef( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the NmTokenDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamNmTokenDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamNmTokenDefObj> readAllNmTokenDef();

	/**
	 *	Return a sorted map of all the NmTokenDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamNmTokenDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamNmTokenDefObj> readAllNmTokenDef( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamNmTokenDefObj readNmTokenDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamNmTokenDefObj readNmTokenDefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamNmTokenDefObj readNmTokenDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamNmTokenDefObj readNmTokenDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokenDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenDefObj> readNmTokenDefByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamNmTokenDefObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokenDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenDefObj> readNmTokenDefByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokenDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenDefObj> readNmTokenDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamNmTokenDefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokenDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenDefObj> readNmTokenDefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokenDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenDefObj> readNmTokenDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamNmTokenDefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokenDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenDefObj> readNmTokenDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokenDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenDefObj> readNmTokenDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamNmTokenDefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokenDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenDefObj> readNmTokenDefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokenDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenDefObj> readNmTokenDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamNmTokenDefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokenDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenDefObj> readNmTokenDefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokenDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenDefObj> readNmTokenDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamNmTokenDefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokenDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenDefObj> readNmTokenDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokenDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenDefObj> readNmTokenDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamNmTokenDefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokenDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenDefObj> readNmTokenDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamNmTokenDefObj updateNmTokenDef( ICFBamNmTokenDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteNmTokenDef( ICFBamNmTokenDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The NmTokenDef key attribute of the instance generating the id.
	 */
	void deleteNmTokenDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The NmTokenDef key attribute of the instance generating the id.
	 */
	void deleteNmTokenDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokenDef key attribute of the instance generating the id.
	 */
	void deleteNmTokenDefByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenDef key attribute of the instance generating the id.
	 */
	void deleteNmTokenDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The NmTokenDef key attribute of the instance generating the id.
	 */
	void deleteNmTokenDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokenDef key attribute of the instance generating the id.
	 */
	void deleteNmTokenDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokenDef key attribute of the instance generating the id.
	 */
	void deleteNmTokenDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokenDef key attribute of the instance generating the id.
	 */
	void deleteNmTokenDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokenDef key attribute of the instance generating the id.
	 */
	void deleteNmTokenDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the CFBamNmTokenDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamNmTokenDefObj refreshed cache instance.
	 */
	ICFBamNmTokenDefObj moveUpNmTokenDef( ICFBamNmTokenDefObj Obj );

	/**
	 *	Move the CFBamNmTokenDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamNmTokenDefObj refreshed cache instance.
	 */
	ICFBamNmTokenDefObj moveDownNmTokenDef( ICFBamNmTokenDefObj Obj );
}
