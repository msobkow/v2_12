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

public class CFBamDelSubDep2TableObj
	implements ICFBamDelSubDep2TableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamDelSubDep2Obj> members;
	private Map<CFBamScopePKey, ICFBamDelSubDep2Obj> allDelSubDep2;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamDelSubDep2Obj > > indexByTenantIdx;
	private Map< CFBamDelDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamDelSubDep2Obj > > indexByDefSchemaIdx;
	private Map< CFBamDelDepByDelDepIdxKey,
		Map<CFBamScopePKey, ICFBamDelSubDep2Obj > > indexByDelDepIdx;
	private Map< CFBamDelSubDep2ByContDelDep1IdxKey,
		Map<CFBamScopePKey, ICFBamDelSubDep2Obj > > indexByContDelDep1Idx;
	private Map< CFBamDelSubDep2ByUNameIdxKey,
		ICFBamDelSubDep2Obj > indexByUNameIdx;
	public static String TABLE_NAME = "DelSubDep2";
	public static String TABLE_DBNAME = "delsubdep2";

	public CFBamDelSubDep2TableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamDelSubDep2Obj>();
		allDelSubDep2 = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
		indexByContDelDep1Idx = null;
		indexByUNameIdx = null;
	}

	public CFBamDelSubDep2TableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamDelSubDep2Obj>();
		allDelSubDep2 = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
		indexByContDelDep1Idx = null;
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
		allDelSubDep2 = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
		indexByContDelDep1Idx = null;
		indexByUNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDelSubDep2Obj.
	 */
	public ICFBamDelSubDep2Obj newInstance() {
		ICFBamDelSubDep2Obj inst = new CFBamDelSubDep2Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDelSubDep2Obj.
	 */
	public ICFBamDelSubDep2EditObj newEditInstance( ICFBamDelSubDep2Obj orig ) {
		ICFBamDelSubDep2EditObj edit = new CFBamDelSubDep2EditObj( orig );
		return( edit );
	}

	public ICFBamDelSubDep2Obj realiseDelSubDep2( ICFBamDelSubDep2Obj Obj ) {
		ICFBamDelSubDep2Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamDelSubDep2Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamDelSubDep2Obj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByDelDepIdx != null ) {
				CFBamDelDepByDelDepIdxKey keyDelDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					indexByDelDepIdx.remove( keyDelDepIdx );
				}
			}

			if( indexByContDelDep1Idx != null ) {
				CFBamDelSubDep2ByContDelDep1IdxKey keyContDelDep1Idx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelSubDep2().newContDelDep1IdxKey();
				keyContDelDep1Idx.setRequiredDelSubDep1TenantId( keepObj.getRequiredDelSubDep1TenantId() );
				keyContDelDep1Idx.setRequiredDelSubDep1Id( keepObj.getRequiredDelSubDep1Id() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapContDelDep1Idx = indexByContDelDep1Idx.get( keyContDelDep1Idx );
				if( mapContDelDep1Idx != null ) {
					mapContDelDep1Idx.remove( keepObj.getPKey() );
					if( mapContDelDep1Idx.size() <= 0 ) {
						indexByContDelDep1Idx.remove( keyContDelDep1Idx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelSubDep2ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredDelSubDep1TenantId( keepObj.getRequiredDelSubDep1TenantId() );
				keyUNameIdx.setRequiredDelSubDep1Id( keepObj.getRequiredDelSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamDelSubDep2Obj)schema.getDelDepTableObj().realiseDelDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelDepIdx != null ) {
				CFBamDelDepByDelDepIdxKey keyDelDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					mapDelDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContDelDep1Idx != null ) {
				CFBamDelSubDep2ByContDelDep1IdxKey keyContDelDep1Idx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelSubDep2().newContDelDep1IdxKey();
				keyContDelDep1Idx.setRequiredDelSubDep1TenantId( keepObj.getRequiredDelSubDep1TenantId() );
				keyContDelDep1Idx.setRequiredDelSubDep1Id( keepObj.getRequiredDelSubDep1Id() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapContDelDep1Idx = indexByContDelDep1Idx.get( keyContDelDep1Idx );
				if( mapContDelDep1Idx != null ) {
					mapContDelDep1Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelSubDep2ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredDelSubDep1TenantId( keepObj.getRequiredDelSubDep1TenantId() );
				keyUNameIdx.setRequiredDelSubDep1Id( keepObj.getRequiredDelSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allDelSubDep2 != null ) {
				allDelSubDep2.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamDelSubDep2Obj)schema.getDelDepTableObj().realiseDelDep( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allDelSubDep2 != null ) {
				allDelSubDep2.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelDepIdx != null ) {
				CFBamDelDepByDelDepIdxKey keyDelDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					mapDelDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContDelDep1Idx != null ) {
				CFBamDelSubDep2ByContDelDep1IdxKey keyContDelDep1Idx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelSubDep2().newContDelDep1IdxKey();
				keyContDelDep1Idx.setRequiredDelSubDep1TenantId( keepObj.getRequiredDelSubDep1TenantId() );
				keyContDelDep1Idx.setRequiredDelSubDep1Id( keepObj.getRequiredDelSubDep1Id() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapContDelDep1Idx = indexByContDelDep1Idx.get( keyContDelDep1Idx );
				if( mapContDelDep1Idx != null ) {
					mapContDelDep1Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelSubDep2ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredDelSubDep1TenantId( keepObj.getRequiredDelSubDep1TenantId() );
				keyUNameIdx.setRequiredDelSubDep1Id( keepObj.getRequiredDelSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetDelSubDep2( ICFBamDelSubDep2Obj Obj ) {
		forgetDelSubDep2( Obj, false );
	}

	public void forgetDelSubDep2( ICFBamDelSubDep2Obj Obj, boolean forgetSubObjects ) {
		ICFBamDelSubDep2Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamDelSubDep2Obj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByDelDepIdx != null ) {
				CFBamDelDepByDelDepIdxKey keyDelDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					indexByDelDepIdx.remove( keyDelDepIdx );
				}
			}

			if( indexByContDelDep1Idx != null ) {
				CFBamDelSubDep2ByContDelDep1IdxKey keyContDelDep1Idx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelSubDep2().newContDelDep1IdxKey();
				keyContDelDep1Idx.setRequiredDelSubDep1TenantId( keepObj.getRequiredDelSubDep1TenantId() );
				keyContDelDep1Idx.setRequiredDelSubDep1Id( keepObj.getRequiredDelSubDep1Id() );
				Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapContDelDep1Idx = indexByContDelDep1Idx.get( keyContDelDep1Idx );
				if( mapContDelDep1Idx != null ) {
					mapContDelDep1Idx.remove( keepObj.getPKey() );
					if( mapContDelDep1Idx.size() <= 0 ) {
						indexByContDelDep1Idx.remove( keyContDelDep1Idx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelSubDep2ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredDelSubDep1TenantId( keepObj.getRequiredDelSubDep1TenantId() );
				keyUNameIdx.setRequiredDelSubDep1Id( keepObj.getRequiredDelSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allDelSubDep2 != null ) {
				allDelSubDep2.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFBamSchemaObj)schema).getDelSubDep3TableObj().forgetDelSubDep3ByDelSubDep2Idx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		((ICFBamSchemaObj)schema).getDelDepTableObj().forgetDelDep( obj );
	}

	public void forgetDelSubDep2ByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamDelSubDep2Obj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetDelSubDep2ByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamDelSubDep2Obj> toForget = new LinkedList<ICFBamDelSubDep2Obj>();
		ICFBamDelSubDep2Obj cur = null;
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamDelSubDep2Obj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamDelSubDep2Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamDelSubDep2Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetDelSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamDelSubDep2Obj> toForget = new LinkedList<ICFBamDelSubDep2Obj>();
		ICFBamDelSubDep2Obj cur = null;
		CFBamDelDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamDelSubDep2Obj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamDelSubDep2Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamDelSubDep2Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetDelSubDep2ByDelDepIdx( long RelationTenantId,
		long RelationId )
	{
		if( indexByDelDepIdx == null ) {
			return;
		}
		List<ICFBamDelSubDep2Obj> toForget = new LinkedList<ICFBamDelSubDep2Obj>();
		ICFBamDelSubDep2Obj cur = null;
		CFBamDelDepByDelDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByDelDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapDelDepIdx = indexByDelDepIdx.get( key );
			if( mapDelDepIdx != null ) {
				Iterator<ICFBamDelSubDep2Obj> iterDup = mapDelDepIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDelDepIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamDelSubDep2Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamDelSubDep2Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetDelSubDep2ByContDelDep1Idx( long DelSubDep1TenantId,
		long DelSubDep1Id )
	{
		if( indexByContDelDep1Idx == null ) {
			return;
		}
		List<ICFBamDelSubDep2Obj> toForget = new LinkedList<ICFBamDelSubDep2Obj>();
		ICFBamDelSubDep2Obj cur = null;
		CFBamDelSubDep2ByContDelDep1IdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelSubDep2().newContDelDep1IdxKey();
		key.setRequiredDelSubDep1TenantId( DelSubDep1TenantId );
		key.setRequiredDelSubDep1Id( DelSubDep1Id );
		if( indexByContDelDep1Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep2Obj > mapContDelDep1Idx = indexByContDelDep1Idx.get( key );
			if( mapContDelDep1Idx != null ) {
				Iterator<ICFBamDelSubDep2Obj> iterDup = mapContDelDep1Idx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByContDelDep1Idx.remove( key );
			}

		}
		else {
			Iterator<ICFBamDelSubDep2Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamDelSubDep2Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetDelSubDep2ByUNameIdx( long DelSubDep1TenantId,
		long DelSubDep1Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamDelSubDep2Obj> toForget = new LinkedList<ICFBamDelSubDep2Obj>();
		ICFBamDelSubDep2Obj cur = null;
		CFBamDelSubDep2ByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelSubDep2().newUNameIdxKey();
		key.setRequiredDelSubDep1TenantId( DelSubDep1TenantId );
		key.setRequiredDelSubDep1Id( DelSubDep1Id );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamDelSubDep2Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamDelSubDep2Obj createDelSubDep2( ICFBamDelSubDep2Obj Obj ) {
		ICFBamDelSubDep2Obj obj = Obj;
		CFBamDelSubDep2Buff buff = obj.getDelSubDep2Buff();
		((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().createDelSubDep2(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "DEL2" ) ) {
			obj = (ICFBamDelSubDep2Obj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamDelSubDep2Obj readDelSubDep2( CFBamScopePKey pkey ) {
		return( readDelSubDep2( pkey, false ) );
	}

	public ICFBamDelSubDep2Obj readDelSubDep2( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamDelSubDep2Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamDelSubDep2Buff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamDelSubDep2Obj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamDelSubDep2Obj lockDelSubDep2( CFBamScopePKey pkey ) {
		ICFBamDelSubDep2Obj locked = null;
		CFBamDelSubDep2Buff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamDelSubDep2Obj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockDelSubDep2", pkey );
		}
		return( locked );
	}

	public List<ICFBamDelSubDep2Obj> readAllDelSubDep2() {
		return( readAllDelSubDep2( false ) );
	}

	public List<ICFBamDelSubDep2Obj> readAllDelSubDep2( boolean forceRead ) {
		final String S_ProcName = "readAllDelSubDep2";
		if( ( allDelSubDep2 == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamDelSubDep2Obj> map = new HashMap<CFBamScopePKey,ICFBamDelSubDep2Obj>();
			allDelSubDep2 = map;
			CFBamDelSubDep2Buff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().readAllDerived( schema.getAuthorization() );
			CFBamDelSubDep2Buff buff;
			ICFBamDelSubDep2Obj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep2Obj realised = (ICFBamDelSubDep2Obj)obj.realise();
			}
		}
		int len = allDelSubDep2.size();
		ICFBamDelSubDep2Obj arr[] = new ICFBamDelSubDep2Obj[len];
		Iterator<ICFBamDelSubDep2Obj> valIter = allDelSubDep2.values().iterator();
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
		ArrayList<ICFBamDelSubDep2Obj> arrayList = new ArrayList<ICFBamDelSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamDelSubDep2Obj> cmp = new Comparator<ICFBamDelSubDep2Obj>() {
			public int compare( ICFBamDelSubDep2Obj lhs, ICFBamDelSubDep2Obj rhs ) {
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
		List<ICFBamDelSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDelSubDep2Obj readDelSubDep2ByIdIdx( long TenantId,
		long Id )
	{
		return( readDelSubDep2ByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamDelSubDep2Obj readDelSubDep2ByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDelSubDep2Obj obj = readDelSubDep2( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamDelSubDep2Obj> readDelSubDep2ByTenantIdx( long TenantId )
	{
		return( readDelSubDep2ByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamDelSubDep2Obj> readDelSubDep2ByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep2ByTenantIdx";
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamDelSubDep2Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelSubDep2Obj>();
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep2Obj realised = (ICFBamDelSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamDelSubDep2Obj arr[] = new ICFBamDelSubDep2Obj[len];
		Iterator<ICFBamDelSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelSubDep2Obj> arrayList = new ArrayList<ICFBamDelSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamDelSubDep2Obj> cmp = new Comparator<ICFBamDelSubDep2Obj>() {
			public int compare( ICFBamDelSubDep2Obj lhs, ICFBamDelSubDep2Obj rhs ) {
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
		List<ICFBamDelSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelSubDep2Obj> readDelSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readDelSubDep2ByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamDelSubDep2Obj> readDelSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep2ByDefSchemaIdx";
		CFBamDelDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamDelSubDep2Obj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamDelDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelSubDep2Obj>();
			ICFBamDelDepObj obj;
			CFBamDelDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableDelDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamDelDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep2Obj realised = (ICFBamDelSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamDelSubDep2Obj arr[] = new ICFBamDelSubDep2Obj[len];
		Iterator<ICFBamDelSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelSubDep2Obj> arrayList = new ArrayList<ICFBamDelSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamDelSubDep2Obj> cmp = new Comparator<ICFBamDelSubDep2Obj>() {
			public int compare( ICFBamDelSubDep2Obj lhs, ICFBamDelSubDep2Obj rhs ) {
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
		List<ICFBamDelSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelSubDep2Obj> readDelSubDep2ByDelDepIdx( long RelationTenantId,
		long RelationId )
	{
		return( readDelSubDep2ByDelDepIdx( RelationTenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamDelSubDep2Obj> readDelSubDep2ByDelDepIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep2ByDelDepIdx";
		CFBamDelDepByDelDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamDelSubDep2Obj> dict;
		if( indexByDelDepIdx == null ) {
			indexByDelDepIdx = new HashMap< CFBamDelDepByDelDepIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByDelDepIdx.containsKey( key ) ) {
			dict = indexByDelDepIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelSubDep2Obj>();
			ICFBamDelDepObj obj;
			CFBamDelDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableDelDep().readDerivedByDelDepIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			CFBamDelDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep2Obj realised = (ICFBamDelSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDelDepIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamDelSubDep2Obj arr[] = new ICFBamDelSubDep2Obj[len];
		Iterator<ICFBamDelSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelSubDep2Obj> arrayList = new ArrayList<ICFBamDelSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamDelSubDep2Obj> cmp = new Comparator<ICFBamDelSubDep2Obj>() {
			public int compare( ICFBamDelSubDep2Obj lhs, ICFBamDelSubDep2Obj rhs ) {
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
		List<ICFBamDelSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelSubDep2Obj> readDelSubDep2ByContDelDep1Idx( long DelSubDep1TenantId,
		long DelSubDep1Id )
	{
		return( readDelSubDep2ByContDelDep1Idx( DelSubDep1TenantId,
			DelSubDep1Id,
			false ) );
	}

	public List<ICFBamDelSubDep2Obj> readDelSubDep2ByContDelDep1Idx( long DelSubDep1TenantId,
		long DelSubDep1Id,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep2ByContDelDep1Idx";
		CFBamDelSubDep2ByContDelDep1IdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelSubDep2().newContDelDep1IdxKey();
		key.setRequiredDelSubDep1TenantId( DelSubDep1TenantId );
		key.setRequiredDelSubDep1Id( DelSubDep1Id );
		Map<CFBamScopePKey, ICFBamDelSubDep2Obj> dict;
		if( indexByContDelDep1Idx == null ) {
			indexByContDelDep1Idx = new HashMap< CFBamDelSubDep2ByContDelDep1IdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByContDelDep1Idx.containsKey( key ) ) {
			dict = indexByContDelDep1Idx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelSubDep2Obj>();
			ICFBamDelSubDep2Obj obj;
			CFBamDelSubDep2Buff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().readDerivedByContDelDep1Idx( schema.getAuthorization(),
				DelSubDep1TenantId,
				DelSubDep1Id );
			CFBamDelSubDep2Buff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelSubDep2Obj realised = (ICFBamDelSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContDelDep1Idx.put( key, dict );
		}
		int len = dict.size();
		ICFBamDelSubDep2Obj arr[] = new ICFBamDelSubDep2Obj[len];
		Iterator<ICFBamDelSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelSubDep2Obj> arrayList = new ArrayList<ICFBamDelSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamDelSubDep2Obj> cmp = new Comparator<ICFBamDelSubDep2Obj>() {
			public int compare( ICFBamDelSubDep2Obj lhs, ICFBamDelSubDep2Obj rhs ) {
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
		List<ICFBamDelSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDelSubDep2Obj readDelSubDep2ByUNameIdx( long DelSubDep1TenantId,
		long DelSubDep1Id,
		String Name )
	{
		return( readDelSubDep2ByUNameIdx( DelSubDep1TenantId,
			DelSubDep1Id,
			Name,
			false ) );
	}

	public ICFBamDelSubDep2Obj readDelSubDep2ByUNameIdx( long DelSubDep1TenantId,
		long DelSubDep1Id,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamDelSubDep2ByUNameIdxKey,
				ICFBamDelSubDep2Obj >();
		}
		CFBamDelSubDep2ByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelSubDep2().newUNameIdxKey();
		key.setRequiredDelSubDep1TenantId( DelSubDep1TenantId );
		key.setRequiredDelSubDep1Id( DelSubDep1Id );
		key.setRequiredName( Name );
		ICFBamDelSubDep2Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamDelSubDep2Buff buff = ((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().readDerivedByUNameIdx( schema.getAuthorization(),
				DelSubDep1TenantId,
				DelSubDep1Id,
				Name );
			if( buff != null ) {
				obj = (ICFBamDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamDelSubDep2Obj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamDelSubDep2Obj updateDelSubDep2( ICFBamDelSubDep2Obj Obj ) {
		ICFBamDelSubDep2Obj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().updateDelSubDep2( schema.getAuthorization(),
			Obj.getDelSubDep2Buff() );
		if( Obj.getClassCode().equals( "DEL2" ) ) {
			obj = (ICFBamDelSubDep2Obj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteDelSubDep2( ICFBamDelSubDep2Obj Obj ) {
		ICFBamDelSubDep2Obj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().deleteDelSubDep2( schema.getAuthorization(),
			obj.getDelSubDep2Buff() );
		obj.forget( true );
	}

	public void deleteDelSubDep2ByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDelSubDep2Obj obj = readDelSubDep2( pkey );
		if( obj != null ) {
			ICFBamDelSubDep2EditObj editObj = (ICFBamDelSubDep2EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamDelSubDep2EditObj)obj.beginEdit();
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

	public void deleteDelSubDep2ByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep2Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep2Obj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().deleteDelSubDep2ByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamDelSubDep2Obj> iter = dict.values().iterator();
			ICFBamDelSubDep2Obj obj;
			List<ICFBamDelSubDep2Obj> toForget = new LinkedList<ICFBamDelSubDep2Obj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().deleteDelSubDep2ByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteDelSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamDelDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamDelDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep2Obj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep2Obj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().deleteDelSubDep2ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamDelSubDep2Obj> iter = dict.values().iterator();
			ICFBamDelSubDep2Obj obj;
			List<ICFBamDelSubDep2Obj> toForget = new LinkedList<ICFBamDelSubDep2Obj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().deleteDelSubDep2ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteDelSubDep2ByDelDepIdx( long RelationTenantId,
		long RelationId )
	{
		CFBamDelDepByDelDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByDelDepIdx == null ) {
			indexByDelDepIdx = new HashMap< CFBamDelDepByDelDepIdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep2Obj > >();
		}
		if( indexByDelDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep2Obj> dict = indexByDelDepIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().deleteDelSubDep2ByDelDepIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			Iterator<ICFBamDelSubDep2Obj> iter = dict.values().iterator();
			ICFBamDelSubDep2Obj obj;
			List<ICFBamDelSubDep2Obj> toForget = new LinkedList<ICFBamDelSubDep2Obj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().deleteDelSubDep2ByDelDepIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
		}
	}

	public void deleteDelSubDep2ByContDelDep1Idx( long DelSubDep1TenantId,
		long DelSubDep1Id )
	{
		CFBamDelSubDep2ByContDelDep1IdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelSubDep2().newContDelDep1IdxKey();
		key.setRequiredDelSubDep1TenantId( DelSubDep1TenantId );
		key.setRequiredDelSubDep1Id( DelSubDep1Id );
		if( indexByContDelDep1Idx == null ) {
			indexByContDelDep1Idx = new HashMap< CFBamDelSubDep2ByContDelDep1IdxKey,
				Map< CFBamScopePKey, ICFBamDelSubDep2Obj > >();
		}
		if( indexByContDelDep1Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelSubDep2Obj> dict = indexByContDelDep1Idx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().deleteDelSubDep2ByContDelDep1Idx( schema.getAuthorization(),
				DelSubDep1TenantId,
				DelSubDep1Id );
			Iterator<ICFBamDelSubDep2Obj> iter = dict.values().iterator();
			ICFBamDelSubDep2Obj obj;
			List<ICFBamDelSubDep2Obj> toForget = new LinkedList<ICFBamDelSubDep2Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByContDelDep1Idx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().deleteDelSubDep2ByContDelDep1Idx( schema.getAuthorization(),
				DelSubDep1TenantId,
				DelSubDep1Id );
		}
	}

	public void deleteDelSubDep2ByUNameIdx( long DelSubDep1TenantId,
		long DelSubDep1Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamDelSubDep2ByUNameIdxKey,
				ICFBamDelSubDep2Obj >();
		}
		CFBamDelSubDep2ByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelSubDep2().newUNameIdxKey();
		key.setRequiredDelSubDep1TenantId( DelSubDep1TenantId );
		key.setRequiredDelSubDep1Id( DelSubDep1Id );
		key.setRequiredName( Name );
		ICFBamDelSubDep2Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().deleteDelSubDep2ByUNameIdx( schema.getAuthorization(),
				DelSubDep1TenantId,
				DelSubDep1Id,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().deleteDelSubDep2ByUNameIdx( schema.getAuthorization(),
				DelSubDep1TenantId,
				DelSubDep1Id,
				Name );
		}
	}
}
