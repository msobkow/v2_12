
// Description: Java 11 DbIO interface for URLProtocol.

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
 *	CFBamURLProtocolTable database interface for URLProtocol
 */
public interface ICFBamURLProtocolTable
extends ICFIntURLProtocolTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createURLProtocol( CFSecAuthorization Authorization,
		CFIntURLProtocolBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateURLProtocol( CFSecAuthorization Authorization,
		CFIntURLProtocolBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteURLProtocol( CFSecAuthorization Authorization,
		CFIntURLProtocolBuff Buff );
	/**
	 *	Delete the URLProtocol instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argURLProtocolId	The URLProtocol key attribute of the instance generating the id.
	 */
	void deleteURLProtocolByIdIdx( CFSecAuthorization Authorization,
		int argURLProtocolId );

	/**
	 *	Delete the URLProtocol instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteURLProtocolByIdIdx( CFSecAuthorization Authorization,
		CFIntURLProtocolPKey argKey );
	/**
	 *	Delete the URLProtocol instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The URLProtocol key attribute of the instance generating the id.
	 */
	void deleteURLProtocolByUNameIdx( CFSecAuthorization Authorization,
		String argName );

	/**
	 *	Delete the URLProtocol instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteURLProtocolByUNameIdx( CFSecAuthorization Authorization,
		CFIntURLProtocolByUNameIdxKey argKey );
	/**
	 *	Delete the URLProtocol instances identified by the key IsSecureIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argIsSecure	The URLProtocol key attribute of the instance generating the id.
	 */
	void deleteURLProtocolByIsSecureIdx( CFSecAuthorization Authorization,
		boolean argIsSecure );

	/**
	 *	Delete the URLProtocol instances identified by the key IsSecureIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteURLProtocolByIsSecureIdx( CFSecAuthorization Authorization,
		CFIntURLProtocolByIsSecureIdxKey argKey );


	/**
	 *	Read the derived URLProtocol buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the URLProtocol instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFIntURLProtocolBuff readDerived( CFSecAuthorization Authorization,
		CFIntURLProtocolPKey PKey );

	/**
	 *	Lock the derived URLProtocol buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the URLProtocol instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFIntURLProtocolBuff lockDerived( CFSecAuthorization Authorization,
		CFIntURLProtocolPKey PKey );

	/**
	 *	Read all URLProtocol instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFIntURLProtocolBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived URLProtocol buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argURLProtocolId	The URLProtocol key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFIntURLProtocolBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		int URLProtocolId );

	/**
	 *	Read the derived URLProtocol buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The URLProtocol key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFIntURLProtocolBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		String Name );

	/**
	 *	Read an array of the derived URLProtocol buffer instances identified by the duplicate key IsSecureIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argIsSecure	The URLProtocol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFIntURLProtocolBuff[] readDerivedByIsSecureIdx( CFSecAuthorization Authorization,
		boolean IsSecure );

	/**
	 *	Read the specific URLProtocol buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the URLProtocol instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntURLProtocolBuff readBuff( CFSecAuthorization Authorization,
		CFIntURLProtocolPKey PKey );

	/**
	 *	Lock the specific URLProtocol buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the URLProtocol instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntURLProtocolBuff lockBuff( CFSecAuthorization Authorization,
		CFIntURLProtocolPKey PKey );

	/**
	 *	Read all the specific URLProtocol buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific URLProtocol instances in the database accessible for the Authorization.
	 */
	CFIntURLProtocolBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific URLProtocol buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argURLProtocolId	The URLProtocol key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntURLProtocolBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		int URLProtocolId );

	/**
	 *	Read the specific URLProtocol buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The URLProtocol key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntURLProtocolBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		String Name );

	/**
	 *	Read an array of the specific URLProtocol buffer instances identified by the duplicate key IsSecureIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argIsSecure	The URLProtocol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntURLProtocolBuff[] readBuffByIsSecureIdx( CFSecAuthorization Authorization,
		boolean IsSecure );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
