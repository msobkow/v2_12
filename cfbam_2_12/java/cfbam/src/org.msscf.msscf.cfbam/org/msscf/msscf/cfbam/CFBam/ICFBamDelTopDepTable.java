
// Description: Java 11 DbIO interface for DelTopDep.

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
 *	CFBamDelTopDepTable database interface for DelTopDep
 */
public interface ICFBamDelTopDepTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createDelTopDep( CFSecAuthorization Authorization,
		CFBamDelTopDepBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateDelTopDep( CFSecAuthorization Authorization,
		CFBamDelTopDepBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteDelTopDep( CFSecAuthorization Authorization,
		CFBamDelTopDepBuff Buff );
	/**
	 *	Delete the DelTopDep instances identified by the key DelTopDepTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTableTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByDelTopDepTblIdx( CFSecAuthorization Authorization,
		long argTableTenantId,
		long argTableId );

	/**
	 *	Delete the DelTopDep instances identified by the key DelTopDepTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDelTopDepByDelTopDepTblIdx( CFSecAuthorization Authorization,
		CFBamDelTopDepByDelTopDepTblIdxKey argKey );
	/**
	 *	Delete the DelTopDep instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTableTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByUNameIdx( CFSecAuthorization Authorization,
		long argTableTenantId,
		long argTableId,
		String argName );

	/**
	 *	Delete the DelTopDep instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDelTopDepByUNameIdx( CFSecAuthorization Authorization,
		CFBamDelTopDepByUNameIdxKey argKey );
	/**
	 *	Delete the DelTopDep instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByPrevIdx( CFSecAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId );

	/**
	 *	Delete the DelTopDep instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDelTopDepByPrevIdx( CFSecAuthorization Authorization,
		CFBamDelTopDepByPrevIdxKey argKey );
	/**
	 *	Delete the DelTopDep instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByNextIdx( CFSecAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId );

	/**
	 *	Delete the DelTopDep instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDelTopDepByNextIdx( CFSecAuthorization Authorization,
		CFBamDelTopDepByNextIdxKey argKey );
	/**
	 *	Delete the DelTopDep instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the DelTopDep instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDelTopDepByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamDelDepByDefSchemaIdxKey argKey );
	/**
	 *	Delete the DelTopDep instances identified by the key DelDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRelationTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByDelDepIdx( CFSecAuthorization Authorization,
		long argRelationTenantId,
		long argRelationId );

	/**
	 *	Delete the DelTopDep instances identified by the key DelDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDelTopDepByDelDepIdx( CFSecAuthorization Authorization,
		CFBamDelDepByDelDepIdxKey argKey );
	/**
	 *	Delete the DelTopDep instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the DelTopDep instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteDelTopDepByIdIdx( CFSecAuthorization Authorization,
		CFBamScopePKey argKey );
	/**
	 *	Delete the DelTopDep instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByTenantIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the DelTopDep instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDelTopDepByTenantIdx( CFSecAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey );


	/**
	 *	Read the derived DelTopDep buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DelTopDep instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamDelTopDepBuff readDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the derived DelTopDep buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DelTopDep instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamDelTopDepBuff lockDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all DelTopDep instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamDelTopDepBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived DelTopDep buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamDelTopDepBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the derived DelTopDep buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDelTopDepBuff[] readDerivedByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived DelTopDep buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDelTopDepBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the derived DelTopDep buffer instances identified by the duplicate key DelDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRelationTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDelTopDepBuff[] readDerivedByDelDepIdx( CFSecAuthorization Authorization,
		long RelationTenantId,
		long RelationId );

	/**
	 *	Read an array of the derived DelTopDep buffer instances identified by the duplicate key DelTopDepTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTableTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDelTopDepBuff[] readDerivedByDelTopDepTblIdx( CFSecAuthorization Authorization,
		long TableTenantId,
		long TableId );

	/**
	 *	Read the derived DelTopDep buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTableTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamDelTopDepBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long TableTenantId,
		long TableId,
		String Name );

	/**
	 *	Read an array of the derived DelTopDep buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDelTopDepBuff[] readDerivedByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the derived DelTopDep buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDelTopDepBuff[] readDerivedByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read the specific DelTopDep buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DelTopDep instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDelTopDepBuff readBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the specific DelTopDep buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DelTopDep instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDelTopDepBuff lockBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all the specific DelTopDep buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific DelTopDep instances in the database accessible for the Authorization.
	 */
	CFBamDelTopDepBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific DelTopDep buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDelTopDepBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the specific DelTopDep buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDelTopDepBuff[] readBuffByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific DelTopDep buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDelTopDepBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the specific DelTopDep buffer instances identified by the duplicate key DelDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRelationTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDelTopDepBuff[] readBuffByDelDepIdx( CFSecAuthorization Authorization,
		long RelationTenantId,
		long RelationId );

	/**
	 *	Read an array of the specific DelTopDep buffer instances identified by the duplicate key DelTopDepTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTableTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDelTopDepBuff[] readBuffByDelTopDepTblIdx( CFSecAuthorization Authorization,
		long TableTenantId,
		long TableId );

	/**
	 *	Read the specific DelTopDep buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTableTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDelTopDepBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long TableTenantId,
		long TableId,
		String Name );

	/**
	 *	Read an array of the specific DelTopDep buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDelTopDepBuff[] readBuffByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the specific DelTopDep buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDelTopDepBuff[] readBuffByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamDelTopDepBuff moveBuffUp( CFSecAuthorization Authorization,
		long TenantId,
		long Id,
		int revision );

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamDelTopDepBuff moveBuffDown( CFSecAuthorization Authorization,
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
