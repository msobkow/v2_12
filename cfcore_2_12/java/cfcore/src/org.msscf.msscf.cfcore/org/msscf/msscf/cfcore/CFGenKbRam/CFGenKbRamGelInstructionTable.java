
// Description: Java 11 in-memory RAM DbIO implementation for GelInstruction.

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
 *	CFGenKbRamGelInstructionTable in-memory RAM DbIO implementation
 *	for GelInstruction.
 */
public class CFGenKbRamGelInstructionTable
	implements ICFGenKbGelInstructionTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGelInstructionPKey,
				CFGenKbGelInstructionBuff > dictByPKey
		= new HashMap< CFGenKbGelInstructionPKey,
				CFGenKbGelInstructionBuff >();
	private Map< CFGenKbGelInstructionByTenantIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelInstructionBuff >> dictByTenantIdx
		= new HashMap< CFGenKbGelInstructionByTenantIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelInstructionBuff >>();
	private Map< CFGenKbGelInstructionByGelCacheIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelInstructionBuff >> dictByGelCacheIdx
		= new HashMap< CFGenKbGelInstructionByGelCacheIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelInstructionBuff >>();
	private Map< CFGenKbGelInstructionByChainIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelInstructionBuff >> dictByChainIdx
		= new HashMap< CFGenKbGelInstructionByChainIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelInstructionBuff >>();

	public CFGenKbRamGelInstructionTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGelInstruction( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionBuff Buff )
	{
		final String S_ProcName = "createGelInstruction";
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( ((CFGenKbRamTenantTable)schema.getTableTenant()).nextGelInstructionIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredGelCacheId( pkey.getRequiredGelCacheId() );
		Buff.setRequiredGelInstId( pkey.getRequiredGelInstId() );
		CFGenKbGelInstructionByTenantIdxKey keyTenantIdx = schema.getFactoryGelInstruction().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx = schema.getFactoryGelInstruction().newGelCacheIdxKey();
		keyGelCacheIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyGelCacheIdx.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );

		CFGenKbGelInstructionByChainIdxKey keyChainIdx = schema.getFactoryGelInstruction().newChainIdxKey();
		keyChainIdx.setOptionalChainInstTenantId( Buff.getOptionalChainInstTenantId() );
		keyChainIdx.setOptionalChainInstGelCacheId( Buff.getOptionalChainInstGelCacheId() );
		keyChainIdx.setOptionalChainInstGelInstId( Buff.getOptionalChainInstGelInstId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
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
				if( null == schema.getTableGelCache().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredGelCacheId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"GelCache",
						"GelCache",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff > subdictGelCacheIdx;
		if( dictByGelCacheIdx.containsKey( keyGelCacheIdx ) ) {
			subdictGelCacheIdx = dictByGelCacheIdx.get( keyGelCacheIdx );
		}
		else {
			subdictGelCacheIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff >();
			dictByGelCacheIdx.put( keyGelCacheIdx, subdictGelCacheIdx );
		}
		subdictGelCacheIdx.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff > subdictChainIdx;
		if( dictByChainIdx.containsKey( keyChainIdx ) ) {
			subdictChainIdx = dictByChainIdx.get( keyChainIdx );
		}
		else {
			subdictChainIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff >();
			dictByChainIdx.put( keyChainIdx, subdictChainIdx );
		}
		subdictChainIdx.put( pkey, Buff );

	}

	public CFGenKbGelInstructionBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelInstructionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelInstructionBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelInstructionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelInstructionBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGelInstruction.readAllDerived";
		CFGenKbGelInstructionBuff[] retList = new CFGenKbGelInstructionBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGelInstructionBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGelInstructionBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByTenantIdx";
		CFGenKbGelInstructionByTenantIdxKey key = schema.getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFGenKbGelInstructionBuff[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new CFGenKbGelInstructionBuff[ subdictTenantIdx.size() ];
			Iterator< CFGenKbGelInstructionBuff > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff > subdictTenantIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new CFGenKbGelInstructionBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelInstructionBuff[] readDerivedByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByGelCacheIdx";
		CFGenKbGelInstructionByGelCacheIdxKey key = schema.getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );

		CFGenKbGelInstructionBuff[] recArray;
		if( dictByGelCacheIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff > subdictGelCacheIdx
				= dictByGelCacheIdx.get( key );
			recArray = new CFGenKbGelInstructionBuff[ subdictGelCacheIdx.size() ];
			Iterator< CFGenKbGelInstructionBuff > iter = subdictGelCacheIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff > subdictGelCacheIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff >();
			dictByGelCacheIdx.put( key, subdictGelCacheIdx );
			recArray = new CFGenKbGelInstructionBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelInstructionBuff[] readDerivedByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByChainIdx";
		CFGenKbGelInstructionByChainIdxKey key = schema.getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );

		CFGenKbGelInstructionBuff[] recArray;
		if( dictByChainIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff > subdictChainIdx
				= dictByChainIdx.get( key );
			recArray = new CFGenKbGelInstructionBuff[ subdictChainIdx.size() ];
			Iterator< CFGenKbGelInstructionBuff > iter = subdictChainIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff > subdictChainIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff >();
			dictByChainIdx.put( key, subdictChainIdx );
			recArray = new CFGenKbGelInstructionBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelInstructionBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByPIdx() ";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );

		CFGenKbGelInstructionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelInstructionBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuff";
		CFGenKbGelInstructionBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GINS" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelInstructionBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGelInstructionBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GINS" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelInstructionBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readAllBuff";
		CFGenKbGelInstructionBuff buff;
		ArrayList<CFGenKbGelInstructionBuff> filteredList = new ArrayList<CFGenKbGelInstructionBuff>();
		CFGenKbGelInstructionBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelInstructionBuff[0] ) );
	}

	public CFGenKbGelInstructionBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByPIdx() ";
		CFGenKbGelInstructionBuff buff = readDerivedByPIdx( Authorization,
			TenantId,
			GelCacheId,
			GelInstId );
		if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
			return( (CFGenKbGelInstructionBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGelInstructionBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByTenantIdx() ";
		CFGenKbGelInstructionBuff buff;
		ArrayList<CFGenKbGelInstructionBuff> filteredList = new ArrayList<CFGenKbGelInstructionBuff>();
		CFGenKbGelInstructionBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelInstructionBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelInstructionBuff[0] ) );
	}

	public CFGenKbGelInstructionBuff[] readBuffByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByGelCacheIdx() ";
		CFGenKbGelInstructionBuff buff;
		ArrayList<CFGenKbGelInstructionBuff> filteredList = new ArrayList<CFGenKbGelInstructionBuff>();
		CFGenKbGelInstructionBuff[] buffList = readDerivedByGelCacheIdx( Authorization,
			TenantId,
			GelCacheId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelInstructionBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelInstructionBuff[0] ) );
	}

	public CFGenKbGelInstructionBuff[] readBuffByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByChainIdx() ";
		CFGenKbGelInstructionBuff buff;
		ArrayList<CFGenKbGelInstructionBuff> filteredList = new ArrayList<CFGenKbGelInstructionBuff>();
		CFGenKbGelInstructionBuff[] buffList = readDerivedByChainIdx( Authorization,
			ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelInstructionBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelInstructionBuff[0] ) );
	}

	public void updateGelInstruction( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionBuff Buff )
	{
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelInstructionBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGelInstruction",
				"Existing record not found",
				"GelInstruction",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateGelInstruction",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbGelInstructionByTenantIdxKey existingKeyTenantIdx = schema.getFactoryGelInstruction().newTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFGenKbGelInstructionByTenantIdxKey newKeyTenantIdx = schema.getFactoryGelInstruction().newTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFGenKbGelInstructionByGelCacheIdxKey existingKeyGelCacheIdx = schema.getFactoryGelInstruction().newGelCacheIdxKey();
		existingKeyGelCacheIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyGelCacheIdx.setRequiredGelCacheId( existing.getRequiredGelCacheId() );

		CFGenKbGelInstructionByGelCacheIdxKey newKeyGelCacheIdx = schema.getFactoryGelInstruction().newGelCacheIdxKey();
		newKeyGelCacheIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyGelCacheIdx.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );

		CFGenKbGelInstructionByChainIdxKey existingKeyChainIdx = schema.getFactoryGelInstruction().newChainIdxKey();
		existingKeyChainIdx.setOptionalChainInstTenantId( existing.getOptionalChainInstTenantId() );
		existingKeyChainIdx.setOptionalChainInstGelCacheId( existing.getOptionalChainInstGelCacheId() );
		existingKeyChainIdx.setOptionalChainInstGelInstId( existing.getOptionalChainInstGelInstId() );

		CFGenKbGelInstructionByChainIdxKey newKeyChainIdx = schema.getFactoryGelInstruction().newChainIdxKey();
		newKeyChainIdx.setOptionalChainInstTenantId( Buff.getOptionalChainInstTenantId() );
		newKeyChainIdx.setOptionalChainInstGelCacheId( Buff.getOptionalChainInstGelCacheId() );
		newKeyChainIdx.setOptionalChainInstGelInstId( Buff.getOptionalChainInstGelInstId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateGelInstruction",
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
				if( null == schema.getTableGelCache().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredGelCacheId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateGelInstruction",
						"Container",
						"GelCache",
						"GelCache",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff > subdict;

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
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByGelCacheIdx.get( existingKeyGelCacheIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByGelCacheIdx.containsKey( newKeyGelCacheIdx ) ) {
			subdict = dictByGelCacheIdx.get( newKeyGelCacheIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff >();
			dictByGelCacheIdx.put( newKeyGelCacheIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByChainIdx.get( existingKeyChainIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByChainIdx.containsKey( newKeyChainIdx ) ) {
			subdict = dictByChainIdx.get( newKeyChainIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff >();
			dictByChainIdx.put( newKeyChainIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteGelInstruction( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGelInstructionTable.deleteGelInstruction() ";
		String classCode;
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelInstructionBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGelInstruction",
				pkey );
		}
		CFGenKbGelInstructionByTenantIdxKey keyTenantIdx = schema.getFactoryGelInstruction().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx = schema.getFactoryGelInstruction().newGelCacheIdxKey();
		keyGelCacheIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyGelCacheIdx.setRequiredGelCacheId( existing.getRequiredGelCacheId() );

		CFGenKbGelInstructionByChainIdxKey keyChainIdx = schema.getFactoryGelInstruction().newChainIdxKey();
		keyChainIdx.setOptionalChainInstTenantId( existing.getOptionalChainInstTenantId() );
		keyChainIdx.setOptionalChainInstGelCacheId( existing.getOptionalChainInstGelCacheId() );
		keyChainIdx.setOptionalChainInstGelInstId( existing.getOptionalChainInstGelInstId() );

		// Validate reverse foreign keys

		if( schema.getTableGelIterator().readDerivedByPIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredGelCacheId(),
					existing.getRequiredGelInstId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGelInstruction",
				"Superclass",
				"SuperClass",
				"GelIterator",
				pkey );
		}

		if( schema.getTableGelSpread().readDerivedByPIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredGelCacheId(),
					existing.getRequiredGelInstId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGelInstruction",
				"Superclass",
				"SuperClass",
				"GelSpread",
				pkey );
		}

		if( schema.getTableGelPop().readDerivedByPIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredGelCacheId(),
					existing.getRequiredGelInstId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGelInstruction",
				"Superclass",
				"SuperClass",
				"GelPop",
				pkey );
		}

		if( schema.getTableGelPrefixLine().readDerivedByPIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredGelCacheId(),
					existing.getRequiredGelInstId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGelInstruction",
				"Superclass",
				"SuperClass",
				"GelPrefixLine",
				pkey );
		}

		if( schema.getTableGelReference().readDerivedByPIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredGelCacheId(),
					existing.getRequiredGelInstId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGelInstruction",
				"Superclass",
				"SuperClass",
				"GelReference",
				pkey );
		}

		if( schema.getTableGelCall().readDerivedByPIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredGelCacheId(),
					existing.getRequiredGelInstId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGelInstruction",
				"Superclass",
				"SuperClass",
				"GelCall",
				pkey );
		}

		if( schema.getTableGelSequence().readDerivedByPIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredGelCacheId(),
					existing.getRequiredGelInstId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGelInstruction",
				"Superclass",
				"SuperClass",
				"GelSequence",
				pkey );
		}

		if( schema.getTableGelSwitch().readDerivedByPIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredGelCacheId(),
					existing.getRequiredGelInstId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGelInstruction",
				"Superclass",
				"SuperClass",
				"GelSwitch",
				pkey );
		}

		if( schema.getTableGelBoilerplate().readDerivedByPIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredGelCacheId(),
					existing.getRequiredGelInstId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGelInstruction",
				"Superclass",
				"SuperClass",
				"GelBoilerplate",
				pkey );
		}

		if( schema.getTableGelBuiltin().readDerivedByPIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredGelCacheId(),
					existing.getRequiredGelInstId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGelInstruction",
				"Superclass",
				"SuperClass",
				"GelBuiltin",
				pkey );
		}

		if( schema.getTableGelConstrain().readDerivedByPIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredGelCacheId(),
					existing.getRequiredGelInstId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGelInstruction",
				"Superclass",
				"SuperClass",
				"GelConstrain",
				pkey );
		}

		if( schema.getTableGelCounter().readDerivedByPIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredGelCacheId(),
					existing.getRequiredGelInstId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGelInstruction",
				"Superclass",
				"SuperClass",
				"GelCounter",
				pkey );
		}

		if( schema.getTableGelExpansion().readDerivedByPIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredGelCacheId(),
					existing.getRequiredGelInstId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGelInstruction",
				"Superclass",
				"SuperClass",
				"GelExpansion",
				pkey );
		}

		if( schema.getTableGelModifier().readDerivedByPIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredGelCacheId(),
					existing.getRequiredGelInstId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGelInstruction",
				"Superclass",
				"SuperClass",
				"GelModifier",
				pkey );
		}

		// Delete is valid
		Map< CFGenKbGelInstructionPKey, CFGenKbGelInstructionBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		subdict = dictByGelCacheIdx.get( keyGelCacheIdx );
		subdict.remove( pkey );

		subdict = dictByChainIdx.get( keyChainIdx );
		subdict.remove( pkey );

	}
	public void deleteGelInstructionByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId )
	{
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		key.setRequiredGelInstId( argGelInstId );
		deleteGelInstructionByPIdx( Authorization, key );
	}

	public void deleteGelInstructionByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey argKey )
	{
		final String S_ProcName = "deleteGelInstructionByPIdx";
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGelInstructionBuff cur;
		LinkedList<CFGenKbGelInstructionBuff> matchSet = new LinkedList<CFGenKbGelInstructionBuff>();
		Iterator<CFGenKbGelInstructionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelInstructionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelInstruction().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			String subClassCode = cur.getClassCode();
			if( "GINS".equals( subClassCode ) ) {
				schema.getTableGelInstruction().deleteGelInstruction( Authorization, cur );
			}
			else if( "GITR".equals( subClassCode ) ) {
				schema.getTableGelIterator().deleteGelIterator( Authorization, (CFGenKbGelIteratorBuff)cur );
			}
			else if( "GSPR".equals( subClassCode ) ) {
				schema.getTableGelSpread().deleteGelSpread( Authorization, (CFGenKbGelSpreadBuff)cur );
			}
			else if( "GPOP".equals( subClassCode ) ) {
				schema.getTableGelPop().deleteGelPop( Authorization, (CFGenKbGelPopBuff)cur );
			}
			else if( "GPFX".equals( subClassCode ) ) {
				schema.getTableGelPrefixLine().deleteGelPrefixLine( Authorization, (CFGenKbGelPrefixLineBuff)cur );
			}
			else if( "GREF".equals( subClassCode ) ) {
				schema.getTableGelReference().deleteGelReference( Authorization, (CFGenKbGelReferenceBuff)cur );
			}
			else if( "GCAL".equals( subClassCode ) ) {
				schema.getTableGelCall().deleteGelCall( Authorization, (CFGenKbGelCallBuff)cur );
			}
			else if( "GSEQ".equals( subClassCode ) ) {
				schema.getTableGelSequence().deleteGelSequence( Authorization, (CFGenKbGelSequenceBuff)cur );
			}
			else if( "GEXE".equals( subClassCode ) ) {
				schema.getTableGelExecutable().deleteGelExecutable( Authorization, (CFGenKbGelExecutableBuff)cur );
			}
			else if( "GSWT".equals( subClassCode ) ) {
				schema.getTableGelSwitch().deleteGelSwitch( Authorization, (CFGenKbGelSwitchBuff)cur );
			}
			else if( "GBLR".equals( subClassCode ) ) {
				schema.getTableGelBoilerplate().deleteGelBoilerplate( Authorization, (CFGenKbGelBoilerplateBuff)cur );
			}
			else if( "GERR".equals( subClassCode ) ) {
				schema.getTableGelError().deleteGelError( Authorization, (CFGenKbGelErrorBuff)cur );
			}
			else if( "GBLT".equals( subClassCode ) ) {
				schema.getTableGelBuiltin().deleteGelBuiltin( Authorization, (CFGenKbGelBuiltinBuff)cur );
			}
			else if( "GCON".equals( subClassCode ) ) {
				schema.getTableGelConstrain().deleteGelConstrain( Authorization, (CFGenKbGelConstrainBuff)cur );
			}
			else if( "GCNT".equals( subClassCode ) ) {
				schema.getTableGelCounter().deleteGelCounter( Authorization, (CFGenKbGelCounterBuff)cur );
			}
			else if( "GEXP".equals( subClassCode ) ) {
				schema.getTableGelExpansion().deleteGelExpansion( Authorization, (CFGenKbGelExpansionBuff)cur );
			}
			else if( "GMOD".equals( subClassCode ) ) {
				schema.getTableGelModifier().deleteGelModifier( Authorization, (CFGenKbGelModifierBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GelInstruction must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGelInstructionByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGelInstructionByTenantIdxKey key = schema.getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGelInstructionByTenantIdx( Authorization, key );
	}

	public void deleteGelInstructionByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByTenantIdxKey argKey )
	{
		final String S_ProcName = "deleteGelInstructionByTenantIdx";
		CFGenKbGelInstructionBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelInstructionBuff> matchSet = new LinkedList<CFGenKbGelInstructionBuff>();
		Iterator<CFGenKbGelInstructionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelInstructionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelInstruction().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			String subClassCode = cur.getClassCode();
			if( "GINS".equals( subClassCode ) ) {
				schema.getTableGelInstruction().deleteGelInstruction( Authorization, cur );
			}
			else if( "GITR".equals( subClassCode ) ) {
				schema.getTableGelIterator().deleteGelIterator( Authorization, (CFGenKbGelIteratorBuff)cur );
			}
			else if( "GSPR".equals( subClassCode ) ) {
				schema.getTableGelSpread().deleteGelSpread( Authorization, (CFGenKbGelSpreadBuff)cur );
			}
			else if( "GPOP".equals( subClassCode ) ) {
				schema.getTableGelPop().deleteGelPop( Authorization, (CFGenKbGelPopBuff)cur );
			}
			else if( "GPFX".equals( subClassCode ) ) {
				schema.getTableGelPrefixLine().deleteGelPrefixLine( Authorization, (CFGenKbGelPrefixLineBuff)cur );
			}
			else if( "GREF".equals( subClassCode ) ) {
				schema.getTableGelReference().deleteGelReference( Authorization, (CFGenKbGelReferenceBuff)cur );
			}
			else if( "GCAL".equals( subClassCode ) ) {
				schema.getTableGelCall().deleteGelCall( Authorization, (CFGenKbGelCallBuff)cur );
			}
			else if( "GSEQ".equals( subClassCode ) ) {
				schema.getTableGelSequence().deleteGelSequence( Authorization, (CFGenKbGelSequenceBuff)cur );
			}
			else if( "GEXE".equals( subClassCode ) ) {
				schema.getTableGelExecutable().deleteGelExecutable( Authorization, (CFGenKbGelExecutableBuff)cur );
			}
			else if( "GSWT".equals( subClassCode ) ) {
				schema.getTableGelSwitch().deleteGelSwitch( Authorization, (CFGenKbGelSwitchBuff)cur );
			}
			else if( "GBLR".equals( subClassCode ) ) {
				schema.getTableGelBoilerplate().deleteGelBoilerplate( Authorization, (CFGenKbGelBoilerplateBuff)cur );
			}
			else if( "GERR".equals( subClassCode ) ) {
				schema.getTableGelError().deleteGelError( Authorization, (CFGenKbGelErrorBuff)cur );
			}
			else if( "GBLT".equals( subClassCode ) ) {
				schema.getTableGelBuiltin().deleteGelBuiltin( Authorization, (CFGenKbGelBuiltinBuff)cur );
			}
			else if( "GCON".equals( subClassCode ) ) {
				schema.getTableGelConstrain().deleteGelConstrain( Authorization, (CFGenKbGelConstrainBuff)cur );
			}
			else if( "GCNT".equals( subClassCode ) ) {
				schema.getTableGelCounter().deleteGelCounter( Authorization, (CFGenKbGelCounterBuff)cur );
			}
			else if( "GEXP".equals( subClassCode ) ) {
				schema.getTableGelExpansion().deleteGelExpansion( Authorization, (CFGenKbGelExpansionBuff)cur );
			}
			else if( "GMOD".equals( subClassCode ) ) {
				schema.getTableGelModifier().deleteGelModifier( Authorization, (CFGenKbGelModifierBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GelInstruction must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGelInstructionByGelCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId )
	{
		CFGenKbGelInstructionByGelCacheIdxKey key = schema.getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		deleteGelInstructionByGelCacheIdx( Authorization, key );
	}

	public void deleteGelInstructionByGelCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByGelCacheIdxKey argKey )
	{
		final String S_ProcName = "deleteGelInstructionByGelCacheIdx";
		CFGenKbGelInstructionBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelInstructionBuff> matchSet = new LinkedList<CFGenKbGelInstructionBuff>();
		Iterator<CFGenKbGelInstructionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelInstructionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelInstruction().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			String subClassCode = cur.getClassCode();
			if( "GINS".equals( subClassCode ) ) {
				schema.getTableGelInstruction().deleteGelInstruction( Authorization, cur );
			}
			else if( "GITR".equals( subClassCode ) ) {
				schema.getTableGelIterator().deleteGelIterator( Authorization, (CFGenKbGelIteratorBuff)cur );
			}
			else if( "GSPR".equals( subClassCode ) ) {
				schema.getTableGelSpread().deleteGelSpread( Authorization, (CFGenKbGelSpreadBuff)cur );
			}
			else if( "GPOP".equals( subClassCode ) ) {
				schema.getTableGelPop().deleteGelPop( Authorization, (CFGenKbGelPopBuff)cur );
			}
			else if( "GPFX".equals( subClassCode ) ) {
				schema.getTableGelPrefixLine().deleteGelPrefixLine( Authorization, (CFGenKbGelPrefixLineBuff)cur );
			}
			else if( "GREF".equals( subClassCode ) ) {
				schema.getTableGelReference().deleteGelReference( Authorization, (CFGenKbGelReferenceBuff)cur );
			}
			else if( "GCAL".equals( subClassCode ) ) {
				schema.getTableGelCall().deleteGelCall( Authorization, (CFGenKbGelCallBuff)cur );
			}
			else if( "GSEQ".equals( subClassCode ) ) {
				schema.getTableGelSequence().deleteGelSequence( Authorization, (CFGenKbGelSequenceBuff)cur );
			}
			else if( "GEXE".equals( subClassCode ) ) {
				schema.getTableGelExecutable().deleteGelExecutable( Authorization, (CFGenKbGelExecutableBuff)cur );
			}
			else if( "GSWT".equals( subClassCode ) ) {
				schema.getTableGelSwitch().deleteGelSwitch( Authorization, (CFGenKbGelSwitchBuff)cur );
			}
			else if( "GBLR".equals( subClassCode ) ) {
				schema.getTableGelBoilerplate().deleteGelBoilerplate( Authorization, (CFGenKbGelBoilerplateBuff)cur );
			}
			else if( "GERR".equals( subClassCode ) ) {
				schema.getTableGelError().deleteGelError( Authorization, (CFGenKbGelErrorBuff)cur );
			}
			else if( "GBLT".equals( subClassCode ) ) {
				schema.getTableGelBuiltin().deleteGelBuiltin( Authorization, (CFGenKbGelBuiltinBuff)cur );
			}
			else if( "GCON".equals( subClassCode ) ) {
				schema.getTableGelConstrain().deleteGelConstrain( Authorization, (CFGenKbGelConstrainBuff)cur );
			}
			else if( "GCNT".equals( subClassCode ) ) {
				schema.getTableGelCounter().deleteGelCounter( Authorization, (CFGenKbGelCounterBuff)cur );
			}
			else if( "GEXP".equals( subClassCode ) ) {
				schema.getTableGelExpansion().deleteGelExpansion( Authorization, (CFGenKbGelExpansionBuff)cur );
			}
			else if( "GMOD".equals( subClassCode ) ) {
				schema.getTableGelModifier().deleteGelModifier( Authorization, (CFGenKbGelModifierBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GelInstruction must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGelInstructionByChainIdx( CFGenKbAuthorization Authorization,
		Long argChainInstTenantId,
		Long argChainInstGelCacheId,
		Long argChainInstGelInstId )
	{
		CFGenKbGelInstructionByChainIdxKey key = schema.getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( argChainInstTenantId );
		key.setOptionalChainInstGelCacheId( argChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( argChainInstGelInstId );
		deleteGelInstructionByChainIdx( Authorization, key );
	}

	public void deleteGelInstructionByChainIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByChainIdxKey argKey )
	{
		final String S_ProcName = "deleteGelInstructionByChainIdx";
		CFGenKbGelInstructionBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalChainInstTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalChainInstGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalChainInstGelInstId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelInstructionBuff> matchSet = new LinkedList<CFGenKbGelInstructionBuff>();
		Iterator<CFGenKbGelInstructionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelInstructionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelInstruction().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			String subClassCode = cur.getClassCode();
			if( "GINS".equals( subClassCode ) ) {
				schema.getTableGelInstruction().deleteGelInstruction( Authorization, cur );
			}
			else if( "GITR".equals( subClassCode ) ) {
				schema.getTableGelIterator().deleteGelIterator( Authorization, (CFGenKbGelIteratorBuff)cur );
			}
			else if( "GSPR".equals( subClassCode ) ) {
				schema.getTableGelSpread().deleteGelSpread( Authorization, (CFGenKbGelSpreadBuff)cur );
			}
			else if( "GPOP".equals( subClassCode ) ) {
				schema.getTableGelPop().deleteGelPop( Authorization, (CFGenKbGelPopBuff)cur );
			}
			else if( "GPFX".equals( subClassCode ) ) {
				schema.getTableGelPrefixLine().deleteGelPrefixLine( Authorization, (CFGenKbGelPrefixLineBuff)cur );
			}
			else if( "GREF".equals( subClassCode ) ) {
				schema.getTableGelReference().deleteGelReference( Authorization, (CFGenKbGelReferenceBuff)cur );
			}
			else if( "GCAL".equals( subClassCode ) ) {
				schema.getTableGelCall().deleteGelCall( Authorization, (CFGenKbGelCallBuff)cur );
			}
			else if( "GSEQ".equals( subClassCode ) ) {
				schema.getTableGelSequence().deleteGelSequence( Authorization, (CFGenKbGelSequenceBuff)cur );
			}
			else if( "GEXE".equals( subClassCode ) ) {
				schema.getTableGelExecutable().deleteGelExecutable( Authorization, (CFGenKbGelExecutableBuff)cur );
			}
			else if( "GSWT".equals( subClassCode ) ) {
				schema.getTableGelSwitch().deleteGelSwitch( Authorization, (CFGenKbGelSwitchBuff)cur );
			}
			else if( "GBLR".equals( subClassCode ) ) {
				schema.getTableGelBoilerplate().deleteGelBoilerplate( Authorization, (CFGenKbGelBoilerplateBuff)cur );
			}
			else if( "GERR".equals( subClassCode ) ) {
				schema.getTableGelError().deleteGelError( Authorization, (CFGenKbGelErrorBuff)cur );
			}
			else if( "GBLT".equals( subClassCode ) ) {
				schema.getTableGelBuiltin().deleteGelBuiltin( Authorization, (CFGenKbGelBuiltinBuff)cur );
			}
			else if( "GCON".equals( subClassCode ) ) {
				schema.getTableGelConstrain().deleteGelConstrain( Authorization, (CFGenKbGelConstrainBuff)cur );
			}
			else if( "GCNT".equals( subClassCode ) ) {
				schema.getTableGelCounter().deleteGelCounter( Authorization, (CFGenKbGelCounterBuff)cur );
			}
			else if( "GEXP".equals( subClassCode ) ) {
				schema.getTableGelExpansion().deleteGelExpansion( Authorization, (CFGenKbGelExpansionBuff)cur );
			}
			else if( "GMOD".equals( subClassCode ) ) {
				schema.getTableGelModifier().deleteGelModifier( Authorization, (CFGenKbGelModifierBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GelInstruction must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void releasePreparedStatements() {
	}
}
