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

public class CFIntISOCtryCcyTableObj
	implements ICFIntISOCtryCcyTableObj
{
	protected ICFSecSchemaObj schema;
	private Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj> members;
	private Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj> allISOCtryCcy;
	private Map< CFSecISOCtryCcyByCtryIdxKey,
		Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj > > indexByCtryIdx;
	private Map< CFSecISOCtryCcyByCcyIdxKey,
		Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj > > indexByCcyIdx;
	public static String TABLE_NAME = "ISOCtryCcy";
	public static String TABLE_DBNAME = "iso_cntryccy";

	public CFIntISOCtryCcyTableObj() {
		schema = null;
		members = new HashMap<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj>();
		allISOCtryCcy = null;
		indexByCtryIdx = null;
		indexByCcyIdx = null;
	}

	public CFIntISOCtryCcyTableObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj>();
		allISOCtryCcy = null;
		indexByCtryIdx = null;
		indexByCcyIdx = null;
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
		allISOCtryCcy = null;
		indexByCtryIdx = null;
		indexByCcyIdx = null;
		List<ICFSecISOCtryCcyObj> toForget = new LinkedList<ICFSecISOCtryCcyObj>();
		ICFSecISOCtryCcyObj cur = null;
		Iterator<ICFSecISOCtryCcyObj> iter = members.values().iterator();
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
	 *	CFIntISOCtryCcyObj.
	 */
	public ICFSecISOCtryCcyObj newInstance() {
		ICFSecISOCtryCcyObj inst = new CFIntISOCtryCcyObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFIntISOCtryCcyObj.
	 */
	public ICFSecISOCtryCcyEditObj newEditInstance( ICFSecISOCtryCcyObj orig ) {
		ICFSecISOCtryCcyEditObj edit = new CFIntISOCtryCcyEditObj( orig );
		return( edit );
	}

	public ICFSecISOCtryCcyObj realiseISOCtryCcy( ICFSecISOCtryCcyObj Obj ) {
		ICFSecISOCtryCcyObj obj = Obj;
		CFSecISOCtryCcyPKey pkey = obj.getPKey();
		ICFSecISOCtryCcyObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFSecISOCtryCcyObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByCtryIdx != null ) {
				CFSecISOCtryCcyByCtryIdxKey keyCtryIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newCtryIdxKey();
				keyCtryIdx.setRequiredISOCtryId( keepObj.getRequiredISOCtryId() );
				Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj > mapCtryIdx = indexByCtryIdx.get( keyCtryIdx );
				if( mapCtryIdx != null ) {
					mapCtryIdx.remove( keepObj.getPKey() );
					if( mapCtryIdx.size() <= 0 ) {
						indexByCtryIdx.remove( keyCtryIdx );
					}
				}
			}

			if( indexByCcyIdx != null ) {
				CFSecISOCtryCcyByCcyIdxKey keyCcyIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newCcyIdxKey();
				keyCcyIdx.setRequiredISOCcyId( keepObj.getRequiredISOCcyId() );
				Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj > mapCcyIdx = indexByCcyIdx.get( keyCcyIdx );
				if( mapCcyIdx != null ) {
					mapCcyIdx.remove( keepObj.getPKey() );
					if( mapCcyIdx.size() <= 0 ) {
						indexByCcyIdx.remove( keyCcyIdx );
					}
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByCtryIdx != null ) {
				CFSecISOCtryCcyByCtryIdxKey keyCtryIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newCtryIdxKey();
				keyCtryIdx.setRequiredISOCtryId( keepObj.getRequiredISOCtryId() );
				Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj > mapCtryIdx = indexByCtryIdx.get( keyCtryIdx );
				if( mapCtryIdx != null ) {
					mapCtryIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCcyIdx != null ) {
				CFSecISOCtryCcyByCcyIdxKey keyCcyIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newCcyIdxKey();
				keyCcyIdx.setRequiredISOCcyId( keepObj.getRequiredISOCcyId() );
				Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj > mapCcyIdx = indexByCcyIdx.get( keyCcyIdx );
				if( mapCcyIdx != null ) {
					mapCcyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allISOCtryCcy != null ) {
				allISOCtryCcy.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allISOCtryCcy != null ) {
				allISOCtryCcy.put( keepObj.getPKey(), keepObj );
			}

			if( indexByCtryIdx != null ) {
				CFSecISOCtryCcyByCtryIdxKey keyCtryIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newCtryIdxKey();
				keyCtryIdx.setRequiredISOCtryId( keepObj.getRequiredISOCtryId() );
				Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj > mapCtryIdx = indexByCtryIdx.get( keyCtryIdx );
				if( mapCtryIdx != null ) {
					mapCtryIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCcyIdx != null ) {
				CFSecISOCtryCcyByCcyIdxKey keyCcyIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newCcyIdxKey();
				keyCcyIdx.setRequiredISOCcyId( keepObj.getRequiredISOCcyId() );
				Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj > mapCcyIdx = indexByCcyIdx.get( keyCcyIdx );
				if( mapCcyIdx != null ) {
					mapCcyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetISOCtryCcy( ICFSecISOCtryCcyObj Obj ) {
		forgetISOCtryCcy( Obj, false );
	}

	public void forgetISOCtryCcy( ICFSecISOCtryCcyObj Obj, boolean forgetSubObjects ) {
		ICFSecISOCtryCcyObj obj = Obj;
		CFSecISOCtryCcyPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFSecISOCtryCcyObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByCtryIdx != null ) {
				CFSecISOCtryCcyByCtryIdxKey keyCtryIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newCtryIdxKey();
				keyCtryIdx.setRequiredISOCtryId( keepObj.getRequiredISOCtryId() );
				Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj > mapCtryIdx = indexByCtryIdx.get( keyCtryIdx );
				if( mapCtryIdx != null ) {
					mapCtryIdx.remove( keepObj.getPKey() );
					if( mapCtryIdx.size() <= 0 ) {
						indexByCtryIdx.remove( keyCtryIdx );
					}
				}
			}

			if( indexByCcyIdx != null ) {
				CFSecISOCtryCcyByCcyIdxKey keyCcyIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newCcyIdxKey();
				keyCcyIdx.setRequiredISOCcyId( keepObj.getRequiredISOCcyId() );
				Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj > mapCcyIdx = indexByCcyIdx.get( keyCcyIdx );
				if( mapCcyIdx != null ) {
					mapCcyIdx.remove( keepObj.getPKey() );
					if( mapCcyIdx.size() <= 0 ) {
						indexByCcyIdx.remove( keyCcyIdx );
					}
				}
			}

			if( allISOCtryCcy != null ) {
				allISOCtryCcy.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetISOCtryCcyByIdIdx( short ISOCtryId,
		short ISOCcyId )
	{
		if( members == null ) {
			return;
		}
		CFSecISOCtryCcyPKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newPKey();
		key.setRequiredISOCtryId( ISOCtryId );
		key.setRequiredISOCcyId( ISOCcyId );
		if( members.containsKey( key ) ) {
			ICFSecISOCtryCcyObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetISOCtryCcyByCtryIdx( short ISOCtryId )
	{
		if( indexByCtryIdx == null ) {
			return;
		}
		List<ICFSecISOCtryCcyObj> toForget = new LinkedList<ICFSecISOCtryCcyObj>();
		ICFSecISOCtryCcyObj cur = null;
		CFSecISOCtryCcyByCtryIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newCtryIdxKey();
		key.setRequiredISOCtryId( ISOCtryId );
		if( indexByCtryIdx.containsKey( key ) ) {
			Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj > mapCtryIdx = indexByCtryIdx.get( key );
			if( mapCtryIdx != null ) {
				Iterator<ICFSecISOCtryCcyObj> iterDup = mapCtryIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByCtryIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecISOCtryCcyObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecISOCtryCcyObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetISOCtryCcyByCcyIdx( short ISOCcyId )
	{
		if( indexByCcyIdx == null ) {
			return;
		}
		List<ICFSecISOCtryCcyObj> toForget = new LinkedList<ICFSecISOCtryCcyObj>();
		ICFSecISOCtryCcyObj cur = null;
		CFSecISOCtryCcyByCcyIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newCcyIdxKey();
		key.setRequiredISOCcyId( ISOCcyId );
		if( indexByCcyIdx.containsKey( key ) ) {
			Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj > mapCcyIdx = indexByCcyIdx.get( key );
			if( mapCcyIdx != null ) {
				Iterator<ICFSecISOCtryCcyObj> iterDup = mapCcyIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByCcyIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecISOCtryCcyObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecISOCtryCcyObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFSecISOCtryCcyObj createISOCtryCcy( ICFSecISOCtryCcyObj Obj ) {
		ICFSecISOCtryCcyObj obj = Obj;
		CFSecISOCtryCcyBuff buff = obj.getISOCtryCcyBuff();
		((ICFIntSchema)schema.getBackingStore()).getTableISOCtryCcy().createISOCtryCcy(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFSecISOCtryCcyObj readISOCtryCcy( CFSecISOCtryCcyPKey pkey ) {
		return( readISOCtryCcy( pkey, false ) );
	}

	public ICFSecISOCtryCcyObj readISOCtryCcy( CFSecISOCtryCcyPKey pkey, boolean forceRead ) {
		ICFSecISOCtryCcyObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFSecISOCtryCcyBuff readBuff = ((ICFIntSchema)schema.getBackingStore()).getTableISOCtryCcy().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredISOCtryId(),
				pkey.getRequiredISOCcyId() );
			if( readBuff != null ) {
				obj = schema.getISOCtryCcyTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFSecISOCtryCcyObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecISOCtryCcyObj lockISOCtryCcy( CFSecISOCtryCcyPKey pkey ) {
		ICFSecISOCtryCcyObj locked = null;
		CFSecISOCtryCcyBuff lockBuff = ((ICFIntSchema)schema.getBackingStore()).getTableISOCtryCcy().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getISOCtryCcyTableObj().newInstance();
			locked.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFSecISOCtryCcyObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockISOCtryCcy", pkey );
		}
		return( locked );
	}

	public List<ICFSecISOCtryCcyObj> readAllISOCtryCcy() {
		return( readAllISOCtryCcy( false ) );
	}

	public List<ICFSecISOCtryCcyObj> readAllISOCtryCcy( boolean forceRead ) {
		final String S_ProcName = "readAllISOCtryCcy";
		if( ( allISOCtryCcy == null ) || forceRead ) {
			Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj> map = new HashMap<CFSecISOCtryCcyPKey,ICFSecISOCtryCcyObj>();
			allISOCtryCcy = map;
			CFSecISOCtryCcyBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableISOCtryCcy().readAllDerived( schema.getAuthorization() );
			CFSecISOCtryCcyBuff buff;
			ICFSecISOCtryCcyObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newPKey() );
				obj.setBuff( buff );
				ICFSecISOCtryCcyObj realised = (ICFSecISOCtryCcyObj)obj.realise();
			}
		}
		int len = allISOCtryCcy.size();
		ICFSecISOCtryCcyObj arr[] = new ICFSecISOCtryCcyObj[len];
		Iterator<ICFSecISOCtryCcyObj> valIter = allISOCtryCcy.values().iterator();
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
		ArrayList<ICFSecISOCtryCcyObj> arrayList = new ArrayList<ICFSecISOCtryCcyObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecISOCtryCcyObj> cmp = new Comparator<ICFSecISOCtryCcyObj>() {
			public int compare( ICFSecISOCtryCcyObj lhs, ICFSecISOCtryCcyObj rhs ) {
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
					CFSecISOCtryCcyPKey lhsPKey = lhs.getPKey();
					CFSecISOCtryCcyPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecISOCtryCcyObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecISOCtryCcyObj readISOCtryCcyByIdIdx( short ISOCtryId,
		short ISOCcyId )
	{
		return( readISOCtryCcyByIdIdx( ISOCtryId,
			ISOCcyId,
			false ) );
	}

	public ICFSecISOCtryCcyObj readISOCtryCcyByIdIdx( short ISOCtryId,
		short ISOCcyId, boolean forceRead )
	{
		CFSecISOCtryCcyPKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newPKey();
		pkey.setRequiredISOCtryId( ISOCtryId );
		pkey.setRequiredISOCcyId( ISOCcyId );
		ICFSecISOCtryCcyObj obj = readISOCtryCcy( pkey, forceRead );
		return( obj );
	}

	public List<ICFSecISOCtryCcyObj> readISOCtryCcyByCtryIdx( short ISOCtryId )
	{
		return( readISOCtryCcyByCtryIdx( ISOCtryId,
			false ) );
	}

	public List<ICFSecISOCtryCcyObj> readISOCtryCcyByCtryIdx( short ISOCtryId,
		boolean forceRead )
	{
		final String S_ProcName = "readISOCtryCcyByCtryIdx";
		CFSecISOCtryCcyByCtryIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newCtryIdxKey();
		key.setRequiredISOCtryId( ISOCtryId );
		Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj> dict;
		if( indexByCtryIdx == null ) {
			indexByCtryIdx = new HashMap< CFSecISOCtryCcyByCtryIdxKey,
				Map< CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj > >();
		}
		if( ( ! forceRead ) && indexByCtryIdx.containsKey( key ) ) {
			dict = indexByCtryIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj>();
			ICFSecISOCtryCcyObj obj;
			CFSecISOCtryCcyBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableISOCtryCcy().readDerivedByCtryIdx( schema.getAuthorization(),
				ISOCtryId );
			CFSecISOCtryCcyBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getISOCtryCcyTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newPKey() );
				obj.setBuff( buff );
				ICFSecISOCtryCcyObj realised = (ICFSecISOCtryCcyObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByCtryIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecISOCtryCcyObj arr[] = new ICFSecISOCtryCcyObj[len];
		Iterator<ICFSecISOCtryCcyObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecISOCtryCcyObj> arrayList = new ArrayList<ICFSecISOCtryCcyObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecISOCtryCcyObj> cmp = new Comparator<ICFSecISOCtryCcyObj>() {
			public int compare( ICFSecISOCtryCcyObj lhs, ICFSecISOCtryCcyObj rhs ) {
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
					CFSecISOCtryCcyPKey lhsPKey = lhs.getPKey();
					CFSecISOCtryCcyPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecISOCtryCcyObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFSecISOCtryCcyObj> readISOCtryCcyByCcyIdx( short ISOCcyId )
	{
		return( readISOCtryCcyByCcyIdx( ISOCcyId,
			false ) );
	}

	public List<ICFSecISOCtryCcyObj> readISOCtryCcyByCcyIdx( short ISOCcyId,
		boolean forceRead )
	{
		final String S_ProcName = "readISOCtryCcyByCcyIdx";
		CFSecISOCtryCcyByCcyIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newCcyIdxKey();
		key.setRequiredISOCcyId( ISOCcyId );
		Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj> dict;
		if( indexByCcyIdx == null ) {
			indexByCcyIdx = new HashMap< CFSecISOCtryCcyByCcyIdxKey,
				Map< CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj > >();
		}
		if( ( ! forceRead ) && indexByCcyIdx.containsKey( key ) ) {
			dict = indexByCcyIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj>();
			ICFSecISOCtryCcyObj obj;
			CFSecISOCtryCcyBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableISOCtryCcy().readDerivedByCcyIdx( schema.getAuthorization(),
				ISOCcyId );
			CFSecISOCtryCcyBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getISOCtryCcyTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newPKey() );
				obj.setBuff( buff );
				ICFSecISOCtryCcyObj realised = (ICFSecISOCtryCcyObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByCcyIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecISOCtryCcyObj arr[] = new ICFSecISOCtryCcyObj[len];
		Iterator<ICFSecISOCtryCcyObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecISOCtryCcyObj> arrayList = new ArrayList<ICFSecISOCtryCcyObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecISOCtryCcyObj> cmp = new Comparator<ICFSecISOCtryCcyObj>() {
			public int compare( ICFSecISOCtryCcyObj lhs, ICFSecISOCtryCcyObj rhs ) {
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
					CFSecISOCtryCcyPKey lhsPKey = lhs.getPKey();
					CFSecISOCtryCcyPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecISOCtryCcyObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecISOCtryCcyObj updateISOCtryCcy( ICFSecISOCtryCcyObj Obj ) {
		ICFSecISOCtryCcyObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableISOCtryCcy().updateISOCtryCcy( schema.getAuthorization(),
			Obj.getISOCtryCcyBuff() );
		obj = (ICFSecISOCtryCcyObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteISOCtryCcy( ICFSecISOCtryCcyObj Obj ) {
		ICFSecISOCtryCcyObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableISOCtryCcy().deleteISOCtryCcy( schema.getAuthorization(),
			obj.getISOCtryCcyBuff() );
		obj.forget( true );
	}

	public void deleteISOCtryCcyByIdIdx( short ISOCtryId,
		short ISOCcyId )
	{
		CFSecISOCtryCcyPKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newPKey();
		pkey.setRequiredISOCtryId( ISOCtryId );
		pkey.setRequiredISOCcyId( ISOCcyId );
		ICFSecISOCtryCcyObj obj = readISOCtryCcy( pkey );
		if( obj != null ) {
			ICFSecISOCtryCcyEditObj editObj = (ICFSecISOCtryCcyEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFSecISOCtryCcyEditObj)obj.beginEdit();
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

	public void deleteISOCtryCcyByCtryIdx( short ISOCtryId )
	{
		CFSecISOCtryCcyByCtryIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newCtryIdxKey();
		key.setRequiredISOCtryId( ISOCtryId );
		if( indexByCtryIdx == null ) {
			indexByCtryIdx = new HashMap< CFSecISOCtryCcyByCtryIdxKey,
				Map< CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj > >();
		}
		if( indexByCtryIdx.containsKey( key ) ) {
			Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj> dict = indexByCtryIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableISOCtryCcy().deleteISOCtryCcyByCtryIdx( schema.getAuthorization(),
				ISOCtryId );
			Iterator<ICFSecISOCtryCcyObj> iter = dict.values().iterator();
			ICFSecISOCtryCcyObj obj;
			List<ICFSecISOCtryCcyObj> toForget = new LinkedList<ICFSecISOCtryCcyObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByCtryIdx.remove( key );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableISOCtryCcy().deleteISOCtryCcyByCtryIdx( schema.getAuthorization(),
				ISOCtryId );
		}
	}

	public void deleteISOCtryCcyByCcyIdx( short ISOCcyId )
	{
		CFSecISOCtryCcyByCcyIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtryCcy().newCcyIdxKey();
		key.setRequiredISOCcyId( ISOCcyId );
		if( indexByCcyIdx == null ) {
			indexByCcyIdx = new HashMap< CFSecISOCtryCcyByCcyIdxKey,
				Map< CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj > >();
		}
		if( indexByCcyIdx.containsKey( key ) ) {
			Map<CFSecISOCtryCcyPKey, ICFSecISOCtryCcyObj> dict = indexByCcyIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableISOCtryCcy().deleteISOCtryCcyByCcyIdx( schema.getAuthorization(),
				ISOCcyId );
			Iterator<ICFSecISOCtryCcyObj> iter = dict.values().iterator();
			ICFSecISOCtryCcyObj obj;
			List<ICFSecISOCtryCcyObj> toForget = new LinkedList<ICFSecISOCtryCcyObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByCcyIdx.remove( key );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableISOCtryCcy().deleteISOCtryCcyByCcyIdx( schema.getAuthorization(),
				ISOCcyId );
		}
	}
}
