
// Description: Java 11 DbIO interface for MajorVersion.

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
 *	CFBamMajorVersionTable database interface for MajorVersion
 */
public interface ICFBamMajorVersionTable
extends ICFIntMajorVersionTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createMajorVersion( CFSecAuthorization Authorization,
		CFIntMajorVersionBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateMajorVersion( CFSecAuthorization Authorization,
		CFIntMajorVersionBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteMajorVersion( CFSecAuthorization Authorization,
		CFIntMajorVersionBuff Buff );
	/**
	 *	Delete the MajorVersion instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argId	The MajorVersion key attribute of the instance generating the id.
	 */
	void deleteMajorVersionByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the MajorVersion instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteMajorVersionByIdIdx( CFSecAuthorization Authorization,
		CFIntMajorVersionPKey argKey );
	/**
	 *	Delete the MajorVersion instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MajorVersion key attribute of the instance generating the id.
	 */
	void deleteMajorVersionByTenantIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the MajorVersion instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteMajorVersionByTenantIdx( CFSecAuthorization Authorization,
		CFIntMajorVersionByTenantIdxKey argKey );
	/**
	 *	Delete the MajorVersion instances identified by the key SubProjectIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argSubProjectId	The MajorVersion key attribute of the instance generating the id.
	 */
	void deleteMajorVersionBySubProjectIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argSubProjectId );

	/**
	 *	Delete the MajorVersion instances identified by the key SubProjectIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteMajorVersionBySubProjectIdx( CFSecAuthorization Authorization,
		CFIntMajorVersionBySubProjectIdxKey argKey );
	/**
	 *	Delete the MajorVersion instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argSubProjectId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argName	The MajorVersion key attribute of the instance generating the id.
	 */
	void deleteMajorVersionByNameIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argSubProjectId,
		String argName );

	/**
	 *	Delete the MajorVersion instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteMajorVersionByNameIdx( CFSecAuthorization Authorization,
		CFIntMajorVersionByNameIdxKey argKey );


	/**
	 *	Read the derived MajorVersion buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the MajorVersion instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFIntMajorVersionBuff readDerived( CFSecAuthorization Authorization,
		CFIntMajorVersionPKey PKey );

	/**
	 *	Lock the derived MajorVersion buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the MajorVersion instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFIntMajorVersionBuff lockDerived( CFSecAuthorization Authorization,
		CFIntMajorVersionPKey PKey );

	/**
	 *	Read all MajorVersion instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFIntMajorVersionBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived MajorVersion buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFIntMajorVersionBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the derived MajorVersion buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFIntMajorVersionBuff[] readDerivedByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived MajorVersion buffer instances identified by the duplicate key SubProjectIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argSubProjectId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFIntMajorVersionBuff[] readDerivedBySubProjectIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SubProjectId );

	/**
	 *	Read the derived MajorVersion buffer instance identified by the unique key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argSubProjectId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argName	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFIntMajorVersionBuff readDerivedByNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SubProjectId,
		String Name );

	/**
	 *	Read the specific MajorVersion buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the MajorVersion instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntMajorVersionBuff readBuff( CFSecAuthorization Authorization,
		CFIntMajorVersionPKey PKey );

	/**
	 *	Lock the specific MajorVersion buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the MajorVersion instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntMajorVersionBuff lockBuff( CFSecAuthorization Authorization,
		CFIntMajorVersionPKey PKey );

	/**
	 *	Read all the specific MajorVersion buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific MajorVersion instances in the database accessible for the Authorization.
	 */
	CFIntMajorVersionBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific MajorVersion buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntMajorVersionBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the specific MajorVersion buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntMajorVersionBuff[] readBuffByTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific MajorVersion buffer instances identified by the duplicate key SubProjectIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argSubProjectId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntMajorVersionBuff[] readBuffBySubProjectIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SubProjectId );

	/**
	 *	Read the specific MajorVersion buffer instance identified by the unique key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argSubProjectId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@param	argName	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntMajorVersionBuff readBuffByNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SubProjectId,
		String Name );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
