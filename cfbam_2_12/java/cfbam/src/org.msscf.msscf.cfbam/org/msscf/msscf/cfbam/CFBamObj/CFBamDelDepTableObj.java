// Description: Java 11 Table Object implementation for CFBam.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamDelDepTableObj
	implements ICFBamDelDepTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamDelDepObj> members;
	private Map<CFBamScopePKey, ICFBamDelDepObj> allDelDep;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamDelDepObj > > indexByTenantIdx;
	private Map< CFBamDelDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamDelDepObj > > indexByDefSchemaIdx;
	private Map< CFBamDelDepByDelDepIdxKey,
		Map<CFBamScopePKey, ICFBamDelDepObj > > indexByDelDepIdx;
	public static String TABLE_NAME = "DelDep";
	public static String TABLE_DBNAME = "del_dep";

	public CFBamDelDepTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamDelDepObj>();
		allDelDep = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
	}

	public CFBamDelDepTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamDelDepObj>();
		allDelDep = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
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
		allDelDep = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDelDepObj.
	 */
	public ICFBamDelDepObj newInstance() {
		ICFBamDelDepObj inst = new CFBamDelDepObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDelDepObj.
	 */
	public ICFBamDelDepEditObj newEditInstance( ICFBamDelDepObj orig ) {
		ICFBamDelDepEditObj edit = new CFBamDelDepEditObj( orig );
		return( edit );
	}

	public ICFBamDelDepObj realiseDelDep( ICFBamDelDepObj Obj ) {
		ICFBamDelDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamDelDepObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamDelDepObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamDelDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByDelDepIdx != null ) {
				CFBamDelDepByDelDepIdxKey keyDelDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					mapDelDepIdx.remove( keepObj.getPKey() );
					if( mapDelDepIdx.size() <= 0 ) {
						indexByDelDepIdx.remove( keyDelDepIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamDelDepObj)schema.getScopeTableObj().realiseScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelDepIdx != null ) {
				CFBamDelDepByDelDepIdxKey keyDelDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					mapDelDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allDelDep != null ) {
				allDelDep.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamDelDepObj)schema.getScopeTableObj().realiseScope( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allDelDep != null ) {
				allDelDep.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelDepIdx != null ) {
				CFBamDelDepByDelDepIdxKey keyDelDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					mapDelDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetDelDep( ICFBamDelDepObj Obj ) {
		forgetDelDep( Obj, false );
	}

	public void forgetDelDep( ICFBamDelDepObj Obj, boolean forgetSubObjects ) {
		ICFBamDelDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamDelDepObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByDelDepIdx != null ) {
				CFBamDelDepByDelDepIdxKey keyDelDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelDepObj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					mapDelDepIdx.remove( keepObj.getPKey() );
					if( mapDelDepIdx.size() <= 0 ) {
						indexByDelDepIdx.remove( keyDelDepIdx );
					}
				}
			}

			if( allDelDep != null ) {
				allDelDep.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		((ICFBamSchemaObj)schema).getScopeTableObj().forgetScope( obj );
	}

	public void forgetDelDepByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamDelDepObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetDelDepByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamDelDepObj> toForget = new LinkedList<ICFBamDelDepObj>();
		ICFBamDelDepObj cur = null;
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelDepObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamDelDepObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamDelDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamDelDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetDelDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamDelDepObj> toForget = new LinkedList<ICFBamDelDepObj>();
		ICFBamDelDepObj cur = null;
		CFBamDelDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamDelDepObj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamDelDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamDelDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetDelDepByDelDepIdx( long RelationTenantId,
		long RelationId )
	{
		if( indexByDelDepIdx == null ) {
			return;
		}
		List<ICFBamDelDepObj> toForget = new LinkedList<ICFBamDelDepObj>();
		ICFBamDelDepObj cur = null;
		CFBamDelDepByDelDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByDelDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelDepObj > mapDelDepIdx = indexByDelDepIdx.get( key );
			if( mapDelDepIdx != null ) {
				Iterator<ICFBamDelDepObj> iterDup = mapDelDepIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDelDepIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamDelDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamDelDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamDelDepObj createDelDep( ICFBamDelDepObj Obj ) {
		ICFBamDelDepObj obj = Obj;
		CFBamDelDepBuff buff = obj.getDelDepBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableDelDep().createDelDep(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "DELD" ) ) {
			obj = (ICFBamDelDepObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamDelDepObj readDelDep( CFBamScopePKey pkey ) {
		return( readDelDep( pkey, false ) );
	}

	public ICFBamDelDepObj readDelDep( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamDelDepObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamDelDepBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableDelDep().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamDelDepObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamDelDepObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamDelDepObj lockDelDep( CFBamScopePKey pkey ) {
		ICFBamDelDepObj locked = null;
		CFBamDelDepBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableDelDep().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamDelDepObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamDelDepObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockDelDep", pkey );
		}
		return( locked );
	}

	public List<ICFBamDelDepObj> readAllDelDep() {
		return( readAllDelDep( false ) );
	}

	public List<ICFBamDelDepObj> readAllDelDep( boolean forceRead ) {
		final String S_ProcName = "readAllDelDep";
		if( ( allDelDep == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamDelDepObj> map = new HashMap<CFBamScopePKey,ICFBamDelDepObj>();
			allDelDep = map;
			CFBamDelDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableDelDep().readAllDerived( schema.getAuthorization() );
			CFBamDelDepBuff buff;
			ICFBamDelDepObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelDepObj realised = (ICFBamDelDepObj)obj.realise();
			}
		}
		int len = allDelDep.size();
		ICFBamDelDepObj arr[] = new ICFBamDelDepObj[len];
		Iterator<ICFBamDelDepObj> valIter = allDelDep.values().iterator();
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
		ArrayList<ICFBamDelDepObj> arrayList = new ArrayList<ICFBamDelDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamDelDepObj> cmp = new Comparator<ICFBamDelDepObj>() {
			public int compare( ICFBamDelDepObj lhs, ICFBamDelDepObj rhs ) {
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
		List<ICFBamDelDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDelDepObj readDelDepByIdIdx( long TenantId,
		long Id )
	{
		return( readDelDepByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamDelDepObj readDelDepByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDelDepObj obj = readDelDep( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamDelDepObj> readDelDepByTenantIdx( long TenantId )
	{
		return( readDelDepByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamDelDepObj> readDelDepByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelDepByTenantIdx";
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamDelDepObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamDelDepObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelDepObj>();
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelDepObj realised = (ICFBamDelDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamDelDepObj arr[] = new ICFBamDelDepObj[len];
		Iterator<ICFBamDelDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelDepObj> arrayList = new ArrayList<ICFBamDelDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamDelDepObj> cmp = new Comparator<ICFBamDelDepObj>() {
			public int compare( ICFBamDelDepObj lhs, ICFBamDelDepObj rhs ) {
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
		List<ICFBamDelDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelDepObj> readDelDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readDelDepByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamDelDepObj> readDelDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelDepByDefSchemaIdx";
		CFBamDelDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamDelDepObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamDelDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamDelDepObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelDepObj>();
			ICFBamDelDepObj obj;
			CFBamDelDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableDelDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamDelDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelDepObj realised = (ICFBamDelDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamDelDepObj arr[] = new ICFBamDelDepObj[len];
		Iterator<ICFBamDelDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelDepObj> arrayList = new ArrayList<ICFBamDelDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamDelDepObj> cmp = new Comparator<ICFBamDelDepObj>() {
			public int compare( ICFBamDelDepObj lhs, ICFBamDelDepObj rhs ) {
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
		List<ICFBamDelDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelDepObj> readDelDepByDelDepIdx( long RelationTenantId,
		long RelationId )
	{
		return( readDelDepByDelDepIdx( RelationTenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamDelDepObj> readDelDepByDelDepIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelDepByDelDepIdx";
		CFBamDelDepByDelDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamDelDepObj> dict;
		if( indexByDelDepIdx == null ) {
			indexByDelDepIdx = new HashMap< CFBamDelDepByDelDepIdxKey,
				Map< CFBamScopePKey, ICFBamDelDepObj > >();
		}
		if( ( ! forceRead ) && indexByDelDepIdx.containsKey( key ) ) {
			dict = indexByDelDepIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelDepObj>();
			ICFBamDelDepObj obj;
			CFBamDelDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableDelDep().readDerivedByDelDepIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			CFBamDelDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelDepObj realised = (ICFBamDelDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDelDepIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamDelDepObj arr[] = new ICFBamDelDepObj[len];
		Iterator<ICFBamDelDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelDepObj> arrayList = new ArrayList<ICFBamDelDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamDelDepObj> cmp = new Comparator<ICFBamDelDepObj>() {
			public int compare( ICFBamDelDepObj lhs, ICFBamDelDepObj rhs ) {
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
		List<ICFBamDelDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDelDepObj updateDelDep( ICFBamDelDepObj Obj ) {
		ICFBamDelDepObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableDelDep().updateDelDep( schema.getAuthorization(),
			Obj.getDelDepBuff() );
		if( Obj.getClassCode().equals( "DELD" ) ) {
			obj = (ICFBamDelDepObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteDelDep( ICFBamDelDepObj Obj ) {
		ICFBamDelDepObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableDelDep().deleteDelDep( schema.getAuthorization(),
			obj.getDelDepBuff() );
		obj.forget( true );
	}

	public void deleteDelDepByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDelDepObj obj = readDelDep( pkey );
		if( obj != null ) {
			ICFBamDelDepEditObj editObj = (ICFBamDelDepEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamDelDepEditObj)obj.beginEdit();
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

	public void deleteDelDepByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamDelDepObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelDepObj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableDelDep().deleteDelDepByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamDelDepObj> iter = dict.values().iterator();
			ICFBamDelDepObj obj;
			List<ICFBamDelDepObj> toForget = new LinkedList<ICFBamDelDepObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableDelDep().deleteDelDepByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteDelDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamDelDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamDelDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamDelDepObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelDepObj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableDelDep().deleteDelDepByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamDelDepObj> iter = dict.values().iterator();
			ICFBamDelDepObj obj;
			List<ICFBamDelDepObj> toForget = new LinkedList<ICFBamDelDepObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableDelDep().deleteDelDepByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteDelDepByDelDepIdx( long RelationTenantId,
		long RelationId )
	{
		CFBamDelDepByDelDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByDelDepIdx == null ) {
			indexByDelDepIdx = new HashMap< CFBamDelDepByDelDepIdxKey,
				Map< CFBamScopePKey, ICFBamDelDepObj > >();
		}
		if( indexByDelDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelDepObj> dict = indexByDelDepIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableDelDep().deleteDelDepByDelDepIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			Iterator<ICFBamDelDepObj> iter = dict.values().iterator();
			ICFBamDelDepObj obj;
			List<ICFBamDelDepObj> toForget = new LinkedList<ICFBamDelDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByDelDepIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableDelDep().deleteDelDepByDelDepIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
		}
	}
}
