
// Description: Java 11 DbIO interface for Chain.

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
 *	CFBamChainTable database interface for Chain
 */
public interface ICFBamChainTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createChain( CFSecAuthorization Authorization,
		CFBamChainBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateChain( CFSecAuthorization Authorization,
		CFBamChainBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteChain( CFSecAuthorization Authorization,
		CFBamChainBuff Buff );
	/**
	 *	Delete the Chain instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Chain key attribute of the instance generating the id.
	 */
	void deleteChainByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the Chain instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteChainByIdIdx( CFSecAuthorization Authorization,
		CFBamChainPKey argKey );
	/**
	 *	Delete the Chain instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Chain key attribute of the instance generating the id.
	 */
	void deleteChainByTenantIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the Chain instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteChainByTenantIdx( CFSecAuthorization Authorization,
		CFBamChainByTenantIdxKey argKey );
	/**
	 *	Delete the Chain instances identified by the key ChainTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Chain key attribute of the instance generating the id.
	 */
	void deleteChainByChainTableIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argTableId );

	/**
	 *	Delete the Chain instances identified by the key ChainTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteChainByChainTableIdx( CFSecAuthorization Authorization,
		CFBamChainByChainTableIdxKey argKey );
	/**
	 *	Delete the Chain instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Chain key attribute of the instance generating the id.
	 */
	void deleteChainByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the Chain instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteChainByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamChainByDefSchemaIdxKey argKey );
	/**
	 *	Delete the Chain instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Chain key attribute of the instance generating the id.
	 */
	void deleteChainByUNameIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argTableId,
		String argName );

	/**
	 *	Delete the Chain instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteChainByUNameIdx( CFSecAuthorization Authorization,
		CFBamChainByUNameIdxKey argKey );
	/**
	 *	Delete the Chain instances identified by the key PrevRelIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevRelationTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argPrevRelationId	The Chain key attribute of the instance generating the id.
	 */
	void deleteChainByPrevRelIdx( CFSecAuthorization Authorization,
		long argPrevRelationTenantId,
		long argPrevRelationId );

	/**
	 *	Delete the Chain instances identified by the key PrevRelIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteChainByPrevRelIdx( CFSecAuthorization Authorization,
		CFBamChainByPrevRelIdxKey argKey );
	/**
	 *	Delete the Chain instances identified by the key NextRelIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextRelationTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argNextRelationId	The Chain key attribute of the instance generating the id.
	 */
	void deleteChainByNextRelIdx( CFSecAuthorization Authorization,
		long argNextRelationTenantId,
		long argNextRelationId );

	/**
	 *	Delete the Chain instances identified by the key NextRelIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteChainByNextRelIdx( CFSecAuthorization Authorization,
		CFBamChainByNextRelIdxKey argKey );


	/**
	 *	Read the derived Chain buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Chain instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamChainBuff readDerived( CFSecAuthorization Authorization,
		CFBamChainPKey PKey );

	/**
	 *	Lock the derived Chain buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Chain instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamChainBuff lockDerived( CFSecAuthorization Authorization,
		CFBamChainPKey PKey );

	/**
	 *	Read all Chain instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamChainBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived Chain buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamChainBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the derived Chain buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamChainBuff[] readDerivedByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived Chain buffer instances identified by the duplicate key ChainTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamChainBuff[] readDerivedByChainTableIdx( CFSecAuthorization Authorization,
		long TenantId,
		long TableId );

	/**
	 *	Read an array of the derived Chain buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamChainBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read the derived Chain buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Chain key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamChainBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long TableId,
		String Name );

	/**
	 *	Read an array of the derived Chain buffer instances identified by the duplicate key PrevRelIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevRelationTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argPrevRelationId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamChainBuff[] readDerivedByPrevRelIdx( CFSecAuthorization Authorization,
		long PrevRelationTenantId,
		long PrevRelationId );

	/**
	 *	Read an array of the derived Chain buffer instances identified by the duplicate key NextRelIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextRelationTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argNextRelationId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamChainBuff[] readDerivedByNextRelIdx( CFSecAuthorization Authorization,
		long NextRelationTenantId,
		long NextRelationId );

	/**
	 *	Read the specific Chain buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Chain instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamChainBuff readBuff( CFSecAuthorization Authorization,
		CFBamChainPKey PKey );

	/**
	 *	Lock the specific Chain buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Chain instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamChainBuff lockBuff( CFSecAuthorization Authorization,
		CFBamChainPKey PKey );

	/**
	 *	Read all the specific Chain buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific Chain instances in the database accessible for the Authorization.
	 */
	CFBamChainBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific Chain buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamChainBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the specific Chain buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamChainBuff[] readBuffByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific Chain buffer instances identified by the duplicate key ChainTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamChainBuff[] readBuffByChainTableIdx( CFSecAuthorization Authorization,
		long TenantId,
		long TableId );

	/**
	 *	Read an array of the specific Chain buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamChainBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read the specific Chain buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Chain key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamChainBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long TableId,
		String Name );

	/**
	 *	Read an array of the specific Chain buffer instances identified by the duplicate key PrevRelIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevRelationTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argPrevRelationId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamChainBuff[] readBuffByPrevRelIdx( CFSecAuthorization Authorization,
		long PrevRelationTenantId,
		long PrevRelationId );

	/**
	 *	Read an array of the specific Chain buffer instances identified by the duplicate key NextRelIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextRelationTenantId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	argNextRelationId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamChainBuff[] readBuffByNextRelIdx( CFSecAuthorization Authorization,
		long NextRelationTenantId,
		long NextRelationId );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
