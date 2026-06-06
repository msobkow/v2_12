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

public class CFBamClearSubDep1TableObj
	implements ICFBamClearSubDep1TableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamClearSubDep1Obj> members;
	private Map<CFBamScopePKey, ICFBamClearSubDep1Obj> allClearSubDep1;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep1Obj > > indexByTenantIdx;
	private Map< CFBamClearDepByClearDepIdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep1Obj > > indexByClearDepIdx;
	private Map< CFBamClearDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep1Obj > > indexByDefSchemaIdx;
	private Map< CFBamClearSubDep1ByClearTopDepIdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep1Obj > > indexByClearTopDepIdx;
	private Map< CFBamClearSubDep1ByUNameIdxKey,
		ICFBamClearSubDep1Obj > indexByUNameIdx;
	public static String TABLE_NAME = "ClearSubDep1";
	public static String TABLE_DBNAME = "clrsubdep1";

	public CFBamClearSubDep1TableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamClearSubDep1Obj>();
		allClearSubDep1 = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		indexByClearTopDepIdx = null;
		indexByUNameIdx = null;
	}

	public CFBamClearSubDep1TableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamClearSubDep1Obj>();
		allClearSubDep1 = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		indexByClearTopDepIdx = null;
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
		allClearSubDep1 = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		indexByClearTopDepIdx = null;
		indexByUNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearSubDep1Obj.
	 */
	public ICFBamClearSubDep1Obj newInstance() {
		ICFBamClearSubDep1Obj inst = new CFBamClearSubDep1Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearSubDep1Obj.
	 */
	public ICFBamClearSubDep1EditObj newEditInstance( ICFBamClearSubDep1Obj orig ) {
		ICFBamClearSubDep1EditObj edit = new CFBamClearSubDep1EditObj( orig );
		return( edit );
	}

	public ICFBamClearSubDep1Obj realiseClearSubDep1( ICFBamClearSubDep1Obj Obj ) {
		ICFBamClearSubDep1Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamClearSubDep1Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamClearSubDep1Obj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					indexByClearDepIdx.remove( keyClearDepIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByClearTopDepIdx != null ) {
				CFBamClearSubDep1ByClearTopDepIdxKey keyClearTopDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep1().newClearTopDepIdxKey();
				keyClearTopDepIdx.setRequiredClearTopDepTenantId( keepObj.getRequiredClearTopDepTenantId() );
				keyClearTopDepIdx.setRequiredClearTopDepId( keepObj.getRequiredClearTopDepId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapClearTopDepIdx = indexByClearTopDepIdx.get( keyClearTopDepIdx );
				if( mapClearTopDepIdx != null ) {
					mapClearTopDepIdx.remove( keepObj.getPKey() );
					if( mapClearTopDepIdx.size() <= 0 ) {
						indexByClearTopDepIdx.remove( keyClearTopDepIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep1ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredClearTopDepTenantId( keepObj.getRequiredClearTopDepTenantId() );
				keyUNameIdx.setRequiredClearTopDepId( keepObj.getRequiredClearTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamClearSubDep1Obj)schema.getClearDepTableObj().realiseClearDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearTopDepIdx != null ) {
				CFBamClearSubDep1ByClearTopDepIdxKey keyClearTopDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep1().newClearTopDepIdxKey();
				keyClearTopDepIdx.setRequiredClearTopDepTenantId( keepObj.getRequiredClearTopDepTenantId() );
				keyClearTopDepIdx.setRequiredClearTopDepId( keepObj.getRequiredClearTopDepId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapClearTopDepIdx = indexByClearTopDepIdx.get( keyClearTopDepIdx );
				if( mapClearTopDepIdx != null ) {
					mapClearTopDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep1ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredClearTopDepTenantId( keepObj.getRequiredClearTopDepTenantId() );
				keyUNameIdx.setRequiredClearTopDepId( keepObj.getRequiredClearTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allClearSubDep1 != null ) {
				allClearSubDep1.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamClearSubDep1Obj)schema.getClearDepTableObj().realiseClearDep( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allClearSubDep1 != null ) {
				allClearSubDep1.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearTopDepIdx != null ) {
				CFBamClearSubDep1ByClearTopDepIdxKey keyClearTopDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep1().newClearTopDepIdxKey();
				keyClearTopDepIdx.setRequiredClearTopDepTenantId( keepObj.getRequiredClearTopDepTenantId() );
				keyClearTopDepIdx.setRequiredClearTopDepId( keepObj.getRequiredClearTopDepId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapClearTopDepIdx = indexByClearTopDepIdx.get( keyClearTopDepIdx );
				if( mapClearTopDepIdx != null ) {
					mapClearTopDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep1ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredClearTopDepTenantId( keepObj.getRequiredClearTopDepTenantId() );
				keyUNameIdx.setRequiredClearTopDepId( keepObj.getRequiredClearTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetClearSubDep1( ICFBamClearSubDep1Obj Obj ) {
		forgetClearSubDep1( Obj, false );
	}

	public void forgetClearSubDep1( ICFBamClearSubDep1Obj Obj, boolean forgetSubObjects ) {
		ICFBamClearSubDep1Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamClearSubDep1Obj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					indexByClearDepIdx.remove( keyClearDepIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByClearTopDepIdx != null ) {
				CFBamClearSubDep1ByClearTopDepIdxKey keyClearTopDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep1().newClearTopDepIdxKey();
				keyClearTopDepIdx.setRequiredClearTopDepTenantId( keepObj.getRequiredClearTopDepTenantId() );
				keyClearTopDepIdx.setRequiredClearTopDepId( keepObj.getRequiredClearTopDepId() );
				Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapClearTopDepIdx = indexByClearTopDepIdx.get( keyClearTopDepIdx );
				if( mapClearTopDepIdx != null ) {
					mapClearTopDepIdx.remove( keepObj.getPKey() );
					if( mapClearTopDepIdx.size() <= 0 ) {
						indexByClearTopDepIdx.remove( keyClearTopDepIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep1ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredClearTopDepTenantId( keepObj.getRequiredClearTopDepTenantId() );
				keyUNameIdx.setRequiredClearTopDepId( keepObj.getRequiredClearTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allClearSubDep1 != null ) {
				allClearSubDep1.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFBamSchemaObj)schema).getClearSubDep2TableObj().forgetClearSubDep2ByClearSubDep1Idx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		((ICFBamSchemaObj)schema).getClearDepTableObj().forgetClearDep( obj );
	}

	public void forgetClearSubDep1ByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamClearSubDep1Obj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetClearSubDep1ByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamClearSubDep1Obj> toForget = new LinkedList<ICFBamClearSubDep1Obj>();
		ICFBamClearSubDep1Obj cur = null;
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamClearSubDep1Obj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearSubDep1Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearSubDep1Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearSubDep1ByClearDepIdx( long TenantId,
		long RelationId )
	{
		if( indexByClearDepIdx == null ) {
			return;
		}
		List<ICFBamClearSubDep1Obj> toForget = new LinkedList<ICFBamClearSubDep1Obj>();
		ICFBamClearSubDep1Obj cur = null;
		CFBamClearDepByClearDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByClearDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapClearDepIdx = indexByClearDepIdx.get( key );
			if( mapClearDepIdx != null ) {
				Iterator<ICFBamClearSubDep1Obj> iterDup = mapClearDepIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClearDepIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearSubDep1Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearSubDep1Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamClearSubDep1Obj> toForget = new LinkedList<ICFBamClearSubDep1Obj>();
		ICFBamClearSubDep1Obj cur = null;
		CFBamClearDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamClearSubDep1Obj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearSubDep1Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearSubDep1Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearSubDep1ByClearTopDepIdx( long ClearTopDepTenantId,
		long ClearTopDepId )
	{
		if( indexByClearTopDepIdx == null ) {
			return;
		}
		List<ICFBamClearSubDep1Obj> toForget = new LinkedList<ICFBamClearSubDep1Obj>();
		ICFBamClearSubDep1Obj cur = null;
		CFBamClearSubDep1ByClearTopDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep1().newClearTopDepIdxKey();
		key.setRequiredClearTopDepTenantId( ClearTopDepTenantId );
		key.setRequiredClearTopDepId( ClearTopDepId );
		if( indexByClearTopDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep1Obj > mapClearTopDepIdx = indexByClearTopDepIdx.get( key );
			if( mapClearTopDepIdx != null ) {
				Iterator<ICFBamClearSubDep1Obj> iterDup = mapClearTopDepIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClearTopDepIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearSubDep1Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearSubDep1Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearSubDep1ByUNameIdx( long ClearTopDepTenantId,
		long ClearTopDepId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamClearSubDep1Obj> toForget = new LinkedList<ICFBamClearSubDep1Obj>();
		ICFBamClearSubDep1Obj cur = null;
		CFBamClearSubDep1ByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep1().newUNameIdxKey();
		key.setRequiredClearTopDepTenantId( ClearTopDepTenantId );
		key.setRequiredClearTopDepId( ClearTopDepId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamClearSubDep1Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamClearSubDep1Obj createClearSubDep1( ICFBamClearSubDep1Obj Obj ) {
		ICFBamClearSubDep1Obj obj = Obj;
		CFBamClearSubDep1Buff buff = obj.getClearSubDep1Buff();
		((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep1().createClearSubDep1(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "CLR1" ) ) {
			obj = (ICFBamClearSubDep1Obj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamClearSubDep1Obj readClearSubDep1( CFBamScopePKey pkey ) {
		return( readClearSubDep1( pkey, false ) );
	}

	public ICFBamClearSubDep1Obj readClearSubDep1( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamClearSubDep1Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamClearSubDep1Buff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep1().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamClearSubDep1Obj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamClearSubDep1Obj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamClearSubDep1Obj lockClearSubDep1( CFBamScopePKey pkey ) {
		ICFBamClearSubDep1Obj locked = null;
		CFBamClearSubDep1Buff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep1().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamClearSubDep1Obj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamClearSubDep1Obj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockClearSubDep1", pkey );
		}
		return( locked );
	}

	public List<ICFBamClearSubDep1Obj> readAllClearSubDep1() {
		return( readAllClearSubDep1( false ) );
	}

	public List<ICFBamClearSubDep1Obj> readAllClearSubDep1( boolean forceRead ) {
		final String S_ProcName = "readAllClearSubDep1";
		if( ( allClearSubDep1 == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamClearSubDep1Obj> map = new HashMap<CFBamScopePKey,ICFBamClearSubDep1Obj>();
			allClearSubDep1 = map;
			CFBamClearSubDep1Buff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep1().readAllDerived( schema.getAuthorization() );
			CFBamClearSubDep1Buff buff;
			ICFBamClearSubDep1Obj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep1Obj realised = (ICFBamClearSubDep1Obj)obj.realise();
			}
		}
		int len = allClearSubDep1.size();
		ICFBamClearSubDep1Obj arr[] = new ICFBamClearSubDep1Obj[len];
		Iterator<ICFBamClearSubDep1Obj> valIter = allClearSubDep1.values().iterator();
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
		ArrayList<ICFBamClearSubDep1Obj> arrayList = new ArrayList<ICFBamClearSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearSubDep1Obj> cmp = new Comparator<ICFBamClearSubDep1Obj>() {
			public int compare( ICFBamClearSubDep1Obj lhs, ICFBamClearSubDep1Obj rhs ) {
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
		List<ICFBamClearSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearSubDep1Obj readClearSubDep1ByIdIdx( long TenantId,
		long Id )
	{
		return( readClearSubDep1ByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamClearSubDep1Obj readClearSubDep1ByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamClearSubDep1Obj obj = readClearSubDep1( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamClearSubDep1Obj> readClearSubDep1ByTenantIdx( long TenantId )
	{
		return( readClearSubDep1ByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamClearSubDep1Obj> readClearSubDep1ByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep1ByTenantIdx";
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamClearSubDep1Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep1Obj>();
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep1Obj realised = (ICFBamClearSubDep1Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearSubDep1Obj arr[] = new ICFBamClearSubDep1Obj[len];
		Iterator<ICFBamClearSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep1Obj> arrayList = new ArrayList<ICFBamClearSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearSubDep1Obj> cmp = new Comparator<ICFBamClearSubDep1Obj>() {
			public int compare( ICFBamClearSubDep1Obj lhs, ICFBamClearSubDep1Obj rhs ) {
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
		List<ICFBamClearSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearSubDep1Obj> readClearSubDep1ByClearDepIdx( long TenantId,
		long RelationId )
	{
		return( readClearSubDep1ByClearDepIdx( TenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamClearSubDep1Obj> readClearSubDep1ByClearDepIdx( long TenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep1ByClearDepIdx";
		CFBamClearDepByClearDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamClearSubDep1Obj> dict;
		if( indexByClearDepIdx == null ) {
			indexByClearDepIdx = new HashMap< CFBamClearDepByClearDepIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByClearDepIdx.containsKey( key ) ) {
			dict = indexByClearDepIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep1Obj>();
			ICFBamClearDepObj obj;
			CFBamClearDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearDep().readDerivedByClearDepIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			CFBamClearDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep1Obj realised = (ICFBamClearSubDep1Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClearDepIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearSubDep1Obj arr[] = new ICFBamClearSubDep1Obj[len];
		Iterator<ICFBamClearSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep1Obj> arrayList = new ArrayList<ICFBamClearSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearSubDep1Obj> cmp = new Comparator<ICFBamClearSubDep1Obj>() {
			public int compare( ICFBamClearSubDep1Obj lhs, ICFBamClearSubDep1Obj rhs ) {
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
		List<ICFBamClearSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearSubDep1Obj> readClearSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readClearSubDep1ByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamClearSubDep1Obj> readClearSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep1ByDefSchemaIdx";
		CFBamClearDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamClearSubDep1Obj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamClearDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep1Obj>();
			ICFBamClearDepObj obj;
			CFBamClearDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamClearDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep1Obj realised = (ICFBamClearSubDep1Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearSubDep1Obj arr[] = new ICFBamClearSubDep1Obj[len];
		Iterator<ICFBamClearSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep1Obj> arrayList = new ArrayList<ICFBamClearSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearSubDep1Obj> cmp = new Comparator<ICFBamClearSubDep1Obj>() {
			public int compare( ICFBamClearSubDep1Obj lhs, ICFBamClearSubDep1Obj rhs ) {
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
		List<ICFBamClearSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearSubDep1Obj> readClearSubDep1ByClearTopDepIdx( long ClearTopDepTenantId,
		long ClearTopDepId )
	{
		return( readClearSubDep1ByClearTopDepIdx( ClearTopDepTenantId,
			ClearTopDepId,
			false ) );
	}

	public List<ICFBamClearSubDep1Obj> readClearSubDep1ByClearTopDepIdx( long ClearTopDepTenantId,
		long ClearTopDepId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep1ByClearTopDepIdx";
		CFBamClearSubDep1ByClearTopDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep1().newClearTopDepIdxKey();
		key.setRequiredClearTopDepTenantId( ClearTopDepTenantId );
		key.setRequiredClearTopDepId( ClearTopDepId );
		Map<CFBamScopePKey, ICFBamClearSubDep1Obj> dict;
		if( indexByClearTopDepIdx == null ) {
			indexByClearTopDepIdx = new HashMap< CFBamClearSubDep1ByClearTopDepIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByClearTopDepIdx.containsKey( key ) ) {
			dict = indexByClearTopDepIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep1Obj>();
			ICFBamClearSubDep1Obj obj;
			CFBamClearSubDep1Buff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep1().readDerivedByClearTopDepIdx( schema.getAuthorization(),
				ClearTopDepTenantId,
				ClearTopDepId );
			CFBamClearSubDep1Buff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep1Obj realised = (ICFBamClearSubDep1Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClearTopDepIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearSubDep1Obj arr[] = new ICFBamClearSubDep1Obj[len];
		Iterator<ICFBamClearSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep1Obj> arrayList = new ArrayList<ICFBamClearSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearSubDep1Obj> cmp = new Comparator<ICFBamClearSubDep1Obj>() {
			public int compare( ICFBamClearSubDep1Obj lhs, ICFBamClearSubDep1Obj rhs ) {
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
		List<ICFBamClearSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearSubDep1Obj readClearSubDep1ByUNameIdx( long ClearTopDepTenantId,
		long ClearTopDepId,
		String Name )
	{
		return( readClearSubDep1ByUNameIdx( ClearTopDepTenantId,
			ClearTopDepId,
			Name,
			false ) );
	}

	public ICFBamClearSubDep1Obj readClearSubDep1ByUNameIdx( long ClearTopDepTenantId,
		long ClearTopDepId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamClearSubDep1ByUNameIdxKey,
				ICFBamClearSubDep1Obj >();
		}
		CFBamClearSubDep1ByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep1().newUNameIdxKey();
		key.setRequiredClearTopDepTenantId( ClearTopDepTenantId );
		key.setRequiredClearTopDepId( ClearTopDepId );
		key.setRequiredName( Name );
		ICFBamClearSubDep1Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamClearSubDep1Buff buff = ((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep1().readDerivedByUNameIdx( schema.getAuthorization(),
				ClearTopDepTenantId,
				ClearTopDepId,
				Name );
			if( buff != null ) {
				obj = (ICFBamClearSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamClearSubDep1Obj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamClearSubDep1Obj updateClearSubDep1( ICFBamClearSubDep1Obj Obj ) {
		ICFBamClearSubDep1Obj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep1().updateClearSubDep1( schema.getAuthorization(),
			Obj.getClearSubDep1Buff() );
		if( Obj.getClassCode().equals( "CLR1" ) ) {
			obj = (ICFBamClearSubDep1Obj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteClearSubDep1( ICFBamClearSubDep1Obj Obj ) {
		ICFBamClearSubDep1Obj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep1().deleteClearSubDep1( schema.getAuthorization(),
			obj.getClearSubDep1Buff() );
		obj.forget( true );
	}

	public void deleteClearSubDep1ByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamClearSubDep1Obj obj = readClearSubDep1( pkey );
		if( obj != null ) {
			ICFBamClearSubDep1EditObj editObj = (ICFBamClearSubDep1EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamClearSubDep1EditObj)obj.beginEdit();
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

	public void deleteClearSubDep1ByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep1Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep1Obj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep1().deleteClearSubDep1ByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamClearSubDep1Obj> iter = dict.values().iterator();
			ICFBamClearSubDep1Obj obj;
			List<ICFBamClearSubDep1Obj> toForget = new LinkedList<ICFBamClearSubDep1Obj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep1().deleteClearSubDep1ByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteClearSubDep1ByClearDepIdx( long TenantId,
		long RelationId )
	{
		CFBamClearDepByClearDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByClearDepIdx == null ) {
			indexByClearDepIdx = new HashMap< CFBamClearDepByClearDepIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep1Obj > >();
		}
		if( indexByClearDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep1Obj> dict = indexByClearDepIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep1().deleteClearSubDep1ByClearDepIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			Iterator<ICFBamClearSubDep1Obj> iter = dict.values().iterator();
			ICFBamClearSubDep1Obj obj;
			List<ICFBamClearSubDep1Obj> toForget = new LinkedList<ICFBamClearSubDep1Obj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep1().deleteClearSubDep1ByClearDepIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
		}
	}

	public void deleteClearSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamClearDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamClearDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep1Obj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep1Obj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep1().deleteClearSubDep1ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamClearSubDep1Obj> iter = dict.values().iterator();
			ICFBamClearSubDep1Obj obj;
			List<ICFBamClearSubDep1Obj> toForget = new LinkedList<ICFBamClearSubDep1Obj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep1().deleteClearSubDep1ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteClearSubDep1ByClearTopDepIdx( long ClearTopDepTenantId,
		long ClearTopDepId )
	{
		CFBamClearSubDep1ByClearTopDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep1().newClearTopDepIdxKey();
		key.setRequiredClearTopDepTenantId( ClearTopDepTenantId );
		key.setRequiredClearTopDepId( ClearTopDepId );
		if( indexByClearTopDepIdx == null ) {
			indexByClearTopDepIdx = new HashMap< CFBamClearSubDep1ByClearTopDepIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep1Obj > >();
		}
		if( indexByClearTopDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep1Obj> dict = indexByClearTopDepIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep1().deleteClearSubDep1ByClearTopDepIdx( schema.getAuthorization(),
				ClearTopDepTenantId,
				ClearTopDepId );
			Iterator<ICFBamClearSubDep1Obj> iter = dict.values().iterator();
			ICFBamClearSubDep1Obj obj;
			List<ICFBamClearSubDep1Obj> toForget = new LinkedList<ICFBamClearSubDep1Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByClearTopDepIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep1().deleteClearSubDep1ByClearTopDepIdx( schema.getAuthorization(),
				ClearTopDepTenantId,
				ClearTopDepId );
		}
	}

	public void deleteClearSubDep1ByUNameIdx( long ClearTopDepTenantId,
		long ClearTopDepId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamClearSubDep1ByUNameIdxKey,
				ICFBamClearSubDep1Obj >();
		}
		CFBamClearSubDep1ByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep1().newUNameIdxKey();
		key.setRequiredClearTopDepTenantId( ClearTopDepTenantId );
		key.setRequiredClearTopDepId( ClearTopDepId );
		key.setRequiredName( Name );
		ICFBamClearSubDep1Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep1().deleteClearSubDep1ByUNameIdx( schema.getAuthorization(),
				ClearTopDepTenantId,
				ClearTopDepId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep1().deleteClearSubDep1ByUNameIdx( schema.getAuthorization(),
				ClearTopDepTenantId,
				ClearTopDepId,
				Name );
		}
	}
}
