
// Description: Java 11 DbIO interface for MimeType.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFInt;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;

/*
 *	CFIntMimeTypeTable database interface for MimeType
 */
public interface ICFIntMimeTypeTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createMimeType( CFSecAuthorization Authorization,
		CFIntMimeTypeBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateMimeType( CFSecAuthorization Authorization,
		CFIntMimeTypeBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteMimeType( CFSecAuthorization Authorization,
		CFIntMimeTypeBuff Buff );
	/**
	 *	Delete the MimeType instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argMimeTypeId	The MimeType key attribute of the instance generating the id.
	 */
	void deleteMimeTypeByIdIdx( CFSecAuthorization Authorization,
		int argMimeTypeId );

	/**
	 *	Delete the MimeType instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteMimeTypeByIdIdx( CFSecAuthorization Authorization,
		CFIntMimeTypePKey argKey );
	/**
	 *	Delete the MimeType instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The MimeType key attribute of the instance generating the id.
	 */
	void deleteMimeTypeByUNameIdx( CFSecAuthorization Authorization,
		String argName );

	/**
	 *	Delete the MimeType instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteMimeTypeByUNameIdx( CFSecAuthorization Authorization,
		CFIntMimeTypeByUNameIdxKey argKey );


	/**
	 *	Read the derived MimeType buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the MimeType instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFIntMimeTypeBuff readDerived( CFSecAuthorization Authorization,
		CFIntMimeTypePKey PKey );

	/**
	 *	Lock the derived MimeType buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the MimeType instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFIntMimeTypeBuff lockDerived( CFSecAuthorization Authorization,
		CFIntMimeTypePKey PKey );

	/**
	 *	Read all MimeType instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFIntMimeTypeBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived MimeType buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argMimeTypeId	The MimeType key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFIntMimeTypeBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		int MimeTypeId );

	/**
	 *	Read the derived MimeType buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The MimeType key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFIntMimeTypeBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		String Name );

	/**
	 *	Read the specific MimeType buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the MimeType instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntMimeTypeBuff readBuff( CFSecAuthorization Authorization,
		CFIntMimeTypePKey PKey );

	/**
	 *	Lock the specific MimeType buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the MimeType instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntMimeTypeBuff lockBuff( CFSecAuthorization Authorization,
		CFIntMimeTypePKey PKey );

	/**
	 *	Read all the specific MimeType buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific MimeType instances in the database accessible for the Authorization.
	 */
	CFIntMimeTypeBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific MimeType buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argMimeTypeId	The MimeType key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntMimeTypeBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		int MimeTypeId );

	/**
	 *	Read the specific MimeType buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The MimeType key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntMimeTypeBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		String Name );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
