
// Description: Java 11 in-memory RAM DbIO implementation for SecUser.

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
 *	CFGenKbRamSecUserTable in-memory RAM DbIO implementation
 *	for SecUser.
 */
public class CFGenKbRamSecUserTable
	implements ICFGenKbSecUserTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbSecUserPKey,
				CFGenKbSecUserBuff > dictByPKey
		= new HashMap< CFGenKbSecUserPKey,
				CFGenKbSecUserBuff >();
	private Map< CFGenKbSecUserByULoginIdxKey,
			CFGenKbSecUserBuff > dictByULoginIdx
		= new HashMap< CFGenKbSecUserByULoginIdxKey,
			CFGenKbSecUserBuff >();
	private Map< CFGenKbSecUserByEMConfIdxKey,
				Map< CFGenKbSecUserPKey,
					CFGenKbSecUserBuff >> dictByEMConfIdx
		= new HashMap< CFGenKbSecUserByEMConfIdxKey,
				Map< CFGenKbSecUserPKey,
					CFGenKbSecUserBuff >>();
	private Map< CFGenKbSecUserByPwdResetIdxKey,
				Map< CFGenKbSecUserPKey,
					CFGenKbSecUserBuff >> dictByPwdResetIdx
		= new HashMap< CFGenKbSecUserByPwdResetIdxKey,
				Map< CFGenKbSecUserPKey,
					CFGenKbSecUserBuff >>();
	private Map< CFGenKbSecUserByDefDevIdxKey,
				Map< CFGenKbSecUserPKey,
					CFGenKbSecUserBuff >> dictByDefDevIdx
		= new HashMap< CFGenKbSecUserByDefDevIdxKey,
				Map< CFGenKbSecUserPKey,
					CFGenKbSecUserBuff >>();

	public CFGenKbRamSecUserTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecUser( CFGenKbAuthorization Authorization,
		CFGenKbSecUserBuff Buff )
	{
		final String S_ProcName = "createSecUser";
		CFGenKbSecUserPKey pkey = schema.getFactorySecUser().newPKey();
		pkey.setRequiredSecUserId( schema.nextSecUserIdGen() );
		Buff.setRequiredSecUserId( pkey.getRequiredSecUserId() );
		CFGenKbSecUserByULoginIdxKey keyULoginIdx = schema.getFactorySecUser().newULoginIdxKey();
		keyULoginIdx.setRequiredLoginId( Buff.getRequiredLoginId() );

		CFGenKbSecUserByEMConfIdxKey keyEMConfIdx = schema.getFactorySecUser().newEMConfIdxKey();
		keyEMConfIdx.setOptionalEMailConfirmUuid( Buff.getOptionalEMailConfirmUuid() );

		CFGenKbSecUserByPwdResetIdxKey keyPwdResetIdx = schema.getFactorySecUser().newPwdResetIdxKey();
		keyPwdResetIdx.setOptionalPasswordResetUuid( Buff.getOptionalPasswordResetUuid() );

		CFGenKbSecUserByDefDevIdxKey keyDefDevIdx = schema.getFactorySecUser().newDefDevIdxKey();
		keyDefDevIdx.setOptionalDfltDevUserId( Buff.getOptionalDfltDevUserId() );
		keyDefDevIdx.setOptionalDfltDevName( Buff.getOptionalDfltDevName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByULoginIdx.containsKey( keyULoginIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecUserLoginIdx",
				keyULoginIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByULoginIdx.put( keyULoginIdx, Buff );

		Map< CFGenKbSecUserPKey, CFGenKbSecUserBuff > subdictEMConfIdx;
		if( dictByEMConfIdx.containsKey( keyEMConfIdx ) ) {
			subdictEMConfIdx = dictByEMConfIdx.get( keyEMConfIdx );
		}
		else {
			subdictEMConfIdx = new HashMap< CFGenKbSecUserPKey, CFGenKbSecUserBuff >();
			dictByEMConfIdx.put( keyEMConfIdx, subdictEMConfIdx );
		}
		subdictEMConfIdx.put( pkey, Buff );

		Map< CFGenKbSecUserPKey, CFGenKbSecUserBuff > subdictPwdResetIdx;
		if( dictByPwdResetIdx.containsKey( keyPwdResetIdx ) ) {
			subdictPwdResetIdx = dictByPwdResetIdx.get( keyPwdResetIdx );
		}
		else {
			subdictPwdResetIdx = new HashMap< CFGenKbSecUserPKey, CFGenKbSecUserBuff >();
			dictByPwdResetIdx.put( keyPwdResetIdx, subdictPwdResetIdx );
		}
		subdictPwdResetIdx.put( pkey, Buff );

		Map< CFGenKbSecUserPKey, CFGenKbSecUserBuff > subdictDefDevIdx;
		if( dictByDefDevIdx.containsKey( keyDefDevIdx ) ) {
			subdictDefDevIdx = dictByDefDevIdx.get( keyDefDevIdx );
		}
		else {
			subdictDefDevIdx = new HashMap< CFGenKbSecUserPKey, CFGenKbSecUserBuff >();
			dictByDefDevIdx.put( keyDefDevIdx, subdictDefDevIdx );
		}
		subdictDefDevIdx.put( pkey, Buff );

	}

	public CFGenKbSecUserBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbSecUserPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecUser.readDerived";
		CFGenKbSecUserPKey key = schema.getFactorySecUser().newPKey();
		key.setRequiredSecUserId( PKey.getRequiredSecUserId() );
		CFGenKbSecUserBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecUserBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbSecUserPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecUser.readDerived";
		CFGenKbSecUserPKey key = schema.getFactorySecUser().newPKey();
		key.setRequiredSecUserId( PKey.getRequiredSecUserId() );
		CFGenKbSecUserBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecUserBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamSecUser.readAllDerived";
		CFGenKbSecUserBuff[] retList = new CFGenKbSecUserBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbSecUserBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbSecUserBuff readDerivedByULoginIdx( CFGenKbAuthorization Authorization,
		String LoginId )
	{
		final String S_ProcName = "CFGenKbRamSecUser.readDerivedByULoginIdx";
		CFGenKbSecUserByULoginIdxKey key = schema.getFactorySecUser().newULoginIdxKey();
		key.setRequiredLoginId( LoginId );

		CFGenKbSecUserBuff buff;
		if( dictByULoginIdx.containsKey( key ) ) {
			buff = dictByULoginIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecUserBuff[] readDerivedByEMConfIdx( CFGenKbAuthorization Authorization,
		UUID EMailConfirmUuid )
	{
		final String S_ProcName = "CFGenKbRamSecUser.readDerivedByEMConfIdx";
		CFGenKbSecUserByEMConfIdxKey key = schema.getFactorySecUser().newEMConfIdxKey();
		key.setOptionalEMailConfirmUuid( EMailConfirmUuid );

		CFGenKbSecUserBuff[] recArray;
		if( dictByEMConfIdx.containsKey( key ) ) {
			Map< CFGenKbSecUserPKey, CFGenKbSecUserBuff > subdictEMConfIdx
				= dictByEMConfIdx.get( key );
			recArray = new CFGenKbSecUserBuff[ subdictEMConfIdx.size() ];
			Iterator< CFGenKbSecUserBuff > iter = subdictEMConfIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecUserPKey, CFGenKbSecUserBuff > subdictEMConfIdx
				= new HashMap< CFGenKbSecUserPKey, CFGenKbSecUserBuff >();
			dictByEMConfIdx.put( key, subdictEMConfIdx );
			recArray = new CFGenKbSecUserBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecUserBuff[] readDerivedByPwdResetIdx( CFGenKbAuthorization Authorization,
		UUID PasswordResetUuid )
	{
		final String S_ProcName = "CFGenKbRamSecUser.readDerivedByPwdResetIdx";
		CFGenKbSecUserByPwdResetIdxKey key = schema.getFactorySecUser().newPwdResetIdxKey();
		key.setOptionalPasswordResetUuid( PasswordResetUuid );

		CFGenKbSecUserBuff[] recArray;
		if( dictByPwdResetIdx.containsKey( key ) ) {
			Map< CFGenKbSecUserPKey, CFGenKbSecUserBuff > subdictPwdResetIdx
				= dictByPwdResetIdx.get( key );
			recArray = new CFGenKbSecUserBuff[ subdictPwdResetIdx.size() ];
			Iterator< CFGenKbSecUserBuff > iter = subdictPwdResetIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecUserPKey, CFGenKbSecUserBuff > subdictPwdResetIdx
				= new HashMap< CFGenKbSecUserPKey, CFGenKbSecUserBuff >();
			dictByPwdResetIdx.put( key, subdictPwdResetIdx );
			recArray = new CFGenKbSecUserBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecUserBuff[] readDerivedByDefDevIdx( CFGenKbAuthorization Authorization,
		UUID DfltDevUserId,
		String DfltDevName )
	{
		final String S_ProcName = "CFGenKbRamSecUser.readDerivedByDefDevIdx";
		CFGenKbSecUserByDefDevIdxKey key = schema.getFactorySecUser().newDefDevIdxKey();
		key.setOptionalDfltDevUserId( DfltDevUserId );
		key.setOptionalDfltDevName( DfltDevName );

		CFGenKbSecUserBuff[] recArray;
		if( dictByDefDevIdx.containsKey( key ) ) {
			Map< CFGenKbSecUserPKey, CFGenKbSecUserBuff > subdictDefDevIdx
				= dictByDefDevIdx.get( key );
			recArray = new CFGenKbSecUserBuff[ subdictDefDevIdx.size() ];
			Iterator< CFGenKbSecUserBuff > iter = subdictDefDevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecUserPKey, CFGenKbSecUserBuff > subdictDefDevIdx
				= new HashMap< CFGenKbSecUserPKey, CFGenKbSecUserBuff >();
			dictByDefDevIdx.put( key, subdictDefDevIdx );
			recArray = new CFGenKbSecUserBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecUserBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFGenKbRamSecUser.readDerivedByIdIdx() ";
		CFGenKbSecUserPKey key = schema.getFactorySecUser().newPKey();
		key.setRequiredSecUserId( SecUserId );

		CFGenKbSecUserBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecUserBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbSecUserPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecUser.readBuff";
		CFGenKbSecUserBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SUSR" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecUserBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbSecUserPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbSecUserBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SUSR" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecUserBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamSecUser.readAllBuff";
		CFGenKbSecUserBuff buff;
		ArrayList<CFGenKbSecUserBuff> filteredList = new ArrayList<CFGenKbSecUserBuff>();
		CFGenKbSecUserBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SUSR" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecUserBuff[0] ) );
	}

	/**
	 *	Read a page of all the specific SecUser buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecUser instances in the database accessible for the Authorization.
	 */
	public CFGenKbSecUserBuff[] pageAllBuff( CFGenKbAuthorization Authorization,
		UUID priorSecUserId )
	{
		final String S_ProcName = "pageAllBuff";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public CFGenKbSecUserBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFGenKbRamSecUser.readBuffByIdIdx() ";
		CFGenKbSecUserBuff buff = readDerivedByIdIdx( Authorization,
			SecUserId );
		if( ( buff != null ) && buff.getClassCode().equals( "SUSR" ) ) {
			return( (CFGenKbSecUserBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbSecUserBuff readBuffByULoginIdx( CFGenKbAuthorization Authorization,
		String LoginId )
	{
		final String S_ProcName = "CFGenKbRamSecUser.readBuffByULoginIdx() ";
		CFGenKbSecUserBuff buff = readDerivedByULoginIdx( Authorization,
			LoginId );
		if( ( buff != null ) && buff.getClassCode().equals( "SUSR" ) ) {
			return( (CFGenKbSecUserBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbSecUserBuff[] readBuffByEMConfIdx( CFGenKbAuthorization Authorization,
		UUID EMailConfirmUuid )
	{
		final String S_ProcName = "CFGenKbRamSecUser.readBuffByEMConfIdx() ";
		CFGenKbSecUserBuff buff;
		ArrayList<CFGenKbSecUserBuff> filteredList = new ArrayList<CFGenKbSecUserBuff>();
		CFGenKbSecUserBuff[] buffList = readDerivedByEMConfIdx( Authorization,
			EMailConfirmUuid );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SUSR" ) ) {
				filteredList.add( (CFGenKbSecUserBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecUserBuff[0] ) );
	}

	public CFGenKbSecUserBuff[] readBuffByPwdResetIdx( CFGenKbAuthorization Authorization,
		UUID PasswordResetUuid )
	{
		final String S_ProcName = "CFGenKbRamSecUser.readBuffByPwdResetIdx() ";
		CFGenKbSecUserBuff buff;
		ArrayList<CFGenKbSecUserBuff> filteredList = new ArrayList<CFGenKbSecUserBuff>();
		CFGenKbSecUserBuff[] buffList = readDerivedByPwdResetIdx( Authorization,
			PasswordResetUuid );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SUSR" ) ) {
				filteredList.add( (CFGenKbSecUserBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecUserBuff[0] ) );
	}

	public CFGenKbSecUserBuff[] readBuffByDefDevIdx( CFGenKbAuthorization Authorization,
		UUID DfltDevUserId,
		String DfltDevName )
	{
		final String S_ProcName = "CFGenKbRamSecUser.readBuffByDefDevIdx() ";
		CFGenKbSecUserBuff buff;
		ArrayList<CFGenKbSecUserBuff> filteredList = new ArrayList<CFGenKbSecUserBuff>();
		CFGenKbSecUserBuff[] buffList = readDerivedByDefDevIdx( Authorization,
			DfltDevUserId,
			DfltDevName );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SUSR" ) ) {
				filteredList.add( (CFGenKbSecUserBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecUserBuff[0] ) );
	}

	/**
	 *	Read a page array of the specific SecUser buffer instances identified by the duplicate key EMConfIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEMailConfirmUuid	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecUserBuff[] pageBuffByEMConfIdx( CFGenKbAuthorization Authorization,
		UUID EMailConfirmUuid,
		UUID priorSecUserId )
	{
		final String S_ProcName = "pageBuffByEMConfIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecUser buffer instances identified by the duplicate key PwdResetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPasswordResetUuid	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecUserBuff[] pageBuffByPwdResetIdx( CFGenKbAuthorization Authorization,
		UUID PasswordResetUuid,
		UUID priorSecUserId )
	{
		final String S_ProcName = "pageBuffByPwdResetIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecUser buffer instances identified by the duplicate key DefDevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDfltDevUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@param	argDfltDevName	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecUserBuff[] pageBuffByDefDevIdx( CFGenKbAuthorization Authorization,
		UUID DfltDevUserId,
		String DfltDevName,
		UUID priorSecUserId )
	{
		final String S_ProcName = "pageBuffByDefDevIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateSecUser( CFGenKbAuthorization Authorization,
		CFGenKbSecUserBuff Buff )
	{
		CFGenKbSecUserPKey pkey = schema.getFactorySecUser().newPKey();
		pkey.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		CFGenKbSecUserBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateSecUser",
				"Existing record not found",
				"SecUser",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateSecUser",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbSecUserByULoginIdxKey existingKeyULoginIdx = schema.getFactorySecUser().newULoginIdxKey();
		existingKeyULoginIdx.setRequiredLoginId( existing.getRequiredLoginId() );

		CFGenKbSecUserByULoginIdxKey newKeyULoginIdx = schema.getFactorySecUser().newULoginIdxKey();
		newKeyULoginIdx.setRequiredLoginId( Buff.getRequiredLoginId() );

		CFGenKbSecUserByEMConfIdxKey existingKeyEMConfIdx = schema.getFactorySecUser().newEMConfIdxKey();
		existingKeyEMConfIdx.setOptionalEMailConfirmUuid( existing.getOptionalEMailConfirmUuid() );

		CFGenKbSecUserByEMConfIdxKey newKeyEMConfIdx = schema.getFactorySecUser().newEMConfIdxKey();
		newKeyEMConfIdx.setOptionalEMailConfirmUuid( Buff.getOptionalEMailConfirmUuid() );

		CFGenKbSecUserByPwdResetIdxKey existingKeyPwdResetIdx = schema.getFactorySecUser().newPwdResetIdxKey();
		existingKeyPwdResetIdx.setOptionalPasswordResetUuid( existing.getOptionalPasswordResetUuid() );

		CFGenKbSecUserByPwdResetIdxKey newKeyPwdResetIdx = schema.getFactorySecUser().newPwdResetIdxKey();
		newKeyPwdResetIdx.setOptionalPasswordResetUuid( Buff.getOptionalPasswordResetUuid() );

		CFGenKbSecUserByDefDevIdxKey existingKeyDefDevIdx = schema.getFactorySecUser().newDefDevIdxKey();
		existingKeyDefDevIdx.setOptionalDfltDevUserId( existing.getOptionalDfltDevUserId() );
		existingKeyDefDevIdx.setOptionalDfltDevName( existing.getOptionalDfltDevName() );

		CFGenKbSecUserByDefDevIdxKey newKeyDefDevIdx = schema.getFactorySecUser().newDefDevIdxKey();
		newKeyDefDevIdx.setOptionalDfltDevUserId( Buff.getOptionalDfltDevUserId() );
		newKeyDefDevIdx.setOptionalDfltDevName( Buff.getOptionalDfltDevName() );

		// Check unique indexes

		if( ! existingKeyULoginIdx.equals( newKeyULoginIdx ) ) {
			if( dictByULoginIdx.containsKey( newKeyULoginIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateSecUser",
					"SecUserLoginIdx",
					newKeyULoginIdx );
			}
		}

		// Validate foreign keys

		// Update is valid

		Map< CFGenKbSecUserPKey, CFGenKbSecUserBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByULoginIdx.remove( existingKeyULoginIdx );
		dictByULoginIdx.put( newKeyULoginIdx, Buff );

		subdict = dictByEMConfIdx.get( existingKeyEMConfIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByEMConfIdx.containsKey( newKeyEMConfIdx ) ) {
			subdict = dictByEMConfIdx.get( newKeyEMConfIdx );
		}
		else {
			subdict = new HashMap< CFGenKbSecUserPKey, CFGenKbSecUserBuff >();
			dictByEMConfIdx.put( newKeyEMConfIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByPwdResetIdx.get( existingKeyPwdResetIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByPwdResetIdx.containsKey( newKeyPwdResetIdx ) ) {
			subdict = dictByPwdResetIdx.get( newKeyPwdResetIdx );
		}
		else {
			subdict = new HashMap< CFGenKbSecUserPKey, CFGenKbSecUserBuff >();
			dictByPwdResetIdx.put( newKeyPwdResetIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByDefDevIdx.get( existingKeyDefDevIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByDefDevIdx.containsKey( newKeyDefDevIdx ) ) {
			subdict = dictByDefDevIdx.get( newKeyDefDevIdx );
		}
		else {
			subdict = new HashMap< CFGenKbSecUserPKey, CFGenKbSecUserBuff >();
			dictByDefDevIdx.put( newKeyDefDevIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteSecUser( CFGenKbAuthorization Authorization,
		CFGenKbSecUserBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamSecUserTable.deleteSecUser() ";
		String classCode;
		CFGenKbSecUserPKey pkey = schema.getFactorySecUser().newPKey();
		pkey.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		CFGenKbSecUserBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteSecUser",
				pkey );
		}
					{
						CFGenKbSecUserBuff editBuff = schema.getTableSecUser().readDerivedByIdIdx( Authorization,
						existing.getRequiredSecUserId() );
						editBuff.setOptionalDfltDevUserId( null );
						editBuff.setOptionalDfltDevName( null );
						classCode = editBuff.getClassCode();
						if( classCode.equals( "SUSR" ) ) {
							schema.getTableSecUser().updateSecUser( Authorization, editBuff );
						}
						else {
							new CFLibUnsupportedClassException( getClass(),
								S_ProcName,
								"Unrecognized ClassCode \"" + classCode + "\"" );
						}
					}
		CFGenKbSecUserBuff editSubobj = schema.getTableSecUser().readDerivedByIdIdx( Authorization,
			existing.getRequiredSecUserId() );
			editSubobj.setOptionalDfltDevUserId( null );
			editSubobj.setOptionalDfltDevName( null );
		classCode = editSubobj.getClassCode();
		if( classCode.equals( "SUSR" ) ) {
			schema.getTableSecUser().updateSecUser( Authorization, editSubobj );
		}
		else {
			new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"Unrecognized ClassCode \"" + classCode + "\"" );
		}
		existing = editSubobj;
					schema.getTableTSecGrpMemb().deleteTSecGrpMembByUserIdx( Authorization,
						existing.getRequiredSecUserId() );
					schema.getTableSecGrpMemb().deleteSecGrpMembByUserIdx( Authorization,
						existing.getRequiredSecUserId() );
					schema.getTableSecSession().deleteSecSessionBySecUserIdx( Authorization,
						existing.getRequiredSecUserId() );
					schema.getTableSecSession().deleteSecSessionBySecProxyIdx( Authorization,
						existing.getRequiredSecUserId() );
					schema.getTableSecDevice().deleteSecDeviceByUserIdx( Authorization,
						existing.getRequiredSecUserId() );
		CFGenKbSecUserByULoginIdxKey keyULoginIdx = schema.getFactorySecUser().newULoginIdxKey();
		keyULoginIdx.setRequiredLoginId( existing.getRequiredLoginId() );

		CFGenKbSecUserByEMConfIdxKey keyEMConfIdx = schema.getFactorySecUser().newEMConfIdxKey();
		keyEMConfIdx.setOptionalEMailConfirmUuid( existing.getOptionalEMailConfirmUuid() );

		CFGenKbSecUserByPwdResetIdxKey keyPwdResetIdx = schema.getFactorySecUser().newPwdResetIdxKey();
		keyPwdResetIdx.setOptionalPasswordResetUuid( existing.getOptionalPasswordResetUuid() );

		CFGenKbSecUserByDefDevIdxKey keyDefDevIdx = schema.getFactorySecUser().newDefDevIdxKey();
		keyDefDevIdx.setOptionalDfltDevUserId( existing.getOptionalDfltDevUserId() );
		keyDefDevIdx.setOptionalDfltDevName( existing.getOptionalDfltDevName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbSecUserPKey, CFGenKbSecUserBuff > subdict;

		dictByPKey.remove( pkey );

		dictByULoginIdx.remove( keyULoginIdx );

		subdict = dictByEMConfIdx.get( keyEMConfIdx );
		subdict.remove( pkey );

		subdict = dictByPwdResetIdx.get( keyPwdResetIdx );
		subdict.remove( pkey );

		subdict = dictByDefDevIdx.get( keyDefDevIdx );
		subdict.remove( pkey );

	}
	public void deleteSecUserByIdIdx( CFGenKbAuthorization Authorization,
		UUID argSecUserId )
	{
		CFGenKbSecUserPKey key = schema.getFactorySecUser().newPKey();
		key.setRequiredSecUserId( argSecUserId );
		deleteSecUserByIdIdx( Authorization, key );
	}

	public void deleteSecUserByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecUserPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbSecUserBuff cur;
		LinkedList<CFGenKbSecUserBuff> matchSet = new LinkedList<CFGenKbSecUserBuff>();
		Iterator<CFGenKbSecUserBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecUserBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecUser().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() );
			deleteSecUser( Authorization, cur );
		}
	}

	public void deleteSecUserByULoginIdx( CFGenKbAuthorization Authorization,
		String argLoginId )
	{
		CFGenKbSecUserByULoginIdxKey key = schema.getFactorySecUser().newULoginIdxKey();
		key.setRequiredLoginId( argLoginId );
		deleteSecUserByULoginIdx( Authorization, key );
	}

	public void deleteSecUserByULoginIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecUserByULoginIdxKey argKey )
	{
		CFGenKbSecUserBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecUserBuff> matchSet = new LinkedList<CFGenKbSecUserBuff>();
		Iterator<CFGenKbSecUserBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecUserBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecUser().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() );
			deleteSecUser( Authorization, cur );
		}
	}

	public void deleteSecUserByEMConfIdx( CFGenKbAuthorization Authorization,
		UUID argEMailConfirmUuid )
	{
		CFGenKbSecUserByEMConfIdxKey key = schema.getFactorySecUser().newEMConfIdxKey();
		key.setOptionalEMailConfirmUuid( argEMailConfirmUuid );
		deleteSecUserByEMConfIdx( Authorization, key );
	}

	public void deleteSecUserByEMConfIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecUserByEMConfIdxKey argKey )
	{
		CFGenKbSecUserBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalEMailConfirmUuid() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecUserBuff> matchSet = new LinkedList<CFGenKbSecUserBuff>();
		Iterator<CFGenKbSecUserBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecUserBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecUser().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() );
			deleteSecUser( Authorization, cur );
		}
	}

	public void deleteSecUserByPwdResetIdx( CFGenKbAuthorization Authorization,
		UUID argPasswordResetUuid )
	{
		CFGenKbSecUserByPwdResetIdxKey key = schema.getFactorySecUser().newPwdResetIdxKey();
		key.setOptionalPasswordResetUuid( argPasswordResetUuid );
		deleteSecUserByPwdResetIdx( Authorization, key );
	}

	public void deleteSecUserByPwdResetIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecUserByPwdResetIdxKey argKey )
	{
		CFGenKbSecUserBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalPasswordResetUuid() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecUserBuff> matchSet = new LinkedList<CFGenKbSecUserBuff>();
		Iterator<CFGenKbSecUserBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecUserBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecUser().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() );
			deleteSecUser( Authorization, cur );
		}
	}

	public void deleteSecUserByDefDevIdx( CFGenKbAuthorization Authorization,
		UUID argDfltDevUserId,
		String argDfltDevName )
	{
		CFGenKbSecUserByDefDevIdxKey key = schema.getFactorySecUser().newDefDevIdxKey();
		key.setOptionalDfltDevUserId( argDfltDevUserId );
		key.setOptionalDfltDevName( argDfltDevName );
		deleteSecUserByDefDevIdx( Authorization, key );
	}

	public void deleteSecUserByDefDevIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecUserByDefDevIdxKey argKey )
	{
		CFGenKbSecUserBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDfltDevUserId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalDfltDevName() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecUserBuff> matchSet = new LinkedList<CFGenKbSecUserBuff>();
		Iterator<CFGenKbSecUserBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecUserBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecUser().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() );
			deleteSecUser( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
