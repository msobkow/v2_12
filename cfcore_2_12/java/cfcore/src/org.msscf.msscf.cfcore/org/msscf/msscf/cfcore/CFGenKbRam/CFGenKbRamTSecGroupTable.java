
// Description: Java 11 in-memory RAM DbIO implementation for TSecGroup.

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
 *	CFGenKbRamTSecGroupTable in-memory RAM DbIO implementation
 *	for TSecGroup.
 */
public class CFGenKbRamTSecGroupTable
	implements ICFGenKbTSecGroupTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbTSecGroupPKey,
				CFGenKbTSecGroupBuff > dictByPKey
		= new HashMap< CFGenKbTSecGroupPKey,
				CFGenKbTSecGroupBuff >();
	private Map< CFGenKbTSecGroupByTenantIdxKey,
				Map< CFGenKbTSecGroupPKey,
					CFGenKbTSecGroupBuff >> dictByTenantIdx
		= new HashMap< CFGenKbTSecGroupByTenantIdxKey,
				Map< CFGenKbTSecGroupPKey,
					CFGenKbTSecGroupBuff >>();
	private Map< CFGenKbTSecGroupByTenantVisIdxKey,
				Map< CFGenKbTSecGroupPKey,
					CFGenKbTSecGroupBuff >> dictByTenantVisIdx
		= new HashMap< CFGenKbTSecGroupByTenantVisIdxKey,
				Map< CFGenKbTSecGroupPKey,
					CFGenKbTSecGroupBuff >>();
	private Map< CFGenKbTSecGroupByUNameIdxKey,
			CFGenKbTSecGroupBuff > dictByUNameIdx
		= new HashMap< CFGenKbTSecGroupByUNameIdxKey,
			CFGenKbTSecGroupBuff >();

	public CFGenKbRamTSecGroupTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createTSecGroup( CFGenKbAuthorization Authorization,
		CFGenKbTSecGroupBuff Buff )
	{
		final String S_ProcName = "createTSecGroup";
		CFGenKbTSecGroupPKey pkey = schema.getFactoryTSecGroup().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTSecGroupId( ((CFGenKbRamTenantTable)schema.getTableTenant()).nextTSecGroupIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredTSecGroupId( pkey.getRequiredTSecGroupId() );
		CFGenKbTSecGroupByTenantIdxKey keyTenantIdx = schema.getFactoryTSecGroup().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFGenKbTSecGroupByTenantVisIdxKey keyTenantVisIdx = schema.getFactoryTSecGroup().newTenantVisIdxKey();
		keyTenantVisIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyTenantVisIdx.setRequiredIsVisible( Buff.getRequiredIsVisible() );

		CFGenKbTSecGroupByUNameIdxKey keyUNameIdx = schema.getFactoryTSecGroup().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TSecGroupUNameIdx",
				keyUNameIdx );
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
						"TSecGroupTenant",
						"Tenant",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbTSecGroupPKey, CFGenKbTSecGroupBuff > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< CFGenKbTSecGroupPKey, CFGenKbTSecGroupBuff >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		Map< CFGenKbTSecGroupPKey, CFGenKbTSecGroupBuff > subdictTenantVisIdx;
		if( dictByTenantVisIdx.containsKey( keyTenantVisIdx ) ) {
			subdictTenantVisIdx = dictByTenantVisIdx.get( keyTenantVisIdx );
		}
		else {
			subdictTenantVisIdx = new HashMap< CFGenKbTSecGroupPKey, CFGenKbTSecGroupBuff >();
			dictByTenantVisIdx.put( keyTenantVisIdx, subdictTenantVisIdx );
		}
		subdictTenantVisIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFGenKbTSecGroupBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbTSecGroupPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamTSecGroup.readDerived";
		CFGenKbTSecGroupPKey key = schema.getFactoryTSecGroup().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredTSecGroupId( PKey.getRequiredTSecGroupId() );
		CFGenKbTSecGroupBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTSecGroupBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbTSecGroupPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamTSecGroup.readDerived";
		CFGenKbTSecGroupPKey key = schema.getFactoryTSecGroup().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredTSecGroupId( PKey.getRequiredTSecGroupId() );
		CFGenKbTSecGroupBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTSecGroupBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamTSecGroup.readAllDerived";
		CFGenKbTSecGroupBuff[] retList = new CFGenKbTSecGroupBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbTSecGroupBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbTSecGroupBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamTSecGroup.readDerivedByTenantIdx";
		CFGenKbTSecGroupByTenantIdxKey key = schema.getFactoryTSecGroup().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFGenKbTSecGroupBuff[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFGenKbTSecGroupPKey, CFGenKbTSecGroupBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new CFGenKbTSecGroupBuff[ subdictTenantIdx.size() ];
			Iterator< CFGenKbTSecGroupBuff > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbTSecGroupPKey, CFGenKbTSecGroupBuff > subdictTenantIdx
				= new HashMap< CFGenKbTSecGroupPKey, CFGenKbTSecGroupBuff >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new CFGenKbTSecGroupBuff[0];
		}
		return( recArray );
	}

	public CFGenKbTSecGroupBuff[] readDerivedByTenantVisIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		boolean IsVisible )
	{
		final String S_ProcName = "CFGenKbRamTSecGroup.readDerivedByTenantVisIdx";
		CFGenKbTSecGroupByTenantVisIdxKey key = schema.getFactoryTSecGroup().newTenantVisIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIsVisible( IsVisible );

		CFGenKbTSecGroupBuff[] recArray;
		if( dictByTenantVisIdx.containsKey( key ) ) {
			Map< CFGenKbTSecGroupPKey, CFGenKbTSecGroupBuff > subdictTenantVisIdx
				= dictByTenantVisIdx.get( key );
			recArray = new CFGenKbTSecGroupBuff[ subdictTenantVisIdx.size() ];
			Iterator< CFGenKbTSecGroupBuff > iter = subdictTenantVisIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbTSecGroupPKey, CFGenKbTSecGroupBuff > subdictTenantVisIdx
				= new HashMap< CFGenKbTSecGroupPKey, CFGenKbTSecGroupBuff >();
			dictByTenantVisIdx.put( key, subdictTenantVisIdx );
			recArray = new CFGenKbTSecGroupBuff[0];
		}
		return( recArray );
	}

	public CFGenKbTSecGroupBuff readDerivedByUNameIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		String Name )
	{
		final String S_ProcName = "CFGenKbRamTSecGroup.readDerivedByUNameIdx";
		CFGenKbTSecGroupByUNameIdxKey key = schema.getFactoryTSecGroup().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );

		CFGenKbTSecGroupBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTSecGroupBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		int TSecGroupId )
	{
		final String S_ProcName = "CFGenKbRamTSecGroup.readDerivedByIdIdx() ";
		CFGenKbTSecGroupPKey key = schema.getFactoryTSecGroup().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );

		CFGenKbTSecGroupBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTSecGroupBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbTSecGroupPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamTSecGroup.readBuff";
		CFGenKbTSecGroupBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TGRP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTSecGroupBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbTSecGroupPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbTSecGroupBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TGRP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTSecGroupBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamTSecGroup.readAllBuff";
		CFGenKbTSecGroupBuff buff;
		ArrayList<CFGenKbTSecGroupBuff> filteredList = new ArrayList<CFGenKbTSecGroupBuff>();
		CFGenKbTSecGroupBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGRP" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbTSecGroupBuff[0] ) );
	}

	public CFGenKbTSecGroupBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		int TSecGroupId )
	{
		final String S_ProcName = "CFGenKbRamTSecGroup.readBuffByIdIdx() ";
		CFGenKbTSecGroupBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			TSecGroupId );
		if( ( buff != null ) && buff.getClassCode().equals( "TGRP" ) ) {
			return( (CFGenKbTSecGroupBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbTSecGroupBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamTSecGroup.readBuffByTenantIdx() ";
		CFGenKbTSecGroupBuff buff;
		ArrayList<CFGenKbTSecGroupBuff> filteredList = new ArrayList<CFGenKbTSecGroupBuff>();
		CFGenKbTSecGroupBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGRP" ) ) {
				filteredList.add( (CFGenKbTSecGroupBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbTSecGroupBuff[0] ) );
	}

	public CFGenKbTSecGroupBuff[] readBuffByTenantVisIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		boolean IsVisible )
	{
		final String S_ProcName = "CFGenKbRamTSecGroup.readBuffByTenantVisIdx() ";
		CFGenKbTSecGroupBuff buff;
		ArrayList<CFGenKbTSecGroupBuff> filteredList = new ArrayList<CFGenKbTSecGroupBuff>();
		CFGenKbTSecGroupBuff[] buffList = readDerivedByTenantVisIdx( Authorization,
			TenantId,
			IsVisible );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TGRP" ) ) {
				filteredList.add( (CFGenKbTSecGroupBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbTSecGroupBuff[0] ) );
	}

	public CFGenKbTSecGroupBuff readBuffByUNameIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		String Name )
	{
		final String S_ProcName = "CFGenKbRamTSecGroup.readBuffByUNameIdx() ";
		CFGenKbTSecGroupBuff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "TGRP" ) ) {
			return( (CFGenKbTSecGroupBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateTSecGroup( CFGenKbAuthorization Authorization,
		CFGenKbTSecGroupBuff Buff )
	{
		CFGenKbTSecGroupPKey pkey = schema.getFactoryTSecGroup().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );
		CFGenKbTSecGroupBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateTSecGroup",
				"Existing record not found",
				"TSecGroup",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateTSecGroup",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbTSecGroupByTenantIdxKey existingKeyTenantIdx = schema.getFactoryTSecGroup().newTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFGenKbTSecGroupByTenantIdxKey newKeyTenantIdx = schema.getFactoryTSecGroup().newTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFGenKbTSecGroupByTenantVisIdxKey existingKeyTenantVisIdx = schema.getFactoryTSecGroup().newTenantVisIdxKey();
		existingKeyTenantVisIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyTenantVisIdx.setRequiredIsVisible( existing.getRequiredIsVisible() );

		CFGenKbTSecGroupByTenantVisIdxKey newKeyTenantVisIdx = schema.getFactoryTSecGroup().newTenantVisIdxKey();
		newKeyTenantVisIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyTenantVisIdx.setRequiredIsVisible( Buff.getRequiredIsVisible() );

		CFGenKbTSecGroupByUNameIdxKey existingKeyUNameIdx = schema.getFactoryTSecGroup().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFGenKbTSecGroupByUNameIdxKey newKeyUNameIdx = schema.getFactoryTSecGroup().newUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateTSecGroup",
					"TSecGroupUNameIdx",
					newKeyUNameIdx );
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
						"updateTSecGroup",
						"Container",
						"TSecGroupTenant",
						"Tenant",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbTSecGroupPKey, CFGenKbTSecGroupBuff > subdict;

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
			subdict = new HashMap< CFGenKbTSecGroupPKey, CFGenKbTSecGroupBuff >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByTenantVisIdx.get( existingKeyTenantVisIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTenantVisIdx.containsKey( newKeyTenantVisIdx ) ) {
			subdict = dictByTenantVisIdx.get( newKeyTenantVisIdx );
		}
		else {
			subdict = new HashMap< CFGenKbTSecGroupPKey, CFGenKbTSecGroupBuff >();
			dictByTenantVisIdx.put( newKeyTenantVisIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteTSecGroup( CFGenKbAuthorization Authorization,
		CFGenKbTSecGroupBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamTSecGroupTable.deleteTSecGroup() ";
		String classCode;
		CFGenKbTSecGroupPKey pkey = schema.getFactoryTSecGroup().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredTSecGroupId( Buff.getRequiredTSecGroupId() );
		CFGenKbTSecGroupBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteTSecGroup",
				pkey );
		}
					schema.getTableTSecGrpInc().deleteTSecGrpIncByIncludeIdx( Authorization,
						existing.getRequiredTenantId(),
						existing.getRequiredTSecGroupId() );
					schema.getTableTSecGrpMemb().deleteTSecGrpMembByGroupIdx( Authorization,
						existing.getRequiredTenantId(),
						existing.getRequiredTSecGroupId() );
					schema.getTableTSecGrpInc().deleteTSecGrpIncByGroupIdx( Authorization,
						existing.getRequiredTenantId(),
						existing.getRequiredTSecGroupId() );
		CFGenKbTSecGroupByTenantIdxKey keyTenantIdx = schema.getFactoryTSecGroup().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFGenKbTSecGroupByTenantVisIdxKey keyTenantVisIdx = schema.getFactoryTSecGroup().newTenantVisIdxKey();
		keyTenantVisIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyTenantVisIdx.setRequiredIsVisible( existing.getRequiredIsVisible() );

		CFGenKbTSecGroupByUNameIdxKey keyUNameIdx = schema.getFactoryTSecGroup().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbTSecGroupPKey, CFGenKbTSecGroupBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		subdict = dictByTenantVisIdx.get( keyTenantVisIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}
	public void deleteTSecGroupByIdIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		int argTSecGroupId )
	{
		CFGenKbTSecGroupPKey key = schema.getFactoryTSecGroup().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTSecGroupId( argTSecGroupId );
		deleteTSecGroupByIdIdx( Authorization, key );
	}

	public void deleteTSecGroupByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbTSecGroupPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbTSecGroupBuff cur;
		LinkedList<CFGenKbTSecGroupBuff> matchSet = new LinkedList<CFGenKbTSecGroupBuff>();
		Iterator<CFGenKbTSecGroupBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbTSecGroupBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTSecGroup().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredTSecGroupId() );
			deleteTSecGroup( Authorization, cur );
		}
	}

	public void deleteTSecGroupByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbTSecGroupByTenantIdxKey key = schema.getFactoryTSecGroup().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTSecGroupByTenantIdx( Authorization, key );
	}

	public void deleteTSecGroupByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbTSecGroupByTenantIdxKey argKey )
	{
		CFGenKbTSecGroupBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbTSecGroupBuff> matchSet = new LinkedList<CFGenKbTSecGroupBuff>();
		Iterator<CFGenKbTSecGroupBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbTSecGroupBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTSecGroup().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredTSecGroupId() );
			deleteTSecGroup( Authorization, cur );
		}
	}

	public void deleteTSecGroupByTenantVisIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		boolean argIsVisible )
	{
		CFGenKbTSecGroupByTenantVisIdxKey key = schema.getFactoryTSecGroup().newTenantVisIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredIsVisible( argIsVisible );
		deleteTSecGroupByTenantVisIdx( Authorization, key );
	}

	public void deleteTSecGroupByTenantVisIdx( CFGenKbAuthorization Authorization,
		CFGenKbTSecGroupByTenantVisIdxKey argKey )
	{
		CFGenKbTSecGroupBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbTSecGroupBuff> matchSet = new LinkedList<CFGenKbTSecGroupBuff>();
		Iterator<CFGenKbTSecGroupBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbTSecGroupBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTSecGroup().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredTSecGroupId() );
			deleteTSecGroup( Authorization, cur );
		}
	}

	public void deleteTSecGroupByUNameIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		String argName )
	{
		CFGenKbTSecGroupByUNameIdxKey key = schema.getFactoryTSecGroup().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredName( argName );
		deleteTSecGroupByUNameIdx( Authorization, key );
	}

	public void deleteTSecGroupByUNameIdx( CFGenKbAuthorization Authorization,
		CFGenKbTSecGroupByUNameIdxKey argKey )
	{
		CFGenKbTSecGroupBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbTSecGroupBuff> matchSet = new LinkedList<CFGenKbTSecGroupBuff>();
		Iterator<CFGenKbTSecGroupBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbTSecGroupBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTSecGroup().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredTSecGroupId() );
			deleteTSecGroup( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
