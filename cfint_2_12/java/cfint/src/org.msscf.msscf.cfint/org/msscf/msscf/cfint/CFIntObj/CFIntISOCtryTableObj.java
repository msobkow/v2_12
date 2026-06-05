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

public class CFIntISOCtryTableObj
	implements ICFIntISOCtryTableObj
{
	protected ICFSecSchemaObj schema;
	private Map<CFSecISOCtryPKey, ICFSecISOCtryObj> members;
	private Map<CFSecISOCtryPKey, ICFSecISOCtryObj> allISOCtry;
	private Map< CFSecISOCtryByISOCodeIdxKey,
		ICFSecISOCtryObj > indexByISOCodeIdx;
	private Map< CFSecISOCtryByNameIdxKey,
		ICFSecISOCtryObj > indexByNameIdx;
	public static String TABLE_NAME = "ISOCtry";
	public static String TABLE_DBNAME = "iso_cntry";

	public CFIntISOCtryTableObj() {
		schema = null;
		members = new HashMap<CFSecISOCtryPKey, ICFSecISOCtryObj>();
		allISOCtry = null;
		indexByISOCodeIdx = null;
		indexByNameIdx = null;
	}

	public CFIntISOCtryTableObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFSecISOCtryPKey, ICFSecISOCtryObj>();
		allISOCtry = null;
		indexByISOCodeIdx = null;
		indexByNameIdx = null;
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
		allISOCtry = null;
		indexByISOCodeIdx = null;
		indexByNameIdx = null;
		List<ICFSecISOCtryObj> toForget = new LinkedList<ICFSecISOCtryObj>();
		ICFSecISOCtryObj cur = null;
		Iterator<ICFSecISOCtryObj> iter = members.values().iterator();
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
	 *	CFIntISOCtryObj.
	 */
	public ICFSecISOCtryObj newInstance() {
		ICFSecISOCtryObj inst = new CFIntISOCtryObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFIntISOCtryObj.
	 */
	public ICFSecISOCtryEditObj newEditInstance( ICFSecISOCtryObj orig ) {
		ICFSecISOCtryEditObj edit = new CFIntISOCtryEditObj( orig );
		return( edit );
	}

	public ICFSecISOCtryObj realiseISOCtry( ICFSecISOCtryObj Obj ) {
		ICFSecISOCtryObj obj = Obj;
		CFSecISOCtryPKey pkey = obj.getPKey();
		ICFSecISOCtryObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFSecISOCtryObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByISOCodeIdx != null ) {
				CFSecISOCtryByISOCodeIdxKey keyISOCodeIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newISOCodeIdxKey();
				keyISOCodeIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByISOCodeIdx.remove( keyISOCodeIdx );
			}

			if( indexByNameIdx != null ) {
				CFSecISOCtryByNameIdxKey keyNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByISOCodeIdx != null ) {
				CFSecISOCtryByISOCodeIdxKey keyISOCodeIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newISOCodeIdxKey();
				keyISOCodeIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByISOCodeIdx.put( keyISOCodeIdx, keepObj );
			}

			if( indexByNameIdx != null ) {
				CFSecISOCtryByNameIdxKey keyNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

			if( allISOCtry != null ) {
				allISOCtry.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allISOCtry != null ) {
				allISOCtry.put( keepObj.getPKey(), keepObj );
			}

			if( indexByISOCodeIdx != null ) {
				CFSecISOCtryByISOCodeIdxKey keyISOCodeIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newISOCodeIdxKey();
				keyISOCodeIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByISOCodeIdx.put( keyISOCodeIdx, keepObj );
			}

			if( indexByNameIdx != null ) {
				CFSecISOCtryByNameIdxKey keyNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetISOCtry( ICFSecISOCtryObj Obj ) {
		forgetISOCtry( Obj, false );
	}

	public void forgetISOCtry( ICFSecISOCtryObj Obj, boolean forgetSubObjects ) {
		ICFSecISOCtryObj obj = Obj;
		CFSecISOCtryPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFSecISOCtryObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByISOCodeIdx != null ) {
				CFSecISOCtryByISOCodeIdxKey keyISOCodeIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newISOCodeIdxKey();
				keyISOCodeIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByISOCodeIdx.remove( keyISOCodeIdx );
			}

			if( indexByNameIdx != null ) {
				CFSecISOCtryByNameIdxKey keyNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( allISOCtry != null ) {
				allISOCtry.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFSecSchemaObj)schema).getISOCtryCcyTableObj().forgetISOCtryCcyByCtryIdx( keepObj.getRequiredISOCtryId() );
				((ICFSecSchemaObj)schema).getISOCtryLangTableObj().forgetISOCtryLangByCtryIdx( keepObj.getRequiredISOCtryId() );
			}
		}
	}

	public void forgetISOCtryByIdIdx( short ISOCtryId )
	{
		if( members == null ) {
			return;
		}
		CFSecISOCtryPKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newPKey();
		key.setRequiredISOCtryId( ISOCtryId );
		if( members.containsKey( key ) ) {
			ICFSecISOCtryObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetISOCtryByISOCodeIdx( String ISOCode )
	{
		if( indexByISOCodeIdx == null ) {
			return;
		}
		List<ICFSecISOCtryObj> toForget = new LinkedList<ICFSecISOCtryObj>();
		ICFSecISOCtryObj cur = null;
		CFSecISOCtryByISOCodeIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newISOCodeIdxKey();
		key.setRequiredISOCode( ISOCode );
		if( indexByISOCodeIdx.containsKey( key ) ) {
			cur = indexByISOCodeIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFSecISOCtryObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetISOCtryByNameIdx( String Name )
	{
		if( indexByNameIdx == null ) {
			return;
		}
		List<ICFSecISOCtryObj> toForget = new LinkedList<ICFSecISOCtryObj>();
		ICFSecISOCtryObj cur = null;
		CFSecISOCtryByNameIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newNameIdxKey();
		key.setRequiredName( Name );
		if( indexByNameIdx.containsKey( key ) ) {
			cur = indexByNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFSecISOCtryObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFSecISOCtryObj createISOCtry( ICFSecISOCtryObj Obj ) {
		ICFSecISOCtryObj obj = Obj;
		CFSecISOCtryBuff buff = obj.getISOCtryBuff();
		((ICFIntSchema)schema.getBackingStore()).getTableISOCtry().createISOCtry(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFSecISOCtryObj readISOCtry( CFSecISOCtryPKey pkey ) {
		return( readISOCtry( pkey, false ) );
	}

	public ICFSecISOCtryObj readISOCtry( CFSecISOCtryPKey pkey, boolean forceRead ) {
		ICFSecISOCtryObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFSecISOCtryBuff readBuff = ((ICFIntSchema)schema.getBackingStore()).getTableISOCtry().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredISOCtryId() );
			if( readBuff != null ) {
				obj = schema.getISOCtryTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFSecISOCtryObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecISOCtryObj lockISOCtry( CFSecISOCtryPKey pkey ) {
		ICFSecISOCtryObj locked = null;
		CFSecISOCtryBuff lockBuff = ((ICFIntSchema)schema.getBackingStore()).getTableISOCtry().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getISOCtryTableObj().newInstance();
			locked.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFSecISOCtryObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockISOCtry", pkey );
		}
		return( locked );
	}

	public List<ICFSecISOCtryObj> readAllISOCtry() {
		return( readAllISOCtry( false ) );
	}

	public List<ICFSecISOCtryObj> readAllISOCtry( boolean forceRead ) {
		final String S_ProcName = "readAllISOCtry";
		if( ( allISOCtry == null ) || forceRead ) {
			Map<CFSecISOCtryPKey, ICFSecISOCtryObj> map = new HashMap<CFSecISOCtryPKey,ICFSecISOCtryObj>();
			allISOCtry = map;
			CFSecISOCtryBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableISOCtry().readAllDerived( schema.getAuthorization() );
			CFSecISOCtryBuff buff;
			ICFSecISOCtryObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newPKey() );
				obj.setBuff( buff );
				ICFSecISOCtryObj realised = (ICFSecISOCtryObj)obj.realise();
			}
		}
		int len = allISOCtry.size();
		ICFSecISOCtryObj arr[] = new ICFSecISOCtryObj[len];
		Iterator<ICFSecISOCtryObj> valIter = allISOCtry.values().iterator();
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
		ArrayList<ICFSecISOCtryObj> arrayList = new ArrayList<ICFSecISOCtryObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecISOCtryObj> cmp = new Comparator<ICFSecISOCtryObj>() {
			public int compare( ICFSecISOCtryObj lhs, ICFSecISOCtryObj rhs ) {
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
					CFSecISOCtryPKey lhsPKey = lhs.getPKey();
					CFSecISOCtryPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecISOCtryObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecISOCtryObj readISOCtryByIdIdx( short ISOCtryId )
	{
		return( readISOCtryByIdIdx( ISOCtryId,
			false ) );
	}

	public ICFSecISOCtryObj readISOCtryByIdIdx( short ISOCtryId, boolean forceRead )
	{
		CFSecISOCtryPKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newPKey();
		pkey.setRequiredISOCtryId( ISOCtryId );
		ICFSecISOCtryObj obj = readISOCtry( pkey, forceRead );
		return( obj );
	}

	public ICFSecISOCtryObj readISOCtryByISOCodeIdx( String ISOCode )
	{
		return( readISOCtryByISOCodeIdx( ISOCode,
			false ) );
	}

	public ICFSecISOCtryObj readISOCtryByISOCodeIdx( String ISOCode, boolean forceRead )
	{
		if( indexByISOCodeIdx == null ) {
			indexByISOCodeIdx = new HashMap< CFSecISOCtryByISOCodeIdxKey,
				ICFSecISOCtryObj >();
		}
		CFSecISOCtryByISOCodeIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newISOCodeIdxKey();
		key.setRequiredISOCode( ISOCode );
		ICFSecISOCtryObj obj = null;
		if( ( ! forceRead ) && indexByISOCodeIdx.containsKey( key ) ) {
			obj = indexByISOCodeIdx.get( key );
		}
		else {
			CFSecISOCtryBuff buff = ((ICFIntSchema)schema.getBackingStore()).getTableISOCtry().readDerivedByISOCodeIdx( schema.getAuthorization(),
				ISOCode );
			if( buff != null ) {
				obj = schema.getISOCtryTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newPKey() );
				obj.setBuff( buff );
				obj = (ICFSecISOCtryObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecISOCtryObj readISOCtryByNameIdx( String Name )
	{
		return( readISOCtryByNameIdx( Name,
			false ) );
	}

	public ICFSecISOCtryObj readISOCtryByNameIdx( String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFSecISOCtryByNameIdxKey,
				ICFSecISOCtryObj >();
		}
		CFSecISOCtryByNameIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newNameIdxKey();
		key.setRequiredName( Name );
		ICFSecISOCtryObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			CFSecISOCtryBuff buff = ((ICFIntSchema)schema.getBackingStore()).getTableISOCtry().readDerivedByNameIdx( schema.getAuthorization(),
				Name );
			if( buff != null ) {
				obj = schema.getISOCtryTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newPKey() );
				obj.setBuff( buff );
				obj = (ICFSecISOCtryObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecISOCtryObj updateISOCtry( ICFSecISOCtryObj Obj ) {
		ICFSecISOCtryObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableISOCtry().updateISOCtry( schema.getAuthorization(),
			Obj.getISOCtryBuff() );
		obj = (ICFSecISOCtryObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteISOCtry( ICFSecISOCtryObj Obj ) {
		ICFSecISOCtryObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableISOCtry().deleteISOCtry( schema.getAuthorization(),
			obj.getISOCtryBuff() );
		obj.forget( true );
	}

	public void deleteISOCtryByIdIdx( short ISOCtryId )
	{
		CFSecISOCtryPKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newPKey();
		pkey.setRequiredISOCtryId( ISOCtryId );
		ICFSecISOCtryObj obj = readISOCtry( pkey );
		if( obj != null ) {
			ICFSecISOCtryEditObj editObj = (ICFSecISOCtryEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFSecISOCtryEditObj)obj.beginEdit();
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

	public void deleteISOCtryByISOCodeIdx( String ISOCode )
	{
		if( indexByISOCodeIdx == null ) {
			indexByISOCodeIdx = new HashMap< CFSecISOCtryByISOCodeIdxKey,
				ICFSecISOCtryObj >();
		}
		CFSecISOCtryByISOCodeIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newISOCodeIdxKey();
		key.setRequiredISOCode( ISOCode );
		ICFSecISOCtryObj obj = null;
		if( indexByISOCodeIdx.containsKey( key ) ) {
			obj = indexByISOCodeIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableISOCtry().deleteISOCtryByISOCodeIdx( schema.getAuthorization(),
				ISOCode );
			obj.forget( true );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableISOCtry().deleteISOCtryByISOCodeIdx( schema.getAuthorization(),
				ISOCode );
		}
	}

	public void deleteISOCtryByNameIdx( String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFSecISOCtryByNameIdxKey,
				ICFSecISOCtryObj >();
		}
		CFSecISOCtryByNameIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOCtry().newNameIdxKey();
		key.setRequiredName( Name );
		ICFSecISOCtryObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableISOCtry().deleteISOCtryByNameIdx( schema.getAuthorization(),
				Name );
			obj.forget( true );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableISOCtry().deleteISOCtryByNameIdx( schema.getAuthorization(),
				Name );
		}
	}
}
