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

public class CFBamPopSubDep1TableObj
	implements ICFBamPopSubDep1TableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamPopSubDep1Obj> members;
	private Map<CFBamScopePKey, ICFBamPopSubDep1Obj> allPopSubDep1;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep1Obj > > indexByTenantIdx;
	private Map< CFBamPopDepByRelationIdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep1Obj > > indexByRelationIdx;
	private Map< CFBamPopDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep1Obj > > indexByDefSchemaIdx;
	private Map< CFBamPopSubDep1ByPopTopDepIdxKey,
		Map<CFBamScopePKey, ICFBamPopSubDep1Obj > > indexByPopTopDepIdx;
	private Map< CFBamPopSubDep1ByUNameIdxKey,
		ICFBamPopSubDep1Obj > indexByUNameIdx;
	public static String TABLE_NAME = "PopSubDep1";
	public static String TABLE_DBNAME = "popsubdep1";

	public CFBamPopSubDep1TableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamPopSubDep1Obj>();
		allPopSubDep1 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByPopTopDepIdx = null;
		indexByUNameIdx = null;
	}

	public CFBamPopSubDep1TableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamPopSubDep1Obj>();
		allPopSubDep1 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByPopTopDepIdx = null;
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
		allPopSubDep1 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByPopTopDepIdx = null;
		indexByUNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamPopSubDep1Obj.
	 */
	public ICFBamPopSubDep1Obj newInstance() {
		ICFBamPopSubDep1Obj inst = new CFBamPopSubDep1Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamPopSubDep1Obj.
	 */
	public ICFBamPopSubDep1EditObj newEditInstance( ICFBamPopSubDep1Obj orig ) {
		ICFBamPopSubDep1EditObj edit = new CFBamPopSubDep1EditObj( orig );
		return( edit );
	}

	public ICFBamPopSubDep1Obj realisePopSubDep1( ICFBamPopSubDep1Obj Obj ) {
		ICFBamPopSubDep1Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamPopSubDep1Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamPopSubDep1Obj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					indexByRelationIdx.remove( keyRelationIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPopTopDepIdx != null ) {
				CFBamPopSubDep1ByPopTopDepIdxKey keyPopTopDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep1().newPopTopDepIdxKey();
				keyPopTopDepIdx.setRequiredPopTopDepTenantId( keepObj.getRequiredPopTopDepTenantId() );
				keyPopTopDepIdx.setRequiredPopTopDepId( keepObj.getRequiredPopTopDepId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapPopTopDepIdx = indexByPopTopDepIdx.get( keyPopTopDepIdx );
				if( mapPopTopDepIdx != null ) {
					mapPopTopDepIdx.remove( keepObj.getPKey() );
					if( mapPopTopDepIdx.size() <= 0 ) {
						indexByPopTopDepIdx.remove( keyPopTopDepIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep1ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredPopTopDepTenantId( keepObj.getRequiredPopTopDepTenantId() );
				keyUNameIdx.setRequiredPopTopDepId( keepObj.getRequiredPopTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamPopSubDep1Obj)schema.getPopDepTableObj().realisePopDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPopTopDepIdx != null ) {
				CFBamPopSubDep1ByPopTopDepIdxKey keyPopTopDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep1().newPopTopDepIdxKey();
				keyPopTopDepIdx.setRequiredPopTopDepTenantId( keepObj.getRequiredPopTopDepTenantId() );
				keyPopTopDepIdx.setRequiredPopTopDepId( keepObj.getRequiredPopTopDepId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapPopTopDepIdx = indexByPopTopDepIdx.get( keyPopTopDepIdx );
				if( mapPopTopDepIdx != null ) {
					mapPopTopDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep1ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredPopTopDepTenantId( keepObj.getRequiredPopTopDepTenantId() );
				keyUNameIdx.setRequiredPopTopDepId( keepObj.getRequiredPopTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allPopSubDep1 != null ) {
				allPopSubDep1.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamPopSubDep1Obj)schema.getPopDepTableObj().realisePopDep( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allPopSubDep1 != null ) {
				allPopSubDep1.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPopTopDepIdx != null ) {
				CFBamPopSubDep1ByPopTopDepIdxKey keyPopTopDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep1().newPopTopDepIdxKey();
				keyPopTopDepIdx.setRequiredPopTopDepTenantId( keepObj.getRequiredPopTopDepTenantId() );
				keyPopTopDepIdx.setRequiredPopTopDepId( keepObj.getRequiredPopTopDepId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapPopTopDepIdx = indexByPopTopDepIdx.get( keyPopTopDepIdx );
				if( mapPopTopDepIdx != null ) {
					mapPopTopDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep1ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredPopTopDepTenantId( keepObj.getRequiredPopTopDepTenantId() );
				keyUNameIdx.setRequiredPopTopDepId( keepObj.getRequiredPopTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetPopSubDep1( ICFBamPopSubDep1Obj Obj ) {
		forgetPopSubDep1( Obj, false );
	}

	public void forgetPopSubDep1( ICFBamPopSubDep1Obj Obj, boolean forgetSubObjects ) {
		ICFBamPopSubDep1Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamPopSubDep1Obj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					indexByRelationIdx.remove( keyRelationIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPopTopDepIdx != null ) {
				CFBamPopSubDep1ByPopTopDepIdxKey keyPopTopDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep1().newPopTopDepIdxKey();
				keyPopTopDepIdx.setRequiredPopTopDepTenantId( keepObj.getRequiredPopTopDepTenantId() );
				keyPopTopDepIdx.setRequiredPopTopDepId( keepObj.getRequiredPopTopDepId() );
				Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapPopTopDepIdx = indexByPopTopDepIdx.get( keyPopTopDepIdx );
				if( mapPopTopDepIdx != null ) {
					mapPopTopDepIdx.remove( keepObj.getPKey() );
					if( mapPopTopDepIdx.size() <= 0 ) {
						indexByPopTopDepIdx.remove( keyPopTopDepIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopSubDep1ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep1().newUNameIdxKey();
				keyUNameIdx.setRequiredPopTopDepTenantId( keepObj.getRequiredPopTopDepTenantId() );
				keyUNameIdx.setRequiredPopTopDepId( keepObj.getRequiredPopTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allPopSubDep1 != null ) {
				allPopSubDep1.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFBamSchemaObj)schema).getPopSubDep2TableObj().forgetPopSubDep2ByPopSubDep1Idx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		((ICFBamSchemaObj)schema).getPopDepTableObj().forgetPopDep( obj );
	}

	public void forgetPopSubDep1ByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamPopSubDep1Obj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetPopSubDep1ByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamPopSubDep1Obj> toForget = new LinkedList<ICFBamPopSubDep1Obj>();
		ICFBamPopSubDep1Obj cur = null;
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamPopSubDep1Obj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamPopSubDep1Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamPopSubDep1Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetPopSubDep1ByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		if( indexByRelationIdx == null ) {
			return;
		}
		List<ICFBamPopSubDep1Obj> toForget = new LinkedList<ICFBamPopSubDep1Obj>();
		ICFBamPopSubDep1Obj cur = null;
		CFBamPopDepByRelationIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapRelationIdx = indexByRelationIdx.get( key );
			if( mapRelationIdx != null ) {
				Iterator<ICFBamPopSubDep1Obj> iterDup = mapRelationIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRelationIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamPopSubDep1Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamPopSubDep1Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetPopSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamPopSubDep1Obj> toForget = new LinkedList<ICFBamPopSubDep1Obj>();
		ICFBamPopSubDep1Obj cur = null;
		CFBamPopDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamPopSubDep1Obj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamPopSubDep1Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamPopSubDep1Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetPopSubDep1ByPopTopDepIdx( long PopTopDepTenantId,
		long PopTopDepId )
	{
		if( indexByPopTopDepIdx == null ) {
			return;
		}
		List<ICFBamPopSubDep1Obj> toForget = new LinkedList<ICFBamPopSubDep1Obj>();
		ICFBamPopSubDep1Obj cur = null;
		CFBamPopSubDep1ByPopTopDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep1().newPopTopDepIdxKey();
		key.setRequiredPopTopDepTenantId( PopTopDepTenantId );
		key.setRequiredPopTopDepId( PopTopDepId );
		if( indexByPopTopDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep1Obj > mapPopTopDepIdx = indexByPopTopDepIdx.get( key );
			if( mapPopTopDepIdx != null ) {
				Iterator<ICFBamPopSubDep1Obj> iterDup = mapPopTopDepIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByPopTopDepIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamPopSubDep1Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamPopSubDep1Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetPopSubDep1ByUNameIdx( long PopTopDepTenantId,
		long PopTopDepId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamPopSubDep1Obj> toForget = new LinkedList<ICFBamPopSubDep1Obj>();
		ICFBamPopSubDep1Obj cur = null;
		CFBamPopSubDep1ByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep1().newUNameIdxKey();
		key.setRequiredPopTopDepTenantId( PopTopDepTenantId );
		key.setRequiredPopTopDepId( PopTopDepId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamPopSubDep1Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamPopSubDep1Obj createPopSubDep1( ICFBamPopSubDep1Obj Obj ) {
		ICFBamPopSubDep1Obj obj = Obj;
		CFBamPopSubDep1Buff buff = obj.getPopSubDep1Buff();
		((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().createPopSubDep1(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "POP1" ) ) {
			obj = (ICFBamPopSubDep1Obj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamPopSubDep1Obj readPopSubDep1( CFBamScopePKey pkey ) {
		return( readPopSubDep1( pkey, false ) );
	}

	public ICFBamPopSubDep1Obj readPopSubDep1( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamPopSubDep1Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamPopSubDep1Buff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamPopSubDep1Obj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamPopSubDep1Obj lockPopSubDep1( CFBamScopePKey pkey ) {
		ICFBamPopSubDep1Obj locked = null;
		CFBamPopSubDep1Buff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamPopSubDep1Obj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockPopSubDep1", pkey );
		}
		return( locked );
	}

	public List<ICFBamPopSubDep1Obj> readAllPopSubDep1() {
		return( readAllPopSubDep1( false ) );
	}

	public List<ICFBamPopSubDep1Obj> readAllPopSubDep1( boolean forceRead ) {
		final String S_ProcName = "readAllPopSubDep1";
		if( ( allPopSubDep1 == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamPopSubDep1Obj> map = new HashMap<CFBamScopePKey,ICFBamPopSubDep1Obj>();
			allPopSubDep1 = map;
			CFBamPopSubDep1Buff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().readAllDerived( schema.getAuthorization() );
			CFBamPopSubDep1Buff buff;
			ICFBamPopSubDep1Obj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep1Obj realised = (ICFBamPopSubDep1Obj)obj.realise();
			}
		}
		int len = allPopSubDep1.size();
		ICFBamPopSubDep1Obj arr[] = new ICFBamPopSubDep1Obj[len];
		Iterator<ICFBamPopSubDep1Obj> valIter = allPopSubDep1.values().iterator();
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
		ArrayList<ICFBamPopSubDep1Obj> arrayList = new ArrayList<ICFBamPopSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopSubDep1Obj> cmp = new Comparator<ICFBamPopSubDep1Obj>() {
			public int compare( ICFBamPopSubDep1Obj lhs, ICFBamPopSubDep1Obj rhs ) {
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
		List<ICFBamPopSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamPopSubDep1Obj readPopSubDep1ByIdIdx( long TenantId,
		long Id )
	{
		return( readPopSubDep1ByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamPopSubDep1Obj readPopSubDep1ByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamPopSubDep1Obj obj = readPopSubDep1( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamPopSubDep1Obj> readPopSubDep1ByTenantIdx( long TenantId )
	{
		return( readPopSubDep1ByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamPopSubDep1Obj> readPopSubDep1ByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep1ByTenantIdx";
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamPopSubDep1Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep1Obj>();
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep1Obj realised = (ICFBamPopSubDep1Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamPopSubDep1Obj arr[] = new ICFBamPopSubDep1Obj[len];
		Iterator<ICFBamPopSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep1Obj> arrayList = new ArrayList<ICFBamPopSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopSubDep1Obj> cmp = new Comparator<ICFBamPopSubDep1Obj>() {
			public int compare( ICFBamPopSubDep1Obj lhs, ICFBamPopSubDep1Obj rhs ) {
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
		List<ICFBamPopSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopSubDep1Obj> readPopSubDep1ByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		return( readPopSubDep1ByRelationIdx( RelationTenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamPopSubDep1Obj> readPopSubDep1ByRelationIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep1ByRelationIdx";
		CFBamPopDepByRelationIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamPopSubDep1Obj> dict;
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< CFBamPopDepByRelationIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByRelationIdx.containsKey( key ) ) {
			dict = indexByRelationIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep1Obj>();
			ICFBamPopDepObj obj;
			CFBamPopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTablePopDep().readDerivedByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			CFBamPopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep1Obj realised = (ICFBamPopSubDep1Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRelationIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamPopSubDep1Obj arr[] = new ICFBamPopSubDep1Obj[len];
		Iterator<ICFBamPopSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep1Obj> arrayList = new ArrayList<ICFBamPopSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopSubDep1Obj> cmp = new Comparator<ICFBamPopSubDep1Obj>() {
			public int compare( ICFBamPopSubDep1Obj lhs, ICFBamPopSubDep1Obj rhs ) {
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
		List<ICFBamPopSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopSubDep1Obj> readPopSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readPopSubDep1ByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamPopSubDep1Obj> readPopSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep1ByDefSchemaIdx";
		CFBamPopDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamPopSubDep1Obj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamPopDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep1Obj>();
			ICFBamPopDepObj obj;
			CFBamPopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTablePopDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamPopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep1Obj realised = (ICFBamPopSubDep1Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamPopSubDep1Obj arr[] = new ICFBamPopSubDep1Obj[len];
		Iterator<ICFBamPopSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep1Obj> arrayList = new ArrayList<ICFBamPopSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopSubDep1Obj> cmp = new Comparator<ICFBamPopSubDep1Obj>() {
			public int compare( ICFBamPopSubDep1Obj lhs, ICFBamPopSubDep1Obj rhs ) {
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
		List<ICFBamPopSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopSubDep1Obj> readPopSubDep1ByPopTopDepIdx( long PopTopDepTenantId,
		long PopTopDepId )
	{
		return( readPopSubDep1ByPopTopDepIdx( PopTopDepTenantId,
			PopTopDepId,
			false ) );
	}

	public List<ICFBamPopSubDep1Obj> readPopSubDep1ByPopTopDepIdx( long PopTopDepTenantId,
		long PopTopDepId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep1ByPopTopDepIdx";
		CFBamPopSubDep1ByPopTopDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep1().newPopTopDepIdxKey();
		key.setRequiredPopTopDepTenantId( PopTopDepTenantId );
		key.setRequiredPopTopDepId( PopTopDepId );
		Map<CFBamScopePKey, ICFBamPopSubDep1Obj> dict;
		if( indexByPopTopDepIdx == null ) {
			indexByPopTopDepIdx = new HashMap< CFBamPopSubDep1ByPopTopDepIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByPopTopDepIdx.containsKey( key ) ) {
			dict = indexByPopTopDepIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopSubDep1Obj>();
			ICFBamPopSubDep1Obj obj;
			CFBamPopSubDep1Buff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().readDerivedByPopTopDepIdx( schema.getAuthorization(),
				PopTopDepTenantId,
				PopTopDepId );
			CFBamPopSubDep1Buff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopSubDep1Obj realised = (ICFBamPopSubDep1Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPopTopDepIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamPopSubDep1Obj arr[] = new ICFBamPopSubDep1Obj[len];
		Iterator<ICFBamPopSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopSubDep1Obj> arrayList = new ArrayList<ICFBamPopSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopSubDep1Obj> cmp = new Comparator<ICFBamPopSubDep1Obj>() {
			public int compare( ICFBamPopSubDep1Obj lhs, ICFBamPopSubDep1Obj rhs ) {
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
		List<ICFBamPopSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamPopSubDep1Obj readPopSubDep1ByUNameIdx( long PopTopDepTenantId,
		long PopTopDepId,
		String Name )
	{
		return( readPopSubDep1ByUNameIdx( PopTopDepTenantId,
			PopTopDepId,
			Name,
			false ) );
	}

	public ICFBamPopSubDep1Obj readPopSubDep1ByUNameIdx( long PopTopDepTenantId,
		long PopTopDepId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamPopSubDep1ByUNameIdxKey,
				ICFBamPopSubDep1Obj >();
		}
		CFBamPopSubDep1ByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep1().newUNameIdxKey();
		key.setRequiredPopTopDepTenantId( PopTopDepTenantId );
		key.setRequiredPopTopDepId( PopTopDepId );
		key.setRequiredName( Name );
		ICFBamPopSubDep1Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamPopSubDep1Buff buff = ((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().readDerivedByUNameIdx( schema.getAuthorization(),
				PopTopDepTenantId,
				PopTopDepId,
				Name );
			if( buff != null ) {
				obj = (ICFBamPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamPopSubDep1Obj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamPopSubDep1Obj updatePopSubDep1( ICFBamPopSubDep1Obj Obj ) {
		ICFBamPopSubDep1Obj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().updatePopSubDep1( schema.getAuthorization(),
			Obj.getPopSubDep1Buff() );
		if( Obj.getClassCode().equals( "POP1" ) ) {
			obj = (ICFBamPopSubDep1Obj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deletePopSubDep1( ICFBamPopSubDep1Obj Obj ) {
		ICFBamPopSubDep1Obj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().deletePopSubDep1( schema.getAuthorization(),
			obj.getPopSubDep1Buff() );
		obj.forget( true );
	}

	public void deletePopSubDep1ByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamPopSubDep1Obj obj = readPopSubDep1( pkey );
		if( obj != null ) {
			ICFBamPopSubDep1EditObj editObj = (ICFBamPopSubDep1EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamPopSubDep1EditObj)obj.beginEdit();
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

	public void deletePopSubDep1ByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep1Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep1Obj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().deletePopSubDep1ByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamPopSubDep1Obj> iter = dict.values().iterator();
			ICFBamPopSubDep1Obj obj;
			List<ICFBamPopSubDep1Obj> toForget = new LinkedList<ICFBamPopSubDep1Obj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().deletePopSubDep1ByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deletePopSubDep1ByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		CFBamPopDepByRelationIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< CFBamPopDepByRelationIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep1Obj > >();
		}
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep1Obj> dict = indexByRelationIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().deletePopSubDep1ByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			Iterator<ICFBamPopSubDep1Obj> iter = dict.values().iterator();
			ICFBamPopSubDep1Obj obj;
			List<ICFBamPopSubDep1Obj> toForget = new LinkedList<ICFBamPopSubDep1Obj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().deletePopSubDep1ByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
		}
	}

	public void deletePopSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamPopDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamPopDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep1Obj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep1Obj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().deletePopSubDep1ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamPopSubDep1Obj> iter = dict.values().iterator();
			ICFBamPopSubDep1Obj obj;
			List<ICFBamPopSubDep1Obj> toForget = new LinkedList<ICFBamPopSubDep1Obj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().deletePopSubDep1ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deletePopSubDep1ByPopTopDepIdx( long PopTopDepTenantId,
		long PopTopDepId )
	{
		CFBamPopSubDep1ByPopTopDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep1().newPopTopDepIdxKey();
		key.setRequiredPopTopDepTenantId( PopTopDepTenantId );
		key.setRequiredPopTopDepId( PopTopDepId );
		if( indexByPopTopDepIdx == null ) {
			indexByPopTopDepIdx = new HashMap< CFBamPopSubDep1ByPopTopDepIdxKey,
				Map< CFBamScopePKey, ICFBamPopSubDep1Obj > >();
		}
		if( indexByPopTopDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopSubDep1Obj> dict = indexByPopTopDepIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().deletePopSubDep1ByPopTopDepIdx( schema.getAuthorization(),
				PopTopDepTenantId,
				PopTopDepId );
			Iterator<ICFBamPopSubDep1Obj> iter = dict.values().iterator();
			ICFBamPopSubDep1Obj obj;
			List<ICFBamPopSubDep1Obj> toForget = new LinkedList<ICFBamPopSubDep1Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByPopTopDepIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().deletePopSubDep1ByPopTopDepIdx( schema.getAuthorization(),
				PopTopDepTenantId,
				PopTopDepId );
		}
	}

	public void deletePopSubDep1ByUNameIdx( long PopTopDepTenantId,
		long PopTopDepId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamPopSubDep1ByUNameIdxKey,
				ICFBamPopSubDep1Obj >();
		}
		CFBamPopSubDep1ByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep1().newUNameIdxKey();
		key.setRequiredPopTopDepTenantId( PopTopDepTenantId );
		key.setRequiredPopTopDepId( PopTopDepId );
		key.setRequiredName( Name );
		ICFBamPopSubDep1Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().deletePopSubDep1ByUNameIdx( schema.getAuthorization(),
				PopTopDepTenantId,
				PopTopDepId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().deletePopSubDep1ByUNameIdx( schema.getAuthorization(),
				PopTopDepTenantId,
				PopTopDepId,
				Name );
		}
	}
}
