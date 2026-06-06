
// Description: Java 11 in-memory RAM DbIO implementation for GelSpread.

/*
 *	org.msscf.msscf.CFCore
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
 *	CFGenKbRamGelSpreadTable in-memory RAM DbIO implementation
 *	for GelSpread.
 */
public class CFGenKbRamGelSpreadTable
	implements ICFGenKbGelSpreadTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGelInstructionPKey,
				CFGenKbGelSpreadBuff > dictByPKey
		= new HashMap< CFGenKbGelInstructionPKey,
				CFGenKbGelSpreadBuff >();
	private Map< CFGenKbGelSpreadByBetweenIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelSpreadBuff >> dictByBetweenIdx
		= new HashMap< CFGenKbGelSpreadByBetweenIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelSpreadBuff >>();
	private Map< CFGenKbGelSpreadByBeforeIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelSpreadBuff >> dictByBeforeIdx
		= new HashMap< CFGenKbGelSpreadByBeforeIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelSpreadBuff >>();
	private Map< CFGenKbGelSpreadByFirstIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelSpreadBuff >> dictByFirstIdx
		= new HashMap< CFGenKbGelSpreadByFirstIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelSpreadBuff >>();
	private Map< CFGenKbGelSpreadByEachIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelSpreadBuff >> dictByEachIdx
		= new HashMap< CFGenKbGelSpreadByEachIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelSpreadBuff >>();
	private Map< CFGenKbGelSpreadByLastIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelSpreadBuff >> dictByLastIdx
		= new HashMap< CFGenKbGelSpreadByLastIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelSpreadBuff >>();
	private Map< CFGenKbGelSpreadByLoneIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelSpreadBuff >> dictByLoneIdx
		= new HashMap< CFGenKbGelSpreadByLoneIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelSpreadBuff >>();
	private Map< CFGenKbGelSpreadByEmptyIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelSpreadBuff >> dictByEmptyIdx
		= new HashMap< CFGenKbGelSpreadByEmptyIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelSpreadBuff >>();

	public CFGenKbRamGelSpreadTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGelSpread( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadBuff Buff )
	{
		final String S_ProcName = "createGelSpread";
		schema.getTableGelInstruction().createGelInstruction( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelSpreadByBetweenIdxKey keyBetweenIdx = schema.getFactoryGelSpread().newBetweenIdxKey();
		keyBetweenIdx.setOptionalExpandBetween( Buff.getOptionalExpandBetween() );

		CFGenKbGelSpreadByBeforeIdxKey keyBeforeIdx = schema.getFactoryGelSpread().newBeforeIdxKey();
		keyBeforeIdx.setOptionalExpandBefore( Buff.getOptionalExpandBefore() );

		CFGenKbGelSpreadByFirstIdxKey keyFirstIdx = schema.getFactoryGelSpread().newFirstIdxKey();
		keyFirstIdx.setOptionalExpandFirst( Buff.getOptionalExpandFirst() );

		CFGenKbGelSpreadByEachIdxKey keyEachIdx = schema.getFactoryGelSpread().newEachIdxKey();
		keyEachIdx.setRequiredExpandEach( Buff.getRequiredExpandEach() );

		CFGenKbGelSpreadByLastIdxKey keyLastIdx = schema.getFactoryGelSpread().newLastIdxKey();
		keyLastIdx.setOptionalExpandLast( Buff.getOptionalExpandLast() );

		CFGenKbGelSpreadByLoneIdxKey keyLoneIdx = schema.getFactoryGelSpread().newLoneIdxKey();
		keyLoneIdx.setOptionalExpandLone( Buff.getOptionalExpandLone() );

		CFGenKbGelSpreadByEmptyIdxKey keyEmptyIdx = schema.getFactoryGelSpread().newEmptyIdxKey();
		keyEmptyIdx.setOptionalExpandEmpty( Buff.getOptionalExpandEmpty() );

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

		Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictBetweenIdx;
		if( dictByBetweenIdx.containsKey( keyBetweenIdx ) ) {
			subdictBetweenIdx = dictByBetweenIdx.get( keyBetweenIdx );
		}
		else {
			subdictBetweenIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByBetweenIdx.put( keyBetweenIdx, subdictBetweenIdx );
		}
		subdictBetweenIdx.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictBeforeIdx;
		if( dictByBeforeIdx.containsKey( keyBeforeIdx ) ) {
			subdictBeforeIdx = dictByBeforeIdx.get( keyBeforeIdx );
		}
		else {
			subdictBeforeIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByBeforeIdx.put( keyBeforeIdx, subdictBeforeIdx );
		}
		subdictBeforeIdx.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictFirstIdx;
		if( dictByFirstIdx.containsKey( keyFirstIdx ) ) {
			subdictFirstIdx = dictByFirstIdx.get( keyFirstIdx );
		}
		else {
			subdictFirstIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByFirstIdx.put( keyFirstIdx, subdictFirstIdx );
		}
		subdictFirstIdx.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictEachIdx;
		if( dictByEachIdx.containsKey( keyEachIdx ) ) {
			subdictEachIdx = dictByEachIdx.get( keyEachIdx );
		}
		else {
			subdictEachIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByEachIdx.put( keyEachIdx, subdictEachIdx );
		}
		subdictEachIdx.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictLastIdx;
		if( dictByLastIdx.containsKey( keyLastIdx ) ) {
			subdictLastIdx = dictByLastIdx.get( keyLastIdx );
		}
		else {
			subdictLastIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByLastIdx.put( keyLastIdx, subdictLastIdx );
		}
		subdictLastIdx.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictLoneIdx;
		if( dictByLoneIdx.containsKey( keyLoneIdx ) ) {
			subdictLoneIdx = dictByLoneIdx.get( keyLoneIdx );
		}
		else {
			subdictLoneIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByLoneIdx.put( keyLoneIdx, subdictLoneIdx );
		}
		subdictLoneIdx.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictEmptyIdx;
		if( dictByEmptyIdx.containsKey( keyEmptyIdx ) ) {
			subdictEmptyIdx = dictByEmptyIdx.get( keyEmptyIdx );
		}
		else {
			subdictEmptyIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByEmptyIdx.put( keyEmptyIdx, subdictEmptyIdx );
		}
		subdictEmptyIdx.put( pkey, Buff );

	}

	public CFGenKbGelSpreadBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelSpread.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelSpreadBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSpreadBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelSpread.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelSpreadBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSpreadBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGelSpread.readAllDerived";
		CFGenKbGelSpreadBuff[] retList = new CFGenKbGelSpreadBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGelSpreadBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGelSpreadBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelSpreadBuff> filteredList = new ArrayList<CFGenKbGelSpreadBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelSpreadBuff ) ) {
					filteredList.add( (CFGenKbGelSpreadBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelSpreadBuff[0] ) );
		}
	}

	public CFGenKbGelSpreadBuff[] readDerivedByGelCacheIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelSpreadBuff> filteredList = new ArrayList<CFGenKbGelSpreadBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelSpreadBuff ) ) {
					filteredList.add( (CFGenKbGelSpreadBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelSpreadBuff[0] ) );
		}
	}

	public CFGenKbGelSpreadBuff[] readDerivedByChainIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelSpreadBuff> filteredList = new ArrayList<CFGenKbGelSpreadBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelSpreadBuff ) ) {
					filteredList.add( (CFGenKbGelSpreadBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelSpreadBuff[0] ) );
		}
	}

	public CFGenKbGelSpreadBuff[] readDerivedByBetweenIdx( CFGenKbAuthorization Authorization,
		String ExpandBetween )
	{
		final String S_ProcName = "CFGenKbRamGelSpread.readDerivedByBetweenIdx";
		CFGenKbGelSpreadByBetweenIdxKey key = schema.getFactoryGelSpread().newBetweenIdxKey();
		key.setOptionalExpandBetween( ExpandBetween );

		CFGenKbGelSpreadBuff[] recArray;
		if( dictByBetweenIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictBetweenIdx
				= dictByBetweenIdx.get( key );
			recArray = new CFGenKbGelSpreadBuff[ subdictBetweenIdx.size() ];
			Iterator< CFGenKbGelSpreadBuff > iter = subdictBetweenIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictBetweenIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByBetweenIdx.put( key, subdictBetweenIdx );
			recArray = new CFGenKbGelSpreadBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelSpreadBuff[] readDerivedByBeforeIdx( CFGenKbAuthorization Authorization,
		String ExpandBefore )
	{
		final String S_ProcName = "CFGenKbRamGelSpread.readDerivedByBeforeIdx";
		CFGenKbGelSpreadByBeforeIdxKey key = schema.getFactoryGelSpread().newBeforeIdxKey();
		key.setOptionalExpandBefore( ExpandBefore );

		CFGenKbGelSpreadBuff[] recArray;
		if( dictByBeforeIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictBeforeIdx
				= dictByBeforeIdx.get( key );
			recArray = new CFGenKbGelSpreadBuff[ subdictBeforeIdx.size() ];
			Iterator< CFGenKbGelSpreadBuff > iter = subdictBeforeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictBeforeIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByBeforeIdx.put( key, subdictBeforeIdx );
			recArray = new CFGenKbGelSpreadBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelSpreadBuff[] readDerivedByFirstIdx( CFGenKbAuthorization Authorization,
		String ExpandFirst )
	{
		final String S_ProcName = "CFGenKbRamGelSpread.readDerivedByFirstIdx";
		CFGenKbGelSpreadByFirstIdxKey key = schema.getFactoryGelSpread().newFirstIdxKey();
		key.setOptionalExpandFirst( ExpandFirst );

		CFGenKbGelSpreadBuff[] recArray;
		if( dictByFirstIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictFirstIdx
				= dictByFirstIdx.get( key );
			recArray = new CFGenKbGelSpreadBuff[ subdictFirstIdx.size() ];
			Iterator< CFGenKbGelSpreadBuff > iter = subdictFirstIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictFirstIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByFirstIdx.put( key, subdictFirstIdx );
			recArray = new CFGenKbGelSpreadBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelSpreadBuff[] readDerivedByEachIdx( CFGenKbAuthorization Authorization,
		String ExpandEach )
	{
		final String S_ProcName = "CFGenKbRamGelSpread.readDerivedByEachIdx";
		CFGenKbGelSpreadByEachIdxKey key = schema.getFactoryGelSpread().newEachIdxKey();
		key.setRequiredExpandEach( ExpandEach );

		CFGenKbGelSpreadBuff[] recArray;
		if( dictByEachIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictEachIdx
				= dictByEachIdx.get( key );
			recArray = new CFGenKbGelSpreadBuff[ subdictEachIdx.size() ];
			Iterator< CFGenKbGelSpreadBuff > iter = subdictEachIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictEachIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByEachIdx.put( key, subdictEachIdx );
			recArray = new CFGenKbGelSpreadBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelSpreadBuff[] readDerivedByLastIdx( CFGenKbAuthorization Authorization,
		String ExpandLast )
	{
		final String S_ProcName = "CFGenKbRamGelSpread.readDerivedByLastIdx";
		CFGenKbGelSpreadByLastIdxKey key = schema.getFactoryGelSpread().newLastIdxKey();
		key.setOptionalExpandLast( ExpandLast );

		CFGenKbGelSpreadBuff[] recArray;
		if( dictByLastIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictLastIdx
				= dictByLastIdx.get( key );
			recArray = new CFGenKbGelSpreadBuff[ subdictLastIdx.size() ];
			Iterator< CFGenKbGelSpreadBuff > iter = subdictLastIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictLastIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByLastIdx.put( key, subdictLastIdx );
			recArray = new CFGenKbGelSpreadBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelSpreadBuff[] readDerivedByLoneIdx( CFGenKbAuthorization Authorization,
		String ExpandLone )
	{
		final String S_ProcName = "CFGenKbRamGelSpread.readDerivedByLoneIdx";
		CFGenKbGelSpreadByLoneIdxKey key = schema.getFactoryGelSpread().newLoneIdxKey();
		key.setOptionalExpandLone( ExpandLone );

		CFGenKbGelSpreadBuff[] recArray;
		if( dictByLoneIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictLoneIdx
				= dictByLoneIdx.get( key );
			recArray = new CFGenKbGelSpreadBuff[ subdictLoneIdx.size() ];
			Iterator< CFGenKbGelSpreadBuff > iter = subdictLoneIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictLoneIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByLoneIdx.put( key, subdictLoneIdx );
			recArray = new CFGenKbGelSpreadBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelSpreadBuff[] readDerivedByEmptyIdx( CFGenKbAuthorization Authorization,
		String ExpandEmpty )
	{
		final String S_ProcName = "CFGenKbRamGelSpread.readDerivedByEmptyIdx";
		CFGenKbGelSpreadByEmptyIdxKey key = schema.getFactoryGelSpread().newEmptyIdxKey();
		key.setOptionalExpandEmpty( ExpandEmpty );

		CFGenKbGelSpreadBuff[] recArray;
		if( dictByEmptyIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictEmptyIdx
				= dictByEmptyIdx.get( key );
			recArray = new CFGenKbGelSpreadBuff[ subdictEmptyIdx.size() ];
			Iterator< CFGenKbGelSpreadBuff > iter = subdictEmptyIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdictEmptyIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByEmptyIdx.put( key, subdictEmptyIdx );
			recArray = new CFGenKbGelSpreadBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelSpreadBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByPIdx() ";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );

		CFGenKbGelSpreadBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSpreadBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelSpread.readBuff";
		CFGenKbGelSpreadBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GSPR" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSpreadBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGelSpreadBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GSPR" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSpreadBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGelSpread.readAllBuff";
		CFGenKbGelSpreadBuff buff;
		ArrayList<CFGenKbGelSpreadBuff> filteredList = new ArrayList<CFGenKbGelSpreadBuff>();
		CFGenKbGelSpreadBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GSPR" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSpreadBuff[0] ) );
	}

	public CFGenKbGelSpreadBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByPIdx() ";
		CFGenKbGelSpreadBuff buff = readDerivedByPIdx( Authorization,
			TenantId,
			GelCacheId,
			GelInstId );
		if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
			return( (CFGenKbGelSpreadBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGelSpreadBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByTenantIdx() ";
		CFGenKbGelSpreadBuff buff;
		ArrayList<CFGenKbGelSpreadBuff> filteredList = new ArrayList<CFGenKbGelSpreadBuff>();
		CFGenKbGelSpreadBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelSpreadBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSpreadBuff[0] ) );
	}

	public CFGenKbGelSpreadBuff[] readBuffByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByGelCacheIdx() ";
		CFGenKbGelSpreadBuff buff;
		ArrayList<CFGenKbGelSpreadBuff> filteredList = new ArrayList<CFGenKbGelSpreadBuff>();
		CFGenKbGelSpreadBuff[] buffList = readDerivedByGelCacheIdx( Authorization,
			TenantId,
			GelCacheId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelSpreadBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSpreadBuff[0] ) );
	}

	public CFGenKbGelSpreadBuff[] readBuffByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByChainIdx() ";
		CFGenKbGelSpreadBuff buff;
		ArrayList<CFGenKbGelSpreadBuff> filteredList = new ArrayList<CFGenKbGelSpreadBuff>();
		CFGenKbGelSpreadBuff[] buffList = readDerivedByChainIdx( Authorization,
			ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelSpreadBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSpreadBuff[0] ) );
	}

	public CFGenKbGelSpreadBuff[] readBuffByBetweenIdx( CFGenKbAuthorization Authorization,
		String ExpandBetween )
	{
		final String S_ProcName = "CFGenKbRamGelSpread.readBuffByBetweenIdx() ";
		CFGenKbGelSpreadBuff buff;
		ArrayList<CFGenKbGelSpreadBuff> filteredList = new ArrayList<CFGenKbGelSpreadBuff>();
		CFGenKbGelSpreadBuff[] buffList = readDerivedByBetweenIdx( Authorization,
			ExpandBetween );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GSPR" ) ) {
				filteredList.add( (CFGenKbGelSpreadBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSpreadBuff[0] ) );
	}

	public CFGenKbGelSpreadBuff[] readBuffByBeforeIdx( CFGenKbAuthorization Authorization,
		String ExpandBefore )
	{
		final String S_ProcName = "CFGenKbRamGelSpread.readBuffByBeforeIdx() ";
		CFGenKbGelSpreadBuff buff;
		ArrayList<CFGenKbGelSpreadBuff> filteredList = new ArrayList<CFGenKbGelSpreadBuff>();
		CFGenKbGelSpreadBuff[] buffList = readDerivedByBeforeIdx( Authorization,
			ExpandBefore );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GSPR" ) ) {
				filteredList.add( (CFGenKbGelSpreadBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSpreadBuff[0] ) );
	}

	public CFGenKbGelSpreadBuff[] readBuffByFirstIdx( CFGenKbAuthorization Authorization,
		String ExpandFirst )
	{
		final String S_ProcName = "CFGenKbRamGelSpread.readBuffByFirstIdx() ";
		CFGenKbGelSpreadBuff buff;
		ArrayList<CFGenKbGelSpreadBuff> filteredList = new ArrayList<CFGenKbGelSpreadBuff>();
		CFGenKbGelSpreadBuff[] buffList = readDerivedByFirstIdx( Authorization,
			ExpandFirst );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GSPR" ) ) {
				filteredList.add( (CFGenKbGelSpreadBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSpreadBuff[0] ) );
	}

	public CFGenKbGelSpreadBuff[] readBuffByEachIdx( CFGenKbAuthorization Authorization,
		String ExpandEach )
	{
		final String S_ProcName = "CFGenKbRamGelSpread.readBuffByEachIdx() ";
		CFGenKbGelSpreadBuff buff;
		ArrayList<CFGenKbGelSpreadBuff> filteredList = new ArrayList<CFGenKbGelSpreadBuff>();
		CFGenKbGelSpreadBuff[] buffList = readDerivedByEachIdx( Authorization,
			ExpandEach );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GSPR" ) ) {
				filteredList.add( (CFGenKbGelSpreadBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSpreadBuff[0] ) );
	}

	public CFGenKbGelSpreadBuff[] readBuffByLastIdx( CFGenKbAuthorization Authorization,
		String ExpandLast )
	{
		final String S_ProcName = "CFGenKbRamGelSpread.readBuffByLastIdx() ";
		CFGenKbGelSpreadBuff buff;
		ArrayList<CFGenKbGelSpreadBuff> filteredList = new ArrayList<CFGenKbGelSpreadBuff>();
		CFGenKbGelSpreadBuff[] buffList = readDerivedByLastIdx( Authorization,
			ExpandLast );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GSPR" ) ) {
				filteredList.add( (CFGenKbGelSpreadBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSpreadBuff[0] ) );
	}

	public CFGenKbGelSpreadBuff[] readBuffByLoneIdx( CFGenKbAuthorization Authorization,
		String ExpandLone )
	{
		final String S_ProcName = "CFGenKbRamGelSpread.readBuffByLoneIdx() ";
		CFGenKbGelSpreadBuff buff;
		ArrayList<CFGenKbGelSpreadBuff> filteredList = new ArrayList<CFGenKbGelSpreadBuff>();
		CFGenKbGelSpreadBuff[] buffList = readDerivedByLoneIdx( Authorization,
			ExpandLone );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GSPR" ) ) {
				filteredList.add( (CFGenKbGelSpreadBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSpreadBuff[0] ) );
	}

	public CFGenKbGelSpreadBuff[] readBuffByEmptyIdx( CFGenKbAuthorization Authorization,
		String ExpandEmpty )
	{
		final String S_ProcName = "CFGenKbRamGelSpread.readBuffByEmptyIdx() ";
		CFGenKbGelSpreadBuff buff;
		ArrayList<CFGenKbGelSpreadBuff> filteredList = new ArrayList<CFGenKbGelSpreadBuff>();
		CFGenKbGelSpreadBuff[] buffList = readDerivedByEmptyIdx( Authorization,
			ExpandEmpty );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GSPR" ) ) {
				filteredList.add( (CFGenKbGelSpreadBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSpreadBuff[0] ) );
	}

	/**
	 *	Read a page array of the specific GelSpread buffer instances identified by the duplicate key BetweenIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandBetween	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelSpreadBuff[] pageBuffByBetweenIdx( CFGenKbAuthorization Authorization,
		String ExpandBetween,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByBetweenIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GelSpread buffer instances identified by the duplicate key BeforeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandBefore	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelSpreadBuff[] pageBuffByBeforeIdx( CFGenKbAuthorization Authorization,
		String ExpandBefore,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByBeforeIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GelSpread buffer instances identified by the duplicate key FirstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandFirst	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelSpreadBuff[] pageBuffByFirstIdx( CFGenKbAuthorization Authorization,
		String ExpandFirst,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByFirstIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GelSpread buffer instances identified by the duplicate key EachIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandEach	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelSpreadBuff[] pageBuffByEachIdx( CFGenKbAuthorization Authorization,
		String ExpandEach,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByEachIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GelSpread buffer instances identified by the duplicate key LastIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandLast	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelSpreadBuff[] pageBuffByLastIdx( CFGenKbAuthorization Authorization,
		String ExpandLast,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByLastIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GelSpread buffer instances identified by the duplicate key LoneIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandLone	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelSpreadBuff[] pageBuffByLoneIdx( CFGenKbAuthorization Authorization,
		String ExpandLone,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByLoneIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GelSpread buffer instances identified by the duplicate key EmptyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandEmpty	The GelSpread key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelSpreadBuff[] pageBuffByEmptyIdx( CFGenKbAuthorization Authorization,
		String ExpandEmpty,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByEmptyIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateGelSpread( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadBuff Buff )
	{
		schema.getTableGelInstruction().updateGelInstruction( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelSpreadBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGelSpread",
				"Existing record not found",
				"GelSpread",
				pkey );
		}
		CFGenKbGelSpreadByBetweenIdxKey existingKeyBetweenIdx = schema.getFactoryGelSpread().newBetweenIdxKey();
		existingKeyBetweenIdx.setOptionalExpandBetween( existing.getOptionalExpandBetween() );

		CFGenKbGelSpreadByBetweenIdxKey newKeyBetweenIdx = schema.getFactoryGelSpread().newBetweenIdxKey();
		newKeyBetweenIdx.setOptionalExpandBetween( Buff.getOptionalExpandBetween() );

		CFGenKbGelSpreadByBeforeIdxKey existingKeyBeforeIdx = schema.getFactoryGelSpread().newBeforeIdxKey();
		existingKeyBeforeIdx.setOptionalExpandBefore( existing.getOptionalExpandBefore() );

		CFGenKbGelSpreadByBeforeIdxKey newKeyBeforeIdx = schema.getFactoryGelSpread().newBeforeIdxKey();
		newKeyBeforeIdx.setOptionalExpandBefore( Buff.getOptionalExpandBefore() );

		CFGenKbGelSpreadByFirstIdxKey existingKeyFirstIdx = schema.getFactoryGelSpread().newFirstIdxKey();
		existingKeyFirstIdx.setOptionalExpandFirst( existing.getOptionalExpandFirst() );

		CFGenKbGelSpreadByFirstIdxKey newKeyFirstIdx = schema.getFactoryGelSpread().newFirstIdxKey();
		newKeyFirstIdx.setOptionalExpandFirst( Buff.getOptionalExpandFirst() );

		CFGenKbGelSpreadByEachIdxKey existingKeyEachIdx = schema.getFactoryGelSpread().newEachIdxKey();
		existingKeyEachIdx.setRequiredExpandEach( existing.getRequiredExpandEach() );

		CFGenKbGelSpreadByEachIdxKey newKeyEachIdx = schema.getFactoryGelSpread().newEachIdxKey();
		newKeyEachIdx.setRequiredExpandEach( Buff.getRequiredExpandEach() );

		CFGenKbGelSpreadByLastIdxKey existingKeyLastIdx = schema.getFactoryGelSpread().newLastIdxKey();
		existingKeyLastIdx.setOptionalExpandLast( existing.getOptionalExpandLast() );

		CFGenKbGelSpreadByLastIdxKey newKeyLastIdx = schema.getFactoryGelSpread().newLastIdxKey();
		newKeyLastIdx.setOptionalExpandLast( Buff.getOptionalExpandLast() );

		CFGenKbGelSpreadByLoneIdxKey existingKeyLoneIdx = schema.getFactoryGelSpread().newLoneIdxKey();
		existingKeyLoneIdx.setOptionalExpandLone( existing.getOptionalExpandLone() );

		CFGenKbGelSpreadByLoneIdxKey newKeyLoneIdx = schema.getFactoryGelSpread().newLoneIdxKey();
		newKeyLoneIdx.setOptionalExpandLone( Buff.getOptionalExpandLone() );

		CFGenKbGelSpreadByEmptyIdxKey existingKeyEmptyIdx = schema.getFactoryGelSpread().newEmptyIdxKey();
		existingKeyEmptyIdx.setOptionalExpandEmpty( existing.getOptionalExpandEmpty() );

		CFGenKbGelSpreadByEmptyIdxKey newKeyEmptyIdx = schema.getFactoryGelSpread().newEmptyIdxKey();
		newKeyEmptyIdx.setOptionalExpandEmpty( Buff.getOptionalExpandEmpty() );

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
						"updateGelSpread",
						"Superclass",
						"SuperClass",
						"GelInstruction",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByBetweenIdx.get( existingKeyBetweenIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByBetweenIdx.containsKey( newKeyBetweenIdx ) ) {
			subdict = dictByBetweenIdx.get( newKeyBetweenIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByBetweenIdx.put( newKeyBetweenIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByBeforeIdx.get( existingKeyBeforeIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByBeforeIdx.containsKey( newKeyBeforeIdx ) ) {
			subdict = dictByBeforeIdx.get( newKeyBeforeIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByBeforeIdx.put( newKeyBeforeIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByFirstIdx.get( existingKeyFirstIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByFirstIdx.containsKey( newKeyFirstIdx ) ) {
			subdict = dictByFirstIdx.get( newKeyFirstIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByFirstIdx.put( newKeyFirstIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByEachIdx.get( existingKeyEachIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByEachIdx.containsKey( newKeyEachIdx ) ) {
			subdict = dictByEachIdx.get( newKeyEachIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByEachIdx.put( newKeyEachIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByLastIdx.get( existingKeyLastIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByLastIdx.containsKey( newKeyLastIdx ) ) {
			subdict = dictByLastIdx.get( newKeyLastIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByLastIdx.put( newKeyLastIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByLoneIdx.get( existingKeyLoneIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByLoneIdx.containsKey( newKeyLoneIdx ) ) {
			subdict = dictByLoneIdx.get( newKeyLoneIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByLoneIdx.put( newKeyLoneIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByEmptyIdx.get( existingKeyEmptyIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByEmptyIdx.containsKey( newKeyEmptyIdx ) ) {
			subdict = dictByEmptyIdx.get( newKeyEmptyIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff >();
			dictByEmptyIdx.put( newKeyEmptyIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteGelSpread( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGelSpreadTable.deleteGelSpread() ";
		String classCode;
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelSpreadBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGelSpread",
				pkey );
		}
		CFGenKbGelSpreadByBetweenIdxKey keyBetweenIdx = schema.getFactoryGelSpread().newBetweenIdxKey();
		keyBetweenIdx.setOptionalExpandBetween( existing.getOptionalExpandBetween() );

		CFGenKbGelSpreadByBeforeIdxKey keyBeforeIdx = schema.getFactoryGelSpread().newBeforeIdxKey();
		keyBeforeIdx.setOptionalExpandBefore( existing.getOptionalExpandBefore() );

		CFGenKbGelSpreadByFirstIdxKey keyFirstIdx = schema.getFactoryGelSpread().newFirstIdxKey();
		keyFirstIdx.setOptionalExpandFirst( existing.getOptionalExpandFirst() );

		CFGenKbGelSpreadByEachIdxKey keyEachIdx = schema.getFactoryGelSpread().newEachIdxKey();
		keyEachIdx.setRequiredExpandEach( existing.getRequiredExpandEach() );

		CFGenKbGelSpreadByLastIdxKey keyLastIdx = schema.getFactoryGelSpread().newLastIdxKey();
		keyLastIdx.setOptionalExpandLast( existing.getOptionalExpandLast() );

		CFGenKbGelSpreadByLoneIdxKey keyLoneIdx = schema.getFactoryGelSpread().newLoneIdxKey();
		keyLoneIdx.setOptionalExpandLone( existing.getOptionalExpandLone() );

		CFGenKbGelSpreadByEmptyIdxKey keyEmptyIdx = schema.getFactoryGelSpread().newEmptyIdxKey();
		keyEmptyIdx.setOptionalExpandEmpty( existing.getOptionalExpandEmpty() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbGelInstructionPKey, CFGenKbGelSpreadBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByBetweenIdx.get( keyBetweenIdx );
		subdict.remove( pkey );

		subdict = dictByBeforeIdx.get( keyBeforeIdx );
		subdict.remove( pkey );

		subdict = dictByFirstIdx.get( keyFirstIdx );
		subdict.remove( pkey );

		subdict = dictByEachIdx.get( keyEachIdx );
		subdict.remove( pkey );

		subdict = dictByLastIdx.get( keyLastIdx );
		subdict.remove( pkey );

		subdict = dictByLoneIdx.get( keyLoneIdx );
		subdict.remove( pkey );

		subdict = dictByEmptyIdx.get( keyEmptyIdx );
		subdict.remove( pkey );

		schema.getTableGelInstruction().deleteGelInstruction( Authorization,
			Buff );
	}
	public void deleteGelSpreadByBetweenIdx( CFGenKbAuthorization Authorization,
		String argExpandBetween )
	{
		CFGenKbGelSpreadByBetweenIdxKey key = schema.getFactoryGelSpread().newBetweenIdxKey();
		key.setOptionalExpandBetween( argExpandBetween );
		deleteGelSpreadByBetweenIdx( Authorization, key );
	}

	public void deleteGelSpreadByBetweenIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadByBetweenIdxKey argKey )
	{
		CFGenKbGelSpreadBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalExpandBetween() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelSpreadBuff> matchSet = new LinkedList<CFGenKbGelSpreadBuff>();
		Iterator<CFGenKbGelSpreadBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSpreadBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSpread().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelSpread( Authorization, cur );
		}
	}

	public void deleteGelSpreadByBeforeIdx( CFGenKbAuthorization Authorization,
		String argExpandBefore )
	{
		CFGenKbGelSpreadByBeforeIdxKey key = schema.getFactoryGelSpread().newBeforeIdxKey();
		key.setOptionalExpandBefore( argExpandBefore );
		deleteGelSpreadByBeforeIdx( Authorization, key );
	}

	public void deleteGelSpreadByBeforeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadByBeforeIdxKey argKey )
	{
		CFGenKbGelSpreadBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalExpandBefore() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelSpreadBuff> matchSet = new LinkedList<CFGenKbGelSpreadBuff>();
		Iterator<CFGenKbGelSpreadBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSpreadBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSpread().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelSpread( Authorization, cur );
		}
	}

	public void deleteGelSpreadByFirstIdx( CFGenKbAuthorization Authorization,
		String argExpandFirst )
	{
		CFGenKbGelSpreadByFirstIdxKey key = schema.getFactoryGelSpread().newFirstIdxKey();
		key.setOptionalExpandFirst( argExpandFirst );
		deleteGelSpreadByFirstIdx( Authorization, key );
	}

	public void deleteGelSpreadByFirstIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadByFirstIdxKey argKey )
	{
		CFGenKbGelSpreadBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalExpandFirst() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelSpreadBuff> matchSet = new LinkedList<CFGenKbGelSpreadBuff>();
		Iterator<CFGenKbGelSpreadBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSpreadBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSpread().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelSpread( Authorization, cur );
		}
	}

	public void deleteGelSpreadByEachIdx( CFGenKbAuthorization Authorization,
		String argExpandEach )
	{
		CFGenKbGelSpreadByEachIdxKey key = schema.getFactoryGelSpread().newEachIdxKey();
		key.setRequiredExpandEach( argExpandEach );
		deleteGelSpreadByEachIdx( Authorization, key );
	}

	public void deleteGelSpreadByEachIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadByEachIdxKey argKey )
	{
		CFGenKbGelSpreadBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelSpreadBuff> matchSet = new LinkedList<CFGenKbGelSpreadBuff>();
		Iterator<CFGenKbGelSpreadBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSpreadBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSpread().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelSpread( Authorization, cur );
		}
	}

	public void deleteGelSpreadByLastIdx( CFGenKbAuthorization Authorization,
		String argExpandLast )
	{
		CFGenKbGelSpreadByLastIdxKey key = schema.getFactoryGelSpread().newLastIdxKey();
		key.setOptionalExpandLast( argExpandLast );
		deleteGelSpreadByLastIdx( Authorization, key );
	}

	public void deleteGelSpreadByLastIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadByLastIdxKey argKey )
	{
		CFGenKbGelSpreadBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalExpandLast() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelSpreadBuff> matchSet = new LinkedList<CFGenKbGelSpreadBuff>();
		Iterator<CFGenKbGelSpreadBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSpreadBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSpread().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelSpread( Authorization, cur );
		}
	}

	public void deleteGelSpreadByLoneIdx( CFGenKbAuthorization Authorization,
		String argExpandLone )
	{
		CFGenKbGelSpreadByLoneIdxKey key = schema.getFactoryGelSpread().newLoneIdxKey();
		key.setOptionalExpandLone( argExpandLone );
		deleteGelSpreadByLoneIdx( Authorization, key );
	}

	public void deleteGelSpreadByLoneIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadByLoneIdxKey argKey )
	{
		CFGenKbGelSpreadBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalExpandLone() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelSpreadBuff> matchSet = new LinkedList<CFGenKbGelSpreadBuff>();
		Iterator<CFGenKbGelSpreadBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSpreadBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSpread().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelSpread( Authorization, cur );
		}
	}

	public void deleteGelSpreadByEmptyIdx( CFGenKbAuthorization Authorization,
		String argExpandEmpty )
	{
		CFGenKbGelSpreadByEmptyIdxKey key = schema.getFactoryGelSpread().newEmptyIdxKey();
		key.setOptionalExpandEmpty( argExpandEmpty );
		deleteGelSpreadByEmptyIdx( Authorization, key );
	}

	public void deleteGelSpreadByEmptyIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSpreadByEmptyIdxKey argKey )
	{
		CFGenKbGelSpreadBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalExpandEmpty() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelSpreadBuff> matchSet = new LinkedList<CFGenKbGelSpreadBuff>();
		Iterator<CFGenKbGelSpreadBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSpreadBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSpread().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelSpread( Authorization, cur );
		}
	}

	public void deleteGelSpreadByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId )
	{
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		key.setRequiredGelInstId( argGelInstId );
		deleteGelSpreadByPIdx( Authorization, key );
	}

	public void deleteGelSpreadByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGelSpreadBuff cur;
		LinkedList<CFGenKbGelSpreadBuff> matchSet = new LinkedList<CFGenKbGelSpreadBuff>();
		Iterator<CFGenKbGelSpreadBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSpreadBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSpread().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelSpread( Authorization, cur );
		}
	}

	public void deleteGelSpreadByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGelInstructionByTenantIdxKey key = schema.getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGelSpreadByTenantIdx( Authorization, key );
	}

	public void deleteGelSpreadByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByTenantIdxKey argKey )
	{
		CFGenKbGelSpreadBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelSpreadBuff> matchSet = new LinkedList<CFGenKbGelSpreadBuff>();
		Iterator<CFGenKbGelSpreadBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSpreadBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSpread().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelSpread( Authorization, cur );
		}
	}

	public void deleteGelSpreadByGelCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId )
	{
		CFGenKbGelInstructionByGelCacheIdxKey key = schema.getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		deleteGelSpreadByGelCacheIdx( Authorization, key );
	}

	public void deleteGelSpreadByGelCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByGelCacheIdxKey argKey )
	{
		CFGenKbGelSpreadBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelSpreadBuff> matchSet = new LinkedList<CFGenKbGelSpreadBuff>();
		Iterator<CFGenKbGelSpreadBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSpreadBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSpread().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelSpread( Authorization, cur );
		}
	}

	public void deleteGelSpreadByChainIdx( CFGenKbAuthorization Authorization,
		Long argChainInstTenantId,
		Long argChainInstGelCacheId,
		Long argChainInstGelInstId )
	{
		CFGenKbGelInstructionByChainIdxKey key = schema.getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( argChainInstTenantId );
		key.setOptionalChainInstGelCacheId( argChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( argChainInstGelInstId );
		deleteGelSpreadByChainIdx( Authorization, key );
	}

	public void deleteGelSpreadByChainIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByChainIdxKey argKey )
	{
		CFGenKbGelSpreadBuff cur;
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
		LinkedList<CFGenKbGelSpreadBuff> matchSet = new LinkedList<CFGenKbGelSpreadBuff>();
		Iterator<CFGenKbGelSpreadBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSpreadBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSpread().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelSpread( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
