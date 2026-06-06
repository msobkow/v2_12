
// Description: Java 11 in-memory RAM DbIO implementation for SecGrpInc.

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
 *	CFGenKbRamSecGrpIncTable in-memory RAM DbIO implementation
 *	for SecGrpInc.
 */
public class CFGenKbRamSecGrpIncTable
	implements ICFGenKbSecGrpIncTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbSecGrpIncPKey,
				CFGenKbSecGrpIncBuff > dictByPKey
		= new HashMap< CFGenKbSecGrpIncPKey,
				CFGenKbSecGrpIncBuff >();
	private Map< CFGenKbSecGrpIncByClusterIdxKey,
				Map< CFGenKbSecGrpIncPKey,
					CFGenKbSecGrpIncBuff >> dictByClusterIdx
		= new HashMap< CFGenKbSecGrpIncByClusterIdxKey,
				Map< CFGenKbSecGrpIncPKey,
					CFGenKbSecGrpIncBuff >>();
	private Map< CFGenKbSecGrpIncByGroupIdxKey,
				Map< CFGenKbSecGrpIncPKey,
					CFGenKbSecGrpIncBuff >> dictByGroupIdx
		= new HashMap< CFGenKbSecGrpIncByGroupIdxKey,
				Map< CFGenKbSecGrpIncPKey,
					CFGenKbSecGrpIncBuff >>();
	private Map< CFGenKbSecGrpIncByIncludeIdxKey,
				Map< CFGenKbSecGrpIncPKey,
					CFGenKbSecGrpIncBuff >> dictByIncludeIdx
		= new HashMap< CFGenKbSecGrpIncByIncludeIdxKey,
				Map< CFGenKbSecGrpIncPKey,
					CFGenKbSecGrpIncBuff >>();
	private Map< CFGenKbSecGrpIncByUIncludeIdxKey,
			CFGenKbSecGrpIncBuff > dictByUIncludeIdx
		= new HashMap< CFGenKbSecGrpIncByUIncludeIdxKey,
			CFGenKbSecGrpIncBuff >();

	public CFGenKbRamSecGrpIncTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecGrpInc( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpIncBuff Buff )
	{
		final String S_ProcName = "createSecGrpInc";
		CFGenKbSecGrpIncPKey pkey = schema.getFactorySecGrpInc().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGrpIncId( ((CFGenKbRamClusterTable)schema.getTableCluster()).nextSecGrpIncIdGen( Authorization,
			Buff.getRequiredClusterId() ) );
		Buff.setRequiredClusterId( pkey.getRequiredClusterId() );
		Buff.setRequiredSecGrpIncId( pkey.getRequiredSecGrpIncId() );
		CFGenKbSecGrpIncByClusterIdxKey keyClusterIdx = schema.getFactorySecGrpInc().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFGenKbSecGrpIncByGroupIdxKey keyGroupIdx = schema.getFactorySecGrpInc().newGroupIdxKey();
		keyGroupIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyGroupIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );

		CFGenKbSecGrpIncByIncludeIdxKey keyIncludeIdx = schema.getFactorySecGrpInc().newIncludeIdxKey();
		keyIncludeIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyIncludeIdx.setRequiredIncludeGroupId( Buff.getRequiredIncludeGroupId() );

		CFGenKbSecGrpIncByUIncludeIdxKey keyUIncludeIdx = schema.getFactorySecGrpInc().newUIncludeIdxKey();
		keyUIncludeIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUIncludeIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );
		keyUIncludeIdx.setRequiredIncludeGroupId( Buff.getRequiredIncludeGroupId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUIncludeIdx.containsKey( keyUIncludeIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecGrpIncUIncludeIdx",
				keyUIncludeIdx );
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
						"Owner",
						"SecGrpIncCluster",
						"Cluster",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableSecGroup().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId(),
						Buff.getRequiredSecGroupId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"SecGrpIncGroup",
						"SecGroup",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		Map< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff > subdictGroupIdx;
		if( dictByGroupIdx.containsKey( keyGroupIdx ) ) {
			subdictGroupIdx = dictByGroupIdx.get( keyGroupIdx );
		}
		else {
			subdictGroupIdx = new HashMap< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff >();
			dictByGroupIdx.put( keyGroupIdx, subdictGroupIdx );
		}
		subdictGroupIdx.put( pkey, Buff );

		Map< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff > subdictIncludeIdx;
		if( dictByIncludeIdx.containsKey( keyIncludeIdx ) ) {
			subdictIncludeIdx = dictByIncludeIdx.get( keyIncludeIdx );
		}
		else {
			subdictIncludeIdx = new HashMap< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff >();
			dictByIncludeIdx.put( keyIncludeIdx, subdictIncludeIdx );
		}
		subdictIncludeIdx.put( pkey, Buff );

		dictByUIncludeIdx.put( keyUIncludeIdx, Buff );

	}

	public CFGenKbSecGrpIncBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpIncPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecGrpInc.readDerived";
		CFGenKbSecGrpIncPKey key = schema.getFactorySecGrpInc().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecGrpIncId( PKey.getRequiredSecGrpIncId() );
		CFGenKbSecGrpIncBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGrpIncBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpIncPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecGrpInc.readDerived";
		CFGenKbSecGrpIncPKey key = schema.getFactorySecGrpInc().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecGrpIncId( PKey.getRequiredSecGrpIncId() );
		CFGenKbSecGrpIncBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGrpIncBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamSecGrpInc.readAllDerived";
		CFGenKbSecGrpIncBuff[] retList = new CFGenKbSecGrpIncBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbSecGrpIncBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbSecGrpIncBuff[] readDerivedByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpInc.readDerivedByClusterIdx";
		CFGenKbSecGrpIncByClusterIdxKey key = schema.getFactorySecGrpInc().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFGenKbSecGrpIncBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFGenKbSecGrpIncBuff[ subdictClusterIdx.size() ];
			Iterator< CFGenKbSecGrpIncBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff > subdictClusterIdx
				= new HashMap< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFGenKbSecGrpIncBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecGrpIncBuff[] readDerivedByGroupIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpInc.readDerivedByGroupIdx";
		CFGenKbSecGrpIncByGroupIdxKey key = schema.getFactorySecGrpInc().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );

		CFGenKbSecGrpIncBuff[] recArray;
		if( dictByGroupIdx.containsKey( key ) ) {
			Map< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff > subdictGroupIdx
				= dictByGroupIdx.get( key );
			recArray = new CFGenKbSecGrpIncBuff[ subdictGroupIdx.size() ];
			Iterator< CFGenKbSecGrpIncBuff > iter = subdictGroupIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff > subdictGroupIdx
				= new HashMap< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff >();
			dictByGroupIdx.put( key, subdictGroupIdx );
			recArray = new CFGenKbSecGrpIncBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecGrpIncBuff[] readDerivedByIncludeIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int IncludeGroupId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpInc.readDerivedByIncludeIdx";
		CFGenKbSecGrpIncByIncludeIdxKey key = schema.getFactorySecGrpInc().newIncludeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredIncludeGroupId( IncludeGroupId );

		CFGenKbSecGrpIncBuff[] recArray;
		if( dictByIncludeIdx.containsKey( key ) ) {
			Map< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff > subdictIncludeIdx
				= dictByIncludeIdx.get( key );
			recArray = new CFGenKbSecGrpIncBuff[ subdictIncludeIdx.size() ];
			Iterator< CFGenKbSecGrpIncBuff > iter = subdictIncludeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff > subdictIncludeIdx
				= new HashMap< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff >();
			dictByIncludeIdx.put( key, subdictIncludeIdx );
			recArray = new CFGenKbSecGrpIncBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecGrpIncBuff readDerivedByUIncludeIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		int IncludeGroupId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpInc.readDerivedByUIncludeIdx";
		CFGenKbSecGrpIncByUIncludeIdxKey key = schema.getFactorySecGrpInc().newUIncludeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredIncludeGroupId( IncludeGroupId );

		CFGenKbSecGrpIncBuff buff;
		if( dictByUIncludeIdx.containsKey( key ) ) {
			buff = dictByUIncludeIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGrpIncBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		long SecGrpIncId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpInc.readDerivedByIdIdx() ";
		CFGenKbSecGrpIncPKey key = schema.getFactorySecGrpInc().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGrpIncId( SecGrpIncId );

		CFGenKbSecGrpIncBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGrpIncBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpIncPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecGrpInc.readBuff";
		CFGenKbSecGrpIncBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SGNC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGrpIncBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpIncPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbSecGrpIncBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SGNC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGrpIncBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamSecGrpInc.readAllBuff";
		CFGenKbSecGrpIncBuff buff;
		ArrayList<CFGenKbSecGrpIncBuff> filteredList = new ArrayList<CFGenKbSecGrpIncBuff>();
		CFGenKbSecGrpIncBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGNC" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecGrpIncBuff[0] ) );
	}

	/**
	 *	Read a page of all the specific SecGrpInc buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecGrpInc instances in the database accessible for the Authorization.
	 */
	public CFGenKbSecGrpIncBuff[] pageAllBuff( CFGenKbAuthorization Authorization,
		Long priorClusterId,
		Long priorSecGrpIncId )
	{
		final String S_ProcName = "pageAllBuff";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public CFGenKbSecGrpIncBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		long SecGrpIncId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpInc.readBuffByIdIdx() ";
		CFGenKbSecGrpIncBuff buff = readDerivedByIdIdx( Authorization,
			ClusterId,
			SecGrpIncId );
		if( ( buff != null ) && buff.getClassCode().equals( "SGNC" ) ) {
			return( (CFGenKbSecGrpIncBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbSecGrpIncBuff[] readBuffByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpInc.readBuffByClusterIdx() ";
		CFGenKbSecGrpIncBuff buff;
		ArrayList<CFGenKbSecGrpIncBuff> filteredList = new ArrayList<CFGenKbSecGrpIncBuff>();
		CFGenKbSecGrpIncBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGNC" ) ) {
				filteredList.add( (CFGenKbSecGrpIncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecGrpIncBuff[0] ) );
	}

	public CFGenKbSecGrpIncBuff[] readBuffByGroupIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpInc.readBuffByGroupIdx() ";
		CFGenKbSecGrpIncBuff buff;
		ArrayList<CFGenKbSecGrpIncBuff> filteredList = new ArrayList<CFGenKbSecGrpIncBuff>();
		CFGenKbSecGrpIncBuff[] buffList = readDerivedByGroupIdx( Authorization,
			ClusterId,
			SecGroupId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGNC" ) ) {
				filteredList.add( (CFGenKbSecGrpIncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecGrpIncBuff[0] ) );
	}

	public CFGenKbSecGrpIncBuff[] readBuffByIncludeIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int IncludeGroupId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpInc.readBuffByIncludeIdx() ";
		CFGenKbSecGrpIncBuff buff;
		ArrayList<CFGenKbSecGrpIncBuff> filteredList = new ArrayList<CFGenKbSecGrpIncBuff>();
		CFGenKbSecGrpIncBuff[] buffList = readDerivedByIncludeIdx( Authorization,
			ClusterId,
			IncludeGroupId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGNC" ) ) {
				filteredList.add( (CFGenKbSecGrpIncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecGrpIncBuff[0] ) );
	}

	public CFGenKbSecGrpIncBuff readBuffByUIncludeIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		int IncludeGroupId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpInc.readBuffByUIncludeIdx() ";
		CFGenKbSecGrpIncBuff buff = readDerivedByUIncludeIdx( Authorization,
			ClusterId,
			SecGroupId,
			IncludeGroupId );
		if( ( buff != null ) && buff.getClassCode().equals( "SGNC" ) ) {
			return( (CFGenKbSecGrpIncBuff)buff );
		}
		else {
			return( null );
		}
	}

	/**
	 *	Read a page array of the specific SecGrpInc buffer instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecGrpIncBuff[] pageBuffByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		Long priorClusterId,
		Long priorSecGrpIncId )
	{
		final String S_ProcName = "pageBuffByClusterIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecGrpInc buffer instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecGrpIncBuff[] pageBuffByGroupIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		Long priorClusterId,
		Long priorSecGrpIncId )
	{
		final String S_ProcName = "pageBuffByGroupIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecGrpInc buffer instances identified by the duplicate key IncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecGrpIncBuff[] pageBuffByIncludeIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int IncludeGroupId,
		Long priorClusterId,
		Long priorSecGrpIncId )
	{
		final String S_ProcName = "pageBuffByIncludeIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateSecGrpInc( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpIncBuff Buff )
	{
		CFGenKbSecGrpIncPKey pkey = schema.getFactorySecGrpInc().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGrpIncId( Buff.getRequiredSecGrpIncId() );
		CFGenKbSecGrpIncBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateSecGrpInc",
				"Existing record not found",
				"SecGrpInc",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateSecGrpInc",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbSecGrpIncByClusterIdxKey existingKeyClusterIdx = schema.getFactorySecGrpInc().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFGenKbSecGrpIncByClusterIdxKey newKeyClusterIdx = schema.getFactorySecGrpInc().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFGenKbSecGrpIncByGroupIdxKey existingKeyGroupIdx = schema.getFactorySecGrpInc().newGroupIdxKey();
		existingKeyGroupIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyGroupIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );

		CFGenKbSecGrpIncByGroupIdxKey newKeyGroupIdx = schema.getFactorySecGrpInc().newGroupIdxKey();
		newKeyGroupIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyGroupIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );

		CFGenKbSecGrpIncByIncludeIdxKey existingKeyIncludeIdx = schema.getFactorySecGrpInc().newIncludeIdxKey();
		existingKeyIncludeIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyIncludeIdx.setRequiredIncludeGroupId( existing.getRequiredIncludeGroupId() );

		CFGenKbSecGrpIncByIncludeIdxKey newKeyIncludeIdx = schema.getFactorySecGrpInc().newIncludeIdxKey();
		newKeyIncludeIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyIncludeIdx.setRequiredIncludeGroupId( Buff.getRequiredIncludeGroupId() );

		CFGenKbSecGrpIncByUIncludeIdxKey existingKeyUIncludeIdx = schema.getFactorySecGrpInc().newUIncludeIdxKey();
		existingKeyUIncludeIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUIncludeIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );
		existingKeyUIncludeIdx.setRequiredIncludeGroupId( existing.getRequiredIncludeGroupId() );

		CFGenKbSecGrpIncByUIncludeIdxKey newKeyUIncludeIdx = schema.getFactorySecGrpInc().newUIncludeIdxKey();
		newKeyUIncludeIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUIncludeIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );
		newKeyUIncludeIdx.setRequiredIncludeGroupId( Buff.getRequiredIncludeGroupId() );

		// Check unique indexes

		if( ! existingKeyUIncludeIdx.equals( newKeyUIncludeIdx ) ) {
			if( dictByUIncludeIdx.containsKey( newKeyUIncludeIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateSecGrpInc",
					"SecGrpIncUIncludeIdx",
					newKeyUIncludeIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableCluster().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateSecGrpInc",
						"Owner",
						"SecGrpIncCluster",
						"Cluster",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecGroup().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId(),
						Buff.getRequiredSecGroupId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateSecGrpInc",
						"Container",
						"SecGrpIncGroup",
						"SecGroup",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff > subdict;

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
			subdict = new HashMap< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff >();
			dictByClusterIdx.put( newKeyClusterIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByGroupIdx.get( existingKeyGroupIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByGroupIdx.containsKey( newKeyGroupIdx ) ) {
			subdict = dictByGroupIdx.get( newKeyGroupIdx );
		}
		else {
			subdict = new HashMap< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff >();
			dictByGroupIdx.put( newKeyGroupIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByIncludeIdx.get( existingKeyIncludeIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByIncludeIdx.containsKey( newKeyIncludeIdx ) ) {
			subdict = dictByIncludeIdx.get( newKeyIncludeIdx );
		}
		else {
			subdict = new HashMap< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff >();
			dictByIncludeIdx.put( newKeyIncludeIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUIncludeIdx.remove( existingKeyUIncludeIdx );
		dictByUIncludeIdx.put( newKeyUIncludeIdx, Buff );

	}

	public void deleteSecGrpInc( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpIncBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamSecGrpIncTable.deleteSecGrpInc() ";
		String classCode;
		CFGenKbSecGrpIncPKey pkey = schema.getFactorySecGrpInc().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGrpIncId( Buff.getRequiredSecGrpIncId() );
		CFGenKbSecGrpIncBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteSecGrpInc",
				pkey );
		}
		CFGenKbSecGrpIncByClusterIdxKey keyClusterIdx = schema.getFactorySecGrpInc().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFGenKbSecGrpIncByGroupIdxKey keyGroupIdx = schema.getFactorySecGrpInc().newGroupIdxKey();
		keyGroupIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyGroupIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );

		CFGenKbSecGrpIncByIncludeIdxKey keyIncludeIdx = schema.getFactorySecGrpInc().newIncludeIdxKey();
		keyIncludeIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyIncludeIdx.setRequiredIncludeGroupId( existing.getRequiredIncludeGroupId() );

		CFGenKbSecGrpIncByUIncludeIdxKey keyUIncludeIdx = schema.getFactorySecGrpInc().newUIncludeIdxKey();
		keyUIncludeIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUIncludeIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );
		keyUIncludeIdx.setRequiredIncludeGroupId( existing.getRequiredIncludeGroupId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbSecGrpIncPKey, CFGenKbSecGrpIncBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		subdict = dictByGroupIdx.get( keyGroupIdx );
		subdict.remove( pkey );

		subdict = dictByIncludeIdx.get( keyIncludeIdx );
		subdict.remove( pkey );

		dictByUIncludeIdx.remove( keyUIncludeIdx );

	}
	public void deleteSecGrpIncByIdIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		long argSecGrpIncId )
	{
		CFGenKbSecGrpIncPKey key = schema.getFactorySecGrpInc().newPKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGrpIncId( argSecGrpIncId );
		deleteSecGrpIncByIdIdx( Authorization, key );
	}

	public void deleteSecGrpIncByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpIncPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbSecGrpIncBuff cur;
		LinkedList<CFGenKbSecGrpIncBuff> matchSet = new LinkedList<CFGenKbSecGrpIncBuff>();
		Iterator<CFGenKbSecGrpIncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGrpIncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGrpInc().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGrpIncId() );
			deleteSecGrpInc( Authorization, cur );
		}
	}

	public void deleteSecGrpIncByClusterIdx( CFGenKbAuthorization Authorization,
		long argClusterId )
	{
		CFGenKbSecGrpIncByClusterIdxKey key = schema.getFactorySecGrpInc().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteSecGrpIncByClusterIdx( Authorization, key );
	}

	public void deleteSecGrpIncByClusterIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpIncByClusterIdxKey argKey )
	{
		CFGenKbSecGrpIncBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecGrpIncBuff> matchSet = new LinkedList<CFGenKbSecGrpIncBuff>();
		Iterator<CFGenKbSecGrpIncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGrpIncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGrpInc().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGrpIncId() );
			deleteSecGrpInc( Authorization, cur );
		}
	}

	public void deleteSecGrpIncByGroupIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		int argSecGroupId )
	{
		CFGenKbSecGrpIncByGroupIdxKey key = schema.getFactorySecGrpInc().newGroupIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGroupId( argSecGroupId );
		deleteSecGrpIncByGroupIdx( Authorization, key );
	}

	public void deleteSecGrpIncByGroupIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpIncByGroupIdxKey argKey )
	{
		CFGenKbSecGrpIncBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecGrpIncBuff> matchSet = new LinkedList<CFGenKbSecGrpIncBuff>();
		Iterator<CFGenKbSecGrpIncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGrpIncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGrpInc().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGrpIncId() );
			deleteSecGrpInc( Authorization, cur );
		}
	}

	public void deleteSecGrpIncByIncludeIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		int argIncludeGroupId )
	{
		CFGenKbSecGrpIncByIncludeIdxKey key = schema.getFactorySecGrpInc().newIncludeIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredIncludeGroupId( argIncludeGroupId );
		deleteSecGrpIncByIncludeIdx( Authorization, key );
	}

	public void deleteSecGrpIncByIncludeIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpIncByIncludeIdxKey argKey )
	{
		CFGenKbSecGrpIncBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecGrpIncBuff> matchSet = new LinkedList<CFGenKbSecGrpIncBuff>();
		Iterator<CFGenKbSecGrpIncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGrpIncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGrpInc().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGrpIncId() );
			deleteSecGrpInc( Authorization, cur );
		}
	}

	public void deleteSecGrpIncByUIncludeIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		int argSecGroupId,
		int argIncludeGroupId )
	{
		CFGenKbSecGrpIncByUIncludeIdxKey key = schema.getFactorySecGrpInc().newUIncludeIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGroupId( argSecGroupId );
		key.setRequiredIncludeGroupId( argIncludeGroupId );
		deleteSecGrpIncByUIncludeIdx( Authorization, key );
	}

	public void deleteSecGrpIncByUIncludeIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpIncByUIncludeIdxKey argKey )
	{
		CFGenKbSecGrpIncBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecGrpIncBuff> matchSet = new LinkedList<CFGenKbSecGrpIncBuff>();
		Iterator<CFGenKbSecGrpIncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGrpIncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGrpInc().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGrpIncId() );
			deleteSecGrpInc( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
