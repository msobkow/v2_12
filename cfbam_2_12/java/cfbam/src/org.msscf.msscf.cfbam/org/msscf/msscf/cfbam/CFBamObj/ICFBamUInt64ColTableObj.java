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

public interface ICFBamUInt64ColTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new UInt64Col instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamUInt64ColObj newInstance();

	/**
	 *	Instantiate a new UInt64Col edition of the specified UInt64Col instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamUInt64ColEditObj newEditInstance( ICFBamUInt64ColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamUInt64ColObj realiseUInt64Col( ICFBamUInt64ColObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetUInt64Col( ICFBamUInt64ColObj Obj );
	void forgetUInt64Col( ICFBamUInt64ColObj Obj, boolean forgetSubObjects );
	void forgetUInt64ColByIdIdx( long TenantId,
		long Id );

	void forgetUInt64ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetUInt64ColByValTentIdx( long TenantId );

	void forgetUInt64ColByScopeIdx( long TenantId,
		long ScopeId );

	void forgetUInt64ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetUInt64ColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetUInt64ColByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetUInt64ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetUInt64ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetUInt64ColByTableIdx( long TenantId,
		long TableId );


	/**
	 *	Internal use only.
	 */
	ICFBamUInt64ColObj createUInt64Col( ICFBamUInt64ColObj Obj );

	/**
	 *	Read a UInt64Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UInt64Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamUInt64ColObj readUInt64Col( CFBamValuePKey pkey );

	/**
	 *	Read a UInt64Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UInt64Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamUInt64ColObj readUInt64Col( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamUInt64ColObj lockUInt64Col( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the UInt64Col-derived instances in the database.
	 *
	 *	@return	List of ICFBamUInt64ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamUInt64ColObj> readAllUInt64Col();

	/**
	 *	Return a sorted map of all the UInt64Col-derived instances in the database.
	 *
	 *	@return	List of ICFBamUInt64ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamUInt64ColObj> readAllUInt64Col( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt64ColObj readUInt64ColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt64ColObj readUInt64ColByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt64ColObj readUInt64ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt64ColObj readUInt64ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt64ColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt64ColObj> readUInt64ColByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamUInt64ColObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt64ColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt64ColObj> readUInt64ColByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt64ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt64ColObj> readUInt64ColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamUInt64ColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt64ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt64ColObj> readUInt64ColByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt64ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt64ColObj> readUInt64ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamUInt64ColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt64ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt64ColObj> readUInt64ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt64ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt64ColObj> readUInt64ColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamUInt64ColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt64ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt64ColObj> readUInt64ColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt64ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt64ColObj> readUInt64ColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamUInt64ColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt64ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt64ColObj> readUInt64ColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt64ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt64ColObj> readUInt64ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamUInt64ColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt64ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt64ColObj> readUInt64ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt64ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt64ColObj> readUInt64ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamUInt64ColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt64ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt64ColObj> readUInt64ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamUInt64ColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt64ColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt64ColObj> readUInt64ColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamUInt64ColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt64ColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt64ColObj> readUInt64ColByTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamUInt64ColObj updateUInt64Col( ICFBamUInt64ColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteUInt64Col( ICFBamUInt64ColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UInt64Col key attribute of the instance generating the id.
	 */
	void deleteUInt64ColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UInt64Col key attribute of the instance generating the id.
	 */
	void deleteUInt64ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 */
	void deleteUInt64ColByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt64Col key attribute of the instance generating the id.
	 */
	void deleteUInt64ColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UInt64Col key attribute of the instance generating the id.
	 */
	void deleteUInt64ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt64Col key attribute of the instance generating the id.
	 */
	void deleteUInt64ColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt64Col key attribute of the instance generating the id.
	 */
	void deleteUInt64ColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt64Col key attribute of the instance generating the id.
	 */
	void deleteUInt64ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt64Col key attribute of the instance generating the id.
	 */
	void deleteUInt64ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The UInt64Col key attribute of the instance generating the id.
	 */
	void deleteUInt64ColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Move the CFBamUInt64ColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamUInt64ColObj refreshed cache instance.
	 */
	ICFBamUInt64ColObj moveUpUInt64Col( ICFBamUInt64ColObj Obj );

	/**
	 *	Move the CFBamUInt64ColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamUInt64ColObj refreshed cache instance.
	 */
	ICFBamUInt64ColObj moveDownUInt64Col( ICFBamUInt64ColObj Obj );
}
