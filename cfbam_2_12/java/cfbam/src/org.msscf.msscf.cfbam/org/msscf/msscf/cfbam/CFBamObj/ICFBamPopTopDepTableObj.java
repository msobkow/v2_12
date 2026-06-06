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

public interface ICFBamPopTopDepTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new PopTopDep instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPopTopDepObj newInstance();

	/**
	 *	Instantiate a new PopTopDep edition of the specified PopTopDep instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPopTopDepEditObj newEditInstance( ICFBamPopTopDepObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPopTopDepObj realisePopTopDep( ICFBamPopTopDepObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetPopTopDep( ICFBamPopTopDepObj Obj );
	void forgetPopTopDep( ICFBamPopTopDepObj Obj, boolean forgetSubObjects );
	void forgetPopTopDepByIdIdx( long TenantId,
		long Id );

	void forgetPopTopDepByTenantIdx( long TenantId );

	void forgetPopTopDepByRelationIdx( long RelationTenantId,
		long RelationId );

	void forgetPopTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetPopTopDepByContRelIdx( long ContRelationTenantId,
		long ContRelationId );

	void forgetPopTopDepByUNameIdx( long ContRelationTenantId,
		long ContRelationId,
		String Name );


	/**
	 *	Internal use only.
	 */
	ICFBamPopTopDepObj createPopTopDep( ICFBamPopTopDepObj Obj );

	/**
	 *	Read a PopTopDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The PopTopDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPopTopDepObj readPopTopDep( CFBamScopePKey pkey );

	/**
	 *	Read a PopTopDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The PopTopDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPopTopDepObj readPopTopDep( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamPopTopDepObj lockPopTopDep( CFBamScopePKey pkey );

	/**
	 *	Return a sorted list of all the PopTopDep-derived instances in the database.
	 *
	 *	@return	List of ICFBamPopTopDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPopTopDepObj> readAllPopTopDep();

	/**
	 *	Return a sorted map of all the PopTopDep-derived instances in the database.
	 *
	 *	@return	List of ICFBamPopTopDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPopTopDepObj> readAllPopTopDep( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPopTopDepObj readPopTopDepByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPopTopDepObj readPopTopDepByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopTopDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopTopDepObj> readPopTopDepByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamPopTopDepObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopTopDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopTopDepObj> readPopTopDepByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPopDepObj instances sorted by their primary keys for the duplicate RelationIdx key.
	 *
	 *	@param	argRelationTenantId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopTopDepObj cached instances sorted by their primary keys for the duplicate RelationIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopTopDepObj> readPopTopDepByRelationIdx( long RelationTenantId,
		long RelationId );

	/**
	 *	Get the map of CFBamPopTopDepObj instances sorted by their primary keys for the duplicate RelationIdx key.
	 *
	 *	@param	argRelationTenantId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopTopDepObj cached instances sorted by their primary keys for the duplicate RelationIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopTopDepObj> readPopTopDepByRelationIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPopDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopTopDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopTopDepObj> readPopTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamPopTopDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopTopDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopTopDepObj> readPopTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPopTopDepObj instances sorted by their primary keys for the duplicate ContRelIdx key.
	 *
	 *	@param	argContRelationTenantId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argContRelationId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopTopDepObj cached instances sorted by their primary keys for the duplicate ContRelIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopTopDepObj> readPopTopDepByContRelIdx( long ContRelationTenantId,
		long ContRelationId );

	/**
	 *	Get the map of CFBamPopTopDepObj instances sorted by their primary keys for the duplicate ContRelIdx key.
	 *
	 *	@param	argContRelationTenantId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argContRelationId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopTopDepObj cached instances sorted by their primary keys for the duplicate ContRelIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopTopDepObj> readPopTopDepByContRelIdx( long ContRelationTenantId,
		long ContRelationId,
		boolean forceRead );

	/**
	 *	Get the CFBamPopTopDepObj instance for the unique UNameIdx key.
	 *
	 *	@param	argContRelationTenantId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argContRelationId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argName	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPopTopDepObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPopTopDepObj readPopTopDepByUNameIdx(long ContRelationTenantId,
		long ContRelationId,
		String Name );

	/**
	 *	Get the CFBamPopTopDepObj instance for the unique UNameIdx key.
	 *
	 *	@param	argContRelationTenantId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argContRelationId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argName	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPopTopDepObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPopTopDepObj readPopTopDepByUNameIdx(long ContRelationTenantId,
		long ContRelationId,
		String Name,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamPopTopDepObj updatePopTopDep( ICFBamPopTopDepObj Obj );

	/**
	 *	Internal use only.
	 */
	void deletePopTopDep( ICFBamPopTopDepObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The PopTopDep key attribute of the instance generating the id.
	 */
	void deletePopTopDepByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The PopTopDep key attribute of the instance generating the id.
	 */
	void deletePopTopDepByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argRelationTenantId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The PopTopDep key attribute of the instance generating the id.
	 */
	void deletePopTopDepByRelationIdx( long RelationTenantId,
		long RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The PopTopDep key attribute of the instance generating the id.
	 */
	void deletePopTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argContRelationTenantId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argContRelationId	The PopTopDep key attribute of the instance generating the id.
	 */
	void deletePopTopDepByContRelIdx( long ContRelationTenantId,
		long ContRelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argContRelationTenantId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argContRelationId	The PopTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argName	The PopTopDep key attribute of the instance generating the id.
	 */
	void deletePopTopDepByUNameIdx(long ContRelationTenantId,
		long ContRelationId,
		String Name );
}
