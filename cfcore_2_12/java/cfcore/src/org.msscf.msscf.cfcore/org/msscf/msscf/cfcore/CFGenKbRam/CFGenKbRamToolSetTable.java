
// Description: Java 11 in-memory RAM DbIO implementation for ToolSet.

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
 *	CFGenKbRamToolSetTable in-memory RAM DbIO implementation
 *	for ToolSet.
 */
public class CFGenKbRamToolSetTable
	implements ICFGenKbToolSetTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbToolSetPKey,
				CFGenKbToolSetBuff > dictByPKey
		= new HashMap< CFGenKbToolSetPKey,
				CFGenKbToolSetBuff >();
	private Map< CFGenKbToolSetByNameIdxKey,
			CFGenKbToolSetBuff > dictByNameIdx
		= new HashMap< CFGenKbToolSetByNameIdxKey,
			CFGenKbToolSetBuff >();
	private Map< CFGenKbToolSetByTool0IdxKey,
				Map< CFGenKbToolSetPKey,
					CFGenKbToolSetBuff >> dictByTool0Idx
		= new HashMap< CFGenKbToolSetByTool0IdxKey,
				Map< CFGenKbToolSetPKey,
					CFGenKbToolSetBuff >>();
	private Map< CFGenKbToolSetByTool1IdxKey,
				Map< CFGenKbToolSetPKey,
					CFGenKbToolSetBuff >> dictByTool1Idx
		= new HashMap< CFGenKbToolSetByTool1IdxKey,
				Map< CFGenKbToolSetPKey,
					CFGenKbToolSetBuff >>();
	private Map< CFGenKbToolSetByTool2IdxKey,
				Map< CFGenKbToolSetPKey,
					CFGenKbToolSetBuff >> dictByTool2Idx
		= new HashMap< CFGenKbToolSetByTool2IdxKey,
				Map< CFGenKbToolSetPKey,
					CFGenKbToolSetBuff >>();
	private Map< CFGenKbToolSetByTool3IdxKey,
				Map< CFGenKbToolSetPKey,
					CFGenKbToolSetBuff >> dictByTool3Idx
		= new HashMap< CFGenKbToolSetByTool3IdxKey,
				Map< CFGenKbToolSetPKey,
					CFGenKbToolSetBuff >>();
	private Map< CFGenKbToolSetByTool4IdxKey,
				Map< CFGenKbToolSetPKey,
					CFGenKbToolSetBuff >> dictByTool4Idx
		= new HashMap< CFGenKbToolSetByTool4IdxKey,
				Map< CFGenKbToolSetPKey,
					CFGenKbToolSetBuff >>();
	private Map< CFGenKbToolSetByTool5IdxKey,
				Map< CFGenKbToolSetPKey,
					CFGenKbToolSetBuff >> dictByTool5Idx
		= new HashMap< CFGenKbToolSetByTool5IdxKey,
				Map< CFGenKbToolSetPKey,
					CFGenKbToolSetBuff >>();
	private Map< CFGenKbToolSetByTool6IdxKey,
				Map< CFGenKbToolSetPKey,
					CFGenKbToolSetBuff >> dictByTool6Idx
		= new HashMap< CFGenKbToolSetByTool6IdxKey,
				Map< CFGenKbToolSetPKey,
					CFGenKbToolSetBuff >>();
	private Map< CFGenKbToolSetByTool7IdxKey,
				Map< CFGenKbToolSetPKey,
					CFGenKbToolSetBuff >> dictByTool7Idx
		= new HashMap< CFGenKbToolSetByTool7IdxKey,
				Map< CFGenKbToolSetPKey,
					CFGenKbToolSetBuff >>();

	public CFGenKbRamToolSetTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createToolSet( CFGenKbAuthorization Authorization,
		CFGenKbToolSetBuff Buff )
	{
		final String S_ProcName = "createToolSet";
		CFGenKbToolSetPKey pkey = schema.getFactoryToolSet().newPKey();
		pkey.setRequiredId( schema.nextToolSetIdGen() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFGenKbToolSetByNameIdxKey keyNameIdx = schema.getFactoryToolSet().newNameIdxKey();
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		CFGenKbToolSetByTool0IdxKey keyTool0Idx = schema.getFactoryToolSet().newTool0IdxKey();
		keyTool0Idx.setRequiredToolId0( Buff.getRequiredToolId0() );

		CFGenKbToolSetByTool1IdxKey keyTool1Idx = schema.getFactoryToolSet().newTool1IdxKey();
		keyTool1Idx.setOptionalToolId1( Buff.getOptionalToolId1() );

		CFGenKbToolSetByTool2IdxKey keyTool2Idx = schema.getFactoryToolSet().newTool2IdxKey();
		keyTool2Idx.setOptionalToolId2( Buff.getOptionalToolId2() );

		CFGenKbToolSetByTool3IdxKey keyTool3Idx = schema.getFactoryToolSet().newTool3IdxKey();
		keyTool3Idx.setOptionalToolId3( Buff.getOptionalToolId3() );

		CFGenKbToolSetByTool4IdxKey keyTool4Idx = schema.getFactoryToolSet().newTool4IdxKey();
		keyTool4Idx.setOptionalToolId4( Buff.getOptionalToolId4() );

		CFGenKbToolSetByTool5IdxKey keyTool5Idx = schema.getFactoryToolSet().newTool5IdxKey();
		keyTool5Idx.setOptionalToolId5( Buff.getOptionalToolId5() );

		CFGenKbToolSetByTool6IdxKey keyTool6Idx = schema.getFactoryToolSet().newTool6IdxKey();
		keyTool6Idx.setOptionalToolId6( Buff.getOptionalToolId6() );

		CFGenKbToolSetByTool7IdxKey keyTool7Idx = schema.getFactoryToolSet().newTool7IdxKey();
		keyTool7Idx.setOptionalToolId7( Buff.getOptionalToolId7() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw new CFLibUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ToolSetName",
				keyNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableTool().readDerivedByIdIdx( Authorization,
						Buff.getRequiredToolId0() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"Tool0",
						"Tool",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

		Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool0Idx;
		if( dictByTool0Idx.containsKey( keyTool0Idx ) ) {
			subdictTool0Idx = dictByTool0Idx.get( keyTool0Idx );
		}
		else {
			subdictTool0Idx = new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool0Idx.put( keyTool0Idx, subdictTool0Idx );
		}
		subdictTool0Idx.put( pkey, Buff );

		Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool1Idx;
		if( dictByTool1Idx.containsKey( keyTool1Idx ) ) {
			subdictTool1Idx = dictByTool1Idx.get( keyTool1Idx );
		}
		else {
			subdictTool1Idx = new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool1Idx.put( keyTool1Idx, subdictTool1Idx );
		}
		subdictTool1Idx.put( pkey, Buff );

		Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool2Idx;
		if( dictByTool2Idx.containsKey( keyTool2Idx ) ) {
			subdictTool2Idx = dictByTool2Idx.get( keyTool2Idx );
		}
		else {
			subdictTool2Idx = new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool2Idx.put( keyTool2Idx, subdictTool2Idx );
		}
		subdictTool2Idx.put( pkey, Buff );

		Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool3Idx;
		if( dictByTool3Idx.containsKey( keyTool3Idx ) ) {
			subdictTool3Idx = dictByTool3Idx.get( keyTool3Idx );
		}
		else {
			subdictTool3Idx = new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool3Idx.put( keyTool3Idx, subdictTool3Idx );
		}
		subdictTool3Idx.put( pkey, Buff );

		Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool4Idx;
		if( dictByTool4Idx.containsKey( keyTool4Idx ) ) {
			subdictTool4Idx = dictByTool4Idx.get( keyTool4Idx );
		}
		else {
			subdictTool4Idx = new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool4Idx.put( keyTool4Idx, subdictTool4Idx );
		}
		subdictTool4Idx.put( pkey, Buff );

		Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool5Idx;
		if( dictByTool5Idx.containsKey( keyTool5Idx ) ) {
			subdictTool5Idx = dictByTool5Idx.get( keyTool5Idx );
		}
		else {
			subdictTool5Idx = new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool5Idx.put( keyTool5Idx, subdictTool5Idx );
		}
		subdictTool5Idx.put( pkey, Buff );

		Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool6Idx;
		if( dictByTool6Idx.containsKey( keyTool6Idx ) ) {
			subdictTool6Idx = dictByTool6Idx.get( keyTool6Idx );
		}
		else {
			subdictTool6Idx = new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool6Idx.put( keyTool6Idx, subdictTool6Idx );
		}
		subdictTool6Idx.put( pkey, Buff );

		Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool7Idx;
		if( dictByTool7Idx.containsKey( keyTool7Idx ) ) {
			subdictTool7Idx = dictByTool7Idx.get( keyTool7Idx );
		}
		else {
			subdictTool7Idx = new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool7Idx.put( keyTool7Idx, subdictTool7Idx );
		}
		subdictTool7Idx.put( pkey, Buff );

	}

	public CFGenKbToolSetBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbToolSetPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readDerived";
		CFGenKbToolSetPKey key = schema.getFactoryToolSet().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFGenKbToolSetBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbToolSetBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbToolSetPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readDerived";
		CFGenKbToolSetPKey key = schema.getFactoryToolSet().newPKey();
		key.setRequiredId( PKey.getRequiredId() );
		CFGenKbToolSetBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbToolSetBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamToolSet.readAllDerived";
		CFGenKbToolSetBuff[] retList = new CFGenKbToolSetBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbToolSetBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbToolSetBuff readDerivedByNameIdx( CFGenKbAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readDerivedByNameIdx";
		CFGenKbToolSetByNameIdxKey key = schema.getFactoryToolSet().newNameIdxKey();
		key.setRequiredName( Name );

		CFGenKbToolSetBuff buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbToolSetBuff[] readDerivedByTool0Idx( CFGenKbAuthorization Authorization,
		short ToolId0 )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readDerivedByTool0Idx";
		CFGenKbToolSetByTool0IdxKey key = schema.getFactoryToolSet().newTool0IdxKey();
		key.setRequiredToolId0( ToolId0 );

		CFGenKbToolSetBuff[] recArray;
		if( dictByTool0Idx.containsKey( key ) ) {
			Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool0Idx
				= dictByTool0Idx.get( key );
			recArray = new CFGenKbToolSetBuff[ subdictTool0Idx.size() ];
			Iterator< CFGenKbToolSetBuff > iter = subdictTool0Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool0Idx
				= new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool0Idx.put( key, subdictTool0Idx );
			recArray = new CFGenKbToolSetBuff[0];
		}
		return( recArray );
	}

	public CFGenKbToolSetBuff[] readDerivedByTool1Idx( CFGenKbAuthorization Authorization,
		Short ToolId1 )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readDerivedByTool1Idx";
		CFGenKbToolSetByTool1IdxKey key = schema.getFactoryToolSet().newTool1IdxKey();
		key.setOptionalToolId1( ToolId1 );

		CFGenKbToolSetBuff[] recArray;
		if( dictByTool1Idx.containsKey( key ) ) {
			Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool1Idx
				= dictByTool1Idx.get( key );
			recArray = new CFGenKbToolSetBuff[ subdictTool1Idx.size() ];
			Iterator< CFGenKbToolSetBuff > iter = subdictTool1Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool1Idx
				= new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool1Idx.put( key, subdictTool1Idx );
			recArray = new CFGenKbToolSetBuff[0];
		}
		return( recArray );
	}

	public CFGenKbToolSetBuff[] readDerivedByTool2Idx( CFGenKbAuthorization Authorization,
		Short ToolId2 )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readDerivedByTool2Idx";
		CFGenKbToolSetByTool2IdxKey key = schema.getFactoryToolSet().newTool2IdxKey();
		key.setOptionalToolId2( ToolId2 );

		CFGenKbToolSetBuff[] recArray;
		if( dictByTool2Idx.containsKey( key ) ) {
			Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool2Idx
				= dictByTool2Idx.get( key );
			recArray = new CFGenKbToolSetBuff[ subdictTool2Idx.size() ];
			Iterator< CFGenKbToolSetBuff > iter = subdictTool2Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool2Idx
				= new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool2Idx.put( key, subdictTool2Idx );
			recArray = new CFGenKbToolSetBuff[0];
		}
		return( recArray );
	}

	public CFGenKbToolSetBuff[] readDerivedByTool3Idx( CFGenKbAuthorization Authorization,
		Short ToolId3 )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readDerivedByTool3Idx";
		CFGenKbToolSetByTool3IdxKey key = schema.getFactoryToolSet().newTool3IdxKey();
		key.setOptionalToolId3( ToolId3 );

		CFGenKbToolSetBuff[] recArray;
		if( dictByTool3Idx.containsKey( key ) ) {
			Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool3Idx
				= dictByTool3Idx.get( key );
			recArray = new CFGenKbToolSetBuff[ subdictTool3Idx.size() ];
			Iterator< CFGenKbToolSetBuff > iter = subdictTool3Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool3Idx
				= new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool3Idx.put( key, subdictTool3Idx );
			recArray = new CFGenKbToolSetBuff[0];
		}
		return( recArray );
	}

	public CFGenKbToolSetBuff[] readDerivedByTool4Idx( CFGenKbAuthorization Authorization,
		Short ToolId4 )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readDerivedByTool4Idx";
		CFGenKbToolSetByTool4IdxKey key = schema.getFactoryToolSet().newTool4IdxKey();
		key.setOptionalToolId4( ToolId4 );

		CFGenKbToolSetBuff[] recArray;
		if( dictByTool4Idx.containsKey( key ) ) {
			Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool4Idx
				= dictByTool4Idx.get( key );
			recArray = new CFGenKbToolSetBuff[ subdictTool4Idx.size() ];
			Iterator< CFGenKbToolSetBuff > iter = subdictTool4Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool4Idx
				= new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool4Idx.put( key, subdictTool4Idx );
			recArray = new CFGenKbToolSetBuff[0];
		}
		return( recArray );
	}

	public CFGenKbToolSetBuff[] readDerivedByTool5Idx( CFGenKbAuthorization Authorization,
		Short ToolId5 )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readDerivedByTool5Idx";
		CFGenKbToolSetByTool5IdxKey key = schema.getFactoryToolSet().newTool5IdxKey();
		key.setOptionalToolId5( ToolId5 );

		CFGenKbToolSetBuff[] recArray;
		if( dictByTool5Idx.containsKey( key ) ) {
			Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool5Idx
				= dictByTool5Idx.get( key );
			recArray = new CFGenKbToolSetBuff[ subdictTool5Idx.size() ];
			Iterator< CFGenKbToolSetBuff > iter = subdictTool5Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool5Idx
				= new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool5Idx.put( key, subdictTool5Idx );
			recArray = new CFGenKbToolSetBuff[0];
		}
		return( recArray );
	}

	public CFGenKbToolSetBuff[] readDerivedByTool6Idx( CFGenKbAuthorization Authorization,
		Short ToolId6 )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readDerivedByTool6Idx";
		CFGenKbToolSetByTool6IdxKey key = schema.getFactoryToolSet().newTool6IdxKey();
		key.setOptionalToolId6( ToolId6 );

		CFGenKbToolSetBuff[] recArray;
		if( dictByTool6Idx.containsKey( key ) ) {
			Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool6Idx
				= dictByTool6Idx.get( key );
			recArray = new CFGenKbToolSetBuff[ subdictTool6Idx.size() ];
			Iterator< CFGenKbToolSetBuff > iter = subdictTool6Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool6Idx
				= new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool6Idx.put( key, subdictTool6Idx );
			recArray = new CFGenKbToolSetBuff[0];
		}
		return( recArray );
	}

	public CFGenKbToolSetBuff[] readDerivedByTool7Idx( CFGenKbAuthorization Authorization,
		Short ToolId7 )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readDerivedByTool7Idx";
		CFGenKbToolSetByTool7IdxKey key = schema.getFactoryToolSet().newTool7IdxKey();
		key.setOptionalToolId7( ToolId7 );

		CFGenKbToolSetBuff[] recArray;
		if( dictByTool7Idx.containsKey( key ) ) {
			Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool7Idx
				= dictByTool7Idx.get( key );
			recArray = new CFGenKbToolSetBuff[ subdictTool7Idx.size() ];
			Iterator< CFGenKbToolSetBuff > iter = subdictTool7Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdictTool7Idx
				= new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool7Idx.put( key, subdictTool7Idx );
			recArray = new CFGenKbToolSetBuff[0];
		}
		return( recArray );
	}

	public CFGenKbToolSetBuff readDerivedByIdIdx( CFGenKbAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readDerivedByIdIdx() ";
		CFGenKbToolSetPKey key = schema.getFactoryToolSet().newPKey();
		key.setRequiredId( Id );

		CFGenKbToolSetBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbToolSetBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbToolSetPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readBuff";
		CFGenKbToolSetBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TLS" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbToolSetBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbToolSetPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbToolSetBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TLS" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbToolSetBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readAllBuff";
		CFGenKbToolSetBuff buff;
		ArrayList<CFGenKbToolSetBuff> filteredList = new ArrayList<CFGenKbToolSetBuff>();
		CFGenKbToolSetBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TLS" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbToolSetBuff[0] ) );
	}

	public CFGenKbToolSetBuff readBuffByIdIdx( CFGenKbAuthorization Authorization,
		short Id )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readBuffByIdIdx() ";
		CFGenKbToolSetBuff buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "TLS" ) ) {
			return( (CFGenKbToolSetBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbToolSetBuff readBuffByNameIdx( CFGenKbAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readBuffByNameIdx() ";
		CFGenKbToolSetBuff buff = readDerivedByNameIdx( Authorization,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "TLS" ) ) {
			return( (CFGenKbToolSetBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbToolSetBuff[] readBuffByTool0Idx( CFGenKbAuthorization Authorization,
		short ToolId0 )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readBuffByTool0Idx() ";
		CFGenKbToolSetBuff buff;
		ArrayList<CFGenKbToolSetBuff> filteredList = new ArrayList<CFGenKbToolSetBuff>();
		CFGenKbToolSetBuff[] buffList = readDerivedByTool0Idx( Authorization,
			ToolId0 );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TLS" ) ) {
				filteredList.add( (CFGenKbToolSetBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbToolSetBuff[0] ) );
	}

	public CFGenKbToolSetBuff[] readBuffByTool1Idx( CFGenKbAuthorization Authorization,
		Short ToolId1 )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readBuffByTool1Idx() ";
		CFGenKbToolSetBuff buff;
		ArrayList<CFGenKbToolSetBuff> filteredList = new ArrayList<CFGenKbToolSetBuff>();
		CFGenKbToolSetBuff[] buffList = readDerivedByTool1Idx( Authorization,
			ToolId1 );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TLS" ) ) {
				filteredList.add( (CFGenKbToolSetBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbToolSetBuff[0] ) );
	}

	public CFGenKbToolSetBuff[] readBuffByTool2Idx( CFGenKbAuthorization Authorization,
		Short ToolId2 )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readBuffByTool2Idx() ";
		CFGenKbToolSetBuff buff;
		ArrayList<CFGenKbToolSetBuff> filteredList = new ArrayList<CFGenKbToolSetBuff>();
		CFGenKbToolSetBuff[] buffList = readDerivedByTool2Idx( Authorization,
			ToolId2 );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TLS" ) ) {
				filteredList.add( (CFGenKbToolSetBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbToolSetBuff[0] ) );
	}

	public CFGenKbToolSetBuff[] readBuffByTool3Idx( CFGenKbAuthorization Authorization,
		Short ToolId3 )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readBuffByTool3Idx() ";
		CFGenKbToolSetBuff buff;
		ArrayList<CFGenKbToolSetBuff> filteredList = new ArrayList<CFGenKbToolSetBuff>();
		CFGenKbToolSetBuff[] buffList = readDerivedByTool3Idx( Authorization,
			ToolId3 );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TLS" ) ) {
				filteredList.add( (CFGenKbToolSetBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbToolSetBuff[0] ) );
	}

	public CFGenKbToolSetBuff[] readBuffByTool4Idx( CFGenKbAuthorization Authorization,
		Short ToolId4 )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readBuffByTool4Idx() ";
		CFGenKbToolSetBuff buff;
		ArrayList<CFGenKbToolSetBuff> filteredList = new ArrayList<CFGenKbToolSetBuff>();
		CFGenKbToolSetBuff[] buffList = readDerivedByTool4Idx( Authorization,
			ToolId4 );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TLS" ) ) {
				filteredList.add( (CFGenKbToolSetBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbToolSetBuff[0] ) );
	}

	public CFGenKbToolSetBuff[] readBuffByTool5Idx( CFGenKbAuthorization Authorization,
		Short ToolId5 )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readBuffByTool5Idx() ";
		CFGenKbToolSetBuff buff;
		ArrayList<CFGenKbToolSetBuff> filteredList = new ArrayList<CFGenKbToolSetBuff>();
		CFGenKbToolSetBuff[] buffList = readDerivedByTool5Idx( Authorization,
			ToolId5 );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TLS" ) ) {
				filteredList.add( (CFGenKbToolSetBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbToolSetBuff[0] ) );
	}

	public CFGenKbToolSetBuff[] readBuffByTool6Idx( CFGenKbAuthorization Authorization,
		Short ToolId6 )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readBuffByTool6Idx() ";
		CFGenKbToolSetBuff buff;
		ArrayList<CFGenKbToolSetBuff> filteredList = new ArrayList<CFGenKbToolSetBuff>();
		CFGenKbToolSetBuff[] buffList = readDerivedByTool6Idx( Authorization,
			ToolId6 );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TLS" ) ) {
				filteredList.add( (CFGenKbToolSetBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbToolSetBuff[0] ) );
	}

	public CFGenKbToolSetBuff[] readBuffByTool7Idx( CFGenKbAuthorization Authorization,
		Short ToolId7 )
	{
		final String S_ProcName = "CFGenKbRamToolSet.readBuffByTool7Idx() ";
		CFGenKbToolSetBuff buff;
		ArrayList<CFGenKbToolSetBuff> filteredList = new ArrayList<CFGenKbToolSetBuff>();
		CFGenKbToolSetBuff[] buffList = readDerivedByTool7Idx( Authorization,
			ToolId7 );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TLS" ) ) {
				filteredList.add( (CFGenKbToolSetBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbToolSetBuff[0] ) );
	}

	public void updateToolSet( CFGenKbAuthorization Authorization,
		CFGenKbToolSetBuff Buff )
	{
		CFGenKbToolSetPKey pkey = schema.getFactoryToolSet().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFGenKbToolSetBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateToolSet",
				"Existing record not found",
				"ToolSet",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new CFLibCollisionDetectedException( getClass(),
				"updateToolSet",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFGenKbToolSetByNameIdxKey existingKeyNameIdx = schema.getFactoryToolSet().newNameIdxKey();
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		CFGenKbToolSetByNameIdxKey newKeyNameIdx = schema.getFactoryToolSet().newNameIdxKey();
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		CFGenKbToolSetByTool0IdxKey existingKeyTool0Idx = schema.getFactoryToolSet().newTool0IdxKey();
		existingKeyTool0Idx.setRequiredToolId0( existing.getRequiredToolId0() );

		CFGenKbToolSetByTool0IdxKey newKeyTool0Idx = schema.getFactoryToolSet().newTool0IdxKey();
		newKeyTool0Idx.setRequiredToolId0( Buff.getRequiredToolId0() );

		CFGenKbToolSetByTool1IdxKey existingKeyTool1Idx = schema.getFactoryToolSet().newTool1IdxKey();
		existingKeyTool1Idx.setOptionalToolId1( existing.getOptionalToolId1() );

		CFGenKbToolSetByTool1IdxKey newKeyTool1Idx = schema.getFactoryToolSet().newTool1IdxKey();
		newKeyTool1Idx.setOptionalToolId1( Buff.getOptionalToolId1() );

		CFGenKbToolSetByTool2IdxKey existingKeyTool2Idx = schema.getFactoryToolSet().newTool2IdxKey();
		existingKeyTool2Idx.setOptionalToolId2( existing.getOptionalToolId2() );

		CFGenKbToolSetByTool2IdxKey newKeyTool2Idx = schema.getFactoryToolSet().newTool2IdxKey();
		newKeyTool2Idx.setOptionalToolId2( Buff.getOptionalToolId2() );

		CFGenKbToolSetByTool3IdxKey existingKeyTool3Idx = schema.getFactoryToolSet().newTool3IdxKey();
		existingKeyTool3Idx.setOptionalToolId3( existing.getOptionalToolId3() );

		CFGenKbToolSetByTool3IdxKey newKeyTool3Idx = schema.getFactoryToolSet().newTool3IdxKey();
		newKeyTool3Idx.setOptionalToolId3( Buff.getOptionalToolId3() );

		CFGenKbToolSetByTool4IdxKey existingKeyTool4Idx = schema.getFactoryToolSet().newTool4IdxKey();
		existingKeyTool4Idx.setOptionalToolId4( existing.getOptionalToolId4() );

		CFGenKbToolSetByTool4IdxKey newKeyTool4Idx = schema.getFactoryToolSet().newTool4IdxKey();
		newKeyTool4Idx.setOptionalToolId4( Buff.getOptionalToolId4() );

		CFGenKbToolSetByTool5IdxKey existingKeyTool5Idx = schema.getFactoryToolSet().newTool5IdxKey();
		existingKeyTool5Idx.setOptionalToolId5( existing.getOptionalToolId5() );

		CFGenKbToolSetByTool5IdxKey newKeyTool5Idx = schema.getFactoryToolSet().newTool5IdxKey();
		newKeyTool5Idx.setOptionalToolId5( Buff.getOptionalToolId5() );

		CFGenKbToolSetByTool6IdxKey existingKeyTool6Idx = schema.getFactoryToolSet().newTool6IdxKey();
		existingKeyTool6Idx.setOptionalToolId6( existing.getOptionalToolId6() );

		CFGenKbToolSetByTool6IdxKey newKeyTool6Idx = schema.getFactoryToolSet().newTool6IdxKey();
		newKeyTool6Idx.setOptionalToolId6( Buff.getOptionalToolId6() );

		CFGenKbToolSetByTool7IdxKey existingKeyTool7Idx = schema.getFactoryToolSet().newTool7IdxKey();
		existingKeyTool7Idx.setOptionalToolId7( existing.getOptionalToolId7() );

		CFGenKbToolSetByTool7IdxKey newKeyTool7Idx = schema.getFactoryToolSet().newTool7IdxKey();
		newKeyTool7Idx.setOptionalToolId7( Buff.getOptionalToolId7() );

		// Check unique indexes

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw new CFLibUniqueIndexViolationException( getClass(),
					"updateToolSet",
					"ToolSetName",
					newKeyNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTool().readDerivedByIdIdx( Authorization,
						Buff.getRequiredToolId0() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateToolSet",
						"Lookup",
						"Tool0",
						"Tool",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

		subdict = dictByTool0Idx.get( existingKeyTool0Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTool0Idx.containsKey( newKeyTool0Idx ) ) {
			subdict = dictByTool0Idx.get( newKeyTool0Idx );
		}
		else {
			subdict = new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool0Idx.put( newKeyTool0Idx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByTool1Idx.get( existingKeyTool1Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTool1Idx.containsKey( newKeyTool1Idx ) ) {
			subdict = dictByTool1Idx.get( newKeyTool1Idx );
		}
		else {
			subdict = new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool1Idx.put( newKeyTool1Idx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByTool2Idx.get( existingKeyTool2Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTool2Idx.containsKey( newKeyTool2Idx ) ) {
			subdict = dictByTool2Idx.get( newKeyTool2Idx );
		}
		else {
			subdict = new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool2Idx.put( newKeyTool2Idx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByTool3Idx.get( existingKeyTool3Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTool3Idx.containsKey( newKeyTool3Idx ) ) {
			subdict = dictByTool3Idx.get( newKeyTool3Idx );
		}
		else {
			subdict = new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool3Idx.put( newKeyTool3Idx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByTool4Idx.get( existingKeyTool4Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTool4Idx.containsKey( newKeyTool4Idx ) ) {
			subdict = dictByTool4Idx.get( newKeyTool4Idx );
		}
		else {
			subdict = new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool4Idx.put( newKeyTool4Idx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByTool5Idx.get( existingKeyTool5Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTool5Idx.containsKey( newKeyTool5Idx ) ) {
			subdict = dictByTool5Idx.get( newKeyTool5Idx );
		}
		else {
			subdict = new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool5Idx.put( newKeyTool5Idx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByTool6Idx.get( existingKeyTool6Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTool6Idx.containsKey( newKeyTool6Idx ) ) {
			subdict = dictByTool6Idx.get( newKeyTool6Idx );
		}
		else {
			subdict = new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool6Idx.put( newKeyTool6Idx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByTool7Idx.get( existingKeyTool7Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTool7Idx.containsKey( newKeyTool7Idx ) ) {
			subdict = dictByTool7Idx.get( newKeyTool7Idx );
		}
		else {
			subdict = new HashMap< CFGenKbToolSetPKey, CFGenKbToolSetBuff >();
			dictByTool7Idx.put( newKeyTool7Idx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteToolSet( CFGenKbAuthorization Authorization,
		CFGenKbToolSetBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamToolSetTable.deleteToolSet() ";
		String classCode;
		CFGenKbToolSetPKey pkey = schema.getFactoryToolSet().newPKey();
		pkey.setRequiredId( Buff.getRequiredId() );
		CFGenKbToolSetBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteToolSet",
				pkey );
		}
		CFGenKbToolSetByNameIdxKey keyNameIdx = schema.getFactoryToolSet().newNameIdxKey();
		keyNameIdx.setRequiredName( existing.getRequiredName() );

		CFGenKbToolSetByTool0IdxKey keyTool0Idx = schema.getFactoryToolSet().newTool0IdxKey();
		keyTool0Idx.setRequiredToolId0( existing.getRequiredToolId0() );

		CFGenKbToolSetByTool1IdxKey keyTool1Idx = schema.getFactoryToolSet().newTool1IdxKey();
		keyTool1Idx.setOptionalToolId1( existing.getOptionalToolId1() );

		CFGenKbToolSetByTool2IdxKey keyTool2Idx = schema.getFactoryToolSet().newTool2IdxKey();
		keyTool2Idx.setOptionalToolId2( existing.getOptionalToolId2() );

		CFGenKbToolSetByTool3IdxKey keyTool3Idx = schema.getFactoryToolSet().newTool3IdxKey();
		keyTool3Idx.setOptionalToolId3( existing.getOptionalToolId3() );

		CFGenKbToolSetByTool4IdxKey keyTool4Idx = schema.getFactoryToolSet().newTool4IdxKey();
		keyTool4Idx.setOptionalToolId4( existing.getOptionalToolId4() );

		CFGenKbToolSetByTool5IdxKey keyTool5Idx = schema.getFactoryToolSet().newTool5IdxKey();
		keyTool5Idx.setOptionalToolId5( existing.getOptionalToolId5() );

		CFGenKbToolSetByTool6IdxKey keyTool6Idx = schema.getFactoryToolSet().newTool6IdxKey();
		keyTool6Idx.setOptionalToolId6( existing.getOptionalToolId6() );

		CFGenKbToolSetByTool7IdxKey keyTool7Idx = schema.getFactoryToolSet().newTool7IdxKey();
		keyTool7Idx.setOptionalToolId7( existing.getOptionalToolId7() );

		// Validate reverse foreign keys

		if( schema.getTableGenItem().readDerivedByToolSetIdx( Authorization,
					existing.getRequiredId() ).length > 0 )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteToolSet",
				"Lookup",
				"ToolSet",
				"GenItem",
				pkey );
		}

		// Delete is valid
		Map< CFGenKbToolSetPKey, CFGenKbToolSetBuff > subdict;

		dictByPKey.remove( pkey );

		dictByNameIdx.remove( keyNameIdx );

		subdict = dictByTool0Idx.get( keyTool0Idx );
		subdict.remove( pkey );

		subdict = dictByTool1Idx.get( keyTool1Idx );
		subdict.remove( pkey );

		subdict = dictByTool2Idx.get( keyTool2Idx );
		subdict.remove( pkey );

		subdict = dictByTool3Idx.get( keyTool3Idx );
		subdict.remove( pkey );

		subdict = dictByTool4Idx.get( keyTool4Idx );
		subdict.remove( pkey );

		subdict = dictByTool5Idx.get( keyTool5Idx );
		subdict.remove( pkey );

		subdict = dictByTool6Idx.get( keyTool6Idx );
		subdict.remove( pkey );

		subdict = dictByTool7Idx.get( keyTool7Idx );
		subdict.remove( pkey );

	}
	public void deleteToolSetByIdIdx( CFGenKbAuthorization Authorization,
		short argId )
	{
		CFGenKbToolSetPKey key = schema.getFactoryToolSet().newPKey();
		key.setRequiredId( argId );
		deleteToolSetByIdIdx( Authorization, key );
	}

	public void deleteToolSetByIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbToolSetBuff cur;
		LinkedList<CFGenKbToolSetBuff> matchSet = new LinkedList<CFGenKbToolSetBuff>();
		Iterator<CFGenKbToolSetBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbToolSetBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableToolSet().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteToolSet( Authorization, cur );
		}
	}

	public void deleteToolSetByNameIdx( CFGenKbAuthorization Authorization,
		String argName )
	{
		CFGenKbToolSetByNameIdxKey key = schema.getFactoryToolSet().newNameIdxKey();
		key.setRequiredName( argName );
		deleteToolSetByNameIdx( Authorization, key );
	}

	public void deleteToolSetByNameIdx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetByNameIdxKey argKey )
	{
		CFGenKbToolSetBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbToolSetBuff> matchSet = new LinkedList<CFGenKbToolSetBuff>();
		Iterator<CFGenKbToolSetBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbToolSetBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableToolSet().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteToolSet( Authorization, cur );
		}
	}

	public void deleteToolSetByTool0Idx( CFGenKbAuthorization Authorization,
		short argToolId0 )
	{
		CFGenKbToolSetByTool0IdxKey key = schema.getFactoryToolSet().newTool0IdxKey();
		key.setRequiredToolId0( argToolId0 );
		deleteToolSetByTool0Idx( Authorization, key );
	}

	public void deleteToolSetByTool0Idx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetByTool0IdxKey argKey )
	{
		CFGenKbToolSetBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbToolSetBuff> matchSet = new LinkedList<CFGenKbToolSetBuff>();
		Iterator<CFGenKbToolSetBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbToolSetBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableToolSet().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteToolSet( Authorization, cur );
		}
	}

	public void deleteToolSetByTool1Idx( CFGenKbAuthorization Authorization,
		Short argToolId1 )
	{
		CFGenKbToolSetByTool1IdxKey key = schema.getFactoryToolSet().newTool1IdxKey();
		key.setOptionalToolId1( argToolId1 );
		deleteToolSetByTool1Idx( Authorization, key );
	}

	public void deleteToolSetByTool1Idx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetByTool1IdxKey argKey )
	{
		CFGenKbToolSetBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalToolId1() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbToolSetBuff> matchSet = new LinkedList<CFGenKbToolSetBuff>();
		Iterator<CFGenKbToolSetBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbToolSetBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableToolSet().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteToolSet( Authorization, cur );
		}
	}

	public void deleteToolSetByTool2Idx( CFGenKbAuthorization Authorization,
		Short argToolId2 )
	{
		CFGenKbToolSetByTool2IdxKey key = schema.getFactoryToolSet().newTool2IdxKey();
		key.setOptionalToolId2( argToolId2 );
		deleteToolSetByTool2Idx( Authorization, key );
	}

	public void deleteToolSetByTool2Idx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetByTool2IdxKey argKey )
	{
		CFGenKbToolSetBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalToolId2() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbToolSetBuff> matchSet = new LinkedList<CFGenKbToolSetBuff>();
		Iterator<CFGenKbToolSetBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbToolSetBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableToolSet().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteToolSet( Authorization, cur );
		}
	}

	public void deleteToolSetByTool3Idx( CFGenKbAuthorization Authorization,
		Short argToolId3 )
	{
		CFGenKbToolSetByTool3IdxKey key = schema.getFactoryToolSet().newTool3IdxKey();
		key.setOptionalToolId3( argToolId3 );
		deleteToolSetByTool3Idx( Authorization, key );
	}

	public void deleteToolSetByTool3Idx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetByTool3IdxKey argKey )
	{
		CFGenKbToolSetBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalToolId3() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbToolSetBuff> matchSet = new LinkedList<CFGenKbToolSetBuff>();
		Iterator<CFGenKbToolSetBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbToolSetBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableToolSet().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteToolSet( Authorization, cur );
		}
	}

	public void deleteToolSetByTool4Idx( CFGenKbAuthorization Authorization,
		Short argToolId4 )
	{
		CFGenKbToolSetByTool4IdxKey key = schema.getFactoryToolSet().newTool4IdxKey();
		key.setOptionalToolId4( argToolId4 );
		deleteToolSetByTool4Idx( Authorization, key );
	}

	public void deleteToolSetByTool4Idx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetByTool4IdxKey argKey )
	{
		CFGenKbToolSetBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalToolId4() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbToolSetBuff> matchSet = new LinkedList<CFGenKbToolSetBuff>();
		Iterator<CFGenKbToolSetBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbToolSetBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableToolSet().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteToolSet( Authorization, cur );
		}
	}

	public void deleteToolSetByTool5Idx( CFGenKbAuthorization Authorization,
		Short argToolId5 )
	{
		CFGenKbToolSetByTool5IdxKey key = schema.getFactoryToolSet().newTool5IdxKey();
		key.setOptionalToolId5( argToolId5 );
		deleteToolSetByTool5Idx( Authorization, key );
	}

	public void deleteToolSetByTool5Idx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetByTool5IdxKey argKey )
	{
		CFGenKbToolSetBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalToolId5() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbToolSetBuff> matchSet = new LinkedList<CFGenKbToolSetBuff>();
		Iterator<CFGenKbToolSetBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbToolSetBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableToolSet().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteToolSet( Authorization, cur );
		}
	}

	public void deleteToolSetByTool6Idx( CFGenKbAuthorization Authorization,
		Short argToolId6 )
	{
		CFGenKbToolSetByTool6IdxKey key = schema.getFactoryToolSet().newTool6IdxKey();
		key.setOptionalToolId6( argToolId6 );
		deleteToolSetByTool6Idx( Authorization, key );
	}

	public void deleteToolSetByTool6Idx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetByTool6IdxKey argKey )
	{
		CFGenKbToolSetBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalToolId6() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbToolSetBuff> matchSet = new LinkedList<CFGenKbToolSetBuff>();
		Iterator<CFGenKbToolSetBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbToolSetBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableToolSet().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteToolSet( Authorization, cur );
		}
	}

	public void deleteToolSetByTool7Idx( CFGenKbAuthorization Authorization,
		Short argToolId7 )
	{
		CFGenKbToolSetByTool7IdxKey key = schema.getFactoryToolSet().newTool7IdxKey();
		key.setOptionalToolId7( argToolId7 );
		deleteToolSetByTool7Idx( Authorization, key );
	}

	public void deleteToolSetByTool7Idx( CFGenKbAuthorization Authorization,
		CFGenKbToolSetByTool7IdxKey argKey )
	{
		CFGenKbToolSetBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalToolId7() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbToolSetBuff> matchSet = new LinkedList<CFGenKbToolSetBuff>();
		Iterator<CFGenKbToolSetBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbToolSetBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableToolSet().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() );
			deleteToolSet( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
