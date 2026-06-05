
// Description: Java 11 in-memory RAM DbIO implementation for GelIterator.

/*
 *	org.msscf.msscf.CFCore
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
 *	
 *	MSS Code Factory is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with MSS Code Factory.  If not, see https://www.gnu.org/licenses/.
 *	
 *	Donations to support MSS Code Factory can be made at
 *	https://www.paypal.com/paypalme2/MarkSobkow
 *	
 *	Contact Mark Stephen Sobkow at msobkow@sasktel.net for commercial licensing.
 *
 *	Manufactured by MSS Code Factory 2.11
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
 *	CFGenKbRamGelIteratorTable in-memory RAM DbIO implementation
 *	for GelIterator.
 */
public class CFGenKbRamGelIteratorTable
	implements ICFGenKbGelIteratorTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGelInstructionPKey,
				CFGenKbGelIteratorBuff > dictByPKey
		= new HashMap< CFGenKbGelInstructionPKey,
				CFGenKbGelIteratorBuff >();
	private Map< CFGenKbGelIteratorByBeforeIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelIteratorBuff >> dictByBeforeIdx
		= new HashMap< CFGenKbGelIteratorByBeforeIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelIteratorBuff >>();
	private Map< CFGenKbGelIteratorByFirstIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelIteratorBuff >> dictByFirstIdx
		= new HashMap< CFGenKbGelIteratorByFirstIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelIteratorBuff >>();
	private Map< CFGenKbGelIteratorByEachIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelIteratorBuff >> dictByEachIdx
		= new HashMap< CFGenKbGelIteratorByEachIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelIteratorBuff >>();
	private Map< CFGenKbGelIteratorByLastIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelIteratorBuff >> dictByLastIdx
		= new HashMap< CFGenKbGelIteratorByLastIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelIteratorBuff >>();
	private Map< CFGenKbGelIteratorByLoneIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelIteratorBuff >> dictByLoneIdx
		= new HashMap< CFGenKbGelIteratorByLoneIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelIteratorBuff >>();
	private Map< CFGenKbGelIteratorByEmptyIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelIteratorBuff >> dictByEmptyIdx
		= new HashMap< CFGenKbGelIteratorByEmptyIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelIteratorBuff >>();

	public CFGenKbRamGelIteratorTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGelIterator( CFGenKbAuthorization Authorization,
		CFGenKbGelIteratorBuff Buff )
	{
		final String S_ProcName = "createGelIterator";
		schema.getTableGelInstruction().createGelInstruction( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelIteratorByBeforeIdxKey keyBeforeIdx = schema.getFactoryGelIterator().newBeforeIdxKey();
		keyBeforeIdx.setOptionalExpandBefore( Buff.getOptionalExpandBefore() );

		CFGenKbGelIteratorByFirstIdxKey keyFirstIdx = schema.getFactoryGelIterator().newFirstIdxKey();
		keyFirstIdx.setOptionalExpandFirst( Buff.getOptionalExpandFirst() );

		CFGenKbGelIteratorByEachIdxKey keyEachIdx = schema.getFactoryGelIterator().newEachIdxKey();
		keyEachIdx.setRequiredExpandEach( Buff.getRequiredExpandEach() );

		CFGenKbGelIteratorByLastIdxKey keyLastIdx = schema.getFactoryGelIterator().newLastIdxKey();
		keyLastIdx.setOptionalExpandLast( Buff.getOptionalExpandLast() );

		CFGenKbGelIteratorByLoneIdxKey keyLoneIdx = schema.getFactoryGelIterator().newLoneIdxKey();
		keyLoneIdx.setOptionalExpandLone( Buff.getOptionalExpandLone() );

		CFGenKbGelIteratorByEmptyIdxKey keyEmptyIdx = schema.getFactoryGelIterator().newEmptyIdxKey();
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

		Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdictBeforeIdx;
		if( dictByBeforeIdx.containsKey( keyBeforeIdx ) ) {
			subdictBeforeIdx = dictByBeforeIdx.get( keyBeforeIdx );
		}
		else {
			subdictBeforeIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff >();
			dictByBeforeIdx.put( keyBeforeIdx, subdictBeforeIdx );
		}
		subdictBeforeIdx.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdictFirstIdx;
		if( dictByFirstIdx.containsKey( keyFirstIdx ) ) {
			subdictFirstIdx = dictByFirstIdx.get( keyFirstIdx );
		}
		else {
			subdictFirstIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff >();
			dictByFirstIdx.put( keyFirstIdx, subdictFirstIdx );
		}
		subdictFirstIdx.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdictEachIdx;
		if( dictByEachIdx.containsKey( keyEachIdx ) ) {
			subdictEachIdx = dictByEachIdx.get( keyEachIdx );
		}
		else {
			subdictEachIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff >();
			dictByEachIdx.put( keyEachIdx, subdictEachIdx );
		}
		subdictEachIdx.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdictLastIdx;
		if( dictByLastIdx.containsKey( keyLastIdx ) ) {
			subdictLastIdx = dictByLastIdx.get( keyLastIdx );
		}
		else {
			subdictLastIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff >();
			dictByLastIdx.put( keyLastIdx, subdictLastIdx );
		}
		subdictLastIdx.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdictLoneIdx;
		if( dictByLoneIdx.containsKey( keyLoneIdx ) ) {
			subdictLoneIdx = dictByLoneIdx.get( keyLoneIdx );
		}
		else {
			subdictLoneIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff >();
			dictByLoneIdx.put( keyLoneIdx, subdictLoneIdx );
		}
		subdictLoneIdx.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdictEmptyIdx;
		if( dictByEmptyIdx.containsKey( keyEmptyIdx ) ) {
			subdictEmptyIdx = dictByEmptyIdx.get( keyEmptyIdx );
		}
		else {
			subdictEmptyIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff >();
			dictByEmptyIdx.put( keyEmptyIdx, subdictEmptyIdx );
		}
		subdictEmptyIdx.put( pkey, Buff );

	}

	public CFGenKbGelIteratorBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelIterator.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelIteratorBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelIteratorBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelIterator.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelIteratorBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelIteratorBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGelIterator.readAllDerived";
		CFGenKbGelIteratorBuff[] retList = new CFGenKbGelIteratorBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGelIteratorBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGelIteratorBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelIteratorBuff> filteredList = new ArrayList<CFGenKbGelIteratorBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelIteratorBuff ) ) {
					filteredList.add( (CFGenKbGelIteratorBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelIteratorBuff[0] ) );
		}
	}

	public CFGenKbGelIteratorBuff[] readDerivedByGelCacheIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelIteratorBuff> filteredList = new ArrayList<CFGenKbGelIteratorBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelIteratorBuff ) ) {
					filteredList.add( (CFGenKbGelIteratorBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelIteratorBuff[0] ) );
		}
	}

	public CFGenKbGelIteratorBuff[] readDerivedByChainIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelIteratorBuff> filteredList = new ArrayList<CFGenKbGelIteratorBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelIteratorBuff ) ) {
					filteredList.add( (CFGenKbGelIteratorBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelIteratorBuff[0] ) );
		}
	}

	public CFGenKbGelIteratorBuff[] readDerivedByBeforeIdx( CFGenKbAuthorization Authorization,
		String ExpandBefore )
	{
		final String S_ProcName = "CFGenKbRamGelIterator.readDerivedByBeforeIdx";
		CFGenKbGelIteratorByBeforeIdxKey key = schema.getFactoryGelIterator().newBeforeIdxKey();
		key.setOptionalExpandBefore( ExpandBefore );

		CFGenKbGelIteratorBuff[] recArray;
		if( dictByBeforeIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdictBeforeIdx
				= dictByBeforeIdx.get( key );
			recArray = new CFGenKbGelIteratorBuff[ subdictBeforeIdx.size() ];
			Iterator< CFGenKbGelIteratorBuff > iter = subdictBeforeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdictBeforeIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff >();
			dictByBeforeIdx.put( key, subdictBeforeIdx );
			recArray = new CFGenKbGelIteratorBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelIteratorBuff[] readDerivedByFirstIdx( CFGenKbAuthorization Authorization,
		String ExpandFirst )
	{
		final String S_ProcName = "CFGenKbRamGelIterator.readDerivedByFirstIdx";
		CFGenKbGelIteratorByFirstIdxKey key = schema.getFactoryGelIterator().newFirstIdxKey();
		key.setOptionalExpandFirst( ExpandFirst );

		CFGenKbGelIteratorBuff[] recArray;
		if( dictByFirstIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdictFirstIdx
				= dictByFirstIdx.get( key );
			recArray = new CFGenKbGelIteratorBuff[ subdictFirstIdx.size() ];
			Iterator< CFGenKbGelIteratorBuff > iter = subdictFirstIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdictFirstIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff >();
			dictByFirstIdx.put( key, subdictFirstIdx );
			recArray = new CFGenKbGelIteratorBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelIteratorBuff[] readDerivedByEachIdx( CFGenKbAuthorization Authorization,
		String ExpandEach )
	{
		final String S_ProcName = "CFGenKbRamGelIterator.readDerivedByEachIdx";
		CFGenKbGelIteratorByEachIdxKey key = schema.getFactoryGelIterator().newEachIdxKey();
		key.setRequiredExpandEach( ExpandEach );

		CFGenKbGelIteratorBuff[] recArray;
		if( dictByEachIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdictEachIdx
				= dictByEachIdx.get( key );
			recArray = new CFGenKbGelIteratorBuff[ subdictEachIdx.size() ];
			Iterator< CFGenKbGelIteratorBuff > iter = subdictEachIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdictEachIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff >();
			dictByEachIdx.put( key, subdictEachIdx );
			recArray = new CFGenKbGelIteratorBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelIteratorBuff[] readDerivedByLastIdx( CFGenKbAuthorization Authorization,
		String ExpandLast )
	{
		final String S_ProcName = "CFGenKbRamGelIterator.readDerivedByLastIdx";
		CFGenKbGelIteratorByLastIdxKey key = schema.getFactoryGelIterator().newLastIdxKey();
		key.setOptionalExpandLast( ExpandLast );

		CFGenKbGelIteratorBuff[] recArray;
		if( dictByLastIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdictLastIdx
				= dictByLastIdx.get( key );
			recArray = new CFGenKbGelIteratorBuff[ subdictLastIdx.size() ];
			Iterator< CFGenKbGelIteratorBuff > iter = subdictLastIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdictLastIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff >();
			dictByLastIdx.put( key, subdictLastIdx );
			recArray = new CFGenKbGelIteratorBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelIteratorBuff[] readDerivedByLoneIdx( CFGenKbAuthorization Authorization,
		String ExpandLone )
	{
		final String S_ProcName = "CFGenKbRamGelIterator.readDerivedByLoneIdx";
		CFGenKbGelIteratorByLoneIdxKey key = schema.getFactoryGelIterator().newLoneIdxKey();
		key.setOptionalExpandLone( ExpandLone );

		CFGenKbGelIteratorBuff[] recArray;
		if( dictByLoneIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdictLoneIdx
				= dictByLoneIdx.get( key );
			recArray = new CFGenKbGelIteratorBuff[ subdictLoneIdx.size() ];
			Iterator< CFGenKbGelIteratorBuff > iter = subdictLoneIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdictLoneIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff >();
			dictByLoneIdx.put( key, subdictLoneIdx );
			recArray = new CFGenKbGelIteratorBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelIteratorBuff[] readDerivedByEmptyIdx( CFGenKbAuthorization Authorization,
		String ExpandEmpty )
	{
		final String S_ProcName = "CFGenKbRamGelIterator.readDerivedByEmptyIdx";
		CFGenKbGelIteratorByEmptyIdxKey key = schema.getFactoryGelIterator().newEmptyIdxKey();
		key.setOptionalExpandEmpty( ExpandEmpty );

		CFGenKbGelIteratorBuff[] recArray;
		if( dictByEmptyIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdictEmptyIdx
				= dictByEmptyIdx.get( key );
			recArray = new CFGenKbGelIteratorBuff[ subdictEmptyIdx.size() ];
			Iterator< CFGenKbGelIteratorBuff > iter = subdictEmptyIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdictEmptyIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff >();
			dictByEmptyIdx.put( key, subdictEmptyIdx );
			recArray = new CFGenKbGelIteratorBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelIteratorBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByPIdx() ";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );

		CFGenKbGelIteratorBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelIteratorBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelIterator.readBuff";
		CFGenKbGelIteratorBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GITR" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelIteratorBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGelIteratorBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GITR" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelIteratorBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGelIterator.readAllBuff";
		CFGenKbGelIteratorBuff buff;
		ArrayList<CFGenKbGelIteratorBuff> filteredList = new ArrayList<CFGenKbGelIteratorBuff>();
		CFGenKbGelIteratorBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GITR" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelIteratorBuff[0] ) );
	}

	public CFGenKbGelIteratorBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByPIdx() ";
		CFGenKbGelIteratorBuff buff = readDerivedByPIdx( Authorization,
			TenantId,
			GelCacheId,
			GelInstId );
		if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
			return( (CFGenKbGelIteratorBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGelIteratorBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByTenantIdx() ";
		CFGenKbGelIteratorBuff buff;
		ArrayList<CFGenKbGelIteratorBuff> filteredList = new ArrayList<CFGenKbGelIteratorBuff>();
		CFGenKbGelIteratorBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelIteratorBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelIteratorBuff[0] ) );
	}

	public CFGenKbGelIteratorBuff[] readBuffByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByGelCacheIdx() ";
		CFGenKbGelIteratorBuff buff;
		ArrayList<CFGenKbGelIteratorBuff> filteredList = new ArrayList<CFGenKbGelIteratorBuff>();
		CFGenKbGelIteratorBuff[] buffList = readDerivedByGelCacheIdx( Authorization,
			TenantId,
			GelCacheId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelIteratorBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelIteratorBuff[0] ) );
	}

	public CFGenKbGelIteratorBuff[] readBuffByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByChainIdx() ";
		CFGenKbGelIteratorBuff buff;
		ArrayList<CFGenKbGelIteratorBuff> filteredList = new ArrayList<CFGenKbGelIteratorBuff>();
		CFGenKbGelIteratorBuff[] buffList = readDerivedByChainIdx( Authorization,
			ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelIteratorBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelIteratorBuff[0] ) );
	}

	public CFGenKbGelIteratorBuff[] readBuffByBeforeIdx( CFGenKbAuthorization Authorization,
		String ExpandBefore )
	{
		final String S_ProcName = "CFGenKbRamGelIterator.readBuffByBeforeIdx() ";
		CFGenKbGelIteratorBuff buff;
		ArrayList<CFGenKbGelIteratorBuff> filteredList = new ArrayList<CFGenKbGelIteratorBuff>();
		CFGenKbGelIteratorBuff[] buffList = readDerivedByBeforeIdx( Authorization,
			ExpandBefore );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GITR" ) ) {
				filteredList.add( (CFGenKbGelIteratorBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelIteratorBuff[0] ) );
	}

	public CFGenKbGelIteratorBuff[] readBuffByFirstIdx( CFGenKbAuthorization Authorization,
		String ExpandFirst )
	{
		final String S_ProcName = "CFGenKbRamGelIterator.readBuffByFirstIdx() ";
		CFGenKbGelIteratorBuff buff;
		ArrayList<CFGenKbGelIteratorBuff> filteredList = new ArrayList<CFGenKbGelIteratorBuff>();
		CFGenKbGelIteratorBuff[] buffList = readDerivedByFirstIdx( Authorization,
			ExpandFirst );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GITR" ) ) {
				filteredList.add( (CFGenKbGelIteratorBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelIteratorBuff[0] ) );
	}

	public CFGenKbGelIteratorBuff[] readBuffByEachIdx( CFGenKbAuthorization Authorization,
		String ExpandEach )
	{
		final String S_ProcName = "CFGenKbRamGelIterator.readBuffByEachIdx() ";
		CFGenKbGelIteratorBuff buff;
		ArrayList<CFGenKbGelIteratorBuff> filteredList = new ArrayList<CFGenKbGelIteratorBuff>();
		CFGenKbGelIteratorBuff[] buffList = readDerivedByEachIdx( Authorization,
			ExpandEach );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GITR" ) ) {
				filteredList.add( (CFGenKbGelIteratorBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelIteratorBuff[0] ) );
	}

	public CFGenKbGelIteratorBuff[] readBuffByLastIdx( CFGenKbAuthorization Authorization,
		String ExpandLast )
	{
		final String S_ProcName = "CFGenKbRamGelIterator.readBuffByLastIdx() ";
		CFGenKbGelIteratorBuff buff;
		ArrayList<CFGenKbGelIteratorBuff> filteredList = new ArrayList<CFGenKbGelIteratorBuff>();
		CFGenKbGelIteratorBuff[] buffList = readDerivedByLastIdx( Authorization,
			ExpandLast );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GITR" ) ) {
				filteredList.add( (CFGenKbGelIteratorBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelIteratorBuff[0] ) );
	}

	public CFGenKbGelIteratorBuff[] readBuffByLoneIdx( CFGenKbAuthorization Authorization,
		String ExpandLone )
	{
		final String S_ProcName = "CFGenKbRamGelIterator.readBuffByLoneIdx() ";
		CFGenKbGelIteratorBuff buff;
		ArrayList<CFGenKbGelIteratorBuff> filteredList = new ArrayList<CFGenKbGelIteratorBuff>();
		CFGenKbGelIteratorBuff[] buffList = readDerivedByLoneIdx( Authorization,
			ExpandLone );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GITR" ) ) {
				filteredList.add( (CFGenKbGelIteratorBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelIteratorBuff[0] ) );
	}

	public CFGenKbGelIteratorBuff[] readBuffByEmptyIdx( CFGenKbAuthorization Authorization,
		String ExpandEmpty )
	{
		final String S_ProcName = "CFGenKbRamGelIterator.readBuffByEmptyIdx() ";
		CFGenKbGelIteratorBuff buff;
		ArrayList<CFGenKbGelIteratorBuff> filteredList = new ArrayList<CFGenKbGelIteratorBuff>();
		CFGenKbGelIteratorBuff[] buffList = readDerivedByEmptyIdx( Authorization,
			ExpandEmpty );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GITR" ) ) {
				filteredList.add( (CFGenKbGelIteratorBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelIteratorBuff[0] ) );
	}

	/**
	 *	Read a page array of the specific GelIterator buffer instances identified by the duplicate key BeforeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandBefore	The GelIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelIteratorBuff[] pageBuffByBeforeIdx( CFGenKbAuthorization Authorization,
		String ExpandBefore,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByBeforeIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GelIterator buffer instances identified by the duplicate key FirstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandFirst	The GelIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelIteratorBuff[] pageBuffByFirstIdx( CFGenKbAuthorization Authorization,
		String ExpandFirst,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByFirstIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GelIterator buffer instances identified by the duplicate key EachIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandEach	The GelIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelIteratorBuff[] pageBuffByEachIdx( CFGenKbAuthorization Authorization,
		String ExpandEach,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByEachIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GelIterator buffer instances identified by the duplicate key LastIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandLast	The GelIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelIteratorBuff[] pageBuffByLastIdx( CFGenKbAuthorization Authorization,
		String ExpandLast,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByLastIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GelIterator buffer instances identified by the duplicate key LoneIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandLone	The GelIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelIteratorBuff[] pageBuffByLoneIdx( CFGenKbAuthorization Authorization,
		String ExpandLone,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByLoneIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GelIterator buffer instances identified by the duplicate key EmptyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argExpandEmpty	The GelIterator key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelIteratorBuff[] pageBuffByEmptyIdx( CFGenKbAuthorization Authorization,
		String ExpandEmpty,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByEmptyIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateGelIterator( CFGenKbAuthorization Authorization,
		CFGenKbGelIteratorBuff Buff )
	{
		schema.getTableGelInstruction().updateGelInstruction( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelIteratorBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGelIterator",
				"Existing record not found",
				"GelIterator",
				pkey );
		}
		CFGenKbGelIteratorByBeforeIdxKey existingKeyBeforeIdx = schema.getFactoryGelIterator().newBeforeIdxKey();
		existingKeyBeforeIdx.setOptionalExpandBefore( existing.getOptionalExpandBefore() );

		CFGenKbGelIteratorByBeforeIdxKey newKeyBeforeIdx = schema.getFactoryGelIterator().newBeforeIdxKey();
		newKeyBeforeIdx.setOptionalExpandBefore( Buff.getOptionalExpandBefore() );

		CFGenKbGelIteratorByFirstIdxKey existingKeyFirstIdx = schema.getFactoryGelIterator().newFirstIdxKey();
		existingKeyFirstIdx.setOptionalExpandFirst( existing.getOptionalExpandFirst() );

		CFGenKbGelIteratorByFirstIdxKey newKeyFirstIdx = schema.getFactoryGelIterator().newFirstIdxKey();
		newKeyFirstIdx.setOptionalExpandFirst( Buff.getOptionalExpandFirst() );

		CFGenKbGelIteratorByEachIdxKey existingKeyEachIdx = schema.getFactoryGelIterator().newEachIdxKey();
		existingKeyEachIdx.setRequiredExpandEach( existing.getRequiredExpandEach() );

		CFGenKbGelIteratorByEachIdxKey newKeyEachIdx = schema.getFactoryGelIterator().newEachIdxKey();
		newKeyEachIdx.setRequiredExpandEach( Buff.getRequiredExpandEach() );

		CFGenKbGelIteratorByLastIdxKey existingKeyLastIdx = schema.getFactoryGelIterator().newLastIdxKey();
		existingKeyLastIdx.setOptionalExpandLast( existing.getOptionalExpandLast() );

		CFGenKbGelIteratorByLastIdxKey newKeyLastIdx = schema.getFactoryGelIterator().newLastIdxKey();
		newKeyLastIdx.setOptionalExpandLast( Buff.getOptionalExpandLast() );

		CFGenKbGelIteratorByLoneIdxKey existingKeyLoneIdx = schema.getFactoryGelIterator().newLoneIdxKey();
		existingKeyLoneIdx.setOptionalExpandLone( existing.getOptionalExpandLone() );

		CFGenKbGelIteratorByLoneIdxKey newKeyLoneIdx = schema.getFactoryGelIterator().newLoneIdxKey();
		newKeyLoneIdx.setOptionalExpandLone( Buff.getOptionalExpandLone() );

		CFGenKbGelIteratorByEmptyIdxKey existingKeyEmptyIdx = schema.getFactoryGelIterator().newEmptyIdxKey();
		existingKeyEmptyIdx.setOptionalExpandEmpty( existing.getOptionalExpandEmpty() );

		CFGenKbGelIteratorByEmptyIdxKey newKeyEmptyIdx = schema.getFactoryGelIterator().newEmptyIdxKey();
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
						"updateGelIterator",
						"Superclass",
						"SuperClass",
						"GelInstruction",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByBeforeIdx.get( existingKeyBeforeIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByBeforeIdx.containsKey( newKeyBeforeIdx ) ) {
			subdict = dictByBeforeIdx.get( newKeyBeforeIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff >();
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
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff >();
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
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff >();
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
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff >();
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
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff >();
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
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff >();
			dictByEmptyIdx.put( newKeyEmptyIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteGelIterator( CFGenKbAuthorization Authorization,
		CFGenKbGelIteratorBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGelIteratorTable.deleteGelIterator() ";
		String classCode;
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelIteratorBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGelIterator",
				pkey );
		}
		CFGenKbGelIteratorByBeforeIdxKey keyBeforeIdx = schema.getFactoryGelIterator().newBeforeIdxKey();
		keyBeforeIdx.setOptionalExpandBefore( existing.getOptionalExpandBefore() );

		CFGenKbGelIteratorByFirstIdxKey keyFirstIdx = schema.getFactoryGelIterator().newFirstIdxKey();
		keyFirstIdx.setOptionalExpandFirst( existing.getOptionalExpandFirst() );

		CFGenKbGelIteratorByEachIdxKey keyEachIdx = schema.getFactoryGelIterator().newEachIdxKey();
		keyEachIdx.setRequiredExpandEach( existing.getRequiredExpandEach() );

		CFGenKbGelIteratorByLastIdxKey keyLastIdx = schema.getFactoryGelIterator().newLastIdxKey();
		keyLastIdx.setOptionalExpandLast( existing.getOptionalExpandLast() );

		CFGenKbGelIteratorByLoneIdxKey keyLoneIdx = schema.getFactoryGelIterator().newLoneIdxKey();
		keyLoneIdx.setOptionalExpandLone( existing.getOptionalExpandLone() );

		CFGenKbGelIteratorByEmptyIdxKey keyEmptyIdx = schema.getFactoryGelIterator().newEmptyIdxKey();
		keyEmptyIdx.setOptionalExpandEmpty( existing.getOptionalExpandEmpty() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbGelInstructionPKey, CFGenKbGelIteratorBuff > subdict;

		dictByPKey.remove( pkey );

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
	public void deleteGelIteratorByBeforeIdx( CFGenKbAuthorization Authorization,
		String argExpandBefore )
	{
		CFGenKbGelIteratorByBeforeIdxKey key = schema.getFactoryGelIterator().newBeforeIdxKey();
		key.setOptionalExpandBefore( argExpandBefore );
		deleteGelIteratorByBeforeIdx( Authorization, key );
	}

	public void deleteGelIteratorByBeforeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelIteratorByBeforeIdxKey argKey )
	{
		CFGenKbGelIteratorBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalExpandBefore() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelIteratorBuff> matchSet = new LinkedList<CFGenKbGelIteratorBuff>();
		Iterator<CFGenKbGelIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelIterator().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelIterator( Authorization, cur );
		}
	}

	public void deleteGelIteratorByFirstIdx( CFGenKbAuthorization Authorization,
		String argExpandFirst )
	{
		CFGenKbGelIteratorByFirstIdxKey key = schema.getFactoryGelIterator().newFirstIdxKey();
		key.setOptionalExpandFirst( argExpandFirst );
		deleteGelIteratorByFirstIdx( Authorization, key );
	}

	public void deleteGelIteratorByFirstIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelIteratorByFirstIdxKey argKey )
	{
		CFGenKbGelIteratorBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalExpandFirst() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelIteratorBuff> matchSet = new LinkedList<CFGenKbGelIteratorBuff>();
		Iterator<CFGenKbGelIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelIterator().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelIterator( Authorization, cur );
		}
	}

	public void deleteGelIteratorByEachIdx( CFGenKbAuthorization Authorization,
		String argExpandEach )
	{
		CFGenKbGelIteratorByEachIdxKey key = schema.getFactoryGelIterator().newEachIdxKey();
		key.setRequiredExpandEach( argExpandEach );
		deleteGelIteratorByEachIdx( Authorization, key );
	}

	public void deleteGelIteratorByEachIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelIteratorByEachIdxKey argKey )
	{
		CFGenKbGelIteratorBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelIteratorBuff> matchSet = new LinkedList<CFGenKbGelIteratorBuff>();
		Iterator<CFGenKbGelIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelIterator().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelIterator( Authorization, cur );
		}
	}

	public void deleteGelIteratorByLastIdx( CFGenKbAuthorization Authorization,
		String argExpandLast )
	{
		CFGenKbGelIteratorByLastIdxKey key = schema.getFactoryGelIterator().newLastIdxKey();
		key.setOptionalExpandLast( argExpandLast );
		deleteGelIteratorByLastIdx( Authorization, key );
	}

	public void deleteGelIteratorByLastIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelIteratorByLastIdxKey argKey )
	{
		CFGenKbGelIteratorBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalExpandLast() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelIteratorBuff> matchSet = new LinkedList<CFGenKbGelIteratorBuff>();
		Iterator<CFGenKbGelIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelIterator().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelIterator( Authorization, cur );
		}
	}

	public void deleteGelIteratorByLoneIdx( CFGenKbAuthorization Authorization,
		String argExpandLone )
	{
		CFGenKbGelIteratorByLoneIdxKey key = schema.getFactoryGelIterator().newLoneIdxKey();
		key.setOptionalExpandLone( argExpandLone );
		deleteGelIteratorByLoneIdx( Authorization, key );
	}

	public void deleteGelIteratorByLoneIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelIteratorByLoneIdxKey argKey )
	{
		CFGenKbGelIteratorBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalExpandLone() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelIteratorBuff> matchSet = new LinkedList<CFGenKbGelIteratorBuff>();
		Iterator<CFGenKbGelIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelIterator().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelIterator( Authorization, cur );
		}
	}

	public void deleteGelIteratorByEmptyIdx( CFGenKbAuthorization Authorization,
		String argExpandEmpty )
	{
		CFGenKbGelIteratorByEmptyIdxKey key = schema.getFactoryGelIterator().newEmptyIdxKey();
		key.setOptionalExpandEmpty( argExpandEmpty );
		deleteGelIteratorByEmptyIdx( Authorization, key );
	}

	public void deleteGelIteratorByEmptyIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelIteratorByEmptyIdxKey argKey )
	{
		CFGenKbGelIteratorBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalExpandEmpty() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelIteratorBuff> matchSet = new LinkedList<CFGenKbGelIteratorBuff>();
		Iterator<CFGenKbGelIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelIterator().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelIterator( Authorization, cur );
		}
	}

	public void deleteGelIteratorByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId )
	{
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		key.setRequiredGelInstId( argGelInstId );
		deleteGelIteratorByPIdx( Authorization, key );
	}

	public void deleteGelIteratorByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGelIteratorBuff cur;
		LinkedList<CFGenKbGelIteratorBuff> matchSet = new LinkedList<CFGenKbGelIteratorBuff>();
		Iterator<CFGenKbGelIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelIterator().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelIterator( Authorization, cur );
		}
	}

	public void deleteGelIteratorByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGelInstructionByTenantIdxKey key = schema.getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGelIteratorByTenantIdx( Authorization, key );
	}

	public void deleteGelIteratorByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByTenantIdxKey argKey )
	{
		CFGenKbGelIteratorBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelIteratorBuff> matchSet = new LinkedList<CFGenKbGelIteratorBuff>();
		Iterator<CFGenKbGelIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelIterator().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelIterator( Authorization, cur );
		}
	}

	public void deleteGelIteratorByGelCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId )
	{
		CFGenKbGelInstructionByGelCacheIdxKey key = schema.getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		deleteGelIteratorByGelCacheIdx( Authorization, key );
	}

	public void deleteGelIteratorByGelCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByGelCacheIdxKey argKey )
	{
		CFGenKbGelIteratorBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelIteratorBuff> matchSet = new LinkedList<CFGenKbGelIteratorBuff>();
		Iterator<CFGenKbGelIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelIterator().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelIterator( Authorization, cur );
		}
	}

	public void deleteGelIteratorByChainIdx( CFGenKbAuthorization Authorization,
		Long argChainInstTenantId,
		Long argChainInstGelCacheId,
		Long argChainInstGelInstId )
	{
		CFGenKbGelInstructionByChainIdxKey key = schema.getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( argChainInstTenantId );
		key.setOptionalChainInstGelCacheId( argChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( argChainInstGelInstId );
		deleteGelIteratorByChainIdx( Authorization, key );
	}

	public void deleteGelIteratorByChainIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByChainIdxKey argKey )
	{
		CFGenKbGelIteratorBuff cur;
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
		LinkedList<CFGenKbGelIteratorBuff> matchSet = new LinkedList<CFGenKbGelIteratorBuff>();
		Iterator<CFGenKbGelIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelIterator().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelIterator( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
