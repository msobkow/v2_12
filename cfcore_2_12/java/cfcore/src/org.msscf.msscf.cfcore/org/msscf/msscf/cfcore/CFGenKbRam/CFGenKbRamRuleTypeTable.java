
// Description: Java 11 in-memory RAM DbIO implementation for RuleType.

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
 *	CFGenKbRamRuleTypeTable in-memory RAM DbIO implementation
 *	for RuleType.
 */
public class CFGenKbRamRuleTypeTable
	implements ICFGenKbRuleTypeTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbRuleTypePKey,
				CFGenKbRuleTypeBuff > dictByPKey
		= new HashMap< CFGenKbRuleTypePKey,
				CFGenKbRuleTypeBuff >();
	private Map< CFGenKbRuleTypeByNameIdxKey,
			CFGenKbRuleTypeBuff > dictByNameIdx
		= new HashMap< CFGenKbRuleTypeByNameIdxKey,
			CFGenKbRuleTypeBuff >();

	public CFGenKbRamRuleTypeTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createRuleType( CFGenKbAuthorization Authorization,
		CFGenKbRuleTypeBuff Buff )
	{
		final String S_ProcName = "createRuleType";
		CFGenKbRuleTypePKey pkey = schema.getFactoryRuleType().newPKey();
		pkey.setRequiredId( schema.nextRuleTypeIdGen() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFGenKbRuleTypeByNameIdxKey keyNameIdx = schema.getFactoryRuleType().newNameIdxKey();
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"RuleTypeName",
				keyNameIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

	}

	public CFGenKbRuleTypeBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbRuleTypePKey PKey )
	{
		final String S_ProcName = "CFGenKbRamRuleType.readDerived";
		CFGenKbRuleTypePKey key = schema.getFactoryRuleType().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFGenKbRuleTypeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbRuleTypeBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbRuleTypePKey PKey )
	{
		final String S_ProcName = "CFGenKbRamRuleType.readDerived";
		CFGenKbRuleTypePKey key = schema.getFactoryRuleType().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFGenKbRuleTypeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbRuleTypeBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamRuleType.readAllDerived";
		CFGenKbRuleTypeBuff[] retList = new CFGenKbRuleTypeBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbRuleTypeBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbRuleTypeBuff readDerivedByNameIdx( CFGenKbAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFGenKbRamRuleType.readDerivedByNameIdx";
		CFGenKbRuleTypeByNameIdxKey key = schema.getFactoryRuleType().newNameIdxKey();
		key.setRequiredName( Name );

		CFGenKbRuleTypeBuff buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbRuleTypeBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFGenKbRamRuleType.readDerivedByIdIdx() ";
		CFGenKbRuleTypePKey key = schema.getFactoryRuleType().newPKey();
		key.setRequiredId( Id );

		CFGenKbRuleTypeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbRuleTypeBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbRuleTypePKey PKey )
	{
		final String S_ProcName = "CFGenKbRamRuleType.readBuff";
		CFGenKbRuleTypeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "RTP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbRuleTypeBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbRuleTypePKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbRuleTypeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "RTP" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbRuleTypeBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamRuleType.readAllBuff";
		CFGenKbRuleTypeBuff buff;
		ArrayList<CFGenKbRuleTypeBuff> filteredList = new ArrayList<CFGenKbRuleTypeBuff>();
		CFGenKbRuleTypeBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RTP" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbRuleTypeBuff[0] ) );
	}

	public CFGenKbRuleTypeBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFGenKbRamRuleType.readBuffByIdIdx() ";
		CFGenKbRuleTypeBuff buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "RTP" ) ) {
			return( (CFGenKbRuleTypeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbRuleTypeBuff readBuffByNameIdx( CFGenKbAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFGenKbRamRuleType.readBuffByNameIdx() ";
		CFGenKbRuleTypeBuff buff = readDerivedByNameIdx( Authorization,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "RTP" ) ) {
			return( (CFGenKbRuleTypeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateRuleType( CFGenKbAuthorization Authorization,
		CFGenKbRuleTypeBuff Buff )
	{
		CFGenKbRuleTypePKey pkey = schema.getFactoryRuleType().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFGenKbRuleTypeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateRuleType",
				"Existing record not found",
				"RuleType",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateRuleType",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbRuleTypeByNameIdxKey existingKeyNameIdx = schema.getFactoryRuleType().newNameIdxKey();
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		CFGenKbRuleTypeByNameIdxKey newKeyNameIdx = schema.getFactoryRuleType().newNameIdxKey();
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateRuleType",
					"RuleTypeName",
					newKeyNameIdx );
			}
		}

		// Validate foreign keys

		// Update is valid

		Map< CFGenKbRuleTypePKey, CFGenKbRuleTypeBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

	}

	public void deleteRuleType( CFGenKbAuthorization Authorization,
		CFGenKbRuleTypeBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamRuleTypeTable.deleteRuleType() ";
		String classCode;
		CFGenKbRuleTypePKey pkey = schema.getFactoryRuleType().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFGenKbRuleTypeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteRuleType",
				pkey );
		}
		CFGenKbRuleTypeByNameIdxKey keyNameIdx = schema.getFactoryRuleType().newNameIdxKey();
		keyNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		if( schema.getTableGenItem().readDerivedByRuleTypeIdx( Authorization,
					existing.getRequiredId() ).length > 0 )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteRuleType",
				"Lookup",
				"RuleType",
				"GenItem",
				pkey );
		}

		// Delete is valid
		Map< CFGenKbRuleTypePKey, CFGenKbRuleTypeBuff > subdict;

		dictByPKey.remove( pkey );

		dictByNameIdx.remove( keyNameIdx );

	}
	public void deleteRuleTypeByIdIdx( CFGenKbAuthorization Authorization,
		short argId )
	{
		CFGenKbRuleTypePKey key = schema.getFactoryRuleType().newPKey();
		key.setRequiredId( argId );
		deleteRuleTypeByIdIdx( Authorization, key );
	}

	public void deleteRuleTypeByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbRuleTypePKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbRuleTypeBuff cur;
		LinkedList<CFGenKbRuleTypeBuff> matchSet = new LinkedList<CFGenKbRuleTypeBuff>();
		Iterator<CFGenKbRuleTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbRuleTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableRuleType().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteRuleType( Authorization, cur );
		}
	}

	public void deleteRuleTypeByNameIdx( CFGenKbAuthorization Authorization,
		String argName )
	{
		CFGenKbRuleTypeByNameIdxKey key = schema.getFactoryRuleType().newNameIdxKey();
		key.setRequiredName( argName );
		deleteRuleTypeByNameIdx( Authorization, key );
	}

	public void deleteRuleTypeByNameIdx( CFGenKbAuthorization Authorization,
		CFGenKbRuleTypeByNameIdxKey argKey )
	{
		CFGenKbRuleTypeBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbRuleTypeBuff> matchSet = new LinkedList<CFGenKbRuleTypeBuff>();
		Iterator<CFGenKbRuleTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbRuleTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableRuleType().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteRuleType( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
