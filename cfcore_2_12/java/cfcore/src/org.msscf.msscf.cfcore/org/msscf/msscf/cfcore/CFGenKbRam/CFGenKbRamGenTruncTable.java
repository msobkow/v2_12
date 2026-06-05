
// Description: Java 11 in-memory RAM DbIO implementation for GenTrunc.

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
 *	CFGenKbRamGenTruncTable in-memory RAM DbIO implementation
 *	for GenTrunc.
 */
public class CFGenKbRamGenTruncTable
	implements ICFGenKbGenTruncTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGenItemPKey,
				CFGenKbGenTruncBuff > dictByPKey
		= new HashMap< CFGenKbGenItemPKey,
				CFGenKbGenTruncBuff >();

	public CFGenKbRamGenTruncTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGenTrunc( CFGenKbAuthorization Authorization,
		CFGenKbGenTruncBuff Buff )
	{
		final String S_ProcName = "createGenTrunc";
		schema.getTableGenRule().createGenRule( Authorization,
			Buff );
		CFGenKbGenItemPKey pkey = schema.getFactoryGenItem().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );
		pkey.setRequiredItemId( Buff.getRequiredItemId() );
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
				if( null == schema.getTableGenRule().readDerivedByItemIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredCartridgeId(),
						Buff.getRequiredItemId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"GenRule",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

	}

	public CFGenKbGenTruncBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGenTrunc.readDerived";
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredCartridgeId( PKey.getRequiredCartridgeId() );
		key.setRequiredItemId( PKey.getRequiredItemId() );
		CFGenKbGenTruncBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenTruncBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGenTrunc.readDerived";
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredCartridgeId( PKey.getRequiredCartridgeId() );
		key.setRequiredItemId( PKey.getRequiredItemId() );
		CFGenKbGenTruncBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenTruncBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGenTrunc.readAllDerived";
		CFGenKbGenTruncBuff[] retList = new CFGenKbGenTruncBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGenTruncBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGenTruncBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenTruncBuff ) ) {
					filteredList.add( (CFGenKbGenTruncBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
		}
	}

	public CFGenKbGenTruncBuff[] readDerivedByCartIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenTruncBuff ) ) {
					filteredList.add( (CFGenKbGenTruncBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
		}
	}

	public CFGenKbGenTruncBuff[] readDerivedByRuleTypeIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenTruncBuff ) ) {
					filteredList.add( (CFGenKbGenTruncBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
		}
	}

	public CFGenKbGenTruncBuff[] readDerivedByToolSetIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenTruncBuff ) ) {
					filteredList.add( (CFGenKbGenTruncBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
		}
	}

	public CFGenKbGenTruncBuff[] readDerivedByScopeIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenTruncBuff ) ) {
					filteredList.add( (CFGenKbGenTruncBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
		}
	}

	public CFGenKbGenTruncBuff[] readDerivedByGenDefIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenTruncBuff ) ) {
					filteredList.add( (CFGenKbGenTruncBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
		}
	}

	public CFGenKbGenTruncBuff readDerivedByAltIdx( CFGenKbAuthorization Authorization,
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
		else if( buff instanceof CFGenKbGenTruncBuff ) {
			return( (CFGenKbGenTruncBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGenTruncBuff[] readDerivedByGelExecIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenTruncBuff ) ) {
					filteredList.add( (CFGenKbGenTruncBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
		}
	}

	public CFGenKbGenTruncBuff[] readDerivedByProbeIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenTruncBuff ) ) {
					filteredList.add( (CFGenKbGenTruncBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
		}
	}

	public CFGenKbGenTruncBuff[] readDerivedByBodyIdx( CFGenKbAuthorization Authorization,
		Long BodyTenantId,
		Long BodyGelCacheId,
		Long BodyGelId )
	{
		final String S_ProcName = "CFGenKbRamGenRule.readDerivedByBodyIdx";
		CFGenKbGenRuleBuff buffList[] = schema.getTableGenRule().readDerivedByBodyIdx( Authorization,
			BodyTenantId,
			BodyGelCacheId,
			BodyGelId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGenRuleBuff buff;
			ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenTruncBuff ) ) {
					filteredList.add( (CFGenKbGenTruncBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
		}
	}

	public CFGenKbGenTruncBuff readDerivedByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByItemIdIdx() ";
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCartridgeId( CartridgeId );
		key.setRequiredItemId( ItemId );

		CFGenKbGenTruncBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenTruncBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGenTrunc.readBuff";
		CFGenKbGenTruncBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TRC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenTruncBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGenTruncBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TRC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenTruncBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGenTrunc.readAllBuff";
		CFGenKbGenTruncBuff buff;
		ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
		CFGenKbGenTruncBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TRC" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
	}

	public CFGenKbGenTruncBuff readBuffByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByItemIdIdx() ";
		CFGenKbGenTruncBuff buff = readDerivedByItemIdIdx( Authorization,
			TenantId,
			CartridgeId,
			ItemId );
		if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
			return( (CFGenKbGenTruncBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGenTruncBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByTenantIdx() ";
		CFGenKbGenTruncBuff buff;
		ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
		CFGenKbGenTruncBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenTruncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
	}

	public CFGenKbGenTruncBuff[] readBuffByCartIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByCartIdx() ";
		CFGenKbGenTruncBuff buff;
		ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
		CFGenKbGenTruncBuff[] buffList = readDerivedByCartIdx( Authorization,
			TenantId,
			CartridgeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenTruncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
	}

	public CFGenKbGenTruncBuff[] readBuffByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short RuleTypeId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByRuleTypeIdx() ";
		CFGenKbGenTruncBuff buff;
		ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
		CFGenKbGenTruncBuff[] buffList = readDerivedByRuleTypeIdx( Authorization,
			RuleTypeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenTruncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
	}

	public CFGenKbGenTruncBuff[] readBuffByToolSetIdx( CFGenKbAuthorization Authorization,
		short ToolSetId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByToolSetIdx() ";
		CFGenKbGenTruncBuff buff;
		ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
		CFGenKbGenTruncBuff[] buffList = readDerivedByToolSetIdx( Authorization,
			ToolSetId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenTruncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
	}

	public CFGenKbGenTruncBuff[] readBuffByScopeIdx( CFGenKbAuthorization Authorization,
		Short ScopeDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByScopeIdx() ";
		CFGenKbGenTruncBuff buff;
		ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
		CFGenKbGenTruncBuff[] buffList = readDerivedByScopeIdx( Authorization,
			ScopeDefId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenTruncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
	}

	public CFGenKbGenTruncBuff[] readBuffByGenDefIdx( CFGenKbAuthorization Authorization,
		short GenDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByGenDefIdx() ";
		CFGenKbGenTruncBuff buff;
		ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
		CFGenKbGenTruncBuff[] buffList = readDerivedByGenDefIdx( Authorization,
			GenDefId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenTruncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
	}

	public CFGenKbGenTruncBuff readBuffByAltIdx( CFGenKbAuthorization Authorization,
		String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByAltIdx() ";
		CFGenKbGenTruncBuff buff = readDerivedByAltIdx( Authorization,
			Name,
			ToolSetId,
			ScopeDefId,
			GenDefId );
		if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
			return( (CFGenKbGenTruncBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGenTruncBuff[] readBuffByGelExecIdx( CFGenKbAuthorization Authorization,
		Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByGelExecIdx() ";
		CFGenKbGenTruncBuff buff;
		ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
		CFGenKbGenTruncBuff[] buffList = readDerivedByGelExecIdx( Authorization,
			GelExecutableTenantId,
			GelExecutableGelCacheId,
			GelExecutableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenTruncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
	}

	public CFGenKbGenTruncBuff[] readBuffByProbeIdx( CFGenKbAuthorization Authorization,
		Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByProbeIdx() ";
		CFGenKbGenTruncBuff buff;
		ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
		CFGenKbGenTruncBuff[] buffList = readDerivedByProbeIdx( Authorization,
			ProbeTenantId,
			ProbeCartridgeId,
			ProbeGenItemId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenTruncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
	}

	public CFGenKbGenTruncBuff[] readBuffByBodyIdx( CFGenKbAuthorization Authorization,
		Long BodyTenantId,
		Long BodyGelCacheId,
		Long BodyGelId )
	{
		final String S_ProcName = "CFGenKbRamGenRule.readBuffByBodyIdx() ";
		CFGenKbGenTruncBuff buff;
		ArrayList<CFGenKbGenTruncBuff> filteredList = new ArrayList<CFGenKbGenTruncBuff>();
		CFGenKbGenTruncBuff[] buffList = readDerivedByBodyIdx( Authorization,
			BodyTenantId,
			BodyGelCacheId,
			BodyGelId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "RUL" ) ) {
				filteredList.add( (CFGenKbGenTruncBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenTruncBuff[0] ) );
	}

	/**
	 *	Read a page array of the specific GenTrunc buffer instances identified by the duplicate key BodyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argBodyTenantId	The GenTrunc key attribute of the instance generating the id.
	 *
	 *	@param	argBodyGelCacheId	The GenTrunc key attribute of the instance generating the id.
	 *
	 *	@param	argBodyGelId	The GenTrunc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGenTruncBuff[] pageBuffByBodyIdx( CFGenKbAuthorization Authorization,
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

	public void updateGenTrunc( CFGenKbAuthorization Authorization,
		CFGenKbGenTruncBuff Buff )
	{
		schema.getTableGenRule().updateGenRule( Authorization,
			Buff );
		CFGenKbGenItemPKey pkey = schema.getFactoryGenItem().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );
		pkey.setRequiredItemId( Buff.getRequiredItemId() );
		CFGenKbGenTruncBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGenTrunc",
				"Existing record not found",
				"GenTrunc",
				pkey );
		}
		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableGenRule().readDerivedByItemIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredCartridgeId(),
						Buff.getRequiredItemId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateGenTrunc",
						"Superclass",
						"SuperClass",
						"GenRule",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGenItemPKey, CFGenKbGenTruncBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteGenTrunc( CFGenKbAuthorization Authorization,
		CFGenKbGenTruncBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGenTruncTable.deleteGenTrunc() ";
		String classCode;
		CFGenKbGenItemPKey pkey = schema.getFactoryGenItem().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );
		pkey.setRequiredItemId( Buff.getRequiredItemId() );
		CFGenKbGenTruncBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGenTrunc",
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
		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbGenItemPKey, CFGenKbGenTruncBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableGenRule().deleteGenRule( Authorization,
			Buff );
	}
	public void deleteGenTruncByBodyIdx( CFGenKbAuthorization Authorization,
		Long argBodyTenantId,
		Long argBodyGelCacheId,
		Long argBodyGelId )
	{
		CFGenKbGenRuleByBodyIdxKey key = schema.getFactoryGenRule().newBodyIdxKey();
		key.setOptionalBodyTenantId( argBodyTenantId );
		key.setOptionalBodyGelCacheId( argBodyGelCacheId );
		key.setOptionalBodyGelId( argBodyGelId );
		deleteGenTruncByBodyIdx( Authorization, key );
	}

	public void deleteGenTruncByBodyIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenRuleByBodyIdxKey argKey )
	{
		CFGenKbGenTruncBuff cur;
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
		LinkedList<CFGenKbGenTruncBuff> matchSet = new LinkedList<CFGenKbGenTruncBuff>();
		Iterator<CFGenKbGenTruncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenTruncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenTrunc().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenTrunc( Authorization, cur );
		}
	}

	public void deleteGenTruncByItemIdIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId,
		long argItemId )
	{
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredCartridgeId( argCartridgeId );
		key.setRequiredItemId( argItemId );
		deleteGenTruncByItemIdIdx( Authorization, key );
	}

	public void deleteGenTruncByItemIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGenTruncBuff cur;
		LinkedList<CFGenKbGenTruncBuff> matchSet = new LinkedList<CFGenKbGenTruncBuff>();
		Iterator<CFGenKbGenTruncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenTruncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenTrunc().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenTrunc( Authorization, cur );
		}
	}

	public void deleteGenTruncByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGenItemByTenantIdxKey key = schema.getFactoryGenItem().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGenTruncByTenantIdx( Authorization, key );
	}

	public void deleteGenTruncByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByTenantIdxKey argKey )
	{
		CFGenKbGenTruncBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenTruncBuff> matchSet = new LinkedList<CFGenKbGenTruncBuff>();
		Iterator<CFGenKbGenTruncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenTruncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenTrunc().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenTrunc( Authorization, cur );
		}
	}

	public void deleteGenTruncByCartIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId )
	{
		CFGenKbGenItemByCartIdxKey key = schema.getFactoryGenItem().newCartIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredCartridgeId( argCartridgeId );
		deleteGenTruncByCartIdx( Authorization, key );
	}

	public void deleteGenTruncByCartIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByCartIdxKey argKey )
	{
		CFGenKbGenTruncBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenTruncBuff> matchSet = new LinkedList<CFGenKbGenTruncBuff>();
		Iterator<CFGenKbGenTruncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenTruncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenTrunc().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenTrunc( Authorization, cur );
		}
	}

	public void deleteGenTruncByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short argRuleTypeId )
	{
		CFGenKbGenItemByRuleTypeIdxKey key = schema.getFactoryGenItem().newRuleTypeIdxKey();
		key.setRequiredRuleTypeId( argRuleTypeId );
		deleteGenTruncByRuleTypeIdx( Authorization, key );
	}

	public void deleteGenTruncByRuleTypeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByRuleTypeIdxKey argKey )
	{
		CFGenKbGenTruncBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenTruncBuff> matchSet = new LinkedList<CFGenKbGenTruncBuff>();
		Iterator<CFGenKbGenTruncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenTruncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenTrunc().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenTrunc( Authorization, cur );
		}
	}

	public void deleteGenTruncByToolSetIdx( CFGenKbAuthorization Authorization,
		short argToolSetId )
	{
		CFGenKbGenItemByToolSetIdxKey key = schema.getFactoryGenItem().newToolSetIdxKey();
		key.setRequiredToolSetId( argToolSetId );
		deleteGenTruncByToolSetIdx( Authorization, key );
	}

	public void deleteGenTruncByToolSetIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByToolSetIdxKey argKey )
	{
		CFGenKbGenTruncBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenTruncBuff> matchSet = new LinkedList<CFGenKbGenTruncBuff>();
		Iterator<CFGenKbGenTruncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenTruncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenTrunc().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenTrunc( Authorization, cur );
		}
	}

	public void deleteGenTruncByScopeIdx( CFGenKbAuthorization Authorization,
		Short argScopeDefId )
	{
		CFGenKbGenItemByScopeIdxKey key = schema.getFactoryGenItem().newScopeIdxKey();
		key.setOptionalScopeDefId( argScopeDefId );
		deleteGenTruncByScopeIdx( Authorization, key );
	}

	public void deleteGenTruncByScopeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByScopeIdxKey argKey )
	{
		CFGenKbGenTruncBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalScopeDefId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenTruncBuff> matchSet = new LinkedList<CFGenKbGenTruncBuff>();
		Iterator<CFGenKbGenTruncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenTruncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenTrunc().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenTrunc( Authorization, cur );
		}
	}

	public void deleteGenTruncByGenDefIdx( CFGenKbAuthorization Authorization,
		short argGenDefId )
	{
		CFGenKbGenItemByGenDefIdxKey key = schema.getFactoryGenItem().newGenDefIdxKey();
		key.setRequiredGenDefId( argGenDefId );
		deleteGenTruncByGenDefIdx( Authorization, key );
	}

	public void deleteGenTruncByGenDefIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGenDefIdxKey argKey )
	{
		CFGenKbGenTruncBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenTruncBuff> matchSet = new LinkedList<CFGenKbGenTruncBuff>();
		Iterator<CFGenKbGenTruncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenTruncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenTrunc().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenTrunc( Authorization, cur );
		}
	}

	public void deleteGenTruncByAltIdx( CFGenKbAuthorization Authorization,
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
		deleteGenTruncByAltIdx( Authorization, key );
	}

	public void deleteGenTruncByAltIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByAltIdxKey argKey )
	{
		CFGenKbGenTruncBuff cur;
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
		LinkedList<CFGenKbGenTruncBuff> matchSet = new LinkedList<CFGenKbGenTruncBuff>();
		Iterator<CFGenKbGenTruncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenTruncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenTrunc().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenTrunc( Authorization, cur );
		}
	}

	public void deleteGenTruncByGelExecIdx( CFGenKbAuthorization Authorization,
		Long argGelExecutableTenantId,
		Long argGelExecutableGelCacheId,
		Long argGelExecutableId )
	{
		CFGenKbGenItemByGelExecIdxKey key = schema.getFactoryGenItem().newGelExecIdxKey();
		key.setOptionalGelExecutableTenantId( argGelExecutableTenantId );
		key.setOptionalGelExecutableGelCacheId( argGelExecutableGelCacheId );
		key.setOptionalGelExecutableId( argGelExecutableId );
		deleteGenTruncByGelExecIdx( Authorization, key );
	}

	public void deleteGenTruncByGelExecIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGelExecIdxKey argKey )
	{
		CFGenKbGenTruncBuff cur;
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
		LinkedList<CFGenKbGenTruncBuff> matchSet = new LinkedList<CFGenKbGenTruncBuff>();
		Iterator<CFGenKbGenTruncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenTruncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenTrunc().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenTrunc( Authorization, cur );
		}
	}

	public void deleteGenTruncByProbeIdx( CFGenKbAuthorization Authorization,
		Long argProbeTenantId,
		Long argProbeCartridgeId,
		Long argProbeGenItemId )
	{
		CFGenKbGenItemByProbeIdxKey key = schema.getFactoryGenItem().newProbeIdxKey();
		key.setOptionalProbeTenantId( argProbeTenantId );
		key.setOptionalProbeCartridgeId( argProbeCartridgeId );
		key.setOptionalProbeGenItemId( argProbeGenItemId );
		deleteGenTruncByProbeIdx( Authorization, key );
	}

	public void deleteGenTruncByProbeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByProbeIdxKey argKey )
	{
		CFGenKbGenTruncBuff cur;
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
		LinkedList<CFGenKbGenTruncBuff> matchSet = new LinkedList<CFGenKbGenTruncBuff>();
		Iterator<CFGenKbGenTruncBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenTruncBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenTrunc().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenTrunc( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
