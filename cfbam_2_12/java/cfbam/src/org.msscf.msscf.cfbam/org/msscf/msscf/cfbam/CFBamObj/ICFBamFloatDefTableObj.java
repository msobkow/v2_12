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

public interface ICFBamFloatDefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new FloatDef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamFloatDefObj newInstance();

	/**
	 *	Instantiate a new FloatDef edition of the specified FloatDef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamFloatDefEditObj newEditInstance( ICFBamFloatDefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamFloatDefObj realiseFloatDef( ICFBamFloatDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetFloatDef( ICFBamFloatDefObj Obj );
	void forgetFloatDef( ICFBamFloatDefObj Obj, boolean forgetSubObjects );
	void forgetFloatDefByIdIdx( long TenantId,
		long Id );

	void forgetFloatDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetFloatDefByValTentIdx( long TenantId );

	void forgetFloatDefByScopeIdx( long TenantId,
		long ScopeId );

	void forgetFloatDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetFloatDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetFloatDefByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetFloatDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetFloatDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamFloatDefObj createFloatDef( ICFBamFloatDefObj Obj );

	/**
	 *	Read a FloatDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The FloatDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamFloatDefObj readFloatDef( CFBamValuePKey pkey );

	/**
	 *	Read a FloatDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The FloatDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamFloatDefObj readFloatDef( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamFloatDefObj lockFloatDef( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the FloatDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamFloatDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamFloatDefObj> readAllFloatDef();

	/**
	 *	Return a sorted map of all the FloatDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamFloatDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamFloatDefObj> readAllFloatDef( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamFloatDefObj readFloatDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamFloatDefObj readFloatDefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamFloatDefObj readFloatDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamFloatDefObj readFloatDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamFloatDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamFloatDefObj> readFloatDefByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamFloatDefObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamFloatDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamFloatDefObj> readFloatDefByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamFloatDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamFloatDefObj> readFloatDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamFloatDefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamFloatDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamFloatDefObj> readFloatDefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamFloatDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamFloatDefObj> readFloatDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamFloatDefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamFloatDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamFloatDefObj> readFloatDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamFloatDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamFloatDefObj> readFloatDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamFloatDefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamFloatDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamFloatDefObj> readFloatDefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamFloatDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamFloatDefObj> readFloatDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamFloatDefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamFloatDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamFloatDefObj> readFloatDefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamFloatDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamFloatDefObj> readFloatDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamFloatDefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamFloatDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamFloatDefObj> readFloatDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamFloatDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamFloatDefObj> readFloatDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamFloatDefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamFloatDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamFloatDefObj> readFloatDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamFloatDefObj updateFloatDef( ICFBamFloatDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteFloatDef( ICFBamFloatDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The FloatDef key attribute of the instance generating the id.
	 */
	void deleteFloatDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The FloatDef key attribute of the instance generating the id.
	 */
	void deleteFloatDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The FloatDef key attribute of the instance generating the id.
	 */
	void deleteFloatDefByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The FloatDef key attribute of the instance generating the id.
	 */
	void deleteFloatDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The FloatDef key attribute of the instance generating the id.
	 */
	void deleteFloatDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The FloatDef key attribute of the instance generating the id.
	 */
	void deleteFloatDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The FloatDef key attribute of the instance generating the id.
	 */
	void deleteFloatDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The FloatDef key attribute of the instance generating the id.
	 */
	void deleteFloatDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The FloatDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The FloatDef key attribute of the instance generating the id.
	 */
	void deleteFloatDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the CFBamFloatDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamFloatDefObj refreshed cache instance.
	 */
	ICFBamFloatDefObj moveUpFloatDef( ICFBamFloatDefObj Obj );

	/**
	 *	Move the CFBamFloatDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamFloatDefObj refreshed cache instance.
	 */
	ICFBamFloatDefObj moveDownFloatDef( ICFBamFloatDefObj Obj );
}
