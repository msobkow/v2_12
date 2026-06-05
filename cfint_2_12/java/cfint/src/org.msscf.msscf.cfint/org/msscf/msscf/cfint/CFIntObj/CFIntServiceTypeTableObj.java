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

public class CFIntServiceTypeTableObj
	implements ICFIntServiceTypeTableObj
{
	protected ICFSecSchemaObj schema;
	private Map<CFSecServiceTypePKey, ICFSecServiceTypeObj> members;
	private Map<CFSecServiceTypePKey, ICFSecServiceTypeObj> allServiceType;
	private Map< CFSecServiceTypeByUDescrIdxKey,
		ICFSecServiceTypeObj > indexByUDescrIdx;
	public static String TABLE_NAME = "ServiceType";
	public static String TABLE_DBNAME = "svctype";

	public CFIntServiceTypeTableObj() {
		schema = null;
		members = new HashMap<CFSecServiceTypePKey, ICFSecServiceTypeObj>();
		allServiceType = null;
		indexByUDescrIdx = null;
	}

	public CFIntServiceTypeTableObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFSecServiceTypePKey, ICFSecServiceTypeObj>();
		allServiceType = null;
		indexByUDescrIdx = null;
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
		allServiceType = null;
		indexByUDescrIdx = null;
		List<ICFSecServiceTypeObj> toForget = new LinkedList<ICFSecServiceTypeObj>();
		ICFSecServiceTypeObj cur = null;
		Iterator<ICFSecServiceTypeObj> iter = members.values().iterator();
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
	 *	CFIntServiceTypeObj.
	 */
	public ICFSecServiceTypeObj newInstance() {
		ICFSecServiceTypeObj inst = new CFIntServiceTypeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFIntServiceTypeObj.
	 */
	public ICFSecServiceTypeEditObj newEditInstance( ICFSecServiceTypeObj orig ) {
		ICFSecServiceTypeEditObj edit = new CFIntServiceTypeEditObj( orig );
		return( edit );
	}

	public ICFSecServiceTypeObj realiseServiceType( ICFSecServiceTypeObj Obj ) {
		ICFSecServiceTypeObj obj = Obj;
		CFSecServiceTypePKey pkey = obj.getPKey();
		ICFSecServiceTypeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFSecServiceTypeObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUDescrIdx != null ) {
				CFSecServiceTypeByUDescrIdxKey keyUDescrIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryServiceType().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.remove( keyUDescrIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUDescrIdx != null ) {
				CFSecServiceTypeByUDescrIdxKey keyUDescrIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryServiceType().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.put( keyUDescrIdx, keepObj );
			}

			if( allServiceType != null ) {
				allServiceType.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allServiceType != null ) {
				allServiceType.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUDescrIdx != null ) {
				CFSecServiceTypeByUDescrIdxKey keyUDescrIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryServiceType().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.put( keyUDescrIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetServiceType( ICFSecServiceTypeObj Obj ) {
		forgetServiceType( Obj, false );
	}

	public void forgetServiceType( ICFSecServiceTypeObj Obj, boolean forgetSubObjects ) {
		ICFSecServiceTypeObj obj = Obj;
		CFSecServiceTypePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFSecServiceTypeObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUDescrIdx != null ) {
				CFSecServiceTypeByUDescrIdxKey keyUDescrIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryServiceType().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.remove( keyUDescrIdx );
			}

			if( allServiceType != null ) {
				allServiceType.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFSecSchemaObj)schema).getServiceTableObj().forgetServiceByTypeIdx( keepObj.getRequiredServiceTypeId() );
			}
		}
	}

	public void forgetServiceTypeByIdIdx( int ServiceTypeId )
	{
		if( members == null ) {
			return;
		}
		CFSecServiceTypePKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryServiceType().newPKey();
		key.setRequiredServiceTypeId( ServiceTypeId );
		if( members.containsKey( key ) ) {
			ICFSecServiceTypeObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetServiceTypeByUDescrIdx( String Description )
	{
		if( indexByUDescrIdx == null ) {
			return;
		}
		List<ICFSecServiceTypeObj> toForget = new LinkedList<ICFSecServiceTypeObj>();
		ICFSecServiceTypeObj cur = null;
		CFSecServiceTypeByUDescrIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryServiceType().newUDescrIdxKey();
		key.setRequiredDescription( Description );
		if( indexByUDescrIdx.containsKey( key ) ) {
			cur = indexByUDescrIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFSecServiceTypeObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFSecServiceTypeObj createServiceType( ICFSecServiceTypeObj Obj ) {
		ICFSecServiceTypeObj obj = Obj;
		CFSecServiceTypeBuff buff = obj.getServiceTypeBuff();
		((ICFIntSchema)schema.getBackingStore()).getTableServiceType().createServiceType(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFSecServiceTypeObj readServiceType( CFSecServiceTypePKey pkey ) {
		return( readServiceType( pkey, false ) );
	}

	public ICFSecServiceTypeObj readServiceType( CFSecServiceTypePKey pkey, boolean forceRead ) {
		ICFSecServiceTypeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFSecServiceTypeBuff readBuff = ((ICFIntSchema)schema.getBackingStore()).getTableServiceType().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredServiceTypeId() );
			if( readBuff != null ) {
				obj = schema.getServiceTypeTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryServiceType().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFSecServiceTypeObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecServiceTypeObj lockServiceType( CFSecServiceTypePKey pkey ) {
		ICFSecServiceTypeObj locked = null;
		CFSecServiceTypeBuff lockBuff = ((ICFIntSchema)schema.getBackingStore()).getTableServiceType().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getServiceTypeTableObj().newInstance();
			locked.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryServiceType().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFSecServiceTypeObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockServiceType", pkey );
		}
		return( locked );
	}

	public List<ICFSecServiceTypeObj> readAllServiceType() {
		return( readAllServiceType( false ) );
	}

	public List<ICFSecServiceTypeObj> readAllServiceType( boolean forceRead ) {
		final String S_ProcName = "readAllServiceType";
		if( ( allServiceType == null ) || forceRead ) {
			Map<CFSecServiceTypePKey, ICFSecServiceTypeObj> map = new HashMap<CFSecServiceTypePKey,ICFSecServiceTypeObj>();
			allServiceType = map;
			CFSecServiceTypeBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableServiceType().readAllDerived( schema.getAuthorization() );
			CFSecServiceTypeBuff buff;
			ICFSecServiceTypeObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryServiceType().newPKey() );
				obj.setBuff( buff );
				ICFSecServiceTypeObj realised = (ICFSecServiceTypeObj)obj.realise();
			}
		}
		int len = allServiceType.size();
		ICFSecServiceTypeObj arr[] = new ICFSecServiceTypeObj[len];
		Iterator<ICFSecServiceTypeObj> valIter = allServiceType.values().iterator();
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
		ArrayList<ICFSecServiceTypeObj> arrayList = new ArrayList<ICFSecServiceTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecServiceTypeObj> cmp = new Comparator<ICFSecServiceTypeObj>() {
			public int compare( ICFSecServiceTypeObj lhs, ICFSecServiceTypeObj rhs ) {
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
					CFSecServiceTypePKey lhsPKey = lhs.getPKey();
					CFSecServiceTypePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecServiceTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecServiceTypeObj readServiceTypeByIdIdx( int ServiceTypeId )
	{
		return( readServiceTypeByIdIdx( ServiceTypeId,
			false ) );
	}

	public ICFSecServiceTypeObj readServiceTypeByIdIdx( int ServiceTypeId, boolean forceRead )
	{
		CFSecServiceTypePKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryServiceType().newPKey();
		pkey.setRequiredServiceTypeId( ServiceTypeId );
		ICFSecServiceTypeObj obj = readServiceType( pkey, forceRead );
		return( obj );
	}

	public ICFSecServiceTypeObj readServiceTypeByUDescrIdx( String Description )
	{
		return( readServiceTypeByUDescrIdx( Description,
			false ) );
	}

	public ICFSecServiceTypeObj readServiceTypeByUDescrIdx( String Description, boolean forceRead )
	{
		if( indexByUDescrIdx == null ) {
			indexByUDescrIdx = new HashMap< CFSecServiceTypeByUDescrIdxKey,
				ICFSecServiceTypeObj >();
		}
		CFSecServiceTypeByUDescrIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryServiceType().newUDescrIdxKey();
		key.setRequiredDescription( Description );
		ICFSecServiceTypeObj obj = null;
		if( ( ! forceRead ) && indexByUDescrIdx.containsKey( key ) ) {
			obj = indexByUDescrIdx.get( key );
		}
		else {
			CFSecServiceTypeBuff buff = ((ICFIntSchema)schema.getBackingStore()).getTableServiceType().readDerivedByUDescrIdx( schema.getAuthorization(),
				Description );
			if( buff != null ) {
				obj = schema.getServiceTypeTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryServiceType().newPKey() );
				obj.setBuff( buff );
				obj = (ICFSecServiceTypeObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecServiceTypeObj updateServiceType( ICFSecServiceTypeObj Obj ) {
		ICFSecServiceTypeObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableServiceType().updateServiceType( schema.getAuthorization(),
			Obj.getServiceTypeBuff() );
		obj = (ICFSecServiceTypeObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteServiceType( ICFSecServiceTypeObj Obj ) {
		ICFSecServiceTypeObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableServiceType().deleteServiceType( schema.getAuthorization(),
			obj.getServiceTypeBuff() );
		obj.forget( true );
	}

	public void deleteServiceTypeByIdIdx( int ServiceTypeId )
	{
		CFSecServiceTypePKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryServiceType().newPKey();
		pkey.setRequiredServiceTypeId( ServiceTypeId );
		ICFSecServiceTypeObj obj = readServiceType( pkey );
		if( obj != null ) {
			ICFSecServiceTypeEditObj editObj = (ICFSecServiceTypeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFSecServiceTypeEditObj)obj.beginEdit();
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

	public void deleteServiceTypeByUDescrIdx( String Description )
	{
		if( indexByUDescrIdx == null ) {
			indexByUDescrIdx = new HashMap< CFSecServiceTypeByUDescrIdxKey,
				ICFSecServiceTypeObj >();
		}
		CFSecServiceTypeByUDescrIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryServiceType().newUDescrIdxKey();
		key.setRequiredDescription( Description );
		ICFSecServiceTypeObj obj = null;
		if( indexByUDescrIdx.containsKey( key ) ) {
			obj = indexByUDescrIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableServiceType().deleteServiceTypeByUDescrIdx( schema.getAuthorization(),
				Description );
			obj.forget( true );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableServiceType().deleteServiceTypeByUDescrIdx( schema.getAuthorization(),
				Description );
		}
	}
}
