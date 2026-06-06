
// Description: Java 11 DbIO interface for TZDateDef.

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
 *	CFBamTZDateDefTable database interface for TZDateDef
 */
public interface ICFBamTZDateDefTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createTZDateDef( CFSecAuthorization Authorization,
		CFBamTZDateDefBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateTZDateDef( CFSecAuthorization Authorization,
		CFBamTZDateDefBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteTZDateDef( CFSecAuthorization Authorization,
		CFBamTZDateDefBuff Buff );
	/**
	 *	Delete the TZDateDef instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZDateDef key attribute of the instance generating the id.
	 */
	void deleteTZDateDefByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the TZDateDef instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteTZDateDefByIdIdx( CFSecAuthorization Authorization,
		CFBamValuePKey argKey );
	/**
	 *	Delete the TZDateDef instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZDateDef key attribute of the instance generating the id.
	 */
	void deleteTZDateDefByUNameIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName );

	/**
	 *	Delete the TZDateDef instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTZDateDefByUNameIdx( CFSecAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey );
	/**
	 *	Delete the TZDateDef instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 */
	void deleteTZDateDefByValTentIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the TZDateDef instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTZDateDefByValTentIdx( CFSecAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey );
	/**
	 *	Delete the TZDateDef instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 */
	void deleteTZDateDefByScopeIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId );

	/**
	 *	Delete the TZDateDef instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTZDateDefByScopeIdx( CFSecAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey );
	/**
	 *	Delete the TZDateDef instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZDateDef key attribute of the instance generating the id.
	 */
	void deleteTZDateDefByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the TZDateDef instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTZDateDefByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey );
	/**
	 *	Delete the TZDateDef instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZDateDef key attribute of the instance generating the id.
	 */
	void deleteTZDateDefByPrevIdx( CFSecAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId );

	/**
	 *	Delete the TZDateDef instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTZDateDefByPrevIdx( CFSecAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey );
	/**
	 *	Delete the TZDateDef instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZDateDef key attribute of the instance generating the id.
	 */
	void deleteTZDateDefByNextIdx( CFSecAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId );

	/**
	 *	Delete the TZDateDef instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTZDateDefByNextIdx( CFSecAuthorization Authorization,
		CFBamValueByNextIdxKey argKey );
	/**
	 *	Delete the TZDateDef instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZDateDef key attribute of the instance generating the id.
	 */
	void deleteTZDateDefByContPrevIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId );

	/**
	 *	Delete the TZDateDef instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTZDateDefByContPrevIdx( CFSecAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey );
	/**
	 *	Delete the TZDateDef instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZDateDef key attribute of the instance generating the id.
	 */
	void deleteTZDateDefByContNextIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId );

	/**
	 *	Delete the TZDateDef instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTZDateDefByContNextIdx( CFSecAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey );


	/**
	 *	Read the derived TZDateDef buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TZDateDef instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamTZDateDefBuff readDerived( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Lock the derived TZDateDef buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TZDateDef instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamTZDateDefBuff lockDerived( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Read all TZDateDef instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamTZDateDefBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived TZDateDef buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamTZDateDefBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read the derived TZDateDef buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamTZDateDefBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Read an array of the derived TZDateDef buffer instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamTZDateDefBuff[] readDerivedByValTentIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived TZDateDef buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamTZDateDefBuff[] readDerivedByScopeIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId );

	/**
	 *	Read an array of the derived TZDateDef buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamTZDateDefBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the derived TZDateDef buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamTZDateDefBuff[] readDerivedByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the derived TZDateDef buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamTZDateDefBuff[] readDerivedByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read an array of the derived TZDateDef buffer instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamTZDateDefBuff[] readDerivedByContPrevIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Read an array of the derived TZDateDef buffer instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamTZDateDefBuff[] readDerivedByContNextIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Read the specific TZDateDef buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TZDateDef instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTZDateDefBuff readBuff( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Lock the specific TZDateDef buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TZDateDef instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTZDateDefBuff lockBuff( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Read all the specific TZDateDef buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific TZDateDef instances in the database accessible for the Authorization.
	 */
	CFBamTZDateDefBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific TZDateDef buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTZDateDefBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read the specific TZDateDef buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTZDateDefBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Read an array of the specific TZDateDef buffer instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTZDateDefBuff[] readBuffByValTentIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific TZDateDef buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTZDateDefBuff[] readBuffByScopeIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId );

	/**
	 *	Read an array of the specific TZDateDef buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTZDateDefBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the specific TZDateDef buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTZDateDefBuff[] readBuffByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the specific TZDateDef buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTZDateDefBuff[] readBuffByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read an array of the specific TZDateDef buffer instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTZDateDefBuff[] readBuffByContPrevIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Read an array of the specific TZDateDef buffer instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZDateDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTZDateDefBuff[] readBuffByContNextIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamTZDateDefBuff moveBuffUp( CFSecAuthorization Authorization,
		long TenantId,
		long Id,
		int revision );

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamTZDateDefBuff moveBuffDown( CFSecAuthorization Authorization,
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
