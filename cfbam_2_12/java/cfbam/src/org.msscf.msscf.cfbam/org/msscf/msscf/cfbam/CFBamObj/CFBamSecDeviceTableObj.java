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

public class CFBamSecDeviceTableObj
	implements ICFBamSecDeviceTableObj
{
	protected ICFSecSchemaObj schema;
	private Map<CFSecSecDevicePKey, ICFSecSecDeviceObj> members;
	private Map<CFSecSecDevicePKey, ICFSecSecDeviceObj> allSecDevice;
	private Map< CFSecSecDeviceByNameIdxKey,
		ICFSecSecDeviceObj > indexByNameIdx;
	private Map< CFSecSecDeviceByUserIdxKey,
		Map<CFSecSecDevicePKey, ICFSecSecDeviceObj > > indexByUserIdx;
	public static String TABLE_NAME = "SecDevice";
	public static String TABLE_DBNAME = "secdev";

	public CFBamSecDeviceTableObj() {
		schema = null;
		members = new HashMap<CFSecSecDevicePKey, ICFSecSecDeviceObj>();
		allSecDevice = null;
		indexByNameIdx = null;
		indexByUserIdx = null;
	}

	public CFBamSecDeviceTableObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFSecSecDevicePKey, ICFSecSecDeviceObj>();
		allSecDevice = null;
		indexByNameIdx = null;
		indexByUserIdx = null;
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
		allSecDevice = null;
		indexByNameIdx = null;
		indexByUserIdx = null;
		List<ICFSecSecDeviceObj> toForget = new LinkedList<ICFSecSecDeviceObj>();
		ICFSecSecDeviceObj cur = null;
		Iterator<ICFSecSecDeviceObj> iter = members.values().iterator();
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
	 *	CFBamSecDeviceObj.
	 */
	public ICFSecSecDeviceObj newInstance() {
		ICFSecSecDeviceObj inst = new CFBamSecDeviceObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSecDeviceObj.
	 */
	public ICFSecSecDeviceEditObj newEditInstance( ICFSecSecDeviceObj orig ) {
		ICFSecSecDeviceEditObj edit = new CFBamSecDeviceEditObj( orig );
		return( edit );
	}

	public ICFSecSecDeviceObj realiseSecDevice( ICFSecSecDeviceObj Obj ) {
		ICFSecSecDeviceObj obj = Obj;
		CFSecSecDevicePKey pkey = obj.getPKey();
		ICFSecSecDeviceObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFSecSecDeviceObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByNameIdx != null ) {
				CFSecSecDeviceByNameIdxKey keyNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newNameIdxKey();
				keyNameIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyNameIdx.setRequiredDevName( keepObj.getRequiredDevName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( indexByUserIdx != null ) {
				CFSecSecDeviceByUserIdxKey keyUserIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFSecSecDevicePKey, ICFSecSecDeviceObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.remove( keepObj.getPKey() );
					if( mapUserIdx.size() <= 0 ) {
						indexByUserIdx.remove( keyUserIdx );
					}
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByNameIdx != null ) {
				CFSecSecDeviceByNameIdxKey keyNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newNameIdxKey();
				keyNameIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyNameIdx.setRequiredDevName( keepObj.getRequiredDevName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

			if( indexByUserIdx != null ) {
				CFSecSecDeviceByUserIdxKey keyUserIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFSecSecDevicePKey, ICFSecSecDeviceObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSecDevice != null ) {
				allSecDevice.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecDevice != null ) {
				allSecDevice.put( keepObj.getPKey(), keepObj );
			}

			if( indexByNameIdx != null ) {
				CFSecSecDeviceByNameIdxKey keyNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newNameIdxKey();
				keyNameIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyNameIdx.setRequiredDevName( keepObj.getRequiredDevName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

			if( indexByUserIdx != null ) {
				CFSecSecDeviceByUserIdxKey keyUserIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFSecSecDevicePKey, ICFSecSecDeviceObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetSecDevice( ICFSecSecDeviceObj Obj ) {
		forgetSecDevice( Obj, false );
	}

	public void forgetSecDevice( ICFSecSecDeviceObj Obj, boolean forgetSubObjects ) {
		ICFSecSecDeviceObj obj = Obj;
		CFSecSecDevicePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFSecSecDeviceObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByNameIdx != null ) {
				CFSecSecDeviceByNameIdxKey keyNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newNameIdxKey();
				keyNameIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyNameIdx.setRequiredDevName( keepObj.getRequiredDevName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( indexByUserIdx != null ) {
				CFSecSecDeviceByUserIdxKey keyUserIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFSecSecDevicePKey, ICFSecSecDeviceObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.remove( keepObj.getPKey() );
					if( mapUserIdx.size() <= 0 ) {
						indexByUserIdx.remove( keyUserIdx );
					}
				}
			}

			if( allSecDevice != null ) {
				allSecDevice.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetSecDeviceByIdIdx( UUID SecUserId,
		String DevName )
	{
		if( members == null ) {
			return;
		}
		CFSecSecDevicePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newPKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredDevName( DevName );
		if( members.containsKey( key ) ) {
			ICFSecSecDeviceObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecDeviceByNameIdx( UUID SecUserId,
		String DevName )
	{
		if( indexByNameIdx == null ) {
			return;
		}
		List<ICFSecSecDeviceObj> toForget = new LinkedList<ICFSecSecDeviceObj>();
		ICFSecSecDeviceObj cur = null;
		CFSecSecDeviceByNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newNameIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredDevName( DevName );
		if( indexByNameIdx.containsKey( key ) ) {
			cur = indexByNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFSecSecDeviceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecDeviceByUserIdx( UUID SecUserId )
	{
		if( indexByUserIdx == null ) {
			return;
		}
		List<ICFSecSecDeviceObj> toForget = new LinkedList<ICFSecSecDeviceObj>();
		ICFSecSecDeviceObj cur = null;
		CFSecSecDeviceByUserIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexByUserIdx.containsKey( key ) ) {
			Map<CFSecSecDevicePKey, ICFSecSecDeviceObj > mapUserIdx = indexByUserIdx.get( key );
			if( mapUserIdx != null ) {
				Iterator<ICFSecSecDeviceObj> iterDup = mapUserIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByUserIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecDeviceObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecDeviceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFSecSecDeviceObj createSecDevice( ICFSecSecDeviceObj Obj ) {
		ICFSecSecDeviceObj obj = Obj;
		CFSecSecDeviceBuff buff = obj.getSecDeviceBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableSecDevice().createSecDevice(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFSecSecDeviceObj readSecDevice( CFSecSecDevicePKey pkey ) {
		return( readSecDevice( pkey, false ) );
	}

	public ICFSecSecDeviceObj readSecDevice( CFSecSecDevicePKey pkey, boolean forceRead ) {
		ICFSecSecDeviceObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFSecSecDeviceBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableSecDevice().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredSecUserId(),
				pkey.getRequiredDevName() );
			if( readBuff != null ) {
				obj = schema.getSecDeviceTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFSecSecDeviceObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecSecDeviceObj lockSecDevice( CFSecSecDevicePKey pkey ) {
		ICFSecSecDeviceObj locked = null;
		CFSecSecDeviceBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableSecDevice().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecDeviceTableObj().newInstance();
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFSecSecDeviceObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockSecDevice", pkey );
		}
		return( locked );
	}

	public List<ICFSecSecDeviceObj> readAllSecDevice() {
		return( readAllSecDevice( false ) );
	}

	public List<ICFSecSecDeviceObj> readAllSecDevice( boolean forceRead ) {
		final String S_ProcName = "readAllSecDevice";
		if( ( allSecDevice == null ) || forceRead ) {
			Map<CFSecSecDevicePKey, ICFSecSecDeviceObj> map = new HashMap<CFSecSecDevicePKey,ICFSecSecDeviceObj>();
			allSecDevice = map;
			CFSecSecDeviceBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecDevice().readAllDerived( schema.getAuthorization() );
			CFSecSecDeviceBuff buff;
			ICFSecSecDeviceObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newPKey() );
				obj.setBuff( buff );
				ICFSecSecDeviceObj realised = (ICFSecSecDeviceObj)obj.realise();
			}
		}
		int len = allSecDevice.size();
		ICFSecSecDeviceObj arr[] = new ICFSecSecDeviceObj[len];
		Iterator<ICFSecSecDeviceObj> valIter = allSecDevice.values().iterator();
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
		ArrayList<ICFSecSecDeviceObj> arrayList = new ArrayList<ICFSecSecDeviceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecDeviceObj> cmp = new Comparator<ICFSecSecDeviceObj>() {
			public int compare( ICFSecSecDeviceObj lhs, ICFSecSecDeviceObj rhs ) {
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
					CFSecSecDevicePKey lhsPKey = lhs.getPKey();
					CFSecSecDevicePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecDeviceObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Return a sorted map of a page of the SecDevice-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecDeviceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	public List<ICFSecSecDeviceObj> pageAllSecDevice(UUID priorSecUserId,
		String priorDevName )
	{
		final String S_ProcName = "pageAllSecDevice";
		Map<CFSecSecDevicePKey, ICFSecSecDeviceObj> map = new HashMap<CFSecSecDevicePKey,ICFSecSecDeviceObj>();
		CFSecSecDeviceBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecDevice().pageAllBuff( schema.getAuthorization(),
			priorSecUserId,
			priorDevName );
		CFSecSecDeviceBuff buff;
		ICFSecSecDeviceObj obj;
		ICFSecSecDeviceObj realised;
		ArrayList<ICFSecSecDeviceObj> arrayList = new ArrayList<ICFSecSecDeviceObj>( buffList.length );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newPKey() );
			obj.setBuff( buff );
			realised = (ICFSecSecDeviceObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	public ICFSecSecDeviceObj readSecDeviceByIdIdx( UUID SecUserId,
		String DevName )
	{
		return( readSecDeviceByIdIdx( SecUserId,
			DevName,
			false ) );
	}

	public ICFSecSecDeviceObj readSecDeviceByIdIdx( UUID SecUserId,
		String DevName, boolean forceRead )
	{
		CFSecSecDevicePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newPKey();
		pkey.setRequiredSecUserId( SecUserId );
		pkey.setRequiredDevName( DevName );
		ICFSecSecDeviceObj obj = readSecDevice( pkey, forceRead );
		return( obj );
	}

	public ICFSecSecDeviceObj readSecDeviceByNameIdx( UUID SecUserId,
		String DevName )
	{
		return( readSecDeviceByNameIdx( SecUserId,
			DevName,
			false ) );
	}

	public ICFSecSecDeviceObj readSecDeviceByNameIdx( UUID SecUserId,
		String DevName, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFSecSecDeviceByNameIdxKey,
				ICFSecSecDeviceObj >();
		}
		CFSecSecDeviceByNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newNameIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredDevName( DevName );
		ICFSecSecDeviceObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			CFSecSecDeviceBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableSecDevice().readDerivedByNameIdx( schema.getAuthorization(),
				SecUserId,
				DevName );
			if( buff != null ) {
				obj = schema.getSecDeviceTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newPKey() );
				obj.setBuff( buff );
				obj = (ICFSecSecDeviceObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFSecSecDeviceObj> readSecDeviceByUserIdx( UUID SecUserId )
	{
		return( readSecDeviceByUserIdx( SecUserId,
			false ) );
	}

	public List<ICFSecSecDeviceObj> readSecDeviceByUserIdx( UUID SecUserId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecDeviceByUserIdx";
		CFSecSecDeviceByUserIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		Map<CFSecSecDevicePKey, ICFSecSecDeviceObj> dict;
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< CFSecSecDeviceByUserIdxKey,
				Map< CFSecSecDevicePKey, ICFSecSecDeviceObj > >();
		}
		if( ( ! forceRead ) && indexByUserIdx.containsKey( key ) ) {
			dict = indexByUserIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecDevicePKey, ICFSecSecDeviceObj>();
			ICFSecSecDeviceObj obj;
			CFSecSecDeviceBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecDevice().readDerivedByUserIdx( schema.getAuthorization(),
				SecUserId );
			CFSecSecDeviceBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecDeviceTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newPKey() );
				obj.setBuff( buff );
				ICFSecSecDeviceObj realised = (ICFSecSecDeviceObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByUserIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecDeviceObj arr[] = new ICFSecSecDeviceObj[len];
		Iterator<ICFSecSecDeviceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecDeviceObj> arrayList = new ArrayList<ICFSecSecDeviceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecDeviceObj> cmp = new Comparator<ICFSecSecDeviceObj>() {
			public int compare( ICFSecSecDeviceObj lhs, ICFSecSecDeviceObj rhs ) {
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
					CFSecSecDevicePKey lhsPKey = lhs.getPKey();
					CFSecSecDevicePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecDeviceObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Read a page of data as a List of SecDevice-derived instances sorted by their primary keys,
	 *	as identified by the duplicate UserIdx key attributes.
	 *
	 *	@param	argSecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecDevice-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecSecDeviceObj> pageSecDeviceByUserIdx( UUID SecUserId,
		UUID priorSecUserId,
		String priorDevName )
	{
		final String S_ProcName = "pageSecDeviceByUserIdx";
		CFSecSecDeviceByUserIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		List<ICFSecSecDeviceObj> retList = new LinkedList<ICFSecSecDeviceObj>();
		ICFSecSecDeviceObj obj;
		CFSecSecDeviceBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecDevice().pageBuffByUserIdx( schema.getAuthorization(),
				SecUserId,
			priorSecUserId,
			priorDevName );
		CFSecSecDeviceBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecDeviceTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newPKey() );
			obj.setBuff( buff );
			ICFSecSecDeviceObj realised = (ICFSecSecDeviceObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	public ICFSecSecDeviceObj updateSecDevice( ICFSecSecDeviceObj Obj ) {
		ICFSecSecDeviceObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableSecDevice().updateSecDevice( schema.getAuthorization(),
			Obj.getSecDeviceBuff() );
		obj = (ICFSecSecDeviceObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteSecDevice( ICFSecSecDeviceObj Obj ) {
		ICFSecSecDeviceObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableSecDevice().deleteSecDevice( schema.getAuthorization(),
			obj.getSecDeviceBuff() );
		obj.forget( true );
	}

	public void deleteSecDeviceByIdIdx( UUID SecUserId,
		String DevName )
	{
		CFSecSecDevicePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newPKey();
		pkey.setRequiredSecUserId( SecUserId );
		pkey.setRequiredDevName( DevName );
		ICFSecSecDeviceObj obj = readSecDevice( pkey );
		if( obj != null ) {
			ICFSecSecDeviceEditObj editObj = (ICFSecSecDeviceEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFSecSecDeviceEditObj)obj.beginEdit();
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

	public void deleteSecDeviceByNameIdx( UUID SecUserId,
		String DevName )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFSecSecDeviceByNameIdxKey,
				ICFSecSecDeviceObj >();
		}
		CFSecSecDeviceByNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newNameIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredDevName( DevName );
		ICFSecSecDeviceObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSecDevice().deleteSecDeviceByNameIdx( schema.getAuthorization(),
				SecUserId,
				DevName );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSecDevice().deleteSecDeviceByNameIdx( schema.getAuthorization(),
				SecUserId,
				DevName );
		}
	}

	public void deleteSecDeviceByUserIdx( UUID SecUserId )
	{
		CFSecSecDeviceByUserIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecDevice().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< CFSecSecDeviceByUserIdxKey,
				Map< CFSecSecDevicePKey, ICFSecSecDeviceObj > >();
		}
		if( indexByUserIdx.containsKey( key ) ) {
			Map<CFSecSecDevicePKey, ICFSecSecDeviceObj> dict = indexByUserIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSecDevice().deleteSecDeviceByUserIdx( schema.getAuthorization(),
				SecUserId );
			Iterator<ICFSecSecDeviceObj> iter = dict.values().iterator();
			ICFSecSecDeviceObj obj;
			List<ICFSecSecDeviceObj> toForget = new LinkedList<ICFSecSecDeviceObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByUserIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSecDevice().deleteSecDeviceByUserIdx( schema.getAuthorization(),
				SecUserId );
		}
	}
}
