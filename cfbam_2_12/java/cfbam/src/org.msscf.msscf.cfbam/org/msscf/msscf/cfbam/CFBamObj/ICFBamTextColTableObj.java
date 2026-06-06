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

public interface ICFBamTextColTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TextCol instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTextColObj newInstance();

	/**
	 *	Instantiate a new TextCol edition of the specified TextCol instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTextColEditObj newEditInstance( ICFBamTextColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTextColObj realiseTextCol( ICFBamTextColObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTextCol( ICFBamTextColObj Obj );
	void forgetTextCol( ICFBamTextColObj Obj, boolean forgetSubObjects );
	void forgetTextColByIdIdx( long TenantId,
		long Id );

	void forgetTextColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetTextColByValTentIdx( long TenantId );

	void forgetTextColByScopeIdx( long TenantId,
		long ScopeId );

	void forgetTextColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTextColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetTextColByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetTextColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetTextColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetTextColByTableIdx( long TenantId,
		long TableId );


	/**
	 *	Internal use only.
	 */
	ICFBamTextColObj createTextCol( ICFBamTextColObj Obj );

	/**
	 *	Read a TextCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TextCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTextColObj readTextCol( CFBamValuePKey pkey );

	/**
	 *	Read a TextCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TextCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTextColObj readTextCol( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTextColObj lockTextCol( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the TextCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamTextColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTextColObj> readAllTextCol();

	/**
	 *	Return a sorted map of all the TextCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamTextColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTextColObj> readAllTextCol( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTextColObj readTextColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTextColObj readTextColByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTextColObj readTextColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTextColObj readTextColByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextColObj> readTextColByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamTextColObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextColObj> readTextColByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextColObj> readTextColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamTextColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextColObj> readTextColByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextColObj> readTextColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamTextColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextColObj> readTextColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextColObj> readTextColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTextColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextColObj> readTextColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextColObj> readTextColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamTextColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextColObj> readTextColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextColObj> readTextColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTextColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextColObj> readTextColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextColObj> readTextColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamTextColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextColObj> readTextColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTextColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextColObj> readTextColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamTextColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextColObj> readTextColByTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTextColObj updateTextCol( ICFBamTextColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTextCol( ICFBamTextColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TextCol key attribute of the instance generating the id.
	 */
	void deleteTextColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TextCol key attribute of the instance generating the id.
	 */
	void deleteTextColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 */
	void deleteTextColByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextCol key attribute of the instance generating the id.
	 */
	void deleteTextColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TextCol key attribute of the instance generating the id.
	 */
	void deleteTextColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TextCol key attribute of the instance generating the id.
	 */
	void deleteTextColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TextCol key attribute of the instance generating the id.
	 */
	void deleteTextColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TextCol key attribute of the instance generating the id.
	 */
	void deleteTextColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TextCol key attribute of the instance generating the id.
	 */
	void deleteTextColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The TextCol key attribute of the instance generating the id.
	 */
	void deleteTextColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Move the CFBamTextColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTextColObj refreshed cache instance.
	 */
	ICFBamTextColObj moveUpTextCol( ICFBamTextColObj Obj );

	/**
	 *	Move the CFBamTextColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTextColObj refreshed cache instance.
	 */
	ICFBamTextColObj moveDownTextCol( ICFBamTextColObj Obj );
}
