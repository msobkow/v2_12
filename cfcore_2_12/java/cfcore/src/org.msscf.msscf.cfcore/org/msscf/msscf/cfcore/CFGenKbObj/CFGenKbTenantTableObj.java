// Description: Java 11 Table Object implementation for CFGenKb.

/*
 *	org.msscf.msscf.CFCore
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
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

public class CFGenKbTenantTableObj
	implements ICFGenKbTenantTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbTenantPKey, ICFGenKbTenantObj> members;
	private Map<CFGenKbTenantPKey, ICFGenKbTenantObj> allTenant;
	private Map< CFGenKbTenantByClusterIdxKey,
		Map<CFGenKbTenantPKey, ICFGenKbTenantObj > > indexByClusterIdx;
	private Map< CFGenKbTenantByUNameIdxKey,
		ICFGenKbTenantObj > indexByUNameIdx;
	public static String TABLE_NAME = "Tenant";
	public static String TABLE_DBNAME = "tenant";

	public CFGenKbTenantTableObj() {
		schema = null;
		members = new HashMap<CFGenKbTenantPKey, ICFGenKbTenantObj>();
		allTenant = null;
		indexByClusterIdx = null;
		indexByUNameIdx = null;
	}

	public CFGenKbTenantTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbTenantPKey, ICFGenKbTenantObj>();
		allTenant = null;
		indexByClusterIdx = null;
		indexByUNameIdx = null;
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
		allTenant = null;
		indexByClusterIdx = null;
		indexByUNameIdx = null;
		List<ICFGenKbTenantObj> toForget = new LinkedList<ICFGenKbTenantObj>();
		ICFGenKbTenantObj cur = null;
		Iterator<ICFGenKbTenantObj> iter = members.values().iterator();
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
	 *	CFGenKbTenantObj.
	 */
	public ICFGenKbTenantObj newInstance() {
		ICFGenKbTenantObj inst = new CFGenKbTenantObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbTenantObj.
	 */
	public ICFGenKbTenantEditObj newEditInstance( ICFGenKbTenantObj orig ) {
		ICFGenKbTenantEditObj edit = new CFGenKbTenantEditObj( orig );
		return( edit );
	}

	public ICFGenKbTenantObj realiseTenant( ICFGenKbTenantObj Obj ) {
		ICFGenKbTenantObj obj = Obj;
		CFGenKbTenantPKey pkey = obj.getPKey();
		ICFGenKbTenantObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbTenantObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFGenKbTenantByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbTenantPKey, ICFGenKbTenantObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFGenKbTenantByUNameIdxKey keyUNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredTenantName( keepObj.getRequiredTenantName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFGenKbTenantByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbTenantPKey, ICFGenKbTenantObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFGenKbTenantByUNameIdxKey keyUNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newUNameIdxKey();
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
				CFGenKbTenantByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbTenantPKey, ICFGenKbTenantObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFGenKbTenantByUNameIdxKey keyUNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredTenantName( keepObj.getRequiredTenantName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetTenant( ICFGenKbTenantObj Obj ) {
		forgetTenant( Obj, false );
	}

	public void forgetTenant( ICFGenKbTenantObj Obj, boolean forgetSubObjects ) {
		ICFGenKbTenantObj obj = Obj;
		CFGenKbTenantPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbTenantObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFGenKbTenantByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbTenantPKey, ICFGenKbTenantObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFGenKbTenantByUNameIdxKey keyUNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredTenantName( keepObj.getRequiredTenantName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allTenant != null ) {
				allTenant.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFGenKbSchemaObj)schema).getTSecGroupTableObj().forgetTSecGroupByTenantIdx( keepObj.getRequiredId() );
				((ICFGenKbSchemaObj)schema).getRuleCartTableObj().forgetRuleCartByTenantIdx( keepObj.getRequiredId() );
			}
		}
	}

	public void forgetTenantByIdIdx( long Id )
	{
		if( members == null ) {
			return;
		}
		CFGenKbTenantPKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newPKey();
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFGenKbTenantObj probed = members.get( key );
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
		List<ICFGenKbTenantObj> toForget = new LinkedList<ICFGenKbTenantObj>();
		ICFGenKbTenantObj cur = null;
		CFGenKbTenantByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFGenKbTenantPKey, ICFGenKbTenantObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				Iterator<ICFGenKbTenantObj> iterDup = mapClusterIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClusterIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbTenantObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbTenantObj> iter = toForget.iterator();
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
		List<ICFGenKbTenantObj> toForget = new LinkedList<ICFGenKbTenantObj>();
		ICFGenKbTenantObj cur = null;
		CFGenKbTenantByUNameIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredTenantName( TenantName );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFGenKbTenantObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbTenantObj createTenant( ICFGenKbTenantObj Obj ) {
		ICFGenKbTenantObj obj = Obj;
		CFGenKbTenantBuff buff = obj.getTenantBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableTenant().createTenant(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbTenantObj readTenant( CFGenKbTenantPKey pkey ) {
		return( readTenant( pkey, false ) );
	}

	public ICFGenKbTenantObj readTenant( CFGenKbTenantPKey pkey, boolean forceRead ) {
		ICFGenKbTenantObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbTenantBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableTenant().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getTenantTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbTenantObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbTenantObj lockTenant( CFGenKbTenantPKey pkey ) {
		ICFGenKbTenantObj locked = null;
		CFGenKbTenantBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableTenant().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getTenantTableObj().newInstance();
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbTenantObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockTenant", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbTenantObj> readAllTenant() {
		return( readAllTenant( false ) );
	}

	public List<ICFGenKbTenantObj> readAllTenant( boolean forceRead ) {
		final String S_ProcName = "readAllTenant";
		if( ( allTenant == null ) || forceRead ) {
			Map<CFGenKbTenantPKey, ICFGenKbTenantObj> map = new HashMap<CFGenKbTenantPKey,ICFGenKbTenantObj>();
			allTenant = map;
			CFGenKbTenantBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableTenant().readAllDerived( schema.getAuthorization() );
			CFGenKbTenantBuff buff;
			ICFGenKbTenantObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newPKey() );
				obj.setBuff( buff );
				ICFGenKbTenantObj realised = (ICFGenKbTenantObj)obj.realise();
			}
		}
		int len = allTenant.size();
		ICFGenKbTenantObj arr[] = new ICFGenKbTenantObj[len];
		Iterator<ICFGenKbTenantObj> valIter = allTenant.values().iterator();
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
		ArrayList<ICFGenKbTenantObj> arrayList = new ArrayList<ICFGenKbTenantObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbTenantObj> cmp = new Comparator<ICFGenKbTenantObj>() {
			public int compare( ICFGenKbTenantObj lhs, ICFGenKbTenantObj rhs ) {
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
					CFGenKbTenantPKey lhsPKey = lhs.getPKey();
					CFGenKbTenantPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbTenantObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Return a sorted map of a page of the Tenant-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbTenantObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	public List<ICFGenKbTenantObj> pageAllTenant(Long priorId )
	{
		final String S_ProcName = "pageAllTenant";
		Map<CFGenKbTenantPKey, ICFGenKbTenantObj> map = new HashMap<CFGenKbTenantPKey,ICFGenKbTenantObj>();
		CFGenKbTenantBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableTenant().pageAllBuff( schema.getAuthorization(),
			priorId );
		CFGenKbTenantBuff buff;
		ICFGenKbTenantObj obj;
		ICFGenKbTenantObj realised;
		ArrayList<ICFGenKbTenantObj> arrayList = new ArrayList<ICFGenKbTenantObj>( buffList.length );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newPKey() );
			obj.setBuff( buff );
			realised = (ICFGenKbTenantObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	public ICFGenKbTenantObj readTenantByIdIdx( long Id )
	{
		return( readTenantByIdIdx( Id,
			false ) );
	}

	public ICFGenKbTenantObj readTenantByIdIdx( long Id, boolean forceRead )
	{
		CFGenKbTenantPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newPKey();
		pkey.setRequiredId( Id );
		ICFGenKbTenantObj obj = readTenant( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbTenantObj> readTenantByClusterIdx( long ClusterId )
	{
		return( readTenantByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFGenKbTenantObj> readTenantByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readTenantByClusterIdx";
		CFGenKbTenantByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFGenKbTenantPKey, ICFGenKbTenantObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFGenKbTenantByClusterIdxKey,
				Map< CFGenKbTenantPKey, ICFGenKbTenantObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbTenantPKey, ICFGenKbTenantObj>();
			ICFGenKbTenantObj obj;
			CFGenKbTenantBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableTenant().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFGenKbTenantBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTenantTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newPKey() );
				obj.setBuff( buff );
				ICFGenKbTenantObj realised = (ICFGenKbTenantObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusterIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbTenantObj arr[] = new ICFGenKbTenantObj[len];
		Iterator<ICFGenKbTenantObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbTenantObj> arrayList = new ArrayList<ICFGenKbTenantObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbTenantObj> cmp = new Comparator<ICFGenKbTenantObj>() {
			public int compare( ICFGenKbTenantObj lhs, ICFGenKbTenantObj rhs ) {
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
					CFGenKbTenantPKey lhsPKey = lhs.getPKey();
					CFGenKbTenantPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbTenantObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbTenantObj readTenantByUNameIdx( long ClusterId,
		String TenantName )
	{
		return( readTenantByUNameIdx( ClusterId,
			TenantName,
			false ) );
	}

	public ICFGenKbTenantObj readTenantByUNameIdx( long ClusterId,
		String TenantName, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFGenKbTenantByUNameIdxKey,
				ICFGenKbTenantObj >();
		}
		CFGenKbTenantByUNameIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredTenantName( TenantName );
		ICFGenKbTenantObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFGenKbTenantBuff buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableTenant().readDerivedByUNameIdx( schema.getAuthorization(),
				ClusterId,
				TenantName );
			if( buff != null ) {
				obj = schema.getTenantTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newPKey() );
				obj.setBuff( buff );
				obj = (ICFGenKbTenantObj)obj.realise();
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
	public List<ICFGenKbTenantObj> pageTenantByClusterIdx( long ClusterId,
		Long priorId )
	{
		final String S_ProcName = "pageTenantByClusterIdx";
		CFGenKbTenantByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		List<ICFGenKbTenantObj> retList = new LinkedList<ICFGenKbTenantObj>();
		ICFGenKbTenantObj obj;
		CFGenKbTenantBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableTenant().pageBuffByClusterIdx( schema.getAuthorization(),
				ClusterId,
			priorId );
		CFGenKbTenantBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getTenantTableObj().newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newPKey() );
			obj.setBuff( buff );
			ICFGenKbTenantObj realised = (ICFGenKbTenantObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	public ICFGenKbTenantObj updateTenant( ICFGenKbTenantObj Obj ) {
		ICFGenKbTenantObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableTenant().updateTenant( schema.getAuthorization(),
			Obj.getTenantBuff() );
		obj = (ICFGenKbTenantObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteTenant( ICFGenKbTenantObj Obj ) {
		ICFGenKbTenantObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableTenant().deleteTenant( schema.getAuthorization(),
			obj.getTenantBuff() );
		obj.forget( true );
	}

	public void deleteTenantByIdIdx( long Id )
	{
		CFGenKbTenantPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newPKey();
		pkey.setRequiredId( Id );
		ICFGenKbTenantObj obj = readTenant( pkey );
		if( obj != null ) {
			ICFGenKbTenantEditObj editObj = (ICFGenKbTenantEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbTenantEditObj)obj.beginEdit();
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
		CFGenKbTenantByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFGenKbTenantByClusterIdxKey,
				Map< CFGenKbTenantPKey, ICFGenKbTenantObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFGenKbTenantPKey, ICFGenKbTenantObj> dict = indexByClusterIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableTenant().deleteTenantByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFGenKbTenantObj> iter = dict.values().iterator();
			ICFGenKbTenantObj obj;
			List<ICFGenKbTenantObj> toForget = new LinkedList<ICFGenKbTenantObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableTenant().deleteTenantByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteTenantByUNameIdx( long ClusterId,
		String TenantName )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFGenKbTenantByUNameIdxKey,
				ICFGenKbTenantObj >();
		}
		CFGenKbTenantByUNameIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredTenantName( TenantName );
		ICFGenKbTenantObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableTenant().deleteTenantByUNameIdx( schema.getAuthorization(),
				ClusterId,
				TenantName );
			obj.forget( true );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableTenant().deleteTenantByUNameIdx( schema.getAuthorization(),
				ClusterId,
				TenantName );
		}
	}

	public ICFGenKbTenantObj getSystemTenant() {
		boolean transactionStarted = schema.beginTransaction();
		ICFGenKbTenantObj tenantObj;
		try {
			ICFGenKbClusterObj clusterObj = schema.getClusterTableObj().getSystemCluster();
			tenantObj = readTenantByUNameIdx( clusterObj.getRequiredId(), "system" );
			if( tenantObj == null ) {
				tenantObj = newInstance();
				ICFGenKbTenantEditObj tenantEdit = tenantObj.beginEdit();
				tenantEdit.setRequiredContainerCluster( clusterObj );
				tenantEdit.setRequiredTenantName( "system" );
				tenantObj = tenantEdit.create();
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
