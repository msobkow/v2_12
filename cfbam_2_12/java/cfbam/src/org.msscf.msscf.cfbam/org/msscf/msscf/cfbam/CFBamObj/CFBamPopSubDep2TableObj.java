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

public class CFBamPopSubDep2TableObj
	implements ICFBamPopSubDep2TableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamPopSubDep2Obj> members;
	private Map<CFBamScopePKey, ICFBamPopSubDep2Obj> allPopSubDep2;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep2Obj > > indexByTenantIdx;
	private Map< CFBamPopDepByRelationIdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep2Obj > > indexByRelationIdx;
	private Map< CFBamPopDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep2Obj > > indexByDefSchemaIdx;
	private Map< CFBamPopSubDep2ByPopSubDep1IdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep2Obj > > indexByPopSubDep1Idx;
	private Map< CFBamPopSubDep2ByUNameIdxKey,
		ICFBamPopSubDep2Obj > indexByUNameIdx;
	public static String TABLE_NAME = "PopSubDep2";
	public static String TABLE_DBNAME = "popsubdep2";

	public CFBamPopSubDep2TableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamPopSubDep2Obj>();
		allPopSubDep2 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByPopSubDep1Idx = null;
		indexByUNameIdx = null;
	}

	public CFBamPopSubDep2TableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamPopSubDep2Obj>();
		allPopSubDep2 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByPopSubDep1Idx = null;
		indexByUNameIdx = null;
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
		allPopSubDep2 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByPopSubDep1Idx = null;
		indexByUNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamPopSubDep2Obj.
	 */
	public ICFBamPopSubDep2Obj newInstance() {
		ICFBamPopSubDep2Obj inst = new CFBamPopSubDep2Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamPopSubDep2Obj.
	 */
	public ICFBamPopSubDep2EditObj newEditInstance( ICFBamPopSubDep2Obj orig ) {
		ICFBamPopSubDep2EditObj edit = new CFBamPopSubDep2EditObj( orig );
		return( edit );
	}

	public ICFBamPopSubDep2Obj realisePopSubDep2( ICFBamPopSubDep2Obj Obj ) {
		ICFBamPopSubDep2Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamPopSubDep2Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamPopSubDep2Obj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					indexByRelationIdx.remove( keyRelationIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPopSubDep1Idx != null ) {
				CFBamPopSubDep2ByPopSubDep1IdxKey keyPopSubDep1Idx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep2().newPopSubDep1IdxKey();
				keyPopSubDep1Idx.setRequiredPopSubDep1TenantId( keepObj.getRequiredPopSubDep1TenantId() );
				keyPopSubDep1Idx.setRequiredPopSubDep1Id( keepObj.getRequiredPopSubDep1Id() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapPopSubDep1Idx = indexByPopSubDep1Idx.get( keyPopSubDep1Idx );
				if( mapPopSubDep1Idx != null ) {
					mapPopSubDep1Idx.remove( keepObj.getPKey() );
					if( mapPopSubDep1Idx.size() <= 0 ) {
						indexByPopSubDep1Idx.remove( keyPopSubDep1Idx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep2ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredPopSubDep1TenantId( keepObj.getRequiredPopSubDep1TenantId() );
				keyUNameIdx.setRequiredPopSubDep1Id( keepObj.getRequiredPopSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamPopSubDep2Obj)schema.getPopDepTableObj().realisePopDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPopSubDep1Idx != null ) {
				CFBamPopSubDep2ByPopSubDep1IdxKey keyPopSubDep1Idx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep2().newPopSubDep1IdxKey();
				keyPopSubDep1Idx.setRequiredPopSubDep1TenantId( keepObj.getRequiredPopSubDep1TenantId() );
				keyPopSubDep1Idx.setRequiredPopSubDep1Id( keepObj.getRequiredPopSubDep1Id() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapPopSubDep1Idx = indexByPopSubDep1Idx.get( keyPopSubDep1Idx );
				if( mapPopSubDep1Idx != null ) {
					mapPopSubDep1Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep2ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredPopSubDep1TenantId( keepObj.getRequiredPopSubDep1TenantId() );
				keyUNameIdx.setRequiredPopSubDep1Id( keepObj.getRequiredPopSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allPopSubDep2 != null ) {
				allPopSubDep2.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamPopSubDep2Obj)schema.getPopDepTableObj().realisePopDep( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allPopSubDep2 != null ) {
				allPopSubDep2.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPopSubDep1Idx != null ) {
				CFBamPopSubDep2ByPopSubDep1IdxKey keyPopSubDep1Idx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep2().newPopSubDep1IdxKey();
				keyPopSubDep1Idx.setRequiredPopSubDep1TenantId( keepObj.getRequiredPopSubDep1TenantId() );
				keyPopSubDep1Idx.setRequiredPopSubDep1Id( keepObj.getRequiredPopSubDep1Id() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapPopSubDep1Idx = indexByPopSubDep1Idx.get( keyPopSubDep1Idx );
				if( mapPopSubDep1Idx != null ) {
					mapPopSubDep1Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep2ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredPopSubDep1TenantId( keepObj.getRequiredPopSubDep1TenantId() );
				keyUNameIdx.setRequiredPopSubDep1Id( keepObj.getRequiredPopSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetPopSubDep2( ICFBamPopSubDep2Obj Obj ) {
		forgetPopSubDep2( Obj, false );
	}

	public void forgetPopSubDep2( ICFBamPopSubDep2Obj Obj, boolean forgetSubObjects ) {
		ICFBamPopSubDep2Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamPopSubDep2Obj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					indexByRelationIdx.remove( keyRelationIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPopSubDep1Idx != null ) {
				CFBamPopSubDep2ByPopSubDep1IdxKey keyPopSubDep1Idx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep2().newPopSubDep1IdxKey();
				keyPopSubDep1Idx.setRequiredPopSubDep1TenantId( keepObj.getRequiredPopSubDep1TenantId() );
				keyPopSubDep1Idx.setRequiredPopSubDep1Id( keepObj.getRequiredPopSubDep1Id() );
				Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapPopSubDep1Idx = indexByPopSubDep1Idx.get( keyPopSubDep1Idx );
				if( mapPopSubDep1Idx != null ) {
					mapPopSubDep1Idx.remove( keepObj.getPKey() );
					if( mapPopSubDep1Idx.size() <= 0 ) {
						indexByPopSubDep1Idx.remove( keyPopSubDep1Idx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep2ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredPopSubDep1TenantId( keepObj.getRequiredPopSubDep1TenantId() );
				keyUNameIdx.setRequiredPopSubDep1Id( keepObj.getRequiredPopSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allPopSubDep2 != null ) {
				allPopSubDep2.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFBamSchemaObj)schema).getPopSubDep3TableObj().forgetPopSubDep3ByPopSubDep2Idx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		((ICFBamSchemaObj)schema).getPopDepTableObj().forgetPopDep( obj );
	}

	public void forgetPopSubDep2ByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamPopSubDep2Obj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetPopSubDep2ByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamPopSubDep2Obj> toForget = new LinkedList<ICFBamPopSubDep2Obj>();
		ICFBamPopSubDep2Obj cur = null;
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamPopSubDep2Obj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamPopSubDep2Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamPopSubDep2Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetPopSubDep2ByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		if( indexByRelationIdx == null ) {
			return;
		}
		List<ICFBamPopSubDep2Obj> toForget = new LinkedList<ICFBamPopSubDep2Obj>();
		ICFBamPopSubDep2Obj cur = null;
		CFBamPopDepByRelationIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapRelationIdx = indexByRelationIdx.get( key );
			if( mapRelationIdx != null ) {
				Iterator<ICFBamPopSubDep2Obj> iterDup = mapRelationIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRelationIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamPopSubDep2Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamPopSubDep2Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetPopSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamPopSubDep2Obj> toForget = new LinkedList<ICFBamPopSubDep2Obj>();
		ICFBamPopSubDep2Obj cur = null;
		CFBamPopDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamPopSubDep2Obj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamPopSubDep2Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamPopSubDep2Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetPopSubDep2ByPopSubDep1Idx( long PopSubDep1TenantId,
		long PopSubDep1Id )
	{
		if( indexByPopSubDep1Idx == null ) {
			return;
		}
		List<ICFBamPopSubDep2Obj> toForget = new LinkedList<ICFBamPopSubDep2Obj>();
		ICFBamPopSubDep2Obj cur = null;
		CFBamPopSubDep2ByPopSubDep1IdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep2().newPopSubDep1IdxKey();
		key.setRequiredPopSubDep1TenantId( PopSubDep1TenantId );
		key.setRequiredPopSubDep1Id( PopSubDep1Id );
		if( indexByPopSubDep1Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep2Obj > mapPopSubDep1Idx = indexByPopSubDep1Idx.get( key );
			if( mapPopSubDep1Idx != null ) {
				Iterator<ICFBamPopSubDep2Obj> iterDup = mapPopSubDep1Idx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByPopSubDep1Idx.remove( key );
			}

		}
		else {
			Iterator<ICFBamPopSubDep2Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamPopSubDep2Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetPopSubDep2ByUNameIdx( long PopSubDep1TenantId,
		long PopSubDep1Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamPopSubDep2Obj> toForget = new LinkedList<ICFBamPopSubDep2Obj>();
		ICFBamPopSubDep2Obj cur = null;
		CFBamPopSubDep2ByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep2().newUNameIdxKey();
		key.setRequiredPopSubDep1TenantId( PopSubDep1TenantId );
		key.setRequiredPopSubDep1Id( PopSubDep1Id );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamPopSubDep2Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamPopSubDep2Obj createPopSubDep2( ICFBamPopSubDep2Obj Obj ) {
		ICFBamPopSubDep2Obj obj = Obj;
		CFBamPopSubDep2Buff buff = obj.getPopSubDep2Buff();
		((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep2().createPopSubDep2(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "POP2" ) ) {
			obj = (ICFBamPopSubDep2Obj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamPopSubDep2Obj readPopSubDep2( CFBamScopePKey pkey ) {
		return( readPopSubDep2( pkey, false ) );
	}

	public ICFBamPopSubDep2Obj readPopSubDep2( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamPopSubDep2Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamPopSubDep2Buff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep2().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamPopSubDep2Obj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamPopSubDep2Obj lockPopSubDep2( CFBamScopePKey pkey ) {
		ICFBamPopSubDep2Obj locked = null;
		CFBamPopSubDep2Buff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep2().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamPopSubDep2Obj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockPopSubDep2", pkey );
		}
		return( locked );
	}

	public List<ICFBamPopSubDep2Obj> readAllPopSubDep2() {
		return( readAllPopSubDep2( false ) );
	}

	public List<ICFBamPopSubDep2Obj> readAllPopSubDep2( boolean forceRead ) {
		final String S_ProcName = "readAllPopSubDep2";
		if( ( allPopSubDep2 == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamPopSubDep2Obj> map = new HashMap<CFBamScopePKey,ICFBamPopSubDep2Obj>();
			allPopSubDep2 = map;
			CFBamPopSubDep2Buff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep2().readAllDerived( schema.getAuthorization() );
			CFBamPopSubDep2Buff buff;
			ICFBamPopSubDep2Obj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep2Obj realised = (ICFBamPopSubDep2Obj)obj.realise();
			}
		}
		int len = allPopSubDep2.size();
		ICFBamPopSubDep2Obj arr[] = new ICFBamPopSubDep2Obj[len];
		Iterator<ICFBamPopSubDep2Obj> valIter = allPopSubDep2.values().iterator();
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
		ArrayList<ICFBamPopSubDep2Obj> arrayList = new ArrayList<ICFBamPopSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopSubDep2Obj> cmp = new Comparator<ICFBamPopSubDep2Obj>() {
			public int compare( ICFBamPopSubDep2Obj lhs, ICFBamPopSubDep2Obj rhs ) {
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
		List<ICFBamPopSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamPopSubDep2Obj readPopSubDep2ByIdIdx( long TenantId,
		long Id )
	{
		return( readPopSubDep2ByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamPopSubDep2Obj readPopSubDep2ByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamPopSubDep2Obj obj = readPopSubDep2( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamPopSubDep2Obj> readPopSubDep2ByTenantIdx( long TenantId )
	{
		return( readPopSubDep2ByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamPopSubDep2Obj> readPopSubDep2ByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep2ByTenantIdx";
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamPopSubDep2Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep2Obj>();
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep2Obj realised = (ICFBamPopSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamPopSubDep2Obj arr[] = new ICFBamPopSubDep2Obj[len];
		Iterator<ICFBamPopSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep2Obj> arrayList = new ArrayList<ICFBamPopSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopSubDep2Obj> cmp = new Comparator<ICFBamPopSubDep2Obj>() {
			public int compare( ICFBamPopSubDep2Obj lhs, ICFBamPopSubDep2Obj rhs ) {
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
		List<ICFBamPopSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopSubDep2Obj> readPopSubDep2ByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		return( readPopSubDep2ByRelationIdx( RelationTenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamPopSubDep2Obj> readPopSubDep2ByRelationIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep2ByRelationIdx";
		CFBamPopDepByRelationIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamPopSubDep2Obj> dict;
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< CFBamPopDepByRelationIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByRelationIdx.containsKey( key ) ) {
			dict = indexByRelationIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep2Obj>();
			ICFBamPopDepObj obj;
			CFBamPopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTablePopDep().readDerivedByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			CFBamPopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep2Obj realised = (ICFBamPopSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRelationIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamPopSubDep2Obj arr[] = new ICFBamPopSubDep2Obj[len];
		Iterator<ICFBamPopSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep2Obj> arrayList = new ArrayList<ICFBamPopSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopSubDep2Obj> cmp = new Comparator<ICFBamPopSubDep2Obj>() {
			public int compare( ICFBamPopSubDep2Obj lhs, ICFBamPopSubDep2Obj rhs ) {
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
		List<ICFBamPopSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopSubDep2Obj> readPopSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readPopSubDep2ByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamPopSubDep2Obj> readPopSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep2ByDefSchemaIdx";
		CFBamPopDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamPopSubDep2Obj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamPopDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep2Obj>();
			ICFBamPopDepObj obj;
			CFBamPopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTablePopDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamPopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep2Obj realised = (ICFBamPopSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamPopSubDep2Obj arr[] = new ICFBamPopSubDep2Obj[len];
		Iterator<ICFBamPopSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep2Obj> arrayList = new ArrayList<ICFBamPopSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopSubDep2Obj> cmp = new Comparator<ICFBamPopSubDep2Obj>() {
			public int compare( ICFBamPopSubDep2Obj lhs, ICFBamPopSubDep2Obj rhs ) {
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
		List<ICFBamPopSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopSubDep2Obj> readPopSubDep2ByPopSubDep1Idx( long PopSubDep1TenantId,
		long PopSubDep1Id )
	{
		return( readPopSubDep2ByPopSubDep1Idx( PopSubDep1TenantId,
			PopSubDep1Id,
			false ) );
	}

	public List<ICFBamPopSubDep2Obj> readPopSubDep2ByPopSubDep1Idx( long PopSubDep1TenantId,
		long PopSubDep1Id,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep2ByPopSubDep1Idx";
		CFBamPopSubDep2ByPopSubDep1IdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep2().newPopSubDep1IdxKey();
		key.setRequiredPopSubDep1TenantId( PopSubDep1TenantId );
		key.setRequiredPopSubDep1Id( PopSubDep1Id );
		Map<CFBamScopePKey, ICFBamPopSubDep2Obj> dict;
		if( indexByPopSubDep1Idx == null ) {
			indexByPopSubDep1Idx = new HashMap< CFBamPopSubDep2ByPopSubDep1IdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByPopSubDep1Idx.containsKey( key ) ) {
			dict = indexByPopSubDep1Idx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep2Obj>();
			ICFBamPopSubDep2Obj obj;
			CFBamPopSubDep2Buff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep2().readDerivedByPopSubDep1Idx( schema.getAuthorization(),
				PopSubDep1TenantId,
				PopSubDep1Id );
			CFBamPopSubDep2Buff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep2Obj realised = (ICFBamPopSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPopSubDep1Idx.put( key, dict );
		}
		int len = dict.size();
		ICFBamPopSubDep2Obj arr[] = new ICFBamPopSubDep2Obj[len];
		Iterator<ICFBamPopSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep2Obj> arrayList = new ArrayList<ICFBamPopSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopSubDep2Obj> cmp = new Comparator<ICFBamPopSubDep2Obj>() {
			public int compare( ICFBamPopSubDep2Obj lhs, ICFBamPopSubDep2Obj rhs ) {
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
		List<ICFBamPopSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamPopSubDep2Obj readPopSubDep2ByUNameIdx( long PopSubDep1TenantId,
		long PopSubDep1Id,
		String Name )
	{
		return( readPopSubDep2ByUNameIdx( PopSubDep1TenantId,
			PopSubDep1Id,
			Name,
			false ) );
	}

	public ICFBamPopSubDep2Obj readPopSubDep2ByUNameIdx( long PopSubDep1TenantId,
		long PopSubDep1Id,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamPopSubDep2ByUNameIdxKey,
				ICFBamPopSubDep2Obj >();
		}
		CFBamPopSubDep2ByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep2().newUNameIdxKey();
		key.setRequiredPopSubDep1TenantId( PopSubDep1TenantId );
		key.setRequiredPopSubDep1Id( PopSubDep1Id );
		key.setRequiredName( Name );
		ICFBamPopSubDep2Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamPopSubDep2Buff buff = ((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep2().readDerivedByUNameIdx( schema.getAuthorization(),
				PopSubDep1TenantId,
				PopSubDep1Id,
				Name );
			if( buff != null ) {
				obj = (ICFBamPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamPopSubDep2Obj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamPopSubDep2Obj updatePopSubDep2( ICFBamPopSubDep2Obj Obj ) {
		ICFBamPopSubDep2Obj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep2().updatePopSubDep2( schema.getAuthorization(),
			Obj.getPopSubDep2Buff() );
		if( Obj.getClassCode().equals( "POP2" ) ) {
			obj = (ICFBamPopSubDep2Obj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deletePopSubDep2( ICFBamPopSubDep2Obj Obj ) {
		ICFBamPopSubDep2Obj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep2().deletePopSubDep2( schema.getAuthorization(),
			obj.getPopSubDep2Buff() );
		obj.forget( true );
	}

	public void deletePopSubDep2ByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamPopSubDep2Obj obj = readPopSubDep2( pkey );
		if( obj != null ) {
			ICFBamPopSubDep2EditObj editObj = (ICFBamPopSubDep2EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamPopSubDep2EditObj)obj.beginEdit();
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

	public void deletePopSubDep2ByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep2Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep2Obj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep2().deletePopSubDep2ByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamPopSubDep2Obj> iter = dict.values().iterator();
			ICFBamPopSubDep2Obj obj;
			List<ICFBamPopSubDep2Obj> toForget = new LinkedList<ICFBamPopSubDep2Obj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep2().deletePopSubDep2ByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deletePopSubDep2ByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		CFBamPopDepByRelationIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< CFBamPopDepByRelationIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep2Obj > >();
		}
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep2Obj> dict = indexByRelationIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep2().deletePopSubDep2ByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			Iterator<ICFBamPopSubDep2Obj> iter = dict.values().iterator();
			ICFBamPopSubDep2Obj obj;
			List<ICFBamPopSubDep2Obj> toForget = new LinkedList<ICFBamPopSubDep2Obj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep2().deletePopSubDep2ByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
		}
	}

	public void deletePopSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamPopDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamPopDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep2Obj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep2Obj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep2().deletePopSubDep2ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamPopSubDep2Obj> iter = dict.values().iterator();
			ICFBamPopSubDep2Obj obj;
			List<ICFBamPopSubDep2Obj> toForget = new LinkedList<ICFBamPopSubDep2Obj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep2().deletePopSubDep2ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deletePopSubDep2ByPopSubDep1Idx( long PopSubDep1TenantId,
		long PopSubDep1Id )
	{
		CFBamPopSubDep2ByPopSubDep1IdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep2().newPopSubDep1IdxKey();
		key.setRequiredPopSubDep1TenantId( PopSubDep1TenantId );
		key.setRequiredPopSubDep1Id( PopSubDep1Id );
		if( indexByPopSubDep1Idx == null ) {
			indexByPopSubDep1Idx = new HashMap< CFBamPopSubDep2ByPopSubDep1IdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep2Obj > >();
		}
		if( indexByPopSubDep1Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep2Obj> dict = indexByPopSubDep1Idx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep2().deletePopSubDep2ByPopSubDep1Idx( schema.getAuthorization(),
				PopSubDep1TenantId,
				PopSubDep1Id );
			Iterator<ICFBamPopSubDep2Obj> iter = dict.values().iterator();
			ICFBamPopSubDep2Obj obj;
			List<ICFBamPopSubDep2Obj> toForget = new LinkedList<ICFBamPopSubDep2Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByPopSubDep1Idx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep2().deletePopSubDep2ByPopSubDep1Idx( schema.getAuthorization(),
				PopSubDep1TenantId,
				PopSubDep1Id );
		}
	}

	public void deletePopSubDep2ByUNameIdx( long PopSubDep1TenantId,
		long PopSubDep1Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamPopSubDep2ByUNameIdxKey,
				ICFBamPopSubDep2Obj >();
		}
		CFBamPopSubDep2ByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep2().newUNameIdxKey();
		key.setRequiredPopSubDep1TenantId( PopSubDep1TenantId );
		key.setRequiredPopSubDep1Id( PopSubDep1Id );
		key.setRequiredName( Name );
		ICFBamPopSubDep2Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep2().deletePopSubDep2ByUNameIdx( schema.getAuthorization(),
				PopSubDep1TenantId,
				PopSubDep1Id,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep2().deletePopSubDep2ByUNameIdx( schema.getAuthorization(),
				PopSubDep1TenantId,
				PopSubDep1Id,
				Name );
		}
	}
}
