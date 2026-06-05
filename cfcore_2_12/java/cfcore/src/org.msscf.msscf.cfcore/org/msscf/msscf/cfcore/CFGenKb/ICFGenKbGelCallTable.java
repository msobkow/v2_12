
// Description: Java 11 DbIO interface for GelCall.

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
 *	CFGenKbGelCallTable database interface for GelCall
 */
public interface ICFGenKbGelCallTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createGelCall( CFGenKbAuthorization Authorization,
		CFGenKbGelCallBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateGelCall( CFGenKbAuthorization Authorization,
		CFGenKbGelCallBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteGelCall( CFGenKbAuthorization Authorization,
		CFGenKbGelCallBuff Buff );
	/**
	 *	Delete the GelCall instances identified by the key CacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelCall key attribute of the instance generating the id.
	 */
	void deleteGelCallByCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId );

	/**
	 *	Delete the GelCall instances identified by the key CacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelCallByCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelCallByCacheIdxKey argKey );
	/**
	 *	Delete the GelCall instances identified by the key SeqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSeqInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argSeqInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argSeqInstId	The GelCall key attribute of the instance generating the id.
	 */
	void deleteGelCallBySeqIdx( CFGenKbAuthorization Authorization,
		Long argSeqInstTenantId,
		Long argSeqInstGelCacheId,
		Long argSeqInstId );

	/**
	 *	Delete the GelCall instances identified by the key SeqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelCallBySeqIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelCallBySeqIdxKey argKey );
	/**
	 *	Delete the GelCall instances identified by the key CallInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argCallInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argCallInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argCallInstId	The GelCall key attribute of the instance generating the id.
	 */
	void deleteGelCallByCallInstIdx( CFGenKbAuthorization Authorization,
		Long argCallInstTenantId,
		Long argCallInstGelCacheId,
		Long argCallInstId );

	/**
	 *	Delete the GelCall instances identified by the key CallInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelCallByCallInstIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelCallByCallInstIdxKey argKey );
	/**
	 *	Delete the GelCall instances identified by the key PrevInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argPrevInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argPrevInstGelInstId	The GelCall key attribute of the instance generating the id.
	 */
	void deleteGelCallByPrevInstIdx( CFGenKbAuthorization Authorization,
		Long argPrevInstTenantId,
		Long argPrevInstGelCacheId,
		Long argPrevInstGelInstId );

	/**
	 *	Delete the GelCall instances identified by the key PrevInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelCallByPrevInstIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelCallByPrevInstIdxKey argKey );
	/**
	 *	Delete the GelCall instances identified by the key NextInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argNextInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argNextInstGelInstId	The GelCall key attribute of the instance generating the id.
	 */
	void deleteGelCallByNextInstIdx( CFGenKbAuthorization Authorization,
		Long argNextInstTenantId,
		Long argNextInstGelCacheId,
		Long argNextInstGelInstId );

	/**
	 *	Delete the GelCall instances identified by the key NextInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelCallByNextInstIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelCallByNextInstIdxKey argKey );
	/**
	 *	Delete the GelCall instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelCall key attribute of the instance generating the id.
	 */
	void deleteGelCallByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId );

	/**
	 *	Delete the GelCall instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteGelCallByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey argKey );
	/**
	 *	Delete the GelCall instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelCall key attribute of the instance generating the id.
	 */
	void deleteGelCallByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the GelCall instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelCallByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByTenantIdxKey argKey );
	/**
	 *	Delete the GelCall instances identified by the key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelCall key attribute of the instance generating the id.
	 */
	void deleteGelCallByGelCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId );

	/**
	 *	Delete the GelCall instances identified by the key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelCallByGelCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByGelCacheIdxKey argKey );
	/**
	 *	Delete the GelCall instances identified by the key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelCall key attribute of the instance generating the id.
	 */
	void deleteGelCallByChainIdx( CFGenKbAuthorization Authorization,
		Long argChainInstTenantId,
		Long argChainInstGelCacheId,
		Long argChainInstGelInstId );

	/**
	 *	Delete the GelCall instances identified by the key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelCallByChainIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByChainIdxKey argKey );


	/**
	 *	Read the derived GelCall buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelCall instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelCallBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Lock the derived GelCall buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelCall instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelCallBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Read all GelCall instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFGenKbGelCallBuff[] readAllDerived( CFGenKbAuthorization Authorization );

	/**
	 *	Read the derived GelCall buffer instance identified by the unique key PIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelCallBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Read an array of the derived GelCall buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelCallBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived GelCall buffer instances identified by the duplicate key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelCallBuff[] readDerivedByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId );

	/**
	 *	Read an array of the derived GelCall buffer instances identified by the duplicate key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelCallBuff[] readDerivedByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Read an array of the derived GelCall buffer instances identified by the duplicate key CacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelCallBuff[] readDerivedByCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId );

	/**
	 *	Read an array of the derived GelCall buffer instances identified by the duplicate key SeqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSeqInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argSeqInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argSeqInstId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelCallBuff[] readDerivedBySeqIdx( CFGenKbAuthorization Authorization,
		Long SeqInstTenantId,
		Long SeqInstGelCacheId,
		Long SeqInstId );

	/**
	 *	Read an array of the derived GelCall buffer instances identified by the duplicate key CallInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argCallInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argCallInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argCallInstId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelCallBuff[] readDerivedByCallInstIdx( CFGenKbAuthorization Authorization,
		Long CallInstTenantId,
		Long CallInstGelCacheId,
		Long CallInstId );

	/**
	 *	Read an array of the derived GelCall buffer instances identified by the duplicate key PrevInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argPrevInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argPrevInstGelInstId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelCallBuff[] readDerivedByPrevInstIdx( CFGenKbAuthorization Authorization,
		Long PrevInstTenantId,
		Long PrevInstGelCacheId,
		Long PrevInstGelInstId );

	/**
	 *	Read an array of the derived GelCall buffer instances identified by the duplicate key NextInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argNextInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argNextInstGelInstId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelCallBuff[] readDerivedByNextInstIdx( CFGenKbAuthorization Authorization,
		Long NextInstTenantId,
		Long NextInstGelCacheId,
		Long NextInstGelInstId );

	/**
	 *	Read the specific GelCall buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelCall instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelCallBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Lock the specific GelCall buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelCall instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelCallBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Read all the specific GelCall buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific GelCall instances in the database accessible for the Authorization.
	 */
	CFGenKbGelCallBuff[] readAllBuff( CFGenKbAuthorization Authorization );

	/**
	 *	Read the specific GelCall buffer instance identified by the unique key PIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelCallBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Read an array of the specific GelCall buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelCallBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific GelCall buffer instances identified by the duplicate key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelCallBuff[] readBuffByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId );

	/**
	 *	Read an array of the specific GelCall buffer instances identified by the duplicate key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelCallBuff[] readBuffByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Read an array of the specific GelCall buffer instances identified by the duplicate key CacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelCallBuff[] readBuffByCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId );

	/**
	 *	Read an array of the specific GelCall buffer instances identified by the duplicate key SeqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSeqInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argSeqInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argSeqInstId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelCallBuff[] readBuffBySeqIdx( CFGenKbAuthorization Authorization,
		Long SeqInstTenantId,
		Long SeqInstGelCacheId,
		Long SeqInstId );

	/**
	 *	Read an array of the specific GelCall buffer instances identified by the duplicate key CallInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argCallInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argCallInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argCallInstId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelCallBuff[] readBuffByCallInstIdx( CFGenKbAuthorization Authorization,
		Long CallInstTenantId,
		Long CallInstGelCacheId,
		Long CallInstId );

	/**
	 *	Read an array of the specific GelCall buffer instances identified by the duplicate key PrevInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argPrevInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argPrevInstGelInstId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelCallBuff[] readBuffByPrevInstIdx( CFGenKbAuthorization Authorization,
		Long PrevInstTenantId,
		Long PrevInstGelCacheId,
		Long PrevInstGelInstId );

	/**
	 *	Read an array of the specific GelCall buffer instances identified by the duplicate key NextInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argNextInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argNextInstGelInstId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelCallBuff[] readBuffByNextInstIdx( CFGenKbAuthorization Authorization,
		Long NextInstTenantId,
		Long NextInstGelCacheId,
		Long NextInstGelInstId );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
