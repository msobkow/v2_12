
// Description: Java 11 DbIO interface for Tool.

/*
 *	org.msscf.msscf.CFCore
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
 *	CFGenKbToolTable database interface for Tool
 */
public interface ICFGenKbToolTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createTool( CFGenKbAuthorization Authorization,
		CFGenKbToolBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateTool( CFGenKbAuthorization Authorization,
		CFGenKbToolBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteTool( CFGenKbAuthorization Authorization,
		CFGenKbToolBuff Buff );
	/**
	 *	Delete the Tool instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argId	The Tool key attribute of the instance generating the id.
	 */
	void deleteToolByIdIdx( CFGenKbAuthorization Authorization,
		short argId );

	/**
	 *	Delete the Tool instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteToolByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbToolPKey argKey );
	/**
	 *	Delete the Tool instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The Tool key attribute of the instance generating the id.
	 */
	void deleteToolByNameIdx( CFGenKbAuthorization Authorization,
		String argName );

	/**
	 *	Delete the Tool instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteToolByNameIdx( CFGenKbAuthorization Authorization,
		CFGenKbToolByNameIdxKey argKey );
	/**
	 *	Delete the Tool instances identified by the key ReplacesIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argReplacesId	The Tool key attribute of the instance generating the id.
	 */
	void deleteToolByReplacesIdx( CFGenKbAuthorization Authorization,
		Short argReplacesId );

	/**
	 *	Delete the Tool instances identified by the key ReplacesIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteToolByReplacesIdx( CFGenKbAuthorization Authorization,
		CFGenKbToolByReplacesIdxKey argKey );


	/**
	 *	Read the derived Tool buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Tool instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbToolBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbToolPKey PKey );

	/**
	 *	Lock the derived Tool buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Tool instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbToolBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbToolPKey PKey );

	/**
	 *	Read all Tool instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFGenKbToolBuff[] readAllDerived( CFGenKbAuthorization Authorization );

	/**
	 *	Read the derived Tool buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argId	The Tool key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbToolBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		short Id );

	/**
	 *	Read the derived Tool buffer instance identified by the unique key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The Tool key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbToolBuff readDerivedByNameIdx( CFGenKbAuthorization Authorization,
		String Name );

	/**
	 *	Read an array of the derived Tool buffer instances identified by the duplicate key ReplacesIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argReplacesId	The Tool key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbToolBuff[] readDerivedByReplacesIdx( CFGenKbAuthorization Authorization,
		Short ReplacesId );

	/**
	 *	Read the specific Tool buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Tool instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbToolBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbToolPKey PKey );

	/**
	 *	Lock the specific Tool buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Tool instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbToolBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbToolPKey PKey );

	/**
	 *	Read all the specific Tool buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific Tool instances in the database accessible for the Authorization.
	 */
	CFGenKbToolBuff[] readAllBuff( CFGenKbAuthorization Authorization );

	/**
	 *	Read the specific Tool buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argId	The Tool key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbToolBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		short Id );

	/**
	 *	Read the specific Tool buffer instance identified by the unique key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The Tool key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbToolBuff readBuffByNameIdx( CFGenKbAuthorization Authorization,
		String Name );

	/**
	 *	Read an array of the specific Tool buffer instances identified by the duplicate key ReplacesIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argReplacesId	The Tool key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbToolBuff[] readBuffByReplacesIdx( CFGenKbAuthorization Authorization,
		Short ReplacesId );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
