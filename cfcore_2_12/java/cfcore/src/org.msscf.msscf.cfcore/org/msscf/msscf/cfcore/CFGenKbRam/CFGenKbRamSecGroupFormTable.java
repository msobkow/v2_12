
// Description: Java 11 in-memory RAM DbIO implementation for SecGroupForm.

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
 *	CFGenKbRamSecGroupFormTable in-memory RAM DbIO implementation
 *	for SecGroupForm.
 */
public class CFGenKbRamSecGroupFormTable
	implements ICFGenKbSecGroupFormTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbSecGroupFormPKey,
				CFGenKbSecGroupFormBuff > dictByPKey
		= new HashMap< CFGenKbSecGroupFormPKey,
				CFGenKbSecGroupFormBuff >();
	private Map< CFGenKbSecGroupFormByClusterIdxKey,
				Map< CFGenKbSecGroupFormPKey,
					CFGenKbSecGroupFormBuff >> dictByClusterIdx
		= new HashMap< CFGenKbSecGroupFormByClusterIdxKey,
				Map< CFGenKbSecGroupFormPKey,
					CFGenKbSecGroupFormBuff >>();
	private Map< CFGenKbSecGroupFormByGroupIdxKey,
				Map< CFGenKbSecGroupFormPKey,
					CFGenKbSecGroupFormBuff >> dictByGroupIdx
		= new HashMap< CFGenKbSecGroupFormByGroupIdxKey,
				Map< CFGenKbSecGroupFormPKey,
					CFGenKbSecGroupFormBuff >>();
	private Map< CFGenKbSecGroupFormByAppIdxKey,
				Map< CFGenKbSecGroupFormPKey,
					CFGenKbSecGroupFormBuff >> dictByAppIdx
		= new HashMap< CFGenKbSecGroupFormByAppIdxKey,
				Map< CFGenKbSecGroupFormPKey,
					CFGenKbSecGroupFormBuff >>();
	private Map< CFGenKbSecGroupFormByFormIdxKey,
				Map< CFGenKbSecGroupFormPKey,
					CFGenKbSecGroupFormBuff >> dictByFormIdx
		= new HashMap< CFGenKbSecGroupFormByFormIdxKey,
				Map< CFGenKbSecGroupFormPKey,
					CFGenKbSecGroupFormBuff >>();
	private Map< CFGenKbSecGroupFormByUFormIdxKey,
			CFGenKbSecGroupFormBuff > dictByUFormIdx
		= new HashMap< CFGenKbSecGroupFormByUFormIdxKey,
			CFGenKbSecGroupFormBuff >();

	public CFGenKbRamSecGroupFormTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecGroupForm( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupFormBuff Buff )
	{
		final String S_ProcName = "createSecGroupForm";
		CFGenKbSecGroupFormPKey pkey = schema.getFactorySecGroupForm().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGroupFormId( ((CFGenKbRamClusterTable)schema.getTableCluster()).nextSecGroupFormIdGen( Authorization,
			Buff.getRequiredClusterId() ) );
		Buff.setRequiredClusterId( pkey.getRequiredClusterId() );
		Buff.setRequiredSecGroupFormId( pkey.getRequiredSecGroupFormId() );
		CFGenKbSecGroupFormByClusterIdxKey keyClusterIdx = schema.getFactorySecGroupForm().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFGenKbSecGroupFormByGroupIdxKey keyGroupIdx = schema.getFactorySecGroupForm().newGroupIdxKey();
		keyGroupIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyGroupIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );

		CFGenKbSecGroupFormByAppIdxKey keyAppIdx = schema.getFactorySecGroupForm().newAppIdxKey();
		keyAppIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyAppIdx.setRequiredSecAppId( Buff.getRequiredSecAppId() );

		CFGenKbSecGroupFormByFormIdxKey keyFormIdx = schema.getFactorySecGroupForm().newFormIdxKey();
		keyFormIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyFormIdx.setRequiredSecFormId( Buff.getRequiredSecFormId() );

		CFGenKbSecGroupFormByUFormIdxKey keyUFormIdx = schema.getFactorySecGroupForm().newUFormIdxKey();
		keyUFormIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUFormIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );
		keyUFormIdx.setRequiredSecFormId( Buff.getRequiredSecFormId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUFormIdx.containsKey( keyUFormIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecGroupFormUFormIdx",
				keyUFormIdx );
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
						"Owner",
						"SecGroupFormCluster",
						"Cluster",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableSecGroup().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId(),
						Buff.getRequiredSecGroupId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"SecGroupFormGroup",
						"SecGroup",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		Map< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff > subdictGroupIdx;
		if( dictByGroupIdx.containsKey( keyGroupIdx ) ) {
			subdictGroupIdx = dictByGroupIdx.get( keyGroupIdx );
		}
		else {
			subdictGroupIdx = new HashMap< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff >();
			dictByGroupIdx.put( keyGroupIdx, subdictGroupIdx );
		}
		subdictGroupIdx.put( pkey, Buff );

		Map< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff > subdictAppIdx;
		if( dictByAppIdx.containsKey( keyAppIdx ) ) {
			subdictAppIdx = dictByAppIdx.get( keyAppIdx );
		}
		else {
			subdictAppIdx = new HashMap< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff >();
			dictByAppIdx.put( keyAppIdx, subdictAppIdx );
		}
		subdictAppIdx.put( pkey, Buff );

		Map< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff > subdictFormIdx;
		if( dictByFormIdx.containsKey( keyFormIdx ) ) {
			subdictFormIdx = dictByFormIdx.get( keyFormIdx );
		}
		else {
			subdictFormIdx = new HashMap< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff >();
			dictByFormIdx.put( keyFormIdx, subdictFormIdx );
		}
		subdictFormIdx.put( pkey, Buff );

		dictByUFormIdx.put( keyUFormIdx, Buff );

	}

	public CFGenKbSecGroupFormBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupFormPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecGroupForm.readDerived";
		CFGenKbSecGroupFormPKey key = schema.getFactorySecGroupForm().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecGroupFormId( PKey.getRequiredSecGroupFormId() );
		CFGenKbSecGroupFormBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGroupFormBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupFormPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecGroupForm.readDerived";
		CFGenKbSecGroupFormPKey key = schema.getFactorySecGroupForm().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecGroupFormId( PKey.getRequiredSecGroupFormId() );
		CFGenKbSecGroupFormBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGroupFormBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamSecGroupForm.readAllDerived";
		CFGenKbSecGroupFormBuff[] retList = new CFGenKbSecGroupFormBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbSecGroupFormBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbSecGroupFormBuff[] readDerivedByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFGenKbRamSecGroupForm.readDerivedByClusterIdx";
		CFGenKbSecGroupFormByClusterIdxKey key = schema.getFactorySecGroupForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFGenKbSecGroupFormBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFGenKbSecGroupFormBuff[ subdictClusterIdx.size() ];
			Iterator< CFGenKbSecGroupFormBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff > subdictClusterIdx
				= new HashMap< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFGenKbSecGroupFormBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecGroupFormBuff[] readDerivedByGroupIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		final String S_ProcName = "CFGenKbRamSecGroupForm.readDerivedByGroupIdx";
		CFGenKbSecGroupFormByGroupIdxKey key = schema.getFactorySecGroupForm().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );

		CFGenKbSecGroupFormBuff[] recArray;
		if( dictByGroupIdx.containsKey( key ) ) {
			Map< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff > subdictGroupIdx
				= dictByGroupIdx.get( key );
			recArray = new CFGenKbSecGroupFormBuff[ subdictGroupIdx.size() ];
			Iterator< CFGenKbSecGroupFormBuff > iter = subdictGroupIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff > subdictGroupIdx
				= new HashMap< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff >();
			dictByGroupIdx.put( key, subdictGroupIdx );
			recArray = new CFGenKbSecGroupFormBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecGroupFormBuff[] readDerivedByAppIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecAppId )
	{
		final String S_ProcName = "CFGenKbRamSecGroupForm.readDerivedByAppIdx";
		CFGenKbSecGroupFormByAppIdxKey key = schema.getFactorySecGroupForm().newAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );

		CFGenKbSecGroupFormBuff[] recArray;
		if( dictByAppIdx.containsKey( key ) ) {
			Map< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff > subdictAppIdx
				= dictByAppIdx.get( key );
			recArray = new CFGenKbSecGroupFormBuff[ subdictAppIdx.size() ];
			Iterator< CFGenKbSecGroupFormBuff > iter = subdictAppIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff > subdictAppIdx
				= new HashMap< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff >();
			dictByAppIdx.put( key, subdictAppIdx );
			recArray = new CFGenKbSecGroupFormBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecGroupFormBuff[] readDerivedByFormIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecFormId )
	{
		final String S_ProcName = "CFGenKbRamSecGroupForm.readDerivedByFormIdx";
		CFGenKbSecGroupFormByFormIdxKey key = schema.getFactorySecGroupForm().newFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecFormId( SecFormId );

		CFGenKbSecGroupFormBuff[] recArray;
		if( dictByFormIdx.containsKey( key ) ) {
			Map< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff > subdictFormIdx
				= dictByFormIdx.get( key );
			recArray = new CFGenKbSecGroupFormBuff[ subdictFormIdx.size() ];
			Iterator< CFGenKbSecGroupFormBuff > iter = subdictFormIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff > subdictFormIdx
				= new HashMap< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff >();
			dictByFormIdx.put( key, subdictFormIdx );
			recArray = new CFGenKbSecGroupFormBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecGroupFormBuff readDerivedByUFormIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		int SecFormId )
	{
		final String S_ProcName = "CFGenKbRamSecGroupForm.readDerivedByUFormIdx";
		CFGenKbSecGroupFormByUFormIdxKey key = schema.getFactorySecGroupForm().newUFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecFormId( SecFormId );

		CFGenKbSecGroupFormBuff buff;
		if( dictByUFormIdx.containsKey( key ) ) {
			buff = dictByUFormIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGroupFormBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		long SecGroupFormId )
	{
		final String S_ProcName = "CFGenKbRamSecGroupForm.readDerivedByIdIdx() ";
		CFGenKbSecGroupFormPKey key = schema.getFactorySecGroupForm().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupFormId( SecGroupFormId );

		CFGenKbSecGroupFormBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGroupFormBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupFormPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecGroupForm.readBuff";
		CFGenKbSecGroupFormBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SGFM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGroupFormBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupFormPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbSecGroupFormBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SGFM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecGroupFormBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamSecGroupForm.readAllBuff";
		CFGenKbSecGroupFormBuff buff;
		ArrayList<CFGenKbSecGroupFormBuff> filteredList = new ArrayList<CFGenKbSecGroupFormBuff>();
		CFGenKbSecGroupFormBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGFM" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecGroupFormBuff[0] ) );
	}

	/**
	 *	Read a page of all the specific SecGroupForm buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecGroupForm instances in the database accessible for the Authorization.
	 */
	public CFGenKbSecGroupFormBuff[] pageAllBuff( CFGenKbAuthorization Authorization,
		Long priorClusterId,
		Long priorSecGroupFormId )
	{
		final String S_ProcName = "pageAllBuff";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public CFGenKbSecGroupFormBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		long SecGroupFormId )
	{
		final String S_ProcName = "CFGenKbRamSecGroupForm.readBuffByIdIdx() ";
		CFGenKbSecGroupFormBuff buff = readDerivedByIdIdx( Authorization,
			ClusterId,
			SecGroupFormId );
		if( ( buff != null ) && buff.getClassCode().equals( "SGFM" ) ) {
			return( (CFGenKbSecGroupFormBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbSecGroupFormBuff[] readBuffByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFGenKbRamSecGroupForm.readBuffByClusterIdx() ";
		CFGenKbSecGroupFormBuff buff;
		ArrayList<CFGenKbSecGroupFormBuff> filteredList = new ArrayList<CFGenKbSecGroupFormBuff>();
		CFGenKbSecGroupFormBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGFM" ) ) {
				filteredList.add( (CFGenKbSecGroupFormBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecGroupFormBuff[0] ) );
	}

	public CFGenKbSecGroupFormBuff[] readBuffByGroupIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecGroupId )
	{
		final String S_ProcName = "CFGenKbRamSecGroupForm.readBuffByGroupIdx() ";
		CFGenKbSecGroupFormBuff buff;
		ArrayList<CFGenKbSecGroupFormBuff> filteredList = new ArrayList<CFGenKbSecGroupFormBuff>();
		CFGenKbSecGroupFormBuff[] buffList = readDerivedByGroupIdx( Authorization,
			ClusterId,
			SecGroupId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGFM" ) ) {
				filteredList.add( (CFGenKbSecGroupFormBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecGroupFormBuff[0] ) );
	}

	public CFGenKbSecGroupFormBuff[] readBuffByAppIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecAppId )
	{
		final String S_ProcName = "CFGenKbRamSecGroupForm.readBuffByAppIdx() ";
		CFGenKbSecGroupFormBuff buff;
		ArrayList<CFGenKbSecGroupFormBuff> filteredList = new ArrayList<CFGenKbSecGroupFormBuff>();
		CFGenKbSecGroupFormBuff[] buffList = readDerivedByAppIdx( Authorization,
			ClusterId,
			SecAppId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGFM" ) ) {
				filteredList.add( (CFGenKbSecGroupFormBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecGroupFormBuff[0] ) );
	}

	public CFGenKbSecGroupFormBuff[] readBuffByFormIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecFormId )
	{
		final String S_ProcName = "CFGenKbRamSecGroupForm.readBuffByFormIdx() ";
		CFGenKbSecGroupFormBuff buff;
		ArrayList<CFGenKbSecGroupFormBuff> filteredList = new ArrayList<CFGenKbSecGroupFormBuff>();
		CFGenKbSecGroupFormBuff[] buffList = readDerivedByFormIdx( Authorization,
			ClusterId,
			SecFormId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SGFM" ) ) {
				filteredList.add( (CFGenKbSecGroupFormBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecGroupFormBuff[0] ) );
	}

	public CFGenKbSecGroupFormBuff readBuffByUFormIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		int SecFormId )
	{
		final String S_ProcName = "CFGenKbRamSecGroupForm.readBuffByUFormIdx() ";
		CFGenKbSecGroupFormBuff buff = readDerivedByUFormIdx( Authorization,
			ClusterId,
			SecGroupId,
			SecFormId );
		if( ( buff != null ) && buff.getClassCode().equals( "SGFM" ) ) {
			return( (CFGenKbSecGroupFormBuff)buff );
		}
		else {
			return( null );
		}
	}

	/**
	 *	Read a page array of the specific SecGroupForm buffer instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecGroupFormBuff[] pageBuffByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		Long priorClusterId,
		Long priorSecGroupFormId )
	{
		final String S_ProcName = "pageBuffByClusterIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecGroupForm buffer instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecGroupFormBuff[] pageBuffByGroupIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		Long priorClusterId,
		Long priorSecGroupFormId )
	{
		final String S_ProcName = "pageBuffByGroupIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecGroupForm buffer instances identified by the duplicate key AppIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecAppId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecGroupFormBuff[] pageBuffByAppIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecAppId,
		Long priorClusterId,
		Long priorSecGroupFormId )
	{
		final String S_ProcName = "pageBuffByAppIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecGroupForm buffer instances identified by the duplicate key FormIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecFormId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecGroupFormBuff[] pageBuffByFormIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecFormId,
		Long priorClusterId,
		Long priorSecGroupFormId )
	{
		final String S_ProcName = "pageBuffByFormIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateSecGroupForm( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupFormBuff Buff )
	{
		CFGenKbSecGroupFormPKey pkey = schema.getFactorySecGroupForm().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGroupFormId( Buff.getRequiredSecGroupFormId() );
		CFGenKbSecGroupFormBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateSecGroupForm",
				"Existing record not found",
				"SecGroupForm",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateSecGroupForm",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbSecGroupFormByClusterIdxKey existingKeyClusterIdx = schema.getFactorySecGroupForm().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFGenKbSecGroupFormByClusterIdxKey newKeyClusterIdx = schema.getFactorySecGroupForm().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFGenKbSecGroupFormByGroupIdxKey existingKeyGroupIdx = schema.getFactorySecGroupForm().newGroupIdxKey();
		existingKeyGroupIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyGroupIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );

		CFGenKbSecGroupFormByGroupIdxKey newKeyGroupIdx = schema.getFactorySecGroupForm().newGroupIdxKey();
		newKeyGroupIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyGroupIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );

		CFGenKbSecGroupFormByAppIdxKey existingKeyAppIdx = schema.getFactorySecGroupForm().newAppIdxKey();
		existingKeyAppIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyAppIdx.setRequiredSecAppId( existing.getRequiredSecAppId() );

		CFGenKbSecGroupFormByAppIdxKey newKeyAppIdx = schema.getFactorySecGroupForm().newAppIdxKey();
		newKeyAppIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyAppIdx.setRequiredSecAppId( Buff.getRequiredSecAppId() );

		CFGenKbSecGroupFormByFormIdxKey existingKeyFormIdx = schema.getFactorySecGroupForm().newFormIdxKey();
		existingKeyFormIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyFormIdx.setRequiredSecFormId( existing.getRequiredSecFormId() );

		CFGenKbSecGroupFormByFormIdxKey newKeyFormIdx = schema.getFactorySecGroupForm().newFormIdxKey();
		newKeyFormIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyFormIdx.setRequiredSecFormId( Buff.getRequiredSecFormId() );

		CFGenKbSecGroupFormByUFormIdxKey existingKeyUFormIdx = schema.getFactorySecGroupForm().newUFormIdxKey();
		existingKeyUFormIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUFormIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );
		existingKeyUFormIdx.setRequiredSecFormId( existing.getRequiredSecFormId() );

		CFGenKbSecGroupFormByUFormIdxKey newKeyUFormIdx = schema.getFactorySecGroupForm().newUFormIdxKey();
		newKeyUFormIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUFormIdx.setRequiredSecGroupId( Buff.getRequiredSecGroupId() );
		newKeyUFormIdx.setRequiredSecFormId( Buff.getRequiredSecFormId() );

		// Check unique indexes

		if( ! existingKeyUFormIdx.equals( newKeyUFormIdx ) ) {
			if( dictByUFormIdx.containsKey( newKeyUFormIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateSecGroupForm",
					"SecGroupFormUFormIdx",
					newKeyUFormIdx );
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
						"updateSecGroupForm",
						"Owner",
						"SecGroupFormCluster",
						"Cluster",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecGroup().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId(),
						Buff.getRequiredSecGroupId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateSecGroupForm",
						"Container",
						"SecGroupFormGroup",
						"SecGroup",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff > subdict;

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
			subdict = new HashMap< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff >();
			dictByClusterIdx.put( newKeyClusterIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByGroupIdx.get( existingKeyGroupIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByGroupIdx.containsKey( newKeyGroupIdx ) ) {
			subdict = dictByGroupIdx.get( newKeyGroupIdx );
		}
		else {
			subdict = new HashMap< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff >();
			dictByGroupIdx.put( newKeyGroupIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByAppIdx.get( existingKeyAppIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByAppIdx.containsKey( newKeyAppIdx ) ) {
			subdict = dictByAppIdx.get( newKeyAppIdx );
		}
		else {
			subdict = new HashMap< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff >();
			dictByAppIdx.put( newKeyAppIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByFormIdx.get( existingKeyFormIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByFormIdx.containsKey( newKeyFormIdx ) ) {
			subdict = dictByFormIdx.get( newKeyFormIdx );
		}
		else {
			subdict = new HashMap< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff >();
			dictByFormIdx.put( newKeyFormIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUFormIdx.remove( existingKeyUFormIdx );
		dictByUFormIdx.put( newKeyUFormIdx, Buff );

	}

	public void deleteSecGroupForm( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupFormBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamSecGroupFormTable.deleteSecGroupForm() ";
		String classCode;
		CFGenKbSecGroupFormPKey pkey = schema.getFactorySecGroupForm().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecGroupFormId( Buff.getRequiredSecGroupFormId() );
		CFGenKbSecGroupFormBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteSecGroupForm",
				pkey );
		}
		CFGenKbSecGroupFormByClusterIdxKey keyClusterIdx = schema.getFactorySecGroupForm().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFGenKbSecGroupFormByGroupIdxKey keyGroupIdx = schema.getFactorySecGroupForm().newGroupIdxKey();
		keyGroupIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyGroupIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );

		CFGenKbSecGroupFormByAppIdxKey keyAppIdx = schema.getFactorySecGroupForm().newAppIdxKey();
		keyAppIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyAppIdx.setRequiredSecAppId( existing.getRequiredSecAppId() );

		CFGenKbSecGroupFormByFormIdxKey keyFormIdx = schema.getFactorySecGroupForm().newFormIdxKey();
		keyFormIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyFormIdx.setRequiredSecFormId( existing.getRequiredSecFormId() );

		CFGenKbSecGroupFormByUFormIdxKey keyUFormIdx = schema.getFactorySecGroupForm().newUFormIdxKey();
		keyUFormIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUFormIdx.setRequiredSecGroupId( existing.getRequiredSecGroupId() );
		keyUFormIdx.setRequiredSecFormId( existing.getRequiredSecFormId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbSecGroupFormPKey, CFGenKbSecGroupFormBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		subdict = dictByGroupIdx.get( keyGroupIdx );
		subdict.remove( pkey );

		subdict = dictByAppIdx.get( keyAppIdx );
		subdict.remove( pkey );

		subdict = dictByFormIdx.get( keyFormIdx );
		subdict.remove( pkey );

		dictByUFormIdx.remove( keyUFormIdx );

	}
	public void deleteSecGroupFormByIdIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		long argSecGroupFormId )
	{
		CFGenKbSecGroupFormPKey key = schema.getFactorySecGroupForm().newPKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGroupFormId( argSecGroupFormId );
		deleteSecGroupFormByIdIdx( Authorization, key );
	}

	public void deleteSecGroupFormByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupFormPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbSecGroupFormBuff cur;
		LinkedList<CFGenKbSecGroupFormBuff> matchSet = new LinkedList<CFGenKbSecGroupFormBuff>();
		Iterator<CFGenKbSecGroupFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGroupFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGroupForm().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGroupFormId() );
			deleteSecGroupForm( Authorization, cur );
		}
	}

	public void deleteSecGroupFormByClusterIdx( CFGenKbAuthorization Authorization,
		long argClusterId )
	{
		CFGenKbSecGroupFormByClusterIdxKey key = schema.getFactorySecGroupForm().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteSecGroupFormByClusterIdx( Authorization, key );
	}

	public void deleteSecGroupFormByClusterIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupFormByClusterIdxKey argKey )
	{
		CFGenKbSecGroupFormBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecGroupFormBuff> matchSet = new LinkedList<CFGenKbSecGroupFormBuff>();
		Iterator<CFGenKbSecGroupFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGroupFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGroupForm().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGroupFormId() );
			deleteSecGroupForm( Authorization, cur );
		}
	}

	public void deleteSecGroupFormByGroupIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		int argSecGroupId )
	{
		CFGenKbSecGroupFormByGroupIdxKey key = schema.getFactorySecGroupForm().newGroupIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGroupId( argSecGroupId );
		deleteSecGroupFormByGroupIdx( Authorization, key );
	}

	public void deleteSecGroupFormByGroupIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupFormByGroupIdxKey argKey )
	{
		CFGenKbSecGroupFormBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecGroupFormBuff> matchSet = new LinkedList<CFGenKbSecGroupFormBuff>();
		Iterator<CFGenKbSecGroupFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGroupFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGroupForm().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGroupFormId() );
			deleteSecGroupForm( Authorization, cur );
		}
	}

	public void deleteSecGroupFormByAppIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		int argSecAppId )
	{
		CFGenKbSecGroupFormByAppIdxKey key = schema.getFactorySecGroupForm().newAppIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecAppId( argSecAppId );
		deleteSecGroupFormByAppIdx( Authorization, key );
	}

	public void deleteSecGroupFormByAppIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupFormByAppIdxKey argKey )
	{
		CFGenKbSecGroupFormBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecGroupFormBuff> matchSet = new LinkedList<CFGenKbSecGroupFormBuff>();
		Iterator<CFGenKbSecGroupFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGroupFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGroupForm().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGroupFormId() );
			deleteSecGroupForm( Authorization, cur );
		}
	}

	public void deleteSecGroupFormByFormIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		int argSecFormId )
	{
		CFGenKbSecGroupFormByFormIdxKey key = schema.getFactorySecGroupForm().newFormIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecFormId( argSecFormId );
		deleteSecGroupFormByFormIdx( Authorization, key );
	}

	public void deleteSecGroupFormByFormIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupFormByFormIdxKey argKey )
	{
		CFGenKbSecGroupFormBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecGroupFormBuff> matchSet = new LinkedList<CFGenKbSecGroupFormBuff>();
		Iterator<CFGenKbSecGroupFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGroupFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGroupForm().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGroupFormId() );
			deleteSecGroupForm( Authorization, cur );
		}
	}

	public void deleteSecGroupFormByUFormIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		int argSecGroupId,
		int argSecFormId )
	{
		CFGenKbSecGroupFormByUFormIdxKey key = schema.getFactorySecGroupForm().newUFormIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecGroupId( argSecGroupId );
		key.setRequiredSecFormId( argSecFormId );
		deleteSecGroupFormByUFormIdx( Authorization, key );
	}

	public void deleteSecGroupFormByUFormIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecGroupFormByUFormIdxKey argKey )
	{
		CFGenKbSecGroupFormBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecGroupFormBuff> matchSet = new LinkedList<CFGenKbSecGroupFormBuff>();
		Iterator<CFGenKbSecGroupFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecGroupFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecGroupForm().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecGroupFormId() );
			deleteSecGroupForm( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
