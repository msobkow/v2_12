
// Description: Java 11 DbIO interface for GenFile.

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
 *	CFGenKbGenFileTable database interface for GenFile
 */
public interface ICFGenKbGenFileTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createGenFile( CFGenKbAuthorization Authorization,
		CFGenKbGenFileBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateGenFile( CFGenKbAuthorization Authorization,
		CFGenKbGenFileBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteGenFile( CFGenKbAuthorization Authorization,
		CFGenKbGenFileBuff Buff );
	/**
	 *	Delete the GenFile instances identified by the key XSrcBundle.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSourceBundleTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argSourceBundleGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argSourceBundleGelId	The GenFile key attribute of the instance generating the id.
	 */
	void deleteGenFileByXSrcBundle( CFGenKbAuthorization Authorization,
		Long argSourceBundleTenantId,
		Long argSourceBundleGelCacheId,
		Long argSourceBundleGelId );

	/**
	 *	Delete the GenFile instances identified by the key XSrcBundle.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenFileByXSrcBundle( CFGenKbAuthorization Authorization,
		CFGenKbGenFileByXSrcBundleKey argKey );
	/**
	 *	Delete the GenFile instances identified by the key XModName.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argModuleNameTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argModuleNameGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argModuleNameGelId	The GenFile key attribute of the instance generating the id.
	 */
	void deleteGenFileByXModName( CFGenKbAuthorization Authorization,
		Long argModuleNameTenantId,
		Long argModuleNameGelCacheId,
		Long argModuleNameGelId );

	/**
	 *	Delete the GenFile instances identified by the key XModName.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenFileByXModName( CFGenKbAuthorization Authorization,
		CFGenKbGenFileByXModNameKey argKey );
	/**
	 *	Delete the GenFile instances identified by the key XBasePkg.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argBasePackageTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argBasePackageGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argBasePackageGelId	The GenFile key attribute of the instance generating the id.
	 */
	void deleteGenFileByXBasePkg( CFGenKbAuthorization Authorization,
		Long argBasePackageTenantId,
		Long argBasePackageGelCacheId,
		Long argBasePackageGelId );

	/**
	 *	Delete the GenFile instances identified by the key XBasePkg.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenFileByXBasePkg( CFGenKbAuthorization Authorization,
		CFGenKbGenFileByXBasePkgKey argKey );
	/**
	 *	Delete the GenFile instances identified by the key XSubPkg.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSubPackageTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argSubPackageGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argSubPackageGelId	The GenFile key attribute of the instance generating the id.
	 */
	void deleteGenFileByXSubPkg( CFGenKbAuthorization Authorization,
		Long argSubPackageTenantId,
		Long argSubPackageGelCacheId,
		Long argSubPackageGelId );

	/**
	 *	Delete the GenFile instances identified by the key XSubPkg.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenFileByXSubPkg( CFGenKbAuthorization Authorization,
		CFGenKbGenFileByXSubPkgKey argKey );
	/**
	 *	Delete the GenFile instances identified by the key XExpClsName.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpansionClassNameTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argExpansionClassNameGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argExpansionClassNameGelId	The GenFile key attribute of the instance generating the id.
	 */
	void deleteGenFileByXExpClsName( CFGenKbAuthorization Authorization,
		Long argExpansionClassNameTenantId,
		Long argExpansionClassNameGelCacheId,
		Long argExpansionClassNameGelId );

	/**
	 *	Delete the GenFile instances identified by the key XExpClsName.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenFileByXExpClsName( CFGenKbAuthorization Authorization,
		CFGenKbGenFileByXExpClsNameKey argKey );
	/**
	 *	Delete the GenFile instances identified by the key XExpKeyName.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpansionKeyNameTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argExpansionKeyNameGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argExpansionKeyNameGelId	The GenFile key attribute of the instance generating the id.
	 */
	void deleteGenFileByXExpKeyName( CFGenKbAuthorization Authorization,
		Long argExpansionKeyNameTenantId,
		Long argExpansionKeyNameGelCacheId,
		Long argExpansionKeyNameGelId );

	/**
	 *	Delete the GenFile instances identified by the key XExpKeyName.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenFileByXExpKeyName( CFGenKbAuthorization Authorization,
		CFGenKbGenFileByXExpKeyNameKey argKey );
	/**
	 *	Delete the GenFile instances identified by the key XExpFileName.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpansionFileNameTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argExpansionFileNameGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argExpansionFileNameGelId	The GenFile key attribute of the instance generating the id.
	 */
	void deleteGenFileByXExpFileName( CFGenKbAuthorization Authorization,
		Long argExpansionFileNameTenantId,
		Long argExpansionFileNameGelCacheId,
		Long argExpansionFileNameGelId );

	/**
	 *	Delete the GenFile instances identified by the key XExpFileName.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenFileByXExpFileName( CFGenKbAuthorization Authorization,
		CFGenKbGenFileByXExpFileNameKey argKey );
	/**
	 *	Delete the GenFile instances identified by the key BodyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argBodyTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argBodyGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argBodyGelId	The GenFile key attribute of the instance generating the id.
	 */
	void deleteGenFileByBodyIdx( CFGenKbAuthorization Authorization,
		Long argBodyTenantId,
		Long argBodyGelCacheId,
		Long argBodyGelId );

	/**
	 *	Delete the GenFile instances identified by the key BodyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenFileByBodyIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenRuleByBodyIdxKey argKey );
	/**
	 *	Delete the GenFile instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenFile key attribute of the instance generating the id.
	 */
	void deleteGenFileByItemIdIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId,
		long argItemId );

	/**
	 *	Delete the GenFile instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteGenFileByItemIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey argKey );
	/**
	 *	Delete the GenFile instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenFile key attribute of the instance generating the id.
	 */
	void deleteGenFileByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the GenFile instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenFileByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByTenantIdxKey argKey );
	/**
	 *	Delete the GenFile instances identified by the key CartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenFile key attribute of the instance generating the id.
	 */
	void deleteGenFileByCartIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId );

	/**
	 *	Delete the GenFile instances identified by the key CartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenFileByCartIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByCartIdxKey argKey );
	/**
	 *	Delete the GenFile instances identified by the key RuleTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRuleTypeId	The GenFile key attribute of the instance generating the id.
	 */
	void deleteGenFileByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short argRuleTypeId );

	/**
	 *	Delete the GenFile instances identified by the key RuleTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenFileByRuleTypeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByRuleTypeIdxKey argKey );
	/**
	 *	Delete the GenFile instances identified by the key ToolSetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolSetId	The GenFile key attribute of the instance generating the id.
	 */
	void deleteGenFileByToolSetIdx( CFGenKbAuthorization Authorization,
		short argToolSetId );

	/**
	 *	Delete the GenFile instances identified by the key ToolSetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenFileByToolSetIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByToolSetIdxKey argKey );
	/**
	 *	Delete the GenFile instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argScopeDefId	The GenFile key attribute of the instance generating the id.
	 */
	void deleteGenFileByScopeIdx( CFGenKbAuthorization Authorization,
		Short argScopeDefId );

	/**
	 *	Delete the GenFile instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenFileByScopeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByScopeIdxKey argKey );
	/**
	 *	Delete the GenFile instances identified by the key GenDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGenDefId	The GenFile key attribute of the instance generating the id.
	 */
	void deleteGenFileByGenDefIdx( CFGenKbAuthorization Authorization,
		short argGenDefId );

	/**
	 *	Delete the GenFile instances identified by the key GenDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenFileByGenDefIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGenDefIdxKey argKey );
	/**
	 *	Delete the GenFile instances identified by the key AltIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenFile key attribute of the instance generating the id.
	 */
	void deleteGenFileByAltIdx( CFGenKbAuthorization Authorization,
		String argName,
		short argToolSetId,
		Short argScopeDefId,
		short argGenDefId );

	/**
	 *	Delete the GenFile instances identified by the key AltIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenFileByAltIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByAltIdxKey argKey );
	/**
	 *	Delete the GenFile instances identified by the key GelExecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGelExecutableTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenFile key attribute of the instance generating the id.
	 */
	void deleteGenFileByGelExecIdx( CFGenKbAuthorization Authorization,
		Long argGelExecutableTenantId,
		Long argGelExecutableGelCacheId,
		Long argGelExecutableId );

	/**
	 *	Delete the GenFile instances identified by the key GelExecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenFileByGelExecIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGelExecIdxKey argKey );
	/**
	 *	Delete the GenFile instances identified by the key ProbeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argProbeTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenFile key attribute of the instance generating the id.
	 */
	void deleteGenFileByProbeIdx( CFGenKbAuthorization Authorization,
		Long argProbeTenantId,
		Long argProbeCartridgeId,
		Long argProbeGenItemId );

	/**
	 *	Delete the GenFile instances identified by the key ProbeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteGenFileByProbeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByProbeIdxKey argKey );


	/**
	 *	Read the derived GenFile buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GenFile instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGenFileBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey );

	/**
	 *	Lock the derived GenFile buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GenFile instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGenFileBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey );

	/**
	 *	Read all GenFile instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFGenKbGenFileBuff[] readAllDerived( CFGenKbAuthorization Authorization );

	/**
	 *	Read the derived GenFile buffer instance identified by the unique key ItemIdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGenFileBuff readDerivedByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId );

	/**
	 *	Read an array of the derived GenFile buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenFileBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived GenFile buffer instances identified by the duplicate key CartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenFileBuff[] readDerivedByCartIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId );

	/**
	 *	Read an array of the derived GenFile buffer instances identified by the duplicate key RuleTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRuleTypeId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenFileBuff[] readDerivedByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short RuleTypeId );

	/**
	 *	Read an array of the derived GenFile buffer instances identified by the duplicate key ToolSetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolSetId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenFileBuff[] readDerivedByToolSetIdx( CFGenKbAuthorization Authorization,
		short ToolSetId );

	/**
	 *	Read an array of the derived GenFile buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argScopeDefId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenFileBuff[] readDerivedByScopeIdx( CFGenKbAuthorization Authorization,
		Short ScopeDefId );

	/**
	 *	Read an array of the derived GenFile buffer instances identified by the duplicate key GenDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGenDefId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenFileBuff[] readDerivedByGenDefIdx( CFGenKbAuthorization Authorization,
		short GenDefId );

	/**
	 *	Read the derived GenFile buffer instance identified by the unique key AltIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFGenKbGenFileBuff readDerivedByAltIdx( CFGenKbAuthorization Authorization,
		String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId );

	/**
	 *	Read an array of the derived GenFile buffer instances identified by the duplicate key GelExecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGelExecutableTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenFileBuff[] readDerivedByGelExecIdx( CFGenKbAuthorization Authorization,
		Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId );

	/**
	 *	Read an array of the derived GenFile buffer instances identified by the duplicate key ProbeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argProbeTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenFileBuff[] readDerivedByProbeIdx( CFGenKbAuthorization Authorization,
		Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId );

	/**
	 *	Read an array of the derived GenFile buffer instances identified by the duplicate key BodyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argBodyTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argBodyGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argBodyGelId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenFileBuff[] readDerivedByBodyIdx( CFGenKbAuthorization Authorization,
		Long BodyTenantId,
		Long BodyGelCacheId,
		Long BodyGelId );

	/**
	 *	Read an array of the derived GenFile buffer instances identified by the duplicate key XSrcBundle.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSourceBundleTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argSourceBundleGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argSourceBundleGelId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenFileBuff[] readDerivedByXSrcBundle( CFGenKbAuthorization Authorization,
		Long SourceBundleTenantId,
		Long SourceBundleGelCacheId,
		Long SourceBundleGelId );

	/**
	 *	Read an array of the derived GenFile buffer instances identified by the duplicate key XModName.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argModuleNameTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argModuleNameGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argModuleNameGelId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenFileBuff[] readDerivedByXModName( CFGenKbAuthorization Authorization,
		Long ModuleNameTenantId,
		Long ModuleNameGelCacheId,
		Long ModuleNameGelId );

	/**
	 *	Read an array of the derived GenFile buffer instances identified by the duplicate key XBasePkg.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argBasePackageTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argBasePackageGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argBasePackageGelId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenFileBuff[] readDerivedByXBasePkg( CFGenKbAuthorization Authorization,
		Long BasePackageTenantId,
		Long BasePackageGelCacheId,
		Long BasePackageGelId );

	/**
	 *	Read an array of the derived GenFile buffer instances identified by the duplicate key XSubPkg.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSubPackageTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argSubPackageGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argSubPackageGelId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenFileBuff[] readDerivedByXSubPkg( CFGenKbAuthorization Authorization,
		Long SubPackageTenantId,
		Long SubPackageGelCacheId,
		Long SubPackageGelId );

	/**
	 *	Read an array of the derived GenFile buffer instances identified by the duplicate key XExpClsName.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpansionClassNameTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argExpansionClassNameGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argExpansionClassNameGelId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenFileBuff[] readDerivedByXExpClsName( CFGenKbAuthorization Authorization,
		Long ExpansionClassNameTenantId,
		Long ExpansionClassNameGelCacheId,
		Long ExpansionClassNameGelId );

	/**
	 *	Read an array of the derived GenFile buffer instances identified by the duplicate key XExpKeyName.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpansionKeyNameTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argExpansionKeyNameGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argExpansionKeyNameGelId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenFileBuff[] readDerivedByXExpKeyName( CFGenKbAuthorization Authorization,
		Long ExpansionKeyNameTenantId,
		Long ExpansionKeyNameGelCacheId,
		Long ExpansionKeyNameGelId );

	/**
	 *	Read an array of the derived GenFile buffer instances identified by the duplicate key XExpFileName.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpansionFileNameTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argExpansionFileNameGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argExpansionFileNameGelId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFGenKbGenFileBuff[] readDerivedByXExpFileName( CFGenKbAuthorization Authorization,
		Long ExpansionFileNameTenantId,
		Long ExpansionFileNameGelCacheId,
		Long ExpansionFileNameGelId );

	/**
	 *	Read the specific GenFile buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GenFile instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey );

	/**
	 *	Lock the specific GenFile buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the GenFile instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey );

	/**
	 *	Read all the specific GenFile buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific GenFile instances in the database accessible for the Authorization.
	 */
	CFGenKbGenFileBuff[] readAllBuff( CFGenKbAuthorization Authorization );

	/**
	 *	Read the specific GenFile buffer instance identified by the unique key ItemIdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff readBuffByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId );

	/**
	 *	Read an array of the specific GenFile buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific GenFile buffer instances identified by the duplicate key CartIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff[] readBuffByCartIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId );

	/**
	 *	Read an array of the specific GenFile buffer instances identified by the duplicate key RuleTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRuleTypeId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff[] readBuffByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short RuleTypeId );

	/**
	 *	Read an array of the specific GenFile buffer instances identified by the duplicate key ToolSetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argToolSetId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff[] readBuffByToolSetIdx( CFGenKbAuthorization Authorization,
		short ToolSetId );

	/**
	 *	Read an array of the specific GenFile buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argScopeDefId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff[] readBuffByScopeIdx( CFGenKbAuthorization Authorization,
		Short ScopeDefId );

	/**
	 *	Read an array of the specific GenFile buffer instances identified by the duplicate key GenDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGenDefId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff[] readBuffByGenDefIdx( CFGenKbAuthorization Authorization,
		short GenDefId );

	/**
	 *	Read the specific GenFile buffer instance identified by the unique key AltIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff readBuffByAltIdx( CFGenKbAuthorization Authorization,
		String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId );

	/**
	 *	Read an array of the specific GenFile buffer instances identified by the duplicate key GelExecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argGelExecutableTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff[] readBuffByGelExecIdx( CFGenKbAuthorization Authorization,
		Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId );

	/**
	 *	Read an array of the specific GenFile buffer instances identified by the duplicate key ProbeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argProbeTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff[] readBuffByProbeIdx( CFGenKbAuthorization Authorization,
		Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId );

	/**
	 *	Read an array of the specific GenFile buffer instances identified by the duplicate key BodyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argBodyTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argBodyGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argBodyGelId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff[] readBuffByBodyIdx( CFGenKbAuthorization Authorization,
		Long BodyTenantId,
		Long BodyGelCacheId,
		Long BodyGelId );

	/**
	 *	Read an array of the specific GenFile buffer instances identified by the duplicate key XSrcBundle.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSourceBundleTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argSourceBundleGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argSourceBundleGelId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff[] readBuffByXSrcBundle( CFGenKbAuthorization Authorization,
		Long SourceBundleTenantId,
		Long SourceBundleGelCacheId,
		Long SourceBundleGelId );

	/**
	 *	Read an array of the specific GenFile buffer instances identified by the duplicate key XModName.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argModuleNameTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argModuleNameGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argModuleNameGelId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff[] readBuffByXModName( CFGenKbAuthorization Authorization,
		Long ModuleNameTenantId,
		Long ModuleNameGelCacheId,
		Long ModuleNameGelId );

	/**
	 *	Read an array of the specific GenFile buffer instances identified by the duplicate key XBasePkg.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argBasePackageTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argBasePackageGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argBasePackageGelId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff[] readBuffByXBasePkg( CFGenKbAuthorization Authorization,
		Long BasePackageTenantId,
		Long BasePackageGelCacheId,
		Long BasePackageGelId );

	/**
	 *	Read an array of the specific GenFile buffer instances identified by the duplicate key XSubPkg.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSubPackageTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argSubPackageGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argSubPackageGelId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff[] readBuffByXSubPkg( CFGenKbAuthorization Authorization,
		Long SubPackageTenantId,
		Long SubPackageGelCacheId,
		Long SubPackageGelId );

	/**
	 *	Read an array of the specific GenFile buffer instances identified by the duplicate key XExpClsName.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpansionClassNameTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argExpansionClassNameGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argExpansionClassNameGelId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff[] readBuffByXExpClsName( CFGenKbAuthorization Authorization,
		Long ExpansionClassNameTenantId,
		Long ExpansionClassNameGelCacheId,
		Long ExpansionClassNameGelId );

	/**
	 *	Read an array of the specific GenFile buffer instances identified by the duplicate key XExpKeyName.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpansionKeyNameTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argExpansionKeyNameGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argExpansionKeyNameGelId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff[] readBuffByXExpKeyName( CFGenKbAuthorization Authorization,
		Long ExpansionKeyNameTenantId,
		Long ExpansionKeyNameGelCacheId,
		Long ExpansionKeyNameGelId );

	/**
	 *	Read an array of the specific GenFile buffer instances identified by the duplicate key XExpFileName.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpansionFileNameTenantId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argExpansionFileNameGelCacheId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@param	argExpansionFileNameGelId	The GenFile key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbGenFileBuff[] readBuffByXExpFileName( CFGenKbAuthorization Authorization,
		Long ExpansionFileNameTenantId,
		Long ExpansionFileNameGelCacheId,
		Long ExpansionFileNameGelId );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
