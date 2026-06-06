
// Description: Java 11 DbIO interface for DoubleDef.

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
 *	CFBamDoubleDefTable database interface for DoubleDef
 */
public interface ICFBamDoubleDefTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createDoubleDef( CFSecAuthorization Authorization,
		CFBamDoubleDefBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateDoubleDef( CFSecAuthorization Authorization,
		CFBamDoubleDefBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteDoubleDef( CFSecAuthorization Authorization,
		CFBamDoubleDefBuff Buff );
	/**
	 *	Delete the DoubleDef instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the DoubleDef instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteDoubleDefByIdIdx( CFSecAuthorization Authorization,
		CFBamValuePKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByUNameIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName );

	/**
	 *	Delete the DoubleDef instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByUNameIdx( CFSecAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByValTentIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the DoubleDef instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByValTentIdx( CFSecAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByScopeIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId );

	/**
	 *	Delete the DoubleDef instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByScopeIdx( CFSecAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the DoubleDef instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByPrevIdx( CFSecAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId );

	/**
	 *	Delete the DoubleDef instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByPrevIdx( CFSecAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByNextIdx( CFSecAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId );

	/**
	 *	Delete the DoubleDef instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByNextIdx( CFSecAuthorization Authorization,
		CFBamValueByNextIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByContPrevIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId );

	/**
	 *	Delete the DoubleDef instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByContPrevIdx( CFSecAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByContNextIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId );

	/**
	 *	Delete the DoubleDef instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByContNextIdx( CFSecAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey );


	/**
	 *	Read the derived DoubleDef buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DoubleDef instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamDoubleDefBuff readDerived( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Lock the derived DoubleDef buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DoubleDef instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamDoubleDefBuff lockDerived( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Read all DoubleDef instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived DoubleDef buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamDoubleDefBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read the derived DoubleDef buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamDoubleDefBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByValTentIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByScopeIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByContPrevIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByContNextIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Read the specific DoubleDef buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DoubleDef instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff readBuff( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Lock the specific DoubleDef buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DoubleDef instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff lockBuff( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Read all the specific DoubleDef buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific DoubleDef instances in the database accessible for the Authorization.
	 */
	CFBamDoubleDefBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific DoubleDef buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read the specific DoubleDef buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByValTentIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByScopeIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByContPrevIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByContNextIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamDoubleDefBuff moveBuffUp( CFSecAuthorization Authorization,
		long TenantId,
		long Id,
		int revision );

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamDoubleDefBuff moveBuffDown( CFSecAuthorization Authorization,
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
