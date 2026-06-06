// Description: Java 11 Table Object implementation for CFBam.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamPopTopDepTableObj
	implements ICFBamPopTopDepTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamPopTopDepObj> members;
	private Map<CFBamScopePKey, ICFBamPopTopDepObj> allPopTopDep;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamPopTopDepObj > > indexByTenantIdx;
	private Map< CFBamPopDepByRelationIdxKey,
		Map<CFBamScopePKey, ICFBamPopTopDepObj > > indexByRelationIdx;
	private Map< CFBamPopDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamPopTopDepObj > > indexByDefSchemaIdx;
	private Map< CFBamPopTopDepByContRelIdxKey,
		Map<CFBamScopePKey, ICFBamPopTopDepObj > > indexByContRelIdx;
	private Map< CFBamPopTopDepByUNameIdxKey,
		ICFBamPopTopDepObj > indexByUNameIdx;
	public static String TABLE_NAME = "PopTopDep";
	public static String TABLE_DBNAME = "pop_topdep";

	public CFBamPopTopDepTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamPopTopDepObj>();
		allPopTopDep = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByContRelIdx = null;
		indexByUNameIdx = null;
	}

	public CFBamPopTopDepTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamPopTopDepObj>();
		allPopTopDep = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByContRelIdx = null;
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
		allPopTopDep = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByContRelIdx = null;
		indexByUNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamPopTopDepObj.
	 */
	public ICFBamPopTopDepObj newInstance() {
		ICFBamPopTopDepObj inst = new CFBamPopTopDepObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamPopTopDepObj.
	 */
	public ICFBamPopTopDepEditObj newEditInstance( ICFBamPopTopDepObj orig ) {
		ICFBamPopTopDepEditObj edit = new CFBamPopTopDepEditObj( orig );
		return( edit );
	}

	public ICFBamPopTopDepObj realisePopTopDep( ICFBamPopTopDepObj Obj ) {
		ICFBamPopTopDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamPopTopDepObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamPopTopDepObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					indexByRelationIdx.remove( keyRelationIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByContRelIdx != null ) {
				CFBamPopTopDepByContRelIdxKey keyContRelIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopTopDep().newContRelIdxKey();
				keyContRelIdx.setRequiredContRelationTenantId( keepObj.getRequiredContRelationTenantId() );
				keyContRelIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapContRelIdx = indexByContRelIdx.get( keyContRelIdx );
				if( mapContRelIdx != null ) {
					mapContRelIdx.remove( keepObj.getPKey() );
					if( mapContRelIdx.size() <= 0 ) {
						indexByContRelIdx.remove( keyContRelIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopTopDepByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredContRelationTenantId( keepObj.getRequiredContRelationTenantId() );
				keyUNameIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamPopTopDepObj)schema.getPopDepTableObj().realisePopDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContRelIdx != null ) {
				CFBamPopTopDepByContRelIdxKey keyContRelIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopTopDep().newContRelIdxKey();
				keyContRelIdx.setRequiredContRelationTenantId( keepObj.getRequiredContRelationTenantId() );
				keyContRelIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapContRelIdx = indexByContRelIdx.get( keyContRelIdx );
				if( mapContRelIdx != null ) {
					mapContRelIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopTopDepByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredContRelationTenantId( keepObj.getRequiredContRelationTenantId() );
				keyUNameIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allPopTopDep != null ) {
				allPopTopDep.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamPopTopDepObj)schema.getPopDepTableObj().realisePopDep( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allPopTopDep != null ) {
				allPopTopDep.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContRelIdx != null ) {
				CFBamPopTopDepByContRelIdxKey keyContRelIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopTopDep().newContRelIdxKey();
				keyContRelIdx.setRequiredContRelationTenantId( keepObj.getRequiredContRelationTenantId() );
				keyContRelIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapContRelIdx = indexByContRelIdx.get( keyContRelIdx );
				if( mapContRelIdx != null ) {
					mapContRelIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopTopDepByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredContRelationTenantId( keepObj.getRequiredContRelationTenantId() );
				keyUNameIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetPopTopDep( ICFBamPopTopDepObj Obj ) {
		forgetPopTopDep( Obj, false );
	}

	public void forgetPopTopDep( ICFBamPopTopDepObj Obj, boolean forgetSubObjects ) {
		ICFBamPopTopDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamPopTopDepObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamPopDepByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
				keyRelationIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					indexByRelationIdx.remove( keyRelationIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByContRelIdx != null ) {
				CFBamPopTopDepByContRelIdxKey keyContRelIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopTopDep().newContRelIdxKey();
				keyContRelIdx.setRequiredContRelationTenantId( keepObj.getRequiredContRelationTenantId() );
				keyContRelIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				Map<CFBamScopePKey, ICFBamPopTopDepObj > mapContRelIdx = indexByContRelIdx.get( keyContRelIdx );
				if( mapContRelIdx != null ) {
					mapContRelIdx.remove( keepObj.getPKey() );
					if( mapContRelIdx.size() <= 0 ) {
						indexByContRelIdx.remove( keyContRelIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamPopTopDepByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryPopTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredContRelationTenantId( keepObj.getRequiredContRelationTenantId() );
				keyUNameIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allPopTopDep != null ) {
				allPopTopDep.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFBamSchemaObj)schema).getPopSubDep1TableObj().forgetPopSubDep1ByPopTopDepIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		((ICFBamSchemaObj)schema).getPopDepTableObj().forgetPopDep( obj );
	}

	public void forgetPopTopDepByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamPopTopDepObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetPopTopDepByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamPopTopDepObj> toForget = new LinkedList<ICFBamPopTopDepObj>();
		ICFBamPopTopDepObj cur = null;
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopTopDepObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamPopTopDepObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamPopTopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamPopTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetPopTopDepByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		if( indexByRelationIdx == null ) {
			return;
		}
		List<ICFBamPopTopDepObj> toForget = new LinkedList<ICFBamPopTopDepObj>();
		ICFBamPopTopDepObj cur = null;
		CFBamPopDepByRelationIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopTopDepObj > mapRelationIdx = indexByRelationIdx.get( key );
			if( mapRelationIdx != null ) {
				Iterator<ICFBamPopTopDepObj> iterDup = mapRelationIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRelationIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamPopTopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamPopTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetPopTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamPopTopDepObj> toForget = new LinkedList<ICFBamPopTopDepObj>();
		ICFBamPopTopDepObj cur = null;
		CFBamPopDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamPopTopDepObj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamPopTopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamPopTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetPopTopDepByContRelIdx( long ContRelationTenantId,
		long ContRelationId )
	{
		if( indexByContRelIdx == null ) {
			return;
		}
		List<ICFBamPopTopDepObj> toForget = new LinkedList<ICFBamPopTopDepObj>();
		ICFBamPopTopDepObj cur = null;
		CFBamPopTopDepByContRelIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopTopDep().newContRelIdxKey();
		key.setRequiredContRelationTenantId( ContRelationTenantId );
		key.setRequiredContRelationId( ContRelationId );
		if( indexByContRelIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopTopDepObj > mapContRelIdx = indexByContRelIdx.get( key );
			if( mapContRelIdx != null ) {
				Iterator<ICFBamPopTopDepObj> iterDup = mapContRelIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByContRelIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamPopTopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamPopTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetPopTopDepByUNameIdx( long ContRelationTenantId,
		long ContRelationId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamPopTopDepObj> toForget = new LinkedList<ICFBamPopTopDepObj>();
		ICFBamPopTopDepObj cur = null;
		CFBamPopTopDepByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopTopDep().newUNameIdxKey();
		key.setRequiredContRelationTenantId( ContRelationTenantId );
		key.setRequiredContRelationId( ContRelationId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamPopTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamPopTopDepObj createPopTopDep( ICFBamPopTopDepObj Obj ) {
		ICFBamPopTopDepObj obj = Obj;
		CFBamPopTopDepBuff buff = obj.getPopTopDepBuff();
		((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().createPopTopDep(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "POPT" ) ) {
			obj = (ICFBamPopTopDepObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamPopTopDepObj readPopTopDep( CFBamScopePKey pkey ) {
		return( readPopTopDep( pkey, false ) );
	}

	public ICFBamPopTopDepObj readPopTopDep( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamPopTopDepObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamPopTopDepBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamPopTopDepObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamPopTopDepObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamPopTopDepObj lockPopTopDep( CFBamScopePKey pkey ) {
		ICFBamPopTopDepObj locked = null;
		CFBamPopTopDepBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamPopTopDepObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamPopTopDepObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockPopTopDep", pkey );
		}
		return( locked );
	}

	public List<ICFBamPopTopDepObj> readAllPopTopDep() {
		return( readAllPopTopDep( false ) );
	}

	public List<ICFBamPopTopDepObj> readAllPopTopDep( boolean forceRead ) {
		final String S_ProcName = "readAllPopTopDep";
		if( ( allPopTopDep == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamPopTopDepObj> map = new HashMap<CFBamScopePKey,ICFBamPopTopDepObj>();
			allPopTopDep = map;
			CFBamPopTopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().readAllDerived( schema.getAuthorization() );
			CFBamPopTopDepBuff buff;
			ICFBamPopTopDepObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopTopDepObj realised = (ICFBamPopTopDepObj)obj.realise();
			}
		}
		int len = allPopTopDep.size();
		ICFBamPopTopDepObj arr[] = new ICFBamPopTopDepObj[len];
		Iterator<ICFBamPopTopDepObj> valIter = allPopTopDep.values().iterator();
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
		ArrayList<ICFBamPopTopDepObj> arrayList = new ArrayList<ICFBamPopTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopTopDepObj> cmp = new Comparator<ICFBamPopTopDepObj>() {
			public int compare( ICFBamPopTopDepObj lhs, ICFBamPopTopDepObj rhs ) {
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
		List<ICFBamPopTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamPopTopDepObj readPopTopDepByIdIdx( long TenantId,
		long Id )
	{
		return( readPopTopDepByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamPopTopDepObj readPopTopDepByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamPopTopDepObj obj = readPopTopDep( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamPopTopDepObj> readPopTopDepByTenantIdx( long TenantId )
	{
		return( readPopTopDepByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamPopTopDepObj> readPopTopDepByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopTopDepByTenantIdx";
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamPopTopDepObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamPopTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopTopDepObj>();
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopTopDepObj realised = (ICFBamPopTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamPopTopDepObj arr[] = new ICFBamPopTopDepObj[len];
		Iterator<ICFBamPopTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopTopDepObj> arrayList = new ArrayList<ICFBamPopTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopTopDepObj> cmp = new Comparator<ICFBamPopTopDepObj>() {
			public int compare( ICFBamPopTopDepObj lhs, ICFBamPopTopDepObj rhs ) {
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
		List<ICFBamPopTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopTopDepObj> readPopTopDepByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		return( readPopTopDepByRelationIdx( RelationTenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamPopTopDepObj> readPopTopDepByRelationIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopTopDepByRelationIdx";
		CFBamPopDepByRelationIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamPopTopDepObj> dict;
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< CFBamPopDepByRelationIdxKey,
				Map< CFBamScopePKey, ICFBamPopTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByRelationIdx.containsKey( key ) ) {
			dict = indexByRelationIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopTopDepObj>();
			ICFBamPopDepObj obj;
			CFBamPopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTablePopDep().readDerivedByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			CFBamPopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopTopDepObj realised = (ICFBamPopTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRelationIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamPopTopDepObj arr[] = new ICFBamPopTopDepObj[len];
		Iterator<ICFBamPopTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopTopDepObj> arrayList = new ArrayList<ICFBamPopTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopTopDepObj> cmp = new Comparator<ICFBamPopTopDepObj>() {
			public int compare( ICFBamPopTopDepObj lhs, ICFBamPopTopDepObj rhs ) {
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
		List<ICFBamPopTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopTopDepObj> readPopTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readPopTopDepByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamPopTopDepObj> readPopTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopTopDepByDefSchemaIdx";
		CFBamPopDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamPopTopDepObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamPopDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamPopTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopTopDepObj>();
			ICFBamPopDepObj obj;
			CFBamPopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTablePopDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamPopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopTopDepObj realised = (ICFBamPopTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamPopTopDepObj arr[] = new ICFBamPopTopDepObj[len];
		Iterator<ICFBamPopTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopTopDepObj> arrayList = new ArrayList<ICFBamPopTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopTopDepObj> cmp = new Comparator<ICFBamPopTopDepObj>() {
			public int compare( ICFBamPopTopDepObj lhs, ICFBamPopTopDepObj rhs ) {
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
		List<ICFBamPopTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamPopTopDepObj> readPopTopDepByContRelIdx( long ContRelationTenantId,
		long ContRelationId )
	{
		return( readPopTopDepByContRelIdx( ContRelationTenantId,
			ContRelationId,
			false ) );
	}

	public List<ICFBamPopTopDepObj> readPopTopDepByContRelIdx( long ContRelationTenantId,
		long ContRelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopTopDepByContRelIdx";
		CFBamPopTopDepByContRelIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopTopDep().newContRelIdxKey();
		key.setRequiredContRelationTenantId( ContRelationTenantId );
		key.setRequiredContRelationId( ContRelationId );
		Map<CFBamScopePKey, ICFBamPopTopDepObj> dict;
		if( indexByContRelIdx == null ) {
			indexByContRelIdx = new HashMap< CFBamPopTopDepByContRelIdxKey,
				Map< CFBamScopePKey, ICFBamPopTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByContRelIdx.containsKey( key ) ) {
			dict = indexByContRelIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamPopTopDepObj>();
			ICFBamPopTopDepObj obj;
			CFBamPopTopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().readDerivedByContRelIdx( schema.getAuthorization(),
				ContRelationTenantId,
				ContRelationId );
			CFBamPopTopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamPopTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamPopTopDepObj realised = (ICFBamPopTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContRelIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamPopTopDepObj arr[] = new ICFBamPopTopDepObj[len];
		Iterator<ICFBamPopTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamPopTopDepObj> arrayList = new ArrayList<ICFBamPopTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamPopTopDepObj> cmp = new Comparator<ICFBamPopTopDepObj>() {
			public int compare( ICFBamPopTopDepObj lhs, ICFBamPopTopDepObj rhs ) {
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
		List<ICFBamPopTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamPopTopDepObj readPopTopDepByUNameIdx( long ContRelationTenantId,
		long ContRelationId,
		String Name )
	{
		return( readPopTopDepByUNameIdx( ContRelationTenantId,
			ContRelationId,
			Name,
			false ) );
	}

	public ICFBamPopTopDepObj readPopTopDepByUNameIdx( long ContRelationTenantId,
		long ContRelationId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamPopTopDepByUNameIdxKey,
				ICFBamPopTopDepObj >();
		}
		CFBamPopTopDepByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopTopDep().newUNameIdxKey();
		key.setRequiredContRelationTenantId( ContRelationTenantId );
		key.setRequiredContRelationId( ContRelationId );
		key.setRequiredName( Name );
		ICFBamPopTopDepObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamPopTopDepBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().readDerivedByUNameIdx( schema.getAuthorization(),
				ContRelationTenantId,
				ContRelationId,
				Name );
			if( buff != null ) {
				obj = (ICFBamPopTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamPopTopDepObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamPopTopDepObj updatePopTopDep( ICFBamPopTopDepObj Obj ) {
		ICFBamPopTopDepObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().updatePopTopDep( schema.getAuthorization(),
			Obj.getPopTopDepBuff() );
		if( Obj.getClassCode().equals( "POPT" ) ) {
			obj = (ICFBamPopTopDepObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deletePopTopDep( ICFBamPopTopDepObj Obj ) {
		ICFBamPopTopDepObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().deletePopTopDep( schema.getAuthorization(),
			obj.getPopTopDepBuff() );
		obj.forget( true );
	}

	public void deletePopTopDepByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamPopTopDepObj obj = readPopTopDep( pkey );
		if( obj != null ) {
			ICFBamPopTopDepEditObj editObj = (ICFBamPopTopDepEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamPopTopDepEditObj)obj.beginEdit();
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

	public void deletePopTopDepByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamPopTopDepObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopTopDepObj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().deletePopTopDepByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamPopTopDepObj> iter = dict.values().iterator();
			ICFBamPopTopDepObj obj;
			List<ICFBamPopTopDepObj> toForget = new LinkedList<ICFBamPopTopDepObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().deletePopTopDepByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deletePopTopDepByRelationIdx( long RelationTenantId,
		long RelationId )
	{
		CFBamPopDepByRelationIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newRelationIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< CFBamPopDepByRelationIdxKey,
				Map< CFBamScopePKey, ICFBamPopTopDepObj > >();
		}
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopTopDepObj> dict = indexByRelationIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().deletePopTopDepByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			Iterator<ICFBamPopTopDepObj> iter = dict.values().iterator();
			ICFBamPopTopDepObj obj;
			List<ICFBamPopTopDepObj> toForget = new LinkedList<ICFBamPopTopDepObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().deletePopTopDepByRelationIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
		}
	}

	public void deletePopTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamPopDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamPopDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamPopTopDepObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopTopDepObj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().deletePopTopDepByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamPopTopDepObj> iter = dict.values().iterator();
			ICFBamPopTopDepObj obj;
			List<ICFBamPopTopDepObj> toForget = new LinkedList<ICFBamPopTopDepObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().deletePopTopDepByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deletePopTopDepByContRelIdx( long ContRelationTenantId,
		long ContRelationId )
	{
		CFBamPopTopDepByContRelIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopTopDep().newContRelIdxKey();
		key.setRequiredContRelationTenantId( ContRelationTenantId );
		key.setRequiredContRelationId( ContRelationId );
		if( indexByContRelIdx == null ) {
			indexByContRelIdx = new HashMap< CFBamPopTopDepByContRelIdxKey,
				Map< CFBamScopePKey, ICFBamPopTopDepObj > >();
		}
		if( indexByContRelIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamPopTopDepObj> dict = indexByContRelIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().deletePopTopDepByContRelIdx( schema.getAuthorization(),
				ContRelationTenantId,
				ContRelationId );
			Iterator<ICFBamPopTopDepObj> iter = dict.values().iterator();
			ICFBamPopTopDepObj obj;
			List<ICFBamPopTopDepObj> toForget = new LinkedList<ICFBamPopTopDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByContRelIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().deletePopTopDepByContRelIdx( schema.getAuthorization(),
				ContRelationTenantId,
				ContRelationId );
		}
	}

	public void deletePopTopDepByUNameIdx( long ContRelationTenantId,
		long ContRelationId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamPopTopDepByUNameIdxKey,
				ICFBamPopTopDepObj >();
		}
		CFBamPopTopDepByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopTopDep().newUNameIdxKey();
		key.setRequiredContRelationTenantId( ContRelationTenantId );
		key.setRequiredContRelationId( ContRelationId );
		key.setRequiredName( Name );
		ICFBamPopTopDepObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().deletePopTopDepByUNameIdx( schema.getAuthorization(),
				ContRelationTenantId,
				ContRelationId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().deletePopTopDepByUNameIdx( schema.getAuthorization(),
				ContRelationTenantId,
				ContRelationId,
				Name );
		}
	}
}
