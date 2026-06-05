
// Description: Java 11 in-memory RAM DbIO implementation for GelCall.

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
 *	CFGenKbRamGelCallTable in-memory RAM DbIO implementation
 *	for GelCall.
 */
public class CFGenKbRamGelCallTable
	implements ICFGenKbGelCallTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGelInstructionPKey,
				CFGenKbGelCallBuff > dictByPKey
		= new HashMap< CFGenKbGelInstructionPKey,
				CFGenKbGelCallBuff >();
	private Map< CFGenKbGelCallByCacheIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelCallBuff >> dictByCacheIdx
		= new HashMap< CFGenKbGelCallByCacheIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelCallBuff >>();
	private Map< CFGenKbGelCallBySeqIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelCallBuff >> dictBySeqIdx
		= new HashMap< CFGenKbGelCallBySeqIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelCallBuff >>();
	private Map< CFGenKbGelCallByCallInstIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelCallBuff >> dictByCallInstIdx
		= new HashMap< CFGenKbGelCallByCallInstIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelCallBuff >>();
	private Map< CFGenKbGelCallByPrevInstIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelCallBuff >> dictByPrevInstIdx
		= new HashMap< CFGenKbGelCallByPrevInstIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelCallBuff >>();
	private Map< CFGenKbGelCallByNextInstIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelCallBuff >> dictByNextInstIdx
		= new HashMap< CFGenKbGelCallByNextInstIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelCallBuff >>();

	public CFGenKbRamGelCallTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGelCall( CFGenKbAuthorization Authorization,
		CFGenKbGelCallBuff Buff )
	{
		final String S_ProcName = "createGelCall";
		schema.getTableGelInstruction().createGelInstruction( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelCallByCacheIdxKey keyCacheIdx = schema.getFactoryGelCall().newCacheIdxKey();
		keyCacheIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyCacheIdx.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );

		CFGenKbGelCallBySeqIdxKey keySeqIdx = schema.getFactoryGelCall().newSeqIdxKey();
		keySeqIdx.setOptionalSeqInstTenantId( Buff.getOptionalSeqInstTenantId() );
		keySeqIdx.setOptionalSeqInstGelCacheId( Buff.getOptionalSeqInstGelCacheId() );
		keySeqIdx.setOptionalSeqInstId( Buff.getOptionalSeqInstId() );

		CFGenKbGelCallByCallInstIdxKey keyCallInstIdx = schema.getFactoryGelCall().newCallInstIdxKey();
		keyCallInstIdx.setOptionalCallInstTenantId( Buff.getOptionalCallInstTenantId() );
		keyCallInstIdx.setOptionalCallInstGelCacheId( Buff.getOptionalCallInstGelCacheId() );
		keyCallInstIdx.setOptionalCallInstId( Buff.getOptionalCallInstId() );

		CFGenKbGelCallByPrevInstIdxKey keyPrevInstIdx = schema.getFactoryGelCall().newPrevInstIdxKey();
		keyPrevInstIdx.setOptionalPrevInstTenantId( Buff.getOptionalPrevInstTenantId() );
		keyPrevInstIdx.setOptionalPrevInstGelCacheId( Buff.getOptionalPrevInstGelCacheId() );
		keyPrevInstIdx.setOptionalPrevInstGelInstId( Buff.getOptionalPrevInstGelInstId() );

		CFGenKbGelCallByNextInstIdxKey keyNextInstIdx = schema.getFactoryGelCall().newNextInstIdxKey();
		keyNextInstIdx.setOptionalNextInstTenantId( Buff.getOptionalNextInstTenantId() );
		keyNextInstIdx.setOptionalNextInstGelCacheId( Buff.getOptionalNextInstGelCacheId() );
		keyNextInstIdx.setOptionalNextInstGelInstId( Buff.getOptionalNextInstGelInstId() );

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

		Map< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff > subdictCacheIdx;
		if( dictByCacheIdx.containsKey( keyCacheIdx ) ) {
			subdictCacheIdx = dictByCacheIdx.get( keyCacheIdx );
		}
		else {
			subdictCacheIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff >();
			dictByCacheIdx.put( keyCacheIdx, subdictCacheIdx );
		}
		subdictCacheIdx.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff > subdictSeqIdx;
		if( dictBySeqIdx.containsKey( keySeqIdx ) ) {
			subdictSeqIdx = dictBySeqIdx.get( keySeqIdx );
		}
		else {
			subdictSeqIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff >();
			dictBySeqIdx.put( keySeqIdx, subdictSeqIdx );
		}
		subdictSeqIdx.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff > subdictCallInstIdx;
		if( dictByCallInstIdx.containsKey( keyCallInstIdx ) ) {
			subdictCallInstIdx = dictByCallInstIdx.get( keyCallInstIdx );
		}
		else {
			subdictCallInstIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff >();
			dictByCallInstIdx.put( keyCallInstIdx, subdictCallInstIdx );
		}
		subdictCallInstIdx.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff > subdictPrevInstIdx;
		if( dictByPrevInstIdx.containsKey( keyPrevInstIdx ) ) {
			subdictPrevInstIdx = dictByPrevInstIdx.get( keyPrevInstIdx );
		}
		else {
			subdictPrevInstIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff >();
			dictByPrevInstIdx.put( keyPrevInstIdx, subdictPrevInstIdx );
		}
		subdictPrevInstIdx.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff > subdictNextInstIdx;
		if( dictByNextInstIdx.containsKey( keyNextInstIdx ) ) {
			subdictNextInstIdx = dictByNextInstIdx.get( keyNextInstIdx );
		}
		else {
			subdictNextInstIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff >();
			dictByNextInstIdx.put( keyNextInstIdx, subdictNextInstIdx );
		}
		subdictNextInstIdx.put( pkey, Buff );

	}

	public CFGenKbGelCallBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelCall.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelCallBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelCallBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelCall.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelCallBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelCallBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGelCall.readAllDerived";
		CFGenKbGelCallBuff[] retList = new CFGenKbGelCallBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGelCallBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGelCallBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelCallBuff> filteredList = new ArrayList<CFGenKbGelCallBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelCallBuff ) ) {
					filteredList.add( (CFGenKbGelCallBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelCallBuff[0] ) );
		}
	}

	public CFGenKbGelCallBuff[] readDerivedByGelCacheIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelCallBuff> filteredList = new ArrayList<CFGenKbGelCallBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelCallBuff ) ) {
					filteredList.add( (CFGenKbGelCallBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelCallBuff[0] ) );
		}
	}

	public CFGenKbGelCallBuff[] readDerivedByChainIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelCallBuff> filteredList = new ArrayList<CFGenKbGelCallBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelCallBuff ) ) {
					filteredList.add( (CFGenKbGelCallBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelCallBuff[0] ) );
		}
	}

	public CFGenKbGelCallBuff[] readDerivedByCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelCall.readDerivedByCacheIdx";
		CFGenKbGelCallByCacheIdxKey key = schema.getFactoryGelCall().newCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );

		CFGenKbGelCallBuff[] recArray;
		if( dictByCacheIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff > subdictCacheIdx
				= dictByCacheIdx.get( key );
			recArray = new CFGenKbGelCallBuff[ subdictCacheIdx.size() ];
			Iterator< CFGenKbGelCallBuff > iter = subdictCacheIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff > subdictCacheIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff >();
			dictByCacheIdx.put( key, subdictCacheIdx );
			recArray = new CFGenKbGelCallBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelCallBuff[] readDerivedBySeqIdx( CFGenKbAuthorization Authorization,
		Long SeqInstTenantId,
		Long SeqInstGelCacheId,
		Long SeqInstId )
	{
		final String S_ProcName = "CFGenKbRamGelCall.readDerivedBySeqIdx";
		CFGenKbGelCallBySeqIdxKey key = schema.getFactoryGelCall().newSeqIdxKey();
		key.setOptionalSeqInstTenantId( SeqInstTenantId );
		key.setOptionalSeqInstGelCacheId( SeqInstGelCacheId );
		key.setOptionalSeqInstId( SeqInstId );

		CFGenKbGelCallBuff[] recArray;
		if( dictBySeqIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff > subdictSeqIdx
				= dictBySeqIdx.get( key );
			recArray = new CFGenKbGelCallBuff[ subdictSeqIdx.size() ];
			Iterator< CFGenKbGelCallBuff > iter = subdictSeqIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff > subdictSeqIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff >();
			dictBySeqIdx.put( key, subdictSeqIdx );
			recArray = new CFGenKbGelCallBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelCallBuff[] readDerivedByCallInstIdx( CFGenKbAuthorization Authorization,
		Long CallInstTenantId,
		Long CallInstGelCacheId,
		Long CallInstId )
	{
		final String S_ProcName = "CFGenKbRamGelCall.readDerivedByCallInstIdx";
		CFGenKbGelCallByCallInstIdxKey key = schema.getFactoryGelCall().newCallInstIdxKey();
		key.setOptionalCallInstTenantId( CallInstTenantId );
		key.setOptionalCallInstGelCacheId( CallInstGelCacheId );
		key.setOptionalCallInstId( CallInstId );

		CFGenKbGelCallBuff[] recArray;
		if( dictByCallInstIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff > subdictCallInstIdx
				= dictByCallInstIdx.get( key );
			recArray = new CFGenKbGelCallBuff[ subdictCallInstIdx.size() ];
			Iterator< CFGenKbGelCallBuff > iter = subdictCallInstIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff > subdictCallInstIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff >();
			dictByCallInstIdx.put( key, subdictCallInstIdx );
			recArray = new CFGenKbGelCallBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelCallBuff[] readDerivedByPrevInstIdx( CFGenKbAuthorization Authorization,
		Long PrevInstTenantId,
		Long PrevInstGelCacheId,
		Long PrevInstGelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelCall.readDerivedByPrevInstIdx";
		CFGenKbGelCallByPrevInstIdxKey key = schema.getFactoryGelCall().newPrevInstIdxKey();
		key.setOptionalPrevInstTenantId( PrevInstTenantId );
		key.setOptionalPrevInstGelCacheId( PrevInstGelCacheId );
		key.setOptionalPrevInstGelInstId( PrevInstGelInstId );

		CFGenKbGelCallBuff[] recArray;
		if( dictByPrevInstIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff > subdictPrevInstIdx
				= dictByPrevInstIdx.get( key );
			recArray = new CFGenKbGelCallBuff[ subdictPrevInstIdx.size() ];
			Iterator< CFGenKbGelCallBuff > iter = subdictPrevInstIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff > subdictPrevInstIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff >();
			dictByPrevInstIdx.put( key, subdictPrevInstIdx );
			recArray = new CFGenKbGelCallBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelCallBuff[] readDerivedByNextInstIdx( CFGenKbAuthorization Authorization,
		Long NextInstTenantId,
		Long NextInstGelCacheId,
		Long NextInstGelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelCall.readDerivedByNextInstIdx";
		CFGenKbGelCallByNextInstIdxKey key = schema.getFactoryGelCall().newNextInstIdxKey();
		key.setOptionalNextInstTenantId( NextInstTenantId );
		key.setOptionalNextInstGelCacheId( NextInstGelCacheId );
		key.setOptionalNextInstGelInstId( NextInstGelInstId );

		CFGenKbGelCallBuff[] recArray;
		if( dictByNextInstIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff > subdictNextInstIdx
				= dictByNextInstIdx.get( key );
			recArray = new CFGenKbGelCallBuff[ subdictNextInstIdx.size() ];
			Iterator< CFGenKbGelCallBuff > iter = subdictNextInstIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff > subdictNextInstIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff >();
			dictByNextInstIdx.put( key, subdictNextInstIdx );
			recArray = new CFGenKbGelCallBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelCallBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByPIdx() ";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );

		CFGenKbGelCallBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelCallBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelCall.readBuff";
		CFGenKbGelCallBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GCAL" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelCallBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGelCallBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GCAL" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelCallBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGelCall.readAllBuff";
		CFGenKbGelCallBuff buff;
		ArrayList<CFGenKbGelCallBuff> filteredList = new ArrayList<CFGenKbGelCallBuff>();
		CFGenKbGelCallBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GCAL" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelCallBuff[0] ) );
	}

	public CFGenKbGelCallBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByPIdx() ";
		CFGenKbGelCallBuff buff = readDerivedByPIdx( Authorization,
			TenantId,
			GelCacheId,
			GelInstId );
		if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
			return( (CFGenKbGelCallBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGelCallBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByTenantIdx() ";
		CFGenKbGelCallBuff buff;
		ArrayList<CFGenKbGelCallBuff> filteredList = new ArrayList<CFGenKbGelCallBuff>();
		CFGenKbGelCallBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelCallBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelCallBuff[0] ) );
	}

	public CFGenKbGelCallBuff[] readBuffByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByGelCacheIdx() ";
		CFGenKbGelCallBuff buff;
		ArrayList<CFGenKbGelCallBuff> filteredList = new ArrayList<CFGenKbGelCallBuff>();
		CFGenKbGelCallBuff[] buffList = readDerivedByGelCacheIdx( Authorization,
			TenantId,
			GelCacheId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelCallBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelCallBuff[0] ) );
	}

	public CFGenKbGelCallBuff[] readBuffByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByChainIdx() ";
		CFGenKbGelCallBuff buff;
		ArrayList<CFGenKbGelCallBuff> filteredList = new ArrayList<CFGenKbGelCallBuff>();
		CFGenKbGelCallBuff[] buffList = readDerivedByChainIdx( Authorization,
			ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelCallBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelCallBuff[0] ) );
	}

	public CFGenKbGelCallBuff[] readBuffByCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelCall.readBuffByCacheIdx() ";
		CFGenKbGelCallBuff buff;
		ArrayList<CFGenKbGelCallBuff> filteredList = new ArrayList<CFGenKbGelCallBuff>();
		CFGenKbGelCallBuff[] buffList = readDerivedByCacheIdx( Authorization,
			TenantId,
			GelCacheId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GCAL" ) ) {
				filteredList.add( (CFGenKbGelCallBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelCallBuff[0] ) );
	}

	public CFGenKbGelCallBuff[] readBuffBySeqIdx( CFGenKbAuthorization Authorization,
		Long SeqInstTenantId,
		Long SeqInstGelCacheId,
		Long SeqInstId )
	{
		final String S_ProcName = "CFGenKbRamGelCall.readBuffBySeqIdx() ";
		CFGenKbGelCallBuff buff;
		ArrayList<CFGenKbGelCallBuff> filteredList = new ArrayList<CFGenKbGelCallBuff>();
		CFGenKbGelCallBuff[] buffList = readDerivedBySeqIdx( Authorization,
			SeqInstTenantId,
			SeqInstGelCacheId,
			SeqInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GCAL" ) ) {
				filteredList.add( (CFGenKbGelCallBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelCallBuff[0] ) );
	}

	public CFGenKbGelCallBuff[] readBuffByCallInstIdx( CFGenKbAuthorization Authorization,
		Long CallInstTenantId,
		Long CallInstGelCacheId,
		Long CallInstId )
	{
		final String S_ProcName = "CFGenKbRamGelCall.readBuffByCallInstIdx() ";
		CFGenKbGelCallBuff buff;
		ArrayList<CFGenKbGelCallBuff> filteredList = new ArrayList<CFGenKbGelCallBuff>();
		CFGenKbGelCallBuff[] buffList = readDerivedByCallInstIdx( Authorization,
			CallInstTenantId,
			CallInstGelCacheId,
			CallInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GCAL" ) ) {
				filteredList.add( (CFGenKbGelCallBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelCallBuff[0] ) );
	}

	public CFGenKbGelCallBuff[] readBuffByPrevInstIdx( CFGenKbAuthorization Authorization,
		Long PrevInstTenantId,
		Long PrevInstGelCacheId,
		Long PrevInstGelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelCall.readBuffByPrevInstIdx() ";
		CFGenKbGelCallBuff buff;
		ArrayList<CFGenKbGelCallBuff> filteredList = new ArrayList<CFGenKbGelCallBuff>();
		CFGenKbGelCallBuff[] buffList = readDerivedByPrevInstIdx( Authorization,
			PrevInstTenantId,
			PrevInstGelCacheId,
			PrevInstGelInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GCAL" ) ) {
				filteredList.add( (CFGenKbGelCallBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelCallBuff[0] ) );
	}

	public CFGenKbGelCallBuff[] readBuffByNextInstIdx( CFGenKbAuthorization Authorization,
		Long NextInstTenantId,
		Long NextInstGelCacheId,
		Long NextInstGelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelCall.readBuffByNextInstIdx() ";
		CFGenKbGelCallBuff buff;
		ArrayList<CFGenKbGelCallBuff> filteredList = new ArrayList<CFGenKbGelCallBuff>();
		CFGenKbGelCallBuff[] buffList = readDerivedByNextInstIdx( Authorization,
			NextInstTenantId,
			NextInstGelCacheId,
			NextInstGelInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GCAL" ) ) {
				filteredList.add( (CFGenKbGelCallBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelCallBuff[0] ) );
	}

	/**
	 *	Read a page array of the specific GelCall buffer instances identified by the duplicate key CacheIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelCallBuff[] pageBuffByCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByCacheIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GelCall buffer instances identified by the duplicate key SeqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSeqInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argSeqInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argSeqInstId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelCallBuff[] pageBuffBySeqIdx( CFGenKbAuthorization Authorization,
		Long SeqInstTenantId,
		Long SeqInstGelCacheId,
		Long SeqInstId,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffBySeqIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GelCall buffer instances identified by the duplicate key CallInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argCallInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argCallInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argCallInstId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelCallBuff[] pageBuffByCallInstIdx( CFGenKbAuthorization Authorization,
		Long CallInstTenantId,
		Long CallInstGelCacheId,
		Long CallInstId,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByCallInstIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GelCall buffer instances identified by the duplicate key PrevInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argPrevInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argPrevInstGelInstId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelCallBuff[] pageBuffByPrevInstIdx( CFGenKbAuthorization Authorization,
		Long PrevInstTenantId,
		Long PrevInstGelCacheId,
		Long PrevInstGelInstId,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByPrevInstIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GelCall buffer instances identified by the duplicate key NextInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextInstTenantId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argNextInstGelCacheId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@param	argNextInstGelInstId	The GelCall key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelCallBuff[] pageBuffByNextInstIdx( CFGenKbAuthorization Authorization,
		Long NextInstTenantId,
		Long NextInstGelCacheId,
		Long NextInstGelInstId,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByNextInstIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateGelCall( CFGenKbAuthorization Authorization,
		CFGenKbGelCallBuff Buff )
	{
		schema.getTableGelInstruction().updateGelInstruction( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelCallBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGelCall",
				"Existing record not found",
				"GelCall",
				pkey );
		}
		CFGenKbGelCallByCacheIdxKey existingKeyCacheIdx = schema.getFactoryGelCall().newCacheIdxKey();
		existingKeyCacheIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyCacheIdx.setRequiredGelCacheId( existing.getRequiredGelCacheId() );

		CFGenKbGelCallByCacheIdxKey newKeyCacheIdx = schema.getFactoryGelCall().newCacheIdxKey();
		newKeyCacheIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyCacheIdx.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );

		CFGenKbGelCallBySeqIdxKey existingKeySeqIdx = schema.getFactoryGelCall().newSeqIdxKey();
		existingKeySeqIdx.setOptionalSeqInstTenantId( existing.getOptionalSeqInstTenantId() );
		existingKeySeqIdx.setOptionalSeqInstGelCacheId( existing.getOptionalSeqInstGelCacheId() );
		existingKeySeqIdx.setOptionalSeqInstId( existing.getOptionalSeqInstId() );

		CFGenKbGelCallBySeqIdxKey newKeySeqIdx = schema.getFactoryGelCall().newSeqIdxKey();
		newKeySeqIdx.setOptionalSeqInstTenantId( Buff.getOptionalSeqInstTenantId() );
		newKeySeqIdx.setOptionalSeqInstGelCacheId( Buff.getOptionalSeqInstGelCacheId() );
		newKeySeqIdx.setOptionalSeqInstId( Buff.getOptionalSeqInstId() );

		CFGenKbGelCallByCallInstIdxKey existingKeyCallInstIdx = schema.getFactoryGelCall().newCallInstIdxKey();
		existingKeyCallInstIdx.setOptionalCallInstTenantId( existing.getOptionalCallInstTenantId() );
		existingKeyCallInstIdx.setOptionalCallInstGelCacheId( existing.getOptionalCallInstGelCacheId() );
		existingKeyCallInstIdx.setOptionalCallInstId( existing.getOptionalCallInstId() );

		CFGenKbGelCallByCallInstIdxKey newKeyCallInstIdx = schema.getFactoryGelCall().newCallInstIdxKey();
		newKeyCallInstIdx.setOptionalCallInstTenantId( Buff.getOptionalCallInstTenantId() );
		newKeyCallInstIdx.setOptionalCallInstGelCacheId( Buff.getOptionalCallInstGelCacheId() );
		newKeyCallInstIdx.setOptionalCallInstId( Buff.getOptionalCallInstId() );

		CFGenKbGelCallByPrevInstIdxKey existingKeyPrevInstIdx = schema.getFactoryGelCall().newPrevInstIdxKey();
		existingKeyPrevInstIdx.setOptionalPrevInstTenantId( existing.getOptionalPrevInstTenantId() );
		existingKeyPrevInstIdx.setOptionalPrevInstGelCacheId( existing.getOptionalPrevInstGelCacheId() );
		existingKeyPrevInstIdx.setOptionalPrevInstGelInstId( existing.getOptionalPrevInstGelInstId() );

		CFGenKbGelCallByPrevInstIdxKey newKeyPrevInstIdx = schema.getFactoryGelCall().newPrevInstIdxKey();
		newKeyPrevInstIdx.setOptionalPrevInstTenantId( Buff.getOptionalPrevInstTenantId() );
		newKeyPrevInstIdx.setOptionalPrevInstGelCacheId( Buff.getOptionalPrevInstGelCacheId() );
		newKeyPrevInstIdx.setOptionalPrevInstGelInstId( Buff.getOptionalPrevInstGelInstId() );

		CFGenKbGelCallByNextInstIdxKey existingKeyNextInstIdx = schema.getFactoryGelCall().newNextInstIdxKey();
		existingKeyNextInstIdx.setOptionalNextInstTenantId( existing.getOptionalNextInstTenantId() );
		existingKeyNextInstIdx.setOptionalNextInstGelCacheId( existing.getOptionalNextInstGelCacheId() );
		existingKeyNextInstIdx.setOptionalNextInstGelInstId( existing.getOptionalNextInstGelInstId() );

		CFGenKbGelCallByNextInstIdxKey newKeyNextInstIdx = schema.getFactoryGelCall().newNextInstIdxKey();
		newKeyNextInstIdx.setOptionalNextInstTenantId( Buff.getOptionalNextInstTenantId() );
		newKeyNextInstIdx.setOptionalNextInstGelCacheId( Buff.getOptionalNextInstGelCacheId() );
		newKeyNextInstIdx.setOptionalNextInstGelInstId( Buff.getOptionalNextInstGelInstId() );

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
						"updateGelCall",
						"Superclass",
						"SuperClass",
						"GelInstruction",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByCacheIdx.get( existingKeyCacheIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByCacheIdx.containsKey( newKeyCacheIdx ) ) {
			subdict = dictByCacheIdx.get( newKeyCacheIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff >();
			dictByCacheIdx.put( newKeyCacheIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictBySeqIdx.get( existingKeySeqIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySeqIdx.containsKey( newKeySeqIdx ) ) {
			subdict = dictBySeqIdx.get( newKeySeqIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff >();
			dictBySeqIdx.put( newKeySeqIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByCallInstIdx.get( existingKeyCallInstIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByCallInstIdx.containsKey( newKeyCallInstIdx ) ) {
			subdict = dictByCallInstIdx.get( newKeyCallInstIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff >();
			dictByCallInstIdx.put( newKeyCallInstIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByPrevInstIdx.get( existingKeyPrevInstIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByPrevInstIdx.containsKey( newKeyPrevInstIdx ) ) {
			subdict = dictByPrevInstIdx.get( newKeyPrevInstIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff >();
			dictByPrevInstIdx.put( newKeyPrevInstIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByNextInstIdx.get( existingKeyNextInstIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByNextInstIdx.containsKey( newKeyNextInstIdx ) ) {
			subdict = dictByNextInstIdx.get( newKeyNextInstIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff >();
			dictByNextInstIdx.put( newKeyNextInstIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteGelCall( CFGenKbAuthorization Authorization,
		CFGenKbGelCallBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGelCallTable.deleteGelCall() ";
		String classCode;
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelCallBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGelCall",
				pkey );
		}
		CFGenKbGelCallByCacheIdxKey keyCacheIdx = schema.getFactoryGelCall().newCacheIdxKey();
		keyCacheIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyCacheIdx.setRequiredGelCacheId( existing.getRequiredGelCacheId() );

		CFGenKbGelCallBySeqIdxKey keySeqIdx = schema.getFactoryGelCall().newSeqIdxKey();
		keySeqIdx.setOptionalSeqInstTenantId( existing.getOptionalSeqInstTenantId() );
		keySeqIdx.setOptionalSeqInstGelCacheId( existing.getOptionalSeqInstGelCacheId() );
		keySeqIdx.setOptionalSeqInstId( existing.getOptionalSeqInstId() );

		CFGenKbGelCallByCallInstIdxKey keyCallInstIdx = schema.getFactoryGelCall().newCallInstIdxKey();
		keyCallInstIdx.setOptionalCallInstTenantId( existing.getOptionalCallInstTenantId() );
		keyCallInstIdx.setOptionalCallInstGelCacheId( existing.getOptionalCallInstGelCacheId() );
		keyCallInstIdx.setOptionalCallInstId( existing.getOptionalCallInstId() );

		CFGenKbGelCallByPrevInstIdxKey keyPrevInstIdx = schema.getFactoryGelCall().newPrevInstIdxKey();
		keyPrevInstIdx.setOptionalPrevInstTenantId( existing.getOptionalPrevInstTenantId() );
		keyPrevInstIdx.setOptionalPrevInstGelCacheId( existing.getOptionalPrevInstGelCacheId() );
		keyPrevInstIdx.setOptionalPrevInstGelInstId( existing.getOptionalPrevInstGelInstId() );

		CFGenKbGelCallByNextInstIdxKey keyNextInstIdx = schema.getFactoryGelCall().newNextInstIdxKey();
		keyNextInstIdx.setOptionalNextInstTenantId( existing.getOptionalNextInstTenantId() );
		keyNextInstIdx.setOptionalNextInstGelCacheId( existing.getOptionalNextInstGelCacheId() );
		keyNextInstIdx.setOptionalNextInstGelInstId( existing.getOptionalNextInstGelInstId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbGelInstructionPKey, CFGenKbGelCallBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByCacheIdx.get( keyCacheIdx );
		subdict.remove( pkey );

		subdict = dictBySeqIdx.get( keySeqIdx );
		subdict.remove( pkey );

		subdict = dictByCallInstIdx.get( keyCallInstIdx );
		subdict.remove( pkey );

		subdict = dictByPrevInstIdx.get( keyPrevInstIdx );
		subdict.remove( pkey );

		subdict = dictByNextInstIdx.get( keyNextInstIdx );
		subdict.remove( pkey );

		schema.getTableGelInstruction().deleteGelInstruction( Authorization,
			Buff );
	}
	public void deleteGelCallByCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId )
	{
		CFGenKbGelCallByCacheIdxKey key = schema.getFactoryGelCall().newCacheIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		deleteGelCallByCacheIdx( Authorization, key );
	}

	public void deleteGelCallByCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelCallByCacheIdxKey argKey )
	{
		CFGenKbGelCallBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelCallBuff> matchSet = new LinkedList<CFGenKbGelCallBuff>();
		Iterator<CFGenKbGelCallBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelCallBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelCall().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelCall( Authorization, cur );
		}
	}

	public void deleteGelCallBySeqIdx( CFGenKbAuthorization Authorization,
		Long argSeqInstTenantId,
		Long argSeqInstGelCacheId,
		Long argSeqInstId )
	{
		CFGenKbGelCallBySeqIdxKey key = schema.getFactoryGelCall().newSeqIdxKey();
		key.setOptionalSeqInstTenantId( argSeqInstTenantId );
		key.setOptionalSeqInstGelCacheId( argSeqInstGelCacheId );
		key.setOptionalSeqInstId( argSeqInstId );
		deleteGelCallBySeqIdx( Authorization, key );
	}

	public void deleteGelCallBySeqIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelCallBySeqIdxKey argKey )
	{
		CFGenKbGelCallBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalSeqInstTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalSeqInstGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalSeqInstId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelCallBuff> matchSet = new LinkedList<CFGenKbGelCallBuff>();
		Iterator<CFGenKbGelCallBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelCallBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelCall().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelCall( Authorization, cur );
		}
	}

	public void deleteGelCallByCallInstIdx( CFGenKbAuthorization Authorization,
		Long argCallInstTenantId,
		Long argCallInstGelCacheId,
		Long argCallInstId )
	{
		CFGenKbGelCallByCallInstIdxKey key = schema.getFactoryGelCall().newCallInstIdxKey();
		key.setOptionalCallInstTenantId( argCallInstTenantId );
		key.setOptionalCallInstGelCacheId( argCallInstGelCacheId );
		key.setOptionalCallInstId( argCallInstId );
		deleteGelCallByCallInstIdx( Authorization, key );
	}

	public void deleteGelCallByCallInstIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelCallByCallInstIdxKey argKey )
	{
		CFGenKbGelCallBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalCallInstTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalCallInstGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalCallInstId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelCallBuff> matchSet = new LinkedList<CFGenKbGelCallBuff>();
		Iterator<CFGenKbGelCallBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelCallBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelCall().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelCall( Authorization, cur );
		}
	}

	public void deleteGelCallByPrevInstIdx( CFGenKbAuthorization Authorization,
		Long argPrevInstTenantId,
		Long argPrevInstGelCacheId,
		Long argPrevInstGelInstId )
	{
		CFGenKbGelCallByPrevInstIdxKey key = schema.getFactoryGelCall().newPrevInstIdxKey();
		key.setOptionalPrevInstTenantId( argPrevInstTenantId );
		key.setOptionalPrevInstGelCacheId( argPrevInstGelCacheId );
		key.setOptionalPrevInstGelInstId( argPrevInstGelInstId );
		deleteGelCallByPrevInstIdx( Authorization, key );
	}

	public void deleteGelCallByPrevInstIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelCallByPrevInstIdxKey argKey )
	{
		CFGenKbGelCallBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalPrevInstTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalPrevInstGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalPrevInstGelInstId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelCallBuff> matchSet = new LinkedList<CFGenKbGelCallBuff>();
		Iterator<CFGenKbGelCallBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelCallBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelCall().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelCall( Authorization, cur );
		}
	}

	public void deleteGelCallByNextInstIdx( CFGenKbAuthorization Authorization,
		Long argNextInstTenantId,
		Long argNextInstGelCacheId,
		Long argNextInstGelInstId )
	{
		CFGenKbGelCallByNextInstIdxKey key = schema.getFactoryGelCall().newNextInstIdxKey();
		key.setOptionalNextInstTenantId( argNextInstTenantId );
		key.setOptionalNextInstGelCacheId( argNextInstGelCacheId );
		key.setOptionalNextInstGelInstId( argNextInstGelInstId );
		deleteGelCallByNextInstIdx( Authorization, key );
	}

	public void deleteGelCallByNextInstIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelCallByNextInstIdxKey argKey )
	{
		CFGenKbGelCallBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalNextInstTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalNextInstGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalNextInstGelInstId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelCallBuff> matchSet = new LinkedList<CFGenKbGelCallBuff>();
		Iterator<CFGenKbGelCallBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelCallBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelCall().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelCall( Authorization, cur );
		}
	}

	public void deleteGelCallByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId )
	{
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		key.setRequiredGelInstId( argGelInstId );
		deleteGelCallByPIdx( Authorization, key );
	}

	public void deleteGelCallByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGelCallBuff cur;
		LinkedList<CFGenKbGelCallBuff> matchSet = new LinkedList<CFGenKbGelCallBuff>();
		Iterator<CFGenKbGelCallBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelCallBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelCall().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelCall( Authorization, cur );
		}
	}

	public void deleteGelCallByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGelInstructionByTenantIdxKey key = schema.getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGelCallByTenantIdx( Authorization, key );
	}

	public void deleteGelCallByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByTenantIdxKey argKey )
	{
		CFGenKbGelCallBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelCallBuff> matchSet = new LinkedList<CFGenKbGelCallBuff>();
		Iterator<CFGenKbGelCallBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelCallBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelCall().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelCall( Authorization, cur );
		}
	}

	public void deleteGelCallByGelCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId )
	{
		CFGenKbGelInstructionByGelCacheIdxKey key = schema.getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		deleteGelCallByGelCacheIdx( Authorization, key );
	}

	public void deleteGelCallByGelCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByGelCacheIdxKey argKey )
	{
		CFGenKbGelCallBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelCallBuff> matchSet = new LinkedList<CFGenKbGelCallBuff>();
		Iterator<CFGenKbGelCallBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelCallBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelCall().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelCall( Authorization, cur );
		}
	}

	public void deleteGelCallByChainIdx( CFGenKbAuthorization Authorization,
		Long argChainInstTenantId,
		Long argChainInstGelCacheId,
		Long argChainInstGelInstId )
	{
		CFGenKbGelInstructionByChainIdxKey key = schema.getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( argChainInstTenantId );
		key.setOptionalChainInstGelCacheId( argChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( argChainInstGelInstId );
		deleteGelCallByChainIdx( Authorization, key );
	}

	public void deleteGelCallByChainIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByChainIdxKey argKey )
	{
		CFGenKbGelCallBuff cur;
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
		LinkedList<CFGenKbGelCallBuff> matchSet = new LinkedList<CFGenKbGelCallBuff>();
		Iterator<CFGenKbGelCallBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelCallBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelCall().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelCall( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
