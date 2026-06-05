
// Description: Java 11 in-memory RAM DbIO implementation for GelModifier.

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
 *	CFGenKbRamGelModifierTable in-memory RAM DbIO implementation
 *	for GelModifier.
 */
public class CFGenKbRamGelModifierTable
	implements ICFGenKbGelModifierTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGelInstructionPKey,
				CFGenKbGelModifierBuff > dictByPKey
		= new HashMap< CFGenKbGelInstructionPKey,
				CFGenKbGelModifierBuff >();
	private Map< CFGenKbGelModifierByRemainderIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelModifierBuff >> dictByRemainderIdx
		= new HashMap< CFGenKbGelModifierByRemainderIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelModifierBuff >>();

	public CFGenKbRamGelModifierTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGelModifier( CFGenKbAuthorization Authorization,
		CFGenKbGelModifierBuff Buff )
	{
		final String S_ProcName = "createGelModifier";
		schema.getTableGelInstruction().createGelInstruction( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelModifierByRemainderIdxKey keyRemainderIdx = schema.getFactoryGelModifier().newRemainderIdxKey();
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

		Map< CFGenKbGelInstructionPKey, CFGenKbGelModifierBuff > subdictRemainderIdx;
		if( dictByRemainderIdx.containsKey( keyRemainderIdx ) ) {
			subdictRemainderIdx = dictByRemainderIdx.get( keyRemainderIdx );
		}
		else {
			subdictRemainderIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelModifierBuff >();
			dictByRemainderIdx.put( keyRemainderIdx, subdictRemainderIdx );
		}
		subdictRemainderIdx.put( pkey, Buff );

	}

	public CFGenKbGelModifierBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelModifier.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelModifierBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelModifierBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelModifier.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelModifierBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelModifierBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGelModifier.readAllDerived";
		CFGenKbGelModifierBuff[] retList = new CFGenKbGelModifierBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGelModifierBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGelModifierBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelModifierBuff> filteredList = new ArrayList<CFGenKbGelModifierBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelModifierBuff ) ) {
					filteredList.add( (CFGenKbGelModifierBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelModifierBuff[0] ) );
		}
	}

	public CFGenKbGelModifierBuff[] readDerivedByGelCacheIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelModifierBuff> filteredList = new ArrayList<CFGenKbGelModifierBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelModifierBuff ) ) {
					filteredList.add( (CFGenKbGelModifierBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelModifierBuff[0] ) );
		}
	}

	public CFGenKbGelModifierBuff[] readDerivedByChainIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGelModifierBuff> filteredList = new ArrayList<CFGenKbGelModifierBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelModifierBuff ) ) {
					filteredList.add( (CFGenKbGelModifierBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelModifierBuff[0] ) );
		}
	}

	public CFGenKbGelModifierBuff[] readDerivedByRemainderIdx( CFGenKbAuthorization Authorization,
		Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId )
	{
		final String S_ProcName = "CFGenKbRamGelModifier.readDerivedByRemainderIdx";
		CFGenKbGelModifierByRemainderIdxKey key = schema.getFactoryGelModifier().newRemainderIdxKey();
		key.setOptionalRemainderTenantId( RemainderTenantId );
		key.setRequiredRemainderGelCacheId( RemainderGelCacheId );
		key.setOptionalRemainderInstId( RemainderInstId );

		CFGenKbGelModifierBuff[] recArray;
		if( dictByRemainderIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelModifierBuff > subdictRemainderIdx
				= dictByRemainderIdx.get( key );
			recArray = new CFGenKbGelModifierBuff[ subdictRemainderIdx.size() ];
			Iterator< CFGenKbGelModifierBuff > iter = subdictRemainderIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelModifierBuff > subdictRemainderIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelModifierBuff >();
			dictByRemainderIdx.put( key, subdictRemainderIdx );
			recArray = new CFGenKbGelModifierBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelModifierBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByPIdx() ";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );

		CFGenKbGelModifierBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelModifierBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelModifier.readBuff";
		CFGenKbGelModifierBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GMOD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelModifierBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGelModifierBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GMOD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelModifierBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGelModifier.readAllBuff";
		CFGenKbGelModifierBuff buff;
		ArrayList<CFGenKbGelModifierBuff> filteredList = new ArrayList<CFGenKbGelModifierBuff>();
		CFGenKbGelModifierBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GMOD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelModifierBuff[0] ) );
	}

	public CFGenKbGelModifierBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByPIdx() ";
		CFGenKbGelModifierBuff buff = readDerivedByPIdx( Authorization,
			TenantId,
			GelCacheId,
			GelInstId );
		if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
			return( (CFGenKbGelModifierBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGelModifierBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByTenantIdx() ";
		CFGenKbGelModifierBuff buff;
		ArrayList<CFGenKbGelModifierBuff> filteredList = new ArrayList<CFGenKbGelModifierBuff>();
		CFGenKbGelModifierBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelModifierBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelModifierBuff[0] ) );
	}

	public CFGenKbGelModifierBuff[] readBuffByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByGelCacheIdx() ";
		CFGenKbGelModifierBuff buff;
		ArrayList<CFGenKbGelModifierBuff> filteredList = new ArrayList<CFGenKbGelModifierBuff>();
		CFGenKbGelModifierBuff[] buffList = readDerivedByGelCacheIdx( Authorization,
			TenantId,
			GelCacheId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelModifierBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelModifierBuff[0] ) );
	}

	public CFGenKbGelModifierBuff[] readBuffByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByChainIdx() ";
		CFGenKbGelModifierBuff buff;
		ArrayList<CFGenKbGelModifierBuff> filteredList = new ArrayList<CFGenKbGelModifierBuff>();
		CFGenKbGelModifierBuff[] buffList = readDerivedByChainIdx( Authorization,
			ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelModifierBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelModifierBuff[0] ) );
	}

	public CFGenKbGelModifierBuff[] readBuffByRemainderIdx( CFGenKbAuthorization Authorization,
		Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId )
	{
		final String S_ProcName = "CFGenKbRamGelModifier.readBuffByRemainderIdx() ";
		CFGenKbGelModifierBuff buff;
		ArrayList<CFGenKbGelModifierBuff> filteredList = new ArrayList<CFGenKbGelModifierBuff>();
		CFGenKbGelModifierBuff[] buffList = readDerivedByRemainderIdx( Authorization,
			RemainderTenantId,
			RemainderGelCacheId,
			RemainderInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GMOD" ) ) {
				filteredList.add( (CFGenKbGelModifierBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelModifierBuff[0] ) );
	}

	/**
	 *	Read a page array of the specific GelModifier buffer instances identified by the duplicate key RemainderIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRemainderTenantId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderGelCacheId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderInstId	The GelModifier key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelModifierBuff[] pageBuffByRemainderIdx( CFGenKbAuthorization Authorization,
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

	public void updateGelModifier( CFGenKbAuthorization Authorization,
		CFGenKbGelModifierBuff Buff )
	{
		schema.getTableGelInstruction().updateGelInstruction( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelModifierBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGelModifier",
				"Existing record not found",
				"GelModifier",
				pkey );
		}
		CFGenKbGelModifierByRemainderIdxKey existingKeyRemainderIdx = schema.getFactoryGelModifier().newRemainderIdxKey();
		existingKeyRemainderIdx.setOptionalRemainderTenantId( existing.getOptionalRemainderTenantId() );
		existingKeyRemainderIdx.setRequiredRemainderGelCacheId( existing.getRequiredRemainderGelCacheId() );
		existingKeyRemainderIdx.setOptionalRemainderInstId( existing.getOptionalRemainderInstId() );

		CFGenKbGelModifierByRemainderIdxKey newKeyRemainderIdx = schema.getFactoryGelModifier().newRemainderIdxKey();
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
						"updateGelModifier",
						"Superclass",
						"SuperClass",
						"GelInstruction",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGelInstructionPKey, CFGenKbGelModifierBuff > subdict;

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
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelModifierBuff >();
			dictByRemainderIdx.put( newKeyRemainderIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteGelModifier( CFGenKbAuthorization Authorization,
		CFGenKbGelModifierBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGelModifierTable.deleteGelModifier() ";
		String classCode;
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelModifierBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGelModifier",
				pkey );
		}
					schema.getTableGelInstruction().deleteGelInstructionByPIdx( Authorization,
						existing.getOptionalRemainderTenantId(),
						existing.getRequiredRemainderGelCacheId(),
						existing.getOptionalRemainderInstId() );
		CFGenKbGelModifierByRemainderIdxKey keyRemainderIdx = schema.getFactoryGelModifier().newRemainderIdxKey();
		keyRemainderIdx.setOptionalRemainderTenantId( existing.getOptionalRemainderTenantId() );
		keyRemainderIdx.setRequiredRemainderGelCacheId( existing.getRequiredRemainderGelCacheId() );
		keyRemainderIdx.setOptionalRemainderInstId( existing.getOptionalRemainderInstId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbGelInstructionPKey, CFGenKbGelModifierBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByRemainderIdx.get( keyRemainderIdx );
		subdict.remove( pkey );

		schema.getTableGelInstruction().deleteGelInstruction( Authorization,
			Buff );
	}
	public void deleteGelModifierByRemainderIdx( CFGenKbAuthorization Authorization,
		Long argRemainderTenantId,
		long argRemainderGelCacheId,
		Long argRemainderInstId )
	{
		CFGenKbGelModifierByRemainderIdxKey key = schema.getFactoryGelModifier().newRemainderIdxKey();
		key.setOptionalRemainderTenantId( argRemainderTenantId );
		key.setRequiredRemainderGelCacheId( argRemainderGelCacheId );
		key.setOptionalRemainderInstId( argRemainderInstId );
		deleteGelModifierByRemainderIdx( Authorization, key );
	}

	public void deleteGelModifierByRemainderIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelModifierByRemainderIdxKey argKey )
	{
		CFGenKbGelModifierBuff cur;
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
		LinkedList<CFGenKbGelModifierBuff> matchSet = new LinkedList<CFGenKbGelModifierBuff>();
		Iterator<CFGenKbGelModifierBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelModifierBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelModifier().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelModifier( Authorization, cur );
		}
	}

	public void deleteGelModifierByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId )
	{
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		key.setRequiredGelInstId( argGelInstId );
		deleteGelModifierByPIdx( Authorization, key );
	}

	public void deleteGelModifierByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGelModifierBuff cur;
		LinkedList<CFGenKbGelModifierBuff> matchSet = new LinkedList<CFGenKbGelModifierBuff>();
		Iterator<CFGenKbGelModifierBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelModifierBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelModifier().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelModifier( Authorization, cur );
		}
	}

	public void deleteGelModifierByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGelInstructionByTenantIdxKey key = schema.getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGelModifierByTenantIdx( Authorization, key );
	}

	public void deleteGelModifierByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByTenantIdxKey argKey )
	{
		CFGenKbGelModifierBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelModifierBuff> matchSet = new LinkedList<CFGenKbGelModifierBuff>();
		Iterator<CFGenKbGelModifierBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelModifierBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelModifier().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelModifier( Authorization, cur );
		}
	}

	public void deleteGelModifierByGelCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId )
	{
		CFGenKbGelInstructionByGelCacheIdxKey key = schema.getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		deleteGelModifierByGelCacheIdx( Authorization, key );
	}

	public void deleteGelModifierByGelCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByGelCacheIdxKey argKey )
	{
		CFGenKbGelModifierBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelModifierBuff> matchSet = new LinkedList<CFGenKbGelModifierBuff>();
		Iterator<CFGenKbGelModifierBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelModifierBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelModifier().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelModifier( Authorization, cur );
		}
	}

	public void deleteGelModifierByChainIdx( CFGenKbAuthorization Authorization,
		Long argChainInstTenantId,
		Long argChainInstGelCacheId,
		Long argChainInstGelInstId )
	{
		CFGenKbGelInstructionByChainIdxKey key = schema.getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( argChainInstTenantId );
		key.setOptionalChainInstGelCacheId( argChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( argChainInstGelInstId );
		deleteGelModifierByChainIdx( Authorization, key );
	}

	public void deleteGelModifierByChainIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByChainIdxKey argKey )
	{
		CFGenKbGelModifierBuff cur;
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
		LinkedList<CFGenKbGelModifierBuff> matchSet = new LinkedList<CFGenKbGelModifierBuff>();
		Iterator<CFGenKbGelModifierBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelModifierBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelModifier().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelModifier( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
