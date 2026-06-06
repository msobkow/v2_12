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

public interface ICFBamServerListFuncTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new ServerListFunc instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamServerListFuncObj newInstance();

	/**
	 *	Instantiate a new ServerListFunc edition of the specified ServerListFunc instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamServerListFuncEditObj newEditInstance( ICFBamServerListFuncObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamServerListFuncObj realiseServerListFunc( ICFBamServerListFuncObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetServerListFunc( ICFBamServerListFuncObj Obj );
	void forgetServerListFunc( ICFBamServerListFuncObj Obj, boolean forgetSubObjects );
	void forgetServerListFuncByIdIdx( long TenantId,
		long Id );

	void forgetServerListFuncByTenantIdx( long TenantId );

	void forgetServerListFuncByUNameIdx( long TenantId,
		long TableId,
		String Name );

	void forgetServerListFuncByMethTableIdx( long TenantId,
		long TableId );

	void forgetServerListFuncByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetServerListFuncByRetTblIdx( Long RetTenantId,
		Long RetTableId );


	/**
	 *	Internal use only.
	 */
	ICFBamServerListFuncObj createServerListFunc( ICFBamServerListFuncObj Obj );

	/**
	 *	Read a ServerListFunc-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ServerListFunc-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamServerListFuncObj readServerListFunc( CFBamScopePKey pkey );

	/**
	 *	Read a ServerListFunc-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ServerListFunc-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamServerListFuncObj readServerListFunc( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamServerListFuncObj lockServerListFunc( CFBamScopePKey pkey );

	/**
	 *	Return a sorted list of all the ServerListFunc-derived instances in the database.
	 *
	 *	@return	List of ICFBamServerListFuncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamServerListFuncObj> readAllServerListFunc();

	/**
	 *	Return a sorted map of all the ServerListFunc-derived instances in the database.
	 *
	 *	@return	List of ICFBamServerListFuncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamServerListFuncObj> readAllServerListFunc( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamServerListFuncObj readServerListFuncByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamServerListFuncObj readServerListFuncByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerListFuncObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerListFuncObj> readServerListFuncByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamServerListFuncObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerListFuncObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerListFuncObj> readServerListFuncByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the CFBamServerMethodObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	CFBamServerMethodObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamServerListFuncObj readServerListFuncByUNameIdx( long TenantId,
		long TableId,
		String Name );

	/**
	 *	Get the CFBamServerMethodObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	CFBamServerMethodObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamServerListFuncObj readServerListFuncByUNameIdx( long TenantId,
		long TableId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamServerMethodObj instances sorted by their primary keys for the duplicate MethTableIdx key.
	 *
	 *	@param	argTenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerListFuncObj cached instances sorted by their primary keys for the duplicate MethTableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerListFuncObj> readServerListFuncByMethTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamServerListFuncObj instances sorted by their primary keys for the duplicate MethTableIdx key.
	 *
	 *	@param	argTenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerListFuncObj cached instances sorted by their primary keys for the duplicate MethTableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerListFuncObj> readServerListFuncByMethTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamServerMethodObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerListFuncObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerListFuncObj> readServerListFuncByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamServerListFuncObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerListFuncObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerListFuncObj> readServerListFuncByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamServerListFuncObj instances sorted by their primary keys for the duplicate RetTblIdx key.
	 *
	 *	@param	argRetTenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	argRetTableId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerListFuncObj cached instances sorted by their primary keys for the duplicate RetTblIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerListFuncObj> readServerListFuncByRetTblIdx( Long RetTenantId,
		Long RetTableId );

	/**
	 *	Get the map of CFBamServerListFuncObj instances sorted by their primary keys for the duplicate RetTblIdx key.
	 *
	 *	@param	argRetTenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	argRetTableId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerListFuncObj cached instances sorted by their primary keys for the duplicate RetTblIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerListFuncObj> readServerListFuncByRetTblIdx( Long RetTenantId,
		Long RetTableId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamServerListFuncObj updateServerListFunc( ICFBamServerListFuncObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteServerListFunc( ICFBamServerListFuncObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ServerListFunc key attribute of the instance generating the id.
	 */
	void deleteServerListFuncByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ServerListFunc key attribute of the instance generating the id.
	 */
	void deleteServerListFuncByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ServerListFunc key attribute of the instance generating the id.
	 */
	void deleteServerListFuncByUNameIdx( long TenantId,
		long TableId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerListFunc key attribute of the instance generating the id.
	 */
	void deleteServerListFuncByMethTableIdx( long TenantId,
		long TableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ServerListFunc key attribute of the instance generating the id.
	 */
	void deleteServerListFuncByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argRetTenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	argRetTableId	The ServerListFunc key attribute of the instance generating the id.
	 */
	void deleteServerListFuncByRetTblIdx( Long RetTenantId,
		Long RetTableId );
}
