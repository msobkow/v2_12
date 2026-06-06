
// Description: Java 11 in-memory RAM DbIO implementation for SysCluster.

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
 *	CFGenKbRamSysClusterTable in-memory RAM DbIO implementation
 *	for SysCluster.
 */
public class CFGenKbRamSysClusterTable
	implements ICFGenKbSysClusterTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbSysClusterPKey,
				CFGenKbSysClusterBuff > dictByPKey
		= new HashMap< CFGenKbSysClusterPKey,
				CFGenKbSysClusterBuff >();
	private Map< CFGenKbSysClusterByClusterIdxKey,
				Map< CFGenKbSysClusterPKey,
					CFGenKbSysClusterBuff >> dictByClusterIdx
		= new HashMap< CFGenKbSysClusterByClusterIdxKey,
				Map< CFGenKbSysClusterPKey,
					CFGenKbSysClusterBuff >>();

	public CFGenKbRamSysClusterTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createSysCluster( CFGenKbAuthorization Authorization,
		CFGenKbSysClusterBuff Buff )
	{
		final String S_ProcName = "createSysCluster";
		CFGenKbSysClusterPKey pkey = schema.getFactorySysCluster().newPKey();
		pkey.setRequiredSingletonId( Buff.getRequiredSingletonId() );
		Buff.setRequiredSingletonId( pkey.getRequiredSingletonId() );
		CFGenKbSysClusterByClusterIdxKey keyClusterIdx = schema.getFactorySysCluster().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableCluster().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"SysClusterCluster",
						"Cluster",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbSysClusterPKey, CFGenKbSysClusterBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFGenKbSysClusterPKey, CFGenKbSysClusterBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

	}

	public CFGenKbSysClusterBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbSysClusterPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSysCluster.readDerived";
		CFGenKbSysClusterPKey key = schema.getFactorySysCluster().newPKey();
		key.setRequiredSingletonId( PKey.getRequiredSingletonId() );
		CFGenKbSysClusterBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSysClusterBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbSysClusterPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSysCluster.readDerived";
		CFGenKbSysClusterPKey key = schema.getFactorySysCluster().newPKey();
		key.setRequiredSingletonId( PKey.getRequiredSingletonId() );
		CFGenKbSysClusterBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSysClusterBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamSysCluster.readAllDerived";
		CFGenKbSysClusterBuff[] retList = new CFGenKbSysClusterBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbSysClusterBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbSysClusterBuff[] readDerivedByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFGenKbRamSysCluster.readDerivedByClusterIdx";
		CFGenKbSysClusterByClusterIdxKey key = schema.getFactorySysCluster().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFGenKbSysClusterBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFGenKbSysClusterPKey, CFGenKbSysClusterBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFGenKbSysClusterBuff[ subdictClusterIdx.size() ];
			Iterator< CFGenKbSysClusterBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSysClusterPKey, CFGenKbSysClusterBuff > subdictClusterIdx
				= new HashMap< CFGenKbSysClusterPKey, CFGenKbSysClusterBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFGenKbSysClusterBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSysClusterBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		int SingletonId )
	{
		final String S_ProcName = "CFGenKbRamSysCluster.readDerivedByIdIdx() ";
		CFGenKbSysClusterPKey key = schema.getFactorySysCluster().newPKey();
		key.setRequiredSingletonId( SingletonId );

		CFGenKbSysClusterBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSysClusterBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbSysClusterPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSysCluster.readBuff";
		CFGenKbSysClusterBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SYSC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSysClusterBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbSysClusterPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbSysClusterBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SYSC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSysClusterBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamSysCluster.readAllBuff";
		CFGenKbSysClusterBuff buff;
		ArrayList<CFGenKbSysClusterBuff> filteredList = new ArrayList<CFGenKbSysClusterBuff>();
		CFGenKbSysClusterBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SYSC" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSysClusterBuff[0] ) );
	}

	public CFGenKbSysClusterBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		int SingletonId )
	{
		final String S_ProcName = "CFGenKbRamSysCluster.readBuffByIdIdx() ";
		CFGenKbSysClusterBuff buff = readDerivedByIdIdx( Authorization,
			SingletonId );
		if( ( buff != null ) && buff.getClassCode().equals( "SYSC" ) ) {
			return( (CFGenKbSysClusterBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbSysClusterBuff[] readBuffByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFGenKbRamSysCluster.readBuffByClusterIdx() ";
		CFGenKbSysClusterBuff buff;
		ArrayList<CFGenKbSysClusterBuff> filteredList = new ArrayList<CFGenKbSysClusterBuff>();
		CFGenKbSysClusterBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SYSC" ) ) {
				filteredList.add( (CFGenKbSysClusterBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSysClusterBuff[0] ) );
	}

	public void updateSysCluster( CFGenKbAuthorization Authorization,
		CFGenKbSysClusterBuff Buff )
	{
		CFGenKbSysClusterPKey pkey = schema.getFactorySysCluster().newPKey();
		pkey.setRequiredSingletonId( Buff.getRequiredSingletonId() );
		CFGenKbSysClusterBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateSysCluster",
				"Existing record not found",
				"SysCluster",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateSysCluster",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbSysClusterByClusterIdxKey existingKeyClusterIdx = schema.getFactorySysCluster().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFGenKbSysClusterByClusterIdxKey newKeyClusterIdx = schema.getFactorySysCluster().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableCluster().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateSysCluster",
						"Container",
						"SysClusterCluster",
						"Cluster",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbSysClusterPKey, CFGenKbSysClusterBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByClusterIdx.get( existingKeyClusterIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByClusterIdx.containsKey( newKeyClusterIdx ) ) {
			subdict = dictByClusterIdx.get( newKeyClusterIdx );
		}
		else {
			subdict = new HashMap< CFGenKbSysClusterPKey, CFGenKbSysClusterBuff >();
			dictByClusterIdx.put( newKeyClusterIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteSysCluster( CFGenKbAuthorization Authorization,
		CFGenKbSysClusterBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamSysClusterTable.deleteSysCluster() ";
		String classCode;
		CFGenKbSysClusterPKey pkey = schema.getFactorySysCluster().newPKey();
		pkey.setRequiredSingletonId( Buff.getRequiredSingletonId() );
		CFGenKbSysClusterBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteSysCluster",
				pkey );
		}
		CFGenKbSysClusterByClusterIdxKey keyClusterIdx = schema.getFactorySysCluster().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbSysClusterPKey, CFGenKbSysClusterBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

	}
	public void deleteSysClusterByIdIdx( CFGenKbAuthorization Authorization,
		int argSingletonId )
	{
		CFGenKbSysClusterPKey key = schema.getFactorySysCluster().newPKey();
		key.setRequiredSingletonId( argSingletonId );
		deleteSysClusterByIdIdx( Authorization, key );
	}

	public void deleteSysClusterByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbSysClusterPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbSysClusterBuff cur;
		LinkedList<CFGenKbSysClusterBuff> matchSet = new LinkedList<CFGenKbSysClusterBuff>();
		Iterator<CFGenKbSysClusterBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSysClusterBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSysCluster().readDerivedByIdIdx( Authorization,
				cur.getRequiredSingletonId() );
			deleteSysCluster( Authorization, cur );
		}
	}

	public void deleteSysClusterByClusterIdx( CFGenKbAuthorization Authorization,
		long argClusterId )
	{
		CFGenKbSysClusterByClusterIdxKey key = schema.getFactorySysCluster().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteSysClusterByClusterIdx( Authorization, key );
	}

	public void deleteSysClusterByClusterIdx( CFGenKbAuthorization Authorization,
		CFGenKbSysClusterByClusterIdxKey argKey )
	{
		CFGenKbSysClusterBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSysClusterBuff> matchSet = new LinkedList<CFGenKbSysClusterBuff>();
		Iterator<CFGenKbSysClusterBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSysClusterBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSysCluster().readDerivedByIdIdx( Authorization,
				cur.getRequiredSingletonId() );
			deleteSysCluster( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
