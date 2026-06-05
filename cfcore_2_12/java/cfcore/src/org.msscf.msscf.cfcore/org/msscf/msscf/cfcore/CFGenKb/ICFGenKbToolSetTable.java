
// Description: Java 11 DbIO interface for ToolSet.

/*
 *	org.msscf.msscf.CFCore
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
 *	CFGenKbToolSetTable database interface for ToolSet
 */
public interface ICFGenKbToolSetTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createToolSet( CFGenKbAuthorization Authorization,
		CFGenKbToolSetBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateToolSet( CFGenKbAuthorization Authorization,
		CFGenKbToolSetBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteToolSet( CFGenKbAuthorization Authorization,
		CFGenKbToolSetBuff Buff );
	/**
	 *	Delete the ToolSet instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argId	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByIdIdx( CFGenKbAuthorization Authorization,
		short argId );

	/**
	 *	Delete the ToolSet instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteToolSetByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetPKey argKey );
	/**
	 *	Delete the ToolSet instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByNameIdx( CFGenKbAuthorization Authorization,
		String argName );

	/**
	 *	Delete the ToolSet instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteToolSetByNameIdx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetByNameIdxKey argKey );
	/**
	 *	Delete the ToolSet instances identified by the key Tool0Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId0	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByTool0Idx( CFGenKbAuthorization Authorization,
		short argToolId0 );

	/**
	 *	Delete the ToolSet instances identified by the key Tool0Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteToolSetByTool0Idx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetByTool0IdxKey argKey );
	/**
	 *	Delete the ToolSet instances identified by the key Tool1Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId1	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByTool1Idx( CFGenKbAuthorization Authorization,
		Short argToolId1 );

	/**
	 *	Delete the ToolSet instances identified by the key Tool1Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteToolSetByTool1Idx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetByTool1IdxKey argKey );
	/**
	 *	Delete the ToolSet instances identified by the key Tool2Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId2	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByTool2Idx( CFGenKbAuthorization Authorization,
		Short argToolId2 );

	/**
	 *	Delete the ToolSet instances identified by the key Tool2Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteToolSetByTool2Idx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetByTool2IdxKey argKey );
	/**
	 *	Delete the ToolSet instances identified by the key Tool3Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId3	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByTool3Idx( CFGenKbAuthorization Authorization,
		Short argToolId3 );

	/**
	 *	Delete the ToolSet instances identified by the key Tool3Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteToolSetByTool3Idx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetByTool3IdxKey argKey );
	/**
	 *	Delete the ToolSet instances identified by the key Tool4Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId4	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByTool4Idx( CFGenKbAuthorization Authorization,
		Short argToolId4 );

	/**
	 *	Delete the ToolSet instances identified by the key Tool4Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteToolSetByTool4Idx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetByTool4IdxKey argKey );
	/**
	 *	Delete the ToolSet instances identified by the key Tool5Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId5	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByTool5Idx( CFGenKbAuthorization Authorization,
		Short argToolId5 );

	/**
	 *	Delete the ToolSet instances identified by the key Tool5Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteToolSetByTool5Idx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetByTool5IdxKey argKey );
	/**
	 *	Delete the ToolSet instances identified by the key Tool6Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId6	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByTool6Idx( CFGenKbAuthorization Authorization,
		Short argToolId6 );

	/**
	 *	Delete the ToolSet instances identified by the key Tool6Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteToolSetByTool6Idx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetByTool6IdxKey argKey );
	/**
	 *	Delete the ToolSet instances identified by the key Tool7Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId7	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByTool7Idx( CFGenKbAuthorization Authorization,
		Short argToolId7 );

	/**
	 *	Delete the ToolSet instances identified by the key Tool7Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteToolSetByTool7Idx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetByTool7IdxKey argKey );


	/**
	 *	Read the derived ToolSet buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ToolSet instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbToolSetBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbToolSetPKey PKey );

	/**
	 *	Lock the derived ToolSet buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ToolSet instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbToolSetBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbToolSetPKey PKey );

	/**
	 *	Read all ToolSet instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFGenKbToolSetBuff[] readAllDerived( CFGenKbAuthorization Authorization );

	/**
	 *	Read the derived ToolSet buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argId	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbToolSetBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		short Id );

	/**
	 *	Read the derived ToolSet buffer instance identified by the unique key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbToolSetBuff readDerivedByNameIdx( CFGenKbAuthorization Authorization,
		String Name );

	/**
	 *	Read an array of the derived ToolSet buffer instances identified by the duplicate key Tool0Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId0	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbToolSetBuff[] readDerivedByTool0Idx( CFGenKbAuthorization Authorization,
		short ToolId0 );

	/**
	 *	Read an array of the derived ToolSet buffer instances identified by the duplicate key Tool1Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId1	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbToolSetBuff[] readDerivedByTool1Idx( CFGenKbAuthorization Authorization,
		Short ToolId1 );

	/**
	 *	Read an array of the derived ToolSet buffer instances identified by the duplicate key Tool2Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId2	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbToolSetBuff[] readDerivedByTool2Idx( CFGenKbAuthorization Authorization,
		Short ToolId2 );

	/**
	 *	Read an array of the derived ToolSet buffer instances identified by the duplicate key Tool3Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId3	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbToolSetBuff[] readDerivedByTool3Idx( CFGenKbAuthorization Authorization,
		Short ToolId3 );

	/**
	 *	Read an array of the derived ToolSet buffer instances identified by the duplicate key Tool4Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId4	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbToolSetBuff[] readDerivedByTool4Idx( CFGenKbAuthorization Authorization,
		Short ToolId4 );

	/**
	 *	Read an array of the derived ToolSet buffer instances identified by the duplicate key Tool5Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId5	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbToolSetBuff[] readDerivedByTool5Idx( CFGenKbAuthorization Authorization,
		Short ToolId5 );

	/**
	 *	Read an array of the derived ToolSet buffer instances identified by the duplicate key Tool6Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId6	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbToolSetBuff[] readDerivedByTool6Idx( CFGenKbAuthorization Authorization,
		Short ToolId6 );

	/**
	 *	Read an array of the derived ToolSet buffer instances identified by the duplicate key Tool7Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId7	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbToolSetBuff[] readDerivedByTool7Idx( CFGenKbAuthorization Authorization,
		Short ToolId7 );

	/**
	 *	Read the specific ToolSet buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ToolSet instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbToolSetBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbToolSetPKey PKey );

	/**
	 *	Lock the specific ToolSet buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ToolSet instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbToolSetBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbToolSetPKey PKey );

	/**
	 *	Read all the specific ToolSet buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific ToolSet instances in the database accessible for the Authorization.
	 */
	CFGenKbToolSetBuff[] readAllBuff( CFGenKbAuthorization Authorization );

	/**
	 *	Read the specific ToolSet buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argId	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbToolSetBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		short Id );

	/**
	 *	Read the specific ToolSet buffer instance identified by the unique key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbToolSetBuff readBuffByNameIdx( CFGenKbAuthorization Authorization,
		String Name );

	/**
	 *	Read an array of the specific ToolSet buffer instances identified by the duplicate key Tool0Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId0	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbToolSetBuff[] readBuffByTool0Idx( CFGenKbAuthorization Authorization,
		short ToolId0 );

	/**
	 *	Read an array of the specific ToolSet buffer instances identified by the duplicate key Tool1Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId1	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbToolSetBuff[] readBuffByTool1Idx( CFGenKbAuthorization Authorization,
		Short ToolId1 );

	/**
	 *	Read an array of the specific ToolSet buffer instances identified by the duplicate key Tool2Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId2	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbToolSetBuff[] readBuffByTool2Idx( CFGenKbAuthorization Authorization,
		Short ToolId2 );

	/**
	 *	Read an array of the specific ToolSet buffer instances identified by the duplicate key Tool3Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId3	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbToolSetBuff[] readBuffByTool3Idx( CFGenKbAuthorization Authorization,
		Short ToolId3 );

	/**
	 *	Read an array of the specific ToolSet buffer instances identified by the duplicate key Tool4Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId4	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbToolSetBuff[] readBuffByTool4Idx( CFGenKbAuthorization Authorization,
		Short ToolId4 );

	/**
	 *	Read an array of the specific ToolSet buffer instances identified by the duplicate key Tool5Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId5	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbToolSetBuff[] readBuffByTool5Idx( CFGenKbAuthorization Authorization,
		Short ToolId5 );

	/**
	 *	Read an array of the specific ToolSet buffer instances identified by the duplicate key Tool6Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId6	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbToolSetBuff[] readBuffByTool6Idx( CFGenKbAuthorization Authorization,
		Short ToolId6 );

	/**
	 *	Read an array of the specific ToolSet buffer instances identified by the duplicate key Tool7Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolId7	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbToolSetBuff[] readBuffByTool7Idx( CFGenKbAuthorization Authorization,
		Short ToolId7 );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
