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

public interface ICFBamPopSubDep2TableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new PopSubDep2 instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPopSubDep2Obj newInstance();

	/**
	 *	Instantiate a new PopSubDep2 edition of the specified PopSubDep2 instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPopSubDep2EditObj newEditInstance( ICFBamPopSubDep2Obj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPopSubDep2Obj realisePopSubDep2( ICFBamPopSubDep2Obj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetPopSubDep2( ICFBamPopSubDep2Obj Obj );
	void forgetPopSubDep2( ICFBamPopSubDep2Obj Obj, boolean forgetSubObjects );
	void forgetPopSubDep2ByIdIdx( long TenantId,
		long Id );

	void forgetPopSubDep2ByTenantIdx( long TenantId );

	void forgetPopSubDep2ByRelationIdx( long RelationTenantId,
		long RelationId );

	void forgetPopSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetPopSubDep2ByPopSubDep1Idx( long PopSubDep1TenantId,
		long PopSubDep1Id );

	void forgetPopSubDep2ByUNameIdx( long PopSubDep1TenantId,
		long PopSubDep1Id,
		String Name );


	/**
	 *	Internal use only.
	 */
	ICFBamPopSubDep2Obj createPopSubDep2( ICFBamPopSubDep2Obj Obj );

	/**
	 *	Read a PopSubDep2-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The PopSubDep2-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPopSubDep2Obj readPopSubDep2( CFBamScopePKey pkey );

	/**
	 *	Read a PopSubDep2-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The PopSubDep2-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPopSubDep2Obj readPopSubDep2( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamPopSubDep2Obj lockPopSubDep2( CFBamScopePKey pkey );

	/**
	 *	Return a sorted list of all the PopSubDep2-derived instances in the database.
	 *
	 *	@return	List of ICFBamPopSubDep2Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPopSubDep2Obj> readAllPopSubDep2();

	/**
	 *	Return a sorted map of all the PopSubDep2-derived instances in the database.
	 *
	 *	@return	List of ICFBamPopSubDep2Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPopSubDep2Obj> readAllPopSubDep2( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPopSubDep2Obj readPopSubDep2ByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPopSubDep2Obj readPopSubDep2ByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopSubDep2Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopSubDep2Obj> readPopSubDep2ByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamPopSubDep2Obj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopSubDep2Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopSubDep2Obj> readPopSubDep2ByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPopDepObj instances sorted by their primary keys for the duplicate RelationIdx key.
	 *
	 *	@param	argRelationTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopSubDep2Obj cached instances sorted by their primary keys for the duplicate RelationIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopSubDep2Obj> readPopSubDep2ByRelationIdx( long RelationTenantId,
		long RelationId );

	/**
	 *	Get the map of CFBamPopSubDep2Obj instances sorted by their primary keys for the duplicate RelationIdx key.
	 *
	 *	@param	argRelationTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopSubDep2Obj cached instances sorted by their primary keys for the duplicate RelationIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopSubDep2Obj> readPopSubDep2ByRelationIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPopDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopSubDep2Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopSubDep2Obj> readPopSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamPopSubDep2Obj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopSubDep2Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopSubDep2Obj> readPopSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPopSubDep2Obj instances sorted by their primary keys for the duplicate PopSubDep1Idx key.
	 *
	 *	@param	argPopSubDep1TenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argPopSubDep1Id	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopSubDep2Obj cached instances sorted by their primary keys for the duplicate PopSubDep1Idx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopSubDep2Obj> readPopSubDep2ByPopSubDep1Idx( long PopSubDep1TenantId,
		long PopSubDep1Id );

	/**
	 *	Get the map of CFBamPopSubDep2Obj instances sorted by their primary keys for the duplicate PopSubDep1Idx key.
	 *
	 *	@param	argPopSubDep1TenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argPopSubDep1Id	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopSubDep2Obj cached instances sorted by their primary keys for the duplicate PopSubDep1Idx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopSubDep2Obj> readPopSubDep2ByPopSubDep1Idx( long PopSubDep1TenantId,
		long PopSubDep1Id,
		boolean forceRead );

	/**
	 *	Get the CFBamPopSubDep2Obj instance for the unique UNameIdx key.
	 *
	 *	@param	argPopSubDep1TenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argPopSubDep1Id	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPopSubDep2Obj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPopSubDep2Obj readPopSubDep2ByUNameIdx(long PopSubDep1TenantId,
		long PopSubDep1Id,
		String Name );

	/**
	 *	Get the CFBamPopSubDep2Obj instance for the unique UNameIdx key.
	 *
	 *	@param	argPopSubDep1TenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argPopSubDep1Id	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPopSubDep2Obj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPopSubDep2Obj readPopSubDep2ByUNameIdx(long PopSubDep1TenantId,
		long PopSubDep1Id,
		String Name,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamPopSubDep2Obj updatePopSubDep2( ICFBamPopSubDep2Obj Obj );

	/**
	 *	Internal use only.
	 */
	void deletePopSubDep2( ICFBamPopSubDep2Obj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The PopSubDep2 key attribute of the instance generating the id.
	 */
	void deletePopSubDep2ByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 */
	void deletePopSubDep2ByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argRelationTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The PopSubDep2 key attribute of the instance generating the id.
	 */
	void deletePopSubDep2ByRelationIdx( long RelationTenantId,
		long RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The PopSubDep2 key attribute of the instance generating the id.
	 */
	void deletePopSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPopSubDep1TenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argPopSubDep1Id	The PopSubDep2 key attribute of the instance generating the id.
	 */
	void deletePopSubDep2ByPopSubDep1Idx( long PopSubDep1TenantId,
		long PopSubDep1Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPopSubDep1TenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argPopSubDep1Id	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The PopSubDep2 key attribute of the instance generating the id.
	 */
	void deletePopSubDep2ByUNameIdx(long PopSubDep1TenantId,
		long PopSubDep1Id,
		String Name );
}
