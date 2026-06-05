
// Description: Java 11 DbIO interface for Table.

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
 *	CFBamTableTable database interface for Table
 */
public interface ICFBamTableTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createTable( CFSecAuthorization Authorization,
		CFBamTableBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateTable( CFSecAuthorization Authorization,
		CFBamTableBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteTable( CFSecAuthorization Authorization,
		CFBamTableBuff Buff );
	/**
	 *	Delete the Table instances identified by the key SchemaDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableBySchemaDefIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argSchemaDefId );

	/**
	 *	Delete the Table instances identified by the key SchemaDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTableBySchemaDefIdx( CFSecAuthorization Authorization,
		CFBamTableBySchemaDefIdxKey argKey );
	/**
	 *	Delete the Table instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the Table instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTableByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamTableByDefSchemaIdxKey argKey );
	/**
	 *	Delete the Table instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByUNameIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argSchemaDefId,
		String argName );

	/**
	 *	Delete the Table instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTableByUNameIdx( CFSecAuthorization Authorization,
		CFBamTableByUNameIdxKey argKey );
	/**
	 *	Delete the Table instances identified by the key SchemaCdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argTableClassCode	The Table key attribute of the instance generating the id.
	 */
	void deleteTableBySchemaCdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argSchemaDefId,
		String argTableClassCode );

	/**
	 *	Delete the Table instances identified by the key SchemaCdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTableBySchemaCdIdx( CFSecAuthorization Authorization,
		CFBamTableBySchemaCdIdxKey argKey );
	/**
	 *	Delete the Table instances identified by the key PrimaryIndexIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrimaryIndexTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argPrimaryIndexId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByPrimaryIndexIdx( CFSecAuthorization Authorization,
		Long argPrimaryIndexTenantId,
		Long argPrimaryIndexId );

	/**
	 *	Delete the Table instances identified by the key PrimaryIndexIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTableByPrimaryIndexIdx( CFSecAuthorization Authorization,
		CFBamTableByPrimaryIndexIdxKey argKey );
	/**
	 *	Delete the Table instances identified by the key LookupIndexIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argLookupIndexTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argLookupIndexId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByLookupIndexIdx( CFSecAuthorization Authorization,
		Long argLookupIndexTenantId,
		Long argLookupIndexId );

	/**
	 *	Delete the Table instances identified by the key LookupIndexIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTableByLookupIndexIdx( CFSecAuthorization Authorization,
		CFBamTableByLookupIndexIdxKey argKey );
	/**
	 *	Delete the Table instances identified by the key AltIndexIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argAltIndexTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argAltIndexId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByAltIndexIdx( CFSecAuthorization Authorization,
		Long argAltIndexTenantId,
		Long argAltIndexId );

	/**
	 *	Delete the Table instances identified by the key AltIndexIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTableByAltIndexIdx( CFSecAuthorization Authorization,
		CFBamTableByAltIndexIdxKey argKey );
	/**
	 *	Delete the Table instances identified by the key QualTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argQualifyingTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argQualifyingTableId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByQualTableIdx( CFSecAuthorization Authorization,
		Long argQualifyingTenantId,
		Long argQualifyingTableId );

	/**
	 *	Delete the Table instances identified by the key QualTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTableByQualTableIdx( CFSecAuthorization Authorization,
		CFBamTableByQualTableIdxKey argKey );
	/**
	 *	Delete the Table instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the Table instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteTableByIdIdx( CFSecAuthorization Authorization,
		CFBamScopePKey argKey );
	/**
	 *	Delete the Table instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByTenantIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the Table instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTableByTenantIdx( CFSecAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey );


	/**
	 *	Read the derived Table buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Table instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamTableBuff readDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the derived Table buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Table instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamTableBuff lockDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all Table instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamTableBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived Table buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Table key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamTableBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the derived Table buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamTableBuff[] readDerivedByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived Table buffer instances identified by the duplicate key SchemaDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamTableBuff[] readDerivedBySchemaDefIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SchemaDefId );

	/**
	 *	Read an array of the derived Table buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Table key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamTableBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read the derived Table buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Table key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamTableBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SchemaDefId,
		String Name );

	/**
	 *	Read the derived Table buffer instance identified by the unique key SchemaCdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argTableClassCode	The Table key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamTableBuff readDerivedBySchemaCdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SchemaDefId,
		String TableClassCode );

	/**
	 *	Read an array of the derived Table buffer instances identified by the duplicate key PrimaryIndexIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrimaryIndexTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argPrimaryIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamTableBuff[] readDerivedByPrimaryIndexIdx( CFSecAuthorization Authorization,
		Long PrimaryIndexTenantId,
		Long PrimaryIndexId );

	/**
	 *	Read an array of the derived Table buffer instances identified by the duplicate key LookupIndexIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argLookupIndexTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argLookupIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamTableBuff[] readDerivedByLookupIndexIdx( CFSecAuthorization Authorization,
		Long LookupIndexTenantId,
		Long LookupIndexId );

	/**
	 *	Read an array of the derived Table buffer instances identified by the duplicate key AltIndexIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argAltIndexTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argAltIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamTableBuff[] readDerivedByAltIndexIdx( CFSecAuthorization Authorization,
		Long AltIndexTenantId,
		Long AltIndexId );

	/**
	 *	Read an array of the derived Table buffer instances identified by the duplicate key QualTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argQualifyingTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argQualifyingTableId	The Table key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamTableBuff[] readDerivedByQualTableIdx( CFSecAuthorization Authorization,
		Long QualifyingTenantId,
		Long QualifyingTableId );

	/**
	 *	Read the specific Table buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Table instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTableBuff readBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the specific Table buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Table instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTableBuff lockBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all the specific Table buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific Table instances in the database accessible for the Authorization.
	 */
	CFBamTableBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific Table buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Table key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTableBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the specific Table buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTableBuff[] readBuffByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific Table buffer instances identified by the duplicate key SchemaDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTableBuff[] readBuffBySchemaDefIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SchemaDefId );

	/**
	 *	Read an array of the specific Table buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Table key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTableBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read the specific Table buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Table key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTableBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SchemaDefId,
		String Name );

	/**
	 *	Read the specific Table buffer instance identified by the unique key SchemaCdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argTableClassCode	The Table key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTableBuff readBuffBySchemaCdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SchemaDefId,
		String TableClassCode );

	/**
	 *	Read an array of the specific Table buffer instances identified by the duplicate key PrimaryIndexIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrimaryIndexTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argPrimaryIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTableBuff[] readBuffByPrimaryIndexIdx( CFSecAuthorization Authorization,
		Long PrimaryIndexTenantId,
		Long PrimaryIndexId );

	/**
	 *	Read an array of the specific Table buffer instances identified by the duplicate key LookupIndexIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argLookupIndexTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argLookupIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTableBuff[] readBuffByLookupIndexIdx( CFSecAuthorization Authorization,
		Long LookupIndexTenantId,
		Long LookupIndexId );

	/**
	 *	Read an array of the specific Table buffer instances identified by the duplicate key AltIndexIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argAltIndexTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argAltIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTableBuff[] readBuffByAltIndexIdx( CFSecAuthorization Authorization,
		Long AltIndexTenantId,
		Long AltIndexId );

	/**
	 *	Read an array of the specific Table buffer instances identified by the duplicate key QualTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argQualifyingTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argQualifyingTableId	The Table key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTableBuff[] readBuffByQualTableIdx( CFSecAuthorization Authorization,
		Long QualifyingTenantId,
		Long QualifyingTableId );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
