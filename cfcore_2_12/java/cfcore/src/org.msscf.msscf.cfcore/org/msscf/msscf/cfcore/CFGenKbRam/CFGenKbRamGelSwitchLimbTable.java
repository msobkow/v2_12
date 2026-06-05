
// Description: Java 11 in-memory RAM DbIO implementation for GelSwitchLimb.

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
 *	CFGenKbRamGelSwitchLimbTable in-memory RAM DbIO implementation
 *	for GelSwitchLimb.
 */
public class CFGenKbRamGelSwitchLimbTable
	implements ICFGenKbGelSwitchLimbTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGelSwitchLimbPKey,
				CFGenKbGelSwitchLimbBuff > dictByPKey
		= new HashMap< CFGenKbGelSwitchLimbPKey,
				CFGenKbGelSwitchLimbBuff >();
	private Map< CFGenKbGelSwitchLimbByTenantIdxKey,
				Map< CFGenKbGelSwitchLimbPKey,
					CFGenKbGelSwitchLimbBuff >> dictByTenantIdx
		= new HashMap< CFGenKbGelSwitchLimbByTenantIdxKey,
				Map< CFGenKbGelSwitchLimbPKey,
					CFGenKbGelSwitchLimbBuff >>();
	private Map< CFGenKbGelSwitchLimbBySwitchIdxKey,
				Map< CFGenKbGelSwitchLimbPKey,
					CFGenKbGelSwitchLimbBuff >> dictBySwitchIdx
		= new HashMap< CFGenKbGelSwitchLimbBySwitchIdxKey,
				Map< CFGenKbGelSwitchLimbPKey,
					CFGenKbGelSwitchLimbBuff >>();

	public CFGenKbRamGelSwitchLimbTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGelSwitchLimb( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbBuff Buff )
	{
		final String S_ProcName = "createGelSwitchLimb";
		CFGenKbGelSwitchLimbPKey pkey = schema.getFactoryGelSwitchLimb().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		pkey.setRequiredLimbName( Buff.getRequiredLimbName() );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredGelCacheId( pkey.getRequiredGelCacheId() );
		Buff.setRequiredGelInstId( pkey.getRequiredGelInstId() );
		Buff.setRequiredLimbName( pkey.getRequiredLimbName() );
		CFGenKbGelSwitchLimbByTenantIdxKey keyTenantIdx = schema.getFactoryGelSwitchLimb().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFGenKbGelSwitchLimbBySwitchIdxKey keySwitchIdx = schema.getFactoryGelSwitchLimb().newSwitchIdxKey();
		keySwitchIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keySwitchIdx.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		keySwitchIdx.setRequiredGelInstId( Buff.getRequiredGelInstId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
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
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbGelSwitchLimbPKey, CFGenKbGelSwitchLimbBuff > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< CFGenKbGelSwitchLimbPKey, CFGenKbGelSwitchLimbBuff >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		Map< CFGenKbGelSwitchLimbPKey, CFGenKbGelSwitchLimbBuff > subdictSwitchIdx;
		if( dictBySwitchIdx.containsKey( keySwitchIdx ) ) {
			subdictSwitchIdx = dictBySwitchIdx.get( keySwitchIdx );
		}
		else {
			subdictSwitchIdx = new HashMap< CFGenKbGelSwitchLimbPKey, CFGenKbGelSwitchLimbBuff >();
			dictBySwitchIdx.put( keySwitchIdx, subdictSwitchIdx );
		}
		subdictSwitchIdx.put( pkey, Buff );

	}

	public CFGenKbGelSwitchLimbBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelSwitchLimb.readDerived";
		CFGenKbGelSwitchLimbPKey key = schema.getFactoryGelSwitchLimb().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		key.setRequiredLimbName( PKey.getRequiredLimbName() );
		CFGenKbGelSwitchLimbBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSwitchLimbBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelSwitchLimb.readDerived";
		CFGenKbGelSwitchLimbPKey key = schema.getFactoryGelSwitchLimb().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		key.setRequiredLimbName( PKey.getRequiredLimbName() );
		CFGenKbGelSwitchLimbBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSwitchLimbBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGelSwitchLimb.readAllDerived";
		CFGenKbGelSwitchLimbBuff[] retList = new CFGenKbGelSwitchLimbBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGelSwitchLimbBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGelSwitchLimbBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGelSwitchLimb.readDerivedByTenantIdx";
		CFGenKbGelSwitchLimbByTenantIdxKey key = schema.getFactoryGelSwitchLimb().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFGenKbGelSwitchLimbBuff[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFGenKbGelSwitchLimbPKey, CFGenKbGelSwitchLimbBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new CFGenKbGelSwitchLimbBuff[ subdictTenantIdx.size() ];
			Iterator< CFGenKbGelSwitchLimbBuff > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelSwitchLimbPKey, CFGenKbGelSwitchLimbBuff > subdictTenantIdx
				= new HashMap< CFGenKbGelSwitchLimbPKey, CFGenKbGelSwitchLimbBuff >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new CFGenKbGelSwitchLimbBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelSwitchLimbBuff[] readDerivedBySwitchIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelSwitchLimb.readDerivedBySwitchIdx";
		CFGenKbGelSwitchLimbBySwitchIdxKey key = schema.getFactoryGelSwitchLimb().newSwitchIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );

		CFGenKbGelSwitchLimbBuff[] recArray;
		if( dictBySwitchIdx.containsKey( key ) ) {
			Map< CFGenKbGelSwitchLimbPKey, CFGenKbGelSwitchLimbBuff > subdictSwitchIdx
				= dictBySwitchIdx.get( key );
			recArray = new CFGenKbGelSwitchLimbBuff[ subdictSwitchIdx.size() ];
			Iterator< CFGenKbGelSwitchLimbBuff > iter = subdictSwitchIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelSwitchLimbPKey, CFGenKbGelSwitchLimbBuff > subdictSwitchIdx
				= new HashMap< CFGenKbGelSwitchLimbPKey, CFGenKbGelSwitchLimbBuff >();
			dictBySwitchIdx.put( key, subdictSwitchIdx );
			recArray = new CFGenKbGelSwitchLimbBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelSwitchLimbBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId,
		String LimbName )
	{
		final String S_ProcName = "CFGenKbRamGelSwitchLimb.readDerivedByPIdx() ";
		CFGenKbGelSwitchLimbPKey key = schema.getFactoryGelSwitchLimb().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );
		key.setRequiredLimbName( LimbName );

		CFGenKbGelSwitchLimbBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSwitchLimbBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelSwitchLimb.readBuff";
		CFGenKbGelSwitchLimbBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GLIM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSwitchLimbBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGelSwitchLimbBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GLIM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelSwitchLimbBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGelSwitchLimb.readAllBuff";
		CFGenKbGelSwitchLimbBuff buff;
		ArrayList<CFGenKbGelSwitchLimbBuff> filteredList = new ArrayList<CFGenKbGelSwitchLimbBuff>();
		CFGenKbGelSwitchLimbBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GLIM" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSwitchLimbBuff[0] ) );
	}

	public CFGenKbGelSwitchLimbBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId,
		String LimbName )
	{
		final String S_ProcName = "CFGenKbRamGelSwitchLimb.readBuffByPIdx() ";
		CFGenKbGelSwitchLimbBuff buff = readDerivedByPIdx( Authorization,
			TenantId,
			GelCacheId,
			GelInstId,
			LimbName );
		if( ( buff != null ) && buff.getClassCode().equals( "GLIM" ) ) {
			return( (CFGenKbGelSwitchLimbBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGelSwitchLimbBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGelSwitchLimb.readBuffByTenantIdx() ";
		CFGenKbGelSwitchLimbBuff buff;
		ArrayList<CFGenKbGelSwitchLimbBuff> filteredList = new ArrayList<CFGenKbGelSwitchLimbBuff>();
		CFGenKbGelSwitchLimbBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GLIM" ) ) {
				filteredList.add( (CFGenKbGelSwitchLimbBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSwitchLimbBuff[0] ) );
	}

	public CFGenKbGelSwitchLimbBuff[] readBuffBySwitchIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelSwitchLimb.readBuffBySwitchIdx() ";
		CFGenKbGelSwitchLimbBuff buff;
		ArrayList<CFGenKbGelSwitchLimbBuff> filteredList = new ArrayList<CFGenKbGelSwitchLimbBuff>();
		CFGenKbGelSwitchLimbBuff[] buffList = readDerivedBySwitchIdx( Authorization,
			TenantId,
			GelCacheId,
			GelInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GLIM" ) ) {
				filteredList.add( (CFGenKbGelSwitchLimbBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelSwitchLimbBuff[0] ) );
	}

	public void updateGelSwitchLimb( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbBuff Buff )
	{
		CFGenKbGelSwitchLimbPKey pkey = schema.getFactoryGelSwitchLimb().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		pkey.setRequiredLimbName( Buff.getRequiredLimbName() );
		CFGenKbGelSwitchLimbBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGelSwitchLimb",
				"Existing record not found",
				"GelSwitchLimb",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateGelSwitchLimb",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbGelSwitchLimbByTenantIdxKey existingKeyTenantIdx = schema.getFactoryGelSwitchLimb().newTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFGenKbGelSwitchLimbByTenantIdxKey newKeyTenantIdx = schema.getFactoryGelSwitchLimb().newTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFGenKbGelSwitchLimbBySwitchIdxKey existingKeySwitchIdx = schema.getFactoryGelSwitchLimb().newSwitchIdxKey();
		existingKeySwitchIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeySwitchIdx.setRequiredGelCacheId( existing.getRequiredGelCacheId() );
		existingKeySwitchIdx.setRequiredGelInstId( existing.getRequiredGelInstId() );

		CFGenKbGelSwitchLimbBySwitchIdxKey newKeySwitchIdx = schema.getFactoryGelSwitchLimb().newSwitchIdxKey();
		newKeySwitchIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeySwitchIdx.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		newKeySwitchIdx.setRequiredGelInstId( Buff.getRequiredGelInstId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateGelSwitchLimb",
						"Owner",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGelSwitchLimbPKey, CFGenKbGelSwitchLimbBuff > subdict;

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
			subdict = new HashMap< CFGenKbGelSwitchLimbPKey, CFGenKbGelSwitchLimbBuff >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictBySwitchIdx.get( existingKeySwitchIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySwitchIdx.containsKey( newKeySwitchIdx ) ) {
			subdict = dictBySwitchIdx.get( newKeySwitchIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelSwitchLimbPKey, CFGenKbGelSwitchLimbBuff >();
			dictBySwitchIdx.put( newKeySwitchIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteGelSwitchLimb( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGelSwitchLimbTable.deleteGelSwitchLimb() ";
		String classCode;
		CFGenKbGelSwitchLimbPKey pkey = schema.getFactoryGelSwitchLimb().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		pkey.setRequiredLimbName( Buff.getRequiredLimbName() );
		CFGenKbGelSwitchLimbBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGelSwitchLimb",
				pkey );
		}
		CFGenKbGelSwitchLimbByTenantIdxKey keyTenantIdx = schema.getFactoryGelSwitchLimb().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFGenKbGelSwitchLimbBySwitchIdxKey keySwitchIdx = schema.getFactoryGelSwitchLimb().newSwitchIdxKey();
		keySwitchIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keySwitchIdx.setRequiredGelCacheId( existing.getRequiredGelCacheId() );
		keySwitchIdx.setRequiredGelInstId( existing.getRequiredGelInstId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbGelSwitchLimbPKey, CFGenKbGelSwitchLimbBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		subdict = dictBySwitchIdx.get( keySwitchIdx );
		subdict.remove( pkey );

	}
	public void deleteGelSwitchLimbByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId,
		String argLimbName )
	{
		CFGenKbGelSwitchLimbPKey key = schema.getFactoryGelSwitchLimb().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		key.setRequiredGelInstId( argGelInstId );
		key.setRequiredLimbName( argLimbName );
		deleteGelSwitchLimbByPIdx( Authorization, key );
	}

	public void deleteGelSwitchLimbByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGelSwitchLimbBuff cur;
		LinkedList<CFGenKbGelSwitchLimbBuff> matchSet = new LinkedList<CFGenKbGelSwitchLimbBuff>();
		Iterator<CFGenKbGelSwitchLimbBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSwitchLimbBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSwitchLimb().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId(),
				cur.getRequiredLimbName() );
			deleteGelSwitchLimb( Authorization, cur );
		}
	}

	public void deleteGelSwitchLimbByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGelSwitchLimbByTenantIdxKey key = schema.getFactoryGelSwitchLimb().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGelSwitchLimbByTenantIdx( Authorization, key );
	}

	public void deleteGelSwitchLimbByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbByTenantIdxKey argKey )
	{
		CFGenKbGelSwitchLimbBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelSwitchLimbBuff> matchSet = new LinkedList<CFGenKbGelSwitchLimbBuff>();
		Iterator<CFGenKbGelSwitchLimbBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSwitchLimbBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSwitchLimb().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId(),
				cur.getRequiredLimbName() );
			deleteGelSwitchLimb( Authorization, cur );
		}
	}

	public void deleteGelSwitchLimbBySwitchIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId )
	{
		CFGenKbGelSwitchLimbBySwitchIdxKey key = schema.getFactoryGelSwitchLimb().newSwitchIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		key.setRequiredGelInstId( argGelInstId );
		deleteGelSwitchLimbBySwitchIdx( Authorization, key );
	}

	public void deleteGelSwitchLimbBySwitchIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelSwitchLimbBySwitchIdxKey argKey )
	{
		CFGenKbGelSwitchLimbBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelSwitchLimbBuff> matchSet = new LinkedList<CFGenKbGelSwitchLimbBuff>();
		Iterator<CFGenKbGelSwitchLimbBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelSwitchLimbBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelSwitchLimb().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId(),
				cur.getRequiredLimbName() );
			deleteGelSwitchLimb( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
