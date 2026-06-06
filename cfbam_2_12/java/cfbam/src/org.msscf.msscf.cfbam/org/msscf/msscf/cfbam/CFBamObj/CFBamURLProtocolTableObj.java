// Description: Java 11 Table Object implementation for CFBam.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamURLProtocolTableObj
	implements ICFBamURLProtocolTableObj
{
	protected ICFIntSchemaObj schema;
	private Map<CFIntURLProtocolPKey, ICFIntURLProtocolObj> members;
	private Map<CFIntURLProtocolPKey, ICFIntURLProtocolObj> allURLProtocol;
	private Map< CFIntURLProtocolByUNameIdxKey,
		ICFIntURLProtocolObj > indexByUNameIdx;
	private Map< CFIntURLProtocolByIsSecureIdxKey,
		Map<CFIntURLProtocolPKey, ICFIntURLProtocolObj > > indexByIsSecureIdx;
	public static String TABLE_NAME = "URLProtocol";
	public static String TABLE_DBNAME = "urlproto";

	public CFBamURLProtocolTableObj() {
		schema = null;
		members = new HashMap<CFIntURLProtocolPKey, ICFIntURLProtocolObj>();
		allURLProtocol = null;
		indexByUNameIdx = null;
		indexByIsSecureIdx = null;
	}

	public CFBamURLProtocolTableObj( ICFIntSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFIntURLProtocolPKey, ICFIntURLProtocolObj>();
		allURLProtocol = null;
		indexByUNameIdx = null;
		indexByIsSecureIdx = null;
	}

	public ICFIntSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFIntSchemaObj value ) {
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
		allURLProtocol = null;
		indexByUNameIdx = null;
		indexByIsSecureIdx = null;
		List<ICFIntURLProtocolObj> toForget = new LinkedList<ICFIntURLProtocolObj>();
		ICFIntURLProtocolObj cur = null;
		Iterator<ICFIntURLProtocolObj> iter = members.values().iterator();
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
	 *	CFBamURLProtocolObj.
	 */
	public ICFIntURLProtocolObj newInstance() {
		ICFIntURLProtocolObj inst = new CFBamURLProtocolObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamURLProtocolObj.
	 */
	public ICFIntURLProtocolEditObj newEditInstance( ICFIntURLProtocolObj orig ) {
		ICFIntURLProtocolEditObj edit = new CFBamURLProtocolEditObj( orig );
		return( edit );
	}

	public ICFIntURLProtocolObj realiseURLProtocol( ICFIntURLProtocolObj Obj ) {
		ICFIntURLProtocolObj obj = Obj;
		CFIntURLProtocolPKey pkey = obj.getPKey();
		ICFIntURLProtocolObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFIntURLProtocolObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				CFIntURLProtocolByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByIsSecureIdx != null ) {
				CFIntURLProtocolByIsSecureIdxKey keyIsSecureIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newIsSecureIdxKey();
				keyIsSecureIdx.setRequiredIsSecure( keepObj.getRequiredIsSecure() );
				Map<CFIntURLProtocolPKey, ICFIntURLProtocolObj > mapIsSecureIdx = indexByIsSecureIdx.get( keyIsSecureIdx );
				if( mapIsSecureIdx != null ) {
					mapIsSecureIdx.remove( keepObj.getPKey() );
					if( mapIsSecureIdx.size() <= 0 ) {
						indexByIsSecureIdx.remove( keyIsSecureIdx );
					}
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				CFIntURLProtocolByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByIsSecureIdx != null ) {
				CFIntURLProtocolByIsSecureIdxKey keyIsSecureIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newIsSecureIdxKey();
				keyIsSecureIdx.setRequiredIsSecure( keepObj.getRequiredIsSecure() );
				Map<CFIntURLProtocolPKey, ICFIntURLProtocolObj > mapIsSecureIdx = indexByIsSecureIdx.get( keyIsSecureIdx );
				if( mapIsSecureIdx != null ) {
					mapIsSecureIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allURLProtocol != null ) {
				allURLProtocol.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allURLProtocol != null ) {
				allURLProtocol.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				CFIntURLProtocolByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByIsSecureIdx != null ) {
				CFIntURLProtocolByIsSecureIdxKey keyIsSecureIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newIsSecureIdxKey();
				keyIsSecureIdx.setRequiredIsSecure( keepObj.getRequiredIsSecure() );
				Map<CFIntURLProtocolPKey, ICFIntURLProtocolObj > mapIsSecureIdx = indexByIsSecureIdx.get( keyIsSecureIdx );
				if( mapIsSecureIdx != null ) {
					mapIsSecureIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetURLProtocol( ICFIntURLProtocolObj Obj ) {
		forgetURLProtocol( Obj, false );
	}

	public void forgetURLProtocol( ICFIntURLProtocolObj Obj, boolean forgetSubObjects ) {
		ICFIntURLProtocolObj obj = Obj;
		CFIntURLProtocolPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFIntURLProtocolObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUNameIdx != null ) {
				CFIntURLProtocolByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByIsSecureIdx != null ) {
				CFIntURLProtocolByIsSecureIdxKey keyIsSecureIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newIsSecureIdxKey();
				keyIsSecureIdx.setRequiredIsSecure( keepObj.getRequiredIsSecure() );
				Map<CFIntURLProtocolPKey, ICFIntURLProtocolObj > mapIsSecureIdx = indexByIsSecureIdx.get( keyIsSecureIdx );
				if( mapIsSecureIdx != null ) {
					mapIsSecureIdx.remove( keepObj.getPKey() );
					if( mapIsSecureIdx.size() <= 0 ) {
						indexByIsSecureIdx.remove( keyIsSecureIdx );
					}
				}
			}

			if( allURLProtocol != null ) {
				allURLProtocol.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetURLProtocolByIdIdx( int URLProtocolId )
	{
		if( members == null ) {
			return;
		}
		CFIntURLProtocolPKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newPKey();
		key.setRequiredURLProtocolId( URLProtocolId );
		if( members.containsKey( key ) ) {
			ICFIntURLProtocolObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetURLProtocolByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFIntURLProtocolObj> toForget = new LinkedList<ICFIntURLProtocolObj>();
		ICFIntURLProtocolObj cur = null;
		CFIntURLProtocolByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newUNameIdxKey();
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFIntURLProtocolObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetURLProtocolByIsSecureIdx( boolean IsSecure )
	{
		if( indexByIsSecureIdx == null ) {
			return;
		}
		List<ICFIntURLProtocolObj> toForget = new LinkedList<ICFIntURLProtocolObj>();
		ICFIntURLProtocolObj cur = null;
		CFIntURLProtocolByIsSecureIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newIsSecureIdxKey();
		key.setRequiredIsSecure( IsSecure );
		if( indexByIsSecureIdx.containsKey( key ) ) {
			Map<CFIntURLProtocolPKey, ICFIntURLProtocolObj > mapIsSecureIdx = indexByIsSecureIdx.get( key );
			if( mapIsSecureIdx != null ) {
				Iterator<ICFIntURLProtocolObj> iterDup = mapIsSecureIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByIsSecureIdx.remove( key );
			}

		}
		else {
			Iterator<ICFIntURLProtocolObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFIntURLProtocolObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFIntURLProtocolObj createURLProtocol( ICFIntURLProtocolObj Obj ) {
		ICFIntURLProtocolObj obj = Obj;
		CFIntURLProtocolBuff buff = obj.getURLProtocolBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableURLProtocol().createURLProtocol(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFIntURLProtocolObj readURLProtocol( CFIntURLProtocolPKey pkey ) {
		return( readURLProtocol( pkey, false ) );
	}

	public ICFIntURLProtocolObj readURLProtocol( CFIntURLProtocolPKey pkey, boolean forceRead ) {
		ICFIntURLProtocolObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFIntURLProtocolBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableURLProtocol().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredURLProtocolId() );
			if( readBuff != null ) {
				obj = schema.getURLProtocolTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFIntURLProtocolObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFIntURLProtocolObj lockURLProtocol( CFIntURLProtocolPKey pkey ) {
		ICFIntURLProtocolObj locked = null;
		CFIntURLProtocolBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableURLProtocol().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getURLProtocolTableObj().newInstance();
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFIntURLProtocolObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockURLProtocol", pkey );
		}
		return( locked );
	}

	public List<ICFIntURLProtocolObj> readAllURLProtocol() {
		return( readAllURLProtocol( false ) );
	}

	public List<ICFIntURLProtocolObj> readAllURLProtocol( boolean forceRead ) {
		final String S_ProcName = "readAllURLProtocol";
		if( ( allURLProtocol == null ) || forceRead ) {
			Map<CFIntURLProtocolPKey, ICFIntURLProtocolObj> map = new HashMap<CFIntURLProtocolPKey,ICFIntURLProtocolObj>();
			allURLProtocol = map;
			CFIntURLProtocolBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableURLProtocol().readAllDerived( schema.getAuthorization() );
			CFIntURLProtocolBuff buff;
			ICFIntURLProtocolObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newPKey() );
				obj.setBuff( buff );
				ICFIntURLProtocolObj realised = (ICFIntURLProtocolObj)obj.realise();
			}
		}
		int len = allURLProtocol.size();
		ICFIntURLProtocolObj arr[] = new ICFIntURLProtocolObj[len];
		Iterator<ICFIntURLProtocolObj> valIter = allURLProtocol.values().iterator();
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
		ArrayList<ICFIntURLProtocolObj> arrayList = new ArrayList<ICFIntURLProtocolObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFIntURLProtocolObj> cmp = new Comparator<ICFIntURLProtocolObj>() {
			public int compare( ICFIntURLProtocolObj lhs, ICFIntURLProtocolObj rhs ) {
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
					CFIntURLProtocolPKey lhsPKey = lhs.getPKey();
					CFIntURLProtocolPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFIntURLProtocolObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFIntURLProtocolObj readURLProtocolByIdIdx( int URLProtocolId )
	{
		return( readURLProtocolByIdIdx( URLProtocolId,
			false ) );
	}

	public ICFIntURLProtocolObj readURLProtocolByIdIdx( int URLProtocolId, boolean forceRead )
	{
		CFIntURLProtocolPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newPKey();
		pkey.setRequiredURLProtocolId( URLProtocolId );
		ICFIntURLProtocolObj obj = readURLProtocol( pkey, forceRead );
		return( obj );
	}

	public ICFIntURLProtocolObj readURLProtocolByUNameIdx( String Name )
	{
		return( readURLProtocolByUNameIdx( Name,
			false ) );
	}

	public ICFIntURLProtocolObj readURLProtocolByUNameIdx( String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFIntURLProtocolByUNameIdxKey,
				ICFIntURLProtocolObj >();
		}
		CFIntURLProtocolByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newUNameIdxKey();
		key.setRequiredName( Name );
		ICFIntURLProtocolObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFIntURLProtocolBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableURLProtocol().readDerivedByUNameIdx( schema.getAuthorization(),
				Name );
			if( buff != null ) {
				obj = schema.getURLProtocolTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newPKey() );
				obj.setBuff( buff );
				obj = (ICFIntURLProtocolObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFIntURLProtocolObj> readURLProtocolByIsSecureIdx( boolean IsSecure )
	{
		return( readURLProtocolByIsSecureIdx( IsSecure,
			false ) );
	}

	public List<ICFIntURLProtocolObj> readURLProtocolByIsSecureIdx( boolean IsSecure,
		boolean forceRead )
	{
		final String S_ProcName = "readURLProtocolByIsSecureIdx";
		CFIntURLProtocolByIsSecureIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newIsSecureIdxKey();
		key.setRequiredIsSecure( IsSecure );
		Map<CFIntURLProtocolPKey, ICFIntURLProtocolObj> dict;
		if( indexByIsSecureIdx == null ) {
			indexByIsSecureIdx = new HashMap< CFIntURLProtocolByIsSecureIdxKey,
				Map< CFIntURLProtocolPKey, ICFIntURLProtocolObj > >();
		}
		if( ( ! forceRead ) && indexByIsSecureIdx.containsKey( key ) ) {
			dict = indexByIsSecureIdx.get( key );
		}
		else {
			dict = new HashMap<CFIntURLProtocolPKey, ICFIntURLProtocolObj>();
			ICFIntURLProtocolObj obj;
			CFIntURLProtocolBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableURLProtocol().readDerivedByIsSecureIdx( schema.getAuthorization(),
				IsSecure );
			CFIntURLProtocolBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getURLProtocolTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newPKey() );
				obj.setBuff( buff );
				ICFIntURLProtocolObj realised = (ICFIntURLProtocolObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByIsSecureIdx.put( key, dict );
		}
		int len = dict.size();
		ICFIntURLProtocolObj arr[] = new ICFIntURLProtocolObj[len];
		Iterator<ICFIntURLProtocolObj> valIter = dict.values().iterator();
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
		ArrayList<ICFIntURLProtocolObj> arrayList = new ArrayList<ICFIntURLProtocolObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFIntURLProtocolObj> cmp = new Comparator<ICFIntURLProtocolObj>() {
			public int compare( ICFIntURLProtocolObj lhs, ICFIntURLProtocolObj rhs ) {
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
					CFIntURLProtocolPKey lhsPKey = lhs.getPKey();
					CFIntURLProtocolPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFIntURLProtocolObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFIntURLProtocolObj updateURLProtocol( ICFIntURLProtocolObj Obj ) {
		ICFIntURLProtocolObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableURLProtocol().updateURLProtocol( schema.getAuthorization(),
			Obj.getURLProtocolBuff() );
		obj = (ICFIntURLProtocolObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteURLProtocol( ICFIntURLProtocolObj Obj ) {
		ICFIntURLProtocolObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableURLProtocol().deleteURLProtocol( schema.getAuthorization(),
			obj.getURLProtocolBuff() );
		obj.forget( true );
	}

	public void deleteURLProtocolByIdIdx( int URLProtocolId )
	{
		CFIntURLProtocolPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newPKey();
		pkey.setRequiredURLProtocolId( URLProtocolId );
		ICFIntURLProtocolObj obj = readURLProtocol( pkey );
		if( obj != null ) {
			ICFIntURLProtocolEditObj editObj = (ICFIntURLProtocolEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFIntURLProtocolEditObj)obj.beginEdit();
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

	public void deleteURLProtocolByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFIntURLProtocolByUNameIdxKey,
				ICFIntURLProtocolObj >();
		}
		CFIntURLProtocolByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newUNameIdxKey();
		key.setRequiredName( Name );
		ICFIntURLProtocolObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableURLProtocol().deleteURLProtocolByUNameIdx( schema.getAuthorization(),
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableURLProtocol().deleteURLProtocolByUNameIdx( schema.getAuthorization(),
				Name );
		}
	}

	public void deleteURLProtocolByIsSecureIdx( boolean IsSecure )
	{
		CFIntURLProtocolByIsSecureIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryURLProtocol().newIsSecureIdxKey();
		key.setRequiredIsSecure( IsSecure );
		if( indexByIsSecureIdx == null ) {
			indexByIsSecureIdx = new HashMap< CFIntURLProtocolByIsSecureIdxKey,
				Map< CFIntURLProtocolPKey, ICFIntURLProtocolObj > >();
		}
		if( indexByIsSecureIdx.containsKey( key ) ) {
			Map<CFIntURLProtocolPKey, ICFIntURLProtocolObj> dict = indexByIsSecureIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableURLProtocol().deleteURLProtocolByIsSecureIdx( schema.getAuthorization(),
				IsSecure );
			Iterator<ICFIntURLProtocolObj> iter = dict.values().iterator();
			ICFIntURLProtocolObj obj;
			List<ICFIntURLProtocolObj> toForget = new LinkedList<ICFIntURLProtocolObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByIsSecureIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableURLProtocol().deleteURLProtocolByIsSecureIdx( schema.getAuthorization(),
				IsSecure );
		}
	}
}
