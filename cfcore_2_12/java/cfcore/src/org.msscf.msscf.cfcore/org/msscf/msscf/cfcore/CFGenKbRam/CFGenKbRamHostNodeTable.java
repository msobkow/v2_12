
// Description: Java 11 in-memory RAM DbIO implementation for HostNode.

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
 *	CFGenKbRamHostNodeTable in-memory RAM DbIO implementation
 *	for HostNode.
 */
public class CFGenKbRamHostNodeTable
	implements ICFGenKbHostNodeTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbHostNodePKey,
				CFGenKbHostNodeBuff > dictByPKey
		= new HashMap< CFGenKbHostNodePKey,
				CFGenKbHostNodeBuff >();
	private Map< CFGenKbHostNodeByClusterIdxKey,
				Map< CFGenKbHostNodePKey,
					CFGenKbHostNodeBuff >> dictByClusterIdx
		= new HashMap< CFGenKbHostNodeByClusterIdxKey,
				Map< CFGenKbHostNodePKey,
					CFGenKbHostNodeBuff >>();
	private Map< CFGenKbHostNodeByUDescrIdxKey,
			CFGenKbHostNodeBuff > dictByUDescrIdx
		= new HashMap< CFGenKbHostNodeByUDescrIdxKey,
			CFGenKbHostNodeBuff >();
	private Map< CFGenKbHostNodeByHostNameIdxKey,
			CFGenKbHostNodeBuff > dictByHostNameIdx
		= new HashMap< CFGenKbHostNodeByHostNameIdxKey,
			CFGenKbHostNodeBuff >();

	public CFGenKbRamHostNodeTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createHostNode( CFGenKbAuthorization Authorization,
		CFGenKbHostNodeBuff Buff )
	{
		final String S_ProcName = "createHostNode";
		CFGenKbHostNodePKey pkey = schema.getFactoryHostNode().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredHostNodeId( ((CFGenKbRamClusterTable)schema.getTableCluster()).nextHostNodeIdGen( Authorization,
			Buff.getRequiredClusterId() ) );
		Buff.setRequiredClusterId( pkey.getRequiredClusterId() );
		Buff.setRequiredHostNodeId( pkey.getRequiredHostNodeId() );
		CFGenKbHostNodeByClusterIdxKey keyClusterIdx = schema.getFactoryHostNode().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFGenKbHostNodeByUDescrIdxKey keyUDescrIdx = schema.getFactoryHostNode().newUDescrIdxKey();
		keyUDescrIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUDescrIdx.setRequiredDescription( Buff.getRequiredDescription() );

		CFGenKbHostNodeByHostNameIdxKey keyHostNameIdx = schema.getFactoryHostNode().newHostNameIdxKey();
		keyHostNameIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyHostNameIdx.setRequiredHostName( Buff.getRequiredHostName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUDescrIdx.containsKey( keyUDescrIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"HostNodeUDescrIdx",
				keyUDescrIdx );
		}

		if( dictByHostNameIdx.containsKey( keyHostNameIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"HostNodeUHostNameIdx",
				keyHostNameIdx );
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
						"HostNodeCluster",
						"Cluster",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbHostNodePKey, CFGenKbHostNodeBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFGenKbHostNodePKey, CFGenKbHostNodeBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		dictByUDescrIdx.put( keyUDescrIdx, Buff );

		dictByHostNameIdx.put( keyHostNameIdx, Buff );

	}

	public CFGenKbHostNodeBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbHostNodePKey PKey )
	{
		final String S_ProcName = "CFGenKbRamHostNode.readDerived";
		CFGenKbHostNodePKey key = schema.getFactoryHostNode().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredHostNodeId( PKey.getRequiredHostNodeId() );
		CFGenKbHostNodeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbHostNodeBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbHostNodePKey PKey )
	{
		final String S_ProcName = "CFGenKbRamHostNode.readDerived";
		CFGenKbHostNodePKey key = schema.getFactoryHostNode().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredHostNodeId( PKey.getRequiredHostNodeId() );
		CFGenKbHostNodeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbHostNodeBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamHostNode.readAllDerived";
		CFGenKbHostNodeBuff[] retList = new CFGenKbHostNodeBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbHostNodeBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbHostNodeBuff[] readDerivedByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFGenKbRamHostNode.readDerivedByClusterIdx";
		CFGenKbHostNodeByClusterIdxKey key = schema.getFactoryHostNode().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFGenKbHostNodeBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFGenKbHostNodePKey, CFGenKbHostNodeBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFGenKbHostNodeBuff[ subdictClusterIdx.size() ];
			Iterator< CFGenKbHostNodeBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbHostNodePKey, CFGenKbHostNodeBuff > subdictClusterIdx
				= new HashMap< CFGenKbHostNodePKey, CFGenKbHostNodeBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFGenKbHostNodeBuff[0];
		}
		return( recArray );
	}

	public CFGenKbHostNodeBuff readDerivedByUDescrIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		String Description )
	{
		final String S_ProcName = "CFGenKbRamHostNode.readDerivedByUDescrIdx";
		CFGenKbHostNodeByUDescrIdxKey key = schema.getFactoryHostNode().newUDescrIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredDescription( Description );

		CFGenKbHostNodeBuff buff;
		if( dictByUDescrIdx.containsKey( key ) ) {
			buff = dictByUDescrIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbHostNodeBuff readDerivedByHostNameIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		String HostName )
	{
		final String S_ProcName = "CFGenKbRamHostNode.readDerivedByHostNameIdx";
		CFGenKbHostNodeByHostNameIdxKey key = schema.getFactoryHostNode().newHostNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostName( HostName );

		CFGenKbHostNodeBuff buff;
		if( dictByHostNameIdx.containsKey( key ) ) {
			buff = dictByHostNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbHostNodeBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		long HostNodeId )
	{
		final String S_ProcName = "CFGenKbRamHostNode.readDerivedByIdIdx() ";
		CFGenKbHostNodePKey key = schema.getFactoryHostNode().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostNodeId( HostNodeId );

		CFGenKbHostNodeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbHostNodeBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbHostNodePKey PKey )
	{
		final String S_ProcName = "CFGenKbRamHostNode.readBuff";
		CFGenKbHostNodeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "HSND" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbHostNodeBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbHostNodePKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbHostNodeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "HSND" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbHostNodeBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamHostNode.readAllBuff";
		CFGenKbHostNodeBuff buff;
		ArrayList<CFGenKbHostNodeBuff> filteredList = new ArrayList<CFGenKbHostNodeBuff>();
		CFGenKbHostNodeBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "HSND" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbHostNodeBuff[0] ) );
	}

	/**
	 *	Read a page of all the specific HostNode buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific HostNode instances in the database accessible for the Authorization.
	 */
	public CFGenKbHostNodeBuff[] pageAllBuff( CFGenKbAuthorization Authorization,
		Long priorClusterId,
		Long priorHostNodeId )
	{
		final String S_ProcName = "pageAllBuff";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public CFGenKbHostNodeBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		long HostNodeId )
	{
		final String S_ProcName = "CFGenKbRamHostNode.readBuffByIdIdx() ";
		CFGenKbHostNodeBuff buff = readDerivedByIdIdx( Authorization,
			ClusterId,
			HostNodeId );
		if( ( buff != null ) && buff.getClassCode().equals( "HSND" ) ) {
			return( (CFGenKbHostNodeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbHostNodeBuff[] readBuffByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFGenKbRamHostNode.readBuffByClusterIdx() ";
		CFGenKbHostNodeBuff buff;
		ArrayList<CFGenKbHostNodeBuff> filteredList = new ArrayList<CFGenKbHostNodeBuff>();
		CFGenKbHostNodeBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "HSND" ) ) {
				filteredList.add( (CFGenKbHostNodeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbHostNodeBuff[0] ) );
	}

	public CFGenKbHostNodeBuff readBuffByUDescrIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		String Description )
	{
		final String S_ProcName = "CFGenKbRamHostNode.readBuffByUDescrIdx() ";
		CFGenKbHostNodeBuff buff = readDerivedByUDescrIdx( Authorization,
			ClusterId,
			Description );
		if( ( buff != null ) && buff.getClassCode().equals( "HSND" ) ) {
			return( (CFGenKbHostNodeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbHostNodeBuff readBuffByHostNameIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		String HostName )
	{
		final String S_ProcName = "CFGenKbRamHostNode.readBuffByHostNameIdx() ";
		CFGenKbHostNodeBuff buff = readDerivedByHostNameIdx( Authorization,
			ClusterId,
			HostName );
		if( ( buff != null ) && buff.getClassCode().equals( "HSND" ) ) {
			return( (CFGenKbHostNodeBuff)buff );
		}
		else {
			return( null );
		}
	}

	/**
	 *	Read a page array of the specific HostNode buffer instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbHostNodeBuff[] pageBuffByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		Long priorClusterId,
		Long priorHostNodeId )
	{
		final String S_ProcName = "pageBuffByClusterIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateHostNode( CFGenKbAuthorization Authorization,
		CFGenKbHostNodeBuff Buff )
	{
		CFGenKbHostNodePKey pkey = schema.getFactoryHostNode().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredHostNodeId( Buff.getRequiredHostNodeId() );
		CFGenKbHostNodeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateHostNode",
				"Existing record not found",
				"HostNode",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateHostNode",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbHostNodeByClusterIdxKey existingKeyClusterIdx = schema.getFactoryHostNode().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFGenKbHostNodeByClusterIdxKey newKeyClusterIdx = schema.getFactoryHostNode().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFGenKbHostNodeByUDescrIdxKey existingKeyUDescrIdx = schema.getFactoryHostNode().newUDescrIdxKey();
		existingKeyUDescrIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUDescrIdx.setRequiredDescription( existing.getRequiredDescription() );

		CFGenKbHostNodeByUDescrIdxKey newKeyUDescrIdx = schema.getFactoryHostNode().newUDescrIdxKey();
		newKeyUDescrIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUDescrIdx.setRequiredDescription( Buff.getRequiredDescription() );

		CFGenKbHostNodeByHostNameIdxKey existingKeyHostNameIdx = schema.getFactoryHostNode().newHostNameIdxKey();
		existingKeyHostNameIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyHostNameIdx.setRequiredHostName( existing.getRequiredHostName() );

		CFGenKbHostNodeByHostNameIdxKey newKeyHostNameIdx = schema.getFactoryHostNode().newHostNameIdxKey();
		newKeyHostNameIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyHostNameIdx.setRequiredHostName( Buff.getRequiredHostName() );

		// Check unique indexes

		if( ! existingKeyUDescrIdx.equals( newKeyUDescrIdx ) ) {
			if( dictByUDescrIdx.containsKey( newKeyUDescrIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateHostNode",
					"HostNodeUDescrIdx",
					newKeyUDescrIdx );
			}
		}

		if( ! existingKeyHostNameIdx.equals( newKeyHostNameIdx ) ) {
			if( dictByHostNameIdx.containsKey( newKeyHostNameIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateHostNode",
					"HostNodeUHostNameIdx",
					newKeyHostNameIdx );
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
						"updateHostNode",
						"Container",
						"HostNodeCluster",
						"Cluster",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbHostNodePKey, CFGenKbHostNodeBuff > subdict;

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
			subdict = new HashMap< CFGenKbHostNodePKey, CFGenKbHostNodeBuff >();
			dictByClusterIdx.put( newKeyClusterIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUDescrIdx.remove( existingKeyUDescrIdx );
		dictByUDescrIdx.put( newKeyUDescrIdx, Buff );

		dictByHostNameIdx.remove( existingKeyHostNameIdx );
		dictByHostNameIdx.put( newKeyHostNameIdx, Buff );

	}

	public void deleteHostNode( CFGenKbAuthorization Authorization,
		CFGenKbHostNodeBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamHostNodeTable.deleteHostNode() ";
		String classCode;
		CFGenKbHostNodePKey pkey = schema.getFactoryHostNode().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredHostNodeId( Buff.getRequiredHostNodeId() );
		CFGenKbHostNodeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteHostNode",
				pkey );
		}
		CFGenKbHostNodeByClusterIdxKey keyClusterIdx = schema.getFactoryHostNode().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFGenKbHostNodeByUDescrIdxKey keyUDescrIdx = schema.getFactoryHostNode().newUDescrIdxKey();
		keyUDescrIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUDescrIdx.setRequiredDescription( existing.getRequiredDescription() );

		CFGenKbHostNodeByHostNameIdxKey keyHostNameIdx = schema.getFactoryHostNode().newHostNameIdxKey();
		keyHostNameIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyHostNameIdx.setRequiredHostName( existing.getRequiredHostName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbHostNodePKey, CFGenKbHostNodeBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		dictByUDescrIdx.remove( keyUDescrIdx );

		dictByHostNameIdx.remove( keyHostNameIdx );

	}
	public void deleteHostNodeByIdIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		long argHostNodeId )
	{
		CFGenKbHostNodePKey key = schema.getFactoryHostNode().newPKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredHostNodeId( argHostNodeId );
		deleteHostNodeByIdIdx( Authorization, key );
	}

	public void deleteHostNodeByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbHostNodePKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbHostNodeBuff cur;
		LinkedList<CFGenKbHostNodeBuff> matchSet = new LinkedList<CFGenKbHostNodeBuff>();
		Iterator<CFGenKbHostNodeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbHostNodeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableHostNode().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredHostNodeId() );
			deleteHostNode( Authorization, cur );
		}
	}

	public void deleteHostNodeByClusterIdx( CFGenKbAuthorization Authorization,
		long argClusterId )
	{
		CFGenKbHostNodeByClusterIdxKey key = schema.getFactoryHostNode().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteHostNodeByClusterIdx( Authorization, key );
	}

	public void deleteHostNodeByClusterIdx( CFGenKbAuthorization Authorization,
		CFGenKbHostNodeByClusterIdxKey argKey )
	{
		CFGenKbHostNodeBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbHostNodeBuff> matchSet = new LinkedList<CFGenKbHostNodeBuff>();
		Iterator<CFGenKbHostNodeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbHostNodeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableHostNode().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredHostNodeId() );
			deleteHostNode( Authorization, cur );
		}
	}

	public void deleteHostNodeByUDescrIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		String argDescription )
	{
		CFGenKbHostNodeByUDescrIdxKey key = schema.getFactoryHostNode().newUDescrIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredDescription( argDescription );
		deleteHostNodeByUDescrIdx( Authorization, key );
	}

	public void deleteHostNodeByUDescrIdx( CFGenKbAuthorization Authorization,
		CFGenKbHostNodeByUDescrIdxKey argKey )
	{
		CFGenKbHostNodeBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbHostNodeBuff> matchSet = new LinkedList<CFGenKbHostNodeBuff>();
		Iterator<CFGenKbHostNodeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbHostNodeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableHostNode().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredHostNodeId() );
			deleteHostNode( Authorization, cur );
		}
	}

	public void deleteHostNodeByHostNameIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		String argHostName )
	{
		CFGenKbHostNodeByHostNameIdxKey key = schema.getFactoryHostNode().newHostNameIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredHostName( argHostName );
		deleteHostNodeByHostNameIdx( Authorization, key );
	}

	public void deleteHostNodeByHostNameIdx( CFGenKbAuthorization Authorization,
		CFGenKbHostNodeByHostNameIdxKey argKey )
	{
		CFGenKbHostNodeBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbHostNodeBuff> matchSet = new LinkedList<CFGenKbHostNodeBuff>();
		Iterator<CFGenKbHostNodeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbHostNodeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableHostNode().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredHostNodeId() );
			deleteHostNode( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
