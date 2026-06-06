// Description: Java 11 Table Object implementation for CFBam.

/*
 *	org.msscf.msscf.CFBam
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

package org.msscf.msscf.cfbam.CFBamObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBam.*;

public class CFBamISOCtryLangTableObj
	implements ICFBamISOCtryLangTableObj
{
	protected ICFSecSchemaObj schema;
	private Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj> members;
	private Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj> allISOCtryLang;
	private Map< CFSecISOCtryLangByCtryIdxKey,
		Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj > > indexByCtryIdx;
	private Map< CFSecISOCtryLangByLangIdxKey,
		Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj > > indexByLangIdx;
	public static String TABLE_NAME = "ISOCtryLang";
	public static String TABLE_DBNAME = "iso_cntrylng";

	public CFBamISOCtryLangTableObj() {
		schema = null;
		members = new HashMap<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj>();
		allISOCtryLang = null;
		indexByCtryIdx = null;
		indexByLangIdx = null;
	}

	public CFBamISOCtryLangTableObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj>();
		allISOCtryLang = null;
		indexByCtryIdx = null;
		indexByLangIdx = null;
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
		allISOCtryLang = null;
		indexByCtryIdx = null;
		indexByLangIdx = null;
		List<ICFSecISOCtryLangObj> toForget = new LinkedList<ICFSecISOCtryLangObj>();
		ICFSecISOCtryLangObj cur = null;
		Iterator<ICFSecISOCtryLangObj> iter = members.values().iterator();
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
	 *	CFBamISOCtryLangObj.
	 */
	public ICFSecISOCtryLangObj newInstance() {
		ICFSecISOCtryLangObj inst = new CFBamISOCtryLangObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamISOCtryLangObj.
	 */
	public ICFSecISOCtryLangEditObj newEditInstance( ICFSecISOCtryLangObj orig ) {
		ICFSecISOCtryLangEditObj edit = new CFBamISOCtryLangEditObj( orig );
		return( edit );
	}

	public ICFSecISOCtryLangObj realiseISOCtryLang( ICFSecISOCtryLangObj Obj ) {
		ICFSecISOCtryLangObj obj = Obj;
		CFSecISOCtryLangPKey pkey = obj.getPKey();
		ICFSecISOCtryLangObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFSecISOCtryLangObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByCtryIdx != null ) {
				CFSecISOCtryLangByCtryIdxKey keyCtryIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newCtryIdxKey();
				keyCtryIdx.setRequiredISOCtryId( keepObj.getRequiredISOCtryId() );
				Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj > mapCtryIdx = indexByCtryIdx.get( keyCtryIdx );
				if( mapCtryIdx != null ) {
					mapCtryIdx.remove( keepObj.getPKey() );
					if( mapCtryIdx.size() <= 0 ) {
						indexByCtryIdx.remove( keyCtryIdx );
					}
				}
			}

			if( indexByLangIdx != null ) {
				CFSecISOCtryLangByLangIdxKey keyLangIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newLangIdxKey();
				keyLangIdx.setRequiredISOLangId( keepObj.getRequiredISOLangId() );
				Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj > mapLangIdx = indexByLangIdx.get( keyLangIdx );
				if( mapLangIdx != null ) {
					mapLangIdx.remove( keepObj.getPKey() );
					if( mapLangIdx.size() <= 0 ) {
						indexByLangIdx.remove( keyLangIdx );
					}
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByCtryIdx != null ) {
				CFSecISOCtryLangByCtryIdxKey keyCtryIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newCtryIdxKey();
				keyCtryIdx.setRequiredISOCtryId( keepObj.getRequiredISOCtryId() );
				Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj > mapCtryIdx = indexByCtryIdx.get( keyCtryIdx );
				if( mapCtryIdx != null ) {
					mapCtryIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLangIdx != null ) {
				CFSecISOCtryLangByLangIdxKey keyLangIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newLangIdxKey();
				keyLangIdx.setRequiredISOLangId( keepObj.getRequiredISOLangId() );
				Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj > mapLangIdx = indexByLangIdx.get( keyLangIdx );
				if( mapLangIdx != null ) {
					mapLangIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allISOCtryLang != null ) {
				allISOCtryLang.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allISOCtryLang != null ) {
				allISOCtryLang.put( keepObj.getPKey(), keepObj );
			}

			if( indexByCtryIdx != null ) {
				CFSecISOCtryLangByCtryIdxKey keyCtryIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newCtryIdxKey();
				keyCtryIdx.setRequiredISOCtryId( keepObj.getRequiredISOCtryId() );
				Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj > mapCtryIdx = indexByCtryIdx.get( keyCtryIdx );
				if( mapCtryIdx != null ) {
					mapCtryIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLangIdx != null ) {
				CFSecISOCtryLangByLangIdxKey keyLangIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newLangIdxKey();
				keyLangIdx.setRequiredISOLangId( keepObj.getRequiredISOLangId() );
				Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj > mapLangIdx = indexByLangIdx.get( keyLangIdx );
				if( mapLangIdx != null ) {
					mapLangIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetISOCtryLang( ICFSecISOCtryLangObj Obj ) {
		forgetISOCtryLang( Obj, false );
	}

	public void forgetISOCtryLang( ICFSecISOCtryLangObj Obj, boolean forgetSubObjects ) {
		ICFSecISOCtryLangObj obj = Obj;
		CFSecISOCtryLangPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFSecISOCtryLangObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByCtryIdx != null ) {
				CFSecISOCtryLangByCtryIdxKey keyCtryIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newCtryIdxKey();
				keyCtryIdx.setRequiredISOCtryId( keepObj.getRequiredISOCtryId() );
				Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj > mapCtryIdx = indexByCtryIdx.get( keyCtryIdx );
				if( mapCtryIdx != null ) {
					mapCtryIdx.remove( keepObj.getPKey() );
					if( mapCtryIdx.size() <= 0 ) {
						indexByCtryIdx.remove( keyCtryIdx );
					}
				}
			}

			if( indexByLangIdx != null ) {
				CFSecISOCtryLangByLangIdxKey keyLangIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newLangIdxKey();
				keyLangIdx.setRequiredISOLangId( keepObj.getRequiredISOLangId() );
				Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj > mapLangIdx = indexByLangIdx.get( keyLangIdx );
				if( mapLangIdx != null ) {
					mapLangIdx.remove( keepObj.getPKey() );
					if( mapLangIdx.size() <= 0 ) {
						indexByLangIdx.remove( keyLangIdx );
					}
				}
			}

			if( allISOCtryLang != null ) {
				allISOCtryLang.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetISOCtryLangByIdIdx( short ISOCtryId,
		short ISOLangId )
	{
		if( members == null ) {
			return;
		}
		CFSecISOCtryLangPKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newPKey();
		key.setRequiredISOCtryId( ISOCtryId );
		key.setRequiredISOLangId( ISOLangId );
		if( members.containsKey( key ) ) {
			ICFSecISOCtryLangObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetISOCtryLangByCtryIdx( short ISOCtryId )
	{
		if( indexByCtryIdx == null ) {
			return;
		}
		List<ICFSecISOCtryLangObj> toForget = new LinkedList<ICFSecISOCtryLangObj>();
		ICFSecISOCtryLangObj cur = null;
		CFSecISOCtryLangByCtryIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newCtryIdxKey();
		key.setRequiredISOCtryId( ISOCtryId );
		if( indexByCtryIdx.containsKey( key ) ) {
			Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj > mapCtryIdx = indexByCtryIdx.get( key );
			if( mapCtryIdx != null ) {
				Iterator<ICFSecISOCtryLangObj> iterDup = mapCtryIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByCtryIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecISOCtryLangObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecISOCtryLangObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetISOCtryLangByLangIdx( short ISOLangId )
	{
		if( indexByLangIdx == null ) {
			return;
		}
		List<ICFSecISOCtryLangObj> toForget = new LinkedList<ICFSecISOCtryLangObj>();
		ICFSecISOCtryLangObj cur = null;
		CFSecISOCtryLangByLangIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newLangIdxKey();
		key.setRequiredISOLangId( ISOLangId );
		if( indexByLangIdx.containsKey( key ) ) {
			Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj > mapLangIdx = indexByLangIdx.get( key );
			if( mapLangIdx != null ) {
				Iterator<ICFSecISOCtryLangObj> iterDup = mapLangIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByLangIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecISOCtryLangObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecISOCtryLangObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFSecISOCtryLangObj createISOCtryLang( ICFSecISOCtryLangObj Obj ) {
		ICFSecISOCtryLangObj obj = Obj;
		CFSecISOCtryLangBuff buff = obj.getISOCtryLangBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableISOCtryLang().createISOCtryLang(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFSecISOCtryLangObj readISOCtryLang( CFSecISOCtryLangPKey pkey ) {
		return( readISOCtryLang( pkey, false ) );
	}

	public ICFSecISOCtryLangObj readISOCtryLang( CFSecISOCtryLangPKey pkey, boolean forceRead ) {
		ICFSecISOCtryLangObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFSecISOCtryLangBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableISOCtryLang().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredISOCtryId(),
				pkey.getRequiredISOLangId() );
			if( readBuff != null ) {
				obj = schema.getISOCtryLangTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFSecISOCtryLangObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecISOCtryLangObj lockISOCtryLang( CFSecISOCtryLangPKey pkey ) {
		ICFSecISOCtryLangObj locked = null;
		CFSecISOCtryLangBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableISOCtryLang().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getISOCtryLangTableObj().newInstance();
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFSecISOCtryLangObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockISOCtryLang", pkey );
		}
		return( locked );
	}

	public List<ICFSecISOCtryLangObj> readAllISOCtryLang() {
		return( readAllISOCtryLang( false ) );
	}

	public List<ICFSecISOCtryLangObj> readAllISOCtryLang( boolean forceRead ) {
		final String S_ProcName = "readAllISOCtryLang";
		if( ( allISOCtryLang == null ) || forceRead ) {
			Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj> map = new HashMap<CFSecISOCtryLangPKey,ICFSecISOCtryLangObj>();
			allISOCtryLang = map;
			CFSecISOCtryLangBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableISOCtryLang().readAllDerived( schema.getAuthorization() );
			CFSecISOCtryLangBuff buff;
			ICFSecISOCtryLangObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newPKey() );
				obj.setBuff( buff );
				ICFSecISOCtryLangObj realised = (ICFSecISOCtryLangObj)obj.realise();
			}
		}
		int len = allISOCtryLang.size();
		ICFSecISOCtryLangObj arr[] = new ICFSecISOCtryLangObj[len];
		Iterator<ICFSecISOCtryLangObj> valIter = allISOCtryLang.values().iterator();
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
		ArrayList<ICFSecISOCtryLangObj> arrayList = new ArrayList<ICFSecISOCtryLangObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecISOCtryLangObj> cmp = new Comparator<ICFSecISOCtryLangObj>() {
			public int compare( ICFSecISOCtryLangObj lhs, ICFSecISOCtryLangObj rhs ) {
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
					CFSecISOCtryLangPKey lhsPKey = lhs.getPKey();
					CFSecISOCtryLangPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecISOCtryLangObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecISOCtryLangObj readISOCtryLangByIdIdx( short ISOCtryId,
		short ISOLangId )
	{
		return( readISOCtryLangByIdIdx( ISOCtryId,
			ISOLangId,
			false ) );
	}

	public ICFSecISOCtryLangObj readISOCtryLangByIdIdx( short ISOCtryId,
		short ISOLangId, boolean forceRead )
	{
		CFSecISOCtryLangPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newPKey();
		pkey.setRequiredISOCtryId( ISOCtryId );
		pkey.setRequiredISOLangId( ISOLangId );
		ICFSecISOCtryLangObj obj = readISOCtryLang( pkey, forceRead );
		return( obj );
	}

	public List<ICFSecISOCtryLangObj> readISOCtryLangByCtryIdx( short ISOCtryId )
	{
		return( readISOCtryLangByCtryIdx( ISOCtryId,
			false ) );
	}

	public List<ICFSecISOCtryLangObj> readISOCtryLangByCtryIdx( short ISOCtryId,
		boolean forceRead )
	{
		final String S_ProcName = "readISOCtryLangByCtryIdx";
		CFSecISOCtryLangByCtryIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newCtryIdxKey();
		key.setRequiredISOCtryId( ISOCtryId );
		Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj> dict;
		if( indexByCtryIdx == null ) {
			indexByCtryIdx = new HashMap< CFSecISOCtryLangByCtryIdxKey,
				Map< CFSecISOCtryLangPKey, ICFSecISOCtryLangObj > >();
		}
		if( ( ! forceRead ) && indexByCtryIdx.containsKey( key ) ) {
			dict = indexByCtryIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj>();
			ICFSecISOCtryLangObj obj;
			CFSecISOCtryLangBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableISOCtryLang().readDerivedByCtryIdx( schema.getAuthorization(),
				ISOCtryId );
			CFSecISOCtryLangBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getISOCtryLangTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newPKey() );
				obj.setBuff( buff );
				ICFSecISOCtryLangObj realised = (ICFSecISOCtryLangObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByCtryIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecISOCtryLangObj arr[] = new ICFSecISOCtryLangObj[len];
		Iterator<ICFSecISOCtryLangObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecISOCtryLangObj> arrayList = new ArrayList<ICFSecISOCtryLangObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecISOCtryLangObj> cmp = new Comparator<ICFSecISOCtryLangObj>() {
			public int compare( ICFSecISOCtryLangObj lhs, ICFSecISOCtryLangObj rhs ) {
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
					CFSecISOCtryLangPKey lhsPKey = lhs.getPKey();
					CFSecISOCtryLangPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecISOCtryLangObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFSecISOCtryLangObj> readISOCtryLangByLangIdx( short ISOLangId )
	{
		return( readISOCtryLangByLangIdx( ISOLangId,
			false ) );
	}

	public List<ICFSecISOCtryLangObj> readISOCtryLangByLangIdx( short ISOLangId,
		boolean forceRead )
	{
		final String S_ProcName = "readISOCtryLangByLangIdx";
		CFSecISOCtryLangByLangIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newLangIdxKey();
		key.setRequiredISOLangId( ISOLangId );
		Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj> dict;
		if( indexByLangIdx == null ) {
			indexByLangIdx = new HashMap< CFSecISOCtryLangByLangIdxKey,
				Map< CFSecISOCtryLangPKey, ICFSecISOCtryLangObj > >();
		}
		if( ( ! forceRead ) && indexByLangIdx.containsKey( key ) ) {
			dict = indexByLangIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj>();
			ICFSecISOCtryLangObj obj;
			CFSecISOCtryLangBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableISOCtryLang().readDerivedByLangIdx( schema.getAuthorization(),
				ISOLangId );
			CFSecISOCtryLangBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getISOCtryLangTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newPKey() );
				obj.setBuff( buff );
				ICFSecISOCtryLangObj realised = (ICFSecISOCtryLangObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByLangIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecISOCtryLangObj arr[] = new ICFSecISOCtryLangObj[len];
		Iterator<ICFSecISOCtryLangObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecISOCtryLangObj> arrayList = new ArrayList<ICFSecISOCtryLangObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecISOCtryLangObj> cmp = new Comparator<ICFSecISOCtryLangObj>() {
			public int compare( ICFSecISOCtryLangObj lhs, ICFSecISOCtryLangObj rhs ) {
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
					CFSecISOCtryLangPKey lhsPKey = lhs.getPKey();
					CFSecISOCtryLangPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecISOCtryLangObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecISOCtryLangObj updateISOCtryLang( ICFSecISOCtryLangObj Obj ) {
		ICFSecISOCtryLangObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableISOCtryLang().updateISOCtryLang( schema.getAuthorization(),
			Obj.getISOCtryLangBuff() );
		obj = (ICFSecISOCtryLangObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteISOCtryLang( ICFSecISOCtryLangObj Obj ) {
		ICFSecISOCtryLangObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableISOCtryLang().deleteISOCtryLang( schema.getAuthorization(),
			obj.getISOCtryLangBuff() );
		obj.forget( true );
	}

	public void deleteISOCtryLangByIdIdx( short ISOCtryId,
		short ISOLangId )
	{
		CFSecISOCtryLangPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newPKey();
		pkey.setRequiredISOCtryId( ISOCtryId );
		pkey.setRequiredISOLangId( ISOLangId );
		ICFSecISOCtryLangObj obj = readISOCtryLang( pkey );
		if( obj != null ) {
			ICFSecISOCtryLangEditObj editObj = (ICFSecISOCtryLangEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFSecISOCtryLangEditObj)obj.beginEdit();
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

	public void deleteISOCtryLangByCtryIdx( short ISOCtryId )
	{
		CFSecISOCtryLangByCtryIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newCtryIdxKey();
		key.setRequiredISOCtryId( ISOCtryId );
		if( indexByCtryIdx == null ) {
			indexByCtryIdx = new HashMap< CFSecISOCtryLangByCtryIdxKey,
				Map< CFSecISOCtryLangPKey, ICFSecISOCtryLangObj > >();
		}
		if( indexByCtryIdx.containsKey( key ) ) {
			Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj> dict = indexByCtryIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableISOCtryLang().deleteISOCtryLangByCtryIdx( schema.getAuthorization(),
				ISOCtryId );
			Iterator<ICFSecISOCtryLangObj> iter = dict.values().iterator();
			ICFSecISOCtryLangObj obj;
			List<ICFSecISOCtryLangObj> toForget = new LinkedList<ICFSecISOCtryLangObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableISOCtryLang().deleteISOCtryLangByCtryIdx( schema.getAuthorization(),
				ISOCtryId );
		}
	}

	public void deleteISOCtryLangByLangIdx( short ISOLangId )
	{
		CFSecISOCtryLangByLangIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCtryLang().newLangIdxKey();
		key.setRequiredISOLangId( ISOLangId );
		if( indexByLangIdx == null ) {
			indexByLangIdx = new HashMap< CFSecISOCtryLangByLangIdxKey,
				Map< CFSecISOCtryLangPKey, ICFSecISOCtryLangObj > >();
		}
		if( indexByLangIdx.containsKey( key ) ) {
			Map<CFSecISOCtryLangPKey, ICFSecISOCtryLangObj> dict = indexByLangIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableISOCtryLang().deleteISOCtryLangByLangIdx( schema.getAuthorization(),
				ISOLangId );
			Iterator<ICFSecISOCtryLangObj> iter = dict.values().iterator();
			ICFSecISOCtryLangObj obj;
			List<ICFSecISOCtryLangObj> toForget = new LinkedList<ICFSecISOCtryLangObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByLangIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableISOCtryLang().deleteISOCtryLangByLangIdx( schema.getAuthorization(),
				ISOLangId );
		}
	}
}
