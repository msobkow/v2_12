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

public class CFBamClearSubDep2TableObj
	implements ICFBamClearSubDep2TableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamClearSubDep2Obj> members;
	private Map<CFBamScopePKey, ICFBamClearSubDep2Obj> allClearSubDep2;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep2Obj > > indexByTenantIdx;
	private Map< CFBamClearDepByClearDepIdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep2Obj > > indexByClearDepIdx;
	private Map< CFBamClearDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep2Obj > > indexByDefSchemaIdx;
	private Map< CFBamClearSubDep2ByClearSubDep1IdxKey,
		Map<CFBamScopePKey, ICFBamClearSubDep2Obj > > indexByClearSubDep1Idx;
	private Map< CFBamClearSubDep2ByUNameIdxKey,
		ICFBamClearSubDep2Obj > indexByUNameIdx;
	public static String TABLE_NAME = "ClearSubDep2";
	public static String TABLE_DBNAME = "clrsubdep2";

	public CFBamClearSubDep2TableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamClearSubDep2Obj>();
		allClearSubDep2 = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		indexByClearSubDep1Idx = null;
		indexByUNameIdx = null;
	}

	public CFBamClearSubDep2TableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamClearSubDep2Obj>();
		allClearSubDep2 = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		indexByClearSubDep1Idx = null;
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
		allClearSubDep2 = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		indexByClearSubDep1Idx = null;
		indexByUNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearSubDep2Obj.
	 */
	public ICFBamClearSubDep2Obj newInstance() {
		ICFBamClearSubDep2Obj inst = new CFBamClearSubDep2Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearSubDep2Obj.
	 */
	public ICFBamClearSubDep2EditObj newEditInstance( ICFBamClearSubDep2Obj orig ) {
		ICFBamClearSubDep2EditObj edit = new CFBamClearSubDep2EditObj( orig );
		return( edit );
	}

	public ICFBamClearSubDep2Obj realiseClearSubDep2( ICFBamClearSubDep2Obj Obj ) {
		ICFBamClearSubDep2Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamClearSubDep2Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamClearSubDep2Obj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					indexByClearDepIdx.remove( keyClearDepIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByClearSubDep1Idx != null ) {
				CFBamClearSubDep2ByClearSubDep1IdxKey keyClearSubDep1Idx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep2().newClearSubDep1IdxKey();
				keyClearSubDep1Idx.setRequiredClearSubDep1TenantId( keepObj.getRequiredClearSubDep1TenantId() );
				keyClearSubDep1Idx.setRequiredClearSubDep1Id( keepObj.getRequiredClearSubDep1Id() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapClearSubDep1Idx = indexByClearSubDep1Idx.get( keyClearSubDep1Idx );
				if( mapClearSubDep1Idx != null ) {
					mapClearSubDep1Idx.remove( keepObj.getPKey() );
					if( mapClearSubDep1Idx.size() <= 0 ) {
						indexByClearSubDep1Idx.remove( keyClearSubDep1Idx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep2ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredClearSubDep1TenantId( keepObj.getRequiredClearSubDep1TenantId() );
				keyUNameIdx.setRequiredClearSubDep1Id( keepObj.getRequiredClearSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamClearSubDep2Obj)schema.getClearDepTableObj().realiseClearDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearSubDep1Idx != null ) {
				CFBamClearSubDep2ByClearSubDep1IdxKey keyClearSubDep1Idx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep2().newClearSubDep1IdxKey();
				keyClearSubDep1Idx.setRequiredClearSubDep1TenantId( keepObj.getRequiredClearSubDep1TenantId() );
				keyClearSubDep1Idx.setRequiredClearSubDep1Id( keepObj.getRequiredClearSubDep1Id() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapClearSubDep1Idx = indexByClearSubDep1Idx.get( keyClearSubDep1Idx );
				if( mapClearSubDep1Idx != null ) {
					mapClearSubDep1Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep2ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredClearSubDep1TenantId( keepObj.getRequiredClearSubDep1TenantId() );
				keyUNameIdx.setRequiredClearSubDep1Id( keepObj.getRequiredClearSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allClearSubDep2 != null ) {
				allClearSubDep2.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamClearSubDep2Obj)schema.getClearDepTableObj().realiseClearDep( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allClearSubDep2 != null ) {
				allClearSubDep2.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearSubDep1Idx != null ) {
				CFBamClearSubDep2ByClearSubDep1IdxKey keyClearSubDep1Idx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep2().newClearSubDep1IdxKey();
				keyClearSubDep1Idx.setRequiredClearSubDep1TenantId( keepObj.getRequiredClearSubDep1TenantId() );
				keyClearSubDep1Idx.setRequiredClearSubDep1Id( keepObj.getRequiredClearSubDep1Id() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapClearSubDep1Idx = indexByClearSubDep1Idx.get( keyClearSubDep1Idx );
				if( mapClearSubDep1Idx != null ) {
					mapClearSubDep1Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep2ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredClearSubDep1TenantId( keepObj.getRequiredClearSubDep1TenantId() );
				keyUNameIdx.setRequiredClearSubDep1Id( keepObj.getRequiredClearSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetClearSubDep2( ICFBamClearSubDep2Obj Obj ) {
		forgetClearSubDep2( Obj, false );
	}

	public void forgetClearSubDep2( ICFBamClearSubDep2Obj Obj, boolean forgetSubObjects ) {
		ICFBamClearSubDep2Obj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamClearSubDep2Obj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					indexByClearDepIdx.remove( keyClearDepIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByClearSubDep1Idx != null ) {
				CFBamClearSubDep2ByClearSubDep1IdxKey keyClearSubDep1Idx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep2().newClearSubDep1IdxKey();
				keyClearSubDep1Idx.setRequiredClearSubDep1TenantId( keepObj.getRequiredClearSubDep1TenantId() );
				keyClearSubDep1Idx.setRequiredClearSubDep1Id( keepObj.getRequiredClearSubDep1Id() );
				Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapClearSubDep1Idx = indexByClearSubDep1Idx.get( keyClearSubDep1Idx );
				if( mapClearSubDep1Idx != null ) {
					mapClearSubDep1Idx.remove( keepObj.getPKey() );
					if( mapClearSubDep1Idx.size() <= 0 ) {
						indexByClearSubDep1Idx.remove( keyClearSubDep1Idx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearSubDep2ByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep2().newUNameIdxKey();
				keyUNameIdx.setRequiredClearSubDep1TenantId( keepObj.getRequiredClearSubDep1TenantId() );
				keyUNameIdx.setRequiredClearSubDep1Id( keepObj.getRequiredClearSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allClearSubDep2 != null ) {
				allClearSubDep2.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFBamSchemaObj)schema).getClearSubDep3TableObj().forgetClearSubDep3ByClearSubDep2Idx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		((ICFBamSchemaObj)schema).getClearDepTableObj().forgetClearDep( obj );
	}

	public void forgetClearSubDep2ByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamClearSubDep2Obj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetClearSubDep2ByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamClearSubDep2Obj> toForget = new LinkedList<ICFBamClearSubDep2Obj>();
		ICFBamClearSubDep2Obj cur = null;
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamClearSubDep2Obj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearSubDep2Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearSubDep2Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearSubDep2ByClearDepIdx( long TenantId,
		long RelationId )
	{
		if( indexByClearDepIdx == null ) {
			return;
		}
		List<ICFBamClearSubDep2Obj> toForget = new LinkedList<ICFBamClearSubDep2Obj>();
		ICFBamClearSubDep2Obj cur = null;
		CFBamClearDepByClearDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByClearDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapClearDepIdx = indexByClearDepIdx.get( key );
			if( mapClearDepIdx != null ) {
				Iterator<ICFBamClearSubDep2Obj> iterDup = mapClearDepIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClearDepIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearSubDep2Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearSubDep2Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamClearSubDep2Obj> toForget = new LinkedList<ICFBamClearSubDep2Obj>();
		ICFBamClearSubDep2Obj cur = null;
		CFBamClearDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamClearSubDep2Obj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearSubDep2Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearSubDep2Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearSubDep2ByClearSubDep1Idx( long ClearSubDep1TenantId,
		long ClearSubDep1Id )
	{
		if( indexByClearSubDep1Idx == null ) {
			return;
		}
		List<ICFBamClearSubDep2Obj> toForget = new LinkedList<ICFBamClearSubDep2Obj>();
		ICFBamClearSubDep2Obj cur = null;
		CFBamClearSubDep2ByClearSubDep1IdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep2().newClearSubDep1IdxKey();
		key.setRequiredClearSubDep1TenantId( ClearSubDep1TenantId );
		key.setRequiredClearSubDep1Id( ClearSubDep1Id );
		if( indexByClearSubDep1Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep2Obj > mapClearSubDep1Idx = indexByClearSubDep1Idx.get( key );
			if( mapClearSubDep1Idx != null ) {
				Iterator<ICFBamClearSubDep2Obj> iterDup = mapClearSubDep1Idx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClearSubDep1Idx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearSubDep2Obj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearSubDep2Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearSubDep2ByUNameIdx( long ClearSubDep1TenantId,
		long ClearSubDep1Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamClearSubDep2Obj> toForget = new LinkedList<ICFBamClearSubDep2Obj>();
		ICFBamClearSubDep2Obj cur = null;
		CFBamClearSubDep2ByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep2().newUNameIdxKey();
		key.setRequiredClearSubDep1TenantId( ClearSubDep1TenantId );
		key.setRequiredClearSubDep1Id( ClearSubDep1Id );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamClearSubDep2Obj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamClearSubDep2Obj createClearSubDep2( ICFBamClearSubDep2Obj Obj ) {
		ICFBamClearSubDep2Obj obj = Obj;
		CFBamClearSubDep2Buff buff = obj.getClearSubDep2Buff();
		((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().createClearSubDep2(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "CLR2" ) ) {
			obj = (ICFBamClearSubDep2Obj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamClearSubDep2Obj readClearSubDep2( CFBamScopePKey pkey ) {
		return( readClearSubDep2( pkey, false ) );
	}

	public ICFBamClearSubDep2Obj readClearSubDep2( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamClearSubDep2Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamClearSubDep2Buff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamClearSubDep2Obj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamClearSubDep2Obj lockClearSubDep2( CFBamScopePKey pkey ) {
		ICFBamClearSubDep2Obj locked = null;
		CFBamClearSubDep2Buff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamClearSubDep2Obj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockClearSubDep2", pkey );
		}
		return( locked );
	}

	public List<ICFBamClearSubDep2Obj> readAllClearSubDep2() {
		return( readAllClearSubDep2( false ) );
	}

	public List<ICFBamClearSubDep2Obj> readAllClearSubDep2( boolean forceRead ) {
		final String S_ProcName = "readAllClearSubDep2";
		if( ( allClearSubDep2 == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamClearSubDep2Obj> map = new HashMap<CFBamScopePKey,ICFBamClearSubDep2Obj>();
			allClearSubDep2 = map;
			CFBamClearSubDep2Buff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().readAllDerived( schema.getAuthorization() );
			CFBamClearSubDep2Buff buff;
			ICFBamClearSubDep2Obj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep2Obj realised = (ICFBamClearSubDep2Obj)obj.realise();
			}
		}
		int len = allClearSubDep2.size();
		ICFBamClearSubDep2Obj arr[] = new ICFBamClearSubDep2Obj[len];
		Iterator<ICFBamClearSubDep2Obj> valIter = allClearSubDep2.values().iterator();
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
		ArrayList<ICFBamClearSubDep2Obj> arrayList = new ArrayList<ICFBamClearSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearSubDep2Obj> cmp = new Comparator<ICFBamClearSubDep2Obj>() {
			public int compare( ICFBamClearSubDep2Obj lhs, ICFBamClearSubDep2Obj rhs ) {
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
		List<ICFBamClearSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearSubDep2Obj readClearSubDep2ByIdIdx( long TenantId,
		long Id )
	{
		return( readClearSubDep2ByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamClearSubDep2Obj readClearSubDep2ByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamClearSubDep2Obj obj = readClearSubDep2( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamClearSubDep2Obj> readClearSubDep2ByTenantIdx( long TenantId )
	{
		return( readClearSubDep2ByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamClearSubDep2Obj> readClearSubDep2ByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep2ByTenantIdx";
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamClearSubDep2Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep2Obj>();
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep2Obj realised = (ICFBamClearSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearSubDep2Obj arr[] = new ICFBamClearSubDep2Obj[len];
		Iterator<ICFBamClearSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep2Obj> arrayList = new ArrayList<ICFBamClearSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearSubDep2Obj> cmp = new Comparator<ICFBamClearSubDep2Obj>() {
			public int compare( ICFBamClearSubDep2Obj lhs, ICFBamClearSubDep2Obj rhs ) {
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
		List<ICFBamClearSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearSubDep2Obj> readClearSubDep2ByClearDepIdx( long TenantId,
		long RelationId )
	{
		return( readClearSubDep2ByClearDepIdx( TenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamClearSubDep2Obj> readClearSubDep2ByClearDepIdx( long TenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep2ByClearDepIdx";
		CFBamClearDepByClearDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamClearSubDep2Obj> dict;
		if( indexByClearDepIdx == null ) {
			indexByClearDepIdx = new HashMap< CFBamClearDepByClearDepIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByClearDepIdx.containsKey( key ) ) {
			dict = indexByClearDepIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep2Obj>();
			ICFBamClearDepObj obj;
			CFBamClearDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearDep().readDerivedByClearDepIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			CFBamClearDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep2Obj realised = (ICFBamClearSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClearDepIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearSubDep2Obj arr[] = new ICFBamClearSubDep2Obj[len];
		Iterator<ICFBamClearSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep2Obj> arrayList = new ArrayList<ICFBamClearSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearSubDep2Obj> cmp = new Comparator<ICFBamClearSubDep2Obj>() {
			public int compare( ICFBamClearSubDep2Obj lhs, ICFBamClearSubDep2Obj rhs ) {
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
		List<ICFBamClearSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearSubDep2Obj> readClearSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readClearSubDep2ByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamClearSubDep2Obj> readClearSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep2ByDefSchemaIdx";
		CFBamClearDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamClearSubDep2Obj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamClearDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep2Obj>();
			ICFBamClearDepObj obj;
			CFBamClearDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamClearDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep2Obj realised = (ICFBamClearSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearSubDep2Obj arr[] = new ICFBamClearSubDep2Obj[len];
		Iterator<ICFBamClearSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep2Obj> arrayList = new ArrayList<ICFBamClearSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearSubDep2Obj> cmp = new Comparator<ICFBamClearSubDep2Obj>() {
			public int compare( ICFBamClearSubDep2Obj lhs, ICFBamClearSubDep2Obj rhs ) {
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
		List<ICFBamClearSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearSubDep2Obj> readClearSubDep2ByClearSubDep1Idx( long ClearSubDep1TenantId,
		long ClearSubDep1Id )
	{
		return( readClearSubDep2ByClearSubDep1Idx( ClearSubDep1TenantId,
			ClearSubDep1Id,
			false ) );
	}

	public List<ICFBamClearSubDep2Obj> readClearSubDep2ByClearSubDep1Idx( long ClearSubDep1TenantId,
		long ClearSubDep1Id,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep2ByClearSubDep1Idx";
		CFBamClearSubDep2ByClearSubDep1IdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep2().newClearSubDep1IdxKey();
		key.setRequiredClearSubDep1TenantId( ClearSubDep1TenantId );
		key.setRequiredClearSubDep1Id( ClearSubDep1Id );
		Map<CFBamScopePKey, ICFBamClearSubDep2Obj> dict;
		if( indexByClearSubDep1Idx == null ) {
			indexByClearSubDep1Idx = new HashMap< CFBamClearSubDep2ByClearSubDep1IdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByClearSubDep1Idx.containsKey( key ) ) {
			dict = indexByClearSubDep1Idx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearSubDep2Obj>();
			ICFBamClearSubDep2Obj obj;
			CFBamClearSubDep2Buff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().readDerivedByClearSubDep1Idx( schema.getAuthorization(),
				ClearSubDep1TenantId,
				ClearSubDep1Id );
			CFBamClearSubDep2Buff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearSubDep2Obj realised = (ICFBamClearSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClearSubDep1Idx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearSubDep2Obj arr[] = new ICFBamClearSubDep2Obj[len];
		Iterator<ICFBamClearSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearSubDep2Obj> arrayList = new ArrayList<ICFBamClearSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearSubDep2Obj> cmp = new Comparator<ICFBamClearSubDep2Obj>() {
			public int compare( ICFBamClearSubDep2Obj lhs, ICFBamClearSubDep2Obj rhs ) {
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
		List<ICFBamClearSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearSubDep2Obj readClearSubDep2ByUNameIdx( long ClearSubDep1TenantId,
		long ClearSubDep1Id,
		String Name )
	{
		return( readClearSubDep2ByUNameIdx( ClearSubDep1TenantId,
			ClearSubDep1Id,
			Name,
			false ) );
	}

	public ICFBamClearSubDep2Obj readClearSubDep2ByUNameIdx( long ClearSubDep1TenantId,
		long ClearSubDep1Id,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamClearSubDep2ByUNameIdxKey,
				ICFBamClearSubDep2Obj >();
		}
		CFBamClearSubDep2ByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep2().newUNameIdxKey();
		key.setRequiredClearSubDep1TenantId( ClearSubDep1TenantId );
		key.setRequiredClearSubDep1Id( ClearSubDep1Id );
		key.setRequiredName( Name );
		ICFBamClearSubDep2Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamClearSubDep2Buff buff = ((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().readDerivedByUNameIdx( schema.getAuthorization(),
				ClearSubDep1TenantId,
				ClearSubDep1Id,
				Name );
			if( buff != null ) {
				obj = (ICFBamClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamClearSubDep2Obj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamClearSubDep2Obj updateClearSubDep2( ICFBamClearSubDep2Obj Obj ) {
		ICFBamClearSubDep2Obj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().updateClearSubDep2( schema.getAuthorization(),
			Obj.getClearSubDep2Buff() );
		if( Obj.getClassCode().equals( "CLR2" ) ) {
			obj = (ICFBamClearSubDep2Obj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteClearSubDep2( ICFBamClearSubDep2Obj Obj ) {
		ICFBamClearSubDep2Obj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().deleteClearSubDep2( schema.getAuthorization(),
			obj.getClearSubDep2Buff() );
		obj.forget( true );
	}

	public void deleteClearSubDep2ByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamClearSubDep2Obj obj = readClearSubDep2( pkey );
		if( obj != null ) {
			ICFBamClearSubDep2EditObj editObj = (ICFBamClearSubDep2EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamClearSubDep2EditObj)obj.beginEdit();
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

	public void deleteClearSubDep2ByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep2Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep2Obj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().deleteClearSubDep2ByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamClearSubDep2Obj> iter = dict.values().iterator();
			ICFBamClearSubDep2Obj obj;
			List<ICFBamClearSubDep2Obj> toForget = new LinkedList<ICFBamClearSubDep2Obj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().deleteClearSubDep2ByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteClearSubDep2ByClearDepIdx( long TenantId,
		long RelationId )
	{
		CFBamClearDepByClearDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByClearDepIdx == null ) {
			indexByClearDepIdx = new HashMap< CFBamClearDepByClearDepIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep2Obj > >();
		}
		if( indexByClearDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep2Obj> dict = indexByClearDepIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().deleteClearSubDep2ByClearDepIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			Iterator<ICFBamClearSubDep2Obj> iter = dict.values().iterator();
			ICFBamClearSubDep2Obj obj;
			List<ICFBamClearSubDep2Obj> toForget = new LinkedList<ICFBamClearSubDep2Obj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().deleteClearSubDep2ByClearDepIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
		}
	}

	public void deleteClearSubDep2ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamClearDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamClearDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep2Obj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep2Obj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().deleteClearSubDep2ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamClearSubDep2Obj> iter = dict.values().iterator();
			ICFBamClearSubDep2Obj obj;
			List<ICFBamClearSubDep2Obj> toForget = new LinkedList<ICFBamClearSubDep2Obj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().deleteClearSubDep2ByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteClearSubDep2ByClearSubDep1Idx( long ClearSubDep1TenantId,
		long ClearSubDep1Id )
	{
		CFBamClearSubDep2ByClearSubDep1IdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep2().newClearSubDep1IdxKey();
		key.setRequiredClearSubDep1TenantId( ClearSubDep1TenantId );
		key.setRequiredClearSubDep1Id( ClearSubDep1Id );
		if( indexByClearSubDep1Idx == null ) {
			indexByClearSubDep1Idx = new HashMap< CFBamClearSubDep2ByClearSubDep1IdxKey,
				Map< CFBamScopePKey, ICFBamClearSubDep2Obj > >();
		}
		if( indexByClearSubDep1Idx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearSubDep2Obj> dict = indexByClearSubDep1Idx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().deleteClearSubDep2ByClearSubDep1Idx( schema.getAuthorization(),
				ClearSubDep1TenantId,
				ClearSubDep1Id );
			Iterator<ICFBamClearSubDep2Obj> iter = dict.values().iterator();
			ICFBamClearSubDep2Obj obj;
			List<ICFBamClearSubDep2Obj> toForget = new LinkedList<ICFBamClearSubDep2Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByClearSubDep1Idx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().deleteClearSubDep2ByClearSubDep1Idx( schema.getAuthorization(),
				ClearSubDep1TenantId,
				ClearSubDep1Id );
		}
	}

	public void deleteClearSubDep2ByUNameIdx( long ClearSubDep1TenantId,
		long ClearSubDep1Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamClearSubDep2ByUNameIdxKey,
				ICFBamClearSubDep2Obj >();
		}
		CFBamClearSubDep2ByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep2().newUNameIdxKey();
		key.setRequiredClearSubDep1TenantId( ClearSubDep1TenantId );
		key.setRequiredClearSubDep1Id( ClearSubDep1Id );
		key.setRequiredName( Name );
		ICFBamClearSubDep2Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().deleteClearSubDep2ByUNameIdx( schema.getAuthorization(),
				ClearSubDep1TenantId,
				ClearSubDep1Id,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().deleteClearSubDep2ByUNameIdx( schema.getAuthorization(),
				ClearSubDep1TenantId,
				ClearSubDep1Id,
				Name );
		}
	}
}
