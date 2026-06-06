
// Description: Java 11 in-memory RAM DbIO implementation for TSecGrpInc.

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
 *	CFGenKbRamTSecGrpIncTable in-memory RAM DbIO implementation
 *	for TSecGrpInc.
 */
public class CFGenKbRamTSecGrpIncTable
	implements ICFGenKbTSecGrpIncTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbTSecGrpIncPKey,
				CFGenKbTSecGrpIncBuff > dictByPKey
		= new HashMap< CFGenKbTSecGrpIncPKey,
				CFGenKbTSecGrpIncBuff >();
	private Map< CFGenKbTSecGrpIncByTenantIdxKey,
				Map< CFGenKbTSecGrpIncPKey,
					CFGenKbTSecGrpIncBuff >> dictByTenantIdx
		= new HashMap< CFGenKbTSecGrpIncByTenantIdxKey,
				Map< CFGenKbTSecGrpIncPKey,
					CFGenKbTSecGrpIncBuff >>();
	private Map< CFGenKbTSecGrpIncByGroupIdxKey,
				Map< CFGenKbTSecGrpIncPKey,
					CFGenKbTSecGrpIncBuff >> dictByGroupIdx
		= new HashMap< CFGenKbTSecGrpIncByGroupIdxKey,
				Map< CFGenKbTSecGrpIncPKey,
					CFGenKbTSecGrpIncBuff >>();
	private Map< CFGenKbTSecGrpIncByIncludeIdxKey,
				Map< CFGenKbTSecGrpIncPKey,
					CFGenKbTSecGrpIncBuff >> dictByIncludeIdx
		= new HashMap< CFGenKbTSecGrpIncByIncludeIdxKey,
				Map< CFGenKbTSecGrpIncPKey,
					CFGenKbTSecGrpIncBuff >>();
	private Map< CFGenKbTSecGrpIncByUIncludeIdxKey,
			CFGenKbTSecGrpIncBuff > dictByUIncludeIdx
		= new HashMap< CFGenKbTSecGrpIncByUIncludeIdxKey,
			CFGenKbTSecGrpIncBuff >();

	public CFGenKbRamTSecGrpIncTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createTSecGrpInc( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpIncBuff Buff )
	{
		final String S_ProcName = "createTSecGrpInc";
		CFGenKbTSecGrpIncPKey pkey = schema.getFactoryTSecGrpInc().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTSecGrpIncId( ((CFGenKbRamTenantTable)schema.getTableTenant()).nextTSecGrpIncIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredTSecGrpIncId( pkey.getRequiredTSecGrpIncId() );
		CFGenKbTSecGrpIncByTenantIdxKey keyTenantIdx = schema.getFactoryTSecGrpInc().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFGenKbTSecGrpIncByGroupIdxKey keyGroupIdx = schema.getFactoryTSecGrpInc().newGroupIdxKey();
		keyGroupIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyGroupIdx.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );

		CFGenKbTSecGrpIncByIncludeIdxKey keyIncludeIdx = schema.getFactoryTSecGrpInc().newIncludeIdxKey();
		keyIncludeIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyIncludeIdx.setRequiredIncludeGroupId( Buff.getRequiredIncludeGroupId() );

		CFGenKbTSecGrpIncByUIncludeIdxKey keyUIncludeIdx = schema.getFactoryTSecGrpInc().newUIncludeIdxKey();
		keyUIncludeIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUIncludeIdx.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );
		keyUIncludeIdx.setRequiredIncludeGroupId( Buff.getRequiredIncludeGroupId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUIncludeIdx.containsKey( keyUIncludeIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TSecGrpIncUIncludeIdx",
				keyUIncludeIdx );
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
						"TSecGrpIncTenant",
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
						"TSecGrpIncGroup",
						"TSecGroup",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		Map< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff > subdictGroupIdx;
		if( dictByGroupIdx.containsKey( keyGroupIdx ) ) {
			subdictGroupIdx = dictByGroupIdx.get( keyGroupIdx );
		}
		else {
			subdictGroupIdx = new HashMap< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff >();
			dictByGroupIdx.put( keyGroupIdx, subdictGroupIdx );
		}
		subdictGroupIdx.put( pkey, Buff );

		Map< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff > subdictIncludeIdx;
		if( dictByIncludeIdx.containsKey( keyIncludeIdx ) ) {
			subdictIncludeIdx = dictByIncludeIdx.get( keyIncludeIdx );
		}
		else {
			subdictIncludeIdx = new HashMap< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff >();
			dictByIncludeIdx.put( keyIncludeIdx, subdictIncludeIdx );
		}
		subdictIncludeIdx.put( pkey, Buff );

		dictByUIncludeIdx.put( keyUIncludeIdx, Buff );

	}

	public CFGenKbTSecGrpIncBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpIncPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpInc.readDerived";
		CFGenKbTSecGrpIncPKey key = schema.getFactoryTSecGrpInc().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredTSecGrpIncId( PKey.getRequiredTSecGrpIncId() );
		CFGenKbTSecGrpIncBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTSecGrpIncBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpIncPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpInc.readDerived";
		CFGenKbTSecGrpIncPKey key = schema.getFactoryTSecGrpInc().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredTSecGrpIncId( PKey.getRequiredTSecGrpIncId() );
		CFGenKbTSecGrpIncBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTSecGrpIncBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamTSecGrpInc.readAllDerived";
		CFGenKbTSecGrpIncBuff[] retList = new CFGenKbTSecGrpIncBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbTSecGrpIncBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbTSecGrpIncBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpInc.readDerivedByTenantIdx";
		CFGenKbTSecGrpIncByTenantIdxKey key = schema.getFactoryTSecGrpInc().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFGenKbTSecGrpIncBuff[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new CFGenKbTSecGrpIncBuff[ subdictTenantIdx.size() ];
			Iterator< CFGenKbTSecGrpIncBuff > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff > subdictTenantIdx
				= new HashMap< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new CFGenKbTSecGrpIncBuff[0];
		}
		return( recArray );
	}

	public CFGenKbTSecGrpIncBuff[] readDerivedByGroupIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		int TSecGroupId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpInc.readDerivedByGroupIdx";
		CFGenKbTSecGrpIncByGroupIdxKey key = schema.getFactoryTSecGrpInc().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );

		CFGenKbTSecGrpIncBuff[] recArray;
		if( dictByGroupIdx.containsKey( key ) ) {
			Map< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff > subdictGroupIdx
				= dictByGroupIdx.get( key );
			recArray = new CFGenKbTSecGrpIncBuff[ subdictGroupIdx.size() ];
			Iterator< CFGenKbTSecGrpIncBuff > iter = subdictGroupIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff > subdictGroupIdx
				= new HashMap< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff >();
			dictByGroupIdx.put( key, subdictGroupIdx );
			recArray = new CFGenKbTSecGrpIncBuff[0];
		}
		return( recArray );
	}

	public CFGenKbTSecGrpIncBuff[] readDerivedByIncludeIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		int IncludeGroupId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpInc.readDerivedByIncludeIdx";
		CFGenKbTSecGrpIncByIncludeIdxKey key = schema.getFactoryTSecGrpInc().newIncludeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIncludeGroupId( IncludeGroupId );

		CFGenKbTSecGrpIncBuff[] recArray;
		if( dictByIncludeIdx.containsKey( key ) ) {
			Map< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff > subdictIncludeIdx
				= dictByIncludeIdx.get( key );
			recArray = new CFGenKbTSecGrpIncBuff[ subdictIncludeIdx.size() ];
			Iterator< CFGenKbTSecGrpIncBuff > iter = subdictIncludeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff > subdictIncludeIdx
				= new HashMap< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff >();
			dictByIncludeIdx.put( key, subdictIncludeIdx );
			recArray = new CFGenKbTSecGrpIncBuff[0];
		}
		return( recArray );
	}

	public CFGenKbTSecGrpIncBuff readDerivedByUIncludeIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		int TSecGroupId,
		int IncludeGroupId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpInc.readDerivedByUIncludeIdx";
		CFGenKbTSecGrpIncByUIncludeIdxKey key = schema.getFactoryTSecGrpInc().newUIncludeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredIncludeGroupId( IncludeGroupId );

		CFGenKbTSecGrpIncBuff buff;
		if( dictByUIncludeIdx.containsKey( key ) ) {
			buff = dictByUIncludeIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTSecGrpIncBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long TSecGrpIncId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpInc.readDerivedByIdIdx() ";
		CFGenKbTSecGrpIncPKey key = schema.getFactoryTSecGrpInc().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGrpIncId( TSecGrpIncId );

		CFGenKbTSecGrpIncBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTSecGrpIncBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpIncPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpInc.readBuff";
		CFGenKbTSecGrpIncBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TGNC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTSecGrpIncBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpIncPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbTSecGrpIncBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TGNC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTSecGrpIncBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpInc.readAllBuff";
		CFGenKbTSecGrpIncBuff buff;
		ArrayList<CFGenKbTSecGrpIncBuff> filteredList = new ArrayList<CFGenKbTSecGrpIncBuff>();
		CFGenKbTSecGrpIncBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGNC" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbTSecGrpIncBuff[0] ) );
	}

	/**
	 *	Read a page of all the specific TSecGrpInc buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific TSecGrpInc instances in the database accessible for the Authorization.
	 */
	public CFGenKbTSecGrpIncBuff[] pageAllBuff( CFGenKbAuthorization Authorization,
		Long priorTenantId,
		Long priorTSecGrpIncId )
	{
		final String S_ProcName = "pageAllBuff";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public CFGenKbTSecGrpIncBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long TSecGrpIncId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpInc.readBuffByIdIdx() ";
		CFGenKbTSecGrpIncBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			TSecGrpIncId );
		if( ( buff != null ) && buff.getClassCode().equals( "TGNC" ) ) {
			return( (CFGenKbTSecGrpIncBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbTSecGrpIncBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpInc.readBuffByTenantIdx() ";
		CFGenKbTSecGrpIncBuff buff;
		ArrayList<CFGenKbTSecGrpIncBuff> filteredList = new ArrayList<CFGenKbTSecGrpIncBuff>();
		CFGenKbTSecGrpIncBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGNC" ) ) {
				filteredList.add( (CFGenKbTSecGrpIncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbTSecGrpIncBuff[0] ) );
	}

	public CFGenKbTSecGrpIncBuff[] readBuffByGroupIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		int TSecGroupId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpInc.readBuffByGroupIdx() ";
		CFGenKbTSecGrpIncBuff buff;
		ArrayList<CFGenKbTSecGrpIncBuff> filteredList = new ArrayList<CFGenKbTSecGrpIncBuff>();
		CFGenKbTSecGrpIncBuff[] buffList = readDerivedByGroupIdx( Authorization,
			TenantId,
			TSecGroupId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGNC" ) ) {
				filteredList.add( (CFGenKbTSecGrpIncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbTSecGrpIncBuff[0] ) );
	}

	public CFGenKbTSecGrpIncBuff[] readBuffByIncludeIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		int IncludeGroupId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpInc.readBuffByIncludeIdx() ";
		CFGenKbTSecGrpIncBuff buff;
		ArrayList<CFGenKbTSecGrpIncBuff> filteredList = new ArrayList<CFGenKbTSecGrpIncBuff>();
		CFGenKbTSecGrpIncBuff[] buffList = readDerivedByIncludeIdx( Authorization,
			TenantId,
			IncludeGroupId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGNC" ) ) {
				filteredList.add( (CFGenKbTSecGrpIncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbTSecGrpIncBuff[0] ) );
	}

	public CFGenKbTSecGrpIncBuff readBuffByUIncludeIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		int TSecGroupId,
		int IncludeGroupId )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpInc.readBuffByUIncludeIdx() ";
		CFGenKbTSecGrpIncBuff buff = readDerivedByUIncludeIdx( Authorization,
			TenantId,
			TSecGroupId,
			IncludeGroupId );
		if( ( buff != null ) && buff.getClassCode().equals( "TGNC" ) ) {
			return( (CFGenKbTSecGrpIncBuff)buff );
		}
		else {
			return( null );
		}
	}

	/**
	 *	Read a page array of the specific TSecGrpInc buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbTSecGrpIncBuff[] pageBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		Long priorTenantId,
		Long priorTSecGrpIncId )
	{
		final String S_ProcName = "pageBuffByTenantIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific TSecGrpInc buffer instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbTSecGrpIncBuff[] pageBuffByGroupIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		int TSecGroupId,
		Long priorTenantId,
		Long priorTSecGrpIncId )
	{
		final String S_ProcName = "pageBuffByGroupIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific TSecGrpInc buffer instances identified by the duplicate key IncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbTSecGrpIncBuff[] pageBuffByIncludeIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		int IncludeGroupId,
		Long priorTenantId,
		Long priorTSecGrpIncId )
	{
		final String S_ProcName = "pageBuffByIncludeIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateTSecGrpInc( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpIncBuff Buff )
	{
		CFGenKbTSecGrpIncPKey pkey = schema.getFactoryTSecGrpInc().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTSecGrpIncId( Buff.getRequiredTSecGrpIncId() );
		CFGenKbTSecGrpIncBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateTSecGrpInc",
				"Existing record not found",
				"TSecGrpInc",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateTSecGrpInc",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbTSecGrpIncByTenantIdxKey existingKeyTenantIdx = schema.getFactoryTSecGrpInc().newTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFGenKbTSecGrpIncByTenantIdxKey newKeyTenantIdx = schema.getFactoryTSecGrpInc().newTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFGenKbTSecGrpIncByGroupIdxKey existingKeyGroupIdx = schema.getFactoryTSecGrpInc().newGroupIdxKey();
		existingKeyGroupIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyGroupIdx.setRequiredTSecGroupId( existing.getRequiredTSecGroupId() );

		CFGenKbTSecGrpIncByGroupIdxKey newKeyGroupIdx = schema.getFactoryTSecGrpInc().newGroupIdxKey();
		newKeyGroupIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyGroupIdx.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );

		CFGenKbTSecGrpIncByIncludeIdxKey existingKeyIncludeIdx = schema.getFactoryTSecGrpInc().newIncludeIdxKey();
		existingKeyIncludeIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyIncludeIdx.setRequiredIncludeGroupId( existing.getRequiredIncludeGroupId() );

		CFGenKbTSecGrpIncByIncludeIdxKey newKeyIncludeIdx = schema.getFactoryTSecGrpInc().newIncludeIdxKey();
		newKeyIncludeIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyIncludeIdx.setRequiredIncludeGroupId( Buff.getRequiredIncludeGroupId() );

		CFGenKbTSecGrpIncByUIncludeIdxKey existingKeyUIncludeIdx = schema.getFactoryTSecGrpInc().newUIncludeIdxKey();
		existingKeyUIncludeIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUIncludeIdx.setRequiredTSecGroupId( existing.getRequiredTSecGroupId() );
		existingKeyUIncludeIdx.setRequiredIncludeGroupId( existing.getRequiredIncludeGroupId() );

		CFGenKbTSecGrpIncByUIncludeIdxKey newKeyUIncludeIdx = schema.getFactoryTSecGrpInc().newUIncludeIdxKey();
		newKeyUIncludeIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUIncludeIdx.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );
		newKeyUIncludeIdx.setRequiredIncludeGroupId( Buff.getRequiredIncludeGroupId() );

		// Check unique indexes

		if( ! existingKeyUIncludeIdx.equals( newKeyUIncludeIdx ) ) {
			if( dictByUIncludeIdx.containsKey( newKeyUIncludeIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateTSecGrpInc",
					"TSecGrpIncUIncludeIdx",
					newKeyUIncludeIdx );
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
						"updateTSecGrpInc",
						"Owner",
						"TSecGrpIncTenant",
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
						"updateTSecGrpInc",
						"Container",
						"TSecGrpIncGroup",
						"TSecGroup",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff > subdict;

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
			subdict = new HashMap< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff >();
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
			subdict = new HashMap< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff >();
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
			subdict = new HashMap< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff >();
			dictByIncludeIdx.put( newKeyIncludeIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUIncludeIdx.remove( existingKeyUIncludeIdx );
		dictByUIncludeIdx.put( newKeyUIncludeIdx, Buff );

	}

	public void deleteTSecGrpInc( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpIncBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamTSecGrpIncTable.deleteTSecGrpInc() ";
		String classCode;
		CFGenKbTSecGrpIncPKey pkey = schema.getFactoryTSecGrpInc().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTSecGrpIncId( Buff.getRequiredTSecGrpIncId() );
		CFGenKbTSecGrpIncBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteTSecGrpInc",
				pkey );
		}
		CFGenKbTSecGrpIncByTenantIdxKey keyTenantIdx = schema.getFactoryTSecGrpInc().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFGenKbTSecGrpIncByGroupIdxKey keyGroupIdx = schema.getFactoryTSecGrpInc().newGroupIdxKey();
		keyGroupIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyGroupIdx.setRequiredTSecGroupId( existing.getRequiredTSecGroupId() );

		CFGenKbTSecGrpIncByIncludeIdxKey keyIncludeIdx = schema.getFactoryTSecGrpInc().newIncludeIdxKey();
		keyIncludeIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyIncludeIdx.setRequiredIncludeGroupId( existing.getRequiredIncludeGroupId() );

		CFGenKbTSecGrpIncByUIncludeIdxKey keyUIncludeIdx = schema.getFactoryTSecGrpInc().newUIncludeIdxKey();
		keyUIncludeIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUIncludeIdx.setRequiredTSecGroupId( existing.getRequiredTSecGroupId() );
		keyUIncludeIdx.setRequiredIncludeGroupId( existing.getRequiredIncludeGroupId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbTSecGrpIncPKey, CFGenKbTSecGrpIncBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		subdict = dictByGroupIdx.get( keyGroupIdx );
		subdict.remove( pkey );

		subdict = dictByIncludeIdx.get( keyIncludeIdx );
		subdict.remove( pkey );

		dictByUIncludeIdx.remove( keyUIncludeIdx );

	}
	public void deleteTSecGrpIncByIdIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argTSecGrpIncId )
	{
		CFGenKbTSecGrpIncPKey key = schema.getFactoryTSecGrpInc().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTSecGrpIncId( argTSecGrpIncId );
		deleteTSecGrpIncByIdIdx( Authorization, key );
	}

	public void deleteTSecGrpIncByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpIncPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbTSecGrpIncBuff cur;
		LinkedList<CFGenKbTSecGrpIncBuff> matchSet = new LinkedList<CFGenKbTSecGrpIncBuff>();
		Iterator<CFGenKbTSecGrpIncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbTSecGrpIncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTSecGrpInc().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredTSecGrpIncId() );
			deleteTSecGrpInc( Authorization, cur );
		}
	}

	public void deleteTSecGrpIncByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbTSecGrpIncByTenantIdxKey key = schema.getFactoryTSecGrpInc().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTSecGrpIncByTenantIdx( Authorization, key );
	}

	public void deleteTSecGrpIncByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpIncByTenantIdxKey argKey )
	{
		CFGenKbTSecGrpIncBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbTSecGrpIncBuff> matchSet = new LinkedList<CFGenKbTSecGrpIncBuff>();
		Iterator<CFGenKbTSecGrpIncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbTSecGrpIncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTSecGrpInc().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredTSecGrpIncId() );
			deleteTSecGrpInc( Authorization, cur );
		}
	}

	public void deleteTSecGrpIncByGroupIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		int argTSecGroupId )
	{
		CFGenKbTSecGrpIncByGroupIdxKey key = schema.getFactoryTSecGrpInc().newGroupIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTSecGroupId( argTSecGroupId );
		deleteTSecGrpIncByGroupIdx( Authorization, key );
	}

	public void deleteTSecGrpIncByGroupIdx( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpIncByGroupIdxKey argKey )
	{
		CFGenKbTSecGrpIncBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbTSecGrpIncBuff> matchSet = new LinkedList<CFGenKbTSecGrpIncBuff>();
		Iterator<CFGenKbTSecGrpIncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbTSecGrpIncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTSecGrpInc().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredTSecGrpIncId() );
			deleteTSecGrpInc( Authorization, cur );
		}
	}

	public void deleteTSecGrpIncByIncludeIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		int argIncludeGroupId )
	{
		CFGenKbTSecGrpIncByIncludeIdxKey key = schema.getFactoryTSecGrpInc().newIncludeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredIncludeGroupId( argIncludeGroupId );
		deleteTSecGrpIncByIncludeIdx( Authorization, key );
	}

	public void deleteTSecGrpIncByIncludeIdx( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpIncByIncludeIdxKey argKey )
	{
		CFGenKbTSecGrpIncBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbTSecGrpIncBuff> matchSet = new LinkedList<CFGenKbTSecGrpIncBuff>();
		Iterator<CFGenKbTSecGrpIncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbTSecGrpIncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTSecGrpInc().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredTSecGrpIncId() );
			deleteTSecGrpInc( Authorization, cur );
		}
	}

	public void deleteTSecGrpIncByUIncludeIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		int argTSecGroupId,
		int argIncludeGroupId )
	{
		CFGenKbTSecGrpIncByUIncludeIdxKey key = schema.getFactoryTSecGrpInc().newUIncludeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTSecGroupId( argTSecGroupId );
		key.setRequiredIncludeGroupId( argIncludeGroupId );
		deleteTSecGrpIncByUIncludeIdx( Authorization, key );
	}

	public void deleteTSecGrpIncByUIncludeIdx( CFGenKbAuthorization Authorization,
		CFGenKbTSecGrpIncByUIncludeIdxKey argKey )
	{
		CFGenKbTSecGrpIncBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbTSecGrpIncBuff> matchSet = new LinkedList<CFGenKbTSecGrpIncBuff>();
		Iterator<CFGenKbTSecGrpIncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbTSecGrpIncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTSecGrpInc().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredTSecGrpIncId() );
			deleteTSecGrpInc( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
