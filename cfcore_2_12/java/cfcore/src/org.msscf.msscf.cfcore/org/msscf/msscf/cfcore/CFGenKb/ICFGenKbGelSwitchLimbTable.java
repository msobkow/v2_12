
// Description: Java 11 DbIO interface for GelSwitchLimb.

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
 *	CFGenKbGelSwitchLimbTable database interface for GelSwitchLimb
 */
public interface ICFGenKbGelSwitchLimbTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createGelSwitchLimb( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateGelSwitchLimb( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteGelSwitchLimb( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbBuff Buff );
	/**
	 *	Delete the GelSwitchLimb instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argLimbName	The GelSwitchLimb key attribute of the instance generating the id.
	 */
	void deleteGelSwitchLimbByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId,
		String argLimbName );

	/**
	 *	Delete the GelSwitchLimb instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteGelSwitchLimbByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbPKey argKey );
	/**
	 *	Delete the GelSwitchLimb instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSwitchLimb key attribute of the instance generating the id.
	 */
	void deleteGelSwitchLimbByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the GelSwitchLimb instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSwitchLimbByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbByTenantIdxKey argKey );
	/**
	 *	Delete the GelSwitchLimb instances identified by the key SwitchIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSwitchLimb key attribute of the instance generating the id.
	 */
	void deleteGelSwitchLimbBySwitchIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId );

	/**
	 *	Delete the GelSwitchLimb instances identified by the key SwitchIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGelSwitchLimbBySwitchIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbBySwitchIdxKey argKey );


	/**
	 *	Read the derived GelSwitchLimb buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelSwitchLimb instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelSwitchLimbBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbPKey PKey );

	/**
	 *	Lock the derived GelSwitchLimb buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelSwitchLimb instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelSwitchLimbBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbPKey PKey );

	/**
	 *	Read all GelSwitchLimb instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFGenKbGelSwitchLimbBuff[] readAllDerived( CFGenKbAuthorization Authorization );

	/**
	 *	Read the derived GelSwitchLimb buffer instance identified by the unique key PIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argLimbName	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGelSwitchLimbBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId,
		String LimbName );

	/**
	 *	Read an array of the derived GelSwitchLimb buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSwitchLimbBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived GelSwitchLimb buffer instances identified by the duplicate key SwitchIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGelSwitchLimbBuff[] readDerivedBySwitchIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Read the specific GelSwitchLimb buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelSwitchLimb instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSwitchLimbBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbPKey PKey );

	/**
	 *	Lock the specific GelSwitchLimb buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GelSwitchLimb instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSwitchLimbBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbPKey PKey );

	/**
	 *	Read all the specific GelSwitchLimb buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific GelSwitchLimb instances in the database accessible for the Authorization.
	 */
	CFGenKbGelSwitchLimbBuff[] readAllBuff( CFGenKbAuthorization Authorization );

	/**
	 *	Read the specific GelSwitchLimb buffer instance identified by the unique key PIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argLimbName	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSwitchLimbBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId,
		String LimbName );

	/**
	 *	Read an array of the specific GelSwitchLimb buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSwitchLimbBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific GelSwitchLimb buffer instances identified by the duplicate key SwitchIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGelSwitchLimbBuff[] readBuffBySwitchIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
