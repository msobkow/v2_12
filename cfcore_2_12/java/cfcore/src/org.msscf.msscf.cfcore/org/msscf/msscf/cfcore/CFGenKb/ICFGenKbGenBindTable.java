
// Description: Java 11 DbIO interface for GenBind.

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
 *	CFGenKbGenBindTable database interface for GenBind
 */
public interface ICFGenKbGenBindTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createGenBind( CFGenKbAuthorization Authorization,
		CFGenKbGenBindBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateGenBind( CFGenKbAuthorization Authorization,
		CFGenKbGenBindBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteGenBind( CFGenKbAuthorization Authorization,
		CFGenKbGenBindBuff Buff );
	/**
	 *	Delete the GenBind instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByItemIdIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId,
		long argItemId );

	/**
	 *	Delete the GenBind instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteGenBindByItemIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey argKey );
	/**
	 *	Delete the GenBind instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the GenBind instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenBindByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByTenantIdxKey argKey );
	/**
	 *	Delete the GenBind instances identified by the key CartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByCartIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId );

	/**
	 *	Delete the GenBind instances identified by the key CartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenBindByCartIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByCartIdxKey argKey );
	/**
	 *	Delete the GenBind instances identified by the key RuleTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRuleTypeId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short argRuleTypeId );

	/**
	 *	Delete the GenBind instances identified by the key RuleTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenBindByRuleTypeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByRuleTypeIdxKey argKey );
	/**
	 *	Delete the GenBind instances identified by the key ToolSetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolSetId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByToolSetIdx( CFGenKbAuthorization Authorization,
		short argToolSetId );

	/**
	 *	Delete the GenBind instances identified by the key ToolSetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenBindByToolSetIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByToolSetIdxKey argKey );
	/**
	 *	Delete the GenBind instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argScopeDefId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByScopeIdx( CFGenKbAuthorization Authorization,
		Short argScopeDefId );

	/**
	 *	Delete the GenBind instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenBindByScopeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByScopeIdxKey argKey );
	/**
	 *	Delete the GenBind instances identified by the key GenDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGenDefId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByGenDefIdx( CFGenKbAuthorization Authorization,
		short argGenDefId );

	/**
	 *	Delete the GenBind instances identified by the key GenDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenBindByGenDefIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGenDefIdxKey argKey );
	/**
	 *	Delete the GenBind instances identified by the key AltIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByAltIdx( CFGenKbAuthorization Authorization,
		String argName,
		short argToolSetId,
		Short argScopeDefId,
		short argGenDefId );

	/**
	 *	Delete the GenBind instances identified by the key AltIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenBindByAltIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByAltIdxKey argKey );
	/**
	 *	Delete the GenBind instances identified by the key GelExecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGelExecutableTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByGelExecIdx( CFGenKbAuthorization Authorization,
		Long argGelExecutableTenantId,
		Long argGelExecutableGelCacheId,
		Long argGelExecutableId );

	/**
	 *	Delete the GenBind instances identified by the key GelExecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenBindByGelExecIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGelExecIdxKey argKey );
	/**
	 *	Delete the GenBind instances identified by the key ProbeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argProbeTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenBind key attribute of the instance generating the id.
	 */
	void deleteGenBindByProbeIdx( CFGenKbAuthorization Authorization,
		Long argProbeTenantId,
		Long argProbeCartridgeId,
		Long argProbeGenItemId );

	/**
	 *	Delete the GenBind instances identified by the key ProbeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenBindByProbeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByProbeIdxKey argKey );


	/**
	 *	Read the derived GenBind buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GenBind instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGenBindBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey );

	/**
	 *	Lock the derived GenBind buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GenBind instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGenBindBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey );

	/**
	 *	Read all GenBind instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFGenKbGenBindBuff[] readAllDerived( CFGenKbAuthorization Authorization );

	/**
	 *	Read the derived GenBind buffer instance identified by the unique key ItemIdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGenBindBuff readDerivedByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId );

	/**
	 *	Read an array of the derived GenBind buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenBindBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived GenBind buffer instances identified by the duplicate key CartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenBindBuff[] readDerivedByCartIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId );

	/**
	 *	Read an array of the derived GenBind buffer instances identified by the duplicate key RuleTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRuleTypeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenBindBuff[] readDerivedByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short RuleTypeId );

	/**
	 *	Read an array of the derived GenBind buffer instances identified by the duplicate key ToolSetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolSetId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenBindBuff[] readDerivedByToolSetIdx( CFGenKbAuthorization Authorization,
		short ToolSetId );

	/**
	 *	Read an array of the derived GenBind buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argScopeDefId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenBindBuff[] readDerivedByScopeIdx( CFGenKbAuthorization Authorization,
		Short ScopeDefId );

	/**
	 *	Read an array of the derived GenBind buffer instances identified by the duplicate key GenDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGenDefId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenBindBuff[] readDerivedByGenDefIdx( CFGenKbAuthorization Authorization,
		short GenDefId );

	/**
	 *	Read the derived GenBind buffer instance identified by the unique key AltIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGenBindBuff readDerivedByAltIdx( CFGenKbAuthorization Authorization,
		String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId );

	/**
	 *	Read an array of the derived GenBind buffer instances identified by the duplicate key GelExecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGelExecutableTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenBindBuff[] readDerivedByGelExecIdx( CFGenKbAuthorization Authorization,
		Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId );

	/**
	 *	Read an array of the derived GenBind buffer instances identified by the duplicate key ProbeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argProbeTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenBindBuff[] readDerivedByProbeIdx( CFGenKbAuthorization Authorization,
		Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId );

	/**
	 *	Read the specific GenBind buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GenBind instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenBindBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey );

	/**
	 *	Lock the specific GenBind buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GenBind instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenBindBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey );

	/**
	 *	Read all the specific GenBind buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific GenBind instances in the database accessible for the Authorization.
	 */
	CFGenKbGenBindBuff[] readAllBuff( CFGenKbAuthorization Authorization );

	/**
	 *	Read the specific GenBind buffer instance identified by the unique key ItemIdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenBindBuff readBuffByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId );

	/**
	 *	Read an array of the specific GenBind buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenBindBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific GenBind buffer instances identified by the duplicate key CartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenBindBuff[] readBuffByCartIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId );

	/**
	 *	Read an array of the specific GenBind buffer instances identified by the duplicate key RuleTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRuleTypeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenBindBuff[] readBuffByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short RuleTypeId );

	/**
	 *	Read an array of the specific GenBind buffer instances identified by the duplicate key ToolSetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolSetId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenBindBuff[] readBuffByToolSetIdx( CFGenKbAuthorization Authorization,
		short ToolSetId );

	/**
	 *	Read an array of the specific GenBind buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argScopeDefId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenBindBuff[] readBuffByScopeIdx( CFGenKbAuthorization Authorization,
		Short ScopeDefId );

	/**
	 *	Read an array of the specific GenBind buffer instances identified by the duplicate key GenDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGenDefId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenBindBuff[] readBuffByGenDefIdx( CFGenKbAuthorization Authorization,
		short GenDefId );

	/**
	 *	Read the specific GenBind buffer instance identified by the unique key AltIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenBindBuff readBuffByAltIdx( CFGenKbAuthorization Authorization,
		String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId );

	/**
	 *	Read an array of the specific GenBind buffer instances identified by the duplicate key GelExecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGelExecutableTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenBindBuff[] readBuffByGelExecIdx( CFGenKbAuthorization Authorization,
		Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId );

	/**
	 *	Read an array of the specific GenBind buffer instances identified by the duplicate key ProbeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argProbeTenantId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenBind key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenBindBuff[] readBuffByProbeIdx( CFGenKbAuthorization Authorization,
		Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
