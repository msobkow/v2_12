
// Description: Java 11 DbIO interface for ClearDep.

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
 *	CFBamClearDepTable database interface for ClearDep
 */
public interface ICFBamClearDepTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createClearDep( CFSecAuthorization Authorization,
		CFBamClearDepBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateClearDep( CFSecAuthorization Authorization,
		CFBamClearDepBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteClearDep( CFSecAuthorization Authorization,
		CFBamClearDepBuff Buff );
	/**
	 *	Delete the ClearDep instances identified by the key ClearDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearDep key attribute of the instance generating the id.
	 */
	void deleteClearDepByClearDepIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argRelationId );

	/**
	 *	Delete the ClearDep instances identified by the key ClearDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearDepByClearDepIdx( CFSecAuthorization Authorization,
		CFBamClearDepByClearDepIdxKey argKey );
	/**
	 *	Delete the ClearDep instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearDep key attribute of the instance generating the id.
	 */
	void deleteClearDepByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the ClearDep instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearDepByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamClearDepByDefSchemaIdxKey argKey );
	/**
	 *	Delete the ClearDep instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearDep key attribute of the instance generating the id.
	 */
	void deleteClearDepByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the ClearDep instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteClearDepByIdIdx( CFSecAuthorization Authorization,
		CFBamScopePKey argKey );
	/**
	 *	Delete the ClearDep instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearDep key attribute of the instance generating the id.
	 */
	void deleteClearDepByTenantIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the ClearDep instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearDepByTenantIdx( CFSecAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey );


	/**
	 *	Read the derived ClearDep buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearDep instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearDepBuff readDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the derived ClearDep buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearDep instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearDepBuff lockDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all ClearDep instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamClearDepBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived ClearDep buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearDepBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the derived ClearDep buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearDepBuff[] readDerivedByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived ClearDep buffer instances identified by the duplicate key ClearDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearDepBuff[] readDerivedByClearDepIdx( CFSecAuthorization Authorization,
		long TenantId,
		long RelationId );

	/**
	 *	Read an array of the derived ClearDep buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearDepBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read the specific ClearDep buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearDep instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearDepBuff readBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the specific ClearDep buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearDep instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearDepBuff lockBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all the specific ClearDep buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific ClearDep instances in the database accessible for the Authorization.
	 */
	CFBamClearDepBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific ClearDep buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearDepBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the specific ClearDep buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearDepBuff[] readBuffByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific ClearDep buffer instances identified by the duplicate key ClearDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearDepBuff[] readBuffByClearDepIdx( CFSecAuthorization Authorization,
		long TenantId,
		long RelationId );

	/**
	 *	Read an array of the specific ClearDep buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearDepBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
