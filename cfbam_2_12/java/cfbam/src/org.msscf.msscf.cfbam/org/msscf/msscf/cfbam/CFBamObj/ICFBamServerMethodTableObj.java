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

public interface ICFBamServerMethodTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new ServerMethod instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamServerMethodObj newInstance();

	/**
	 *	Instantiate a new ServerMethod edition of the specified ServerMethod instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamServerMethodEditObj newEditInstance( ICFBamServerMethodObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamServerMethodObj realiseServerMethod( ICFBamServerMethodObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetServerMethod( ICFBamServerMethodObj Obj );
	void forgetServerMethod( ICFBamServerMethodObj Obj, boolean forgetSubObjects );
	void forgetServerMethodByIdIdx( long TenantId,
		long Id );

	void forgetServerMethodByTenantIdx( long TenantId );

	void forgetServerMethodByUNameIdx( long TenantId,
		long TableId,
		String Name );

	void forgetServerMethodByMethTableIdx( long TenantId,
		long TableId );

	void forgetServerMethodByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );


	/**
	 *	Internal use only.
	 */
	ICFBamServerMethodObj createServerMethod( ICFBamServerMethodObj Obj );

	/**
	 *	Read a ServerMethod-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ServerMethod-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamServerMethodObj readServerMethod( CFBamScopePKey pkey );

	/**
	 *	Read a ServerMethod-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ServerMethod-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamServerMethodObj readServerMethod( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamServerMethodObj lockServerMethod( CFBamScopePKey pkey );

	/**
	 *	Return a sorted list of all the ServerMethod-derived instances in the database.
	 *
	 *	@return	List of ICFBamServerMethodObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamServerMethodObj> readAllServerMethod();

	/**
	 *	Return a sorted map of all the ServerMethod-derived instances in the database.
	 *
	 *	@return	List of ICFBamServerMethodObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamServerMethodObj> readAllServerMethod( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamServerMethodObj readServerMethodByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamServerMethodObj readServerMethodByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerMethodObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerMethodObj> readServerMethodByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamServerMethodObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerMethodObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerMethodObj> readServerMethodByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the CFBamServerMethodObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	CFBamServerMethodObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamServerMethodObj readServerMethodByUNameIdx(long TenantId,
		long TableId,
		String Name );

	/**
	 *	Get the CFBamServerMethodObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	CFBamServerMethodObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamServerMethodObj readServerMethodByUNameIdx(long TenantId,
		long TableId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamServerMethodObj instances sorted by their primary keys for the duplicate MethTableIdx key.
	 *
	 *	@param	argTenantId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerMethodObj cached instances sorted by their primary keys for the duplicate MethTableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerMethodObj> readServerMethodByMethTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamServerMethodObj instances sorted by their primary keys for the duplicate MethTableIdx key.
	 *
	 *	@param	argTenantId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerMethodObj cached instances sorted by their primary keys for the duplicate MethTableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerMethodObj> readServerMethodByMethTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamServerMethodObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerMethodObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerMethodObj> readServerMethodByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamServerMethodObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerMethodObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerMethodObj> readServerMethodByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamServerMethodObj updateServerMethod( ICFBamServerMethodObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteServerMethod( ICFBamServerMethodObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ServerMethod key attribute of the instance generating the id.
	 */
	void deleteServerMethodByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ServerMethod key attribute of the instance generating the id.
	 */
	void deleteServerMethodByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ServerMethod key attribute of the instance generating the id.
	 */
	void deleteServerMethodByUNameIdx(long TenantId,
		long TableId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerMethod key attribute of the instance generating the id.
	 */
	void deleteServerMethodByMethTableIdx( long TenantId,
		long TableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ServerMethod key attribute of the instance generating the id.
	 */
	void deleteServerMethodByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );
}
