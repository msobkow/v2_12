
// Description: Java 11 DbIO interface for PopSubDep1.

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
 *	CFBamPopSubDep1Table database interface for PopSubDep1
 */
public interface ICFBamPopSubDep1Table
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createPopSubDep1( CFSecAuthorization Authorization,
		CFBamPopSubDep1Buff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updatePopSubDep1( CFSecAuthorization Authorization,
		CFBamPopSubDep1Buff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deletePopSubDep1( CFSecAuthorization Authorization,
		CFBamPopSubDep1Buff Buff );
	/**
	 *	Delete the PopSubDep1 instances identified by the key PopTopDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPopTopDepTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argPopTopDepId	The PopSubDep1 key attribute of the instance generating the id.
	 */
	void deletePopSubDep1ByPopTopDepIdx( CFSecAuthorization Authorization,
		long argPopTopDepTenantId,
		long argPopTopDepId );

	/**
	 *	Delete the PopSubDep1 instances identified by the key PopTopDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deletePopSubDep1ByPopTopDepIdx( CFSecAuthorization Authorization,
		CFBamPopSubDep1ByPopTopDepIdxKey argKey );
	/**
	 *	Delete the PopSubDep1 instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPopTopDepTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argPopTopDepId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The PopSubDep1 key attribute of the instance generating the id.
	 */
	void deletePopSubDep1ByUNameIdx( CFSecAuthorization Authorization,
		long argPopTopDepTenantId,
		long argPopTopDepId,
		String argName );

	/**
	 *	Delete the PopSubDep1 instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deletePopSubDep1ByUNameIdx( CFSecAuthorization Authorization,
		CFBamPopSubDep1ByUNameIdxKey argKey );
	/**
	 *	Delete the PopSubDep1 instances identified by the key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRelationTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The PopSubDep1 key attribute of the instance generating the id.
	 */
	void deletePopSubDep1ByRelationIdx( CFSecAuthorization Authorization,
		long argRelationTenantId,
		long argRelationId );

	/**
	 *	Delete the PopSubDep1 instances identified by the key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deletePopSubDep1ByRelationIdx( CFSecAuthorization Authorization,
		CFBamPopDepByRelationIdxKey argKey );
	/**
	 *	Delete the PopSubDep1 instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The PopSubDep1 key attribute of the instance generating the id.
	 */
	void deletePopSubDep1ByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the PopSubDep1 instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deletePopSubDep1ByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamPopDepByDefSchemaIdxKey argKey );
	/**
	 *	Delete the PopSubDep1 instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The PopSubDep1 key attribute of the instance generating the id.
	 */
	void deletePopSubDep1ByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the PopSubDep1 instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deletePopSubDep1ByIdIdx( CFSecAuthorization Authorization,
		CFBamScopePKey argKey );
	/**
	 *	Delete the PopSubDep1 instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 */
	void deletePopSubDep1ByTenantIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the PopSubDep1 instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deletePopSubDep1ByTenantIdx( CFSecAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey );


	/**
	 *	Read the derived PopSubDep1 buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the PopSubDep1 instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamPopSubDep1Buff readDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the derived PopSubDep1 buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the PopSubDep1 instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamPopSubDep1Buff lockDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all PopSubDep1 instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamPopSubDep1Buff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived PopSubDep1 buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamPopSubDep1Buff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the derived PopSubDep1 buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamPopSubDep1Buff[] readDerivedByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived PopSubDep1 buffer instances identified by the duplicate key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRelationTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamPopSubDep1Buff[] readDerivedByRelationIdx( CFSecAuthorization Authorization,
		long RelationTenantId,
		long RelationId );

	/**
	 *	Read an array of the derived PopSubDep1 buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamPopSubDep1Buff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the derived PopSubDep1 buffer instances identified by the duplicate key PopTopDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPopTopDepTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argPopTopDepId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamPopSubDep1Buff[] readDerivedByPopTopDepIdx( CFSecAuthorization Authorization,
		long PopTopDepTenantId,
		long PopTopDepId );

	/**
	 *	Read the derived PopSubDep1 buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPopTopDepTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argPopTopDepId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamPopSubDep1Buff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long PopTopDepTenantId,
		long PopTopDepId,
		String Name );

	/**
	 *	Read the specific PopSubDep1 buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the PopSubDep1 instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamPopSubDep1Buff readBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the specific PopSubDep1 buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the PopSubDep1 instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamPopSubDep1Buff lockBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all the specific PopSubDep1 buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific PopSubDep1 instances in the database accessible for the Authorization.
	 */
	CFBamPopSubDep1Buff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific PopSubDep1 buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamPopSubDep1Buff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the specific PopSubDep1 buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamPopSubDep1Buff[] readBuffByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific PopSubDep1 buffer instances identified by the duplicate key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRelationTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamPopSubDep1Buff[] readBuffByRelationIdx( CFSecAuthorization Authorization,
		long RelationTenantId,
		long RelationId );

	/**
	 *	Read an array of the specific PopSubDep1 buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamPopSubDep1Buff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the specific PopSubDep1 buffer instances identified by the duplicate key PopTopDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPopTopDepTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argPopTopDepId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamPopSubDep1Buff[] readBuffByPopTopDepIdx( CFSecAuthorization Authorization,
		long PopTopDepTenantId,
		long PopTopDepId );

	/**
	 *	Read the specific PopSubDep1 buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPopTopDepTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argPopTopDepId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamPopSubDep1Buff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long PopTopDepTenantId,
		long PopTopDepId,
		String Name );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
