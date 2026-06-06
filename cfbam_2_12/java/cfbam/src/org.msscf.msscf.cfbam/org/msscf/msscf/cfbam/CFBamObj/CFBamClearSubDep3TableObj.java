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

public class CFBamClearSubDep3TableObj
	implements ICFBamClearSubDep3TableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamClearSubDep3Obj> members;
	private Map<CFBamScopePKey, ICFBamClearSubDep3Obj> allClearSubDep3;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep3Obj > > indexByTenantIdx;
	private Map< CFBamClearDepByClearDepIdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep3Obj > > indexByClearDepIdx;
	private Map< CFBamClearDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep3Obj > > indexByDefSchemaIdx;
	private Map< CFBamClearSubDep3ByClearSubDep2IdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep3Obj > > indexByClearSubDep2Idx;
	private Map< CFBamClearSubDep3ByUNameIdxKey,
		ICFBamClearSubDep3Obj > indexByUNameIdx;
	public static String TABLE_NAME = "ClearSubDep3";
	public static String TABLE_DBNAME = "clrsubdep3";

	public CFBamClearSubDep3TableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamClearSubDep3Obj>();
		allClearSubDep3 = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		indexByClearSubDep2Idx = null;
		indexByUNameIdx = null;
	}

	public CFBamClearSubDep3TableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamClearSubDep3Obj>();
		allClearSubDep3 = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		indexByClearSubDep2Idx = null;
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
		allClearSubDep3 = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		indexByClearSubDep2Idx = null;
		indexByUNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearSubDep3Obj.
	 */
	public ICFBamClearSubDep3Obj newInstance() {
		ICFBamClearSubDep3Obj inst = new CFBamClearSubDep3Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearSubDep3Obj.
	 */
	public ICFBamClearSubDep3EditObj newEditInstance( ICFBamClearSubDep3Obj orig ) {
		ICFBamClearSubDep3EditObj edit = new CFBamClearSubDep3EditObj( orig );
		return( edit );
	}

	public ICFBamClearSubDep3Obj realiseClearSubDep3( ICFBamClearSubDep3Obj Obj ) {
		ICFBamClearSubDep3Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamClearSubDep3Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamClearSubDep3Obj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					indexByClearDepIdx.remove( keyClearDepIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByClearSubDep2Idx != null ) {
				CFBamClearSubDep3ByClearSubDep2IdxKey keyClearSubDep2Idx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep3().newClearSubDep2IdxKey();
				keyClearSubDep2Idx.setRequiredClearSubDep2TenantId( keepObj.getRequiredClearSubDep2TenantId() );
				keyClearSubDep2Idx.setRequiredClearSubDep2Id( keepObj.getRequiredClearSubDep2Id() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapClearSubDep2Idx = indexByClearSubDep2Idx.get( keyClearSubDep2Idx );
				if( mapClearSubDep2Idx != null ) {
					mapClearSubDep2Idx.remove( keepObj.getPKey() );
					if( mapClearSubDep2Idx.size() <= 0 ) {
						indexByClearSubDep2Idx.remove( keyClearSubDep2Idx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep3ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep3().newUNameIdxKey();
				keyUNameIdx.setRequiredClearSubDep2TenantId( keepObj.getRequiredClearSubDep2TenantId() );
				keyUNameIdx.setRequiredClearSubDep2Id( keepObj.getRequiredClearSubDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamClearSubDep3Obj)schema.getClearDepTableObj().realiseClearDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearSubDep2Idx != null ) {
				CFBamClearSubDep3ByClearSubDep2IdxKey keyClearSubDep2Idx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep3().newClearSubDep2IdxKey();
				keyClearSubDep2Idx.setRequiredClearSubDep2TenantId( keepObj.getRequiredClearSubDep2TenantId() );
				keyClearSubDep2Idx.setRequiredClearSubDep2Id( keepObj.getRequiredClearSubDep2Id() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapClearSubDep2Idx = indexByClearSubDep2Idx.get( keyClearSubDep2Idx );
				if( mapClearSubDep2Idx != null ) {
					mapClearSubDep2Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep3ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep3().newUNameIdxKey();
				keyUNameIdx.setRequiredClearSubDep2TenantId( keepObj.getRequiredClearSubDep2TenantId() );
				keyUNameIdx.setRequiredClearSubDep2Id( keepObj.getRequiredClearSubDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allClearSubDep3 != null ) {
				allClearSubDep3.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamClearSubDep3Obj)schema.getClearDepTableObj().realiseClearDep( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allClearSubDep3 != null ) {
				allClearSubDep3.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearSubDep2Idx != null ) {
				CFBamClearSubDep3ByClearSubDep2IdxKey keyClearSubDep2Idx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep3().newClearSubDep2IdxKey();
				keyClearSubDep2Idx.setRequiredClearSubDep2TenantId( keepObj.getRequiredClearSubDep2TenantId() );
				keyClearSubDep2Idx.setRequiredClearSubDep2Id( keepObj.getRequiredClearSubDep2Id() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapClearSubDep2Idx = indexByClearSubDep2Idx.get( keyClearSubDep2Idx );
				if( mapClearSubDep2Idx != null ) {
					mapClearSubDep2Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep3ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep3().newUNameIdxKey();
				keyUNameIdx.setRequiredClearSubDep2TenantId( keepObj.getRequiredClearSubDep2TenantId() );
				keyUNameIdx.setRequiredClearSubDep2Id( keepObj.getRequiredClearSubDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetClearSubDep3( ICFBamClearSubDep3Obj Obj ) {
		forgetClearSubDep3( Obj, false );
	}

	public void forgetClearSubDep3( ICFBamClearSubDep3Obj Obj, boolean forgetSubObjects ) {
		ICFBamClearSubDep3Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamClearSubDep3Obj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					indexByClearDepIdx.remove( keyClearDepIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByClearSubDep2Idx != null ) {
				CFBamClearSubDep3ByClearSubDep2IdxKey keyClearSubDep2Idx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep3().newClearSubDep2IdxKey();
				keyClearSubDep2Idx.setRequiredClearSubDep2TenantId( keepObj.getRequiredClearSubDep2TenantId() );
				keyClearSubDep2Idx.setRequiredClearSubDep2Id( keepObj.getRequiredClearSubDep2Id() );
				Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapClearSubDep2Idx = indexByClearSubDep2Idx.get( keyClearSubDep2Idx );
				if( mapClearSubDep2Idx != null ) {
					mapClearSubDep2Idx.remove( keepObj.getPKey() );
					if( mapClearSubDep2Idx.size() <= 0 ) {
						indexByClearSubDep2Idx.remove( keyClearSubDep2Idx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep3ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep3().newUNameIdxKey();
				keyUNameIdx.setRequiredClearSubDep2TenantId( keepObj.getRequiredClearSubDep2TenantId() );
				keyUNameIdx.setRequiredClearSubDep2Id( keepObj.getRequiredClearSubDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allClearSubDep3 != null ) {
				allClearSubDep3.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		((ICFBamSchemaObj)schema).getClearDepTableObj().forgetClearDep( obj );
	}

	public void forgetClearSubDep3ByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamClearSubDep3Obj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetClearSubDep3ByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamClearSubDep3Obj> toForget = new LinkedList<ICFBamClearSubDep3Obj>();
		ICFBamClearSubDep3Obj cur = null;
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamClearSubDep3Obj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearSubDep3Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearSubDep3Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearSubDep3ByClearDepIdx( long TenantId,
		long RelationId )
	{
		if( indexByClearDepIdx == null ) {
			return;
		}
		List<ICFBamClearSubDep3Obj> toForget = new LinkedList<ICFBamClearSubDep3Obj>();
		ICFBamClearSubDep3Obj cur = null;
		CFBamClearDepByClearDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByClearDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapClearDepIdx = indexByClearDepIdx.get( key );
			if( mapClearDepIdx != null ) {
				Iterator<ICFBamClearSubDep3Obj> iterDup = mapClearDepIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClearDepIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearSubDep3Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearSubDep3Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearSubDep3ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamClearSubDep3Obj> toForget = new LinkedList<ICFBamClearSubDep3Obj>();
		ICFBamClearSubDep3Obj cur = null;
		CFBamClearDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamClearSubDep3Obj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearSubDep3Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearSubDep3Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearSubDep3ByClearSubDep2Idx( long ClearSubDep2TenantId,
		long ClearSubDep2Id )
	{
		if( indexByClearSubDep2Idx == null ) {
			return;
		}
		List<ICFBamClearSubDep3Obj> toForget = new LinkedList<ICFBamClearSubDep3Obj>();
		ICFBamClearSubDep3Obj cur = null;
		CFBamClearSubDep3ByClearSubDep2IdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep3().newClearSubDep2IdxKey();
		key.setRequiredClearSubDep2TenantId( ClearSubDep2TenantId );
		key.setRequiredClearSubDep2Id( ClearSubDep2Id );
		if( indexByClearSubDep2Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep3Obj > mapClearSubDep2Idx = indexByClearSubDep2Idx.get( key );
			if( mapClearSubDep2Idx != null ) {
				Iterator<ICFBamClearSubDep3Obj> iterDup = mapClearSubDep2Idx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClearSubDep2Idx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearSubDep3Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearSubDep3Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearSubDep3ByUNameIdx( long ClearSubDep2TenantId,
		long ClearSubDep2Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamClearSubDep3Obj> toForget = new LinkedList<ICFBamClearSubDep3Obj>();
		ICFBamClearSubDep3Obj cur = null;
		CFBamClearSubDep3ByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep3().newUNameIdxKey();
		key.setRequiredClearSubDep2TenantId( ClearSubDep2TenantId );
		key.setRequiredClearSubDep2Id( ClearSubDep2Id );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamClearSubDep3Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamClearSubDep3Obj createClearSubDep3( ICFBamClearSubDep3Obj Obj ) {
		ICFBamClearSubDep3Obj obj = Obj;
		CFBamClearSubDep3Buff buff = obj.getClearSubDep3Buff();
		((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().createClearSubDep3(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "CLR3" ) ) {
			obj = (ICFBamClearSubDep3Obj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamClearSubDep3Obj readClearSubDep3( CFBamScopePKey pkey ) {
		return( readClearSubDep3( pkey, false ) );
	}

	public ICFBamClearSubDep3Obj readClearSubDep3( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamClearSubDep3Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamClearSubDep3Buff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamClearSubDep3Obj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamClearSubDep3Obj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamClearSubDep3Obj lockClearSubDep3( CFBamScopePKey pkey ) {
		ICFBamClearSubDep3Obj locked = null;
		CFBamClearSubDep3Buff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamClearSubDep3Obj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamClearSubDep3Obj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockClearSubDep3", pkey );
		}
		return( locked );
	}

	public List<ICFBamClearSubDep3Obj> readAllClearSubDep3() {
		return( readAllClearSubDep3( false ) );
	}

	public List<ICFBamClearSubDep3Obj> readAllClearSubDep3( boolean forceRead ) {
		final String S_ProcName = "readAllClearSubDep3";
		if( ( allClearSubDep3 == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamClearSubDep3Obj> map = new HashMap<CFBamScopePKey,ICFBamClearSubDep3Obj>();
			allClearSubDep3 = map;
			CFBamClearSubDep3Buff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().readAllDerived( schema.getAuthorization() );
			CFBamClearSubDep3Buff buff;
			ICFBamClearSubDep3Obj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep3Obj realised = (ICFBamClearSubDep3Obj)obj.realise();
			}
		}
		int len = allClearSubDep3.size();
		ICFBamClearSubDep3Obj arr[] = new ICFBamClearSubDep3Obj[len];
		Iterator<ICFBamClearSubDep3Obj> valIter = allClearSubDep3.values().iterator();
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
		ArrayList<ICFBamClearSubDep3Obj> arrayList = new ArrayList<ICFBamClearSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearSubDep3Obj> cmp = new Comparator<ICFBamClearSubDep3Obj>() {
			public int compare( ICFBamClearSubDep3Obj lhs, ICFBamClearSubDep3Obj rhs ) {
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
		List<ICFBamClearSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearSubDep3Obj readClearSubDep3ByIdIdx( long TenantId,
		long Id )
	{
		return( readClearSubDep3ByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamClearSubDep3Obj readClearSubDep3ByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamClearSubDep3Obj obj = readClearSubDep3( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamClearSubDep3Obj> readClearSubDep3ByTenantIdx( long TenantId )
	{
		return( readClearSubDep3ByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamClearSubDep3Obj> readClearSubDep3ByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep3ByTenantIdx";
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamClearSubDep3Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep3Obj>();
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep3Obj realised = (ICFBamClearSubDep3Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearSubDep3Obj arr[] = new ICFBamClearSubDep3Obj[len];
		Iterator<ICFBamClearSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep3Obj> arrayList = new ArrayList<ICFBamClearSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearSubDep3Obj> cmp = new Comparator<ICFBamClearSubDep3Obj>() {
			public int compare( ICFBamClearSubDep3Obj lhs, ICFBamClearSubDep3Obj rhs ) {
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
		List<ICFBamClearSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearSubDep3Obj> readClearSubDep3ByClearDepIdx( long TenantId,
		long RelationId )
	{
		return( readClearSubDep3ByClearDepIdx( TenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamClearSubDep3Obj> readClearSubDep3ByClearDepIdx( long TenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep3ByClearDepIdx";
		CFBamClearDepByClearDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamClearSubDep3Obj> dict;
		if( indexByClearDepIdx == null ) {
			indexByClearDepIdx = new HashMap< CFBamClearDepByClearDepIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByClearDepIdx.containsKey( key ) ) {
			dict = indexByClearDepIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep3Obj>();
			ICFBamClearDepObj obj;
			CFBamClearDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearDep().readDerivedByClearDepIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			CFBamClearDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep3Obj realised = (ICFBamClearSubDep3Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClearDepIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearSubDep3Obj arr[] = new ICFBamClearSubDep3Obj[len];
		Iterator<ICFBamClearSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep3Obj> arrayList = new ArrayList<ICFBamClearSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearSubDep3Obj> cmp = new Comparator<ICFBamClearSubDep3Obj>() {
			public int compare( ICFBamClearSubDep3Obj lhs, ICFBamClearSubDep3Obj rhs ) {
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
		List<ICFBamClearSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearSubDep3Obj> readClearSubDep3ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readClearSubDep3ByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamClearSubDep3Obj> readClearSubDep3ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep3ByDefSchemaIdx";
		CFBamClearDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamClearSubDep3Obj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamClearDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep3Obj>();
			ICFBamClearDepObj obj;
			CFBamClearDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamClearDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep3Obj realised = (ICFBamClearSubDep3Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearSubDep3Obj arr[] = new ICFBamClearSubDep3Obj[len];
		Iterator<ICFBamClearSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep3Obj> arrayList = new ArrayList<ICFBamClearSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearSubDep3Obj> cmp = new Comparator<ICFBamClearSubDep3Obj>() {
			public int compare( ICFBamClearSubDep3Obj lhs, ICFBamClearSubDep3Obj rhs ) {
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
		List<ICFBamClearSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearSubDep3Obj> readClearSubDep3ByClearSubDep2Idx( long ClearSubDep2TenantId,
		long ClearSubDep2Id )
	{
		return( readClearSubDep3ByClearSubDep2Idx( ClearSubDep2TenantId,
			ClearSubDep2Id,
			false ) );
	}

	public List<ICFBamClearSubDep3Obj> readClearSubDep3ByClearSubDep2Idx( long ClearSubDep2TenantId,
		long ClearSubDep2Id,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep3ByClearSubDep2Idx";
		CFBamClearSubDep3ByClearSubDep2IdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep3().newClearSubDep2IdxKey();
		key.setRequiredClearSubDep2TenantId( ClearSubDep2TenantId );
		key.setRequiredClearSubDep2Id( ClearSubDep2Id );
		Map<CFBamScopePKey, ICFBamClearSubDep3Obj> dict;
		if( indexByClearSubDep2Idx == null ) {
			indexByClearSubDep2Idx = new HashMap< CFBamClearSubDep3ByClearSubDep2IdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByClearSubDep2Idx.containsKey( key ) ) {
			dict = indexByClearSubDep2Idx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep3Obj>();
			ICFBamClearSubDep3Obj obj;
			CFBamClearSubDep3Buff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().readDerivedByClearSubDep2Idx( schema.getAuthorization(),
				ClearSubDep2TenantId,
				ClearSubDep2Id );
			CFBamClearSubDep3Buff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep3Obj realised = (ICFBamClearSubDep3Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClearSubDep2Idx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearSubDep3Obj arr[] = new ICFBamClearSubDep3Obj[len];
		Iterator<ICFBamClearSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep3Obj> arrayList = new ArrayList<ICFBamClearSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearSubDep3Obj> cmp = new Comparator<ICFBamClearSubDep3Obj>() {
			public int compare( ICFBamClearSubDep3Obj lhs, ICFBamClearSubDep3Obj rhs ) {
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
		List<ICFBamClearSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearSubDep3Obj readClearSubDep3ByUNameIdx( long ClearSubDep2TenantId,
		long ClearSubDep2Id,
		String Name )
	{
		return( readClearSubDep3ByUNameIdx( ClearSubDep2TenantId,
			ClearSubDep2Id,
			Name,
			false ) );
	}

	public ICFBamClearSubDep3Obj readClearSubDep3ByUNameIdx( long ClearSubDep2TenantId,
		long ClearSubDep2Id,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamClearSubDep3ByUNameIdxKey,
				ICFBamClearSubDep3Obj >();
		}
		CFBamClearSubDep3ByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep3().newUNameIdxKey();
		key.setRequiredClearSubDep2TenantId( ClearSubDep2TenantId );
		key.setRequiredClearSubDep2Id( ClearSubDep2Id );
		key.setRequiredName( Name );
		ICFBamClearSubDep3Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamClearSubDep3Buff buff = ((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().readDerivedByUNameIdx( schema.getAuthorization(),
				ClearSubDep2TenantId,
				ClearSubDep2Id,
				Name );
			if( buff != null ) {
				obj = (ICFBamClearSubDep3Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamClearSubDep3Obj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamClearSubDep3Obj updateClearSubDep3( ICFBamClearSubDep3Obj Obj ) {
		ICFBamClearSubDep3Obj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().updateClearSubDep3( schema.getAuthorization(),
			Obj.getClearSubDep3Buff() );
		if( Obj.getClassCode().equals( "CLR3" ) ) {
			obj = (ICFBamClearSubDep3Obj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteClearSubDep3( ICFBamClearSubDep3Obj Obj ) {
		ICFBamClearSubDep3Obj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().deleteClearSubDep3( schema.getAuthorization(),
			obj.getClearSubDep3Buff() );
		obj.forget( true );
	}

	public void deleteClearSubDep3ByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamClearSubDep3Obj obj = readClearSubDep3( pkey );
		if( obj != null ) {
			ICFBamClearSubDep3EditObj editObj = (ICFBamClearSubDep3EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamClearSubDep3EditObj)obj.beginEdit();
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

	public void deleteClearSubDep3ByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep3Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep3Obj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().deleteClearSubDep3ByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamClearSubDep3Obj> iter = dict.values().iterator();
			ICFBamClearSubDep3Obj obj;
			List<ICFBamClearSubDep3Obj> toForget = new LinkedList<ICFBamClearSubDep3Obj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().deleteClearSubDep3ByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteClearSubDep3ByClearDepIdx( long TenantId,
		long RelationId )
	{
		CFBamClearDepByClearDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByClearDepIdx == null ) {
			indexByClearDepIdx = new HashMap< CFBamClearDepByClearDepIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep3Obj > >();
		}
		if( indexByClearDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep3Obj> dict = indexByClearDepIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().deleteClearSubDep3ByClearDepIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			Iterator<ICFBamClearSubDep3Obj> iter = dict.values().iterator();
			ICFBamClearSubDep3Obj obj;
			List<ICFBamClearSubDep3Obj> toForget = new LinkedList<ICFBamClearSubDep3Obj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().deleteClearSubDep3ByClearDepIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
		}
	}

	public void deleteClearSubDep3ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamClearDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamClearDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep3Obj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep3Obj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().deleteClearSubDep3ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamClearSubDep3Obj> iter = dict.values().iterator();
			ICFBamClearSubDep3Obj obj;
			List<ICFBamClearSubDep3Obj> toForget = new LinkedList<ICFBamClearSubDep3Obj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().deleteClearSubDep3ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteClearSubDep3ByClearSubDep2Idx( long ClearSubDep2TenantId,
		long ClearSubDep2Id )
	{
		CFBamClearSubDep3ByClearSubDep2IdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep3().newClearSubDep2IdxKey();
		key.setRequiredClearSubDep2TenantId( ClearSubDep2TenantId );
		key.setRequiredClearSubDep2Id( ClearSubDep2Id );
		if( indexByClearSubDep2Idx == null ) {
			indexByClearSubDep2Idx = new HashMap< CFBamClearSubDep3ByClearSubDep2IdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep3Obj > >();
		}
		if( indexByClearSubDep2Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep3Obj> dict = indexByClearSubDep2Idx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().deleteClearSubDep3ByClearSubDep2Idx( schema.getAuthorization(),
				ClearSubDep2TenantId,
				ClearSubDep2Id );
			Iterator<ICFBamClearSubDep3Obj> iter = dict.values().iterator();
			ICFBamClearSubDep3Obj obj;
			List<ICFBamClearSubDep3Obj> toForget = new LinkedList<ICFBamClearSubDep3Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByClearSubDep2Idx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().deleteClearSubDep3ByClearSubDep2Idx( schema.getAuthorization(),
				ClearSubDep2TenantId,
				ClearSubDep2Id );
		}
	}

	public void deleteClearSubDep3ByUNameIdx( long ClearSubDep2TenantId,
		long ClearSubDep2Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamClearSubDep3ByUNameIdxKey,
				ICFBamClearSubDep3Obj >();
		}
		CFBamClearSubDep3ByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep3().newUNameIdxKey();
		key.setRequiredClearSubDep2TenantId( ClearSubDep2TenantId );
		key.setRequiredClearSubDep2Id( ClearSubDep2Id );
		key.setRequiredName( Name );
		ICFBamClearSubDep3Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().deleteClearSubDep3ByUNameIdx( schema.getAuthorization(),
				ClearSubDep2TenantId,
				ClearSubDep2Id,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().deleteClearSubDep3ByUNameIdx( schema.getAuthorization(),
				ClearSubDep2TenantId,
				ClearSubDep2Id,
				Name );
		}
	}
}
