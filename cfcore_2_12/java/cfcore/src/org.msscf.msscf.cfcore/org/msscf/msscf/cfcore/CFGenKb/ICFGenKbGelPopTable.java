
// Description: Java 11 DbIO interface for GelPop.

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
 *	CFGenKbGelPopTable database interface for GelPop
 */
public interface ICFGenKbGelPopTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createGelPop( CFGenKbAuthorization Authorization,
		CFGenKbGelPopBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateGelPop( CFGenKbAuthorization Authorization,
		CFGenKbGelPopBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteGelPop( CFGenKbAuthorization Authorization,
		CFGenKbGelPopBuff Buff );
	/**
	 *	Delete the GelPop instances identified by the key RemainderIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRemainderTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderInstId	The GelPop key attribute of the instance generating the id.
	 */
	void deleteGelPopByRemainderIdx( CFGenKbAuthorization Authorization,
		Long argRemainderTenantId,
		long argRemainderGelCacheId,
		Long argRemainderInstId );

	/**
	 *	Delete the GelPop instances identified by the key RemainderIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelPopByRemainderIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelPopByRemainderIdxKey argKey );
	/**
	 *	Delete the GelPop instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelPop key attribute of the instance generating the id.
	 */
	void deleteGelPopByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId );

	/**
	 *	Delete the GelPop instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteGelPopByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey argKey );
	/**
	 *	Delete the GelPop instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelPop key attribute of the instance generating the id.
	 */
	void deleteGelPopByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the GelPop instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelPopByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByTenantIdxKey argKey );
	/**
	 *	Delete the GelPop instances identified by the key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelPop key attribute of the instance generating the id.
	 */
	void deleteGelPopByGelCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId );

	/**
	 *	Delete the GelPop instances identified by the key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelPopByGelCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByGelCacheIdxKey argKey );
	/**
	 *	Delete the GelPop instances identified by the key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelPop key attribute of the instance generating the id.
	 */
	void deleteGelPopByChainIdx( CFGenKbAuthorization Authorization,
		Long argChainInstTenantId,
		Long argChainInstGelCacheId,
		Long argChainInstGelInstId );

	/**
	 *	Delete the GelPop instances identified by the key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelPopByChainIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByChainIdxKey argKey );


	/**
	 *	Read the derived GelPop buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelPop instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelPopBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Lock the derived GelPop buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelPop instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelPopBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Read all GelPop instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFGenKbGelPopBuff[] readAllDerived( CFGenKbAuthorization Authorization );

	/**
	 *	Read the derived GelPop buffer instance identified by the unique key PIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelPopBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Read an array of the derived GelPop buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelPopBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived GelPop buffer instances identified by the duplicate key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelPopBuff[] readDerivedByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId );

	/**
	 *	Read an array of the derived GelPop buffer instances identified by the duplicate key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelPopBuff[] readDerivedByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Read an array of the derived GelPop buffer instances identified by the duplicate key RemainderIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRemainderTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderInstId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelPopBuff[] readDerivedByRemainderIdx( CFGenKbAuthorization Authorization,
		Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId );

	/**
	 *	Read the specific GelPop buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelPop instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelPopBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Lock the specific GelPop buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelPop instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelPopBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Read all the specific GelPop buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific GelPop instances in the database accessible for the Authorization.
	 */
	CFGenKbGelPopBuff[] readAllBuff( CFGenKbAuthorization Authorization );

	/**
	 *	Read the specific GelPop buffer instance identified by the unique key PIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelPopBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Read an array of the specific GelPop buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelPopBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific GelPop buffer instances identified by the duplicate key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelPopBuff[] readBuffByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId );

	/**
	 *	Read an array of the specific GelPop buffer instances identified by the duplicate key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelPopBuff[] readBuffByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Read an array of the specific GelPop buffer instances identified by the duplicate key RemainderIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRemainderTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderInstId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelPopBuff[] readBuffByRemainderIdx( CFGenKbAuthorization Authorization,
		Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
