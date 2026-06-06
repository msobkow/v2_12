// Description: Java 11 Table Object implementation for CFInt.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;

public class CFIntTSecGroupTableObj
	implements ICFIntTSecGroupTableObj
{
	protected ICFSecSchemaObj schema;
	private Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj> members;
	private Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj> allTSecGroup;
	private Map< CFSecTSecGroupByTenantIdxKey,
		Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj > > indexByTenantIdx;
	private Map< CFSecTSecGroupByTenantVisIdxKey,
		Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj > > indexByTenantVisIdx;
	private Map< CFSecTSecGroupByUNameIdxKey,
		ICFSecTSecGroupObj > indexByUNameIdx;
	public static String TABLE_NAME = "TSecGroup";
	public static String TABLE_DBNAME = "tsecgrp";

	public CFIntTSecGroupTableObj() {
		schema = null;
		members = new HashMap<CFSecTSecGroupPKey, ICFSecTSecGroupObj>();
		allTSecGroup = null;
		indexByTenantIdx = null;
		indexByTenantVisIdx = null;
		indexByUNameIdx = null;
	}

	public CFIntTSecGroupTableObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFSecTSecGroupPKey, ICFSecTSecGroupObj>();
		allTSecGroup = null;
		indexByTenantIdx = null;
		indexByTenantVisIdx = null;
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
		allTSecGroup = null;
		indexByTenantIdx = null;
		indexByTenantVisIdx = null;
		indexByUNameIdx = null;
		List<ICFSecTSecGroupObj> toForget = new LinkedList<ICFSecTSecGroupObj>();
		ICFSecTSecGroupObj cur = null;
		Iterator<ICFSecTSecGroupObj> iter = members.values().iterator();
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
	 *	CFIntTSecGroupObj.
	 */
	public ICFSecTSecGroupObj newInstance() {
		ICFSecTSecGroupObj inst = new CFIntTSecGroupObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFIntTSecGroupObj.
	 */
	public ICFSecTSecGroupEditObj newEditInstance( ICFSecTSecGroupObj orig ) {
		ICFSecTSecGroupEditObj edit = new CFIntTSecGroupEditObj( orig );
		return( edit );
	}

	public ICFSecTSecGroupObj realiseTSecGroup( ICFSecTSecGroupObj Obj ) {
		ICFSecTSecGroupObj obj = Obj;
		CFSecTSecGroupPKey pkey = obj.getPKey();
		ICFSecTSecGroupObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFSecTSecGroupObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFSecTSecGroupByTenantIdxKey keyTenantIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByTenantVisIdx != null ) {
				CFSecTSecGroupByTenantVisIdxKey keyTenantVisIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newTenantVisIdxKey();
				keyTenantVisIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTenantVisIdx.setRequiredIsVisible( keepObj.getRequiredIsVisible() );
				Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj > mapTenantVisIdx = indexByTenantVisIdx.get( keyTenantVisIdx );
				if( mapTenantVisIdx != null ) {
					mapTenantVisIdx.remove( keepObj.getPKey() );
					if( mapTenantVisIdx.size() <= 0 ) {
						indexByTenantVisIdx.remove( keyTenantVisIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFSecTSecGroupByUNameIdxKey keyUNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFSecTSecGroupByTenantIdxKey keyTenantIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTenantVisIdx != null ) {
				CFSecTSecGroupByTenantVisIdxKey keyTenantVisIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newTenantVisIdxKey();
				keyTenantVisIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTenantVisIdx.setRequiredIsVisible( keepObj.getRequiredIsVisible() );
				Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj > mapTenantVisIdx = indexByTenantVisIdx.get( keyTenantVisIdx );
				if( mapTenantVisIdx != null ) {
					mapTenantVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFSecTSecGroupByUNameIdxKey keyUNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allTSecGroup != null ) {
				allTSecGroup.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTSecGroup != null ) {
				allTSecGroup.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFSecTSecGroupByTenantIdxKey keyTenantIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTenantVisIdx != null ) {
				CFSecTSecGroupByTenantVisIdxKey keyTenantVisIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newTenantVisIdxKey();
				keyTenantVisIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTenantVisIdx.setRequiredIsVisible( keepObj.getRequiredIsVisible() );
				Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj > mapTenantVisIdx = indexByTenantVisIdx.get( keyTenantVisIdx );
				if( mapTenantVisIdx != null ) {
					mapTenantVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFSecTSecGroupByUNameIdxKey keyUNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetTSecGroup( ICFSecTSecGroupObj Obj ) {
		forgetTSecGroup( Obj, false );
	}

	public void forgetTSecGroup( ICFSecTSecGroupObj Obj, boolean forgetSubObjects ) {
		ICFSecTSecGroupObj obj = Obj;
		CFSecTSecGroupPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFSecTSecGroupObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFSecTSecGroupByTenantIdxKey keyTenantIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByTenantVisIdx != null ) {
				CFSecTSecGroupByTenantVisIdxKey keyTenantVisIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newTenantVisIdxKey();
				keyTenantVisIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTenantVisIdx.setRequiredIsVisible( keepObj.getRequiredIsVisible() );
				Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj > mapTenantVisIdx = indexByTenantVisIdx.get( keyTenantVisIdx );
				if( mapTenantVisIdx != null ) {
					mapTenantVisIdx.remove( keepObj.getPKey() );
					if( mapTenantVisIdx.size() <= 0 ) {
						indexByTenantVisIdx.remove( keyTenantVisIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFSecTSecGroupByUNameIdxKey keyUNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allTSecGroup != null ) {
				allTSecGroup.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFSecSchemaObj)schema).getTSecGrpIncTableObj().forgetTSecGrpIncByGroupIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredTSecGroupId() );
				((ICFSecSchemaObj)schema).getTSecGrpMembTableObj().forgetTSecGrpMembByGroupIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredTSecGroupId() );
				((ICFSecSchemaObj)schema).getTSecGrpIncTableObj().forgetTSecGrpIncByIncludeIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredTSecGroupId() );
			}
		}
	}

	public void forgetTSecGroupByIdIdx( long TenantId,
		int TSecGroupId )
	{
		if( members == null ) {
			return;
		}
		CFSecTSecGroupPKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		if( members.containsKey( key ) ) {
			ICFSecTSecGroupObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTSecGroupByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFSecTSecGroupObj> toForget = new LinkedList<ICFSecTSecGroupObj>();
		ICFSecTSecGroupObj cur = null;
		CFSecTSecGroupByTenantIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFSecTSecGroupObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecTSecGroupObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecTSecGroupObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTSecGroupByTenantVisIdx( long TenantId,
		boolean IsVisible )
	{
		if( indexByTenantVisIdx == null ) {
			return;
		}
		List<ICFSecTSecGroupObj> toForget = new LinkedList<ICFSecTSecGroupObj>();
		ICFSecTSecGroupObj cur = null;
		CFSecTSecGroupByTenantVisIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newTenantVisIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIsVisible( IsVisible );
		if( indexByTenantVisIdx.containsKey( key ) ) {
			Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj > mapTenantVisIdx = indexByTenantVisIdx.get( key );
			if( mapTenantVisIdx != null ) {
				Iterator<ICFSecTSecGroupObj> iterDup = mapTenantVisIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantVisIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecTSecGroupObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecTSecGroupObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTSecGroupByUNameIdx( long TenantId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFSecTSecGroupObj> toForget = new LinkedList<ICFSecTSecGroupObj>();
		ICFSecTSecGroupObj cur = null;
		CFSecTSecGroupByUNameIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFSecTSecGroupObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFSecTSecGroupObj createTSecGroup( ICFSecTSecGroupObj Obj ) {
		ICFSecTSecGroupObj obj = Obj;
		CFSecTSecGroupBuff buff = obj.getTSecGroupBuff();
		((ICFIntSchema)schema.getBackingStore()).getTableTSecGroup().createTSecGroup(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFSecTSecGroupObj readTSecGroup( CFSecTSecGroupPKey pkey ) {
		return( readTSecGroup( pkey, false ) );
	}

	public ICFSecTSecGroupObj readTSecGroup( CFSecTSecGroupPKey pkey, boolean forceRead ) {
		ICFSecTSecGroupObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFSecTSecGroupBuff readBuff = ((ICFIntSchema)schema.getBackingStore()).getTableTSecGroup().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredTSecGroupId() );
			if( readBuff != null ) {
				obj = schema.getTSecGroupTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFSecTSecGroupObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecTSecGroupObj lockTSecGroup( CFSecTSecGroupPKey pkey ) {
		ICFSecTSecGroupObj locked = null;
		CFSecTSecGroupBuff lockBuff = ((ICFIntSchema)schema.getBackingStore()).getTableTSecGroup().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getTSecGroupTableObj().newInstance();
			locked.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFSecTSecGroupObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockTSecGroup", pkey );
		}
		return( locked );
	}

	public List<ICFSecTSecGroupObj> readAllTSecGroup() {
		return( readAllTSecGroup( false ) );
	}

	public List<ICFSecTSecGroupObj> readAllTSecGroup( boolean forceRead ) {
		final String S_ProcName = "readAllTSecGroup";
		if( ( allTSecGroup == null ) || forceRead ) {
			Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj> map = new HashMap<CFSecTSecGroupPKey,ICFSecTSecGroupObj>();
			allTSecGroup = map;
			CFSecTSecGroupBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableTSecGroup().readAllDerived( schema.getAuthorization() );
			CFSecTSecGroupBuff buff;
			ICFSecTSecGroupObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newPKey() );
				obj.setBuff( buff );
				ICFSecTSecGroupObj realised = (ICFSecTSecGroupObj)obj.realise();
			}
		}
		int len = allTSecGroup.size();
		ICFSecTSecGroupObj arr[] = new ICFSecTSecGroupObj[len];
		Iterator<ICFSecTSecGroupObj> valIter = allTSecGroup.values().iterator();
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
		ArrayList<ICFSecTSecGroupObj> arrayList = new ArrayList<ICFSecTSecGroupObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecTSecGroupObj> cmp = new Comparator<ICFSecTSecGroupObj>() {
			public int compare( ICFSecTSecGroupObj lhs, ICFSecTSecGroupObj rhs ) {
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
					CFSecTSecGroupPKey lhsPKey = lhs.getPKey();
					CFSecTSecGroupPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecTSecGroupObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecTSecGroupObj readTSecGroupByIdIdx( long TenantId,
		int TSecGroupId )
	{
		return( readTSecGroupByIdIdx( TenantId,
			TSecGroupId,
			false ) );
	}

	public ICFSecTSecGroupObj readTSecGroupByIdIdx( long TenantId,
		int TSecGroupId, boolean forceRead )
	{
		CFSecTSecGroupPKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredTSecGroupId( TSecGroupId );
		ICFSecTSecGroupObj obj = readTSecGroup( pkey, forceRead );
		return( obj );
	}

	public List<ICFSecTSecGroupObj> readTSecGroupByTenantIdx( long TenantId )
	{
		return( readTSecGroupByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFSecTSecGroupObj> readTSecGroupByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTSecGroupByTenantIdx";
		CFSecTSecGroupByTenantIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFSecTSecGroupByTenantIdxKey,
				Map< CFSecTSecGroupPKey, ICFSecTSecGroupObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecTSecGroupPKey, ICFSecTSecGroupObj>();
			ICFSecTSecGroupObj obj;
			CFSecTSecGroupBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableTSecGroup().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFSecTSecGroupBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTSecGroupTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newPKey() );
				obj.setBuff( buff );
				ICFSecTSecGroupObj realised = (ICFSecTSecGroupObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecTSecGroupObj arr[] = new ICFSecTSecGroupObj[len];
		Iterator<ICFSecTSecGroupObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecTSecGroupObj> arrayList = new ArrayList<ICFSecTSecGroupObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecTSecGroupObj> cmp = new Comparator<ICFSecTSecGroupObj>() {
			public int compare( ICFSecTSecGroupObj lhs, ICFSecTSecGroupObj rhs ) {
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
					CFSecTSecGroupPKey lhsPKey = lhs.getPKey();
					CFSecTSecGroupPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecTSecGroupObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFSecTSecGroupObj> readTSecGroupByTenantVisIdx( long TenantId,
		boolean IsVisible )
	{
		return( readTSecGroupByTenantVisIdx( TenantId,
			IsVisible,
			false ) );
	}

	public List<ICFSecTSecGroupObj> readTSecGroupByTenantVisIdx( long TenantId,
		boolean IsVisible,
		boolean forceRead )
	{
		final String S_ProcName = "readTSecGroupByTenantVisIdx";
		CFSecTSecGroupByTenantVisIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newTenantVisIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIsVisible( IsVisible );
		Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj> dict;
		if( indexByTenantVisIdx == null ) {
			indexByTenantVisIdx = new HashMap< CFSecTSecGroupByTenantVisIdxKey,
				Map< CFSecTSecGroupPKey, ICFSecTSecGroupObj > >();
		}
		if( ( ! forceRead ) && indexByTenantVisIdx.containsKey( key ) ) {
			dict = indexByTenantVisIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecTSecGroupPKey, ICFSecTSecGroupObj>();
			ICFSecTSecGroupObj obj;
			CFSecTSecGroupBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableTSecGroup().readDerivedByTenantVisIdx( schema.getAuthorization(),
				TenantId,
				IsVisible );
			CFSecTSecGroupBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTSecGroupTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newPKey() );
				obj.setBuff( buff );
				ICFSecTSecGroupObj realised = (ICFSecTSecGroupObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantVisIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecTSecGroupObj arr[] = new ICFSecTSecGroupObj[len];
		Iterator<ICFSecTSecGroupObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecTSecGroupObj> arrayList = new ArrayList<ICFSecTSecGroupObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecTSecGroupObj> cmp = new Comparator<ICFSecTSecGroupObj>() {
			public int compare( ICFSecTSecGroupObj lhs, ICFSecTSecGroupObj rhs ) {
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
					CFSecTSecGroupPKey lhsPKey = lhs.getPKey();
					CFSecTSecGroupPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecTSecGroupObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecTSecGroupObj readTSecGroupByUNameIdx( long TenantId,
		String Name )
	{
		return( readTSecGroupByUNameIdx( TenantId,
			Name,
			false ) );
	}

	public ICFSecTSecGroupObj readTSecGroupByUNameIdx( long TenantId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFSecTSecGroupByUNameIdxKey,
				ICFSecTSecGroupObj >();
		}
		CFSecTSecGroupByUNameIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		ICFSecTSecGroupObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFSecTSecGroupBuff buff = ((ICFIntSchema)schema.getBackingStore()).getTableTSecGroup().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				Name );
			if( buff != null ) {
				obj = schema.getTSecGroupTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newPKey() );
				obj.setBuff( buff );
				obj = (ICFSecTSecGroupObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecTSecGroupObj updateTSecGroup( ICFSecTSecGroupObj Obj ) {
		ICFSecTSecGroupObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableTSecGroup().updateTSecGroup( schema.getAuthorization(),
			Obj.getTSecGroupBuff() );
		obj = (ICFSecTSecGroupObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteTSecGroup( ICFSecTSecGroupObj Obj ) {
		ICFSecTSecGroupObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableTSecGroup().deleteTSecGroup( schema.getAuthorization(),
			obj.getTSecGroupBuff() );
		obj.forget( true );
	}

	public void deleteTSecGroupByIdIdx( long TenantId,
		int TSecGroupId )
	{
		CFSecTSecGroupPKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredTSecGroupId( TSecGroupId );
		ICFSecTSecGroupObj obj = readTSecGroup( pkey );
		if( obj != null ) {
			ICFSecTSecGroupEditObj editObj = (ICFSecTSecGroupEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFSecTSecGroupEditObj)obj.beginEdit();
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

	public void deleteTSecGroupByTenantIdx( long TenantId )
	{
		CFSecTSecGroupByTenantIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFSecTSecGroupByTenantIdxKey,
				Map< CFSecTSecGroupPKey, ICFSecTSecGroupObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj> dict = indexByTenantIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableTSecGroup().deleteTSecGroupByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFSecTSecGroupObj> iter = dict.values().iterator();
			ICFSecTSecGroupObj obj;
			List<ICFSecTSecGroupObj> toForget = new LinkedList<ICFSecTSecGroupObj>();
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
			((ICFIntSchema)schema.getBackingStore()).getTableTSecGroup().deleteTSecGroupByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTSecGroupByTenantVisIdx( long TenantId,
		boolean IsVisible )
	{
		CFSecTSecGroupByTenantVisIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newTenantVisIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIsVisible( IsVisible );
		if( indexByTenantVisIdx == null ) {
			indexByTenantVisIdx = new HashMap< CFSecTSecGroupByTenantVisIdxKey,
				Map< CFSecTSecGroupPKey, ICFSecTSecGroupObj > >();
		}
		if( indexByTenantVisIdx.containsKey( key ) ) {
			Map<CFSecTSecGroupPKey, ICFSecTSecGroupObj> dict = indexByTenantVisIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableTSecGroup().deleteTSecGroupByTenantVisIdx( schema.getAuthorization(),
				TenantId,
				IsVisible );
			Iterator<ICFSecTSecGroupObj> iter = dict.values().iterator();
			ICFSecTSecGroupObj obj;
			List<ICFSecTSecGroupObj> toForget = new LinkedList<ICFSecTSecGroupObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByTenantVisIdx.remove( key );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableTSecGroup().deleteTSecGroupByTenantVisIdx( schema.getAuthorization(),
				TenantId,
				IsVisible );
		}
	}

	public void deleteTSecGroupByUNameIdx( long TenantId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFSecTSecGroupByUNameIdxKey,
				ICFSecTSecGroupObj >();
		}
		CFSecTSecGroupByUNameIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGroup().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		ICFSecTSecGroupObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableTSecGroup().deleteTSecGroupByUNameIdx( schema.getAuthorization(),
				TenantId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableTSecGroup().deleteTSecGroupByUNameIdx( schema.getAuthorization(),
				TenantId,
				Name );
		}
	}
}
