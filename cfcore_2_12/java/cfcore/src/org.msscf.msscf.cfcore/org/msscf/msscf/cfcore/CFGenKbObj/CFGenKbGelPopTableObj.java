// Description: Java 11 Table Object implementation for CFGenKb.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public class CFGenKbGelPopTableObj
	implements ICFGenKbGelPopTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj> members;
	private Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj> allGelPop;
	private Map< CFGenKbGelInstructionByTenantIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > > indexByTenantIdx;
	private Map< CFGenKbGelInstructionByGelCacheIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > > indexByGelCacheIdx;
	private Map< CFGenKbGelInstructionByChainIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > > indexByChainIdx;
	private Map< CFGenKbGelPopByRemainderIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > > indexByRemainderIdx;
	public static String TABLE_NAME = "GelPop";
	public static String TABLE_DBNAME = "gelpop";

	public CFGenKbGelPopTableObj() {
		schema = null;
		members = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj>();
		allGelPop = null;
		indexByTenantIdx = null;
		indexByGelCacheIdx = null;
		indexByChainIdx = null;
		indexByRemainderIdx = null;
	}

	public CFGenKbGelPopTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj>();
		allGelPop = null;
		indexByTenantIdx = null;
		indexByGelCacheIdx = null;
		indexByChainIdx = null;
		indexByRemainderIdx = null;
	}

	public ICFGenKbSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFGenKbSchemaObj value ) {
		schema = value;
	}

	public String getTableName() {
		return( TABLE_NAME );
	}

	public String getTableDbName() {
		return( TABLE_DBNAME );
	}

	public Class getObjQualifyingClass() {
		return( null );
	}


	public void minimizeMemory() {
		allGelPop = null;
		indexByTenantIdx = null;
		indexByGelCacheIdx = null;
		indexByChainIdx = null;
		indexByRemainderIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbGelPopObj.
	 */
	public ICFGenKbGelPopObj newInstance() {
		ICFGenKbGelPopObj inst = new CFGenKbGelPopObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbGelPopObj.
	 */
	public ICFGenKbGelPopEditObj newEditInstance( ICFGenKbGelPopObj orig ) {
		ICFGenKbGelPopEditObj edit = new CFGenKbGelPopEditObj( orig );
		return( edit );
	}

	public ICFGenKbGelPopObj realiseGelPop( ICFGenKbGelPopObj Obj ) {
		ICFGenKbGelPopObj obj = Obj;
		CFGenKbGelInstructionPKey pkey = obj.getPKey();
		ICFGenKbGelPopObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbGelPopObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
				if( mapGelCacheIdx != null ) {
					indexByGelCacheIdx.remove( keyGelCacheIdx );
				}
			}

			if( indexByChainIdx != null ) {
				CFGenKbGelInstructionByChainIdxKey keyChainIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
				keyChainIdx.setOptionalChainInstTenantId( keepObj.getOptionalChainInstTenantId() );
				keyChainIdx.setOptionalChainInstGelCacheId( keepObj.getOptionalChainInstGelCacheId() );
				keyChainIdx.setOptionalChainInstGelInstId( keepObj.getOptionalChainInstGelInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					indexByChainIdx.remove( keyChainIdx );
				}
			}

			if( indexByRemainderIdx != null ) {
				CFGenKbGelPopByRemainderIdxKey keyRemainderIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelPop().newRemainderIdxKey();
				keyRemainderIdx.setOptionalRemainderTenantId( keepObj.getOptionalRemainderTenantId() );
				keyRemainderIdx.setRequiredRemainderGelCacheId( keepObj.getRequiredRemainderGelCacheId() );
				keyRemainderIdx.setOptionalRemainderInstId( keepObj.getOptionalRemainderInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapRemainderIdx = indexByRemainderIdx.get( keyRemainderIdx );
				if( mapRemainderIdx != null ) {
					mapRemainderIdx.remove( keepObj.getPKey() );
					if( mapRemainderIdx.size() <= 0 ) {
						indexByRemainderIdx.remove( keyRemainderIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFGenKbGelPopObj)schema.getGelInstructionTableObj().realiseGelInstruction( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
				if( mapGelCacheIdx != null ) {
					mapGelCacheIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByChainIdx != null ) {
				CFGenKbGelInstructionByChainIdxKey keyChainIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
				keyChainIdx.setOptionalChainInstTenantId( keepObj.getOptionalChainInstTenantId() );
				keyChainIdx.setOptionalChainInstGelCacheId( keepObj.getOptionalChainInstGelCacheId() );
				keyChainIdx.setOptionalChainInstGelInstId( keepObj.getOptionalChainInstGelInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					mapChainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRemainderIdx != null ) {
				CFGenKbGelPopByRemainderIdxKey keyRemainderIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelPop().newRemainderIdxKey();
				keyRemainderIdx.setOptionalRemainderTenantId( keepObj.getOptionalRemainderTenantId() );
				keyRemainderIdx.setRequiredRemainderGelCacheId( keepObj.getRequiredRemainderGelCacheId() );
				keyRemainderIdx.setOptionalRemainderInstId( keepObj.getOptionalRemainderInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapRemainderIdx = indexByRemainderIdx.get( keyRemainderIdx );
				if( mapRemainderIdx != null ) {
					mapRemainderIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allGelPop != null ) {
				allGelPop.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFGenKbGelPopObj)schema.getGelInstructionTableObj().realiseGelInstruction( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allGelPop != null ) {
				allGelPop.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
				if( mapGelCacheIdx != null ) {
					mapGelCacheIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByChainIdx != null ) {
				CFGenKbGelInstructionByChainIdxKey keyChainIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
				keyChainIdx.setOptionalChainInstTenantId( keepObj.getOptionalChainInstTenantId() );
				keyChainIdx.setOptionalChainInstGelCacheId( keepObj.getOptionalChainInstGelCacheId() );
				keyChainIdx.setOptionalChainInstGelInstId( keepObj.getOptionalChainInstGelInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					mapChainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRemainderIdx != null ) {
				CFGenKbGelPopByRemainderIdxKey keyRemainderIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelPop().newRemainderIdxKey();
				keyRemainderIdx.setOptionalRemainderTenantId( keepObj.getOptionalRemainderTenantId() );
				keyRemainderIdx.setRequiredRemainderGelCacheId( keepObj.getRequiredRemainderGelCacheId() );
				keyRemainderIdx.setOptionalRemainderInstId( keepObj.getOptionalRemainderInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapRemainderIdx = indexByRemainderIdx.get( keyRemainderIdx );
				if( mapRemainderIdx != null ) {
					mapRemainderIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetGelPop( ICFGenKbGelPopObj Obj ) {
		forgetGelPop( Obj, false );
	}

	public void forgetGelPop( ICFGenKbGelPopObj Obj, boolean forgetSubObjects ) {
		ICFGenKbGelPopObj obj = Obj;
		CFGenKbGelInstructionPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbGelPopObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
				if( mapGelCacheIdx != null ) {
					indexByGelCacheIdx.remove( keyGelCacheIdx );
				}
			}

			if( indexByChainIdx != null ) {
				CFGenKbGelInstructionByChainIdxKey keyChainIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
				keyChainIdx.setOptionalChainInstTenantId( keepObj.getOptionalChainInstTenantId() );
				keyChainIdx.setOptionalChainInstGelCacheId( keepObj.getOptionalChainInstGelCacheId() );
				keyChainIdx.setOptionalChainInstGelInstId( keepObj.getOptionalChainInstGelInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					indexByChainIdx.remove( keyChainIdx );
				}
			}

			if( indexByRemainderIdx != null ) {
				CFGenKbGelPopByRemainderIdxKey keyRemainderIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelPop().newRemainderIdxKey();
				keyRemainderIdx.setOptionalRemainderTenantId( keepObj.getOptionalRemainderTenantId() );
				keyRemainderIdx.setRequiredRemainderGelCacheId( keepObj.getRequiredRemainderGelCacheId() );
				keyRemainderIdx.setOptionalRemainderInstId( keepObj.getOptionalRemainderInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapRemainderIdx = indexByRemainderIdx.get( keyRemainderIdx );
				if( mapRemainderIdx != null ) {
					mapRemainderIdx.remove( keepObj.getPKey() );
					if( mapRemainderIdx.size() <= 0 ) {
						indexByRemainderIdx.remove( keyRemainderIdx );
					}
				}
			}

			if( allGelPop != null ) {
				allGelPop.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		((ICFGenKbSchemaObj)schema).getGelInstructionTableObj().forgetGelInstruction( obj );
	}

	public void forgetGelPopByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		if( members == null ) {
			return;
		}
		CFGenKbGelInstructionPKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );
		if( members.containsKey( key ) ) {
			ICFGenKbGelPopObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetGelPopByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFGenKbGelPopObj> toForget = new LinkedList<ICFGenKbGelPopObj>();
		ICFGenKbGelPopObj cur = null;
		CFGenKbGelInstructionByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFGenKbGelPopObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelPopObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelPopObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelPopByGelCacheIdx( long TenantId,
		long GelCacheId )
	{
		if( indexByGelCacheIdx == null ) {
			return;
		}
		List<ICFGenKbGelPopObj> toForget = new LinkedList<ICFGenKbGelPopObj>();
		ICFGenKbGelPopObj cur = null;
		CFGenKbGelInstructionByGelCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		if( indexByGelCacheIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapGelCacheIdx = indexByGelCacheIdx.get( key );
			if( mapGelCacheIdx != null ) {
				Iterator<ICFGenKbGelPopObj> iterDup = mapGelCacheIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGelCacheIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelPopObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelPopObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelPopByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		if( indexByChainIdx == null ) {
			return;
		}
		List<ICFGenKbGelPopObj> toForget = new LinkedList<ICFGenKbGelPopObj>();
		ICFGenKbGelPopObj cur = null;
		CFGenKbGelInstructionByChainIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );
		if( indexByChainIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapChainIdx = indexByChainIdx.get( key );
			if( mapChainIdx != null ) {
				Iterator<ICFGenKbGelPopObj> iterDup = mapChainIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByChainIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelPopObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelPopObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelPopByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId )
	{
		if( indexByRemainderIdx == null ) {
			return;
		}
		List<ICFGenKbGelPopObj> toForget = new LinkedList<ICFGenKbGelPopObj>();
		ICFGenKbGelPopObj cur = null;
		CFGenKbGelPopByRemainderIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelPop().newRemainderIdxKey();
		key.setOptionalRemainderTenantId( RemainderTenantId );
		key.setRequiredRemainderGelCacheId( RemainderGelCacheId );
		key.setOptionalRemainderInstId( RemainderInstId );
		if( indexByRemainderIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > mapRemainderIdx = indexByRemainderIdx.get( key );
			if( mapRemainderIdx != null ) {
				Iterator<ICFGenKbGelPopObj> iterDup = mapRemainderIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRemainderIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelPopObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelPopObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbGelPopObj createGelPop( ICFGenKbGelPopObj Obj ) {
		ICFGenKbGelPopObj obj = Obj;
		CFGenKbGelPopBuff buff = obj.getGelPopBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelPop().createGelPop(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "GPOP" ) ) {
			obj = (ICFGenKbGelPopObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbGelPopObj readGelPop( CFGenKbGelInstructionPKey pkey ) {
		return( readGelPop( pkey, false ) );
	}

	public ICFGenKbGelPopObj readGelPop( CFGenKbGelInstructionPKey pkey, boolean forceRead ) {
		ICFGenKbGelPopObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbGelPopBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelPop().readDerivedByPIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredGelCacheId(),
				pkey.getRequiredGelInstId() );
			if( readBuff != null ) {
				obj = (ICFGenKbGelPopObj)schema.getGelInstructionTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbGelPopObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbGelPopObj lockGelPop( CFGenKbGelInstructionPKey pkey ) {
		ICFGenKbGelPopObj locked = null;
		CFGenKbGelPopBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelPop().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFGenKbGelPopObj)schema.getGelInstructionTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbGelPopObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockGelPop", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbGelPopObj> readAllGelPop() {
		return( readAllGelPop( false ) );
	}

	public List<ICFGenKbGelPopObj> readAllGelPop( boolean forceRead ) {
		final String S_ProcName = "readAllGelPop";
		if( ( allGelPop == null ) || forceRead ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj> map = new HashMap<CFGenKbGelInstructionPKey,ICFGenKbGelPopObj>();
			allGelPop = map;
			CFGenKbGelPopBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelPop().readAllDerived( schema.getAuthorization() );
			CFGenKbGelPopBuff buff;
			ICFGenKbGelPopObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelPopObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelPopObj realised = (ICFGenKbGelPopObj)obj.realise();
			}
		}
		int len = allGelPop.size();
		ICFGenKbGelPopObj arr[] = new ICFGenKbGelPopObj[len];
		Iterator<ICFGenKbGelPopObj> valIter = allGelPop.values().iterator();
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
		ArrayList<ICFGenKbGelPopObj> arrayList = new ArrayList<ICFGenKbGelPopObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelPopObj> cmp = new Comparator<ICFGenKbGelPopObj>() {
			public int compare( ICFGenKbGelPopObj lhs, ICFGenKbGelPopObj rhs ) {
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
					CFGenKbGelInstructionPKey lhsPKey = lhs.getPKey();
					CFGenKbGelInstructionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGelPopObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGelPopObj readGelPopByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		return( readGelPopByPIdx( TenantId,
			GelCacheId,
			GelInstId,
			false ) );
	}

	public ICFGenKbGelPopObj readGelPopByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId, boolean forceRead )
	{
		CFGenKbGelInstructionPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredGelCacheId( GelCacheId );
		pkey.setRequiredGelInstId( GelInstId );
		ICFGenKbGelPopObj obj = readGelPop( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbGelPopObj> readGelPopByTenantIdx( long TenantId )
	{
		return( readGelPopByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFGenKbGelPopObj> readGelPopByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelPopByTenantIdx";
		CFGenKbGelInstructionByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGelInstructionByTenantIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj>();
			ICFGenKbGelInstructionObj obj;
			CFGenKbGelInstructionBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFGenKbGelInstructionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelPopObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelPopObj realised = (ICFGenKbGelPopObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelPopObj arr[] = new ICFGenKbGelPopObj[len];
		Iterator<ICFGenKbGelPopObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelPopObj> arrayList = new ArrayList<ICFGenKbGelPopObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelPopObj> cmp = new Comparator<ICFGenKbGelPopObj>() {
			public int compare( ICFGenKbGelPopObj lhs, ICFGenKbGelPopObj rhs ) {
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
					CFGenKbGelInstructionPKey lhsPKey = lhs.getPKey();
					CFGenKbGelInstructionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGelPopObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelPopObj> readGelPopByGelCacheIdx( long TenantId,
		long GelCacheId )
	{
		return( readGelPopByGelCacheIdx( TenantId,
			GelCacheId,
			false ) );
	}

	public List<ICFGenKbGelPopObj> readGelPopByGelCacheIdx( long TenantId,
		long GelCacheId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelPopByGelCacheIdx";
		CFGenKbGelInstructionByGelCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj> dict;
		if( indexByGelCacheIdx == null ) {
			indexByGelCacheIdx = new HashMap< CFGenKbGelInstructionByGelCacheIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > >();
		}
		if( ( ! forceRead ) && indexByGelCacheIdx.containsKey( key ) ) {
			dict = indexByGelCacheIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj>();
			ICFGenKbGelInstructionObj obj;
			CFGenKbGelInstructionBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByGelCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
			CFGenKbGelInstructionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelPopObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelPopObj realised = (ICFGenKbGelPopObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGelCacheIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelPopObj arr[] = new ICFGenKbGelPopObj[len];
		Iterator<ICFGenKbGelPopObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelPopObj> arrayList = new ArrayList<ICFGenKbGelPopObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelPopObj> cmp = new Comparator<ICFGenKbGelPopObj>() {
			public int compare( ICFGenKbGelPopObj lhs, ICFGenKbGelPopObj rhs ) {
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
					CFGenKbGelInstructionPKey lhsPKey = lhs.getPKey();
					CFGenKbGelInstructionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGelPopObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelPopObj> readGelPopByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		return( readGelPopByChainIdx( ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId,
			false ) );
	}

	public List<ICFGenKbGelPopObj> readGelPopByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelPopByChainIdx";
		CFGenKbGelInstructionByChainIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj> dict;
		if( indexByChainIdx == null ) {
			indexByChainIdx = new HashMap< CFGenKbGelInstructionByChainIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > >();
		}
		if( ( ! forceRead ) && indexByChainIdx.containsKey( key ) ) {
			dict = indexByChainIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj>();
			ICFGenKbGelInstructionObj obj;
			CFGenKbGelInstructionBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByChainIdx( schema.getAuthorization(),
				ChainInstTenantId,
				ChainInstGelCacheId,
				ChainInstGelInstId );
			CFGenKbGelInstructionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelPopObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelPopObj realised = (ICFGenKbGelPopObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByChainIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelPopObj arr[] = new ICFGenKbGelPopObj[len];
		Iterator<ICFGenKbGelPopObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelPopObj> arrayList = new ArrayList<ICFGenKbGelPopObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelPopObj> cmp = new Comparator<ICFGenKbGelPopObj>() {
			public int compare( ICFGenKbGelPopObj lhs, ICFGenKbGelPopObj rhs ) {
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
					CFGenKbGelInstructionPKey lhsPKey = lhs.getPKey();
					CFGenKbGelInstructionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGelPopObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelPopObj> readGelPopByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId )
	{
		return( readGelPopByRemainderIdx( RemainderTenantId,
			RemainderGelCacheId,
			RemainderInstId,
			false ) );
	}

	public List<ICFGenKbGelPopObj> readGelPopByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelPopByRemainderIdx";
		CFGenKbGelPopByRemainderIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelPop().newRemainderIdxKey();
		key.setOptionalRemainderTenantId( RemainderTenantId );
		key.setRequiredRemainderGelCacheId( RemainderGelCacheId );
		key.setOptionalRemainderInstId( RemainderInstId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj> dict;
		if( indexByRemainderIdx == null ) {
			indexByRemainderIdx = new HashMap< CFGenKbGelPopByRemainderIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > >();
		}
		if( ( ! forceRead ) && indexByRemainderIdx.containsKey( key ) ) {
			dict = indexByRemainderIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj>();
			ICFGenKbGelPopObj obj;
			CFGenKbGelPopBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelPop().readDerivedByRemainderIdx( schema.getAuthorization(),
				RemainderTenantId,
				RemainderGelCacheId,
				RemainderInstId );
			CFGenKbGelPopBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelPopObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelPopObj realised = (ICFGenKbGelPopObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRemainderIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelPopObj arr[] = new ICFGenKbGelPopObj[len];
		Iterator<ICFGenKbGelPopObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelPopObj> arrayList = new ArrayList<ICFGenKbGelPopObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelPopObj> cmp = new Comparator<ICFGenKbGelPopObj>() {
			public int compare( ICFGenKbGelPopObj lhs, ICFGenKbGelPopObj rhs ) {
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
					CFGenKbGelInstructionPKey lhsPKey = lhs.getPKey();
					CFGenKbGelInstructionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGelPopObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGelPopObj updateGelPop( ICFGenKbGelPopObj Obj ) {
		ICFGenKbGelPopObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelPop().updateGelPop( schema.getAuthorization(),
			Obj.getGelPopBuff() );
		if( Obj.getClassCode().equals( "GPOP" ) ) {
			obj = (ICFGenKbGelPopObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteGelPop( ICFGenKbGelPopObj Obj ) {
		ICFGenKbGelPopObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelPop().deleteGelPop( schema.getAuthorization(),
			obj.getGelPopBuff() );
		obj.forget( true );
	}

	public void deleteGelPopByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		CFGenKbGelInstructionPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredGelCacheId( GelCacheId );
		pkey.setRequiredGelInstId( GelInstId );
		ICFGenKbGelPopObj obj = readGelPop( pkey );
		if( obj != null ) {
			ICFGenKbGelPopEditObj editObj = (ICFGenKbGelPopEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbGelPopEditObj)obj.beginEdit();
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

	public void deleteGelPopByTenantIdx( long TenantId )
	{
		CFGenKbGelInstructionByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGelInstructionByTenantIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj> dict = indexByTenantIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelPop().deleteGelPopByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFGenKbGelPopObj> iter = dict.values().iterator();
			ICFGenKbGelPopObj obj;
			List<ICFGenKbGelPopObj> toForget = new LinkedList<ICFGenKbGelPopObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelPop().deleteGelPopByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteGelPopByGelCacheIdx( long TenantId,
		long GelCacheId )
	{
		CFGenKbGelInstructionByGelCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		if( indexByGelCacheIdx == null ) {
			indexByGelCacheIdx = new HashMap< CFGenKbGelInstructionByGelCacheIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > >();
		}
		if( indexByGelCacheIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj> dict = indexByGelCacheIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelPop().deleteGelPopByGelCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
			Iterator<ICFGenKbGelPopObj> iter = dict.values().iterator();
			ICFGenKbGelPopObj obj;
			List<ICFGenKbGelPopObj> toForget = new LinkedList<ICFGenKbGelPopObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByGelCacheIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelPop().deleteGelPopByGelCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
		}
	}

	public void deleteGelPopByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		CFGenKbGelInstructionByChainIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );
		if( indexByChainIdx == null ) {
			indexByChainIdx = new HashMap< CFGenKbGelInstructionByChainIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > >();
		}
		if( indexByChainIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj> dict = indexByChainIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelPop().deleteGelPopByChainIdx( schema.getAuthorization(),
				ChainInstTenantId,
				ChainInstGelCacheId,
				ChainInstGelInstId );
			Iterator<ICFGenKbGelPopObj> iter = dict.values().iterator();
			ICFGenKbGelPopObj obj;
			List<ICFGenKbGelPopObj> toForget = new LinkedList<ICFGenKbGelPopObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByChainIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelPop().deleteGelPopByChainIdx( schema.getAuthorization(),
				ChainInstTenantId,
				ChainInstGelCacheId,
				ChainInstGelInstId );
		}
	}

	public void deleteGelPopByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId )
	{
		CFGenKbGelPopByRemainderIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelPop().newRemainderIdxKey();
		key.setOptionalRemainderTenantId( RemainderTenantId );
		key.setRequiredRemainderGelCacheId( RemainderGelCacheId );
		key.setOptionalRemainderInstId( RemainderInstId );
		if( indexByRemainderIdx == null ) {
			indexByRemainderIdx = new HashMap< CFGenKbGelPopByRemainderIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelPopObj > >();
		}
		if( indexByRemainderIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelPopObj> dict = indexByRemainderIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelPop().deleteGelPopByRemainderIdx( schema.getAuthorization(),
				RemainderTenantId,
				RemainderGelCacheId,
				RemainderInstId );
			Iterator<ICFGenKbGelPopObj> iter = dict.values().iterator();
			ICFGenKbGelPopObj obj;
			List<ICFGenKbGelPopObj> toForget = new LinkedList<ICFGenKbGelPopObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByRemainderIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelPop().deleteGelPopByRemainderIdx( schema.getAuthorization(),
				RemainderTenantId,
				RemainderGelCacheId,
				RemainderInstId );
		}
	}
}
