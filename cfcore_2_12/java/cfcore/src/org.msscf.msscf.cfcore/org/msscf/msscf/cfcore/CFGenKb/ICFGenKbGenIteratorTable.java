
// Description: Java 11 DbIO interface for GenIterator.

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
 *	CFGenKbGenIteratorTable database interface for GenIterator
 */
public interface ICFGenKbGenIteratorTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createGenIterator( CFGenKbAuthorization Authorization,
		CFGenKbGenIteratorBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateGenIterator( CFGenKbAuthorization Authorization,
		CFGenKbGenIteratorBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteGenIterator( CFGenKbAuthorization Authorization,
		CFGenKbGenIteratorBuff Buff );
	/**
	 *	Delete the GenIterator instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByItemIdIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId,
		long argItemId );

	/**
	 *	Delete the GenIterator instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteGenIteratorByItemIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey argKey );
	/**
	 *	Delete the GenIterator instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the GenIterator instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenIteratorByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByTenantIdxKey argKey );
	/**
	 *	Delete the GenIterator instances identified by the key CartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByCartIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId );

	/**
	 *	Delete the GenIterator instances identified by the key CartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenIteratorByCartIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByCartIdxKey argKey );
	/**
	 *	Delete the GenIterator instances identified by the key RuleTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRuleTypeId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short argRuleTypeId );

	/**
	 *	Delete the GenIterator instances identified by the key RuleTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenIteratorByRuleTypeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByRuleTypeIdxKey argKey );
	/**
	 *	Delete the GenIterator instances identified by the key ToolSetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolSetId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByToolSetIdx( CFGenKbAuthorization Authorization,
		short argToolSetId );

	/**
	 *	Delete the GenIterator instances identified by the key ToolSetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenIteratorByToolSetIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByToolSetIdxKey argKey );
	/**
	 *	Delete the GenIterator instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argScopeDefId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByScopeIdx( CFGenKbAuthorization Authorization,
		Short argScopeDefId );

	/**
	 *	Delete the GenIterator instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenIteratorByScopeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByScopeIdxKey argKey );
	/**
	 *	Delete the GenIterator instances identified by the key GenDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGenDefId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByGenDefIdx( CFGenKbAuthorization Authorization,
		short argGenDefId );

	/**
	 *	Delete the GenIterator instances identified by the key GenDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenIteratorByGenDefIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGenDefIdxKey argKey );
	/**
	 *	Delete the GenIterator instances identified by the key AltIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByAltIdx( CFGenKbAuthorization Authorization,
		String argName,
		short argToolSetId,
		Short argScopeDefId,
		short argGenDefId );

	/**
	 *	Delete the GenIterator instances identified by the key AltIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenIteratorByAltIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByAltIdxKey argKey );
	/**
	 *	Delete the GenIterator instances identified by the key GelExecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGelExecutableTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByGelExecIdx( CFGenKbAuthorization Authorization,
		Long argGelExecutableTenantId,
		Long argGelExecutableGelCacheId,
		Long argGelExecutableId );

	/**
	 *	Delete the GenIterator instances identified by the key GelExecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenIteratorByGelExecIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGelExecIdxKey argKey );
	/**
	 *	Delete the GenIterator instances identified by the key ProbeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argProbeTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenIterator key attribute of the instance generating the id.
	 */
	void deleteGenIteratorByProbeIdx( CFGenKbAuthorization Authorization,
		Long argProbeTenantId,
		Long argProbeCartridgeId,
		Long argProbeGenItemId );

	/**
	 *	Delete the GenIterator instances identified by the key ProbeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenIteratorByProbeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByProbeIdxKey argKey );


	/**
	 *	Read the derived GenIterator buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GenIterator instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGenIteratorBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey );

	/**
	 *	Lock the derived GenIterator buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GenIterator instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGenIteratorBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey );

	/**
	 *	Read all GenIterator instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFGenKbGenIteratorBuff[] readAllDerived( CFGenKbAuthorization Authorization );

	/**
	 *	Read the derived GenIterator buffer instance identified by the unique key ItemIdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGenIteratorBuff readDerivedByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId );

	/**
	 *	Read an array of the derived GenIterator buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenIteratorBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived GenIterator buffer instances identified by the duplicate key CartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenIteratorBuff[] readDerivedByCartIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId );

	/**
	 *	Read an array of the derived GenIterator buffer instances identified by the duplicate key RuleTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRuleTypeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenIteratorBuff[] readDerivedByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short RuleTypeId );

	/**
	 *	Read an array of the derived GenIterator buffer instances identified by the duplicate key ToolSetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolSetId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenIteratorBuff[] readDerivedByToolSetIdx( CFGenKbAuthorization Authorization,
		short ToolSetId );

	/**
	 *	Read an array of the derived GenIterator buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argScopeDefId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenIteratorBuff[] readDerivedByScopeIdx( CFGenKbAuthorization Authorization,
		Short ScopeDefId );

	/**
	 *	Read an array of the derived GenIterator buffer instances identified by the duplicate key GenDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGenDefId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenIteratorBuff[] readDerivedByGenDefIdx( CFGenKbAuthorization Authorization,
		short GenDefId );

	/**
	 *	Read the derived GenIterator buffer instance identified by the unique key AltIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGenIteratorBuff readDerivedByAltIdx( CFGenKbAuthorization Authorization,
		String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId );

	/**
	 *	Read an array of the derived GenIterator buffer instances identified by the duplicate key GelExecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGelExecutableTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenIteratorBuff[] readDerivedByGelExecIdx( CFGenKbAuthorization Authorization,
		Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId );

	/**
	 *	Read an array of the derived GenIterator buffer instances identified by the duplicate key ProbeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argProbeTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenIteratorBuff[] readDerivedByProbeIdx( CFGenKbAuthorization Authorization,
		Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId );

	/**
	 *	Read the specific GenIterator buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GenIterator instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenIteratorBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey );

	/**
	 *	Lock the specific GenIterator buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GenIterator instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenIteratorBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey );

	/**
	 *	Read all the specific GenIterator buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific GenIterator instances in the database accessible for the Authorization.
	 */
	CFGenKbGenIteratorBuff[] readAllBuff( CFGenKbAuthorization Authorization );

	/**
	 *	Read the specific GenIterator buffer instance identified by the unique key ItemIdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenIteratorBuff readBuffByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId );

	/**
	 *	Read an array of the specific GenIterator buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenIteratorBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific GenIterator buffer instances identified by the duplicate key CartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenIteratorBuff[] readBuffByCartIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId );

	/**
	 *	Read an array of the specific GenIterator buffer instances identified by the duplicate key RuleTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRuleTypeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenIteratorBuff[] readBuffByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short RuleTypeId );

	/**
	 *	Read an array of the specific GenIterator buffer instances identified by the duplicate key ToolSetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolSetId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenIteratorBuff[] readBuffByToolSetIdx( CFGenKbAuthorization Authorization,
		short ToolSetId );

	/**
	 *	Read an array of the specific GenIterator buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argScopeDefId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenIteratorBuff[] readBuffByScopeIdx( CFGenKbAuthorization Authorization,
		Short ScopeDefId );

	/**
	 *	Read an array of the specific GenIterator buffer instances identified by the duplicate key GenDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGenDefId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenIteratorBuff[] readBuffByGenDefIdx( CFGenKbAuthorization Authorization,
		short GenDefId );

	/**
	 *	Read the specific GenIterator buffer instance identified by the unique key AltIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenIteratorBuff readBuffByAltIdx( CFGenKbAuthorization Authorization,
		String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId );

	/**
	 *	Read an array of the specific GenIterator buffer instances identified by the duplicate key GelExecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGelExecutableTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenIteratorBuff[] readBuffByGelExecIdx( CFGenKbAuthorization Authorization,
		Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId );

	/**
	 *	Read an array of the specific GenIterator buffer instances identified by the duplicate key ProbeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argProbeTenantId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenIteratorBuff[] readBuffByProbeIdx( CFGenKbAuthorization Authorization,
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
