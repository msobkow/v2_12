// Description: Java 11 Table Object implementation for CFBam.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamISOCcyTableObj
	implements ICFBamISOCcyTableObj
{
	protected ICFSecSchemaObj schema;
	private Map<CFSecISOCcyPKey, ICFSecISOCcyObj> members;
	private Map<CFSecISOCcyPKey, ICFSecISOCcyObj> allISOCcy;
	private Map< CFSecISOCcyByCcyCdIdxKey,
		ICFSecISOCcyObj > indexByCcyCdIdx;
	private Map< CFSecISOCcyByCcyNmIdxKey,
		ICFSecISOCcyObj > indexByCcyNmIdx;
	public static String TABLE_NAME = "ISOCcy";
	public static String TABLE_DBNAME = "iso_ccy";

	public CFBamISOCcyTableObj() {
		schema = null;
		members = new HashMap<CFSecISOCcyPKey, ICFSecISOCcyObj>();
		allISOCcy = null;
		indexByCcyCdIdx = null;
		indexByCcyNmIdx = null;
	}

	public CFBamISOCcyTableObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFSecISOCcyPKey, ICFSecISOCcyObj>();
		allISOCcy = null;
		indexByCcyCdIdx = null;
		indexByCcyNmIdx = null;
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
		allISOCcy = null;
		indexByCcyCdIdx = null;
		indexByCcyNmIdx = null;
		List<ICFSecISOCcyObj> toForget = new LinkedList<ICFSecISOCcyObj>();
		ICFSecISOCcyObj cur = null;
		Iterator<ICFSecISOCcyObj> iter = members.values().iterator();
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
	 *	CFBamISOCcyObj.
	 */
	public ICFSecISOCcyObj newInstance() {
		ICFSecISOCcyObj inst = new CFBamISOCcyObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamISOCcyObj.
	 */
	public ICFSecISOCcyEditObj newEditInstance( ICFSecISOCcyObj orig ) {
		ICFSecISOCcyEditObj edit = new CFBamISOCcyEditObj( orig );
		return( edit );
	}

	public ICFSecISOCcyObj realiseISOCcy( ICFSecISOCcyObj Obj ) {
		ICFSecISOCcyObj obj = Obj;
		CFSecISOCcyPKey pkey = obj.getPKey();
		ICFSecISOCcyObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFSecISOCcyObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByCcyCdIdx != null ) {
				CFSecISOCcyByCcyCdIdxKey keyCcyCdIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newCcyCdIdxKey();
				keyCcyCdIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByCcyCdIdx.remove( keyCcyCdIdx );
			}

			if( indexByCcyNmIdx != null ) {
				CFSecISOCcyByCcyNmIdxKey keyCcyNmIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newCcyNmIdxKey();
				keyCcyNmIdx.setRequiredName( keepObj.getRequiredName() );
				indexByCcyNmIdx.remove( keyCcyNmIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByCcyCdIdx != null ) {
				CFSecISOCcyByCcyCdIdxKey keyCcyCdIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newCcyCdIdxKey();
				keyCcyCdIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByCcyCdIdx.put( keyCcyCdIdx, keepObj );
			}

			if( indexByCcyNmIdx != null ) {
				CFSecISOCcyByCcyNmIdxKey keyCcyNmIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newCcyNmIdxKey();
				keyCcyNmIdx.setRequiredName( keepObj.getRequiredName() );
				indexByCcyNmIdx.put( keyCcyNmIdx, keepObj );
			}

			if( allISOCcy != null ) {
				allISOCcy.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allISOCcy != null ) {
				allISOCcy.put( keepObj.getPKey(), keepObj );
			}

			if( indexByCcyCdIdx != null ) {
				CFSecISOCcyByCcyCdIdxKey keyCcyCdIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newCcyCdIdxKey();
				keyCcyCdIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByCcyCdIdx.put( keyCcyCdIdx, keepObj );
			}

			if( indexByCcyNmIdx != null ) {
				CFSecISOCcyByCcyNmIdxKey keyCcyNmIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newCcyNmIdxKey();
				keyCcyNmIdx.setRequiredName( keepObj.getRequiredName() );
				indexByCcyNmIdx.put( keyCcyNmIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetISOCcy( ICFSecISOCcyObj Obj ) {
		forgetISOCcy( Obj, false );
	}

	public void forgetISOCcy( ICFSecISOCcyObj Obj, boolean forgetSubObjects ) {
		ICFSecISOCcyObj obj = Obj;
		CFSecISOCcyPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFSecISOCcyObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByCcyCdIdx != null ) {
				CFSecISOCcyByCcyCdIdxKey keyCcyCdIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newCcyCdIdxKey();
				keyCcyCdIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByCcyCdIdx.remove( keyCcyCdIdx );
			}

			if( indexByCcyNmIdx != null ) {
				CFSecISOCcyByCcyNmIdxKey keyCcyNmIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newCcyNmIdxKey();
				keyCcyNmIdx.setRequiredName( keepObj.getRequiredName() );
				indexByCcyNmIdx.remove( keyCcyNmIdx );
			}

			if( allISOCcy != null ) {
				allISOCcy.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFSecSchemaObj)schema).getISOCtryCcyTableObj().forgetISOCtryCcyByCcyIdx( keepObj.getRequiredISOCcyId() );
			}
		}
	}

	public void forgetISOCcyByIdIdx( short ISOCcyId )
	{
		if( members == null ) {
			return;
		}
		CFSecISOCcyPKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newPKey();
		key.setRequiredISOCcyId( ISOCcyId );
		if( members.containsKey( key ) ) {
			ICFSecISOCcyObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetISOCcyByCcyCdIdx( String ISOCode )
	{
		if( indexByCcyCdIdx == null ) {
			return;
		}
		List<ICFSecISOCcyObj> toForget = new LinkedList<ICFSecISOCcyObj>();
		ICFSecISOCcyObj cur = null;
		CFSecISOCcyByCcyCdIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newCcyCdIdxKey();
		key.setRequiredISOCode( ISOCode );
		if( indexByCcyCdIdx.containsKey( key ) ) {
			cur = indexByCcyCdIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFSecISOCcyObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetISOCcyByCcyNmIdx( String Name )
	{
		if( indexByCcyNmIdx == null ) {
			return;
		}
		List<ICFSecISOCcyObj> toForget = new LinkedList<ICFSecISOCcyObj>();
		ICFSecISOCcyObj cur = null;
		CFSecISOCcyByCcyNmIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newCcyNmIdxKey();
		key.setRequiredName( Name );
		if( indexByCcyNmIdx.containsKey( key ) ) {
			cur = indexByCcyNmIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFSecISOCcyObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFSecISOCcyObj createISOCcy( ICFSecISOCcyObj Obj ) {
		ICFSecISOCcyObj obj = Obj;
		CFSecISOCcyBuff buff = obj.getISOCcyBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableISOCcy().createISOCcy(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFSecISOCcyObj readISOCcy( CFSecISOCcyPKey pkey ) {
		return( readISOCcy( pkey, false ) );
	}

	public ICFSecISOCcyObj readISOCcy( CFSecISOCcyPKey pkey, boolean forceRead ) {
		ICFSecISOCcyObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFSecISOCcyBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableISOCcy().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredISOCcyId() );
			if( readBuff != null ) {
				obj = schema.getISOCcyTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFSecISOCcyObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecISOCcyObj lockISOCcy( CFSecISOCcyPKey pkey ) {
		ICFSecISOCcyObj locked = null;
		CFSecISOCcyBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableISOCcy().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getISOCcyTableObj().newInstance();
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFSecISOCcyObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockISOCcy", pkey );
		}
		return( locked );
	}

	public List<ICFSecISOCcyObj> readAllISOCcy() {
		return( readAllISOCcy( false ) );
	}

	public List<ICFSecISOCcyObj> readAllISOCcy( boolean forceRead ) {
		final String S_ProcName = "readAllISOCcy";
		if( ( allISOCcy == null ) || forceRead ) {
			Map<CFSecISOCcyPKey, ICFSecISOCcyObj> map = new HashMap<CFSecISOCcyPKey,ICFSecISOCcyObj>();
			allISOCcy = map;
			CFSecISOCcyBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableISOCcy().readAllDerived( schema.getAuthorization() );
			CFSecISOCcyBuff buff;
			ICFSecISOCcyObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newPKey() );
				obj.setBuff( buff );
				ICFSecISOCcyObj realised = (ICFSecISOCcyObj)obj.realise();
			}
		}
		int len = allISOCcy.size();
		ICFSecISOCcyObj arr[] = new ICFSecISOCcyObj[len];
		Iterator<ICFSecISOCcyObj> valIter = allISOCcy.values().iterator();
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
		ArrayList<ICFSecISOCcyObj> arrayList = new ArrayList<ICFSecISOCcyObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecISOCcyObj> cmp = new Comparator<ICFSecISOCcyObj>() {
			public int compare( ICFSecISOCcyObj lhs, ICFSecISOCcyObj rhs ) {
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
					CFSecISOCcyPKey lhsPKey = lhs.getPKey();
					CFSecISOCcyPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecISOCcyObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecISOCcyObj readISOCcyByIdIdx( short ISOCcyId )
	{
		return( readISOCcyByIdIdx( ISOCcyId,
			false ) );
	}

	public ICFSecISOCcyObj readISOCcyByIdIdx( short ISOCcyId, boolean forceRead )
	{
		CFSecISOCcyPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newPKey();
		pkey.setRequiredISOCcyId( ISOCcyId );
		ICFSecISOCcyObj obj = readISOCcy( pkey, forceRead );
		return( obj );
	}

	public ICFSecISOCcyObj readISOCcyByCcyCdIdx( String ISOCode )
	{
		return( readISOCcyByCcyCdIdx( ISOCode,
			false ) );
	}

	public ICFSecISOCcyObj readISOCcyByCcyCdIdx( String ISOCode, boolean forceRead )
	{
		if( indexByCcyCdIdx == null ) {
			indexByCcyCdIdx = new HashMap< CFSecISOCcyByCcyCdIdxKey,
				ICFSecISOCcyObj >();
		}
		CFSecISOCcyByCcyCdIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newCcyCdIdxKey();
		key.setRequiredISOCode( ISOCode );
		ICFSecISOCcyObj obj = null;
		if( ( ! forceRead ) && indexByCcyCdIdx.containsKey( key ) ) {
			obj = indexByCcyCdIdx.get( key );
		}
		else {
			CFSecISOCcyBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableISOCcy().readDerivedByCcyCdIdx( schema.getAuthorization(),
				ISOCode );
			if( buff != null ) {
				obj = schema.getISOCcyTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newPKey() );
				obj.setBuff( buff );
				obj = (ICFSecISOCcyObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecISOCcyObj readISOCcyByCcyNmIdx( String Name )
	{
		return( readISOCcyByCcyNmIdx( Name,
			false ) );
	}

	public ICFSecISOCcyObj readISOCcyByCcyNmIdx( String Name, boolean forceRead )
	{
		if( indexByCcyNmIdx == null ) {
			indexByCcyNmIdx = new HashMap< CFSecISOCcyByCcyNmIdxKey,
				ICFSecISOCcyObj >();
		}
		CFSecISOCcyByCcyNmIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newCcyNmIdxKey();
		key.setRequiredName( Name );
		ICFSecISOCcyObj obj = null;
		if( ( ! forceRead ) && indexByCcyNmIdx.containsKey( key ) ) {
			obj = indexByCcyNmIdx.get( key );
		}
		else {
			CFSecISOCcyBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableISOCcy().readDerivedByCcyNmIdx( schema.getAuthorization(),
				Name );
			if( buff != null ) {
				obj = schema.getISOCcyTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newPKey() );
				obj.setBuff( buff );
				obj = (ICFSecISOCcyObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecISOCcyObj updateISOCcy( ICFSecISOCcyObj Obj ) {
		ICFSecISOCcyObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableISOCcy().updateISOCcy( schema.getAuthorization(),
			Obj.getISOCcyBuff() );
		obj = (ICFSecISOCcyObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteISOCcy( ICFSecISOCcyObj Obj ) {
		ICFSecISOCcyObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableISOCcy().deleteISOCcy( schema.getAuthorization(),
			obj.getISOCcyBuff() );
		obj.forget( true );
	}

	public void deleteISOCcyByIdIdx( short ISOCcyId )
	{
		CFSecISOCcyPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newPKey();
		pkey.setRequiredISOCcyId( ISOCcyId );
		ICFSecISOCcyObj obj = readISOCcy( pkey );
		if( obj != null ) {
			ICFSecISOCcyEditObj editObj = (ICFSecISOCcyEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFSecISOCcyEditObj)obj.beginEdit();
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

	public void deleteISOCcyByCcyCdIdx( String ISOCode )
	{
		if( indexByCcyCdIdx == null ) {
			indexByCcyCdIdx = new HashMap< CFSecISOCcyByCcyCdIdxKey,
				ICFSecISOCcyObj >();
		}
		CFSecISOCcyByCcyCdIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newCcyCdIdxKey();
		key.setRequiredISOCode( ISOCode );
		ICFSecISOCcyObj obj = null;
		if( indexByCcyCdIdx.containsKey( key ) ) {
			obj = indexByCcyCdIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableISOCcy().deleteISOCcyByCcyCdIdx( schema.getAuthorization(),
				ISOCode );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableISOCcy().deleteISOCcyByCcyCdIdx( schema.getAuthorization(),
				ISOCode );
		}
	}

	public void deleteISOCcyByCcyNmIdx( String Name )
	{
		if( indexByCcyNmIdx == null ) {
			indexByCcyNmIdx = new HashMap< CFSecISOCcyByCcyNmIdxKey,
				ICFSecISOCcyObj >();
		}
		CFSecISOCcyByCcyNmIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOCcy().newCcyNmIdxKey();
		key.setRequiredName( Name );
		ICFSecISOCcyObj obj = null;
		if( indexByCcyNmIdx.containsKey( key ) ) {
			obj = indexByCcyNmIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableISOCcy().deleteISOCcyByCcyNmIdx( schema.getAuthorization(),
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableISOCcy().deleteISOCcyByCcyNmIdx( schema.getAuthorization(),
				Name );
		}
	}
}
