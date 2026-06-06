
// Description: Java 11 DbIO interface for DelDep.

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
 *	CFBamDelDepTable database interface for DelDep
 */
public interface ICFBamDelDepTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createDelDep( CFSecAuthorization Authorization,
		CFBamDelDepBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateDelDep( CFSecAuthorization Authorization,
		CFBamDelDepBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteDelDep( CFSecAuthorization Authorization,
		CFBamDelDepBuff Buff );
	/**
	 *	Delete the DelDep instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DelDep key attribute of the instance generating the id.
	 */
	void deleteDelDepByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the DelDep instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDelDepByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamDelDepByDefSchemaIdxKey argKey );
	/**
	 *	Delete the DelDep instances identified by the key DelDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRelationTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The DelDep key attribute of the instance generating the id.
	 */
	void deleteDelDepByDelDepIdx( CFSecAuthorization Authorization,
		long argRelationTenantId,
		long argRelationId );

	/**
	 *	Delete the DelDep instances identified by the key DelDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDelDepByDelDepIdx( CFSecAuthorization Authorization,
		CFBamDelDepByDelDepIdxKey argKey );
	/**
	 *	Delete the DelDep instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DelDep key attribute of the instance generating the id.
	 */
	void deleteDelDepByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the DelDep instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteDelDepByIdIdx( CFSecAuthorization Authorization,
		CFBamScopePKey argKey );
	/**
	 *	Delete the DelDep instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DelDep key attribute of the instance generating the id.
	 */
	void deleteDelDepByTenantIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the DelDep instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDelDepByTenantIdx( CFSecAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey );


	/**
	 *	Read the derived DelDep buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DelDep instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamDelDepBuff readDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the derived DelDep buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DelDep instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamDelDepBuff lockDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all DelDep instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamDelDepBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived DelDep buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamDelDepBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the derived DelDep buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDelDepBuff[] readDerivedByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived DelDep buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDelDepBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the derived DelDep buffer instances identified by the duplicate key DelDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRelationTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDelDepBuff[] readDerivedByDelDepIdx( CFSecAuthorization Authorization,
		long RelationTenantId,
		long RelationId );

	/**
	 *	Read the specific DelDep buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DelDep instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDelDepBuff readBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the specific DelDep buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DelDep instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDelDepBuff lockBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all the specific DelDep buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific DelDep instances in the database accessible for the Authorization.
	 */
	CFBamDelDepBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific DelDep buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDelDepBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the specific DelDep buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDelDepBuff[] readBuffByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific DelDep buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDelDepBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the specific DelDep buffer instances identified by the duplicate key DelDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRelationTenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDelDepBuff[] readBuffByDelDepIdx( CFSecAuthorization Authorization,
		long RelationTenantId,
		long RelationId );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
