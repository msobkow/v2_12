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

public class CFGenKbGelSequenceTableObj
	implements ICFGenKbGelSequenceTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj> members;
	private Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj> allGelSequence;
	private Map< CFGenKbGelInstructionByTenantIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > > indexByTenantIdx;
	private Map< CFGenKbGelInstructionByGelCacheIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > > indexByGelCacheIdx;
	private Map< CFGenKbGelInstructionByChainIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > > indexByChainIdx;
	private Map< CFGenKbGelSequenceByFirstInstIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > > indexByFirstInstIdx;
	private Map< CFGenKbGelSequenceByLastInstIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > > indexByLastInstIdx;
	public static String TABLE_NAME = "GelSequence";
	public static String TABLE_DBNAME = "gelsequence";

	public CFGenKbGelSequenceTableObj() {
		schema = null;
		members = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj>();
		allGelSequence = null;
		indexByTenantIdx = null;
		indexByGelCacheIdx = null;
		indexByChainIdx = null;
		indexByFirstInstIdx = null;
		indexByLastInstIdx = null;
	}

	public CFGenKbGelSequenceTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj>();
		allGelSequence = null;
		indexByTenantIdx = null;
		indexByGelCacheIdx = null;
		indexByChainIdx = null;
		indexByFirstInstIdx = null;
		indexByLastInstIdx = null;
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
		allGelSequence = null;
		indexByTenantIdx = null;
		indexByGelCacheIdx = null;
		indexByChainIdx = null;
		indexByFirstInstIdx = null;
		indexByLastInstIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbGelSequenceObj.
	 */
	public ICFGenKbGelSequenceObj newInstance() {
		ICFGenKbGelSequenceObj inst = new CFGenKbGelSequenceObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbGelSequenceObj.
	 */
	public ICFGenKbGelSequenceEditObj newEditInstance( ICFGenKbGelSequenceObj orig ) {
		ICFGenKbGelSequenceEditObj edit = new CFGenKbGelSequenceEditObj( orig );
		return( edit );
	}

	public ICFGenKbGelSequenceObj realiseGelSequence( ICFGenKbGelSequenceObj Obj ) {
		ICFGenKbGelSequenceObj obj = Obj;
		CFGenKbGelInstructionPKey pkey = obj.getPKey();
		ICFGenKbGelSequenceObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbGelSequenceObj existingObj = members.get( pkey );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					indexByChainIdx.remove( keyChainIdx );
				}
			}

			if( indexByFirstInstIdx != null ) {
				CFGenKbGelSequenceByFirstInstIdxKey keyFirstInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSequence().newFirstInstIdxKey();
				keyFirstInstIdx.setOptionalFirstInstTenantId( keepObj.getOptionalFirstInstTenantId() );
				keyFirstInstIdx.setOptionalFirstInstGelCacheId( keepObj.getOptionalFirstInstGelCacheId() );
				keyFirstInstIdx.setOptionalFirstInstId( keepObj.getOptionalFirstInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapFirstInstIdx = indexByFirstInstIdx.get( keyFirstInstIdx );
				if( mapFirstInstIdx != null ) {
					mapFirstInstIdx.remove( keepObj.getPKey() );
					if( mapFirstInstIdx.size() <= 0 ) {
						indexByFirstInstIdx.remove( keyFirstInstIdx );
					}
				}
			}

			if( indexByLastInstIdx != null ) {
				CFGenKbGelSequenceByLastInstIdxKey keyLastInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSequence().newLastInstIdxKey();
				keyLastInstIdx.setOptionalLastInstTenantId( keepObj.getOptionalLastInstTenantId() );
				keyLastInstIdx.setOptionalLastInstGelCacheId( keepObj.getOptionalLastInstGelCacheId() );
				keyLastInstIdx.setOptionalLastInstId( keepObj.getOptionalLastInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapLastInstIdx = indexByLastInstIdx.get( keyLastInstIdx );
				if( mapLastInstIdx != null ) {
					mapLastInstIdx.remove( keepObj.getPKey() );
					if( mapLastInstIdx.size() <= 0 ) {
						indexByLastInstIdx.remove( keyLastInstIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFGenKbGelSequenceObj)schema.getGelInstructionTableObj().realiseGelInstruction( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					mapChainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByFirstInstIdx != null ) {
				CFGenKbGelSequenceByFirstInstIdxKey keyFirstInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSequence().newFirstInstIdxKey();
				keyFirstInstIdx.setOptionalFirstInstTenantId( keepObj.getOptionalFirstInstTenantId() );
				keyFirstInstIdx.setOptionalFirstInstGelCacheId( keepObj.getOptionalFirstInstGelCacheId() );
				keyFirstInstIdx.setOptionalFirstInstId( keepObj.getOptionalFirstInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapFirstInstIdx = indexByFirstInstIdx.get( keyFirstInstIdx );
				if( mapFirstInstIdx != null ) {
					mapFirstInstIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLastInstIdx != null ) {
				CFGenKbGelSequenceByLastInstIdxKey keyLastInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSequence().newLastInstIdxKey();
				keyLastInstIdx.setOptionalLastInstTenantId( keepObj.getOptionalLastInstTenantId() );
				keyLastInstIdx.setOptionalLastInstGelCacheId( keepObj.getOptionalLastInstGelCacheId() );
				keyLastInstIdx.setOptionalLastInstId( keepObj.getOptionalLastInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapLastInstIdx = indexByLastInstIdx.get( keyLastInstIdx );
				if( mapLastInstIdx != null ) {
					mapLastInstIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allGelSequence != null ) {
				allGelSequence.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFGenKbGelSequenceObj)schema.getGelInstructionTableObj().realiseGelInstruction( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allGelSequence != null ) {
				allGelSequence.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					mapChainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByFirstInstIdx != null ) {
				CFGenKbGelSequenceByFirstInstIdxKey keyFirstInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSequence().newFirstInstIdxKey();
				keyFirstInstIdx.setOptionalFirstInstTenantId( keepObj.getOptionalFirstInstTenantId() );
				keyFirstInstIdx.setOptionalFirstInstGelCacheId( keepObj.getOptionalFirstInstGelCacheId() );
				keyFirstInstIdx.setOptionalFirstInstId( keepObj.getOptionalFirstInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapFirstInstIdx = indexByFirstInstIdx.get( keyFirstInstIdx );
				if( mapFirstInstIdx != null ) {
					mapFirstInstIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLastInstIdx != null ) {
				CFGenKbGelSequenceByLastInstIdxKey keyLastInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSequence().newLastInstIdxKey();
				keyLastInstIdx.setOptionalLastInstTenantId( keepObj.getOptionalLastInstTenantId() );
				keyLastInstIdx.setOptionalLastInstGelCacheId( keepObj.getOptionalLastInstGelCacheId() );
				keyLastInstIdx.setOptionalLastInstId( keepObj.getOptionalLastInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapLastInstIdx = indexByLastInstIdx.get( keyLastInstIdx );
				if( mapLastInstIdx != null ) {
					mapLastInstIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetGelSequence( ICFGenKbGelSequenceObj Obj ) {
		forgetGelSequence( Obj, false );
	}

	public void forgetGelSequence( ICFGenKbGelSequenceObj Obj, boolean forgetSubObjects ) {
		ICFGenKbGelSequenceObj obj = Obj;
		CFGenKbGelInstructionPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbGelSequenceObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					indexByChainIdx.remove( keyChainIdx );
				}
			}

			if( indexByFirstInstIdx != null ) {
				CFGenKbGelSequenceByFirstInstIdxKey keyFirstInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSequence().newFirstInstIdxKey();
				keyFirstInstIdx.setOptionalFirstInstTenantId( keepObj.getOptionalFirstInstTenantId() );
				keyFirstInstIdx.setOptionalFirstInstGelCacheId( keepObj.getOptionalFirstInstGelCacheId() );
				keyFirstInstIdx.setOptionalFirstInstId( keepObj.getOptionalFirstInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapFirstInstIdx = indexByFirstInstIdx.get( keyFirstInstIdx );
				if( mapFirstInstIdx != null ) {
					mapFirstInstIdx.remove( keepObj.getPKey() );
					if( mapFirstInstIdx.size() <= 0 ) {
						indexByFirstInstIdx.remove( keyFirstInstIdx );
					}
				}
			}

			if( indexByLastInstIdx != null ) {
				CFGenKbGelSequenceByLastInstIdxKey keyLastInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSequence().newLastInstIdxKey();
				keyLastInstIdx.setOptionalLastInstTenantId( keepObj.getOptionalLastInstTenantId() );
				keyLastInstIdx.setOptionalLastInstGelCacheId( keepObj.getOptionalLastInstGelCacheId() );
				keyLastInstIdx.setOptionalLastInstId( keepObj.getOptionalLastInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapLastInstIdx = indexByLastInstIdx.get( keyLastInstIdx );
				if( mapLastInstIdx != null ) {
					mapLastInstIdx.remove( keepObj.getPKey() );
					if( mapLastInstIdx.size() <= 0 ) {
						indexByLastInstIdx.remove( keyLastInstIdx );
					}
				}
			}

			if( allGelSequence != null ) {
				allGelSequence.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFGenKbSchemaObj)schema).getGelCallTableObj().forgetGelCallBySeqIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredGelCacheId(),
					keepObj.getRequiredGelInstId() );
			}
		}
		((ICFGenKbSchemaObj)schema).getGelInstructionTableObj().forgetGelInstruction( obj );
	}

	public void forgetGelSequenceByPIdx( long TenantId,
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
			ICFGenKbGelSequenceObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetGelSequenceByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFGenKbGelSequenceObj> toForget = new LinkedList<ICFGenKbGelSequenceObj>();
		ICFGenKbGelSequenceObj cur = null;
		CFGenKbGelInstructionByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFGenKbGelSequenceObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelSequenceObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelSequenceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelSequenceByGelCacheIdx( long TenantId,
		long GelCacheId )
	{
		if( indexByGelCacheIdx == null ) {
			return;
		}
		List<ICFGenKbGelSequenceObj> toForget = new LinkedList<ICFGenKbGelSequenceObj>();
		ICFGenKbGelSequenceObj cur = null;
		CFGenKbGelInstructionByGelCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		if( indexByGelCacheIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapGelCacheIdx = indexByGelCacheIdx.get( key );
			if( mapGelCacheIdx != null ) {
				Iterator<ICFGenKbGelSequenceObj> iterDup = mapGelCacheIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGelCacheIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelSequenceObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelSequenceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelSequenceByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		if( indexByChainIdx == null ) {
			return;
		}
		List<ICFGenKbGelSequenceObj> toForget = new LinkedList<ICFGenKbGelSequenceObj>();
		ICFGenKbGelSequenceObj cur = null;
		CFGenKbGelInstructionByChainIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );
		if( indexByChainIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapChainIdx = indexByChainIdx.get( key );
			if( mapChainIdx != null ) {
				Iterator<ICFGenKbGelSequenceObj> iterDup = mapChainIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByChainIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelSequenceObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelSequenceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelSequenceByFirstInstIdx( Long FirstInstTenantId,
		Long FirstInstGelCacheId,
		Long FirstInstId )
	{
		if( indexByFirstInstIdx == null ) {
			return;
		}
		List<ICFGenKbGelSequenceObj> toForget = new LinkedList<ICFGenKbGelSequenceObj>();
		ICFGenKbGelSequenceObj cur = null;
		CFGenKbGelSequenceByFirstInstIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSequence().newFirstInstIdxKey();
		key.setOptionalFirstInstTenantId( FirstInstTenantId );
		key.setOptionalFirstInstGelCacheId( FirstInstGelCacheId );
		key.setOptionalFirstInstId( FirstInstId );
		if( indexByFirstInstIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapFirstInstIdx = indexByFirstInstIdx.get( key );
			if( mapFirstInstIdx != null ) {
				Iterator<ICFGenKbGelSequenceObj> iterDup = mapFirstInstIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByFirstInstIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelSequenceObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelSequenceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelSequenceByLastInstIdx( Long LastInstTenantId,
		Long LastInstGelCacheId,
		Long LastInstId )
	{
		if( indexByLastInstIdx == null ) {
			return;
		}
		List<ICFGenKbGelSequenceObj> toForget = new LinkedList<ICFGenKbGelSequenceObj>();
		ICFGenKbGelSequenceObj cur = null;
		CFGenKbGelSequenceByLastInstIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSequence().newLastInstIdxKey();
		key.setOptionalLastInstTenantId( LastInstTenantId );
		key.setOptionalLastInstGelCacheId( LastInstGelCacheId );
		key.setOptionalLastInstId( LastInstId );
		if( indexByLastInstIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > mapLastInstIdx = indexByLastInstIdx.get( key );
			if( mapLastInstIdx != null ) {
				Iterator<ICFGenKbGelSequenceObj> iterDup = mapLastInstIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByLastInstIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelSequenceObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelSequenceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbGelSequenceObj createGelSequence( ICFGenKbGelSequenceObj Obj ) {
		ICFGenKbGelSequenceObj obj = Obj;
		CFGenKbGelSequenceBuff buff = obj.getGelSequenceBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().createGelSequence(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "GSEQ" ) ) {
			obj = (ICFGenKbGelSequenceObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbGelSequenceObj readGelSequence( CFGenKbGelInstructionPKey pkey ) {
		return( readGelSequence( pkey, false ) );
	}

	public ICFGenKbGelSequenceObj readGelSequence( CFGenKbGelInstructionPKey pkey, boolean forceRead ) {
		ICFGenKbGelSequenceObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbGelSequenceBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().readDerivedByPIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredGelCacheId(),
				pkey.getRequiredGelInstId() );
			if( readBuff != null ) {
				obj = (ICFGenKbGelSequenceObj)schema.getGelInstructionTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbGelSequenceObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbGelSequenceObj lockGelSequence( CFGenKbGelInstructionPKey pkey ) {
		ICFGenKbGelSequenceObj locked = null;
		CFGenKbGelSequenceBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFGenKbGelSequenceObj)schema.getGelInstructionTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbGelSequenceObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockGelSequence", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbGelSequenceObj> readAllGelSequence() {
		return( readAllGelSequence( false ) );
	}

	public List<ICFGenKbGelSequenceObj> readAllGelSequence( boolean forceRead ) {
		final String S_ProcName = "readAllGelSequence";
		if( ( allGelSequence == null ) || forceRead ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj> map = new HashMap<CFGenKbGelInstructionPKey,ICFGenKbGelSequenceObj>();
			allGelSequence = map;
			CFGenKbGelSequenceBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().readAllDerived( schema.getAuthorization() );
			CFGenKbGelSequenceBuff buff;
			ICFGenKbGelSequenceObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelSequenceObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelSequenceObj realised = (ICFGenKbGelSequenceObj)obj.realise();
			}
		}
		int len = allGelSequence.size();
		ICFGenKbGelSequenceObj arr[] = new ICFGenKbGelSequenceObj[len];
		Iterator<ICFGenKbGelSequenceObj> valIter = allGelSequence.values().iterator();
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
		ArrayList<ICFGenKbGelSequenceObj> arrayList = new ArrayList<ICFGenKbGelSequenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelSequenceObj> cmp = new Comparator<ICFGenKbGelSequenceObj>() {
			public int compare( ICFGenKbGelSequenceObj lhs, ICFGenKbGelSequenceObj rhs ) {
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
		List<ICFGenKbGelSequenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGelSequenceObj readGelSequenceByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		return( readGelSequenceByPIdx( TenantId,
			GelCacheId,
			GelInstId,
			false ) );
	}

	public ICFGenKbGelSequenceObj readGelSequenceByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId, boolean forceRead )
	{
		CFGenKbGelInstructionPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredGelCacheId( GelCacheId );
		pkey.setRequiredGelInstId( GelInstId );
		ICFGenKbGelSequenceObj obj = readGelSequence( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbGelSequenceObj> readGelSequenceByTenantIdx( long TenantId )
	{
		return( readGelSequenceByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFGenKbGelSequenceObj> readGelSequenceByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelSequenceByTenantIdx";
		CFGenKbGelInstructionByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGelInstructionByTenantIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj>();
			ICFGenKbGelInstructionObj obj;
			CFGenKbGelInstructionBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFGenKbGelInstructionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelSequenceObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelSequenceObj realised = (ICFGenKbGelSequenceObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelSequenceObj arr[] = new ICFGenKbGelSequenceObj[len];
		Iterator<ICFGenKbGelSequenceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelSequenceObj> arrayList = new ArrayList<ICFGenKbGelSequenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelSequenceObj> cmp = new Comparator<ICFGenKbGelSequenceObj>() {
			public int compare( ICFGenKbGelSequenceObj lhs, ICFGenKbGelSequenceObj rhs ) {
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
		List<ICFGenKbGelSequenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelSequenceObj> readGelSequenceByGelCacheIdx( long TenantId,
		long GelCacheId )
	{
		return( readGelSequenceByGelCacheIdx( TenantId,
			GelCacheId,
			false ) );
	}

	public List<ICFGenKbGelSequenceObj> readGelSequenceByGelCacheIdx( long TenantId,
		long GelCacheId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelSequenceByGelCacheIdx";
		CFGenKbGelInstructionByGelCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj> dict;
		if( indexByGelCacheIdx == null ) {
			indexByGelCacheIdx = new HashMap< CFGenKbGelInstructionByGelCacheIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > >();
		}
		if( ( ! forceRead ) && indexByGelCacheIdx.containsKey( key ) ) {
			dict = indexByGelCacheIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj>();
			ICFGenKbGelInstructionObj obj;
			CFGenKbGelInstructionBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByGelCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
			CFGenKbGelInstructionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelSequenceObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelSequenceObj realised = (ICFGenKbGelSequenceObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGelCacheIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelSequenceObj arr[] = new ICFGenKbGelSequenceObj[len];
		Iterator<ICFGenKbGelSequenceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelSequenceObj> arrayList = new ArrayList<ICFGenKbGelSequenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelSequenceObj> cmp = new Comparator<ICFGenKbGelSequenceObj>() {
			public int compare( ICFGenKbGelSequenceObj lhs, ICFGenKbGelSequenceObj rhs ) {
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
		List<ICFGenKbGelSequenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelSequenceObj> readGelSequenceByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		return( readGelSequenceByChainIdx( ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId,
			false ) );
	}

	public List<ICFGenKbGelSequenceObj> readGelSequenceByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelSequenceByChainIdx";
		CFGenKbGelInstructionByChainIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj> dict;
		if( indexByChainIdx == null ) {
			indexByChainIdx = new HashMap< CFGenKbGelInstructionByChainIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > >();
		}
		if( ( ! forceRead ) && indexByChainIdx.containsKey( key ) ) {
			dict = indexByChainIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj>();
			ICFGenKbGelInstructionObj obj;
			CFGenKbGelInstructionBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByChainIdx( schema.getAuthorization(),
				ChainInstTenantId,
				ChainInstGelCacheId,
				ChainInstGelInstId );
			CFGenKbGelInstructionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelSequenceObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelSequenceObj realised = (ICFGenKbGelSequenceObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByChainIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelSequenceObj arr[] = new ICFGenKbGelSequenceObj[len];
		Iterator<ICFGenKbGelSequenceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelSequenceObj> arrayList = new ArrayList<ICFGenKbGelSequenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelSequenceObj> cmp = new Comparator<ICFGenKbGelSequenceObj>() {
			public int compare( ICFGenKbGelSequenceObj lhs, ICFGenKbGelSequenceObj rhs ) {
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
		List<ICFGenKbGelSequenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelSequenceObj> readGelSequenceByFirstInstIdx( Long FirstInstTenantId,
		Long FirstInstGelCacheId,
		Long FirstInstId )
	{
		return( readGelSequenceByFirstInstIdx( FirstInstTenantId,
			FirstInstGelCacheId,
			FirstInstId,
			false ) );
	}

	public List<ICFGenKbGelSequenceObj> readGelSequenceByFirstInstIdx( Long FirstInstTenantId,
		Long FirstInstGelCacheId,
		Long FirstInstId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelSequenceByFirstInstIdx";
		CFGenKbGelSequenceByFirstInstIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSequence().newFirstInstIdxKey();
		key.setOptionalFirstInstTenantId( FirstInstTenantId );
		key.setOptionalFirstInstGelCacheId( FirstInstGelCacheId );
		key.setOptionalFirstInstId( FirstInstId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj> dict;
		if( indexByFirstInstIdx == null ) {
			indexByFirstInstIdx = new HashMap< CFGenKbGelSequenceByFirstInstIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > >();
		}
		if( ( ! forceRead ) && indexByFirstInstIdx.containsKey( key ) ) {
			dict = indexByFirstInstIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj>();
			ICFGenKbGelSequenceObj obj;
			CFGenKbGelSequenceBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().readDerivedByFirstInstIdx( schema.getAuthorization(),
				FirstInstTenantId,
				FirstInstGelCacheId,
				FirstInstId );
			CFGenKbGelSequenceBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelSequenceObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelSequenceObj realised = (ICFGenKbGelSequenceObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByFirstInstIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelSequenceObj arr[] = new ICFGenKbGelSequenceObj[len];
		Iterator<ICFGenKbGelSequenceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelSequenceObj> arrayList = new ArrayList<ICFGenKbGelSequenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelSequenceObj> cmp = new Comparator<ICFGenKbGelSequenceObj>() {
			public int compare( ICFGenKbGelSequenceObj lhs, ICFGenKbGelSequenceObj rhs ) {
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
		List<ICFGenKbGelSequenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelSequenceObj> readGelSequenceByLastInstIdx( Long LastInstTenantId,
		Long LastInstGelCacheId,
		Long LastInstId )
	{
		return( readGelSequenceByLastInstIdx( LastInstTenantId,
			LastInstGelCacheId,
			LastInstId,
			false ) );
	}

	public List<ICFGenKbGelSequenceObj> readGelSequenceByLastInstIdx( Long LastInstTenantId,
		Long LastInstGelCacheId,
		Long LastInstId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelSequenceByLastInstIdx";
		CFGenKbGelSequenceByLastInstIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSequence().newLastInstIdxKey();
		key.setOptionalLastInstTenantId( LastInstTenantId );
		key.setOptionalLastInstGelCacheId( LastInstGelCacheId );
		key.setOptionalLastInstId( LastInstId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj> dict;
		if( indexByLastInstIdx == null ) {
			indexByLastInstIdx = new HashMap< CFGenKbGelSequenceByLastInstIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > >();
		}
		if( ( ! forceRead ) && indexByLastInstIdx.containsKey( key ) ) {
			dict = indexByLastInstIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj>();
			ICFGenKbGelSequenceObj obj;
			CFGenKbGelSequenceBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().readDerivedByLastInstIdx( schema.getAuthorization(),
				LastInstTenantId,
				LastInstGelCacheId,
				LastInstId );
			CFGenKbGelSequenceBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelSequenceObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelSequenceObj realised = (ICFGenKbGelSequenceObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByLastInstIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelSequenceObj arr[] = new ICFGenKbGelSequenceObj[len];
		Iterator<ICFGenKbGelSequenceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelSequenceObj> arrayList = new ArrayList<ICFGenKbGelSequenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelSequenceObj> cmp = new Comparator<ICFGenKbGelSequenceObj>() {
			public int compare( ICFGenKbGelSequenceObj lhs, ICFGenKbGelSequenceObj rhs ) {
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
		List<ICFGenKbGelSequenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGelSequenceObj updateGelSequence( ICFGenKbGelSequenceObj Obj ) {
		ICFGenKbGelSequenceObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().updateGelSequence( schema.getAuthorization(),
			Obj.getGelSequenceBuff() );
		if( Obj.getClassCode().equals( "GSEQ" ) ) {
			obj = (ICFGenKbGelSequenceObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteGelSequence( ICFGenKbGelSequenceObj Obj ) {
		ICFGenKbGelSequenceObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().deleteGelSequence( schema.getAuthorization(),
			obj.getGelSequenceBuff() );
		obj.forget( true );
	}

	public void deleteGelSequenceByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		CFGenKbGelInstructionPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredGelCacheId( GelCacheId );
		pkey.setRequiredGelInstId( GelInstId );
		ICFGenKbGelSequenceObj obj = readGelSequence( pkey );
		if( obj != null ) {
			ICFGenKbGelSequenceEditObj editObj = (ICFGenKbGelSequenceEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbGelSequenceEditObj)obj.beginEdit();
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

	public void deleteGelSequenceByTenantIdx( long TenantId )
	{
		CFGenKbGelInstructionByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGelInstructionByTenantIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj> dict = indexByTenantIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().deleteGelSequenceByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFGenKbGelSequenceObj> iter = dict.values().iterator();
			ICFGenKbGelSequenceObj obj;
			List<ICFGenKbGelSequenceObj> toForget = new LinkedList<ICFGenKbGelSequenceObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().deleteGelSequenceByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteGelSequenceByGelCacheIdx( long TenantId,
		long GelCacheId )
	{
		CFGenKbGelInstructionByGelCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		if( indexByGelCacheIdx == null ) {
			indexByGelCacheIdx = new HashMap< CFGenKbGelInstructionByGelCacheIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > >();
		}
		if( indexByGelCacheIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj> dict = indexByGelCacheIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().deleteGelSequenceByGelCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
			Iterator<ICFGenKbGelSequenceObj> iter = dict.values().iterator();
			ICFGenKbGelSequenceObj obj;
			List<ICFGenKbGelSequenceObj> toForget = new LinkedList<ICFGenKbGelSequenceObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().deleteGelSequenceByGelCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
		}
	}

	public void deleteGelSequenceByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		CFGenKbGelInstructionByChainIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );
		if( indexByChainIdx == null ) {
			indexByChainIdx = new HashMap< CFGenKbGelInstructionByChainIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > >();
		}
		if( indexByChainIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj> dict = indexByChainIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().deleteGelSequenceByChainIdx( schema.getAuthorization(),
				ChainInstTenantId,
				ChainInstGelCacheId,
				ChainInstGelInstId );
			Iterator<ICFGenKbGelSequenceObj> iter = dict.values().iterator();
			ICFGenKbGelSequenceObj obj;
			List<ICFGenKbGelSequenceObj> toForget = new LinkedList<ICFGenKbGelSequenceObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().deleteGelSequenceByChainIdx( schema.getAuthorization(),
				ChainInstTenantId,
				ChainInstGelCacheId,
				ChainInstGelInstId );
		}
	}

	public void deleteGelSequenceByFirstInstIdx( Long FirstInstTenantId,
		Long FirstInstGelCacheId,
		Long FirstInstId )
	{
		CFGenKbGelSequenceByFirstInstIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSequence().newFirstInstIdxKey();
		key.setOptionalFirstInstTenantId( FirstInstTenantId );
		key.setOptionalFirstInstGelCacheId( FirstInstGelCacheId );
		key.setOptionalFirstInstId( FirstInstId );
		if( indexByFirstInstIdx == null ) {
			indexByFirstInstIdx = new HashMap< CFGenKbGelSequenceByFirstInstIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > >();
		}
		if( indexByFirstInstIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj> dict = indexByFirstInstIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().deleteGelSequenceByFirstInstIdx( schema.getAuthorization(),
				FirstInstTenantId,
				FirstInstGelCacheId,
				FirstInstId );
			Iterator<ICFGenKbGelSequenceObj> iter = dict.values().iterator();
			ICFGenKbGelSequenceObj obj;
			List<ICFGenKbGelSequenceObj> toForget = new LinkedList<ICFGenKbGelSequenceObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByFirstInstIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().deleteGelSequenceByFirstInstIdx( schema.getAuthorization(),
				FirstInstTenantId,
				FirstInstGelCacheId,
				FirstInstId );
		}
	}

	public void deleteGelSequenceByLastInstIdx( Long LastInstTenantId,
		Long LastInstGelCacheId,
		Long LastInstId )
	{
		CFGenKbGelSequenceByLastInstIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSequence().newLastInstIdxKey();
		key.setOptionalLastInstTenantId( LastInstTenantId );
		key.setOptionalLastInstGelCacheId( LastInstGelCacheId );
		key.setOptionalLastInstId( LastInstId );
		if( indexByLastInstIdx == null ) {
			indexByLastInstIdx = new HashMap< CFGenKbGelSequenceByLastInstIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj > >();
		}
		if( indexByLastInstIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelSequenceObj> dict = indexByLastInstIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().deleteGelSequenceByLastInstIdx( schema.getAuthorization(),
				LastInstTenantId,
				LastInstGelCacheId,
				LastInstId );
			Iterator<ICFGenKbGelSequenceObj> iter = dict.values().iterator();
			ICFGenKbGelSequenceObj obj;
			List<ICFGenKbGelSequenceObj> toForget = new LinkedList<ICFGenKbGelSequenceObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByLastInstIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().deleteGelSequenceByLastInstIdx( schema.getAuthorization(),
				LastInstTenantId,
				LastInstGelCacheId,
				LastInstId );
		}
	}
}
