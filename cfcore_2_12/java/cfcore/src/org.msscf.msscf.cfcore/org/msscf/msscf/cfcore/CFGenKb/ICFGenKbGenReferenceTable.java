
// Description: Java 11 DbIO interface for GenReference.

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
 *	CFGenKbGenReferenceTable database interface for GenReference
 */
public interface ICFGenKbGenReferenceTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createGenReference( CFGenKbAuthorization Authorization,
		CFGenKbGenReferenceBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateGenReference( CFGenKbAuthorization Authorization,
		CFGenKbGenReferenceBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteGenReference( CFGenKbAuthorization Authorization,
		CFGenKbGenReferenceBuff Buff );
	/**
	 *	Delete the GenReference instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByItemIdIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId,
		long argItemId );

	/**
	 *	Delete the GenReference instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteGenReferenceByItemIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey argKey );
	/**
	 *	Delete the GenReference instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the GenReference instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenReferenceByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByTenantIdxKey argKey );
	/**
	 *	Delete the GenReference instances identified by the key CartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByCartIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId );

	/**
	 *	Delete the GenReference instances identified by the key CartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenReferenceByCartIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByCartIdxKey argKey );
	/**
	 *	Delete the GenReference instances identified by the key RuleTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRuleTypeId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short argRuleTypeId );

	/**
	 *	Delete the GenReference instances identified by the key RuleTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenReferenceByRuleTypeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByRuleTypeIdxKey argKey );
	/**
	 *	Delete the GenReference instances identified by the key ToolSetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolSetId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByToolSetIdx( CFGenKbAuthorization Authorization,
		short argToolSetId );

	/**
	 *	Delete the GenReference instances identified by the key ToolSetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenReferenceByToolSetIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByToolSetIdxKey argKey );
	/**
	 *	Delete the GenReference instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argScopeDefId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByScopeIdx( CFGenKbAuthorization Authorization,
		Short argScopeDefId );

	/**
	 *	Delete the GenReference instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenReferenceByScopeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByScopeIdxKey argKey );
	/**
	 *	Delete the GenReference instances identified by the key GenDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGenDefId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByGenDefIdx( CFGenKbAuthorization Authorization,
		short argGenDefId );

	/**
	 *	Delete the GenReference instances identified by the key GenDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenReferenceByGenDefIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGenDefIdxKey argKey );
	/**
	 *	Delete the GenReference instances identified by the key AltIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByAltIdx( CFGenKbAuthorization Authorization,
		String argName,
		short argToolSetId,
		Short argScopeDefId,
		short argGenDefId );

	/**
	 *	Delete the GenReference instances identified by the key AltIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenReferenceByAltIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByAltIdxKey argKey );
	/**
	 *	Delete the GenReference instances identified by the key GelExecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGelExecutableTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByGelExecIdx( CFGenKbAuthorization Authorization,
		Long argGelExecutableTenantId,
		Long argGelExecutableGelCacheId,
		Long argGelExecutableId );

	/**
	 *	Delete the GenReference instances identified by the key GelExecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenReferenceByGelExecIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGelExecIdxKey argKey );
	/**
	 *	Delete the GenReference instances identified by the key ProbeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argProbeTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByProbeIdx( CFGenKbAuthorization Authorization,
		Long argProbeTenantId,
		Long argProbeCartridgeId,
		Long argProbeGenItemId );

	/**
	 *	Delete the GenReference instances identified by the key ProbeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenReferenceByProbeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByProbeIdxKey argKey );


	/**
	 *	Read the derived GenReference buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GenReference instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGenReferenceBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey );

	/**
	 *	Lock the derived GenReference buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GenReference instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGenReferenceBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey );

	/**
	 *	Read all GenReference instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFGenKbGenReferenceBuff[] readAllDerived( CFGenKbAuthorization Authorization );

	/**
	 *	Read the derived GenReference buffer instance identified by the unique key ItemIdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGenReferenceBuff readDerivedByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId );

	/**
	 *	Read an array of the derived GenReference buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenReferenceBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived GenReference buffer instances identified by the duplicate key CartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenReferenceBuff[] readDerivedByCartIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId );

	/**
	 *	Read an array of the derived GenReference buffer instances identified by the duplicate key RuleTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRuleTypeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenReferenceBuff[] readDerivedByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short RuleTypeId );

	/**
	 *	Read an array of the derived GenReference buffer instances identified by the duplicate key ToolSetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolSetId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenReferenceBuff[] readDerivedByToolSetIdx( CFGenKbAuthorization Authorization,
		short ToolSetId );

	/**
	 *	Read an array of the derived GenReference buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argScopeDefId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenReferenceBuff[] readDerivedByScopeIdx( CFGenKbAuthorization Authorization,
		Short ScopeDefId );

	/**
	 *	Read an array of the derived GenReference buffer instances identified by the duplicate key GenDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGenDefId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenReferenceBuff[] readDerivedByGenDefIdx( CFGenKbAuthorization Authorization,
		short GenDefId );

	/**
	 *	Read the derived GenReference buffer instance identified by the unique key AltIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGenReferenceBuff readDerivedByAltIdx( CFGenKbAuthorization Authorization,
		String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId );

	/**
	 *	Read an array of the derived GenReference buffer instances identified by the duplicate key GelExecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGelExecutableTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenReferenceBuff[] readDerivedByGelExecIdx( CFGenKbAuthorization Authorization,
		Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId );

	/**
	 *	Read an array of the derived GenReference buffer instances identified by the duplicate key ProbeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argProbeTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenReferenceBuff[] readDerivedByProbeIdx( CFGenKbAuthorization Authorization,
		Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId );

	/**
	 *	Read the specific GenReference buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GenReference instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenReferenceBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey );

	/**
	 *	Lock the specific GenReference buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GenReference instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenReferenceBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey );

	/**
	 *	Read all the specific GenReference buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific GenReference instances in the database accessible for the Authorization.
	 */
	CFGenKbGenReferenceBuff[] readAllBuff( CFGenKbAuthorization Authorization );

	/**
	 *	Read the specific GenReference buffer instance identified by the unique key ItemIdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenReferenceBuff readBuffByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId );

	/**
	 *	Read an array of the specific GenReference buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenReferenceBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific GenReference buffer instances identified by the duplicate key CartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenReferenceBuff[] readBuffByCartIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId );

	/**
	 *	Read an array of the specific GenReference buffer instances identified by the duplicate key RuleTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRuleTypeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenReferenceBuff[] readBuffByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short RuleTypeId );

	/**
	 *	Read an array of the specific GenReference buffer instances identified by the duplicate key ToolSetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolSetId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenReferenceBuff[] readBuffByToolSetIdx( CFGenKbAuthorization Authorization,
		short ToolSetId );

	/**
	 *	Read an array of the specific GenReference buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argScopeDefId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenReferenceBuff[] readBuffByScopeIdx( CFGenKbAuthorization Authorization,
		Short ScopeDefId );

	/**
	 *	Read an array of the specific GenReference buffer instances identified by the duplicate key GenDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGenDefId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenReferenceBuff[] readBuffByGenDefIdx( CFGenKbAuthorization Authorization,
		short GenDefId );

	/**
	 *	Read the specific GenReference buffer instance identified by the unique key AltIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenReferenceBuff readBuffByAltIdx( CFGenKbAuthorization Authorization,
		String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId );

	/**
	 *	Read an array of the specific GenReference buffer instances identified by the duplicate key GelExecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGelExecutableTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenReferenceBuff[] readBuffByGelExecIdx( CFGenKbAuthorization Authorization,
		Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId );

	/**
	 *	Read an array of the specific GenReference buffer instances identified by the duplicate key ProbeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argProbeTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenReferenceBuff[] readBuffByProbeIdx( CFGenKbAuthorization Authorization,
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
