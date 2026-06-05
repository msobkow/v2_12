
// Description: Java 11 in-memory RAM DbIO implementation for GelReference.

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
 *	CFGenKbRamGelReferenceTable in-memory RAM DbIO implementation
 *	for GelReference.
 */
public class CFGenKbRamGelReferenceTable
	implements ICFGenKbGelReferenceTable
{
	private ICFGenKbSchema schema;
	private Map< CFGenKbGelInstructionPKey,
				CFGenKbGelReferenceBuff > dictByPKey
		= new HashMap< CFGenKbGelInstructionPKey,
				CFGenKbGelReferenceBuff >();
	private Map< CFGenKbGelReferenceByRemainderIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelReferenceBuff >> dictByRemainderIdx
		= new HashMap< CFGenKbGelReferenceByRemainderIdxKey,
				Map< CFGenKbGelInstructionPKey,
					CFGenKbGelReferenceBuff >>();

	public CFGenKbRamGelReferenceTable( ICFGenKbSchema argSchema ) {
		schema = argSchema;
	}

	public void createGelReference( CFGenKbAuthorization Authorization,
		CFGenKbGelReferenceBuff Buff )
	{
		final String S_ProcName = "createGelReference";
		schema.getTableGelInstruction().createGelInstruction( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelReferenceByRemainderIdxKey keyRemainderIdx = schema.getFactoryGelReference().newRemainderIdxKey();
		keyRemainderIdx.setOptionalRemainderTenantId( Buff.getOptionalRemainderTenantId() );
		keyRemainderIdx.setRequiredRemainderGelCacheId( Buff.getRequiredRemainderGelCacheId() );
		keyRemainderIdx.setOptionalRemainderInstId( Buff.getOptionalRemainderInstId() );

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
				if( null == schema.getTableGelInstruction().readDerivedByPIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredGelCacheId(),
						Buff.getRequiredGelInstId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"GelInstruction",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFGenKbGelInstructionPKey, CFGenKbGelReferenceBuff > subdictRemainderIdx;
		if( dictByRemainderIdx.containsKey( keyRemainderIdx ) ) {
			subdictRemainderIdx = dictByRemainderIdx.get( keyRemainderIdx );
		}
		else {
			subdictRemainderIdx = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelReferenceBuff >();
			dictByRemainderIdx.put( keyRemainderIdx, subdictRemainderIdx );
		}
		subdictRemainderIdx.put( pkey, Buff );

	}

	public CFGenKbGelReferenceBuff readDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelReference.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelReferenceBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelReferenceBuff lockDerived( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelReference.readDerived";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredGelCacheId( PKey.getRequiredGelCacheId() );
		key.setRequiredGelInstId( PKey.getRequiredGelInstId() );
		CFGenKbGelReferenceBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelReferenceBuff[] readAllDerived( CFGenKbAuthorization Authorization ) {
		final String S_ProcName = "CFGenKbRamGelReference.readAllDerived";
		CFGenKbGelReferenceBuff[] retList = new CFGenKbGelReferenceBuff[ dictByPKey.values().size() ];
		Iterator< CFGenKbGelReferenceBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFGenKbGelReferenceBuff[] readDerivedByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByTenantIdx";
		CFGenKbGelInstructionBuff buffList[] = schema.getTableGelInstruction().readDerivedByTenantIdx( Authorization,
			TenantId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGelInstructionBuff buff;
			ArrayList<CFGenKbGelReferenceBuff> filteredList = new ArrayList<CFGenKbGelReferenceBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelReferenceBuff ) ) {
					filteredList.add( (CFGenKbGelReferenceBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelReferenceBuff[0] ) );
		}
	}

	public CFGenKbGelReferenceBuff[] readDerivedByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByGelCacheIdx";
		CFGenKbGelInstructionBuff buffList[] = schema.getTableGelInstruction().readDerivedByGelCacheIdx( Authorization,
			TenantId,
			GelCacheId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGelInstructionBuff buff;
			ArrayList<CFGenKbGelReferenceBuff> filteredList = new ArrayList<CFGenKbGelReferenceBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelReferenceBuff ) ) {
					filteredList.add( (CFGenKbGelReferenceBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelReferenceBuff[0] ) );
		}
	}

	public CFGenKbGelReferenceBuff[] readDerivedByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByChainIdx";
		CFGenKbGelInstructionBuff buffList[] = schema.getTableGelInstruction().readDerivedByChainIdx( Authorization,
			ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFGenKbGelInstructionBuff buff;
			ArrayList<CFGenKbGelReferenceBuff> filteredList = new ArrayList<CFGenKbGelReferenceBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFGenKbGelReferenceBuff ) ) {
					filteredList.add( (CFGenKbGelReferenceBuff)buff );
				}
			}
			return( filteredList.toArray( new CFGenKbGelReferenceBuff[0] ) );
		}
	}

	public CFGenKbGelReferenceBuff[] readDerivedByRemainderIdx( CFGenKbAuthorization Authorization,
		Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId )
	{
		final String S_ProcName = "CFGenKbRamGelReference.readDerivedByRemainderIdx";
		CFGenKbGelReferenceByRemainderIdxKey key = schema.getFactoryGelReference().newRemainderIdxKey();
		key.setOptionalRemainderTenantId( RemainderTenantId );
		key.setRequiredRemainderGelCacheId( RemainderGelCacheId );
		key.setOptionalRemainderInstId( RemainderInstId );

		CFGenKbGelReferenceBuff[] recArray;
		if( dictByRemainderIdx.containsKey( key ) ) {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelReferenceBuff > subdictRemainderIdx
				= dictByRemainderIdx.get( key );
			recArray = new CFGenKbGelReferenceBuff[ subdictRemainderIdx.size() ];
			Iterator< CFGenKbGelReferenceBuff > iter = subdictRemainderIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFGenKbGelInstructionPKey, CFGenKbGelReferenceBuff > subdictRemainderIdx
				= new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelReferenceBuff >();
			dictByRemainderIdx.put( key, subdictRemainderIdx );
			recArray = new CFGenKbGelReferenceBuff[0];
		}
		return( recArray );
	}

	public CFGenKbGelReferenceBuff readDerivedByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readDerivedByPIdx() ";
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );

		CFGenKbGelReferenceBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelReferenceBuff readBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "CFGenKbRamGelReference.readBuff";
		CFGenKbGelReferenceBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GREF" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelReferenceBuff lockBuff( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFGenKbGelReferenceBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "GREF" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFGenKbGelReferenceBuff[] readAllBuff( CFGenKbAuthorization Authorization )
	{
		final String S_ProcName = "CFGenKbRamGelReference.readAllBuff";
		CFGenKbGelReferenceBuff buff;
		ArrayList<CFGenKbGelReferenceBuff> filteredList = new ArrayList<CFGenKbGelReferenceBuff>();
		CFGenKbGelReferenceBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GREF" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelReferenceBuff[0] ) );
	}

	public CFGenKbGelReferenceBuff readBuffByPIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByPIdx() ";
		CFGenKbGelReferenceBuff buff = readDerivedByPIdx( Authorization,
			TenantId,
			GelCacheId,
			GelInstId );
		if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
			return( (CFGenKbGelReferenceBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFGenKbGelReferenceBuff[] readBuffByTenantIdx( CFGenKbAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByTenantIdx() ";
		CFGenKbGelReferenceBuff buff;
		ArrayList<CFGenKbGelReferenceBuff> filteredList = new ArrayList<CFGenKbGelReferenceBuff>();
		CFGenKbGelReferenceBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelReferenceBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelReferenceBuff[0] ) );
	}

	public CFGenKbGelReferenceBuff[] readBuffByGelCacheIdx( CFGenKbAuthorization Authorization,
		long TenantId,
		long GelCacheId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByGelCacheIdx() ";
		CFGenKbGelReferenceBuff buff;
		ArrayList<CFGenKbGelReferenceBuff> filteredList = new ArrayList<CFGenKbGelReferenceBuff>();
		CFGenKbGelReferenceBuff[] buffList = readDerivedByGelCacheIdx( Authorization,
			TenantId,
			GelCacheId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelReferenceBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelReferenceBuff[0] ) );
	}

	public CFGenKbGelReferenceBuff[] readBuffByChainIdx( CFGenKbAuthorization Authorization,
		Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		final String S_ProcName = "CFGenKbRamGelInstruction.readBuffByChainIdx() ";
		CFGenKbGelReferenceBuff buff;
		ArrayList<CFGenKbGelReferenceBuff> filteredList = new ArrayList<CFGenKbGelReferenceBuff>();
		CFGenKbGelReferenceBuff[] buffList = readDerivedByChainIdx( Authorization,
			ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GINS" ) ) {
				filteredList.add( (CFGenKbGelReferenceBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelReferenceBuff[0] ) );
	}

	public CFGenKbGelReferenceBuff[] readBuffByRemainderIdx( CFGenKbAuthorization Authorization,
		Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId )
	{
		final String S_ProcName = "CFGenKbRamGelReference.readBuffByRemainderIdx() ";
		CFGenKbGelReferenceBuff buff;
		ArrayList<CFGenKbGelReferenceBuff> filteredList = new ArrayList<CFGenKbGelReferenceBuff>();
		CFGenKbGelReferenceBuff[] buffList = readDerivedByRemainderIdx( Authorization,
			RemainderTenantId,
			RemainderGelCacheId,
			RemainderInstId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "GREF" ) ) {
				filteredList.add( (CFGenKbGelReferenceBuff)buff );
			}
		}
		return( filteredList.toArray( new CFGenKbGelReferenceBuff[0] ) );
	}

	/**
	 *	Read a page array of the specific GelReference buffer instances identified by the duplicate key RemainderIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argRemainderTenantId	The GelReference key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderGelCacheId	The GelReference key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderInstId	The GelReference key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFGenKbGelReferenceBuff[] pageBuffByRemainderIdx( CFGenKbAuthorization Authorization,
		Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId,
		Long priorTenantId,
		Long priorGelCacheId,
		Long priorGelInstId )
	{
		final String S_ProcName = "pageBuffByRemainderIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	public void updateGelReference( CFGenKbAuthorization Authorization,
		CFGenKbGelReferenceBuff Buff )
	{
		schema.getTableGelInstruction().updateGelInstruction( Authorization,
			Buff );
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelReferenceBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateGelReference",
				"Existing record not found",
				"GelReference",
				pkey );
		}
		CFGenKbGelReferenceByRemainderIdxKey existingKeyRemainderIdx = schema.getFactoryGelReference().newRemainderIdxKey();
		existingKeyRemainderIdx.setOptionalRemainderTenantId( existing.getOptionalRemainderTenantId() );
		existingKeyRemainderIdx.setRequiredRemainderGelCacheId( existing.getRequiredRemainderGelCacheId() );
		existingKeyRemainderIdx.setOptionalRemainderInstId( existing.getOptionalRemainderInstId() );

		CFGenKbGelReferenceByRemainderIdxKey newKeyRemainderIdx = schema.getFactoryGelReference().newRemainderIdxKey();
		newKeyRemainderIdx.setOptionalRemainderTenantId( Buff.getOptionalRemainderTenantId() );
		newKeyRemainderIdx.setRequiredRemainderGelCacheId( Buff.getRequiredRemainderGelCacheId() );
		newKeyRemainderIdx.setOptionalRemainderInstId( Buff.getOptionalRemainderInstId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableGelInstruction().readDerivedByPIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredGelCacheId(),
						Buff.getRequiredGelInstId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateGelReference",
						"Superclass",
						"SuperClass",
						"GelInstruction",
						null );
				}
			}
		}

		// Update is valid

		Map< CFGenKbGelInstructionPKey, CFGenKbGelReferenceBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByRemainderIdx.get( existingKeyRemainderIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRemainderIdx.containsKey( newKeyRemainderIdx ) ) {
			subdict = dictByRemainderIdx.get( newKeyRemainderIdx );
		}
		else {
			subdict = new HashMap< CFGenKbGelInstructionPKey, CFGenKbGelReferenceBuff >();
			dictByRemainderIdx.put( newKeyRemainderIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteGelReference( CFGenKbAuthorization Authorization,
		CFGenKbGelReferenceBuff Buff )
	{
		final String S_ProcName = "CFGenKbRamGelReferenceTable.deleteGelReference() ";
		String classCode;
		CFGenKbGelInstructionPKey pkey = schema.getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredGelCacheId( Buff.getRequiredGelCacheId() );
		pkey.setRequiredGelInstId( Buff.getRequiredGelInstId() );
		CFGenKbGelReferenceBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteGelReference",
				pkey );
		}
					schema.getTableGelInstruction().deleteGelInstructionByPIdx( Authorization,
						existing.getOptionalRemainderTenantId(),
						existing.getRequiredRemainderGelCacheId(),
						existing.getOptionalRemainderInstId() );
		CFGenKbGelReferenceByRemainderIdxKey keyRemainderIdx = schema.getFactoryGelReference().newRemainderIdxKey();
		keyRemainderIdx.setOptionalRemainderTenantId( existing.getOptionalRemainderTenantId() );
		keyRemainderIdx.setRequiredRemainderGelCacheId( existing.getRequiredRemainderGelCacheId() );
		keyRemainderIdx.setOptionalRemainderInstId( existing.getOptionalRemainderInstId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFGenKbGelInstructionPKey, CFGenKbGelReferenceBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByRemainderIdx.get( keyRemainderIdx );
		subdict.remove( pkey );

		schema.getTableGelInstruction().deleteGelInstruction( Authorization,
			Buff );
	}
	public void deleteGelReferenceByRemainderIdx( CFGenKbAuthorization Authorization,
		Long argRemainderTenantId,
		long argRemainderGelCacheId,
		Long argRemainderInstId )
	{
		CFGenKbGelReferenceByRemainderIdxKey key = schema.getFactoryGelReference().newRemainderIdxKey();
		key.setOptionalRemainderTenantId( argRemainderTenantId );
		key.setRequiredRemainderGelCacheId( argRemainderGelCacheId );
		key.setOptionalRemainderInstId( argRemainderInstId );
		deleteGelReferenceByRemainderIdx( Authorization, key );
	}

	public void deleteGelReferenceByRemainderIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelReferenceByRemainderIdxKey argKey )
	{
		CFGenKbGelReferenceBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalRemainderTenantId() != null ) {
			anyNotNull = true;
		}
		anyNotNull = true;
		if( argKey.getOptionalRemainderInstId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelReferenceBuff> matchSet = new LinkedList<CFGenKbGelReferenceBuff>();
		Iterator<CFGenKbGelReferenceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelReferenceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelReference().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelReference( Authorization, cur );
		}
	}

	public void deleteGelReferenceByPIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId,
		long argGelInstId )
	{
		CFGenKbGelInstructionPKey key = schema.getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		key.setRequiredGelInstId( argGelInstId );
		deleteGelReferenceByPIdx( Authorization, key );
	}

	public void deleteGelReferenceByPIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionPKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFGenKbGelReferenceBuff cur;
		LinkedList<CFGenKbGelReferenceBuff> matchSet = new LinkedList<CFGenKbGelReferenceBuff>();
		Iterator<CFGenKbGelReferenceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelReferenceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelReference().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelReference( Authorization, cur );
		}
	}

	public void deleteGelReferenceByTenantIdx( CFGenKbAuthorization Authorization,
		long argTenantId )
	{
		CFGenKbGelInstructionByTenantIdxKey key = schema.getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteGelReferenceByTenantIdx( Authorization, key );
	}

	public void deleteGelReferenceByTenantIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByTenantIdxKey argKey )
	{
		CFGenKbGelReferenceBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelReferenceBuff> matchSet = new LinkedList<CFGenKbGelReferenceBuff>();
		Iterator<CFGenKbGelReferenceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelReferenceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelReference().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelReference( Authorization, cur );
		}
	}

	public void deleteGelReferenceByGelCacheIdx( CFGenKbAuthorization Authorization,
		long argTenantId,
		long argGelCacheId )
	{
		CFGenKbGelInstructionByGelCacheIdxKey key = schema.getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredGelCacheId( argGelCacheId );
		deleteGelReferenceByGelCacheIdx( Authorization, key );
	}

	public void deleteGelReferenceByGelCacheIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByGelCacheIdxKey argKey )
	{
		CFGenKbGelReferenceBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelReferenceBuff> matchSet = new LinkedList<CFGenKbGelReferenceBuff>();
		Iterator<CFGenKbGelReferenceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelReferenceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelReference().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelReference( Authorization, cur );
		}
	}

	public void deleteGelReferenceByChainIdx( CFGenKbAuthorization Authorization,
		Long argChainInstTenantId,
		Long argChainInstGelCacheId,
		Long argChainInstGelInstId )
	{
		CFGenKbGelInstructionByChainIdxKey key = schema.getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( argChainInstTenantId );
		key.setOptionalChainInstGelCacheId( argChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( argChainInstGelInstId );
		deleteGelReferenceByChainIdx( Authorization, key );
	}

	public void deleteGelReferenceByChainIdx( CFGenKbAuthorization Authorization,
		CFGenKbGelInstructionByChainIdxKey argKey )
	{
		CFGenKbGelReferenceBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalChainInstTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalChainInstGelCacheId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalChainInstGelInstId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFGenKbGelReferenceBuff> matchSet = new LinkedList<CFGenKbGelReferenceBuff>();
		Iterator<CFGenKbGelReferenceBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFGenKbGelReferenceBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableGelReference().readDerivedByPIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredGelCacheId(),
				cur.getRequiredGelInstId() );
			deleteGelReference( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
