
// Description: Java 11 in-memory RAM DbIO implementation for GenBind.

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
 *	CFGenKbRamGenBindTable in-memory RAM DbIO implementation
 *	for GenBind.
 */
public class CFGenKbRamGenBindTable
	implements ICFGenKbGenBindTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGenItemPKey,
				CFGenKbGenBindBuff > dictByPKey
		= new HashMap< CFGenKbGenItemPKey,
				CFGenKbGenBindBuff >();

	public CFGenKbRamGenBindTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGenBind( CFGenKbAuthorization Authorization,
		CFGenKbGenBindBuff Buff )
	{
		final String S_ProcName = "createGenBind";
		schema.getTableGenItem().createGenItem( Authorization,
			Buff );
		CFGenKbGenItemPKey pkey = schema.getFactoryGenItem().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );
		pkey.setRequiredItemId( Buff.getRequiredItemId() );
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
				if( null == schema.getTableGenItem().readDerivedByItemIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredCartridgeId(),
						Buff.getRequiredItemId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"GenItem",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

	}

	public CFGenKbGenBindBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGenBind.readDerived";
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredCartridgeId( PKey.getRequiredCartridgeId() );
		key.setRequiredItemId( PKey.getRequiredItemId() );
		CFGenKbGenBindBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenBindBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGenBind.readDerived";
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredCartridgeId( PKey.getRequiredCartridgeId() );
		key.setRequiredItemId( PKey.getRequiredItemId() );
		CFGenKbGenBindBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenBindBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGenBind.readAllDerived";
		CFGenKbGenBindBuff[] retList = new CFGenKbGenBindBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGenBindBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGenBindBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenBindBuff> filteredList = new ArrayList<CFGenKbGenBindBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenBindBuff ) ) {
					filteredList.add( (CFGenKbGenBindBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenBindBuff[0] ) );
		}
	}

	public CFGenKbGenBindBuff[] readDerivedByCartIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenBindBuff> filteredList = new ArrayList<CFGenKbGenBindBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenBindBuff ) ) {
					filteredList.add( (CFGenKbGenBindBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenBindBuff[0] ) );
		}
	}

	public CFGenKbGenBindBuff[] readDerivedByRuleTypeIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenBindBuff> filteredList = new ArrayList<CFGenKbGenBindBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenBindBuff ) ) {
					filteredList.add( (CFGenKbGenBindBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenBindBuff[0] ) );
		}
	}

	public CFGenKbGenBindBuff[] readDerivedByToolSetIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenBindBuff> filteredList = new ArrayList<CFGenKbGenBindBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenBindBuff ) ) {
					filteredList.add( (CFGenKbGenBindBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenBindBuff[0] ) );
		}
	}

	public CFGenKbGenBindBuff[] readDerivedByScopeIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenBindBuff> filteredList = new ArrayList<CFGenKbGenBindBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenBindBuff ) ) {
					filteredList.add( (CFGenKbGenBindBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenBindBuff[0] ) );
		}
	}

	public CFGenKbGenBindBuff[] readDerivedByGenDefIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenBindBuff> filteredList = new ArrayList<CFGenKbGenBindBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenBindBuff ) ) {
					filteredList.add( (CFGenKbGenBindBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenBindBuff[0] ) );
		}
	}

	public CFGenKbGenBindBuff readDerivedByAltIdx( CFGenKbAuthorization Authorization,
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
		else if( buff instanceof CFGenKbGenBindBuff ) {
			return( (CFGenKbGenBindBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGenBindBuff[] readDerivedByGelExecIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenBindBuff> filteredList = new ArrayList<CFGenKbGenBindBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenBindBuff ) ) {
					filteredList.add( (CFGenKbGenBindBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenBindBuff[0] ) );
		}
	}

	public CFGenKbGenBindBuff[] readDerivedByProbeIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenBindBuff> filteredList = new ArrayList<CFGenKbGenBindBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenBindBuff ) ) {
					filteredList.add( (CFGenKbGenBindBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenBindBuff[0] ) );
		}
	}

	public CFGenKbGenBindBuff readDerivedByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByItemIdIdx() ";
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCartridgeId( CartridgeId );
		key.setRequiredItemId( ItemId );

		CFGenKbGenBindBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenBindBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGenBind.readBuff";
		CFGenKbGenBindBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "BND" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenBindBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGenBindBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "BND" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenBindBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGenBind.readAllBuff";
		CFGenKbGenBindBuff buff;
		ArrayList<CFGenKbGenBindBuff> filteredList = new ArrayList<CFGenKbGenBindBuff>();
		CFGenKbGenBindBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "BND" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenBindBuff[0] ) );
	}

	public CFGenKbGenBindBuff readBuffByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByItemIdIdx() ";
		CFGenKbGenBindBuff buff = readDerivedByItemIdIdx( Authorization,
			TenantId,
			CartridgeId,
			ItemId );
		if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
			return( (CFGenKbGenBindBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGenBindBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByTenantIdx() ";
		CFGenKbGenBindBuff buff;
		ArrayList<CFGenKbGenBindBuff> filteredList = new ArrayList<CFGenKbGenBindBuff>();
		CFGenKbGenBindBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenBindBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenBindBuff[0] ) );
	}

	public CFGenKbGenBindBuff[] readBuffByCartIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByCartIdx() ";
		CFGenKbGenBindBuff buff;
		ArrayList<CFGenKbGenBindBuff> filteredList = new ArrayList<CFGenKbGenBindBuff>();
		CFGenKbGenBindBuff[] buffList = readDerivedByCartIdx( Authorization,
			TenantId,
			CartridgeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenBindBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenBindBuff[0] ) );
	}

	public CFGenKbGenBindBuff[] readBuffByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short RuleTypeId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByRuleTypeIdx() ";
		CFGenKbGenBindBuff buff;
		ArrayList<CFGenKbGenBindBuff> filteredList = new ArrayList<CFGenKbGenBindBuff>();
		CFGenKbGenBindBuff[] buffList = readDerivedByRuleTypeIdx( Authorization,
			RuleTypeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenBindBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenBindBuff[0] ) );
	}

	public CFGenKbGenBindBuff[] readBuffByToolSetIdx( CFGenKbAuthorization Authorization,
		short ToolSetId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByToolSetIdx() ";
		CFGenKbGenBindBuff buff;
		ArrayList<CFGenKbGenBindBuff> filteredList = new ArrayList<CFGenKbGenBindBuff>();
		CFGenKbGenBindBuff[] buffList = readDerivedByToolSetIdx( Authorization,
			ToolSetId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenBindBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenBindBuff[0] ) );
	}

	public CFGenKbGenBindBuff[] readBuffByScopeIdx( CFGenKbAuthorization Authorization,
		Short ScopeDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByScopeIdx() ";
		CFGenKbGenBindBuff buff;
		ArrayList<CFGenKbGenBindBuff> filteredList = new ArrayList<CFGenKbGenBindBuff>();
		CFGenKbGenBindBuff[] buffList = readDerivedByScopeIdx( Authorization,
			ScopeDefId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenBindBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenBindBuff[0] ) );
	}

	public CFGenKbGenBindBuff[] readBuffByGenDefIdx( CFGenKbAuthorization Authorization,
		short GenDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByGenDefIdx() ";
		CFGenKbGenBindBuff buff;
		ArrayList<CFGenKbGenBindBuff> filteredList = new ArrayList<CFGenKbGenBindBuff>();
		CFGenKbGenBindBuff[] buffList = readDerivedByGenDefIdx( Authorization,
			GenDefId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenBindBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenBindBuff[0] ) );
	}

	public CFGenKbGenBindBuff readBuffByAltIdx( CFGenKbAuthorization Authorization,
		String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByAltIdx() ";
		CFGenKbGenBindBuff buff = readDerivedByAltIdx( Authorization,
			Name,
			ToolSetId,
			ScopeDefId,
			GenDefId );
		if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
			return( (CFGenKbGenBindBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGenBindBuff[] readBuffByGelExecIdx( CFGenKbAuthorization Authorization,
		Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByGelExecIdx() ";
		CFGenKbGenBindBuff buff;
		ArrayList<CFGenKbGenBindBuff> filteredList = new ArrayList<CFGenKbGenBindBuff>();
		CFGenKbGenBindBuff[] buffList = readDerivedByGelExecIdx( Authorization,
			GelExecutableTenantId,
			GelExecutableGelCacheId,
			GelExecutableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenBindBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenBindBuff[0] ) );
	}

	public CFGenKbGenBindBuff[] readBuffByProbeIdx( CFGenKbAuthorization Authorization,
		Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByProbeIdx() ";
		CFGenKbGenBindBuff buff;
		ArrayList<CFGenKbGenBindBuff> filteredList = new ArrayList<CFGenKbGenBindBuff>();
		CFGenKbGenBindBuff[] buffList = readDerivedByProbeIdx( Authorization,
			ProbeTenantId,
			ProbeCartridgeId,
			ProbeGenItemId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenBindBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenBindBuff[0] ) );
	}

	public void updateGenBind( CFGenKbAuthorization Authorization,
		CFGenKbGenBindBuff Buff )
	{
		schema.getTableGenItem().updateGenItem( Authorization,
			Buff );
		CFGenKbGenItemPKey pkey = schema.getFactoryGenItem().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );
		pkey.setRequiredItemId( Buff.getRequiredItemId() );
		CFGenKbGenBindBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGenBind",
				"Existing record not found",
				"GenBind",
				pkey );
		}
		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableGenItem().readDerivedByItemIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredCartridgeId(),
						Buff.getRequiredItemId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateGenBind",
						"Superclass",
						"SuperClass",
						"GenItem",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGenItemPKey, CFGenKbGenBindBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteGenBind( CFGenKbAuthorization Authorization,
		CFGenKbGenBindBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGenBindTable.deleteGenBind() ";
		String classCode;
		CFGenKbGenItemPKey pkey = schema.getFactoryGenItem().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );
		pkey.setRequiredItemId( Buff.getRequiredItemId() );
		CFGenKbGenBindBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGenBind",
				pkey );
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
		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbGenItemPKey, CFGenKbGenBindBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableGenItem().deleteGenItem( Authorization,
			Buff );
	}
	public void deleteGenBindByItemIdIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId,
		long argItemId )
	{
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredCartridgeId( argCartridgeId );
		key.setRequiredItemId( argItemId );
		deleteGenBindByItemIdIdx( Authorization, key );
	}

	public void deleteGenBindByItemIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGenBindBuff cur;
		LinkedList<CFGenKbGenBindBuff> matchSet = new LinkedList<CFGenKbGenBindBuff>();
		Iterator<CFGenKbGenBindBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenBindBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenBind().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenBind( Authorization, cur );
		}
	}

	public void deleteGenBindByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGenItemByTenantIdxKey key = schema.getFactoryGenItem().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGenBindByTenantIdx( Authorization, key );
	}

	public void deleteGenBindByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByTenantIdxKey argKey )
	{
		CFGenKbGenBindBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenBindBuff> matchSet = new LinkedList<CFGenKbGenBindBuff>();
		Iterator<CFGenKbGenBindBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenBindBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenBind().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenBind( Authorization, cur );
		}
	}

	public void deleteGenBindByCartIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId )
	{
		CFGenKbGenItemByCartIdxKey key = schema.getFactoryGenItem().newCartIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredCartridgeId( argCartridgeId );
		deleteGenBindByCartIdx( Authorization, key );
	}

	public void deleteGenBindByCartIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByCartIdxKey argKey )
	{
		CFGenKbGenBindBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenBindBuff> matchSet = new LinkedList<CFGenKbGenBindBuff>();
		Iterator<CFGenKbGenBindBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenBindBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenBind().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenBind( Authorization, cur );
		}
	}

	public void deleteGenBindByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short argRuleTypeId )
	{
		CFGenKbGenItemByRuleTypeIdxKey key = schema.getFactoryGenItem().newRuleTypeIdxKey();
		key.setRequiredRuleTypeId( argRuleTypeId );
		deleteGenBindByRuleTypeIdx( Authorization, key );
	}

	public void deleteGenBindByRuleTypeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByRuleTypeIdxKey argKey )
	{
		CFGenKbGenBindBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenBindBuff> matchSet = new LinkedList<CFGenKbGenBindBuff>();
		Iterator<CFGenKbGenBindBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenBindBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenBind().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenBind( Authorization, cur );
		}
	}

	public void deleteGenBindByToolSetIdx( CFGenKbAuthorization Authorization,
		short argToolSetId )
	{
		CFGenKbGenItemByToolSetIdxKey key = schema.getFactoryGenItem().newToolSetIdxKey();
		key.setRequiredToolSetId( argToolSetId );
		deleteGenBindByToolSetIdx( Authorization, key );
	}

	public void deleteGenBindByToolSetIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByToolSetIdxKey argKey )
	{
		CFGenKbGenBindBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenBindBuff> matchSet = new LinkedList<CFGenKbGenBindBuff>();
		Iterator<CFGenKbGenBindBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenBindBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenBind().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenBind( Authorization, cur );
		}
	}

	public void deleteGenBindByScopeIdx( CFGenKbAuthorization Authorization,
		Short argScopeDefId )
	{
		CFGenKbGenItemByScopeIdxKey key = schema.getFactoryGenItem().newScopeIdxKey();
		key.setOptionalScopeDefId( argScopeDefId );
		deleteGenBindByScopeIdx( Authorization, key );
	}

	public void deleteGenBindByScopeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByScopeIdxKey argKey )
	{
		CFGenKbGenBindBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalScopeDefId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenBindBuff> matchSet = new LinkedList<CFGenKbGenBindBuff>();
		Iterator<CFGenKbGenBindBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenBindBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenBind().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenBind( Authorization, cur );
		}
	}

	public void deleteGenBindByGenDefIdx( CFGenKbAuthorization Authorization,
		short argGenDefId )
	{
		CFGenKbGenItemByGenDefIdxKey key = schema.getFactoryGenItem().newGenDefIdxKey();
		key.setRequiredGenDefId( argGenDefId );
		deleteGenBindByGenDefIdx( Authorization, key );
	}

	public void deleteGenBindByGenDefIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGenDefIdxKey argKey )
	{
		CFGenKbGenBindBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenBindBuff> matchSet = new LinkedList<CFGenKbGenBindBuff>();
		Iterator<CFGenKbGenBindBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenBindBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenBind().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenBind( Authorization, cur );
		}
	}

	public void deleteGenBindByAltIdx( CFGenKbAuthorization Authorization,
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
		deleteGenBindByAltIdx( Authorization, key );
	}

	public void deleteGenBindByAltIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByAltIdxKey argKey )
	{
		CFGenKbGenBindBuff cur;
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
		LinkedList<CFGenKbGenBindBuff> matchSet = new LinkedList<CFGenKbGenBindBuff>();
		Iterator<CFGenKbGenBindBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenBindBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenBind().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenBind( Authorization, cur );
		}
	}

	public void deleteGenBindByGelExecIdx( CFGenKbAuthorization Authorization,
		Long argGelExecutableTenantId,
		Long argGelExecutableGelCacheId,
		Long argGelExecutableId )
	{
		CFGenKbGenItemByGelExecIdxKey key = schema.getFactoryGenItem().newGelExecIdxKey();
		key.setOptionalGelExecutableTenantId( argGelExecutableTenantId );
		key.setOptionalGelExecutableGelCacheId( argGelExecutableGelCacheId );
		key.setOptionalGelExecutableId( argGelExecutableId );
		deleteGenBindByGelExecIdx( Authorization, key );
	}

	public void deleteGenBindByGelExecIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGelExecIdxKey argKey )
	{
		CFGenKbGenBindBuff cur;
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
		LinkedList<CFGenKbGenBindBuff> matchSet = new LinkedList<CFGenKbGenBindBuff>();
		Iterator<CFGenKbGenBindBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenBindBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenBind().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenBind( Authorization, cur );
		}
	}

	public void deleteGenBindByProbeIdx( CFGenKbAuthorization Authorization,
		Long argProbeTenantId,
		Long argProbeCartridgeId,
		Long argProbeGenItemId )
	{
		CFGenKbGenItemByProbeIdxKey key = schema.getFactoryGenItem().newProbeIdxKey();
		key.setOptionalProbeTenantId( argProbeTenantId );
		key.setOptionalProbeCartridgeId( argProbeCartridgeId );
		key.setOptionalProbeGenItemId( argProbeGenItemId );
		deleteGenBindByProbeIdx( Authorization, key );
	}

	public void deleteGenBindByProbeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByProbeIdxKey argKey )
	{
		CFGenKbGenBindBuff cur;
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
		LinkedList<CFGenKbGenBindBuff> matchSet = new LinkedList<CFGenKbGenBindBuff>();
		Iterator<CFGenKbGenBindBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenBindBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenBind().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenBind( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
