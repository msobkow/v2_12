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

public class CFBamServerObjFuncTableObj
	implements ICFBamServerObjFuncTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamServerObjFuncObj> members;
	private Map<CFBamScopePKey, ICFBamServerObjFuncObj> allServerObjFunc;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamServerObjFuncObj > > indexByTenantIdx;
	private Map< CFBamServerMethodByUNameIdxKey,
		ICFBamServerObjFuncObj > indexByUNameIdx;
	private Map< CFBamServerMethodByMethTableIdxKey,
		Map<CFBamScopePKey, ICFBamServerObjFuncObj > > indexByMethTableIdx;
	private Map< CFBamServerMethodByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamServerObjFuncObj > > indexByDefSchemaIdx;
	private Map< CFBamServerObjFuncByRetTblIdxKey,
		Map<CFBamScopePKey, ICFBamServerObjFuncObj > > indexByRetTblIdx;
	public static String TABLE_NAME = "ServerObjFunc";
	public static String TABLE_DBNAME = "srvofunc";

	public CFBamServerObjFuncTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamServerObjFuncObj>();
		allServerObjFunc = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByMethTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByRetTblIdx = null;
	}

	public CFBamServerObjFuncTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamServerObjFuncObj>();
		allServerObjFunc = null;
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
		allServerObjFunc = null;
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
	 *	CFBamServerObjFuncObj.
	 */
	public ICFBamServerObjFuncObj newInstance() {
		ICFBamServerObjFuncObj inst = new CFBamServerObjFuncObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamServerObjFuncObj.
	 */
	public ICFBamServerObjFuncEditObj newEditInstance( ICFBamServerObjFuncObj orig ) {
		ICFBamServerObjFuncEditObj edit = new CFBamServerObjFuncEditObj( orig );
		return( edit );
	}

	public ICFBamServerObjFuncObj realiseServerObjFunc( ICFBamServerObjFuncObj Obj ) {
		ICFBamServerObjFuncObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamServerObjFuncObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamServerObjFuncObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
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
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					indexByMethTableIdx.remove( keyMethTableIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByRetTblIdx != null ) {
				CFBamServerObjFuncByRetTblIdxKey keyRetTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerObjFunc().newRetTblIdxKey();
				keyRetTblIdx.setOptionalRetTenantId( keepObj.getOptionalRetTenantId() );
				keyRetTblIdx.setOptionalRetTableId( keepObj.getOptionalRetTableId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapRetTblIdx = indexByRetTblIdx.get( keyRetTblIdx );
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
			keepObj = (ICFBamServerObjFuncObj)schema.getServerMethodTableObj().realiseServerMethod( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
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
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					mapMethTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRetTblIdx != null ) {
				CFBamServerObjFuncByRetTblIdxKey keyRetTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerObjFunc().newRetTblIdxKey();
				keyRetTblIdx.setOptionalRetTenantId( keepObj.getOptionalRetTenantId() );
				keyRetTblIdx.setOptionalRetTableId( keepObj.getOptionalRetTableId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapRetTblIdx = indexByRetTblIdx.get( keyRetTblIdx );
				if( mapRetTblIdx != null ) {
					mapRetTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allServerObjFunc != null ) {
				allServerObjFunc.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamServerObjFuncObj)schema.getServerMethodTableObj().realiseServerMethod( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allServerObjFunc != null ) {
				allServerObjFunc.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
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
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					mapMethTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRetTblIdx != null ) {
				CFBamServerObjFuncByRetTblIdxKey keyRetTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerObjFunc().newRetTblIdxKey();
				keyRetTblIdx.setOptionalRetTenantId( keepObj.getOptionalRetTenantId() );
				keyRetTblIdx.setOptionalRetTableId( keepObj.getOptionalRetTableId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapRetTblIdx = indexByRetTblIdx.get( keyRetTblIdx );
				if( mapRetTblIdx != null ) {
					mapRetTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetServerObjFunc( ICFBamServerObjFuncObj Obj ) {
		forgetServerObjFunc( Obj, false );
	}

	public void forgetServerObjFunc( ICFBamServerObjFuncObj Obj, boolean forgetSubObjects ) {
		ICFBamServerObjFuncObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamServerObjFuncObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
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
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					indexByMethTableIdx.remove( keyMethTableIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByRetTblIdx != null ) {
				CFBamServerObjFuncByRetTblIdxKey keyRetTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryServerObjFunc().newRetTblIdxKey();
				keyRetTblIdx.setOptionalRetTenantId( keepObj.getOptionalRetTenantId() );
				keyRetTblIdx.setOptionalRetTableId( keepObj.getOptionalRetTableId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapRetTblIdx = indexByRetTblIdx.get( keyRetTblIdx );
				if( mapRetTblIdx != null ) {
					mapRetTblIdx.remove( keepObj.getPKey() );
					if( mapRetTblIdx.size() <= 0 ) {
						indexByRetTblIdx.remove( keyRetTblIdx );
					}
				}
			}

			if( allServerObjFunc != null ) {
				allServerObjFunc.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		((ICFBamSchemaObj)schema).getServerMethodTableObj().forgetServerMethod( obj );
	}

	public void forgetServerObjFuncByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamServerObjFuncObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetServerObjFuncByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamServerObjFuncObj> toForget = new LinkedList<ICFBamServerObjFuncObj>();
		ICFBamServerObjFuncObj cur = null;
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamServerObjFuncObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamServerObjFuncObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamServerObjFuncObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetServerObjFuncByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamServerObjFuncObj> toForget = new LinkedList<ICFBamServerObjFuncObj>();
		ICFBamServerObjFuncObj cur = null;
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
		Iterator<ICFBamServerObjFuncObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetServerObjFuncByMethTableIdx( long TenantId,
		long TableId )
	{
		if( indexByMethTableIdx == null ) {
			return;
		}
		List<ICFBamServerObjFuncObj> toForget = new LinkedList<ICFBamServerObjFuncObj>();
		ICFBamServerObjFuncObj cur = null;
		CFBamServerMethodByMethTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newMethTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByMethTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapMethTableIdx = indexByMethTableIdx.get( key );
			if( mapMethTableIdx != null ) {
				Iterator<ICFBamServerObjFuncObj> iterDup = mapMethTableIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByMethTableIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamServerObjFuncObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamServerObjFuncObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetServerObjFuncByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamServerObjFuncObj> toForget = new LinkedList<ICFBamServerObjFuncObj>();
		ICFBamServerObjFuncObj cur = null;
		CFBamServerMethodByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamServerObjFuncObj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamServerObjFuncObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamServerObjFuncObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetServerObjFuncByRetTblIdx( Long RetTenantId,
		Long RetTableId )
	{
		if( indexByRetTblIdx == null ) {
			return;
		}
		List<ICFBamServerObjFuncObj> toForget = new LinkedList<ICFBamServerObjFuncObj>();
		ICFBamServerObjFuncObj cur = null;
		CFBamServerObjFuncByRetTblIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerObjFunc().newRetTblIdxKey();
		key.setOptionalRetTenantId( RetTenantId );
		key.setOptionalRetTableId( RetTableId );
		if( indexByRetTblIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapRetTblIdx = indexByRetTblIdx.get( key );
			if( mapRetTblIdx != null ) {
				Iterator<ICFBamServerObjFuncObj> iterDup = mapRetTblIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRetTblIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamServerObjFuncObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamServerObjFuncObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamServerObjFuncObj createServerObjFunc( ICFBamServerObjFuncObj Obj ) {
		ICFBamServerObjFuncObj obj = Obj;
		CFBamServerObjFuncBuff buff = obj.getServerObjFuncBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableServerObjFunc().createServerObjFunc(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "SRVO" ) ) {
			obj = (ICFBamServerObjFuncObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamServerObjFuncObj readServerObjFunc( CFBamScopePKey pkey ) {
		return( readServerObjFunc( pkey, false ) );
	}

	public ICFBamServerObjFuncObj readServerObjFunc( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamServerObjFuncObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamServerObjFuncBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableServerObjFunc().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamServerObjFuncObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamServerObjFuncObj lockServerObjFunc( CFBamScopePKey pkey ) {
		ICFBamServerObjFuncObj locked = null;
		CFBamServerObjFuncBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableServerObjFunc().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamServerObjFuncObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockServerObjFunc", pkey );
		}
		return( locked );
	}

	public List<ICFBamServerObjFuncObj> readAllServerObjFunc() {
		return( readAllServerObjFunc( false ) );
	}

	public List<ICFBamServerObjFuncObj> readAllServerObjFunc( boolean forceRead ) {
		final String S_ProcName = "readAllServerObjFunc";
		if( ( allServerObjFunc == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamServerObjFuncObj> map = new HashMap<CFBamScopePKey,ICFBamServerObjFuncObj>();
			allServerObjFunc = map;
			CFBamServerObjFuncBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableServerObjFunc().readAllDerived( schema.getAuthorization() );
			CFBamServerObjFuncBuff buff;
			ICFBamServerObjFuncObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamServerObjFuncObj realised = (ICFBamServerObjFuncObj)obj.realise();
			}
		}
		int len = allServerObjFunc.size();
		ICFBamServerObjFuncObj arr[] = new ICFBamServerObjFuncObj[len];
		Iterator<ICFBamServerObjFuncObj> valIter = allServerObjFunc.values().iterator();
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
		ArrayList<ICFBamServerObjFuncObj> arrayList = new ArrayList<ICFBamServerObjFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamServerObjFuncObj> cmp = new Comparator<ICFBamServerObjFuncObj>() {
			public int compare( ICFBamServerObjFuncObj lhs, ICFBamServerObjFuncObj rhs ) {
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
		List<ICFBamServerObjFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamServerObjFuncObj readServerObjFuncByIdIdx( long TenantId,
		long Id )
	{
		return( readServerObjFuncByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamServerObjFuncObj readServerObjFuncByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamServerObjFuncObj obj = readServerObjFunc( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamServerObjFuncObj> readServerObjFuncByTenantIdx( long TenantId )
	{
		return( readServerObjFuncByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamServerObjFuncObj> readServerObjFuncByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerObjFuncByTenantIdx";
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamServerObjFuncObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamServerObjFuncObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamServerObjFuncObj>();
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamServerObjFuncObj realised = (ICFBamServerObjFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamServerObjFuncObj arr[] = new ICFBamServerObjFuncObj[len];
		Iterator<ICFBamServerObjFuncObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamServerObjFuncObj> arrayList = new ArrayList<ICFBamServerObjFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamServerObjFuncObj> cmp = new Comparator<ICFBamServerObjFuncObj>() {
			public int compare( ICFBamServerObjFuncObj lhs, ICFBamServerObjFuncObj rhs ) {
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
		List<ICFBamServerObjFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamServerObjFuncObj readServerObjFuncByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		return( readServerObjFuncByUNameIdx( TenantId,
			TableId,
			Name,
			false ) );
	}

	public ICFBamServerObjFuncObj readServerObjFuncByUNameIdx( long TenantId,
		long TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamServerMethodByUNameIdxKey,
				ICFBamServerObjFuncObj >();
		}
		CFBamServerMethodByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamServerObjFuncObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamServerMethodBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableServerMethod().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
			if( buff != null ) {
				obj = (ICFBamServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamServerObjFuncObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFBamServerObjFuncObj> readServerObjFuncByMethTableIdx( long TenantId,
		long TableId )
	{
		return( readServerObjFuncByMethTableIdx( TenantId,
			TableId,
			false ) );
	}

	public List<ICFBamServerObjFuncObj> readServerObjFuncByMethTableIdx( long TenantId,
		long TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerObjFuncByMethTableIdx";
		CFBamServerMethodByMethTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newMethTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		Map<CFBamScopePKey, ICFBamServerObjFuncObj> dict;
		if( indexByMethTableIdx == null ) {
			indexByMethTableIdx = new HashMap< CFBamServerMethodByMethTableIdxKey,
				Map< CFBamScopePKey, ICFBamServerObjFuncObj > >();
		}
		if( ( ! forceRead ) && indexByMethTableIdx.containsKey( key ) ) {
			dict = indexByMethTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamServerObjFuncObj>();
			ICFBamServerMethodObj obj;
			CFBamServerMethodBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableServerMethod().readDerivedByMethTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			CFBamServerMethodBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamServerObjFuncObj realised = (ICFBamServerObjFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByMethTableIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamServerObjFuncObj arr[] = new ICFBamServerObjFuncObj[len];
		Iterator<ICFBamServerObjFuncObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamServerObjFuncObj> arrayList = new ArrayList<ICFBamServerObjFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamServerObjFuncObj> cmp = new Comparator<ICFBamServerObjFuncObj>() {
			public int compare( ICFBamServerObjFuncObj lhs, ICFBamServerObjFuncObj rhs ) {
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
		List<ICFBamServerObjFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamServerObjFuncObj> readServerObjFuncByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readServerObjFuncByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamServerObjFuncObj> readServerObjFuncByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerObjFuncByDefSchemaIdx";
		CFBamServerMethodByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamServerObjFuncObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamServerMethodByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamServerObjFuncObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamServerObjFuncObj>();
			ICFBamServerMethodObj obj;
			CFBamServerMethodBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableServerMethod().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamServerMethodBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamServerObjFuncObj realised = (ICFBamServerObjFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamServerObjFuncObj arr[] = new ICFBamServerObjFuncObj[len];
		Iterator<ICFBamServerObjFuncObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamServerObjFuncObj> arrayList = new ArrayList<ICFBamServerObjFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamServerObjFuncObj> cmp = new Comparator<ICFBamServerObjFuncObj>() {
			public int compare( ICFBamServerObjFuncObj lhs, ICFBamServerObjFuncObj rhs ) {
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
		List<ICFBamServerObjFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamServerObjFuncObj> readServerObjFuncByRetTblIdx( Long RetTenantId,
		Long RetTableId )
	{
		return( readServerObjFuncByRetTblIdx( RetTenantId,
			RetTableId,
			false ) );
	}

	public List<ICFBamServerObjFuncObj> readServerObjFuncByRetTblIdx( Long RetTenantId,
		Long RetTableId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerObjFuncByRetTblIdx";
		CFBamServerObjFuncByRetTblIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerObjFunc().newRetTblIdxKey();
		key.setOptionalRetTenantId( RetTenantId );
		key.setOptionalRetTableId( RetTableId );
		Map<CFBamScopePKey, ICFBamServerObjFuncObj> dict;
		if( indexByRetTblIdx == null ) {
			indexByRetTblIdx = new HashMap< CFBamServerObjFuncByRetTblIdxKey,
				Map< CFBamScopePKey, ICFBamServerObjFuncObj > >();
		}
		if( ( ! forceRead ) && indexByRetTblIdx.containsKey( key ) ) {
			dict = indexByRetTblIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamServerObjFuncObj>();
			ICFBamServerObjFuncObj obj;
			CFBamServerObjFuncBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableServerObjFunc().readDerivedByRetTblIdx( schema.getAuthorization(),
				RetTenantId,
				RetTableId );
			CFBamServerObjFuncBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamServerObjFuncObj realised = (ICFBamServerObjFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRetTblIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamServerObjFuncObj arr[] = new ICFBamServerObjFuncObj[len];
		Iterator<ICFBamServerObjFuncObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamServerObjFuncObj> arrayList = new ArrayList<ICFBamServerObjFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamServerObjFuncObj> cmp = new Comparator<ICFBamServerObjFuncObj>() {
			public int compare( ICFBamServerObjFuncObj lhs, ICFBamServerObjFuncObj rhs ) {
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
		List<ICFBamServerObjFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamServerObjFuncObj updateServerObjFunc( ICFBamServerObjFuncObj Obj ) {
		ICFBamServerObjFuncObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableServerObjFunc().updateServerObjFunc( schema.getAuthorization(),
			Obj.getServerObjFuncBuff() );
		if( Obj.getClassCode().equals( "SRVO" ) ) {
			obj = (ICFBamServerObjFuncObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteServerObjFunc( ICFBamServerObjFuncObj Obj ) {
		ICFBamServerObjFuncObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableServerObjFunc().deleteServerObjFunc( schema.getAuthorization(),
			obj.getServerObjFuncBuff() );
		obj.forget( true );
	}

	public void deleteServerObjFuncByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamServerObjFuncObj obj = readServerObjFunc( pkey );
		if( obj != null ) {
			ICFBamServerObjFuncEditObj editObj = (ICFBamServerObjFuncEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamServerObjFuncEditObj)obj.beginEdit();
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

	public void deleteServerObjFuncByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamServerObjFuncObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerObjFuncObj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableServerObjFunc().deleteServerObjFuncByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamServerObjFuncObj> iter = dict.values().iterator();
			ICFBamServerObjFuncObj obj;
			List<ICFBamServerObjFuncObj> toForget = new LinkedList<ICFBamServerObjFuncObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableServerObjFunc().deleteServerObjFuncByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteServerObjFuncByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamServerMethodByUNameIdxKey,
				ICFBamServerObjFuncObj >();
		}
		CFBamServerMethodByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamServerObjFuncObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableServerObjFunc().deleteServerObjFuncByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableServerObjFunc().deleteServerObjFuncByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
		}
	}

	public void deleteServerObjFuncByMethTableIdx( long TenantId,
		long TableId )
	{
		CFBamServerMethodByMethTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newMethTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByMethTableIdx == null ) {
			indexByMethTableIdx = new HashMap< CFBamServerMethodByMethTableIdxKey,
				Map< CFBamScopePKey, ICFBamServerObjFuncObj > >();
		}
		if( indexByMethTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerObjFuncObj> dict = indexByMethTableIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableServerObjFunc().deleteServerObjFuncByMethTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			Iterator<ICFBamServerObjFuncObj> iter = dict.values().iterator();
			ICFBamServerObjFuncObj obj;
			List<ICFBamServerObjFuncObj> toForget = new LinkedList<ICFBamServerObjFuncObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableServerObjFunc().deleteServerObjFuncByMethTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
		}
	}

	public void deleteServerObjFuncByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamServerMethodByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerMethod().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamServerMethodByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamServerObjFuncObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerObjFuncObj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableServerObjFunc().deleteServerObjFuncByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamServerObjFuncObj> iter = dict.values().iterator();
			ICFBamServerObjFuncObj obj;
			List<ICFBamServerObjFuncObj> toForget = new LinkedList<ICFBamServerObjFuncObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableServerObjFunc().deleteServerObjFuncByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteServerObjFuncByRetTblIdx( Long RetTenantId,
		Long RetTableId )
	{
		CFBamServerObjFuncByRetTblIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryServerObjFunc().newRetTblIdxKey();
		key.setOptionalRetTenantId( RetTenantId );
		key.setOptionalRetTableId( RetTableId );
		if( indexByRetTblIdx == null ) {
			indexByRetTblIdx = new HashMap< CFBamServerObjFuncByRetTblIdxKey,
				Map< CFBamScopePKey, ICFBamServerObjFuncObj > >();
		}
		if( indexByRetTblIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerObjFuncObj> dict = indexByRetTblIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableServerObjFunc().deleteServerObjFuncByRetTblIdx( schema.getAuthorization(),
				RetTenantId,
				RetTableId );
			Iterator<ICFBamServerObjFuncObj> iter = dict.values().iterator();
			ICFBamServerObjFuncObj obj;
			List<ICFBamServerObjFuncObj> toForget = new LinkedList<ICFBamServerObjFuncObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableServerObjFunc().deleteServerObjFuncByRetTblIdx( schema.getAuthorization(),
				RetTenantId,
				RetTableId );
		}
	}
}
