
// Description: Java 11 DbIO interface for UuidGen.

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
 *	CFBamUuidGenTable database interface for UuidGen
 */
public interface ICFBamUuidGenTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createUuidGen( CFSecAuthorization Authorization,
		CFBamUuidGenBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateUuidGen( CFSecAuthorization Authorization,
		CFBamUuidGenBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteUuidGen( CFSecAuthorization Authorization,
		CFBamUuidGenBuff Buff );
	/**
	 *	Delete the UuidGen instances identified by the key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenBySchemaIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argSchemaDefId );

	/**
	 *	Delete the UuidGen instances identified by the key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteUuidGenBySchemaIdx( CFSecAuthorization Authorization,
		CFBamUuidTypeBySchemaIdxKey argKey );
	/**
	 *	Delete the UuidGen instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the UuidGen instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteUuidGenByIdIdx( CFSecAuthorization Authorization,
		CFBamValuePKey argKey );
	/**
	 *	Delete the UuidGen instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenByUNameIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName );

	/**
	 *	Delete the UuidGen instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteUuidGenByUNameIdx( CFSecAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey );
	/**
	 *	Delete the UuidGen instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenByValTentIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the UuidGen instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteUuidGenByValTentIdx( CFSecAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey );
	/**
	 *	Delete the UuidGen instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenByScopeIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId );

	/**
	 *	Delete the UuidGen instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteUuidGenByScopeIdx( CFSecAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey );
	/**
	 *	Delete the UuidGen instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the UuidGen instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteUuidGenByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey );
	/**
	 *	Delete the UuidGen instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenByPrevIdx( CFSecAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId );

	/**
	 *	Delete the UuidGen instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteUuidGenByPrevIdx( CFSecAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey );
	/**
	 *	Delete the UuidGen instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenByNextIdx( CFSecAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId );

	/**
	 *	Delete the UuidGen instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteUuidGenByNextIdx( CFSecAuthorization Authorization,
		CFBamValueByNextIdxKey argKey );
	/**
	 *	Delete the UuidGen instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenByContPrevIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId );

	/**
	 *	Delete the UuidGen instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteUuidGenByContPrevIdx( CFSecAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey );
	/**
	 *	Delete the UuidGen instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenByContNextIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId );

	/**
	 *	Delete the UuidGen instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteUuidGenByContNextIdx( CFSecAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey );


	/**
	 *	Read the derived UuidGen buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the UuidGen instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamUuidGenBuff readDerived( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Lock the derived UuidGen buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the UuidGen instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamUuidGenBuff lockDerived( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Read all UuidGen instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamUuidGenBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived UuidGen buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamUuidGenBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read the derived UuidGen buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamUuidGenBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Read an array of the derived UuidGen buffer instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamUuidGenBuff[] readDerivedByValTentIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived UuidGen buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamUuidGenBuff[] readDerivedByScopeIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId );

	/**
	 *	Read an array of the derived UuidGen buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamUuidGenBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the derived UuidGen buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamUuidGenBuff[] readDerivedByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the derived UuidGen buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamUuidGenBuff[] readDerivedByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read an array of the derived UuidGen buffer instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamUuidGenBuff[] readDerivedByContPrevIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Read an array of the derived UuidGen buffer instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamUuidGenBuff[] readDerivedByContNextIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Read an array of the derived UuidGen buffer instances identified by the duplicate key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamUuidGenBuff[] readDerivedBySchemaIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SchemaDefId );

	/**
	 *	Read the specific UuidGen buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the UuidGen instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamUuidGenBuff readBuff( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Lock the specific UuidGen buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the UuidGen instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamUuidGenBuff lockBuff( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Read all the specific UuidGen buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific UuidGen instances in the database accessible for the Authorization.
	 */
	CFBamUuidGenBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific UuidGen buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamUuidGenBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read the specific UuidGen buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamUuidGenBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Read an array of the specific UuidGen buffer instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamUuidGenBuff[] readBuffByValTentIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific UuidGen buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamUuidGenBuff[] readBuffByScopeIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId );

	/**
	 *	Read an array of the specific UuidGen buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamUuidGenBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the specific UuidGen buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamUuidGenBuff[] readBuffByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the specific UuidGen buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamUuidGenBuff[] readBuffByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read an array of the specific UuidGen buffer instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamUuidGenBuff[] readBuffByContPrevIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Read an array of the specific UuidGen buffer instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamUuidGenBuff[] readBuffByContNextIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Read an array of the specific UuidGen buffer instances identified by the duplicate key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamUuidGenBuff[] readBuffBySchemaIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SchemaDefId );

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamUuidGenBuff moveBuffUp( CFSecAuthorization Authorization,
		long TenantId,
		long Id,
		int revision );

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamUuidGenBuff moveBuffDown( CFSecAuthorization Authorization,
		long TenantId,
		long Id,
		int revision );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
