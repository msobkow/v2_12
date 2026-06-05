
// Description: Java 11 DbIO interface for GelSpread.

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
 *	CFGenKbGelSpreadTable database interface for GelSpread
 */
public interface ICFGenKbGelSpreadTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createGelSpread( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateGelSpread( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteGelSpread( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadBuff Buff );
	/**
	 *	Delete the GelSpread instances identified by the key BetweenIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandBetween	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByBetweenIdx( CFGenKbAuthorization Authorization,
		String argExpandBetween );

	/**
	 *	Delete the GelSpread instances identified by the key BetweenIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSpreadByBetweenIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadByBetweenIdxKey argKey );
	/**
	 *	Delete the GelSpread instances identified by the key BeforeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandBefore	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByBeforeIdx( CFGenKbAuthorization Authorization,
		String argExpandBefore );

	/**
	 *	Delete the GelSpread instances identified by the key BeforeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSpreadByBeforeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadByBeforeIdxKey argKey );
	/**
	 *	Delete the GelSpread instances identified by the key FirstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandFirst	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByFirstIdx( CFGenKbAuthorization Authorization,
		String argExpandFirst );

	/**
	 *	Delete the GelSpread instances identified by the key FirstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSpreadByFirstIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadByFirstIdxKey argKey );
	/**
	 *	Delete the GelSpread instances identified by the key EachIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandEach	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByEachIdx( CFGenKbAuthorization Authorization,
		String argExpandEach );

	/**
	 *	Delete the GelSpread instances identified by the key EachIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSpreadByEachIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadByEachIdxKey argKey );
	/**
	 *	Delete the GelSpread instances identified by the key LastIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandLast	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByLastIdx( CFGenKbAuthorization Authorization,
		String argExpandLast );

	/**
	 *	Delete the GelSpread instances identified by the key LastIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSpreadByLastIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadByLastIdxKey argKey );
	/**
	 *	Delete the GelSpread instances identified by the key LoneIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandLone	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByLoneIdx( CFGenKbAuthorization Authorization,
		String argExpandLone );

	/**
	 *	Delete the GelSpread instances identified by the key LoneIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSpreadByLoneIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadByLoneIdxKey argKey );
	/**
	 *	Delete the GelSpread instances identified by the key EmptyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandEmpty	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByEmptyIdx( CFGenKbAuthorization Authorization,
		String argExpandEmpty );

	/**
	 *	Delete the GelSpread instances identified by the key EmptyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSpreadByEmptyIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadByEmptyIdxKey argKey );
	/**
	 *	Delete the GelSpread instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId );

	/**
	 *	Delete the GelSpread instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteGelSpreadByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey argKey );
	/**
	 *	Delete the GelSpread instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the GelSpread instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSpreadByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByTenantIdxKey argKey );
	/**
	 *	Delete the GelSpread instances identified by the key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByGelCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId );

	/**
	 *	Delete the GelSpread instances identified by the key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSpreadByGelCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByGelCacheIdxKey argKey );
	/**
	 *	Delete the GelSpread instances identified by the key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelSpread key attribute of the instance generating the id.
	 */
	void deleteGelSpreadByChainIdx( CFGenKbAuthorization Authorization,
		Long argChainInstTenantId,
		Long argChainInstGelCacheId,
		Long argChainInstGelInstId );

	/**
	 *	Delete the GelSpread instances identified by the key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSpreadByChainIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByChainIdxKey argKey );


	/**
	 *	Read the derived GelSpread buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelSpread instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelSpreadBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Lock the derived GelSpread buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelSpread instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelSpreadBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Read all GelSpread instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFGenKbGelSpreadBuff[] readAllDerived( CFGenKbAuthorization Authorization );

	/**
	 *	Read the derived GelSpread buffer instance identified by the unique key PIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelSpreadBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Read an array of the derived GelSpread buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSpreadBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived GelSpread buffer instances identified by the duplicate key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSpreadBuff[] readDerivedByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId );

	/**
	 *	Read an array of the derived GelSpread buffer instances identified by the duplicate key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSpreadBuff[] readDerivedByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Read an array of the derived GelSpread buffer instances identified by the duplicate key BetweenIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandBetween	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSpreadBuff[] readDerivedByBetweenIdx( CFGenKbAuthorization Authorization,
		String ExpandBetween );

	/**
	 *	Read an array of the derived GelSpread buffer instances identified by the duplicate key BeforeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandBefore	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSpreadBuff[] readDerivedByBeforeIdx( CFGenKbAuthorization Authorization,
		String ExpandBefore );

	/**
	 *	Read an array of the derived GelSpread buffer instances identified by the duplicate key FirstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandFirst	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSpreadBuff[] readDerivedByFirstIdx( CFGenKbAuthorization Authorization,
		String ExpandFirst );

	/**
	 *	Read an array of the derived GelSpread buffer instances identified by the duplicate key EachIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandEach	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSpreadBuff[] readDerivedByEachIdx( CFGenKbAuthorization Authorization,
		String ExpandEach );

	/**
	 *	Read an array of the derived GelSpread buffer instances identified by the duplicate key LastIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandLast	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSpreadBuff[] readDerivedByLastIdx( CFGenKbAuthorization Authorization,
		String ExpandLast );

	/**
	 *	Read an array of the derived GelSpread buffer instances identified by the duplicate key LoneIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandLone	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSpreadBuff[] readDerivedByLoneIdx( CFGenKbAuthorization Authorization,
		String ExpandLone );

	/**
	 *	Read an array of the derived GelSpread buffer instances identified by the duplicate key EmptyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandEmpty	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSpreadBuff[] readDerivedByEmptyIdx( CFGenKbAuthorization Authorization,
		String ExpandEmpty );

	/**
	 *	Read the specific GelSpread buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelSpread instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSpreadBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Lock the specific GelSpread buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelSpread instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSpreadBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Read all the specific GelSpread buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific GelSpread instances in the database accessible for the Authorization.
	 */
	CFGenKbGelSpreadBuff[] readAllBuff( CFGenKbAuthorization Authorization );

	/**
	 *	Read the specific GelSpread buffer instance identified by the unique key PIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSpreadBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Read an array of the specific GelSpread buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSpreadBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific GelSpread buffer instances identified by the duplicate key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSpreadBuff[] readBuffByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId );

	/**
	 *	Read an array of the specific GelSpread buffer instances identified by the duplicate key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSpreadBuff[] readBuffByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Read an array of the specific GelSpread buffer instances identified by the duplicate key BetweenIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandBetween	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSpreadBuff[] readBuffByBetweenIdx( CFGenKbAuthorization Authorization,
		String ExpandBetween );

	/**
	 *	Read an array of the specific GelSpread buffer instances identified by the duplicate key BeforeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandBefore	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSpreadBuff[] readBuffByBeforeIdx( CFGenKbAuthorization Authorization,
		String ExpandBefore );

	/**
	 *	Read an array of the specific GelSpread buffer instances identified by the duplicate key FirstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandFirst	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSpreadBuff[] readBuffByFirstIdx( CFGenKbAuthorization Authorization,
		String ExpandFirst );

	/**
	 *	Read an array of the specific GelSpread buffer instances identified by the duplicate key EachIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandEach	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSpreadBuff[] readBuffByEachIdx( CFGenKbAuthorization Authorization,
		String ExpandEach );

	/**
	 *	Read an array of the specific GelSpread buffer instances identified by the duplicate key LastIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandLast	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSpreadBuff[] readBuffByLastIdx( CFGenKbAuthorization Authorization,
		String ExpandLast );

	/**
	 *	Read an array of the specific GelSpread buffer instances identified by the duplicate key LoneIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandLone	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSpreadBuff[] readBuffByLoneIdx( CFGenKbAuthorization Authorization,
		String ExpandLone );

	/**
	 *	Read an array of the specific GelSpread buffer instances identified by the duplicate key EmptyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandEmpty	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSpreadBuff[] readBuffByEmptyIdx( CFGenKbAuthorization Authorization,
		String ExpandEmpty );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
