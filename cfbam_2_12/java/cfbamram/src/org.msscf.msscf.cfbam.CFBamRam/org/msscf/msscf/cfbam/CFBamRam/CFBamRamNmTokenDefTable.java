
// Description: Java 11 in-memory RAM DbIO implementation for NmTokenDef.

/*
 *	org.msscf.msscf.CFBam
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

package org.msscf.msscf.cfbam.CFBamRam;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfbam.CFBamObj.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBamObj.*;

/*
 *	CFBamRamNmTokenDefTable in-memory RAM DbIO implementation
 *	for NmTokenDef.
 */
public class CFBamRamNmTokenDefTable
	implements ICFBamNmTokenDefTable
{
	private ICFBamSchema schema;
	private Map< CFBamValuePKey,
				CFBamNmTokenDefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamNmTokenDefBuff >();

	public CFBamRamNmTokenDefTable( ICFBamSchema argSchema ) {
		schema = argSchema;
	}

	public void createNmTokenDef( CFSecAuthorization Authorization,
		CFBamNmTokenDefBuff Buff )
	{
		final String S_ProcName = "createNmTokenDef";
		schema.getTableAtom().createAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableAtom().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

	}

	public CFBamNmTokenDefBuff readDerived( CFSecAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamNmTokenDef.readDerived";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamNmTokenDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamNmTokenDefBuff lockDerived( CFSecAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamNmTokenDef.readDerived";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamNmTokenDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamNmTokenDefBuff[] readAllDerived( CFSecAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamNmTokenDef.readAllDerived";
		CFBamNmTokenDefBuff[] retList = new CFBamNmTokenDefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamNmTokenDefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamNmTokenDefBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByUNameIdx";
		CFBamValueBuff buff = schema.getTableValue().readDerivedByUNameIdx( Authorization,
			TenantId,
			ScopeId,
			Name );
		if( buff == null ) {
			return( null );
		}
		else if( buff instanceof CFBamNmTokenDefBuff ) {
			return( (CFBamNmTokenDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByValTentIdx( CFSecAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByValTentIdx";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByValTentIdx( Authorization,
			TenantId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByScopeIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByScopeIdx";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByDefSchemaIdx";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByPrevIdx";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByNextIdx";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByContPrevIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByContPrevIdx";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByContNextIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByContNextIdx";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamNmTokenDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamNmTokenDefBuff readBuff( CFSecAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamNmTokenDef.readBuff";
		CFBamNmTokenDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "NTKD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamNmTokenDefBuff lockBuff( CFSecAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFBamNmTokenDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "NTKD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamNmTokenDefBuff[] readAllBuff( CFSecAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamNmTokenDef.readAllBuff";
		CFBamNmTokenDefBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamNmTokenDefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "NTKD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamNmTokenDefBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamNmTokenDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamNmTokenDefBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByUNameIdx() ";
		CFBamNmTokenDefBuff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			ScopeId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamNmTokenDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamNmTokenDefBuff[] readBuffByValTentIdx( CFSecAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamNmTokenDefBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamNmTokenDefBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff[] readBuffByScopeIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamNmTokenDefBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamNmTokenDefBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamNmTokenDefBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamNmTokenDefBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff[] readBuffByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamNmTokenDefBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamNmTokenDefBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff[] readBuffByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamNmTokenDefBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamNmTokenDefBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff[] readBuffByContPrevIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamNmTokenDefBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamNmTokenDefBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff[] readBuffByContNextIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamNmTokenDefBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamNmTokenDefBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamNmTokenDefBuff moveBuffUp( CFSecAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		final String S_ProcName = "moveBuffUp";

		CFBamValueBuff grandprev = null;
		CFBamValueBuff prev = null;
		CFBamValueBuff cur = null;
		CFBamValueBuff next = null;

		cur = schema.getTableValue().readDerivedByIdIdx(Authorization, TenantId, Id);
		if( cur == null ) {
			throw new CFLibCollisionDetectedException( getClass(),
				S_ProcName,
				"Could not locate object" );
		}

		if( ( cur.getOptionalPrevTenantId() == null )
			&& ( cur.getOptionalPrevId() == null ) )
		{
			return( (CFBamNmTokenDefBuff)cur );
		}

		prev = schema.getTableValue().readDerivedByIdIdx(Authorization, cur.getOptionalPrevTenantId(), cur.getOptionalPrevId() );
		if( prev == null ) {
			throw new CFLibCollisionDetectedException( getClass(),
				S_ProcName,
				"Could not locate object.prev" );
		}

		if( ( prev.getOptionalPrevTenantId() != null )
			&& ( prev.getOptionalPrevId() != null ) )
		{
			grandprev = schema.getTableValue().readDerivedByIdIdx(Authorization, prev.getOptionalPrevTenantId(), prev.getOptionalPrevId() );
			if( grandprev == null ) {
				throw new CFLibCollisionDetectedException( getClass(),
					S_ProcName,
					"Could not locate object.prev.prev" );
			}
		}

		if( ( cur.getOptionalNextTenantId() != null )
			&& ( cur.getOptionalNextId() != null ) )
		{
			next = schema.getTableValue().readDerivedByIdIdx(Authorization, cur.getOptionalNextTenantId(), cur.getOptionalNextId() );
			if( next == null ) {
				throw new CFLibCollisionDetectedException( getClass(),
					S_ProcName,
					"Could not locate object.next" );
			}
		}

		String classCode = prev.getClassCode();
		CFBamValueBuff newInstance;
			if( classCode.equals( "VALU" ) ) {
				newInstance = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				newInstance = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				newInstance = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				newInstance = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				newInstance = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				newInstance = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				newInstance = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				newInstance = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				newInstance = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				newInstance = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				newInstance = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				newInstance = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				newInstance = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				newInstance = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				newInstance = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				newInstance = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				newInstance = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				newInstance = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				newInstance = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				newInstance = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				newInstance = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				newInstance = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				newInstance = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				newInstance = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				newInstance = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				newInstance = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				newInstance = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				newInstance = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				newInstance = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				newInstance = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				newInstance = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				newInstance = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				newInstance = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				newInstance = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				newInstance = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				newInstance = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				newInstance = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				newInstance = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				newInstance = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				newInstance = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				newInstance = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				newInstance = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				newInstance = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				newInstance = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				newInstance = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				newInstance = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				newInstance = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				newInstance = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				newInstance = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				newInstance = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				newInstance = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				newInstance = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				newInstance = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				newInstance = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				newInstance = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				newInstance = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				newInstance = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				newInstance = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				newInstance = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				newInstance = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				newInstance = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				newInstance = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				newInstance = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				newInstance = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				newInstance = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				newInstance = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				newInstance = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				newInstance = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				newInstance = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				newInstance = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				newInstance = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				newInstance = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				newInstance = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				newInstance = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				newInstance = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				newInstance = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				newInstance = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				newInstance = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		CFBamValueBuff editPrev = newInstance;
		editPrev.set( prev );

		classCode = cur.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				newInstance = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				newInstance = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				newInstance = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				newInstance = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				newInstance = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				newInstance = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				newInstance = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				newInstance = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				newInstance = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				newInstance = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				newInstance = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				newInstance = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				newInstance = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				newInstance = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				newInstance = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				newInstance = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				newInstance = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				newInstance = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				newInstance = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				newInstance = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				newInstance = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				newInstance = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				newInstance = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				newInstance = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				newInstance = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				newInstance = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				newInstance = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				newInstance = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				newInstance = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				newInstance = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				newInstance = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				newInstance = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				newInstance = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				newInstance = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				newInstance = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				newInstance = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				newInstance = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				newInstance = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				newInstance = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				newInstance = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				newInstance = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				newInstance = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				newInstance = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				newInstance = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				newInstance = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				newInstance = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				newInstance = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				newInstance = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				newInstance = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				newInstance = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				newInstance = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				newInstance = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				newInstance = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				newInstance = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				newInstance = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				newInstance = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				newInstance = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				newInstance = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				newInstance = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				newInstance = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				newInstance = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				newInstance = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				newInstance = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				newInstance = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				newInstance = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				newInstance = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				newInstance = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				newInstance = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				newInstance = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				newInstance = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				newInstance = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				newInstance = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				newInstance = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				newInstance = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				newInstance = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				newInstance = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				newInstance = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				newInstance = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		CFBamValueBuff editCur = newInstance;
		editCur.set( cur );

		CFBamValueBuff editGrandprev = null;
		if( grandprev != null ) {
			classCode = grandprev.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				newInstance = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				newInstance = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				newInstance = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				newInstance = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				newInstance = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				newInstance = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				newInstance = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				newInstance = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				newInstance = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				newInstance = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				newInstance = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				newInstance = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				newInstance = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				newInstance = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				newInstance = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				newInstance = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				newInstance = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				newInstance = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				newInstance = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				newInstance = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				newInstance = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				newInstance = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				newInstance = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				newInstance = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				newInstance = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				newInstance = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				newInstance = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				newInstance = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				newInstance = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				newInstance = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				newInstance = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				newInstance = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				newInstance = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				newInstance = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				newInstance = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				newInstance = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				newInstance = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				newInstance = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				newInstance = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				newInstance = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				newInstance = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				newInstance = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				newInstance = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				newInstance = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				newInstance = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				newInstance = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				newInstance = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				newInstance = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				newInstance = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				newInstance = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				newInstance = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				newInstance = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				newInstance = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				newInstance = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				newInstance = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				newInstance = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				newInstance = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				newInstance = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				newInstance = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				newInstance = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				newInstance = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				newInstance = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				newInstance = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				newInstance = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				newInstance = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				newInstance = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				newInstance = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				newInstance = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				newInstance = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				newInstance = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				newInstance = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				newInstance = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				newInstance = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				newInstance = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				newInstance = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				newInstance = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				newInstance = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				newInstance = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
			editGrandprev = newInstance;
			editGrandprev.set( grandprev );
		}

		CFBamValueBuff editNext = null;
		if( next != null ) {
			classCode = next.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				newInstance = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				newInstance = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				newInstance = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				newInstance = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				newInstance = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				newInstance = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				newInstance = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				newInstance = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				newInstance = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				newInstance = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				newInstance = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				newInstance = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				newInstance = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				newInstance = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				newInstance = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				newInstance = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				newInstance = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				newInstance = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				newInstance = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				newInstance = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				newInstance = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				newInstance = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				newInstance = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				newInstance = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				newInstance = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				newInstance = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				newInstance = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				newInstance = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				newInstance = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				newInstance = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				newInstance = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				newInstance = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				newInstance = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				newInstance = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				newInstance = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				newInstance = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				newInstance = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				newInstance = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				newInstance = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				newInstance = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				newInstance = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				newInstance = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				newInstance = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				newInstance = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				newInstance = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				newInstance = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				newInstance = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				newInstance = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				newInstance = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				newInstance = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				newInstance = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				newInstance = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				newInstance = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				newInstance = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				newInstance = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				newInstance = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				newInstance = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				newInstance = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				newInstance = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				newInstance = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				newInstance = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				newInstance = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				newInstance = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				newInstance = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				newInstance = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				newInstance = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				newInstance = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				newInstance = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				newInstance = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				newInstance = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				newInstance = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				newInstance = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				newInstance = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				newInstance = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				newInstance = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				newInstance = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				newInstance = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				newInstance = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
			editNext = newInstance;
			editNext.set( next );
		}

		if( editGrandprev != null ) {
			editGrandprev.setOptionalNextTenantId( cur.getRequiredTenantId() );
			editGrandprev.setOptionalNextId( cur.getRequiredId() );
			editCur.setOptionalPrevTenantId( grandprev.getRequiredTenantId() );
			editCur.setOptionalPrevId( grandprev.getRequiredId() );
		}
		else {
			editCur.setOptionalPrevTenantId( null );
			editCur.setOptionalPrevId( null );
		}

			editPrev.setOptionalPrevTenantId( cur.getRequiredTenantId() );
			editPrev.setOptionalPrevId( cur.getRequiredId() );

			editCur.setOptionalNextTenantId( prev.getRequiredTenantId() );
			editCur.setOptionalNextId( prev.getRequiredId() );

		if( next != null ) {
			editPrev.setOptionalNextTenantId( next.getRequiredTenantId() );
			editPrev.setOptionalNextId( next.getRequiredId() );
			editNext.setOptionalPrevTenantId( prev.getRequiredTenantId() );
			editNext.setOptionalPrevId( prev.getRequiredId() );
		}
		else {
			editPrev.setOptionalNextTenantId( null );
			editPrev.setOptionalNextId( null );
		}

		if( editGrandprev != null ) {
			classCode = editGrandprev.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editGrandprev );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editGrandprev );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editGrandprev );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editGrandprev );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editGrandprev );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editGrandprev );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editGrandprev );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editGrandprev );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editGrandprev );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editGrandprev );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editGrandprev );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editGrandprev );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editGrandprev );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editGrandprev );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editGrandprev );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editGrandprev );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editGrandprev );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editGrandprev );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editGrandprev );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editGrandprev );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editGrandprev );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editGrandprev );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editGrandprev );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editGrandprev );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editGrandprev );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editGrandprev );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editGrandprev );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editGrandprev );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editGrandprev );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editGrandprev );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editGrandprev );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editGrandprev );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editGrandprev );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editGrandprev );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editGrandprev );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editGrandprev );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editGrandprev );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editGrandprev );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editGrandprev );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editGrandprev );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editGrandprev );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editGrandprev );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editGrandprev );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editGrandprev );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editGrandprev );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editGrandprev );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editGrandprev );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editGrandprev );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editGrandprev );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editGrandprev );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editGrandprev );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editGrandprev );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editGrandprev );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editGrandprev );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editGrandprev );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editGrandprev );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editGrandprev );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editGrandprev );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editGrandprev );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editGrandprev );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		}

		classCode = editPrev.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editPrev );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editPrev );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editPrev );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editPrev );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editPrev );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editPrev );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editPrev );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editPrev );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editPrev );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editPrev );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editPrev );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editPrev );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editPrev );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editPrev );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editPrev );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editPrev );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editPrev );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editPrev );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editPrev );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editPrev );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editPrev );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editPrev );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editPrev );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editPrev );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editPrev );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editPrev );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editPrev );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editPrev );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editPrev );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editPrev );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editPrev );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editPrev );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editPrev );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editPrev );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editPrev );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editPrev );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editPrev );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editPrev );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editPrev );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editPrev );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editPrev );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editPrev );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editPrev );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editPrev );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editPrev );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editPrev );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editPrev );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editPrev );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editPrev );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editPrev );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editPrev );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editPrev );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editPrev );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editPrev );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editPrev );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editPrev );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editPrev );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editPrev );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editPrev );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editPrev );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editPrev );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editPrev );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editPrev );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editPrev );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editPrev );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editPrev );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editPrev );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editPrev );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editPrev );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editPrev );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editPrev );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editPrev );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editPrev );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editPrev );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editPrev );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editPrev );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editPrev );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editPrev );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}

		classCode = editCur.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editCur );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editCur );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editCur );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editCur );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editCur );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editCur );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editCur );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editCur );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editCur );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editCur );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editCur );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editCur );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editCur );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editCur );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editCur );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editCur );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editCur );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editCur );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editCur );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editCur );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editCur );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editCur );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editCur );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editCur );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editCur );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editCur );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editCur );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editCur );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editCur );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editCur );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editCur );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editCur );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editCur );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editCur );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editCur );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editCur );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editCur );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editCur );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editCur );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editCur );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editCur );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editCur );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editCur );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editCur );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editCur );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editCur );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editCur );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editCur );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editCur );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editCur );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editCur );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editCur );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editCur );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editCur );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editCur );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editCur );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editCur );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editCur );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editCur );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editCur );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editCur );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editCur );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editCur );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editCur );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editCur );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editCur );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editCur );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editCur );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editCur );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editCur );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editCur );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editCur );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editCur );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editCur );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editCur );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editCur );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editCur );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editCur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}

		if( editNext != null ) {
			classCode = editNext.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editNext );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editNext );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editNext );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editNext );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editNext );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editNext );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editNext );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editNext );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editNext );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editNext );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editNext );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editNext );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editNext );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editNext );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editNext );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editNext );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editNext );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editNext );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editNext );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editNext );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editNext );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editNext );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editNext );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editNext );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editNext );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editNext );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editNext );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editNext );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editNext );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editNext );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editNext );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editNext );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editNext );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editNext );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editNext );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editNext );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editNext );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editNext );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editNext );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editNext );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editNext );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editNext );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editNext );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editNext );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editNext );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editNext );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editNext );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editNext );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editNext );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editNext );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editNext );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editNext );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editNext );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editNext );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editNext );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editNext );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editNext );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editNext );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editNext );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editNext );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editNext );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editNext );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editNext );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editNext );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editNext );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editNext );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editNext );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editNext );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editNext );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editNext );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editNext );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editNext );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editNext );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editNext );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editNext );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editNext );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editNext );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editNext );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		}

		return( (CFBamNmTokenDefBuff)editCur );
	}

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamNmTokenDefBuff moveBuffDown( CFSecAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		final String S_ProcName = "moveBuffDown";

		CFBamValueBuff prev = null;
		CFBamValueBuff cur = null;
		CFBamValueBuff next = null;
		CFBamValueBuff grandnext = null;

		cur = schema.getTableValue().readDerivedByIdIdx(Authorization, TenantId, Id);
		if( cur == null ) {
			throw new CFLibCollisionDetectedException( getClass(),
				S_ProcName,
				"Could not locate object" );
		}

		if( ( cur.getOptionalNextTenantId() == null )
			&& ( cur.getOptionalNextId() == null ) )
		{
			return( (CFBamNmTokenDefBuff)cur );
		}

		next = schema.getTableValue().readDerivedByIdIdx(Authorization, cur.getOptionalNextTenantId(), cur.getOptionalNextId() );
		if( next == null ) {
			throw new CFLibCollisionDetectedException( getClass(),
				S_ProcName,
				"Could not locate object.next" );
		}

		if( ( next.getOptionalNextTenantId() != null )
			&& ( next.getOptionalNextId() != null ) )
		{
			grandnext = schema.getTableValue().readDerivedByIdIdx(Authorization, next.getOptionalNextTenantId(), next.getOptionalNextId() );
			if( grandnext == null ) {
				throw new CFLibCollisionDetectedException( getClass(),
					S_ProcName,
					"Could not locate object.next.next" );
			}
		}

		if( ( cur.getOptionalPrevTenantId() != null )
			&& ( cur.getOptionalPrevId() != null ) )
		{
			prev = schema.getTableValue().readDerivedByIdIdx(Authorization, cur.getOptionalPrevTenantId(), cur.getOptionalPrevId() );
			if( prev == null ) {
				throw new CFLibCollisionDetectedException( getClass(),
					S_ProcName,
					"Could not locate object.prev" );
			}
		}

		String classCode = cur.getClassCode();
		CFBamValueBuff newInstance;
			if( classCode.equals( "VALU" ) ) {
				newInstance = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				newInstance = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				newInstance = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				newInstance = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				newInstance = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				newInstance = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				newInstance = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				newInstance = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				newInstance = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				newInstance = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				newInstance = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				newInstance = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				newInstance = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				newInstance = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				newInstance = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				newInstance = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				newInstance = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				newInstance = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				newInstance = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				newInstance = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				newInstance = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				newInstance = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				newInstance = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				newInstance = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				newInstance = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				newInstance = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				newInstance = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				newInstance = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				newInstance = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				newInstance = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				newInstance = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				newInstance = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				newInstance = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				newInstance = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				newInstance = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				newInstance = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				newInstance = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				newInstance = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				newInstance = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				newInstance = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				newInstance = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				newInstance = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				newInstance = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				newInstance = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				newInstance = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				newInstance = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				newInstance = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				newInstance = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				newInstance = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				newInstance = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				newInstance = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				newInstance = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				newInstance = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				newInstance = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				newInstance = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				newInstance = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				newInstance = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				newInstance = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				newInstance = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				newInstance = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				newInstance = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				newInstance = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				newInstance = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				newInstance = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				newInstance = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				newInstance = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				newInstance = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				newInstance = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				newInstance = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				newInstance = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				newInstance = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				newInstance = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				newInstance = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				newInstance = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				newInstance = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				newInstance = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				newInstance = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				newInstance = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		CFBamValueBuff editCur = newInstance;
		editCur.set( cur );

		classCode = next.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				newInstance = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				newInstance = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				newInstance = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				newInstance = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				newInstance = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				newInstance = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				newInstance = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				newInstance = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				newInstance = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				newInstance = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				newInstance = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				newInstance = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				newInstance = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				newInstance = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				newInstance = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				newInstance = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				newInstance = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				newInstance = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				newInstance = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				newInstance = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				newInstance = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				newInstance = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				newInstance = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				newInstance = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				newInstance = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				newInstance = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				newInstance = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				newInstance = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				newInstance = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				newInstance = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				newInstance = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				newInstance = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				newInstance = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				newInstance = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				newInstance = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				newInstance = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				newInstance = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				newInstance = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				newInstance = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				newInstance = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				newInstance = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				newInstance = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				newInstance = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				newInstance = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				newInstance = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				newInstance = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				newInstance = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				newInstance = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				newInstance = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				newInstance = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				newInstance = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				newInstance = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				newInstance = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				newInstance = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				newInstance = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				newInstance = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				newInstance = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				newInstance = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				newInstance = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				newInstance = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				newInstance = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				newInstance = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				newInstance = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				newInstance = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				newInstance = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				newInstance = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				newInstance = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				newInstance = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				newInstance = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				newInstance = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				newInstance = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				newInstance = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				newInstance = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				newInstance = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				newInstance = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				newInstance = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				newInstance = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				newInstance = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		CFBamValueBuff editNext = newInstance;
		editNext.set( next );

		CFBamValueBuff editGrandnext = null;
		if( grandnext != null ) {
			classCode = grandnext.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				newInstance = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				newInstance = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				newInstance = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				newInstance = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				newInstance = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				newInstance = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				newInstance = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				newInstance = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				newInstance = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				newInstance = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				newInstance = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				newInstance = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				newInstance = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				newInstance = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				newInstance = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				newInstance = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				newInstance = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				newInstance = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				newInstance = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				newInstance = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				newInstance = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				newInstance = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				newInstance = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				newInstance = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				newInstance = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				newInstance = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				newInstance = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				newInstance = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				newInstance = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				newInstance = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				newInstance = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				newInstance = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				newInstance = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				newInstance = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				newInstance = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				newInstance = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				newInstance = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				newInstance = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				newInstance = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				newInstance = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				newInstance = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				newInstance = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				newInstance = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				newInstance = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				newInstance = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				newInstance = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				newInstance = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				newInstance = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				newInstance = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				newInstance = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				newInstance = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				newInstance = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				newInstance = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				newInstance = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				newInstance = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				newInstance = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				newInstance = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				newInstance = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				newInstance = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				newInstance = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				newInstance = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				newInstance = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				newInstance = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				newInstance = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				newInstance = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				newInstance = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				newInstance = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				newInstance = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				newInstance = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				newInstance = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				newInstance = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				newInstance = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				newInstance = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				newInstance = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				newInstance = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				newInstance = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				newInstance = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				newInstance = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
			editGrandnext = newInstance;
			editGrandnext.set( grandnext );
		}

		CFBamValueBuff editPrev = null;
		if( prev != null ) {
			classCode = prev.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				newInstance = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				newInstance = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				newInstance = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				newInstance = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				newInstance = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				newInstance = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				newInstance = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				newInstance = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				newInstance = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				newInstance = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				newInstance = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				newInstance = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				newInstance = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				newInstance = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				newInstance = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				newInstance = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				newInstance = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				newInstance = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				newInstance = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				newInstance = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				newInstance = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				newInstance = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				newInstance = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				newInstance = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				newInstance = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				newInstance = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				newInstance = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				newInstance = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				newInstance = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				newInstance = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				newInstance = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				newInstance = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				newInstance = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				newInstance = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				newInstance = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				newInstance = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				newInstance = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				newInstance = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				newInstance = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				newInstance = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				newInstance = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				newInstance = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				newInstance = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				newInstance = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				newInstance = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				newInstance = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				newInstance = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				newInstance = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				newInstance = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				newInstance = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				newInstance = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				newInstance = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				newInstance = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				newInstance = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				newInstance = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				newInstance = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				newInstance = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				newInstance = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				newInstance = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				newInstance = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				newInstance = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				newInstance = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				newInstance = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				newInstance = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				newInstance = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				newInstance = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				newInstance = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				newInstance = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				newInstance = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				newInstance = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				newInstance = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				newInstance = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				newInstance = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				newInstance = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				newInstance = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				newInstance = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				newInstance = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				newInstance = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
			editPrev = newInstance;
			editPrev.set( prev );
		}

		if( prev != null ) {
			editPrev.setOptionalNextTenantId( next.getRequiredTenantId() );
			editPrev.setOptionalNextId( next.getRequiredId() );
			editNext.setOptionalPrevTenantId( prev.getRequiredTenantId() );
			editNext.setOptionalPrevId( prev.getRequiredId() );
		}
		else {
			editNext.setOptionalPrevTenantId( null );
			editNext.setOptionalPrevId( null );
		}

			editCur.setOptionalPrevTenantId( next.getRequiredTenantId() );
			editCur.setOptionalPrevId( next.getRequiredId() );

			editNext.setOptionalNextTenantId( cur.getRequiredTenantId() );
			editNext.setOptionalNextId( cur.getRequiredId() );

		if( editGrandnext != null ) {
			editCur.setOptionalNextTenantId( grandnext.getRequiredTenantId() );
			editCur.setOptionalNextId( grandnext.getRequiredId() );
			editGrandnext.setOptionalPrevTenantId( cur.getRequiredTenantId() );
			editGrandnext.setOptionalPrevId( cur.getRequiredId() );
		}
		else {
			editCur.setOptionalNextTenantId( null );
			editCur.setOptionalNextId( null );
		}

		if( editPrev != null ) {
			classCode = editPrev.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editPrev );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editPrev );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editPrev );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editPrev );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editPrev );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editPrev );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editPrev );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editPrev );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editPrev );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editPrev );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editPrev );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editPrev );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editPrev );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editPrev );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editPrev );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editPrev );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editPrev );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editPrev );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editPrev );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editPrev );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editPrev );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editPrev );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editPrev );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editPrev );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editPrev );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editPrev );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editPrev );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editPrev );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editPrev );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editPrev );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editPrev );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editPrev );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editPrev );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editPrev );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editPrev );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editPrev );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editPrev );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editPrev );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editPrev );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editPrev );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editPrev );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editPrev );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editPrev );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editPrev );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editPrev );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editPrev );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editPrev );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editPrev );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editPrev );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editPrev );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editPrev );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editPrev );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editPrev );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editPrev );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editPrev );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editPrev );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editPrev );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editPrev );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editPrev );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editPrev );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editPrev );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editPrev );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editPrev );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editPrev );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editPrev );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editPrev );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editPrev );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editPrev );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editPrev );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editPrev );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editPrev );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editPrev );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editPrev );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editPrev );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editPrev );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editPrev );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editPrev );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editPrev );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		}

		classCode = editCur.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editCur );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editCur );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editCur );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editCur );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editCur );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editCur );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editCur );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editCur );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editCur );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editCur );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editCur );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editCur );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editCur );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editCur );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editCur );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editCur );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editCur );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editCur );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editCur );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editCur );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editCur );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editCur );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editCur );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editCur );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editCur );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editCur );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editCur );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editCur );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editCur );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editCur );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editCur );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editCur );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editCur );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editCur );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editCur );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editCur );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editCur );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editCur );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editCur );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editCur );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editCur );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editCur );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editCur );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editCur );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editCur );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editCur );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editCur );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editCur );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editCur );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editCur );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editCur );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editCur );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editCur );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editCur );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editCur );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editCur );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editCur );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editCur );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editCur );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editCur );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editCur );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editCur );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editCur );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editCur );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editCur );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editCur );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editCur );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editCur );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editCur );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editCur );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editCur );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editCur );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editCur );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editCur );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editCur );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editCur );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editCur );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editCur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}

		classCode = editNext.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editNext );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editNext );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editNext );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editNext );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editNext );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editNext );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editNext );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editNext );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editNext );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editNext );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editNext );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editNext );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editNext );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editNext );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editNext );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editNext );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editNext );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editNext );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editNext );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editNext );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editNext );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editNext );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editNext );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editNext );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editNext );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editNext );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editNext );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editNext );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editNext );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editNext );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editNext );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editNext );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editNext );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editNext );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editNext );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editNext );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editNext );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editNext );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editNext );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editNext );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editNext );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editNext );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editNext );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editNext );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editNext );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editNext );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editNext );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editNext );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editNext );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editNext );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editNext );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editNext );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editNext );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editNext );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editNext );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editNext );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editNext );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editNext );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editNext );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editNext );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editNext );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editNext );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editNext );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editNext );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editNext );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editNext );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editNext );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editNext );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editNext );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editNext );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editNext );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editNext );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editNext );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editNext );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editNext );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editNext );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editNext );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editNext );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}

		if( editGrandnext != null ) {
			classCode = editGrandnext.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editGrandnext );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editGrandnext );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editGrandnext );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editGrandnext );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editGrandnext );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editGrandnext );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editGrandnext );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editGrandnext );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editGrandnext );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editGrandnext );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editGrandnext );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editGrandnext );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editGrandnext );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editGrandnext );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editGrandnext );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editGrandnext );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editGrandnext );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editGrandnext );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editGrandnext );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editGrandnext );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editGrandnext );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editGrandnext );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editGrandnext );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editGrandnext );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editGrandnext );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editGrandnext );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editGrandnext );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editGrandnext );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editGrandnext );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editGrandnext );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editGrandnext );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editGrandnext );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editGrandnext );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editGrandnext );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editGrandnext );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editGrandnext );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editGrandnext );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editGrandnext );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editGrandnext );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editGrandnext );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editGrandnext );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editGrandnext );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editGrandnext );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editGrandnext );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editGrandnext );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editGrandnext );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editGrandnext );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editGrandnext );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editGrandnext );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editGrandnext );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editGrandnext );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editGrandnext );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editGrandnext );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editGrandnext );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editGrandnext );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editGrandnext );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editGrandnext );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editGrandnext );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editGrandnext );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editGrandnext );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		}

		return( (CFBamNmTokenDefBuff)editCur );
	}

	public void updateNmTokenDef( CFSecAuthorization Authorization,
		CFBamNmTokenDefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamNmTokenDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateNmTokenDef",
				"Existing record not found",
				"NmTokenDef",
				pkey );
		}
		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableAtom().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateNmTokenDef",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid

		Map< CFBamValuePKey, CFBamNmTokenDefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteNmTokenDef( CFSecAuthorization Authorization,
		CFBamNmTokenDefBuff Buff )
	{
		final String S_ProcName = "CFBamRamNmTokenDefTable.deleteNmTokenDef() ";
		String classCode;
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamNmTokenDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteNmTokenDef",
				pkey );
		}
		long varTenantId = existing.getRequiredTenantId();
		long varScopeId = existing.getRequiredScopeId();
		CFBamScopeBuff container = schema.getTableScope().readDerivedByIdIdx( Authorization,
			varTenantId,
			varScopeId );
		if( container == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				0,
				"container" );
		}

		Long prevTenantId = existing.getOptionalPrevTenantId();
		Long prevId = existing.getOptionalPrevId();
		Long nextTenantId = existing.getOptionalNextTenantId();
		Long nextId = existing.getOptionalNextId();

		CFBamValueBuff prev = null;
		if( ( prevTenantId != null )
			&& ( prevId != null ) )
		{
			prev = schema.getTableValue().readDerivedByIdIdx( Authorization,
				prevTenantId,
				prevId );
			if( prev == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"prev" );
			}
			CFBamValueBuff editPrev;
			classCode = prev.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				editPrev = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				editPrev = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				editPrev = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				editPrev = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				editPrev = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				editPrev = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				editPrev = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				editPrev = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				editPrev = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				editPrev = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				editPrev = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				editPrev = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				editPrev = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				editPrev = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				editPrev = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				editPrev = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				editPrev = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				editPrev = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				editPrev = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				editPrev = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				editPrev = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				editPrev = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				editPrev = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				editPrev = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				editPrev = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				editPrev = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				editPrev = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				editPrev = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				editPrev = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				editPrev = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				editPrev = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				editPrev = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				editPrev = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				editPrev = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				editPrev = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				editPrev = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				editPrev = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				editPrev = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				editPrev = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				editPrev = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				editPrev = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				editPrev = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				editPrev = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				editPrev = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				editPrev = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				editPrev = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				editPrev = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				editPrev = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				editPrev = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				editPrev = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				editPrev = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				editPrev = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				editPrev = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				editPrev = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				editPrev = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				editPrev = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				editPrev = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				editPrev = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				editPrev = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				editPrev = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				editPrev = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				editPrev = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				editPrev = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				editPrev = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				editPrev = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				editPrev = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				editPrev = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				editPrev = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				editPrev = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				editPrev = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				editPrev = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				editPrev = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				editPrev = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				editPrev = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				editPrev = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				editPrev = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				editPrev = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				editPrev = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
			editPrev.set( prev );
			editPrev.setOptionalNextTenantId( nextTenantId );
			editPrev.setOptionalNextId( nextId );
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editPrev );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editPrev );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editPrev );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editPrev );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editPrev );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editPrev );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editPrev );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editPrev );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editPrev );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editPrev );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editPrev );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editPrev );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editPrev );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editPrev );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editPrev );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editPrev );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editPrev );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editPrev );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editPrev );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editPrev );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editPrev );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editPrev );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editPrev );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editPrev );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editPrev );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editPrev );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editPrev );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editPrev );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editPrev );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editPrev );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editPrev );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editPrev );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editPrev );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editPrev );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editPrev );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editPrev );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editPrev );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editPrev );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editPrev );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editPrev );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editPrev );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editPrev );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editPrev );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editPrev );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editPrev );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editPrev );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editPrev );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editPrev );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editPrev );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editPrev );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editPrev );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editPrev );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editPrev );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editPrev );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editPrev );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editPrev );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editPrev );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editPrev );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editPrev );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editPrev );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editPrev );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editPrev );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editPrev );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editPrev );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editPrev );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editPrev );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editPrev );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editPrev );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editPrev );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editPrev );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editPrev );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editPrev );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editPrev );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editPrev );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editPrev );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editPrev );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editPrev );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editPrev );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		}

		CFBamValueBuff next = null;
		if( ( nextTenantId != null )
			&& ( nextId != null ) )
		{
			next = schema.getTableValue().readDerivedByIdIdx( Authorization,
				nextTenantId,
				nextId );
			if( next == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"next" );
			}
			CFBamValueBuff editNext;
			classCode = next.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				editNext = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				editNext = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				editNext = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				editNext = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				editNext = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				editNext = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				editNext = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				editNext = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				editNext = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				editNext = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				editNext = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				editNext = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				editNext = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				editNext = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				editNext = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				editNext = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				editNext = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				editNext = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				editNext = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				editNext = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				editNext = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				editNext = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				editNext = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				editNext = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				editNext = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				editNext = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				editNext = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				editNext = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				editNext = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				editNext = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				editNext = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				editNext = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				editNext = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				editNext = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				editNext = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				editNext = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				editNext = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				editNext = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				editNext = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				editNext = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				editNext = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				editNext = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				editNext = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				editNext = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				editNext = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				editNext = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				editNext = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				editNext = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				editNext = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				editNext = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				editNext = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				editNext = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				editNext = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				editNext = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				editNext = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				editNext = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				editNext = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				editNext = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				editNext = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				editNext = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				editNext = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				editNext = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				editNext = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				editNext = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				editNext = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				editNext = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				editNext = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				editNext = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				editNext = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				editNext = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				editNext = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				editNext = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				editNext = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				editNext = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				editNext = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				editNext = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				editNext = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				editNext = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
			editNext.set( next );
			editNext.setOptionalPrevTenantId( prevTenantId );
			editNext.setOptionalPrevId( prevId );
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editNext );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editNext );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editNext );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editNext );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editNext );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editNext );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editNext );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editNext );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editNext );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editNext );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editNext );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editNext );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editNext );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editNext );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editNext );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editNext );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editNext );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editNext );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editNext );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editNext );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editNext );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editNext );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editNext );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editNext );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editNext );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editNext );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editNext );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editNext );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editNext );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editNext );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editNext );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editNext );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editNext );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editNext );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editNext );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editNext );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editNext );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editNext );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editNext );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editNext );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editNext );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editNext );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editNext );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editNext );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editNext );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editNext );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editNext );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editNext );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editNext );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editNext );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editNext );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editNext );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editNext );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editNext );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editNext );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editNext );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editNext );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editNext );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editNext );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editNext );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editNext );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editNext );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editNext );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editNext );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editNext );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editNext );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editNext );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editNext );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editNext );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editNext );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editNext );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editNext );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editNext );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editNext );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editNext );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editNext );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editNext );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editNext );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		}

		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckReferencingTableCols[] = schema.getTableTableCol().readDerivedByDataIdx( Authorization,
						existing.getRequiredTenantId(),
						existing.getRequiredId() );
		if( arrCheckReferencingTableCols.length > 0 ) {
			schema.getTableTableCol().deleteTableColByDataIdx( Authorization,
						existing.getRequiredTenantId(),
						existing.getRequiredId() );
		}
		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckReferencingIndexCols[] = schema.getTableIndexCol().readDerivedByColIdx( Authorization,
						existing.getRequiredTenantId(),
						existing.getRequiredId() );
		if( arrCheckReferencingIndexCols.length > 0 ) {
			schema.getTableIndexCol().deleteIndexColByColIdx( Authorization,
						existing.getRequiredTenantId(),
						existing.getRequiredId() );
		}
		// Validate reverse foreign keys

		if( schema.getTableNmTokenType().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteNmTokenDef",
				"Superclass",
				"SuperClass",
				"NmTokenType",
				pkey );
		}

		if( schema.getTableNmTokenCol().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw new CFLibDependentsDetectedException( getClass(),
				"deleteNmTokenDef",
				"Superclass",
				"SuperClass",
				"NmTokenCol",
				pkey );
		}

		// Delete is valid
		Map< CFBamValuePKey, CFBamNmTokenDefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}
	public void deleteNmTokenDefByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteNmTokenDefByIdIdx( Authorization, key );
	}

	public void deleteNmTokenDefByIdIdx( CFSecAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByIdIdx";
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFBamNmTokenDefBuff cur;
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableNmTokenDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByUNameIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteNmTokenDefByUNameIdx( Authorization, key );
	}

	public void deleteNmTokenDefByUNameIdx( CFSecAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByUNameIdx";
		CFBamNmTokenDefBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableNmTokenDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByValTentIdx( CFSecAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteNmTokenDefByValTentIdx( Authorization, key );
	}

	public void deleteNmTokenDefByValTentIdx( CFSecAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByValTentIdx";
		CFBamNmTokenDefBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableNmTokenDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByScopeIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteNmTokenDefByScopeIdx( Authorization, key );
	}

	public void deleteNmTokenDefByScopeIdx( CFSecAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByScopeIdx";
		CFBamNmTokenDefBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableNmTokenDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteNmTokenDefByDefSchemaIdx( Authorization, key );
	}

	public void deleteNmTokenDefByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByDefSchemaIdx";
		CFBamNmTokenDefBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableNmTokenDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByPrevIdx( CFSecAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteNmTokenDefByPrevIdx( Authorization, key );
	}

	public void deleteNmTokenDefByPrevIdx( CFSecAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByPrevIdx";
		CFBamNmTokenDefBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalPrevTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalPrevId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableNmTokenDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByNextIdx( CFSecAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteNmTokenDefByNextIdx( Authorization, key );
	}

	public void deleteNmTokenDefByNextIdx( CFSecAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByNextIdx";
		CFBamNmTokenDefBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalNextTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalNextId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableNmTokenDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByContPrevIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteNmTokenDefByContPrevIdx( Authorization, key );
	}

	public void deleteNmTokenDefByContPrevIdx( CFSecAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByContPrevIdx";
		CFBamNmTokenDefBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( argKey.getOptionalPrevId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableNmTokenDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByContNextIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteNmTokenDefByContNextIdx( Authorization, key );
	}

	public void deleteNmTokenDefByContNextIdx( CFSecAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByContNextIdx";
		CFBamNmTokenDefBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( argKey.getOptionalNextId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableNmTokenDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void releasePreparedStatements() {
	}
}
