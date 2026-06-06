
// Description: Java 11 DbIO interface for GelBuiltin.

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
 *	CFGenKbGelBuiltinTable database interface for GelBuiltin
 */
public interface ICFGenKbGelBuiltinTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createGelBuiltin( CFGenKbAuthorization Authorization,
		CFGenKbGelBuiltinBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateGelBuiltin( CFGenKbAuthorization Authorization,
		CFGenKbGelBuiltinBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteGelBuiltin( CFGenKbAuthorization Authorization,
		CFGenKbGelBuiltinBuff Buff );
	/**
	 *	Delete the GelBuiltin instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelBuiltin key attribute of the instance generating the id.
	 */
	void deleteGelBuiltinByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId );

	/**
	 *	Delete the GelBuiltin instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteGelBuiltinByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey argKey );
	/**
	 *	Delete the GelBuiltin instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelBuiltin key attribute of the instance generating the id.
	 */
	void deleteGelBuiltinByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the GelBuiltin instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelBuiltinByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByTenantIdxKey argKey );
	/**
	 *	Delete the GelBuiltin instances identified by the key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelBuiltin key attribute of the instance generating the id.
	 */
	void deleteGelBuiltinByGelCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId );

	/**
	 *	Delete the GelBuiltin instances identified by the key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelBuiltinByGelCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByGelCacheIdxKey argKey );
	/**
	 *	Delete the GelBuiltin instances identified by the key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelBuiltin key attribute of the instance generating the id.
	 */
	void deleteGelBuiltinByChainIdx( CFGenKbAuthorization Authorization,
		Long argChainInstTenantId,
		Long argChainInstGelCacheId,
		Long argChainInstGelInstId );

	/**
	 *	Delete the GelBuiltin instances identified by the key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelBuiltinByChainIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByChainIdxKey argKey );


	/**
	 *	Read the derived GelBuiltin buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelBuiltin instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelBuiltinBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Lock the derived GelBuiltin buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelBuiltin instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelBuiltinBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Read all GelBuiltin instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFGenKbGelBuiltinBuff[] readAllDerived( CFGenKbAuthorization Authorization );

	/**
	 *	Read the derived GelBuiltin buffer instance identified by the unique key PIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelBuiltinBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Read an array of the derived GelBuiltin buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelBuiltinBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived GelBuiltin buffer instances identified by the duplicate key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelBuiltinBuff[] readDerivedByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId );

	/**
	 *	Read an array of the derived GelBuiltin buffer instances identified by the duplicate key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelBuiltinBuff[] readDerivedByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Read the specific GelBuiltin buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelBuiltin instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelBuiltinBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Lock the specific GelBuiltin buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelBuiltin instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelBuiltinBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Read all the specific GelBuiltin buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific GelBuiltin instances in the database accessible for the Authorization.
	 */
	CFGenKbGelBuiltinBuff[] readAllBuff( CFGenKbAuthorization Authorization );

	/**
	 *	Read the specific GelBuiltin buffer instance identified by the unique key PIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelBuiltinBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Read an array of the specific GelBuiltin buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelBuiltinBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific GelBuiltin buffer instances identified by the duplicate key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelBuiltinBuff[] readBuffByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId );

	/**
	 *	Read an array of the specific GelBuiltin buffer instances identified by the duplicate key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelBuiltin key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelBuiltinBuff[] readBuffByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
