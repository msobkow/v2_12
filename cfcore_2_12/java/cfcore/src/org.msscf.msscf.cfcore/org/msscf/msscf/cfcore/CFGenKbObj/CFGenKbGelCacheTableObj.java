// Description: Java 11 Table Object implementation for CFGenKb.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public class CFGenKbGelCacheTableObj
	implements ICFGenKbGelCacheTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbGelCachePKey, ICFGenKbGelCacheObj> members;
	private Map<CFGenKbGelCachePKey, ICFGenKbGelCacheObj> allGelCache;
	private Map< CFGenKbGelCacheByTenantIdxKey,
		Map<CFGenKbGelCachePKey, ICFGenKbGelCacheObj > > indexByTenantIdx;
	private Map< CFGenKbGelCacheByAltIdxKey,
		ICFGenKbGelCacheObj > indexByAltIdx;
	public static String TABLE_NAME = "GelCache";
	public static String TABLE_DBNAME = "gelcache";

	public CFGenKbGelCacheTableObj() {
		schema = null;
		members = new HashMap<CFGenKbGelCachePKey, ICFGenKbGelCacheObj>();
		allGelCache = null;
		indexByTenantIdx = null;
		indexByAltIdx = null;
	}

	public CFGenKbGelCacheTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbGelCachePKey, ICFGenKbGelCacheObj>();
		allGelCache = null;
		indexByTenantIdx = null;
		indexByAltIdx = null;
	}

	public ICFGenKbSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFGenKbSchemaObj value ) {
		schema = value;
	}

	public String getTableName() {
		return( TABLE_NAME );
	}

	public String getTableDbName() {
		return( TABLE_DBNAME );
	}

	public Class getObjQualifyingClass() {
		return( null );
	}


	public void minimizeMemory() {
		allGelCache = null;
		indexByTenantIdx = null;
		indexByAltIdx = null;
		List<ICFGenKbGelCacheObj> toForget = new LinkedList<ICFGenKbGelCacheObj>();
		ICFGenKbGelCacheObj cur = null;
		Iterator<ICFGenKbGelCacheObj> iter = members.values().iterator();
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
	 *	CFGenKbGelCacheObj.
	 */
	public ICFGenKbGelCacheObj newInstance() {
		ICFGenKbGelCacheObj inst = new CFGenKbGelCacheObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbGelCacheObj.
	 */
	public ICFGenKbGelCacheEditObj newEditInstance( ICFGenKbGelCacheObj orig ) {
		ICFGenKbGelCacheEditObj edit = new CFGenKbGelCacheEditObj( orig );
		return( edit );
	}

	public ICFGenKbGelCacheObj realiseGelCache( ICFGenKbGelCacheObj Obj ) {
		ICFGenKbGelCacheObj obj = Obj;
		CFGenKbGelCachePKey pkey = obj.getPKey();
		ICFGenKbGelCacheObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbGelCacheObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFGenKbGelCacheByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelCachePKey, ICFGenKbGelCacheObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByAltIdx != null ) {
				CFGenKbGelCacheByAltIdxKey keyAltIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newAltIdxKey();
				keyAltIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyAltIdx.setRequiredCacheName( keepObj.getRequiredCacheName() );
				indexByAltIdx.remove( keyAltIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFGenKbGelCacheByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelCachePKey, ICFGenKbGelCacheObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByAltIdx != null ) {
				CFGenKbGelCacheByAltIdxKey keyAltIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newAltIdxKey();
				keyAltIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyAltIdx.setRequiredCacheName( keepObj.getRequiredCacheName() );
				indexByAltIdx.put( keyAltIdx, keepObj );
			}

			if( allGelCache != null ) {
				allGelCache.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allGelCache != null ) {
				allGelCache.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFGenKbGelCacheByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelCachePKey, ICFGenKbGelCacheObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByAltIdx != null ) {
				CFGenKbGelCacheByAltIdxKey keyAltIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newAltIdxKey();
				keyAltIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyAltIdx.setRequiredCacheName( keepObj.getRequiredCacheName() );
				indexByAltIdx.put( keyAltIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetGelCache( ICFGenKbGelCacheObj Obj ) {
		forgetGelCache( Obj, false );
	}

	public void forgetGelCache( ICFGenKbGelCacheObj Obj, boolean forgetSubObjects ) {
		ICFGenKbGelCacheObj obj = Obj;
		CFGenKbGelCachePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbGelCacheObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFGenKbGelCacheByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelCachePKey, ICFGenKbGelCacheObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByAltIdx != null ) {
				CFGenKbGelCacheByAltIdxKey keyAltIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newAltIdxKey();
				keyAltIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyAltIdx.setRequiredCacheName( keepObj.getRequiredCacheName() );
				indexByAltIdx.remove( keyAltIdx );
			}

			if( allGelCache != null ) {
				allGelCache.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetGelCacheByIdIdx( long TenantId,
		long GelCacheId )
	{
		if( members == null ) {
			return;
		}
		CFGenKbGelCachePKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		if( members.containsKey( key ) ) {
			ICFGenKbGelCacheObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetGelCacheByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFGenKbGelCacheObj> toForget = new LinkedList<ICFGenKbGelCacheObj>();
		ICFGenKbGelCacheObj cur = null;
		CFGenKbGelCacheByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGelCachePKey, ICFGenKbGelCacheObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFGenKbGelCacheObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelCacheObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelCacheObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelCacheByAltIdx( long TenantId,
		String CacheName )
	{
		if( indexByAltIdx == null ) {
			return;
		}
		List<ICFGenKbGelCacheObj> toForget = new LinkedList<ICFGenKbGelCacheObj>();
		ICFGenKbGelCacheObj cur = null;
		CFGenKbGelCacheByAltIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newAltIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCacheName( CacheName );
		if( indexByAltIdx.containsKey( key ) ) {
			cur = indexByAltIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFGenKbGelCacheObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbGelCacheObj createGelCache( ICFGenKbGelCacheObj Obj ) {
		ICFGenKbGelCacheObj obj = Obj;
		CFGenKbGelCacheBuff buff = obj.getGelCacheBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelCache().createGelCache(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbGelCacheObj readGelCache( CFGenKbGelCachePKey pkey ) {
		return( readGelCache( pkey, false ) );
	}

	public ICFGenKbGelCacheObj readGelCache( CFGenKbGelCachePKey pkey, boolean forceRead ) {
		ICFGenKbGelCacheObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbGelCacheBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelCache().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredGelCacheId() );
			if( readBuff != null ) {
				obj = schema.getGelCacheTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbGelCacheObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbGelCacheObj lockGelCache( CFGenKbGelCachePKey pkey ) {
		ICFGenKbGelCacheObj locked = null;
		CFGenKbGelCacheBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelCache().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getGelCacheTableObj().newInstance();
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbGelCacheObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockGelCache", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbGelCacheObj> readAllGelCache() {
		return( readAllGelCache( false ) );
	}

	public List<ICFGenKbGelCacheObj> readAllGelCache( boolean forceRead ) {
		final String S_ProcName = "readAllGelCache";
		if( ( allGelCache == null ) || forceRead ) {
			Map<CFGenKbGelCachePKey, ICFGenKbGelCacheObj> map = new HashMap<CFGenKbGelCachePKey,ICFGenKbGelCacheObj>();
			allGelCache = map;
			CFGenKbGelCacheBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelCache().readAllDerived( schema.getAuthorization() );
			CFGenKbGelCacheBuff buff;
			ICFGenKbGelCacheObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelCacheObj realised = (ICFGenKbGelCacheObj)obj.realise();
			}
		}
		int len = allGelCache.size();
		ICFGenKbGelCacheObj arr[] = new ICFGenKbGelCacheObj[len];
		Iterator<ICFGenKbGelCacheObj> valIter = allGelCache.values().iterator();
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
		ArrayList<ICFGenKbGelCacheObj> arrayList = new ArrayList<ICFGenKbGelCacheObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelCacheObj> cmp = new Comparator<ICFGenKbGelCacheObj>() {
			public int compare( ICFGenKbGelCacheObj lhs, ICFGenKbGelCacheObj rhs ) {
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
					CFGenKbGelCachePKey lhsPKey = lhs.getPKey();
					CFGenKbGelCachePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGelCacheObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGelCacheObj readGelCacheByIdIdx( long TenantId,
		long GelCacheId )
	{
		return( readGelCacheByIdIdx( TenantId,
			GelCacheId,
			false ) );
	}

	public ICFGenKbGelCacheObj readGelCacheByIdIdx( long TenantId,
		long GelCacheId, boolean forceRead )
	{
		CFGenKbGelCachePKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredGelCacheId( GelCacheId );
		ICFGenKbGelCacheObj obj = readGelCache( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbGelCacheObj> readGelCacheByTenantIdx( long TenantId )
	{
		return( readGelCacheByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFGenKbGelCacheObj> readGelCacheByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelCacheByTenantIdx";
		CFGenKbGelCacheByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFGenKbGelCachePKey, ICFGenKbGelCacheObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGelCacheByTenantIdxKey,
				Map< CFGenKbGelCachePKey, ICFGenKbGelCacheObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelCachePKey, ICFGenKbGelCacheObj>();
			ICFGenKbGelCacheObj obj;
			CFGenKbGelCacheBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelCache().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFGenKbGelCacheBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getGelCacheTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelCacheObj realised = (ICFGenKbGelCacheObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelCacheObj arr[] = new ICFGenKbGelCacheObj[len];
		Iterator<ICFGenKbGelCacheObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelCacheObj> arrayList = new ArrayList<ICFGenKbGelCacheObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelCacheObj> cmp = new Comparator<ICFGenKbGelCacheObj>() {
			public int compare( ICFGenKbGelCacheObj lhs, ICFGenKbGelCacheObj rhs ) {
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
					CFGenKbGelCachePKey lhsPKey = lhs.getPKey();
					CFGenKbGelCachePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGelCacheObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGelCacheObj readGelCacheByAltIdx( long TenantId,
		String CacheName )
	{
		return( readGelCacheByAltIdx( TenantId,
			CacheName,
			false ) );
	}

	public ICFGenKbGelCacheObj readGelCacheByAltIdx( long TenantId,
		String CacheName, boolean forceRead )
	{
		if( indexByAltIdx == null ) {
			indexByAltIdx = new HashMap< CFGenKbGelCacheByAltIdxKey,
				ICFGenKbGelCacheObj >();
		}
		CFGenKbGelCacheByAltIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newAltIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCacheName( CacheName );
		ICFGenKbGelCacheObj obj = null;
		if( ( ! forceRead ) && indexByAltIdx.containsKey( key ) ) {
			obj = indexByAltIdx.get( key );
		}
		else {
			CFGenKbGelCacheBuff buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelCache().readDerivedByAltIdx( schema.getAuthorization(),
				TenantId,
				CacheName );
			if( buff != null ) {
				obj = schema.getGelCacheTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newPKey() );
				obj.setBuff( buff );
				obj = (ICFGenKbGelCacheObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbGelCacheObj updateGelCache( ICFGenKbGelCacheObj Obj ) {
		ICFGenKbGelCacheObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelCache().updateGelCache( schema.getAuthorization(),
			Obj.getGelCacheBuff() );
		obj = (ICFGenKbGelCacheObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteGelCache( ICFGenKbGelCacheObj Obj ) {
		ICFGenKbGelCacheObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelCache().deleteGelCache( schema.getAuthorization(),
			obj.getGelCacheBuff() );
		obj.forget( true );
	}

	public void deleteGelCacheByIdIdx( long TenantId,
		long GelCacheId )
	{
		CFGenKbGelCachePKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredGelCacheId( GelCacheId );
		ICFGenKbGelCacheObj obj = readGelCache( pkey );
		if( obj != null ) {
			ICFGenKbGelCacheEditObj editObj = (ICFGenKbGelCacheEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbGelCacheEditObj)obj.beginEdit();
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

	public void deleteGelCacheByTenantIdx( long TenantId )
	{
		CFGenKbGelCacheByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGelCacheByTenantIdxKey,
				Map< CFGenKbGelCachePKey, ICFGenKbGelCacheObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGelCachePKey, ICFGenKbGelCacheObj> dict = indexByTenantIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCache().deleteGelCacheByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFGenKbGelCacheObj> iter = dict.values().iterator();
			ICFGenKbGelCacheObj obj;
			List<ICFGenKbGelCacheObj> toForget = new LinkedList<ICFGenKbGelCacheObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCache().deleteGelCacheByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteGelCacheByAltIdx( long TenantId,
		String CacheName )
	{
		if( indexByAltIdx == null ) {
			indexByAltIdx = new HashMap< CFGenKbGelCacheByAltIdxKey,
				ICFGenKbGelCacheObj >();
		}
		CFGenKbGelCacheByAltIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCache().newAltIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCacheName( CacheName );
		ICFGenKbGelCacheObj obj = null;
		if( indexByAltIdx.containsKey( key ) ) {
			obj = indexByAltIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCache().deleteGelCacheByAltIdx( schema.getAuthorization(),
				TenantId,
				CacheName );
			obj.forget( true );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCache().deleteGelCacheByAltIdx( schema.getAuthorization(),
				TenantId,
				CacheName );
		}
	}
}
