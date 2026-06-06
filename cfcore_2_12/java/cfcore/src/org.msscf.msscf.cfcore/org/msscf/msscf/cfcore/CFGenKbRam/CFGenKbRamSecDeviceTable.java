
// Description: Java 11 in-memory RAM DbIO implementation for SecDevice.

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
 *	CFGenKbRamSecDeviceTable in-memory RAM DbIO implementation
 *	for SecDevice.
 */
public class CFGenKbRamSecDeviceTable
	implements ICFGenKbSecDeviceTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbSecDevicePKey,
				CFGenKbSecDeviceBuff > dictByPKey
		= new HashMap< CFGenKbSecDevicePKey,
				CFGenKbSecDeviceBuff >();
	private Map< CFGenKbSecDeviceByNameIdxKey,
			CFGenKbSecDeviceBuff > dictByNameIdx
		= new HashMap< CFGenKbSecDeviceByNameIdxKey,
			CFGenKbSecDeviceBuff >();
	private Map< CFGenKbSecDeviceByUserIdxKey,
				Map< CFGenKbSecDevicePKey,
					CFGenKbSecDeviceBuff >> dictByUserIdx
		= new HashMap< CFGenKbSecDeviceByUserIdxKey,
				Map< CFGenKbSecDevicePKey,
					CFGenKbSecDeviceBuff >>();

	public CFGenKbRamSecDeviceTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecDevice( CFGenKbAuthorization Authorization,
		CFGenKbSecDeviceBuff Buff )
	{
		final String S_ProcName = "createSecDevice";
		CFGenKbSecDevicePKey pkey = schema.getFactorySecDevice().newPKey();
		pkey.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		pkey.setRequiredDevName( Buff.getRequiredDevName() );
		Buff.setRequiredSecUserId( pkey.getRequiredSecUserId() );
		Buff.setRequiredDevName( pkey.getRequiredDevName() );
		CFGenKbSecDeviceByNameIdxKey keyNameIdx = schema.getFactorySecDevice().newNameIdxKey();
		keyNameIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		keyNameIdx.setRequiredDevName( Buff.getRequiredDevName() );

		CFGenKbSecDeviceByUserIdxKey keyUserIdx = schema.getFactorySecDevice().newUserIdxKey();
		keyUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecDeviceNameIdx",
				keyNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableSecUser().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecUserId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"SecDeviceSecUser",
						"SecUser",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

		Map< CFGenKbSecDevicePKey, CFGenKbSecDeviceBuff > subdictUserIdx;
		if( dictByUserIdx.containsKey( keyUserIdx ) ) {
			subdictUserIdx = dictByUserIdx.get( keyUserIdx );
		}
		else {
			subdictUserIdx = new HashMap< CFGenKbSecDevicePKey, CFGenKbSecDeviceBuff >();
			dictByUserIdx.put( keyUserIdx, subdictUserIdx );
		}
		subdictUserIdx.put( pkey, Buff );

	}

	public CFGenKbSecDeviceBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbSecDevicePKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecDevice.readDerived";
		CFGenKbSecDevicePKey key = schema.getFactorySecDevice().newPKey();
		key.setRequiredSecUserId( PKey.getRequiredSecUserId() );
		key.setRequiredDevName( PKey.getRequiredDevName() );
		CFGenKbSecDeviceBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecDeviceBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbSecDevicePKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecDevice.readDerived";
		CFGenKbSecDevicePKey key = schema.getFactorySecDevice().newPKey();
		key.setRequiredSecUserId( PKey.getRequiredSecUserId() );
		key.setRequiredDevName( PKey.getRequiredDevName() );
		CFGenKbSecDeviceBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecDeviceBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamSecDevice.readAllDerived";
		CFGenKbSecDeviceBuff[] retList = new CFGenKbSecDeviceBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbSecDeviceBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbSecDeviceBuff readDerivedByNameIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId,
		String DevName )
	{
		final String S_ProcName = "CFGenKbRamSecDevice.readDerivedByNameIdx";
		CFGenKbSecDeviceByNameIdxKey key = schema.getFactorySecDevice().newNameIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredDevName( DevName );

		CFGenKbSecDeviceBuff buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecDeviceBuff[] readDerivedByUserIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFGenKbRamSecDevice.readDerivedByUserIdx";
		CFGenKbSecDeviceByUserIdxKey key = schema.getFactorySecDevice().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );

		CFGenKbSecDeviceBuff[] recArray;
		if( dictByUserIdx.containsKey( key ) ) {
			Map< CFGenKbSecDevicePKey, CFGenKbSecDeviceBuff > subdictUserIdx
				= dictByUserIdx.get( key );
			recArray = new CFGenKbSecDeviceBuff[ subdictUserIdx.size() ];
			Iterator< CFGenKbSecDeviceBuff > iter = subdictUserIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecDevicePKey, CFGenKbSecDeviceBuff > subdictUserIdx
				= new HashMap< CFGenKbSecDevicePKey, CFGenKbSecDeviceBuff >();
			dictByUserIdx.put( key, subdictUserIdx );
			recArray = new CFGenKbSecDeviceBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecDeviceBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId,
		String DevName )
	{
		final String S_ProcName = "CFGenKbRamSecDevice.readDerivedByIdIdx() ";
		CFGenKbSecDevicePKey key = schema.getFactorySecDevice().newPKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredDevName( DevName );

		CFGenKbSecDeviceBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecDeviceBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbSecDevicePKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecDevice.readBuff";
		CFGenKbSecDeviceBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SDEV" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecDeviceBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbSecDevicePKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbSecDeviceBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SDEV" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecDeviceBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamSecDevice.readAllBuff";
		CFGenKbSecDeviceBuff buff;
		ArrayList<CFGenKbSecDeviceBuff> filteredList = new ArrayList<CFGenKbSecDeviceBuff>();
		CFGenKbSecDeviceBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SDEV" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecDeviceBuff[0] ) );
	}

	/**
	 *	Read a page of all the specific SecDevice buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecDevice instances in the database accessible for the Authorization.
	 */
	public CFGenKbSecDeviceBuff[] pageAllBuff( CFGenKbAuthorization Authorization,
		UUID priorSecUserId,
		String priorDevName )
	{
		final String S_ProcName = "pageAllBuff";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public CFGenKbSecDeviceBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId,
		String DevName )
	{
		final String S_ProcName = "CFGenKbRamSecDevice.readBuffByIdIdx() ";
		CFGenKbSecDeviceBuff buff = readDerivedByIdIdx( Authorization,
			SecUserId,
			DevName );
		if( ( buff != null ) && buff.getClassCode().equals( "SDEV" ) ) {
			return( (CFGenKbSecDeviceBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbSecDeviceBuff readBuffByNameIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId,
		String DevName )
	{
		final String S_ProcName = "CFGenKbRamSecDevice.readBuffByNameIdx() ";
		CFGenKbSecDeviceBuff buff = readDerivedByNameIdx( Authorization,
			SecUserId,
			DevName );
		if( ( buff != null ) && buff.getClassCode().equals( "SDEV" ) ) {
			return( (CFGenKbSecDeviceBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbSecDeviceBuff[] readBuffByUserIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFGenKbRamSecDevice.readBuffByUserIdx() ";
		CFGenKbSecDeviceBuff buff;
		ArrayList<CFGenKbSecDeviceBuff> filteredList = new ArrayList<CFGenKbSecDeviceBuff>();
		CFGenKbSecDeviceBuff[] buffList = readDerivedByUserIdx( Authorization,
			SecUserId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SDEV" ) ) {
				filteredList.add( (CFGenKbSecDeviceBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecDeviceBuff[0] ) );
	}

	/**
	 *	Read a page array of the specific SecDevice buffer instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecDeviceBuff[] pageBuffByUserIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId,
		UUID priorSecUserId,
		String priorDevName )
	{
		final String S_ProcName = "pageBuffByUserIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateSecDevice( CFGenKbAuthorization Authorization,
		CFGenKbSecDeviceBuff Buff )
	{
		CFGenKbSecDevicePKey pkey = schema.getFactorySecDevice().newPKey();
		pkey.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		pkey.setRequiredDevName( Buff.getRequiredDevName() );
		CFGenKbSecDeviceBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateSecDevice",
				"Existing record not found",
				"SecDevice",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateSecDevice",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbSecDeviceByNameIdxKey existingKeyNameIdx = schema.getFactorySecDevice().newNameIdxKey();
		existingKeyNameIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		existingKeyNameIdx.setRequiredDevName( existing.getRequiredDevName() );

		CFGenKbSecDeviceByNameIdxKey newKeyNameIdx = schema.getFactorySecDevice().newNameIdxKey();
		newKeyNameIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		newKeyNameIdx.setRequiredDevName( Buff.getRequiredDevName() );

		CFGenKbSecDeviceByUserIdxKey existingKeyUserIdx = schema.getFactorySecDevice().newUserIdxKey();
		existingKeyUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		CFGenKbSecDeviceByUserIdxKey newKeyUserIdx = schema.getFactorySecDevice().newUserIdxKey();
		newKeyUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		// Check unique indexes

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateSecDevice",
					"SecDeviceNameIdx",
					newKeyNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecUser().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecUserId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateSecDevice",
						"Container",
						"SecDeviceSecUser",
						"SecUser",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbSecDevicePKey, CFGenKbSecDeviceBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

		subdict = dictByUserIdx.get( existingKeyUserIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByUserIdx.containsKey( newKeyUserIdx ) ) {
			subdict = dictByUserIdx.get( newKeyUserIdx );
		}
		else {
			subdict = new HashMap< CFGenKbSecDevicePKey, CFGenKbSecDeviceBuff >();
			dictByUserIdx.put( newKeyUserIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteSecDevice( CFGenKbAuthorization Authorization,
		CFGenKbSecDeviceBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamSecDeviceTable.deleteSecDevice() ";
		String classCode;
		CFGenKbSecDevicePKey pkey = schema.getFactorySecDevice().newPKey();
		pkey.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		pkey.setRequiredDevName( Buff.getRequiredDevName() );
		CFGenKbSecDeviceBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteSecDevice",
				pkey );
		}
		CFGenKbSecDeviceByNameIdxKey keyNameIdx = schema.getFactorySecDevice().newNameIdxKey();
		keyNameIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		keyNameIdx.setRequiredDevName( existing.getRequiredDevName() );

		CFGenKbSecDeviceByUserIdxKey keyUserIdx = schema.getFactorySecDevice().newUserIdxKey();
		keyUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbSecDevicePKey, CFGenKbSecDeviceBuff > subdict;

		dictByPKey.remove( pkey );

		dictByNameIdx.remove( keyNameIdx );

		subdict = dictByUserIdx.get( keyUserIdx );
		subdict.remove( pkey );

	}
	public void deleteSecDeviceByIdIdx( CFGenKbAuthorization Authorization,
		UUID argSecUserId,
		String argDevName )
	{
		CFGenKbSecDevicePKey key = schema.getFactorySecDevice().newPKey();
		key.setRequiredSecUserId( argSecUserId );
		key.setRequiredDevName( argDevName );
		deleteSecDeviceByIdIdx( Authorization, key );
	}

	public void deleteSecDeviceByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecDevicePKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbSecDeviceBuff cur;
		LinkedList<CFGenKbSecDeviceBuff> matchSet = new LinkedList<CFGenKbSecDeviceBuff>();
		Iterator<CFGenKbSecDeviceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecDeviceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecDevice().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId(),
				cur.getRequiredDevName() );
			deleteSecDevice( Authorization, cur );
		}
	}

	public void deleteSecDeviceByNameIdx( CFGenKbAuthorization Authorization,
		UUID argSecUserId,
		String argDevName )
	{
		CFGenKbSecDeviceByNameIdxKey key = schema.getFactorySecDevice().newNameIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		key.setRequiredDevName( argDevName );
		deleteSecDeviceByNameIdx( Authorization, key );
	}

	public void deleteSecDeviceByNameIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecDeviceByNameIdxKey argKey )
	{
		CFGenKbSecDeviceBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecDeviceBuff> matchSet = new LinkedList<CFGenKbSecDeviceBuff>();
		Iterator<CFGenKbSecDeviceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecDeviceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecDevice().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId(),
				cur.getRequiredDevName() );
			deleteSecDevice( Authorization, cur );
		}
	}

	public void deleteSecDeviceByUserIdx( CFGenKbAuthorization Authorization,
		UUID argSecUserId )
	{
		CFGenKbSecDeviceByUserIdxKey key = schema.getFactorySecDevice().newUserIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		deleteSecDeviceByUserIdx( Authorization, key );
	}

	public void deleteSecDeviceByUserIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecDeviceByUserIdxKey argKey )
	{
		CFGenKbSecDeviceBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecDeviceBuff> matchSet = new LinkedList<CFGenKbSecDeviceBuff>();
		Iterator<CFGenKbSecDeviceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecDeviceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecDevice().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId(),
				cur.getRequiredDevName() );
			deleteSecDevice( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
