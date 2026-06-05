
// Description: Java 11 in-memory RAM DbIO implementation for GenIterator.

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
 *	CFGenKbRamGenIteratorTable in-memory RAM DbIO implementation
 *	for GenIterator.
 */
public class CFGenKbRamGenIteratorTable
	implements ICFGenKbGenIteratorTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGenItemPKey,
				CFGenKbGenIteratorBuff > dictByPKey
		= new HashMap< CFGenKbGenItemPKey,
				CFGenKbGenIteratorBuff >();

	public CFGenKbRamGenIteratorTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGenIterator( CFGenKbAuthorization Authorization,
		CFGenKbGenIteratorBuff Buff )
	{
		final String S_ProcName = "createGenIterator";
		schema.getTableGenItem().createGenItem( Authorization,
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

	}

	public CFGenKbGenIteratorBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGenIterator.readDerived";
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredCartridgeId( PKey.getRequiredCartridgeId() );
		key.setRequiredItemId( PKey.getRequiredItemId() );
		CFGenKbGenIteratorBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenIteratorBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGenIterator.readDerived";
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredCartridgeId( PKey.getRequiredCartridgeId() );
		key.setRequiredItemId( PKey.getRequiredItemId() );
		CFGenKbGenIteratorBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenIteratorBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGenIterator.readAllDerived";
		CFGenKbGenIteratorBuff[] retList = new CFGenKbGenIteratorBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGenIteratorBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGenIteratorBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenIteratorBuff> filteredList = new ArrayList<CFGenKbGenIteratorBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenIteratorBuff ) ) {
					filteredList.add( (CFGenKbGenIteratorBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenIteratorBuff[0] ) );
		}
	}

	public CFGenKbGenIteratorBuff[] readDerivedByCartIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenIteratorBuff> filteredList = new ArrayList<CFGenKbGenIteratorBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenIteratorBuff ) ) {
					filteredList.add( (CFGenKbGenIteratorBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenIteratorBuff[0] ) );
		}
	}

	public CFGenKbGenIteratorBuff[] readDerivedByRuleTypeIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenIteratorBuff> filteredList = new ArrayList<CFGenKbGenIteratorBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenIteratorBuff ) ) {
					filteredList.add( (CFGenKbGenIteratorBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenIteratorBuff[0] ) );
		}
	}

	public CFGenKbGenIteratorBuff[] readDerivedByToolSetIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenIteratorBuff> filteredList = new ArrayList<CFGenKbGenIteratorBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenIteratorBuff ) ) {
					filteredList.add( (CFGenKbGenIteratorBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenIteratorBuff[0] ) );
		}
	}

	public CFGenKbGenIteratorBuff[] readDerivedByScopeIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenIteratorBuff> filteredList = new ArrayList<CFGenKbGenIteratorBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenIteratorBuff ) ) {
					filteredList.add( (CFGenKbGenIteratorBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenIteratorBuff[0] ) );
		}
	}

	public CFGenKbGenIteratorBuff[] readDerivedByGenDefIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenIteratorBuff> filteredList = new ArrayList<CFGenKbGenIteratorBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenIteratorBuff ) ) {
					filteredList.add( (CFGenKbGenIteratorBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenIteratorBuff[0] ) );
		}
	}

	public CFGenKbGenIteratorBuff readDerivedByAltIdx( CFGenKbAuthorization Authorization,
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
		else if( buff instanceof CFGenKbGenIteratorBuff ) {
			return( (CFGenKbGenIteratorBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGenIteratorBuff[] readDerivedByGelExecIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenIteratorBuff> filteredList = new ArrayList<CFGenKbGenIteratorBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenIteratorBuff ) ) {
					filteredList.add( (CFGenKbGenIteratorBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenIteratorBuff[0] ) );
		}
	}

	public CFGenKbGenIteratorBuff[] readDerivedByProbeIdx( CFGenKbAuthorization Authorization,
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
			ArrayList<CFGenKbGenIteratorBuff> filteredList = new ArrayList<CFGenKbGenIteratorBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGenIteratorBuff ) ) {
					filteredList.add( (CFGenKbGenIteratorBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGenIteratorBuff[0] ) );
		}
	}

	public CFGenKbGenIteratorBuff readDerivedByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readDerivedByItemIdIdx() ";
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCartridgeId( CartridgeId );
		key.setRequiredItemId( ItemId );

		CFGenKbGenIteratorBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenIteratorBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGenIterator.readBuff";
		CFGenKbGenIteratorBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ITR" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenIteratorBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGenIteratorBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ITR" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGenIteratorBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGenIterator.readAllBuff";
		CFGenKbGenIteratorBuff buff;
		ArrayList<CFGenKbGenIteratorBuff> filteredList = new ArrayList<CFGenKbGenIteratorBuff>();
		CFGenKbGenIteratorBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITR" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenIteratorBuff[0] ) );
	}

	public CFGenKbGenIteratorBuff readBuffByItemIdIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId,
		long ItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByItemIdIdx() ";
		CFGenKbGenIteratorBuff buff = readDerivedByItemIdIdx( Authorization,
			TenantId,
			CartridgeId,
			ItemId );
		if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
			return( (CFGenKbGenIteratorBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGenIteratorBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByTenantIdx() ";
		CFGenKbGenIteratorBuff buff;
		ArrayList<CFGenKbGenIteratorBuff> filteredList = new ArrayList<CFGenKbGenIteratorBuff>();
		CFGenKbGenIteratorBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenIteratorBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenIteratorBuff[0] ) );
	}

	public CFGenKbGenIteratorBuff[] readBuffByCartIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long CartridgeId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByCartIdx() ";
		CFGenKbGenIteratorBuff buff;
		ArrayList<CFGenKbGenIteratorBuff> filteredList = new ArrayList<CFGenKbGenIteratorBuff>();
		CFGenKbGenIteratorBuff[] buffList = readDerivedByCartIdx( Authorization,
			TenantId,
			CartridgeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenIteratorBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenIteratorBuff[0] ) );
	}

	public CFGenKbGenIteratorBuff[] readBuffByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short RuleTypeId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByRuleTypeIdx() ";
		CFGenKbGenIteratorBuff buff;
		ArrayList<CFGenKbGenIteratorBuff> filteredList = new ArrayList<CFGenKbGenIteratorBuff>();
		CFGenKbGenIteratorBuff[] buffList = readDerivedByRuleTypeIdx( Authorization,
			RuleTypeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenIteratorBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenIteratorBuff[0] ) );
	}

	public CFGenKbGenIteratorBuff[] readBuffByToolSetIdx( CFGenKbAuthorization Authorization,
		short ToolSetId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByToolSetIdx() ";
		CFGenKbGenIteratorBuff buff;
		ArrayList<CFGenKbGenIteratorBuff> filteredList = new ArrayList<CFGenKbGenIteratorBuff>();
		CFGenKbGenIteratorBuff[] buffList = readDerivedByToolSetIdx( Authorization,
			ToolSetId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenIteratorBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenIteratorBuff[0] ) );
	}

	public CFGenKbGenIteratorBuff[] readBuffByScopeIdx( CFGenKbAuthorization Authorization,
		Short ScopeDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByScopeIdx() ";
		CFGenKbGenIteratorBuff buff;
		ArrayList<CFGenKbGenIteratorBuff> filteredList = new ArrayList<CFGenKbGenIteratorBuff>();
		CFGenKbGenIteratorBuff[] buffList = readDerivedByScopeIdx( Authorization,
			ScopeDefId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenIteratorBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenIteratorBuff[0] ) );
	}

	public CFGenKbGenIteratorBuff[] readBuffByGenDefIdx( CFGenKbAuthorization Authorization,
		short GenDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByGenDefIdx() ";
		CFGenKbGenIteratorBuff buff;
		ArrayList<CFGenKbGenIteratorBuff> filteredList = new ArrayList<CFGenKbGenIteratorBuff>();
		CFGenKbGenIteratorBuff[] buffList = readDerivedByGenDefIdx( Authorization,
			GenDefId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenIteratorBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenIteratorBuff[0] ) );
	}

	public CFGenKbGenIteratorBuff readBuffByAltIdx( CFGenKbAuthorization Authorization,
		String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByAltIdx() ";
		CFGenKbGenIteratorBuff buff = readDerivedByAltIdx( Authorization,
			Name,
			ToolSetId,
			ScopeDefId,
			GenDefId );
		if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
			return( (CFGenKbGenIteratorBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGenIteratorBuff[] readBuffByGelExecIdx( CFGenKbAuthorization Authorization,
		Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByGelExecIdx() ";
		CFGenKbGenIteratorBuff buff;
		ArrayList<CFGenKbGenIteratorBuff> filteredList = new ArrayList<CFGenKbGenIteratorBuff>();
		CFGenKbGenIteratorBuff[] buffList = readDerivedByGelExecIdx( Authorization,
			GelExecutableTenantId,
			GelExecutableGelCacheId,
			GelExecutableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenIteratorBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenIteratorBuff[0] ) );
	}

	public CFGenKbGenIteratorBuff[] readBuffByProbeIdx( CFGenKbAuthorization Authorization,
		Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId )
	{
		final String S_ProcName = "CFGenKbRamGenItem.readBuffByProbeIdx() ";
		CFGenKbGenIteratorBuff buff;
		ArrayList<CFGenKbGenIteratorBuff> filteredList = new ArrayList<CFGenKbGenIteratorBuff>();
		CFGenKbGenIteratorBuff[] buffList = readDerivedByProbeIdx( Authorization,
			ProbeTenantId,
			ProbeCartridgeId,
			ProbeGenItemId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ITM" ) ) {
				filteredList.add( (CFGenKbGenIteratorBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGenIteratorBuff[0] ) );
	}

	public void updateGenIterator( CFGenKbAuthorization Authorization,
		CFGenKbGenIteratorBuff Buff )
	{
		schema.getTableGenItem().updateGenItem( Authorization,
			Buff );
		CFGenKbGenItemPKey pkey = schema.getFactoryGenItem().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );
		pkey.setRequiredItemId( Buff.getRequiredItemId() );
		CFGenKbGenIteratorBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGenIterator",
				"Existing record not found",
				"GenIterator",
				pkey );
		}
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
						"updateGenIterator",
						"Superclass",
						"SuperClass",
						"GenItem",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGenItemPKey, CFGenKbGenIteratorBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteGenIterator( CFGenKbAuthorization Authorization,
		CFGenKbGenIteratorBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGenIteratorTable.deleteGenIterator() ";
		String classCode;
		CFGenKbGenItemPKey pkey = schema.getFactoryGenItem().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredCartridgeId( Buff.getRequiredCartridgeId() );
		pkey.setRequiredItemId( Buff.getRequiredItemId() );
		CFGenKbGenIteratorBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGenIterator",
				pkey );
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
		Map< CFGenKbGenItemPKey, CFGenKbGenIteratorBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableGenItem().deleteGenItem( Authorization,
			Buff );
	}
	public void deleteGenIteratorByItemIdIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId,
		long argItemId )
	{
		CFGenKbGenItemPKey key = schema.getFactoryGenItem().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredCartridgeId( argCartridgeId );
		key.setRequiredItemId( argItemId );
		deleteGenIteratorByItemIdIdx( Authorization, key );
	}

	public void deleteGenIteratorByItemIdIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGenIteratorBuff cur;
		LinkedList<CFGenKbGenIteratorBuff> matchSet = new LinkedList<CFGenKbGenIteratorBuff>();
		Iterator<CFGenKbGenIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenIterator().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenIterator( Authorization, cur );
		}
	}

	public void deleteGenIteratorByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGenItemByTenantIdxKey key = schema.getFactoryGenItem().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGenIteratorByTenantIdx( Authorization, key );
	}

	public void deleteGenIteratorByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByTenantIdxKey argKey )
	{
		CFGenKbGenIteratorBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenIteratorBuff> matchSet = new LinkedList<CFGenKbGenIteratorBuff>();
		Iterator<CFGenKbGenIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenIterator().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenIterator( Authorization, cur );
		}
	}

	public void deleteGenIteratorByCartIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argCartridgeId )
	{
		CFGenKbGenItemByCartIdxKey key = schema.getFactoryGenItem().newCartIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredCartridgeId( argCartridgeId );
		deleteGenIteratorByCartIdx( Authorization, key );
	}

	public void deleteGenIteratorByCartIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByCartIdxKey argKey )
	{
		CFGenKbGenIteratorBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenIteratorBuff> matchSet = new LinkedList<CFGenKbGenIteratorBuff>();
		Iterator<CFGenKbGenIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenIterator().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenIterator( Authorization, cur );
		}
	}

	public void deleteGenIteratorByRuleTypeIdx( CFGenKbAuthorization Authorization,
		short argRuleTypeId )
	{
		CFGenKbGenItemByRuleTypeIdxKey key = schema.getFactoryGenItem().newRuleTypeIdxKey();
		key.setRequiredRuleTypeId( argRuleTypeId );
		deleteGenIteratorByRuleTypeIdx( Authorization, key );
	}

	public void deleteGenIteratorByRuleTypeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByRuleTypeIdxKey argKey )
	{
		CFGenKbGenIteratorBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenIteratorBuff> matchSet = new LinkedList<CFGenKbGenIteratorBuff>();
		Iterator<CFGenKbGenIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenIterator().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenIterator( Authorization, cur );
		}
	}

	public void deleteGenIteratorByToolSetIdx( CFGenKbAuthorization Authorization,
		short argToolSetId )
	{
		CFGenKbGenItemByToolSetIdxKey key = schema.getFactoryGenItem().newToolSetIdxKey();
		key.setRequiredToolSetId( argToolSetId );
		deleteGenIteratorByToolSetIdx( Authorization, key );
	}

	public void deleteGenIteratorByToolSetIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByToolSetIdxKey argKey )
	{
		CFGenKbGenIteratorBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenIteratorBuff> matchSet = new LinkedList<CFGenKbGenIteratorBuff>();
		Iterator<CFGenKbGenIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenIterator().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenIterator( Authorization, cur );
		}
	}

	public void deleteGenIteratorByScopeIdx( CFGenKbAuthorization Authorization,
		Short argScopeDefId )
	{
		CFGenKbGenItemByScopeIdxKey key = schema.getFactoryGenItem().newScopeIdxKey();
		key.setOptionalScopeDefId( argScopeDefId );
		deleteGenIteratorByScopeIdx( Authorization, key );
	}

	public void deleteGenIteratorByScopeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByScopeIdxKey argKey )
	{
		CFGenKbGenIteratorBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalScopeDefId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenIteratorBuff> matchSet = new LinkedList<CFGenKbGenIteratorBuff>();
		Iterator<CFGenKbGenIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenIterator().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenIterator( Authorization, cur );
		}
	}

	public void deleteGenIteratorByGenDefIdx( CFGenKbAuthorization Authorization,
		short argGenDefId )
	{
		CFGenKbGenItemByGenDefIdxKey key = schema.getFactoryGenItem().newGenDefIdxKey();
		key.setRequiredGenDefId( argGenDefId );
		deleteGenIteratorByGenDefIdx( Authorization, key );
	}

	public void deleteGenIteratorByGenDefIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGenDefIdxKey argKey )
	{
		CFGenKbGenIteratorBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGenIteratorBuff> matchSet = new LinkedList<CFGenKbGenIteratorBuff>();
		Iterator<CFGenKbGenIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenIterator().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenIterator( Authorization, cur );
		}
	}

	public void deleteGenIteratorByAltIdx( CFGenKbAuthorization Authorization,
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
		deleteGenIteratorByAltIdx( Authorization, key );
	}

	public void deleteGenIteratorByAltIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByAltIdxKey argKey )
	{
		CFGenKbGenIteratorBuff cur;
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
		LinkedList<CFGenKbGenIteratorBuff> matchSet = new LinkedList<CFGenKbGenIteratorBuff>();
		Iterator<CFGenKbGenIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenIterator().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenIterator( Authorization, cur );
		}
	}

	public void deleteGenIteratorByGelExecIdx( CFGenKbAuthorization Authorization,
		Long argGelExecutableTenantId,
		Long argGelExecutableGelCacheId,
		Long argGelExecutableId )
	{
		CFGenKbGenItemByGelExecIdxKey key = schema.getFactoryGenItem().newGelExecIdxKey();
		key.setOptionalGelExecutableTenantId( argGelExecutableTenantId );
		key.setOptionalGelExecutableGelCacheId( argGelExecutableGelCacheId );
		key.setOptionalGelExecutableId( argGelExecutableId );
		deleteGenIteratorByGelExecIdx( Authorization, key );
	}

	public void deleteGenIteratorByGelExecIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByGelExecIdxKey argKey )
	{
		CFGenKbGenIteratorBuff cur;
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
		LinkedList<CFGenKbGenIteratorBuff> matchSet = new LinkedList<CFGenKbGenIteratorBuff>();
		Iterator<CFGenKbGenIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenIterator().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenIterator( Authorization, cur );
		}
	}

	public void deleteGenIteratorByProbeIdx( CFGenKbAuthorization Authorization,
		Long argProbeTenantId,
		Long argProbeCartridgeId,
		Long argProbeGenItemId )
	{
		CFGenKbGenItemByProbeIdxKey key = schema.getFactoryGenItem().newProbeIdxKey();
		key.setOptionalProbeTenantId( argProbeTenantId );
		key.setOptionalProbeCartridgeId( argProbeCartridgeId );
		key.setOptionalProbeGenItemId( argProbeGenItemId );
		deleteGenIteratorByProbeIdx( Authorization, key );
	}

	public void deleteGenIteratorByProbeIdx( CFGenKbAuthorization Authorization,
		CFGenKbGenItemByProbeIdxKey argKey )
	{
		CFGenKbGenIteratorBuff cur;
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
		LinkedList<CFGenKbGenIteratorBuff> matchSet = new LinkedList<CFGenKbGenIteratorBuff>();
		Iterator<CFGenKbGenIteratorBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGenIteratorBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGenIterator().readDerivedByItemIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredCartridgeId(),
				cur.getRequiredItemId() );
			deleteGenIterator( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
