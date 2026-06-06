// Description: Java 11 Table Object implementation for CFGenKb.

/*
 *	org.msscf.msscf.CFCore
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

public class CFGenKbRuleTypeTableObj
	implements ICFGenKbRuleTypeTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbRuleTypePKey, ICFGenKbRuleTypeObj> members;
	private Map<CFGenKbRuleTypePKey, ICFGenKbRuleTypeObj> allRuleType;
	private Map< CFGenKbRuleTypeByNameIdxKey,
		ICFGenKbRuleTypeObj > indexByNameIdx;
	public static String TABLE_NAME = "RuleType";
	public static String TABLE_DBNAME = "kbruletype";

	public CFGenKbRuleTypeTableObj() {
		schema = null;
		members = new HashMap<CFGenKbRuleTypePKey, ICFGenKbRuleTypeObj>();
		allRuleType = null;
		indexByNameIdx = null;
	}

	public CFGenKbRuleTypeTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbRuleTypePKey, ICFGenKbRuleTypeObj>();
		allRuleType = null;
		indexByNameIdx = null;
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
		allRuleType = null;
		indexByNameIdx = null;
		List<ICFGenKbRuleTypeObj> toForget = new LinkedList<ICFGenKbRuleTypeObj>();
		ICFGenKbRuleTypeObj cur = null;
		Iterator<ICFGenKbRuleTypeObj> iter = members.values().iterator();
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
	 *	CFGenKbRuleTypeObj.
	 */
	public ICFGenKbRuleTypeObj newInstance() {
		ICFGenKbRuleTypeObj inst = new CFGenKbRuleTypeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbRuleTypeObj.
	 */
	public ICFGenKbRuleTypeEditObj newEditInstance( ICFGenKbRuleTypeObj orig ) {
		ICFGenKbRuleTypeEditObj edit = new CFGenKbRuleTypeEditObj( orig );
		return( edit );
	}

	public ICFGenKbRuleTypeObj realiseRuleType( ICFGenKbRuleTypeObj Obj ) {
		ICFGenKbRuleTypeObj obj = Obj;
		CFGenKbRuleTypePKey pkey = obj.getPKey();
		ICFGenKbRuleTypeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbRuleTypeObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByNameIdx != null ) {
				CFGenKbRuleTypeByNameIdxKey keyNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryRuleType().newNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByNameIdx != null ) {
				CFGenKbRuleTypeByNameIdxKey keyNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryRuleType().newNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

			if( allRuleType != null ) {
				allRuleType.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allRuleType != null ) {
				allRuleType.put( keepObj.getPKey(), keepObj );
			}

			if( indexByNameIdx != null ) {
				CFGenKbRuleTypeByNameIdxKey keyNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryRuleType().newNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetRuleType( ICFGenKbRuleTypeObj Obj ) {
		forgetRuleType( Obj, false );
	}

	public void forgetRuleType( ICFGenKbRuleTypeObj Obj, boolean forgetSubObjects ) {
		ICFGenKbRuleTypeObj obj = Obj;
		CFGenKbRuleTypePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbRuleTypeObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByNameIdx != null ) {
				CFGenKbRuleTypeByNameIdxKey keyNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryRuleType().newNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( allRuleType != null ) {
				allRuleType.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetRuleTypeByIdIdx( short Id )
	{
		if( members == null ) {
			return;
		}
		CFGenKbRuleTypePKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryRuleType().newPKey();
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFGenKbRuleTypeObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetRuleTypeByNameIdx( String Name )
	{
		if( indexByNameIdx == null ) {
			return;
		}
		List<ICFGenKbRuleTypeObj> toForget = new LinkedList<ICFGenKbRuleTypeObj>();
		ICFGenKbRuleTypeObj cur = null;
		CFGenKbRuleTypeByNameIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryRuleType().newNameIdxKey();
		key.setRequiredName( Name );
		if( indexByNameIdx.containsKey( key ) ) {
			cur = indexByNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFGenKbRuleTypeObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbRuleTypeObj createRuleType( ICFGenKbRuleTypeObj Obj ) {
		ICFGenKbRuleTypeObj obj = Obj;
		CFGenKbRuleTypeBuff buff = obj.getRuleTypeBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableRuleType().createRuleType(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbRuleTypeObj readRuleType( CFGenKbRuleTypePKey pkey ) {
		return( readRuleType( pkey, false ) );
	}

	public ICFGenKbRuleTypeObj readRuleType( CFGenKbRuleTypePKey pkey, boolean forceRead ) {
		ICFGenKbRuleTypeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbRuleTypeBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableRuleType().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getRuleTypeTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryRuleType().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbRuleTypeObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbRuleTypeObj lockRuleType( CFGenKbRuleTypePKey pkey ) {
		ICFGenKbRuleTypeObj locked = null;
		CFGenKbRuleTypeBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableRuleType().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getRuleTypeTableObj().newInstance();
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryRuleType().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbRuleTypeObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockRuleType", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbRuleTypeObj> readAllRuleType() {
		return( readAllRuleType( false ) );
	}

	public List<ICFGenKbRuleTypeObj> readAllRuleType( boolean forceRead ) {
		final String S_ProcName = "readAllRuleType";
		if( ( allRuleType == null ) || forceRead ) {
			Map<CFGenKbRuleTypePKey, ICFGenKbRuleTypeObj> map = new HashMap<CFGenKbRuleTypePKey,ICFGenKbRuleTypeObj>();
			allRuleType = map;
			CFGenKbRuleTypeBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableRuleType().readAllDerived( schema.getAuthorization() );
			CFGenKbRuleTypeBuff buff;
			ICFGenKbRuleTypeObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryRuleType().newPKey() );
				obj.setBuff( buff );
				ICFGenKbRuleTypeObj realised = (ICFGenKbRuleTypeObj)obj.realise();
			}
		}
		int len = allRuleType.size();
		ICFGenKbRuleTypeObj arr[] = new ICFGenKbRuleTypeObj[len];
		Iterator<ICFGenKbRuleTypeObj> valIter = allRuleType.values().iterator();
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
		ArrayList<ICFGenKbRuleTypeObj> arrayList = new ArrayList<ICFGenKbRuleTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbRuleTypeObj> cmp = new Comparator<ICFGenKbRuleTypeObj>() {
			public int compare( ICFGenKbRuleTypeObj lhs, ICFGenKbRuleTypeObj rhs ) {
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
					CFGenKbRuleTypePKey lhsPKey = lhs.getPKey();
					CFGenKbRuleTypePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbRuleTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbRuleTypeObj readRuleTypeByIdIdx( short Id )
	{
		return( readRuleTypeByIdIdx( Id,
			false ) );
	}

	public ICFGenKbRuleTypeObj readRuleTypeByIdIdx( short Id, boolean forceRead )
	{
		CFGenKbRuleTypePKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryRuleType().newPKey();
		pkey.setRequiredId( Id );
		ICFGenKbRuleTypeObj obj = readRuleType( pkey, forceRead );
		return( obj );
	}

	public ICFGenKbRuleTypeObj readRuleTypeByNameIdx( String Name )
	{
		return( readRuleTypeByNameIdx( Name,
			false ) );
	}

	public ICFGenKbRuleTypeObj readRuleTypeByNameIdx( String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFGenKbRuleTypeByNameIdxKey,
				ICFGenKbRuleTypeObj >();
		}
		CFGenKbRuleTypeByNameIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryRuleType().newNameIdxKey();
		key.setRequiredName( Name );
		ICFGenKbRuleTypeObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			CFGenKbRuleTypeBuff buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableRuleType().readDerivedByNameIdx( schema.getAuthorization(),
				Name );
			if( buff != null ) {
				obj = schema.getRuleTypeTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryRuleType().newPKey() );
				obj.setBuff( buff );
				obj = (ICFGenKbRuleTypeObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbRuleTypeObj updateRuleType( ICFGenKbRuleTypeObj Obj ) {
		ICFGenKbRuleTypeObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableRuleType().updateRuleType( schema.getAuthorization(),
			Obj.getRuleTypeBuff() );
		obj = (ICFGenKbRuleTypeObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteRuleType( ICFGenKbRuleTypeObj Obj ) {
		ICFGenKbRuleTypeObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableRuleType().deleteRuleType( schema.getAuthorization(),
			obj.getRuleTypeBuff() );
		obj.forget( true );
	}

	public void deleteRuleTypeByIdIdx( short Id )
	{
		CFGenKbRuleTypePKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryRuleType().newPKey();
		pkey.setRequiredId( Id );
		ICFGenKbRuleTypeObj obj = readRuleType( pkey );
		if( obj != null ) {
			ICFGenKbRuleTypeEditObj editObj = (ICFGenKbRuleTypeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbRuleTypeEditObj)obj.beginEdit();
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

	public void deleteRuleTypeByNameIdx( String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFGenKbRuleTypeByNameIdxKey,
				ICFGenKbRuleTypeObj >();
		}
		CFGenKbRuleTypeByNameIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryRuleType().newNameIdxKey();
		key.setRequiredName( Name );
		ICFGenKbRuleTypeObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableRuleType().deleteRuleTypeByNameIdx( schema.getAuthorization(),
				Name );
			obj.forget( true );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableRuleType().deleteRuleTypeByNameIdx( schema.getAuthorization(),
				Name );
		}
	}
}
