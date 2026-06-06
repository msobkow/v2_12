// Description: Java 11 Table Object implementation for CFInt.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;

public class CFIntTldTableObj
	implements ICFIntTldTableObj
{
	protected ICFIntSchemaObj schema;
	private Map<CFIntTldPKey, ICFIntTldObj> members;
	private Map<CFIntTldPKey, ICFIntTldObj> allTld;
	private Map< CFIntTldByTenantIdxKey,
		Map<CFIntTldPKey, ICFIntTldObj > > indexByTenantIdx;
	private Map< CFIntTldByNameIdxKey,
		ICFIntTldObj > indexByNameIdx;
	public static String TABLE_NAME = "Tld";
	public static String TABLE_DBNAME = "tlddef";

	public CFIntTldTableObj() {
		schema = null;
		members = new HashMap<CFIntTldPKey, ICFIntTldObj>();
		allTld = null;
		indexByTenantIdx = null;
		indexByNameIdx = null;
	}

	public CFIntTldTableObj( ICFIntSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFIntTldPKey, ICFIntTldObj>();
		allTld = null;
		indexByTenantIdx = null;
		indexByNameIdx = null;
	}

	public ICFIntSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFIntSchemaObj value ) {
		schema = value;
	}

	public String getTableName() {
		return( TABLE_NAME );
	}

	public String getTableDbName() {
		return( TABLE_DBNAME );
	}

	public Class getObjQualifyingClass() {
		return( ICFIntTenantObj.class );
	}


	public void minimizeMemory() {
		allTld = null;
		indexByTenantIdx = null;
		indexByNameIdx = null;
		List<ICFIntTldObj> toForget = new LinkedList<ICFIntTldObj>();
		ICFIntTldObj cur = null;
		Iterator<ICFIntTldObj> iter = members.values().iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			toForget.add( cur );
		}
		iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget();
		}
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFIntTldObj.
	 */
	public ICFIntTldObj newInstance() {
		ICFIntTldObj inst = new CFIntTldObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFIntTldObj.
	 */
	public ICFIntTldEditObj newEditInstance( ICFIntTldObj orig ) {
		ICFIntTldEditObj edit = new CFIntTldEditObj( orig );
		return( edit );
	}

	public ICFIntTldObj realiseTld( ICFIntTldObj Obj ) {
		ICFIntTldObj obj = Obj;
		CFIntTldPKey pkey = obj.getPKey();
		ICFIntTldObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFIntTldObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFIntTldByTenantIdxKey keyTenantIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntTldPKey, ICFIntTldObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				CFIntTldByNameIdxKey keyNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFIntTldByTenantIdxKey keyTenantIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntTldPKey, ICFIntTldObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFIntTldByNameIdxKey keyNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

			if( allTld != null ) {
				allTld.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTld != null ) {
				allTld.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFIntTldByTenantIdxKey keyTenantIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntTldPKey, ICFIntTldObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFIntTldByNameIdxKey keyNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetTld( ICFIntTldObj Obj ) {
		forgetTld( Obj, false );
	}

	public void forgetTld( ICFIntTldObj Obj, boolean forgetSubObjects ) {
		ICFIntTldObj obj = Obj;
		CFIntTldPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFIntTldObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFIntTldByTenantIdxKey keyTenantIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntTldPKey, ICFIntTldObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				CFIntTldByNameIdxKey keyNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( allTld != null ) {
				allTld.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFIntSchemaObj)schema).getTopDomainTableObj().forgetTopDomainByTldIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
	}

	public void forgetTldByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFIntTldPKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFIntTldObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTldByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFIntTldObj> toForget = new LinkedList<ICFIntTldObj>();
		ICFIntTldObj cur = null;
		CFIntTldByTenantIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFIntTldPKey, ICFIntTldObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFIntTldObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFIntTldObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFIntTldObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTldByNameIdx( long TenantId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			return;
		}
		List<ICFIntTldObj> toForget = new LinkedList<ICFIntTldObj>();
		ICFIntTldObj cur = null;
		CFIntTldByNameIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		if( indexByNameIdx.containsKey( key ) ) {
			cur = indexByNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFIntTldObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFIntTldObj createTld( ICFIntTldObj Obj ) {
		ICFIntTldObj obj = Obj;
		CFIntTldBuff buff = obj.getTldBuff();
		((ICFIntSchema)schema.getBackingStore()).getTableTld().createTld(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFIntTldObj readTld( CFIntTldPKey pkey ) {
		return( readTld( pkey, false ) );
	}

	public ICFIntTldObj readTld( CFIntTldPKey pkey, boolean forceRead ) {
		ICFIntTldObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFIntTldBuff readBuff = ((ICFIntSchema)schema.getBackingStore()).getTableTld().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getTldTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFIntTldObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFIntTldObj lockTld( CFIntTldPKey pkey ) {
		ICFIntTldObj locked = null;
		CFIntTldBuff lockBuff = ((ICFIntSchema)schema.getBackingStore()).getTableTld().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getTldTableObj().newInstance();
			locked.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFIntTldObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockTld", pkey );
		}
		return( locked );
	}

	public List<ICFIntTldObj> readAllTld() {
		return( readAllTld( false ) );
	}

	public List<ICFIntTldObj> readAllTld( boolean forceRead ) {
		final String S_ProcName = "readAllTld";
		if( ( allTld == null ) || forceRead ) {
			Map<CFIntTldPKey, ICFIntTldObj> map = new HashMap<CFIntTldPKey,ICFIntTldObj>();
			allTld = map;
			CFIntTldBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableTld().readAllDerived( schema.getAuthorization() );
			CFIntTldBuff buff;
			ICFIntTldObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newPKey() );
				obj.setBuff( buff );
				ICFIntTldObj realised = (ICFIntTldObj)obj.realise();
			}
		}
		int len = allTld.size();
		ICFIntTldObj arr[] = new ICFIntTldObj[len];
		Iterator<ICFIntTldObj> valIter = allTld.values().iterator();
		int idx = 0;
		while( ( idx < len ) && valIter.hasNext() ) {
			arr[idx++] = valIter.next();
		}
		if( idx < len ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"idx",
				idx,
				len );
		}
		else if( valIter.hasNext() ) {
			throw new CFLibArgumentOverflowException( getClass(),
					S_ProcName,
					0,
					"idx",
					idx,
					len );
		}
		ArrayList<ICFIntTldObj> arrayList = new ArrayList<ICFIntTldObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFIntTldObj> cmp = new Comparator<ICFIntTldObj>() {
			public int compare( ICFIntTldObj lhs, ICFIntTldObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					CFIntTldPKey lhsPKey = lhs.getPKey();
					CFIntTldPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFIntTldObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFIntTldObj readTldByIdIdx( long TenantId,
		long Id )
	{
		return( readTldByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFIntTldObj readTldByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFIntTldPKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFIntTldObj obj = readTld( pkey, forceRead );
		return( obj );
	}

	public List<ICFIntTldObj> readTldByTenantIdx( long TenantId )
	{
		return( readTldByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFIntTldObj> readTldByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTldByTenantIdx";
		CFIntTldByTenantIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFIntTldPKey, ICFIntTldObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFIntTldByTenantIdxKey,
				Map< CFIntTldPKey, ICFIntTldObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFIntTldPKey, ICFIntTldObj>();
			ICFIntTldObj obj;
			CFIntTldBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableTld().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFIntTldBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTldTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newPKey() );
				obj.setBuff( buff );
				ICFIntTldObj realised = (ICFIntTldObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFIntTldObj arr[] = new ICFIntTldObj[len];
		Iterator<ICFIntTldObj> valIter = dict.values().iterator();
		int idx = 0;
		while( ( idx < len ) && valIter.hasNext() ) {
			arr[idx++] = valIter.next();
		}
		if( idx < len ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"idx",
				idx,
				len );
		}
		else if( valIter.hasNext() ) {
			throw new CFLibArgumentOverflowException( getClass(),
					S_ProcName,
					0,
					"idx",
					idx,
					len );
		}
		ArrayList<ICFIntTldObj> arrayList = new ArrayList<ICFIntTldObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFIntTldObj> cmp = new Comparator<ICFIntTldObj>() {
			public int compare( ICFIntTldObj lhs, ICFIntTldObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					CFIntTldPKey lhsPKey = lhs.getPKey();
					CFIntTldPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFIntTldObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFIntTldObj readTldByNameIdx( long TenantId,
		String Name )
	{
		return( readTldByNameIdx( TenantId,
			Name,
			false ) );
	}

	public ICFIntTldObj readTldByNameIdx( long TenantId,
		String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFIntTldByNameIdxKey,
				ICFIntTldObj >();
		}
		CFIntTldByNameIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		ICFIntTldObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			CFIntTldBuff buff = ((ICFIntSchema)schema.getBackingStore()).getTableTld().readDerivedByNameIdx( schema.getAuthorization(),
				TenantId,
				Name );
			if( buff != null ) {
				obj = schema.getTldTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newPKey() );
				obj.setBuff( buff );
				obj = (ICFIntTldObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFIntTldObj updateTld( ICFIntTldObj Obj ) {
		ICFIntTldObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableTld().updateTld( schema.getAuthorization(),
			Obj.getTldBuff() );
		obj = (ICFIntTldObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteTld( ICFIntTldObj Obj ) {
		ICFIntTldObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableTld().deleteTld( schema.getAuthorization(),
			obj.getTldBuff() );
		obj.forget( true );
	}

	public void deleteTldByIdIdx( long TenantId,
		long Id )
	{
		CFIntTldPKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFIntTldObj obj = readTld( pkey );
		if( obj != null ) {
			ICFIntTldEditObj editObj = (ICFIntTldEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFIntTldEditObj)obj.beginEdit();
				if( editObj != null ) {
					editStarted = true;
				}
				else {
					editStarted = false;
				}
			}
			else {
				editStarted = false;
			}
			if( editObj != null ) {
				editObj.deleteInstance();
				if( editStarted ) {
					editObj.endEdit();
				}
			}
			obj.forget( true );
		}
	}

	public void deleteTldByTenantIdx( long TenantId )
	{
		CFIntTldByTenantIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFIntTldByTenantIdxKey,
				Map< CFIntTldPKey, ICFIntTldObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFIntTldPKey, ICFIntTldObj> dict = indexByTenantIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableTld().deleteTldByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFIntTldObj> iter = dict.values().iterator();
			ICFIntTldObj obj;
			List<ICFIntTldObj> toForget = new LinkedList<ICFIntTldObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByTenantIdx.remove( key );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableTld().deleteTldByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTldByNameIdx( long TenantId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFIntTldByNameIdxKey,
				ICFIntTldObj >();
		}
		CFIntTldByNameIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTld().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		ICFIntTldObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableTld().deleteTldByNameIdx( schema.getAuthorization(),
				TenantId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableTld().deleteTldByNameIdx( schema.getAuthorization(),
				TenantId,
				Name );
		}
	}
}
