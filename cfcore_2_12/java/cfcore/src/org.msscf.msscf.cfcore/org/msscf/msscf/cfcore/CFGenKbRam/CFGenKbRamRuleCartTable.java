
// Description: Java 11 in-memory RAM DbIO implementation for RuleCart.

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
 *	CFGenKbRamRuleCartTable in-memory RAM DbIO implementation
 *	for RuleCart.
 */
public class CFGenKbRamRuleCartTable
	implements ICFGenKbRuleCartTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbRuleCartPKey,
				CFGenKbRuleCartBuff > dictByPKey
		= new HashMap< CFGenKbRuleCartPKey,
				CFGenKbRuleCartBuff >();
	private Map< CFGenKbRuleCartByTenantIdxKey,
				Map< CFGenKbRuleCartPKey,
					CFGenKbRuleCartBuff >> dictByTenantIdx
		= new HashMap< CFGenKbRuleCartByTenantIdxKey,
				Map< CFGenKbRuleCartPKey,
					CFGenKbRuleCartBuff >>();
	private Map< CFGenKbRuleCartByNameIdxKey,
			CFGenKbRuleCartBuff > dictByNameIdx
		= new HashMap< CFGenKbRuleCartByNameIdxKey,
			CFGenKbRuleCartBuff >();

	public CFGenKbRamRuleCartTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createRuleCart( CFGenKbAuthorization Authorization,
		CFGenKbRuleCartBuff Buff )
	{
		final String S_ProcName = "createRuleCart";
		CFGenKbRuleCartPKey pkey = schema.getFactoryRuleCart().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( ((CFGenKbRamTenantTable)schema.getTableTenant()).nextRuleCartIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFGenKbRuleCartByTenantIdxKey keyTenantIdx = schema.getFactoryRuleCart().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFGenKbRuleCartByNameIdxKey keyNameIdx = schema.getFactoryRuleCart().newNameIdxKey();
		keyNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"RuleCartName",
				keyNameIdx );
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
						"Container",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbRuleCartPKey, CFGenKbRuleCartBuff > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< CFGenKbRuleCartPKey, CFGenKbRuleCartBuff >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

	}

	public CFGenKbRuleCartBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbRuleCartPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamRuleCart.readDerived";
		CFGenKbRuleCartPKey key = schema.getFactoryRuleCart().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFGenKbRuleCartBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbRuleCartBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbRuleCartPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamRuleCart.readDerived";
		CFGenKbRuleCartPKey key = schema.getFactoryRuleCart().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFGenKbRuleCartBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbRuleCartBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamRuleCart.readAllDerived";
		CFGenKbRuleCartBuff[] retList = new CFGenKbRuleCartBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbRuleCartBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbRuleCartBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamRuleCart.readDerivedByTenantIdx";
		CFGenKbRuleCartByTenantIdxKey key = schema.getFactoryRuleCart().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFGenKbRuleCartBuff[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFGenKbRuleCartPKey, CFGenKbRuleCartBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new CFGenKbRuleCartBuff[ subdictTenantIdx.size() ];
			Iterator< CFGenKbRuleCartBuff > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbRuleCartPKey, CFGenKbRuleCartBuff > subdictTenantIdx
				= new HashMap< CFGenKbRuleCartPKey, CFGenKbRuleCartBuff >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new CFGenKbRuleCartBuff[0];
		}
		return( recArray );
	}

	public CFGenKbRuleCartBuff readDerivedByNameIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		String Name )
	{
		final String S_ProcName = "CFGenKbRamRuleCart.readDerivedByNameIdx";
		CFGenKbRuleCartByNameIdxKey key = schema.getFactoryRuleCart().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );

		CFGenKbRuleCartBuff buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbRuleCartBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFGenKbRamRuleCart.readDerivedByIdIdx() ";
		CFGenKbRuleCartPKey key = schema.getFactoryRuleCart().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFGenKbRuleCartBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbRuleCartBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbRuleCartPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamRuleCart.readBuff";
		CFGenKbRuleCartBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "RCT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbRuleCartBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbRuleCartPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbRuleCartBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "RCT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbRuleCartBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamRuleCart.readAllBuff";
		CFGenKbRuleCartBuff buff;
		ArrayList<CFGenKbRuleCartBuff> filteredList = new ArrayList<CFGenKbRuleCartBuff>();
		CFGenKbRuleCartBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RCT" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbRuleCartBuff[0] ) );
	}

	public CFGenKbRuleCartBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFGenKbRamRuleCart.readBuffByIdIdx() ";
		CFGenKbRuleCartBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "RCT" ) ) {
			return( (CFGenKbRuleCartBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbRuleCartBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamRuleCart.readBuffByTenantIdx() ";
		CFGenKbRuleCartBuff buff;
		ArrayList<CFGenKbRuleCartBuff> filteredList = new ArrayList<CFGenKbRuleCartBuff>();
		CFGenKbRuleCartBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RCT" ) ) {
				filteredList.add( (CFGenKbRuleCartBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbRuleCartBuff[0] ) );
	}

	public CFGenKbRuleCartBuff readBuffByNameIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		String Name )
	{
		final String S_ProcName = "CFGenKbRamRuleCart.readBuffByNameIdx() ";
		CFGenKbRuleCartBuff buff = readDerivedByNameIdx( Authorization,
			TenantId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "RCT" ) ) {
			return( (CFGenKbRuleCartBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateRuleCart( CFGenKbAuthorization Authorization,
		CFGenKbRuleCartBuff Buff )
	{
		CFGenKbRuleCartPKey pkey = schema.getFactoryRuleCart().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFGenKbRuleCartBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateRuleCart",
				"Existing record not found",
				"RuleCart",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateRuleCart",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbRuleCartByTenantIdxKey existingKeyTenantIdx = schema.getFactoryRuleCart().newTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFGenKbRuleCartByTenantIdxKey newKeyTenantIdx = schema.getFactoryRuleCart().newTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFGenKbRuleCartByNameIdxKey existingKeyNameIdx = schema.getFactoryRuleCart().newNameIdxKey();
		existingKeyNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		CFGenKbRuleCartByNameIdxKey newKeyNameIdx = schema.getFactoryRuleCart().newNameIdxKey();
		newKeyNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateRuleCart",
					"RuleCartName",
					newKeyNameIdx );
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
						"updateRuleCart",
						"Container",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbRuleCartPKey, CFGenKbRuleCartBuff > subdict;

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
			subdict = new HashMap< CFGenKbRuleCartPKey, CFGenKbRuleCartBuff >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

	}

	public void deleteRuleCart( CFGenKbAuthorization Authorization,
		CFGenKbRuleCartBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamRuleCartTable.deleteRuleCart() ";
		String classCode;
		CFGenKbRuleCartPKey pkey = schema.getFactoryRuleCart().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFGenKbRuleCartBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteRuleCart",
				pkey );
		}
					schema.getTableGenItem().deleteGenItemByCartIdx( Authorization,
						existing.getRequiredTenantId(),
						existing.getRequiredId() );
		CFGenKbRuleCartByTenantIdxKey keyTenantIdx = schema.getFactoryRuleCart().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFGenKbRuleCartByNameIdxKey keyNameIdx = schema.getFactoryRuleCart().newNameIdxKey();
		keyNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbRuleCartPKey, CFGenKbRuleCartBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		dictByNameIdx.remove( keyNameIdx );

	}
	public void deleteRuleCartByIdIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFGenKbRuleCartPKey key = schema.getFactoryRuleCart().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteRuleCartByIdIdx( Authorization, key );
	}

	public void deleteRuleCartByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbRuleCartPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbRuleCartBuff cur;
		LinkedList<CFGenKbRuleCartBuff> matchSet = new LinkedList<CFGenKbRuleCartBuff>();
		Iterator<CFGenKbRuleCartBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbRuleCartBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableRuleCart().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			deleteRuleCart( Authorization, cur );
		}
	}

	public void deleteRuleCartByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbRuleCartByTenantIdxKey key = schema.getFactoryRuleCart().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteRuleCartByTenantIdx( Authorization, key );
	}

	public void deleteRuleCartByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbRuleCartByTenantIdxKey argKey )
	{
		CFGenKbRuleCartBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbRuleCartBuff> matchSet = new LinkedList<CFGenKbRuleCartBuff>();
		Iterator<CFGenKbRuleCartBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbRuleCartBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableRuleCart().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			deleteRuleCart( Authorization, cur );
		}
	}

	public void deleteRuleCartByNameIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		String argName )
	{
		CFGenKbRuleCartByNameIdxKey key = schema.getFactoryRuleCart().newNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredName( argName );
		deleteRuleCartByNameIdx( Authorization, key );
	}

	public void deleteRuleCartByNameIdx( CFGenKbAuthorization Authorization,
		CFGenKbRuleCartByNameIdxKey argKey )
	{
		CFGenKbRuleCartBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbRuleCartBuff> matchSet = new LinkedList<CFGenKbRuleCartBuff>();
		Iterator<CFGenKbRuleCartBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbRuleCartBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableRuleCart().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			deleteRuleCart( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
