
// Description: Java 11 DbIO interface for MinorVersion.

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
 *	CFBamMinorVersionTable database interface for MinorVersion
 */
public interface ICFBamMinorVersionTable
extends ICFIntMinorVersionTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createMinorVersion( CFSecAuthorization Authorization,
		CFIntMinorVersionBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateMinorVersion( CFSecAuthorization Authorization,
		CFIntMinorVersionBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteMinorVersion( CFSecAuthorization Authorization,
		CFIntMinorVersionBuff Buff );
	/**
	 *	Delete the MinorVersion instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argId	The MinorVersion key attribute of the instance generating the id.
	 */
	void deleteMinorVersionByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the MinorVersion instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteMinorVersionByIdIdx( CFSecAuthorization Authorization,
		CFIntMinorVersionPKey argKey );
	/**
	 *	Delete the MinorVersion instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MinorVersion key attribute of the instance generating the id.
	 */
	void deleteMinorVersionByTenantIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the MinorVersion instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteMinorVersionByTenantIdx( CFSecAuthorization Authorization,
		CFIntMinorVersionByTenantIdxKey argKey );
	/**
	 *	Delete the MinorVersion instances identified by the key MajorVerIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argMajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 */
	void deleteMinorVersionByMajorVerIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argMajorVersionId );

	/**
	 *	Delete the MinorVersion instances identified by the key MajorVerIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteMinorVersionByMajorVerIdx( CFSecAuthorization Authorization,
		CFIntMinorVersionByMajorVerIdxKey argKey );
	/**
	 *	Delete the MinorVersion instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argMajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argName	The MinorVersion key attribute of the instance generating the id.
	 */
	void deleteMinorVersionByNameIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argMajorVersionId,
		String argName );

	/**
	 *	Delete the MinorVersion instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteMinorVersionByNameIdx( CFSecAuthorization Authorization,
		CFIntMinorVersionByNameIdxKey argKey );


	/**
	 *	Read the derived MinorVersion buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the MinorVersion instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFIntMinorVersionBuff readDerived( CFSecAuthorization Authorization,
		CFIntMinorVersionPKey PKey );

	/**
	 *	Lock the derived MinorVersion buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the MinorVersion instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFIntMinorVersionBuff lockDerived( CFSecAuthorization Authorization,
		CFIntMinorVersionPKey PKey );

	/**
	 *	Read all MinorVersion instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFIntMinorVersionBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived MinorVersion buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFIntMinorVersionBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the derived MinorVersion buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFIntMinorVersionBuff[] readDerivedByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived MinorVersion buffer instances identified by the duplicate key MajorVerIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argMajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFIntMinorVersionBuff[] readDerivedByMajorVerIdx( CFSecAuthorization Authorization,
		long TenantId,
		long MajorVersionId );

	/**
	 *	Read the derived MinorVersion buffer instance identified by the unique key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argMajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argName	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFIntMinorVersionBuff readDerivedByNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long MajorVersionId,
		String Name );

	/**
	 *	Read the specific MinorVersion buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the MinorVersion instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntMinorVersionBuff readBuff( CFSecAuthorization Authorization,
		CFIntMinorVersionPKey PKey );

	/**
	 *	Lock the specific MinorVersion buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the MinorVersion instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntMinorVersionBuff lockBuff( CFSecAuthorization Authorization,
		CFIntMinorVersionPKey PKey );

	/**
	 *	Read all the specific MinorVersion buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific MinorVersion instances in the database accessible for the Authorization.
	 */
	CFIntMinorVersionBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific MinorVersion buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntMinorVersionBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the specific MinorVersion buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntMinorVersionBuff[] readBuffByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific MinorVersion buffer instances identified by the duplicate key MajorVerIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argMajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntMinorVersionBuff[] readBuffByMajorVerIdx( CFSecAuthorization Authorization,
		long TenantId,
		long MajorVersionId );

	/**
	 *	Read the specific MinorVersion buffer instance identified by the unique key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argMajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argName	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntMinorVersionBuff readBuffByNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long MajorVersionId,
		String Name );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
