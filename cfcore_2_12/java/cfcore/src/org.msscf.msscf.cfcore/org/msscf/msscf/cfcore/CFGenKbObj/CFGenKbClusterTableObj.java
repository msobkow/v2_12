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

public class CFGenKbClusterTableObj
	implements ICFGenKbClusterTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbClusterPKey, ICFGenKbClusterObj> members;
	private Map<CFGenKbClusterPKey, ICFGenKbClusterObj> allCluster;
	private Map< CFGenKbClusterByUDomNameIdxKey,
		ICFGenKbClusterObj > indexByUDomNameIdx;
	private Map< CFGenKbClusterByUDescrIdxKey,
		ICFGenKbClusterObj > indexByUDescrIdx;
	public static String TABLE_NAME = "Cluster";
	public static String TABLE_DBNAME = "clus";

	public CFGenKbClusterTableObj() {
		schema = null;
		members = new HashMap<CFGenKbClusterPKey, ICFGenKbClusterObj>();
		allCluster = null;
		indexByUDomNameIdx = null;
		indexByUDescrIdx = null;
	}

	public CFGenKbClusterTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbClusterPKey, ICFGenKbClusterObj>();
		allCluster = null;
		indexByUDomNameIdx = null;
		indexByUDescrIdx = null;
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
		allCluster = null;
		indexByUDomNameIdx = null;
		indexByUDescrIdx = null;
		List<ICFGenKbClusterObj> toForget = new LinkedList<ICFGenKbClusterObj>();
		ICFGenKbClusterObj cur = null;
		Iterator<ICFGenKbClusterObj> iter = members.values().iterator();
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
	 *	CFGenKbClusterObj.
	 */
	public ICFGenKbClusterObj newInstance() {
		ICFGenKbClusterObj inst = new CFGenKbClusterObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbClusterObj.
	 */
	public ICFGenKbClusterEditObj newEditInstance( ICFGenKbClusterObj orig ) {
		ICFGenKbClusterEditObj edit = new CFGenKbClusterEditObj( orig );
		return( edit );
	}

	public ICFGenKbClusterObj realiseCluster( ICFGenKbClusterObj Obj ) {
		ICFGenKbClusterObj obj = Obj;
		CFGenKbClusterPKey pkey = obj.getPKey();
		ICFGenKbClusterObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbClusterObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUDomNameIdx != null ) {
				CFGenKbClusterByUDomNameIdxKey keyUDomNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newUDomNameIdxKey();
				keyUDomNameIdx.setRequiredFullDomName( keepObj.getRequiredFullDomName() );
				indexByUDomNameIdx.remove( keyUDomNameIdx );
			}

			if( indexByUDescrIdx != null ) {
				CFGenKbClusterByUDescrIdxKey keyUDescrIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.remove( keyUDescrIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUDomNameIdx != null ) {
				CFGenKbClusterByUDomNameIdxKey keyUDomNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newUDomNameIdxKey();
				keyUDomNameIdx.setRequiredFullDomName( keepObj.getRequiredFullDomName() );
				indexByUDomNameIdx.put( keyUDomNameIdx, keepObj );
			}

			if( indexByUDescrIdx != null ) {
				CFGenKbClusterByUDescrIdxKey keyUDescrIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.put( keyUDescrIdx, keepObj );
			}

			if( allCluster != null ) {
				allCluster.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allCluster != null ) {
				allCluster.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUDomNameIdx != null ) {
				CFGenKbClusterByUDomNameIdxKey keyUDomNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newUDomNameIdxKey();
				keyUDomNameIdx.setRequiredFullDomName( keepObj.getRequiredFullDomName() );
				indexByUDomNameIdx.put( keyUDomNameIdx, keepObj );
			}

			if( indexByUDescrIdx != null ) {
				CFGenKbClusterByUDescrIdxKey keyUDescrIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.put( keyUDescrIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetCluster( ICFGenKbClusterObj Obj ) {
		forgetCluster( Obj, false );
	}

	public void forgetCluster( ICFGenKbClusterObj Obj, boolean forgetSubObjects ) {
		ICFGenKbClusterObj obj = Obj;
		CFGenKbClusterPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbClusterObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUDomNameIdx != null ) {
				CFGenKbClusterByUDomNameIdxKey keyUDomNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newUDomNameIdxKey();
				keyUDomNameIdx.setRequiredFullDomName( keepObj.getRequiredFullDomName() );
				indexByUDomNameIdx.remove( keyUDomNameIdx );
			}

			if( indexByUDescrIdx != null ) {
				CFGenKbClusterByUDescrIdxKey keyUDescrIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.remove( keyUDescrIdx );
			}

			if( allCluster != null ) {
				allCluster.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFGenKbSchemaObj)schema).getHostNodeTableObj().forgetHostNodeByClusterIdx( keepObj.getRequiredId() );
				((ICFGenKbSchemaObj)schema).getTenantTableObj().forgetTenantByClusterIdx( keepObj.getRequiredId() );
				((ICFGenKbSchemaObj)schema).getSecAppTableObj().forgetSecAppByClusterIdx( keepObj.getRequiredId() );
				((ICFGenKbSchemaObj)schema).getSecGroupTableObj().forgetSecGroupByClusterIdx( keepObj.getRequiredId() );
				((ICFGenKbSchemaObj)schema).getSysClusterTableObj().forgetSysClusterByClusterIdx( keepObj.getRequiredId() );
			}
		}
	}

	public void forgetClusterByIdIdx( long Id )
	{
		if( members == null ) {
			return;
		}
		CFGenKbClusterPKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newPKey();
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFGenKbClusterObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetClusterByUDomNameIdx( String FullDomName )
	{
		if( indexByUDomNameIdx == null ) {
			return;
		}
		List<ICFGenKbClusterObj> toForget = new LinkedList<ICFGenKbClusterObj>();
		ICFGenKbClusterObj cur = null;
		CFGenKbClusterByUDomNameIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newUDomNameIdxKey();
		key.setRequiredFullDomName( FullDomName );
		if( indexByUDomNameIdx.containsKey( key ) ) {
			cur = indexByUDomNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFGenKbClusterObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClusterByUDescrIdx( String Description )
	{
		if( indexByUDescrIdx == null ) {
			return;
		}
		List<ICFGenKbClusterObj> toForget = new LinkedList<ICFGenKbClusterObj>();
		ICFGenKbClusterObj cur = null;
		CFGenKbClusterByUDescrIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newUDescrIdxKey();
		key.setRequiredDescription( Description );
		if( indexByUDescrIdx.containsKey( key ) ) {
			cur = indexByUDescrIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFGenKbClusterObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbClusterObj createCluster( ICFGenKbClusterObj Obj ) {
		ICFGenKbClusterObj obj = Obj;
		CFGenKbClusterBuff buff = obj.getClusterBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableCluster().createCluster(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbClusterObj readCluster( CFGenKbClusterPKey pkey ) {
		return( readCluster( pkey, false ) );
	}

	public ICFGenKbClusterObj readCluster( CFGenKbClusterPKey pkey, boolean forceRead ) {
		ICFGenKbClusterObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbClusterBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableCluster().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getClusterTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbClusterObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbClusterObj lockCluster( CFGenKbClusterPKey pkey ) {
		ICFGenKbClusterObj locked = null;
		CFGenKbClusterBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableCluster().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getClusterTableObj().newInstance();
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbClusterObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockCluster", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbClusterObj> readAllCluster() {
		return( readAllCluster( false ) );
	}

	public List<ICFGenKbClusterObj> readAllCluster( boolean forceRead ) {
		final String S_ProcName = "readAllCluster";
		if( ( allCluster == null ) || forceRead ) {
			Map<CFGenKbClusterPKey, ICFGenKbClusterObj> map = new HashMap<CFGenKbClusterPKey,ICFGenKbClusterObj>();
			allCluster = map;
			CFGenKbClusterBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableCluster().readAllDerived( schema.getAuthorization() );
			CFGenKbClusterBuff buff;
			ICFGenKbClusterObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newPKey() );
				obj.setBuff( buff );
				ICFGenKbClusterObj realised = (ICFGenKbClusterObj)obj.realise();
			}
		}
		int len = allCluster.size();
		ICFGenKbClusterObj arr[] = new ICFGenKbClusterObj[len];
		Iterator<ICFGenKbClusterObj> valIter = allCluster.values().iterator();
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
		ArrayList<ICFGenKbClusterObj> arrayList = new ArrayList<ICFGenKbClusterObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbClusterObj> cmp = new Comparator<ICFGenKbClusterObj>() {
			public int compare( ICFGenKbClusterObj lhs, ICFGenKbClusterObj rhs ) {
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
					CFGenKbClusterPKey lhsPKey = lhs.getPKey();
					CFGenKbClusterPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbClusterObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Return a sorted map of a page of the Cluster-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbClusterObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	public List<ICFGenKbClusterObj> pageAllCluster(Long priorId )
	{
		final String S_ProcName = "pageAllCluster";
		Map<CFGenKbClusterPKey, ICFGenKbClusterObj> map = new HashMap<CFGenKbClusterPKey,ICFGenKbClusterObj>();
		CFGenKbClusterBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableCluster().pageAllBuff( schema.getAuthorization(),
			priorId );
		CFGenKbClusterBuff buff;
		ICFGenKbClusterObj obj;
		ICFGenKbClusterObj realised;
		ArrayList<ICFGenKbClusterObj> arrayList = new ArrayList<ICFGenKbClusterObj>( buffList.length );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newPKey() );
			obj.setBuff( buff );
			realised = (ICFGenKbClusterObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	public ICFGenKbClusterObj readClusterByIdIdx( long Id )
	{
		return( readClusterByIdIdx( Id,
			false ) );
	}

	public ICFGenKbClusterObj readClusterByIdIdx( long Id, boolean forceRead )
	{
		CFGenKbClusterPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newPKey();
		pkey.setRequiredId( Id );
		ICFGenKbClusterObj obj = readCluster( pkey, forceRead );
		return( obj );
	}

	public ICFGenKbClusterObj readClusterByUDomNameIdx( String FullDomName )
	{
		return( readClusterByUDomNameIdx( FullDomName,
			false ) );
	}

	public ICFGenKbClusterObj readClusterByUDomNameIdx( String FullDomName, boolean forceRead )
	{
		if( indexByUDomNameIdx == null ) {
			indexByUDomNameIdx = new HashMap< CFGenKbClusterByUDomNameIdxKey,
				ICFGenKbClusterObj >();
		}
		CFGenKbClusterByUDomNameIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newUDomNameIdxKey();
		key.setRequiredFullDomName( FullDomName );
		ICFGenKbClusterObj obj = null;
		if( ( ! forceRead ) && indexByUDomNameIdx.containsKey( key ) ) {
			obj = indexByUDomNameIdx.get( key );
		}
		else {
			CFGenKbClusterBuff buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableCluster().readDerivedByUDomNameIdx( schema.getAuthorization(),
				FullDomName );
			if( buff != null ) {
				obj = schema.getClusterTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newPKey() );
				obj.setBuff( buff );
				obj = (ICFGenKbClusterObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbClusterObj readClusterByUDescrIdx( String Description )
	{
		return( readClusterByUDescrIdx( Description,
			false ) );
	}

	public ICFGenKbClusterObj readClusterByUDescrIdx( String Description, boolean forceRead )
	{
		if( indexByUDescrIdx == null ) {
			indexByUDescrIdx = new HashMap< CFGenKbClusterByUDescrIdxKey,
				ICFGenKbClusterObj >();
		}
		CFGenKbClusterByUDescrIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newUDescrIdxKey();
		key.setRequiredDescription( Description );
		ICFGenKbClusterObj obj = null;
		if( ( ! forceRead ) && indexByUDescrIdx.containsKey( key ) ) {
			obj = indexByUDescrIdx.get( key );
		}
		else {
			CFGenKbClusterBuff buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableCluster().readDerivedByUDescrIdx( schema.getAuthorization(),
				Description );
			if( buff != null ) {
				obj = schema.getClusterTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newPKey() );
				obj.setBuff( buff );
				obj = (ICFGenKbClusterObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbClusterObj updateCluster( ICFGenKbClusterObj Obj ) {
		ICFGenKbClusterObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableCluster().updateCluster( schema.getAuthorization(),
			Obj.getClusterBuff() );
		obj = (ICFGenKbClusterObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteCluster( ICFGenKbClusterObj Obj ) {
		ICFGenKbClusterObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableCluster().deleteCluster( schema.getAuthorization(),
			obj.getClusterBuff() );
		obj.forget( true );
	}

	public void deleteClusterByIdIdx( long Id )
	{
		CFGenKbClusterPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newPKey();
		pkey.setRequiredId( Id );
		ICFGenKbClusterObj obj = readCluster( pkey );
		if( obj != null ) {
			ICFGenKbClusterEditObj editObj = (ICFGenKbClusterEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbClusterEditObj)obj.beginEdit();
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

	public void deleteClusterByUDomNameIdx( String FullDomName )
	{
		if( indexByUDomNameIdx == null ) {
			indexByUDomNameIdx = new HashMap< CFGenKbClusterByUDomNameIdxKey,
				ICFGenKbClusterObj >();
		}
		CFGenKbClusterByUDomNameIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newUDomNameIdxKey();
		key.setRequiredFullDomName( FullDomName );
		ICFGenKbClusterObj obj = null;
		if( indexByUDomNameIdx.containsKey( key ) ) {
			obj = indexByUDomNameIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableCluster().deleteClusterByUDomNameIdx( schema.getAuthorization(),
				FullDomName );
			obj.forget( true );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableCluster().deleteClusterByUDomNameIdx( schema.getAuthorization(),
				FullDomName );
		}
	}

	public void deleteClusterByUDescrIdx( String Description )
	{
		if( indexByUDescrIdx == null ) {
			indexByUDescrIdx = new HashMap< CFGenKbClusterByUDescrIdxKey,
				ICFGenKbClusterObj >();
		}
		CFGenKbClusterByUDescrIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newUDescrIdxKey();
		key.setRequiredDescription( Description );
		ICFGenKbClusterObj obj = null;
		if( indexByUDescrIdx.containsKey( key ) ) {
			obj = indexByUDescrIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableCluster().deleteClusterByUDescrIdx( schema.getAuthorization(),
				Description );
			obj.forget( true );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableCluster().deleteClusterByUDescrIdx( schema.getAuthorization(),
				Description );
		}
	}

	public ICFGenKbClusterObj getSystemCluster() {
		boolean transactionStarted = schema.beginTransaction();
		ICFGenKbClusterObj clusterObj;
		try {
			clusterObj = readClusterByUDomNameIdx( "system" );
			if( clusterObj == null ) {
				clusterObj = newInstance();
				ICFGenKbClusterEditObj clusterEdit = clusterObj.beginEdit();
				clusterEdit.setRequiredFullDomName( "system" );
				clusterObj = clusterEdit.create();
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
		return( clusterObj );
	}
}
