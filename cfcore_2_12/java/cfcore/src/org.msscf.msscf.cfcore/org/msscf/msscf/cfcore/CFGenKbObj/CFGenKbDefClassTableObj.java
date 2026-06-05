// Description: Java 11 Table Object implementation for CFGenKb.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public class CFGenKbDefClassTableObj
	implements ICFGenKbDefClassTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbDefClassPKey, ICFGenKbDefClassObj> members;
	private Map<CFGenKbDefClassPKey, ICFGenKbDefClassObj> allDefClass;
	private Map< CFGenKbDefClassByNameIdxKey,
		ICFGenKbDefClassObj > indexByNameIdx;
	private Map< CFGenKbDefClassByBaseIdxKey,
		Map<CFGenKbDefClassPKey, ICFGenKbDefClassObj > > indexByBaseIdx;
	public static String TABLE_NAME = "DefClass";
	public static String TABLE_DBNAME = "kbdefclass";

	public CFGenKbDefClassTableObj() {
		schema = null;
		members = new HashMap<CFGenKbDefClassPKey, ICFGenKbDefClassObj>();
		allDefClass = null;
		indexByNameIdx = null;
		indexByBaseIdx = null;
	}

	public CFGenKbDefClassTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbDefClassPKey, ICFGenKbDefClassObj>();
		allDefClass = null;
		indexByNameIdx = null;
		indexByBaseIdx = null;
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
		allDefClass = null;
		indexByNameIdx = null;
		indexByBaseIdx = null;
		List<ICFGenKbDefClassObj> toForget = new LinkedList<ICFGenKbDefClassObj>();
		ICFGenKbDefClassObj cur = null;
		Iterator<ICFGenKbDefClassObj> iter = members.values().iterator();
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
	 *	CFGenKbDefClassObj.
	 */
	public ICFGenKbDefClassObj newInstance() {
		ICFGenKbDefClassObj inst = new CFGenKbDefClassObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbDefClassObj.
	 */
	public ICFGenKbDefClassEditObj newEditInstance( ICFGenKbDefClassObj orig ) {
		ICFGenKbDefClassEditObj edit = new CFGenKbDefClassEditObj( orig );
		return( edit );
	}

	public ICFGenKbDefClassObj realiseDefClass( ICFGenKbDefClassObj Obj ) {
		ICFGenKbDefClassObj obj = Obj;
		CFGenKbDefClassPKey pkey = obj.getPKey();
		ICFGenKbDefClassObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbDefClassObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByNameIdx != null ) {
				CFGenKbDefClassByNameIdxKey keyNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( indexByBaseIdx != null ) {
				CFGenKbDefClassByBaseIdxKey keyBaseIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newBaseIdxKey();
				keyBaseIdx.setOptionalBaseId( keepObj.getOptionalBaseId() );
				Map<CFGenKbDefClassPKey, ICFGenKbDefClassObj > mapBaseIdx = indexByBaseIdx.get( keyBaseIdx );
				if( mapBaseIdx != null ) {
					mapBaseIdx.remove( keepObj.getPKey() );
					if( mapBaseIdx.size() <= 0 ) {
						indexByBaseIdx.remove( keyBaseIdx );
					}
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByNameIdx != null ) {
				CFGenKbDefClassByNameIdxKey keyNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

			if( indexByBaseIdx != null ) {
				CFGenKbDefClassByBaseIdxKey keyBaseIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newBaseIdxKey();
				keyBaseIdx.setOptionalBaseId( keepObj.getOptionalBaseId() );
				Map<CFGenKbDefClassPKey, ICFGenKbDefClassObj > mapBaseIdx = indexByBaseIdx.get( keyBaseIdx );
				if( mapBaseIdx != null ) {
					mapBaseIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allDefClass != null ) {
				allDefClass.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allDefClass != null ) {
				allDefClass.put( keepObj.getPKey(), keepObj );
			}

			if( indexByNameIdx != null ) {
				CFGenKbDefClassByNameIdxKey keyNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

			if( indexByBaseIdx != null ) {
				CFGenKbDefClassByBaseIdxKey keyBaseIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newBaseIdxKey();
				keyBaseIdx.setOptionalBaseId( keepObj.getOptionalBaseId() );
				Map<CFGenKbDefClassPKey, ICFGenKbDefClassObj > mapBaseIdx = indexByBaseIdx.get( keyBaseIdx );
				if( mapBaseIdx != null ) {
					mapBaseIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetDefClass( ICFGenKbDefClassObj Obj ) {
		forgetDefClass( Obj, false );
	}

	public void forgetDefClass( ICFGenKbDefClassObj Obj, boolean forgetSubObjects ) {
		ICFGenKbDefClassObj obj = Obj;
		CFGenKbDefClassPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbDefClassObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByNameIdx != null ) {
				CFGenKbDefClassByNameIdxKey keyNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( indexByBaseIdx != null ) {
				CFGenKbDefClassByBaseIdxKey keyBaseIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newBaseIdxKey();
				keyBaseIdx.setOptionalBaseId( keepObj.getOptionalBaseId() );
				Map<CFGenKbDefClassPKey, ICFGenKbDefClassObj > mapBaseIdx = indexByBaseIdx.get( keyBaseIdx );
				if( mapBaseIdx != null ) {
					mapBaseIdx.remove( keepObj.getPKey() );
					if( mapBaseIdx.size() <= 0 ) {
						indexByBaseIdx.remove( keyBaseIdx );
					}
				}
			}

			if( allDefClass != null ) {
				allDefClass.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetDefClassByIdIdx( short Id )
	{
		if( members == null ) {
			return;
		}
		CFGenKbDefClassPKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newPKey();
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFGenKbDefClassObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetDefClassByNameIdx( String Name )
	{
		if( indexByNameIdx == null ) {
			return;
		}
		List<ICFGenKbDefClassObj> toForget = new LinkedList<ICFGenKbDefClassObj>();
		ICFGenKbDefClassObj cur = null;
		CFGenKbDefClassByNameIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newNameIdxKey();
		key.setRequiredName( Name );
		if( indexByNameIdx.containsKey( key ) ) {
			cur = indexByNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFGenKbDefClassObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetDefClassByBaseIdx( Short BaseId )
	{
		if( indexByBaseIdx == null ) {
			return;
		}
		List<ICFGenKbDefClassObj> toForget = new LinkedList<ICFGenKbDefClassObj>();
		ICFGenKbDefClassObj cur = null;
		CFGenKbDefClassByBaseIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newBaseIdxKey();
		key.setOptionalBaseId( BaseId );
		if( indexByBaseIdx.containsKey( key ) ) {
			Map<CFGenKbDefClassPKey, ICFGenKbDefClassObj > mapBaseIdx = indexByBaseIdx.get( key );
			if( mapBaseIdx != null ) {
				Iterator<ICFGenKbDefClassObj> iterDup = mapBaseIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByBaseIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbDefClassObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbDefClassObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbDefClassObj createDefClass( ICFGenKbDefClassObj Obj ) {
		ICFGenKbDefClassObj obj = Obj;
		CFGenKbDefClassBuff buff = obj.getDefClassBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableDefClass().createDefClass(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbDefClassObj readDefClass( CFGenKbDefClassPKey pkey ) {
		return( readDefClass( pkey, false ) );
	}

	public ICFGenKbDefClassObj readDefClass( CFGenKbDefClassPKey pkey, boolean forceRead ) {
		ICFGenKbDefClassObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbDefClassBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableDefClass().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getDefClassTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbDefClassObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbDefClassObj lockDefClass( CFGenKbDefClassPKey pkey ) {
		ICFGenKbDefClassObj locked = null;
		CFGenKbDefClassBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableDefClass().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getDefClassTableObj().newInstance();
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbDefClassObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockDefClass", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbDefClassObj> readAllDefClass() {
		return( readAllDefClass( false ) );
	}

	public List<ICFGenKbDefClassObj> readAllDefClass( boolean forceRead ) {
		final String S_ProcName = "readAllDefClass";
		if( ( allDefClass == null ) || forceRead ) {
			Map<CFGenKbDefClassPKey, ICFGenKbDefClassObj> map = new HashMap<CFGenKbDefClassPKey,ICFGenKbDefClassObj>();
			allDefClass = map;
			CFGenKbDefClassBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableDefClass().readAllDerived( schema.getAuthorization() );
			CFGenKbDefClassBuff buff;
			ICFGenKbDefClassObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newPKey() );
				obj.setBuff( buff );
				ICFGenKbDefClassObj realised = (ICFGenKbDefClassObj)obj.realise();
			}
		}
		int len = allDefClass.size();
		ICFGenKbDefClassObj arr[] = new ICFGenKbDefClassObj[len];
		Iterator<ICFGenKbDefClassObj> valIter = allDefClass.values().iterator();
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
		ArrayList<ICFGenKbDefClassObj> arrayList = new ArrayList<ICFGenKbDefClassObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbDefClassObj> cmp = new Comparator<ICFGenKbDefClassObj>() {
			public int compare( ICFGenKbDefClassObj lhs, ICFGenKbDefClassObj rhs ) {
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
					CFGenKbDefClassPKey lhsPKey = lhs.getPKey();
					CFGenKbDefClassPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbDefClassObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbDefClassObj readDefClassByIdIdx( short Id )
	{
		return( readDefClassByIdIdx( Id,
			false ) );
	}

	public ICFGenKbDefClassObj readDefClassByIdIdx( short Id, boolean forceRead )
	{
		CFGenKbDefClassPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newPKey();
		pkey.setRequiredId( Id );
		ICFGenKbDefClassObj obj = readDefClass( pkey, forceRead );
		return( obj );
	}

	public ICFGenKbDefClassObj readDefClassByNameIdx( String Name )
	{
		return( readDefClassByNameIdx( Name,
			false ) );
	}

	public ICFGenKbDefClassObj readDefClassByNameIdx( String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFGenKbDefClassByNameIdxKey,
				ICFGenKbDefClassObj >();
		}
		CFGenKbDefClassByNameIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newNameIdxKey();
		key.setRequiredName( Name );
		ICFGenKbDefClassObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			CFGenKbDefClassBuff buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableDefClass().readDerivedByNameIdx( schema.getAuthorization(),
				Name );
			if( buff != null ) {
				obj = schema.getDefClassTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newPKey() );
				obj.setBuff( buff );
				obj = (ICFGenKbDefClassObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFGenKbDefClassObj> readDefClassByBaseIdx( Short BaseId )
	{
		return( readDefClassByBaseIdx( BaseId,
			false ) );
	}

	public List<ICFGenKbDefClassObj> readDefClassByBaseIdx( Short BaseId,
		boolean forceRead )
	{
		final String S_ProcName = "readDefClassByBaseIdx";
		CFGenKbDefClassByBaseIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newBaseIdxKey();
		key.setOptionalBaseId( BaseId );
		Map<CFGenKbDefClassPKey, ICFGenKbDefClassObj> dict;
		if( indexByBaseIdx == null ) {
			indexByBaseIdx = new HashMap< CFGenKbDefClassByBaseIdxKey,
				Map< CFGenKbDefClassPKey, ICFGenKbDefClassObj > >();
		}
		if( ( ! forceRead ) && indexByBaseIdx.containsKey( key ) ) {
			dict = indexByBaseIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbDefClassPKey, ICFGenKbDefClassObj>();
			ICFGenKbDefClassObj obj;
			CFGenKbDefClassBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableDefClass().readDerivedByBaseIdx( schema.getAuthorization(),
				BaseId );
			CFGenKbDefClassBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getDefClassTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newPKey() );
				obj.setBuff( buff );
				ICFGenKbDefClassObj realised = (ICFGenKbDefClassObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByBaseIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbDefClassObj arr[] = new ICFGenKbDefClassObj[len];
		Iterator<ICFGenKbDefClassObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbDefClassObj> arrayList = new ArrayList<ICFGenKbDefClassObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbDefClassObj> cmp = new Comparator<ICFGenKbDefClassObj>() {
			public int compare( ICFGenKbDefClassObj lhs, ICFGenKbDefClassObj rhs ) {
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
					CFGenKbDefClassPKey lhsPKey = lhs.getPKey();
					CFGenKbDefClassPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbDefClassObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbDefClassObj updateDefClass( ICFGenKbDefClassObj Obj ) {
		ICFGenKbDefClassObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableDefClass().updateDefClass( schema.getAuthorization(),
			Obj.getDefClassBuff() );
		obj = (ICFGenKbDefClassObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteDefClass( ICFGenKbDefClassObj Obj ) {
		ICFGenKbDefClassObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableDefClass().deleteDefClass( schema.getAuthorization(),
			obj.getDefClassBuff() );
		obj.forget( true );
	}

	public void deleteDefClassByIdIdx( short Id )
	{
		CFGenKbDefClassPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newPKey();
		pkey.setRequiredId( Id );
		ICFGenKbDefClassObj obj = readDefClass( pkey );
		if( obj != null ) {
			ICFGenKbDefClassEditObj editObj = (ICFGenKbDefClassEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbDefClassEditObj)obj.beginEdit();
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

	public void deleteDefClassByNameIdx( String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFGenKbDefClassByNameIdxKey,
				ICFGenKbDefClassObj >();
		}
		CFGenKbDefClassByNameIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newNameIdxKey();
		key.setRequiredName( Name );
		ICFGenKbDefClassObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableDefClass().deleteDefClassByNameIdx( schema.getAuthorization(),
				Name );
			obj.forget( true );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableDefClass().deleteDefClassByNameIdx( schema.getAuthorization(),
				Name );
		}
	}

	public void deleteDefClassByBaseIdx( Short BaseId )
	{
		CFGenKbDefClassByBaseIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newBaseIdxKey();
		key.setOptionalBaseId( BaseId );
		if( indexByBaseIdx == null ) {
			indexByBaseIdx = new HashMap< CFGenKbDefClassByBaseIdxKey,
				Map< CFGenKbDefClassPKey, ICFGenKbDefClassObj > >();
		}
		if( indexByBaseIdx.containsKey( key ) ) {
			Map<CFGenKbDefClassPKey, ICFGenKbDefClassObj> dict = indexByBaseIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableDefClass().deleteDefClassByBaseIdx( schema.getAuthorization(),
				BaseId );
			Iterator<ICFGenKbDefClassObj> iter = dict.values().iterator();
			ICFGenKbDefClassObj obj;
			List<ICFGenKbDefClassObj> toForget = new LinkedList<ICFGenKbDefClassObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByBaseIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableDefClass().deleteDefClassByBaseIdx( schema.getAuthorization(),
				BaseId );
		}
	}
}
