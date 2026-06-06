
// Description: Java 11 in-memory RAM DbIO implementation for SecForm.

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
 *	CFGenKbRamSecFormTable in-memory RAM DbIO implementation
 *	for SecForm.
 */
public class CFGenKbRamSecFormTable
	implements ICFGenKbSecFormTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbSecFormPKey,
				CFGenKbSecFormBuff > dictByPKey
		= new HashMap< CFGenKbSecFormPKey,
				CFGenKbSecFormBuff >();
	private Map< CFGenKbSecFormByClusterIdxKey,
				Map< CFGenKbSecFormPKey,
					CFGenKbSecFormBuff >> dictByClusterIdx
		= new HashMap< CFGenKbSecFormByClusterIdxKey,
				Map< CFGenKbSecFormPKey,
					CFGenKbSecFormBuff >>();
	private Map< CFGenKbSecFormBySecAppIdxKey,
				Map< CFGenKbSecFormPKey,
					CFGenKbSecFormBuff >> dictBySecAppIdx
		= new HashMap< CFGenKbSecFormBySecAppIdxKey,
				Map< CFGenKbSecFormPKey,
					CFGenKbSecFormBuff >>();
	private Map< CFGenKbSecFormByUJEEServletIdxKey,
			CFGenKbSecFormBuff > dictByUJEEServletIdx
		= new HashMap< CFGenKbSecFormByUJEEServletIdxKey,
			CFGenKbSecFormBuff >();

	public CFGenKbRamSecFormTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecForm( CFGenKbAuthorization Authorization,
		CFGenKbSecFormBuff Buff )
	{
		final String S_ProcName = "createSecForm";
		CFGenKbSecFormPKey pkey = schema.getFactorySecForm().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecFormId( ((CFGenKbRamClusterTable)schema.getTableCluster()).nextSecFormIdGen( Authorization,
			Buff.getRequiredClusterId() ) );
		Buff.setRequiredClusterId( pkey.getRequiredClusterId() );
		Buff.setRequiredSecFormId( pkey.getRequiredSecFormId() );
		CFGenKbSecFormByClusterIdxKey keyClusterIdx = schema.getFactorySecForm().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFGenKbSecFormBySecAppIdxKey keySecAppIdx = schema.getFactorySecForm().newSecAppIdxKey();
		keySecAppIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keySecAppIdx.setRequiredSecAppId( Buff.getRequiredSecAppId() );

		CFGenKbSecFormByUJEEServletIdxKey keyUJEEServletIdx = schema.getFactorySecForm().newUJEEServletIdxKey();
		keyUJEEServletIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUJEEServletIdx.setRequiredSecAppId( Buff.getRequiredSecAppId() );
		keyUJEEServletIdx.setRequiredJEEServletMapName( Buff.getRequiredJEEServletMapName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUJEEServletIdx.containsKey( keyUJEEServletIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecFormUJEEServletIdx",
				keyUJEEServletIdx );
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
						"SecFormCluster",
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
				if( null == schema.getTableSecApp().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId(),
						Buff.getRequiredSecAppId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"SecFormApplication",
						"SecApp",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbSecFormPKey, CFGenKbSecFormBuff > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< CFGenKbSecFormPKey, CFGenKbSecFormBuff >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		Map< CFGenKbSecFormPKey, CFGenKbSecFormBuff > subdictSecAppIdx;
		if( dictBySecAppIdx.containsKey( keySecAppIdx ) ) {
			subdictSecAppIdx = dictBySecAppIdx.get( keySecAppIdx );
		}
		else {
			subdictSecAppIdx = new HashMap< CFGenKbSecFormPKey, CFGenKbSecFormBuff >();
			dictBySecAppIdx.put( keySecAppIdx, subdictSecAppIdx );
		}
		subdictSecAppIdx.put( pkey, Buff );

		dictByUJEEServletIdx.put( keyUJEEServletIdx, Buff );

	}

	public CFGenKbSecFormBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbSecFormPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecForm.readDerived";
		CFGenKbSecFormPKey key = schema.getFactorySecForm().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecFormId( PKey.getRequiredSecFormId() );
		CFGenKbSecFormBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecFormBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbSecFormPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecForm.readDerived";
		CFGenKbSecFormPKey key = schema.getFactorySecForm().newPKey();
		key.setRequiredClusterId( PKey.getRequiredClusterId() );
		key.setRequiredSecFormId( PKey.getRequiredSecFormId() );
		CFGenKbSecFormBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecFormBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamSecForm.readAllDerived";
		CFGenKbSecFormBuff[] retList = new CFGenKbSecFormBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbSecFormBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbSecFormBuff[] readDerivedByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFGenKbRamSecForm.readDerivedByClusterIdx";
		CFGenKbSecFormByClusterIdxKey key = schema.getFactorySecForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );

		CFGenKbSecFormBuff[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< CFGenKbSecFormPKey, CFGenKbSecFormBuff > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new CFGenKbSecFormBuff[ subdictClusterIdx.size() ];
			Iterator< CFGenKbSecFormBuff > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecFormPKey, CFGenKbSecFormBuff > subdictClusterIdx
				= new HashMap< CFGenKbSecFormPKey, CFGenKbSecFormBuff >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new CFGenKbSecFormBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecFormBuff[] readDerivedBySecAppIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecAppId )
	{
		final String S_ProcName = "CFGenKbRamSecForm.readDerivedBySecAppIdx";
		CFGenKbSecFormBySecAppIdxKey key = schema.getFactorySecForm().newSecAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );

		CFGenKbSecFormBuff[] recArray;
		if( dictBySecAppIdx.containsKey( key ) ) {
			Map< CFGenKbSecFormPKey, CFGenKbSecFormBuff > subdictSecAppIdx
				= dictBySecAppIdx.get( key );
			recArray = new CFGenKbSecFormBuff[ subdictSecAppIdx.size() ];
			Iterator< CFGenKbSecFormBuff > iter = subdictSecAppIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecFormPKey, CFGenKbSecFormBuff > subdictSecAppIdx
				= new HashMap< CFGenKbSecFormPKey, CFGenKbSecFormBuff >();
			dictBySecAppIdx.put( key, subdictSecAppIdx );
			recArray = new CFGenKbSecFormBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecFormBuff readDerivedByUJEEServletIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecAppId,
		String JEEServletMapName )
	{
		final String S_ProcName = "CFGenKbRamSecForm.readDerivedByUJEEServletIdx";
		CFGenKbSecFormByUJEEServletIdxKey key = schema.getFactorySecForm().newUJEEServletIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		key.setRequiredJEEServletMapName( JEEServletMapName );

		CFGenKbSecFormBuff buff;
		if( dictByUJEEServletIdx.containsKey( key ) ) {
			buff = dictByUJEEServletIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecFormBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecFormId )
	{
		final String S_ProcName = "CFGenKbRamSecForm.readDerivedByIdIdx() ";
		CFGenKbSecFormPKey key = schema.getFactorySecForm().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecFormId( SecFormId );

		CFGenKbSecFormBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecFormBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbSecFormPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecForm.readBuff";
		CFGenKbSecFormBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SFRM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecFormBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbSecFormPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbSecFormBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SFRM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecFormBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamSecForm.readAllBuff";
		CFGenKbSecFormBuff buff;
		ArrayList<CFGenKbSecFormBuff> filteredList = new ArrayList<CFGenKbSecFormBuff>();
		CFGenKbSecFormBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SFRM" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecFormBuff[0] ) );
	}

	/**
	 *	Read a page of all the specific SecForm buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecForm instances in the database accessible for the Authorization.
	 */
	public CFGenKbSecFormBuff[] pageAllBuff( CFGenKbAuthorization Authorization,
		Long priorClusterId,
		Integer priorSecFormId )
	{
		final String S_ProcName = "pageAllBuff";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public CFGenKbSecFormBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecFormId )
	{
		final String S_ProcName = "CFGenKbRamSecForm.readBuffByIdIdx() ";
		CFGenKbSecFormBuff buff = readDerivedByIdIdx( Authorization,
			ClusterId,
			SecFormId );
		if( ( buff != null ) && buff.getClassCode().equals( "SFRM" ) ) {
			return( (CFGenKbSecFormBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbSecFormBuff[] readBuffByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "CFGenKbRamSecForm.readBuffByClusterIdx() ";
		CFGenKbSecFormBuff buff;
		ArrayList<CFGenKbSecFormBuff> filteredList = new ArrayList<CFGenKbSecFormBuff>();
		CFGenKbSecFormBuff[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SFRM" ) ) {
				filteredList.add( (CFGenKbSecFormBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecFormBuff[0] ) );
	}

	public CFGenKbSecFormBuff[] readBuffBySecAppIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecAppId )
	{
		final String S_ProcName = "CFGenKbRamSecForm.readBuffBySecAppIdx() ";
		CFGenKbSecFormBuff buff;
		ArrayList<CFGenKbSecFormBuff> filteredList = new ArrayList<CFGenKbSecFormBuff>();
		CFGenKbSecFormBuff[] buffList = readDerivedBySecAppIdx( Authorization,
			ClusterId,
			SecAppId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SFRM" ) ) {
				filteredList.add( (CFGenKbSecFormBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecFormBuff[0] ) );
	}

	public CFGenKbSecFormBuff readBuffByUJEEServletIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecAppId,
		String JEEServletMapName )
	{
		final String S_ProcName = "CFGenKbRamSecForm.readBuffByUJEEServletIdx() ";
		CFGenKbSecFormBuff buff = readDerivedByUJEEServletIdx( Authorization,
			ClusterId,
			SecAppId,
			JEEServletMapName );
		if( ( buff != null ) && buff.getClassCode().equals( "SFRM" ) ) {
			return( (CFGenKbSecFormBuff)buff );
		}
		else {
			return( null );
		}
	}

	/**
	 *	Read a page array of the specific SecForm buffer instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecForm key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecFormBuff[] pageBuffByClusterIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		Long priorClusterId,
		Integer priorSecFormId )
	{
		final String S_ProcName = "pageBuffByClusterIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecForm buffer instances identified by the duplicate key SecAppIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecAppId	The SecForm key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecFormBuff[] pageBuffBySecAppIdx( CFGenKbAuthorization Authorization,
		long ClusterId,
		int SecAppId,
		Long priorClusterId,
		Integer priorSecFormId )
	{
		final String S_ProcName = "pageBuffBySecAppIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateSecForm( CFGenKbAuthorization Authorization,
		CFGenKbSecFormBuff Buff )
	{
		CFGenKbSecFormPKey pkey = schema.getFactorySecForm().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecFormId( Buff.getRequiredSecFormId() );
		CFGenKbSecFormBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateSecForm",
				"Existing record not found",
				"SecForm",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateSecForm",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbSecFormByClusterIdxKey existingKeyClusterIdx = schema.getFactorySecForm().newClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFGenKbSecFormByClusterIdxKey newKeyClusterIdx = schema.getFactorySecForm().newClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		CFGenKbSecFormBySecAppIdxKey existingKeySecAppIdx = schema.getFactorySecForm().newSecAppIdxKey();
		existingKeySecAppIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeySecAppIdx.setRequiredSecAppId( existing.getRequiredSecAppId() );

		CFGenKbSecFormBySecAppIdxKey newKeySecAppIdx = schema.getFactorySecForm().newSecAppIdxKey();
		newKeySecAppIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeySecAppIdx.setRequiredSecAppId( Buff.getRequiredSecAppId() );

		CFGenKbSecFormByUJEEServletIdxKey existingKeyUJEEServletIdx = schema.getFactorySecForm().newUJEEServletIdxKey();
		existingKeyUJEEServletIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUJEEServletIdx.setRequiredSecAppId( existing.getRequiredSecAppId() );
		existingKeyUJEEServletIdx.setRequiredJEEServletMapName( existing.getRequiredJEEServletMapName() );

		CFGenKbSecFormByUJEEServletIdxKey newKeyUJEEServletIdx = schema.getFactorySecForm().newUJEEServletIdxKey();
		newKeyUJEEServletIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUJEEServletIdx.setRequiredSecAppId( Buff.getRequiredSecAppId() );
		newKeyUJEEServletIdx.setRequiredJEEServletMapName( Buff.getRequiredJEEServletMapName() );

		// Check unique indexes

		if( ! existingKeyUJEEServletIdx.equals( newKeyUJEEServletIdx ) ) {
			if( dictByUJEEServletIdx.containsKey( newKeyUJEEServletIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateSecForm",
					"SecFormUJEEServletIdx",
					newKeyUJEEServletIdx );
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
						"updateSecForm",
						"Owner",
						"SecFormCluster",
						"Cluster",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecApp().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId(),
						Buff.getRequiredSecAppId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateSecForm",
						"Container",
						"SecFormApplication",
						"SecApp",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbSecFormPKey, CFGenKbSecFormBuff > subdict;

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
			subdict = new HashMap< CFGenKbSecFormPKey, CFGenKbSecFormBuff >();
			dictByClusterIdx.put( newKeyClusterIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictBySecAppIdx.get( existingKeySecAppIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySecAppIdx.containsKey( newKeySecAppIdx ) ) {
			subdict = dictBySecAppIdx.get( newKeySecAppIdx );
		}
		else {
			subdict = new HashMap< CFGenKbSecFormPKey, CFGenKbSecFormBuff >();
			dictBySecAppIdx.put( newKeySecAppIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUJEEServletIdx.remove( existingKeyUJEEServletIdx );
		dictByUJEEServletIdx.put( newKeyUJEEServletIdx, Buff );

	}

	public void deleteSecForm( CFGenKbAuthorization Authorization,
		CFGenKbSecFormBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamSecFormTable.deleteSecForm() ";
		String classCode;
		CFGenKbSecFormPKey pkey = schema.getFactorySecForm().newPKey();
		pkey.setRequiredClusterId( Buff.getRequiredClusterId() );
		pkey.setRequiredSecFormId( Buff.getRequiredSecFormId() );
		CFGenKbSecFormBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteSecForm",
				pkey );
		}
		CFGenKbSecFormByClusterIdxKey keyClusterIdx = schema.getFactorySecForm().newClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		CFGenKbSecFormBySecAppIdxKey keySecAppIdx = schema.getFactorySecForm().newSecAppIdxKey();
		keySecAppIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keySecAppIdx.setRequiredSecAppId( existing.getRequiredSecAppId() );

		CFGenKbSecFormByUJEEServletIdxKey keyUJEEServletIdx = schema.getFactorySecForm().newUJEEServletIdxKey();
		keyUJEEServletIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUJEEServletIdx.setRequiredSecAppId( existing.getRequiredSecAppId() );
		keyUJEEServletIdx.setRequiredJEEServletMapName( existing.getRequiredJEEServletMapName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbSecFormPKey, CFGenKbSecFormBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		subdict = dictBySecAppIdx.get( keySecAppIdx );
		subdict.remove( pkey );

		dictByUJEEServletIdx.remove( keyUJEEServletIdx );

	}
	public void deleteSecFormByIdIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		int argSecFormId )
	{
		CFGenKbSecFormPKey key = schema.getFactorySecForm().newPKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecFormId( argSecFormId );
		deleteSecFormByIdIdx( Authorization, key );
	}

	public void deleteSecFormByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecFormPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbSecFormBuff cur;
		LinkedList<CFGenKbSecFormBuff> matchSet = new LinkedList<CFGenKbSecFormBuff>();
		Iterator<CFGenKbSecFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecForm().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecFormId() );
			deleteSecForm( Authorization, cur );
		}
	}

	public void deleteSecFormByClusterIdx( CFGenKbAuthorization Authorization,
		long argClusterId )
	{
		CFGenKbSecFormByClusterIdxKey key = schema.getFactorySecForm().newClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteSecFormByClusterIdx( Authorization, key );
	}

	public void deleteSecFormByClusterIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecFormByClusterIdxKey argKey )
	{
		CFGenKbSecFormBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecFormBuff> matchSet = new LinkedList<CFGenKbSecFormBuff>();
		Iterator<CFGenKbSecFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecForm().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecFormId() );
			deleteSecForm( Authorization, cur );
		}
	}

	public void deleteSecFormBySecAppIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		int argSecAppId )
	{
		CFGenKbSecFormBySecAppIdxKey key = schema.getFactorySecForm().newSecAppIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecAppId( argSecAppId );
		deleteSecFormBySecAppIdx( Authorization, key );
	}

	public void deleteSecFormBySecAppIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecFormBySecAppIdxKey argKey )
	{
		CFGenKbSecFormBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecFormBuff> matchSet = new LinkedList<CFGenKbSecFormBuff>();
		Iterator<CFGenKbSecFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecForm().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecFormId() );
			deleteSecForm( Authorization, cur );
		}
	}

	public void deleteSecFormByUJEEServletIdx( CFGenKbAuthorization Authorization,
		long argClusterId,
		int argSecAppId,
		String argJEEServletMapName )
	{
		CFGenKbSecFormByUJEEServletIdxKey key = schema.getFactorySecForm().newUJEEServletIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredSecAppId( argSecAppId );
		key.setRequiredJEEServletMapName( argJEEServletMapName );
		deleteSecFormByUJEEServletIdx( Authorization, key );
	}

	public void deleteSecFormByUJEEServletIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecFormByUJEEServletIdxKey argKey )
	{
		CFGenKbSecFormBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecFormBuff> matchSet = new LinkedList<CFGenKbSecFormBuff>();
		Iterator<CFGenKbSecFormBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecFormBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecForm().readDerivedByIdIdx( Authorization,
				cur.getRequiredClusterId(),
				cur.getRequiredSecFormId() );
			deleteSecForm( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
