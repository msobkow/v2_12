
// Description: Java 11 DbIO interface for ClearSubDep2.

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
 *	CFBamClearSubDep2Table database interface for ClearSubDep2
 */
public interface ICFBamClearSubDep2Table
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createClearSubDep2( CFSecAuthorization Authorization,
		CFBamClearSubDep2Buff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateClearSubDep2( CFSecAuthorization Authorization,
		CFBamClearSubDep2Buff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteClearSubDep2( CFSecAuthorization Authorization,
		CFBamClearSubDep2Buff Buff );
	/**
	 *	Delete the ClearSubDep2 instances identified by the key ClearSubDep1Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClearSubDep1TenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argClearSubDep1Id	The ClearSubDep2 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep2ByClearSubDep1Idx( CFSecAuthorization Authorization,
		long argClearSubDep1TenantId,
		long argClearSubDep1Id );

	/**
	 *	Delete the ClearSubDep2 instances identified by the key ClearSubDep1Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearSubDep2ByClearSubDep1Idx( CFSecAuthorization Authorization,
		CFBamClearSubDep2ByClearSubDep1IdxKey argKey );
	/**
	 *	Delete the ClearSubDep2 instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClearSubDep1TenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argClearSubDep1Id	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearSubDep2 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep2ByUNameIdx( CFSecAuthorization Authorization,
		long argClearSubDep1TenantId,
		long argClearSubDep1Id,
		String argName );

	/**
	 *	Delete the ClearSubDep2 instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearSubDep2ByUNameIdx( CFSecAuthorization Authorization,
		CFBamClearSubDep2ByUNameIdxKey argKey );
	/**
	 *	Delete the ClearSubDep2 instances identified by the key ClearDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearSubDep2 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep2ByClearDepIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argRelationId );

	/**
	 *	Delete the ClearSubDep2 instances identified by the key ClearDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearSubDep2ByClearDepIdx( CFSecAuthorization Authorization,
		CFBamClearDepByClearDepIdxKey argKey );
	/**
	 *	Delete the ClearSubDep2 instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearSubDep2 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep2ByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the ClearSubDep2 instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearSubDep2ByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamClearDepByDefSchemaIdxKey argKey );
	/**
	 *	Delete the ClearSubDep2 instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearSubDep2 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep2ByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the ClearSubDep2 instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteClearSubDep2ByIdIdx( CFSecAuthorization Authorization,
		CFBamScopePKey argKey );
	/**
	 *	Delete the ClearSubDep2 instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep2ByTenantIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the ClearSubDep2 instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearSubDep2ByTenantIdx( CFSecAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey );


	/**
	 *	Read the derived ClearSubDep2 buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearSubDep2 instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearSubDep2Buff readDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the derived ClearSubDep2 buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearSubDep2 instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearSubDep2Buff lockDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all ClearSubDep2 instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamClearSubDep2Buff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived ClearSubDep2 buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearSubDep2Buff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the derived ClearSubDep2 buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearSubDep2Buff[] readDerivedByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived ClearSubDep2 buffer instances identified by the duplicate key ClearDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearSubDep2Buff[] readDerivedByClearDepIdx( CFSecAuthorization Authorization,
		long TenantId,
		long RelationId );

	/**
	 *	Read an array of the derived ClearSubDep2 buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearSubDep2Buff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the derived ClearSubDep2 buffer instances identified by the duplicate key ClearSubDep1Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClearSubDep1TenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argClearSubDep1Id	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearSubDep2Buff[] readDerivedByClearSubDep1Idx( CFSecAuthorization Authorization,
		long ClearSubDep1TenantId,
		long ClearSubDep1Id );

	/**
	 *	Read the derived ClearSubDep2 buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClearSubDep1TenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argClearSubDep1Id	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearSubDep2Buff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long ClearSubDep1TenantId,
		long ClearSubDep1Id,
		String Name );

	/**
	 *	Read the specific ClearSubDep2 buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearSubDep2 instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff readBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the specific ClearSubDep2 buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearSubDep2 instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff lockBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all the specific ClearSubDep2 buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific ClearSubDep2 instances in the database accessible for the Authorization.
	 */
	CFBamClearSubDep2Buff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific ClearSubDep2 buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the specific ClearSubDep2 buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff[] readBuffByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific ClearSubDep2 buffer instances identified by the duplicate key ClearDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff[] readBuffByClearDepIdx( CFSecAuthorization Authorization,
		long TenantId,
		long RelationId );

	/**
	 *	Read an array of the specific ClearSubDep2 buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the specific ClearSubDep2 buffer instances identified by the duplicate key ClearSubDep1Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClearSubDep1TenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argClearSubDep1Id	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff[] readBuffByClearSubDep1Idx( CFSecAuthorization Authorization,
		long ClearSubDep1TenantId,
		long ClearSubDep1Id );

	/**
	 *	Read the specific ClearSubDep2 buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClearSubDep1TenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argClearSubDep1Id	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long ClearSubDep1TenantId,
		long ClearSubDep1Id,
		String Name );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
