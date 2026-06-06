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

public class CFIntMimeTypeTableObj
	implements ICFIntMimeTypeTableObj
{
	protected ICFIntSchemaObj schema;
	private Map<CFIntMimeTypePKey, ICFIntMimeTypeObj> members;
	private Map<CFIntMimeTypePKey, ICFIntMimeTypeObj> allMimeType;
	private Map< CFIntMimeTypeByUNameIdxKey,
		ICFIntMimeTypeObj > indexByUNameIdx;
	public static String TABLE_NAME = "MimeType";
	public static String TABLE_DBNAME = "mimetype";

	public CFIntMimeTypeTableObj() {
		schema = null;
		members = new HashMap<CFIntMimeTypePKey, ICFIntMimeTypeObj>();
		allMimeType = null;
		indexByUNameIdx = null;
	}

	public CFIntMimeTypeTableObj( ICFIntSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFIntMimeTypePKey, ICFIntMimeTypeObj>();
		allMimeType = null;
		indexByUNameIdx = null;
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
		allMimeType = null;
		indexByUNameIdx = null;
		List<ICFIntMimeTypeObj> toForget = new LinkedList<ICFIntMimeTypeObj>();
		ICFIntMimeTypeObj cur = null;
		Iterator<ICFIntMimeTypeObj> iter = members.values().iterator();
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
	 *	CFIntMimeTypeObj.
	 */
	public ICFIntMimeTypeObj newInstance() {
		ICFIntMimeTypeObj inst = new CFIntMimeTypeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFIntMimeTypeObj.
	 */
	public ICFIntMimeTypeEditObj newEditInstance( ICFIntMimeTypeObj orig ) {
		ICFIntMimeTypeEditObj edit = new CFIntMimeTypeEditObj( orig );
		return( edit );
	}

	public ICFIntMimeTypeObj realiseMimeType( ICFIntMimeTypeObj Obj ) {
		ICFIntMimeTypeObj obj = Obj;
		CFIntMimeTypePKey pkey = obj.getPKey();
		ICFIntMimeTypeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFIntMimeTypeObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				CFIntMimeTypeByUNameIdxKey keyUNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryMimeType().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				CFIntMimeTypeByUNameIdxKey keyUNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryMimeType().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allMimeType != null ) {
				allMimeType.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allMimeType != null ) {
				allMimeType.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				CFIntMimeTypeByUNameIdxKey keyUNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryMimeType().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetMimeType( ICFIntMimeTypeObj Obj ) {
		forgetMimeType( Obj, false );
	}

	public void forgetMimeType( ICFIntMimeTypeObj Obj, boolean forgetSubObjects ) {
		ICFIntMimeTypeObj obj = Obj;
		CFIntMimeTypePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFIntMimeTypeObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUNameIdx != null ) {
				CFIntMimeTypeByUNameIdxKey keyUNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryMimeType().newUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allMimeType != null ) {
				allMimeType.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetMimeTypeByIdIdx( int MimeTypeId )
	{
		if( members == null ) {
			return;
		}
		CFIntMimeTypePKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryMimeType().newPKey();
		key.setRequiredMimeTypeId( MimeTypeId );
		if( members.containsKey( key ) ) {
			ICFIntMimeTypeObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetMimeTypeByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFIntMimeTypeObj> toForget = new LinkedList<ICFIntMimeTypeObj>();
		ICFIntMimeTypeObj cur = null;
		CFIntMimeTypeByUNameIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryMimeType().newUNameIdxKey();
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFIntMimeTypeObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFIntMimeTypeObj createMimeType( ICFIntMimeTypeObj Obj ) {
		ICFIntMimeTypeObj obj = Obj;
		CFIntMimeTypeBuff buff = obj.getMimeTypeBuff();
		((ICFIntSchema)schema.getBackingStore()).getTableMimeType().createMimeType(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFIntMimeTypeObj readMimeType( CFIntMimeTypePKey pkey ) {
		return( readMimeType( pkey, false ) );
	}

	public ICFIntMimeTypeObj readMimeType( CFIntMimeTypePKey pkey, boolean forceRead ) {
		ICFIntMimeTypeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFIntMimeTypeBuff readBuff = ((ICFIntSchema)schema.getBackingStore()).getTableMimeType().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredMimeTypeId() );
			if( readBuff != null ) {
				obj = schema.getMimeTypeTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryMimeType().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFIntMimeTypeObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFIntMimeTypeObj lockMimeType( CFIntMimeTypePKey pkey ) {
		ICFIntMimeTypeObj locked = null;
		CFIntMimeTypeBuff lockBuff = ((ICFIntSchema)schema.getBackingStore()).getTableMimeType().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getMimeTypeTableObj().newInstance();
			locked.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryMimeType().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFIntMimeTypeObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockMimeType", pkey );
		}
		return( locked );
	}

	public List<ICFIntMimeTypeObj> readAllMimeType() {
		return( readAllMimeType( false ) );
	}

	public List<ICFIntMimeTypeObj> readAllMimeType( boolean forceRead ) {
		final String S_ProcName = "readAllMimeType";
		if( ( allMimeType == null ) || forceRead ) {
			Map<CFIntMimeTypePKey, ICFIntMimeTypeObj> map = new HashMap<CFIntMimeTypePKey,ICFIntMimeTypeObj>();
			allMimeType = map;
			CFIntMimeTypeBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableMimeType().readAllDerived( schema.getAuthorization() );
			CFIntMimeTypeBuff buff;
			ICFIntMimeTypeObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryMimeType().newPKey() );
				obj.setBuff( buff );
				ICFIntMimeTypeObj realised = (ICFIntMimeTypeObj)obj.realise();
			}
		}
		int len = allMimeType.size();
		ICFIntMimeTypeObj arr[] = new ICFIntMimeTypeObj[len];
		Iterator<ICFIntMimeTypeObj> valIter = allMimeType.values().iterator();
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
		ArrayList<ICFIntMimeTypeObj> arrayList = new ArrayList<ICFIntMimeTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFIntMimeTypeObj> cmp = new Comparator<ICFIntMimeTypeObj>() {
			public int compare( ICFIntMimeTypeObj lhs, ICFIntMimeTypeObj rhs ) {
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
					CFIntMimeTypePKey lhsPKey = lhs.getPKey();
					CFIntMimeTypePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFIntMimeTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFIntMimeTypeObj readMimeTypeByIdIdx( int MimeTypeId )
	{
		return( readMimeTypeByIdIdx( MimeTypeId,
			false ) );
	}

	public ICFIntMimeTypeObj readMimeTypeByIdIdx( int MimeTypeId, boolean forceRead )
	{
		CFIntMimeTypePKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryMimeType().newPKey();
		pkey.setRequiredMimeTypeId( MimeTypeId );
		ICFIntMimeTypeObj obj = readMimeType( pkey, forceRead );
		return( obj );
	}

	public ICFIntMimeTypeObj readMimeTypeByUNameIdx( String Name )
	{
		return( readMimeTypeByUNameIdx( Name,
			false ) );
	}

	public ICFIntMimeTypeObj readMimeTypeByUNameIdx( String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFIntMimeTypeByUNameIdxKey,
				ICFIntMimeTypeObj >();
		}
		CFIntMimeTypeByUNameIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryMimeType().newUNameIdxKey();
		key.setRequiredName( Name );
		ICFIntMimeTypeObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFIntMimeTypeBuff buff = ((ICFIntSchema)schema.getBackingStore()).getTableMimeType().readDerivedByUNameIdx( schema.getAuthorization(),
				Name );
			if( buff != null ) {
				obj = schema.getMimeTypeTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryMimeType().newPKey() );
				obj.setBuff( buff );
				obj = (ICFIntMimeTypeObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFIntMimeTypeObj updateMimeType( ICFIntMimeTypeObj Obj ) {
		ICFIntMimeTypeObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableMimeType().updateMimeType( schema.getAuthorization(),
			Obj.getMimeTypeBuff() );
		obj = (ICFIntMimeTypeObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteMimeType( ICFIntMimeTypeObj Obj ) {
		ICFIntMimeTypeObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableMimeType().deleteMimeType( schema.getAuthorization(),
			obj.getMimeTypeBuff() );
		obj.forget( true );
	}

	public void deleteMimeTypeByIdIdx( int MimeTypeId )
	{
		CFIntMimeTypePKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryMimeType().newPKey();
		pkey.setRequiredMimeTypeId( MimeTypeId );
		ICFIntMimeTypeObj obj = readMimeType( pkey );
		if( obj != null ) {
			ICFIntMimeTypeEditObj editObj = (ICFIntMimeTypeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFIntMimeTypeEditObj)obj.beginEdit();
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

	public void deleteMimeTypeByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFIntMimeTypeByUNameIdxKey,
				ICFIntMimeTypeObj >();
		}
		CFIntMimeTypeByUNameIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryMimeType().newUNameIdxKey();
		key.setRequiredName( Name );
		ICFIntMimeTypeObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableMimeType().deleteMimeTypeByUNameIdx( schema.getAuthorization(),
				Name );
			obj.forget( true );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableMimeType().deleteMimeTypeByUNameIdx( schema.getAuthorization(),
				Name );
		}
	}
}
