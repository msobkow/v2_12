
// Description: Java 11 DbIO interface for ServerObjFunc.

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

package org.msscf.msscf.cfbam.CFBam;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBamObj.*;

/*
 *	CFBamServerObjFuncTable database interface for ServerObjFunc
 */
public interface ICFBamServerObjFuncTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createServerObjFunc( CFSecAuthorization Authorization,
		CFBamServerObjFuncBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateServerObjFunc( CFSecAuthorization Authorization,
		CFBamServerObjFuncBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteServerObjFunc( CFSecAuthorization Authorization,
		CFBamServerObjFuncBuff Buff );
	/**
	 *	Delete the ServerObjFunc instances identified by the key RetTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRetTenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	argRetTableId	The ServerObjFunc key attribute of the instance generating the id.
	 */
	void deleteServerObjFuncByRetTblIdx( CFSecAuthorization Authorization,
		Long argRetTenantId,
		Long argRetTableId );

	/**
	 *	Delete the ServerObjFunc instances identified by the key RetTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteServerObjFuncByRetTblIdx( CFSecAuthorization Authorization,
		CFBamServerObjFuncByRetTblIdxKey argKey );
	/**
	 *	Delete the ServerObjFunc instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ServerObjFunc key attribute of the instance generating the id.
	 */
	void deleteServerObjFuncByUNameIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argTableId,
		String argName );

	/**
	 *	Delete the ServerObjFunc instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteServerObjFuncByUNameIdx( CFSecAuthorization Authorization,
		CFBamServerMethodByUNameIdxKey argKey );
	/**
	 *	Delete the ServerObjFunc instances identified by the key MethTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerObjFunc key attribute of the instance generating the id.
	 */
	void deleteServerObjFuncByMethTableIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argTableId );

	/**
	 *	Delete the ServerObjFunc instances identified by the key MethTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteServerObjFuncByMethTableIdx( CFSecAuthorization Authorization,
		CFBamServerMethodByMethTableIdxKey argKey );
	/**
	 *	Delete the ServerObjFunc instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ServerObjFunc key attribute of the instance generating the id.
	 */
	void deleteServerObjFuncByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the ServerObjFunc instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteServerObjFuncByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamServerMethodByDefSchemaIdxKey argKey );
	/**
	 *	Delete the ServerObjFunc instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ServerObjFunc key attribute of the instance generating the id.
	 */
	void deleteServerObjFuncByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the ServerObjFunc instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteServerObjFuncByIdIdx( CFSecAuthorization Authorization,
		CFBamScopePKey argKey );
	/**
	 *	Delete the ServerObjFunc instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ServerObjFunc key attribute of the instance generating the id.
	 */
	void deleteServerObjFuncByTenantIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the ServerObjFunc instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteServerObjFuncByTenantIdx( CFSecAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey );


	/**
	 *	Read the derived ServerObjFunc buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ServerObjFunc instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamServerObjFuncBuff readDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the derived ServerObjFunc buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ServerObjFunc instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamServerObjFuncBuff lockDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all ServerObjFunc instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamServerObjFuncBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived ServerObjFunc buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamServerObjFuncBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the derived ServerObjFunc buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamServerObjFuncBuff[] readDerivedByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read the derived ServerObjFunc buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamServerObjFuncBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long TableId,
		String Name );

	/**
	 *	Read an array of the derived ServerObjFunc buffer instances identified by the duplicate key MethTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamServerObjFuncBuff[] readDerivedByMethTableIdx( CFSecAuthorization Authorization,
		long TenantId,
		long TableId );

	/**
	 *	Read an array of the derived ServerObjFunc buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamServerObjFuncBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the derived ServerObjFunc buffer instances identified by the duplicate key RetTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRetTenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	argRetTableId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamServerObjFuncBuff[] readDerivedByRetTblIdx( CFSecAuthorization Authorization,
		Long RetTenantId,
		Long RetTableId );

	/**
	 *	Read the specific ServerObjFunc buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ServerObjFunc instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamServerObjFuncBuff readBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the specific ServerObjFunc buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ServerObjFunc instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamServerObjFuncBuff lockBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all the specific ServerObjFunc buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific ServerObjFunc instances in the database accessible for the Authorization.
	 */
	CFBamServerObjFuncBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific ServerObjFunc buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamServerObjFuncBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the specific ServerObjFunc buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamServerObjFuncBuff[] readBuffByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read the specific ServerObjFunc buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamServerObjFuncBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long TableId,
		String Name );

	/**
	 *	Read an array of the specific ServerObjFunc buffer instances identified by the duplicate key MethTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamServerObjFuncBuff[] readBuffByMethTableIdx( CFSecAuthorization Authorization,
		long TenantId,
		long TableId );

	/**
	 *	Read an array of the specific ServerObjFunc buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamServerObjFuncBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the specific ServerObjFunc buffer instances identified by the duplicate key RetTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRetTenantId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@param	argRetTableId	The ServerObjFunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamServerObjFuncBuff[] readBuffByRetTblIdx( CFSecAuthorization Authorization,
		Long RetTenantId,
		Long RetTableId );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
