
// Description: Java 11 DbIO interface for GelModifier.

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
 *	CFGenKbGelModifierTable database interface for GelModifier
 */
public interface ICFGenKbGelModifierTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createGelModifier( CFGenKbAuthorization Authorization,
		CFGenKbGelModifierBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateGelModifier( CFGenKbAuthorization Authorization,
		CFGenKbGelModifierBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteGelModifier( CFGenKbAuthorization Authorization,
		CFGenKbGelModifierBuff Buff );
	/**
	 *	Delete the GelModifier instances identified by the key RemainderIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRemainderTenantId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderGelCacheId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderInstId	The GelModifier key attribute of the instance generating the id.
	 */
	void deleteGelModifierByRemainderIdx( CFGenKbAuthorization Authorization,
		Long argRemainderTenantId,
		long argRemainderGelCacheId,
		Long argRemainderInstId );

	/**
	 *	Delete the GelModifier instances identified by the key RemainderIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelModifierByRemainderIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelModifierByRemainderIdxKey argKey );
	/**
	 *	Delete the GelModifier instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelModifier key attribute of the instance generating the id.
	 */
	void deleteGelModifierByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId );

	/**
	 *	Delete the GelModifier instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteGelModifierByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey argKey );
	/**
	 *	Delete the GelModifier instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelModifier key attribute of the instance generating the id.
	 */
	void deleteGelModifierByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the GelModifier instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelModifierByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByTenantIdxKey argKey );
	/**
	 *	Delete the GelModifier instances identified by the key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelModifier key attribute of the instance generating the id.
	 */
	void deleteGelModifierByGelCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId );

	/**
	 *	Delete the GelModifier instances identified by the key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelModifierByGelCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByGelCacheIdxKey argKey );
	/**
	 *	Delete the GelModifier instances identified by the key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelModifier key attribute of the instance generating the id.
	 */
	void deleteGelModifierByChainIdx( CFGenKbAuthorization Authorization,
		Long argChainInstTenantId,
		Long argChainInstGelCacheId,
		Long argChainInstGelInstId );

	/**
	 *	Delete the GelModifier instances identified by the key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelModifierByChainIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByChainIdxKey argKey );


	/**
	 *	Read the derived GelModifier buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelModifier instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelModifierBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Lock the derived GelModifier buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelModifier instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelModifierBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Read all GelModifier instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFGenKbGelModifierBuff[] readAllDerived( CFGenKbAuthorization Authorization );

	/**
	 *	Read the derived GelModifier buffer instance identified by the unique key PIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelModifierBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Read an array of the derived GelModifier buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelModifierBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived GelModifier buffer instances identified by the duplicate key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelModifierBuff[] readDerivedByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId );

	/**
	 *	Read an array of the derived GelModifier buffer instances identified by the duplicate key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelModifierBuff[] readDerivedByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Read an array of the derived GelModifier buffer instances identified by the duplicate key RemainderIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRemainderTenantId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderGelCacheId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderInstId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelModifierBuff[] readDerivedByRemainderIdx( CFGenKbAuthorization Authorization,
		Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId );

	/**
	 *	Read the specific GelModifier buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelModifier instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelModifierBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Lock the specific GelModifier buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelModifier instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelModifierBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey );

	/**
	 *	Read all the specific GelModifier buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific GelModifier instances in the database accessible for the Authorization.
	 */
	CFGenKbGelModifierBuff[] readAllBuff( CFGenKbAuthorization Authorization );

	/**
	 *	Read the specific GelModifier buffer instance identified by the unique key PIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelModifierBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Read an array of the specific GelModifier buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelModifierBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific GelModifier buffer instances identified by the duplicate key GelCacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelModifierBuff[] readBuffByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId );

	/**
	 *	Read an array of the specific GelModifier buffer instances identified by the duplicate key ChainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argChainInstTenantId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelModifierBuff[] readBuffByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Read an array of the specific GelModifier buffer instances identified by the duplicate key RemainderIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRemainderTenantId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderGelCacheId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderInstId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelModifierBuff[] readBuffByRemainderIdx( CFGenKbAuthorization Authorization,
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
