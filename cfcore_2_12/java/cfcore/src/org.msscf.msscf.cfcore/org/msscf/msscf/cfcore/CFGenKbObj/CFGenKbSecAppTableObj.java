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

public class CFGenKbSecAppTableObj
	implements ICFGenKbSecAppTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbSecAppPKey, ICFGenKbSecAppObj> members;
	private Map<CFGenKbSecAppPKey, ICFGenKbSecAppObj> allSecApp;
	private Map< CFGenKbSecAppByClusterIdxKey,
		Map<CFGenKbSecAppPKey, ICFGenKbSecAppObj > > indexByClusterIdx;
	private Map< CFGenKbSecAppByUJEEMountIdxKey,
		ICFGenKbSecAppObj > indexByUJEEMountIdx;
	public static String TABLE_NAME = "SecApp";
	public static String TABLE_DBNAME = "secapp";

	public CFGenKbSecAppTableObj() {
		schema = null;
		members = new HashMap<CFGenKbSecAppPKey, ICFGenKbSecAppObj>();
		allSecApp = null;
		indexByClusterIdx = null;
		indexByUJEEMountIdx = null;
	}

	public CFGenKbSecAppTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbSecAppPKey, ICFGenKbSecAppObj>();
		allSecApp = null;
		indexByClusterIdx = null;
		indexByUJEEMountIdx = null;
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
		allSecApp = null;
		indexByClusterIdx = null;
		indexByUJEEMountIdx = null;
		List<ICFGenKbSecAppObj> toForget = new LinkedList<ICFGenKbSecAppObj>();
		ICFGenKbSecAppObj cur = null;
		Iterator<ICFGenKbSecAppObj> iter = members.values().iterator();
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
	 *	CFGenKbSecAppObj.
	 */
	public ICFGenKbSecAppObj newInstance() {
		ICFGenKbSecAppObj inst = new CFGenKbSecAppObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbSecAppObj.
	 */
	public ICFGenKbSecAppEditObj newEditInstance( ICFGenKbSecAppObj orig ) {
		ICFGenKbSecAppEditObj edit = new CFGenKbSecAppEditObj( orig );
		return( edit );
	}

	public ICFGenKbSecAppObj realiseSecApp( ICFGenKbSecAppObj Obj ) {
		ICFGenKbSecAppObj obj = Obj;
		CFGenKbSecAppPKey pkey = obj.getPKey();
		ICFGenKbSecAppObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbSecAppObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFGenKbSecAppByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecAppPKey, ICFGenKbSecAppObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByUJEEMountIdx != null ) {
				CFGenKbSecAppByUJEEMountIdxKey keyUJEEMountIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newUJEEMountIdxKey();
				keyUJEEMountIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUJEEMountIdx.setRequiredJEEMountName( keepObj.getRequiredJEEMountName() );
				indexByUJEEMountIdx.remove( keyUJEEMountIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFGenKbSecAppByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecAppPKey, ICFGenKbSecAppObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUJEEMountIdx != null ) {
				CFGenKbSecAppByUJEEMountIdxKey keyUJEEMountIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newUJEEMountIdxKey();
				keyUJEEMountIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUJEEMountIdx.setRequiredJEEMountName( keepObj.getRequiredJEEMountName() );
				indexByUJEEMountIdx.put( keyUJEEMountIdx, keepObj );
			}

			if( allSecApp != null ) {
				allSecApp.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecApp != null ) {
				allSecApp.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				CFGenKbSecAppByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecAppPKey, ICFGenKbSecAppObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUJEEMountIdx != null ) {
				CFGenKbSecAppByUJEEMountIdxKey keyUJEEMountIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newUJEEMountIdxKey();
				keyUJEEMountIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUJEEMountIdx.setRequiredJEEMountName( keepObj.getRequiredJEEMountName() );
				indexByUJEEMountIdx.put( keyUJEEMountIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetSecApp( ICFGenKbSecAppObj Obj ) {
		forgetSecApp( Obj, false );
	}

	public void forgetSecApp( ICFGenKbSecAppObj Obj, boolean forgetSubObjects ) {
		ICFGenKbSecAppObj obj = Obj;
		CFGenKbSecAppPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbSecAppObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFGenKbSecAppByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecAppPKey, ICFGenKbSecAppObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByUJEEMountIdx != null ) {
				CFGenKbSecAppByUJEEMountIdxKey keyUJEEMountIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newUJEEMountIdxKey();
				keyUJEEMountIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUJEEMountIdx.setRequiredJEEMountName( keepObj.getRequiredJEEMountName() );
				indexByUJEEMountIdx.remove( keyUJEEMountIdx );
			}

			if( allSecApp != null ) {
				allSecApp.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFGenKbSchemaObj)schema).getSecFormTableObj().forgetSecFormBySecAppIdx( keepObj.getRequiredClusterId(),
					keepObj.getRequiredSecAppId() );
			}
		}
	}

	public void forgetSecAppByIdIdx( long ClusterId,
		int SecAppId )
	{
		if( members == null ) {
			return;
		}
		CFGenKbSecAppPKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		if( members.containsKey( key ) ) {
			ICFGenKbSecAppObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecAppByClusterIdx( long ClusterId )
	{
		if( indexByClusterIdx == null ) {
			return;
		}
		List<ICFGenKbSecAppObj> toForget = new LinkedList<ICFGenKbSecAppObj>();
		ICFGenKbSecAppObj cur = null;
		CFGenKbSecAppByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFGenKbSecAppPKey, ICFGenKbSecAppObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				Iterator<ICFGenKbSecAppObj> iterDup = mapClusterIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClusterIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbSecAppObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbSecAppObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecAppByUJEEMountIdx( long ClusterId,
		String JEEMountName )
	{
		if( indexByUJEEMountIdx == null ) {
			return;
		}
		List<ICFGenKbSecAppObj> toForget = new LinkedList<ICFGenKbSecAppObj>();
		ICFGenKbSecAppObj cur = null;
		CFGenKbSecAppByUJEEMountIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newUJEEMountIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredJEEMountName( JEEMountName );
		if( indexByUJEEMountIdx.containsKey( key ) ) {
			cur = indexByUJEEMountIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFGenKbSecAppObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbSecAppObj createSecApp( ICFGenKbSecAppObj Obj ) {
		ICFGenKbSecAppObj obj = Obj;
		CFGenKbSecAppBuff buff = obj.getSecAppBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableSecApp().createSecApp(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbSecAppObj readSecApp( CFGenKbSecAppPKey pkey ) {
		return( readSecApp( pkey, false ) );
	}

	public ICFGenKbSecAppObj readSecApp( CFGenKbSecAppPKey pkey, boolean forceRead ) {
		ICFGenKbSecAppObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbSecAppBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecApp().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredClusterId(),
				pkey.getRequiredSecAppId() );
			if( readBuff != null ) {
				obj = schema.getSecAppTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbSecAppObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbSecAppObj lockSecApp( CFGenKbSecAppPKey pkey ) {
		ICFGenKbSecAppObj locked = null;
		CFGenKbSecAppBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecApp().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecAppTableObj().newInstance();
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbSecAppObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockSecApp", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbSecAppObj> readAllSecApp() {
		return( readAllSecApp( false ) );
	}

	public List<ICFGenKbSecAppObj> readAllSecApp( boolean forceRead ) {
		final String S_ProcName = "readAllSecApp";
		if( ( allSecApp == null ) || forceRead ) {
			Map<CFGenKbSecAppPKey, ICFGenKbSecAppObj> map = new HashMap<CFGenKbSecAppPKey,ICFGenKbSecAppObj>();
			allSecApp = map;
			CFGenKbSecAppBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecApp().readAllDerived( schema.getAuthorization() );
			CFGenKbSecAppBuff buff;
			ICFGenKbSecAppObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newPKey() );
				obj.setBuff( buff );
				ICFGenKbSecAppObj realised = (ICFGenKbSecAppObj)obj.realise();
			}
		}
		int len = allSecApp.size();
		ICFGenKbSecAppObj arr[] = new ICFGenKbSecAppObj[len];
		Iterator<ICFGenKbSecAppObj> valIter = allSecApp.values().iterator();
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
		ArrayList<ICFGenKbSecAppObj> arrayList = new ArrayList<ICFGenKbSecAppObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbSecAppObj> cmp = new Comparator<ICFGenKbSecAppObj>() {
			public int compare( ICFGenKbSecAppObj lhs, ICFGenKbSecAppObj rhs ) {
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
					CFGenKbSecAppPKey lhsPKey = lhs.getPKey();
					CFGenKbSecAppPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbSecAppObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Return a sorted map of a page of the SecApp-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecAppObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	public List<ICFGenKbSecAppObj> pageAllSecApp(Long priorClusterId,
		Integer priorSecAppId )
	{
		final String S_ProcName = "pageAllSecApp";
		Map<CFGenKbSecAppPKey, ICFGenKbSecAppObj> map = new HashMap<CFGenKbSecAppPKey,ICFGenKbSecAppObj>();
		CFGenKbSecAppBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecApp().pageAllBuff( schema.getAuthorization(),
			priorClusterId,
			priorSecAppId );
		CFGenKbSecAppBuff buff;
		ICFGenKbSecAppObj obj;
		ICFGenKbSecAppObj realised;
		ArrayList<ICFGenKbSecAppObj> arrayList = new ArrayList<ICFGenKbSecAppObj>( buffList.length );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newPKey() );
			obj.setBuff( buff );
			realised = (ICFGenKbSecAppObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	public ICFGenKbSecAppObj readSecAppByIdIdx( long ClusterId,
		int SecAppId )
	{
		return( readSecAppByIdIdx( ClusterId,
			SecAppId,
			false ) );
	}

	public ICFGenKbSecAppObj readSecAppByIdIdx( long ClusterId,
		int SecAppId, boolean forceRead )
	{
		CFGenKbSecAppPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecAppId( SecAppId );
		ICFGenKbSecAppObj obj = readSecApp( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbSecAppObj> readSecAppByClusterIdx( long ClusterId )
	{
		return( readSecAppByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFGenKbSecAppObj> readSecAppByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecAppByClusterIdx";
		CFGenKbSecAppByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFGenKbSecAppPKey, ICFGenKbSecAppObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFGenKbSecAppByClusterIdxKey,
				Map< CFGenKbSecAppPKey, ICFGenKbSecAppObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbSecAppPKey, ICFGenKbSecAppObj>();
			ICFGenKbSecAppObj obj;
			CFGenKbSecAppBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecApp().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFGenKbSecAppBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecAppTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newPKey() );
				obj.setBuff( buff );
				ICFGenKbSecAppObj realised = (ICFGenKbSecAppObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusterIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbSecAppObj arr[] = new ICFGenKbSecAppObj[len];
		Iterator<ICFGenKbSecAppObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbSecAppObj> arrayList = new ArrayList<ICFGenKbSecAppObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbSecAppObj> cmp = new Comparator<ICFGenKbSecAppObj>() {
			public int compare( ICFGenKbSecAppObj lhs, ICFGenKbSecAppObj rhs ) {
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
					CFGenKbSecAppPKey lhsPKey = lhs.getPKey();
					CFGenKbSecAppPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbSecAppObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbSecAppObj readSecAppByUJEEMountIdx( long ClusterId,
		String JEEMountName )
	{
		return( readSecAppByUJEEMountIdx( ClusterId,
			JEEMountName,
			false ) );
	}

	public ICFGenKbSecAppObj readSecAppByUJEEMountIdx( long ClusterId,
		String JEEMountName, boolean forceRead )
	{
		if( indexByUJEEMountIdx == null ) {
			indexByUJEEMountIdx = new HashMap< CFGenKbSecAppByUJEEMountIdxKey,
				ICFGenKbSecAppObj >();
		}
		CFGenKbSecAppByUJEEMountIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newUJEEMountIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredJEEMountName( JEEMountName );
		ICFGenKbSecAppObj obj = null;
		if( ( ! forceRead ) && indexByUJEEMountIdx.containsKey( key ) ) {
			obj = indexByUJEEMountIdx.get( key );
		}
		else {
			CFGenKbSecAppBuff buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecApp().readDerivedByUJEEMountIdx( schema.getAuthorization(),
				ClusterId,
				JEEMountName );
			if( buff != null ) {
				obj = schema.getSecAppTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newPKey() );
				obj.setBuff( buff );
				obj = (ICFGenKbSecAppObj)obj.realise();
			}
		}
		return( obj );
	}

	/**
	 *	Read a page of data as a List of SecApp-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	argClusterId	The SecApp key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecApp-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFGenKbSecAppObj> pageSecAppByClusterIdx( long ClusterId,
		Long priorClusterId,
		Integer priorSecAppId )
	{
		final String S_ProcName = "pageSecAppByClusterIdx";
		CFGenKbSecAppByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		List<ICFGenKbSecAppObj> retList = new LinkedList<ICFGenKbSecAppObj>();
		ICFGenKbSecAppObj obj;
		CFGenKbSecAppBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecApp().pageBuffByClusterIdx( schema.getAuthorization(),
				ClusterId,
			priorClusterId,
			priorSecAppId );
		CFGenKbSecAppBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecAppTableObj().newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newPKey() );
			obj.setBuff( buff );
			ICFGenKbSecAppObj realised = (ICFGenKbSecAppObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	public ICFGenKbSecAppObj updateSecApp( ICFGenKbSecAppObj Obj ) {
		ICFGenKbSecAppObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableSecApp().updateSecApp( schema.getAuthorization(),
			Obj.getSecAppBuff() );
		obj = (ICFGenKbSecAppObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteSecApp( ICFGenKbSecAppObj Obj ) {
		ICFGenKbSecAppObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableSecApp().deleteSecApp( schema.getAuthorization(),
			obj.getSecAppBuff() );
		obj.forget( true );
	}

	public void deleteSecAppByIdIdx( long ClusterId,
		int SecAppId )
	{
		CFGenKbSecAppPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecAppId( SecAppId );
		ICFGenKbSecAppObj obj = readSecApp( pkey );
		if( obj != null ) {
			ICFGenKbSecAppEditObj editObj = (ICFGenKbSecAppEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbSecAppEditObj)obj.beginEdit();
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

	public void deleteSecAppByClusterIdx( long ClusterId )
	{
		CFGenKbSecAppByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFGenKbSecAppByClusterIdxKey,
				Map< CFGenKbSecAppPKey, ICFGenKbSecAppObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFGenKbSecAppPKey, ICFGenKbSecAppObj> dict = indexByClusterIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecApp().deleteSecAppByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFGenKbSecAppObj> iter = dict.values().iterator();
			ICFGenKbSecAppObj obj;
			List<ICFGenKbSecAppObj> toForget = new LinkedList<ICFGenKbSecAppObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByClusterIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecApp().deleteSecAppByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteSecAppByUJEEMountIdx( long ClusterId,
		String JEEMountName )
	{
		if( indexByUJEEMountIdx == null ) {
			indexByUJEEMountIdx = new HashMap< CFGenKbSecAppByUJEEMountIdxKey,
				ICFGenKbSecAppObj >();
		}
		CFGenKbSecAppByUJEEMountIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newUJEEMountIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredJEEMountName( JEEMountName );
		ICFGenKbSecAppObj obj = null;
		if( indexByUJEEMountIdx.containsKey( key ) ) {
			obj = indexByUJEEMountIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecApp().deleteSecAppByUJEEMountIdx( schema.getAuthorization(),
				ClusterId,
				JEEMountName );
			obj.forget( true );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecApp().deleteSecAppByUJEEMountIdx( schema.getAuthorization(),
				ClusterId,
				JEEMountName );
		}
	}
}
