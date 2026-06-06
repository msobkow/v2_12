
// Description: Java 11 in-memory RAM DbIO implementation for SecGrpMemb.

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
 *	CFGenKbRamSecGrpMembTable in-memory RAM DbIO implementation
 *	for SecGrpMemb.
 */
public class CFGenKbRamSecGrpMembTable
	implements ICFGenKbSecGrpMembTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbSecGrpMembPKey,
				CFGenKbSecGrpMembBuff > dictByPKey
		= new HashMap< CFGenKbSecGrpMembPKey,
				CFGenKbSecGrpMembBuff >();
	private Map< CFGenKbSecGrpMembByClusterIdxKey,
				Map< CFGenKbSecGrpMembPKey,
					CFGenKbSecGrpMembBuff >> dictByClusterIdx
		= new HashMap< CFGenKbSecGrpMembByClusterIdxKey,
				Map< CFGenKbSecGrpMembPKey,
					CFGenKbSecGrpMembBuff >>();
	private Map< CFGenKbSecGrpMembByGroupIdxKey,
				Map< CFGenKbSecGrpMembPKey,
					CFGenKbSecGrpMembBuff >> dictByGroupIdx
		= new HashMap< CFGenKbSecGrpMembByGroupIdxKey,
				Map< CFGenKbSecGrpMembPKey,
					CFGenKbSecGrpMembBuff >>();
	private Map< CFGenKbSecGrpMembByUserIdxKey,
				Map< CFGenKbSecGrpMembPKey,
					CFGenKbSecGrpMembBuff >> dictByUserIdx
		= new HashMap< CFGenKbSecGrpMembByUserIdxKey,
				Map< CFGenKbSecGrpMembPKey,
					CFGenKbSecGrpMembBuff >>();
	private Map< CFGenKbSecGrpMembByUUserIdxKey,
			CFGenKbSecGrpMembBuff > dictByUUserIdx
		= new HashMap< CFGenKbSecGrpMembByUUserIdxKey,
			CFGenKbSecGrpMembBuff >();

	public CFGenKbRamSecGrpMembTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecGrpMemb( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpMembBuff Buff )
	{
		final String S_ProcName = "createSecGrpMemb";
		CFGenKbSecGrpMembPKey pkey = schema.getFactorySecGrpMemb().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGrpMembId( ((CFGenKbRamClusterTable)schema.getTableCluster()).nextSecGrpMembIdGen( Authorization,
			Buff.getRequiredClusterId() ) );
		Buff.setRequiredClusterId( pkey.getRequiredClusterId() );
		Buff.setRequiredSecGrpMembId( pkey.getRequiredSecGrpMembId() );
		CFGenKbSecGrpMembByClusterIdxKey keyClusterIdx = schema.getFactorySecGrpMemb().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFGenKbSecGrpMembByGroupIdxKey keyGroupIdx = schema.getFactorySecGrpMemb().newGroupIdxKey();
		keyGroupIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyGroupIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );

		CFGenKbSecGrpMembByUserIdxKey keyUserIdx = schema.getFactorySecGrpMemb().newUserIdxKey();
		keyUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		CFGenKbSecGrpMembByUUserIdxKey keyUUserIdx = schema.getFactorySecGrpMemb().newUUserIdxKey();
		keyUUserIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUUserIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );
		keyUUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUUserIdx.containsKey( keyUUserIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecGrpMembUUserIdx",
				keyUUserIdx );
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
						"SecGrpMembCluster",
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
						"SecGrpMembGroup",
						"SecGroup",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		Map< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff > subdictGroupIdx;
		if( dictByGroupIdx.containsKey( keyGroupIdx ) ) {
			subdictGroupIdx = dictByGroupIdx.get( keyGroupIdx );
		}
		else {
			subdictGroupIdx = new HashMap< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff >();
			dictByGroupIdx.put( keyGroupIdx, subdictGroupIdx );
		}
		subdictGroupIdx.put( pkey, Buff );

		Map< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff > subdictUserIdx;
		if( dictByUserIdx.containsKey( keyUserIdx ) ) {
			subdictUserIdx = dictByUserIdx.get( keyUserIdx );
		}
		else {
			subdictUserIdx = new HashMap< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff >();
			dictByUserIdx.put( keyUserIdx, subdictUserIdx );
		}
		subdictUserIdx.put( pkey, Buff );

		dictByUUserIdx.put( keyUUserIdx, Buff );

	}

	public CFGenKbSecGrpMembBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpMembPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecGrpMemb.readDerived";
		CFGenKbSecGrpMembPKey key = schema.getFactorySecGrpMemb().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecGrpMembId( PKey.getRequiredSecGrpMembId() );
		CFGenKbSecGrpMembBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGrpMembBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpMembPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecGrpMemb.readDerived";
		CFGenKbSecGrpMembPKey key = schema.getFactorySecGrpMemb().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecGrpMembId( PKey.getRequiredSecGrpMembId() );
		CFGenKbSecGrpMembBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGrpMembBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamSecGrpMemb.readAllDerived";
		CFGenKbSecGrpMembBuff[] retList = new CFGenKbSecGrpMembBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbSecGrpMembBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbSecGrpMembBuff[] readDerivedByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpMemb.readDerivedByClusterIdx";
		CFGenKbSecGrpMembByClusterIdxKey key = schema.getFactorySecGrpMemb().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFGenKbSecGrpMembBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFGenKbSecGrpMembBuff[ subdictClusterIdx.size() ];
			Iterator< CFGenKbSecGrpMembBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff > subdictClusterIdx
				= new HashMap< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFGenKbSecGrpMembBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecGrpMembBuff[] readDerivedByGroupIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpMemb.readDerivedByGroupIdx";
		CFGenKbSecGrpMembByGroupIdxKey key = schema.getFactorySecGrpMemb().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );

		CFGenKbSecGrpMembBuff[] recArray;
		if( dictByGroupIdx.containsKey( key ) ) {
			Map< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff > subdictGroupIdx
				= dictByGroupIdx.get( key );
			recArray = new CFGenKbSecGrpMembBuff[ subdictGroupIdx.size() ];
			Iterator< CFGenKbSecGrpMembBuff > iter = subdictGroupIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff > subdictGroupIdx
				= new HashMap< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff >();
			dictByGroupIdx.put( key, subdictGroupIdx );
			recArray = new CFGenKbSecGrpMembBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecGrpMembBuff[] readDerivedByUserIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpMemb.readDerivedByUserIdx";
		CFGenKbSecGrpMembByUserIdxKey key = schema.getFactorySecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );

		CFGenKbSecGrpMembBuff[] recArray;
		if( dictByUserIdx.containsKey( key ) ) {
			Map< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff > subdictUserIdx
				= dictByUserIdx.get( key );
			recArray = new CFGenKbSecGrpMembBuff[ subdictUserIdx.size() ];
			Iterator< CFGenKbSecGrpMembBuff > iter = subdictUserIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff > subdictUserIdx
				= new HashMap< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff >();
			dictByUserIdx.put( key, subdictUserIdx );
			recArray = new CFGenKbSecGrpMembBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecGrpMembBuff readDerivedByUUserIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		UUID SecUserId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpMemb.readDerivedByUUserIdx";
		CFGenKbSecGrpMembByUUserIdxKey key = schema.getFactorySecGrpMemb().newUUserIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecUserId( SecUserId );

		CFGenKbSecGrpMembBuff buff;
		if( dictByUUserIdx.containsKey( key ) ) {
			buff = dictByUUserIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGrpMembBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		long SecGrpMembId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpMemb.readDerivedByIdIdx() ";
		CFGenKbSecGrpMembPKey key = schema.getFactorySecGrpMemb().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGrpMembId( SecGrpMembId );

		CFGenKbSecGrpMembBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGrpMembBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpMembPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecGrpMemb.readBuff";
		CFGenKbSecGrpMembBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SGMB" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGrpMembBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpMembPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbSecGrpMembBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SGMB" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGrpMembBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamSecGrpMemb.readAllBuff";
		CFGenKbSecGrpMembBuff buff;
		ArrayList<CFGenKbSecGrpMembBuff> filteredList = new ArrayList<CFGenKbSecGrpMembBuff>();
		CFGenKbSecGrpMembBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGMB" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecGrpMembBuff[0] ) );
	}

	/**
	 *	Read a page of all the specific SecGrpMemb buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecGrpMemb instances in the database accessible for the Authorization.
	 */
	public CFGenKbSecGrpMembBuff[] pageAllBuff( CFGenKbAuthorization Authorization,
		Long priorClusterId,
		Long priorSecGrpMembId )
	{
		final String S_ProcName = "pageAllBuff";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public CFGenKbSecGrpMembBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		long SecGrpMembId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpMemb.readBuffByIdIdx() ";
		CFGenKbSecGrpMembBuff buff = readDerivedByIdIdx( Authorization,
			ClusterId,
			SecGrpMembId );
		if( ( buff != null ) && buff.getClassCode().equals( "SGMB" ) ) {
			return( (CFGenKbSecGrpMembBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbSecGrpMembBuff[] readBuffByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpMemb.readBuffByClusterIdx() ";
		CFGenKbSecGrpMembBuff buff;
		ArrayList<CFGenKbSecGrpMembBuff> filteredList = new ArrayList<CFGenKbSecGrpMembBuff>();
		CFGenKbSecGrpMembBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGMB" ) ) {
				filteredList.add( (CFGenKbSecGrpMembBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecGrpMembBuff[0] ) );
	}

	public CFGenKbSecGrpMembBuff[] readBuffByGroupIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpMemb.readBuffByGroupIdx() ";
		CFGenKbSecGrpMembBuff buff;
		ArrayList<CFGenKbSecGrpMembBuff> filteredList = new ArrayList<CFGenKbSecGrpMembBuff>();
		CFGenKbSecGrpMembBuff[] buffList = readDerivedByGroupIdx( Authorization,
			ClusterId,
			SecGroupId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGMB" ) ) {
				filteredList.add( (CFGenKbSecGrpMembBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecGrpMembBuff[0] ) );
	}

	public CFGenKbSecGrpMembBuff[] readBuffByUserIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpMemb.readBuffByUserIdx() ";
		CFGenKbSecGrpMembBuff buff;
		ArrayList<CFGenKbSecGrpMembBuff> filteredList = new ArrayList<CFGenKbSecGrpMembBuff>();
		CFGenKbSecGrpMembBuff[] buffList = readDerivedByUserIdx( Authorization,
			SecUserId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGMB" ) ) {
				filteredList.add( (CFGenKbSecGrpMembBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecGrpMembBuff[0] ) );
	}

	public CFGenKbSecGrpMembBuff readBuffByUUserIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		UUID SecUserId )
	{
		final String S_ProcName = "CFGenKbRamSecGrpMemb.readBuffByUUserIdx() ";
		CFGenKbSecGrpMembBuff buff = readDerivedByUUserIdx( Authorization,
			ClusterId,
			SecGroupId,
			SecUserId );
		if( ( buff != null ) && buff.getClassCode().equals( "SGMB" ) ) {
			return( (CFGenKbSecGrpMembBuff)buff );
		}
		else {
			return( null );
		}
	}

	/**
	 *	Read a page array of the specific SecGrpMemb buffer instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecGrpMembBuff[] pageBuffByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		Long priorClusterId,
		Long priorSecGrpMembId )
	{
		final String S_ProcName = "pageBuffByClusterIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecGrpMemb buffer instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecGrpMembBuff[] pageBuffByGroupIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		Long priorClusterId,
		Long priorSecGrpMembId )
	{
		final String S_ProcName = "pageBuffByGroupIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecGrpMemb buffer instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecGrpMembBuff[] pageBuffByUserIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId,
		Long priorClusterId,
		Long priorSecGrpMembId )
	{
		final String S_ProcName = "pageBuffByUserIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateSecGrpMemb( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpMembBuff Buff )
	{
		CFGenKbSecGrpMembPKey pkey = schema.getFactorySecGrpMemb().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGrpMembId( Buff.getRequiredSecGrpMembId() );
		CFGenKbSecGrpMembBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateSecGrpMemb",
				"Existing record not found",
				"SecGrpMemb",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateSecGrpMemb",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbSecGrpMembByClusterIdxKey existingKeyClusterIdx = schema.getFactorySecGrpMemb().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFGenKbSecGrpMembByClusterIdxKey newKeyClusterIdx = schema.getFactorySecGrpMemb().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFGenKbSecGrpMembByGroupIdxKey existingKeyGroupIdx = schema.getFactorySecGrpMemb().newGroupIdxKey();
		existingKeyGroupIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyGroupIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );

		CFGenKbSecGrpMembByGroupIdxKey newKeyGroupIdx = schema.getFactorySecGrpMemb().newGroupIdxKey();
		newKeyGroupIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyGroupIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );

		CFGenKbSecGrpMembByUserIdxKey existingKeyUserIdx = schema.getFactorySecGrpMemb().newUserIdxKey();
		existingKeyUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		CFGenKbSecGrpMembByUserIdxKey newKeyUserIdx = schema.getFactorySecGrpMemb().newUserIdxKey();
		newKeyUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		CFGenKbSecGrpMembByUUserIdxKey existingKeyUUserIdx = schema.getFactorySecGrpMemb().newUUserIdxKey();
		existingKeyUUserIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUUserIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );
		existingKeyUUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		CFGenKbSecGrpMembByUUserIdxKey newKeyUUserIdx = schema.getFactorySecGrpMemb().newUUserIdxKey();
		newKeyUUserIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUUserIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );
		newKeyUUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		// Check unique indexes

		if( ! existingKeyUUserIdx.equals( newKeyUUserIdx ) ) {
			if( dictByUUserIdx.containsKey( newKeyUUserIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateSecGrpMemb",
					"SecGrpMembUUserIdx",
					newKeyUUserIdx );
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
						"updateSecGrpMemb",
						"Owner",
						"SecGrpMembCluster",
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
						"updateSecGrpMemb",
						"Container",
						"SecGrpMembGroup",
						"SecGroup",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff > subdict;

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
			subdict = new HashMap< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff >();
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
			subdict = new HashMap< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff >();
			dictByGroupIdx.put( newKeyGroupIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByUserIdx.get( existingKeyUserIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByUserIdx.containsKey( newKeyUserIdx ) ) {
			subdict = dictByUserIdx.get( newKeyUserIdx );
		}
		else {
			subdict = new HashMap< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff >();
			dictByUserIdx.put( newKeyUserIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUUserIdx.remove( existingKeyUUserIdx );
		dictByUUserIdx.put( newKeyUUserIdx, Buff );

	}

	public void deleteSecGrpMemb( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpMembBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamSecGrpMembTable.deleteSecGrpMemb() ";
		String classCode;
		CFGenKbSecGrpMembPKey pkey = schema.getFactorySecGrpMemb().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGrpMembId( Buff.getRequiredSecGrpMembId() );
		CFGenKbSecGrpMembBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteSecGrpMemb",
				pkey );
		}
		CFGenKbSecGrpMembByClusterIdxKey keyClusterIdx = schema.getFactorySecGrpMemb().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFGenKbSecGrpMembByGroupIdxKey keyGroupIdx = schema.getFactorySecGrpMemb().newGroupIdxKey();
		keyGroupIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyGroupIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );

		CFGenKbSecGrpMembByUserIdxKey keyUserIdx = schema.getFactorySecGrpMemb().newUserIdxKey();
		keyUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		CFGenKbSecGrpMembByUUserIdxKey keyUUserIdx = schema.getFactorySecGrpMemb().newUUserIdxKey();
		keyUUserIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUUserIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );
		keyUUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbSecGrpMembPKey, CFGenKbSecGrpMembBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		subdict = dictByGroupIdx.get( keyGroupIdx );
		subdict.remove( pkey );

		subdict = dictByUserIdx.get( keyUserIdx );
		subdict.remove( pkey );

		dictByUUserIdx.remove( keyUUserIdx );

	}
	public void deleteSecGrpMembByIdIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		long argSecGrpMembId )
	{
		CFGenKbSecGrpMembPKey key = schema.getFactorySecGrpMemb().newPKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGrpMembId( argSecGrpMembId );
		deleteSecGrpMembByIdIdx( Authorization, key );
	}

	public void deleteSecGrpMembByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpMembPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbSecGrpMembBuff cur;
		LinkedList<CFGenKbSecGrpMembBuff> matchSet = new LinkedList<CFGenKbSecGrpMembBuff>();
		Iterator<CFGenKbSecGrpMembBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGrpMembBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGrpMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGrpMembId() );
			deleteSecGrpMemb( Authorization, cur );
		}
	}

	public void deleteSecGrpMembByClusterIdx( CFGenKbAuthorization Authorization,
		long argClusterId )
	{
		CFGenKbSecGrpMembByClusterIdxKey key = schema.getFactorySecGrpMemb().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteSecGrpMembByClusterIdx( Authorization, key );
	}

	public void deleteSecGrpMembByClusterIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpMembByClusterIdxKey argKey )
	{
		CFGenKbSecGrpMembBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecGrpMembBuff> matchSet = new LinkedList<CFGenKbSecGrpMembBuff>();
		Iterator<CFGenKbSecGrpMembBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGrpMembBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGrpMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGrpMembId() );
			deleteSecGrpMemb( Authorization, cur );
		}
	}

	public void deleteSecGrpMembByGroupIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		int argSecGroupId )
	{
		CFGenKbSecGrpMembByGroupIdxKey key = schema.getFactorySecGrpMemb().newGroupIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGroupId( argSecGroupId );
		deleteSecGrpMembByGroupIdx( Authorization, key );
	}

	public void deleteSecGrpMembByGroupIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpMembByGroupIdxKey argKey )
	{
		CFGenKbSecGrpMembBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecGrpMembBuff> matchSet = new LinkedList<CFGenKbSecGrpMembBuff>();
		Iterator<CFGenKbSecGrpMembBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGrpMembBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGrpMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGrpMembId() );
			deleteSecGrpMemb( Authorization, cur );
		}
	}

	public void deleteSecGrpMembByUserIdx( CFGenKbAuthorization Authorization,
		UUID argSecUserId )
	{
		CFGenKbSecGrpMembByUserIdxKey key = schema.getFactorySecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		deleteSecGrpMembByUserIdx( Authorization, key );
	}

	public void deleteSecGrpMembByUserIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpMembByUserIdxKey argKey )
	{
		CFGenKbSecGrpMembBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecGrpMembBuff> matchSet = new LinkedList<CFGenKbSecGrpMembBuff>();
		Iterator<CFGenKbSecGrpMembBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGrpMembBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGrpMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGrpMembId() );
			deleteSecGrpMemb( Authorization, cur );
		}
	}

	public void deleteSecGrpMembByUUserIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		int argSecGroupId,
		UUID argSecUserId )
	{
		CFGenKbSecGrpMembByUUserIdxKey key = schema.getFactorySecGrpMemb().newUUserIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGroupId( argSecGroupId );
		key.setRequiredSecUserId( argSecUserId );
		deleteSecGrpMembByUUserIdx( Authorization, key );
	}

	public void deleteSecGrpMembByUUserIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGrpMembByUUserIdxKey argKey )
	{
		CFGenKbSecGrpMembBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecGrpMembBuff> matchSet = new LinkedList<CFGenKbSecGrpMembBuff>();
		Iterator<CFGenKbSecGrpMembBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGrpMembBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGrpMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGrpMembId() );
			deleteSecGrpMemb( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
