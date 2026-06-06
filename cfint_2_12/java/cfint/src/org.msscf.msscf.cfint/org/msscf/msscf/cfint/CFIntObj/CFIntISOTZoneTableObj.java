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

public class CFIntISOTZoneTableObj
	implements ICFIntISOTZoneTableObj
{
	protected ICFSecSchemaObj schema;
	private Map<CFSecISOTZonePKey, ICFSecISOTZoneObj> members;
	private Map<CFSecISOTZonePKey, ICFSecISOTZoneObj> allISOTZone;
	private Map< CFSecISOTZoneByOffsetIdxKey,
		Map<CFSecISOTZonePKey, ICFSecISOTZoneObj > > indexByOffsetIdx;
	private Map< CFSecISOTZoneByUTZNameIdxKey,
		ICFSecISOTZoneObj > indexByUTZNameIdx;
	private Map< CFSecISOTZoneByIso8601IdxKey,
		Map<CFSecISOTZonePKey, ICFSecISOTZoneObj > > indexByIso8601Idx;
	public static String TABLE_NAME = "ISOTZone";
	public static String TABLE_DBNAME = "isotz";

	public CFIntISOTZoneTableObj() {
		schema = null;
		members = new HashMap<CFSecISOTZonePKey, ICFSecISOTZoneObj>();
		allISOTZone = null;
		indexByOffsetIdx = null;
		indexByUTZNameIdx = null;
		indexByIso8601Idx = null;
	}

	public CFIntISOTZoneTableObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFSecISOTZonePKey, ICFSecISOTZoneObj>();
		allISOTZone = null;
		indexByOffsetIdx = null;
		indexByUTZNameIdx = null;
		indexByIso8601Idx = null;
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
		allISOTZone = null;
		indexByOffsetIdx = null;
		indexByUTZNameIdx = null;
		indexByIso8601Idx = null;
		List<ICFSecISOTZoneObj> toForget = new LinkedList<ICFSecISOTZoneObj>();
		ICFSecISOTZoneObj cur = null;
		Iterator<ICFSecISOTZoneObj> iter = members.values().iterator();
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
	 *	CFIntISOTZoneObj.
	 */
	public ICFSecISOTZoneObj newInstance() {
		ICFSecISOTZoneObj inst = new CFIntISOTZoneObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFIntISOTZoneObj.
	 */
	public ICFSecISOTZoneEditObj newEditInstance( ICFSecISOTZoneObj orig ) {
		ICFSecISOTZoneEditObj edit = new CFIntISOTZoneEditObj( orig );
		return( edit );
	}

	public ICFSecISOTZoneObj realiseISOTZone( ICFSecISOTZoneObj Obj ) {
		ICFSecISOTZoneObj obj = Obj;
		CFSecISOTZonePKey pkey = obj.getPKey();
		ICFSecISOTZoneObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFSecISOTZoneObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByOffsetIdx != null ) {
				CFSecISOTZoneByOffsetIdxKey keyOffsetIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newOffsetIdxKey();
				keyOffsetIdx.setRequiredTZHourOffset( keepObj.getRequiredTZHourOffset() );
				keyOffsetIdx.setRequiredTZMinOffset( keepObj.getRequiredTZMinOffset() );
				Map<CFSecISOTZonePKey, ICFSecISOTZoneObj > mapOffsetIdx = indexByOffsetIdx.get( keyOffsetIdx );
				if( mapOffsetIdx != null ) {
					mapOffsetIdx.remove( keepObj.getPKey() );
					if( mapOffsetIdx.size() <= 0 ) {
						indexByOffsetIdx.remove( keyOffsetIdx );
					}
				}
			}

			if( indexByUTZNameIdx != null ) {
				CFSecISOTZoneByUTZNameIdxKey keyUTZNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newUTZNameIdxKey();
				keyUTZNameIdx.setRequiredTZName( keepObj.getRequiredTZName() );
				indexByUTZNameIdx.remove( keyUTZNameIdx );
			}

			if( indexByIso8601Idx != null ) {
				CFSecISOTZoneByIso8601IdxKey keyIso8601Idx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newIso8601IdxKey();
				keyIso8601Idx.setRequiredIso8601( keepObj.getRequiredIso8601() );
				Map<CFSecISOTZonePKey, ICFSecISOTZoneObj > mapIso8601Idx = indexByIso8601Idx.get( keyIso8601Idx );
				if( mapIso8601Idx != null ) {
					mapIso8601Idx.remove( keepObj.getPKey() );
					if( mapIso8601Idx.size() <= 0 ) {
						indexByIso8601Idx.remove( keyIso8601Idx );
					}
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByOffsetIdx != null ) {
				CFSecISOTZoneByOffsetIdxKey keyOffsetIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newOffsetIdxKey();
				keyOffsetIdx.setRequiredTZHourOffset( keepObj.getRequiredTZHourOffset() );
				keyOffsetIdx.setRequiredTZMinOffset( keepObj.getRequiredTZMinOffset() );
				Map<CFSecISOTZonePKey, ICFSecISOTZoneObj > mapOffsetIdx = indexByOffsetIdx.get( keyOffsetIdx );
				if( mapOffsetIdx != null ) {
					mapOffsetIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUTZNameIdx != null ) {
				CFSecISOTZoneByUTZNameIdxKey keyUTZNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newUTZNameIdxKey();
				keyUTZNameIdx.setRequiredTZName( keepObj.getRequiredTZName() );
				indexByUTZNameIdx.put( keyUTZNameIdx, keepObj );
			}

			if( indexByIso8601Idx != null ) {
				CFSecISOTZoneByIso8601IdxKey keyIso8601Idx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newIso8601IdxKey();
				keyIso8601Idx.setRequiredIso8601( keepObj.getRequiredIso8601() );
				Map<CFSecISOTZonePKey, ICFSecISOTZoneObj > mapIso8601Idx = indexByIso8601Idx.get( keyIso8601Idx );
				if( mapIso8601Idx != null ) {
					mapIso8601Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allISOTZone != null ) {
				allISOTZone.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allISOTZone != null ) {
				allISOTZone.put( keepObj.getPKey(), keepObj );
			}

			if( indexByOffsetIdx != null ) {
				CFSecISOTZoneByOffsetIdxKey keyOffsetIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newOffsetIdxKey();
				keyOffsetIdx.setRequiredTZHourOffset( keepObj.getRequiredTZHourOffset() );
				keyOffsetIdx.setRequiredTZMinOffset( keepObj.getRequiredTZMinOffset() );
				Map<CFSecISOTZonePKey, ICFSecISOTZoneObj > mapOffsetIdx = indexByOffsetIdx.get( keyOffsetIdx );
				if( mapOffsetIdx != null ) {
					mapOffsetIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUTZNameIdx != null ) {
				CFSecISOTZoneByUTZNameIdxKey keyUTZNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newUTZNameIdxKey();
				keyUTZNameIdx.setRequiredTZName( keepObj.getRequiredTZName() );
				indexByUTZNameIdx.put( keyUTZNameIdx, keepObj );
			}

			if( indexByIso8601Idx != null ) {
				CFSecISOTZoneByIso8601IdxKey keyIso8601Idx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newIso8601IdxKey();
				keyIso8601Idx.setRequiredIso8601( keepObj.getRequiredIso8601() );
				Map<CFSecISOTZonePKey, ICFSecISOTZoneObj > mapIso8601Idx = indexByIso8601Idx.get( keyIso8601Idx );
				if( mapIso8601Idx != null ) {
					mapIso8601Idx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetISOTZone( ICFSecISOTZoneObj Obj ) {
		forgetISOTZone( Obj, false );
	}

	public void forgetISOTZone( ICFSecISOTZoneObj Obj, boolean forgetSubObjects ) {
		ICFSecISOTZoneObj obj = Obj;
		CFSecISOTZonePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFSecISOTZoneObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByOffsetIdx != null ) {
				CFSecISOTZoneByOffsetIdxKey keyOffsetIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newOffsetIdxKey();
				keyOffsetIdx.setRequiredTZHourOffset( keepObj.getRequiredTZHourOffset() );
				keyOffsetIdx.setRequiredTZMinOffset( keepObj.getRequiredTZMinOffset() );
				Map<CFSecISOTZonePKey, ICFSecISOTZoneObj > mapOffsetIdx = indexByOffsetIdx.get( keyOffsetIdx );
				if( mapOffsetIdx != null ) {
					mapOffsetIdx.remove( keepObj.getPKey() );
					if( mapOffsetIdx.size() <= 0 ) {
						indexByOffsetIdx.remove( keyOffsetIdx );
					}
				}
			}

			if( indexByUTZNameIdx != null ) {
				CFSecISOTZoneByUTZNameIdxKey keyUTZNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newUTZNameIdxKey();
				keyUTZNameIdx.setRequiredTZName( keepObj.getRequiredTZName() );
				indexByUTZNameIdx.remove( keyUTZNameIdx );
			}

			if( indexByIso8601Idx != null ) {
				CFSecISOTZoneByIso8601IdxKey keyIso8601Idx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newIso8601IdxKey();
				keyIso8601Idx.setRequiredIso8601( keepObj.getRequiredIso8601() );
				Map<CFSecISOTZonePKey, ICFSecISOTZoneObj > mapIso8601Idx = indexByIso8601Idx.get( keyIso8601Idx );
				if( mapIso8601Idx != null ) {
					mapIso8601Idx.remove( keepObj.getPKey() );
					if( mapIso8601Idx.size() <= 0 ) {
						indexByIso8601Idx.remove( keyIso8601Idx );
					}
				}
			}

			if( allISOTZone != null ) {
				allISOTZone.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetISOTZoneByIdIdx( short ISOTZoneId )
	{
		if( members == null ) {
			return;
		}
		CFSecISOTZonePKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newPKey();
		key.setRequiredISOTZoneId( ISOTZoneId );
		if( members.containsKey( key ) ) {
			ICFSecISOTZoneObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetISOTZoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset )
	{
		if( indexByOffsetIdx == null ) {
			return;
		}
		List<ICFSecISOTZoneObj> toForget = new LinkedList<ICFSecISOTZoneObj>();
		ICFSecISOTZoneObj cur = null;
		CFSecISOTZoneByOffsetIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newOffsetIdxKey();
		key.setRequiredTZHourOffset( TZHourOffset );
		key.setRequiredTZMinOffset( TZMinOffset );
		if( indexByOffsetIdx.containsKey( key ) ) {
			Map<CFSecISOTZonePKey, ICFSecISOTZoneObj > mapOffsetIdx = indexByOffsetIdx.get( key );
			if( mapOffsetIdx != null ) {
				Iterator<ICFSecISOTZoneObj> iterDup = mapOffsetIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByOffsetIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecISOTZoneObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecISOTZoneObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetISOTZoneByUTZNameIdx( String TZName )
	{
		if( indexByUTZNameIdx == null ) {
			return;
		}
		List<ICFSecISOTZoneObj> toForget = new LinkedList<ICFSecISOTZoneObj>();
		ICFSecISOTZoneObj cur = null;
		CFSecISOTZoneByUTZNameIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newUTZNameIdxKey();
		key.setRequiredTZName( TZName );
		if( indexByUTZNameIdx.containsKey( key ) ) {
			cur = indexByUTZNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFSecISOTZoneObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetISOTZoneByIso8601Idx( String Iso8601 )
	{
		if( indexByIso8601Idx == null ) {
			return;
		}
		List<ICFSecISOTZoneObj> toForget = new LinkedList<ICFSecISOTZoneObj>();
		ICFSecISOTZoneObj cur = null;
		CFSecISOTZoneByIso8601IdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newIso8601IdxKey();
		key.setRequiredIso8601( Iso8601 );
		if( indexByIso8601Idx.containsKey( key ) ) {
			Map<CFSecISOTZonePKey, ICFSecISOTZoneObj > mapIso8601Idx = indexByIso8601Idx.get( key );
			if( mapIso8601Idx != null ) {
				Iterator<ICFSecISOTZoneObj> iterDup = mapIso8601Idx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByIso8601Idx.remove( key );
			}

		}
		else {
			Iterator<ICFSecISOTZoneObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecISOTZoneObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFSecISOTZoneObj createISOTZone( ICFSecISOTZoneObj Obj ) {
		ICFSecISOTZoneObj obj = Obj;
		CFSecISOTZoneBuff buff = obj.getISOTZoneBuff();
		((ICFIntSchema)schema.getBackingStore()).getTableISOTZone().createISOTZone(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFSecISOTZoneObj readISOTZone( CFSecISOTZonePKey pkey ) {
		return( readISOTZone( pkey, false ) );
	}

	public ICFSecISOTZoneObj readISOTZone( CFSecISOTZonePKey pkey, boolean forceRead ) {
		ICFSecISOTZoneObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFSecISOTZoneBuff readBuff = ((ICFIntSchema)schema.getBackingStore()).getTableISOTZone().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredISOTZoneId() );
			if( readBuff != null ) {
				obj = schema.getISOTZoneTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFSecISOTZoneObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecISOTZoneObj lockISOTZone( CFSecISOTZonePKey pkey ) {
		ICFSecISOTZoneObj locked = null;
		CFSecISOTZoneBuff lockBuff = ((ICFIntSchema)schema.getBackingStore()).getTableISOTZone().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getISOTZoneTableObj().newInstance();
			locked.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFSecISOTZoneObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockISOTZone", pkey );
		}
		return( locked );
	}

	public List<ICFSecISOTZoneObj> readAllISOTZone() {
		return( readAllISOTZone( false ) );
	}

	public List<ICFSecISOTZoneObj> readAllISOTZone( boolean forceRead ) {
		final String S_ProcName = "readAllISOTZone";
		if( ( allISOTZone == null ) || forceRead ) {
			Map<CFSecISOTZonePKey, ICFSecISOTZoneObj> map = new HashMap<CFSecISOTZonePKey,ICFSecISOTZoneObj>();
			allISOTZone = map;
			CFSecISOTZoneBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableISOTZone().readAllDerived( schema.getAuthorization() );
			CFSecISOTZoneBuff buff;
			ICFSecISOTZoneObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newPKey() );
				obj.setBuff( buff );
				ICFSecISOTZoneObj realised = (ICFSecISOTZoneObj)obj.realise();
			}
		}
		int len = allISOTZone.size();
		ICFSecISOTZoneObj arr[] = new ICFSecISOTZoneObj[len];
		Iterator<ICFSecISOTZoneObj> valIter = allISOTZone.values().iterator();
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
		ArrayList<ICFSecISOTZoneObj> arrayList = new ArrayList<ICFSecISOTZoneObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecISOTZoneObj> cmp = new Comparator<ICFSecISOTZoneObj>() {
			public int compare( ICFSecISOTZoneObj lhs, ICFSecISOTZoneObj rhs ) {
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
					CFSecISOTZonePKey lhsPKey = lhs.getPKey();
					CFSecISOTZonePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecISOTZoneObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecISOTZoneObj readISOTZoneByIdIdx( short ISOTZoneId )
	{
		return( readISOTZoneByIdIdx( ISOTZoneId,
			false ) );
	}

	public ICFSecISOTZoneObj readISOTZoneByIdIdx( short ISOTZoneId, boolean forceRead )
	{
		CFSecISOTZonePKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newPKey();
		pkey.setRequiredISOTZoneId( ISOTZoneId );
		ICFSecISOTZoneObj obj = readISOTZone( pkey, forceRead );
		return( obj );
	}

	public List<ICFSecISOTZoneObj> readISOTZoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset )
	{
		return( readISOTZoneByOffsetIdx( TZHourOffset,
			TZMinOffset,
			false ) );
	}

	public List<ICFSecISOTZoneObj> readISOTZoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset,
		boolean forceRead )
	{
		final String S_ProcName = "readISOTZoneByOffsetIdx";
		CFSecISOTZoneByOffsetIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newOffsetIdxKey();
		key.setRequiredTZHourOffset( TZHourOffset );
		key.setRequiredTZMinOffset( TZMinOffset );
		Map<CFSecISOTZonePKey, ICFSecISOTZoneObj> dict;
		if( indexByOffsetIdx == null ) {
			indexByOffsetIdx = new HashMap< CFSecISOTZoneByOffsetIdxKey,
				Map< CFSecISOTZonePKey, ICFSecISOTZoneObj > >();
		}
		if( ( ! forceRead ) && indexByOffsetIdx.containsKey( key ) ) {
			dict = indexByOffsetIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecISOTZonePKey, ICFSecISOTZoneObj>();
			ICFSecISOTZoneObj obj;
			CFSecISOTZoneBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableISOTZone().readDerivedByOffsetIdx( schema.getAuthorization(),
				TZHourOffset,
				TZMinOffset );
			CFSecISOTZoneBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getISOTZoneTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newPKey() );
				obj.setBuff( buff );
				ICFSecISOTZoneObj realised = (ICFSecISOTZoneObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByOffsetIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecISOTZoneObj arr[] = new ICFSecISOTZoneObj[len];
		Iterator<ICFSecISOTZoneObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecISOTZoneObj> arrayList = new ArrayList<ICFSecISOTZoneObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecISOTZoneObj> cmp = new Comparator<ICFSecISOTZoneObj>() {
			public int compare( ICFSecISOTZoneObj lhs, ICFSecISOTZoneObj rhs ) {
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
					CFSecISOTZonePKey lhsPKey = lhs.getPKey();
					CFSecISOTZonePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecISOTZoneObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecISOTZoneObj readISOTZoneByUTZNameIdx( String TZName )
	{
		return( readISOTZoneByUTZNameIdx( TZName,
			false ) );
	}

	public ICFSecISOTZoneObj readISOTZoneByUTZNameIdx( String TZName, boolean forceRead )
	{
		if( indexByUTZNameIdx == null ) {
			indexByUTZNameIdx = new HashMap< CFSecISOTZoneByUTZNameIdxKey,
				ICFSecISOTZoneObj >();
		}
		CFSecISOTZoneByUTZNameIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newUTZNameIdxKey();
		key.setRequiredTZName( TZName );
		ICFSecISOTZoneObj obj = null;
		if( ( ! forceRead ) && indexByUTZNameIdx.containsKey( key ) ) {
			obj = indexByUTZNameIdx.get( key );
		}
		else {
			CFSecISOTZoneBuff buff = ((ICFIntSchema)schema.getBackingStore()).getTableISOTZone().readDerivedByUTZNameIdx( schema.getAuthorization(),
				TZName );
			if( buff != null ) {
				obj = schema.getISOTZoneTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newPKey() );
				obj.setBuff( buff );
				obj = (ICFSecISOTZoneObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFSecISOTZoneObj> readISOTZoneByIso8601Idx( String Iso8601 )
	{
		return( readISOTZoneByIso8601Idx( Iso8601,
			false ) );
	}

	public List<ICFSecISOTZoneObj> readISOTZoneByIso8601Idx( String Iso8601,
		boolean forceRead )
	{
		final String S_ProcName = "readISOTZoneByIso8601Idx";
		CFSecISOTZoneByIso8601IdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newIso8601IdxKey();
		key.setRequiredIso8601( Iso8601 );
		Map<CFSecISOTZonePKey, ICFSecISOTZoneObj> dict;
		if( indexByIso8601Idx == null ) {
			indexByIso8601Idx = new HashMap< CFSecISOTZoneByIso8601IdxKey,
				Map< CFSecISOTZonePKey, ICFSecISOTZoneObj > >();
		}
		if( ( ! forceRead ) && indexByIso8601Idx.containsKey( key ) ) {
			dict = indexByIso8601Idx.get( key );
		}
		else {
			dict = new HashMap<CFSecISOTZonePKey, ICFSecISOTZoneObj>();
			ICFSecISOTZoneObj obj;
			CFSecISOTZoneBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableISOTZone().readDerivedByIso8601Idx( schema.getAuthorization(),
				Iso8601 );
			CFSecISOTZoneBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getISOTZoneTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newPKey() );
				obj.setBuff( buff );
				ICFSecISOTZoneObj realised = (ICFSecISOTZoneObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByIso8601Idx.put( key, dict );
		}
		int len = dict.size();
		ICFSecISOTZoneObj arr[] = new ICFSecISOTZoneObj[len];
		Iterator<ICFSecISOTZoneObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecISOTZoneObj> arrayList = new ArrayList<ICFSecISOTZoneObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecISOTZoneObj> cmp = new Comparator<ICFSecISOTZoneObj>() {
			public int compare( ICFSecISOTZoneObj lhs, ICFSecISOTZoneObj rhs ) {
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
					CFSecISOTZonePKey lhsPKey = lhs.getPKey();
					CFSecISOTZonePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecISOTZoneObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecISOTZoneObj updateISOTZone( ICFSecISOTZoneObj Obj ) {
		ICFSecISOTZoneObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableISOTZone().updateISOTZone( schema.getAuthorization(),
			Obj.getISOTZoneBuff() );
		obj = (ICFSecISOTZoneObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteISOTZone( ICFSecISOTZoneObj Obj ) {
		ICFSecISOTZoneObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableISOTZone().deleteISOTZone( schema.getAuthorization(),
			obj.getISOTZoneBuff() );
		obj.forget( true );
	}

	public void deleteISOTZoneByIdIdx( short ISOTZoneId )
	{
		CFSecISOTZonePKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newPKey();
		pkey.setRequiredISOTZoneId( ISOTZoneId );
		ICFSecISOTZoneObj obj = readISOTZone( pkey );
		if( obj != null ) {
			ICFSecISOTZoneEditObj editObj = (ICFSecISOTZoneEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFSecISOTZoneEditObj)obj.beginEdit();
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

	public void deleteISOTZoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset )
	{
		CFSecISOTZoneByOffsetIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newOffsetIdxKey();
		key.setRequiredTZHourOffset( TZHourOffset );
		key.setRequiredTZMinOffset( TZMinOffset );
		if( indexByOffsetIdx == null ) {
			indexByOffsetIdx = new HashMap< CFSecISOTZoneByOffsetIdxKey,
				Map< CFSecISOTZonePKey, ICFSecISOTZoneObj > >();
		}
		if( indexByOffsetIdx.containsKey( key ) ) {
			Map<CFSecISOTZonePKey, ICFSecISOTZoneObj> dict = indexByOffsetIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableISOTZone().deleteISOTZoneByOffsetIdx( schema.getAuthorization(),
				TZHourOffset,
				TZMinOffset );
			Iterator<ICFSecISOTZoneObj> iter = dict.values().iterator();
			ICFSecISOTZoneObj obj;
			List<ICFSecISOTZoneObj> toForget = new LinkedList<ICFSecISOTZoneObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByOffsetIdx.remove( key );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableISOTZone().deleteISOTZoneByOffsetIdx( schema.getAuthorization(),
				TZHourOffset,
				TZMinOffset );
		}
	}

	public void deleteISOTZoneByUTZNameIdx( String TZName )
	{
		if( indexByUTZNameIdx == null ) {
			indexByUTZNameIdx = new HashMap< CFSecISOTZoneByUTZNameIdxKey,
				ICFSecISOTZoneObj >();
		}
		CFSecISOTZoneByUTZNameIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newUTZNameIdxKey();
		key.setRequiredTZName( TZName );
		ICFSecISOTZoneObj obj = null;
		if( indexByUTZNameIdx.containsKey( key ) ) {
			obj = indexByUTZNameIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableISOTZone().deleteISOTZoneByUTZNameIdx( schema.getAuthorization(),
				TZName );
			obj.forget( true );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableISOTZone().deleteISOTZoneByUTZNameIdx( schema.getAuthorization(),
				TZName );
		}
	}

	public void deleteISOTZoneByIso8601Idx( String Iso8601 )
	{
		CFSecISOTZoneByIso8601IdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newIso8601IdxKey();
		key.setRequiredIso8601( Iso8601 );
		if( indexByIso8601Idx == null ) {
			indexByIso8601Idx = new HashMap< CFSecISOTZoneByIso8601IdxKey,
				Map< CFSecISOTZonePKey, ICFSecISOTZoneObj > >();
		}
		if( indexByIso8601Idx.containsKey( key ) ) {
			Map<CFSecISOTZonePKey, ICFSecISOTZoneObj> dict = indexByIso8601Idx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableISOTZone().deleteISOTZoneByIso8601Idx( schema.getAuthorization(),
				Iso8601 );
			Iterator<ICFSecISOTZoneObj> iter = dict.values().iterator();
			ICFSecISOTZoneObj obj;
			List<ICFSecISOTZoneObj> toForget = new LinkedList<ICFSecISOTZoneObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByIso8601Idx.remove( key );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableISOTZone().deleteISOTZoneByIso8601Idx( schema.getAuthorization(),
				Iso8601 );
		}
	}
}
