
// Description: Java 11 DbIO interface for PopSubDep2.

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
 *	CFBamPopSubDep2Table database interface for PopSubDep2
 */
public interface ICFBamPopSubDep2Table
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createPopSubDep2( CFSecAuthorization Authorization,
		CFBamPopSubDep2Buff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updatePopSubDep2( CFSecAuthorization Authorization,
		CFBamPopSubDep2Buff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deletePopSubDep2( CFSecAuthorization Authorization,
		CFBamPopSubDep2Buff Buff );
	/**
	 *	Delete the PopSubDep2 instances identified by the key PopSubDep1Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPopSubDep1TenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argPopSubDep1Id	The PopSubDep2 key attribute of the instance generating the id.
	 */
	void deletePopSubDep2ByPopSubDep1Idx( CFSecAuthorization Authorization,
		long argPopSubDep1TenantId,
		long argPopSubDep1Id );

	/**
	 *	Delete the PopSubDep2 instances identified by the key PopSubDep1Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deletePopSubDep2ByPopSubDep1Idx( CFSecAuthorization Authorization,
		CFBamPopSubDep2ByPopSubDep1IdxKey argKey );
	/**
	 *	Delete the PopSubDep2 instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPopSubDep1TenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argPopSubDep1Id	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The PopSubDep2 key attribute of the instance generating the id.
	 */
	void deletePopSubDep2ByUNameIdx( CFSecAuthorization Authorization,
		long argPopSubDep1TenantId,
		long argPopSubDep1Id,
		String argName );

	/**
	 *	Delete the PopSubDep2 instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deletePopSubDep2ByUNameIdx( CFSecAuthorization Authorization,
		CFBamPopSubDep2ByUNameIdxKey argKey );
	/**
	 *	Delete the PopSubDep2 instances identified by the key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRelationTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The PopSubDep2 key attribute of the instance generating the id.
	 */
	void deletePopSubDep2ByRelationIdx( CFSecAuthorization Authorization,
		long argRelationTenantId,
		long argRelationId );

	/**
	 *	Delete the PopSubDep2 instances identified by the key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deletePopSubDep2ByRelationIdx( CFSecAuthorization Authorization,
		CFBamPopDepByRelationIdxKey argKey );
	/**
	 *	Delete the PopSubDep2 instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The PopSubDep2 key attribute of the instance generating the id.
	 */
	void deletePopSubDep2ByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the PopSubDep2 instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deletePopSubDep2ByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamPopDepByDefSchemaIdxKey argKey );
	/**
	 *	Delete the PopSubDep2 instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The PopSubDep2 key attribute of the instance generating the id.
	 */
	void deletePopSubDep2ByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the PopSubDep2 instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deletePopSubDep2ByIdIdx( CFSecAuthorization Authorization,
		CFBamScopePKey argKey );
	/**
	 *	Delete the PopSubDep2 instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 */
	void deletePopSubDep2ByTenantIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the PopSubDep2 instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deletePopSubDep2ByTenantIdx( CFSecAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey );


	/**
	 *	Read the derived PopSubDep2 buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the PopSubDep2 instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamPopSubDep2Buff readDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the derived PopSubDep2 buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the PopSubDep2 instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamPopSubDep2Buff lockDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all PopSubDep2 instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamPopSubDep2Buff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived PopSubDep2 buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamPopSubDep2Buff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the derived PopSubDep2 buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamPopSubDep2Buff[] readDerivedByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived PopSubDep2 buffer instances identified by the duplicate key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRelationTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamPopSubDep2Buff[] readDerivedByRelationIdx( CFSecAuthorization Authorization,
		long RelationTenantId,
		long RelationId );

	/**
	 *	Read an array of the derived PopSubDep2 buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamPopSubDep2Buff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the derived PopSubDep2 buffer instances identified by the duplicate key PopSubDep1Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPopSubDep1TenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argPopSubDep1Id	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamPopSubDep2Buff[] readDerivedByPopSubDep1Idx( CFSecAuthorization Authorization,
		long PopSubDep1TenantId,
		long PopSubDep1Id );

	/**
	 *	Read the derived PopSubDep2 buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPopSubDep1TenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argPopSubDep1Id	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamPopSubDep2Buff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long PopSubDep1TenantId,
		long PopSubDep1Id,
		String Name );

	/**
	 *	Read the specific PopSubDep2 buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the PopSubDep2 instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamPopSubDep2Buff readBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the specific PopSubDep2 buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the PopSubDep2 instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamPopSubDep2Buff lockBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all the specific PopSubDep2 buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific PopSubDep2 instances in the database accessible for the Authorization.
	 */
	CFBamPopSubDep2Buff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific PopSubDep2 buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamPopSubDep2Buff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the specific PopSubDep2 buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamPopSubDep2Buff[] readBuffByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific PopSubDep2 buffer instances identified by the duplicate key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRelationTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamPopSubDep2Buff[] readBuffByRelationIdx( CFSecAuthorization Authorization,
		long RelationTenantId,
		long RelationId );

	/**
	 *	Read an array of the specific PopSubDep2 buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamPopSubDep2Buff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the specific PopSubDep2 buffer instances identified by the duplicate key PopSubDep1Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPopSubDep1TenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argPopSubDep1Id	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamPopSubDep2Buff[] readBuffByPopSubDep1Idx( CFSecAuthorization Authorization,
		long PopSubDep1TenantId,
		long PopSubDep1Id );

	/**
	 *	Read the specific PopSubDep2 buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPopSubDep1TenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argPopSubDep1Id	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamPopSubDep2Buff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long PopSubDep1TenantId,
		long PopSubDep1Id,
		String Name );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
