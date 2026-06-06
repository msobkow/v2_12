
// Description: Java 11 DbIO interface for ClearSubDep1.

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
 *	CFBamClearSubDep1Table database interface for ClearSubDep1
 */
public interface ICFBamClearSubDep1Table
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createClearSubDep1( CFSecAuthorization Authorization,
		CFBamClearSubDep1Buff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateClearSubDep1( CFSecAuthorization Authorization,
		CFBamClearSubDep1Buff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteClearSubDep1( CFSecAuthorization Authorization,
		CFBamClearSubDep1Buff Buff );
	/**
	 *	Delete the ClearSubDep1 instances identified by the key ClearTopDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClearTopDepTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argClearTopDepId	The ClearSubDep1 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep1ByClearTopDepIdx( CFSecAuthorization Authorization,
		long argClearTopDepTenantId,
		long argClearTopDepId );

	/**
	 *	Delete the ClearSubDep1 instances identified by the key ClearTopDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearSubDep1ByClearTopDepIdx( CFSecAuthorization Authorization,
		CFBamClearSubDep1ByClearTopDepIdxKey argKey );
	/**
	 *	Delete the ClearSubDep1 instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClearTopDepTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argClearTopDepId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearSubDep1 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep1ByUNameIdx( CFSecAuthorization Authorization,
		long argClearTopDepTenantId,
		long argClearTopDepId,
		String argName );

	/**
	 *	Delete the ClearSubDep1 instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearSubDep1ByUNameIdx( CFSecAuthorization Authorization,
		CFBamClearSubDep1ByUNameIdxKey argKey );
	/**
	 *	Delete the ClearSubDep1 instances identified by the key ClearDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearSubDep1 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep1ByClearDepIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argRelationId );

	/**
	 *	Delete the ClearSubDep1 instances identified by the key ClearDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearSubDep1ByClearDepIdx( CFSecAuthorization Authorization,
		CFBamClearDepByClearDepIdxKey argKey );
	/**
	 *	Delete the ClearSubDep1 instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearSubDep1 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep1ByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the ClearSubDep1 instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearSubDep1ByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamClearDepByDefSchemaIdxKey argKey );
	/**
	 *	Delete the ClearSubDep1 instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearSubDep1 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep1ByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the ClearSubDep1 instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteClearSubDep1ByIdIdx( CFSecAuthorization Authorization,
		CFBamScopePKey argKey );
	/**
	 *	Delete the ClearSubDep1 instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep1ByTenantIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the ClearSubDep1 instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearSubDep1ByTenantIdx( CFSecAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey );


	/**
	 *	Read the derived ClearSubDep1 buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearSubDep1 instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearSubDep1Buff readDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the derived ClearSubDep1 buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearSubDep1 instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearSubDep1Buff lockDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all ClearSubDep1 instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamClearSubDep1Buff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived ClearSubDep1 buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearSubDep1Buff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the derived ClearSubDep1 buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearSubDep1Buff[] readDerivedByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived ClearSubDep1 buffer instances identified by the duplicate key ClearDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearSubDep1Buff[] readDerivedByClearDepIdx( CFSecAuthorization Authorization,
		long TenantId,
		long RelationId );

	/**
	 *	Read an array of the derived ClearSubDep1 buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearSubDep1Buff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the derived ClearSubDep1 buffer instances identified by the duplicate key ClearTopDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClearTopDepTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argClearTopDepId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearSubDep1Buff[] readDerivedByClearTopDepIdx( CFSecAuthorization Authorization,
		long ClearTopDepTenantId,
		long ClearTopDepId );

	/**
	 *	Read the derived ClearSubDep1 buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClearTopDepTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argClearTopDepId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearSubDep1Buff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long ClearTopDepTenantId,
		long ClearTopDepId,
		String Name );

	/**
	 *	Read the specific ClearSubDep1 buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearSubDep1 instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep1Buff readBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the specific ClearSubDep1 buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearSubDep1 instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep1Buff lockBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all the specific ClearSubDep1 buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific ClearSubDep1 instances in the database accessible for the Authorization.
	 */
	CFBamClearSubDep1Buff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific ClearSubDep1 buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep1Buff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the specific ClearSubDep1 buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep1Buff[] readBuffByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific ClearSubDep1 buffer instances identified by the duplicate key ClearDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep1Buff[] readBuffByClearDepIdx( CFSecAuthorization Authorization,
		long TenantId,
		long RelationId );

	/**
	 *	Read an array of the specific ClearSubDep1 buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep1Buff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the specific ClearSubDep1 buffer instances identified by the duplicate key ClearTopDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClearTopDepTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argClearTopDepId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep1Buff[] readBuffByClearTopDepIdx( CFSecAuthorization Authorization,
		long ClearTopDepTenantId,
		long ClearTopDepId );

	/**
	 *	Read the specific ClearSubDep1 buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClearTopDepTenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argClearTopDepId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep1Buff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long ClearTopDepTenantId,
		long ClearTopDepId,
		String Name );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
