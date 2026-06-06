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

public class CFGenKbGelSwitchLimbTableObj
	implements ICFGenKbGelSwitchLimbTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj> members;
	private Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj> allGelSwitchLimb;
	private Map< CFGenKbGelSwitchLimbByTenantIdxKey,
		Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj > > indexByTenantIdx;
	private Map< CFGenKbGelSwitchLimbBySwitchIdxKey,
		Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj > > indexBySwitchIdx;
	public static String TABLE_NAME = "GelSwitchLimb";
	public static String TABLE_DBNAME = "gellimb";

	public CFGenKbGelSwitchLimbTableObj() {
		schema = null;
		members = new HashMap<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj>();
		allGelSwitchLimb = null;
		indexByTenantIdx = null;
		indexBySwitchIdx = null;
	}

	public CFGenKbGelSwitchLimbTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj>();
		allGelSwitchLimb = null;
		indexByTenantIdx = null;
		indexBySwitchIdx = null;
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
		allGelSwitchLimb = null;
		indexByTenantIdx = null;
		indexBySwitchIdx = null;
		List<ICFGenKbGelSwitchLimbObj> toForget = new LinkedList<ICFGenKbGelSwitchLimbObj>();
		ICFGenKbGelSwitchLimbObj cur = null;
		Iterator<ICFGenKbGelSwitchLimbObj> iter = members.values().iterator();
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
	 *	CFGenKbGelSwitchLimbObj.
	 */
	public ICFGenKbGelSwitchLimbObj newInstance() {
		ICFGenKbGelSwitchLimbObj inst = new CFGenKbGelSwitchLimbObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbGelSwitchLimbObj.
	 */
	public ICFGenKbGelSwitchLimbEditObj newEditInstance( ICFGenKbGelSwitchLimbObj orig ) {
		ICFGenKbGelSwitchLimbEditObj edit = new CFGenKbGelSwitchLimbEditObj( orig );
		return( edit );
	}

	public ICFGenKbGelSwitchLimbObj realiseGelSwitchLimb( ICFGenKbGelSwitchLimbObj Obj ) {
		ICFGenKbGelSwitchLimbObj obj = Obj;
		CFGenKbGelSwitchLimbPKey pkey = obj.getPKey();
		ICFGenKbGelSwitchLimbObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbGelSwitchLimbObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFGenKbGelSwitchLimbByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexBySwitchIdx != null ) {
				CFGenKbGelSwitchLimbBySwitchIdxKey keySwitchIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newSwitchIdxKey();
				keySwitchIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySwitchIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				keySwitchIdx.setRequiredGelInstId( keepObj.getRequiredGelInstId() );
				Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj > mapSwitchIdx = indexBySwitchIdx.get( keySwitchIdx );
				if( mapSwitchIdx != null ) {
					mapSwitchIdx.remove( keepObj.getPKey() );
					if( mapSwitchIdx.size() <= 0 ) {
						indexBySwitchIdx.remove( keySwitchIdx );
					}
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFGenKbGelSwitchLimbByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySwitchIdx != null ) {
				CFGenKbGelSwitchLimbBySwitchIdxKey keySwitchIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newSwitchIdxKey();
				keySwitchIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySwitchIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				keySwitchIdx.setRequiredGelInstId( keepObj.getRequiredGelInstId() );
				Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj > mapSwitchIdx = indexBySwitchIdx.get( keySwitchIdx );
				if( mapSwitchIdx != null ) {
					mapSwitchIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allGelSwitchLimb != null ) {
				allGelSwitchLimb.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allGelSwitchLimb != null ) {
				allGelSwitchLimb.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFGenKbGelSwitchLimbByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySwitchIdx != null ) {
				CFGenKbGelSwitchLimbBySwitchIdxKey keySwitchIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newSwitchIdxKey();
				keySwitchIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySwitchIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				keySwitchIdx.setRequiredGelInstId( keepObj.getRequiredGelInstId() );
				Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj > mapSwitchIdx = indexBySwitchIdx.get( keySwitchIdx );
				if( mapSwitchIdx != null ) {
					mapSwitchIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetGelSwitchLimb( ICFGenKbGelSwitchLimbObj Obj ) {
		forgetGelSwitchLimb( Obj, false );
	}

	public void forgetGelSwitchLimb( ICFGenKbGelSwitchLimbObj Obj, boolean forgetSubObjects ) {
		ICFGenKbGelSwitchLimbObj obj = Obj;
		CFGenKbGelSwitchLimbPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbGelSwitchLimbObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFGenKbGelSwitchLimbByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexBySwitchIdx != null ) {
				CFGenKbGelSwitchLimbBySwitchIdxKey keySwitchIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newSwitchIdxKey();
				keySwitchIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySwitchIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				keySwitchIdx.setRequiredGelInstId( keepObj.getRequiredGelInstId() );
				Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj > mapSwitchIdx = indexBySwitchIdx.get( keySwitchIdx );
				if( mapSwitchIdx != null ) {
					mapSwitchIdx.remove( keepObj.getPKey() );
					if( mapSwitchIdx.size() <= 0 ) {
						indexBySwitchIdx.remove( keySwitchIdx );
					}
				}
			}

			if( allGelSwitchLimb != null ) {
				allGelSwitchLimb.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetGelSwitchLimbByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId,
		String LimbName )
	{
		if( members == null ) {
			return;
		}
		CFGenKbGelSwitchLimbPKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );
		key.setRequiredLimbName( LimbName );
		if( members.containsKey( key ) ) {
			ICFGenKbGelSwitchLimbObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetGelSwitchLimbByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFGenKbGelSwitchLimbObj> toForget = new LinkedList<ICFGenKbGelSwitchLimbObj>();
		ICFGenKbGelSwitchLimbObj cur = null;
		CFGenKbGelSwitchLimbByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFGenKbGelSwitchLimbObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelSwitchLimbObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelSwitchLimbObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelSwitchLimbBySwitchIdx( long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		if( indexBySwitchIdx == null ) {
			return;
		}
		List<ICFGenKbGelSwitchLimbObj> toForget = new LinkedList<ICFGenKbGelSwitchLimbObj>();
		ICFGenKbGelSwitchLimbObj cur = null;
		CFGenKbGelSwitchLimbBySwitchIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newSwitchIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );
		if( indexBySwitchIdx.containsKey( key ) ) {
			Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj > mapSwitchIdx = indexBySwitchIdx.get( key );
			if( mapSwitchIdx != null ) {
				Iterator<ICFGenKbGelSwitchLimbObj> iterDup = mapSwitchIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexBySwitchIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelSwitchLimbObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelSwitchLimbObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbGelSwitchLimbObj createGelSwitchLimb( ICFGenKbGelSwitchLimbObj Obj ) {
		ICFGenKbGelSwitchLimbObj obj = Obj;
		CFGenKbGelSwitchLimbBuff buff = obj.getGelSwitchLimbBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelSwitchLimb().createGelSwitchLimb(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbGelSwitchLimbObj readGelSwitchLimb( CFGenKbGelSwitchLimbPKey pkey ) {
		return( readGelSwitchLimb( pkey, false ) );
	}

	public ICFGenKbGelSwitchLimbObj readGelSwitchLimb( CFGenKbGelSwitchLimbPKey pkey, boolean forceRead ) {
		ICFGenKbGelSwitchLimbObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbGelSwitchLimbBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelSwitchLimb().readDerivedByPIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredGelCacheId(),
				pkey.getRequiredGelInstId(),
				pkey.getRequiredLimbName() );
			if( readBuff != null ) {
				obj = schema.getGelSwitchLimbTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbGelSwitchLimbObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbGelSwitchLimbObj lockGelSwitchLimb( CFGenKbGelSwitchLimbPKey pkey ) {
		ICFGenKbGelSwitchLimbObj locked = null;
		CFGenKbGelSwitchLimbBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelSwitchLimb().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getGelSwitchLimbTableObj().newInstance();
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbGelSwitchLimbObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockGelSwitchLimb", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbGelSwitchLimbObj> readAllGelSwitchLimb() {
		return( readAllGelSwitchLimb( false ) );
	}

	public List<ICFGenKbGelSwitchLimbObj> readAllGelSwitchLimb( boolean forceRead ) {
		final String S_ProcName = "readAllGelSwitchLimb";
		if( ( allGelSwitchLimb == null ) || forceRead ) {
			Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj> map = new HashMap<CFGenKbGelSwitchLimbPKey,ICFGenKbGelSwitchLimbObj>();
			allGelSwitchLimb = map;
			CFGenKbGelSwitchLimbBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelSwitchLimb().readAllDerived( schema.getAuthorization() );
			CFGenKbGelSwitchLimbBuff buff;
			ICFGenKbGelSwitchLimbObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelSwitchLimbObj realised = (ICFGenKbGelSwitchLimbObj)obj.realise();
			}
		}
		int len = allGelSwitchLimb.size();
		ICFGenKbGelSwitchLimbObj arr[] = new ICFGenKbGelSwitchLimbObj[len];
		Iterator<ICFGenKbGelSwitchLimbObj> valIter = allGelSwitchLimb.values().iterator();
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
		ArrayList<ICFGenKbGelSwitchLimbObj> arrayList = new ArrayList<ICFGenKbGelSwitchLimbObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelSwitchLimbObj> cmp = new Comparator<ICFGenKbGelSwitchLimbObj>() {
			public int compare( ICFGenKbGelSwitchLimbObj lhs, ICFGenKbGelSwitchLimbObj rhs ) {
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
					CFGenKbGelSwitchLimbPKey lhsPKey = lhs.getPKey();
					CFGenKbGelSwitchLimbPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGelSwitchLimbObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGelSwitchLimbObj readGelSwitchLimbByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId,
		String LimbName )
	{
		return( readGelSwitchLimbByPIdx( TenantId,
			GelCacheId,
			GelInstId,
			LimbName,
			false ) );
	}

	public ICFGenKbGelSwitchLimbObj readGelSwitchLimbByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId,
		String LimbName, boolean forceRead )
	{
		CFGenKbGelSwitchLimbPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredGelCacheId( GelCacheId );
		pkey.setRequiredGelInstId( GelInstId );
		pkey.setRequiredLimbName( LimbName );
		ICFGenKbGelSwitchLimbObj obj = readGelSwitchLimb( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbGelSwitchLimbObj> readGelSwitchLimbByTenantIdx( long TenantId )
	{
		return( readGelSwitchLimbByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFGenKbGelSwitchLimbObj> readGelSwitchLimbByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelSwitchLimbByTenantIdx";
		CFGenKbGelSwitchLimbByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGelSwitchLimbByTenantIdxKey,
				Map< CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj>();
			ICFGenKbGelSwitchLimbObj obj;
			CFGenKbGelSwitchLimbBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelSwitchLimb().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFGenKbGelSwitchLimbBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getGelSwitchLimbTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelSwitchLimbObj realised = (ICFGenKbGelSwitchLimbObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelSwitchLimbObj arr[] = new ICFGenKbGelSwitchLimbObj[len];
		Iterator<ICFGenKbGelSwitchLimbObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelSwitchLimbObj> arrayList = new ArrayList<ICFGenKbGelSwitchLimbObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelSwitchLimbObj> cmp = new Comparator<ICFGenKbGelSwitchLimbObj>() {
			public int compare( ICFGenKbGelSwitchLimbObj lhs, ICFGenKbGelSwitchLimbObj rhs ) {
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
					CFGenKbGelSwitchLimbPKey lhsPKey = lhs.getPKey();
					CFGenKbGelSwitchLimbPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGelSwitchLimbObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelSwitchLimbObj> readGelSwitchLimbBySwitchIdx( long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		return( readGelSwitchLimbBySwitchIdx( TenantId,
			GelCacheId,
			GelInstId,
			false ) );
	}

	public List<ICFGenKbGelSwitchLimbObj> readGelSwitchLimbBySwitchIdx( long TenantId,
		long GelCacheId,
		long GelInstId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelSwitchLimbBySwitchIdx";
		CFGenKbGelSwitchLimbBySwitchIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newSwitchIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );
		Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj> dict;
		if( indexBySwitchIdx == null ) {
			indexBySwitchIdx = new HashMap< CFGenKbGelSwitchLimbBySwitchIdxKey,
				Map< CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj > >();
		}
		if( ( ! forceRead ) && indexBySwitchIdx.containsKey( key ) ) {
			dict = indexBySwitchIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj>();
			ICFGenKbGelSwitchLimbObj obj;
			CFGenKbGelSwitchLimbBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelSwitchLimb().readDerivedBySwitchIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId,
				GelInstId );
			CFGenKbGelSwitchLimbBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getGelSwitchLimbTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelSwitchLimbObj realised = (ICFGenKbGelSwitchLimbObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySwitchIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelSwitchLimbObj arr[] = new ICFGenKbGelSwitchLimbObj[len];
		Iterator<ICFGenKbGelSwitchLimbObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelSwitchLimbObj> arrayList = new ArrayList<ICFGenKbGelSwitchLimbObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelSwitchLimbObj> cmp = new Comparator<ICFGenKbGelSwitchLimbObj>() {
			public int compare( ICFGenKbGelSwitchLimbObj lhs, ICFGenKbGelSwitchLimbObj rhs ) {
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
					CFGenKbGelSwitchLimbPKey lhsPKey = lhs.getPKey();
					CFGenKbGelSwitchLimbPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGelSwitchLimbObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGelSwitchLimbObj updateGelSwitchLimb( ICFGenKbGelSwitchLimbObj Obj ) {
		ICFGenKbGelSwitchLimbObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelSwitchLimb().updateGelSwitchLimb( schema.getAuthorization(),
			Obj.getGelSwitchLimbBuff() );
		obj = (ICFGenKbGelSwitchLimbObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteGelSwitchLimb( ICFGenKbGelSwitchLimbObj Obj ) {
		ICFGenKbGelSwitchLimbObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelSwitchLimb().deleteGelSwitchLimb( schema.getAuthorization(),
			obj.getGelSwitchLimbBuff() );
		obj.forget( true );
	}

	public void deleteGelSwitchLimbByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId,
		String LimbName )
	{
		CFGenKbGelSwitchLimbPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredGelCacheId( GelCacheId );
		pkey.setRequiredGelInstId( GelInstId );
		pkey.setRequiredLimbName( LimbName );
		ICFGenKbGelSwitchLimbObj obj = readGelSwitchLimb( pkey );
		if( obj != null ) {
			ICFGenKbGelSwitchLimbEditObj editObj = (ICFGenKbGelSwitchLimbEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbGelSwitchLimbEditObj)obj.beginEdit();
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

	public void deleteGelSwitchLimbByTenantIdx( long TenantId )
	{
		CFGenKbGelSwitchLimbByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGelSwitchLimbByTenantIdxKey,
				Map< CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj> dict = indexByTenantIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelSwitchLimb().deleteGelSwitchLimbByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFGenKbGelSwitchLimbObj> iter = dict.values().iterator();
			ICFGenKbGelSwitchLimbObj obj;
			List<ICFGenKbGelSwitchLimbObj> toForget = new LinkedList<ICFGenKbGelSwitchLimbObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelSwitchLimb().deleteGelSwitchLimbByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteGelSwitchLimbBySwitchIdx( long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		CFGenKbGelSwitchLimbBySwitchIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitchLimb().newSwitchIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );
		if( indexBySwitchIdx == null ) {
			indexBySwitchIdx = new HashMap< CFGenKbGelSwitchLimbBySwitchIdxKey,
				Map< CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj > >();
		}
		if( indexBySwitchIdx.containsKey( key ) ) {
			Map<CFGenKbGelSwitchLimbPKey, ICFGenKbGelSwitchLimbObj> dict = indexBySwitchIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelSwitchLimb().deleteGelSwitchLimbBySwitchIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId,
				GelInstId );
			Iterator<ICFGenKbGelSwitchLimbObj> iter = dict.values().iterator();
			ICFGenKbGelSwitchLimbObj obj;
			List<ICFGenKbGelSwitchLimbObj> toForget = new LinkedList<ICFGenKbGelSwitchLimbObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexBySwitchIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelSwitchLimb().deleteGelSwitchLimbBySwitchIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId,
				GelInstId );
		}
	}
}
