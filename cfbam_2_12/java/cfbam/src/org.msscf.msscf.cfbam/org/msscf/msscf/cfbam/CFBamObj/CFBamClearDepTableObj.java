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

public class CFBamClearDepTableObj
	implements ICFBamClearDepTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamClearDepObj> members;
	private Map<CFBamScopePKey, ICFBamClearDepObj> allClearDep;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamClearDepObj > > indexByTenantIdx;
	private Map< CFBamClearDepByClearDepIdxKey,
		Map<CFBamScopePKey, ICFBamClearDepObj > > indexByClearDepIdx;
	private Map< CFBamClearDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamClearDepObj > > indexByDefSchemaIdx;
	public static String TABLE_NAME = "ClearDep";
	public static String TABLE_DBNAME = "clr_dep";

	public CFBamClearDepTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamClearDepObj>();
		allClearDep = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
	}

	public CFBamClearDepTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamClearDepObj>();
		allClearDep = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
	}

	public ICFBamSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFBamSchemaObj value ) {
		schema = value;
	}

	public String getTableName() {
		return( TABLE_NAME );
	}

	public String getTableDbName() {
		return( TABLE_DBNAME );
	}

	public Class getObjQualifyingClass() {
		return( ICFBamSchemaDefObj.class );
	}


	public void minimizeMemory() {
		allClearDep = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearDepObj.
	 */
	public ICFBamClearDepObj newInstance() {
		ICFBamClearDepObj inst = new CFBamClearDepObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearDepObj.
	 */
	public ICFBamClearDepEditObj newEditInstance( ICFBamClearDepObj orig ) {
		ICFBamClearDepEditObj edit = new CFBamClearDepEditObj( orig );
		return( edit );
	}

	public ICFBamClearDepObj realiseClearDep( ICFBamClearDepObj Obj ) {
		ICFBamClearDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamClearDepObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamClearDepObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.remove( keepObj.getPKey() );
					if( mapClearDepIdx.size() <= 0 ) {
						indexByClearDepIdx.remove( keyClearDepIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamClearDepObj)schema.getScopeTableObj().realiseScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allClearDep != null ) {
				allClearDep.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamClearDepObj)schema.getScopeTableObj().realiseScope( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allClearDep != null ) {
				allClearDep.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetClearDep( ICFBamClearDepObj Obj ) {
		forgetClearDep( Obj, false );
	}

	public void forgetClearDep( ICFBamClearDepObj Obj, boolean forgetSubObjects ) {
		ICFBamClearDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamClearDepObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.remove( keepObj.getPKey() );
					if( mapClearDepIdx.size() <= 0 ) {
						indexByClearDepIdx.remove( keyClearDepIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( allClearDep != null ) {
				allClearDep.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		((ICFBamSchemaObj)schema).getScopeTableObj().forgetScope( obj );
	}

	public void forgetClearDepByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamClearDepObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetClearDepByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamClearDepObj> toForget = new LinkedList<ICFBamClearDepObj>();
		ICFBamClearDepObj cur = null;
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearDepObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamClearDepObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearDepByClearDepIdx( long TenantId,
		long RelationId )
	{
		if( indexByClearDepIdx == null ) {
			return;
		}
		List<ICFBamClearDepObj> toForget = new LinkedList<ICFBamClearDepObj>();
		ICFBamClearDepObj cur = null;
		CFBamClearDepByClearDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByClearDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearDepObj > mapClearDepIdx = indexByClearDepIdx.get( key );
			if( mapClearDepIdx != null ) {
				Iterator<ICFBamClearDepObj> iterDup = mapClearDepIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClearDepIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamClearDepObj> toForget = new LinkedList<ICFBamClearDepObj>();
		ICFBamClearDepObj cur = null;
		CFBamClearDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamClearDepObj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamClearDepObj createClearDep( ICFBamClearDepObj Obj ) {
		ICFBamClearDepObj obj = Obj;
		CFBamClearDepBuff buff = obj.getClearDepBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableClearDep().createClearDep(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "CLRD" ) ) {
			obj = (ICFBamClearDepObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamClearDepObj readClearDep( CFBamScopePKey pkey ) {
		return( readClearDep( pkey, false ) );
	}

	public ICFBamClearDepObj readClearDep( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamClearDepObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamClearDepBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableClearDep().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamClearDepObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamClearDepObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamClearDepObj lockClearDep( CFBamScopePKey pkey ) {
		ICFBamClearDepObj locked = null;
		CFBamClearDepBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableClearDep().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamClearDepObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamClearDepObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockClearDep", pkey );
		}
		return( locked );
	}

	public List<ICFBamClearDepObj> readAllClearDep() {
		return( readAllClearDep( false ) );
	}

	public List<ICFBamClearDepObj> readAllClearDep( boolean forceRead ) {
		final String S_ProcName = "readAllClearDep";
		if( ( allClearDep == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamClearDepObj> map = new HashMap<CFBamScopePKey,ICFBamClearDepObj>();
			allClearDep = map;
			CFBamClearDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearDep().readAllDerived( schema.getAuthorization() );
			CFBamClearDepBuff buff;
			ICFBamClearDepObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearDepObj realised = (ICFBamClearDepObj)obj.realise();
			}
		}
		int len = allClearDep.size();
		ICFBamClearDepObj arr[] = new ICFBamClearDepObj[len];
		Iterator<ICFBamClearDepObj> valIter = allClearDep.values().iterator();
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
		ArrayList<ICFBamClearDepObj> arrayList = new ArrayList<ICFBamClearDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearDepObj> cmp = new Comparator<ICFBamClearDepObj>() {
			public int compare( ICFBamClearDepObj lhs, ICFBamClearDepObj rhs ) {
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
					CFBamScopePKey lhsPKey = lhs.getPKey();
					CFBamScopePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamClearDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearDepObj readClearDepByIdIdx( long TenantId,
		long Id )
	{
		return( readClearDepByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamClearDepObj readClearDepByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamClearDepObj obj = readClearDep( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamClearDepObj> readClearDepByTenantIdx( long TenantId )
	{
		return( readClearDepByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamClearDepObj> readClearDepByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearDepByTenantIdx";
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamClearDepObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearDepObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearDepObj>();
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearDepObj realised = (ICFBamClearDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearDepObj arr[] = new ICFBamClearDepObj[len];
		Iterator<ICFBamClearDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearDepObj> arrayList = new ArrayList<ICFBamClearDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearDepObj> cmp = new Comparator<ICFBamClearDepObj>() {
			public int compare( ICFBamClearDepObj lhs, ICFBamClearDepObj rhs ) {
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
					CFBamScopePKey lhsPKey = lhs.getPKey();
					CFBamScopePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamClearDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearDepObj> readClearDepByClearDepIdx( long TenantId,
		long RelationId )
	{
		return( readClearDepByClearDepIdx( TenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamClearDepObj> readClearDepByClearDepIdx( long TenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearDepByClearDepIdx";
		CFBamClearDepByClearDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamClearDepObj> dict;
		if( indexByClearDepIdx == null ) {
			indexByClearDepIdx = new HashMap< CFBamClearDepByClearDepIdxKey,
				Map< CFBamScopePKey, ICFBamClearDepObj > >();
		}
		if( ( ! forceRead ) && indexByClearDepIdx.containsKey( key ) ) {
			dict = indexByClearDepIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearDepObj>();
			ICFBamClearDepObj obj;
			CFBamClearDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearDep().readDerivedByClearDepIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			CFBamClearDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearDepObj realised = (ICFBamClearDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClearDepIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearDepObj arr[] = new ICFBamClearDepObj[len];
		Iterator<ICFBamClearDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearDepObj> arrayList = new ArrayList<ICFBamClearDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearDepObj> cmp = new Comparator<ICFBamClearDepObj>() {
			public int compare( ICFBamClearDepObj lhs, ICFBamClearDepObj rhs ) {
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
					CFBamScopePKey lhsPKey = lhs.getPKey();
					CFBamScopePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamClearDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearDepObj> readClearDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readClearDepByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamClearDepObj> readClearDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearDepByDefSchemaIdx";
		CFBamClearDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamClearDepObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamClearDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamClearDepObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearDepObj>();
			ICFBamClearDepObj obj;
			CFBamClearDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamClearDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearDepObj realised = (ICFBamClearDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearDepObj arr[] = new ICFBamClearDepObj[len];
		Iterator<ICFBamClearDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearDepObj> arrayList = new ArrayList<ICFBamClearDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearDepObj> cmp = new Comparator<ICFBamClearDepObj>() {
			public int compare( ICFBamClearDepObj lhs, ICFBamClearDepObj rhs ) {
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
					CFBamScopePKey lhsPKey = lhs.getPKey();
					CFBamScopePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamClearDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearDepObj updateClearDep( ICFBamClearDepObj Obj ) {
		ICFBamClearDepObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableClearDep().updateClearDep( schema.getAuthorization(),
			Obj.getClearDepBuff() );
		if( Obj.getClassCode().equals( "CLRD" ) ) {
			obj = (ICFBamClearDepObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteClearDep( ICFBamClearDepObj Obj ) {
		ICFBamClearDepObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableClearDep().deleteClearDep( schema.getAuthorization(),
			obj.getClearDepBuff() );
		obj.forget( true );
	}

	public void deleteClearDepByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamClearDepObj obj = readClearDep( pkey );
		if( obj != null ) {
			ICFBamClearDepEditObj editObj = (ICFBamClearDepEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamClearDepEditObj)obj.beginEdit();
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

	public void deleteClearDepByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearDepObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearDepObj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearDep().deleteClearDepByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamClearDepObj> iter = dict.values().iterator();
			ICFBamClearDepObj obj;
			List<ICFBamClearDepObj> toForget = new LinkedList<ICFBamClearDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByTenantIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableClearDep().deleteClearDepByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteClearDepByClearDepIdx( long TenantId,
		long RelationId )
	{
		CFBamClearDepByClearDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByClearDepIdx == null ) {
			indexByClearDepIdx = new HashMap< CFBamClearDepByClearDepIdxKey,
				Map< CFBamScopePKey, ICFBamClearDepObj > >();
		}
		if( indexByClearDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearDepObj> dict = indexByClearDepIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearDep().deleteClearDepByClearDepIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			Iterator<ICFBamClearDepObj> iter = dict.values().iterator();
			ICFBamClearDepObj obj;
			List<ICFBamClearDepObj> toForget = new LinkedList<ICFBamClearDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByClearDepIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableClearDep().deleteClearDepByClearDepIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
		}
	}

	public void deleteClearDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamClearDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamClearDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamClearDepObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearDepObj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearDep().deleteClearDepByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamClearDepObj> iter = dict.values().iterator();
			ICFBamClearDepObj obj;
			List<ICFBamClearDepObj> toForget = new LinkedList<ICFBamClearDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByDefSchemaIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableClearDep().deleteClearDepByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}
}
