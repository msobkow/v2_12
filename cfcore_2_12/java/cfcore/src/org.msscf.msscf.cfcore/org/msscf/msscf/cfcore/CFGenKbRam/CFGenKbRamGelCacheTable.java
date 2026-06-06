
// Description: Java 11 in-memory RAM DbIO implementation for GelCache.

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
 *	CFGenKbRamGelCacheTable in-memory RAM DbIO implementation
 *	for GelCache.
 */
public class CFGenKbRamGelCacheTable
	implements ICFGenKbGelCacheTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGelCachePKey,
				CFGenKbGelCacheBuff > dictByPKey
		= new HashMap< CFGenKbGelCachePKey,
				CFGenKbGelCacheBuff >();
	private Map< CFGenKbGelCacheByTenantIdxKey,
				Map< CFGenKbGelCachePKey,
					CFGenKbGelCacheBuff >> dictByTenantIdx
		= new HashMap< CFGenKbGelCacheByTenantIdxKey,
				Map< CFGenKbGelCachePKey,
					CFGenKbGelCacheBuff >>();
	private Map< CFGenKbGelCacheByAltIdxKey,
			CFGenKbGelCacheBuff > dictByAltIdx
		= new HashMap< CFGenKbGelCacheByAltIdxKey,
			CFGenKbGelCacheBuff >();

	public CFGenKbRamGelCacheTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGelCache( CFGenKbAuthorization Authorization,
		CFGenKbGelCacheBuff Buff )
	{
		final String S_ProcName = "createGelCache";
		CFGenKbGelCachePKey pkey = schema.getFactoryGelCache().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( ((CFGenKbRamTenantTable)schema.getTableTenant()).nextGelCacheIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredGelCacheId( pkey.getRequiredGelCacheId() );
		CFGenKbGelCacheByTenantIdxKey keyTenantIdx = schema.getFactoryGelCache().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFGenKbGelCacheByAltIdxKey keyAltIdx = schema.getFactoryGelCache().newAltIdxKey();
		keyAltIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyAltIdx.setRequiredCacheName( Buff.getRequiredCacheName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByAltIdx.containsKey( keyAltIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"GelCacheAltIdIdx",
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

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbGelCachePKey, CFGenKbGelCacheBuff > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< CFGenKbGelCachePKey, CFGenKbGelCacheBuff >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		dictByAltIdx.put( keyAltIdx, Buff );

	}

	public CFGenKbGelCacheBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelCachePKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelCache.readDerived";
		CFGenKbGelCachePKey key = schema.getFactoryGelCache().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		CFGenKbGelCacheBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelCacheBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelCachePKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelCache.readDerived";
		CFGenKbGelCachePKey key = schema.getFactoryGelCache().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		CFGenKbGelCacheBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelCacheBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGelCache.readAllDerived";
		CFGenKbGelCacheBuff[] retList = new CFGenKbGelCacheBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGelCacheBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGelCacheBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGelCache.readDerivedByTenantIdx";
		CFGenKbGelCacheByTenantIdxKey key = schema.getFactoryGelCache().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFGenKbGelCacheBuff[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFGenKbGelCachePKey, CFGenKbGelCacheBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new CFGenKbGelCacheBuff[ subdictTenantIdx.size() ];
			Iterator< CFGenKbGelCacheBuff > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelCachePKey, CFGenKbGelCacheBuff > subdictTenantIdx
				= new HashMap< CFGenKbGelCachePKey, CFGenKbGelCacheBuff >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new CFGenKbGelCacheBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelCacheBuff readDerivedByAltIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		String CacheName )
	{
		final String S_ProcName = "CFGenKbRamGelCache.readDerivedByAltIdx";
		CFGenKbGelCacheByAltIdxKey key = schema.getFactoryGelCache().newAltIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCacheName( CacheName );

		CFGenKbGelCacheBuff buff;
		if( dictByAltIdx.containsKey( key ) ) {
			buff = dictByAltIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelCacheBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelCache.readDerivedByIdIdx() ";
		CFGenKbGelCachePKey key = schema.getFactoryGelCache().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );

		CFGenKbGelCacheBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelCacheBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelCachePKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelCache.readBuff";
		CFGenKbGelCacheBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GLCH" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelCacheBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelCachePKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGelCacheBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GLCH" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelCacheBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGelCache.readAllBuff";
		CFGenKbGelCacheBuff buff;
		ArrayList<CFGenKbGelCacheBuff> filteredList = new ArrayList<CFGenKbGelCacheBuff>();
		CFGenKbGelCacheBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GLCH" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelCacheBuff[0] ) );
	}

	public CFGenKbGelCacheBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelCache.readBuffByIdIdx() ";
		CFGenKbGelCacheBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			GelCacheId );
		if( ( buff != null ) && buff.getClassCode().equals( "GLCH" ) ) {
			return( (CFGenKbGelCacheBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGelCacheBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGelCache.readBuffByTenantIdx() ";
		CFGenKbGelCacheBuff buff;
		ArrayList<CFGenKbGelCacheBuff> filteredList = new ArrayList<CFGenKbGelCacheBuff>();
		CFGenKbGelCacheBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GLCH" ) ) {
				filteredList.add( (CFGenKbGelCacheBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelCacheBuff[0] ) );
	}

	public CFGenKbGelCacheBuff readBuffByAltIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		String CacheName )
	{
		final String S_ProcName = "CFGenKbRamGelCache.readBuffByAltIdx() ";
		CFGenKbGelCacheBuff buff = readDerivedByAltIdx( Authorization,
			TenantId,
			CacheName );
		if( ( buff != null ) && buff.getClassCode().equals( "GLCH" ) ) {
			return( (CFGenKbGelCacheBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateGelCache( CFGenKbAuthorization Authorization,
		CFGenKbGelCacheBuff Buff )
	{
		CFGenKbGelCachePKey pkey = schema.getFactoryGelCache().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		CFGenKbGelCacheBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGelCache",
				"Existing record not found",
				"GelCache",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateGelCache",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbGelCacheByTenantIdxKey existingKeyTenantIdx = schema.getFactoryGelCache().newTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFGenKbGelCacheByTenantIdxKey newKeyTenantIdx = schema.getFactoryGelCache().newTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFGenKbGelCacheByAltIdxKey existingKeyAltIdx = schema.getFactoryGelCache().newAltIdxKey();
		existingKeyAltIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyAltIdx.setRequiredCacheName( existing.getRequiredCacheName() );

		CFGenKbGelCacheByAltIdxKey newKeyAltIdx = schema.getFactoryGelCache().newAltIdxKey();
		newKeyAltIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyAltIdx.setRequiredCacheName( Buff.getRequiredCacheName() );

		// Check unique indexes

		if( ! existingKeyAltIdx.equals( newKeyAltIdx ) ) {
			if( dictByAltIdx.containsKey( newKeyAltIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateGelCache",
					"GelCacheAltIdIdx",
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
						"updateGelCache",
						"Owner",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGelCachePKey, CFGenKbGelCacheBuff > subdict;

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
			subdict = new HashMap< CFGenKbGelCachePKey, CFGenKbGelCacheBuff >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByAltIdx.remove( existingKeyAltIdx );
		dictByAltIdx.put( newKeyAltIdx, Buff );

	}

	public void deleteGelCache( CFGenKbAuthorization Authorization,
		CFGenKbGelCacheBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGelCacheTable.deleteGelCache() ";
		String classCode;
		CFGenKbGelCachePKey pkey = schema.getFactoryGelCache().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		CFGenKbGelCacheBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGelCache",
				pkey );
		}
		CFGenKbGelCacheByTenantIdxKey keyTenantIdx = schema.getFactoryGelCache().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFGenKbGelCacheByAltIdxKey keyAltIdx = schema.getFactoryGelCache().newAltIdxKey();
		keyAltIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyAltIdx.setRequiredCacheName( existing.getRequiredCacheName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbGelCachePKey, CFGenKbGelCacheBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		dictByAltIdx.remove( keyAltIdx );

	}
	public void deleteGelCacheByIdIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId )
	{
		CFGenKbGelCachePKey key = schema.getFactoryGelCache().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		deleteGelCacheByIdIdx( Authorization, key );
	}

	public void deleteGelCacheByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelCachePKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGelCacheBuff cur;
		LinkedList<CFGenKbGelCacheBuff> matchSet = new LinkedList<CFGenKbGelCacheBuff>();
		Iterator<CFGenKbGelCacheBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelCacheBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelCache().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId() );
			deleteGelCache( Authorization, cur );
		}
	}

	public void deleteGelCacheByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGelCacheByTenantIdxKey key = schema.getFactoryGelCache().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGelCacheByTenantIdx( Authorization, key );
	}

	public void deleteGelCacheByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelCacheByTenantIdxKey argKey )
	{
		CFGenKbGelCacheBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelCacheBuff> matchSet = new LinkedList<CFGenKbGelCacheBuff>();
		Iterator<CFGenKbGelCacheBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelCacheBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelCache().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId() );
			deleteGelCache( Authorization, cur );
		}
	}

	public void deleteGelCacheByAltIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		String argCacheName )
	{
		CFGenKbGelCacheByAltIdxKey key = schema.getFactoryGelCache().newAltIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredCacheName( argCacheName );
		deleteGelCacheByAltIdx( Authorization, key );
	}

	public void deleteGelCacheByAltIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelCacheByAltIdxKey argKey )
	{
		CFGenKbGelCacheBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelCacheBuff> matchSet = new LinkedList<CFGenKbGelCacheBuff>();
		Iterator<CFGenKbGelCacheBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelCacheBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelCache().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId() );
			deleteGelCache( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
