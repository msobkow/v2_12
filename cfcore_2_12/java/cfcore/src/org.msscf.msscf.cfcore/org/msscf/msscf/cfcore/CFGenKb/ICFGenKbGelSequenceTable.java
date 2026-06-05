
// Description: Java 11 DbIO interface for GelSequence.

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
 *	CFGenKbGelSequenceTable database interface for GelSequence
 */
public interface ICFGenKbGelSequenceTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createGelSequence( CFGenKbAuthorization Authorization,
		CFGenKbGelSequenceBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateGelSequence( CFGenKbAuthorization Authorization,
		CFGenKbGelSequenceBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteGelSequence( CFGenKbAuthorization Authorization,
		CFGenKbGelSequenceBuff Buff );
	/**
	 *	Delete the GelSequence instances identified by the key FirstInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argFirstInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argFirstInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argFirstInstId	The GelSequence key attribute of the instance generating the id.
	 */
	void deleteGelSequenceByFirstInstIdx( CFGenKbAuthorization Authorization,
		Long argFirstInstTenantId,
		Long argFirstInstGelCacheId,
		Long argFirstInstId );

	/**
	 *	Delete the GelSequence instances identified by the key FirstInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSequenceByFirstInstIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSequenceByFirstInstIdxKey argKey );
	/**
	 *	Delete the GelSequence instances identified by the key LastInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argLastInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argLastInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argLastInstId	The GelSequence key attribute of the instance generating the id.
	 */
	void deleteGelSequenceByLastInstIdx( CFGenKbAuthorization Authorization,
		Long argLastInstTenantId,
		Long argLastInstGelCacheId,
		Long argLastInstId );

	/**
	 *	Delete the GelSequence instances identified by the key LastInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSequenceByLastInstIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSequenceByLastInstIdxKey argKey );
	/**
	 *	Delete the GelSequence instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSequence key attribute of the instance generating the id.
	 */
	void deleteGelSequenceByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId );

	/**
	 *	Delete the GelSequence instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteGelSequenceByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey argKey );
	/**
	 *	Delete the GelSequence instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSequence key attribute of the instance generating the id.
	 */
	void deleteGelSequenceByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the GelSequence instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSequenceByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByTenantIdxKey argKey );
	/**
	 *	Delete the GelSequence instances identified by the key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSequence key attribute of the instance generating the id.
	 */
	void deleteGelSequenceByGelCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId );

	/**
	 *	Delete the GelSequence instances identified by the key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSequenceByGelCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByGelCacheIdxKey argKey );
	/**
	 *	Delete the GelSequence instances identified by the key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelSequence key attribute of the instance generating the id.
	 */
	void deleteGelSequenceByChainIdx( CFGenKbAuthorization Authorization,
		Long argChainInstTenantId,
		Long argChainInstGelCacheId,
		Long argChainInstGelInstId );

	/**
	 *	Delete the GelSequence instances identified by the key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSequenceByChainIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByChainIdxKey argKey );


	/**
	 *	Read the derived GelSequence buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelSequence instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelSequenceBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Lock the derived GelSequence buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelSequence instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelSequenceBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Read all GelSequence instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFGenKbGelSequenceBuff[] readAllDerived( CFGenKbAuthorization Authorization );

	/**
	 *	Read the derived GelSequence buffer instance identified by the unique key PIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelSequenceBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Read an array of the derived GelSequence buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSequenceBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived GelSequence buffer instances identified by the duplicate key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSequenceBuff[] readDerivedByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId );

	/**
	 *	Read an array of the derived GelSequence buffer instances identified by the duplicate key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSequenceBuff[] readDerivedByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Read an array of the derived GelSequence buffer instances identified by the duplicate key FirstInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argFirstInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argFirstInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argFirstInstId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSequenceBuff[] readDerivedByFirstInstIdx( CFGenKbAuthorization Authorization,
		Long FirstInstTenantId,
		Long FirstInstGelCacheId,
		Long FirstInstId );

	/**
	 *	Read an array of the derived GelSequence buffer instances identified by the duplicate key LastInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argLastInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argLastInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argLastInstId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSequenceBuff[] readDerivedByLastInstIdx( CFGenKbAuthorization Authorization,
		Long LastInstTenantId,
		Long LastInstGelCacheId,
		Long LastInstId );

	/**
	 *	Read the specific GelSequence buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelSequence instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSequenceBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Lock the specific GelSequence buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelSequence instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSequenceBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Read all the specific GelSequence buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific GelSequence instances in the database accessible for the Authorization.
	 */
	CFGenKbGelSequenceBuff[] readAllBuff( CFGenKbAuthorization Authorization );

	/**
	 *	Read the specific GelSequence buffer instance identified by the unique key PIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSequenceBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Read an array of the specific GelSequence buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSequenceBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific GelSequence buffer instances identified by the duplicate key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSequenceBuff[] readBuffByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId );

	/**
	 *	Read an array of the specific GelSequence buffer instances identified by the duplicate key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSequenceBuff[] readBuffByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Read an array of the specific GelSequence buffer instances identified by the duplicate key FirstInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argFirstInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argFirstInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argFirstInstId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSequenceBuff[] readBuffByFirstInstIdx( CFGenKbAuthorization Authorization,
		Long FirstInstTenantId,
		Long FirstInstGelCacheId,
		Long FirstInstId );

	/**
	 *	Read an array of the specific GelSequence buffer instances identified by the duplicate key LastInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argLastInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argLastInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argLastInstId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSequenceBuff[] readBuffByLastInstIdx( CFGenKbAuthorization Authorization,
		Long LastInstTenantId,
		Long LastInstGelCacheId,
		Long LastInstId );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
