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

public class CFBamPopDepTableObj
	implements ICFBamPopDepTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamPopDepObj> members;
	private Map<CFBamScopePKey, ICFBamPopDepObj> allPopDep;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamPopDepObj > > indexByTenantIdx;
	private Map< CFBamPopDepByRelationIdxKey,
		Map<CFBamScopePKey, ICFBamPopDepObj > > indexByRelationIdx;
	private Map< CFBamPopDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamPopDepObj > > indexByDefSchemaIdx;
	public static String TABLE_NAME = "PopDep";
	public static String TABLE_DBNAME = "pop_dep";

	public CFBamPopDepTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamPopDepObj>();
		allPopDep = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
	}

	public CFBamPopDepTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamPopDepObj>();
		allPopDep = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
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
		allPopDep = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamPopDepObj.
	 */
	public ICFBamPopDepObj newInstance() {
		ICFBamPopDepObj inst = new CFBamPopDepObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamPopDepObj.
	 */
	public ICFBamPopDepEditObj newEditInstance( ICFBamPopDepObj orig ) {
		ICFBamPopDepEditObj edit = new CFBamPopDepEditObj( orig );
		return( edit );
	}

	public ICFBamPopDepObj realisePopDep( ICFBamPopDepObj Obj ) {
		ICFBamPopDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamPopDepObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamPopDepObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamPopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopDepObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.remove( keepObj.getPKey() );
					if( mapRelationIdx.size() <= 0 ) {
						indexByRelationIdx.remove( keyRelationIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
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
			keepObj = (ICFBamPopDepObj)schema.getScopeTableObj().realiseScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopDepObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allPopDep != null ) {
				allPopDep.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamPopDepObj)schema.getScopeTableObj().realiseScope( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allPopDep != null ) {
				allPopDep.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopDepObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetPopDep( ICFBamPopDepObj Obj ) {
		forgetPopDep( Obj, false );
	}

	public void forgetPopDep( ICFBamPopDepObj Obj, boolean forgetSubObjects ) {
		ICFBamPopDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamPopDepObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopDepObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.remove( keepObj.getPKey() );
					if( mapRelationIdx.size() <= 0 ) {
						indexByRelationIdx.remove( keyRelationIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( allPopDep != null ) {
				allPopDep.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		((ICFBamSchemaObj)schema).getScopeTableObj().forgetScope( obj );
	}

	public void forgetPopDepByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamPopDepObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetPopDepByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamPopDepObj> toForget = new LinkedList<ICFBamPopDepObj>();
		ICFBamPopDepObj cur = null;
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopDepObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamPopDepObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamPopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamPopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetPopDepByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		if( indexByRelationIdx == null ) {
			return;
		}
		List<ICFBamPopDepObj> toForget = new LinkedList<ICFBamPopDepObj>();
		ICFBamPopDepObj cur = null;
		CFBamPopDepByRelationIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopDepObj > mapRelationIdx = indexByRelationIdx.get( key );
			if( mapRelationIdx != null ) {
				Iterator<ICFBamPopDepObj> iterDup = mapRelationIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRelationIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamPopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamPopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetPopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamPopDepObj> toForget = new LinkedList<ICFBamPopDepObj>();
		ICFBamPopDepObj cur = null;
		CFBamPopDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamPopDepObj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamPopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamPopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamPopDepObj createPopDep( ICFBamPopDepObj Obj ) {
		ICFBamPopDepObj obj = Obj;
		CFBamPopDepBuff buff = obj.getPopDepBuff();
		((ICFBamSchema)schema.getBackingStore()).getTablePopDep().createPopDep(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "POPD" ) ) {
			obj = (ICFBamPopDepObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamPopDepObj readPopDep( CFBamScopePKey pkey ) {
		return( readPopDep( pkey, false ) );
	}

	public ICFBamPopDepObj readPopDep( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamPopDepObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamPopDepBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTablePopDep().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamPopDepObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamPopDepObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamPopDepObj lockPopDep( CFBamScopePKey pkey ) {
		ICFBamPopDepObj locked = null;
		CFBamPopDepBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTablePopDep().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamPopDepObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamPopDepObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockPopDep", pkey );
		}
		return( locked );
	}

	public List<ICFBamPopDepObj> readAllPopDep() {
		return( readAllPopDep( false ) );
	}

	public List<ICFBamPopDepObj> readAllPopDep( boolean forceRead ) {
		final String S_ProcName = "readAllPopDep";
		if( ( allPopDep == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamPopDepObj> map = new HashMap<CFBamScopePKey,ICFBamPopDepObj>();
			allPopDep = map;
			CFBamPopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTablePopDep().readAllDerived( schema.getAuthorization() );
			CFBamPopDepBuff buff;
			ICFBamPopDepObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopDepObj realised = (ICFBamPopDepObj)obj.realise();
			}
		}
		int len = allPopDep.size();
		ICFBamPopDepObj arr[] = new ICFBamPopDepObj[len];
		Iterator<ICFBamPopDepObj> valIter = allPopDep.values().iterator();
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
		ArrayList<ICFBamPopDepObj> arrayList = new ArrayList<ICFBamPopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopDepObj> cmp = new Comparator<ICFBamPopDepObj>() {
			public int compare( ICFBamPopDepObj lhs, ICFBamPopDepObj rhs ) {
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
		List<ICFBamPopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamPopDepObj readPopDepByIdIdx( long TenantId,
		long Id )
	{
		return( readPopDepByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamPopDepObj readPopDepByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamPopDepObj obj = readPopDep( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamPopDepObj> readPopDepByTenantIdx( long TenantId )
	{
		return( readPopDepByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamPopDepObj> readPopDepByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopDepByTenantIdx";
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamPopDepObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamPopDepObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopDepObj>();
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopDepObj realised = (ICFBamPopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamPopDepObj arr[] = new ICFBamPopDepObj[len];
		Iterator<ICFBamPopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopDepObj> arrayList = new ArrayList<ICFBamPopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopDepObj> cmp = new Comparator<ICFBamPopDepObj>() {
			public int compare( ICFBamPopDepObj lhs, ICFBamPopDepObj rhs ) {
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
		List<ICFBamPopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopDepObj> readPopDepByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		return( readPopDepByRelationIdx( RelationTenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamPopDepObj> readPopDepByRelationIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopDepByRelationIdx";
		CFBamPopDepByRelationIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamPopDepObj> dict;
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< CFBamPopDepByRelationIdxKey,
				Map< CFBamScopePKey, ICFBamPopDepObj > >();
		}
		if( ( ! forceRead ) && indexByRelationIdx.containsKey( key ) ) {
			dict = indexByRelationIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopDepObj>();
			ICFBamPopDepObj obj;
			CFBamPopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTablePopDep().readDerivedByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			CFBamPopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopDepObj realised = (ICFBamPopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRelationIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamPopDepObj arr[] = new ICFBamPopDepObj[len];
		Iterator<ICFBamPopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopDepObj> arrayList = new ArrayList<ICFBamPopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopDepObj> cmp = new Comparator<ICFBamPopDepObj>() {
			public int compare( ICFBamPopDepObj lhs, ICFBamPopDepObj rhs ) {
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
		List<ICFBamPopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopDepObj> readPopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readPopDepByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamPopDepObj> readPopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopDepByDefSchemaIdx";
		CFBamPopDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamPopDepObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamPopDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamPopDepObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopDepObj>();
			ICFBamPopDepObj obj;
			CFBamPopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTablePopDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamPopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopDepObj realised = (ICFBamPopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamPopDepObj arr[] = new ICFBamPopDepObj[len];
		Iterator<ICFBamPopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopDepObj> arrayList = new ArrayList<ICFBamPopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopDepObj> cmp = new Comparator<ICFBamPopDepObj>() {
			public int compare( ICFBamPopDepObj lhs, ICFBamPopDepObj rhs ) {
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
		List<ICFBamPopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamPopDepObj updatePopDep( ICFBamPopDepObj Obj ) {
		ICFBamPopDepObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTablePopDep().updatePopDep( schema.getAuthorization(),
			Obj.getPopDepBuff() );
		if( Obj.getClassCode().equals( "POPD" ) ) {
			obj = (ICFBamPopDepObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deletePopDep( ICFBamPopDepObj Obj ) {
		ICFBamPopDepObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTablePopDep().deletePopDep( schema.getAuthorization(),
			obj.getPopDepBuff() );
		obj.forget( true );
	}

	public void deletePopDepByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamPopDepObj obj = readPopDep( pkey );
		if( obj != null ) {
			ICFBamPopDepEditObj editObj = (ICFBamPopDepEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamPopDepEditObj)obj.beginEdit();
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

	public void deletePopDepByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamPopDepObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopDepObj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTablePopDep().deletePopDepByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamPopDepObj> iter = dict.values().iterator();
			ICFBamPopDepObj obj;
			List<ICFBamPopDepObj> toForget = new LinkedList<ICFBamPopDepObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTablePopDep().deletePopDepByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deletePopDepByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		CFBamPopDepByRelationIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< CFBamPopDepByRelationIdxKey,
				Map< CFBamScopePKey, ICFBamPopDepObj > >();
		}
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopDepObj> dict = indexByRelationIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTablePopDep().deletePopDepByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			Iterator<ICFBamPopDepObj> iter = dict.values().iterator();
			ICFBamPopDepObj obj;
			List<ICFBamPopDepObj> toForget = new LinkedList<ICFBamPopDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByRelationIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTablePopDep().deletePopDepByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
		}
	}

	public void deletePopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamPopDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamPopDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamPopDepObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopDepObj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTablePopDep().deletePopDepByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamPopDepObj> iter = dict.values().iterator();
			ICFBamPopDepObj obj;
			List<ICFBamPopDepObj> toForget = new LinkedList<ICFBamPopDepObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTablePopDep().deletePopDepByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}
}
