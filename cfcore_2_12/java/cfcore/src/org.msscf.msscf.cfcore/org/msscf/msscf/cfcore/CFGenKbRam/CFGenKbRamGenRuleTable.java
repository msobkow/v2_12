
// Description: Java 11 in-memory RAM DbIO implementation for GenRule.

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
 *	CFGenKbRamGenRuleTable in-memory RAM DbIO implementation
 *	for GenRule.
 */
public class CFGenKbRamGenRuleTable
	implements ICFGenKbGenRuleTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGenItemPKey,
				CFGenKbGenRuleBuff > dictByPKey
		= new HashMap< CFGenKbGenItemPKey,
				CFGenKbGenRuleBuff >();
	private Map< CFGenKbGenRuleByBodyIdxKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenRuleBuff >> dictByBodyIdx
		= new HashMap< CFGenKbGenRuleByBodyIdxKey,
				Map< CFGenKbGenItemPKey,
					CFGenKbGenRuleBuff >>();

	public CFGenKbRamGenRuleTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGenRule( CFGenKbAuthorization Authorization,
		CFGenKbGenRuleBuff Buff )
	{
		final String S_ProcName = "createGenRule";
		schema.getTableGenItem().createGenItem( Authorization,
			Buff );
		CFGenKbGenItemPKey pkey = schema.getFactoryGenItem().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );
		pkey.setRequiredItemId( Buff.getRequiredItemId() );
		CFGenKbGenRuleByBodyIdxKey keyBodyIdx = schema.getFactoryGenRule().newBodyIdxKey();
		keyBodyIdx.setOptionalBodyTenantId( Buff.getOptionalBodyTenantId() );
		keyBodyIdx.setOptionalBodyGelCacheId( Buff.getOptionalBodyGelCacheId() );
		keyBodyIdx.setOptionalBodyGelId( Buff.getOptionalBodyGelId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableGenItem().readDerivedByItemIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredCartridgeId(),
						Buff.getRequiredItemId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"GenItem",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbGenItemPKey, CFGenKbGenRuleBuff > subdictBodyIdx;
		if( dictByBodyIdx.containsKey( keyBodyIdx ) ) {
			subdictBodyIdx = dictByBodyIdx.get( keyBodyIdx );
		}
		else {
			subdictBodyIdx = new HashMap< CFGenKbGenItemPKey, CFGenKbGenRuleBuff >();
			dictByBodyIdx.put( keyBodyIdx, subdictBodyIdx );
		}
		subdictBodyIdx.put( pkey, Buff );

	}

	public CFGenKbGenRuleBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGenRule.readDerived";
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredCartridgeId( PKey.getRequiredCartridgeId() );
		key.setRequiredItemId( PKey.getRequiredItemId() );
		CFGenKbGenRuleBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenRuleBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGenRule.readDerived";
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredCartridgeId( PKey.getRequiredCartridgeId() );
		key.setRequiredItemId( PKey.getRequiredItemId() );
		CFGenKbGenRuleBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenRuleBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGenRule.readAllDerived";
		CFGenKbGenRuleBuff[] retList = new CFGenKbGenRuleBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGenRuleBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGenRuleBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByTenantIdx";
		CFGenKbGenItemBuff buffList[] = schema.getTableGenItem().readDerivedByTenantIdx( Authorization,
			TenantId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGenItemBuff buff;
			ArrayList<CFGenKbGenRuleBuff> filteredList = new ArrayList<CFGenKbGenRuleBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenRuleBuff ) ) {
					filteredList.add( (CFGenKbGenRuleBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenRuleBuff[0] ) );
		}
	}

	public CFGenKbGenRuleBuff[] readDerivedByCartIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByCartIdx";
		CFGenKbGenItemBuff buffList[] = schema.getTableGenItem().readDerivedByCartIdx( Authorization,
			TenantId,
			CartridgeId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGenItemBuff buff;
			ArrayList<CFGenKbGenRuleBuff> filteredList = new ArrayList<CFGenKbGenRuleBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenRuleBuff ) ) {
					filteredList.add( (CFGenKbGenRuleBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenRuleBuff[0] ) );
		}
	}

	public CFGenKbGenRuleBuff[] readDerivedByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short RuleTypeId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByRuleTypeIdx";
		CFGenKbGenItemBuff buffList[] = schema.getTableGenItem().readDerivedByRuleTypeIdx( Authorization,
			RuleTypeId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGenItemBuff buff;
			ArrayList<CFGenKbGenRuleBuff> filteredList = new ArrayList<CFGenKbGenRuleBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenRuleBuff ) ) {
					filteredList.add( (CFGenKbGenRuleBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenRuleBuff[0] ) );
		}
	}

	public CFGenKbGenRuleBuff[] readDerivedByToolSetIdx( CFGenKbAuthorization Authorization,
		short ToolSetId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByToolSetIdx";
		CFGenKbGenItemBuff buffList[] = schema.getTableGenItem().readDerivedByToolSetIdx( Authorization,
			ToolSetId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGenItemBuff buff;
			ArrayList<CFGenKbGenRuleBuff> filteredList = new ArrayList<CFGenKbGenRuleBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenRuleBuff ) ) {
					filteredList.add( (CFGenKbGenRuleBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenRuleBuff[0] ) );
		}
	}

	public CFGenKbGenRuleBuff[] readDerivedByScopeIdx( CFGenKbAuthorization Authorization,
		Short ScopeDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByScopeIdx";
		CFGenKbGenItemBuff buffList[] = schema.getTableGenItem().readDerivedByScopeIdx( Authorization,
			ScopeDefId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGenItemBuff buff;
			ArrayList<CFGenKbGenRuleBuff> filteredList = new ArrayList<CFGenKbGenRuleBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenRuleBuff ) ) {
					filteredList.add( (CFGenKbGenRuleBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenRuleBuff[0] ) );
		}
	}

	public CFGenKbGenRuleBuff[] readDerivedByGenDefIdx( CFGenKbAuthorization Authorization,
		short GenDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByGenDefIdx";
		CFGenKbGenItemBuff buffList[] = schema.getTableGenItem().readDerivedByGenDefIdx( Authorization,
			GenDefId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGenItemBuff buff;
			ArrayList<CFGenKbGenRuleBuff> filteredList = new ArrayList<CFGenKbGenRuleBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenRuleBuff ) ) {
					filteredList.add( (CFGenKbGenRuleBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenRuleBuff[0] ) );
		}
	}

	public CFGenKbGenRuleBuff readDerivedByAltIdx( CFGenKbAuthorization Authorization,
		String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByAltIdx";
		CFGenKbGenItemBuff buff = schema.getTableGenItem().readDerivedByAltIdx( Authorization,
			Name,
			ToolSetId,
			ScopeDefId,
			GenDefId );
		if( buff == null ) {
			return( null );
		}
		else if( buff instanceof CFGenKbGenRuleBuff ) {
			return( (CFGenKbGenRuleBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGenRuleBuff[] readDerivedByGelExecIdx( CFGenKbAuthorization Authorization,
		Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByGelExecIdx";
		CFGenKbGenItemBuff buffList[] = schema.getTableGenItem().readDerivedByGelExecIdx( Authorization,
			GelExecutableTenantId,
			GelExecutableGelCacheId,
			GelExecutableId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGenItemBuff buff;
			ArrayList<CFGenKbGenRuleBuff> filteredList = new ArrayList<CFGenKbGenRuleBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenRuleBuff ) ) {
					filteredList.add( (CFGenKbGenRuleBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenRuleBuff[0] ) );
		}
	}

	public CFGenKbGenRuleBuff[] readDerivedByProbeIdx( CFGenKbAuthorization Authorization,
		Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByProbeIdx";
		CFGenKbGenItemBuff buffList[] = schema.getTableGenItem().readDerivedByProbeIdx( Authorization,
			ProbeTenantId,
			ProbeCartridgeId,
			ProbeGenItemId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGenItemBuff buff;
			ArrayList<CFGenKbGenRuleBuff> filteredList = new ArrayList<CFGenKbGenRuleBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenRuleBuff ) ) {
					filteredList.add( (CFGenKbGenRuleBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenRuleBuff[0] ) );
		}
	}

	public CFGenKbGenRuleBuff[] readDerivedByBodyIdx( CFGenKbAuthorization Authorization,
		Long BodyTenantId,
		Long BodyGelCacheId,
		Long BodyGelId )
	{
		final String S_ProcName = "CFGenKbRamGenRule.readDerivedByBodyIdx";
		CFGenKbGenRuleByBodyIdxKey key = schema.getFactoryGenRule().newBodyIdxKey();
		key.setOptionalBodyTenantId( BodyTenantId );
		key.setOptionalBodyGelCacheId( BodyGelCacheId );
		key.setOptionalBodyGelId( BodyGelId );

		CFGenKbGenRuleBuff[] recArray;
		if( dictByBodyIdx.containsKey( key ) ) {
			Map< CFGenKbGenItemPKey, CFGenKbGenRuleBuff > subdictBodyIdx
				= dictByBodyIdx.get( key );
			recArray = new CFGenKbGenRuleBuff[ subdictBodyIdx.size() ];
			Iterator< CFGenKbGenRuleBuff > iter = subdictBodyIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGenItemPKey, CFGenKbGenRuleBuff > subdictBodyIdx
				= new HashMap< CFGenKbGenItemPKey, CFGenKbGenRuleBuff >();
			dictByBodyIdx.put( key, subdictBodyIdx );
			recArray = new CFGenKbGenRuleBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGenRuleBuff readDerivedByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByItemIdIdx() ";
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCartridgeId( CartridgeId );
		key.setRequiredItemId( ItemId );

		CFGenKbGenRuleBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenRuleBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGenRule.readBuff";
		CFGenKbGenRuleBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "RUL" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenRuleBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGenRuleBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "RUL" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenRuleBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGenRule.readAllBuff";
		CFGenKbGenRuleBuff buff;
		ArrayList<CFGenKbGenRuleBuff> filteredList = new ArrayList<CFGenKbGenRuleBuff>();
		CFGenKbGenRuleBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RUL" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenRuleBuff[0] ) );
	}

	public CFGenKbGenRuleBuff readBuffByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByItemIdIdx() ";
		CFGenKbGenRuleBuff buff = readDerivedByItemIdIdx( Authorization,
			TenantId,
			CartridgeId,
			ItemId );
		if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
			return( (CFGenKbGenRuleBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGenRuleBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByTenantIdx() ";
		CFGenKbGenRuleBuff buff;
		ArrayList<CFGenKbGenRuleBuff> filteredList = new ArrayList<CFGenKbGenRuleBuff>();
		CFGenKbGenRuleBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenRuleBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenRuleBuff[0] ) );
	}

	public CFGenKbGenRuleBuff[] readBuffByCartIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByCartIdx() ";
		CFGenKbGenRuleBuff buff;
		ArrayList<CFGenKbGenRuleBuff> filteredList = new ArrayList<CFGenKbGenRuleBuff>();
		CFGenKbGenRuleBuff[] buffList = readDerivedByCartIdx( Authorization,
			TenantId,
			CartridgeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenRuleBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenRuleBuff[0] ) );
	}

	public CFGenKbGenRuleBuff[] readBuffByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short RuleTypeId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByRuleTypeIdx() ";
		CFGenKbGenRuleBuff buff;
		ArrayList<CFGenKbGenRuleBuff> filteredList = new ArrayList<CFGenKbGenRuleBuff>();
		CFGenKbGenRuleBuff[] buffList = readDerivedByRuleTypeIdx( Authorization,
			RuleTypeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenRuleBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenRuleBuff[0] ) );
	}

	public CFGenKbGenRuleBuff[] readBuffByToolSetIdx( CFGenKbAuthorization Authorization,
		short ToolSetId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByToolSetIdx() ";
		CFGenKbGenRuleBuff buff;
		ArrayList<CFGenKbGenRuleBuff> filteredList = new ArrayList<CFGenKbGenRuleBuff>();
		CFGenKbGenRuleBuff[] buffList = readDerivedByToolSetIdx( Authorization,
			ToolSetId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenRuleBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenRuleBuff[0] ) );
	}

	public CFGenKbGenRuleBuff[] readBuffByScopeIdx( CFGenKbAuthorization Authorization,
		Short ScopeDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByScopeIdx() ";
		CFGenKbGenRuleBuff buff;
		ArrayList<CFGenKbGenRuleBuff> filteredList = new ArrayList<CFGenKbGenRuleBuff>();
		CFGenKbGenRuleBuff[] buffList = readDerivedByScopeIdx( Authorization,
			ScopeDefId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenRuleBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenRuleBuff[0] ) );
	}

	public CFGenKbGenRuleBuff[] readBuffByGenDefIdx( CFGenKbAuthorization Authorization,
		short GenDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByGenDefIdx() ";
		CFGenKbGenRuleBuff buff;
		ArrayList<CFGenKbGenRuleBuff> filteredList = new ArrayList<CFGenKbGenRuleBuff>();
		CFGenKbGenRuleBuff[] buffList = readDerivedByGenDefIdx( Authorization,
			GenDefId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenRuleBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenRuleBuff[0] ) );
	}

	public CFGenKbGenRuleBuff readBuffByAltIdx( CFGenKbAuthorization Authorization,
		String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByAltIdx() ";
		CFGenKbGenRuleBuff buff = readDerivedByAltIdx( Authorization,
			Name,
			ToolSetId,
			ScopeDefId,
			GenDefId );
		if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
			return( (CFGenKbGenRuleBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGenRuleBuff[] readBuffByGelExecIdx( CFGenKbAuthorization Authorization,
		Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByGelExecIdx() ";
		CFGenKbGenRuleBuff buff;
		ArrayList<CFGenKbGenRuleBuff> filteredList = new ArrayList<CFGenKbGenRuleBuff>();
		CFGenKbGenRuleBuff[] buffList = readDerivedByGelExecIdx( Authorization,
			GelExecutableTenantId,
			GelExecutableGelCacheId,
			GelExecutableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenRuleBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenRuleBuff[0] ) );
	}

	public CFGenKbGenRuleBuff[] readBuffByProbeIdx( CFGenKbAuthorization Authorization,
		Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByProbeIdx() ";
		CFGenKbGenRuleBuff buff;
		ArrayList<CFGenKbGenRuleBuff> filteredList = new ArrayList<CFGenKbGenRuleBuff>();
		CFGenKbGenRuleBuff[] buffList = readDerivedByProbeIdx( Authorization,
			ProbeTenantId,
			ProbeCartridgeId,
			ProbeGenItemId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenRuleBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenRuleBuff[0] ) );
	}

	public CFGenKbGenRuleBuff[] readBuffByBodyIdx( CFGenKbAuthorization Authorization,
		Long BodyTenantId,
		Long BodyGelCacheId,
		Long BodyGelId )
	{
		final String S_ProcName = "CFGenKbRamGenRule.readBuffByBodyIdx() ";
		CFGenKbGenRuleBuff buff;
		ArrayList<CFGenKbGenRuleBuff> filteredList = new ArrayList<CFGenKbGenRuleBuff>();
		CFGenKbGenRuleBuff[] buffList = readDerivedByBodyIdx( Authorization,
			BodyTenantId,
			BodyGelCacheId,
			BodyGelId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RUL" ) ) {
				filteredList.add( (CFGenKbGenRuleBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenRuleBuff[0] ) );
	}

	/**
	 *	Read a page array of the specific GenRule buffer instances identified by the duplicate key BodyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argBodyTenantId	The GenRule key attribute of the instance generating the id.
	 *
	 *	@param	argBodyGelCacheId	The GenRule key attribute of the instance generating the id.
	 *
	 *	@param	argBodyGelId	The GenRule key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGenRuleBuff[] pageBuffByBodyIdx( CFGenKbAuthorization Authorization,
		Long BodyTenantId,
		Long BodyGelCacheId,
		Long BodyGelId,
		Long priorTenantId,
		Long priorCartridgeId,
		Long priorItemId )
	{
		final String S_ProcName = "pageBuffByBodyIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateGenRule( CFGenKbAuthorization Authorization,
		CFGenKbGenRuleBuff Buff )
	{
		schema.getTableGenItem().updateGenItem( Authorization,
			Buff );
		CFGenKbGenItemPKey pkey = schema.getFactoryGenItem().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );
		pkey.setRequiredItemId( Buff.getRequiredItemId() );
		CFGenKbGenRuleBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGenRule",
				"Existing record not found",
				"GenRule",
				pkey );
		}
		CFGenKbGenRuleByBodyIdxKey existingKeyBodyIdx = schema.getFactoryGenRule().newBodyIdxKey();
		existingKeyBodyIdx.setOptionalBodyTenantId( existing.getOptionalBodyTenantId() );
		existingKeyBodyIdx.setOptionalBodyGelCacheId( existing.getOptionalBodyGelCacheId() );
		existingKeyBodyIdx.setOptionalBodyGelId( existing.getOptionalBodyGelId() );

		CFGenKbGenRuleByBodyIdxKey newKeyBodyIdx = schema.getFactoryGenRule().newBodyIdxKey();
		newKeyBodyIdx.setOptionalBodyTenantId( Buff.getOptionalBodyTenantId() );
		newKeyBodyIdx.setOptionalBodyGelCacheId( Buff.getOptionalBodyGelCacheId() );
		newKeyBodyIdx.setOptionalBodyGelId( Buff.getOptionalBodyGelId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableGenItem().readDerivedByItemIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredCartridgeId(),
						Buff.getRequiredItemId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateGenRule",
						"Superclass",
						"SuperClass",
						"GenItem",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGenItemPKey, CFGenKbGenRuleBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByBodyIdx.get( existingKeyBodyIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByBodyIdx.containsKey( newKeyBodyIdx ) ) {
			subdict = dictByBodyIdx.get( newKeyBodyIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGenItemPKey, CFGenKbGenRuleBuff >();
			dictByBodyIdx.put( newKeyBodyIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteGenRule( CFGenKbAuthorization Authorization,
		CFGenKbGenRuleBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGenRuleTable.deleteGenRule() ";
		String classCode;
		CFGenKbGenItemPKey pkey = schema.getFactoryGenItem().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );
		pkey.setRequiredItemId( Buff.getRequiredItemId() );
		CFGenKbGenRuleBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGenRule",
				pkey );
		}
		// Short circuit self-referential code to prevent stack overflows
		if( null != schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
						existing.getOptionalBodyTenantId(),
						existing.getOptionalBodyGelCacheId(),
						existing.getOptionalBodyGelId() ) ) {
			schema.getTableGelExecutable().deleteGelExecutableByPIdx( Authorization,
						existing.getOptionalBodyTenantId(),
						existing.getOptionalBodyGelCacheId(),
						existing.getOptionalBodyGelId() );
		}
		// Short circuit self-referential code to prevent stack overflows
		if( null != schema.getTableGelExecutable().readDerivedByPIdx( Authorization,
						existing.getOptionalGelExecutableTenantId(),
						existing.getOptionalGelExecutableGelCacheId(),
						existing.getOptionalGelExecutableId() ) ) {
			schema.getTableGelExecutable().deleteGelExecutableByPIdx( Authorization,
						existing.getOptionalGelExecutableTenantId(),
						existing.getOptionalGelExecutableGelCacheId(),
						existing.getOptionalGelExecutableId() );
		}
		CFGenKbGenRuleByBodyIdxKey keyBodyIdx = schema.getFactoryGenRule().newBodyIdxKey();
		keyBodyIdx.setOptionalBodyTenantId( existing.getOptionalBodyTenantId() );
		keyBodyIdx.setOptionalBodyGelCacheId( existing.getOptionalBodyGelCacheId() );
		keyBodyIdx.setOptionalBodyGelId( existing.getOptionalBodyGelId() );

		// Validate reverse foreign keys

		if( schema.getTableGenTrunc().readDerivedByItemIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredCartridgeId(),
					existing.getRequiredItemId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGenRule",
				"Superclass",
				"SuperClass",
				"GenTrunc",
				pkey );
		}

		if( schema.getTableGenFile().readDerivedByItemIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredCartridgeId(),
					existing.getRequiredItemId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteGenRule",
				"Superclass",
				"SuperClass",
				"GenFile",
				pkey );
		}

		// Delete is valid
		Map< CFGenKbGenItemPKey, CFGenKbGenRuleBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByBodyIdx.get( keyBodyIdx );
		subdict.remove( pkey );

		schema.getTableGenItem().deleteGenItem( Authorization,
			Buff );
	}
	public void deleteGenRuleByBodyIdx( CFGenKbAuthorization Authorization,
		Long argBodyTenantId,
		Long argBodyGelCacheId,
		Long argBodyGelId )
	{
		CFGenKbGenRuleByBodyIdxKey key = schema.getFactoryGenRule().newBodyIdxKey();
		key.setOptionalBodyTenantId( argBodyTenantId );
		key.setOptionalBodyGelCacheId( argBodyGelCacheId );
		key.setOptionalBodyGelId( argBodyGelId );
		deleteGenRuleByBodyIdx( Authorization, key );
	}

	public void deleteGenRuleByBodyIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenRuleByBodyIdxKey argKey )
	{
		final String S_ProcName = "deleteGenRuleByBodyIdx";
		CFGenKbGenRuleBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalBodyTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalBodyGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalBodyGelId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenRuleBuff> matchSet = new LinkedList<CFGenKbGenRuleBuff>();
		Iterator<CFGenKbGenRuleBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenRuleBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenRule().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenRule must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenRuleByItemIdIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId,
		long argItemId )
	{
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredCartridgeId( argCartridgeId );
		key.setRequiredItemId( argItemId );
		deleteGenRuleByItemIdIdx( Authorization, key );
	}

	public void deleteGenRuleByItemIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey argKey )
	{
		final String S_ProcName = "deleteGenRuleByItemIdIdx";
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGenRuleBuff cur;
		LinkedList<CFGenKbGenRuleBuff> matchSet = new LinkedList<CFGenKbGenRuleBuff>();
		Iterator<CFGenKbGenRuleBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenRuleBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenRule().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenRule must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenRuleByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGenItemByTenantIdxKey key = schema.getFactoryGenItem().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGenRuleByTenantIdx( Authorization, key );
	}

	public void deleteGenRuleByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByTenantIdxKey argKey )
	{
		final String S_ProcName = "deleteGenRuleByTenantIdx";
		CFGenKbGenRuleBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenRuleBuff> matchSet = new LinkedList<CFGenKbGenRuleBuff>();
		Iterator<CFGenKbGenRuleBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenRuleBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenRule().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenRule must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenRuleByCartIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId )
	{
		CFGenKbGenItemByCartIdxKey key = schema.getFactoryGenItem().newCartIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredCartridgeId( argCartridgeId );
		deleteGenRuleByCartIdx( Authorization, key );
	}

	public void deleteGenRuleByCartIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByCartIdxKey argKey )
	{
		final String S_ProcName = "deleteGenRuleByCartIdx";
		CFGenKbGenRuleBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenRuleBuff> matchSet = new LinkedList<CFGenKbGenRuleBuff>();
		Iterator<CFGenKbGenRuleBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenRuleBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenRule().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenRule must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenRuleByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short argRuleTypeId )
	{
		CFGenKbGenItemByRuleTypeIdxKey key = schema.getFactoryGenItem().newRuleTypeIdxKey();
		key.setRequiredRuleTypeId( argRuleTypeId );
		deleteGenRuleByRuleTypeIdx( Authorization, key );
	}

	public void deleteGenRuleByRuleTypeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByRuleTypeIdxKey argKey )
	{
		final String S_ProcName = "deleteGenRuleByRuleTypeIdx";
		CFGenKbGenRuleBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenRuleBuff> matchSet = new LinkedList<CFGenKbGenRuleBuff>();
		Iterator<CFGenKbGenRuleBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenRuleBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenRule().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenRule must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenRuleByToolSetIdx( CFGenKbAuthorization Authorization,
		short argToolSetId )
	{
		CFGenKbGenItemByToolSetIdxKey key = schema.getFactoryGenItem().newToolSetIdxKey();
		key.setRequiredToolSetId( argToolSetId );
		deleteGenRuleByToolSetIdx( Authorization, key );
	}

	public void deleteGenRuleByToolSetIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByToolSetIdxKey argKey )
	{
		final String S_ProcName = "deleteGenRuleByToolSetIdx";
		CFGenKbGenRuleBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenRuleBuff> matchSet = new LinkedList<CFGenKbGenRuleBuff>();
		Iterator<CFGenKbGenRuleBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenRuleBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenRule().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenRule must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenRuleByScopeIdx( CFGenKbAuthorization Authorization,
		Short argScopeDefId )
	{
		CFGenKbGenItemByScopeIdxKey key = schema.getFactoryGenItem().newScopeIdxKey();
		key.setOptionalScopeDefId( argScopeDefId );
		deleteGenRuleByScopeIdx( Authorization, key );
	}

	public void deleteGenRuleByScopeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteGenRuleByScopeIdx";
		CFGenKbGenRuleBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalScopeDefId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenRuleBuff> matchSet = new LinkedList<CFGenKbGenRuleBuff>();
		Iterator<CFGenKbGenRuleBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenRuleBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenRule().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenRule must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenRuleByGenDefIdx( CFGenKbAuthorization Authorization,
		short argGenDefId )
	{
		CFGenKbGenItemByGenDefIdxKey key = schema.getFactoryGenItem().newGenDefIdxKey();
		key.setRequiredGenDefId( argGenDefId );
		deleteGenRuleByGenDefIdx( Authorization, key );
	}

	public void deleteGenRuleByGenDefIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGenDefIdxKey argKey )
	{
		final String S_ProcName = "deleteGenRuleByGenDefIdx";
		CFGenKbGenRuleBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenRuleBuff> matchSet = new LinkedList<CFGenKbGenRuleBuff>();
		Iterator<CFGenKbGenRuleBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenRuleBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenRule().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenRule must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenRuleByAltIdx( CFGenKbAuthorization Authorization,
		String argName,
		short argToolSetId,
		Short argScopeDefId,
		short argGenDefId )
	{
		CFGenKbGenItemByAltIdxKey key = schema.getFactoryGenItem().newAltIdxKey();
		key.setRequiredName( argName );
		key.setRequiredToolSetId( argToolSetId );
		key.setOptionalScopeDefId( argScopeDefId );
		key.setRequiredGenDefId( argGenDefId );
		deleteGenRuleByAltIdx( Authorization, key );
	}

	public void deleteGenRuleByAltIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByAltIdxKey argKey )
	{
		final String S_ProcName = "deleteGenRuleByAltIdx";
		CFGenKbGenRuleBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( argKey.getOptionalScopeDefId() != null ) {
			anyNotNull = true;
		}
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenRuleBuff> matchSet = new LinkedList<CFGenKbGenRuleBuff>();
		Iterator<CFGenKbGenRuleBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenRuleBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenRule().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenRule must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenRuleByGelExecIdx( CFGenKbAuthorization Authorization,
		Long argGelExecutableTenantId,
		Long argGelExecutableGelCacheId,
		Long argGelExecutableId )
	{
		CFGenKbGenItemByGelExecIdxKey key = schema.getFactoryGenItem().newGelExecIdxKey();
		key.setOptionalGelExecutableTenantId( argGelExecutableTenantId );
		key.setOptionalGelExecutableGelCacheId( argGelExecutableGelCacheId );
		key.setOptionalGelExecutableId( argGelExecutableId );
		deleteGenRuleByGelExecIdx( Authorization, key );
	}

	public void deleteGenRuleByGelExecIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGelExecIdxKey argKey )
	{
		final String S_ProcName = "deleteGenRuleByGelExecIdx";
		CFGenKbGenRuleBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalGelExecutableTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalGelExecutableGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalGelExecutableId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenRuleBuff> matchSet = new LinkedList<CFGenKbGenRuleBuff>();
		Iterator<CFGenKbGenRuleBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenRuleBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenRule().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenRule must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteGenRuleByProbeIdx( CFGenKbAuthorization Authorization,
		Long argProbeTenantId,
		Long argProbeCartridgeId,
		Long argProbeGenItemId )
	{
		CFGenKbGenItemByProbeIdxKey key = schema.getFactoryGenItem().newProbeIdxKey();
		key.setOptionalProbeTenantId( argProbeTenantId );
		key.setOptionalProbeCartridgeId( argProbeCartridgeId );
		key.setOptionalProbeGenItemId( argProbeGenItemId );
		deleteGenRuleByProbeIdx( Authorization, key );
	}

	public void deleteGenRuleByProbeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByProbeIdxKey argKey )
	{
		final String S_ProcName = "deleteGenRuleByProbeIdx";
		CFGenKbGenRuleBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalProbeTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalProbeCartridgeId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalProbeGenItemId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenRuleBuff> matchSet = new LinkedList<CFGenKbGenRuleBuff>();
		Iterator<CFGenKbGenRuleBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenRuleBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenRule().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			String subClassCode = cur.getClassCode();
			if( "RUL".equals( subClassCode ) ) {
				schema.getTableGenRule().deleteGenRule( Authorization, cur );
			}
			else if( "TRC".equals( subClassCode ) ) {
				schema.getTableGenTrunc().deleteGenTrunc( Authorization, (CFGenKbGenTruncBuff)cur );
			}
			else if( "FIL".equals( subClassCode ) ) {
				schema.getTableGenFile().deleteGenFile( Authorization, (CFGenKbGenFileBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of GenRule must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void releasePreparedStatements() {
	}
}
