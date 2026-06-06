
// Description: Java 11 in-memory RAM DbIO implementation for SecSession.

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
 *	CFGenKbRamSecSessionTable in-memory RAM DbIO implementation
 *	for SecSession.
 */
public class CFGenKbRamSecSessionTable
	implements ICFGenKbSecSessionTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbSecSessionPKey,
				CFGenKbSecSessionBuff > dictByPKey
		= new HashMap< CFGenKbSecSessionPKey,
				CFGenKbSecSessionBuff >();
	private Map< CFGenKbSecSessionBySecUserIdxKey,
				Map< CFGenKbSecSessionPKey,
					CFGenKbSecSessionBuff >> dictBySecUserIdx
		= new HashMap< CFGenKbSecSessionBySecUserIdxKey,
				Map< CFGenKbSecSessionPKey,
					CFGenKbSecSessionBuff >>();
	private Map< CFGenKbSecSessionBySecDevIdxKey,
				Map< CFGenKbSecSessionPKey,
					CFGenKbSecSessionBuff >> dictBySecDevIdx
		= new HashMap< CFGenKbSecSessionBySecDevIdxKey,
				Map< CFGenKbSecSessionPKey,
					CFGenKbSecSessionBuff >>();
	private Map< CFGenKbSecSessionByStartIdxKey,
			CFGenKbSecSessionBuff > dictByStartIdx
		= new HashMap< CFGenKbSecSessionByStartIdxKey,
			CFGenKbSecSessionBuff >();
	private Map< CFGenKbSecSessionByFinishIdxKey,
				Map< CFGenKbSecSessionPKey,
					CFGenKbSecSessionBuff >> dictByFinishIdx
		= new HashMap< CFGenKbSecSessionByFinishIdxKey,
				Map< CFGenKbSecSessionPKey,
					CFGenKbSecSessionBuff >>();
	private Map< CFGenKbSecSessionBySecProxyIdxKey,
				Map< CFGenKbSecSessionPKey,
					CFGenKbSecSessionBuff >> dictBySecProxyIdx
		= new HashMap< CFGenKbSecSessionBySecProxyIdxKey,
				Map< CFGenKbSecSessionPKey,
					CFGenKbSecSessionBuff >>();

	public CFGenKbRamSecSessionTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecSession( CFGenKbAuthorization Authorization,
		CFGenKbSecSessionBuff Buff )
	{
		final String S_ProcName = "createSecSession";
		CFGenKbSecSessionPKey pkey = schema.getFactorySecSession().newPKey();
		pkey.setRequiredSecSessionId( schema.nextSecSessionIdGen() );
		Buff.setRequiredSecSessionId( pkey.getRequiredSecSessionId() );
		CFGenKbSecSessionBySecUserIdxKey keySecUserIdx = schema.getFactorySecSession().newSecUserIdxKey();
		keySecUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		CFGenKbSecSessionBySecDevIdxKey keySecDevIdx = schema.getFactorySecSession().newSecDevIdxKey();
		keySecDevIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		keySecDevIdx.setOptionalSecDevName( Buff.getOptionalSecDevName() );

		CFGenKbSecSessionByStartIdxKey keyStartIdx = schema.getFactorySecSession().newStartIdxKey();
		keyStartIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		keyStartIdx.setRequiredStart( Buff.getRequiredStart() );

		CFGenKbSecSessionByFinishIdxKey keyFinishIdx = schema.getFactorySecSession().newFinishIdxKey();
		keyFinishIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		keyFinishIdx.setOptionalFinish( Buff.getOptionalFinish() );

		CFGenKbSecSessionBySecProxyIdxKey keySecProxyIdx = schema.getFactorySecSession().newSecProxyIdxKey();
		keySecProxyIdx.setOptionalSecProxyId( Buff.getOptionalSecProxyId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByStartIdx.containsKey( keyStartIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SessionStartIdx",
				keyStartIdx );
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
						"SecSessionUser",
						"SecUser",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff > subdictSecUserIdx;
		if( dictBySecUserIdx.containsKey( keySecUserIdx ) ) {
			subdictSecUserIdx = dictBySecUserIdx.get( keySecUserIdx );
		}
		else {
			subdictSecUserIdx = new HashMap< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff >();
			dictBySecUserIdx.put( keySecUserIdx, subdictSecUserIdx );
		}
		subdictSecUserIdx.put( pkey, Buff );

		Map< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff > subdictSecDevIdx;
		if( dictBySecDevIdx.containsKey( keySecDevIdx ) ) {
			subdictSecDevIdx = dictBySecDevIdx.get( keySecDevIdx );
		}
		else {
			subdictSecDevIdx = new HashMap< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff >();
			dictBySecDevIdx.put( keySecDevIdx, subdictSecDevIdx );
		}
		subdictSecDevIdx.put( pkey, Buff );

		dictByStartIdx.put( keyStartIdx, Buff );

		Map< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff > subdictFinishIdx;
		if( dictByFinishIdx.containsKey( keyFinishIdx ) ) {
			subdictFinishIdx = dictByFinishIdx.get( keyFinishIdx );
		}
		else {
			subdictFinishIdx = new HashMap< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff >();
			dictByFinishIdx.put( keyFinishIdx, subdictFinishIdx );
		}
		subdictFinishIdx.put( pkey, Buff );

		Map< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff > subdictSecProxyIdx;
		if( dictBySecProxyIdx.containsKey( keySecProxyIdx ) ) {
			subdictSecProxyIdx = dictBySecProxyIdx.get( keySecProxyIdx );
		}
		else {
			subdictSecProxyIdx = new HashMap< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff >();
			dictBySecProxyIdx.put( keySecProxyIdx, subdictSecProxyIdx );
		}
		subdictSecProxyIdx.put( pkey, Buff );

	}

	public CFGenKbSecSessionBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbSecSessionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecSession.readDerived";
		CFGenKbSecSessionPKey key = schema.getFactorySecSession().newPKey();
		key.setRequiredSecSessionId( PKey.getRequiredSecSessionId() );
		CFGenKbSecSessionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecSessionBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbSecSessionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecSession.readDerived";
		CFGenKbSecSessionPKey key = schema.getFactorySecSession().newPKey();
		key.setRequiredSecSessionId( PKey.getRequiredSecSessionId() );
		CFGenKbSecSessionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecSessionBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamSecSession.readAllDerived";
		CFGenKbSecSessionBuff[] retList = new CFGenKbSecSessionBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbSecSessionBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbSecSessionBuff[] readDerivedBySecUserIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFGenKbRamSecSession.readDerivedBySecUserIdx";
		CFGenKbSecSessionBySecUserIdxKey key = schema.getFactorySecSession().newSecUserIdxKey();
		key.setRequiredSecUserId( SecUserId );

		CFGenKbSecSessionBuff[] recArray;
		if( dictBySecUserIdx.containsKey( key ) ) {
			Map< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff > subdictSecUserIdx
				= dictBySecUserIdx.get( key );
			recArray = new CFGenKbSecSessionBuff[ subdictSecUserIdx.size() ];
			Iterator< CFGenKbSecSessionBuff > iter = subdictSecUserIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff > subdictSecUserIdx
				= new HashMap< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff >();
			dictBySecUserIdx.put( key, subdictSecUserIdx );
			recArray = new CFGenKbSecSessionBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecSessionBuff[] readDerivedBySecDevIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId,
		String SecDevName )
	{
		final String S_ProcName = "CFGenKbRamSecSession.readDerivedBySecDevIdx";
		CFGenKbSecSessionBySecDevIdxKey key = schema.getFactorySecSession().newSecDevIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalSecDevName( SecDevName );

		CFGenKbSecSessionBuff[] recArray;
		if( dictBySecDevIdx.containsKey( key ) ) {
			Map< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff > subdictSecDevIdx
				= dictBySecDevIdx.get( key );
			recArray = new CFGenKbSecSessionBuff[ subdictSecDevIdx.size() ];
			Iterator< CFGenKbSecSessionBuff > iter = subdictSecDevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff > subdictSecDevIdx
				= new HashMap< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff >();
			dictBySecDevIdx.put( key, subdictSecDevIdx );
			recArray = new CFGenKbSecSessionBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecSessionBuff readDerivedByStartIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId,
		Calendar Start )
	{
		final String S_ProcName = "CFGenKbRamSecSession.readDerivedByStartIdx";
		CFGenKbSecSessionByStartIdxKey key = schema.getFactorySecSession().newStartIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredStart( Start );

		CFGenKbSecSessionBuff buff;
		if( dictByStartIdx.containsKey( key ) ) {
			buff = dictByStartIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecSessionBuff[] readDerivedByFinishIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId,
		Calendar Finish )
	{
		final String S_ProcName = "CFGenKbRamSecSession.readDerivedByFinishIdx";
		CFGenKbSecSessionByFinishIdxKey key = schema.getFactorySecSession().newFinishIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalFinish( Finish );

		CFGenKbSecSessionBuff[] recArray;
		if( dictByFinishIdx.containsKey( key ) ) {
			Map< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff > subdictFinishIdx
				= dictByFinishIdx.get( key );
			recArray = new CFGenKbSecSessionBuff[ subdictFinishIdx.size() ];
			Iterator< CFGenKbSecSessionBuff > iter = subdictFinishIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff > subdictFinishIdx
				= new HashMap< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff >();
			dictByFinishIdx.put( key, subdictFinishIdx );
			recArray = new CFGenKbSecSessionBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecSessionBuff[] readDerivedBySecProxyIdx( CFGenKbAuthorization Authorization,
		UUID SecProxyId )
	{
		final String S_ProcName = "CFGenKbRamSecSession.readDerivedBySecProxyIdx";
		CFGenKbSecSessionBySecProxyIdxKey key = schema.getFactorySecSession().newSecProxyIdxKey();
		key.setOptionalSecProxyId( SecProxyId );

		CFGenKbSecSessionBuff[] recArray;
		if( dictBySecProxyIdx.containsKey( key ) ) {
			Map< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff > subdictSecProxyIdx
				= dictBySecProxyIdx.get( key );
			recArray = new CFGenKbSecSessionBuff[ subdictSecProxyIdx.size() ];
			Iterator< CFGenKbSecSessionBuff > iter = subdictSecProxyIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff > subdictSecProxyIdx
				= new HashMap< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff >();
			dictBySecProxyIdx.put( key, subdictSecProxyIdx );
			recArray = new CFGenKbSecSessionBuff[0];
		}
		return( recArray );
	}

	public CFGenKbSecSessionBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		UUID SecSessionId )
	{
		final String S_ProcName = "CFGenKbRamSecSession.readDerivedByIdIdx() ";
		CFGenKbSecSessionPKey key = schema.getFactorySecSession().newPKey();
		key.setRequiredSecSessionId( SecSessionId );

		CFGenKbSecSessionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecSessionBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbSecSessionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamSecSession.readBuff";
		CFGenKbSecSessionBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SESS" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecSessionBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbSecSessionPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbSecSessionBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SESS" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbSecSessionBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamSecSession.readAllBuff";
		CFGenKbSecSessionBuff buff;
		ArrayList<CFGenKbSecSessionBuff> filteredList = new ArrayList<CFGenKbSecSessionBuff>();
		CFGenKbSecSessionBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SESS" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecSessionBuff[0] ) );
	}

	/**
	 *	Read a page of all the specific SecSession buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSession instances in the database accessible for the Authorization.
	 */
	public CFGenKbSecSessionBuff[] pageAllBuff( CFGenKbAuthorization Authorization,
		UUID priorSecSessionId )
	{
		final String S_ProcName = "pageAllBuff";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public CFGenKbSecSessionBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		UUID SecSessionId )
	{
		final String S_ProcName = "CFGenKbRamSecSession.readBuffByIdIdx() ";
		CFGenKbSecSessionBuff buff = readDerivedByIdIdx( Authorization,
			SecSessionId );
		if( ( buff != null ) && buff.getClassCode().equals( "SESS" ) ) {
			return( (CFGenKbSecSessionBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbSecSessionBuff[] readBuffBySecUserIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId )
	{
		final String S_ProcName = "CFGenKbRamSecSession.readBuffBySecUserIdx() ";
		CFGenKbSecSessionBuff buff;
		ArrayList<CFGenKbSecSessionBuff> filteredList = new ArrayList<CFGenKbSecSessionBuff>();
		CFGenKbSecSessionBuff[] buffList = readDerivedBySecUserIdx( Authorization,
			SecUserId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SESS" ) ) {
				filteredList.add( (CFGenKbSecSessionBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecSessionBuff[0] ) );
	}

	public CFGenKbSecSessionBuff[] readBuffBySecDevIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId,
		String SecDevName )
	{
		final String S_ProcName = "CFGenKbRamSecSession.readBuffBySecDevIdx() ";
		CFGenKbSecSessionBuff buff;
		ArrayList<CFGenKbSecSessionBuff> filteredList = new ArrayList<CFGenKbSecSessionBuff>();
		CFGenKbSecSessionBuff[] buffList = readDerivedBySecDevIdx( Authorization,
			SecUserId,
			SecDevName );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SESS" ) ) {
				filteredList.add( (CFGenKbSecSessionBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecSessionBuff[0] ) );
	}

	public CFGenKbSecSessionBuff readBuffByStartIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId,
		Calendar Start )
	{
		final String S_ProcName = "CFGenKbRamSecSession.readBuffByStartIdx() ";
		CFGenKbSecSessionBuff buff = readDerivedByStartIdx( Authorization,
			SecUserId,
			Start );
		if( ( buff != null ) && buff.getClassCode().equals( "SESS" ) ) {
			return( (CFGenKbSecSessionBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbSecSessionBuff[] readBuffByFinishIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId,
		Calendar Finish )
	{
		final String S_ProcName = "CFGenKbRamSecSession.readBuffByFinishIdx() ";
		CFGenKbSecSessionBuff buff;
		ArrayList<CFGenKbSecSessionBuff> filteredList = new ArrayList<CFGenKbSecSessionBuff>();
		CFGenKbSecSessionBuff[] buffList = readDerivedByFinishIdx( Authorization,
			SecUserId,
			Finish );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SESS" ) ) {
				filteredList.add( (CFGenKbSecSessionBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecSessionBuff[0] ) );
	}

	public CFGenKbSecSessionBuff[] readBuffBySecProxyIdx( CFGenKbAuthorization Authorization,
		UUID SecProxyId )
	{
		final String S_ProcName = "CFGenKbRamSecSession.readBuffBySecProxyIdx() ";
		CFGenKbSecSessionBuff buff;
		ArrayList<CFGenKbSecSessionBuff> filteredList = new ArrayList<CFGenKbSecSessionBuff>();
		CFGenKbSecSessionBuff[] buffList = readDerivedBySecProxyIdx( Authorization,
			SecProxyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SESS" ) ) {
				filteredList.add( (CFGenKbSecSessionBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbSecSessionBuff[0] ) );
	}

	/**
	 *	Read a page array of the specific SecSession buffer instances identified by the duplicate key SecUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecSessionBuff[] pageBuffBySecUserIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId,
		UUID priorSecSessionId )
	{
		final String S_ProcName = "pageBuffBySecUserIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecSession buffer instances identified by the duplicate key SecDevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	argSecDevName	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecSessionBuff[] pageBuffBySecDevIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId,
		String SecDevName,
		UUID priorSecSessionId )
	{
		final String S_ProcName = "pageBuffBySecDevIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecSession buffer instances identified by the duplicate key FinishIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	argFinish	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecSessionBuff[] pageBuffByFinishIdx( CFGenKbAuthorization Authorization,
		UUID SecUserId,
		Calendar Finish,
		UUID priorSecSessionId )
	{
		final String S_ProcName = "pageBuffByFinishIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecSession buffer instances identified by the duplicate key SecProxyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSecProxyId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbSecSessionBuff[] pageBuffBySecProxyIdx( CFGenKbAuthorization Authorization,
		UUID SecProxyId,
		UUID priorSecSessionId )
	{
		final String S_ProcName = "pageBuffBySecProxyIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateSecSession( CFGenKbAuthorization Authorization,
		CFGenKbSecSessionBuff Buff )
	{
		CFGenKbSecSessionPKey pkey = schema.getFactorySecSession().newPKey();
		pkey.setRequiredSecSessionId( Buff.getRequiredSecSessionId() );
		CFGenKbSecSessionBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateSecSession",
				"Existing record not found",
				"SecSession",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateSecSession",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbSecSessionBySecUserIdxKey existingKeySecUserIdx = schema.getFactorySecSession().newSecUserIdxKey();
		existingKeySecUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		CFGenKbSecSessionBySecUserIdxKey newKeySecUserIdx = schema.getFactorySecSession().newSecUserIdxKey();
		newKeySecUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		CFGenKbSecSessionBySecDevIdxKey existingKeySecDevIdx = schema.getFactorySecSession().newSecDevIdxKey();
		existingKeySecDevIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		existingKeySecDevIdx.setOptionalSecDevName( existing.getOptionalSecDevName() );

		CFGenKbSecSessionBySecDevIdxKey newKeySecDevIdx = schema.getFactorySecSession().newSecDevIdxKey();
		newKeySecDevIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		newKeySecDevIdx.setOptionalSecDevName( Buff.getOptionalSecDevName() );

		CFGenKbSecSessionByStartIdxKey existingKeyStartIdx = schema.getFactorySecSession().newStartIdxKey();
		existingKeyStartIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		existingKeyStartIdx.setRequiredStart( existing.getRequiredStart() );

		CFGenKbSecSessionByStartIdxKey newKeyStartIdx = schema.getFactorySecSession().newStartIdxKey();
		newKeyStartIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		newKeyStartIdx.setRequiredStart( Buff.getRequiredStart() );

		CFGenKbSecSessionByFinishIdxKey existingKeyFinishIdx = schema.getFactorySecSession().newFinishIdxKey();
		existingKeyFinishIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		existingKeyFinishIdx.setOptionalFinish( existing.getOptionalFinish() );

		CFGenKbSecSessionByFinishIdxKey newKeyFinishIdx = schema.getFactorySecSession().newFinishIdxKey();
		newKeyFinishIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		newKeyFinishIdx.setOptionalFinish( Buff.getOptionalFinish() );

		CFGenKbSecSessionBySecProxyIdxKey existingKeySecProxyIdx = schema.getFactorySecSession().newSecProxyIdxKey();
		existingKeySecProxyIdx.setOptionalSecProxyId( existing.getOptionalSecProxyId() );

		CFGenKbSecSessionBySecProxyIdxKey newKeySecProxyIdx = schema.getFactorySecSession().newSecProxyIdxKey();
		newKeySecProxyIdx.setOptionalSecProxyId( Buff.getOptionalSecProxyId() );

		// Check unique indexes

		if( ! existingKeyStartIdx.equals( newKeyStartIdx ) ) {
			if( dictByStartIdx.containsKey( newKeyStartIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateSecSession",
					"SessionStartIdx",
					newKeyStartIdx );
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
						"updateSecSession",
						"Container",
						"SecSessionUser",
						"SecUser",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictBySecUserIdx.get( existingKeySecUserIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySecUserIdx.containsKey( newKeySecUserIdx ) ) {
			subdict = dictBySecUserIdx.get( newKeySecUserIdx );
		}
		else {
			subdict = new HashMap< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff >();
			dictBySecUserIdx.put( newKeySecUserIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictBySecDevIdx.get( existingKeySecDevIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySecDevIdx.containsKey( newKeySecDevIdx ) ) {
			subdict = dictBySecDevIdx.get( newKeySecDevIdx );
		}
		else {
			subdict = new HashMap< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff >();
			dictBySecDevIdx.put( newKeySecDevIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByStartIdx.remove( existingKeyStartIdx );
		dictByStartIdx.put( newKeyStartIdx, Buff );

		subdict = dictByFinishIdx.get( existingKeyFinishIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByFinishIdx.containsKey( newKeyFinishIdx ) ) {
			subdict = dictByFinishIdx.get( newKeyFinishIdx );
		}
		else {
			subdict = new HashMap< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff >();
			dictByFinishIdx.put( newKeyFinishIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictBySecProxyIdx.get( existingKeySecProxyIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySecProxyIdx.containsKey( newKeySecProxyIdx ) ) {
			subdict = dictBySecProxyIdx.get( newKeySecProxyIdx );
		}
		else {
			subdict = new HashMap< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff >();
			dictBySecProxyIdx.put( newKeySecProxyIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteSecSession( CFGenKbAuthorization Authorization,
		CFGenKbSecSessionBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamSecSessionTable.deleteSecSession() ";
		String classCode;
		CFGenKbSecSessionPKey pkey = schema.getFactorySecSession().newPKey();
		pkey.setRequiredSecSessionId( Buff.getRequiredSecSessionId() );
		CFGenKbSecSessionBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteSecSession",
				pkey );
		}
		CFGenKbSecSessionBySecUserIdxKey keySecUserIdx = schema.getFactorySecSession().newSecUserIdxKey();
		keySecUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		CFGenKbSecSessionBySecDevIdxKey keySecDevIdx = schema.getFactorySecSession().newSecDevIdxKey();
		keySecDevIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		keySecDevIdx.setOptionalSecDevName( existing.getOptionalSecDevName() );

		CFGenKbSecSessionByStartIdxKey keyStartIdx = schema.getFactorySecSession().newStartIdxKey();
		keyStartIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		keyStartIdx.setRequiredStart( existing.getRequiredStart() );

		CFGenKbSecSessionByFinishIdxKey keyFinishIdx = schema.getFactorySecSession().newFinishIdxKey();
		keyFinishIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		keyFinishIdx.setOptionalFinish( existing.getOptionalFinish() );

		CFGenKbSecSessionBySecProxyIdxKey keySecProxyIdx = schema.getFactorySecSession().newSecProxyIdxKey();
		keySecProxyIdx.setOptionalSecProxyId( existing.getOptionalSecProxyId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbSecSessionPKey, CFGenKbSecSessionBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictBySecUserIdx.get( keySecUserIdx );
		subdict.remove( pkey );

		subdict = dictBySecDevIdx.get( keySecDevIdx );
		subdict.remove( pkey );

		dictByStartIdx.remove( keyStartIdx );

		subdict = dictByFinishIdx.get( keyFinishIdx );
		subdict.remove( pkey );

		subdict = dictBySecProxyIdx.get( keySecProxyIdx );
		subdict.remove( pkey );

	}
	public void deleteSecSessionByIdIdx( CFGenKbAuthorization Authorization,
		UUID argSecSessionId )
	{
		CFGenKbSecSessionPKey key = schema.getFactorySecSession().newPKey();
		key.setRequiredSecSessionId( argSecSessionId );
		deleteSecSessionByIdIdx( Authorization, key );
	}

	public void deleteSecSessionByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecSessionPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbSecSessionBuff cur;
		LinkedList<CFGenKbSecSessionBuff> matchSet = new LinkedList<CFGenKbSecSessionBuff>();
		Iterator<CFGenKbSecSessionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecSessionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecSession().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSessionId() );
			deleteSecSession( Authorization, cur );
		}
	}

	public void deleteSecSessionBySecUserIdx( CFGenKbAuthorization Authorization,
		UUID argSecUserId )
	{
		CFGenKbSecSessionBySecUserIdxKey key = schema.getFactorySecSession().newSecUserIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		deleteSecSessionBySecUserIdx( Authorization, key );
	}

	public void deleteSecSessionBySecUserIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecSessionBySecUserIdxKey argKey )
	{
		CFGenKbSecSessionBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecSessionBuff> matchSet = new LinkedList<CFGenKbSecSessionBuff>();
		Iterator<CFGenKbSecSessionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecSessionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecSession().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSessionId() );
			deleteSecSession( Authorization, cur );
		}
	}

	public void deleteSecSessionBySecDevIdx( CFGenKbAuthorization Authorization,
		UUID argSecUserId,
		String argSecDevName )
	{
		CFGenKbSecSessionBySecDevIdxKey key = schema.getFactorySecSession().newSecDevIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		key.setOptionalSecDevName( argSecDevName );
		deleteSecSessionBySecDevIdx( Authorization, key );
	}

	public void deleteSecSessionBySecDevIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecSessionBySecDevIdxKey argKey )
	{
		CFGenKbSecSessionBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( argKey.getOptionalSecDevName() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecSessionBuff> matchSet = new LinkedList<CFGenKbSecSessionBuff>();
		Iterator<CFGenKbSecSessionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecSessionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecSession().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSessionId() );
			deleteSecSession( Authorization, cur );
		}
	}

	public void deleteSecSessionByStartIdx( CFGenKbAuthorization Authorization,
		UUID argSecUserId,
		Calendar argStart )
	{
		CFGenKbSecSessionByStartIdxKey key = schema.getFactorySecSession().newStartIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		key.setRequiredStart( argStart );
		deleteSecSessionByStartIdx( Authorization, key );
	}

	public void deleteSecSessionByStartIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecSessionByStartIdxKey argKey )
	{
		CFGenKbSecSessionBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecSessionBuff> matchSet = new LinkedList<CFGenKbSecSessionBuff>();
		Iterator<CFGenKbSecSessionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecSessionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecSession().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSessionId() );
			deleteSecSession( Authorization, cur );
		}
	}

	public void deleteSecSessionByFinishIdx( CFGenKbAuthorization Authorization,
		UUID argSecUserId,
		Calendar argFinish )
	{
		CFGenKbSecSessionByFinishIdxKey key = schema.getFactorySecSession().newFinishIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		key.setOptionalFinish( argFinish );
		deleteSecSessionByFinishIdx( Authorization, key );
	}

	public void deleteSecSessionByFinishIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecSessionByFinishIdxKey argKey )
	{
		CFGenKbSecSessionBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( argKey.getOptionalFinish() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecSessionBuff> matchSet = new LinkedList<CFGenKbSecSessionBuff>();
		Iterator<CFGenKbSecSessionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecSessionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecSession().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSessionId() );
			deleteSecSession( Authorization, cur );
		}
	}

	public void deleteSecSessionBySecProxyIdx( CFGenKbAuthorization Authorization,
		UUID argSecProxyId )
	{
		CFGenKbSecSessionBySecProxyIdxKey key = schema.getFactorySecSession().newSecProxyIdxKey();
		key.setOptionalSecProxyId( argSecProxyId );
		deleteSecSessionBySecProxyIdx( Authorization, key );
	}

	public void deleteSecSessionBySecProxyIdx( CFGenKbAuthorization Authorization,
		CFGenKbSecSessionBySecProxyIdxKey argKey )
	{
		CFGenKbSecSessionBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalSecProxyId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbSecSessionBuff> matchSet = new LinkedList<CFGenKbSecSessionBuff>();
		Iterator<CFGenKbSecSessionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbSecSessionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableSecSession().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSessionId() );
			deleteSecSession( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
