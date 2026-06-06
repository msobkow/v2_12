
// Description: Java 11 DbIO interface for DefClass.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKb;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

/*
 *	CFGenKbDefClassTable database interface for DefClass
 */
public interface ICFGenKbDefClassTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createDefClass( CFGenKbAuthorization Authorization,
		CFGenKbDefClassBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateDefClass( CFGenKbAuthorization Authorization,
		CFGenKbDefClassBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteDefClass( CFGenKbAuthorization Authorization,
		CFGenKbDefClassBuff Buff );
	/**
	 *	Delete the DefClass instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argId	The DefClass key attribute of the instance generating the id.
	 */
	void deleteDefClassByIdIdx( CFGenKbAuthorization Authorization,
		short argId );

	/**
	 *	Delete the DefClass instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteDefClassByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbDefClassPKey argKey );
	/**
	 *	Delete the DefClass instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The DefClass key attribute of the instance generating the id.
	 */
	void deleteDefClassByNameIdx( CFGenKbAuthorization Authorization,
		String argName );

	/**
	 *	Delete the DefClass instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDefClassByNameIdx( CFGenKbAuthorization Authorization,
		CFGenKbDefClassByNameIdxKey argKey );
	/**
	 *	Delete the DefClass instances identified by the key BaseIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argBaseId	The DefClass key attribute of the instance generating the id.
	 */
	void deleteDefClassByBaseIdx( CFGenKbAuthorization Authorization,
		Short argBaseId );

	/**
	 *	Delete the DefClass instances identified by the key BaseIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDefClassByBaseIdx( CFGenKbAuthorization Authorization,
		CFGenKbDefClassByBaseIdxKey argKey );


	/**
	 *	Read the derived DefClass buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DefClass instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbDefClassBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbDefClassPKey PKey );

	/**
	 *	Lock the derived DefClass buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DefClass instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbDefClassBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbDefClassPKey PKey );

	/**
	 *	Read all DefClass instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFGenKbDefClassBuff[] readAllDerived( CFGenKbAuthorization Authorization );

	/**
	 *	Read the derived DefClass buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argId	The DefClass key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbDefClassBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		short Id );

	/**
	 *	Read the derived DefClass buffer instance identified by the unique key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The DefClass key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbDefClassBuff readDerivedByNameIdx( CFGenKbAuthorization Authorization,
		String Name );

	/**
	 *	Read an array of the derived DefClass buffer instances identified by the duplicate key BaseIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argBaseId	The DefClass key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbDefClassBuff[] readDerivedByBaseIdx( CFGenKbAuthorization Authorization,
		Short BaseId );

	/**
	 *	Read the specific DefClass buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DefClass instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbDefClassBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbDefClassPKey PKey );

	/**
	 *	Lock the specific DefClass buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DefClass instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbDefClassBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbDefClassPKey PKey );

	/**
	 *	Read all the specific DefClass buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific DefClass instances in the database accessible for the Authorization.
	 */
	CFGenKbDefClassBuff[] readAllBuff( CFGenKbAuthorization Authorization );

	/**
	 *	Read the specific DefClass buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argId	The DefClass key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbDefClassBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		short Id );

	/**
	 *	Read the specific DefClass buffer instance identified by the unique key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The DefClass key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbDefClassBuff readBuffByNameIdx( CFGenKbAuthorization Authorization,
		String Name );

	/**
	 *	Read an array of the specific DefClass buffer instances identified by the duplicate key BaseIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argBaseId	The DefClass key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbDefClassBuff[] readBuffByBaseIdx( CFGenKbAuthorization Authorization,
		Short BaseId );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
