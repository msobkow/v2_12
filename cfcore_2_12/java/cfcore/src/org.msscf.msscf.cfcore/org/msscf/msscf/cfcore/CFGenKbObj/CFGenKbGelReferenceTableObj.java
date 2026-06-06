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

public class CFGenKbGelReferenceTableObj
	implements ICFGenKbGelReferenceTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj> members;
	private Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj> allGelReference;
	private Map< CFGenKbGelInstructionByTenantIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > > indexByTenantIdx;
	private Map< CFGenKbGelInstructionByGelCacheIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > > indexByGelCacheIdx;
	private Map< CFGenKbGelInstructionByChainIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > > indexByChainIdx;
	private Map< CFGenKbGelReferenceByRemainderIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > > indexByRemainderIdx;
	public static String TABLE_NAME = "GelReference";
	public static String TABLE_DBNAME = "gelrefer";

	public CFGenKbGelReferenceTableObj() {
		schema = null;
		members = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj>();
		allGelReference = null;
		indexByTenantIdx = null;
		indexByGelCacheIdx = null;
		indexByChainIdx = null;
		indexByRemainderIdx = null;
	}

	public CFGenKbGelReferenceTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj>();
		allGelReference = null;
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
		allGelReference = null;
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
	 *	CFGenKbGelReferenceObj.
	 */
	public ICFGenKbGelReferenceObj newInstance() {
		ICFGenKbGelReferenceObj inst = new CFGenKbGelReferenceObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbGelReferenceObj.
	 */
	public ICFGenKbGelReferenceEditObj newEditInstance( ICFGenKbGelReferenceObj orig ) {
		ICFGenKbGelReferenceEditObj edit = new CFGenKbGelReferenceEditObj( orig );
		return( edit );
	}

	public ICFGenKbGelReferenceObj realiseGelReference( ICFGenKbGelReferenceObj Obj ) {
		ICFGenKbGelReferenceObj obj = Obj;
		CFGenKbGelInstructionPKey pkey = obj.getPKey();
		ICFGenKbGelReferenceObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbGelReferenceObj existingObj = members.get( pkey );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					indexByChainIdx.remove( keyChainIdx );
				}
			}

			if( indexByRemainderIdx != null ) {
				CFGenKbGelReferenceByRemainderIdxKey keyRemainderIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelReference().newRemainderIdxKey();
				keyRemainderIdx.setOptionalRemainderTenantId( keepObj.getOptionalRemainderTenantId() );
				keyRemainderIdx.setRequiredRemainderGelCacheId( keepObj.getRequiredRemainderGelCacheId() );
				keyRemainderIdx.setOptionalRemainderInstId( keepObj.getOptionalRemainderInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapRemainderIdx = indexByRemainderIdx.get( keyRemainderIdx );
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
			keepObj = (ICFGenKbGelReferenceObj)schema.getGelInstructionTableObj().realiseGelInstruction( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					mapChainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRemainderIdx != null ) {
				CFGenKbGelReferenceByRemainderIdxKey keyRemainderIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelReference().newRemainderIdxKey();
				keyRemainderIdx.setOptionalRemainderTenantId( keepObj.getOptionalRemainderTenantId() );
				keyRemainderIdx.setRequiredRemainderGelCacheId( keepObj.getRequiredRemainderGelCacheId() );
				keyRemainderIdx.setOptionalRemainderInstId( keepObj.getOptionalRemainderInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapRemainderIdx = indexByRemainderIdx.get( keyRemainderIdx );
				if( mapRemainderIdx != null ) {
					mapRemainderIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allGelReference != null ) {
				allGelReference.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFGenKbGelReferenceObj)schema.getGelInstructionTableObj().realiseGelInstruction( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allGelReference != null ) {
				allGelReference.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					mapChainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRemainderIdx != null ) {
				CFGenKbGelReferenceByRemainderIdxKey keyRemainderIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelReference().newRemainderIdxKey();
				keyRemainderIdx.setOptionalRemainderTenantId( keepObj.getOptionalRemainderTenantId() );
				keyRemainderIdx.setRequiredRemainderGelCacheId( keepObj.getRequiredRemainderGelCacheId() );
				keyRemainderIdx.setOptionalRemainderInstId( keepObj.getOptionalRemainderInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapRemainderIdx = indexByRemainderIdx.get( keyRemainderIdx );
				if( mapRemainderIdx != null ) {
					mapRemainderIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetGelReference( ICFGenKbGelReferenceObj Obj ) {
		forgetGelReference( Obj, false );
	}

	public void forgetGelReference( ICFGenKbGelReferenceObj Obj, boolean forgetSubObjects ) {
		ICFGenKbGelReferenceObj obj = Obj;
		CFGenKbGelInstructionPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbGelReferenceObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					indexByChainIdx.remove( keyChainIdx );
				}
			}

			if( indexByRemainderIdx != null ) {
				CFGenKbGelReferenceByRemainderIdxKey keyRemainderIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelReference().newRemainderIdxKey();
				keyRemainderIdx.setOptionalRemainderTenantId( keepObj.getOptionalRemainderTenantId() );
				keyRemainderIdx.setRequiredRemainderGelCacheId( keepObj.getRequiredRemainderGelCacheId() );
				keyRemainderIdx.setOptionalRemainderInstId( keepObj.getOptionalRemainderInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapRemainderIdx = indexByRemainderIdx.get( keyRemainderIdx );
				if( mapRemainderIdx != null ) {
					mapRemainderIdx.remove( keepObj.getPKey() );
					if( mapRemainderIdx.size() <= 0 ) {
						indexByRemainderIdx.remove( keyRemainderIdx );
					}
				}
			}

			if( allGelReference != null ) {
				allGelReference.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		((ICFGenKbSchemaObj)schema).getGelInstructionTableObj().forgetGelInstruction( obj );
	}

	public void forgetGelReferenceByPIdx( long TenantId,
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
			ICFGenKbGelReferenceObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetGelReferenceByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFGenKbGelReferenceObj> toForget = new LinkedList<ICFGenKbGelReferenceObj>();
		ICFGenKbGelReferenceObj cur = null;
		CFGenKbGelInstructionByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFGenKbGelReferenceObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelReferenceObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelReferenceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelReferenceByGelCacheIdx( long TenantId,
		long GelCacheId )
	{
		if( indexByGelCacheIdx == null ) {
			return;
		}
		List<ICFGenKbGelReferenceObj> toForget = new LinkedList<ICFGenKbGelReferenceObj>();
		ICFGenKbGelReferenceObj cur = null;
		CFGenKbGelInstructionByGelCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		if( indexByGelCacheIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapGelCacheIdx = indexByGelCacheIdx.get( key );
			if( mapGelCacheIdx != null ) {
				Iterator<ICFGenKbGelReferenceObj> iterDup = mapGelCacheIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGelCacheIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelReferenceObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelReferenceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelReferenceByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		if( indexByChainIdx == null ) {
			return;
		}
		List<ICFGenKbGelReferenceObj> toForget = new LinkedList<ICFGenKbGelReferenceObj>();
		ICFGenKbGelReferenceObj cur = null;
		CFGenKbGelInstructionByChainIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );
		if( indexByChainIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapChainIdx = indexByChainIdx.get( key );
			if( mapChainIdx != null ) {
				Iterator<ICFGenKbGelReferenceObj> iterDup = mapChainIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByChainIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelReferenceObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelReferenceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelReferenceByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId )
	{
		if( indexByRemainderIdx == null ) {
			return;
		}
		List<ICFGenKbGelReferenceObj> toForget = new LinkedList<ICFGenKbGelReferenceObj>();
		ICFGenKbGelReferenceObj cur = null;
		CFGenKbGelReferenceByRemainderIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelReference().newRemainderIdxKey();
		key.setOptionalRemainderTenantId( RemainderTenantId );
		key.setRequiredRemainderGelCacheId( RemainderGelCacheId );
		key.setOptionalRemainderInstId( RemainderInstId );
		if( indexByRemainderIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > mapRemainderIdx = indexByRemainderIdx.get( key );
			if( mapRemainderIdx != null ) {
				Iterator<ICFGenKbGelReferenceObj> iterDup = mapRemainderIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRemainderIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelReferenceObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelReferenceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbGelReferenceObj createGelReference( ICFGenKbGelReferenceObj Obj ) {
		ICFGenKbGelReferenceObj obj = Obj;
		CFGenKbGelReferenceBuff buff = obj.getGelReferenceBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelReference().createGelReference(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "GREF" ) ) {
			obj = (ICFGenKbGelReferenceObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbGelReferenceObj readGelReference( CFGenKbGelInstructionPKey pkey ) {
		return( readGelReference( pkey, false ) );
	}

	public ICFGenKbGelReferenceObj readGelReference( CFGenKbGelInstructionPKey pkey, boolean forceRead ) {
		ICFGenKbGelReferenceObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbGelReferenceBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelReference().readDerivedByPIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredGelCacheId(),
				pkey.getRequiredGelInstId() );
			if( readBuff != null ) {
				obj = (ICFGenKbGelReferenceObj)schema.getGelInstructionTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbGelReferenceObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbGelReferenceObj lockGelReference( CFGenKbGelInstructionPKey pkey ) {
		ICFGenKbGelReferenceObj locked = null;
		CFGenKbGelReferenceBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelReference().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFGenKbGelReferenceObj)schema.getGelInstructionTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbGelReferenceObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockGelReference", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbGelReferenceObj> readAllGelReference() {
		return( readAllGelReference( false ) );
	}

	public List<ICFGenKbGelReferenceObj> readAllGelReference( boolean forceRead ) {
		final String S_ProcName = "readAllGelReference";
		if( ( allGelReference == null ) || forceRead ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj> map = new HashMap<CFGenKbGelInstructionPKey,ICFGenKbGelReferenceObj>();
			allGelReference = map;
			CFGenKbGelReferenceBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelReference().readAllDerived( schema.getAuthorization() );
			CFGenKbGelReferenceBuff buff;
			ICFGenKbGelReferenceObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelReferenceObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelReferenceObj realised = (ICFGenKbGelReferenceObj)obj.realise();
			}
		}
		int len = allGelReference.size();
		ICFGenKbGelReferenceObj arr[] = new ICFGenKbGelReferenceObj[len];
		Iterator<ICFGenKbGelReferenceObj> valIter = allGelReference.values().iterator();
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
		ArrayList<ICFGenKbGelReferenceObj> arrayList = new ArrayList<ICFGenKbGelReferenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelReferenceObj> cmp = new Comparator<ICFGenKbGelReferenceObj>() {
			public int compare( ICFGenKbGelReferenceObj lhs, ICFGenKbGelReferenceObj rhs ) {
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
		List<ICFGenKbGelReferenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGelReferenceObj readGelReferenceByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		return( readGelReferenceByPIdx( TenantId,
			GelCacheId,
			GelInstId,
			false ) );
	}

	public ICFGenKbGelReferenceObj readGelReferenceByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId, boolean forceRead )
	{
		CFGenKbGelInstructionPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredGelCacheId( GelCacheId );
		pkey.setRequiredGelInstId( GelInstId );
		ICFGenKbGelReferenceObj obj = readGelReference( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbGelReferenceObj> readGelReferenceByTenantIdx( long TenantId )
	{
		return( readGelReferenceByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFGenKbGelReferenceObj> readGelReferenceByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelReferenceByTenantIdx";
		CFGenKbGelInstructionByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGelInstructionByTenantIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj>();
			ICFGenKbGelInstructionObj obj;
			CFGenKbGelInstructionBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFGenKbGelInstructionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelReferenceObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelReferenceObj realised = (ICFGenKbGelReferenceObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelReferenceObj arr[] = new ICFGenKbGelReferenceObj[len];
		Iterator<ICFGenKbGelReferenceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelReferenceObj> arrayList = new ArrayList<ICFGenKbGelReferenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelReferenceObj> cmp = new Comparator<ICFGenKbGelReferenceObj>() {
			public int compare( ICFGenKbGelReferenceObj lhs, ICFGenKbGelReferenceObj rhs ) {
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
		List<ICFGenKbGelReferenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelReferenceObj> readGelReferenceByGelCacheIdx( long TenantId,
		long GelCacheId )
	{
		return( readGelReferenceByGelCacheIdx( TenantId,
			GelCacheId,
			false ) );
	}

	public List<ICFGenKbGelReferenceObj> readGelReferenceByGelCacheIdx( long TenantId,
		long GelCacheId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelReferenceByGelCacheIdx";
		CFGenKbGelInstructionByGelCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj> dict;
		if( indexByGelCacheIdx == null ) {
			indexByGelCacheIdx = new HashMap< CFGenKbGelInstructionByGelCacheIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > >();
		}
		if( ( ! forceRead ) && indexByGelCacheIdx.containsKey( key ) ) {
			dict = indexByGelCacheIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj>();
			ICFGenKbGelInstructionObj obj;
			CFGenKbGelInstructionBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByGelCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
			CFGenKbGelInstructionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelReferenceObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelReferenceObj realised = (ICFGenKbGelReferenceObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGelCacheIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelReferenceObj arr[] = new ICFGenKbGelReferenceObj[len];
		Iterator<ICFGenKbGelReferenceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelReferenceObj> arrayList = new ArrayList<ICFGenKbGelReferenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelReferenceObj> cmp = new Comparator<ICFGenKbGelReferenceObj>() {
			public int compare( ICFGenKbGelReferenceObj lhs, ICFGenKbGelReferenceObj rhs ) {
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
		List<ICFGenKbGelReferenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelReferenceObj> readGelReferenceByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		return( readGelReferenceByChainIdx( ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId,
			false ) );
	}

	public List<ICFGenKbGelReferenceObj> readGelReferenceByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelReferenceByChainIdx";
		CFGenKbGelInstructionByChainIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj> dict;
		if( indexByChainIdx == null ) {
			indexByChainIdx = new HashMap< CFGenKbGelInstructionByChainIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > >();
		}
		if( ( ! forceRead ) && indexByChainIdx.containsKey( key ) ) {
			dict = indexByChainIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj>();
			ICFGenKbGelInstructionObj obj;
			CFGenKbGelInstructionBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByChainIdx( schema.getAuthorization(),
				ChainInstTenantId,
				ChainInstGelCacheId,
				ChainInstGelInstId );
			CFGenKbGelInstructionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelReferenceObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelReferenceObj realised = (ICFGenKbGelReferenceObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByChainIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelReferenceObj arr[] = new ICFGenKbGelReferenceObj[len];
		Iterator<ICFGenKbGelReferenceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelReferenceObj> arrayList = new ArrayList<ICFGenKbGelReferenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelReferenceObj> cmp = new Comparator<ICFGenKbGelReferenceObj>() {
			public int compare( ICFGenKbGelReferenceObj lhs, ICFGenKbGelReferenceObj rhs ) {
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
		List<ICFGenKbGelReferenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelReferenceObj> readGelReferenceByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId )
	{
		return( readGelReferenceByRemainderIdx( RemainderTenantId,
			RemainderGelCacheId,
			RemainderInstId,
			false ) );
	}

	public List<ICFGenKbGelReferenceObj> readGelReferenceByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelReferenceByRemainderIdx";
		CFGenKbGelReferenceByRemainderIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelReference().newRemainderIdxKey();
		key.setOptionalRemainderTenantId( RemainderTenantId );
		key.setRequiredRemainderGelCacheId( RemainderGelCacheId );
		key.setOptionalRemainderInstId( RemainderInstId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj> dict;
		if( indexByRemainderIdx == null ) {
			indexByRemainderIdx = new HashMap< CFGenKbGelReferenceByRemainderIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > >();
		}
		if( ( ! forceRead ) && indexByRemainderIdx.containsKey( key ) ) {
			dict = indexByRemainderIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj>();
			ICFGenKbGelReferenceObj obj;
			CFGenKbGelReferenceBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelReference().readDerivedByRemainderIdx( schema.getAuthorization(),
				RemainderTenantId,
				RemainderGelCacheId,
				RemainderInstId );
			CFGenKbGelReferenceBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelReferenceObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelReferenceObj realised = (ICFGenKbGelReferenceObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRemainderIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelReferenceObj arr[] = new ICFGenKbGelReferenceObj[len];
		Iterator<ICFGenKbGelReferenceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelReferenceObj> arrayList = new ArrayList<ICFGenKbGelReferenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelReferenceObj> cmp = new Comparator<ICFGenKbGelReferenceObj>() {
			public int compare( ICFGenKbGelReferenceObj lhs, ICFGenKbGelReferenceObj rhs ) {
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
		List<ICFGenKbGelReferenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGelReferenceObj updateGelReference( ICFGenKbGelReferenceObj Obj ) {
		ICFGenKbGelReferenceObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelReference().updateGelReference( schema.getAuthorization(),
			Obj.getGelReferenceBuff() );
		if( Obj.getClassCode().equals( "GREF" ) ) {
			obj = (ICFGenKbGelReferenceObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteGelReference( ICFGenKbGelReferenceObj Obj ) {
		ICFGenKbGelReferenceObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelReference().deleteGelReference( schema.getAuthorization(),
			obj.getGelReferenceBuff() );
		obj.forget( true );
	}

	public void deleteGelReferenceByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		CFGenKbGelInstructionPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredGelCacheId( GelCacheId );
		pkey.setRequiredGelInstId( GelInstId );
		ICFGenKbGelReferenceObj obj = readGelReference( pkey );
		if( obj != null ) {
			ICFGenKbGelReferenceEditObj editObj = (ICFGenKbGelReferenceEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbGelReferenceEditObj)obj.beginEdit();
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

	public void deleteGelReferenceByTenantIdx( long TenantId )
	{
		CFGenKbGelInstructionByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGelInstructionByTenantIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj> dict = indexByTenantIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelReference().deleteGelReferenceByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFGenKbGelReferenceObj> iter = dict.values().iterator();
			ICFGenKbGelReferenceObj obj;
			List<ICFGenKbGelReferenceObj> toForget = new LinkedList<ICFGenKbGelReferenceObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelReference().deleteGelReferenceByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteGelReferenceByGelCacheIdx( long TenantId,
		long GelCacheId )
	{
		CFGenKbGelInstructionByGelCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		if( indexByGelCacheIdx == null ) {
			indexByGelCacheIdx = new HashMap< CFGenKbGelInstructionByGelCacheIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > >();
		}
		if( indexByGelCacheIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj> dict = indexByGelCacheIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelReference().deleteGelReferenceByGelCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
			Iterator<ICFGenKbGelReferenceObj> iter = dict.values().iterator();
			ICFGenKbGelReferenceObj obj;
			List<ICFGenKbGelReferenceObj> toForget = new LinkedList<ICFGenKbGelReferenceObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelReference().deleteGelReferenceByGelCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
		}
	}

	public void deleteGelReferenceByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		CFGenKbGelInstructionByChainIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );
		if( indexByChainIdx == null ) {
			indexByChainIdx = new HashMap< CFGenKbGelInstructionByChainIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > >();
		}
		if( indexByChainIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj> dict = indexByChainIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelReference().deleteGelReferenceByChainIdx( schema.getAuthorization(),
				ChainInstTenantId,
				ChainInstGelCacheId,
				ChainInstGelInstId );
			Iterator<ICFGenKbGelReferenceObj> iter = dict.values().iterator();
			ICFGenKbGelReferenceObj obj;
			List<ICFGenKbGelReferenceObj> toForget = new LinkedList<ICFGenKbGelReferenceObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelReference().deleteGelReferenceByChainIdx( schema.getAuthorization(),
				ChainInstTenantId,
				ChainInstGelCacheId,
				ChainInstGelInstId );
		}
	}

	public void deleteGelReferenceByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId )
	{
		CFGenKbGelReferenceByRemainderIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelReference().newRemainderIdxKey();
		key.setOptionalRemainderTenantId( RemainderTenantId );
		key.setRequiredRemainderGelCacheId( RemainderGelCacheId );
		key.setOptionalRemainderInstId( RemainderInstId );
		if( indexByRemainderIdx == null ) {
			indexByRemainderIdx = new HashMap< CFGenKbGelReferenceByRemainderIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj > >();
		}
		if( indexByRemainderIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelReferenceObj> dict = indexByRemainderIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelReference().deleteGelReferenceByRemainderIdx( schema.getAuthorization(),
				RemainderTenantId,
				RemainderGelCacheId,
				RemainderInstId );
			Iterator<ICFGenKbGelReferenceObj> iter = dict.values().iterator();
			ICFGenKbGelReferenceObj obj;
			List<ICFGenKbGelReferenceObj> toForget = new LinkedList<ICFGenKbGelReferenceObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelReference().deleteGelReferenceByRemainderIdx( schema.getAuthorization(),
				RemainderTenantId,
				RemainderGelCacheId,
				RemainderInstId );
		}
	}
}
