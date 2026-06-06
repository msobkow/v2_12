
// Description: Java 11 in-memory RAM DbIO implementation for GelSwitch.

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
 *	CFGenKbRamGelSwitchTable in-memory RAM DbIO implementation
 *	for GelSwitch.
 */
public class CFGenKbRamGelSwitchTable
	implements ICFGenKbGelSwitchTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGelInstructionPKey,
				CFGenKbGelSwitchBuff > dictByPKey
		= new HashMap< CFGenKbGelInstructionPKey,
				CFGenKbGelSwitchBuff >();

	public CFGenKbRamGelSwitchTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGelSwitch( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchBuff Buff )
	{
		final String S_ProcName = "createGelSwitch";
		schema.getTableGelInstruction().createGelInstruction( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
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
				if( null == schema.getTableGelInstruction().readDerivedByPIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredGelCacheId(),
						Buff.getRequiredGelInstId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"GelInstruction",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

	}

	public CFGenKbGelSwitchBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelSwitch.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelSwitchBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSwitchBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelSwitch.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelSwitchBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSwitchBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGelSwitch.readAllDerived";
		CFGenKbGelSwitchBuff[] retList = new CFGenKbGelSwitchBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGelSwitchBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGelSwitchBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByTenantIdx";
		CFGenKbGelInstructionBuff buffList[] = schema.getTableGelInstruction().readDerivedByTenantIdx( Authorization,
			TenantId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGelInstructionBuff buff;
			ArrayList<CFGenKbGelSwitchBuff> filteredList = new ArrayList<CFGenKbGelSwitchBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelSwitchBuff ) ) {
					filteredList.add( (CFGenKbGelSwitchBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelSwitchBuff[0] ) );
		}
	}

	public CFGenKbGelSwitchBuff[] readDerivedByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByGelCacheIdx";
		CFGenKbGelInstructionBuff buffList[] = schema.getTableGelInstruction().readDerivedByGelCacheIdx( Authorization,
			TenantId,
			GelCacheId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGelInstructionBuff buff;
			ArrayList<CFGenKbGelSwitchBuff> filteredList = new ArrayList<CFGenKbGelSwitchBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelSwitchBuff ) ) {
					filteredList.add( (CFGenKbGelSwitchBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelSwitchBuff[0] ) );
		}
	}

	public CFGenKbGelSwitchBuff[] readDerivedByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByChainIdx";
		CFGenKbGelInstructionBuff buffList[] = schema.getTableGelInstruction().readDerivedByChainIdx( Authorization,
			ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGelInstructionBuff buff;
			ArrayList<CFGenKbGelSwitchBuff> filteredList = new ArrayList<CFGenKbGelSwitchBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelSwitchBuff ) ) {
					filteredList.add( (CFGenKbGelSwitchBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelSwitchBuff[0] ) );
		}
	}

	public CFGenKbGelSwitchBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByPIdx() ";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );

		CFGenKbGelSwitchBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSwitchBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelSwitch.readBuff";
		CFGenKbGelSwitchBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GSWT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSwitchBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGelSwitchBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GSWT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSwitchBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGelSwitch.readAllBuff";
		CFGenKbGelSwitchBuff buff;
		ArrayList<CFGenKbGelSwitchBuff> filteredList = new ArrayList<CFGenKbGelSwitchBuff>();
		CFGenKbGelSwitchBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GSWT" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSwitchBuff[0] ) );
	}

	public CFGenKbGelSwitchBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByPIdx() ";
		CFGenKbGelSwitchBuff buff = readDerivedByPIdx( Authorization,
			TenantId,
			GelCacheId,
			GelInstId );
		if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
			return( (CFGenKbGelSwitchBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGelSwitchBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByTenantIdx() ";
		CFGenKbGelSwitchBuff buff;
		ArrayList<CFGenKbGelSwitchBuff> filteredList = new ArrayList<CFGenKbGelSwitchBuff>();
		CFGenKbGelSwitchBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelSwitchBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSwitchBuff[0] ) );
	}

	public CFGenKbGelSwitchBuff[] readBuffByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByGelCacheIdx() ";
		CFGenKbGelSwitchBuff buff;
		ArrayList<CFGenKbGelSwitchBuff> filteredList = new ArrayList<CFGenKbGelSwitchBuff>();
		CFGenKbGelSwitchBuff[] buffList = readDerivedByGelCacheIdx( Authorization,
			TenantId,
			GelCacheId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelSwitchBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSwitchBuff[0] ) );
	}

	public CFGenKbGelSwitchBuff[] readBuffByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByChainIdx() ";
		CFGenKbGelSwitchBuff buff;
		ArrayList<CFGenKbGelSwitchBuff> filteredList = new ArrayList<CFGenKbGelSwitchBuff>();
		CFGenKbGelSwitchBuff[] buffList = readDerivedByChainIdx( Authorization,
			ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelSwitchBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSwitchBuff[0] ) );
	}

	public void updateGelSwitch( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchBuff Buff )
	{
		schema.getTableGelInstruction().updateGelInstruction( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelSwitchBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGelSwitch",
				"Existing record not found",
				"GelSwitch",
				pkey );
		}
		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableGelInstruction().readDerivedByPIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredGelCacheId(),
						Buff.getRequiredGelInstId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateGelSwitch",
						"Superclass",
						"SuperClass",
						"GelInstruction",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGelInstructionPKey, CFGenKbGelSwitchBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteGelSwitch( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGelSwitchTable.deleteGelSwitch() ";
		String classCode;
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelSwitchBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGelSwitch",
				pkey );
		}
					schema.getTableGelSwitchLimb().deleteGelSwitchLimbBySwitchIdx( Authorization,
						existing.getRequiredTenantId(),
						existing.getRequiredGelCacheId(),
						existing.getRequiredGelInstId() );
		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbGelInstructionPKey, CFGenKbGelSwitchBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableGelInstruction().deleteGelInstruction( Authorization,
			Buff );
	}
	public void deleteGelSwitchByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId )
	{
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		key.setRequiredGelInstId( argGelInstId );
		deleteGelSwitchByPIdx( Authorization, key );
	}

	public void deleteGelSwitchByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGelSwitchBuff cur;
		LinkedList<CFGenKbGelSwitchBuff> matchSet = new LinkedList<CFGenKbGelSwitchBuff>();
		Iterator<CFGenKbGelSwitchBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSwitchBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSwitch().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelSwitch( Authorization, cur );
		}
	}

	public void deleteGelSwitchByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGelInstructionByTenantIdxKey key = schema.getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGelSwitchByTenantIdx( Authorization, key );
	}

	public void deleteGelSwitchByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByTenantIdxKey argKey )
	{
		CFGenKbGelSwitchBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelSwitchBuff> matchSet = new LinkedList<CFGenKbGelSwitchBuff>();
		Iterator<CFGenKbGelSwitchBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSwitchBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSwitch().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelSwitch( Authorization, cur );
		}
	}

	public void deleteGelSwitchByGelCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId )
	{
		CFGenKbGelInstructionByGelCacheIdxKey key = schema.getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		deleteGelSwitchByGelCacheIdx( Authorization, key );
	}

	public void deleteGelSwitchByGelCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByGelCacheIdxKey argKey )
	{
		CFGenKbGelSwitchBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelSwitchBuff> matchSet = new LinkedList<CFGenKbGelSwitchBuff>();
		Iterator<CFGenKbGelSwitchBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSwitchBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSwitch().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelSwitch( Authorization, cur );
		}
	}

	public void deleteGelSwitchByChainIdx( CFGenKbAuthorization Authorization,
		Long argChainInstTenantId,
		Long argChainInstGelCacheId,
		Long argChainInstGelInstId )
	{
		CFGenKbGelInstructionByChainIdxKey key = schema.getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( argChainInstTenantId );
		key.setOptionalChainInstGelCacheId( argChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( argChainInstGelInstId );
		deleteGelSwitchByChainIdx( Authorization, key );
	}

	public void deleteGelSwitchByChainIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByChainIdxKey argKey )
	{
		CFGenKbGelSwitchBuff cur;
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
		LinkedList<CFGenKbGelSwitchBuff> matchSet = new LinkedList<CFGenKbGelSwitchBuff>();
		Iterator<CFGenKbGelSwitchBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSwitchBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSwitch().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelSwitch( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
