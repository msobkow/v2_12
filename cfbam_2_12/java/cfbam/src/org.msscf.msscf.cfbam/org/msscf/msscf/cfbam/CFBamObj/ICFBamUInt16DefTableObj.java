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

public interface ICFBamUInt16DefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new UInt16Def instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamUInt16DefObj newInstance();

	/**
	 *	Instantiate a new UInt16Def edition of the specified UInt16Def instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamUInt16DefEditObj newEditInstance( ICFBamUInt16DefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamUInt16DefObj realiseUInt16Def( ICFBamUInt16DefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetUInt16Def( ICFBamUInt16DefObj Obj );
	void forgetUInt16Def( ICFBamUInt16DefObj Obj, boolean forgetSubObjects );
	void forgetUInt16DefByIdIdx( long TenantId,
		long Id );

	void forgetUInt16DefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetUInt16DefByValTentIdx( long TenantId );

	void forgetUInt16DefByScopeIdx( long TenantId,
		long ScopeId );

	void forgetUInt16DefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetUInt16DefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetUInt16DefByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetUInt16DefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetUInt16DefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamUInt16DefObj createUInt16Def( ICFBamUInt16DefObj Obj );

	/**
	 *	Read a UInt16Def-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UInt16Def-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamUInt16DefObj readUInt16Def( CFBamValuePKey pkey );

	/**
	 *	Read a UInt16Def-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UInt16Def-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamUInt16DefObj readUInt16Def( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamUInt16DefObj lockUInt16Def( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the UInt16Def-derived instances in the database.
	 *
	 *	@return	List of ICFBamUInt16DefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamUInt16DefObj> readAllUInt16Def();

	/**
	 *	Return a sorted map of all the UInt16Def-derived instances in the database.
	 *
	 *	@return	List of ICFBamUInt16DefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamUInt16DefObj> readAllUInt16Def( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt16DefObj readUInt16DefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt16DefObj readUInt16DefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt16DefObj readUInt16DefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamUInt16DefObj readUInt16DefByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16DefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16DefObj> readUInt16DefByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamUInt16DefObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16DefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16DefObj> readUInt16DefByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16DefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16DefObj> readUInt16DefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamUInt16DefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16DefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16DefObj> readUInt16DefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16DefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16DefObj> readUInt16DefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamUInt16DefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16DefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16DefObj> readUInt16DefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16DefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16DefObj> readUInt16DefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamUInt16DefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16DefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16DefObj> readUInt16DefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16DefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16DefObj> readUInt16DefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamUInt16DefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16DefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16DefObj> readUInt16DefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16DefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16DefObj> readUInt16DefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamUInt16DefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16DefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16DefObj> readUInt16DefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16DefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16DefObj> readUInt16DefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamUInt16DefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUInt16DefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUInt16DefObj> readUInt16DefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamUInt16DefObj updateUInt16Def( ICFBamUInt16DefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteUInt16Def( ICFBamUInt16DefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UInt16Def key attribute of the instance generating the id.
	 */
	void deleteUInt16DefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UInt16Def key attribute of the instance generating the id.
	 */
	void deleteUInt16DefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Def key attribute of the instance generating the id.
	 */
	void deleteUInt16DefByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Def key attribute of the instance generating the id.
	 */
	void deleteUInt16DefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UInt16Def key attribute of the instance generating the id.
	 */
	void deleteUInt16DefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt16Def key attribute of the instance generating the id.
	 */
	void deleteUInt16DefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt16Def key attribute of the instance generating the id.
	 */
	void deleteUInt16DefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UInt16Def key attribute of the instance generating the id.
	 */
	void deleteUInt16DefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UInt16Def key attribute of the instance generating the id.
	 */
	void deleteUInt16DefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the CFBamUInt16DefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamUInt16DefObj refreshed cache instance.
	 */
	ICFBamUInt16DefObj moveUpUInt16Def( ICFBamUInt16DefObj Obj );

	/**
	 *	Move the CFBamUInt16DefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamUInt16DefObj refreshed cache instance.
	 */
	ICFBamUInt16DefObj moveDownUInt16Def( ICFBamUInt16DefObj Obj );
}
