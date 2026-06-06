
// Description: Java 11 in-memory RAM DbIO implementation for Cluster.

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
 *	CFGenKbRamClusterTable in-memory RAM DbIO implementation
 *	for Cluster.
 */
public class CFGenKbRamClusterTable
	implements ICFGenKbClusterTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbClusterPKey,
				CFGenKbClusterBuff > dictByPKey
		= new HashMap< CFGenKbClusterPKey,
				CFGenKbClusterBuff >();
	private Map< CFGenKbClusterByUDomNameIdxKey,
			CFGenKbClusterBuff > dictByUDomNameIdx
		= new HashMap< CFGenKbClusterByUDomNameIdxKey,
			CFGenKbClusterBuff >();
	private Map< CFGenKbClusterByUDescrIdxKey,
			CFGenKbClusterBuff > dictByUDescrIdx
		= new HashMap< CFGenKbClusterByUDescrIdxKey,
			CFGenKbClusterBuff >();
	private Map< CFGenKbRamClusterId32Gen,
				CFGenKbRamClusterId32Gen > id32Generator
		= new HashMap< CFGenKbRamClusterId32Gen,
				CFGenKbRamClusterId32Gen >();
	private Map< CFGenKbRamClusterId64Gen,
				CFGenKbRamClusterId64Gen > id64Generator
		= new HashMap< CFGenKbRamClusterId64Gen,
				CFGenKbRamClusterId64Gen >();

	public CFGenKbRamClusterTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	protected int generateNextId32( long argId,
		short argSliceId )
	{
		CFGenKbRamClusterId32Gen key = new CFGenKbRamClusterId32Gen();
		key.setRequiredId( argId );
		key.setRequiredSliceId( argSliceId );

		CFGenKbRamClusterId32Gen useGen = id32Generator.get( key );
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
		CFGenKbRamClusterId64Gen key = new CFGenKbRamClusterId64Gen();
		key.setRequiredId( argId );
		key.setRequiredSliceId( argSliceId );

		CFGenKbRamClusterId64Gen useGen = id64Generator.get( key );
		if( useGen == null ) {
			id64Generator.put( key, key );
			useGen = key;
		}

		long retNext = useGen.getNextId();

		return( retNext );
	}

	public int nextSecAppIdGen( CFGenKbAuthorization Authorization,
		CFGenKbClusterPKey pkey )
	{
		int retval = nextSecAppIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public int nextSecAppIdGen( CFGenKbAuthorization Authorization,
		long argId )
	{
		int retNext = generateNextId32( argId,
			(short)1011 );
		return( retNext );
	}

	public int nextSecFormIdGen( CFGenKbAuthorization Authorization,
		CFGenKbClusterPKey pkey )
	{
		int retval = nextSecFormIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public int nextSecFormIdGen( CFGenKbAuthorization Authorization,
		long argId )
	{
		int retNext = generateNextId32( argId,
			(short)1012 );
		return( retNext );
	}

	public int nextSecGroupIdGen( CFGenKbAuthorization Authorization,
		CFGenKbClusterPKey pkey )
	{
		int retval = nextSecGroupIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public int nextSecGroupIdGen( CFGenKbAuthorization Authorization,
		long argId )
	{
		int retNext = generateNextId32( argId,
			(short)1014 );
		return( retNext );
	}

	public long nextHostNodeIdGen( CFGenKbAuthorization Authorization,
		CFGenKbClusterPKey pkey )
	{
		long retval = nextHostNodeIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextHostNodeIdGen( CFGenKbAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)1010 );
		return( retNext );
	}

	public long nextSecGroupFormIdGen( CFGenKbAuthorization Authorization,
		CFGenKbClusterPKey pkey )
	{
		long retval = nextSecGroupFormIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextSecGroupFormIdGen( CFGenKbAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)1013 );
		return( retNext );
	}

	public long nextSecGrpIncIdGen( CFGenKbAuthorization Authorization,
		CFGenKbClusterPKey pkey )
	{
		long retval = nextSecGrpIncIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextSecGrpIncIdGen( CFGenKbAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)1015 );
		return( retNext );
	}

	public long nextSecGrpMembIdGen( CFGenKbAuthorization Authorization,
		CFGenKbClusterPKey pkey )
	{
		long retval = nextSecGrpMembIdGen( Authorization,
			pkey.getRequiredId() );
		return( retval );
	}

	public long nextSecGrpMembIdGen( CFGenKbAuthorization Authorization,
		long argId )
	{
		long retNext = generateNextId64( argId,
			(short)1016 );
		return( retNext );
	}

	public void createCluster( CFGenKbAuthorization Authorization,
		CFGenKbClusterBuff Buff )
	{
		final String S_ProcName = "createCluster";
		CFGenKbClusterPKey pkey = schema.getFactoryCluster().newPKey();
		pkey.setRequiredId( schema.nextClusterIdGen() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFGenKbClusterByUDomNameIdxKey keyUDomNameIdx = schema.getFactoryCluster().newUDomNameIdxKey();
		keyUDomNameIdx.setRequiredFullDomName( Buff.getRequiredFullDomName() );

		CFGenKbClusterByUDescrIdxKey keyUDescrIdx = schema.getFactoryCluster().newUDescrIdxKey();
		keyUDescrIdx.setRequiredDescription( Buff.getRequiredDescription() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUDomNameIdx.containsKey( keyUDomNameIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ClusterUDomNameIdx",
				keyUDomNameIdx );
		}

		if( dictByUDescrIdx.containsKey( keyUDescrIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ClusterUDescrNameIdx",
				keyUDescrIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUDomNameIdx.put( keyUDomNameIdx, Buff );

		dictByUDescrIdx.put( keyUDescrIdx, Buff );

	}

	public CFGenKbClusterBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbClusterPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamCluster.readDerived";
		CFGenKbClusterPKey key = schema.getFactoryCluster().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFGenKbClusterBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbClusterBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbClusterPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamCluster.readDerived";
		CFGenKbClusterPKey key = schema.getFactoryCluster().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFGenKbClusterBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbClusterBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamCluster.readAllDerived";
		CFGenKbClusterBuff[] retList = new CFGenKbClusterBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbClusterBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbClusterBuff readDerivedByUDomNameIdx( CFGenKbAuthorization Authorization,
		String FullDomName )
	{
		final String S_ProcName = "CFGenKbRamCluster.readDerivedByUDomNameIdx";
		CFGenKbClusterByUDomNameIdxKey key = schema.getFactoryCluster().newUDomNameIdxKey();
		key.setRequiredFullDomName( FullDomName );

		CFGenKbClusterBuff buff;
		if( dictByUDomNameIdx.containsKey( key ) ) {
			buff = dictByUDomNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbClusterBuff readDerivedByUDescrIdx( CFGenKbAuthorization Authorization,
		String Description )
	{
		final String S_ProcName = "CFGenKbRamCluster.readDerivedByUDescrIdx";
		CFGenKbClusterByUDescrIdxKey key = schema.getFactoryCluster().newUDescrIdxKey();
		key.setRequiredDescription( Description );

		CFGenKbClusterBuff buff;
		if( dictByUDescrIdx.containsKey( key ) ) {
			buff = dictByUDescrIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbClusterBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		long Id )
	{
		final String S_ProcName = "CFGenKbRamCluster.readDerivedByIdIdx() ";
		CFGenKbClusterPKey key = schema.getFactoryCluster().newPKey();
		key.setRequiredId( Id );

		CFGenKbClusterBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbClusterBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbClusterPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamCluster.readBuff";
		CFGenKbClusterBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "CLUS" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbClusterBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbClusterPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbClusterBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "CLUS" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbClusterBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamCluster.readAllBuff";
		CFGenKbClusterBuff buff;
		ArrayList<CFGenKbClusterBuff> filteredList = new ArrayList<CFGenKbClusterBuff>();
		CFGenKbClusterBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "CLUS" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbClusterBuff[0] ) );
	}

	/**
	 *	Read a page of all the specific Cluster buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific Cluster instances in the database accessible for the Authorization.
	 */
	public CFGenKbClusterBuff[] pageAllBuff( CFGenKbAuthorization Authorization,
		Long priorId )
	{
		final String S_ProcName = "pageAllBuff";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public CFGenKbClusterBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		long Id )
	{
		final String S_ProcName = "CFGenKbRamCluster.readBuffByIdIdx() ";
		CFGenKbClusterBuff buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "CLUS" ) ) {
			return( (CFGenKbClusterBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbClusterBuff readBuffByUDomNameIdx( CFGenKbAuthorization Authorization,
		String FullDomName )
	{
		final String S_ProcName = "CFGenKbRamCluster.readBuffByUDomNameIdx() ";
		CFGenKbClusterBuff buff = readDerivedByUDomNameIdx( Authorization,
			FullDomName );
		if( ( buff != null ) && buff.getClassCode().equals( "CLUS" ) ) {
			return( (CFGenKbClusterBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbClusterBuff readBuffByUDescrIdx( CFGenKbAuthorization Authorization,
		String Description )
	{
		final String S_ProcName = "CFGenKbRamCluster.readBuffByUDescrIdx() ";
		CFGenKbClusterBuff buff = readDerivedByUDescrIdx( Authorization,
			Description );
		if( ( buff != null ) && buff.getClassCode().equals( "CLUS" ) ) {
			return( (CFGenKbClusterBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateCluster( CFGenKbAuthorization Authorization,
		CFGenKbClusterBuff Buff )
	{
		CFGenKbClusterPKey pkey = schema.getFactoryCluster().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFGenKbClusterBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateCluster",
				"Existing record not found",
				"Cluster",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateCluster",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbClusterByUDomNameIdxKey existingKeyUDomNameIdx = schema.getFactoryCluster().newUDomNameIdxKey();
		existingKeyUDomNameIdx.setRequiredFullDomName( existing.getRequiredFullDomName() );

		CFGenKbClusterByUDomNameIdxKey newKeyUDomNameIdx = schema.getFactoryCluster().newUDomNameIdxKey();
		newKeyUDomNameIdx.setRequiredFullDomName( Buff.getRequiredFullDomName() );

		CFGenKbClusterByUDescrIdxKey existingKeyUDescrIdx = schema.getFactoryCluster().newUDescrIdxKey();
		existingKeyUDescrIdx.setRequiredDescription( existing.getRequiredDescription() );

		CFGenKbClusterByUDescrIdxKey newKeyUDescrIdx = schema.getFactoryCluster().newUDescrIdxKey();
		newKeyUDescrIdx.setRequiredDescription( Buff.getRequiredDescription() );

		// Check unique indexes

		if( ! existingKeyUDomNameIdx.equals( newKeyUDomNameIdx ) ) {
			if( dictByUDomNameIdx.containsKey( newKeyUDomNameIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateCluster",
					"ClusterUDomNameIdx",
					newKeyUDomNameIdx );
			}
		}

		if( ! existingKeyUDescrIdx.equals( newKeyUDescrIdx ) ) {
			if( dictByUDescrIdx.containsKey( newKeyUDescrIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateCluster",
					"ClusterUDescrNameIdx",
					newKeyUDescrIdx );
			}
		}

		// Validate foreign keys

		// Update is valid

		Map< CFGenKbClusterPKey, CFGenKbClusterBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUDomNameIdx.remove( existingKeyUDomNameIdx );
		dictByUDomNameIdx.put( newKeyUDomNameIdx, Buff );

		dictByUDescrIdx.remove( existingKeyUDescrIdx );
		dictByUDescrIdx.put( newKeyUDescrIdx, Buff );

	}

	public void deleteCluster( CFGenKbAuthorization Authorization,
		CFGenKbClusterBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamClusterTable.deleteCluster() ";
		String classCode;
		CFGenKbClusterPKey pkey = schema.getFactoryCluster().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFGenKbClusterBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteCluster",
				pkey );
		}
		CFGenKbSecGroupBuff buffDelSecGroupForms;
		CFGenKbSecGroupBuff arrDelSecGroupForms[] = schema.getTableSecGroup().readDerivedByClusterIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelSecGroupForms = 0; idxDelSecGroupForms < arrDelSecGroupForms.length; idxDelSecGroupForms++ ) {
			buffDelSecGroupForms = arrDelSecGroupForms[idxDelSecGroupForms];
					schema.getTableSecGroupForm().deleteSecGroupFormByGroupIdx( Authorization,
						buffDelSecGroupForms.getRequiredClusterId(),
						buffDelSecGroupForms.getRequiredSecGroupId() );
		}
		CFGenKbSecGroupBuff buffDelSecGrpIncByGroup;
		CFGenKbSecGroupBuff arrDelSecGrpIncByGroup[] = schema.getTableSecGroup().readDerivedByClusterIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelSecGrpIncByGroup = 0; idxDelSecGrpIncByGroup < arrDelSecGrpIncByGroup.length; idxDelSecGrpIncByGroup++ ) {
			buffDelSecGrpIncByGroup = arrDelSecGrpIncByGroup[idxDelSecGrpIncByGroup];
					schema.getTableSecGrpInc().deleteSecGrpIncByIncludeIdx( Authorization,
						buffDelSecGrpIncByGroup.getRequiredClusterId(),
						buffDelSecGrpIncByGroup.getRequiredSecGroupId() );
		}
		CFGenKbSecGroupBuff buffDelSecGrpMembs;
		CFGenKbSecGroupBuff arrDelSecGrpMembs[] = schema.getTableSecGroup().readDerivedByClusterIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelSecGrpMembs = 0; idxDelSecGrpMembs < arrDelSecGrpMembs.length; idxDelSecGrpMembs++ ) {
			buffDelSecGrpMembs = arrDelSecGrpMembs[idxDelSecGrpMembs];
					schema.getTableSecGrpMemb().deleteSecGrpMembByGroupIdx( Authorization,
						buffDelSecGrpMembs.getRequiredClusterId(),
						buffDelSecGrpMembs.getRequiredSecGroupId() );
		}
		CFGenKbSecGroupBuff buffDelSecGrpIncs;
		CFGenKbSecGroupBuff arrDelSecGrpIncs[] = schema.getTableSecGroup().readDerivedByClusterIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelSecGrpIncs = 0; idxDelSecGrpIncs < arrDelSecGrpIncs.length; idxDelSecGrpIncs++ ) {
			buffDelSecGrpIncs = arrDelSecGrpIncs[idxDelSecGrpIncs];
					schema.getTableSecGrpInc().deleteSecGrpIncByGroupIdx( Authorization,
						buffDelSecGrpIncs.getRequiredClusterId(),
						buffDelSecGrpIncs.getRequiredSecGroupId() );
		}
					schema.getTableSecGroup().deleteSecGroupByClusterIdx( Authorization,
						existing.getRequiredId() );
		CFGenKbSecAppBuff buffDelSecAppForms;
		CFGenKbSecAppBuff arrDelSecAppForms[] = schema.getTableSecApp().readDerivedByClusterIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelSecAppForms = 0; idxDelSecAppForms < arrDelSecAppForms.length; idxDelSecAppForms++ ) {
			buffDelSecAppForms = arrDelSecAppForms[idxDelSecAppForms];
					schema.getTableSecForm().deleteSecFormBySecAppIdx( Authorization,
						buffDelSecAppForms.getRequiredClusterId(),
						buffDelSecAppForms.getRequiredSecAppId() );
		}
					schema.getTableSecApp().deleteSecAppByClusterIdx( Authorization,
						existing.getRequiredId() );
					schema.getTableTenant().deleteTenantByClusterIdx( Authorization,
						existing.getRequiredId() );
					schema.getTableHostNode().deleteHostNodeByClusterIdx( Authorization,
						existing.getRequiredId() );
		CFGenKbClusterByUDomNameIdxKey keyUDomNameIdx = schema.getFactoryCluster().newUDomNameIdxKey();
		keyUDomNameIdx.setRequiredFullDomName( existing.getRequiredFullDomName() );

		CFGenKbClusterByUDescrIdxKey keyUDescrIdx = schema.getFactoryCluster().newUDescrIdxKey();
		keyUDescrIdx.setRequiredDescription( existing.getRequiredDescription() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbClusterPKey, CFGenKbClusterBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUDomNameIdx.remove( keyUDomNameIdx );

		dictByUDescrIdx.remove( keyUDescrIdx );

	}
	public void deleteClusterByIdIdx( CFGenKbAuthorization Authorization,
		long argId )
	{
		CFGenKbClusterPKey key = schema.getFactoryCluster().newPKey();
		key.setRequiredId( argId );
		deleteClusterByIdIdx( Authorization, key );
	}

	public void deleteClusterByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbClusterPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbClusterBuff cur;
		LinkedList<CFGenKbClusterBuff> matchSet = new LinkedList<CFGenKbClusterBuff>();
		Iterator<CFGenKbClusterBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbClusterBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableCluster().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteCluster( Authorization, cur );
		}
	}

	public void deleteClusterByUDomNameIdx( CFGenKbAuthorization Authorization,
		String argFullDomName )
	{
		CFGenKbClusterByUDomNameIdxKey key = schema.getFactoryCluster().newUDomNameIdxKey();
		key.setRequiredFullDomName( argFullDomName );
		deleteClusterByUDomNameIdx( Authorization, key );
	}

	public void deleteClusterByUDomNameIdx( CFGenKbAuthorization Authorization,
		CFGenKbClusterByUDomNameIdxKey argKey )
	{
		CFGenKbClusterBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbClusterBuff> matchSet = new LinkedList<CFGenKbClusterBuff>();
		Iterator<CFGenKbClusterBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbClusterBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableCluster().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteCluster( Authorization, cur );
		}
	}

	public void deleteClusterByUDescrIdx( CFGenKbAuthorization Authorization,
		String argDescription )
	{
		CFGenKbClusterByUDescrIdxKey key = schema.getFactoryCluster().newUDescrIdxKey();
		key.setRequiredDescription( argDescription );
		deleteClusterByUDescrIdx( Authorization, key );
	}

	public void deleteClusterByUDescrIdx( CFGenKbAuthorization Authorization,
		CFGenKbClusterByUDescrIdxKey argKey )
	{
		CFGenKbClusterBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbClusterBuff> matchSet = new LinkedList<CFGenKbClusterBuff>();
		Iterator<CFGenKbClusterBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbClusterBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableCluster().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteCluster( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
