
// Description: Java 11 in-memory RAM DbIO implementation for GelConstrain.

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
 *	CFGenKbRamGelConstrainTable in-memory RAM DbIO implementation
 *	for GelConstrain.
 */
public class CFGenKbRamGelConstrainTable
	implements ICFGenKbGelConstrainTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGelInstructionPKey,
				CFGenKbGelConstrainBuff > dictByPKey
		= new HashMap< CFGenKbGelInstructionPKey,
				CFGenKbGelConstrainBuff >();
	private Map< CFGenKbGelConstrainByRemainderIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelConstrainBuff >> dictByRemainderIdx
		= new HashMap< CFGenKbGelConstrainByRemainderIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelConstrainBuff >>();

	public CFGenKbRamGelConstrainTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGelConstrain( CFGenKbAuthorization Authorization,
		CFGenKbGelConstrainBuff Buff )
	{
		final String S_ProcName = "createGelConstrain";
		schema.getTableGelInstruction().createGelInstruction( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelConstrainByRemainderIdxKey keyRemainderIdx = schema.getFactoryGelConstrain().newRemainderIdxKey();
		keyRemainderIdx.setOptionalRemainderTenantId( Buff.getOptionalRemainderTenantId() );
		keyRemainderIdx.setRequiredRemainderGelCacheId( Buff.getRequiredRemainderGelCacheId() );
		keyRemainderIdx.setOptionalRemainderInstId( Buff.getOptionalRemainderInstId() );

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

		Map< CFGenKbGelInstructionPKey, CFGenKbGelConstrainBuff > subdictRemainderIdx;
		if( dictByRemainderIdx.containsKey( keyRemainderIdx ) ) {
			subdictRemainderIdx = dictByRemainderIdx.get( keyRemainderIdx );
		}
		else {
			subdictRemainderIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelConstrainBuff >();
			dictByRemainderIdx.put( keyRemainderIdx, subdictRemainderIdx );
		}
		subdictRemainderIdx.put( pkey, Buff );

	}

	public CFGenKbGelConstrainBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelConstrain.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelConstrainBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelConstrainBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelConstrain.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelConstrainBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelConstrainBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGelConstrain.readAllDerived";
		CFGenKbGelConstrainBuff[] retList = new CFGenKbGelConstrainBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGelConstrainBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGelConstrainBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelConstrainBuff> filteredList = new ArrayList<CFGenKbGelConstrainBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelConstrainBuff ) ) {
					filteredList.add( (CFGenKbGelConstrainBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelConstrainBuff[0] ) );
		}
	}

	public CFGenKbGelConstrainBuff[] readDerivedByGelCacheIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelConstrainBuff> filteredList = new ArrayList<CFGenKbGelConstrainBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelConstrainBuff ) ) {
					filteredList.add( (CFGenKbGelConstrainBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelConstrainBuff[0] ) );
		}
	}

	public CFGenKbGelConstrainBuff[] readDerivedByChainIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelConstrainBuff> filteredList = new ArrayList<CFGenKbGelConstrainBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelConstrainBuff ) ) {
					filteredList.add( (CFGenKbGelConstrainBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelConstrainBuff[0] ) );
		}
	}

	public CFGenKbGelConstrainBuff[] readDerivedByRemainderIdx( CFGenKbAuthorization Authorization,
		Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId )
	{
		final String S_ProcName = "CFGenKbRamGelConstrain.readDerivedByRemainderIdx";
		CFGenKbGelConstrainByRemainderIdxKey key = schema.getFactoryGelConstrain().newRemainderIdxKey();
		key.setOptionalRemainderTenantId( RemainderTenantId );
		key.setRequiredRemainderGelCacheId( RemainderGelCacheId );
		key.setOptionalRemainderInstId( RemainderInstId );

		CFGenKbGelConstrainBuff[] recArray;
		if( dictByRemainderIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelConstrainBuff > subdictRemainderIdx
				= dictByRemainderIdx.get( key );
			recArray = new CFGenKbGelConstrainBuff[ subdictRemainderIdx.size() ];
			Iterator< CFGenKbGelConstrainBuff > iter = subdictRemainderIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelConstrainBuff > subdictRemainderIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelConstrainBuff >();
			dictByRemainderIdx.put( key, subdictRemainderIdx );
			recArray = new CFGenKbGelConstrainBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelConstrainBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByPIdx() ";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );

		CFGenKbGelConstrainBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelConstrainBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelConstrain.readBuff";
		CFGenKbGelConstrainBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GCON" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelConstrainBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGelConstrainBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GCON" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelConstrainBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGelConstrain.readAllBuff";
		CFGenKbGelConstrainBuff buff;
		ArrayList<CFGenKbGelConstrainBuff> filteredList = new ArrayList<CFGenKbGelConstrainBuff>();
		CFGenKbGelConstrainBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GCON" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelConstrainBuff[0] ) );
	}

	public CFGenKbGelConstrainBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByPIdx() ";
		CFGenKbGelConstrainBuff buff = readDerivedByPIdx( Authorization,
			TenantId,
			GelCacheId,
			GelInstId );
		if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
			return( (CFGenKbGelConstrainBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGelConstrainBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByTenantIdx() ";
		CFGenKbGelConstrainBuff buff;
		ArrayList<CFGenKbGelConstrainBuff> filteredList = new ArrayList<CFGenKbGelConstrainBuff>();
		CFGenKbGelConstrainBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelConstrainBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelConstrainBuff[0] ) );
	}

	public CFGenKbGelConstrainBuff[] readBuffByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByGelCacheIdx() ";
		CFGenKbGelConstrainBuff buff;
		ArrayList<CFGenKbGelConstrainBuff> filteredList = new ArrayList<CFGenKbGelConstrainBuff>();
		CFGenKbGelConstrainBuff[] buffList = readDerivedByGelCacheIdx( Authorization,
			TenantId,
			GelCacheId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelConstrainBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelConstrainBuff[0] ) );
	}

	public CFGenKbGelConstrainBuff[] readBuffByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByChainIdx() ";
		CFGenKbGelConstrainBuff buff;
		ArrayList<CFGenKbGelConstrainBuff> filteredList = new ArrayList<CFGenKbGelConstrainBuff>();
		CFGenKbGelConstrainBuff[] buffList = readDerivedByChainIdx( Authorization,
			ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelConstrainBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelConstrainBuff[0] ) );
	}

	public CFGenKbGelConstrainBuff[] readBuffByRemainderIdx( CFGenKbAuthorization Authorization,
		Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId )
	{
		final String S_ProcName = "CFGenKbRamGelConstrain.readBuffByRemainderIdx() ";
		CFGenKbGelConstrainBuff buff;
		ArrayList<CFGenKbGelConstrainBuff> filteredList = new ArrayList<CFGenKbGelConstrainBuff>();
		CFGenKbGelConstrainBuff[] buffList = readDerivedByRemainderIdx( Authorization,
			RemainderTenantId,
			RemainderGelCacheId,
			RemainderInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GCON" ) ) {
				filteredList.add( (CFGenKbGelConstrainBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelConstrainBuff[0] ) );
	}

	/**
	 *	Read a page array of the specific GelConstrain buffer instances identified by the duplicate key RemainderIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRemainderTenantId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderGelCacheId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderInstId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelConstrainBuff[] pageBuffByRemainderIdx( CFGenKbAuthorization Authorization,
		Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByRemainderIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateGelConstrain( CFGenKbAuthorization Authorization,
		CFGenKbGelConstrainBuff Buff )
	{
		schema.getTableGelInstruction().updateGelInstruction( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelConstrainBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGelConstrain",
				"Existing record not found",
				"GelConstrain",
				pkey );
		}
		CFGenKbGelConstrainByRemainderIdxKey existingKeyRemainderIdx = schema.getFactoryGelConstrain().newRemainderIdxKey();
		existingKeyRemainderIdx.setOptionalRemainderTenantId( existing.getOptionalRemainderTenantId() );
		existingKeyRemainderIdx.setRequiredRemainderGelCacheId( existing.getRequiredRemainderGelCacheId() );
		existingKeyRemainderIdx.setOptionalRemainderInstId( existing.getOptionalRemainderInstId() );

		CFGenKbGelConstrainByRemainderIdxKey newKeyRemainderIdx = schema.getFactoryGelConstrain().newRemainderIdxKey();
		newKeyRemainderIdx.setOptionalRemainderTenantId( Buff.getOptionalRemainderTenantId() );
		newKeyRemainderIdx.setRequiredRemainderGelCacheId( Buff.getRequiredRemainderGelCacheId() );
		newKeyRemainderIdx.setOptionalRemainderInstId( Buff.getOptionalRemainderInstId() );

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
						"updateGelConstrain",
						"Superclass",
						"SuperClass",
						"GelInstruction",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGelInstructionPKey, CFGenKbGelConstrainBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByRemainderIdx.get( existingKeyRemainderIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRemainderIdx.containsKey( newKeyRemainderIdx ) ) {
			subdict = dictByRemainderIdx.get( newKeyRemainderIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelConstrainBuff >();
			dictByRemainderIdx.put( newKeyRemainderIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteGelConstrain( CFGenKbAuthorization Authorization,
		CFGenKbGelConstrainBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGelConstrainTable.deleteGelConstrain() ";
		String classCode;
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelConstrainBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGelConstrain",
				pkey );
		}
					schema.getTableGelInstruction().deleteGelInstructionByPIdx( Authorization,
						existing.getOptionalRemainderTenantId(),
						existing.getRequiredRemainderGelCacheId(),
						existing.getOptionalRemainderInstId() );
		CFGenKbGelConstrainByRemainderIdxKey keyRemainderIdx = schema.getFactoryGelConstrain().newRemainderIdxKey();
		keyRemainderIdx.setOptionalRemainderTenantId( existing.getOptionalRemainderTenantId() );
		keyRemainderIdx.setRequiredRemainderGelCacheId( existing.getRequiredRemainderGelCacheId() );
		keyRemainderIdx.setOptionalRemainderInstId( existing.getOptionalRemainderInstId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbGelInstructionPKey, CFGenKbGelConstrainBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByRemainderIdx.get( keyRemainderIdx );
		subdict.remove( pkey );

		schema.getTableGelInstruction().deleteGelInstruction( Authorization,
			Buff );
	}
	public void deleteGelConstrainByRemainderIdx( CFGenKbAuthorization Authorization,
		Long argRemainderTenantId,
		long argRemainderGelCacheId,
		Long argRemainderInstId )
	{
		CFGenKbGelConstrainByRemainderIdxKey key = schema.getFactoryGelConstrain().newRemainderIdxKey();
		key.setOptionalRemainderTenantId( argRemainderTenantId );
		key.setRequiredRemainderGelCacheId( argRemainderGelCacheId );
		key.setOptionalRemainderInstId( argRemainderInstId );
		deleteGelConstrainByRemainderIdx( Authorization, key );
	}

	public void deleteGelConstrainByRemainderIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelConstrainByRemainderIdxKey argKey )
	{
		CFGenKbGelConstrainBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalRemainderTenantId() != null ) {
			anyNotNull = true;
		}
		anyNotNull = true;
		if( argKey.getOptionalRemainderInstId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelConstrainBuff> matchSet = new LinkedList<CFGenKbGelConstrainBuff>();
		Iterator<CFGenKbGelConstrainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelConstrainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelConstrain().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelConstrain( Authorization, cur );
		}
	}

	public void deleteGelConstrainByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId )
	{
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		key.setRequiredGelInstId( argGelInstId );
		deleteGelConstrainByPIdx( Authorization, key );
	}

	public void deleteGelConstrainByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGelConstrainBuff cur;
		LinkedList<CFGenKbGelConstrainBuff> matchSet = new LinkedList<CFGenKbGelConstrainBuff>();
		Iterator<CFGenKbGelConstrainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelConstrainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelConstrain().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelConstrain( Authorization, cur );
		}
	}

	public void deleteGelConstrainByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGelInstructionByTenantIdxKey key = schema.getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGelConstrainByTenantIdx( Authorization, key );
	}

	public void deleteGelConstrainByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByTenantIdxKey argKey )
	{
		CFGenKbGelConstrainBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelConstrainBuff> matchSet = new LinkedList<CFGenKbGelConstrainBuff>();
		Iterator<CFGenKbGelConstrainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelConstrainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelConstrain().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelConstrain( Authorization, cur );
		}
	}

	public void deleteGelConstrainByGelCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId )
	{
		CFGenKbGelInstructionByGelCacheIdxKey key = schema.getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		deleteGelConstrainByGelCacheIdx( Authorization, key );
	}

	public void deleteGelConstrainByGelCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByGelCacheIdxKey argKey )
	{
		CFGenKbGelConstrainBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelConstrainBuff> matchSet = new LinkedList<CFGenKbGelConstrainBuff>();
		Iterator<CFGenKbGelConstrainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelConstrainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelConstrain().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelConstrain( Authorization, cur );
		}
	}

	public void deleteGelConstrainByChainIdx( CFGenKbAuthorization Authorization,
		Long argChainInstTenantId,
		Long argChainInstGelCacheId,
		Long argChainInstGelInstId )
	{
		CFGenKbGelInstructionByChainIdxKey key = schema.getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( argChainInstTenantId );
		key.setOptionalChainInstGelCacheId( argChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( argChainInstGelInstId );
		deleteGelConstrainByChainIdx( Authorization, key );
	}

	public void deleteGelConstrainByChainIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByChainIdxKey argKey )
	{
		CFGenKbGelConstrainBuff cur;
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
		LinkedList<CFGenKbGelConstrainBuff> matchSet = new LinkedList<CFGenKbGelConstrainBuff>();
		Iterator<CFGenKbGelConstrainBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelConstrainBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelConstrain().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelConstrain( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
