
// Description: Java 11 in-memory RAM DbIO implementation for GelCounter.

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
 *	CFGenKbRamGelCounterTable in-memory RAM DbIO implementation
 *	for GelCounter.
 */
public class CFGenKbRamGelCounterTable
	implements ICFGenKbGelCounterTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGelInstructionPKey,
				CFGenKbGelCounterBuff > dictByPKey
		= new HashMap< CFGenKbGelInstructionPKey,
				CFGenKbGelCounterBuff >();

	public CFGenKbRamGelCounterTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGelCounter( CFGenKbAuthorization Authorization,
		CFGenKbGelCounterBuff Buff )
	{
		final String S_ProcName = "createGelCounter";
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

	public CFGenKbGelCounterBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelCounter.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelCounterBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelCounterBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelCounter.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelCounterBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelCounterBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGelCounter.readAllDerived";
		CFGenKbGelCounterBuff[] retList = new CFGenKbGelCounterBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGelCounterBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGelCounterBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelCounterBuff> filteredList = new ArrayList<CFGenKbGelCounterBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelCounterBuff ) ) {
					filteredList.add( (CFGenKbGelCounterBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelCounterBuff[0] ) );
		}
	}

	public CFGenKbGelCounterBuff[] readDerivedByGelCacheIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelCounterBuff> filteredList = new ArrayList<CFGenKbGelCounterBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelCounterBuff ) ) {
					filteredList.add( (CFGenKbGelCounterBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelCounterBuff[0] ) );
		}
	}

	public CFGenKbGelCounterBuff[] readDerivedByChainIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelCounterBuff> filteredList = new ArrayList<CFGenKbGelCounterBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelCounterBuff ) ) {
					filteredList.add( (CFGenKbGelCounterBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelCounterBuff[0] ) );
		}
	}

	public CFGenKbGelCounterBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByPIdx() ";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );

		CFGenKbGelCounterBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelCounterBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelCounter.readBuff";
		CFGenKbGelCounterBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GCNT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelCounterBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGelCounterBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GCNT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelCounterBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGelCounter.readAllBuff";
		CFGenKbGelCounterBuff buff;
		ArrayList<CFGenKbGelCounterBuff> filteredList = new ArrayList<CFGenKbGelCounterBuff>();
		CFGenKbGelCounterBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GCNT" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelCounterBuff[0] ) );
	}

	public CFGenKbGelCounterBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByPIdx() ";
		CFGenKbGelCounterBuff buff = readDerivedByPIdx( Authorization,
			TenantId,
			GelCacheId,
			GelInstId );
		if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
			return( (CFGenKbGelCounterBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGelCounterBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByTenantIdx() ";
		CFGenKbGelCounterBuff buff;
		ArrayList<CFGenKbGelCounterBuff> filteredList = new ArrayList<CFGenKbGelCounterBuff>();
		CFGenKbGelCounterBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelCounterBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelCounterBuff[0] ) );
	}

	public CFGenKbGelCounterBuff[] readBuffByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByGelCacheIdx() ";
		CFGenKbGelCounterBuff buff;
		ArrayList<CFGenKbGelCounterBuff> filteredList = new ArrayList<CFGenKbGelCounterBuff>();
		CFGenKbGelCounterBuff[] buffList = readDerivedByGelCacheIdx( Authorization,
			TenantId,
			GelCacheId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelCounterBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelCounterBuff[0] ) );
	}

	public CFGenKbGelCounterBuff[] readBuffByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByChainIdx() ";
		CFGenKbGelCounterBuff buff;
		ArrayList<CFGenKbGelCounterBuff> filteredList = new ArrayList<CFGenKbGelCounterBuff>();
		CFGenKbGelCounterBuff[] buffList = readDerivedByChainIdx( Authorization,
			ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelCounterBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelCounterBuff[0] ) );
	}

	public void updateGelCounter( CFGenKbAuthorization Authorization,
		CFGenKbGelCounterBuff Buff )
	{
		schema.getTableGelInstruction().updateGelInstruction( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelCounterBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGelCounter",
				"Existing record not found",
				"GelCounter",
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
						"updateGelCounter",
						"Superclass",
						"SuperClass",
						"GelInstruction",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGelInstructionPKey, CFGenKbGelCounterBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteGelCounter( CFGenKbAuthorization Authorization,
		CFGenKbGelCounterBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGelCounterTable.deleteGelCounter() ";
		String classCode;
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelCounterBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGelCounter",
				pkey );
		}
		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbGelInstructionPKey, CFGenKbGelCounterBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableGelInstruction().deleteGelInstruction( Authorization,
			Buff );
	}
	public void deleteGelCounterByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId )
	{
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		key.setRequiredGelInstId( argGelInstId );
		deleteGelCounterByPIdx( Authorization, key );
	}

	public void deleteGelCounterByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGelCounterBuff cur;
		LinkedList<CFGenKbGelCounterBuff> matchSet = new LinkedList<CFGenKbGelCounterBuff>();
		Iterator<CFGenKbGelCounterBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelCounterBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelCounter().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelCounter( Authorization, cur );
		}
	}

	public void deleteGelCounterByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGelInstructionByTenantIdxKey key = schema.getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGelCounterByTenantIdx( Authorization, key );
	}

	public void deleteGelCounterByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByTenantIdxKey argKey )
	{
		CFGenKbGelCounterBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelCounterBuff> matchSet = new LinkedList<CFGenKbGelCounterBuff>();
		Iterator<CFGenKbGelCounterBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelCounterBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelCounter().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelCounter( Authorization, cur );
		}
	}

	public void deleteGelCounterByGelCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId )
	{
		CFGenKbGelInstructionByGelCacheIdxKey key = schema.getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		deleteGelCounterByGelCacheIdx( Authorization, key );
	}

	public void deleteGelCounterByGelCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByGelCacheIdxKey argKey )
	{
		CFGenKbGelCounterBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelCounterBuff> matchSet = new LinkedList<CFGenKbGelCounterBuff>();
		Iterator<CFGenKbGelCounterBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelCounterBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelCounter().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelCounter( Authorization, cur );
		}
	}

	public void deleteGelCounterByChainIdx( CFGenKbAuthorization Authorization,
		Long argChainInstTenantId,
		Long argChainInstGelCacheId,
		Long argChainInstGelInstId )
	{
		CFGenKbGelInstructionByChainIdxKey key = schema.getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( argChainInstTenantId );
		key.setOptionalChainInstGelCacheId( argChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( argChainInstGelInstId );
		deleteGelCounterByChainIdx( Authorization, key );
	}

	public void deleteGelCounterByChainIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByChainIdxKey argKey )
	{
		CFGenKbGelCounterBuff cur;
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
		LinkedList<CFGenKbGelCounterBuff> matchSet = new LinkedList<CFGenKbGelCounterBuff>();
		Iterator<CFGenKbGelCounterBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelCounterBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelCounter().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelCounter( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
