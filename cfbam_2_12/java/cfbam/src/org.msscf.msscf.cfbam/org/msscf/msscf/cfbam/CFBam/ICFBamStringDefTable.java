
// Description: Java 11 DbIO interface for StringDef.

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
 *	CFBamStringDefTable database interface for StringDef
 */
public interface ICFBamStringDefTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createStringDef( CFSecAuthorization Authorization,
		CFBamStringDefBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateStringDef( CFSecAuthorization Authorization,
		CFBamStringDefBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteStringDef( CFSecAuthorization Authorization,
		CFBamStringDefBuff Buff );
	/**
	 *	Delete the StringDef instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The StringDef key attribute of the instance generating the id.
	 */
	void deleteStringDefByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the StringDef instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteStringDefByIdIdx( CFSecAuthorization Authorization,
		CFBamValuePKey argKey );
	/**
	 *	Delete the StringDef instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The StringDef key attribute of the instance generating the id.
	 */
	void deleteStringDefByUNameIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName );

	/**
	 *	Delete the StringDef instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringDefByUNameIdx( CFSecAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey );
	/**
	 *	Delete the StringDef instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 */
	void deleteStringDefByValTentIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the StringDef instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringDefByValTentIdx( CFSecAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey );
	/**
	 *	Delete the StringDef instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 */
	void deleteStringDefByScopeIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId );

	/**
	 *	Delete the StringDef instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringDefByScopeIdx( CFSecAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey );
	/**
	 *	Delete the StringDef instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The StringDef key attribute of the instance generating the id.
	 */
	void deleteStringDefByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the StringDef instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringDefByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey );
	/**
	 *	Delete the StringDef instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringDef key attribute of the instance generating the id.
	 */
	void deleteStringDefByPrevIdx( CFSecAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId );

	/**
	 *	Delete the StringDef instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringDefByPrevIdx( CFSecAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey );
	/**
	 *	Delete the StringDef instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringDef key attribute of the instance generating the id.
	 */
	void deleteStringDefByNextIdx( CFSecAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId );

	/**
	 *	Delete the StringDef instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringDefByNextIdx( CFSecAuthorization Authorization,
		CFBamValueByNextIdxKey argKey );
	/**
	 *	Delete the StringDef instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringDef key attribute of the instance generating the id.
	 */
	void deleteStringDefByContPrevIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId );

	/**
	 *	Delete the StringDef instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringDefByContPrevIdx( CFSecAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey );
	/**
	 *	Delete the StringDef instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringDef key attribute of the instance generating the id.
	 */
	void deleteStringDefByContNextIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId );

	/**
	 *	Delete the StringDef instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringDefByContNextIdx( CFSecAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey );


	/**
	 *	Read the derived StringDef buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the StringDef instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamStringDefBuff readDerived( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Lock the derived StringDef buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the StringDef instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamStringDefBuff lockDerived( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Read all StringDef instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamStringDefBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived StringDef buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamStringDefBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read the derived StringDef buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamStringDefBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Read an array of the derived StringDef buffer instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringDefBuff[] readDerivedByValTentIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived StringDef buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringDefBuff[] readDerivedByScopeIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId );

	/**
	 *	Read an array of the derived StringDef buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringDefBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the derived StringDef buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringDefBuff[] readDerivedByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the derived StringDef buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringDefBuff[] readDerivedByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read an array of the derived StringDef buffer instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringDefBuff[] readDerivedByContPrevIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Read an array of the derived StringDef buffer instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringDefBuff[] readDerivedByContNextIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Read the specific StringDef buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the StringDef instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringDefBuff readBuff( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Lock the specific StringDef buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the StringDef instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringDefBuff lockBuff( CFSecAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Read all the specific StringDef buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific StringDef instances in the database accessible for the Authorization.
	 */
	CFBamStringDefBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific StringDef buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringDefBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read the specific StringDef buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringDefBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Read an array of the specific StringDef buffer instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringDefBuff[] readBuffByValTentIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific StringDef buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringDefBuff[] readBuffByScopeIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId );

	/**
	 *	Read an array of the specific StringDef buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringDefBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the specific StringDef buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringDefBuff[] readBuffByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the specific StringDef buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringDefBuff[] readBuffByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read an array of the specific StringDef buffer instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringDefBuff[] readBuffByContPrevIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Read an array of the specific StringDef buffer instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringDefBuff[] readBuffByContNextIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamStringDefBuff moveBuffUp( CFSecAuthorization Authorization,
		long TenantId,
		long Id,
		int revision );

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamStringDefBuff moveBuffDown( CFSecAuthorization Authorization,
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
