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

public class CFBamServerListFuncTableObj
	implements ICFBamServerListFuncTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamServerListFuncObj> members;
	private Map<CFBamScopePKey, ICFBamServerListFuncObj> allServerListFunc;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamServerListFuncObj > > indexByTenantIdx;
	private Map< CFBamServerMethodByUNameIdxKey,
		ICFBamServerListFuncObj > indexByUNameIdx;
	private Map< CFBamServerMethodByMethTableIdxKey,
		Map<CFBamScopePKey, ICFBamServerListFuncObj > > indexByMethTableIdx;
	private Map< CFBamServerMethodByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamServerListFuncObj > > indexByDefSchemaIdx;
	private Map< CFBamServerListFuncByRetTblIdxKey,
		Map<CFBamScopePKey, ICFBamServerListFuncObj > > indexByRetTblIdx;
	public static String TABLE_NAME = "ServerListFunc";
	public static String TABLE_DBNAME = "srvlfunc";

	public CFBamServerListFuncTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamServerListFuncObj>();
		allServerListFunc = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByMethTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByRetTblIdx = null;
	}

	public CFBamServerListFuncTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamServerListFuncObj>();
		allServerListFunc = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByMethTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByRetTblIdx = null;
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
		allServerListFunc = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByMethTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByRetTblIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamServerListFuncObj.
	 */
	public ICFBamServerListFuncObj newInstance() {
		ICFBamServerListFuncObj inst = new CFBamServerListFuncObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamServerListFuncObj.
	 */
	public ICFBamServerListFuncEditObj newEditInstance( ICFBamServerListFuncObj orig ) {
		ICFBamServerListFuncEditObj edit = new CFBamServerListFuncEditObj( orig );
		return( edit );
	}

	public ICFBamServerListFuncObj realiseServerListFunc( ICFBamServerListFuncObj Obj ) {
		ICFBamServerListFuncObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamServerListFuncObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamServerListFuncObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamServerListFuncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamServerMethodByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByMethTableIdx != null ) {
				CFBamServerMethodByMethTableIdxKey keyMethTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newMethTableIdxKey();
				keyMethTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyMethTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamServerListFuncObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					indexByMethTableIdx.remove( keyMethTableIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamServerListFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByRetTblIdx != null ) {
				CFBamServerListFuncByRetTblIdxKey keyRetTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerListFunc().newRetTblIdxKey();
				keyRetTblIdx.setOptionalRetTenantId( keepObj.getOptionalRetTenantId() );
				keyRetTblIdx.setOptionalRetTableId( keepObj.getOptionalRetTableId() );
				Map<CFBamScopePKey, ICFBamServerListFuncObj > mapRetTblIdx = indexByRetTblIdx.get( keyRetTblIdx );
				if( mapRetTblIdx != null ) {
					mapRetTblIdx.remove( keepObj.getPKey() );
					if( mapRetTblIdx.size() <= 0 ) {
						indexByRetTblIdx.remove( keyRetTblIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamServerListFuncObj)schema.getServerMethodTableObj().realiseServerMethod( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamServerListFuncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamServerMethodByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByMethTableIdx != null ) {
				CFBamServerMethodByMethTableIdxKey keyMethTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newMethTableIdxKey();
				keyMethTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyMethTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamServerListFuncObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					mapMethTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamServerListFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRetTblIdx != null ) {
				CFBamServerListFuncByRetTblIdxKey keyRetTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerListFunc().newRetTblIdxKey();
				keyRetTblIdx.setOptionalRetTenantId( keepObj.getOptionalRetTenantId() );
				keyRetTblIdx.setOptionalRetTableId( keepObj.getOptionalRetTableId() );
				Map<CFBamScopePKey, ICFBamServerListFuncObj > mapRetTblIdx = indexByRetTblIdx.get( keyRetTblIdx );
				if( mapRetTblIdx != null ) {
					mapRetTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allServerListFunc != null ) {
				allServerListFunc.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamServerListFuncObj)schema.getServerMethodTableObj().realiseServerMethod( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allServerListFunc != null ) {
				allServerListFunc.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamServerListFuncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamServerMethodByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByMethTableIdx != null ) {
				CFBamServerMethodByMethTableIdxKey keyMethTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newMethTableIdxKey();
				keyMethTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyMethTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamServerListFuncObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					mapMethTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamServerListFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRetTblIdx != null ) {
				CFBamServerListFuncByRetTblIdxKey keyRetTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerListFunc().newRetTblIdxKey();
				keyRetTblIdx.setOptionalRetTenantId( keepObj.getOptionalRetTenantId() );
				keyRetTblIdx.setOptionalRetTableId( keepObj.getOptionalRetTableId() );
				Map<CFBamScopePKey, ICFBamServerListFuncObj > mapRetTblIdx = indexByRetTblIdx.get( keyRetTblIdx );
				if( mapRetTblIdx != null ) {
					mapRetTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetServerListFunc( ICFBamServerListFuncObj Obj ) {
		forgetServerListFunc( Obj, false );
	}

	public void forgetServerListFunc( ICFBamServerListFuncObj Obj, boolean forgetSubObjects ) {
		ICFBamServerListFuncObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamServerListFuncObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamServerListFuncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamServerMethodByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByMethTableIdx != null ) {
				CFBamServerMethodByMethTableIdxKey keyMethTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newMethTableIdxKey();
				keyMethTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyMethTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamServerListFuncObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					indexByMethTableIdx.remove( keyMethTableIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamServerListFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByRetTblIdx != null ) {
				CFBamServerListFuncByRetTblIdxKey keyRetTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerListFunc().newRetTblIdxKey();
				keyRetTblIdx.setOptionalRetTenantId( keepObj.getOptionalRetTenantId() );
				keyRetTblIdx.setOptionalRetTableId( keepObj.getOptionalRetTableId() );
				Map<CFBamScopePKey, ICFBamServerListFuncObj > mapRetTblIdx = indexByRetTblIdx.get( keyRetTblIdx );
				if( mapRetTblIdx != null ) {
					mapRetTblIdx.remove( keepObj.getPKey() );
					if( mapRetTblIdx.size() <= 0 ) {
						indexByRetTblIdx.remove( keyRetTblIdx );
					}
				}
			}

			if( allServerListFunc != null ) {
				allServerListFunc.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		((ICFBamSchemaObj)schema).getServerMethodTableObj().forgetServerMethod( obj );
	}

	public void forgetServerListFuncByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamServerListFuncObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetServerListFuncByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamServerListFuncObj> toForget = new LinkedList<ICFBamServerListFuncObj>();
		ICFBamServerListFuncObj cur = null;
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerListFuncObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamServerListFuncObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamServerListFuncObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamServerListFuncObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetServerListFuncByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamServerListFuncObj> toForget = new LinkedList<ICFBamServerListFuncObj>();
		ICFBamServerListFuncObj cur = null;
		CFBamServerMethodByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamServerListFuncObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetServerListFuncByMethTableIdx( long TenantId,
		long TableId )
	{
		if( indexByMethTableIdx == null ) {
			return;
		}
		List<ICFBamServerListFuncObj> toForget = new LinkedList<ICFBamServerListFuncObj>();
		ICFBamServerListFuncObj cur = null;
		CFBamServerMethodByMethTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newMethTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByMethTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerListFuncObj > mapMethTableIdx = indexByMethTableIdx.get( key );
			if( mapMethTableIdx != null ) {
				Iterator<ICFBamServerListFuncObj> iterDup = mapMethTableIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByMethTableIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamServerListFuncObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamServerListFuncObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetServerListFuncByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamServerListFuncObj> toForget = new LinkedList<ICFBamServerListFuncObj>();
		ICFBamServerListFuncObj cur = null;
		CFBamServerMethodByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerListFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamServerListFuncObj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamServerListFuncObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamServerListFuncObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetServerListFuncByRetTblIdx( Long RetTenantId,
		Long RetTableId )
	{
		if( indexByRetTblIdx == null ) {
			return;
		}
		List<ICFBamServerListFuncObj> toForget = new LinkedList<ICFBamServerListFuncObj>();
		ICFBamServerListFuncObj cur = null;
		CFBamServerListFuncByRetTblIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerListFunc().newRetTblIdxKey();
		key.setOptionalRetTenantId( RetTenantId );
		key.setOptionalRetTableId( RetTableId );
		if( indexByRetTblIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerListFuncObj > mapRetTblIdx = indexByRetTblIdx.get( key );
			if( mapRetTblIdx != null ) {
				Iterator<ICFBamServerListFuncObj> iterDup = mapRetTblIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRetTblIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamServerListFuncObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamServerListFuncObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamServerListFuncObj createServerListFunc( ICFBamServerListFuncObj Obj ) {
		ICFBamServerListFuncObj obj = Obj;
		CFBamServerListFuncBuff buff = obj.getServerListFuncBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableServerListFunc().createServerListFunc(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "SRVL" ) ) {
			obj = (ICFBamServerListFuncObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamServerListFuncObj readServerListFunc( CFBamScopePKey pkey ) {
		return( readServerListFunc( pkey, false ) );
	}

	public ICFBamServerListFuncObj readServerListFunc( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamServerListFuncObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamServerListFuncBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableServerListFunc().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamServerListFuncObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamServerListFuncObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamServerListFuncObj lockServerListFunc( CFBamScopePKey pkey ) {
		ICFBamServerListFuncObj locked = null;
		CFBamServerListFuncBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableServerListFunc().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamServerListFuncObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamServerListFuncObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockServerListFunc", pkey );
		}
		return( locked );
	}

	public List<ICFBamServerListFuncObj> readAllServerListFunc() {
		return( readAllServerListFunc( false ) );
	}

	public List<ICFBamServerListFuncObj> readAllServerListFunc( boolean forceRead ) {
		final String S_ProcName = "readAllServerListFunc";
		if( ( allServerListFunc == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamServerListFuncObj> map = new HashMap<CFBamScopePKey,ICFBamServerListFuncObj>();
			allServerListFunc = map;
			CFBamServerListFuncBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableServerListFunc().readAllDerived( schema.getAuthorization() );
			CFBamServerListFuncBuff buff;
			ICFBamServerListFuncObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamServerListFuncObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamServerListFuncObj realised = (ICFBamServerListFuncObj)obj.realise();
			}
		}
		int len = allServerListFunc.size();
		ICFBamServerListFuncObj arr[] = new ICFBamServerListFuncObj[len];
		Iterator<ICFBamServerListFuncObj> valIter = allServerListFunc.values().iterator();
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
		ArrayList<ICFBamServerListFuncObj> arrayList = new ArrayList<ICFBamServerListFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamServerListFuncObj> cmp = new Comparator<ICFBamServerListFuncObj>() {
			public int compare( ICFBamServerListFuncObj lhs, ICFBamServerListFuncObj rhs ) {
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
		List<ICFBamServerListFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamServerListFuncObj readServerListFuncByIdIdx( long TenantId,
		long Id )
	{
		return( readServerListFuncByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamServerListFuncObj readServerListFuncByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamServerListFuncObj obj = readServerListFunc( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamServerListFuncObj> readServerListFuncByTenantIdx( long TenantId )
	{
		return( readServerListFuncByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamServerListFuncObj> readServerListFuncByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerListFuncByTenantIdx";
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamServerListFuncObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamServerListFuncObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamServerListFuncObj>();
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamServerListFuncObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamServerListFuncObj realised = (ICFBamServerListFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamServerListFuncObj arr[] = new ICFBamServerListFuncObj[len];
		Iterator<ICFBamServerListFuncObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamServerListFuncObj> arrayList = new ArrayList<ICFBamServerListFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamServerListFuncObj> cmp = new Comparator<ICFBamServerListFuncObj>() {
			public int compare( ICFBamServerListFuncObj lhs, ICFBamServerListFuncObj rhs ) {
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
		List<ICFBamServerListFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamServerListFuncObj readServerListFuncByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		return( readServerListFuncByUNameIdx( TenantId,
			TableId,
			Name,
			false ) );
	}

	public ICFBamServerListFuncObj readServerListFuncByUNameIdx( long TenantId,
		long TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamServerMethodByUNameIdxKey,
				ICFBamServerListFuncObj >();
		}
		CFBamServerMethodByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamServerListFuncObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamServerMethodBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableServerMethod().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
			if( buff != null ) {
				obj = (ICFBamServerListFuncObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamServerListFuncObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFBamServerListFuncObj> readServerListFuncByMethTableIdx( long TenantId,
		long TableId )
	{
		return( readServerListFuncByMethTableIdx( TenantId,
			TableId,
			false ) );
	}

	public List<ICFBamServerListFuncObj> readServerListFuncByMethTableIdx( long TenantId,
		long TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerListFuncByMethTableIdx";
		CFBamServerMethodByMethTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newMethTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		Map<CFBamScopePKey, ICFBamServerListFuncObj> dict;
		if( indexByMethTableIdx == null ) {
			indexByMethTableIdx = new HashMap< CFBamServerMethodByMethTableIdxKey,
				Map< CFBamScopePKey, ICFBamServerListFuncObj > >();
		}
		if( ( ! forceRead ) && indexByMethTableIdx.containsKey( key ) ) {
			dict = indexByMethTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamServerListFuncObj>();
			ICFBamServerMethodObj obj;
			CFBamServerMethodBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableServerMethod().readDerivedByMethTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			CFBamServerMethodBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamServerListFuncObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamServerListFuncObj realised = (ICFBamServerListFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByMethTableIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamServerListFuncObj arr[] = new ICFBamServerListFuncObj[len];
		Iterator<ICFBamServerListFuncObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamServerListFuncObj> arrayList = new ArrayList<ICFBamServerListFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamServerListFuncObj> cmp = new Comparator<ICFBamServerListFuncObj>() {
			public int compare( ICFBamServerListFuncObj lhs, ICFBamServerListFuncObj rhs ) {
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
		List<ICFBamServerListFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamServerListFuncObj> readServerListFuncByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readServerListFuncByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamServerListFuncObj> readServerListFuncByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerListFuncByDefSchemaIdx";
		CFBamServerMethodByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamServerListFuncObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamServerMethodByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamServerListFuncObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamServerListFuncObj>();
			ICFBamServerMethodObj obj;
			CFBamServerMethodBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableServerMethod().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamServerMethodBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamServerListFuncObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamServerListFuncObj realised = (ICFBamServerListFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamServerListFuncObj arr[] = new ICFBamServerListFuncObj[len];
		Iterator<ICFBamServerListFuncObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamServerListFuncObj> arrayList = new ArrayList<ICFBamServerListFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamServerListFuncObj> cmp = new Comparator<ICFBamServerListFuncObj>() {
			public int compare( ICFBamServerListFuncObj lhs, ICFBamServerListFuncObj rhs ) {
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
		List<ICFBamServerListFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamServerListFuncObj> readServerListFuncByRetTblIdx( Long RetTenantId,
		Long RetTableId )
	{
		return( readServerListFuncByRetTblIdx( RetTenantId,
			RetTableId,
			false ) );
	}

	public List<ICFBamServerListFuncObj> readServerListFuncByRetTblIdx( Long RetTenantId,
		Long RetTableId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerListFuncByRetTblIdx";
		CFBamServerListFuncByRetTblIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerListFunc().newRetTblIdxKey();
		key.setOptionalRetTenantId( RetTenantId );
		key.setOptionalRetTableId( RetTableId );
		Map<CFBamScopePKey, ICFBamServerListFuncObj> dict;
		if( indexByRetTblIdx == null ) {
			indexByRetTblIdx = new HashMap< CFBamServerListFuncByRetTblIdxKey,
				Map< CFBamScopePKey, ICFBamServerListFuncObj > >();
		}
		if( ( ! forceRead ) && indexByRetTblIdx.containsKey( key ) ) {
			dict = indexByRetTblIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamServerListFuncObj>();
			ICFBamServerListFuncObj obj;
			CFBamServerListFuncBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableServerListFunc().readDerivedByRetTblIdx( schema.getAuthorization(),
				RetTenantId,
				RetTableId );
			CFBamServerListFuncBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamServerListFuncObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamServerListFuncObj realised = (ICFBamServerListFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRetTblIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamServerListFuncObj arr[] = new ICFBamServerListFuncObj[len];
		Iterator<ICFBamServerListFuncObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamServerListFuncObj> arrayList = new ArrayList<ICFBamServerListFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamServerListFuncObj> cmp = new Comparator<ICFBamServerListFuncObj>() {
			public int compare( ICFBamServerListFuncObj lhs, ICFBamServerListFuncObj rhs ) {
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
		List<ICFBamServerListFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamServerListFuncObj updateServerListFunc( ICFBamServerListFuncObj Obj ) {
		ICFBamServerListFuncObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableServerListFunc().updateServerListFunc( schema.getAuthorization(),
			Obj.getServerListFuncBuff() );
		if( Obj.getClassCode().equals( "SRVL" ) ) {
			obj = (ICFBamServerListFuncObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteServerListFunc( ICFBamServerListFuncObj Obj ) {
		ICFBamServerListFuncObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableServerListFunc().deleteServerListFunc( schema.getAuthorization(),
			obj.getServerListFuncBuff() );
		obj.forget( true );
	}

	public void deleteServerListFuncByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamServerListFuncObj obj = readServerListFunc( pkey );
		if( obj != null ) {
			ICFBamServerListFuncEditObj editObj = (ICFBamServerListFuncEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamServerListFuncEditObj)obj.beginEdit();
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

	public void deleteServerListFuncByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamServerListFuncObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerListFuncObj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableServerListFunc().deleteServerListFuncByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamServerListFuncObj> iter = dict.values().iterator();
			ICFBamServerListFuncObj obj;
			List<ICFBamServerListFuncObj> toForget = new LinkedList<ICFBamServerListFuncObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableServerListFunc().deleteServerListFuncByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteServerListFuncByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamServerMethodByUNameIdxKey,
				ICFBamServerListFuncObj >();
		}
		CFBamServerMethodByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamServerListFuncObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableServerListFunc().deleteServerListFuncByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableServerListFunc().deleteServerListFuncByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
		}
	}

	public void deleteServerListFuncByMethTableIdx( long TenantId,
		long TableId )
	{
		CFBamServerMethodByMethTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newMethTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByMethTableIdx == null ) {
			indexByMethTableIdx = new HashMap< CFBamServerMethodByMethTableIdxKey,
				Map< CFBamScopePKey, ICFBamServerListFuncObj > >();
		}
		if( indexByMethTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerListFuncObj> dict = indexByMethTableIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableServerListFunc().deleteServerListFuncByMethTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			Iterator<ICFBamServerListFuncObj> iter = dict.values().iterator();
			ICFBamServerListFuncObj obj;
			List<ICFBamServerListFuncObj> toForget = new LinkedList<ICFBamServerListFuncObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByMethTableIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableServerListFunc().deleteServerListFuncByMethTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
		}
	}

	public void deleteServerListFuncByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamServerMethodByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamServerMethodByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamServerListFuncObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerListFuncObj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableServerListFunc().deleteServerListFuncByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamServerListFuncObj> iter = dict.values().iterator();
			ICFBamServerListFuncObj obj;
			List<ICFBamServerListFuncObj> toForget = new LinkedList<ICFBamServerListFuncObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableServerListFunc().deleteServerListFuncByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteServerListFuncByRetTblIdx( Long RetTenantId,
		Long RetTableId )
	{
		CFBamServerListFuncByRetTblIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerListFunc().newRetTblIdxKey();
		key.setOptionalRetTenantId( RetTenantId );
		key.setOptionalRetTableId( RetTableId );
		if( indexByRetTblIdx == null ) {
			indexByRetTblIdx = new HashMap< CFBamServerListFuncByRetTblIdxKey,
				Map< CFBamScopePKey, ICFBamServerListFuncObj > >();
		}
		if( indexByRetTblIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerListFuncObj> dict = indexByRetTblIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableServerListFunc().deleteServerListFuncByRetTblIdx( schema.getAuthorization(),
				RetTenantId,
				RetTableId );
			Iterator<ICFBamServerListFuncObj> iter = dict.values().iterator();
			ICFBamServerListFuncObj obj;
			List<ICFBamServerListFuncObj> toForget = new LinkedList<ICFBamServerListFuncObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByRetTblIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableServerListFunc().deleteServerListFuncByRetTblIdx( schema.getAuthorization(),
				RetTenantId,
				RetTableId );
		}
	}
}
