
// Description: Java 11 in-memory RAM DbIO implementation for TSecGrpMemb.

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
 *	CFGenKbRamTSecGrpMembTable in-memory RAM DbIO implementation
 *	for TSecGrpMemb.
 */
public class CFGenKbRamTSecGrpMembTable
	implements ICFGenKbTSecGrpMembTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbTSecGrpMembPKey,
				CFGenKbTSecGrpMembBuff > dictByPKey
		= new HashMap< CFGenKbTSecGrpMembPKey,
				CFGenKbTSecGrpMembBuff >();
	private Map< CFGenKbTSecGrpMembByTenantIdxKey,
				Map< CFGenKbTSecGrpMembPKey,
					CFGenKbTSecGrpMembBuff >> dictByTenantIdx
		= new HashMap< CFGenKbTSecGrpMembByTenantIdxKey,
				Map< CFGenKbTSecGrpMembPKey,
					CFGenKbTSecGrpMembBuff >>();
	private Map< CFGenKbTSecGrpMembByGroupIdxKey,
				Map< CFGenKbTSecGrpMembPKey,
					CFGenKbTSecGrpMembBuff >> dictByGroupIdx
		= new HashMap< CFGenKbTSecGrpMembByGroupIdxKey,
				Map< CFGenKbTSecGrpMembPKey,
					CFGenKbTSecGrpMembBuff >>();
	private Map< CFGenKbTSecGrpMembByUserIdxKey,
				Map< CFGenKbTSecGrpMembPKey,
					CFGenKbTSecGrpMembBuff >> dictByUserIdx
		= new HashMap< CFGenKbTSecGrpMembByUserIdxKey,
				Map< CFGenKbTSecGrpMembPKey,
					CFGenKbTSecGrpMembBuff >>();
	private Map< CFGenKbTSecGrpMembByUUserIdxKey,
			CFGenKbTSecGrpMembBuff > dictByUUserIdx
		= new HashMap< CFGenKbTSecGrpMembByUUserIdxKey,
			CFGenKbTSecGrpMembBuff >();

	public CFGenKbRamTSecGrpMembTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createTSecGrpMemb( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpMembBuff Buff )
	{
		final String S_ProcName = "createTSecGrpMemb";
		CFGenKbTSecGrpMembPKey pkey = schema.getFactoryTSecGrpMemb().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTSecGrpMembId( ((CFGenKbRamTenantTable)schema.getTableTenant()).nextTSecGrpMembIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredTSecGrpMembId( pkey.getRequiredTSecGrpMembId() );
		CFGenKbTSecGrpMembByTenantIdxKey keyTenantIdx = schema.getFactoryTSecGrpMemb().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFGenKbTSecGrpMembByGroupIdxKey keyGroupIdx = schema.getFactoryTSecGrpMemb().newGroupIdxKey();
		keyGroupIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyGroupIdx.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );

		CFGenKbTSecGrpMembByUserIdxKey keyUserIdx = schema.getFactoryTSecGrpMemb().newUserIdxKey();
		keyUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		CFGenKbTSecGrpMembByUUserIdxKey keyUUserIdx = schema.getFactoryTSecGrpMemb().newUUserIdxKey();
		keyUUserIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUUserIdx.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );
		keyUUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUUserIdx.containsKey( keyUUserIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TSecGrpMembUUserIdx",
				keyUUserIdx );
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
						"TSecGrpMembTenant",
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
				if( null == schema.getTableTSecGroup().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredTSecGroupId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"TSecGrpMembGroup",
						"TSecGroup",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		Map< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff > subdictGroupIdx;
		if( dictByGroupIdx.containsKey( keyGroupIdx ) ) {
			subdictGroupIdx = dictByGroupIdx.get( keyGroupIdx );
		}
		else {
			subdictGroupIdx = new HashMap< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff >();
			dictByGroupIdx.put( keyGroupIdx, subdictGroupIdx );
		}
		subdictGroupIdx.put( pkey, Buff );

		Map< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff > subdictUserIdx;
		if( dictByUserIdx.containsKey( keyUserIdx ) ) {
			subdictUserIdx = dictByUserIdx.get( keyUserIdx );
		}
		else {
			subdictUserIdx = new HashMap< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff >();
			dictByUserIdx.put( keyUserIdx, subdictUserIdx );
		}
		subdictUserIdx.put( pkey, Buff );

		dictByUUserIdx.put( keyUUserIdx, Buff );

	}

	public CFGenKbTSecGrpMembBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpMembPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpMemb.readDerived";
		CFGenKbTSecGrpMembPKey key = schema.getFactoryTSecGrpMemb().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredTSecGrpMembId( PKey.getRequiredTSecGrpMembId() );
		CFGenKbTSecGrpMembBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTSecGrpMembBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpMembPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpMemb.readDerived";
		CFGenKbTSecGrpMembPKey key = schema.getFactoryTSecGrpMemb().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredTSecGrpMembId( PKey.getRequiredTSecGrpMembId() );
		CFGenKbTSecGrpMembBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTSecGrpMembBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamTSecGrpMemb.readAllDerived";
		CFGenKbTSecGrpMembBuff[] retList = new CFGenKbTSecGrpMembBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbTSecGrpMembBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbTSecGrpMembBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpMemb.readDerivedByTenantIdx";
		CFGenKbTSecGrpMembByTenantIdxKey key = schema.getFactoryTSecGrpMemb().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFGenKbTSecGrpMembBuff[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new CFGenKbTSecGrpMembBuff[ subdictTenantIdx.size() ];
			Iterator< CFGenKbTSecGrpMembBuff > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff > subdictTenantIdx
				= new HashMap< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new CFGenKbTSecGrpMembBuff[0];
		}
		return( recArray );
	}

	public CFGenKbTSecGrpMembBuff[] readDerivedByGroupIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		int TSecGroupId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpMemb.readDerivedByGroupIdx";
		CFGenKbTSecGrpMembByGroupIdxKey key = schema.getFactoryTSecGrpMemb().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );

		CFGenKbTSecGrpMembBuff[] recArray;
		if( dictByGroupIdx.containsKey( key ) ) {
			Map< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff > subdictGroupIdx
				= dictByGroupIdx.get( key );
			recArray = new CFGenKbTSecGrpMembBuff[ subdictGroupIdx.size() ];
			Iterator< CFGenKbTSecGrpMembBuff > iter = subdictGroupIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff > subdictGroupIdx
				= new HashMap< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff >();
			dictByGroupIdx.put( key, subdictGroupIdx );
			recArray = new CFGenKbTSecGrpMembBuff[0];
		}
		return( recArray );
	}

	public CFGenKbTSecGrpMembBuff[] readDerivedByUserIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpMemb.readDerivedByUserIdx";
		CFGenKbTSecGrpMembByUserIdxKey key = schema.getFactoryTSecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );

		CFGenKbTSecGrpMembBuff[] recArray;
		if( dictByUserIdx.containsKey( key ) ) {
			Map< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff > subdictUserIdx
				= dictByUserIdx.get( key );
			recArray = new CFGenKbTSecGrpMembBuff[ subdictUserIdx.size() ];
			Iterator< CFGenKbTSecGrpMembBuff > iter = subdictUserIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff > subdictUserIdx
				= new HashMap< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff >();
			dictByUserIdx.put( key, subdictUserIdx );
			recArray = new CFGenKbTSecGrpMembBuff[0];
		}
		return( recArray );
	}

	public CFGenKbTSecGrpMembBuff readDerivedByUUserIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		int TSecGroupId,
		UUID SecUserId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpMemb.readDerivedByUUserIdx";
		CFGenKbTSecGrpMembByUUserIdxKey key = schema.getFactoryTSecGrpMemb().newUUserIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredSecUserId( SecUserId );

		CFGenKbTSecGrpMembBuff buff;
		if( dictByUUserIdx.containsKey( key ) ) {
			buff = dictByUUserIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTSecGrpMembBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long TSecGrpMembId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpMemb.readDerivedByIdIdx() ";
		CFGenKbTSecGrpMembPKey key = schema.getFactoryTSecGrpMemb().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGrpMembId( TSecGrpMembId );

		CFGenKbTSecGrpMembBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTSecGrpMembBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpMembPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpMemb.readBuff";
		CFGenKbTSecGrpMembBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TGMB" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTSecGrpMembBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpMembPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbTSecGrpMembBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TGMB" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTSecGrpMembBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpMemb.readAllBuff";
		CFGenKbTSecGrpMembBuff buff;
		ArrayList<CFGenKbTSecGrpMembBuff> filteredList = new ArrayList<CFGenKbTSecGrpMembBuff>();
		CFGenKbTSecGrpMembBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGMB" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbTSecGrpMembBuff[0] ) );
	}

	/**
	 *	Read a page of all the specific TSecGrpMemb buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific TSecGrpMemb instances in the database accessible for the Authorization.
	 */
	public CFGenKbTSecGrpMembBuff[] pageAllBuff( CFGenKbAuthorization Authorization,
		Long priorTenantId,
		Long priorTSecGrpMembId )
	{
		final String S_ProcName = "pageAllBuff";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public CFGenKbTSecGrpMembBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long TSecGrpMembId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpMemb.readBuffByIdIdx() ";
		CFGenKbTSecGrpMembBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			TSecGrpMembId );
		if( ( buff != null ) && buff.getClassCode().equals( "TGMB" ) ) {
			return( (CFGenKbTSecGrpMembBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbTSecGrpMembBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpMemb.readBuffByTenantIdx() ";
		CFGenKbTSecGrpMembBuff buff;
		ArrayList<CFGenKbTSecGrpMembBuff> filteredList = new ArrayList<CFGenKbTSecGrpMembBuff>();
		CFGenKbTSecGrpMembBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGMB" ) ) {
				filteredList.add( (CFGenKbTSecGrpMembBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbTSecGrpMembBuff[0] ) );
	}

	public CFGenKbTSecGrpMembBuff[] readBuffByGroupIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		int TSecGroupId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpMemb.readBuffByGroupIdx() ";
		CFGenKbTSecGrpMembBuff buff;
		ArrayList<CFGenKbTSecGrpMembBuff> filteredList = new ArrayList<CFGenKbTSecGrpMembBuff>();
		CFGenKbTSecGrpMembBuff[] buffList = readDerivedByGroupIdx( Authorization,
			TenantId,
			TSecGroupId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGMB" ) ) {
				filteredList.add( (CFGenKbTSecGrpMembBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbTSecGrpMembBuff[0] ) );
	}

	public CFGenKbTSecGrpMembBuff[] readBuffByUserIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpMemb.readBuffByUserIdx() ";
		CFGenKbTSecGrpMembBuff buff;
		ArrayList<CFGenKbTSecGrpMembBuff> filteredList = new ArrayList<CFGenKbTSecGrpMembBuff>();
		CFGenKbTSecGrpMembBuff[] buffList = readDerivedByUserIdx( Authorization,
			SecUserId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGMB" ) ) {
				filteredList.add( (CFGenKbTSecGrpMembBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbTSecGrpMembBuff[0] ) );
	}

	public CFGenKbTSecGrpMembBuff readBuffByUUserIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		int TSecGroupId,
		UUID SecUserId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpMemb.readBuffByUUserIdx() ";
		CFGenKbTSecGrpMembBuff buff = readDerivedByUUserIdx( Authorization,
			TenantId,
			TSecGroupId,
			SecUserId );
		if( ( buff != null ) && buff.getClassCode().equals( "TGMB" ) ) {
			return( (CFGenKbTSecGrpMembBuff)buff );
		}
		else {
			return( null );
		}
	}

	/**
	 *	Read a page array of the specific TSecGrpMemb buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbTSecGrpMembBuff[] pageBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		Long priorTenantId,
		Long priorTSecGrpMembId )
	{
		final String S_ProcName = "pageBuffByTenantIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific TSecGrpMemb buffer instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbTSecGrpMembBuff[] pageBuffByGroupIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		int TSecGroupId,
		Long priorTenantId,
		Long priorTSecGrpMembId )
	{
		final String S_ProcName = "pageBuffByGroupIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific TSecGrpMemb buffer instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSecUserId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbTSecGrpMembBuff[] pageBuffByUserIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId,
		Long priorTenantId,
		Long priorTSecGrpMembId )
	{
		final String S_ProcName = "pageBuffByUserIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateTSecGrpMemb( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpMembBuff Buff )
	{
		CFGenKbTSecGrpMembPKey pkey = schema.getFactoryTSecGrpMemb().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTSecGrpMembId( Buff.getRequiredTSecGrpMembId() );
		CFGenKbTSecGrpMembBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateTSecGrpMemb",
				"Existing record not found",
				"TSecGrpMemb",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateTSecGrpMemb",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbTSecGrpMembByTenantIdxKey existingKeyTenantIdx = schema.getFactoryTSecGrpMemb().newTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFGenKbTSecGrpMembByTenantIdxKey newKeyTenantIdx = schema.getFactoryTSecGrpMemb().newTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFGenKbTSecGrpMembByGroupIdxKey existingKeyGroupIdx = schema.getFactoryTSecGrpMemb().newGroupIdxKey();
		existingKeyGroupIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyGroupIdx.setRequiredTSecGroupId( existing.getRequiredTSecGroupId() );

		CFGenKbTSecGrpMembByGroupIdxKey newKeyGroupIdx = schema.getFactoryTSecGrpMemb().newGroupIdxKey();
		newKeyGroupIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyGroupIdx.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );

		CFGenKbTSecGrpMembByUserIdxKey existingKeyUserIdx = schema.getFactoryTSecGrpMemb().newUserIdxKey();
		existingKeyUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		CFGenKbTSecGrpMembByUserIdxKey newKeyUserIdx = schema.getFactoryTSecGrpMemb().newUserIdxKey();
		newKeyUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		CFGenKbTSecGrpMembByUUserIdxKey existingKeyUUserIdx = schema.getFactoryTSecGrpMemb().newUUserIdxKey();
		existingKeyUUserIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUUserIdx.setRequiredTSecGroupId( existing.getRequiredTSecGroupId() );
		existingKeyUUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		CFGenKbTSecGrpMembByUUserIdxKey newKeyUUserIdx = schema.getFactoryTSecGrpMemb().newUUserIdxKey();
		newKeyUUserIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUUserIdx.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );
		newKeyUUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		// Check unique indexes

		if( ! existingKeyUUserIdx.equals( newKeyUUserIdx ) ) {
			if( dictByUUserIdx.containsKey( newKeyUUserIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateTSecGrpMemb",
					"TSecGrpMembUUserIdx",
					newKeyUUserIdx );
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
						"updateTSecGrpMemb",
						"Owner",
						"TSecGrpMembTenant",
						"Tenant",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTSecGroup().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredTSecGroupId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateTSecGrpMemb",
						"Container",
						"TSecGrpMembGroup",
						"TSecGroup",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff > subdict;

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
			subdict = new HashMap< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
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
			subdict = new HashMap< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff >();
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
			subdict = new HashMap< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff >();
			dictByUserIdx.put( newKeyUserIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUUserIdx.remove( existingKeyUUserIdx );
		dictByUUserIdx.put( newKeyUUserIdx, Buff );

	}

	public void deleteTSecGrpMemb( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpMembBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpMembTable.deleteTSecGrpMemb() ";
		String classCode;
		CFGenKbTSecGrpMembPKey pkey = schema.getFactoryTSecGrpMemb().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTSecGrpMembId( Buff.getRequiredTSecGrpMembId() );
		CFGenKbTSecGrpMembBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteTSecGrpMemb",
				pkey );
		}
		CFGenKbTSecGrpMembByTenantIdxKey keyTenantIdx = schema.getFactoryTSecGrpMemb().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFGenKbTSecGrpMembByGroupIdxKey keyGroupIdx = schema.getFactoryTSecGrpMemb().newGroupIdxKey();
		keyGroupIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyGroupIdx.setRequiredTSecGroupId( existing.getRequiredTSecGroupId() );

		CFGenKbTSecGrpMembByUserIdxKey keyUserIdx = schema.getFactoryTSecGrpMemb().newUserIdxKey();
		keyUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		CFGenKbTSecGrpMembByUUserIdxKey keyUUserIdx = schema.getFactoryTSecGrpMemb().newUUserIdxKey();
		keyUUserIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUUserIdx.setRequiredTSecGroupId( existing.getRequiredTSecGroupId() );
		keyUUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbTSecGrpMembPKey, CFGenKbTSecGrpMembBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		subdict = dictByGroupIdx.get( keyGroupIdx );
		subdict.remove( pkey );

		subdict = dictByUserIdx.get( keyUserIdx );
		subdict.remove( pkey );

		dictByUUserIdx.remove( keyUUserIdx );

	}
	public void deleteTSecGrpMembByIdIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argTSecGrpMembId )
	{
		CFGenKbTSecGrpMembPKey key = schema.getFactoryTSecGrpMemb().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTSecGrpMembId( argTSecGrpMembId );
		deleteTSecGrpMembByIdIdx( Authorization, key );
	}

	public void deleteTSecGrpMembByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpMembPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbTSecGrpMembBuff cur;
		LinkedList<CFGenKbTSecGrpMembBuff> matchSet = new LinkedList<CFGenKbTSecGrpMembBuff>();
		Iterator<CFGenKbTSecGrpMembBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbTSecGrpMembBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTSecGrpMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredTSecGrpMembId() );
			deleteTSecGrpMemb( Authorization, cur );
		}
	}

	public void deleteTSecGrpMembByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbTSecGrpMembByTenantIdxKey key = schema.getFactoryTSecGrpMemb().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTSecGrpMembByTenantIdx( Authorization, key );
	}

	public void deleteTSecGrpMembByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpMembByTenantIdxKey argKey )
	{
		CFGenKbTSecGrpMembBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbTSecGrpMembBuff> matchSet = new LinkedList<CFGenKbTSecGrpMembBuff>();
		Iterator<CFGenKbTSecGrpMembBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbTSecGrpMembBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTSecGrpMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredTSecGrpMembId() );
			deleteTSecGrpMemb( Authorization, cur );
		}
	}

	public void deleteTSecGrpMembByGroupIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		int argTSecGroupId )
	{
		CFGenKbTSecGrpMembByGroupIdxKey key = schema.getFactoryTSecGrpMemb().newGroupIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTSecGroupId( argTSecGroupId );
		deleteTSecGrpMembByGroupIdx( Authorization, key );
	}

	public void deleteTSecGrpMembByGroupIdx( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpMembByGroupIdxKey argKey )
	{
		CFGenKbTSecGrpMembBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbTSecGrpMembBuff> matchSet = new LinkedList<CFGenKbTSecGrpMembBuff>();
		Iterator<CFGenKbTSecGrpMembBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbTSecGrpMembBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTSecGrpMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredTSecGrpMembId() );
			deleteTSecGrpMemb( Authorization, cur );
		}
	}

	public void deleteTSecGrpMembByUserIdx( CFGenKbAuthorization Authorization,
		UUID argSecUserId )
	{
		CFGenKbTSecGrpMembByUserIdxKey key = schema.getFactoryTSecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		deleteTSecGrpMembByUserIdx( Authorization, key );
	}

	public void deleteTSecGrpMembByUserIdx( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpMembByUserIdxKey argKey )
	{
		CFGenKbTSecGrpMembBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbTSecGrpMembBuff> matchSet = new LinkedList<CFGenKbTSecGrpMembBuff>();
		Iterator<CFGenKbTSecGrpMembBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbTSecGrpMembBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTSecGrpMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredTSecGrpMembId() );
			deleteTSecGrpMemb( Authorization, cur );
		}
	}

	public void deleteTSecGrpMembByUUserIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		int argTSecGroupId,
		UUID argSecUserId )
	{
		CFGenKbTSecGrpMembByUUserIdxKey key = schema.getFactoryTSecGrpMemb().newUUserIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTSecGroupId( argTSecGroupId );
		key.setRequiredSecUserId( argSecUserId );
		deleteTSecGrpMembByUUserIdx( Authorization, key );
	}

	public void deleteTSecGrpMembByUUserIdx( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpMembByUUserIdxKey argKey )
	{
		CFGenKbTSecGrpMembBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbTSecGrpMembBuff> matchSet = new LinkedList<CFGenKbTSecGrpMembBuff>();
		Iterator<CFGenKbTSecGrpMembBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbTSecGrpMembBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTSecGrpMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredTSecGrpMembId() );
			deleteTSecGrpMemb( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
