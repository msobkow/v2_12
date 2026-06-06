
// Description: Java 11 in-memory RAM DbIO implementation for GelExecutable.

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
 *	CFGenKbRamGelExecutableTable in-memory RAM DbIO implementation
 *	for GelExecutable.
 */
public class CFGenKbRamGelExecutableTable
	implements ICFGenKbGelExecutableTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGelInstructionPKey,
				CFGenKbGelExecutableBuff > dictByPKey
		= new HashMap< CFGenKbGelInstructionPKey,
				CFGenKbGelExecutableBuff >();
	private Map< CFGenKbGelExecutableByGenItemIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelExecutableBuff >> dictByGenItemIdx
		= new HashMap< CFGenKbGelExecutableByGenItemIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelExecutableBuff >>();

	public CFGenKbRamGelExecutableTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGelExecutable( CFGenKbAuthorization Authorization,
		CFGenKbGelExecutableBuff Buff )
	{
		final String S_ProcName = "createGelExecutable";
		schema.getTableGelSequence().createGelSequence( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelExecutableByGenItemIdxKey keyGenItemIdx = schema.getFactoryGelExecutable().newGenItemIdxKey();
		keyGenItemIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyGenItemIdx.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );

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
				if( null == schema.getTableGelSequence().readDerivedByPIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredGelCacheId(),
						Buff.getRequiredGelInstId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"GelSequence",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelExecutableBuff > subdictGenItemIdx;
		if( dictByGenItemIdx.containsKey( keyGenItemIdx ) ) {
			subdictGenItemIdx = dictByGenItemIdx.get( keyGenItemIdx );
		}
		else {
			subdictGenItemIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelExecutableBuff >();
			dictByGenItemIdx.put( keyGenItemIdx, subdictGenItemIdx );
		}
		subdictGenItemIdx.put( pkey, Buff );

	}

	public CFGenKbGelExecutableBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelExecutable.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelExecutableBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelExecutableBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelExecutable.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelExecutableBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelExecutableBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGelExecutable.readAllDerived";
		CFGenKbGelExecutableBuff[] retList = new CFGenKbGelExecutableBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGelExecutableBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGelExecutableBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelExecutableBuff> filteredList = new ArrayList<CFGenKbGelExecutableBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelExecutableBuff ) ) {
					filteredList.add( (CFGenKbGelExecutableBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelExecutableBuff[0] ) );
		}
	}

	public CFGenKbGelExecutableBuff[] readDerivedByGelCacheIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelExecutableBuff> filteredList = new ArrayList<CFGenKbGelExecutableBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelExecutableBuff ) ) {
					filteredList.add( (CFGenKbGelExecutableBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelExecutableBuff[0] ) );
		}
	}

	public CFGenKbGelExecutableBuff[] readDerivedByChainIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelExecutableBuff> filteredList = new ArrayList<CFGenKbGelExecutableBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelExecutableBuff ) ) {
					filteredList.add( (CFGenKbGelExecutableBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelExecutableBuff[0] ) );
		}
	}

	public CFGenKbGelExecutableBuff[] readDerivedByFirstInstIdx( CFGenKbAuthorization Authorization,
		Long FirstInstTenantId,
		Long FirstInstGelCacheId,
		Long FirstInstId )
	{
		final String S_ProcName = "CFGenKbRamGelSequence.readDerivedByFirstInstIdx";
		CFGenKbGelSequenceBuff buffList[] = schema.getTableGelSequence().readDerivedByFirstInstIdx( Authorization,
			FirstInstTenantId,
			FirstInstGelCacheId,
			FirstInstId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGelSequenceBuff buff;
			ArrayList<CFGenKbGelExecutableBuff> filteredList = new ArrayList<CFGenKbGelExecutableBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelExecutableBuff ) ) {
					filteredList.add( (CFGenKbGelExecutableBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelExecutableBuff[0] ) );
		}
	}

	public CFGenKbGelExecutableBuff[] readDerivedByLastInstIdx( CFGenKbAuthorization Authorization,
		Long LastInstTenantId,
		Long LastInstGelCacheId,
		Long LastInstId )
	{
		final String S_ProcName = "CFGenKbRamGelSequence.readDerivedByLastInstIdx";
		CFGenKbGelSequenceBuff buffList[] = schema.getTableGelSequence().readDerivedByLastInstIdx( Authorization,
			LastInstTenantId,
			LastInstGelCacheId,
			LastInstId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGelSequenceBuff buff;
			ArrayList<CFGenKbGelExecutableBuff> filteredList = new ArrayList<CFGenKbGelExecutableBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelExecutableBuff ) ) {
					filteredList.add( (CFGenKbGelExecutableBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelExecutableBuff[0] ) );
		}
	}

	public CFGenKbGelExecutableBuff[] readDerivedByGenItemIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelExecutable.readDerivedByGenItemIdx";
		CFGenKbGelExecutableByGenItemIdxKey key = schema.getFactoryGelExecutable().newGenItemIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );

		CFGenKbGelExecutableBuff[] recArray;
		if( dictByGenItemIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelExecutableBuff > subdictGenItemIdx
				= dictByGenItemIdx.get( key );
			recArray = new CFGenKbGelExecutableBuff[ subdictGenItemIdx.size() ];
			Iterator< CFGenKbGelExecutableBuff > iter = subdictGenItemIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelExecutableBuff > subdictGenItemIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelExecutableBuff >();
			dictByGenItemIdx.put( key, subdictGenItemIdx );
			recArray = new CFGenKbGelExecutableBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelExecutableBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByPIdx() ";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );

		CFGenKbGelExecutableBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelExecutableBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelExecutable.readBuff";
		CFGenKbGelExecutableBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GEXE" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelExecutableBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGelExecutableBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GEXE" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelExecutableBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGelExecutable.readAllBuff";
		CFGenKbGelExecutableBuff buff;
		ArrayList<CFGenKbGelExecutableBuff> filteredList = new ArrayList<CFGenKbGelExecutableBuff>();
		CFGenKbGelExecutableBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GEXE" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelExecutableBuff[0] ) );
	}

	public CFGenKbGelExecutableBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByPIdx() ";
		CFGenKbGelExecutableBuff buff = readDerivedByPIdx( Authorization,
			TenantId,
			GelCacheId,
			GelInstId );
		if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
			return( (CFGenKbGelExecutableBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGelExecutableBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByTenantIdx() ";
		CFGenKbGelExecutableBuff buff;
		ArrayList<CFGenKbGelExecutableBuff> filteredList = new ArrayList<CFGenKbGelExecutableBuff>();
		CFGenKbGelExecutableBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelExecutableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelExecutableBuff[0] ) );
	}

	public CFGenKbGelExecutableBuff[] readBuffByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByGelCacheIdx() ";
		CFGenKbGelExecutableBuff buff;
		ArrayList<CFGenKbGelExecutableBuff> filteredList = new ArrayList<CFGenKbGelExecutableBuff>();
		CFGenKbGelExecutableBuff[] buffList = readDerivedByGelCacheIdx( Authorization,
			TenantId,
			GelCacheId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelExecutableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelExecutableBuff[0] ) );
	}

	public CFGenKbGelExecutableBuff[] readBuffByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByChainIdx() ";
		CFGenKbGelExecutableBuff buff;
		ArrayList<CFGenKbGelExecutableBuff> filteredList = new ArrayList<CFGenKbGelExecutableBuff>();
		CFGenKbGelExecutableBuff[] buffList = readDerivedByChainIdx( Authorization,
			ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelExecutableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelExecutableBuff[0] ) );
	}

	public CFGenKbGelExecutableBuff[] readBuffByFirstInstIdx( CFGenKbAuthorization Authorization,
		Long FirstInstTenantId,
		Long FirstInstGelCacheId,
		Long FirstInstId )
	{
		final String S_ProcName = "CFGenKbRamGelSequence.readBuffByFirstInstIdx() ";
		CFGenKbGelExecutableBuff buff;
		ArrayList<CFGenKbGelExecutableBuff> filteredList = new ArrayList<CFGenKbGelExecutableBuff>();
		CFGenKbGelExecutableBuff[] buffList = readDerivedByFirstInstIdx( Authorization,
			FirstInstTenantId,
			FirstInstGelCacheId,
			FirstInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GSEQ" ) ) {
				filteredList.add( (CFGenKbGelExecutableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelExecutableBuff[0] ) );
	}

	public CFGenKbGelExecutableBuff[] readBuffByLastInstIdx( CFGenKbAuthorization Authorization,
		Long LastInstTenantId,
		Long LastInstGelCacheId,
		Long LastInstId )
	{
		final String S_ProcName = "CFGenKbRamGelSequence.readBuffByLastInstIdx() ";
		CFGenKbGelExecutableBuff buff;
		ArrayList<CFGenKbGelExecutableBuff> filteredList = new ArrayList<CFGenKbGelExecutableBuff>();
		CFGenKbGelExecutableBuff[] buffList = readDerivedByLastInstIdx( Authorization,
			LastInstTenantId,
			LastInstGelCacheId,
			LastInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GSEQ" ) ) {
				filteredList.add( (CFGenKbGelExecutableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelExecutableBuff[0] ) );
	}

	public CFGenKbGelExecutableBuff[] readBuffByGenItemIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelExecutable.readBuffByGenItemIdx() ";
		CFGenKbGelExecutableBuff buff;
		ArrayList<CFGenKbGelExecutableBuff> filteredList = new ArrayList<CFGenKbGelExecutableBuff>();
		CFGenKbGelExecutableBuff[] buffList = readDerivedByGenItemIdx( Authorization,
			TenantId,
			GelCacheId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GEXE" ) ) {
				filteredList.add( (CFGenKbGelExecutableBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelExecutableBuff[0] ) );
	}

	/**
	 *	Read a page array of the specific GelExecutable buffer instances identified by the duplicate key FirstInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argFirstInstTenantId	The GelExecutable key attribute of the instance generating the id.
	 *
	 *	@param	argFirstInstGelCacheId	The GelExecutable key attribute of the instance generating the id.
	 *
	 *	@param	argFirstInstId	The GelExecutable key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelExecutableBuff[] pageBuffByFirstInstIdx( CFGenKbAuthorization Authorization,
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
	 *	Read a page array of the specific GelExecutable buffer instances identified by the duplicate key LastInstIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argLastInstTenantId	The GelExecutable key attribute of the instance generating the id.
	 *
	 *	@param	argLastInstGelCacheId	The GelExecutable key attribute of the instance generating the id.
	 *
	 *	@param	argLastInstId	The GelExecutable key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelExecutableBuff[] pageBuffByLastInstIdx( CFGenKbAuthorization Authorization,
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

	/**
	 *	Read a page array of the specific GelExecutable buffer instances identified by the duplicate key GenItemIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The GelExecutable key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelExecutable key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelExecutableBuff[] pageBuffByGenItemIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByGenItemIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateGelExecutable( CFGenKbAuthorization Authorization,
		CFGenKbGelExecutableBuff Buff )
	{
		schema.getTableGelSequence().updateGelSequence( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelExecutableBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGelExecutable",
				"Existing record not found",
				"GelExecutable",
				pkey );
		}
		CFGenKbGelExecutableByGenItemIdxKey existingKeyGenItemIdx = schema.getFactoryGelExecutable().newGenItemIdxKey();
		existingKeyGenItemIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyGenItemIdx.setRequiredGelCacheId( existing.getRequiredGelCacheId() );

		CFGenKbGelExecutableByGenItemIdxKey newKeyGenItemIdx = schema.getFactoryGelExecutable().newGenItemIdxKey();
		newKeyGenItemIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyGenItemIdx.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableGelSequence().readDerivedByPIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredGelCacheId(),
						Buff.getRequiredGelInstId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateGelExecutable",
						"Superclass",
						"SuperClass",
						"GelSequence",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGelInstructionPKey, CFGenKbGelExecutableBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByGenItemIdx.get( existingKeyGenItemIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByGenItemIdx.containsKey( newKeyGenItemIdx ) ) {
			subdict = dictByGenItemIdx.get( newKeyGenItemIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelExecutableBuff >();
			dictByGenItemIdx.put( newKeyGenItemIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteGelExecutable( CFGenKbAuthorization Authorization,
		CFGenKbGelExecutableBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGelExecutableTable.deleteGelExecutable() ";
		String classCode;
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelExecutableBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGelExecutable",
				pkey );
		}
		CFGenKbGelExecutableBuff editSubobj = schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
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
		if( classCode.equals( "GEXE" ) ) {
			schema.getTableGelExecutable().updateGelExecutable( Authorization, editSubobj );
		}
		else {
			new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"Unrecognized ClassCode \"" + classCode + "\"" );
		}
		existing = editSubobj;
		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckGelCalls[] = schema.getTableGelCall().readDerivedBySeqIdx( Authorization,
						existing.getRequiredTenantId(),
						existing.getRequiredGelCacheId(),
						existing.getRequiredGelInstId() );
		if( arrCheckGelCalls.length > 0 ) {
			schema.getTableGelCall().deleteGelCallBySeqIdx( Authorization,
						existing.getRequiredTenantId(),
						existing.getRequiredGelCacheId(),
						existing.getRequiredGelInstId() );
		}
		CFGenKbGelExecutableByGenItemIdxKey keyGenItemIdx = schema.getFactoryGelExecutable().newGenItemIdxKey();
		keyGenItemIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyGenItemIdx.setRequiredGelCacheId( existing.getRequiredGelCacheId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbGelInstructionPKey, CFGenKbGelExecutableBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByGenItemIdx.get( keyGenItemIdx );
		subdict.remove( pkey );

		schema.getTableGelSequence().deleteGelSequence( Authorization,
			Buff );
	}
	public void deleteGelExecutableByGenItemIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId )
	{
		CFGenKbGelExecutableByGenItemIdxKey key = schema.getFactoryGelExecutable().newGenItemIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		deleteGelExecutableByGenItemIdx( Authorization, key );
	}

	public void deleteGelExecutableByGenItemIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelExecutableByGenItemIdxKey argKey )
	{
		CFGenKbGelExecutableBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelExecutableBuff> matchSet = new LinkedList<CFGenKbGelExecutableBuff>();
		Iterator<CFGenKbGelExecutableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelExecutableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelExecutable( Authorization, cur );
		}
	}

	public void deleteGelExecutableByFirstInstIdx( CFGenKbAuthorization Authorization,
		Long argFirstInstTenantId,
		Long argFirstInstGelCacheId,
		Long argFirstInstId )
	{
		CFGenKbGelSequenceByFirstInstIdxKey key = schema.getFactoryGelSequence().newFirstInstIdxKey();
		key.setOptionalFirstInstTenantId( argFirstInstTenantId );
		key.setOptionalFirstInstGelCacheId( argFirstInstGelCacheId );
		key.setOptionalFirstInstId( argFirstInstId );
		deleteGelExecutableByFirstInstIdx( Authorization, key );
	}

	public void deleteGelExecutableByFirstInstIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSequenceByFirstInstIdxKey argKey )
	{
		CFGenKbGelExecutableBuff cur;
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
		LinkedList<CFGenKbGelExecutableBuff> matchSet = new LinkedList<CFGenKbGelExecutableBuff>();
		Iterator<CFGenKbGelExecutableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelExecutableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelExecutable( Authorization, cur );
		}
	}

	public void deleteGelExecutableByLastInstIdx( CFGenKbAuthorization Authorization,
		Long argLastInstTenantId,
		Long argLastInstGelCacheId,
		Long argLastInstId )
	{
		CFGenKbGelSequenceByLastInstIdxKey key = schema.getFactoryGelSequence().newLastInstIdxKey();
		key.setOptionalLastInstTenantId( argLastInstTenantId );
		key.setOptionalLastInstGelCacheId( argLastInstGelCacheId );
		key.setOptionalLastInstId( argLastInstId );
		deleteGelExecutableByLastInstIdx( Authorization, key );
	}

	public void deleteGelExecutableByLastInstIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSequenceByLastInstIdxKey argKey )
	{
		CFGenKbGelExecutableBuff cur;
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
		LinkedList<CFGenKbGelExecutableBuff> matchSet = new LinkedList<CFGenKbGelExecutableBuff>();
		Iterator<CFGenKbGelExecutableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelExecutableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelExecutable( Authorization, cur );
		}
	}

	public void deleteGelExecutableByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId )
	{
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		key.setRequiredGelInstId( argGelInstId );
		deleteGelExecutableByPIdx( Authorization, key );
	}

	public void deleteGelExecutableByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGelExecutableBuff cur;
		LinkedList<CFGenKbGelExecutableBuff> matchSet = new LinkedList<CFGenKbGelExecutableBuff>();
		Iterator<CFGenKbGelExecutableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelExecutableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelExecutable( Authorization, cur );
		}
	}

	public void deleteGelExecutableByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGelInstructionByTenantIdxKey key = schema.getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGelExecutableByTenantIdx( Authorization, key );
	}

	public void deleteGelExecutableByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByTenantIdxKey argKey )
	{
		CFGenKbGelExecutableBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelExecutableBuff> matchSet = new LinkedList<CFGenKbGelExecutableBuff>();
		Iterator<CFGenKbGelExecutableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelExecutableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelExecutable( Authorization, cur );
		}
	}

	public void deleteGelExecutableByGelCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId )
	{
		CFGenKbGelInstructionByGelCacheIdxKey key = schema.getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		deleteGelExecutableByGelCacheIdx( Authorization, key );
	}

	public void deleteGelExecutableByGelCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByGelCacheIdxKey argKey )
	{
		CFGenKbGelExecutableBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelExecutableBuff> matchSet = new LinkedList<CFGenKbGelExecutableBuff>();
		Iterator<CFGenKbGelExecutableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelExecutableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelExecutable( Authorization, cur );
		}
	}

	public void deleteGelExecutableByChainIdx( CFGenKbAuthorization Authorization,
		Long argChainInstTenantId,
		Long argChainInstGelCacheId,
		Long argChainInstGelInstId )
	{
		CFGenKbGelInstructionByChainIdxKey key = schema.getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( argChainInstTenantId );
		key.setOptionalChainInstGelCacheId( argChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( argChainInstGelInstId );
		deleteGelExecutableByChainIdx( Authorization, key );
	}

	public void deleteGelExecutableByChainIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByChainIdxKey argKey )
	{
		CFGenKbGelExecutableBuff cur;
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
		LinkedList<CFGenKbGelExecutableBuff> matchSet = new LinkedList<CFGenKbGelExecutableBuff>();
		Iterator<CFGenKbGelExecutableBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelExecutableBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelExecutable( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
