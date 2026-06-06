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

public interface ICFBamUInt16ColTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new UInt16Col instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamUInt16ColObj newInstance();

	/**
	 *	Instantiate a new UInt16Col edition of the specified UInt16Col instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamUInt16ColEditObj newEditInstance( ICFBamUInt16ColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamUInt16ColObj realiseUInt16Col( ICFBamUInt16ColObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetUInt16Col( ICFBamUInt16ColObj Obj );
	void forgetUInt16Col( ICFBamUInt16ColObj Obj, boolean forgetSubObjects );
	void forgetUInt16ColByIdIdx( long TenantId,
		long Id );

	void forgetUInt16ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetUInt16ColByValTentIdx( long TenantId );

	void forgetUInt16ColByScopeIdx( long TenantId,
		long ScopeId );

	void forgetUInt16ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetUInt16ColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetUInt16ColByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetUInt16ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetUInt16ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetUInt16ColByTableIdx( long TenantId,
		long TableId );


	/**
	 *	Internal use only.
	 */
	ICFBamUInt16ColObj createUInt16Col( ICFBamUInt16ColObj Obj );

	/**
	 *	Read a UInt16Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UInt16Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamUInt16ColObj readUInt16Col( CFBamValuePKey pkey );

	/**
	 *	Read a UInt16Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UInt16Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamUInt16ColObj readUInt16Col( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamUInt16ColObj lockUInt16Col( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the UInt16Col-derived instances in the database.
	 *
	 *	@return	List of ICFBamUInt16ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamUInt16ColObj> readAllUInt16Col();

	/**
	 *	Return a sorted map of all the UInt16Col-derived instances in the database.
	 *
	 *	@return	List of ICFBamUInt16ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamUInt16ColObj> readAllUInt16Col( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt16ColObj readUInt16ColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt16ColObj readUInt16ColByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt16ColObj readUInt16ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt16ColObj readUInt16ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16ColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16ColObj> readUInt16ColByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamUInt16ColObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16ColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16ColObj> readUInt16ColByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16ColObj> readUInt16ColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamUInt16ColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16ColObj> readUInt16ColByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16ColObj> readUInt16ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamUInt16ColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16ColObj> readUInt16ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16ColObj> readUInt16ColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamUInt16ColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16ColObj> readUInt16ColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16ColObj> readUInt16ColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamUInt16ColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16ColObj> readUInt16ColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16ColObj> readUInt16ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamUInt16ColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16ColObj> readUInt16ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16ColObj> readUInt16ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamUInt16ColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16ColObj> readUInt16ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamUInt16ColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16ColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16ColObj> readUInt16ColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamUInt16ColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16ColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16ColObj> readUInt16ColByTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamUInt16ColObj updateUInt16Col( ICFBamUInt16ColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteUInt16Col( ICFBamUInt16ColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UInt16Col key attribute of the instance generating the id.
	 */
	void deleteUInt16ColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UInt16Col key attribute of the instance generating the id.
	 */
	void deleteUInt16ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 */
	void deleteUInt16ColByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Col key attribute of the instance generating the id.
	 */
	void deleteUInt16ColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UInt16Col key attribute of the instance generating the id.
	 */
	void deleteUInt16ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt16Col key attribute of the instance generating the id.
	 */
	void deleteUInt16ColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt16Col key attribute of the instance generating the id.
	 */
	void deleteUInt16ColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt16Col key attribute of the instance generating the id.
	 */
	void deleteUInt16ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt16Col key attribute of the instance generating the id.
	 */
	void deleteUInt16ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Col key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The UInt16Col key attribute of the instance generating the id.
	 */
	void deleteUInt16ColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Move the CFBamUInt16ColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamUInt16ColObj refreshed cache instance.
	 */
	ICFBamUInt16ColObj moveUpUInt16Col( ICFBamUInt16ColObj Obj );

	/**
	 *	Move the CFBamUInt16ColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamUInt16ColObj refreshed cache instance.
	 */
	ICFBamUInt16ColObj moveDownUInt16Col( ICFBamUInt16ColObj Obj );
}
