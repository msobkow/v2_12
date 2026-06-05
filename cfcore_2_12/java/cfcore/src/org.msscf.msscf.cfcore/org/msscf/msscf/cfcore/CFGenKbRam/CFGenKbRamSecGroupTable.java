
// Description: Java 11 in-memory RAM DbIO implementation for SecGroup.

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
 *	CFGenKbRamSecGroupTable in-memory RAM DbIO implementation
 *	for SecGroup.
 */
public class CFGenKbRamSecGroupTable
	implements ICFGenKbSecGroupTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbSecGroupPKey,
				CFGenKbSecGroupBuff > dictByPKey
		= new HashMap< CFGenKbSecGroupPKey,
				CFGenKbSecGroupBuff >();
	private Map< CFGenKbSecGroupByClusterIdxKey,
				Map< CFGenKbSecGroupPKey,
					CFGenKbSecGroupBuff >> dictByClusterIdx
		= new HashMap< CFGenKbSecGroupByClusterIdxKey,
				Map< CFGenKbSecGroupPKey,
					CFGenKbSecGroupBuff >>();
	private Map< CFGenKbSecGroupByClusterVisIdxKey,
				Map< CFGenKbSecGroupPKey,
					CFGenKbSecGroupBuff >> dictByClusterVisIdx
		= new HashMap< CFGenKbSecGroupByClusterVisIdxKey,
				Map< CFGenKbSecGroupPKey,
					CFGenKbSecGroupBuff >>();
	private Map< CFGenKbSecGroupByUNameIdxKey,
			CFGenKbSecGroupBuff > dictByUNameIdx
		= new HashMap< CFGenKbSecGroupByUNameIdxKey,
			CFGenKbSecGroupBuff >();

	public CFGenKbRamSecGroupTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecGroup( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupBuff Buff )
	{
		final String S_ProcName = "createSecGroup";
		CFGenKbSecGroupPKey pkey = schema.getFactorySecGroup().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGroupId( ((CFGenKbRamClusterTable)schema.getTableCluster()).nextSecGroupIdGen( Authorization,
			Buff.getRequiredClusterId() ) );
		Buff.setRequiredClusterId( pkey.getRequiredClusterId() );
		Buff.setRequiredSecGroupId( pkey.getRequiredSecGroupId() );
		CFGenKbSecGroupByClusterIdxKey keyClusterIdx = schema.getFactorySecGroup().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFGenKbSecGroupByClusterVisIdxKey keyClusterVisIdx = schema.getFactorySecGroup().newClusterVisIdxKey();
		keyClusterVisIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyClusterVisIdx.setRequiredIsVisible( Buff.getRequiredIsVisible() );

		CFGenKbSecGroupByUNameIdxKey keyUNameIdx = schema.getFactorySecGroup().newUNameIdxKey();
		keyUNameIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecGroupUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableCluster().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"SecGroupCluster",
						"Cluster",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbSecGroupPKey, CFGenKbSecGroupBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFGenKbSecGroupPKey, CFGenKbSecGroupBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		Map< CFGenKbSecGroupPKey, CFGenKbSecGroupBuff > subdictClusterVisIdx;
		if( dictByClusterVisIdx.containsKey( keyClusterVisIdx ) ) {
			subdictClusterVisIdx = dictByClusterVisIdx.get( keyClusterVisIdx );
		}
		else {
			subdictClusterVisIdx = new HashMap< CFGenKbSecGroupPKey, CFGenKbSecGroupBuff >();
			dictByClusterVisIdx.put( keyClusterVisIdx, subdictClusterVisIdx );
		}
		subdictClusterVisIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFGenKbSecGroupBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecGroup.readDerived";
		CFGenKbSecGroupPKey key = schema.getFactorySecGroup().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecGroupId( PKey.getRequiredSecGroupId() );
		CFGenKbSecGroupBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGroupBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecGroup.readDerived";
		CFGenKbSecGroupPKey key = schema.getFactorySecGroup().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecGroupId( PKey.getRequiredSecGroupId() );
		CFGenKbSecGroupBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGroupBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamSecGroup.readAllDerived";
		CFGenKbSecGroupBuff[] retList = new CFGenKbSecGroupBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbSecGroupBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbSecGroupBuff[] readDerivedByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFGenKbRamSecGroup.readDerivedByClusterIdx";
		CFGenKbSecGroupByClusterIdxKey key = schema.getFactorySecGroup().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFGenKbSecGroupBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFGenKbSecGroupPKey, CFGenKbSecGroupBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFGenKbSecGroupBuff[ subdictClusterIdx.size() ];
			Iterator< CFGenKbSecGroupBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecGroupPKey, CFGenKbSecGroupBuff > subdictClusterIdx
				= new HashMap< CFGenKbSecGroupPKey, CFGenKbSecGroupBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFGenKbSecGroupBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecGroupBuff[] readDerivedByClusterVisIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		boolean IsVisible )
	{
		final String S_ProcName = "CFGenKbRamSecGroup.readDerivedByClusterVisIdx";
		CFGenKbSecGroupByClusterVisIdxKey key = schema.getFactorySecGroup().newClusterVisIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredIsVisible( IsVisible );

		CFGenKbSecGroupBuff[] recArray;
		if( dictByClusterVisIdx.containsKey( key ) ) {
			Map< CFGenKbSecGroupPKey, CFGenKbSecGroupBuff > subdictClusterVisIdx
				= dictByClusterVisIdx.get( key );
			recArray = new CFGenKbSecGroupBuff[ subdictClusterVisIdx.size() ];
			Iterator< CFGenKbSecGroupBuff > iter = subdictClusterVisIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecGroupPKey, CFGenKbSecGroupBuff > subdictClusterVisIdx
				= new HashMap< CFGenKbSecGroupPKey, CFGenKbSecGroupBuff >();
			dictByClusterVisIdx.put( key, subdictClusterVisIdx );
			recArray = new CFGenKbSecGroupBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecGroupBuff readDerivedByUNameIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		String Name )
	{
		final String S_ProcName = "CFGenKbRamSecGroup.readDerivedByUNameIdx";
		CFGenKbSecGroupByUNameIdxKey key = schema.getFactorySecGroup().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredName( Name );

		CFGenKbSecGroupBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGroupBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		final String S_ProcName = "CFGenKbRamSecGroup.readDerivedByIdIdx() ";
		CFGenKbSecGroupPKey key = schema.getFactorySecGroup().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );

		CFGenKbSecGroupBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGroupBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecGroup.readBuff";
		CFGenKbSecGroupBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SGRP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGroupBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbSecGroupBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SGRP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGroupBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamSecGroup.readAllBuff";
		CFGenKbSecGroupBuff buff;
		ArrayList<CFGenKbSecGroupBuff> filteredList = new ArrayList<CFGenKbSecGroupBuff>();
		CFGenKbSecGroupBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGRP" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecGroupBuff[0] ) );
	}

	public CFGenKbSecGroupBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		final String S_ProcName = "CFGenKbRamSecGroup.readBuffByIdIdx() ";
		CFGenKbSecGroupBuff buff = readDerivedByIdIdx( Authorization,
			ClusterId,
			SecGroupId );
		if( ( buff != null ) && buff.getClassCode().equals( "SGRP" ) ) {
			return( (CFGenKbSecGroupBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbSecGroupBuff[] readBuffByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFGenKbRamSecGroup.readBuffByClusterIdx() ";
		CFGenKbSecGroupBuff buff;
		ArrayList<CFGenKbSecGroupBuff> filteredList = new ArrayList<CFGenKbSecGroupBuff>();
		CFGenKbSecGroupBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGRP" ) ) {
				filteredList.add( (CFGenKbSecGroupBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecGroupBuff[0] ) );
	}

	public CFGenKbSecGroupBuff[] readBuffByClusterVisIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		boolean IsVisible )
	{
		final String S_ProcName = "CFGenKbRamSecGroup.readBuffByClusterVisIdx() ";
		CFGenKbSecGroupBuff buff;
		ArrayList<CFGenKbSecGroupBuff> filteredList = new ArrayList<CFGenKbSecGroupBuff>();
		CFGenKbSecGroupBuff[] buffList = readDerivedByClusterVisIdx( Authorization,
			ClusterId,
			IsVisible );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGRP" ) ) {
				filteredList.add( (CFGenKbSecGroupBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecGroupBuff[0] ) );
	}

	public CFGenKbSecGroupBuff readBuffByUNameIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		String Name )
	{
		final String S_ProcName = "CFGenKbRamSecGroup.readBuffByUNameIdx() ";
		CFGenKbSecGroupBuff buff = readDerivedByUNameIdx( Authorization,
			ClusterId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "SGRP" ) ) {
			return( (CFGenKbSecGroupBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateSecGroup( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupBuff Buff )
	{
		CFGenKbSecGroupPKey pkey = schema.getFactorySecGroup().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );
		CFGenKbSecGroupBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateSecGroup",
				"Existing record not found",
				"SecGroup",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateSecGroup",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbSecGroupByClusterIdxKey existingKeyClusterIdx = schema.getFactorySecGroup().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFGenKbSecGroupByClusterIdxKey newKeyClusterIdx = schema.getFactorySecGroup().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFGenKbSecGroupByClusterVisIdxKey existingKeyClusterVisIdx = schema.getFactorySecGroup().newClusterVisIdxKey();
		existingKeyClusterVisIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyClusterVisIdx.setRequiredIsVisible( existing.getRequiredIsVisible() );

		CFGenKbSecGroupByClusterVisIdxKey newKeyClusterVisIdx = schema.getFactorySecGroup().newClusterVisIdxKey();
		newKeyClusterVisIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyClusterVisIdx.setRequiredIsVisible( Buff.getRequiredIsVisible() );

		CFGenKbSecGroupByUNameIdxKey existingKeyUNameIdx = schema.getFactorySecGroup().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFGenKbSecGroupByUNameIdxKey newKeyUNameIdx = schema.getFactorySecGroup().newUNameIdxKey();
		newKeyUNameIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateSecGroup",
					"SecGroupUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableCluster().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateSecGroup",
						"Container",
						"SecGroupCluster",
						"Cluster",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbSecGroupPKey, CFGenKbSecGroupBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByClusterIdx.get( existingKeyClusterIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByClusterIdx.containsKey( newKeyClusterIdx ) ) {
			subdict = dictByClusterIdx.get( newKeyClusterIdx );
		}
		else {
			subdict = new HashMap< CFGenKbSecGroupPKey, CFGenKbSecGroupBuff >();
			dictByClusterIdx.put( newKeyClusterIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByClusterVisIdx.get( existingKeyClusterVisIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByClusterVisIdx.containsKey( newKeyClusterVisIdx ) ) {
			subdict = dictByClusterVisIdx.get( newKeyClusterVisIdx );
		}
		else {
			subdict = new HashMap< CFGenKbSecGroupPKey, CFGenKbSecGroupBuff >();
			dictByClusterVisIdx.put( newKeyClusterVisIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteSecGroup( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamSecGroupTable.deleteSecGroup() ";
		String classCode;
		CFGenKbSecGroupPKey pkey = schema.getFactorySecGroup().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );
		CFGenKbSecGroupBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteSecGroup",
				pkey );
		}
					schema.getTableSecGroupForm().deleteSecGroupFormByGroupIdx( Authorization,
						existing.getRequiredClusterId(),
						existing.getRequiredSecGroupId() );
					schema.getTableSecGrpInc().deleteSecGrpIncByIncludeIdx( Authorization,
						existing.getRequiredClusterId(),
						existing.getRequiredSecGroupId() );
					schema.getTableSecGrpMemb().deleteSecGrpMembByGroupIdx( Authorization,
						existing.getRequiredClusterId(),
						existing.getRequiredSecGroupId() );
					schema.getTableSecGrpInc().deleteSecGrpIncByGroupIdx( Authorization,
						existing.getRequiredClusterId(),
						existing.getRequiredSecGroupId() );
		CFGenKbSecGroupByClusterIdxKey keyClusterIdx = schema.getFactorySecGroup().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFGenKbSecGroupByClusterVisIdxKey keyClusterVisIdx = schema.getFactorySecGroup().newClusterVisIdxKey();
		keyClusterVisIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyClusterVisIdx.setRequiredIsVisible( existing.getRequiredIsVisible() );

		CFGenKbSecGroupByUNameIdxKey keyUNameIdx = schema.getFactorySecGroup().newUNameIdxKey();
		keyUNameIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbSecGroupPKey, CFGenKbSecGroupBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		subdict = dictByClusterVisIdx.get( keyClusterVisIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}
	public void deleteSecGroupByIdIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		int argSecGroupId )
	{
		CFGenKbSecGroupPKey key = schema.getFactorySecGroup().newPKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGroupId( argSecGroupId );
		deleteSecGroupByIdIdx( Authorization, key );
	}

	public void deleteSecGroupByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbSecGroupBuff cur;
		LinkedList<CFGenKbSecGroupBuff> matchSet = new LinkedList<CFGenKbSecGroupBuff>();
		Iterator<CFGenKbSecGroupBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGroupBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGroup().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGroupId() );
			deleteSecGroup( Authorization, cur );
		}
	}

	public void deleteSecGroupByClusterIdx( CFGenKbAuthorization Authorization,
		long argClusterId )
	{
		CFGenKbSecGroupByClusterIdxKey key = schema.getFactorySecGroup().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteSecGroupByClusterIdx( Authorization, key );
	}

	public void deleteSecGroupByClusterIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupByClusterIdxKey argKey )
	{
		CFGenKbSecGroupBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecGroupBuff> matchSet = new LinkedList<CFGenKbSecGroupBuff>();
		Iterator<CFGenKbSecGroupBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGroupBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGroup().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGroupId() );
			deleteSecGroup( Authorization, cur );
		}
	}

	public void deleteSecGroupByClusterVisIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		boolean argIsVisible )
	{
		CFGenKbSecGroupByClusterVisIdxKey key = schema.getFactorySecGroup().newClusterVisIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredIsVisible( argIsVisible );
		deleteSecGroupByClusterVisIdx( Authorization, key );
	}

	public void deleteSecGroupByClusterVisIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupByClusterVisIdxKey argKey )
	{
		CFGenKbSecGroupBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecGroupBuff> matchSet = new LinkedList<CFGenKbSecGroupBuff>();
		Iterator<CFGenKbSecGroupBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGroupBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGroup().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGroupId() );
			deleteSecGroup( Authorization, cur );
		}
	}

	public void deleteSecGroupByUNameIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		String argName )
	{
		CFGenKbSecGroupByUNameIdxKey key = schema.getFactorySecGroup().newUNameIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredName( argName );
		deleteSecGroupByUNameIdx( Authorization, key );
	}

	public void deleteSecGroupByUNameIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupByUNameIdxKey argKey )
	{
		CFGenKbSecGroupBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecGroupBuff> matchSet = new LinkedList<CFGenKbSecGroupBuff>();
		Iterator<CFGenKbSecGroupBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGroupBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGroup().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGroupId() );
			deleteSecGroup( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
