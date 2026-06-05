// Description: Java 11 Table Object implementation for CFInt.

/*
 *	org.msscf.msscf.CFInt
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
 *	
 *	MSS Code Factory is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with MSS Code Factory.  If not, see https://www.gnu.org/licenses/.
 *	
 *	Donations to support MSS Code Factory can be made at
 *	https://www.paypal.com/paypalme2/MarkSobkow
 *	
 *	Contact Mark Stephen Sobkow at msobkow@sasktel.net for commercial licensing.
 *
 *	Manufactured by MSS Code Factory 2.11
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

public class CFIntISOLangTableObj
	implements ICFIntISOLangTableObj
{
	protected ICFSecSchemaObj schema;
	private Map<CFSecISOLangPKey, ICFSecISOLangObj> members;
	private Map<CFSecISOLangPKey, ICFSecISOLangObj> allISOLang;
	private Map< CFSecISOLangByCode3IdxKey,
		ICFSecISOLangObj > indexByCode3Idx;
	private Map< CFSecISOLangByCode2IdxKey,
		Map<CFSecISOLangPKey, ICFSecISOLangObj > > indexByCode2Idx;
	public static String TABLE_NAME = "ISOLang";
	public static String TABLE_DBNAME = "iso_lang";

	public CFIntISOLangTableObj() {
		schema = null;
		members = new HashMap<CFSecISOLangPKey, ICFSecISOLangObj>();
		allISOLang = null;
		indexByCode3Idx = null;
		indexByCode2Idx = null;
	}

	public CFIntISOLangTableObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFSecISOLangPKey, ICFSecISOLangObj>();
		allISOLang = null;
		indexByCode3Idx = null;
		indexByCode2Idx = null;
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
		allISOLang = null;
		indexByCode3Idx = null;
		indexByCode2Idx = null;
		List<ICFSecISOLangObj> toForget = new LinkedList<ICFSecISOLangObj>();
		ICFSecISOLangObj cur = null;
		Iterator<ICFSecISOLangObj> iter = members.values().iterator();
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
	 *	CFIntISOLangObj.
	 */
	public ICFSecISOLangObj newInstance() {
		ICFSecISOLangObj inst = new CFIntISOLangObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFIntISOLangObj.
	 */
	public ICFSecISOLangEditObj newEditInstance( ICFSecISOLangObj orig ) {
		ICFSecISOLangEditObj edit = new CFIntISOLangEditObj( orig );
		return( edit );
	}

	public ICFSecISOLangObj realiseISOLang( ICFSecISOLangObj Obj ) {
		ICFSecISOLangObj obj = Obj;
		CFSecISOLangPKey pkey = obj.getPKey();
		ICFSecISOLangObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFSecISOLangObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByCode3Idx != null ) {
				CFSecISOLangByCode3IdxKey keyCode3Idx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newCode3IdxKey();
				keyCode3Idx.setRequiredISO6392Code( keepObj.getRequiredISO6392Code() );
				indexByCode3Idx.remove( keyCode3Idx );
			}

			if( indexByCode2Idx != null ) {
				CFSecISOLangByCode2IdxKey keyCode2Idx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newCode2IdxKey();
				keyCode2Idx.setOptionalISO6391Code( keepObj.getOptionalISO6391Code() );
				Map<CFSecISOLangPKey, ICFSecISOLangObj > mapCode2Idx = indexByCode2Idx.get( keyCode2Idx );
				if( mapCode2Idx != null ) {
					mapCode2Idx.remove( keepObj.getPKey() );
					if( mapCode2Idx.size() <= 0 ) {
						indexByCode2Idx.remove( keyCode2Idx );
					}
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByCode3Idx != null ) {
				CFSecISOLangByCode3IdxKey keyCode3Idx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newCode3IdxKey();
				keyCode3Idx.setRequiredISO6392Code( keepObj.getRequiredISO6392Code() );
				indexByCode3Idx.put( keyCode3Idx, keepObj );
			}

			if( indexByCode2Idx != null ) {
				CFSecISOLangByCode2IdxKey keyCode2Idx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newCode2IdxKey();
				keyCode2Idx.setOptionalISO6391Code( keepObj.getOptionalISO6391Code() );
				Map<CFSecISOLangPKey, ICFSecISOLangObj > mapCode2Idx = indexByCode2Idx.get( keyCode2Idx );
				if( mapCode2Idx != null ) {
					mapCode2Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allISOLang != null ) {
				allISOLang.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allISOLang != null ) {
				allISOLang.put( keepObj.getPKey(), keepObj );
			}

			if( indexByCode3Idx != null ) {
				CFSecISOLangByCode3IdxKey keyCode3Idx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newCode3IdxKey();
				keyCode3Idx.setRequiredISO6392Code( keepObj.getRequiredISO6392Code() );
				indexByCode3Idx.put( keyCode3Idx, keepObj );
			}

			if( indexByCode2Idx != null ) {
				CFSecISOLangByCode2IdxKey keyCode2Idx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newCode2IdxKey();
				keyCode2Idx.setOptionalISO6391Code( keepObj.getOptionalISO6391Code() );
				Map<CFSecISOLangPKey, ICFSecISOLangObj > mapCode2Idx = indexByCode2Idx.get( keyCode2Idx );
				if( mapCode2Idx != null ) {
					mapCode2Idx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetISOLang( ICFSecISOLangObj Obj ) {
		forgetISOLang( Obj, false );
	}

	public void forgetISOLang( ICFSecISOLangObj Obj, boolean forgetSubObjects ) {
		ICFSecISOLangObj obj = Obj;
		CFSecISOLangPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFSecISOLangObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByCode3Idx != null ) {
				CFSecISOLangByCode3IdxKey keyCode3Idx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newCode3IdxKey();
				keyCode3Idx.setRequiredISO6392Code( keepObj.getRequiredISO6392Code() );
				indexByCode3Idx.remove( keyCode3Idx );
			}

			if( indexByCode2Idx != null ) {
				CFSecISOLangByCode2IdxKey keyCode2Idx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newCode2IdxKey();
				keyCode2Idx.setOptionalISO6391Code( keepObj.getOptionalISO6391Code() );
				Map<CFSecISOLangPKey, ICFSecISOLangObj > mapCode2Idx = indexByCode2Idx.get( keyCode2Idx );
				if( mapCode2Idx != null ) {
					mapCode2Idx.remove( keepObj.getPKey() );
					if( mapCode2Idx.size() <= 0 ) {
						indexByCode2Idx.remove( keyCode2Idx );
					}
				}
			}

			if( allISOLang != null ) {
				allISOLang.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFSecSchemaObj)schema).getISOCtryLangTableObj().forgetISOCtryLangByLangIdx( keepObj.getRequiredISOLangId() );
			}
		}
	}

	public void forgetISOLangByIdIdx( short ISOLangId )
	{
		if( members == null ) {
			return;
		}
		CFSecISOLangPKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newPKey();
		key.setRequiredISOLangId( ISOLangId );
		if( members.containsKey( key ) ) {
			ICFSecISOLangObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetISOLangByCode3Idx( String ISO6392Code )
	{
		if( indexByCode3Idx == null ) {
			return;
		}
		List<ICFSecISOLangObj> toForget = new LinkedList<ICFSecISOLangObj>();
		ICFSecISOLangObj cur = null;
		CFSecISOLangByCode3IdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newCode3IdxKey();
		key.setRequiredISO6392Code( ISO6392Code );
		if( indexByCode3Idx.containsKey( key ) ) {
			cur = indexByCode3Idx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFSecISOLangObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetISOLangByCode2Idx( String ISO6391Code )
	{
		if( indexByCode2Idx == null ) {
			return;
		}
		List<ICFSecISOLangObj> toForget = new LinkedList<ICFSecISOLangObj>();
		ICFSecISOLangObj cur = null;
		CFSecISOLangByCode2IdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newCode2IdxKey();
		key.setOptionalISO6391Code( ISO6391Code );
		if( indexByCode2Idx.containsKey( key ) ) {
			Map<CFSecISOLangPKey, ICFSecISOLangObj > mapCode2Idx = indexByCode2Idx.get( key );
			if( mapCode2Idx != null ) {
				Iterator<ICFSecISOLangObj> iterDup = mapCode2Idx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByCode2Idx.remove( key );
			}

		}
		else {
			Iterator<ICFSecISOLangObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecISOLangObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFSecISOLangObj createISOLang( ICFSecISOLangObj Obj ) {
		ICFSecISOLangObj obj = Obj;
		CFSecISOLangBuff buff = obj.getISOLangBuff();
		((ICFIntSchema)schema.getBackingStore()).getTableISOLang().createISOLang(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFSecISOLangObj readISOLang( CFSecISOLangPKey pkey ) {
		return( readISOLang( pkey, false ) );
	}

	public ICFSecISOLangObj readISOLang( CFSecISOLangPKey pkey, boolean forceRead ) {
		ICFSecISOLangObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFSecISOLangBuff readBuff = ((ICFIntSchema)schema.getBackingStore()).getTableISOLang().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredISOLangId() );
			if( readBuff != null ) {
				obj = schema.getISOLangTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFSecISOLangObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecISOLangObj lockISOLang( CFSecISOLangPKey pkey ) {
		ICFSecISOLangObj locked = null;
		CFSecISOLangBuff lockBuff = ((ICFIntSchema)schema.getBackingStore()).getTableISOLang().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getISOLangTableObj().newInstance();
			locked.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFSecISOLangObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockISOLang", pkey );
		}
		return( locked );
	}

	public List<ICFSecISOLangObj> readAllISOLang() {
		return( readAllISOLang( false ) );
	}

	public List<ICFSecISOLangObj> readAllISOLang( boolean forceRead ) {
		final String S_ProcName = "readAllISOLang";
		if( ( allISOLang == null ) || forceRead ) {
			Map<CFSecISOLangPKey, ICFSecISOLangObj> map = new HashMap<CFSecISOLangPKey,ICFSecISOLangObj>();
			allISOLang = map;
			CFSecISOLangBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableISOLang().readAllDerived( schema.getAuthorization() );
			CFSecISOLangBuff buff;
			ICFSecISOLangObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newPKey() );
				obj.setBuff( buff );
				ICFSecISOLangObj realised = (ICFSecISOLangObj)obj.realise();
			}
		}
		int len = allISOLang.size();
		ICFSecISOLangObj arr[] = new ICFSecISOLangObj[len];
		Iterator<ICFSecISOLangObj> valIter = allISOLang.values().iterator();
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
		ArrayList<ICFSecISOLangObj> arrayList = new ArrayList<ICFSecISOLangObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecISOLangObj> cmp = new Comparator<ICFSecISOLangObj>() {
			public int compare( ICFSecISOLangObj lhs, ICFSecISOLangObj rhs ) {
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
					CFSecISOLangPKey lhsPKey = lhs.getPKey();
					CFSecISOLangPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecISOLangObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecISOLangObj readISOLangByIdIdx( short ISOLangId )
	{
		return( readISOLangByIdIdx( ISOLangId,
			false ) );
	}

	public ICFSecISOLangObj readISOLangByIdIdx( short ISOLangId, boolean forceRead )
	{
		CFSecISOLangPKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newPKey();
		pkey.setRequiredISOLangId( ISOLangId );
		ICFSecISOLangObj obj = readISOLang( pkey, forceRead );
		return( obj );
	}

	public ICFSecISOLangObj readISOLangByCode3Idx( String ISO6392Code )
	{
		return( readISOLangByCode3Idx( ISO6392Code,
			false ) );
	}

	public ICFSecISOLangObj readISOLangByCode3Idx( String ISO6392Code, boolean forceRead )
	{
		if( indexByCode3Idx == null ) {
			indexByCode3Idx = new HashMap< CFSecISOLangByCode3IdxKey,
				ICFSecISOLangObj >();
		}
		CFSecISOLangByCode3IdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newCode3IdxKey();
		key.setRequiredISO6392Code( ISO6392Code );
		ICFSecISOLangObj obj = null;
		if( ( ! forceRead ) && indexByCode3Idx.containsKey( key ) ) {
			obj = indexByCode3Idx.get( key );
		}
		else {
			CFSecISOLangBuff buff = ((ICFIntSchema)schema.getBackingStore()).getTableISOLang().readDerivedByCode3Idx( schema.getAuthorization(),
				ISO6392Code );
			if( buff != null ) {
				obj = schema.getISOLangTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newPKey() );
				obj.setBuff( buff );
				obj = (ICFSecISOLangObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFSecISOLangObj> readISOLangByCode2Idx( String ISO6391Code )
	{
		return( readISOLangByCode2Idx( ISO6391Code,
			false ) );
	}

	public List<ICFSecISOLangObj> readISOLangByCode2Idx( String ISO6391Code,
		boolean forceRead )
	{
		final String S_ProcName = "readISOLangByCode2Idx";
		CFSecISOLangByCode2IdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newCode2IdxKey();
		key.setOptionalISO6391Code( ISO6391Code );
		Map<CFSecISOLangPKey, ICFSecISOLangObj> dict;
		if( indexByCode2Idx == null ) {
			indexByCode2Idx = new HashMap< CFSecISOLangByCode2IdxKey,
				Map< CFSecISOLangPKey, ICFSecISOLangObj > >();
		}
		if( ( ! forceRead ) && indexByCode2Idx.containsKey( key ) ) {
			dict = indexByCode2Idx.get( key );
		}
		else {
			dict = new HashMap<CFSecISOLangPKey, ICFSecISOLangObj>();
			ICFSecISOLangObj obj;
			CFSecISOLangBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableISOLang().readDerivedByCode2Idx( schema.getAuthorization(),
				ISO6391Code );
			CFSecISOLangBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getISOLangTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newPKey() );
				obj.setBuff( buff );
				ICFSecISOLangObj realised = (ICFSecISOLangObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByCode2Idx.put( key, dict );
		}
		int len = dict.size();
		ICFSecISOLangObj arr[] = new ICFSecISOLangObj[len];
		Iterator<ICFSecISOLangObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecISOLangObj> arrayList = new ArrayList<ICFSecISOLangObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecISOLangObj> cmp = new Comparator<ICFSecISOLangObj>() {
			public int compare( ICFSecISOLangObj lhs, ICFSecISOLangObj rhs ) {
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
					CFSecISOLangPKey lhsPKey = lhs.getPKey();
					CFSecISOLangPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecISOLangObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecISOLangObj updateISOLang( ICFSecISOLangObj Obj ) {
		ICFSecISOLangObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableISOLang().updateISOLang( schema.getAuthorization(),
			Obj.getISOLangBuff() );
		obj = (ICFSecISOLangObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteISOLang( ICFSecISOLangObj Obj ) {
		ICFSecISOLangObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableISOLang().deleteISOLang( schema.getAuthorization(),
			obj.getISOLangBuff() );
		obj.forget( true );
	}

	public void deleteISOLangByIdIdx( short ISOLangId )
	{
		CFSecISOLangPKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newPKey();
		pkey.setRequiredISOLangId( ISOLangId );
		ICFSecISOLangObj obj = readISOLang( pkey );
		if( obj != null ) {
			ICFSecISOLangEditObj editObj = (ICFSecISOLangEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFSecISOLangEditObj)obj.beginEdit();
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

	public void deleteISOLangByCode3Idx( String ISO6392Code )
	{
		if( indexByCode3Idx == null ) {
			indexByCode3Idx = new HashMap< CFSecISOLangByCode3IdxKey,
				ICFSecISOLangObj >();
		}
		CFSecISOLangByCode3IdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newCode3IdxKey();
		key.setRequiredISO6392Code( ISO6392Code );
		ICFSecISOLangObj obj = null;
		if( indexByCode3Idx.containsKey( key ) ) {
			obj = indexByCode3Idx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableISOLang().deleteISOLangByCode3Idx( schema.getAuthorization(),
				ISO6392Code );
			obj.forget( true );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableISOLang().deleteISOLangByCode3Idx( schema.getAuthorization(),
				ISO6392Code );
		}
	}

	public void deleteISOLangByCode2Idx( String ISO6391Code )
	{
		CFSecISOLangByCode2IdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOLang().newCode2IdxKey();
		key.setOptionalISO6391Code( ISO6391Code );
		if( indexByCode2Idx == null ) {
			indexByCode2Idx = new HashMap< CFSecISOLangByCode2IdxKey,
				Map< CFSecISOLangPKey, ICFSecISOLangObj > >();
		}
		if( indexByCode2Idx.containsKey( key ) ) {
			Map<CFSecISOLangPKey, ICFSecISOLangObj> dict = indexByCode2Idx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableISOLang().deleteISOLangByCode2Idx( schema.getAuthorization(),
				ISO6391Code );
			Iterator<ICFSecISOLangObj> iter = dict.values().iterator();
			ICFSecISOLangObj obj;
			List<ICFSecISOLangObj> toForget = new LinkedList<ICFSecISOLangObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByCode2Idx.remove( key );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableISOLang().deleteISOLangByCode2Idx( schema.getAuthorization(),
				ISO6391Code );
		}
	}
}
