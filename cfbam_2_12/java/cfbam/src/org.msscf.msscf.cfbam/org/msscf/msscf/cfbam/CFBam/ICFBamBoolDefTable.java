
// Description: Java 11 DbIO interface for BoolDef.

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
 *	CFBamBoolDefTable database interface for BoolDef
 */
public interface ICFBamBoolDefTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createBoolDef( CFSecAuthorization Authorization,
		CFBamBoolDefBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateBoolDef( CFSecAuthorization Authorization,
		CFBamBoolDefBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteBoolDef( CFSecAuthorization Authorization,
		CFBamBoolDefBuff Buff );
	/**
	 *	Delete the BoolDef instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the BoolDef instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteBoolDefByIdIdx( CFSecAuthorization Authorization,
		CFBamValuePKey argKey );
	/**
	 *	Delete the BoolDef instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByUNameIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName );

	/**
	 *	Delete the BoolDef instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteBoolDefByUNameIdx( CFSecAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey );
	/**
	 *	Delete the BoolDef instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByValTentIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the BoolDef instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteBoolDefByValTentIdx( CFSecAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey );
	/**
	 *	Delete the BoolDef instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByScopeIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId );

	/**
	 *	Delete the BoolDef instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteBoolDefByScopeIdx( CFSecAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey );
	/**
	 *	Delete the BoolDef instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the BoolDef instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteBoolDefByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey );
	/**
	 *	Delete the BoolDef instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByPrevIdx( CFSecAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId );

	/**
	 *	Delete the BoolDef instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteBoolDefByPrevIdx( CFSecAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey );
	/**
	 *	Delete the BoolDef instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByNextIdx( CFSecAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId );

	/**
	 *	Delete the BoolDef instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteBoolDefByNextIdx( CFSecAuthorization Authorization,
		CFBamValueByNextIdxKey argKey );
	/**
	 *	Delete the BoolDef instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByContPrevIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId );

	/**
	 *	Delete the BoolDef instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteBoolDefByContPrevIdx( CFSecAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey );
	/**
	 *	Delete the BoolDef instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByContNextIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId );

	/**
	 *	Delete the BoolDef instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteBoolDefByContNextIdx( CFSecAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey );


	/**
	 *	Read the derived BoolDef buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the BoolDef instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamBoolDefBuff readDerived( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Lock the derived BoolDef buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the BoolDef instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamBoolDefBuff lockDerived( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Read all BoolDef instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamBoolDefBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived BoolDef buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamBoolDefBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read the derived BoolDef buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamBoolDefBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Read an array of the derived BoolDef buffer instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamBoolDefBuff[] readDerivedByValTentIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived BoolDef buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamBoolDefBuff[] readDerivedByScopeIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId );

	/**
	 *	Read an array of the derived BoolDef buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamBoolDefBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the derived BoolDef buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamBoolDefBuff[] readDerivedByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the derived BoolDef buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamBoolDefBuff[] readDerivedByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read an array of the derived BoolDef buffer instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamBoolDefBuff[] readDerivedByContPrevIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Read an array of the derived BoolDef buffer instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamBoolDefBuff[] readDerivedByContNextIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Read the specific BoolDef buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the BoolDef instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamBoolDefBuff readBuff( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Lock the specific BoolDef buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the BoolDef instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamBoolDefBuff lockBuff( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Read all the specific BoolDef buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific BoolDef instances in the database accessible for the Authorization.
	 */
	CFBamBoolDefBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific BoolDef buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamBoolDefBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read the specific BoolDef buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamBoolDefBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Read an array of the specific BoolDef buffer instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamBoolDefBuff[] readBuffByValTentIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific BoolDef buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamBoolDefBuff[] readBuffByScopeIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId );

	/**
	 *	Read an array of the specific BoolDef buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamBoolDefBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the specific BoolDef buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamBoolDefBuff[] readBuffByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the specific BoolDef buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamBoolDefBuff[] readBuffByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read an array of the specific BoolDef buffer instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamBoolDefBuff[] readBuffByContPrevIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Read an array of the specific BoolDef buffer instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamBoolDefBuff[] readBuffByContNextIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamBoolDefBuff moveBuffUp( CFSecAuthorization Authorization,
		long TenantId,
		long Id,
		int revision );

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamBoolDefBuff moveBuffDown( CFSecAuthorization Authorization,
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
