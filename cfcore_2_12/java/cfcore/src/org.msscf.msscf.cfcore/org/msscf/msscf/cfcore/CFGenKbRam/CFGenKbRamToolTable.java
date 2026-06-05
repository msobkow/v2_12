
// Description: Java 11 in-memory RAM DbIO implementation for Tool.

/*
 *	org.msscf.msscf.CFCore
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
 *	
 *	MSS Code Factory is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with MSS Code Factory.  If not, see https://www.gnu.org/licenses/.
 *	
 *	Donations to support MSS Code Factory can be made at
 *	https://www.paypal.com/paypalme2/MarkSobkow
 *	
 *	Contact Mark Stephen Sobkow at msobkow@sasktel.net for commercial licensing.
 *
 *	Manufactured by MSS Code Factory 2.11
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
 *	CFGenKbRamToolTable in-memory RAM DbIO implementation
 *	for Tool.
 */
public class CFGenKbRamToolTable
	implements ICFGenKbToolTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbToolPKey,
				CFGenKbToolBuff > dictByPKey
		= new HashMap< CFGenKbToolPKey,
				CFGenKbToolBuff >();
	private Map< CFGenKbToolByNameIdxKey,
			CFGenKbToolBuff > dictByNameIdx
		= new HashMap< CFGenKbToolByNameIdxKey,
			CFGenKbToolBuff >();
	private Map< CFGenKbToolByReplacesIdxKey,
				Map< CFGenKbToolPKey,
					CFGenKbToolBuff >> dictByReplacesIdx
		= new HashMap< CFGenKbToolByReplacesIdxKey,
				Map< CFGenKbToolPKey,
					CFGenKbToolBuff >>();

	public CFGenKbRamToolTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createTool( CFGenKbAuthorization Authorization,
		CFGenKbToolBuff Buff )
	{
		final String S_ProcName = "createTool";
		CFGenKbToolPKey pkey = schema.getFactoryTool().newPKey();
		pkey.setRequiredId( schema.nextToolIdGen() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFGenKbToolByNameIdxKey keyNameIdx = schema.getFactoryTool().newNameIdxKey();
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		CFGenKbToolByReplacesIdxKey keyReplacesIdx = schema.getFactoryTool().newReplacesIdxKey();
		keyReplacesIdx.setOptionalReplacesId( Buff.getOptionalReplacesId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ToolName",
				keyNameIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

		Map< CFGenKbToolPKey, CFGenKbToolBuff > subdictReplacesIdx;
		if( dictByReplacesIdx.containsKey( keyReplacesIdx ) ) {
			subdictReplacesIdx = dictByReplacesIdx.get( keyReplacesIdx );
		}
		else {
			subdictReplacesIdx = new HashMap< CFGenKbToolPKey, CFGenKbToolBuff >();
			dictByReplacesIdx.put( keyReplacesIdx, subdictReplacesIdx );
		}
		subdictReplacesIdx.put( pkey, Buff );

	}

	public CFGenKbToolBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbToolPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamTool.readDerived";
		CFGenKbToolPKey key = schema.getFactoryTool().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFGenKbToolBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbToolBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbToolPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamTool.readDerived";
		CFGenKbToolPKey key = schema.getFactoryTool().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFGenKbToolBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbToolBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamTool.readAllDerived";
		CFGenKbToolBuff[] retList = new CFGenKbToolBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbToolBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbToolBuff readDerivedByNameIdx( CFGenKbAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFGenKbRamTool.readDerivedByNameIdx";
		CFGenKbToolByNameIdxKey key = schema.getFactoryTool().newNameIdxKey();
		key.setRequiredName( Name );

		CFGenKbToolBuff buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbToolBuff[] readDerivedByReplacesIdx( CFGenKbAuthorization Authorization,
		Short ReplacesId )
	{
		final String S_ProcName = "CFGenKbRamTool.readDerivedByReplacesIdx";
		CFGenKbToolByReplacesIdxKey key = schema.getFactoryTool().newReplacesIdxKey();
		key.setOptionalReplacesId( ReplacesId );

		CFGenKbToolBuff[] recArray;
		if( dictByReplacesIdx.containsKey( key ) ) {
			Map< CFGenKbToolPKey, CFGenKbToolBuff > subdictReplacesIdx
				= dictByReplacesIdx.get( key );
			recArray = new CFGenKbToolBuff[ subdictReplacesIdx.size() ];
			Iterator< CFGenKbToolBuff > iter = subdictReplacesIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbToolPKey, CFGenKbToolBuff > subdictReplacesIdx
				= new HashMap< CFGenKbToolPKey, CFGenKbToolBuff >();
			dictByReplacesIdx.put( key, subdictReplacesIdx );
			recArray = new CFGenKbToolBuff[0];
		}
		return( recArray );
	}

	public CFGenKbToolBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFGenKbRamTool.readDerivedByIdIdx() ";
		CFGenKbToolPKey key = schema.getFactoryTool().newPKey();
		key.setRequiredId( Id );

		CFGenKbToolBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbToolBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbToolPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamTool.readBuff";
		CFGenKbToolBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TOL" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbToolBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbToolPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbToolBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TOL" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbToolBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamTool.readAllBuff";
		CFGenKbToolBuff buff;
		ArrayList<CFGenKbToolBuff> filteredList = new ArrayList<CFGenKbToolBuff>();
		CFGenKbToolBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TOL" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbToolBuff[0] ) );
	}

	public CFGenKbToolBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFGenKbRamTool.readBuffByIdIdx() ";
		CFGenKbToolBuff buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "TOL" ) ) {
			return( (CFGenKbToolBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbToolBuff readBuffByNameIdx( CFGenKbAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFGenKbRamTool.readBuffByNameIdx() ";
		CFGenKbToolBuff buff = readDerivedByNameIdx( Authorization,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "TOL" ) ) {
			return( (CFGenKbToolBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbToolBuff[] readBuffByReplacesIdx( CFGenKbAuthorization Authorization,
		Short ReplacesId )
	{
		final String S_ProcName = "CFGenKbRamTool.readBuffByReplacesIdx() ";
		CFGenKbToolBuff buff;
		ArrayList<CFGenKbToolBuff> filteredList = new ArrayList<CFGenKbToolBuff>();
		CFGenKbToolBuff[] buffList = readDerivedByReplacesIdx( Authorization,
			ReplacesId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TOL" ) ) {
				filteredList.add( (CFGenKbToolBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbToolBuff[0] ) );
	}

	public void updateTool( CFGenKbAuthorization Authorization,
		CFGenKbToolBuff Buff )
	{
		CFGenKbToolPKey pkey = schema.getFactoryTool().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFGenKbToolBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateTool",
				"Existing record not found",
				"Tool",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateTool",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbToolByNameIdxKey existingKeyNameIdx = schema.getFactoryTool().newNameIdxKey();
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		CFGenKbToolByNameIdxKey newKeyNameIdx = schema.getFactoryTool().newNameIdxKey();
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		CFGenKbToolByReplacesIdxKey existingKeyReplacesIdx = schema.getFactoryTool().newReplacesIdxKey();
		existingKeyReplacesIdx.setOptionalReplacesId( existing.getOptionalReplacesId() );

		CFGenKbToolByReplacesIdxKey newKeyReplacesIdx = schema.getFactoryTool().newReplacesIdxKey();
		newKeyReplacesIdx.setOptionalReplacesId( Buff.getOptionalReplacesId() );

		// Check unique indexes

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateTool",
					"ToolName",
					newKeyNameIdx );
			}
		}

		// Validate foreign keys

		// Update is valid

		Map< CFGenKbToolPKey, CFGenKbToolBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

		subdict = dictByReplacesIdx.get( existingKeyReplacesIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByReplacesIdx.containsKey( newKeyReplacesIdx ) ) {
			subdict = dictByReplacesIdx.get( newKeyReplacesIdx );
		}
		else {
			subdict = new HashMap< CFGenKbToolPKey, CFGenKbToolBuff >();
			dictByReplacesIdx.put( newKeyReplacesIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteTool( CFGenKbAuthorization Authorization,
		CFGenKbToolBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamToolTable.deleteTool() ";
		String classCode;
		CFGenKbToolPKey pkey = schema.getFactoryTool().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFGenKbToolBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteTool",
				pkey );
		}
		CFGenKbToolByNameIdxKey keyNameIdx = schema.getFactoryTool().newNameIdxKey();
		keyNameIdx.setRequiredName( existing.getRequiredName() );

		CFGenKbToolByReplacesIdxKey keyReplacesIdx = schema.getFactoryTool().newReplacesIdxKey();
		keyReplacesIdx.setOptionalReplacesId( existing.getOptionalReplacesId() );

		// Validate reverse foreign keys

		if( schema.getTableToolSet().readDerivedByTool0Idx( Authorization,
					existing.getRequiredId() ).length > 0 )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteTool",
				"Lookup",
				"Tool0",
				"ToolSet",
				pkey );
		}

		// Delete is valid
		Map< CFGenKbToolPKey, CFGenKbToolBuff > subdict;

		dictByPKey.remove( pkey );

		dictByNameIdx.remove( keyNameIdx );

		subdict = dictByReplacesIdx.get( keyReplacesIdx );
		subdict.remove( pkey );

	}
	public void deleteToolByIdIdx( CFGenKbAuthorization Authorization,
		short argId )
	{
		CFGenKbToolPKey key = schema.getFactoryTool().newPKey();
		key.setRequiredId( argId );
		deleteToolByIdIdx( Authorization, key );
	}

	public void deleteToolByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbToolPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbToolBuff cur;
		LinkedList<CFGenKbToolBuff> matchSet = new LinkedList<CFGenKbToolBuff>();
		Iterator<CFGenKbToolBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbToolBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTool().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteTool( Authorization, cur );
		}
	}

	public void deleteToolByNameIdx( CFGenKbAuthorization Authorization,
		String argName )
	{
		CFGenKbToolByNameIdxKey key = schema.getFactoryTool().newNameIdxKey();
		key.setRequiredName( argName );
		deleteToolByNameIdx( Authorization, key );
	}

	public void deleteToolByNameIdx( CFGenKbAuthorization Authorization,
		CFGenKbToolByNameIdxKey argKey )
	{
		CFGenKbToolBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbToolBuff> matchSet = new LinkedList<CFGenKbToolBuff>();
		Iterator<CFGenKbToolBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbToolBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTool().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteTool( Authorization, cur );
		}
	}

	public void deleteToolByReplacesIdx( CFGenKbAuthorization Authorization,
		Short argReplacesId )
	{
		CFGenKbToolByReplacesIdxKey key = schema.getFactoryTool().newReplacesIdxKey();
		key.setOptionalReplacesId( argReplacesId );
		deleteToolByReplacesIdx( Authorization, key );
	}

	public void deleteToolByReplacesIdx( CFGenKbAuthorization Authorization,
		CFGenKbToolByReplacesIdxKey argKey )
	{
		CFGenKbToolBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalReplacesId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbToolBuff> matchSet = new LinkedList<CFGenKbToolBuff>();
		Iterator<CFGenKbToolBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbToolBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableTool().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteTool( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
