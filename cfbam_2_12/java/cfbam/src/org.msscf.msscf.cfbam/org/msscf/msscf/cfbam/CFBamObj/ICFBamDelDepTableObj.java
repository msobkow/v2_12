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

public interface ICFBamDelDepTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new DelDep instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamDelDepObj newInstance();

	/**
	 *	Instantiate a new DelDep edition of the specified DelDep instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamDelDepEditObj newEditInstance( ICFBamDelDepObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamDelDepObj realiseDelDep( ICFBamDelDepObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetDelDep( ICFBamDelDepObj Obj );
	void forgetDelDep( ICFBamDelDepObj Obj, boolean forgetSubObjects );
	void forgetDelDepByIdIdx( long TenantId,
		long Id );

	void forgetDelDepByTenantIdx( long TenantId );

	void forgetDelDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetDelDepByDelDepIdx( long RelationTenantId,
		long RelationId );


	/**
	 *	Internal use only.
	 */
	ICFBamDelDepObj createDelDep( ICFBamDelDepObj Obj );

	/**
	 *	Read a DelDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DelDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamDelDepObj readDelDep( CFBamScopePKey pkey );

	/**
	 *	Read a DelDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DelDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamDelDepObj readDelDep( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamDelDepObj lockDelDep( CFBamScopePKey pkey );

	/**
	 *	Return a sorted list of all the DelDep-derived instances in the database.
	 *
	 *	@return	List of ICFBamDelDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamDelDepObj> readAllDelDep();

	/**
	 *	Return a sorted map of all the DelDep-derived instances in the database.
	 *
	 *	@return	List of ICFBamDelDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamDelDepObj> readAllDelDep( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamDelDepObj readDelDepByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamDelDepObj readDelDepByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelDepObj> readDelDepByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamDelDepObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelDepObj> readDelDepByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamDelDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelDepObj> readDelDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamDelDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelDepObj> readDelDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamDelDepObj instances sorted by their primary keys for the duplicate DelDepIdx key.
	 *
	 *	@param	argRelationTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelDepObj cached instances sorted by their primary keys for the duplicate DelDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelDepObj> readDelDepByDelDepIdx( long RelationTenantId,
		long RelationId );

	/**
	 *	Get the map of CFBamDelDepObj instances sorted by their primary keys for the duplicate DelDepIdx key.
	 *
	 *	@param	argRelationTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelDepObj cached instances sorted by their primary keys for the duplicate DelDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelDepObj> readDelDepByDelDepIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamDelDepObj updateDelDep( ICFBamDelDepObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDelDep( ICFBamDelDepObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DelDep key attribute of the instance generating the id.
	 */
	void deleteDelDepByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DelDep key attribute of the instance generating the id.
	 */
	void deleteDelDepByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DelDep key attribute of the instance generating the id.
	 */
	void deleteDelDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argRelationTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The DelDep key attribute of the instance generating the id.
	 */
	void deleteDelDepByDelDepIdx( long RelationTenantId,
		long RelationId );
}
