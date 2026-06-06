// Description: Java 11 Table Object implementation for CFSec.

/*
 *	org.msscf.msscf.CFSec
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

package org.msscf.msscf.cfsec.CFSecObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;

public class CFSecTenantTableObj
	implements ICFSecTenantTableObj
{
	protected ICFSecSchemaObj schema;
	private Map<CFSecTenantPKey, ICFSecTenantObj> members;
	private Map<CFSecTenantPKey, ICFSecTenantObj> allTenant;
	private Map< CFSecTenantByClusterIdxKey,
		Map<CFSecTenantPKey, ICFSecTenantObj > > indexByClusterIdx;
	private Map< CFSecTenantByUNameIdxKey,
		ICFSecTenantObj > indexByUNameIdx;
	public static String TABLE_NAME = "Tenant";
	public static String TABLE_DBNAME = "tenant";

	public CFSecTenantTableObj() {
		schema = null;
		members = new HashMap<CFSecTenantPKey, ICFSecTenantObj>();
		allTenant = null;
		indexByClusterIdx = null;
		indexByUNameIdx = null;
	}

	public CFSecTenantTableObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFSecTenantPKey, ICFSecTenantObj>();
		allTenant = null;
		indexByClusterIdx = null;
		indexByUNameIdx = null;
	}

	public ICFSecSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFSecSchemaObj value ) {
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
		allTenant = null;
		indexByClusterIdx = null;
		indexByUNameIdx = null;
		List<ICFSecTenantObj> toForget = new LinkedList<ICFSecTenantObj>();
		ICFSecTenantObj cur = null;
		Iterator<ICFSecTenantObj> iter = members.values().iterator();
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
	 *	CFSecTenantObj.
	 */
	public ICFSecTenantObj newInstance() {
		ICFSecTenantObj inst = new CFSecTenantObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFSecTenantObj.
	 */
	public ICFSecTenantEditObj newEditInstance( ICFSecTenantObj orig ) {
		ICFSecTenantEditObj edit = new CFSecTenantEditObj( orig );
		return( edit );
	}

	public ICFSecTenantObj realiseTenant( ICFSecTenantObj Obj ) {
		ICFSecTenantObj obj = Obj;
		CFSecTenantPKey pkey = obj.getPKey();
		ICFSecTenantObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFSecTenantObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFSecTenantByClusterIdxKey keyClusterIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecTenantPKey, ICFSecTenantObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFSecTenantByUNameIdxKey keyUNameIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredTenantName( keepObj.getRequiredTenantName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFSecTenantByClusterIdxKey keyClusterIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecTenantPKey, ICFSecTenantObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFSecTenantByUNameIdxKey keyUNameIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredTenantName( keepObj.getRequiredTenantName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allTenant != null ) {
				allTenant.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTenant != null ) {
				allTenant.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				CFSecTenantByClusterIdxKey keyClusterIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecTenantPKey, ICFSecTenantObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFSecTenantByUNameIdxKey keyUNameIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredTenantName( keepObj.getRequiredTenantName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetTenant( ICFSecTenantObj Obj ) {
		forgetTenant( Obj, false );
	}

	public void forgetTenant( ICFSecTenantObj Obj, boolean forgetSubObjects ) {
		ICFSecTenantObj obj = Obj;
		CFSecTenantPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFSecTenantObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFSecTenantByClusterIdxKey keyClusterIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecTenantPKey, ICFSecTenantObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFSecTenantByUNameIdxKey keyUNameIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredTenantName( keepObj.getRequiredTenantName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allTenant != null ) {
				allTenant.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFSecSchemaObj)schema).getTSecGroupTableObj().forgetTSecGroupByTenantIdx( keepObj.getRequiredId() );
			}
		}
	}

	public void forgetTenantByIdIdx( long Id )
	{
		if( members == null ) {
			return;
		}
		CFSecTenantPKey key = ((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newPKey();
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFSecTenantObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTenantByClusterIdx( long ClusterId )
	{
		if( indexByClusterIdx == null ) {
			return;
		}
		List<ICFSecTenantObj> toForget = new LinkedList<ICFSecTenantObj>();
		ICFSecTenantObj cur = null;
		CFSecTenantByClusterIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFSecTenantPKey, ICFSecTenantObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				Iterator<ICFSecTenantObj> iterDup = mapClusterIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClusterIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecTenantObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecTenantObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTenantByUNameIdx( long ClusterId,
		String TenantName )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFSecTenantObj> toForget = new LinkedList<ICFSecTenantObj>();
		ICFSecTenantObj cur = null;
		CFSecTenantByUNameIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredTenantName( TenantName );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFSecTenantObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFSecTenantObj createTenant( ICFSecTenantObj Obj ) {
		ICFSecTenantObj obj = Obj;
		CFSecTenantBuff buff = obj.getTenantBuff();
		((ICFSecSchema)schema.getBackingStore()).getTableTenant().createTenant(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFSecTenantObj readTenant( CFSecTenantPKey pkey ) {
		return( readTenant( pkey, false ) );
	}

	public ICFSecTenantObj readTenant( CFSecTenantPKey pkey, boolean forceRead ) {
		ICFSecTenantObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFSecTenantBuff readBuff = ((ICFSecSchema)schema.getBackingStore()).getTableTenant().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getTenantTableObj().newInstance();
				obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFSecTenantObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecTenantObj lockTenant( CFSecTenantPKey pkey ) {
		ICFSecTenantObj locked = null;
		CFSecTenantBuff lockBuff = ((ICFSecSchema)schema.getBackingStore()).getTableTenant().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getTenantTableObj().newInstance();
			locked.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFSecTenantObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockTenant", pkey );
		}
		return( locked );
	}

	public List<ICFSecTenantObj> readAllTenant() {
		return( readAllTenant( false ) );
	}

	public List<ICFSecTenantObj> readAllTenant( boolean forceRead ) {
		final String S_ProcName = "readAllTenant";
		if( ( allTenant == null ) || forceRead ) {
			Map<CFSecTenantPKey, ICFSecTenantObj> map = new HashMap<CFSecTenantPKey,ICFSecTenantObj>();
			allTenant = map;
			CFSecTenantBuff[] buffList = ((ICFSecSchema)schema.getBackingStore()).getTableTenant().readAllDerived( schema.getAuthorization() );
			CFSecTenantBuff buff;
			ICFSecTenantObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newPKey() );
				obj.setBuff( buff );
				ICFSecTenantObj realised = (ICFSecTenantObj)obj.realise();
			}
		}
		int len = allTenant.size();
		ICFSecTenantObj arr[] = new ICFSecTenantObj[len];
		Iterator<ICFSecTenantObj> valIter = allTenant.values().iterator();
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
		ArrayList<ICFSecTenantObj> arrayList = new ArrayList<ICFSecTenantObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecTenantObj> cmp = new Comparator<ICFSecTenantObj>() {
			public int compare( ICFSecTenantObj lhs, ICFSecTenantObj rhs ) {
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
					CFSecTenantPKey lhsPKey = lhs.getPKey();
					CFSecTenantPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecTenantObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Return a sorted map of a page of the Tenant-derived instances in the database.
	 *
	 *	@return	List of ICFSecTenantObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	public List<ICFSecTenantObj> pageAllTenant(Long priorId )
	{
		final String S_ProcName = "pageAllTenant";
		Map<CFSecTenantPKey, ICFSecTenantObj> map = new HashMap<CFSecTenantPKey,ICFSecTenantObj>();
		CFSecTenantBuff[] buffList = ((ICFSecSchema)schema.getBackingStore()).getTableTenant().pageAllBuff( schema.getAuthorization(),
			priorId );
		CFSecTenantBuff buff;
		ICFSecTenantObj obj;
		ICFSecTenantObj realised;
		ArrayList<ICFSecTenantObj> arrayList = new ArrayList<ICFSecTenantObj>( buffList.length );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = newInstance();
			obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newPKey() );
			obj.setBuff( buff );
			realised = (ICFSecTenantObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	public ICFSecTenantObj readTenantByIdIdx( long Id )
	{
		return( readTenantByIdIdx( Id,
			false ) );
	}

	public ICFSecTenantObj readTenantByIdIdx( long Id, boolean forceRead )
	{
		CFSecTenantPKey pkey = ((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newPKey();
		pkey.setRequiredId( Id );
		ICFSecTenantObj obj = readTenant( pkey, forceRead );
		return( obj );
	}

	public List<ICFSecTenantObj> readTenantByClusterIdx( long ClusterId )
	{
		return( readTenantByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFSecTenantObj> readTenantByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readTenantByClusterIdx";
		CFSecTenantByClusterIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFSecTenantPKey, ICFSecTenantObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFSecTenantByClusterIdxKey,
				Map< CFSecTenantPKey, ICFSecTenantObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecTenantPKey, ICFSecTenantObj>();
			ICFSecTenantObj obj;
			CFSecTenantBuff[] buffList = ((ICFSecSchema)schema.getBackingStore()).getTableTenant().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFSecTenantBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTenantTableObj().newInstance();
				obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newPKey() );
				obj.setBuff( buff );
				ICFSecTenantObj realised = (ICFSecTenantObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusterIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecTenantObj arr[] = new ICFSecTenantObj[len];
		Iterator<ICFSecTenantObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecTenantObj> arrayList = new ArrayList<ICFSecTenantObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecTenantObj> cmp = new Comparator<ICFSecTenantObj>() {
			public int compare( ICFSecTenantObj lhs, ICFSecTenantObj rhs ) {
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
					CFSecTenantPKey lhsPKey = lhs.getPKey();
					CFSecTenantPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecTenantObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecTenantObj readTenantByUNameIdx( long ClusterId,
		String TenantName )
	{
		return( readTenantByUNameIdx( ClusterId,
			TenantName,
			false ) );
	}

	public ICFSecTenantObj readTenantByUNameIdx( long ClusterId,
		String TenantName, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFSecTenantByUNameIdxKey,
				ICFSecTenantObj >();
		}
		CFSecTenantByUNameIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredTenantName( TenantName );
		ICFSecTenantObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFSecTenantBuff buff = ((ICFSecSchema)schema.getBackingStore()).getTableTenant().readDerivedByUNameIdx( schema.getAuthorization(),
				ClusterId,
				TenantName );
			if( buff != null ) {
				obj = schema.getTenantTableObj().newInstance();
				obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newPKey() );
				obj.setBuff( buff );
				obj = (ICFSecTenantObj)obj.realise();
			}
		}
		return( obj );
	}

	/**
	 *	Read a page of data as a List of Tenant-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	argClusterId	The Tenant key attribute of the instance generating the id.
	 *
	 *	@return	A List of Tenant-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecTenantObj> pageTenantByClusterIdx( long ClusterId,
		Long priorId )
	{
		final String S_ProcName = "pageTenantByClusterIdx";
		CFSecTenantByClusterIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		List<ICFSecTenantObj> retList = new LinkedList<ICFSecTenantObj>();
		ICFSecTenantObj obj;
		CFSecTenantBuff[] buffList = ((ICFSecSchema)schema.getBackingStore()).getTableTenant().pageBuffByClusterIdx( schema.getAuthorization(),
				ClusterId,
			priorId );
		CFSecTenantBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getTenantTableObj().newInstance();
			obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newPKey() );
			obj.setBuff( buff );
			ICFSecTenantObj realised = (ICFSecTenantObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	public ICFSecTenantObj updateTenant( ICFSecTenantObj Obj ) {
		ICFSecTenantObj obj = Obj;
		((ICFSecSchema)schema.getBackingStore()).getTableTenant().updateTenant( schema.getAuthorization(),
			Obj.getTenantBuff() );
		obj = (ICFSecTenantObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteTenant( ICFSecTenantObj Obj ) {
		ICFSecTenantObj obj = Obj;
		((ICFSecSchema)schema.getBackingStore()).getTableTenant().deleteTenant( schema.getAuthorization(),
			obj.getTenantBuff() );
		obj.forget( true );
	}

	public void deleteTenantByIdIdx( long Id )
	{
		CFSecTenantPKey pkey = ((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newPKey();
		pkey.setRequiredId( Id );
		ICFSecTenantObj obj = readTenant( pkey );
		if( obj != null ) {
			ICFSecTenantEditObj editObj = (ICFSecTenantEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFSecTenantEditObj)obj.beginEdit();
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

	public void deleteTenantByClusterIdx( long ClusterId )
	{
		CFSecTenantByClusterIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFSecTenantByClusterIdxKey,
				Map< CFSecTenantPKey, ICFSecTenantObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFSecTenantPKey, ICFSecTenantObj> dict = indexByClusterIdx.get( key );
			((ICFSecSchema)schema.getBackingStore()).getTableTenant().deleteTenantByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFSecTenantObj> iter = dict.values().iterator();
			ICFSecTenantObj obj;
			List<ICFSecTenantObj> toForget = new LinkedList<ICFSecTenantObj>();
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
			((ICFSecSchema)schema.getBackingStore()).getTableTenant().deleteTenantByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteTenantByUNameIdx( long ClusterId,
		String TenantName )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFSecTenantByUNameIdxKey,
				ICFSecTenantObj >();
		}
		CFSecTenantByUNameIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactoryTenant().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredTenantName( TenantName );
		ICFSecTenantObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFSecSchema)schema.getBackingStore()).getTableTenant().deleteTenantByUNameIdx( schema.getAuthorization(),
				ClusterId,
				TenantName );
			obj.forget( true );
		}
		else {
			((ICFSecSchema)schema.getBackingStore()).getTableTenant().deleteTenantByUNameIdx( schema.getAuthorization(),
				ClusterId,
				TenantName );
		}
	}

	public ICFSecTenantObj getSystemTenant() {
		boolean transactionStarted = schema.beginTransaction();
		ICFSecTenantObj tenantObj;
		try {
			ICFSecClusterObj clusterObj = schema.getClusterTableObj().getSystemCluster();
			tenantObj = readTenantByUNameIdx( clusterObj.getRequiredId(), "system" );
			if( tenantObj == null ) {
				tenantObj = newInstance();
				ICFSecTenantEditObj tenantEdit = tenantObj.beginEdit();
				tenantEdit.setRequiredContainerCluster( clusterObj );
				tenantEdit.setRequiredTenantName( "system" );
				tenantObj = tenantEdit.create();
				tenantEdit = null;
			}
			if( transactionStarted ) {
				schema.commit();
			}
		}
		catch( RuntimeException e ) {
			if( transactionStarted ) {
				try {
					schema.rollback();
				}
				catch( Exception e2 ) {
				}
			}
			throw e;
		}
		return( tenantObj );
	}
}
