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

public interface ICFBamTextDefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TextDef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTextDefObj newInstance();

	/**
	 *	Instantiate a new TextDef edition of the specified TextDef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTextDefEditObj newEditInstance( ICFBamTextDefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTextDefObj realiseTextDef( ICFBamTextDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTextDef( ICFBamTextDefObj Obj );
	void forgetTextDef( ICFBamTextDefObj Obj, boolean forgetSubObjects );
	void forgetTextDefByIdIdx( long TenantId,
		long Id );

	void forgetTextDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetTextDefByValTentIdx( long TenantId );

	void forgetTextDefByScopeIdx( long TenantId,
		long ScopeId );

	void forgetTextDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTextDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetTextDefByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetTextDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetTextDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamTextDefObj createTextDef( ICFBamTextDefObj Obj );

	/**
	 *	Read a TextDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TextDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTextDefObj readTextDef( CFBamValuePKey pkey );

	/**
	 *	Read a TextDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TextDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTextDefObj readTextDef( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTextDefObj lockTextDef( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the TextDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamTextDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTextDefObj> readAllTextDef();

	/**
	 *	Return a sorted map of all the TextDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamTextDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTextDefObj> readAllTextDef( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTextDefObj readTextDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTextDefObj readTextDefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTextDefObj readTextDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTextDefObj readTextDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextDefObj> readTextDefByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamTextDefObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextDefObj> readTextDefByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextDefObj> readTextDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamTextDefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextDefObj> readTextDefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextDefObj> readTextDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamTextDefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextDefObj> readTextDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextDefObj> readTextDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTextDefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextDefObj> readTextDefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextDefObj> readTextDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamTextDefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextDefObj> readTextDefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextDefObj> readTextDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTextDefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextDefObj> readTextDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextDefObj> readTextDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamTextDefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextDefObj> readTextDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTextDefObj updateTextDef( ICFBamTextDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTextDef( ICFBamTextDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TextDef key attribute of the instance generating the id.
	 */
	void deleteTextDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TextDef key attribute of the instance generating the id.
	 */
	void deleteTextDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextDef key attribute of the instance generating the id.
	 */
	void deleteTextDefByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextDef key attribute of the instance generating the id.
	 */
	void deleteTextDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TextDef key attribute of the instance generating the id.
	 */
	void deleteTextDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TextDef key attribute of the instance generating the id.
	 */
	void deleteTextDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TextDef key attribute of the instance generating the id.
	 */
	void deleteTextDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TextDef key attribute of the instance generating the id.
	 */
	void deleteTextDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TextDef key attribute of the instance generating the id.
	 */
	void deleteTextDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the CFBamTextDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTextDefObj refreshed cache instance.
	 */
	ICFBamTextDefObj moveUpTextDef( ICFBamTextDefObj Obj );

	/**
	 *	Move the CFBamTextDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTextDefObj refreshed cache instance.
	 */
	ICFBamTextDefObj moveDownTextDef( ICFBamTextDefObj Obj );
}
