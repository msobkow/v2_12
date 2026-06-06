
// Description: Java 11 DbIO interface for SchemaRef.

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
 *	CFBamSchemaRefTable database interface for SchemaRef
 */
public interface ICFBamSchemaRefTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createSchemaRef( CFSecAuthorization Authorization,
		CFBamSchemaRefBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateSchemaRef( CFSecAuthorization Authorization,
		CFBamSchemaRefBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteSchemaRef( CFSecAuthorization Authorization,
		CFBamSchemaRefBuff Buff );
	/**
	 *	Delete the SchemaRef instances identified by the key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaId	The SchemaRef key attribute of the instance generating the id.
	 */
	void deleteSchemaRefBySchemaIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argSchemaId );

	/**
	 *	Delete the SchemaRef instances identified by the key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSchemaRefBySchemaIdx( CFSecAuthorization Authorization,
		CFBamSchemaRefBySchemaIdxKey argKey );
	/**
	 *	Delete the SchemaRef instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The SchemaRef key attribute of the instance generating the id.
	 */
	void deleteSchemaRefByUNameIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argSchemaId,
		String argName );

	/**
	 *	Delete the SchemaRef instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSchemaRefByUNameIdx( CFSecAuthorization Authorization,
		CFBamSchemaRefByUNameIdxKey argKey );
	/**
	 *	Delete the SchemaRef instances identified by the key RefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRefSchemaTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argRefSchemaId	The SchemaRef key attribute of the instance generating the id.
	 */
	void deleteSchemaRefByRefSchemaIdx( CFSecAuthorization Authorization,
		Long argRefSchemaTenantId,
		Long argRefSchemaId );

	/**
	 *	Delete the SchemaRef instances identified by the key RefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSchemaRefByRefSchemaIdx( CFSecAuthorization Authorization,
		CFBamSchemaRefByRefSchemaIdxKey argKey );
	/**
	 *	Delete the SchemaRef instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The SchemaRef key attribute of the instance generating the id.
	 */
	void deleteSchemaRefByPrevIdx( CFSecAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId );

	/**
	 *	Delete the SchemaRef instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSchemaRefByPrevIdx( CFSecAuthorization Authorization,
		CFBamSchemaRefByPrevIdxKey argKey );
	/**
	 *	Delete the SchemaRef instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The SchemaRef key attribute of the instance generating the id.
	 */
	void deleteSchemaRefByNextIdx( CFSecAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId );

	/**
	 *	Delete the SchemaRef instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSchemaRefByNextIdx( CFSecAuthorization Authorization,
		CFBamSchemaRefByNextIdxKey argKey );
	/**
	 *	Delete the SchemaRef instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The SchemaRef key attribute of the instance generating the id.
	 */
	void deleteSchemaRefByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the SchemaRef instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSchemaRefByIdIdx( CFSecAuthorization Authorization,
		CFBamScopePKey argKey );
	/**
	 *	Delete the SchemaRef instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The SchemaRef key attribute of the instance generating the id.
	 */
	void deleteSchemaRefByTenantIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the SchemaRef instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSchemaRefByTenantIdx( CFSecAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey );


	/**
	 *	Read the derived SchemaRef buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SchemaRef instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamSchemaRefBuff readDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the derived SchemaRef buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SchemaRef instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamSchemaRefBuff lockDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all SchemaRef instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamSchemaRefBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived SchemaRef buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamSchemaRefBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the derived SchemaRef buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamSchemaRefBuff[] readDerivedByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived SchemaRef buffer instances identified by the duplicate key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamSchemaRefBuff[] readDerivedBySchemaIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SchemaId );

	/**
	 *	Read the derived SchemaRef buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamSchemaRefBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SchemaId,
		String Name );

	/**
	 *	Read an array of the derived SchemaRef buffer instances identified by the duplicate key RefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRefSchemaTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argRefSchemaId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamSchemaRefBuff[] readDerivedByRefSchemaIdx( CFSecAuthorization Authorization,
		Long RefSchemaTenantId,
		Long RefSchemaId );

	/**
	 *	Read an array of the derived SchemaRef buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamSchemaRefBuff[] readDerivedByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the derived SchemaRef buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamSchemaRefBuff[] readDerivedByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read the specific SchemaRef buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SchemaRef instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSchemaRefBuff readBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the specific SchemaRef buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SchemaRef instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSchemaRefBuff lockBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all the specific SchemaRef buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SchemaRef instances in the database accessible for the Authorization.
	 */
	CFBamSchemaRefBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific SchemaRef buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSchemaRefBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the specific SchemaRef buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSchemaRefBuff[] readBuffByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific SchemaRef buffer instances identified by the duplicate key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSchemaRefBuff[] readBuffBySchemaIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SchemaId );

	/**
	 *	Read the specific SchemaRef buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSchemaRefBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SchemaId,
		String Name );

	/**
	 *	Read an array of the specific SchemaRef buffer instances identified by the duplicate key RefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRefSchemaTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argRefSchemaId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSchemaRefBuff[] readBuffByRefSchemaIdx( CFSecAuthorization Authorization,
		Long RefSchemaTenantId,
		Long RefSchemaId );

	/**
	 *	Read an array of the specific SchemaRef buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSchemaRefBuff[] readBuffByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the specific SchemaRef buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSchemaRefBuff[] readBuffByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamSchemaRefBuff moveBuffUp( CFSecAuthorization Authorization,
		long TenantId,
		long Id,
		int revision );

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamSchemaRefBuff moveBuffDown( CFSecAuthorization Authorization,
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
