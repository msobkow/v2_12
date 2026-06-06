
// Description: Java 11 in-memory RAM DbIO implementation for GelSequence.

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
 *	CFGenKbRamGelSequenceTable in-memory RAM DbIO implementation
 *	for GelSequence.
 */
public class CFGenKbRamGelSequenceTable
	implements ICFGenKbGelSequenceTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGelInstructionPKey,
				CFGenKbGelSequenceBuff > dictByPKey
		= new HashMap< CFGenKbGelInstructionPKey,
				CFGenKbGelSequenceBuff >();
	private Map< CFGenKbGelSequenceByFirstInstIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelSequenceBuff >> dictByFirstInstIdx
		= new HashMap< CFGenKbGelSequenceByFirstInstIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelSequenceBuff >>();
	private Map< CFGenKbGelSequenceByLastInstIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelSequenceBuff >> dictByLastInstIdx
		= new HashMap< CFGenKbGelSequenceByLastInstIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelSequenceBuff >>();

	public CFGenKbRamGelSequenceTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGelSequence( CFGenKbAuthorization Authorization,
		CFGenKbGelSequenceBuff Buff )
	{
		final String S_ProcName = "createGelSequence";
		schema.getTableGelInstruction().createGelInstruction( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelSequenceByFirstInstIdxKey keyFirstInstIdx = schema.getFactoryGelSequence().newFirstInstIdxKey();
		keyFirstInstIdx.setOptionalFirstInstTenantId( Buff.getOptionalFirstInstTenantId() );
		keyFirstInstIdx.setOptionalFirstInstGelCacheId( Buff.getOptionalFirstInstGelCacheId() );
		keyFirstInstIdx.setOptionalFirstInstId( Buff.getOptionalFirstInstId() );

		CFGenKbGelSequenceByLastInstIdxKey keyLastInstIdx = schema.getFactoryGelSequence().newLastInstIdxKey();
		keyLastInstIdx.setOptionalLastInstTenantId( Buff.getOptionalLastInstTenantId() );
		keyLastInstIdx.setOptionalLastInstGelCacheId( Buff.getOptionalLastInstGelCacheId() );
		keyLastInstIdx.setOptionalLastInstId( Buff.getOptionalLastInstId() );

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

		Map< CFGenKbGelInstructionPKey, CFGenKbGelSequenceBuff > subdictFirstInstIdx;
		if( dictByFirstInstIdx.containsKey( keyFirstInstIdx ) ) {
			subdictFirstInstIdx = dictByFirstInstIdx.get( keyFirstInstIdx );
		}
		else {
			subdictFirstInstIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSequenceBuff >();
			dictByFirstInstIdx.put( keyFirstInstIdx, subdictFirstInstIdx );
		}
		subdictFirstInstIdx.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelSequenceBuff > subdictLastInstIdx;
		if( dictByLastInstIdx.containsKey( keyLastInstIdx ) ) {
			subdictLastInstIdx = dictByLastInstIdx.get( keyLastInstIdx );
		}
		else {
			subdictLastInstIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSequenceBuff >();
			dictByLastInstIdx.put( keyLastInstIdx, subdictLastInstIdx );
		}
		subdictLastInstIdx.put( pkey, Buff );

	}

	public CFGenKbGelSequenceBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelSequence.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelSequenceBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSequenceBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelSequence.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelSequenceBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSequenceBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGelSequence.readAllDerived";
		CFGenKbGelSequenceBuff[] retList = new CFGenKbGelSequenceBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGelSequenceBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGelSequenceBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelSequenceBuff> filteredList = new ArrayList<CFGenKbGelSequenceBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelSequenceBuff ) ) {
					filteredList.add( (CFGenKbGelSequenceBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelSequenceBuff[0] ) );
		}
	}

	public CFGenKbGelSequenceBuff[] readDerivedByGelCacheIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelSequenceBuff> filteredList = new ArrayList<CFGenKbGelSequenceBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelSequenceBuff ) ) {
					filteredList.add( (CFGenKbGelSequenceBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelSequenceBuff[0] ) );
		}
	}

	public CFGenKbGelSequenceBuff[] readDerivedByChainIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelSequenceBuff> filteredList = new ArrayList<CFGenKbGelSequenceBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelSequenceBuff ) ) {
					filteredList.add( (CFGenKbGelSequenceBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelSequenceBuff[0] ) );
		}
	}

	public CFGenKbGelSequenceBuff[] readDerivedByFirstInstIdx( CFGenKbAuthorization Authorization,
		Long FirstInstTenantId,
		Long FirstInstGelCacheId,
		Long FirstInstId )
	{
		final String S_ProcName = "CFGenKbRamGelSequence.readDerivedByFirstInstIdx";
		CFGenKbGelSequenceByFirstInstIdxKey key = schema.getFactoryGelSequence().newFirstInstIdxKey();
		key.setOptionalFirstInstTenantId( FirstInstTenantId );
		key.setOptionalFirstInstGelCacheId( FirstInstGelCacheId );
		key.setOptionalFirstInstId( FirstInstId );

		CFGenKbGelSequenceBuff[] recArray;
		if( dictByFirstInstIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelSequenceBuff > subdictFirstInstIdx
				= dictByFirstInstIdx.get( key );
			recArray = new CFGenKbGelSequenceBuff[ subdictFirstInstIdx.size() ];
			Iterator< CFGenKbGelSequenceBuff > iter = subdictFirstInstIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelSequenceBuff > subdictFirstInstIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSequenceBuff >();
			dictByFirstInstIdx.put( key, subdictFirstInstIdx );
			recArray = new CFGenKbGelSequenceBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelSequenceBuff[] readDerivedByLastInstIdx( CFGenKbAuthorization Authorization,
		Long LastInstTenantId,
		Long LastInstGelCacheId,
		Long LastInstId )
	{
		final String S_ProcName = "CFGenKbRamGelSequence.readDerivedByLastInstIdx";
		CFGenKbGelSequenceByLastInstIdxKey key = schema.getFactoryGelSequence().newLastInstIdxKey();
		key.setOptionalLastInstTenantId( LastInstTenantId );
		key.setOptionalLastInstGelCacheId( LastInstGelCacheId );
		key.setOptionalLastInstId( LastInstId );

		CFGenKbGelSequenceBuff[] recArray;
		if( dictByLastInstIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelSequenceBuff > subdictLastInstIdx
				= dictByLastInstIdx.get( key );
			recArray = new CFGenKbGelSequenceBuff[ subdictLastInstIdx.size() ];
			Iterator< CFGenKbGelSequenceBuff > iter = subdictLastInstIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelSequenceBuff > subdictLastInstIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSequenceBuff >();
			dictByLastInstIdx.put( key, subdictLastInstIdx );
			recArray = new CFGenKbGelSequenceBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelSequenceBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByPIdx() ";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );

		CFGenKbGelSequenceBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSequenceBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelSequence.readBuff";
		CFGenKbGelSequenceBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GSEQ" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSequenceBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGelSequenceBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GSEQ" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSequenceBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGelSequence.readAllBuff";
		CFGenKbGelSequenceBuff buff;
		ArrayList<CFGenKbGelSequenceBuff> filteredList = new ArrayList<CFGenKbGelSequenceBuff>();
		CFGenKbGelSequenceBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GSEQ" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSequenceBuff[0] ) );
	}

	public CFGenKbGelSequenceBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByPIdx() ";
		CFGenKbGelSequenceBuff buff = readDerivedByPIdx( Authorization,
			TenantId,
			GelCacheId,
			GelInstId );
		if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
			return( (CFGenKbGelSequenceBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGelSequenceBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByTenantIdx() ";
		CFGenKbGelSequenceBuff buff;
		ArrayList<CFGenKbGelSequenceBuff> filteredList = new ArrayList<CFGenKbGelSequenceBuff>();
		CFGenKbGelSequenceBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelSequenceBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSequenceBuff[0] ) );
	}

	public CFGenKbGelSequenceBuff[] readBuffByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByGelCacheIdx() ";
		CFGenKbGelSequenceBuff buff;
		ArrayList<CFGenKbGelSequenceBuff> filteredList = new ArrayList<CFGenKbGelSequenceBuff>();
		CFGenKbGelSequenceBuff[] buffList = readDerivedByGelCacheIdx( Authorization,
			TenantId,
			GelCacheId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelSequenceBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSequenceBuff[0] ) );
	}

	public CFGenKbGelSequenceBuff[] readBuffByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByChainIdx() ";
		CFGenKbGelSequenceBuff buff;
		ArrayList<CFGenKbGelSequenceBuff> filteredList = new ArrayList<CFGenKbGelSequenceBuff>();
		CFGenKbGelSequenceBuff[] buffList = readDerivedByChainIdx( Authorization,
			ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelSequenceBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSequenceBuff[0] ) );
	}

	public CFGenKbGelSequenceBuff[] readBuffByFirstInstIdx( CFGenKbAuthorization Authorization,
		Long FirstInstTenantId,
		Long FirstInstGelCacheId,
		Long FirstInstId )
	{
		final String S_ProcName = "CFGenKbRamGelSequence.readBuffByFirstInstIdx() ";
		CFGenKbGelSequenceBuff buff;
		ArrayList<CFGenKbGelSequenceBuff> filteredList = new ArrayList<CFGenKbGelSequenceBuff>();
		CFGenKbGelSequenceBuff[] buffList = readDerivedByFirstInstIdx( Authorization,
			FirstInstTenantId,
			FirstInstGelCacheId,
			FirstInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GSEQ" ) ) {
				filteredList.add( (CFGenKbGelSequenceBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSequenceBuff[0] ) );
	}

	public CFGenKbGelSequenceBuff[] readBuffByLastInstIdx( CFGenKbAuthorization Authorization,
		Long LastInstTenantId,
		Long LastInstGelCacheId,
		Long LastInstId )
	{
		final String S_ProcName = "CFGenKbRamGelSequence.readBuffByLastInstIdx() ";
		CFGenKbGelSequenceBuff buff;
		ArrayList<CFGenKbGelSequenceBuff> filteredList = new ArrayList<CFGenKbGelSequenceBuff>();
		CFGenKbGelSequenceBuff[] buffList = readDerivedByLastInstIdx( Authorization,
			LastInstTenantId,
			LastInstGelCacheId,
			LastInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GSEQ" ) ) {
				filteredList.add( (CFGenKbGelSequenceBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSequenceBuff[0] ) );
	}

	/**
	 *	Read a page array of the specific GelSequence buffer instances identified by the duplicate key FirstInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argFirstInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argFirstInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argFirstInstId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelSequenceBuff[] pageBuffByFirstInstIdx( CFGenKbAuthorization Authorization,
		Long FirstInstTenantId,
		Long FirstInstGelCacheId,
		Long FirstInstId,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByFirstInstIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific GelSequence buffer instances identified by the duplicate key LastInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argLastInstTenantId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argLastInstGelCacheId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@param	argLastInstId	The GelSequence key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelSequenceBuff[] pageBuffByLastInstIdx( CFGenKbAuthorization Authorization,
		Long LastInstTenantId,
		Long LastInstGelCacheId,
		Long LastInstId,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByLastInstIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateGelSequence( CFGenKbAuthorization Authorization,
		CFGenKbGelSequenceBuff Buff )
	{
		schema.getTableGelInstruction().updateGelInstruction( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelSequenceBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGelSequence",
				"Existing record not found",
				"GelSequence",
				pkey );
		}
		CFGenKbGelSequenceByFirstInstIdxKey existingKeyFirstInstIdx = schema.getFactoryGelSequence().newFirstInstIdxKey();
		existingKeyFirstInstIdx.setOptionalFirstInstTenantId( existing.getOptionalFirstInstTenantId() );
		existingKeyFirstInstIdx.setOptionalFirstInstGelCacheId( existing.getOptionalFirstInstGelCacheId() );
		existingKeyFirstInstIdx.setOptionalFirstInstId( existing.getOptionalFirstInstId() );

		CFGenKbGelSequenceByFirstInstIdxKey newKeyFirstInstIdx = schema.getFactoryGelSequence().newFirstInstIdxKey();
		newKeyFirstInstIdx.setOptionalFirstInstTenantId( Buff.getOptionalFirstInstTenantId() );
		newKeyFirstInstIdx.setOptionalFirstInstGelCacheId( Buff.getOptionalFirstInstGelCacheId() );
		newKeyFirstInstIdx.setOptionalFirstInstId( Buff.getOptionalFirstInstId() );

		CFGenKbGelSequenceByLastInstIdxKey existingKeyLastInstIdx = schema.getFactoryGelSequence().newLastInstIdxKey();
		existingKeyLastInstIdx.setOptionalLastInstTenantId( existing.getOptionalLastInstTenantId() );
		existingKeyLastInstIdx.setOptionalLastInstGelCacheId( existing.getOptionalLastInstGelCacheId() );
		existingKeyLastInstIdx.setOptionalLastInstId( existing.getOptionalLastInstId() );

		CFGenKbGelSequenceByLastInstIdxKey newKeyLastInstIdx = schema.getFactoryGelSequence().newLastInstIdxKey();
		newKeyLastInstIdx.setOptionalLastInstTenantId( Buff.getOptionalLastInstTenantId() );
		newKeyLastInstIdx.setOptionalLastInstGelCacheId( Buff.getOptionalLastInstGelCacheId() );
		newKeyLastInstIdx.setOptionalLastInstId( Buff.getOptionalLastInstId() );

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
						"updateGelSequence",
						"Superclass",
						"SuperClass",
						"GelInstruction",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGelInstructionPKey, CFGenKbGelSequenceBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByFirstInstIdx.get( existingKeyFirstInstIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByFirstInstIdx.containsKey( newKeyFirstInstIdx ) ) {
			subdict = dictByFirstInstIdx.get( newKeyFirstInstIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSequenceBuff >();
			dictByFirstInstIdx.put( newKeyFirstInstIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByLastInstIdx.get( existingKeyLastInstIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByLastInstIdx.containsKey( newKeyLastInstIdx ) ) {
			subdict = dictByLastInstIdx.get( newKeyLastInstIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelSequenceBuff >();
			dictByLastInstIdx.put( newKeyLastInstIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteGelSequence( CFGenKbAuthorization Authorization,
		CFGenKbGelSequenceBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGelSequenceTable.deleteGelSequence() ";
		String classCode;
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelSequenceBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGelSequence",
				pkey );
		}
		CFGenKbGelSequenceBuff editSubobj = schema.getTableGelSequence().readDerivedByPIdx( Authorization,
			existing.getRequiredTenantId(),
			existing.getRequiredGelCacheId(),
			existing.getRequiredGelInstId() );
			editSubobj.setOptionalFirstInstTenantId( null );
			editSubobj.setOptionalFirstInstGelCacheId( null );
			editSubobj.setOptionalFirstInstId( null );
			editSubobj.setOptionalLastInstTenantId( null );
			editSubobj.setOptionalLastInstGelCacheId( null );
			editSubobj.setOptionalLastInstId( null );
		classCode = editSubobj.getClassCode();
		if( classCode.equals( "GSEQ" ) ) {
			schema.getTableGelSequence().updateGelSequence( Authorization, editSubobj );
		}
		else if( classCode.equals( "GEXE" ) ) {
			schema.getTableGelExecutable().updateGelExecutable( Authorization, (CFGenKbGelExecutableBuff)editSubobj );
		}
		else {
			new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"Unrecognized ClassCode \"" + classCode + "\"" );
		}
		existing = editSubobj;
					schema.getTableGelCall().deleteGelCallBySeqIdx( Authorization,
						existing.getRequiredTenantId(),
						existing.getRequiredGelCacheId(),
						existing.getRequiredGelInstId() );
		CFGenKbGelSequenceByFirstInstIdxKey keyFirstInstIdx = schema.getFactoryGelSequence().newFirstInstIdxKey();
		keyFirstInstIdx.setOptionalFirstInstTenantId( existing.getOptionalFirstInstTenantId() );
		keyFirstInstIdx.setOptionalFirstInstGelCacheId( existing.getOptionalFirstInstGelCacheId() );
		keyFirstInstIdx.setOptionalFirstInstId( existing.getOptionalFirstInstId() );

		CFGenKbGelSequenceByLastInstIdxKey keyLastInstIdx = schema.getFactoryGelSequence().newLastInstIdxKey();
		keyLastInstIdx.setOptionalLastInstTenantId( existing.getOptionalLastInstTenantId() );
		keyLastInstIdx.setOptionalLastInstGelCacheId( existing.getOptionalLastInstGelCacheId() );
		keyLastInstIdx.setOptionalLastInstId( existing.getOptionalLastInstId() );

		// Validate reverse foreign keys

		if( schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredGelCacheId(),
					existing.getRequiredGelInstId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGelSequence",
				"Superclass",
				"SuperClass",
				"GelExecutable",
				pkey );
		}

		// Delete is valid
		Map< CFGenKbGelInstructionPKey, CFGenKbGelSequenceBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByFirstInstIdx.get( keyFirstInstIdx );
		subdict.remove( pkey );

		subdict = dictByLastInstIdx.get( keyLastInstIdx );
		subdict.remove( pkey );

		schema.getTableGelInstruction().deleteGelInstruction( Authorization,
			Buff );
	}
	public void deleteGelSequenceByFirstInstIdx( CFGenKbAuthorization Authorization,
		Long argFirstInstTenantId,
		Long argFirstInstGelCacheId,
		Long argFirstInstId )
	{
		CFGenKbGelSequenceByFirstInstIdxKey key = schema.getFactoryGelSequence().newFirstInstIdxKey();
		key.setOptionalFirstInstTenantId( argFirstInstTenantId );
		key.setOptionalFirstInstGelCacheId( argFirstInstGelCacheId );
		key.setOptionalFirstInstId( argFirstInstId );
		deleteGelSequenceByFirstInstIdx( Authorization, key );
	}

	public void deleteGelSequenceByFirstInstIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSequenceByFirstInstIdxKey argKey )
	{
		final String S_ProcName = "deleteGelSequenceByFirstInstIdx";
		CFGenKbGelSequenceBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalFirstInstTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalFirstInstGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalFirstInstId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelSequenceBuff> matchSet = new LinkedList<CFGenKbGelSequenceBuff>();
		Iterator<CFGenKbGelSequenceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSequenceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSequence().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			String subClassCode = cur.getClassCode();
			if( "GSEQ".equals( subClassCode ) ) {
				schema.getTableGelSequence().deleteGelSequence( Authorization, cur );
			}
			else if( "GEXE".equals( subClassCode ) ) {
				schema.getTableGelExecutable().deleteGelExecutable( Authorization, (CFGenKbGelExecutableBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GelSequence must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGelSequenceByLastInstIdx( CFGenKbAuthorization Authorization,
		Long argLastInstTenantId,
		Long argLastInstGelCacheId,
		Long argLastInstId )
	{
		CFGenKbGelSequenceByLastInstIdxKey key = schema.getFactoryGelSequence().newLastInstIdxKey();
		key.setOptionalLastInstTenantId( argLastInstTenantId );
		key.setOptionalLastInstGelCacheId( argLastInstGelCacheId );
		key.setOptionalLastInstId( argLastInstId );
		deleteGelSequenceByLastInstIdx( Authorization, key );
	}

	public void deleteGelSequenceByLastInstIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSequenceByLastInstIdxKey argKey )
	{
		final String S_ProcName = "deleteGelSequenceByLastInstIdx";
		CFGenKbGelSequenceBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalLastInstTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalLastInstGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalLastInstId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelSequenceBuff> matchSet = new LinkedList<CFGenKbGelSequenceBuff>();
		Iterator<CFGenKbGelSequenceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSequenceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSequence().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			String subClassCode = cur.getClassCode();
			if( "GSEQ".equals( subClassCode ) ) {
				schema.getTableGelSequence().deleteGelSequence( Authorization, cur );
			}
			else if( "GEXE".equals( subClassCode ) ) {
				schema.getTableGelExecutable().deleteGelExecutable( Authorization, (CFGenKbGelExecutableBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GelSequence must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGelSequenceByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId )
	{
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		key.setRequiredGelInstId( argGelInstId );
		deleteGelSequenceByPIdx( Authorization, key );
	}

	public void deleteGelSequenceByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey argKey )
	{
		final String S_ProcName = "deleteGelSequenceByPIdx";
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGelSequenceBuff cur;
		LinkedList<CFGenKbGelSequenceBuff> matchSet = new LinkedList<CFGenKbGelSequenceBuff>();
		Iterator<CFGenKbGelSequenceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSequenceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSequence().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			String subClassCode = cur.getClassCode();
			if( "GSEQ".equals( subClassCode ) ) {
				schema.getTableGelSequence().deleteGelSequence( Authorization, cur );
			}
			else if( "GEXE".equals( subClassCode ) ) {
				schema.getTableGelExecutable().deleteGelExecutable( Authorization, (CFGenKbGelExecutableBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GelSequence must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGelSequenceByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGelInstructionByTenantIdxKey key = schema.getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGelSequenceByTenantIdx( Authorization, key );
	}

	public void deleteGelSequenceByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByTenantIdxKey argKey )
	{
		final String S_ProcName = "deleteGelSequenceByTenantIdx";
		CFGenKbGelSequenceBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelSequenceBuff> matchSet = new LinkedList<CFGenKbGelSequenceBuff>();
		Iterator<CFGenKbGelSequenceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSequenceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSequence().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			String subClassCode = cur.getClassCode();
			if( "GSEQ".equals( subClassCode ) ) {
				schema.getTableGelSequence().deleteGelSequence( Authorization, cur );
			}
			else if( "GEXE".equals( subClassCode ) ) {
				schema.getTableGelExecutable().deleteGelExecutable( Authorization, (CFGenKbGelExecutableBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GelSequence must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGelSequenceByGelCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId )
	{
		CFGenKbGelInstructionByGelCacheIdxKey key = schema.getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		deleteGelSequenceByGelCacheIdx( Authorization, key );
	}

	public void deleteGelSequenceByGelCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByGelCacheIdxKey argKey )
	{
		final String S_ProcName = "deleteGelSequenceByGelCacheIdx";
		CFGenKbGelSequenceBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelSequenceBuff> matchSet = new LinkedList<CFGenKbGelSequenceBuff>();
		Iterator<CFGenKbGelSequenceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSequenceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSequence().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			String subClassCode = cur.getClassCode();
			if( "GSEQ".equals( subClassCode ) ) {
				schema.getTableGelSequence().deleteGelSequence( Authorization, cur );
			}
			else if( "GEXE".equals( subClassCode ) ) {
				schema.getTableGelExecutable().deleteGelExecutable( Authorization, (CFGenKbGelExecutableBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GelSequence must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGelSequenceByChainIdx( CFGenKbAuthorization Authorization,
		Long argChainInstTenantId,
		Long argChainInstGelCacheId,
		Long argChainInstGelInstId )
	{
		CFGenKbGelInstructionByChainIdxKey key = schema.getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( argChainInstTenantId );
		key.setOptionalChainInstGelCacheId( argChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( argChainInstGelInstId );
		deleteGelSequenceByChainIdx( Authorization, key );
	}

	public void deleteGelSequenceByChainIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByChainIdxKey argKey )
	{
		final String S_ProcName = "deleteGelSequenceByChainIdx";
		CFGenKbGelSequenceBuff cur;
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
		LinkedList<CFGenKbGelSequenceBuff> matchSet = new LinkedList<CFGenKbGelSequenceBuff>();
		Iterator<CFGenKbGelSequenceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSequenceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSequence().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			String subClassCode = cur.getClassCode();
			if( "GSEQ".equals( subClassCode ) ) {
				schema.getTableGelSequence().deleteGelSequence( Authorization, cur );
			}
			else if( "GEXE".equals( subClassCode ) ) {
				schema.getTableGelExecutable().deleteGelExecutable( Authorization, (CFGenKbGelExecutableBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GelSequence must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void releasePreparedStatements() {
	}
}
