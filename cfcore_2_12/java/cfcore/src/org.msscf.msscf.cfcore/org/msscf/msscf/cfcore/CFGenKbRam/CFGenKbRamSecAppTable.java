
// Description: Java 11 in-memory RAM DbIO implementation for SecApp.

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
 *	CFGenKbRamSecAppTable in-memory RAM DbIO implementation
 *	for SecApp.
 */
public class CFGenKbRamSecAppTable
	implements ICFGenKbSecAppTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbSecAppPKey,
				CFGenKbSecAppBuff > dictByPKey
		= new HashMap< CFGenKbSecAppPKey,
				CFGenKbSecAppBuff >();
	private Map< CFGenKbSecAppByClusterIdxKey,
				Map< CFGenKbSecAppPKey,
					CFGenKbSecAppBuff >> dictByClusterIdx
		= new HashMap< CFGenKbSecAppByClusterIdxKey,
				Map< CFGenKbSecAppPKey,
					CFGenKbSecAppBuff >>();
	private Map< CFGenKbSecAppByUJEEMountIdxKey,
			CFGenKbSecAppBuff > dictByUJEEMountIdx
		= new HashMap< CFGenKbSecAppByUJEEMountIdxKey,
			CFGenKbSecAppBuff >();

	public CFGenKbRamSecAppTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecApp( CFGenKbAuthorization Authorization,
		CFGenKbSecAppBuff Buff )
	{
		final String S_ProcName = "createSecApp";
		CFGenKbSecAppPKey pkey = schema.getFactorySecApp().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecAppId( ((CFGenKbRamClusterTable)schema.getTableCluster()).nextSecAppIdGen( Authorization,
			Buff.getRequiredClusterId() ) );
		Buff.setRequiredClusterId( pkey.getRequiredClusterId() );
		Buff.setRequiredSecAppId( pkey.getRequiredSecAppId() );
		CFGenKbSecAppByClusterIdxKey keyClusterIdx = schema.getFactorySecApp().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFGenKbSecAppByUJEEMountIdxKey keyUJEEMountIdx = schema.getFactorySecApp().newUJEEMountIdxKey();
		keyUJEEMountIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUJEEMountIdx.setRequiredJEEMountName( Buff.getRequiredJEEMountName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUJEEMountIdx.containsKey( keyUJEEMountIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecAppUJEEMountIdx",
				keyUJEEMountIdx );
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
						"SecAppCluster",
						"Cluster",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbSecAppPKey, CFGenKbSecAppBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFGenKbSecAppPKey, CFGenKbSecAppBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		dictByUJEEMountIdx.put( keyUJEEMountIdx, Buff );

	}

	public CFGenKbSecAppBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbSecAppPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecApp.readDerived";
		CFGenKbSecAppPKey key = schema.getFactorySecApp().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecAppId( PKey.getRequiredSecAppId() );
		CFGenKbSecAppBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecAppBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbSecAppPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecApp.readDerived";
		CFGenKbSecAppPKey key = schema.getFactorySecApp().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecAppId( PKey.getRequiredSecAppId() );
		CFGenKbSecAppBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecAppBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamSecApp.readAllDerived";
		CFGenKbSecAppBuff[] retList = new CFGenKbSecAppBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbSecAppBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbSecAppBuff[] readDerivedByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFGenKbRamSecApp.readDerivedByClusterIdx";
		CFGenKbSecAppByClusterIdxKey key = schema.getFactorySecApp().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFGenKbSecAppBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFGenKbSecAppPKey, CFGenKbSecAppBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFGenKbSecAppBuff[ subdictClusterIdx.size() ];
			Iterator< CFGenKbSecAppBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecAppPKey, CFGenKbSecAppBuff > subdictClusterIdx
				= new HashMap< CFGenKbSecAppPKey, CFGenKbSecAppBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFGenKbSecAppBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecAppBuff readDerivedByUJEEMountIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		String JEEMountName )
	{
		final String S_ProcName = "CFGenKbRamSecApp.readDerivedByUJEEMountIdx";
		CFGenKbSecAppByUJEEMountIdxKey key = schema.getFactorySecApp().newUJEEMountIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredJEEMountName( JEEMountName );

		CFGenKbSecAppBuff buff;
		if( dictByUJEEMountIdx.containsKey( key ) ) {
			buff = dictByUJEEMountIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecAppBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecAppId )
	{
		final String S_ProcName = "CFGenKbRamSecApp.readDerivedByIdIdx() ";
		CFGenKbSecAppPKey key = schema.getFactorySecApp().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );

		CFGenKbSecAppBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecAppBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbSecAppPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecApp.readBuff";
		CFGenKbSecAppBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SAPP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecAppBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbSecAppPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbSecAppBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SAPP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecAppBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamSecApp.readAllBuff";
		CFGenKbSecAppBuff buff;
		ArrayList<CFGenKbSecAppBuff> filteredList = new ArrayList<CFGenKbSecAppBuff>();
		CFGenKbSecAppBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SAPP" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecAppBuff[0] ) );
	}

	/**
	 *	Read a page of all the specific SecApp buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecApp instances in the database accessible for the Authorization.
	 */
	public CFGenKbSecAppBuff[] pageAllBuff( CFGenKbAuthorization Authorization,
		Long priorClusterId,
		Integer priorSecAppId )
	{
		final String S_ProcName = "pageAllBuff";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public CFGenKbSecAppBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecAppId )
	{
		final String S_ProcName = "CFGenKbRamSecApp.readBuffByIdIdx() ";
		CFGenKbSecAppBuff buff = readDerivedByIdIdx( Authorization,
			ClusterId,
			SecAppId );
		if( ( buff != null ) && buff.getClassCode().equals( "SAPP" ) ) {
			return( (CFGenKbSecAppBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbSecAppBuff[] readBuffByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFGenKbRamSecApp.readBuffByClusterIdx() ";
		CFGenKbSecAppBuff buff;
		ArrayList<CFGenKbSecAppBuff> filteredList = new ArrayList<CFGenKbSecAppBuff>();
		CFGenKbSecAppBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SAPP" ) ) {
				filteredList.add( (CFGenKbSecAppBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecAppBuff[0] ) );
	}

	public CFGenKbSecAppBuff readBuffByUJEEMountIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		String JEEMountName )
	{
		final String S_ProcName = "CFGenKbRamSecApp.readBuffByUJEEMountIdx() ";
		CFGenKbSecAppBuff buff = readDerivedByUJEEMountIdx( Authorization,
			ClusterId,
			JEEMountName );
		if( ( buff != null ) && buff.getClassCode().equals( "SAPP" ) ) {
			return( (CFGenKbSecAppBuff)buff );
		}
		else {
			return( null );
		}
	}

	/**
	 *	Read a page array of the specific SecApp buffer instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecApp key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecAppBuff[] pageBuffByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		Long priorClusterId,
		Integer priorSecAppId )
	{
		final String S_ProcName = "pageBuffByClusterIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateSecApp( CFGenKbAuthorization Authorization,
		CFGenKbSecAppBuff Buff )
	{
		CFGenKbSecAppPKey pkey = schema.getFactorySecApp().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecAppId( Buff.getRequiredSecAppId() );
		CFGenKbSecAppBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateSecApp",
				"Existing record not found",
				"SecApp",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateSecApp",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbSecAppByClusterIdxKey existingKeyClusterIdx = schema.getFactorySecApp().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFGenKbSecAppByClusterIdxKey newKeyClusterIdx = schema.getFactorySecApp().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFGenKbSecAppByUJEEMountIdxKey existingKeyUJEEMountIdx = schema.getFactorySecApp().newUJEEMountIdxKey();
		existingKeyUJEEMountIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUJEEMountIdx.setRequiredJEEMountName( existing.getRequiredJEEMountName() );

		CFGenKbSecAppByUJEEMountIdxKey newKeyUJEEMountIdx = schema.getFactorySecApp().newUJEEMountIdxKey();
		newKeyUJEEMountIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUJEEMountIdx.setRequiredJEEMountName( Buff.getRequiredJEEMountName() );

		// Check unique indexes

		if( ! existingKeyUJEEMountIdx.equals( newKeyUJEEMountIdx ) ) {
			if( dictByUJEEMountIdx.containsKey( newKeyUJEEMountIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateSecApp",
					"SecAppUJEEMountIdx",
					newKeyUJEEMountIdx );
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
						"updateSecApp",
						"Container",
						"SecAppCluster",
						"Cluster",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbSecAppPKey, CFGenKbSecAppBuff > subdict;

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
			subdict = new HashMap< CFGenKbSecAppPKey, CFGenKbSecAppBuff >();
			dictByClusterIdx.put( newKeyClusterIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUJEEMountIdx.remove( existingKeyUJEEMountIdx );
		dictByUJEEMountIdx.put( newKeyUJEEMountIdx, Buff );

	}

	public void deleteSecApp( CFGenKbAuthorization Authorization,
		CFGenKbSecAppBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamSecAppTable.deleteSecApp() ";
		String classCode;
		CFGenKbSecAppPKey pkey = schema.getFactorySecApp().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecAppId( Buff.getRequiredSecAppId() );
		CFGenKbSecAppBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteSecApp",
				pkey );
		}
					schema.getTableSecForm().deleteSecFormBySecAppIdx( Authorization,
						existing.getRequiredClusterId(),
						existing.getRequiredSecAppId() );
		CFGenKbSecAppByClusterIdxKey keyClusterIdx = schema.getFactorySecApp().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFGenKbSecAppByUJEEMountIdxKey keyUJEEMountIdx = schema.getFactorySecApp().newUJEEMountIdxKey();
		keyUJEEMountIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUJEEMountIdx.setRequiredJEEMountName( existing.getRequiredJEEMountName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbSecAppPKey, CFGenKbSecAppBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		dictByUJEEMountIdx.remove( keyUJEEMountIdx );

	}
	public void deleteSecAppByIdIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		int argSecAppId )
	{
		CFGenKbSecAppPKey key = schema.getFactorySecApp().newPKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecAppId( argSecAppId );
		deleteSecAppByIdIdx( Authorization, key );
	}

	public void deleteSecAppByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecAppPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbSecAppBuff cur;
		LinkedList<CFGenKbSecAppBuff> matchSet = new LinkedList<CFGenKbSecAppBuff>();
		Iterator<CFGenKbSecAppBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecAppBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecApp().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecAppId() );
			deleteSecApp( Authorization, cur );
		}
	}

	public void deleteSecAppByClusterIdx( CFGenKbAuthorization Authorization,
		long argClusterId )
	{
		CFGenKbSecAppByClusterIdxKey key = schema.getFactorySecApp().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteSecAppByClusterIdx( Authorization, key );
	}

	public void deleteSecAppByClusterIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecAppByClusterIdxKey argKey )
	{
		CFGenKbSecAppBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecAppBuff> matchSet = new LinkedList<CFGenKbSecAppBuff>();
		Iterator<CFGenKbSecAppBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecAppBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecApp().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecAppId() );
			deleteSecApp( Authorization, cur );
		}
	}

	public void deleteSecAppByUJEEMountIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		String argJEEMountName )
	{
		CFGenKbSecAppByUJEEMountIdxKey key = schema.getFactorySecApp().newUJEEMountIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredJEEMountName( argJEEMountName );
		deleteSecAppByUJEEMountIdx( Authorization, key );
	}

	public void deleteSecAppByUJEEMountIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecAppByUJEEMountIdxKey argKey )
	{
		CFGenKbSecAppBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecAppBuff> matchSet = new LinkedList<CFGenKbSecAppBuff>();
		Iterator<CFGenKbSecAppBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecAppBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecApp().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecAppId() );
			deleteSecApp( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
