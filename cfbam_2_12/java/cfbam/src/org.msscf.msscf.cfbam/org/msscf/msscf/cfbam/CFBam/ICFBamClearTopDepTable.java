
// Description: Java 11 DbIO interface for ClearTopDep.

/*
 *	org.msscf.msscf.CFBam
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
 *	
 *	MSS Code Factory is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with MSS Code Factory.  If not, see https://www.gnu.org/licenses/.
 *	
 *	Donations to support MSS Code Factory can be made at
 *	https://www.paypal.com/paypalme2/MarkSobkow
 *	
 *	Contact Mark Stephen Sobkow at msobkow@sasktel.net for commercial licensing.
 *
 *	Manufactured by MSS Code Factory 2.11
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
 *	CFBamClearTopDepTable database interface for ClearTopDep
 */
public interface ICFBamClearTopDepTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createClearTopDep( CFSecAuthorization Authorization,
		CFBamClearTopDepBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateClearTopDep( CFSecAuthorization Authorization,
		CFBamClearTopDepBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteClearTopDep( CFSecAuthorization Authorization,
		CFBamClearTopDepBuff Buff );
	/**
	 *	Delete the ClearTopDep instances identified by the key ClrTopDepTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTableTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByClrTopDepTblIdx( CFSecAuthorization Authorization,
		long argTableTenantId,
		long argTableId );

	/**
	 *	Delete the ClearTopDep instances identified by the key ClrTopDepTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearTopDepByClrTopDepTblIdx( CFSecAuthorization Authorization,
		CFBamClearTopDepByClrTopDepTblIdxKey argKey );
	/**
	 *	Delete the ClearTopDep instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTableTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByUNameIdx( CFSecAuthorization Authorization,
		long argTableTenantId,
		long argTableId,
		String argName );

	/**
	 *	Delete the ClearTopDep instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearTopDepByUNameIdx( CFSecAuthorization Authorization,
		CFBamClearTopDepByUNameIdxKey argKey );
	/**
	 *	Delete the ClearTopDep instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByPrevIdx( CFSecAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId );

	/**
	 *	Delete the ClearTopDep instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearTopDepByPrevIdx( CFSecAuthorization Authorization,
		CFBamClearTopDepByPrevIdxKey argKey );
	/**
	 *	Delete the ClearTopDep instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByNextIdx( CFSecAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId );

	/**
	 *	Delete the ClearTopDep instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearTopDepByNextIdx( CFSecAuthorization Authorization,
		CFBamClearTopDepByNextIdxKey argKey );
	/**
	 *	Delete the ClearTopDep instances identified by the key ClearDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByClearDepIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argRelationId );

	/**
	 *	Delete the ClearTopDep instances identified by the key ClearDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearTopDepByClearDepIdx( CFSecAuthorization Authorization,
		CFBamClearDepByClearDepIdxKey argKey );
	/**
	 *	Delete the ClearTopDep instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the ClearTopDep instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearTopDepByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamClearDepByDefSchemaIdxKey argKey );
	/**
	 *	Delete the ClearTopDep instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the ClearTopDep instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteClearTopDepByIdIdx( CFSecAuthorization Authorization,
		CFBamScopePKey argKey );
	/**
	 *	Delete the ClearTopDep instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByTenantIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the ClearTopDep instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearTopDepByTenantIdx( CFSecAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey );


	/**
	 *	Read the derived ClearTopDep buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearTopDep instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearTopDepBuff readDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the derived ClearTopDep buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearTopDep instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearTopDepBuff lockDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all ClearTopDep instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamClearTopDepBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived ClearTopDep buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearTopDepBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the derived ClearTopDep buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearTopDepBuff[] readDerivedByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived ClearTopDep buffer instances identified by the duplicate key ClearDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearTopDepBuff[] readDerivedByClearDepIdx( CFSecAuthorization Authorization,
		long TenantId,
		long RelationId );

	/**
	 *	Read an array of the derived ClearTopDep buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearTopDepBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the derived ClearTopDep buffer instances identified by the duplicate key ClrTopDepTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTableTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearTopDepBuff[] readDerivedByClrTopDepTblIdx( CFSecAuthorization Authorization,
		long TableTenantId,
		long TableId );

	/**
	 *	Read the derived ClearTopDep buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTableTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearTopDepBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long TableTenantId,
		long TableId,
		String Name );

	/**
	 *	Read an array of the derived ClearTopDep buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearTopDepBuff[] readDerivedByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the derived ClearTopDep buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearTopDepBuff[] readDerivedByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read the specific ClearTopDep buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearTopDep instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearTopDepBuff readBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the specific ClearTopDep buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearTopDep instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearTopDepBuff lockBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all the specific ClearTopDep buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific ClearTopDep instances in the database accessible for the Authorization.
	 */
	CFBamClearTopDepBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific ClearTopDep buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearTopDepBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the specific ClearTopDep buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearTopDepBuff[] readBuffByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific ClearTopDep buffer instances identified by the duplicate key ClearDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearTopDepBuff[] readBuffByClearDepIdx( CFSecAuthorization Authorization,
		long TenantId,
		long RelationId );

	/**
	 *	Read an array of the specific ClearTopDep buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearTopDepBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the specific ClearTopDep buffer instances identified by the duplicate key ClrTopDepTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTableTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearTopDepBuff[] readBuffByClrTopDepTblIdx( CFSecAuthorization Authorization,
		long TableTenantId,
		long TableId );

	/**
	 *	Read the specific ClearTopDep buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTableTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearTopDepBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long TableTenantId,
		long TableId,
		String Name );

	/**
	 *	Read an array of the specific ClearTopDep buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearTopDepBuff[] readBuffByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the specific ClearTopDep buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearTopDepBuff[] readBuffByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamClearTopDepBuff moveBuffUp( CFSecAuthorization Authorization,
		long TenantId,
		long Id,
		int revision );

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamClearTopDepBuff moveBuffDown( CFSecAuthorization Authorization,
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
