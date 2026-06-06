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

public interface ICFBamClearSubDep1TableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new ClearSubDep1 instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamClearSubDep1Obj newInstance();

	/**
	 *	Instantiate a new ClearSubDep1 edition of the specified ClearSubDep1 instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamClearSubDep1EditObj newEditInstance( ICFBamClearSubDep1Obj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamClearSubDep1Obj realiseClearSubDep1( ICFBamClearSubDep1Obj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetClearSubDep1( ICFBamClearSubDep1Obj Obj );
	void forgetClearSubDep1( ICFBamClearSubDep1Obj Obj, boolean forgetSubObjects );
	void forgetClearSubDep1ByIdIdx( long TenantId,
		long Id );

	void forgetClearSubDep1ByTenantIdx( long TenantId );

	void forgetClearSubDep1ByClearDepIdx( long TenantId,
		long RelationId );

	void forgetClearSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetClearSubDep1ByClearTopDepIdx( long ClearTopDepTenantId,
		long ClearTopDepId );

	void forgetClearSubDep1ByUNameIdx( long ClearTopDepTenantId,
		long ClearTopDepId,
		String Name );


	/**
	 *	Internal use only.
	 */
	ICFBamClearSubDep1Obj createClearSubDep1( ICFBamClearSubDep1Obj Obj );

	/**
	 *	Read a ClearSubDep1-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ClearSubDep1-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamClearSubDep1Obj readClearSubDep1( CFBamScopePKey pkey );

	/**
	 *	Read a ClearSubDep1-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ClearSubDep1-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamClearSubDep1Obj readClearSubDep1( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamClearSubDep1Obj lockClearSubDep1( CFBamScopePKey pkey );

	/**
	 *	Return a sorted list of all the ClearSubDep1-derived instances in the database.
	 *
	 *	@return	List of ICFBamClearSubDep1Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamClearSubDep1Obj> readAllClearSubDep1();

	/**
	 *	Return a sorted map of all the ClearSubDep1-derived instances in the database.
	 *
	 *	@return	List of ICFBamClearSubDep1Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamClearSubDep1Obj> readAllClearSubDep1( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamClearSubDep1Obj readClearSubDep1ByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamClearSubDep1Obj readClearSubDep1ByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearSubDep1Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearSubDep1Obj> readClearSubDep1ByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamClearSubDep1Obj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearSubDep1Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearSubDep1Obj> readClearSubDep1ByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamClearDepObj instances sorted by their primary keys for the duplicate ClearDepIdx key.
	 *
	 *	@param	argTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearSubDep1Obj cached instances sorted by their primary keys for the duplicate ClearDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearSubDep1Obj> readClearSubDep1ByClearDepIdx( long TenantId,
		long RelationId );

	/**
	 *	Get the map of CFBamClearSubDep1Obj instances sorted by their primary keys for the duplicate ClearDepIdx key.
	 *
	 *	@param	argTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearSubDep1Obj cached instances sorted by their primary keys for the duplicate ClearDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearSubDep1Obj> readClearSubDep1ByClearDepIdx( long TenantId,
		long RelationId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamClearDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearSubDep1Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearSubDep1Obj> readClearSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamClearSubDep1Obj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearSubDep1Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearSubDep1Obj> readClearSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamClearSubDep1Obj instances sorted by their primary keys for the duplicate ClearTopDepIdx key.
	 *
	 *	@param	argClearTopDepTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argClearTopDepId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearSubDep1Obj cached instances sorted by their primary keys for the duplicate ClearTopDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearSubDep1Obj> readClearSubDep1ByClearTopDepIdx( long ClearTopDepTenantId,
		long ClearTopDepId );

	/**
	 *	Get the map of CFBamClearSubDep1Obj instances sorted by their primary keys for the duplicate ClearTopDepIdx key.
	 *
	 *	@param	argClearTopDepTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argClearTopDepId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearSubDep1Obj cached instances sorted by their primary keys for the duplicate ClearTopDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearSubDep1Obj> readClearSubDep1ByClearTopDepIdx( long ClearTopDepTenantId,
		long ClearTopDepId,
		boolean forceRead );

	/**
	 *	Get the CFBamClearSubDep1Obj instance for the unique UNameIdx key.
	 *
	 *	@param	argClearTopDepTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argClearTopDepId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamClearSubDep1Obj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamClearSubDep1Obj readClearSubDep1ByUNameIdx(long ClearTopDepTenantId,
		long ClearTopDepId,
		String Name );

	/**
	 *	Get the CFBamClearSubDep1Obj instance for the unique UNameIdx key.
	 *
	 *	@param	argClearTopDepTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argClearTopDepId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamClearSubDep1Obj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamClearSubDep1Obj readClearSubDep1ByUNameIdx(long ClearTopDepTenantId,
		long ClearTopDepId,
		String Name,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamClearSubDep1Obj updateClearSubDep1( ICFBamClearSubDep1Obj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteClearSubDep1( ICFBamClearSubDep1Obj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearSubDep1 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep1ByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep1ByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearSubDep1 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep1ByClearDepIdx( long TenantId,
		long RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearSubDep1 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClearTopDepTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argClearTopDepId	The ClearSubDep1 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep1ByClearTopDepIdx( long ClearTopDepTenantId,
		long ClearTopDepId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClearTopDepTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argClearTopDepId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearSubDep1 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep1ByUNameIdx(long ClearTopDepTenantId,
		long ClearTopDepId,
		String Name );
}
