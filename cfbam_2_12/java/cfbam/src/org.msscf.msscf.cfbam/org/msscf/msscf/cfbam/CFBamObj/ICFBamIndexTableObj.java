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

public interface ICFBamIndexTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new Index instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamIndexObj newInstance();

	/**
	 *	Instantiate a new Index edition of the specified Index instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamIndexEditObj newEditInstance( ICFBamIndexObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamIndexObj realiseIndex( ICFBamIndexObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetIndex( ICFBamIndexObj Obj );
	void forgetIndex( ICFBamIndexObj Obj, boolean forgetSubObjects );
	void forgetIndexByIdIdx( long TenantId,
		long Id );

	void forgetIndexByTenantIdx( long TenantId );

	void forgetIndexByUNameIdx( long TenantId,
		long TableId,
		String Name );

	void forgetIndexByIndexTenantIdx( long TenantId );

	void forgetIndexByIdxTableIdx( long TenantId,
		long TableId );

	void forgetIndexByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );


	/**
	 *	Internal use only.
	 */
	ICFBamIndexObj createIndex( ICFBamIndexObj Obj );

	/**
	 *	Read a Index-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Index-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamIndexObj readIndex( CFBamScopePKey pkey );

	/**
	 *	Read a Index-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Index-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamIndexObj readIndex( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamIndexObj lockIndex( CFBamScopePKey pkey );

	/**
	 *	Return a sorted list of all the Index-derived instances in the database.
	 *
	 *	@return	List of ICFBamIndexObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamIndexObj> readAllIndex();

	/**
	 *	Return a sorted map of all the Index-derived instances in the database.
	 *
	 *	@return	List of ICFBamIndexObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamIndexObj> readAllIndex( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Index key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Index key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamIndexObj readIndexByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Index key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Index key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamIndexObj readIndexByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The Index key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexObj> readIndexByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamIndexObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The Index key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexObj> readIndexByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the CFBamIndexObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Index key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Index key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Index key attribute of the instance generating the id.
	 *
	 *	@return	CFBamIndexObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamIndexObj readIndexByUNameIdx(long TenantId,
		long TableId,
		String Name );

	/**
	 *	Get the CFBamIndexObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Index key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Index key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Index key attribute of the instance generating the id.
	 *
	 *	@return	CFBamIndexObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamIndexObj readIndexByUNameIdx(long TenantId,
		long TableId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamIndexObj instances sorted by their primary keys for the duplicate IndexTenantIdx key.
	 *
	 *	@param	argTenantId	The Index key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexObj cached instances sorted by their primary keys for the duplicate IndexTenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexObj> readIndexByIndexTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamIndexObj instances sorted by their primary keys for the duplicate IndexTenantIdx key.
	 *
	 *	@param	argTenantId	The Index key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexObj cached instances sorted by their primary keys for the duplicate IndexTenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexObj> readIndexByIndexTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamIndexObj instances sorted by their primary keys for the duplicate IdxTableIdx key.
	 *
	 *	@param	argTenantId	The Index key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Index key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexObj cached instances sorted by their primary keys for the duplicate IdxTableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexObj> readIndexByIdxTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamIndexObj instances sorted by their primary keys for the duplicate IdxTableIdx key.
	 *
	 *	@param	argTenantId	The Index key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Index key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexObj cached instances sorted by their primary keys for the duplicate IdxTableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexObj> readIndexByIdxTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamIndexObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Index key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Index key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexObj> readIndexByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamIndexObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Index key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Index key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamIndexObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamIndexObj> readIndexByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamIndexObj updateIndex( ICFBamIndexObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteIndex( ICFBamIndexObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Index key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Index key attribute of the instance generating the id.
	 */
	void deleteIndexByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Index key attribute of the instance generating the id.
	 */
	void deleteIndexByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Index key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Index key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Index key attribute of the instance generating the id.
	 */
	void deleteIndexByUNameIdx(long TenantId,
		long TableId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Index key attribute of the instance generating the id.
	 */
	void deleteIndexByIndexTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Index key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Index key attribute of the instance generating the id.
	 */
	void deleteIndexByIdxTableIdx( long TenantId,
		long TableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The Index key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Index key attribute of the instance generating the id.
	 */
	void deleteIndexByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );
}
