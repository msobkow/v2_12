
// Description: Java 11 DbIO interface for GelSwitch.

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
 *	CFGenKbGelSwitchTable database interface for GelSwitch
 */
public interface ICFGenKbGelSwitchTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createGelSwitch( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateGelSwitch( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteGelSwitch( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchBuff Buff );
	/**
	 *	Delete the GelSwitch instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSwitch key attribute of the instance generating the id.
	 */
	void deleteGelSwitchByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId );

	/**
	 *	Delete the GelSwitch instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteGelSwitchByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey argKey );
	/**
	 *	Delete the GelSwitch instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSwitch key attribute of the instance generating the id.
	 */
	void deleteGelSwitchByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the GelSwitch instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSwitchByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByTenantIdxKey argKey );
	/**
	 *	Delete the GelSwitch instances identified by the key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSwitch key attribute of the instance generating the id.
	 */
	void deleteGelSwitchByGelCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId );

	/**
	 *	Delete the GelSwitch instances identified by the key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSwitchByGelCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByGelCacheIdxKey argKey );
	/**
	 *	Delete the GelSwitch instances identified by the key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelSwitch key attribute of the instance generating the id.
	 */
	void deleteGelSwitchByChainIdx( CFGenKbAuthorization Authorization,
		Long argChainInstTenantId,
		Long argChainInstGelCacheId,
		Long argChainInstGelInstId );

	/**
	 *	Delete the GelSwitch instances identified by the key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSwitchByChainIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByChainIdxKey argKey );


	/**
	 *	Read the derived GelSwitch buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelSwitch instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelSwitchBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Lock the derived GelSwitch buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelSwitch instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelSwitchBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Read all GelSwitch instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFGenKbGelSwitchBuff[] readAllDerived( CFGenKbAuthorization Authorization );

	/**
	 *	Read the derived GelSwitch buffer instance identified by the unique key PIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelSwitchBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Read an array of the derived GelSwitch buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSwitchBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived GelSwitch buffer instances identified by the duplicate key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSwitchBuff[] readDerivedByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId );

	/**
	 *	Read an array of the derived GelSwitch buffer instances identified by the duplicate key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSwitchBuff[] readDerivedByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Read the specific GelSwitch buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelSwitch instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSwitchBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Lock the specific GelSwitch buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelSwitch instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSwitchBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Read all the specific GelSwitch buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific GelSwitch instances in the database accessible for the Authorization.
	 */
	CFGenKbGelSwitchBuff[] readAllBuff( CFGenKbAuthorization Authorization );

	/**
	 *	Read the specific GelSwitch buffer instance identified by the unique key PIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSwitchBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Read an array of the specific GelSwitch buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSwitchBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific GelSwitch buffer instances identified by the duplicate key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSwitchBuff[] readBuffByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId );

	/**
	 *	Read an array of the specific GelSwitch buffer instances identified by the duplicate key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelSwitch key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSwitchBuff[] readBuffByChainIdx( CFGenKbAuthorization Authorization,
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
