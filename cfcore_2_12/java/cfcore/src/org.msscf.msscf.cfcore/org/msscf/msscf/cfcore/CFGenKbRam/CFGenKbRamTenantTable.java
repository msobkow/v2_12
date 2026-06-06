
// Description: Java 11 in-memory RAM DbIO implementation for Tenant.

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
 *	CFGenKbRamTenantTable in-memory RAM DbIO implementation
 *	for Tenant.
 */
public class CFGenKbRamTenantTable
	implements ICFGenKbTenantTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbTenantPKey,
				CFGenKbTenantBuff > dictByPKey
		= new HashMap< CFGenKbTenantPKey,
				CFGenKbTenantBuff >();
	private Map< CFGenKbTenantByClusterIdxKey,
				Map< CFGenKbTenantPKey,
					CFGenKbTenantBuff >> dictByClusterIdx
		= new HashMap< CFGenKbTenantByClusterIdxKey,
				Map< CFGenKbTenantPKey,
					CFGenKbTenantBuff >>();
	private Map< CFGenKbTenantByUNameIdxKey,
			CFGenKbTenantBuff > dictByUNameIdx
		= new HashMap< CFGenKbTenantByUNameIdxKey,
			CFGenKbTenantBuff >();
	private Map< CFGenKbRamTenantId32Gen,
				CFGenKbRamTenantId32Gen > id32Generator
		= new HashMap< CFGenKbRamTenantId32Gen,
				CFGenKbRamTenantId32Gen >();
	private Map< CFGenKbRamTenantId64Gen,
				CFGenKbRamTenantId64Gen > id64Generator
		= new HashMap< CFGenKbRamTenantId64Gen,
				CFGenKbRamTenantId64Gen >();

	public CFGenKbRamTenantTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	protected int generateNextId32( long argId,
		short argSliceId )
	{
		CFGenKbRamTenantId32Gen key = new CFGenKbRamTenantId32Gen();
		key.setRequiredId( argId );
		key.setRequiredSliceId( argSliceId );

		CFGenKbRamTenantId32Gen useGen = id32Generator.get( key );
		if( useGen == null ) {
			id32Generator.put( key, key );
			useGen = key;
		}

		int retNext = useGen.getNextId();

		return( retNext );
	}

	protected long generateNextId64( long argId,
		short argSliceId )
	{
		CFGenKbRamTenantId64Gen key = new CFGenKbRamTenantId64Gen();
		key.setRequiredId( argId );
		key.setRequiredSliceId( argSliceId );

		CFGenKbRamTenantId64Gen useGen = id64Generator.get( key );
		if( useGen == null ) {
			id64Generator.put( key, key );
			useGen = key;
		}

		long retNext = useGen.getNextId();

		return( retNext );
	}

	public int nextTSecGroupIdGen( CFGenKbAuthorization Authorization,
		CFGenKbTenantPKey pkey )
	{
		int retval = nextTSecGroupIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public int nextTSecGroupIdGen( CFGenKbAuthorization Authorization,
		long argId )
	{
		int retNext = generateNextId32( argId,
			(short)1018 );
		return( retNext );
	}

	public long nextTSecGrpIncIdGen( CFGenKbAuthorization Authorization,
		CFGenKbTenantPKey pkey )
	{
		long retval = nextTSecGrpIncIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextTSecGrpIncIdGen( CFGenKbAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)1019 );
		return( retNext );
	}

	public long nextTSecGrpMembIdGen( CFGenKbAuthorization Authorization,
		CFGenKbTenantPKey pkey )
	{
		long retval = nextTSecGrpMembIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextTSecGrpMembIdGen( CFGenKbAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)1020 );
		return( retNext );
	}

	public long nextGelCacheIdGen( CFGenKbAuthorization Authorization,
		CFGenKbTenantPKey pkey )
	{
		long retval = nextGelCacheIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextGelCacheIdGen( CFGenKbAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)1022 );
		return( retNext );
	}

	public long nextGelInstructionIdGen( CFGenKbAuthorization Authorization,
		CFGenKbTenantPKey pkey )
	{
		long retval = nextGelInstructionIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextGelInstructionIdGen( CFGenKbAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)1023 );
		return( retNext );
	}

	public long nextGenItemIdGen( CFGenKbAuthorization Authorization,
		CFGenKbTenantPKey pkey )
	{
		long retval = nextGenItemIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextGenItemIdGen( CFGenKbAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)1024 );
		return( retNext );
	}

	public long nextRuleCartIdGen( CFGenKbAuthorization Authorization,
		CFGenKbTenantPKey pkey )
	{
		long retval = nextRuleCartIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextRuleCartIdGen( CFGenKbAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)1025 );
		return( retNext );
	}

	public void createTenant( CFGenKbAuthorization Authorization,
		CFGenKbTenantBuff Buff )
	{
		final String S_ProcName = "createTenant";
		CFGenKbTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( schema.nextTenantIdGen() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFGenKbTenantByClusterIdxKey keyClusterIdx = schema.getFactoryTenant().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFGenKbTenantByUNameIdxKey keyUNameIdx = schema.getFactoryTenant().newUNameIdxKey();
		keyUNameIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUNameIdx.setRequiredTenantName( Buff.getRequiredTenantName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TenantUNameIdx",
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
						"TenantCluster",
						"Cluster",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbTenantPKey, CFGenKbTenantBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFGenKbTenantPKey, CFGenKbTenantBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFGenKbTenantBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbTenantPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamTenant.readDerived";
		CFGenKbTenantPKey key = schema.getFactoryTenant().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFGenKbTenantBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTenantBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbTenantPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamTenant.readDerived";
		CFGenKbTenantPKey key = schema.getFactoryTenant().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFGenKbTenantBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTenantBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamTenant.readAllDerived";
		CFGenKbTenantBuff[] retList = new CFGenKbTenantBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbTenantBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbTenantBuff[] readDerivedByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFGenKbRamTenant.readDerivedByClusterIdx";
		CFGenKbTenantByClusterIdxKey key = schema.getFactoryTenant().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFGenKbTenantBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFGenKbTenantPKey, CFGenKbTenantBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFGenKbTenantBuff[ subdictClusterIdx.size() ];
			Iterator< CFGenKbTenantBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbTenantPKey, CFGenKbTenantBuff > subdictClusterIdx
				= new HashMap< CFGenKbTenantPKey, CFGenKbTenantBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFGenKbTenantBuff[0];
		}
		return( recArray );
	}

	public CFGenKbTenantBuff readDerivedByUNameIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		String TenantName )
	{
		final String S_ProcName = "CFGenKbRamTenant.readDerivedByUNameIdx";
		CFGenKbTenantByUNameIdxKey key = schema.getFactoryTenant().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredTenantName( TenantName );

		CFGenKbTenantBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTenantBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		long Id )
	{
		final String S_ProcName = "CFGenKbRamTenant.readDerivedByIdIdx() ";
		CFGenKbTenantPKey key = schema.getFactoryTenant().newPKey();
		key.setRequiredId( Id );

		CFGenKbTenantBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTenantBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbTenantPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamTenant.readBuff";
		CFGenKbTenantBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TENT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTenantBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbTenantPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbTenantBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TENT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbTenantBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamTenant.readAllBuff";
		CFGenKbTenantBuff buff;
		ArrayList<CFGenKbTenantBuff> filteredList = new ArrayList<CFGenKbTenantBuff>();
		CFGenKbTenantBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TENT" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbTenantBuff[0] ) );
	}

	/**
	 *	Read a page of all the specific Tenant buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific Tenant instances in the database accessible for the Authorization.
	 */
	public CFGenKbTenantBuff[] pageAllBuff( CFGenKbAuthorization Authorization,
		Long priorId )
	{
		final String S_ProcName = "pageAllBuff";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public CFGenKbTenantBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		long Id )
	{
		final String S_ProcName = "CFGenKbRamTenant.readBuffByIdIdx() ";
		CFGenKbTenantBuff buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "TENT" ) ) {
			return( (CFGenKbTenantBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbTenantBuff[] readBuffByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFGenKbRamTenant.readBuffByClusterIdx() ";
		CFGenKbTenantBuff buff;
		ArrayList<CFGenKbTenantBuff> filteredList = new ArrayList<CFGenKbTenantBuff>();
		CFGenKbTenantBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TENT" ) ) {
				filteredList.add( (CFGenKbTenantBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbTenantBuff[0] ) );
	}

	public CFGenKbTenantBuff readBuffByUNameIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		String TenantName )
	{
		final String S_ProcName = "CFGenKbRamTenant.readBuffByUNameIdx() ";
		CFGenKbTenantBuff buff = readDerivedByUNameIdx( Authorization,
			ClusterId,
			TenantName );
		if( ( buff != null ) && buff.getClassCode().equals( "TENT" ) ) {
			return( (CFGenKbTenantBuff)buff );
		}
		else {
			return( null );
		}
	}

	/**
	 *	Read a page array of the specific Tenant buffer instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The Tenant key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbTenantBuff[] pageBuffByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		Long priorId )
	{
		final String S_ProcName = "pageBuffByClusterIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateTenant( CFGenKbAuthorization Authorization,
		CFGenKbTenantBuff Buff )
	{
		CFGenKbTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFGenKbTenantBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateTenant",
				"Existing record not found",
				"Tenant",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateTenant",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbTenantByClusterIdxKey existingKeyClusterIdx = schema.getFactoryTenant().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFGenKbTenantByClusterIdxKey newKeyClusterIdx = schema.getFactoryTenant().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFGenKbTenantByUNameIdxKey existingKeyUNameIdx = schema.getFactoryTenant().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUNameIdx.setRequiredTenantName( existing.getRequiredTenantName() );

		CFGenKbTenantByUNameIdxKey newKeyUNameIdx = schema.getFactoryTenant().newUNameIdxKey();
		newKeyUNameIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUNameIdx.setRequiredTenantName( Buff.getRequiredTenantName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateTenant",
					"TenantUNameIdx",
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
						"updateTenant",
						"Container",
						"TenantCluster",
						"Cluster",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbTenantPKey, CFGenKbTenantBuff > subdict;

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
			subdict = new HashMap< CFGenKbTenantPKey, CFGenKbTenantBuff >();
			dictByClusterIdx.put( newKeyClusterIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteTenant( CFGenKbAuthorization Authorization,
		CFGenKbTenantBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamTenantTable.deleteTenant() ";
		String classCode;
		CFGenKbTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFGenKbTenantBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteTenant",
				pkey );
		}
					schema.getTableRuleCart().deleteRuleCartByTenantIdx( Authorization,
						existing.getRequiredId() );
		CFGenKbTSecGroupBuff buffDelIncludedByGroup;
		CFGenKbTSecGroupBuff arrDelIncludedByGroup[] = schema.getTableTSecGroup().readDerivedByTenantIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelIncludedByGroup = 0; idxDelIncludedByGroup < arrDelIncludedByGroup.length; idxDelIncludedByGroup++ ) {
			buffDelIncludedByGroup = arrDelIncludedByGroup[idxDelIncludedByGroup];
					schema.getTableTSecGrpInc().deleteTSecGrpIncByIncludeIdx( Authorization,
						buffDelIncludedByGroup.getRequiredTenantId(),
						buffDelIncludedByGroup.getRequiredTSecGroupId() );
		}
		CFGenKbTSecGroupBuff buffDelGrpMembs;
		CFGenKbTSecGroupBuff arrDelGrpMembs[] = schema.getTableTSecGroup().readDerivedByTenantIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelGrpMembs = 0; idxDelGrpMembs < arrDelGrpMembs.length; idxDelGrpMembs++ ) {
			buffDelGrpMembs = arrDelGrpMembs[idxDelGrpMembs];
					schema.getTableTSecGrpMemb().deleteTSecGrpMembByGroupIdx( Authorization,
						buffDelGrpMembs.getRequiredTenantId(),
						buffDelGrpMembs.getRequiredTSecGroupId() );
		}
		CFGenKbTSecGroupBuff buffDelGrpIncs;
		CFGenKbTSecGroupBuff arrDelGrpIncs[] = schema.getTableTSecGroup().readDerivedByTenantIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelGrpIncs = 0; idxDelGrpIncs < arrDelGrpIncs.length; idxDelGrpIncs++ ) {
			buffDelGrpIncs = arrDelGrpIncs[idxDelGrpIncs];
					schema.getTableTSecGrpInc().deleteTSecGrpIncByGroupIdx( Authorization,
						buffDelGrpIncs.getRequiredTenantId(),
						buffDelGrpIncs.getRequiredTSecGroupId() );
		}
					schema.getTableTSecGroup().deleteTSecGroupByTenantIdx( Authorization,
						existing.getRequiredId() );
		CFGenKbTenantByClusterIdxKey keyClusterIdx = schema.getFactoryTenant().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFGenKbTenantByUNameIdxKey keyUNameIdx = schema.getFactoryTenant().newUNameIdxKey();
		keyUNameIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUNameIdx.setRequiredTenantName( existing.getRequiredTenantName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbTenantPKey, CFGenKbTenantBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}
	public void deleteTenantByIdIdx( CFGenKbAuthorization Authorization,
		long argId )
	{
		CFGenKbTenantPKey key = schema.getFactoryTenant().newPKey();
		key.setRequiredId( argId );
		deleteTenantByIdIdx( Authorization, key );
	}

	public void deleteTenantByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbTenantPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbTenantBuff cur;
		LinkedList<CFGenKbTenantBuff> matchSet = new LinkedList<CFGenKbTenantBuff>();
		Iterator<CFGenKbTenantBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbTenantBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTenant().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteTenant( Authorization, cur );
		}
	}

	public void deleteTenantByClusterIdx( CFGenKbAuthorization Authorization,
		long argClusterId )
	{
		CFGenKbTenantByClusterIdxKey key = schema.getFactoryTenant().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteTenantByClusterIdx( Authorization, key );
	}

	public void deleteTenantByClusterIdx( CFGenKbAuthorization Authorization,
		CFGenKbTenantByClusterIdxKey argKey )
	{
		CFGenKbTenantBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbTenantBuff> matchSet = new LinkedList<CFGenKbTenantBuff>();
		Iterator<CFGenKbTenantBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbTenantBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTenant().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteTenant( Authorization, cur );
		}
	}

	public void deleteTenantByUNameIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		String argTenantName )
	{
		CFGenKbTenantByUNameIdxKey key = schema.getFactoryTenant().newUNameIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredTenantName( argTenantName );
		deleteTenantByUNameIdx( Authorization, key );
	}

	public void deleteTenantByUNameIdx( CFGenKbAuthorization Authorization,
		CFGenKbTenantByUNameIdxKey argKey )
	{
		CFGenKbTenantBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbTenantBuff> matchSet = new LinkedList<CFGenKbTenantBuff>();
		Iterator<CFGenKbTenantBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbTenantBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTenant().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteTenant( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
