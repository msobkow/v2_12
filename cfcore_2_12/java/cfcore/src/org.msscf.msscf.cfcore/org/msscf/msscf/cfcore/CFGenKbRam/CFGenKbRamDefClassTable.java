
// Description: Java 11 in-memory RAM DbIO implementation for DefClass.

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
 *	CFGenKbRamDefClassTable in-memory RAM DbIO implementation
 *	for DefClass.
 */
public class CFGenKbRamDefClassTable
	implements ICFGenKbDefClassTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbDefClassPKey,
				CFGenKbDefClassBuff > dictByPKey
		= new HashMap< CFGenKbDefClassPKey,
				CFGenKbDefClassBuff >();
	private Map< CFGenKbDefClassByNameIdxKey,
			CFGenKbDefClassBuff > dictByNameIdx
		= new HashMap< CFGenKbDefClassByNameIdxKey,
			CFGenKbDefClassBuff >();
	private Map< CFGenKbDefClassByBaseIdxKey,
				Map< CFGenKbDefClassPKey,
					CFGenKbDefClassBuff >> dictByBaseIdx
		= new HashMap< CFGenKbDefClassByBaseIdxKey,
				Map< CFGenKbDefClassPKey,
					CFGenKbDefClassBuff >>();

	public CFGenKbRamDefClassTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createDefClass( CFGenKbAuthorization Authorization,
		CFGenKbDefClassBuff Buff )
	{
		final String S_ProcName = "createDefClass";
		CFGenKbDefClassPKey pkey = schema.getFactoryDefClass().newPKey();
		pkey.setRequiredId( schema.nextDefClassIdGen() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFGenKbDefClassByNameIdxKey keyNameIdx = schema.getFactoryDefClass().newNameIdxKey();
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		CFGenKbDefClassByBaseIdxKey keyBaseIdx = schema.getFactoryDefClass().newBaseIdxKey();
		keyBaseIdx.setOptionalBaseId( Buff.getOptionalBaseId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"DefClassName",
				keyNameIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

		Map< CFGenKbDefClassPKey, CFGenKbDefClassBuff > subdictBaseIdx;
		if( dictByBaseIdx.containsKey( keyBaseIdx ) ) {
			subdictBaseIdx = dictByBaseIdx.get( keyBaseIdx );
		}
		else {
			subdictBaseIdx = new HashMap< CFGenKbDefClassPKey, CFGenKbDefClassBuff >();
			dictByBaseIdx.put( keyBaseIdx, subdictBaseIdx );
		}
		subdictBaseIdx.put( pkey, Buff );

	}

	public CFGenKbDefClassBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbDefClassPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamDefClass.readDerived";
		CFGenKbDefClassPKey key = schema.getFactoryDefClass().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFGenKbDefClassBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbDefClassBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbDefClassPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamDefClass.readDerived";
		CFGenKbDefClassPKey key = schema.getFactoryDefClass().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFGenKbDefClassBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbDefClassBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamDefClass.readAllDerived";
		CFGenKbDefClassBuff[] retList = new CFGenKbDefClassBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbDefClassBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbDefClassBuff readDerivedByNameIdx( CFGenKbAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFGenKbRamDefClass.readDerivedByNameIdx";
		CFGenKbDefClassByNameIdxKey key = schema.getFactoryDefClass().newNameIdxKey();
		key.setRequiredName( Name );

		CFGenKbDefClassBuff buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbDefClassBuff[] readDerivedByBaseIdx( CFGenKbAuthorization Authorization,
		Short BaseId )
	{
		final String S_ProcName = "CFGenKbRamDefClass.readDerivedByBaseIdx";
		CFGenKbDefClassByBaseIdxKey key = schema.getFactoryDefClass().newBaseIdxKey();
		key.setOptionalBaseId( BaseId );

		CFGenKbDefClassBuff[] recArray;
		if( dictByBaseIdx.containsKey( key ) ) {
			Map< CFGenKbDefClassPKey, CFGenKbDefClassBuff > subdictBaseIdx
				= dictByBaseIdx.get( key );
			recArray = new CFGenKbDefClassBuff[ subdictBaseIdx.size() ];
			Iterator< CFGenKbDefClassBuff > iter = subdictBaseIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbDefClassPKey, CFGenKbDefClassBuff > subdictBaseIdx
				= new HashMap< CFGenKbDefClassPKey, CFGenKbDefClassBuff >();
			dictByBaseIdx.put( key, subdictBaseIdx );
			recArray = new CFGenKbDefClassBuff[0];
		}
		return( recArray );
	}

	public CFGenKbDefClassBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFGenKbRamDefClass.readDerivedByIdIdx() ";
		CFGenKbDefClassPKey key = schema.getFactoryDefClass().newPKey();
		key.setRequiredId( Id );

		CFGenKbDefClassBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbDefClassBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbDefClassPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamDefClass.readBuff";
		CFGenKbDefClassBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DCL" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbDefClassBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbDefClassPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbDefClassBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DCL" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbDefClassBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamDefClass.readAllBuff";
		CFGenKbDefClassBuff buff;
		ArrayList<CFGenKbDefClassBuff> filteredList = new ArrayList<CFGenKbDefClassBuff>();
		CFGenKbDefClassBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DCL" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbDefClassBuff[0] ) );
	}

	public CFGenKbDefClassBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFGenKbRamDefClass.readBuffByIdIdx() ";
		CFGenKbDefClassBuff buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "DCL" ) ) {
			return( (CFGenKbDefClassBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbDefClassBuff readBuffByNameIdx( CFGenKbAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFGenKbRamDefClass.readBuffByNameIdx() ";
		CFGenKbDefClassBuff buff = readDerivedByNameIdx( Authorization,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "DCL" ) ) {
			return( (CFGenKbDefClassBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbDefClassBuff[] readBuffByBaseIdx( CFGenKbAuthorization Authorization,
		Short BaseId )
	{
		final String S_ProcName = "CFGenKbRamDefClass.readBuffByBaseIdx() ";
		CFGenKbDefClassBuff buff;
		ArrayList<CFGenKbDefClassBuff> filteredList = new ArrayList<CFGenKbDefClassBuff>();
		CFGenKbDefClassBuff[] buffList = readDerivedByBaseIdx( Authorization,
			BaseId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DCL" ) ) {
				filteredList.add( (CFGenKbDefClassBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbDefClassBuff[0] ) );
	}

	public void updateDefClass( CFGenKbAuthorization Authorization,
		CFGenKbDefClassBuff Buff )
	{
		CFGenKbDefClassPKey pkey = schema.getFactoryDefClass().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFGenKbDefClassBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateDefClass",
				"Existing record not found",
				"DefClass",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateDefClass",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbDefClassByNameIdxKey existingKeyNameIdx = schema.getFactoryDefClass().newNameIdxKey();
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		CFGenKbDefClassByNameIdxKey newKeyNameIdx = schema.getFactoryDefClass().newNameIdxKey();
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		CFGenKbDefClassByBaseIdxKey existingKeyBaseIdx = schema.getFactoryDefClass().newBaseIdxKey();
		existingKeyBaseIdx.setOptionalBaseId( existing.getOptionalBaseId() );

		CFGenKbDefClassByBaseIdxKey newKeyBaseIdx = schema.getFactoryDefClass().newBaseIdxKey();
		newKeyBaseIdx.setOptionalBaseId( Buff.getOptionalBaseId() );

		// Check unique indexes

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateDefClass",
					"DefClassName",
					newKeyNameIdx );
			}
		}

		// Validate foreign keys

		// Update is valid

		Map< CFGenKbDefClassPKey, CFGenKbDefClassBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

		subdict = dictByBaseIdx.get( existingKeyBaseIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByBaseIdx.containsKey( newKeyBaseIdx ) ) {
			subdict = dictByBaseIdx.get( newKeyBaseIdx );
		}
		else {
			subdict = new HashMap< CFGenKbDefClassPKey, CFGenKbDefClassBuff >();
			dictByBaseIdx.put( newKeyBaseIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteDefClass( CFGenKbAuthorization Authorization,
		CFGenKbDefClassBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamDefClassTable.deleteDefClass() ";
		String classCode;
		CFGenKbDefClassPKey pkey = schema.getFactoryDefClass().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFGenKbDefClassBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteDefClass",
				pkey );
		}
		CFGenKbDefClassByNameIdxKey keyNameIdx = schema.getFactoryDefClass().newNameIdxKey();
		keyNameIdx.setRequiredName( existing.getRequiredName() );

		CFGenKbDefClassByBaseIdxKey keyBaseIdx = schema.getFactoryDefClass().newBaseIdxKey();
		keyBaseIdx.setOptionalBaseId( existing.getOptionalBaseId() );

		// Validate reverse foreign keys

		if( schema.getTableGenItem().readDerivedByGenDefIdx( Authorization,
					existing.getRequiredId() ).length > 0 )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteDefClass",
				"Lookup",
				"GenDef",
				"GenItem",
				pkey );
		}

		// Delete is valid
		Map< CFGenKbDefClassPKey, CFGenKbDefClassBuff > subdict;

		dictByPKey.remove( pkey );

		dictByNameIdx.remove( keyNameIdx );

		subdict = dictByBaseIdx.get( keyBaseIdx );
		subdict.remove( pkey );

	}
	public void deleteDefClassByIdIdx( CFGenKbAuthorization Authorization,
		short argId )
	{
		CFGenKbDefClassPKey key = schema.getFactoryDefClass().newPKey();
		key.setRequiredId( argId );
		deleteDefClassByIdIdx( Authorization, key );
	}

	public void deleteDefClassByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbDefClassPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbDefClassBuff cur;
		LinkedList<CFGenKbDefClassBuff> matchSet = new LinkedList<CFGenKbDefClassBuff>();
		Iterator<CFGenKbDefClassBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbDefClassBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableDefClass().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteDefClass( Authorization, cur );
		}
	}

	public void deleteDefClassByNameIdx( CFGenKbAuthorization Authorization,
		String argName )
	{
		CFGenKbDefClassByNameIdxKey key = schema.getFactoryDefClass().newNameIdxKey();
		key.setRequiredName( argName );
		deleteDefClassByNameIdx( Authorization, key );
	}

	public void deleteDefClassByNameIdx( CFGenKbAuthorization Authorization,
		CFGenKbDefClassByNameIdxKey argKey )
	{
		CFGenKbDefClassBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbDefClassBuff> matchSet = new LinkedList<CFGenKbDefClassBuff>();
		Iterator<CFGenKbDefClassBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbDefClassBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableDefClass().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteDefClass( Authorization, cur );
		}
	}

	public void deleteDefClassByBaseIdx( CFGenKbAuthorization Authorization,
		Short argBaseId )
	{
		CFGenKbDefClassByBaseIdxKey key = schema.getFactoryDefClass().newBaseIdxKey();
		key.setOptionalBaseId( argBaseId );
		deleteDefClassByBaseIdx( Authorization, key );
	}

	public void deleteDefClassByBaseIdx( CFGenKbAuthorization Authorization,
		CFGenKbDefClassByBaseIdxKey argKey )
	{
		CFGenKbDefClassBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalBaseId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbDefClassBuff> matchSet = new LinkedList<CFGenKbDefClassBuff>();
		Iterator<CFGenKbDefClassBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbDefClassBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableDefClass().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteDefClass( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
