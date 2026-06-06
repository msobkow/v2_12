
// Description: Java 11 in-memory RAM DbIO implementation for GenFile.

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

package org.msscf.msscf.cfcore.CFGenKbRam;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cfcore.CFGenKbObj.*;
import org.msscf.msscf.cfcore.CFGenKbObj.*;

/*
 *	CFGenKbRamGenFileTable in-memory RAM DbIO implementation
 *	for GenFile.
 */
public class CFGenKbRamGenFileTable
	implements ICFGenKbGenFileTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGenItemPKey,
				CFGenKbGenFileBuff > dictByPKey
		= new HashMap< CFGenKbGenItemPKey,
				CFGenKbGenFileBuff >();
	private Map< CFGenKbGenFileByXSrcBundleKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenFileBuff >> dictByXSrcBundle
		= new HashMap< CFGenKbGenFileByXSrcBundleKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenFileBuff >>();
	private Map< CFGenKbGenFileByXModNameKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenFileBuff >> dictByXModName
		= new HashMap< CFGenKbGenFileByXModNameKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenFileBuff >>();
	private Map< CFGenKbGenFileByXBasePkgKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenFileBuff >> dictByXBasePkg
		= new HashMap< CFGenKbGenFileByXBasePkgKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenFileBuff >>();
	private Map< CFGenKbGenFileByXSubPkgKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenFileBuff >> dictByXSubPkg
		= new HashMap< CFGenKbGenFileByXSubPkgKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenFileBuff >>();
	private Map< CFGenKbGenFileByXExpClsNameKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenFileBuff >> dictByXExpClsName
		= new HashMap< CFGenKbGenFileByXExpClsNameKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenFileBuff >>();
	private Map< CFGenKbGenFileByXExpKeyNameKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenFileBuff >> dictByXExpKeyName
		= new HashMap< CFGenKbGenFileByXExpKeyNameKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenFileBuff >>();
	private Map< CFGenKbGenFileByXExpFileNameKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenFileBuff >> dictByXExpFileName
		= new HashMap< CFGenKbGenFileByXExpFileNameKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenFileBuff >>();

	public CFGenKbRamGenFileTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGenFile( CFGenKbAuthorization Authorization,
		CFGenKbGenFileBuff Buff )
	{
		final String S_ProcName = "createGenFile";
		schema.getTableGenRule().createGenRule( Authorization,
			Buff );
		CFGenKbGenItemPKey pkey = schema.getFactoryGenItem().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );
		pkey.setRequiredItemId( Buff.getRequiredItemId() );
		CFGenKbGenFileByXSrcBundleKey keyXSrcBundle = schema.getFactoryGenFile().newXSrcBundleKey();
		keyXSrcBundle.setOptionalSourceBundleTenantId( Buff.getOptionalSourceBundleTenantId() );
		keyXSrcBundle.setOptionalSourceBundleGelCacheId( Buff.getOptionalSourceBundleGelCacheId() );
		keyXSrcBundle.setOptionalSourceBundleGelId( Buff.getOptionalSourceBundleGelId() );

		CFGenKbGenFileByXModNameKey keyXModName = schema.getFactoryGenFile().newXModNameKey();
		keyXModName.setOptionalModuleNameTenantId( Buff.getOptionalModuleNameTenantId() );
		keyXModName.setOptionalModuleNameGelCacheId( Buff.getOptionalModuleNameGelCacheId() );
		keyXModName.setOptionalModuleNameGelId( Buff.getOptionalModuleNameGelId() );

		CFGenKbGenFileByXBasePkgKey keyXBasePkg = schema.getFactoryGenFile().newXBasePkgKey();
		keyXBasePkg.setOptionalBasePackageTenantId( Buff.getOptionalBasePackageTenantId() );
		keyXBasePkg.setOptionalBasePackageGelCacheId( Buff.getOptionalBasePackageGelCacheId() );
		keyXBasePkg.setOptionalBasePackageGelId( Buff.getOptionalBasePackageGelId() );

		CFGenKbGenFileByXSubPkgKey keyXSubPkg = schema.getFactoryGenFile().newXSubPkgKey();
		keyXSubPkg.setOptionalSubPackageTenantId( Buff.getOptionalSubPackageTenantId() );
		keyXSubPkg.setOptionalSubPackageGelCacheId( Buff.getOptionalSubPackageGelCacheId() );
		keyXSubPkg.setOptionalSubPackageGelId( Buff.getOptionalSubPackageGelId() );

		CFGenKbGenFileByXExpClsNameKey keyXExpClsName = schema.getFactoryGenFile().newXExpClsNameKey();
		keyXExpClsName.setOptionalExpansionClassNameTenantId( Buff.getOptionalExpansionClassNameTenantId() );
		keyXExpClsName.setOptionalExpansionClassNameGelCacheId( Buff.getOptionalExpansionClassNameGelCacheId() );
		keyXExpClsName.setOptionalExpansionClassNameGelId( Buff.getOptionalExpansionClassNameGelId() );

		CFGenKbGenFileByXExpKeyNameKey keyXExpKeyName = schema.getFactoryGenFile().newXExpKeyNameKey();
		keyXExpKeyName.setOptionalExpansionKeyNameTenantId( Buff.getOptionalExpansionKeyNameTenantId() );
		keyXExpKeyName.setOptionalExpansionKeyNameGelCacheId( Buff.getOptionalExpansionKeyNameGelCacheId() );
		keyXExpKeyName.setOptionalExpansionKeyNameGelId( Buff.getOptionalExpansionKeyNameGelId() );

		CFGenKbGenFileByXExpFileNameKey keyXExpFileName = schema.getFactoryGenFile().newXExpFileNameKey();
		keyXExpFileName.setOptionalExpansionFileNameTenantId( Buff.getOptionalExpansionFileNameTenantId() );
		keyXExpFileName.setOptionalExpansionFileNameGelCacheId( Buff.getOptionalExpansionFileNameGelCacheId() );
		keyXExpFileName.setOptionalExpansionFileNameGelId( Buff.getOptionalExpansionFileNameGelId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableGenRule().readDerivedByItemIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredCartridgeId(),
						Buff.getRequiredItemId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"GenRule",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXSrcBundle;
		if( dictByXSrcBundle.containsKey( keyXSrcBundle ) ) {
			subdictXSrcBundle = dictByXSrcBundle.get( keyXSrcBundle );
		}
		else {
			subdictXSrcBundle = new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXSrcBundle.put( keyXSrcBundle, subdictXSrcBundle );
		}
		subdictXSrcBundle.put( pkey, Buff );

		Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXModName;
		if( dictByXModName.containsKey( keyXModName ) ) {
			subdictXModName = dictByXModName.get( keyXModName );
		}
		else {
			subdictXModName = new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXModName.put( keyXModName, subdictXModName );
		}
		subdictXModName.put( pkey, Buff );

		Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXBasePkg;
		if( dictByXBasePkg.containsKey( keyXBasePkg ) ) {
			subdictXBasePkg = dictByXBasePkg.get( keyXBasePkg );
		}
		else {
			subdictXBasePkg = new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXBasePkg.put( keyXBasePkg, subdictXBasePkg );
		}
		subdictXBasePkg.put( pkey, Buff );

		Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXSubPkg;
		if( dictByXSubPkg.containsKey( keyXSubPkg ) ) {
			subdictXSubPkg = dictByXSubPkg.get( keyXSubPkg );
		}
		else {
			subdictXSubPkg = new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXSubPkg.put( keyXSubPkg, subdictXSubPkg );
		}
		subdictXSubPkg.put( pkey, Buff );

		Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXExpClsName;
		if( dictByXExpClsName.containsKey( keyXExpClsName ) ) {
			subdictXExpClsName = dictByXExpClsName.get( keyXExpClsName );
		}
		else {
			subdictXExpClsName = new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXExpClsName.put( keyXExpClsName, subdictXExpClsName );
		}
		subdictXExpClsName.put( pkey, Buff );

		Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXExpKeyName;
		if( dictByXExpKeyName.containsKey( keyXExpKeyName ) ) {
			subdictXExpKeyName = dictByXExpKeyName.get( keyXExpKeyName );
		}
		else {
			subdictXExpKeyName = new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXExpKeyName.put( keyXExpKeyName, subdictXExpKeyName );
		}
		subdictXExpKeyName.put( pkey, Buff );

		Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXExpFileName;
		if( dictByXExpFileName.containsKey( keyXExpFileName ) ) {
			subdictXExpFileName = dictByXExpFileName.get( keyXExpFileName );
		}
		else {
			subdictXExpFileName = new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXExpFileName.put( keyXExpFileName, subdictXExpFileName );
		}
		subdictXExpFileName.put( pkey, Buff );

	}

	public CFGenKbGenFileBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGenFile.readDerived";
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredCartridgeId( PKey.getRequiredCartridgeId() );
		key.setRequiredItemId( PKey.getRequiredItemId() );
		CFGenKbGenFileBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenFileBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGenFile.readDerived";
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredCartridgeId( PKey.getRequiredCartridgeId() );
		key.setRequiredItemId( PKey.getRequiredItemId() );
		CFGenKbGenFileBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenFileBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGenFile.readAllDerived";
		CFGenKbGenFileBuff[] retList = new CFGenKbGenFileBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGenFileBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGenFileBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByTenantIdx";
		CFGenKbGenItemBuff buffList[] = schema.getTableGenItem().readDerivedByTenantIdx( Authorization,
			TenantId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGenItemBuff buff;
			ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenFileBuff ) ) {
					filteredList.add( (CFGenKbGenFileBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
		}
	}

	public CFGenKbGenFileBuff[] readDerivedByCartIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByCartIdx";
		CFGenKbGenItemBuff buffList[] = schema.getTableGenItem().readDerivedByCartIdx( Authorization,
			TenantId,
			CartridgeId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGenItemBuff buff;
			ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenFileBuff ) ) {
					filteredList.add( (CFGenKbGenFileBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
		}
	}

	public CFGenKbGenFileBuff[] readDerivedByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short RuleTypeId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByRuleTypeIdx";
		CFGenKbGenItemBuff buffList[] = schema.getTableGenItem().readDerivedByRuleTypeIdx( Authorization,
			RuleTypeId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGenItemBuff buff;
			ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenFileBuff ) ) {
					filteredList.add( (CFGenKbGenFileBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
		}
	}

	public CFGenKbGenFileBuff[] readDerivedByToolSetIdx( CFGenKbAuthorization Authorization,
		short ToolSetId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByToolSetIdx";
		CFGenKbGenItemBuff buffList[] = schema.getTableGenItem().readDerivedByToolSetIdx( Authorization,
			ToolSetId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGenItemBuff buff;
			ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenFileBuff ) ) {
					filteredList.add( (CFGenKbGenFileBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
		}
	}

	public CFGenKbGenFileBuff[] readDerivedByScopeIdx( CFGenKbAuthorization Authorization,
		Short ScopeDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByScopeIdx";
		CFGenKbGenItemBuff buffList[] = schema.getTableGenItem().readDerivedByScopeIdx( Authorization,
			ScopeDefId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGenItemBuff buff;
			ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenFileBuff ) ) {
					filteredList.add( (CFGenKbGenFileBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
		}
	}

	public CFGenKbGenFileBuff[] readDerivedByGenDefIdx( CFGenKbAuthorization Authorization,
		short GenDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByGenDefIdx";
		CFGenKbGenItemBuff buffList[] = schema.getTableGenItem().readDerivedByGenDefIdx( Authorization,
			GenDefId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGenItemBuff buff;
			ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenFileBuff ) ) {
					filteredList.add( (CFGenKbGenFileBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
		}
	}

	public CFGenKbGenFileBuff readDerivedByAltIdx( CFGenKbAuthorization Authorization,
		String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByAltIdx";
		CFGenKbGenItemBuff buff = schema.getTableGenItem().readDerivedByAltIdx( Authorization,
			Name,
			ToolSetId,
			ScopeDefId,
			GenDefId );
		if( buff == null ) {
			return( null );
		}
		else if( buff instanceof CFGenKbGenFileBuff ) {
			return( (CFGenKbGenFileBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGenFileBuff[] readDerivedByGelExecIdx( CFGenKbAuthorization Authorization,
		Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByGelExecIdx";
		CFGenKbGenItemBuff buffList[] = schema.getTableGenItem().readDerivedByGelExecIdx( Authorization,
			GelExecutableTenantId,
			GelExecutableGelCacheId,
			GelExecutableId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGenItemBuff buff;
			ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenFileBuff ) ) {
					filteredList.add( (CFGenKbGenFileBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
		}
	}

	public CFGenKbGenFileBuff[] readDerivedByProbeIdx( CFGenKbAuthorization Authorization,
		Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByProbeIdx";
		CFGenKbGenItemBuff buffList[] = schema.getTableGenItem().readDerivedByProbeIdx( Authorization,
			ProbeTenantId,
			ProbeCartridgeId,
			ProbeGenItemId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGenItemBuff buff;
			ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenFileBuff ) ) {
					filteredList.add( (CFGenKbGenFileBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
		}
	}

	public CFGenKbGenFileBuff[] readDerivedByBodyIdx( CFGenKbAuthorization Authorization,
		Long BodyTenantId,
		Long BodyGelCacheId,
		Long BodyGelId )
	{
		final String S_ProcName = "CFGenKbRamGenRule.readDerivedByBodyIdx";
		CFGenKbGenRuleBuff buffList[] = schema.getTableGenRule().readDerivedByBodyIdx( Authorization,
			BodyTenantId,
			BodyGelCacheId,
			BodyGelId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGenRuleBuff buff;
			ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenFileBuff ) ) {
					filteredList.add( (CFGenKbGenFileBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
		}
	}

	public CFGenKbGenFileBuff[] readDerivedByXSrcBundle( CFGenKbAuthorization Authorization,
		Long SourceBundleTenantId,
		Long SourceBundleGelCacheId,
		Long SourceBundleGelId )
	{
		final String S_ProcName = "CFGenKbRamGenFile.readDerivedByXSrcBundle";
		CFGenKbGenFileByXSrcBundleKey key = schema.getFactoryGenFile().newXSrcBundleKey();
		key.setOptionalSourceBundleTenantId( SourceBundleTenantId );
		key.setOptionalSourceBundleGelCacheId( SourceBundleGelCacheId );
		key.setOptionalSourceBundleGelId( SourceBundleGelId );

		CFGenKbGenFileBuff[] recArray;
		if( dictByXSrcBundle.containsKey( key ) ) {
			Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXSrcBundle
				= dictByXSrcBundle.get( key );
			recArray = new CFGenKbGenFileBuff[ subdictXSrcBundle.size() ];
			Iterator< CFGenKbGenFileBuff > iter = subdictXSrcBundle.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXSrcBundle
				= new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXSrcBundle.put( key, subdictXSrcBundle );
			recArray = new CFGenKbGenFileBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGenFileBuff[] readDerivedByXModName( CFGenKbAuthorization Authorization,
		Long ModuleNameTenantId,
		Long ModuleNameGelCacheId,
		Long ModuleNameGelId )
	{
		final String S_ProcName = "CFGenKbRamGenFile.readDerivedByXModName";
		CFGenKbGenFileByXModNameKey key = schema.getFactoryGenFile().newXModNameKey();
		key.setOptionalModuleNameTenantId( ModuleNameTenantId );
		key.setOptionalModuleNameGelCacheId( ModuleNameGelCacheId );
		key.setOptionalModuleNameGelId( ModuleNameGelId );

		CFGenKbGenFileBuff[] recArray;
		if( dictByXModName.containsKey( key ) ) {
			Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXModName
				= dictByXModName.get( key );
			recArray = new CFGenKbGenFileBuff[ subdictXModName.size() ];
			Iterator< CFGenKbGenFileBuff > iter = subdictXModName.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXModName
				= new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXModName.put( key, subdictXModName );
			recArray = new CFGenKbGenFileBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGenFileBuff[] readDerivedByXBasePkg( CFGenKbAuthorization Authorization,
		Long BasePackageTenantId,
		Long BasePackageGelCacheId,
		Long BasePackageGelId )
	{
		final String S_ProcName = "CFGenKbRamGenFile.readDerivedByXBasePkg";
		CFGenKbGenFileByXBasePkgKey key = schema.getFactoryGenFile().newXBasePkgKey();
		key.setOptionalBasePackageTenantId( BasePackageTenantId );
		key.setOptionalBasePackageGelCacheId( BasePackageGelCacheId );
		key.setOptionalBasePackageGelId( BasePackageGelId );

		CFGenKbGenFileBuff[] recArray;
		if( dictByXBasePkg.containsKey( key ) ) {
			Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXBasePkg
				= dictByXBasePkg.get( key );
			recArray = new CFGenKbGenFileBuff[ subdictXBasePkg.size() ];
			Iterator< CFGenKbGenFileBuff > iter = subdictXBasePkg.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXBasePkg
				= new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXBasePkg.put( key, subdictXBasePkg );
			recArray = new CFGenKbGenFileBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGenFileBuff[] readDerivedByXSubPkg( CFGenKbAuthorization Authorization,
		Long SubPackageTenantId,
		Long SubPackageGelCacheId,
		Long SubPackageGelId )
	{
		final String S_ProcName = "CFGenKbRamGenFile.readDerivedByXSubPkg";
		CFGenKbGenFileByXSubPkgKey key = schema.getFactoryGenFile().newXSubPkgKey();
		key.setOptionalSubPackageTenantId( SubPackageTenantId );
		key.setOptionalSubPackageGelCacheId( SubPackageGelCacheId );
		key.setOptionalSubPackageGelId( SubPackageGelId );

		CFGenKbGenFileBuff[] recArray;
		if( dictByXSubPkg.containsKey( key ) ) {
			Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXSubPkg
				= dictByXSubPkg.get( key );
			recArray = new CFGenKbGenFileBuff[ subdictXSubPkg.size() ];
			Iterator< CFGenKbGenFileBuff > iter = subdictXSubPkg.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXSubPkg
				= new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXSubPkg.put( key, subdictXSubPkg );
			recArray = new CFGenKbGenFileBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGenFileBuff[] readDerivedByXExpClsName( CFGenKbAuthorization Authorization,
		Long ExpansionClassNameTenantId,
		Long ExpansionClassNameGelCacheId,
		Long ExpansionClassNameGelId )
	{
		final String S_ProcName = "CFGenKbRamGenFile.readDerivedByXExpClsName";
		CFGenKbGenFileByXExpClsNameKey key = schema.getFactoryGenFile().newXExpClsNameKey();
		key.setOptionalExpansionClassNameTenantId( ExpansionClassNameTenantId );
		key.setOptionalExpansionClassNameGelCacheId( ExpansionClassNameGelCacheId );
		key.setOptionalExpansionClassNameGelId( ExpansionClassNameGelId );

		CFGenKbGenFileBuff[] recArray;
		if( dictByXExpClsName.containsKey( key ) ) {
			Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXExpClsName
				= dictByXExpClsName.get( key );
			recArray = new CFGenKbGenFileBuff[ subdictXExpClsName.size() ];
			Iterator< CFGenKbGenFileBuff > iter = subdictXExpClsName.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXExpClsName
				= new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXExpClsName.put( key, subdictXExpClsName );
			recArray = new CFGenKbGenFileBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGenFileBuff[] readDerivedByXExpKeyName( CFGenKbAuthorization Authorization,
		Long ExpansionKeyNameTenantId,
		Long ExpansionKeyNameGelCacheId,
		Long ExpansionKeyNameGelId )
	{
		final String S_ProcName = "CFGenKbRamGenFile.readDerivedByXExpKeyName";
		CFGenKbGenFileByXExpKeyNameKey key = schema.getFactoryGenFile().newXExpKeyNameKey();
		key.setOptionalExpansionKeyNameTenantId( ExpansionKeyNameTenantId );
		key.setOptionalExpansionKeyNameGelCacheId( ExpansionKeyNameGelCacheId );
		key.setOptionalExpansionKeyNameGelId( ExpansionKeyNameGelId );

		CFGenKbGenFileBuff[] recArray;
		if( dictByXExpKeyName.containsKey( key ) ) {
			Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXExpKeyName
				= dictByXExpKeyName.get( key );
			recArray = new CFGenKbGenFileBuff[ subdictXExpKeyName.size() ];
			Iterator< CFGenKbGenFileBuff > iter = subdictXExpKeyName.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXExpKeyName
				= new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXExpKeyName.put( key, subdictXExpKeyName );
			recArray = new CFGenKbGenFileBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGenFileBuff[] readDerivedByXExpFileName( CFGenKbAuthorization Authorization,
		Long ExpansionFileNameTenantId,
		Long ExpansionFileNameGelCacheId,
		Long ExpansionFileNameGelId )
	{
		final String S_ProcName = "CFGenKbRamGenFile.readDerivedByXExpFileName";
		CFGenKbGenFileByXExpFileNameKey key = schema.getFactoryGenFile().newXExpFileNameKey();
		key.setOptionalExpansionFileNameTenantId( ExpansionFileNameTenantId );
		key.setOptionalExpansionFileNameGelCacheId( ExpansionFileNameGelCacheId );
		key.setOptionalExpansionFileNameGelId( ExpansionFileNameGelId );

		CFGenKbGenFileBuff[] recArray;
		if( dictByXExpFileName.containsKey( key ) ) {
			Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXExpFileName
				= dictByXExpFileName.get( key );
			recArray = new CFGenKbGenFileBuff[ subdictXExpFileName.size() ];
			Iterator< CFGenKbGenFileBuff > iter = subdictXExpFileName.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdictXExpFileName
				= new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXExpFileName.put( key, subdictXExpFileName );
			recArray = new CFGenKbGenFileBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGenFileBuff readDerivedByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByItemIdIdx() ";
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCartridgeId( CartridgeId );
		key.setRequiredItemId( ItemId );

		CFGenKbGenFileBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenFileBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGenFile.readBuff";
		CFGenKbGenFileBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "FIL" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenFileBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGenFileBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "FIL" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenFileBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGenFile.readAllBuff";
		CFGenKbGenFileBuff buff;
		ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
		CFGenKbGenFileBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "FIL" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
	}

	public CFGenKbGenFileBuff readBuffByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByItemIdIdx() ";
		CFGenKbGenFileBuff buff = readDerivedByItemIdIdx( Authorization,
			TenantId,
			CartridgeId,
			ItemId );
		if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
			return( (CFGenKbGenFileBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGenFileBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByTenantIdx() ";
		CFGenKbGenFileBuff buff;
		ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
		CFGenKbGenFileBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenFileBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
	}

	public CFGenKbGenFileBuff[] readBuffByCartIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByCartIdx() ";
		CFGenKbGenFileBuff buff;
		ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
		CFGenKbGenFileBuff[] buffList = readDerivedByCartIdx( Authorization,
			TenantId,
			CartridgeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenFileBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
	}

	public CFGenKbGenFileBuff[] readBuffByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short RuleTypeId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByRuleTypeIdx() ";
		CFGenKbGenFileBuff buff;
		ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
		CFGenKbGenFileBuff[] buffList = readDerivedByRuleTypeIdx( Authorization,
			RuleTypeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenFileBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
	}

	public CFGenKbGenFileBuff[] readBuffByToolSetIdx( CFGenKbAuthorization Authorization,
		short ToolSetId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByToolSetIdx() ";
		CFGenKbGenFileBuff buff;
		ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
		CFGenKbGenFileBuff[] buffList = readDerivedByToolSetIdx( Authorization,
			ToolSetId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenFileBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
	}

	public CFGenKbGenFileBuff[] readBuffByScopeIdx( CFGenKbAuthorization Authorization,
		Short ScopeDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByScopeIdx() ";
		CFGenKbGenFileBuff buff;
		ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
		CFGenKbGenFileBuff[] buffList = readDerivedByScopeIdx( Authorization,
			ScopeDefId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenFileBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
	}

	public CFGenKbGenFileBuff[] readBuffByGenDefIdx( CFGenKbAuthorization Authorization,
		short GenDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByGenDefIdx() ";
		CFGenKbGenFileBuff buff;
		ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
		CFGenKbGenFileBuff[] buffList = readDerivedByGenDefIdx( Authorization,
			GenDefId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenFileBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
	}

	public CFGenKbGenFileBuff readBuffByAltIdx( CFGenKbAuthorization Authorization,
		String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByAltIdx() ";
		CFGenKbGenFileBuff buff = readDerivedByAltIdx( Authorization,
			Name,
			ToolSetId,
			ScopeDefId,
			GenDefId );
		if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
			return( (CFGenKbGenFileBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGenFileBuff[] readBuffByGelExecIdx( CFGenKbAuthorization Authorization,
		Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByGelExecIdx() ";
		CFGenKbGenFileBuff buff;
		ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
		CFGenKbGenFileBuff[] buffList = readDerivedByGelExecIdx( Authorization,
			GelExecutableTenantId,
			GelExecutableGelCacheId,
			GelExecutableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenFileBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
	}

	public CFGenKbGenFileBuff[] readBuffByProbeIdx( CFGenKbAuthorization Authorization,
		Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByProbeIdx() ";
		CFGenKbGenFileBuff buff;
		ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
		CFGenKbGenFileBuff[] buffList = readDerivedByProbeIdx( Authorization,
			ProbeTenantId,
			ProbeCartridgeId,
			ProbeGenItemId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenFileBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
	}

	public CFGenKbGenFileBuff[] readBuffByBodyIdx( CFGenKbAuthorization Authorization,
		Long BodyTenantId,
		Long BodyGelCacheId,
		Long BodyGelId )
	{
		final String S_ProcName = "CFGenKbRamGenRule.readBuffByBodyIdx() ";
		CFGenKbGenFileBuff buff;
		ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
		CFGenKbGenFileBuff[] buffList = readDerivedByBodyIdx( Authorization,
			BodyTenantId,
			BodyGelCacheId,
			BodyGelId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RUL" ) ) {
				filteredList.add( (CFGenKbGenFileBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
	}

	public CFGenKbGenFileBuff[] readBuffByXSrcBundle( CFGenKbAuthorization Authorization,
		Long SourceBundleTenantId,
		Long SourceBundleGelCacheId,
		Long SourceBundleGelId )
	{
		final String S_ProcName = "CFGenKbRamGenFile.readBuffByXSrcBundle() ";
		CFGenKbGenFileBuff buff;
		ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
		CFGenKbGenFileBuff[] buffList = readDerivedByXSrcBundle( Authorization,
			SourceBundleTenantId,
			SourceBundleGelCacheId,
			SourceBundleGelId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "FIL" ) ) {
				filteredList.add( (CFGenKbGenFileBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
	}

	public CFGenKbGenFileBuff[] readBuffByXModName( CFGenKbAuthorization Authorization,
		Long ModuleNameTenantId,
		Long ModuleNameGelCacheId,
		Long ModuleNameGelId )
	{
		final String S_ProcName = "CFGenKbRamGenFile.readBuffByXModName() ";
		CFGenKbGenFileBuff buff;
		ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
		CFGenKbGenFileBuff[] buffList = readDerivedByXModName( Authorization,
			ModuleNameTenantId,
			ModuleNameGelCacheId,
			ModuleNameGelId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "FIL" ) ) {
				filteredList.add( (CFGenKbGenFileBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
	}

	public CFGenKbGenFileBuff[] readBuffByXBasePkg( CFGenKbAuthorization Authorization,
		Long BasePackageTenantId,
		Long BasePackageGelCacheId,
		Long BasePackageGelId )
	{
		final String S_ProcName = "CFGenKbRamGenFile.readBuffByXBasePkg() ";
		CFGenKbGenFileBuff buff;
		ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
		CFGenKbGenFileBuff[] buffList = readDerivedByXBasePkg( Authorization,
			BasePackageTenantId,
			BasePackageGelCacheId,
			BasePackageGelId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "FIL" ) ) {
				filteredList.add( (CFGenKbGenFileBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
	}

	public CFGenKbGenFileBuff[] readBuffByXSubPkg( CFGenKbAuthorization Authorization,
		Long SubPackageTenantId,
		Long SubPackageGelCacheId,
		Long SubPackageGelId )
	{
		final String S_ProcName = "CFGenKbRamGenFile.readBuffByXSubPkg() ";
		CFGenKbGenFileBuff buff;
		ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
		CFGenKbGenFileBuff[] buffList = readDerivedByXSubPkg( Authorization,
			SubPackageTenantId,
			SubPackageGelCacheId,
			SubPackageGelId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "FIL" ) ) {
				filteredList.add( (CFGenKbGenFileBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
	}

	public CFGenKbGenFileBuff[] readBuffByXExpClsName( CFGenKbAuthorization Authorization,
		Long ExpansionClassNameTenantId,
		Long ExpansionClassNameGelCacheId,
		Long ExpansionClassNameGelId )
	{
		final String S_ProcName = "CFGenKbRamGenFile.readBuffByXExpClsName() ";
		CFGenKbGenFileBuff buff;
		ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
		CFGenKbGenFileBuff[] buffList = readDerivedByXExpClsName( Authorization,
			ExpansionClassNameTenantId,
			ExpansionClassNameGelCacheId,
			ExpansionClassNameGelId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "FIL" ) ) {
				filteredList.add( (CFGenKbGenFileBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
	}

	public CFGenKbGenFileBuff[] readBuffByXExpKeyName( CFGenKbAuthorization Authorization,
		Long ExpansionKeyNameTenantId,
		Long ExpansionKeyNameGelCacheId,
		Long ExpansionKeyNameGelId )
	{
		final String S_ProcName = "CFGenKbRamGenFile.readBuffByXExpKeyName() ";
		CFGenKbGenFileBuff buff;
		ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
		CFGenKbGenFileBuff[] buffList = readDerivedByXExpKeyName( Authorization,
			ExpansionKeyNameTenantId,
			ExpansionKeyNameGelCacheId,
			ExpansionKeyNameGelId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "FIL" ) ) {
				filteredList.add( (CFGenKbGenFileBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
	}

	public CFGenKbGenFileBuff[] readBuffByXExpFileName( CFGenKbAuthorization Authorization,
		Long ExpansionFileNameTenantId,
		Long ExpansionFileNameGelCacheId,
		Long ExpansionFileNameGelId )
	{
		final String S_ProcName = "CFGenKbRamGenFile.readBuffByXExpFileName() ";
		CFGenKbGenFileBuff buff;
		ArrayList<CFGenKbGenFileBuff> filteredList = new ArrayList<CFGenKbGenFileBuff>();
		CFGenKbGenFileBuff[] buffList = readDerivedByXExpFileName( Authorization,
			ExpansionFileNameTenantId,
			ExpansionFileNameGelCacheId,
			ExpansionFileNameGelId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "FIL" ) ) {
				filteredList.add( (CFGenKbGenFileBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenFileBuff[0] ) );
	}

	/**
	 *	Read a page array of the specific GenFile buffer instances identified by the duplicate key BodyIdx.
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
	public CFGenKbGenFileBuff[] pageBuffByBodyIdx( CFGenKbAuthorization Authorization,
		Long BodyTenantId,
		Long BodyGelCacheId,
		Long BodyGelId,
		Long priorTenantId,
		Long priorCartridgeId,
		Long priorItemId )
	{
		final String S_ProcName = "pageBuffByBodyIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GenFile buffer instances identified by the duplicate key XSrcBundle.
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
	public CFGenKbGenFileBuff[] pageBuffByXSrcBundle( CFGenKbAuthorization Authorization,
		Long SourceBundleTenantId,
		Long SourceBundleGelCacheId,
		Long SourceBundleGelId,
		Long priorTenantId,
		Long priorCartridgeId,
		Long priorItemId )
	{
		final String S_ProcName = "pageBuffByXSrcBundle";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GenFile buffer instances identified by the duplicate key XModName.
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
	public CFGenKbGenFileBuff[] pageBuffByXModName( CFGenKbAuthorization Authorization,
		Long ModuleNameTenantId,
		Long ModuleNameGelCacheId,
		Long ModuleNameGelId,
		Long priorTenantId,
		Long priorCartridgeId,
		Long priorItemId )
	{
		final String S_ProcName = "pageBuffByXModName";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GenFile buffer instances identified by the duplicate key XBasePkg.
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
	public CFGenKbGenFileBuff[] pageBuffByXBasePkg( CFGenKbAuthorization Authorization,
		Long BasePackageTenantId,
		Long BasePackageGelCacheId,
		Long BasePackageGelId,
		Long priorTenantId,
		Long priorCartridgeId,
		Long priorItemId )
	{
		final String S_ProcName = "pageBuffByXBasePkg";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GenFile buffer instances identified by the duplicate key XSubPkg.
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
	public CFGenKbGenFileBuff[] pageBuffByXSubPkg( CFGenKbAuthorization Authorization,
		Long SubPackageTenantId,
		Long SubPackageGelCacheId,
		Long SubPackageGelId,
		Long priorTenantId,
		Long priorCartridgeId,
		Long priorItemId )
	{
		final String S_ProcName = "pageBuffByXSubPkg";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GenFile buffer instances identified by the duplicate key XExpClsName.
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
	public CFGenKbGenFileBuff[] pageBuffByXExpClsName( CFGenKbAuthorization Authorization,
		Long ExpansionClassNameTenantId,
		Long ExpansionClassNameGelCacheId,
		Long ExpansionClassNameGelId,
		Long priorTenantId,
		Long priorCartridgeId,
		Long priorItemId )
	{
		final String S_ProcName = "pageBuffByXExpClsName";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GenFile buffer instances identified by the duplicate key XExpKeyName.
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
	public CFGenKbGenFileBuff[] pageBuffByXExpKeyName( CFGenKbAuthorization Authorization,
		Long ExpansionKeyNameTenantId,
		Long ExpansionKeyNameGelCacheId,
		Long ExpansionKeyNameGelId,
		Long priorTenantId,
		Long priorCartridgeId,
		Long priorItemId )
	{
		final String S_ProcName = "pageBuffByXExpKeyName";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GenFile buffer instances identified by the duplicate key XExpFileName.
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
	public CFGenKbGenFileBuff[] pageBuffByXExpFileName( CFGenKbAuthorization Authorization,
		Long ExpansionFileNameTenantId,
		Long ExpansionFileNameGelCacheId,
		Long ExpansionFileNameGelId,
		Long priorTenantId,
		Long priorCartridgeId,
		Long priorItemId )
	{
		final String S_ProcName = "pageBuffByXExpFileName";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateGenFile( CFGenKbAuthorization Authorization,
		CFGenKbGenFileBuff Buff )
	{
		schema.getTableGenRule().updateGenRule( Authorization,
			Buff );
		CFGenKbGenItemPKey pkey = schema.getFactoryGenItem().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );
		pkey.setRequiredItemId( Buff.getRequiredItemId() );
		CFGenKbGenFileBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGenFile",
				"Existing record not found",
				"GenFile",
				pkey );
		}
		CFGenKbGenFileByXSrcBundleKey existingKeyXSrcBundle = schema.getFactoryGenFile().newXSrcBundleKey();
		existingKeyXSrcBundle.setOptionalSourceBundleTenantId( existing.getOptionalSourceBundleTenantId() );
		existingKeyXSrcBundle.setOptionalSourceBundleGelCacheId( existing.getOptionalSourceBundleGelCacheId() );
		existingKeyXSrcBundle.setOptionalSourceBundleGelId( existing.getOptionalSourceBundleGelId() );

		CFGenKbGenFileByXSrcBundleKey newKeyXSrcBundle = schema.getFactoryGenFile().newXSrcBundleKey();
		newKeyXSrcBundle.setOptionalSourceBundleTenantId( Buff.getOptionalSourceBundleTenantId() );
		newKeyXSrcBundle.setOptionalSourceBundleGelCacheId( Buff.getOptionalSourceBundleGelCacheId() );
		newKeyXSrcBundle.setOptionalSourceBundleGelId( Buff.getOptionalSourceBundleGelId() );

		CFGenKbGenFileByXModNameKey existingKeyXModName = schema.getFactoryGenFile().newXModNameKey();
		existingKeyXModName.setOptionalModuleNameTenantId( existing.getOptionalModuleNameTenantId() );
		existingKeyXModName.setOptionalModuleNameGelCacheId( existing.getOptionalModuleNameGelCacheId() );
		existingKeyXModName.setOptionalModuleNameGelId( existing.getOptionalModuleNameGelId() );

		CFGenKbGenFileByXModNameKey newKeyXModName = schema.getFactoryGenFile().newXModNameKey();
		newKeyXModName.setOptionalModuleNameTenantId( Buff.getOptionalModuleNameTenantId() );
		newKeyXModName.setOptionalModuleNameGelCacheId( Buff.getOptionalModuleNameGelCacheId() );
		newKeyXModName.setOptionalModuleNameGelId( Buff.getOptionalModuleNameGelId() );

		CFGenKbGenFileByXBasePkgKey existingKeyXBasePkg = schema.getFactoryGenFile().newXBasePkgKey();
		existingKeyXBasePkg.setOptionalBasePackageTenantId( existing.getOptionalBasePackageTenantId() );
		existingKeyXBasePkg.setOptionalBasePackageGelCacheId( existing.getOptionalBasePackageGelCacheId() );
		existingKeyXBasePkg.setOptionalBasePackageGelId( existing.getOptionalBasePackageGelId() );

		CFGenKbGenFileByXBasePkgKey newKeyXBasePkg = schema.getFactoryGenFile().newXBasePkgKey();
		newKeyXBasePkg.setOptionalBasePackageTenantId( Buff.getOptionalBasePackageTenantId() );
		newKeyXBasePkg.setOptionalBasePackageGelCacheId( Buff.getOptionalBasePackageGelCacheId() );
		newKeyXBasePkg.setOptionalBasePackageGelId( Buff.getOptionalBasePackageGelId() );

		CFGenKbGenFileByXSubPkgKey existingKeyXSubPkg = schema.getFactoryGenFile().newXSubPkgKey();
		existingKeyXSubPkg.setOptionalSubPackageTenantId( existing.getOptionalSubPackageTenantId() );
		existingKeyXSubPkg.setOptionalSubPackageGelCacheId( existing.getOptionalSubPackageGelCacheId() );
		existingKeyXSubPkg.setOptionalSubPackageGelId( existing.getOptionalSubPackageGelId() );

		CFGenKbGenFileByXSubPkgKey newKeyXSubPkg = schema.getFactoryGenFile().newXSubPkgKey();
		newKeyXSubPkg.setOptionalSubPackageTenantId( Buff.getOptionalSubPackageTenantId() );
		newKeyXSubPkg.setOptionalSubPackageGelCacheId( Buff.getOptionalSubPackageGelCacheId() );
		newKeyXSubPkg.setOptionalSubPackageGelId( Buff.getOptionalSubPackageGelId() );

		CFGenKbGenFileByXExpClsNameKey existingKeyXExpClsName = schema.getFactoryGenFile().newXExpClsNameKey();
		existingKeyXExpClsName.setOptionalExpansionClassNameTenantId( existing.getOptionalExpansionClassNameTenantId() );
		existingKeyXExpClsName.setOptionalExpansionClassNameGelCacheId( existing.getOptionalExpansionClassNameGelCacheId() );
		existingKeyXExpClsName.setOptionalExpansionClassNameGelId( existing.getOptionalExpansionClassNameGelId() );

		CFGenKbGenFileByXExpClsNameKey newKeyXExpClsName = schema.getFactoryGenFile().newXExpClsNameKey();
		newKeyXExpClsName.setOptionalExpansionClassNameTenantId( Buff.getOptionalExpansionClassNameTenantId() );
		newKeyXExpClsName.setOptionalExpansionClassNameGelCacheId( Buff.getOptionalExpansionClassNameGelCacheId() );
		newKeyXExpClsName.setOptionalExpansionClassNameGelId( Buff.getOptionalExpansionClassNameGelId() );

		CFGenKbGenFileByXExpKeyNameKey existingKeyXExpKeyName = schema.getFactoryGenFile().newXExpKeyNameKey();
		existingKeyXExpKeyName.setOptionalExpansionKeyNameTenantId( existing.getOptionalExpansionKeyNameTenantId() );
		existingKeyXExpKeyName.setOptionalExpansionKeyNameGelCacheId( existing.getOptionalExpansionKeyNameGelCacheId() );
		existingKeyXExpKeyName.setOptionalExpansionKeyNameGelId( existing.getOptionalExpansionKeyNameGelId() );

		CFGenKbGenFileByXExpKeyNameKey newKeyXExpKeyName = schema.getFactoryGenFile().newXExpKeyNameKey();
		newKeyXExpKeyName.setOptionalExpansionKeyNameTenantId( Buff.getOptionalExpansionKeyNameTenantId() );
		newKeyXExpKeyName.setOptionalExpansionKeyNameGelCacheId( Buff.getOptionalExpansionKeyNameGelCacheId() );
		newKeyXExpKeyName.setOptionalExpansionKeyNameGelId( Buff.getOptionalExpansionKeyNameGelId() );

		CFGenKbGenFileByXExpFileNameKey existingKeyXExpFileName = schema.getFactoryGenFile().newXExpFileNameKey();
		existingKeyXExpFileName.setOptionalExpansionFileNameTenantId( existing.getOptionalExpansionFileNameTenantId() );
		existingKeyXExpFileName.setOptionalExpansionFileNameGelCacheId( existing.getOptionalExpansionFileNameGelCacheId() );
		existingKeyXExpFileName.setOptionalExpansionFileNameGelId( existing.getOptionalExpansionFileNameGelId() );

		CFGenKbGenFileByXExpFileNameKey newKeyXExpFileName = schema.getFactoryGenFile().newXExpFileNameKey();
		newKeyXExpFileName.setOptionalExpansionFileNameTenantId( Buff.getOptionalExpansionFileNameTenantId() );
		newKeyXExpFileName.setOptionalExpansionFileNameGelCacheId( Buff.getOptionalExpansionFileNameGelCacheId() );
		newKeyXExpFileName.setOptionalExpansionFileNameGelId( Buff.getOptionalExpansionFileNameGelId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableGenRule().readDerivedByItemIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredCartridgeId(),
						Buff.getRequiredItemId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateGenFile",
						"Superclass",
						"SuperClass",
						"GenRule",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByXSrcBundle.get( existingKeyXSrcBundle );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByXSrcBundle.containsKey( newKeyXSrcBundle ) ) {
			subdict = dictByXSrcBundle.get( newKeyXSrcBundle );
		}
		else {
			subdict = new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXSrcBundle.put( newKeyXSrcBundle, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByXModName.get( existingKeyXModName );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByXModName.containsKey( newKeyXModName ) ) {
			subdict = dictByXModName.get( newKeyXModName );
		}
		else {
			subdict = new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXModName.put( newKeyXModName, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByXBasePkg.get( existingKeyXBasePkg );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByXBasePkg.containsKey( newKeyXBasePkg ) ) {
			subdict = dictByXBasePkg.get( newKeyXBasePkg );
		}
		else {
			subdict = new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXBasePkg.put( newKeyXBasePkg, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByXSubPkg.get( existingKeyXSubPkg );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByXSubPkg.containsKey( newKeyXSubPkg ) ) {
			subdict = dictByXSubPkg.get( newKeyXSubPkg );
		}
		else {
			subdict = new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXSubPkg.put( newKeyXSubPkg, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByXExpClsName.get( existingKeyXExpClsName );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByXExpClsName.containsKey( newKeyXExpClsName ) ) {
			subdict = dictByXExpClsName.get( newKeyXExpClsName );
		}
		else {
			subdict = new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXExpClsName.put( newKeyXExpClsName, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByXExpKeyName.get( existingKeyXExpKeyName );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByXExpKeyName.containsKey( newKeyXExpKeyName ) ) {
			subdict = dictByXExpKeyName.get( newKeyXExpKeyName );
		}
		else {
			subdict = new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXExpKeyName.put( newKeyXExpKeyName, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByXExpFileName.get( existingKeyXExpFileName );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByXExpFileName.containsKey( newKeyXExpFileName ) ) {
			subdict = dictByXExpFileName.get( newKeyXExpFileName );
		}
		else {
			subdict = new HashMap< CFGenKbGenItemPKey, CFGenKbGenFileBuff >();
			dictByXExpFileName.put( newKeyXExpFileName, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteGenFile( CFGenKbAuthorization Authorization,
		CFGenKbGenFileBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGenFileTable.deleteGenFile() ";
		String classCode;
		CFGenKbGenItemPKey pkey = schema.getFactoryGenItem().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );
		pkey.setRequiredItemId( Buff.getRequiredItemId() );
		CFGenKbGenFileBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGenFile",
				pkey );
		}
		// Short circuit self-referential code to prevent stack overflows
		if( null != schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
						existing.getOptionalSourceBundleTenantId(),
						existing.getOptionalSourceBundleGelCacheId(),
						existing.getOptionalSourceBundleGelId() ) ) {
			schema.getTableGelExecutable().deleteGelExecutableByPIdx( Authorization,
						existing.getOptionalSourceBundleTenantId(),
						existing.getOptionalSourceBundleGelCacheId(),
						existing.getOptionalSourceBundleGelId() );
		}
		// Short circuit self-referential code to prevent stack overflows
		if( null != schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
						existing.getOptionalBasePackageTenantId(),
						existing.getOptionalBasePackageGelCacheId(),
						existing.getOptionalBasePackageGelId() ) ) {
			schema.getTableGelExecutable().deleteGelExecutableByPIdx( Authorization,
						existing.getOptionalBasePackageTenantId(),
						existing.getOptionalBasePackageGelCacheId(),
						existing.getOptionalBasePackageGelId() );
		}
		// Short circuit self-referential code to prevent stack overflows
		if( null != schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
						existing.getOptionalModuleNameTenantId(),
						existing.getOptionalModuleNameGelCacheId(),
						existing.getOptionalModuleNameGelId() ) ) {
			schema.getTableGelExecutable().deleteGelExecutableByPIdx( Authorization,
						existing.getOptionalModuleNameTenantId(),
						existing.getOptionalModuleNameGelCacheId(),
						existing.getOptionalModuleNameGelId() );
		}
		// Short circuit self-referential code to prevent stack overflows
		if( null != schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
						existing.getOptionalSubPackageTenantId(),
						existing.getOptionalSubPackageGelCacheId(),
						existing.getOptionalSubPackageGelId() ) ) {
			schema.getTableGelExecutable().deleteGelExecutableByPIdx( Authorization,
						existing.getOptionalSubPackageTenantId(),
						existing.getOptionalSubPackageGelCacheId(),
						existing.getOptionalSubPackageGelId() );
		}
		// Short circuit self-referential code to prevent stack overflows
		if( null != schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
						existing.getOptionalExpansionClassNameTenantId(),
						existing.getOptionalExpansionClassNameGelCacheId(),
						existing.getOptionalExpansionClassNameGelId() ) ) {
			schema.getTableGelExecutable().deleteGelExecutableByPIdx( Authorization,
						existing.getOptionalExpansionClassNameTenantId(),
						existing.getOptionalExpansionClassNameGelCacheId(),
						existing.getOptionalExpansionClassNameGelId() );
		}
		// Short circuit self-referential code to prevent stack overflows
		if( null != schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
						existing.getOptionalExpansionKeyNameTenantId(),
						existing.getOptionalExpansionKeyNameGelCacheId(),
						existing.getOptionalExpansionKeyNameGelId() ) ) {
			schema.getTableGelExecutable().deleteGelExecutableByPIdx( Authorization,
						existing.getOptionalExpansionKeyNameTenantId(),
						existing.getOptionalExpansionKeyNameGelCacheId(),
						existing.getOptionalExpansionKeyNameGelId() );
		}
		// Short circuit self-referential code to prevent stack overflows
		if( null != schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
						existing.getOptionalExpansionFileNameTenantId(),
						existing.getOptionalExpansionFileNameGelCacheId(),
						existing.getOptionalExpansionFileNameGelId() ) ) {
			schema.getTableGelExecutable().deleteGelExecutableByPIdx( Authorization,
						existing.getOptionalExpansionFileNameTenantId(),
						existing.getOptionalExpansionFileNameGelCacheId(),
						existing.getOptionalExpansionFileNameGelId() );
		}
		// Short circuit self-referential code to prevent stack overflows
		if( null != schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
						existing.getOptionalBodyTenantId(),
						existing.getOptionalBodyGelCacheId(),
						existing.getOptionalBodyGelId() ) ) {
			schema.getTableGelExecutable().deleteGelExecutableByPIdx( Authorization,
						existing.getOptionalBodyTenantId(),
						existing.getOptionalBodyGelCacheId(),
						existing.getOptionalBodyGelId() );
		}
		// Short circuit self-referential code to prevent stack overflows
		if( null != schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
						existing.getOptionalGelExecutableTenantId(),
						existing.getOptionalGelExecutableGelCacheId(),
						existing.getOptionalGelExecutableId() ) ) {
			schema.getTableGelExecutable().deleteGelExecutableByPIdx( Authorization,
						existing.getOptionalGelExecutableTenantId(),
						existing.getOptionalGelExecutableGelCacheId(),
						existing.getOptionalGelExecutableId() );
		}
		CFGenKbGenFileByXSrcBundleKey keyXSrcBundle = schema.getFactoryGenFile().newXSrcBundleKey();
		keyXSrcBundle.setOptionalSourceBundleTenantId( existing.getOptionalSourceBundleTenantId() );
		keyXSrcBundle.setOptionalSourceBundleGelCacheId( existing.getOptionalSourceBundleGelCacheId() );
		keyXSrcBundle.setOptionalSourceBundleGelId( existing.getOptionalSourceBundleGelId() );

		CFGenKbGenFileByXModNameKey keyXModName = schema.getFactoryGenFile().newXModNameKey();
		keyXModName.setOptionalModuleNameTenantId( existing.getOptionalModuleNameTenantId() );
		keyXModName.setOptionalModuleNameGelCacheId( existing.getOptionalModuleNameGelCacheId() );
		keyXModName.setOptionalModuleNameGelId( existing.getOptionalModuleNameGelId() );

		CFGenKbGenFileByXBasePkgKey keyXBasePkg = schema.getFactoryGenFile().newXBasePkgKey();
		keyXBasePkg.setOptionalBasePackageTenantId( existing.getOptionalBasePackageTenantId() );
		keyXBasePkg.setOptionalBasePackageGelCacheId( existing.getOptionalBasePackageGelCacheId() );
		keyXBasePkg.setOptionalBasePackageGelId( existing.getOptionalBasePackageGelId() );

		CFGenKbGenFileByXSubPkgKey keyXSubPkg = schema.getFactoryGenFile().newXSubPkgKey();
		keyXSubPkg.setOptionalSubPackageTenantId( existing.getOptionalSubPackageTenantId() );
		keyXSubPkg.setOptionalSubPackageGelCacheId( existing.getOptionalSubPackageGelCacheId() );
		keyXSubPkg.setOptionalSubPackageGelId( existing.getOptionalSubPackageGelId() );

		CFGenKbGenFileByXExpClsNameKey keyXExpClsName = schema.getFactoryGenFile().newXExpClsNameKey();
		keyXExpClsName.setOptionalExpansionClassNameTenantId( existing.getOptionalExpansionClassNameTenantId() );
		keyXExpClsName.setOptionalExpansionClassNameGelCacheId( existing.getOptionalExpansionClassNameGelCacheId() );
		keyXExpClsName.setOptionalExpansionClassNameGelId( existing.getOptionalExpansionClassNameGelId() );

		CFGenKbGenFileByXExpKeyNameKey keyXExpKeyName = schema.getFactoryGenFile().newXExpKeyNameKey();
		keyXExpKeyName.setOptionalExpansionKeyNameTenantId( existing.getOptionalExpansionKeyNameTenantId() );
		keyXExpKeyName.setOptionalExpansionKeyNameGelCacheId( existing.getOptionalExpansionKeyNameGelCacheId() );
		keyXExpKeyName.setOptionalExpansionKeyNameGelId( existing.getOptionalExpansionKeyNameGelId() );

		CFGenKbGenFileByXExpFileNameKey keyXExpFileName = schema.getFactoryGenFile().newXExpFileNameKey();
		keyXExpFileName.setOptionalExpansionFileNameTenantId( existing.getOptionalExpansionFileNameTenantId() );
		keyXExpFileName.setOptionalExpansionFileNameGelCacheId( existing.getOptionalExpansionFileNameGelCacheId() );
		keyXExpFileName.setOptionalExpansionFileNameGelId( existing.getOptionalExpansionFileNameGelId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbGenItemPKey, CFGenKbGenFileBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByXSrcBundle.get( keyXSrcBundle );
		subdict.remove( pkey );

		subdict = dictByXModName.get( keyXModName );
		subdict.remove( pkey );

		subdict = dictByXBasePkg.get( keyXBasePkg );
		subdict.remove( pkey );

		subdict = dictByXSubPkg.get( keyXSubPkg );
		subdict.remove( pkey );

		subdict = dictByXExpClsName.get( keyXExpClsName );
		subdict.remove( pkey );

		subdict = dictByXExpKeyName.get( keyXExpKeyName );
		subdict.remove( pkey );

		subdict = dictByXExpFileName.get( keyXExpFileName );
		subdict.remove( pkey );

		schema.getTableGenRule().deleteGenRule( Authorization,
			Buff );
	}
	public void deleteGenFileByXSrcBundle( CFGenKbAuthorization Authorization,
		Long argSourceBundleTenantId,
		Long argSourceBundleGelCacheId,
		Long argSourceBundleGelId )
	{
		CFGenKbGenFileByXSrcBundleKey key = schema.getFactoryGenFile().newXSrcBundleKey();
		key.setOptionalSourceBundleTenantId( argSourceBundleTenantId );
		key.setOptionalSourceBundleGelCacheId( argSourceBundleGelCacheId );
		key.setOptionalSourceBundleGelId( argSourceBundleGelId );
		deleteGenFileByXSrcBundle( Authorization, key );
	}

	public void deleteGenFileByXSrcBundle( CFGenKbAuthorization Authorization,
		CFGenKbGenFileByXSrcBundleKey argKey )
	{
		CFGenKbGenFileBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalSourceBundleTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalSourceBundleGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalSourceBundleGelId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenFileBuff> matchSet = new LinkedList<CFGenKbGenFileBuff>();
		Iterator<CFGenKbGenFileBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenFileBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenFile( Authorization, cur );
		}
	}

	public void deleteGenFileByXModName( CFGenKbAuthorization Authorization,
		Long argModuleNameTenantId,
		Long argModuleNameGelCacheId,
		Long argModuleNameGelId )
	{
		CFGenKbGenFileByXModNameKey key = schema.getFactoryGenFile().newXModNameKey();
		key.setOptionalModuleNameTenantId( argModuleNameTenantId );
		key.setOptionalModuleNameGelCacheId( argModuleNameGelCacheId );
		key.setOptionalModuleNameGelId( argModuleNameGelId );
		deleteGenFileByXModName( Authorization, key );
	}

	public void deleteGenFileByXModName( CFGenKbAuthorization Authorization,
		CFGenKbGenFileByXModNameKey argKey )
	{
		CFGenKbGenFileBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalModuleNameTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalModuleNameGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalModuleNameGelId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenFileBuff> matchSet = new LinkedList<CFGenKbGenFileBuff>();
		Iterator<CFGenKbGenFileBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenFileBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenFile( Authorization, cur );
		}
	}

	public void deleteGenFileByXBasePkg( CFGenKbAuthorization Authorization,
		Long argBasePackageTenantId,
		Long argBasePackageGelCacheId,
		Long argBasePackageGelId )
	{
		CFGenKbGenFileByXBasePkgKey key = schema.getFactoryGenFile().newXBasePkgKey();
		key.setOptionalBasePackageTenantId( argBasePackageTenantId );
		key.setOptionalBasePackageGelCacheId( argBasePackageGelCacheId );
		key.setOptionalBasePackageGelId( argBasePackageGelId );
		deleteGenFileByXBasePkg( Authorization, key );
	}

	public void deleteGenFileByXBasePkg( CFGenKbAuthorization Authorization,
		CFGenKbGenFileByXBasePkgKey argKey )
	{
		CFGenKbGenFileBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalBasePackageTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalBasePackageGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalBasePackageGelId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenFileBuff> matchSet = new LinkedList<CFGenKbGenFileBuff>();
		Iterator<CFGenKbGenFileBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenFileBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenFile( Authorization, cur );
		}
	}

	public void deleteGenFileByXSubPkg( CFGenKbAuthorization Authorization,
		Long argSubPackageTenantId,
		Long argSubPackageGelCacheId,
		Long argSubPackageGelId )
	{
		CFGenKbGenFileByXSubPkgKey key = schema.getFactoryGenFile().newXSubPkgKey();
		key.setOptionalSubPackageTenantId( argSubPackageTenantId );
		key.setOptionalSubPackageGelCacheId( argSubPackageGelCacheId );
		key.setOptionalSubPackageGelId( argSubPackageGelId );
		deleteGenFileByXSubPkg( Authorization, key );
	}

	public void deleteGenFileByXSubPkg( CFGenKbAuthorization Authorization,
		CFGenKbGenFileByXSubPkgKey argKey )
	{
		CFGenKbGenFileBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalSubPackageTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalSubPackageGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalSubPackageGelId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenFileBuff> matchSet = new LinkedList<CFGenKbGenFileBuff>();
		Iterator<CFGenKbGenFileBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenFileBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenFile( Authorization, cur );
		}
	}

	public void deleteGenFileByXExpClsName( CFGenKbAuthorization Authorization,
		Long argExpansionClassNameTenantId,
		Long argExpansionClassNameGelCacheId,
		Long argExpansionClassNameGelId )
	{
		CFGenKbGenFileByXExpClsNameKey key = schema.getFactoryGenFile().newXExpClsNameKey();
		key.setOptionalExpansionClassNameTenantId( argExpansionClassNameTenantId );
		key.setOptionalExpansionClassNameGelCacheId( argExpansionClassNameGelCacheId );
		key.setOptionalExpansionClassNameGelId( argExpansionClassNameGelId );
		deleteGenFileByXExpClsName( Authorization, key );
	}

	public void deleteGenFileByXExpClsName( CFGenKbAuthorization Authorization,
		CFGenKbGenFileByXExpClsNameKey argKey )
	{
		CFGenKbGenFileBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalExpansionClassNameTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalExpansionClassNameGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalExpansionClassNameGelId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenFileBuff> matchSet = new LinkedList<CFGenKbGenFileBuff>();
		Iterator<CFGenKbGenFileBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenFileBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenFile( Authorization, cur );
		}
	}

	public void deleteGenFileByXExpKeyName( CFGenKbAuthorization Authorization,
		Long argExpansionKeyNameTenantId,
		Long argExpansionKeyNameGelCacheId,
		Long argExpansionKeyNameGelId )
	{
		CFGenKbGenFileByXExpKeyNameKey key = schema.getFactoryGenFile().newXExpKeyNameKey();
		key.setOptionalExpansionKeyNameTenantId( argExpansionKeyNameTenantId );
		key.setOptionalExpansionKeyNameGelCacheId( argExpansionKeyNameGelCacheId );
		key.setOptionalExpansionKeyNameGelId( argExpansionKeyNameGelId );
		deleteGenFileByXExpKeyName( Authorization, key );
	}

	public void deleteGenFileByXExpKeyName( CFGenKbAuthorization Authorization,
		CFGenKbGenFileByXExpKeyNameKey argKey )
	{
		CFGenKbGenFileBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalExpansionKeyNameTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalExpansionKeyNameGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalExpansionKeyNameGelId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenFileBuff> matchSet = new LinkedList<CFGenKbGenFileBuff>();
		Iterator<CFGenKbGenFileBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenFileBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenFile( Authorization, cur );
		}
	}

	public void deleteGenFileByXExpFileName( CFGenKbAuthorization Authorization,
		Long argExpansionFileNameTenantId,
		Long argExpansionFileNameGelCacheId,
		Long argExpansionFileNameGelId )
	{
		CFGenKbGenFileByXExpFileNameKey key = schema.getFactoryGenFile().newXExpFileNameKey();
		key.setOptionalExpansionFileNameTenantId( argExpansionFileNameTenantId );
		key.setOptionalExpansionFileNameGelCacheId( argExpansionFileNameGelCacheId );
		key.setOptionalExpansionFileNameGelId( argExpansionFileNameGelId );
		deleteGenFileByXExpFileName( Authorization, key );
	}

	public void deleteGenFileByXExpFileName( CFGenKbAuthorization Authorization,
		CFGenKbGenFileByXExpFileNameKey argKey )
	{
		CFGenKbGenFileBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalExpansionFileNameTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalExpansionFileNameGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalExpansionFileNameGelId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenFileBuff> matchSet = new LinkedList<CFGenKbGenFileBuff>();
		Iterator<CFGenKbGenFileBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenFileBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenFile( Authorization, cur );
		}
	}

	public void deleteGenFileByBodyIdx( CFGenKbAuthorization Authorization,
		Long argBodyTenantId,
		Long argBodyGelCacheId,
		Long argBodyGelId )
	{
		CFGenKbGenRuleByBodyIdxKey key = schema.getFactoryGenRule().newBodyIdxKey();
		key.setOptionalBodyTenantId( argBodyTenantId );
		key.setOptionalBodyGelCacheId( argBodyGelCacheId );
		key.setOptionalBodyGelId( argBodyGelId );
		deleteGenFileByBodyIdx( Authorization, key );
	}

	public void deleteGenFileByBodyIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenRuleByBodyIdxKey argKey )
	{
		CFGenKbGenFileBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalBodyTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalBodyGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalBodyGelId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenFileBuff> matchSet = new LinkedList<CFGenKbGenFileBuff>();
		Iterator<CFGenKbGenFileBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenFileBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenFile( Authorization, cur );
		}
	}

	public void deleteGenFileByItemIdIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId,
		long argItemId )
	{
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredCartridgeId( argCartridgeId );
		key.setRequiredItemId( argItemId );
		deleteGenFileByItemIdIdx( Authorization, key );
	}

	public void deleteGenFileByItemIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGenFileBuff cur;
		LinkedList<CFGenKbGenFileBuff> matchSet = new LinkedList<CFGenKbGenFileBuff>();
		Iterator<CFGenKbGenFileBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenFileBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenFile( Authorization, cur );
		}
	}

	public void deleteGenFileByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGenItemByTenantIdxKey key = schema.getFactoryGenItem().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGenFileByTenantIdx( Authorization, key );
	}

	public void deleteGenFileByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByTenantIdxKey argKey )
	{
		CFGenKbGenFileBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenFileBuff> matchSet = new LinkedList<CFGenKbGenFileBuff>();
		Iterator<CFGenKbGenFileBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenFileBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenFile( Authorization, cur );
		}
	}

	public void deleteGenFileByCartIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId )
	{
		CFGenKbGenItemByCartIdxKey key = schema.getFactoryGenItem().newCartIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredCartridgeId( argCartridgeId );
		deleteGenFileByCartIdx( Authorization, key );
	}

	public void deleteGenFileByCartIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByCartIdxKey argKey )
	{
		CFGenKbGenFileBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenFileBuff> matchSet = new LinkedList<CFGenKbGenFileBuff>();
		Iterator<CFGenKbGenFileBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenFileBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenFile( Authorization, cur );
		}
	}

	public void deleteGenFileByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short argRuleTypeId )
	{
		CFGenKbGenItemByRuleTypeIdxKey key = schema.getFactoryGenItem().newRuleTypeIdxKey();
		key.setRequiredRuleTypeId( argRuleTypeId );
		deleteGenFileByRuleTypeIdx( Authorization, key );
	}

	public void deleteGenFileByRuleTypeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByRuleTypeIdxKey argKey )
	{
		CFGenKbGenFileBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenFileBuff> matchSet = new LinkedList<CFGenKbGenFileBuff>();
		Iterator<CFGenKbGenFileBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenFileBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenFile( Authorization, cur );
		}
	}

	public void deleteGenFileByToolSetIdx( CFGenKbAuthorization Authorization,
		short argToolSetId )
	{
		CFGenKbGenItemByToolSetIdxKey key = schema.getFactoryGenItem().newToolSetIdxKey();
		key.setRequiredToolSetId( argToolSetId );
		deleteGenFileByToolSetIdx( Authorization, key );
	}

	public void deleteGenFileByToolSetIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByToolSetIdxKey argKey )
	{
		CFGenKbGenFileBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenFileBuff> matchSet = new LinkedList<CFGenKbGenFileBuff>();
		Iterator<CFGenKbGenFileBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenFileBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenFile( Authorization, cur );
		}
	}

	public void deleteGenFileByScopeIdx( CFGenKbAuthorization Authorization,
		Short argScopeDefId )
	{
		CFGenKbGenItemByScopeIdxKey key = schema.getFactoryGenItem().newScopeIdxKey();
		key.setOptionalScopeDefId( argScopeDefId );
		deleteGenFileByScopeIdx( Authorization, key );
	}

	public void deleteGenFileByScopeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByScopeIdxKey argKey )
	{
		CFGenKbGenFileBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalScopeDefId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenFileBuff> matchSet = new LinkedList<CFGenKbGenFileBuff>();
		Iterator<CFGenKbGenFileBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenFileBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenFile( Authorization, cur );
		}
	}

	public void deleteGenFileByGenDefIdx( CFGenKbAuthorization Authorization,
		short argGenDefId )
	{
		CFGenKbGenItemByGenDefIdxKey key = schema.getFactoryGenItem().newGenDefIdxKey();
		key.setRequiredGenDefId( argGenDefId );
		deleteGenFileByGenDefIdx( Authorization, key );
	}

	public void deleteGenFileByGenDefIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGenDefIdxKey argKey )
	{
		CFGenKbGenFileBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenFileBuff> matchSet = new LinkedList<CFGenKbGenFileBuff>();
		Iterator<CFGenKbGenFileBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenFileBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenFile( Authorization, cur );
		}
	}

	public void deleteGenFileByAltIdx( CFGenKbAuthorization Authorization,
		String argName,
		short argToolSetId,
		Short argScopeDefId,
		short argGenDefId )
	{
		CFGenKbGenItemByAltIdxKey key = schema.getFactoryGenItem().newAltIdxKey();
		key.setRequiredName( argName );
		key.setRequiredToolSetId( argToolSetId );
		key.setOptionalScopeDefId( argScopeDefId );
		key.setRequiredGenDefId( argGenDefId );
		deleteGenFileByAltIdx( Authorization, key );
	}

	public void deleteGenFileByAltIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByAltIdxKey argKey )
	{
		CFGenKbGenFileBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( argKey.getOptionalScopeDefId() != null ) {
			anyNotNull = true;
		}
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenFileBuff> matchSet = new LinkedList<CFGenKbGenFileBuff>();
		Iterator<CFGenKbGenFileBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenFileBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenFile( Authorization, cur );
		}
	}

	public void deleteGenFileByGelExecIdx( CFGenKbAuthorization Authorization,
		Long argGelExecutableTenantId,
		Long argGelExecutableGelCacheId,
		Long argGelExecutableId )
	{
		CFGenKbGenItemByGelExecIdxKey key = schema.getFactoryGenItem().newGelExecIdxKey();
		key.setOptionalGelExecutableTenantId( argGelExecutableTenantId );
		key.setOptionalGelExecutableGelCacheId( argGelExecutableGelCacheId );
		key.setOptionalGelExecutableId( argGelExecutableId );
		deleteGenFileByGelExecIdx( Authorization, key );
	}

	public void deleteGenFileByGelExecIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGelExecIdxKey argKey )
	{
		CFGenKbGenFileBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalGelExecutableTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalGelExecutableGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalGelExecutableId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenFileBuff> matchSet = new LinkedList<CFGenKbGenFileBuff>();
		Iterator<CFGenKbGenFileBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenFileBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenFile( Authorization, cur );
		}
	}

	public void deleteGenFileByProbeIdx( CFGenKbAuthorization Authorization,
		Long argProbeTenantId,
		Long argProbeCartridgeId,
		Long argProbeGenItemId )
	{
		CFGenKbGenItemByProbeIdxKey key = schema.getFactoryGenItem().newProbeIdxKey();
		key.setOptionalProbeTenantId( argProbeTenantId );
		key.setOptionalProbeCartridgeId( argProbeCartridgeId );
		key.setOptionalProbeGenItemId( argProbeGenItemId );
		deleteGenFileByProbeIdx( Authorization, key );
	}

	public void deleteGenFileByProbeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByProbeIdxKey argKey )
	{
		CFGenKbGenFileBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalProbeTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalProbeCartridgeId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalProbeGenItemId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenFileBuff> matchSet = new LinkedList<CFGenKbGenFileBuff>();
		Iterator<CFGenKbGenFileBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenFileBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenFile( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
