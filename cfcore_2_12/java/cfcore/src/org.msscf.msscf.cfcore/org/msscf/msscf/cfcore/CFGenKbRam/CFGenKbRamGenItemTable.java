
// Description: Java 11 in-memory RAM DbIO implementation for GenItem.

/*
 *	org.msscf.msscf.CFCore
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
 *	CFGenKbRamGenItemTable in-memory RAM DbIO implementation
 *	for GenItem.
 */
public class CFGenKbRamGenItemTable
	implements ICFGenKbGenItemTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGenItemPKey,
				CFGenKbGenItemBuff > dictByPKey
		= new HashMap< CFGenKbGenItemPKey,
				CFGenKbGenItemBuff >();
	private Map< CFGenKbGenItemByTenantIdxKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenItemBuff >> dictByTenantIdx
		= new HashMap< CFGenKbGenItemByTenantIdxKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenItemBuff >>();
	private Map< CFGenKbGenItemByCartIdxKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenItemBuff >> dictByCartIdx
		= new HashMap< CFGenKbGenItemByCartIdxKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenItemBuff >>();
	private Map< CFGenKbGenItemByRuleTypeIdxKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenItemBuff >> dictByRuleTypeIdx
		= new HashMap< CFGenKbGenItemByRuleTypeIdxKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenItemBuff >>();
	private Map< CFGenKbGenItemByToolSetIdxKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenItemBuff >> dictByToolSetIdx
		= new HashMap< CFGenKbGenItemByToolSetIdxKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenItemBuff >>();
	private Map< CFGenKbGenItemByScopeIdxKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenItemBuff >> dictByScopeIdx
		= new HashMap< CFGenKbGenItemByScopeIdxKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenItemBuff >>();
	private Map< CFGenKbGenItemByGenDefIdxKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenItemBuff >> dictByGenDefIdx
		= new HashMap< CFGenKbGenItemByGenDefIdxKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenItemBuff >>();
	private Map< CFGenKbGenItemByAltIdxKey,
			CFGenKbGenItemBuff > dictByAltIdx
		= new HashMap< CFGenKbGenItemByAltIdxKey,
			CFGenKbGenItemBuff >();
	private Map< CFGenKbGenItemByGelExecIdxKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenItemBuff >> dictByGelExecIdx
		= new HashMap< CFGenKbGenItemByGelExecIdxKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenItemBuff >>();
	private Map< CFGenKbGenItemByProbeIdxKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenItemBuff >> dictByProbeIdx
		= new HashMap< CFGenKbGenItemByProbeIdxKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenItemBuff >>();

	public CFGenKbRamGenItemTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGenItem( CFGenKbAuthorization Authorization,
		CFGenKbGenItemBuff Buff )
	{
		final String S_ProcName = "createGenItem";
		CFGenKbGenItemPKey pkey = schema.getFactoryGenItem().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );
		pkey.setRequiredItemId( ((CFGenKbRamTenantTable)schema.getTableTenant()).nextGenItemIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredCartridgeId( pkey.getRequiredCartridgeId() );
		Buff.setRequiredItemId( pkey.getRequiredItemId() );
		CFGenKbGenItemByTenantIdxKey keyTenantIdx = schema.getFactoryGenItem().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFGenKbGenItemByCartIdxKey keyCartIdx = schema.getFactoryGenItem().newCartIdxKey();
		keyCartIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyCartIdx.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );

		CFGenKbGenItemByRuleTypeIdxKey keyRuleTypeIdx = schema.getFactoryGenItem().newRuleTypeIdxKey();
		keyRuleTypeIdx.setRequiredRuleTypeId( Buff.getRequiredRuleTypeId() );

		CFGenKbGenItemByToolSetIdxKey keyToolSetIdx = schema.getFactoryGenItem().newToolSetIdxKey();
		keyToolSetIdx.setRequiredToolSetId( Buff.getRequiredToolSetId() );

		CFGenKbGenItemByScopeIdxKey keyScopeIdx = schema.getFactoryGenItem().newScopeIdxKey();
		keyScopeIdx.setOptionalScopeDefId( Buff.getOptionalScopeDefId() );

		CFGenKbGenItemByGenDefIdxKey keyGenDefIdx = schema.getFactoryGenItem().newGenDefIdxKey();
		keyGenDefIdx.setRequiredGenDefId( Buff.getRequiredGenDefId() );

		CFGenKbGenItemByAltIdxKey keyAltIdx = schema.getFactoryGenItem().newAltIdxKey();
		keyAltIdx.setRequiredName( Buff.getRequiredName() );
		keyAltIdx.setRequiredToolSetId( Buff.getRequiredToolSetId() );
		keyAltIdx.setOptionalScopeDefId( Buff.getOptionalScopeDefId() );
		keyAltIdx.setRequiredGenDefId( Buff.getRequiredGenDefId() );

		CFGenKbGenItemByGelExecIdxKey keyGelExecIdx = schema.getFactoryGenItem().newGelExecIdxKey();
		keyGelExecIdx.setOptionalGelExecutableTenantId( Buff.getOptionalGelExecutableTenantId() );
		keyGelExecIdx.setOptionalGelExecutableGelCacheId( Buff.getOptionalGelExecutableGelCacheId() );
		keyGelExecIdx.setOptionalGelExecutableId( Buff.getOptionalGelExecutableId() );

		CFGenKbGenItemByProbeIdxKey keyProbeIdx = schema.getFactoryGenItem().newProbeIdxKey();
		keyProbeIdx.setOptionalProbeTenantId( Buff.getOptionalProbeTenantId() );
		keyProbeIdx.setOptionalProbeCartridgeId( Buff.getOptionalProbeCartridgeId() );
		keyProbeIdx.setOptionalProbeGenItemId( Buff.getOptionalProbeGenItemId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByAltIdx.containsKey( keyAltIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"GenItemAlt",
				keyAltIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Owner",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableRuleCart().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredCartridgeId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Cartridge",
						"RuleCart",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableRuleType().readDerivedByIdIdx( Authorization,
						Buff.getRequiredRuleTypeId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"RuleType",
						"RuleType",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableToolSet().readDerivedByIdIdx( Authorization,
						Buff.getRequiredToolSetId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"ToolSet",
						"ToolSet",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableDefClass().readDerivedByIdIdx( Authorization,
						Buff.getRequiredGenDefId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"GenDef",
						"DefClass",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictCartIdx;
		if( dictByCartIdx.containsKey( keyCartIdx ) ) {
			subdictCartIdx = dictByCartIdx.get( keyCartIdx );
		}
		else {
			subdictCartIdx = new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByCartIdx.put( keyCartIdx, subdictCartIdx );
		}
		subdictCartIdx.put( pkey, Buff );

		Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictRuleTypeIdx;
		if( dictByRuleTypeIdx.containsKey( keyRuleTypeIdx ) ) {
			subdictRuleTypeIdx = dictByRuleTypeIdx.get( keyRuleTypeIdx );
		}
		else {
			subdictRuleTypeIdx = new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByRuleTypeIdx.put( keyRuleTypeIdx, subdictRuleTypeIdx );
		}
		subdictRuleTypeIdx.put( pkey, Buff );

		Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictToolSetIdx;
		if( dictByToolSetIdx.containsKey( keyToolSetIdx ) ) {
			subdictToolSetIdx = dictByToolSetIdx.get( keyToolSetIdx );
		}
		else {
			subdictToolSetIdx = new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByToolSetIdx.put( keyToolSetIdx, subdictToolSetIdx );
		}
		subdictToolSetIdx.put( pkey, Buff );

		Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictScopeIdx;
		if( dictByScopeIdx.containsKey( keyScopeIdx ) ) {
			subdictScopeIdx = dictByScopeIdx.get( keyScopeIdx );
		}
		else {
			subdictScopeIdx = new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByScopeIdx.put( keyScopeIdx, subdictScopeIdx );
		}
		subdictScopeIdx.put( pkey, Buff );

		Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictGenDefIdx;
		if( dictByGenDefIdx.containsKey( keyGenDefIdx ) ) {
			subdictGenDefIdx = dictByGenDefIdx.get( keyGenDefIdx );
		}
		else {
			subdictGenDefIdx = new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByGenDefIdx.put( keyGenDefIdx, subdictGenDefIdx );
		}
		subdictGenDefIdx.put( pkey, Buff );

		dictByAltIdx.put( keyAltIdx, Buff );

		Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictGelExecIdx;
		if( dictByGelExecIdx.containsKey( keyGelExecIdx ) ) {
			subdictGelExecIdx = dictByGelExecIdx.get( keyGelExecIdx );
		}
		else {
			subdictGelExecIdx = new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByGelExecIdx.put( keyGelExecIdx, subdictGelExecIdx );
		}
		subdictGelExecIdx.put( pkey, Buff );

		Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictProbeIdx;
		if( dictByProbeIdx.containsKey( keyProbeIdx ) ) {
			subdictProbeIdx = dictByProbeIdx.get( keyProbeIdx );
		}
		else {
			subdictProbeIdx = new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByProbeIdx.put( keyProbeIdx, subdictProbeIdx );
		}
		subdictProbeIdx.put( pkey, Buff );

	}

	public CFGenKbGenItemBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerived";
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredCartridgeId( PKey.getRequiredCartridgeId() );
		key.setRequiredItemId( PKey.getRequiredItemId() );
		CFGenKbGenItemBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenItemBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerived";
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredCartridgeId( PKey.getRequiredCartridgeId() );
		key.setRequiredItemId( PKey.getRequiredItemId() );
		CFGenKbGenItemBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenItemBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGenItem.readAllDerived";
		CFGenKbGenItemBuff[] retList = new CFGenKbGenItemBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGenItemBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGenItemBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByTenantIdx";
		CFGenKbGenItemByTenantIdxKey key = schema.getFactoryGenItem().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFGenKbGenItemBuff[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new CFGenKbGenItemBuff[ subdictTenantIdx.size() ];
			Iterator< CFGenKbGenItemBuff > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictTenantIdx
				= new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new CFGenKbGenItemBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGenItemBuff[] readDerivedByCartIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByCartIdx";
		CFGenKbGenItemByCartIdxKey key = schema.getFactoryGenItem().newCartIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCartridgeId( CartridgeId );

		CFGenKbGenItemBuff[] recArray;
		if( dictByCartIdx.containsKey( key ) ) {
			Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictCartIdx
				= dictByCartIdx.get( key );
			recArray = new CFGenKbGenItemBuff[ subdictCartIdx.size() ];
			Iterator< CFGenKbGenItemBuff > iter = subdictCartIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictCartIdx
				= new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByCartIdx.put( key, subdictCartIdx );
			recArray = new CFGenKbGenItemBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGenItemBuff[] readDerivedByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short RuleTypeId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByRuleTypeIdx";
		CFGenKbGenItemByRuleTypeIdxKey key = schema.getFactoryGenItem().newRuleTypeIdxKey();
		key.setRequiredRuleTypeId( RuleTypeId );

		CFGenKbGenItemBuff[] recArray;
		if( dictByRuleTypeIdx.containsKey( key ) ) {
			Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictRuleTypeIdx
				= dictByRuleTypeIdx.get( key );
			recArray = new CFGenKbGenItemBuff[ subdictRuleTypeIdx.size() ];
			Iterator< CFGenKbGenItemBuff > iter = subdictRuleTypeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictRuleTypeIdx
				= new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByRuleTypeIdx.put( key, subdictRuleTypeIdx );
			recArray = new CFGenKbGenItemBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGenItemBuff[] readDerivedByToolSetIdx( CFGenKbAuthorization Authorization,
		short ToolSetId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByToolSetIdx";
		CFGenKbGenItemByToolSetIdxKey key = schema.getFactoryGenItem().newToolSetIdxKey();
		key.setRequiredToolSetId( ToolSetId );

		CFGenKbGenItemBuff[] recArray;
		if( dictByToolSetIdx.containsKey( key ) ) {
			Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictToolSetIdx
				= dictByToolSetIdx.get( key );
			recArray = new CFGenKbGenItemBuff[ subdictToolSetIdx.size() ];
			Iterator< CFGenKbGenItemBuff > iter = subdictToolSetIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictToolSetIdx
				= new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByToolSetIdx.put( key, subdictToolSetIdx );
			recArray = new CFGenKbGenItemBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGenItemBuff[] readDerivedByScopeIdx( CFGenKbAuthorization Authorization,
		Short ScopeDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByScopeIdx";
		CFGenKbGenItemByScopeIdxKey key = schema.getFactoryGenItem().newScopeIdxKey();
		key.setOptionalScopeDefId( ScopeDefId );

		CFGenKbGenItemBuff[] recArray;
		if( dictByScopeIdx.containsKey( key ) ) {
			Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictScopeIdx
				= dictByScopeIdx.get( key );
			recArray = new CFGenKbGenItemBuff[ subdictScopeIdx.size() ];
			Iterator< CFGenKbGenItemBuff > iter = subdictScopeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictScopeIdx
				= new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByScopeIdx.put( key, subdictScopeIdx );
			recArray = new CFGenKbGenItemBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGenItemBuff[] readDerivedByGenDefIdx( CFGenKbAuthorization Authorization,
		short GenDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByGenDefIdx";
		CFGenKbGenItemByGenDefIdxKey key = schema.getFactoryGenItem().newGenDefIdxKey();
		key.setRequiredGenDefId( GenDefId );

		CFGenKbGenItemBuff[] recArray;
		if( dictByGenDefIdx.containsKey( key ) ) {
			Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictGenDefIdx
				= dictByGenDefIdx.get( key );
			recArray = new CFGenKbGenItemBuff[ subdictGenDefIdx.size() ];
			Iterator< CFGenKbGenItemBuff > iter = subdictGenDefIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictGenDefIdx
				= new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByGenDefIdx.put( key, subdictGenDefIdx );
			recArray = new CFGenKbGenItemBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGenItemBuff readDerivedByAltIdx( CFGenKbAuthorization Authorization,
		String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByAltIdx";
		CFGenKbGenItemByAltIdxKey key = schema.getFactoryGenItem().newAltIdxKey();
		key.setRequiredName( Name );
		key.setRequiredToolSetId( ToolSetId );
		key.setOptionalScopeDefId( ScopeDefId );
		key.setRequiredGenDefId( GenDefId );

		CFGenKbGenItemBuff buff;
		if( dictByAltIdx.containsKey( key ) ) {
			buff = dictByAltIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenItemBuff[] readDerivedByGelExecIdx( CFGenKbAuthorization Authorization,
		Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByGelExecIdx";
		CFGenKbGenItemByGelExecIdxKey key = schema.getFactoryGenItem().newGelExecIdxKey();
		key.setOptionalGelExecutableTenantId( GelExecutableTenantId );
		key.setOptionalGelExecutableGelCacheId( GelExecutableGelCacheId );
		key.setOptionalGelExecutableId( GelExecutableId );

		CFGenKbGenItemBuff[] recArray;
		if( dictByGelExecIdx.containsKey( key ) ) {
			Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictGelExecIdx
				= dictByGelExecIdx.get( key );
			recArray = new CFGenKbGenItemBuff[ subdictGelExecIdx.size() ];
			Iterator< CFGenKbGenItemBuff > iter = subdictGelExecIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictGelExecIdx
				= new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByGelExecIdx.put( key, subdictGelExecIdx );
			recArray = new CFGenKbGenItemBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGenItemBuff[] readDerivedByProbeIdx( CFGenKbAuthorization Authorization,
		Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByProbeIdx";
		CFGenKbGenItemByProbeIdxKey key = schema.getFactoryGenItem().newProbeIdxKey();
		key.setOptionalProbeTenantId( ProbeTenantId );
		key.setOptionalProbeCartridgeId( ProbeCartridgeId );
		key.setOptionalProbeGenItemId( ProbeGenItemId );

		CFGenKbGenItemBuff[] recArray;
		if( dictByProbeIdx.containsKey( key ) ) {
			Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictProbeIdx
				= dictByProbeIdx.get( key );
			recArray = new CFGenKbGenItemBuff[ subdictProbeIdx.size() ];
			Iterator< CFGenKbGenItemBuff > iter = subdictProbeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdictProbeIdx
				= new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByProbeIdx.put( key, subdictProbeIdx );
			recArray = new CFGenKbGenItemBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGenItemBuff readDerivedByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByItemIdIdx() ";
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCartridgeId( CartridgeId );
		key.setRequiredItemId( ItemId );

		CFGenKbGenItemBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenItemBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuff";
		CFGenKbGenItemBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ITM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenItemBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGenItemBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ITM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenItemBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readAllBuff";
		CFGenKbGenItemBuff buff;
		ArrayList<CFGenKbGenItemBuff> filteredList = new ArrayList<CFGenKbGenItemBuff>();
		CFGenKbGenItemBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenItemBuff[0] ) );
	}

	public CFGenKbGenItemBuff readBuffByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByItemIdIdx() ";
		CFGenKbGenItemBuff buff = readDerivedByItemIdIdx( Authorization,
			TenantId,
			CartridgeId,
			ItemId );
		if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
			return( (CFGenKbGenItemBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGenItemBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByTenantIdx() ";
		CFGenKbGenItemBuff buff;
		ArrayList<CFGenKbGenItemBuff> filteredList = new ArrayList<CFGenKbGenItemBuff>();
		CFGenKbGenItemBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenItemBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenItemBuff[0] ) );
	}

	public CFGenKbGenItemBuff[] readBuffByCartIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByCartIdx() ";
		CFGenKbGenItemBuff buff;
		ArrayList<CFGenKbGenItemBuff> filteredList = new ArrayList<CFGenKbGenItemBuff>();
		CFGenKbGenItemBuff[] buffList = readDerivedByCartIdx( Authorization,
			TenantId,
			CartridgeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenItemBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenItemBuff[0] ) );
	}

	public CFGenKbGenItemBuff[] readBuffByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short RuleTypeId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByRuleTypeIdx() ";
		CFGenKbGenItemBuff buff;
		ArrayList<CFGenKbGenItemBuff> filteredList = new ArrayList<CFGenKbGenItemBuff>();
		CFGenKbGenItemBuff[] buffList = readDerivedByRuleTypeIdx( Authorization,
			RuleTypeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenItemBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenItemBuff[0] ) );
	}

	public CFGenKbGenItemBuff[] readBuffByToolSetIdx( CFGenKbAuthorization Authorization,
		short ToolSetId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByToolSetIdx() ";
		CFGenKbGenItemBuff buff;
		ArrayList<CFGenKbGenItemBuff> filteredList = new ArrayList<CFGenKbGenItemBuff>();
		CFGenKbGenItemBuff[] buffList = readDerivedByToolSetIdx( Authorization,
			ToolSetId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenItemBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenItemBuff[0] ) );
	}

	public CFGenKbGenItemBuff[] readBuffByScopeIdx( CFGenKbAuthorization Authorization,
		Short ScopeDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByScopeIdx() ";
		CFGenKbGenItemBuff buff;
		ArrayList<CFGenKbGenItemBuff> filteredList = new ArrayList<CFGenKbGenItemBuff>();
		CFGenKbGenItemBuff[] buffList = readDerivedByScopeIdx( Authorization,
			ScopeDefId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenItemBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenItemBuff[0] ) );
	}

	public CFGenKbGenItemBuff[] readBuffByGenDefIdx( CFGenKbAuthorization Authorization,
		short GenDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByGenDefIdx() ";
		CFGenKbGenItemBuff buff;
		ArrayList<CFGenKbGenItemBuff> filteredList = new ArrayList<CFGenKbGenItemBuff>();
		CFGenKbGenItemBuff[] buffList = readDerivedByGenDefIdx( Authorization,
			GenDefId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenItemBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenItemBuff[0] ) );
	}

	public CFGenKbGenItemBuff readBuffByAltIdx( CFGenKbAuthorization Authorization,
		String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByAltIdx() ";
		CFGenKbGenItemBuff buff = readDerivedByAltIdx( Authorization,
			Name,
			ToolSetId,
			ScopeDefId,
			GenDefId );
		if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
			return( (CFGenKbGenItemBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGenItemBuff[] readBuffByGelExecIdx( CFGenKbAuthorization Authorization,
		Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByGelExecIdx() ";
		CFGenKbGenItemBuff buff;
		ArrayList<CFGenKbGenItemBuff> filteredList = new ArrayList<CFGenKbGenItemBuff>();
		CFGenKbGenItemBuff[] buffList = readDerivedByGelExecIdx( Authorization,
			GelExecutableTenantId,
			GelExecutableGelCacheId,
			GelExecutableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenItemBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenItemBuff[0] ) );
	}

	public CFGenKbGenItemBuff[] readBuffByProbeIdx( CFGenKbAuthorization Authorization,
		Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByProbeIdx() ";
		CFGenKbGenItemBuff buff;
		ArrayList<CFGenKbGenItemBuff> filteredList = new ArrayList<CFGenKbGenItemBuff>();
		CFGenKbGenItemBuff[] buffList = readDerivedByProbeIdx( Authorization,
			ProbeTenantId,
			ProbeCartridgeId,
			ProbeGenItemId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenItemBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenItemBuff[0] ) );
	}

	public void updateGenItem( CFGenKbAuthorization Authorization,
		CFGenKbGenItemBuff Buff )
	{
		CFGenKbGenItemPKey pkey = schema.getFactoryGenItem().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );
		pkey.setRequiredItemId( Buff.getRequiredItemId() );
		CFGenKbGenItemBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGenItem",
				"Existing record not found",
				"GenItem",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateGenItem",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbGenItemByTenantIdxKey existingKeyTenantIdx = schema.getFactoryGenItem().newTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFGenKbGenItemByTenantIdxKey newKeyTenantIdx = schema.getFactoryGenItem().newTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFGenKbGenItemByCartIdxKey existingKeyCartIdx = schema.getFactoryGenItem().newCartIdxKey();
		existingKeyCartIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyCartIdx.setRequiredCartridgeId( existing.getRequiredCartridgeId() );

		CFGenKbGenItemByCartIdxKey newKeyCartIdx = schema.getFactoryGenItem().newCartIdxKey();
		newKeyCartIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyCartIdx.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );

		CFGenKbGenItemByRuleTypeIdxKey existingKeyRuleTypeIdx = schema.getFactoryGenItem().newRuleTypeIdxKey();
		existingKeyRuleTypeIdx.setRequiredRuleTypeId( existing.getRequiredRuleTypeId() );

		CFGenKbGenItemByRuleTypeIdxKey newKeyRuleTypeIdx = schema.getFactoryGenItem().newRuleTypeIdxKey();
		newKeyRuleTypeIdx.setRequiredRuleTypeId( Buff.getRequiredRuleTypeId() );

		CFGenKbGenItemByToolSetIdxKey existingKeyToolSetIdx = schema.getFactoryGenItem().newToolSetIdxKey();
		existingKeyToolSetIdx.setRequiredToolSetId( existing.getRequiredToolSetId() );

		CFGenKbGenItemByToolSetIdxKey newKeyToolSetIdx = schema.getFactoryGenItem().newToolSetIdxKey();
		newKeyToolSetIdx.setRequiredToolSetId( Buff.getRequiredToolSetId() );

		CFGenKbGenItemByScopeIdxKey existingKeyScopeIdx = schema.getFactoryGenItem().newScopeIdxKey();
		existingKeyScopeIdx.setOptionalScopeDefId( existing.getOptionalScopeDefId() );

		CFGenKbGenItemByScopeIdxKey newKeyScopeIdx = schema.getFactoryGenItem().newScopeIdxKey();
		newKeyScopeIdx.setOptionalScopeDefId( Buff.getOptionalScopeDefId() );

		CFGenKbGenItemByGenDefIdxKey existingKeyGenDefIdx = schema.getFactoryGenItem().newGenDefIdxKey();
		existingKeyGenDefIdx.setRequiredGenDefId( existing.getRequiredGenDefId() );

		CFGenKbGenItemByGenDefIdxKey newKeyGenDefIdx = schema.getFactoryGenItem().newGenDefIdxKey();
		newKeyGenDefIdx.setRequiredGenDefId( Buff.getRequiredGenDefId() );

		CFGenKbGenItemByAltIdxKey existingKeyAltIdx = schema.getFactoryGenItem().newAltIdxKey();
		existingKeyAltIdx.setRequiredName( existing.getRequiredName() );
		existingKeyAltIdx.setRequiredToolSetId( existing.getRequiredToolSetId() );
		existingKeyAltIdx.setOptionalScopeDefId( existing.getOptionalScopeDefId() );
		existingKeyAltIdx.setRequiredGenDefId( existing.getRequiredGenDefId() );

		CFGenKbGenItemByAltIdxKey newKeyAltIdx = schema.getFactoryGenItem().newAltIdxKey();
		newKeyAltIdx.setRequiredName( Buff.getRequiredName() );
		newKeyAltIdx.setRequiredToolSetId( Buff.getRequiredToolSetId() );
		newKeyAltIdx.setOptionalScopeDefId( Buff.getOptionalScopeDefId() );
		newKeyAltIdx.setRequiredGenDefId( Buff.getRequiredGenDefId() );

		CFGenKbGenItemByGelExecIdxKey existingKeyGelExecIdx = schema.getFactoryGenItem().newGelExecIdxKey();
		existingKeyGelExecIdx.setOptionalGelExecutableTenantId( existing.getOptionalGelExecutableTenantId() );
		existingKeyGelExecIdx.setOptionalGelExecutableGelCacheId( existing.getOptionalGelExecutableGelCacheId() );
		existingKeyGelExecIdx.setOptionalGelExecutableId( existing.getOptionalGelExecutableId() );

		CFGenKbGenItemByGelExecIdxKey newKeyGelExecIdx = schema.getFactoryGenItem().newGelExecIdxKey();
		newKeyGelExecIdx.setOptionalGelExecutableTenantId( Buff.getOptionalGelExecutableTenantId() );
		newKeyGelExecIdx.setOptionalGelExecutableGelCacheId( Buff.getOptionalGelExecutableGelCacheId() );
		newKeyGelExecIdx.setOptionalGelExecutableId( Buff.getOptionalGelExecutableId() );

		CFGenKbGenItemByProbeIdxKey existingKeyProbeIdx = schema.getFactoryGenItem().newProbeIdxKey();
		existingKeyProbeIdx.setOptionalProbeTenantId( existing.getOptionalProbeTenantId() );
		existingKeyProbeIdx.setOptionalProbeCartridgeId( existing.getOptionalProbeCartridgeId() );
		existingKeyProbeIdx.setOptionalProbeGenItemId( existing.getOptionalProbeGenItemId() );

		CFGenKbGenItemByProbeIdxKey newKeyProbeIdx = schema.getFactoryGenItem().newProbeIdxKey();
		newKeyProbeIdx.setOptionalProbeTenantId( Buff.getOptionalProbeTenantId() );
		newKeyProbeIdx.setOptionalProbeCartridgeId( Buff.getOptionalProbeCartridgeId() );
		newKeyProbeIdx.setOptionalProbeGenItemId( Buff.getOptionalProbeGenItemId() );

		// Check unique indexes

		if( ! existingKeyAltIdx.equals( newKeyAltIdx ) ) {
			if( dictByAltIdx.containsKey( newKeyAltIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateGenItem",
					"GenItemAlt",
					newKeyAltIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateGenItem",
						"Owner",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableRuleCart().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredCartridgeId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateGenItem",
						"Container",
						"Cartridge",
						"RuleCart",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableRuleType().readDerivedByIdIdx( Authorization,
						Buff.getRequiredRuleTypeId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateGenItem",
						"Lookup",
						"RuleType",
						"RuleType",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableToolSet().readDerivedByIdIdx( Authorization,
						Buff.getRequiredToolSetId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateGenItem",
						"Lookup",
						"ToolSet",
						"ToolSet",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableDefClass().readDerivedByIdIdx( Authorization,
						Buff.getRequiredGenDefId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateGenItem",
						"Lookup",
						"GenDef",
						"DefClass",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByTenantIdx.get( existingKeyTenantIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTenantIdx.containsKey( newKeyTenantIdx ) ) {
			subdict = dictByTenantIdx.get( newKeyTenantIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByCartIdx.get( existingKeyCartIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByCartIdx.containsKey( newKeyCartIdx ) ) {
			subdict = dictByCartIdx.get( newKeyCartIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByCartIdx.put( newKeyCartIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByRuleTypeIdx.get( existingKeyRuleTypeIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRuleTypeIdx.containsKey( newKeyRuleTypeIdx ) ) {
			subdict = dictByRuleTypeIdx.get( newKeyRuleTypeIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByRuleTypeIdx.put( newKeyRuleTypeIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByToolSetIdx.get( existingKeyToolSetIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByToolSetIdx.containsKey( newKeyToolSetIdx ) ) {
			subdict = dictByToolSetIdx.get( newKeyToolSetIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByToolSetIdx.put( newKeyToolSetIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByScopeIdx.get( existingKeyScopeIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByScopeIdx.containsKey( newKeyScopeIdx ) ) {
			subdict = dictByScopeIdx.get( newKeyScopeIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByScopeIdx.put( newKeyScopeIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByGenDefIdx.get( existingKeyGenDefIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByGenDefIdx.containsKey( newKeyGenDefIdx ) ) {
			subdict = dictByGenDefIdx.get( newKeyGenDefIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByGenDefIdx.put( newKeyGenDefIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByAltIdx.remove( existingKeyAltIdx );
		dictByAltIdx.put( newKeyAltIdx, Buff );

		subdict = dictByGelExecIdx.get( existingKeyGelExecIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByGelExecIdx.containsKey( newKeyGelExecIdx ) ) {
			subdict = dictByGelExecIdx.get( newKeyGelExecIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByGelExecIdx.put( newKeyGelExecIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByProbeIdx.get( existingKeyProbeIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByProbeIdx.containsKey( newKeyProbeIdx ) ) {
			subdict = dictByProbeIdx.get( newKeyProbeIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGenItemPKey, CFGenKbGenItemBuff >();
			dictByProbeIdx.put( newKeyProbeIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteGenItem( CFGenKbAuthorization Authorization,
		CFGenKbGenItemBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGenItemTable.deleteGenItem() ";
		String classCode;
		CFGenKbGenItemPKey pkey = schema.getFactoryGenItem().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );
		pkey.setRequiredItemId( Buff.getRequiredItemId() );
		CFGenKbGenItemBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGenItem",
				pkey );
		}
					schema.getTableGelExecutable().deleteGelExecutableByPIdx( Authorization,
						existing.getOptionalGelExecutableTenantId(),
						existing.getOptionalGelExecutableGelCacheId(),
						existing.getOptionalGelExecutableId() );
		CFGenKbGenItemByTenantIdxKey keyTenantIdx = schema.getFactoryGenItem().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFGenKbGenItemByCartIdxKey keyCartIdx = schema.getFactoryGenItem().newCartIdxKey();
		keyCartIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyCartIdx.setRequiredCartridgeId( existing.getRequiredCartridgeId() );

		CFGenKbGenItemByRuleTypeIdxKey keyRuleTypeIdx = schema.getFactoryGenItem().newRuleTypeIdxKey();
		keyRuleTypeIdx.setRequiredRuleTypeId( existing.getRequiredRuleTypeId() );

		CFGenKbGenItemByToolSetIdxKey keyToolSetIdx = schema.getFactoryGenItem().newToolSetIdxKey();
		keyToolSetIdx.setRequiredToolSetId( existing.getRequiredToolSetId() );

		CFGenKbGenItemByScopeIdxKey keyScopeIdx = schema.getFactoryGenItem().newScopeIdxKey();
		keyScopeIdx.setOptionalScopeDefId( existing.getOptionalScopeDefId() );

		CFGenKbGenItemByGenDefIdxKey keyGenDefIdx = schema.getFactoryGenItem().newGenDefIdxKey();
		keyGenDefIdx.setRequiredGenDefId( existing.getRequiredGenDefId() );

		CFGenKbGenItemByAltIdxKey keyAltIdx = schema.getFactoryGenItem().newAltIdxKey();
		keyAltIdx.setRequiredName( existing.getRequiredName() );
		keyAltIdx.setRequiredToolSetId( existing.getRequiredToolSetId() );
		keyAltIdx.setOptionalScopeDefId( existing.getOptionalScopeDefId() );
		keyAltIdx.setRequiredGenDefId( existing.getRequiredGenDefId() );

		CFGenKbGenItemByGelExecIdxKey keyGelExecIdx = schema.getFactoryGenItem().newGelExecIdxKey();
		keyGelExecIdx.setOptionalGelExecutableTenantId( existing.getOptionalGelExecutableTenantId() );
		keyGelExecIdx.setOptionalGelExecutableGelCacheId( existing.getOptionalGelExecutableGelCacheId() );
		keyGelExecIdx.setOptionalGelExecutableId( existing.getOptionalGelExecutableId() );

		CFGenKbGenItemByProbeIdxKey keyProbeIdx = schema.getFactoryGenItem().newProbeIdxKey();
		keyProbeIdx.setOptionalProbeTenantId( existing.getOptionalProbeTenantId() );
		keyProbeIdx.setOptionalProbeCartridgeId( existing.getOptionalProbeCartridgeId() );
		keyProbeIdx.setOptionalProbeGenItemId( existing.getOptionalProbeGenItemId() );

		// Validate reverse foreign keys

		if( schema.getTableGenIterator().readDerivedByItemIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredCartridgeId(),
					existing.getRequiredItemId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGenItem",
				"Superclass",
				"SuperClass",
				"GenIterator",
				pkey );
		}

		if( schema.getTableGenReference().readDerivedByItemIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredCartridgeId(),
					existing.getRequiredItemId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGenItem",
				"Superclass",
				"SuperClass",
				"GenReference",
				pkey );
		}

		if( schema.getTableGenRule().readDerivedByItemIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredCartridgeId(),
					existing.getRequiredItemId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGenItem",
				"Superclass",
				"SuperClass",
				"GenRule",
				pkey );
		}

		if( schema.getTableGenBind().readDerivedByItemIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredCartridgeId(),
					existing.getRequiredItemId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGenItem",
				"Superclass",
				"SuperClass",
				"GenBind",
				pkey );
		}

		// Delete is valid
		Map< CFGenKbGenItemPKey, CFGenKbGenItemBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		subdict = dictByCartIdx.get( keyCartIdx );
		subdict.remove( pkey );

		subdict = dictByRuleTypeIdx.get( keyRuleTypeIdx );
		subdict.remove( pkey );

		subdict = dictByToolSetIdx.get( keyToolSetIdx );
		subdict.remove( pkey );

		subdict = dictByScopeIdx.get( keyScopeIdx );
		subdict.remove( pkey );

		subdict = dictByGenDefIdx.get( keyGenDefIdx );
		subdict.remove( pkey );

		dictByAltIdx.remove( keyAltIdx );

		subdict = dictByGelExecIdx.get( keyGelExecIdx );
		subdict.remove( pkey );

		subdict = dictByProbeIdx.get( keyProbeIdx );
		subdict.remove( pkey );

	}
	public void deleteGenItemByItemIdIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId,
		long argItemId )
	{
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredCartridgeId( argCartridgeId );
		key.setRequiredItemId( argItemId );
		deleteGenItemByItemIdIdx( Authorization, key );
	}

	public void deleteGenItemByItemIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey argKey )
	{
		final String S_ProcName = "deleteGenItemByItemIdIdx";
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGenItemBuff cur;
		LinkedList<CFGenKbGenItemBuff> matchSet = new LinkedList<CFGenKbGenItemBuff>();
		Iterator<CFGenKbGenItemBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenItemBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenItem().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "ITM".equals( subClassCode ) ) {
				schema.getTableGenItem().deleteGenItem( Authorization, cur );
			}
			else if( "ITR".equals( subClassCode ) ) {
				schema.getTableGenIterator().deleteGenIterator( Authorization, (CFGenKbGenIteratorBuff)cur );
			}
			else if( "REF".equals( subClassCode ) ) {
				schema.getTableGenReference().deleteGenReference( Authorization, (CFGenKbGenReferenceBuff)cur );
			}
			else if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, (CFGenKbGenRuleBuff)cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else if( "BND".equals( subClassCode ) ) {
				schema.getTableGenBind().deleteGenBind( Authorization, (CFGenKbGenBindBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenItem must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenItemByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGenItemByTenantIdxKey key = schema.getFactoryGenItem().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGenItemByTenantIdx( Authorization, key );
	}

	public void deleteGenItemByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByTenantIdxKey argKey )
	{
		final String S_ProcName = "deleteGenItemByTenantIdx";
		CFGenKbGenItemBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenItemBuff> matchSet = new LinkedList<CFGenKbGenItemBuff>();
		Iterator<CFGenKbGenItemBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenItemBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenItem().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "ITM".equals( subClassCode ) ) {
				schema.getTableGenItem().deleteGenItem( Authorization, cur );
			}
			else if( "ITR".equals( subClassCode ) ) {
				schema.getTableGenIterator().deleteGenIterator( Authorization, (CFGenKbGenIteratorBuff)cur );
			}
			else if( "REF".equals( subClassCode ) ) {
				schema.getTableGenReference().deleteGenReference( Authorization, (CFGenKbGenReferenceBuff)cur );
			}
			else if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, (CFGenKbGenRuleBuff)cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else if( "BND".equals( subClassCode ) ) {
				schema.getTableGenBind().deleteGenBind( Authorization, (CFGenKbGenBindBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenItem must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenItemByCartIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId )
	{
		CFGenKbGenItemByCartIdxKey key = schema.getFactoryGenItem().newCartIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredCartridgeId( argCartridgeId );
		deleteGenItemByCartIdx( Authorization, key );
	}

	public void deleteGenItemByCartIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByCartIdxKey argKey )
	{
		final String S_ProcName = "deleteGenItemByCartIdx";
		CFGenKbGenItemBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenItemBuff> matchSet = new LinkedList<CFGenKbGenItemBuff>();
		Iterator<CFGenKbGenItemBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenItemBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenItem().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "ITM".equals( subClassCode ) ) {
				schema.getTableGenItem().deleteGenItem( Authorization, cur );
			}
			else if( "ITR".equals( subClassCode ) ) {
				schema.getTableGenIterator().deleteGenIterator( Authorization, (CFGenKbGenIteratorBuff)cur );
			}
			else if( "REF".equals( subClassCode ) ) {
				schema.getTableGenReference().deleteGenReference( Authorization, (CFGenKbGenReferenceBuff)cur );
			}
			else if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, (CFGenKbGenRuleBuff)cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else if( "BND".equals( subClassCode ) ) {
				schema.getTableGenBind().deleteGenBind( Authorization, (CFGenKbGenBindBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenItem must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenItemByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short argRuleTypeId )
	{
		CFGenKbGenItemByRuleTypeIdxKey key = schema.getFactoryGenItem().newRuleTypeIdxKey();
		key.setRequiredRuleTypeId( argRuleTypeId );
		deleteGenItemByRuleTypeIdx( Authorization, key );
	}

	public void deleteGenItemByRuleTypeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByRuleTypeIdxKey argKey )
	{
		final String S_ProcName = "deleteGenItemByRuleTypeIdx";
		CFGenKbGenItemBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenItemBuff> matchSet = new LinkedList<CFGenKbGenItemBuff>();
		Iterator<CFGenKbGenItemBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenItemBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenItem().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "ITM".equals( subClassCode ) ) {
				schema.getTableGenItem().deleteGenItem( Authorization, cur );
			}
			else if( "ITR".equals( subClassCode ) ) {
				schema.getTableGenIterator().deleteGenIterator( Authorization, (CFGenKbGenIteratorBuff)cur );
			}
			else if( "REF".equals( subClassCode ) ) {
				schema.getTableGenReference().deleteGenReference( Authorization, (CFGenKbGenReferenceBuff)cur );
			}
			else if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, (CFGenKbGenRuleBuff)cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else if( "BND".equals( subClassCode ) ) {
				schema.getTableGenBind().deleteGenBind( Authorization, (CFGenKbGenBindBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenItem must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenItemByToolSetIdx( CFGenKbAuthorization Authorization,
		short argToolSetId )
	{
		CFGenKbGenItemByToolSetIdxKey key = schema.getFactoryGenItem().newToolSetIdxKey();
		key.setRequiredToolSetId( argToolSetId );
		deleteGenItemByToolSetIdx( Authorization, key );
	}

	public void deleteGenItemByToolSetIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByToolSetIdxKey argKey )
	{
		final String S_ProcName = "deleteGenItemByToolSetIdx";
		CFGenKbGenItemBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenItemBuff> matchSet = new LinkedList<CFGenKbGenItemBuff>();
		Iterator<CFGenKbGenItemBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenItemBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenItem().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "ITM".equals( subClassCode ) ) {
				schema.getTableGenItem().deleteGenItem( Authorization, cur );
			}
			else if( "ITR".equals( subClassCode ) ) {
				schema.getTableGenIterator().deleteGenIterator( Authorization, (CFGenKbGenIteratorBuff)cur );
			}
			else if( "REF".equals( subClassCode ) ) {
				schema.getTableGenReference().deleteGenReference( Authorization, (CFGenKbGenReferenceBuff)cur );
			}
			else if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, (CFGenKbGenRuleBuff)cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else if( "BND".equals( subClassCode ) ) {
				schema.getTableGenBind().deleteGenBind( Authorization, (CFGenKbGenBindBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenItem must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenItemByScopeIdx( CFGenKbAuthorization Authorization,
		Short argScopeDefId )
	{
		CFGenKbGenItemByScopeIdxKey key = schema.getFactoryGenItem().newScopeIdxKey();
		key.setOptionalScopeDefId( argScopeDefId );
		deleteGenItemByScopeIdx( Authorization, key );
	}

	public void deleteGenItemByScopeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteGenItemByScopeIdx";
		CFGenKbGenItemBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalScopeDefId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenItemBuff> matchSet = new LinkedList<CFGenKbGenItemBuff>();
		Iterator<CFGenKbGenItemBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenItemBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenItem().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "ITM".equals( subClassCode ) ) {
				schema.getTableGenItem().deleteGenItem( Authorization, cur );
			}
			else if( "ITR".equals( subClassCode ) ) {
				schema.getTableGenIterator().deleteGenIterator( Authorization, (CFGenKbGenIteratorBuff)cur );
			}
			else if( "REF".equals( subClassCode ) ) {
				schema.getTableGenReference().deleteGenReference( Authorization, (CFGenKbGenReferenceBuff)cur );
			}
			else if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, (CFGenKbGenRuleBuff)cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else if( "BND".equals( subClassCode ) ) {
				schema.getTableGenBind().deleteGenBind( Authorization, (CFGenKbGenBindBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenItem must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenItemByGenDefIdx( CFGenKbAuthorization Authorization,
		short argGenDefId )
	{
		CFGenKbGenItemByGenDefIdxKey key = schema.getFactoryGenItem().newGenDefIdxKey();
		key.setRequiredGenDefId( argGenDefId );
		deleteGenItemByGenDefIdx( Authorization, key );
	}

	public void deleteGenItemByGenDefIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGenDefIdxKey argKey )
	{
		final String S_ProcName = "deleteGenItemByGenDefIdx";
		CFGenKbGenItemBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenItemBuff> matchSet = new LinkedList<CFGenKbGenItemBuff>();
		Iterator<CFGenKbGenItemBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenItemBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenItem().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "ITM".equals( subClassCode ) ) {
				schema.getTableGenItem().deleteGenItem( Authorization, cur );
			}
			else if( "ITR".equals( subClassCode ) ) {
				schema.getTableGenIterator().deleteGenIterator( Authorization, (CFGenKbGenIteratorBuff)cur );
			}
			else if( "REF".equals( subClassCode ) ) {
				schema.getTableGenReference().deleteGenReference( Authorization, (CFGenKbGenReferenceBuff)cur );
			}
			else if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, (CFGenKbGenRuleBuff)cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else if( "BND".equals( subClassCode ) ) {
				schema.getTableGenBind().deleteGenBind( Authorization, (CFGenKbGenBindBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenItem must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenItemByAltIdx( CFGenKbAuthorization Authorization,
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
		deleteGenItemByAltIdx( Authorization, key );
	}

	public void deleteGenItemByAltIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByAltIdxKey argKey )
	{
		final String S_ProcName = "deleteGenItemByAltIdx";
		CFGenKbGenItemBuff cur;
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
		LinkedList<CFGenKbGenItemBuff> matchSet = new LinkedList<CFGenKbGenItemBuff>();
		Iterator<CFGenKbGenItemBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenItemBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenItem().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "ITM".equals( subClassCode ) ) {
				schema.getTableGenItem().deleteGenItem( Authorization, cur );
			}
			else if( "ITR".equals( subClassCode ) ) {
				schema.getTableGenIterator().deleteGenIterator( Authorization, (CFGenKbGenIteratorBuff)cur );
			}
			else if( "REF".equals( subClassCode ) ) {
				schema.getTableGenReference().deleteGenReference( Authorization, (CFGenKbGenReferenceBuff)cur );
			}
			else if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, (CFGenKbGenRuleBuff)cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else if( "BND".equals( subClassCode ) ) {
				schema.getTableGenBind().deleteGenBind( Authorization, (CFGenKbGenBindBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenItem must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenItemByGelExecIdx( CFGenKbAuthorization Authorization,
		Long argGelExecutableTenantId,
		Long argGelExecutableGelCacheId,
		Long argGelExecutableId )
	{
		CFGenKbGenItemByGelExecIdxKey key = schema.getFactoryGenItem().newGelExecIdxKey();
		key.setOptionalGelExecutableTenantId( argGelExecutableTenantId );
		key.setOptionalGelExecutableGelCacheId( argGelExecutableGelCacheId );
		key.setOptionalGelExecutableId( argGelExecutableId );
		deleteGenItemByGelExecIdx( Authorization, key );
	}

	public void deleteGenItemByGelExecIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGelExecIdxKey argKey )
	{
		final String S_ProcName = "deleteGenItemByGelExecIdx";
		CFGenKbGenItemBuff cur;
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
		LinkedList<CFGenKbGenItemBuff> matchSet = new LinkedList<CFGenKbGenItemBuff>();
		Iterator<CFGenKbGenItemBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenItemBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenItem().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "ITM".equals( subClassCode ) ) {
				schema.getTableGenItem().deleteGenItem( Authorization, cur );
			}
			else if( "ITR".equals( subClassCode ) ) {
				schema.getTableGenIterator().deleteGenIterator( Authorization, (CFGenKbGenIteratorBuff)cur );
			}
			else if( "REF".equals( subClassCode ) ) {
				schema.getTableGenReference().deleteGenReference( Authorization, (CFGenKbGenReferenceBuff)cur );
			}
			else if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, (CFGenKbGenRuleBuff)cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else if( "BND".equals( subClassCode ) ) {
				schema.getTableGenBind().deleteGenBind( Authorization, (CFGenKbGenBindBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenItem must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenItemByProbeIdx( CFGenKbAuthorization Authorization,
		Long argProbeTenantId,
		Long argProbeCartridgeId,
		Long argProbeGenItemId )
	{
		CFGenKbGenItemByProbeIdxKey key = schema.getFactoryGenItem().newProbeIdxKey();
		key.setOptionalProbeTenantId( argProbeTenantId );
		key.setOptionalProbeCartridgeId( argProbeCartridgeId );
		key.setOptionalProbeGenItemId( argProbeGenItemId );
		deleteGenItemByProbeIdx( Authorization, key );
	}

	public void deleteGenItemByProbeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByProbeIdxKey argKey )
	{
		final String S_ProcName = "deleteGenItemByProbeIdx";
		CFGenKbGenItemBuff cur;
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
		LinkedList<CFGenKbGenItemBuff> matchSet = new LinkedList<CFGenKbGenItemBuff>();
		Iterator<CFGenKbGenItemBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenItemBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenItem().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "ITM".equals( subClassCode ) ) {
				schema.getTableGenItem().deleteGenItem( Authorization, cur );
			}
			else if( "ITR".equals( subClassCode ) ) {
				schema.getTableGenIterator().deleteGenIterator( Authorization, (CFGenKbGenIteratorBuff)cur );
			}
			else if( "REF".equals( subClassCode ) ) {
				schema.getTableGenReference().deleteGenReference( Authorization, (CFGenKbGenReferenceBuff)cur );
			}
			else if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, (CFGenKbGenRuleBuff)cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else if( "BND".equals( subClassCode ) ) {
				schema.getTableGenBind().deleteGenBind( Authorization, (CFGenKbGenBindBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenItem must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void releasePreparedStatements() {
	}
}
