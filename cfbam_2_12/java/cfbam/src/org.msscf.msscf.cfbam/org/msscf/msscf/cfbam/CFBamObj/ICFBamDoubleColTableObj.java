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

public interface ICFBamDoubleColTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new DoubleCol instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamDoubleColObj newInstance();

	/**
	 *	Instantiate a new DoubleCol edition of the specified DoubleCol instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamDoubleColEditObj newEditInstance( ICFBamDoubleColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamDoubleColObj realiseDoubleCol( ICFBamDoubleColObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetDoubleCol( ICFBamDoubleColObj Obj );
	void forgetDoubleCol( ICFBamDoubleColObj Obj, boolean forgetSubObjects );
	void forgetDoubleColByIdIdx( long TenantId,
		long Id );

	void forgetDoubleColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetDoubleColByValTentIdx( long TenantId );

	void forgetDoubleColByScopeIdx( long TenantId,
		long ScopeId );

	void forgetDoubleColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetDoubleColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetDoubleColByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetDoubleColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetDoubleColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetDoubleColByTableIdx( long TenantId,
		long TableId );


	/**
	 *	Internal use only.
	 */
	ICFBamDoubleColObj createDoubleCol( ICFBamDoubleColObj Obj );

	/**
	 *	Read a DoubleCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DoubleCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamDoubleColObj readDoubleCol( CFBamValuePKey pkey );

	/**
	 *	Read a DoubleCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DoubleCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamDoubleColObj readDoubleCol( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamDoubleColObj lockDoubleCol( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the DoubleCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamDoubleColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamDoubleColObj> readAllDoubleCol();

	/**
	 *	Return a sorted map of all the DoubleCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamDoubleColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamDoubleColObj> readAllDoubleCol( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamDoubleColObj readDoubleColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamDoubleColObj readDoubleColByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamDoubleColObj readDoubleColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamDoubleColObj readDoubleColByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleColObj> readDoubleColByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamDoubleColObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleColObj> readDoubleColByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleColObj> readDoubleColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamDoubleColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleColObj> readDoubleColByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleColObj> readDoubleColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamDoubleColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleColObj> readDoubleColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleColObj> readDoubleColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamDoubleColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleColObj> readDoubleColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleColObj> readDoubleColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamDoubleColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleColObj> readDoubleColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleColObj> readDoubleColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamDoubleColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleColObj> readDoubleColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleColObj> readDoubleColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamDoubleColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleColObj> readDoubleColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamDoubleColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleColObj> readDoubleColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamDoubleColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleColObj> readDoubleColByTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamDoubleColObj updateDoubleCol( ICFBamDoubleColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDoubleCol( ICFBamDoubleColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Move the CFBamDoubleColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamDoubleColObj refreshed cache instance.
	 */
	ICFBamDoubleColObj moveUpDoubleCol( ICFBamDoubleColObj Obj );

	/**
	 *	Move the CFBamDoubleColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamDoubleColObj refreshed cache instance.
	 */
	ICFBamDoubleColObj moveDownDoubleCol( ICFBamDoubleColObj Obj );
}
