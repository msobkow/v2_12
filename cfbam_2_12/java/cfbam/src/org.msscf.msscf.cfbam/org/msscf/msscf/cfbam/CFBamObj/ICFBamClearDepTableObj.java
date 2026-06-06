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

public interface ICFBamClearDepTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new ClearDep instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamClearDepObj newInstance();

	/**
	 *	Instantiate a new ClearDep edition of the specified ClearDep instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamClearDepEditObj newEditInstance( ICFBamClearDepObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamClearDepObj realiseClearDep( ICFBamClearDepObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetClearDep( ICFBamClearDepObj Obj );
	void forgetClearDep( ICFBamClearDepObj Obj, boolean forgetSubObjects );
	void forgetClearDepByIdIdx( long TenantId,
		long Id );

	void forgetClearDepByTenantIdx( long TenantId );

	void forgetClearDepByClearDepIdx( long TenantId,
		long RelationId );

	void forgetClearDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );


	/**
	 *	Internal use only.
	 */
	ICFBamClearDepObj createClearDep( ICFBamClearDepObj Obj );

	/**
	 *	Read a ClearDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ClearDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamClearDepObj readClearDep( CFBamScopePKey pkey );

	/**
	 *	Read a ClearDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ClearDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamClearDepObj readClearDep( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamClearDepObj lockClearDep( CFBamScopePKey pkey );

	/**
	 *	Return a sorted list of all the ClearDep-derived instances in the database.
	 *
	 *	@return	List of ICFBamClearDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamClearDepObj> readAllClearDep();

	/**
	 *	Return a sorted map of all the ClearDep-derived instances in the database.
	 *
	 *	@return	List of ICFBamClearDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamClearDepObj> readAllClearDep( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamClearDepObj readClearDepByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamClearDepObj readClearDepByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearDepObj> readClearDepByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamClearDepObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearDepObj> readClearDepByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamClearDepObj instances sorted by their primary keys for the duplicate ClearDepIdx key.
	 *
	 *	@param	argTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearDepObj cached instances sorted by their primary keys for the duplicate ClearDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearDepObj> readClearDepByClearDepIdx( long TenantId,
		long RelationId );

	/**
	 *	Get the map of CFBamClearDepObj instances sorted by their primary keys for the duplicate ClearDepIdx key.
	 *
	 *	@param	argTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearDepObj cached instances sorted by their primary keys for the duplicate ClearDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearDepObj> readClearDepByClearDepIdx( long TenantId,
		long RelationId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamClearDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearDepObj> readClearDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamClearDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearDepObj> readClearDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamClearDepObj updateClearDep( ICFBamClearDepObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteClearDep( ICFBamClearDepObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearDep key attribute of the instance generating the id.
	 */
	void deleteClearDepByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ClearDep key attribute of the instance generating the id.
	 */
	void deleteClearDepByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearDep key attribute of the instance generating the id.
	 */
	void deleteClearDepByClearDepIdx( long TenantId,
		long RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearDep key attribute of the instance generating the id.
	 */
	void deleteClearDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );
}
