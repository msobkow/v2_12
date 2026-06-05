// Description: Java 11 Table Object implementation for CFGenKb.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public class CFGenKbGelPrefixLineTableObj
	implements ICFGenKbGelPrefixLineTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj> members;
	private Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj> allGelPrefixLine;
	private Map< CFGenKbGelInstructionByTenantIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > > indexByTenantIdx;
	private Map< CFGenKbGelInstructionByGelCacheIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > > indexByGelCacheIdx;
	private Map< CFGenKbGelInstructionByChainIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > > indexByChainIdx;
	private Map< CFGenKbGelPrefixLineByRemainderIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > > indexByRemainderIdx;
	public static String TABLE_NAME = "GelPrefixLine";
	public static String TABLE_DBNAME = "gelprefix";

	public CFGenKbGelPrefixLineTableObj() {
		schema = null;
		members = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj>();
		allGelPrefixLine = null;
		indexByTenantIdx = null;
		indexByGelCacheIdx = null;
		indexByChainIdx = null;
		indexByRemainderIdx = null;
	}

	public CFGenKbGelPrefixLineTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj>();
		allGelPrefixLine = null;
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
		allGelPrefixLine = null;
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
	 *	CFGenKbGelPrefixLineObj.
	 */
	public ICFGenKbGelPrefixLineObj newInstance() {
		ICFGenKbGelPrefixLineObj inst = new CFGenKbGelPrefixLineObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbGelPrefixLineObj.
	 */
	public ICFGenKbGelPrefixLineEditObj newEditInstance( ICFGenKbGelPrefixLineObj orig ) {
		ICFGenKbGelPrefixLineEditObj edit = new CFGenKbGelPrefixLineEditObj( orig );
		return( edit );
	}

	public ICFGenKbGelPrefixLineObj realiseGelPrefixLine( ICFGenKbGelPrefixLineObj Obj ) {
		ICFGenKbGelPrefixLineObj obj = Obj;
		CFGenKbGelInstructionPKey pkey = obj.getPKey();
		ICFGenKbGelPrefixLineObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbGelPrefixLineObj existingObj = members.get( pkey );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					indexByChainIdx.remove( keyChainIdx );
				}
			}

			if( indexByRemainderIdx != null ) {
				CFGenKbGelPrefixLineByRemainderIdxKey keyRemainderIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelPrefixLine().newRemainderIdxKey();
				keyRemainderIdx.setOptionalRemainderTenantId( keepObj.getOptionalRemainderTenantId() );
				keyRemainderIdx.setRequiredRemainderGelCacheId( keepObj.getRequiredRemainderGelCacheId() );
				keyRemainderIdx.setOptionalRemainderInstId( keepObj.getOptionalRemainderInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapRemainderIdx = indexByRemainderIdx.get( keyRemainderIdx );
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
			keepObj = (ICFGenKbGelPrefixLineObj)schema.getGelInstructionTableObj().realiseGelInstruction( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					mapChainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRemainderIdx != null ) {
				CFGenKbGelPrefixLineByRemainderIdxKey keyRemainderIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelPrefixLine().newRemainderIdxKey();
				keyRemainderIdx.setOptionalRemainderTenantId( keepObj.getOptionalRemainderTenantId() );
				keyRemainderIdx.setRequiredRemainderGelCacheId( keepObj.getRequiredRemainderGelCacheId() );
				keyRemainderIdx.setOptionalRemainderInstId( keepObj.getOptionalRemainderInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapRemainderIdx = indexByRemainderIdx.get( keyRemainderIdx );
				if( mapRemainderIdx != null ) {
					mapRemainderIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allGelPrefixLine != null ) {
				allGelPrefixLine.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFGenKbGelPrefixLineObj)schema.getGelInstructionTableObj().realiseGelInstruction( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allGelPrefixLine != null ) {
				allGelPrefixLine.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					mapChainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRemainderIdx != null ) {
				CFGenKbGelPrefixLineByRemainderIdxKey keyRemainderIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelPrefixLine().newRemainderIdxKey();
				keyRemainderIdx.setOptionalRemainderTenantId( keepObj.getOptionalRemainderTenantId() );
				keyRemainderIdx.setRequiredRemainderGelCacheId( keepObj.getRequiredRemainderGelCacheId() );
				keyRemainderIdx.setOptionalRemainderInstId( keepObj.getOptionalRemainderInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapRemainderIdx = indexByRemainderIdx.get( keyRemainderIdx );
				if( mapRemainderIdx != null ) {
					mapRemainderIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetGelPrefixLine( ICFGenKbGelPrefixLineObj Obj ) {
		forgetGelPrefixLine( Obj, false );
	}

	public void forgetGelPrefixLine( ICFGenKbGelPrefixLineObj Obj, boolean forgetSubObjects ) {
		ICFGenKbGelPrefixLineObj obj = Obj;
		CFGenKbGelInstructionPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbGelPrefixLineObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					indexByChainIdx.remove( keyChainIdx );
				}
			}

			if( indexByRemainderIdx != null ) {
				CFGenKbGelPrefixLineByRemainderIdxKey keyRemainderIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelPrefixLine().newRemainderIdxKey();
				keyRemainderIdx.setOptionalRemainderTenantId( keepObj.getOptionalRemainderTenantId() );
				keyRemainderIdx.setRequiredRemainderGelCacheId( keepObj.getRequiredRemainderGelCacheId() );
				keyRemainderIdx.setOptionalRemainderInstId( keepObj.getOptionalRemainderInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapRemainderIdx = indexByRemainderIdx.get( keyRemainderIdx );
				if( mapRemainderIdx != null ) {
					mapRemainderIdx.remove( keepObj.getPKey() );
					if( mapRemainderIdx.size() <= 0 ) {
						indexByRemainderIdx.remove( keyRemainderIdx );
					}
				}
			}

			if( allGelPrefixLine != null ) {
				allGelPrefixLine.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		((ICFGenKbSchemaObj)schema).getGelInstructionTableObj().forgetGelInstruction( obj );
	}

	public void forgetGelPrefixLineByPIdx( long TenantId,
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
			ICFGenKbGelPrefixLineObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetGelPrefixLineByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFGenKbGelPrefixLineObj> toForget = new LinkedList<ICFGenKbGelPrefixLineObj>();
		ICFGenKbGelPrefixLineObj cur = null;
		CFGenKbGelInstructionByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFGenKbGelPrefixLineObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelPrefixLineObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelPrefixLineObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelPrefixLineByGelCacheIdx( long TenantId,
		long GelCacheId )
	{
		if( indexByGelCacheIdx == null ) {
			return;
		}
		List<ICFGenKbGelPrefixLineObj> toForget = new LinkedList<ICFGenKbGelPrefixLineObj>();
		ICFGenKbGelPrefixLineObj cur = null;
		CFGenKbGelInstructionByGelCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		if( indexByGelCacheIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapGelCacheIdx = indexByGelCacheIdx.get( key );
			if( mapGelCacheIdx != null ) {
				Iterator<ICFGenKbGelPrefixLineObj> iterDup = mapGelCacheIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGelCacheIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelPrefixLineObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelPrefixLineObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelPrefixLineByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		if( indexByChainIdx == null ) {
			return;
		}
		List<ICFGenKbGelPrefixLineObj> toForget = new LinkedList<ICFGenKbGelPrefixLineObj>();
		ICFGenKbGelPrefixLineObj cur = null;
		CFGenKbGelInstructionByChainIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );
		if( indexByChainIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapChainIdx = indexByChainIdx.get( key );
			if( mapChainIdx != null ) {
				Iterator<ICFGenKbGelPrefixLineObj> iterDup = mapChainIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByChainIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelPrefixLineObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelPrefixLineObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelPrefixLineByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId )
	{
		if( indexByRemainderIdx == null ) {
			return;
		}
		List<ICFGenKbGelPrefixLineObj> toForget = new LinkedList<ICFGenKbGelPrefixLineObj>();
		ICFGenKbGelPrefixLineObj cur = null;
		CFGenKbGelPrefixLineByRemainderIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelPrefixLine().newRemainderIdxKey();
		key.setOptionalRemainderTenantId( RemainderTenantId );
		key.setRequiredRemainderGelCacheId( RemainderGelCacheId );
		key.setOptionalRemainderInstId( RemainderInstId );
		if( indexByRemainderIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > mapRemainderIdx = indexByRemainderIdx.get( key );
			if( mapRemainderIdx != null ) {
				Iterator<ICFGenKbGelPrefixLineObj> iterDup = mapRemainderIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRemainderIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelPrefixLineObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelPrefixLineObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbGelPrefixLineObj createGelPrefixLine( ICFGenKbGelPrefixLineObj Obj ) {
		ICFGenKbGelPrefixLineObj obj = Obj;
		CFGenKbGelPrefixLineBuff buff = obj.getGelPrefixLineBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelPrefixLine().createGelPrefixLine(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "GPFX" ) ) {
			obj = (ICFGenKbGelPrefixLineObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbGelPrefixLineObj readGelPrefixLine( CFGenKbGelInstructionPKey pkey ) {
		return( readGelPrefixLine( pkey, false ) );
	}

	public ICFGenKbGelPrefixLineObj readGelPrefixLine( CFGenKbGelInstructionPKey pkey, boolean forceRead ) {
		ICFGenKbGelPrefixLineObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbGelPrefixLineBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelPrefixLine().readDerivedByPIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredGelCacheId(),
				pkey.getRequiredGelInstId() );
			if( readBuff != null ) {
				obj = (ICFGenKbGelPrefixLineObj)schema.getGelInstructionTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbGelPrefixLineObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbGelPrefixLineObj lockGelPrefixLine( CFGenKbGelInstructionPKey pkey ) {
		ICFGenKbGelPrefixLineObj locked = null;
		CFGenKbGelPrefixLineBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelPrefixLine().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFGenKbGelPrefixLineObj)schema.getGelInstructionTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbGelPrefixLineObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockGelPrefixLine", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbGelPrefixLineObj> readAllGelPrefixLine() {
		return( readAllGelPrefixLine( false ) );
	}

	public List<ICFGenKbGelPrefixLineObj> readAllGelPrefixLine( boolean forceRead ) {
		final String S_ProcName = "readAllGelPrefixLine";
		if( ( allGelPrefixLine == null ) || forceRead ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj> map = new HashMap<CFGenKbGelInstructionPKey,ICFGenKbGelPrefixLineObj>();
			allGelPrefixLine = map;
			CFGenKbGelPrefixLineBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelPrefixLine().readAllDerived( schema.getAuthorization() );
			CFGenKbGelPrefixLineBuff buff;
			ICFGenKbGelPrefixLineObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelPrefixLineObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelPrefixLineObj realised = (ICFGenKbGelPrefixLineObj)obj.realise();
			}
		}
		int len = allGelPrefixLine.size();
		ICFGenKbGelPrefixLineObj arr[] = new ICFGenKbGelPrefixLineObj[len];
		Iterator<ICFGenKbGelPrefixLineObj> valIter = allGelPrefixLine.values().iterator();
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
		ArrayList<ICFGenKbGelPrefixLineObj> arrayList = new ArrayList<ICFGenKbGelPrefixLineObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelPrefixLineObj> cmp = new Comparator<ICFGenKbGelPrefixLineObj>() {
			public int compare( ICFGenKbGelPrefixLineObj lhs, ICFGenKbGelPrefixLineObj rhs ) {
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
		List<ICFGenKbGelPrefixLineObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGelPrefixLineObj readGelPrefixLineByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		return( readGelPrefixLineByPIdx( TenantId,
			GelCacheId,
			GelInstId,
			false ) );
	}

	public ICFGenKbGelPrefixLineObj readGelPrefixLineByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId, boolean forceRead )
	{
		CFGenKbGelInstructionPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredGelCacheId( GelCacheId );
		pkey.setRequiredGelInstId( GelInstId );
		ICFGenKbGelPrefixLineObj obj = readGelPrefixLine( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbGelPrefixLineObj> readGelPrefixLineByTenantIdx( long TenantId )
	{
		return( readGelPrefixLineByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFGenKbGelPrefixLineObj> readGelPrefixLineByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelPrefixLineByTenantIdx";
		CFGenKbGelInstructionByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGelInstructionByTenantIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj>();
			ICFGenKbGelInstructionObj obj;
			CFGenKbGelInstructionBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFGenKbGelInstructionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelPrefixLineObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelPrefixLineObj realised = (ICFGenKbGelPrefixLineObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelPrefixLineObj arr[] = new ICFGenKbGelPrefixLineObj[len];
		Iterator<ICFGenKbGelPrefixLineObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelPrefixLineObj> arrayList = new ArrayList<ICFGenKbGelPrefixLineObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelPrefixLineObj> cmp = new Comparator<ICFGenKbGelPrefixLineObj>() {
			public int compare( ICFGenKbGelPrefixLineObj lhs, ICFGenKbGelPrefixLineObj rhs ) {
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
		List<ICFGenKbGelPrefixLineObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelPrefixLineObj> readGelPrefixLineByGelCacheIdx( long TenantId,
		long GelCacheId )
	{
		return( readGelPrefixLineByGelCacheIdx( TenantId,
			GelCacheId,
			false ) );
	}

	public List<ICFGenKbGelPrefixLineObj> readGelPrefixLineByGelCacheIdx( long TenantId,
		long GelCacheId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelPrefixLineByGelCacheIdx";
		CFGenKbGelInstructionByGelCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj> dict;
		if( indexByGelCacheIdx == null ) {
			indexByGelCacheIdx = new HashMap< CFGenKbGelInstructionByGelCacheIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > >();
		}
		if( ( ! forceRead ) && indexByGelCacheIdx.containsKey( key ) ) {
			dict = indexByGelCacheIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj>();
			ICFGenKbGelInstructionObj obj;
			CFGenKbGelInstructionBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByGelCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
			CFGenKbGelInstructionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelPrefixLineObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelPrefixLineObj realised = (ICFGenKbGelPrefixLineObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGelCacheIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelPrefixLineObj arr[] = new ICFGenKbGelPrefixLineObj[len];
		Iterator<ICFGenKbGelPrefixLineObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelPrefixLineObj> arrayList = new ArrayList<ICFGenKbGelPrefixLineObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelPrefixLineObj> cmp = new Comparator<ICFGenKbGelPrefixLineObj>() {
			public int compare( ICFGenKbGelPrefixLineObj lhs, ICFGenKbGelPrefixLineObj rhs ) {
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
		List<ICFGenKbGelPrefixLineObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelPrefixLineObj> readGelPrefixLineByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		return( readGelPrefixLineByChainIdx( ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId,
			false ) );
	}

	public List<ICFGenKbGelPrefixLineObj> readGelPrefixLineByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelPrefixLineByChainIdx";
		CFGenKbGelInstructionByChainIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj> dict;
		if( indexByChainIdx == null ) {
			indexByChainIdx = new HashMap< CFGenKbGelInstructionByChainIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > >();
		}
		if( ( ! forceRead ) && indexByChainIdx.containsKey( key ) ) {
			dict = indexByChainIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj>();
			ICFGenKbGelInstructionObj obj;
			CFGenKbGelInstructionBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByChainIdx( schema.getAuthorization(),
				ChainInstTenantId,
				ChainInstGelCacheId,
				ChainInstGelInstId );
			CFGenKbGelInstructionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelPrefixLineObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelPrefixLineObj realised = (ICFGenKbGelPrefixLineObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByChainIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelPrefixLineObj arr[] = new ICFGenKbGelPrefixLineObj[len];
		Iterator<ICFGenKbGelPrefixLineObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelPrefixLineObj> arrayList = new ArrayList<ICFGenKbGelPrefixLineObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelPrefixLineObj> cmp = new Comparator<ICFGenKbGelPrefixLineObj>() {
			public int compare( ICFGenKbGelPrefixLineObj lhs, ICFGenKbGelPrefixLineObj rhs ) {
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
		List<ICFGenKbGelPrefixLineObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelPrefixLineObj> readGelPrefixLineByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId )
	{
		return( readGelPrefixLineByRemainderIdx( RemainderTenantId,
			RemainderGelCacheId,
			RemainderInstId,
			false ) );
	}

	public List<ICFGenKbGelPrefixLineObj> readGelPrefixLineByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelPrefixLineByRemainderIdx";
		CFGenKbGelPrefixLineByRemainderIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelPrefixLine().newRemainderIdxKey();
		key.setOptionalRemainderTenantId( RemainderTenantId );
		key.setRequiredRemainderGelCacheId( RemainderGelCacheId );
		key.setOptionalRemainderInstId( RemainderInstId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj> dict;
		if( indexByRemainderIdx == null ) {
			indexByRemainderIdx = new HashMap< CFGenKbGelPrefixLineByRemainderIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > >();
		}
		if( ( ! forceRead ) && indexByRemainderIdx.containsKey( key ) ) {
			dict = indexByRemainderIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj>();
			ICFGenKbGelPrefixLineObj obj;
			CFGenKbGelPrefixLineBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelPrefixLine().readDerivedByRemainderIdx( schema.getAuthorization(),
				RemainderTenantId,
				RemainderGelCacheId,
				RemainderInstId );
			CFGenKbGelPrefixLineBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelPrefixLineObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelPrefixLineObj realised = (ICFGenKbGelPrefixLineObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRemainderIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelPrefixLineObj arr[] = new ICFGenKbGelPrefixLineObj[len];
		Iterator<ICFGenKbGelPrefixLineObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelPrefixLineObj> arrayList = new ArrayList<ICFGenKbGelPrefixLineObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelPrefixLineObj> cmp = new Comparator<ICFGenKbGelPrefixLineObj>() {
			public int compare( ICFGenKbGelPrefixLineObj lhs, ICFGenKbGelPrefixLineObj rhs ) {
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
		List<ICFGenKbGelPrefixLineObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGelPrefixLineObj updateGelPrefixLine( ICFGenKbGelPrefixLineObj Obj ) {
		ICFGenKbGelPrefixLineObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelPrefixLine().updateGelPrefixLine( schema.getAuthorization(),
			Obj.getGelPrefixLineBuff() );
		if( Obj.getClassCode().equals( "GPFX" ) ) {
			obj = (ICFGenKbGelPrefixLineObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteGelPrefixLine( ICFGenKbGelPrefixLineObj Obj ) {
		ICFGenKbGelPrefixLineObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelPrefixLine().deleteGelPrefixLine( schema.getAuthorization(),
			obj.getGelPrefixLineBuff() );
		obj.forget( true );
	}

	public void deleteGelPrefixLineByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		CFGenKbGelInstructionPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredGelCacheId( GelCacheId );
		pkey.setRequiredGelInstId( GelInstId );
		ICFGenKbGelPrefixLineObj obj = readGelPrefixLine( pkey );
		if( obj != null ) {
			ICFGenKbGelPrefixLineEditObj editObj = (ICFGenKbGelPrefixLineEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbGelPrefixLineEditObj)obj.beginEdit();
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

	public void deleteGelPrefixLineByTenantIdx( long TenantId )
	{
		CFGenKbGelInstructionByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGelInstructionByTenantIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj> dict = indexByTenantIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelPrefixLine().deleteGelPrefixLineByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFGenKbGelPrefixLineObj> iter = dict.values().iterator();
			ICFGenKbGelPrefixLineObj obj;
			List<ICFGenKbGelPrefixLineObj> toForget = new LinkedList<ICFGenKbGelPrefixLineObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelPrefixLine().deleteGelPrefixLineByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteGelPrefixLineByGelCacheIdx( long TenantId,
		long GelCacheId )
	{
		CFGenKbGelInstructionByGelCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		if( indexByGelCacheIdx == null ) {
			indexByGelCacheIdx = new HashMap< CFGenKbGelInstructionByGelCacheIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > >();
		}
		if( indexByGelCacheIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj> dict = indexByGelCacheIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelPrefixLine().deleteGelPrefixLineByGelCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
			Iterator<ICFGenKbGelPrefixLineObj> iter = dict.values().iterator();
			ICFGenKbGelPrefixLineObj obj;
			List<ICFGenKbGelPrefixLineObj> toForget = new LinkedList<ICFGenKbGelPrefixLineObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelPrefixLine().deleteGelPrefixLineByGelCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
		}
	}

	public void deleteGelPrefixLineByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		CFGenKbGelInstructionByChainIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );
		if( indexByChainIdx == null ) {
			indexByChainIdx = new HashMap< CFGenKbGelInstructionByChainIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > >();
		}
		if( indexByChainIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj> dict = indexByChainIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelPrefixLine().deleteGelPrefixLineByChainIdx( schema.getAuthorization(),
				ChainInstTenantId,
				ChainInstGelCacheId,
				ChainInstGelInstId );
			Iterator<ICFGenKbGelPrefixLineObj> iter = dict.values().iterator();
			ICFGenKbGelPrefixLineObj obj;
			List<ICFGenKbGelPrefixLineObj> toForget = new LinkedList<ICFGenKbGelPrefixLineObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelPrefixLine().deleteGelPrefixLineByChainIdx( schema.getAuthorization(),
				ChainInstTenantId,
				ChainInstGelCacheId,
				ChainInstGelInstId );
		}
	}

	public void deleteGelPrefixLineByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId )
	{
		CFGenKbGelPrefixLineByRemainderIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelPrefixLine().newRemainderIdxKey();
		key.setOptionalRemainderTenantId( RemainderTenantId );
		key.setRequiredRemainderGelCacheId( RemainderGelCacheId );
		key.setOptionalRemainderInstId( RemainderInstId );
		if( indexByRemainderIdx == null ) {
			indexByRemainderIdx = new HashMap< CFGenKbGelPrefixLineByRemainderIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj > >();
		}
		if( indexByRemainderIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelPrefixLineObj> dict = indexByRemainderIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelPrefixLine().deleteGelPrefixLineByRemainderIdx( schema.getAuthorization(),
				RemainderTenantId,
				RemainderGelCacheId,
				RemainderInstId );
			Iterator<ICFGenKbGelPrefixLineObj> iter = dict.values().iterator();
			ICFGenKbGelPrefixLineObj obj;
			List<ICFGenKbGelPrefixLineObj> toForget = new LinkedList<ICFGenKbGelPrefixLineObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelPrefixLine().deleteGelPrefixLineByRemainderIdx( schema.getAuthorization(),
				RemainderTenantId,
				RemainderGelCacheId,
				RemainderInstId );
		}
	}
}
