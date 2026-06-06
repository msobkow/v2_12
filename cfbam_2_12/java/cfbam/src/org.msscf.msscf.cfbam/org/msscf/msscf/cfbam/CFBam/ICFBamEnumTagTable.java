
// Description: Java 11 DbIO interface for EnumTag.

/*
 *	org.msscf.msscf.CFBam
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
 *	CFBamEnumTagTable database interface for EnumTag
 */
public interface ICFBamEnumTagTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createEnumTag( CFSecAuthorization Authorization,
		CFBamEnumTagBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateEnumTag( CFSecAuthorization Authorization,
		CFBamEnumTagBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteEnumTag( CFSecAuthorization Authorization,
		CFBamEnumTagBuff Buff );
	/**
	 *	Delete the EnumTag instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the EnumTag instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteEnumTagByIdIdx( CFSecAuthorization Authorization,
		CFBamEnumTagPKey argKey );
	/**
	 *	Delete the EnumTag instances identified by the key EnumTagTenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByEnumTagTenantIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the EnumTag instances identified by the key EnumTagTenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumTagByEnumTagTenantIdx( CFSecAuthorization Authorization,
		CFBamEnumTagByEnumTagTenantIdxKey argKey );
	/**
	 *	Delete the EnumTag instances identified by the key EnumIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argEnumId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByEnumIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argEnumId );

	/**
	 *	Delete the EnumTag instances identified by the key EnumIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumTagByEnumIdx( CFSecAuthorization Authorization,
		CFBamEnumTagByEnumIdxKey argKey );
	/**
	 *	Delete the EnumTag instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the EnumTag instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumTagByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamEnumTagByDefSchemaIdxKey argKey );
	/**
	 *	Delete the EnumTag instances identified by the key EnumNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argEnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argName	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByEnumNameIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argEnumId,
		String argName );

	/**
	 *	Delete the EnumTag instances identified by the key EnumNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumTagByEnumNameIdx( CFSecAuthorization Authorization,
		CFBamEnumTagByEnumNameIdxKey argKey );
	/**
	 *	Delete the EnumTag instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByPrevIdx( CFSecAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId );

	/**
	 *	Delete the EnumTag instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumTagByPrevIdx( CFSecAuthorization Authorization,
		CFBamEnumTagByPrevIdxKey argKey );
	/**
	 *	Delete the EnumTag instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByNextIdx( CFSecAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId );

	/**
	 *	Delete the EnumTag instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumTagByNextIdx( CFSecAuthorization Authorization,
		CFBamEnumTagByNextIdxKey argKey );


	/**
	 *	Read the derived EnumTag buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the EnumTag instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamEnumTagBuff readDerived( CFSecAuthorization Authorization,
		CFBamEnumTagPKey PKey );

	/**
	 *	Lock the derived EnumTag buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the EnumTag instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamEnumTagBuff lockDerived( CFSecAuthorization Authorization,
		CFBamEnumTagPKey PKey );

	/**
	 *	Read all EnumTag instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamEnumTagBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived EnumTag buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamEnumTagBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the derived EnumTag buffer instances identified by the duplicate key EnumTagTenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamEnumTagBuff[] readDerivedByEnumTagTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived EnumTag buffer instances identified by the duplicate key EnumIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argEnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamEnumTagBuff[] readDerivedByEnumIdx( CFSecAuthorization Authorization,
		long TenantId,
		long EnumId );

	/**
	 *	Read an array of the derived EnumTag buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamEnumTagBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read the derived EnumTag buffer instance identified by the unique key EnumNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argEnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argName	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamEnumTagBuff readDerivedByEnumNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long EnumId,
		String Name );

	/**
	 *	Read an array of the derived EnumTag buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamEnumTagBuff[] readDerivedByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the derived EnumTag buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamEnumTagBuff[] readDerivedByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read the specific EnumTag buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the EnumTag instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumTagBuff readBuff( CFSecAuthorization Authorization,
		CFBamEnumTagPKey PKey );

	/**
	 *	Lock the specific EnumTag buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the EnumTag instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumTagBuff lockBuff( CFSecAuthorization Authorization,
		CFBamEnumTagPKey PKey );

	/**
	 *	Read all the specific EnumTag buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific EnumTag instances in the database accessible for the Authorization.
	 */
	CFBamEnumTagBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific EnumTag buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumTagBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the specific EnumTag buffer instances identified by the duplicate key EnumTagTenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumTagBuff[] readBuffByEnumTagTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific EnumTag buffer instances identified by the duplicate key EnumIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argEnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumTagBuff[] readBuffByEnumIdx( CFSecAuthorization Authorization,
		long TenantId,
		long EnumId );

	/**
	 *	Read an array of the specific EnumTag buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumTagBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read the specific EnumTag buffer instance identified by the unique key EnumNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argEnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argName	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumTagBuff readBuffByEnumNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long EnumId,
		String Name );

	/**
	 *	Read an array of the specific EnumTag buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumTagBuff[] readBuffByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the specific EnumTag buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumTagBuff[] readBuffByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamEnumTagBuff moveBuffUp( CFSecAuthorization Authorization,
		long TenantId,
		long Id,
		int revision );

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamEnumTagBuff moveBuffDown( CFSecAuthorization Authorization,
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
