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

public class CFGenKbGelCallTableObj
	implements ICFGenKbGelCallTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> members;
	private Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> allGelCall;
	private Map< CFGenKbGelInstructionByTenantIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > > indexByTenantIdx;
	private Map< CFGenKbGelInstructionByGelCacheIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > > indexByGelCacheIdx;
	private Map< CFGenKbGelInstructionByChainIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > > indexByChainIdx;
	private Map< CFGenKbGelCallByCacheIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > > indexByCacheIdx;
	private Map< CFGenKbGelCallBySeqIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > > indexBySeqIdx;
	private Map< CFGenKbGelCallByCallInstIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > > indexByCallInstIdx;
	private Map< CFGenKbGelCallByPrevInstIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > > indexByPrevInstIdx;
	private Map< CFGenKbGelCallByNextInstIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > > indexByNextInstIdx;
	public static String TABLE_NAME = "GelCall";
	public static String TABLE_DBNAME = "gelcall";

	public CFGenKbGelCallTableObj() {
		schema = null;
		members = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj>();
		allGelCall = null;
		indexByTenantIdx = null;
		indexByGelCacheIdx = null;
		indexByChainIdx = null;
		indexByCacheIdx = null;
		indexBySeqIdx = null;
		indexByCallInstIdx = null;
		indexByPrevInstIdx = null;
		indexByNextInstIdx = null;
	}

	public CFGenKbGelCallTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj>();
		allGelCall = null;
		indexByTenantIdx = null;
		indexByGelCacheIdx = null;
		indexByChainIdx = null;
		indexByCacheIdx = null;
		indexBySeqIdx = null;
		indexByCallInstIdx = null;
		indexByPrevInstIdx = null;
		indexByNextInstIdx = null;
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
		allGelCall = null;
		indexByTenantIdx = null;
		indexByGelCacheIdx = null;
		indexByChainIdx = null;
		indexByCacheIdx = null;
		indexBySeqIdx = null;
		indexByCallInstIdx = null;
		indexByPrevInstIdx = null;
		indexByNextInstIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbGelCallObj.
	 */
	public ICFGenKbGelCallObj newInstance() {
		ICFGenKbGelCallObj inst = new CFGenKbGelCallObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbGelCallObj.
	 */
	public ICFGenKbGelCallEditObj newEditInstance( ICFGenKbGelCallObj orig ) {
		ICFGenKbGelCallEditObj edit = new CFGenKbGelCallEditObj( orig );
		return( edit );
	}

	public ICFGenKbGelCallObj realiseGelCall( ICFGenKbGelCallObj Obj ) {
		ICFGenKbGelCallObj obj = Obj;
		CFGenKbGelInstructionPKey pkey = obj.getPKey();
		ICFGenKbGelCallObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbGelCallObj existingObj = members.get( pkey );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					indexByChainIdx.remove( keyChainIdx );
				}
			}

			if( indexByCacheIdx != null ) {
				CFGenKbGelCallByCacheIdxKey keyCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newCacheIdxKey();
				keyCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapCacheIdx = indexByCacheIdx.get( keyCacheIdx );
				if( mapCacheIdx != null ) {
					mapCacheIdx.remove( keepObj.getPKey() );
					if( mapCacheIdx.size() <= 0 ) {
						indexByCacheIdx.remove( keyCacheIdx );
					}
				}
			}

			if( indexBySeqIdx != null ) {
				CFGenKbGelCallBySeqIdxKey keySeqIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newSeqIdxKey();
				keySeqIdx.setOptionalSeqInstTenantId( keepObj.getOptionalSeqInstTenantId() );
				keySeqIdx.setOptionalSeqInstGelCacheId( keepObj.getOptionalSeqInstGelCacheId() );
				keySeqIdx.setOptionalSeqInstId( keepObj.getOptionalSeqInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapSeqIdx = indexBySeqIdx.get( keySeqIdx );
				if( mapSeqIdx != null ) {
					mapSeqIdx.remove( keepObj.getPKey() );
					if( mapSeqIdx.size() <= 0 ) {
						indexBySeqIdx.remove( keySeqIdx );
					}
				}
			}

			if( indexByCallInstIdx != null ) {
				CFGenKbGelCallByCallInstIdxKey keyCallInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newCallInstIdxKey();
				keyCallInstIdx.setOptionalCallInstTenantId( keepObj.getOptionalCallInstTenantId() );
				keyCallInstIdx.setOptionalCallInstGelCacheId( keepObj.getOptionalCallInstGelCacheId() );
				keyCallInstIdx.setOptionalCallInstId( keepObj.getOptionalCallInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapCallInstIdx = indexByCallInstIdx.get( keyCallInstIdx );
				if( mapCallInstIdx != null ) {
					mapCallInstIdx.remove( keepObj.getPKey() );
					if( mapCallInstIdx.size() <= 0 ) {
						indexByCallInstIdx.remove( keyCallInstIdx );
					}
				}
			}

			if( indexByPrevInstIdx != null ) {
				CFGenKbGelCallByPrevInstIdxKey keyPrevInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newPrevInstIdxKey();
				keyPrevInstIdx.setOptionalPrevInstTenantId( keepObj.getOptionalPrevInstTenantId() );
				keyPrevInstIdx.setOptionalPrevInstGelCacheId( keepObj.getOptionalPrevInstGelCacheId() );
				keyPrevInstIdx.setOptionalPrevInstGelInstId( keepObj.getOptionalPrevInstGelInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapPrevInstIdx = indexByPrevInstIdx.get( keyPrevInstIdx );
				if( mapPrevInstIdx != null ) {
					mapPrevInstIdx.remove( keepObj.getPKey() );
					if( mapPrevInstIdx.size() <= 0 ) {
						indexByPrevInstIdx.remove( keyPrevInstIdx );
					}
				}
			}

			if( indexByNextInstIdx != null ) {
				CFGenKbGelCallByNextInstIdxKey keyNextInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newNextInstIdxKey();
				keyNextInstIdx.setOptionalNextInstTenantId( keepObj.getOptionalNextInstTenantId() );
				keyNextInstIdx.setOptionalNextInstGelCacheId( keepObj.getOptionalNextInstGelCacheId() );
				keyNextInstIdx.setOptionalNextInstGelInstId( keepObj.getOptionalNextInstGelInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapNextInstIdx = indexByNextInstIdx.get( keyNextInstIdx );
				if( mapNextInstIdx != null ) {
					mapNextInstIdx.remove( keepObj.getPKey() );
					if( mapNextInstIdx.size() <= 0 ) {
						indexByNextInstIdx.remove( keyNextInstIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFGenKbGelCallObj)schema.getGelInstructionTableObj().realiseGelInstruction( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					mapChainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCacheIdx != null ) {
				CFGenKbGelCallByCacheIdxKey keyCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newCacheIdxKey();
				keyCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapCacheIdx = indexByCacheIdx.get( keyCacheIdx );
				if( mapCacheIdx != null ) {
					mapCacheIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySeqIdx != null ) {
				CFGenKbGelCallBySeqIdxKey keySeqIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newSeqIdxKey();
				keySeqIdx.setOptionalSeqInstTenantId( keepObj.getOptionalSeqInstTenantId() );
				keySeqIdx.setOptionalSeqInstGelCacheId( keepObj.getOptionalSeqInstGelCacheId() );
				keySeqIdx.setOptionalSeqInstId( keepObj.getOptionalSeqInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapSeqIdx = indexBySeqIdx.get( keySeqIdx );
				if( mapSeqIdx != null ) {
					mapSeqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCallInstIdx != null ) {
				CFGenKbGelCallByCallInstIdxKey keyCallInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newCallInstIdxKey();
				keyCallInstIdx.setOptionalCallInstTenantId( keepObj.getOptionalCallInstTenantId() );
				keyCallInstIdx.setOptionalCallInstGelCacheId( keepObj.getOptionalCallInstGelCacheId() );
				keyCallInstIdx.setOptionalCallInstId( keepObj.getOptionalCallInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapCallInstIdx = indexByCallInstIdx.get( keyCallInstIdx );
				if( mapCallInstIdx != null ) {
					mapCallInstIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevInstIdx != null ) {
				CFGenKbGelCallByPrevInstIdxKey keyPrevInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newPrevInstIdxKey();
				keyPrevInstIdx.setOptionalPrevInstTenantId( keepObj.getOptionalPrevInstTenantId() );
				keyPrevInstIdx.setOptionalPrevInstGelCacheId( keepObj.getOptionalPrevInstGelCacheId() );
				keyPrevInstIdx.setOptionalPrevInstGelInstId( keepObj.getOptionalPrevInstGelInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapPrevInstIdx = indexByPrevInstIdx.get( keyPrevInstIdx );
				if( mapPrevInstIdx != null ) {
					mapPrevInstIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextInstIdx != null ) {
				CFGenKbGelCallByNextInstIdxKey keyNextInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newNextInstIdxKey();
				keyNextInstIdx.setOptionalNextInstTenantId( keepObj.getOptionalNextInstTenantId() );
				keyNextInstIdx.setOptionalNextInstGelCacheId( keepObj.getOptionalNextInstGelCacheId() );
				keyNextInstIdx.setOptionalNextInstGelInstId( keepObj.getOptionalNextInstGelInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapNextInstIdx = indexByNextInstIdx.get( keyNextInstIdx );
				if( mapNextInstIdx != null ) {
					mapNextInstIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allGelCall != null ) {
				allGelCall.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFGenKbGelCallObj)schema.getGelInstructionTableObj().realiseGelInstruction( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allGelCall != null ) {
				allGelCall.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					mapChainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCacheIdx != null ) {
				CFGenKbGelCallByCacheIdxKey keyCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newCacheIdxKey();
				keyCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapCacheIdx = indexByCacheIdx.get( keyCacheIdx );
				if( mapCacheIdx != null ) {
					mapCacheIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySeqIdx != null ) {
				CFGenKbGelCallBySeqIdxKey keySeqIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newSeqIdxKey();
				keySeqIdx.setOptionalSeqInstTenantId( keepObj.getOptionalSeqInstTenantId() );
				keySeqIdx.setOptionalSeqInstGelCacheId( keepObj.getOptionalSeqInstGelCacheId() );
				keySeqIdx.setOptionalSeqInstId( keepObj.getOptionalSeqInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapSeqIdx = indexBySeqIdx.get( keySeqIdx );
				if( mapSeqIdx != null ) {
					mapSeqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCallInstIdx != null ) {
				CFGenKbGelCallByCallInstIdxKey keyCallInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newCallInstIdxKey();
				keyCallInstIdx.setOptionalCallInstTenantId( keepObj.getOptionalCallInstTenantId() );
				keyCallInstIdx.setOptionalCallInstGelCacheId( keepObj.getOptionalCallInstGelCacheId() );
				keyCallInstIdx.setOptionalCallInstId( keepObj.getOptionalCallInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapCallInstIdx = indexByCallInstIdx.get( keyCallInstIdx );
				if( mapCallInstIdx != null ) {
					mapCallInstIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevInstIdx != null ) {
				CFGenKbGelCallByPrevInstIdxKey keyPrevInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newPrevInstIdxKey();
				keyPrevInstIdx.setOptionalPrevInstTenantId( keepObj.getOptionalPrevInstTenantId() );
				keyPrevInstIdx.setOptionalPrevInstGelCacheId( keepObj.getOptionalPrevInstGelCacheId() );
				keyPrevInstIdx.setOptionalPrevInstGelInstId( keepObj.getOptionalPrevInstGelInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapPrevInstIdx = indexByPrevInstIdx.get( keyPrevInstIdx );
				if( mapPrevInstIdx != null ) {
					mapPrevInstIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextInstIdx != null ) {
				CFGenKbGelCallByNextInstIdxKey keyNextInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newNextInstIdxKey();
				keyNextInstIdx.setOptionalNextInstTenantId( keepObj.getOptionalNextInstTenantId() );
				keyNextInstIdx.setOptionalNextInstGelCacheId( keepObj.getOptionalNextInstGelCacheId() );
				keyNextInstIdx.setOptionalNextInstGelInstId( keepObj.getOptionalNextInstGelInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapNextInstIdx = indexByNextInstIdx.get( keyNextInstIdx );
				if( mapNextInstIdx != null ) {
					mapNextInstIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetGelCall( ICFGenKbGelCallObj Obj ) {
		forgetGelCall( Obj, false );
	}

	public void forgetGelCall( ICFGenKbGelCallObj Obj, boolean forgetSubObjects ) {
		ICFGenKbGelCallObj obj = Obj;
		CFGenKbGelInstructionPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbGelCallObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
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
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					indexByChainIdx.remove( keyChainIdx );
				}
			}

			if( indexByCacheIdx != null ) {
				CFGenKbGelCallByCacheIdxKey keyCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newCacheIdxKey();
				keyCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapCacheIdx = indexByCacheIdx.get( keyCacheIdx );
				if( mapCacheIdx != null ) {
					mapCacheIdx.remove( keepObj.getPKey() );
					if( mapCacheIdx.size() <= 0 ) {
						indexByCacheIdx.remove( keyCacheIdx );
					}
				}
			}

			if( indexBySeqIdx != null ) {
				CFGenKbGelCallBySeqIdxKey keySeqIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newSeqIdxKey();
				keySeqIdx.setOptionalSeqInstTenantId( keepObj.getOptionalSeqInstTenantId() );
				keySeqIdx.setOptionalSeqInstGelCacheId( keepObj.getOptionalSeqInstGelCacheId() );
				keySeqIdx.setOptionalSeqInstId( keepObj.getOptionalSeqInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapSeqIdx = indexBySeqIdx.get( keySeqIdx );
				if( mapSeqIdx != null ) {
					mapSeqIdx.remove( keepObj.getPKey() );
					if( mapSeqIdx.size() <= 0 ) {
						indexBySeqIdx.remove( keySeqIdx );
					}
				}
			}

			if( indexByCallInstIdx != null ) {
				CFGenKbGelCallByCallInstIdxKey keyCallInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newCallInstIdxKey();
				keyCallInstIdx.setOptionalCallInstTenantId( keepObj.getOptionalCallInstTenantId() );
				keyCallInstIdx.setOptionalCallInstGelCacheId( keepObj.getOptionalCallInstGelCacheId() );
				keyCallInstIdx.setOptionalCallInstId( keepObj.getOptionalCallInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapCallInstIdx = indexByCallInstIdx.get( keyCallInstIdx );
				if( mapCallInstIdx != null ) {
					mapCallInstIdx.remove( keepObj.getPKey() );
					if( mapCallInstIdx.size() <= 0 ) {
						indexByCallInstIdx.remove( keyCallInstIdx );
					}
				}
			}

			if( indexByPrevInstIdx != null ) {
				CFGenKbGelCallByPrevInstIdxKey keyPrevInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newPrevInstIdxKey();
				keyPrevInstIdx.setOptionalPrevInstTenantId( keepObj.getOptionalPrevInstTenantId() );
				keyPrevInstIdx.setOptionalPrevInstGelCacheId( keepObj.getOptionalPrevInstGelCacheId() );
				keyPrevInstIdx.setOptionalPrevInstGelInstId( keepObj.getOptionalPrevInstGelInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapPrevInstIdx = indexByPrevInstIdx.get( keyPrevInstIdx );
				if( mapPrevInstIdx != null ) {
					mapPrevInstIdx.remove( keepObj.getPKey() );
					if( mapPrevInstIdx.size() <= 0 ) {
						indexByPrevInstIdx.remove( keyPrevInstIdx );
					}
				}
			}

			if( indexByNextInstIdx != null ) {
				CFGenKbGelCallByNextInstIdxKey keyNextInstIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newNextInstIdxKey();
				keyNextInstIdx.setOptionalNextInstTenantId( keepObj.getOptionalNextInstTenantId() );
				keyNextInstIdx.setOptionalNextInstGelCacheId( keepObj.getOptionalNextInstGelCacheId() );
				keyNextInstIdx.setOptionalNextInstGelInstId( keepObj.getOptionalNextInstGelInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapNextInstIdx = indexByNextInstIdx.get( keyNextInstIdx );
				if( mapNextInstIdx != null ) {
					mapNextInstIdx.remove( keepObj.getPKey() );
					if( mapNextInstIdx.size() <= 0 ) {
						indexByNextInstIdx.remove( keyNextInstIdx );
					}
				}
			}

			if( allGelCall != null ) {
				allGelCall.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		((ICFGenKbSchemaObj)schema).getGelInstructionTableObj().forgetGelInstruction( obj );
	}

	public void forgetGelCallByPIdx( long TenantId,
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
			ICFGenKbGelCallObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetGelCallByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFGenKbGelCallObj> toForget = new LinkedList<ICFGenKbGelCallObj>();
		ICFGenKbGelCallObj cur = null;
		CFGenKbGelInstructionByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFGenKbGelCallObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelCallObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelCallObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelCallByGelCacheIdx( long TenantId,
		long GelCacheId )
	{
		if( indexByGelCacheIdx == null ) {
			return;
		}
		List<ICFGenKbGelCallObj> toForget = new LinkedList<ICFGenKbGelCallObj>();
		ICFGenKbGelCallObj cur = null;
		CFGenKbGelInstructionByGelCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		if( indexByGelCacheIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapGelCacheIdx = indexByGelCacheIdx.get( key );
			if( mapGelCacheIdx != null ) {
				Iterator<ICFGenKbGelCallObj> iterDup = mapGelCacheIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGelCacheIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelCallObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelCallObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelCallByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		if( indexByChainIdx == null ) {
			return;
		}
		List<ICFGenKbGelCallObj> toForget = new LinkedList<ICFGenKbGelCallObj>();
		ICFGenKbGelCallObj cur = null;
		CFGenKbGelInstructionByChainIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );
		if( indexByChainIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapChainIdx = indexByChainIdx.get( key );
			if( mapChainIdx != null ) {
				Iterator<ICFGenKbGelCallObj> iterDup = mapChainIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByChainIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelCallObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelCallObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelCallByCacheIdx( long TenantId,
		long GelCacheId )
	{
		if( indexByCacheIdx == null ) {
			return;
		}
		List<ICFGenKbGelCallObj> toForget = new LinkedList<ICFGenKbGelCallObj>();
		ICFGenKbGelCallObj cur = null;
		CFGenKbGelCallByCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		if( indexByCacheIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapCacheIdx = indexByCacheIdx.get( key );
			if( mapCacheIdx != null ) {
				Iterator<ICFGenKbGelCallObj> iterDup = mapCacheIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByCacheIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelCallObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelCallObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelCallBySeqIdx( Long SeqInstTenantId,
		Long SeqInstGelCacheId,
		Long SeqInstId )
	{
		if( indexBySeqIdx == null ) {
			return;
		}
		List<ICFGenKbGelCallObj> toForget = new LinkedList<ICFGenKbGelCallObj>();
		ICFGenKbGelCallObj cur = null;
		CFGenKbGelCallBySeqIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newSeqIdxKey();
		key.setOptionalSeqInstTenantId( SeqInstTenantId );
		key.setOptionalSeqInstGelCacheId( SeqInstGelCacheId );
		key.setOptionalSeqInstId( SeqInstId );
		if( indexBySeqIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapSeqIdx = indexBySeqIdx.get( key );
			if( mapSeqIdx != null ) {
				Iterator<ICFGenKbGelCallObj> iterDup = mapSeqIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexBySeqIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelCallObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelCallObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelCallByCallInstIdx( Long CallInstTenantId,
		Long CallInstGelCacheId,
		Long CallInstId )
	{
		if( indexByCallInstIdx == null ) {
			return;
		}
		List<ICFGenKbGelCallObj> toForget = new LinkedList<ICFGenKbGelCallObj>();
		ICFGenKbGelCallObj cur = null;
		CFGenKbGelCallByCallInstIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newCallInstIdxKey();
		key.setOptionalCallInstTenantId( CallInstTenantId );
		key.setOptionalCallInstGelCacheId( CallInstGelCacheId );
		key.setOptionalCallInstId( CallInstId );
		if( indexByCallInstIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapCallInstIdx = indexByCallInstIdx.get( key );
			if( mapCallInstIdx != null ) {
				Iterator<ICFGenKbGelCallObj> iterDup = mapCallInstIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByCallInstIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelCallObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelCallObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelCallByPrevInstIdx( Long PrevInstTenantId,
		Long PrevInstGelCacheId,
		Long PrevInstGelInstId )
	{
		if( indexByPrevInstIdx == null ) {
			return;
		}
		List<ICFGenKbGelCallObj> toForget = new LinkedList<ICFGenKbGelCallObj>();
		ICFGenKbGelCallObj cur = null;
		CFGenKbGelCallByPrevInstIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newPrevInstIdxKey();
		key.setOptionalPrevInstTenantId( PrevInstTenantId );
		key.setOptionalPrevInstGelCacheId( PrevInstGelCacheId );
		key.setOptionalPrevInstGelInstId( PrevInstGelInstId );
		if( indexByPrevInstIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapPrevInstIdx = indexByPrevInstIdx.get( key );
			if( mapPrevInstIdx != null ) {
				Iterator<ICFGenKbGelCallObj> iterDup = mapPrevInstIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByPrevInstIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelCallObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelCallObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelCallByNextInstIdx( Long NextInstTenantId,
		Long NextInstGelCacheId,
		Long NextInstGelInstId )
	{
		if( indexByNextInstIdx == null ) {
			return;
		}
		List<ICFGenKbGelCallObj> toForget = new LinkedList<ICFGenKbGelCallObj>();
		ICFGenKbGelCallObj cur = null;
		CFGenKbGelCallByNextInstIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newNextInstIdxKey();
		key.setOptionalNextInstTenantId( NextInstTenantId );
		key.setOptionalNextInstGelCacheId( NextInstGelCacheId );
		key.setOptionalNextInstGelInstId( NextInstGelInstId );
		if( indexByNextInstIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > mapNextInstIdx = indexByNextInstIdx.get( key );
			if( mapNextInstIdx != null ) {
				Iterator<ICFGenKbGelCallObj> iterDup = mapNextInstIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByNextInstIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelCallObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelCallObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbGelCallObj createGelCall( ICFGenKbGelCallObj Obj ) {
		ICFGenKbGelCallObj obj = Obj;
		CFGenKbGelCallBuff buff = obj.getGelCallBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().createGelCall(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "GCAL" ) ) {
			obj = (ICFGenKbGelCallObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbGelCallObj readGelCall( CFGenKbGelInstructionPKey pkey ) {
		return( readGelCall( pkey, false ) );
	}

	public ICFGenKbGelCallObj readGelCall( CFGenKbGelInstructionPKey pkey, boolean forceRead ) {
		ICFGenKbGelCallObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbGelCallBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().readDerivedByPIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredGelCacheId(),
				pkey.getRequiredGelInstId() );
			if( readBuff != null ) {
				obj = (ICFGenKbGelCallObj)schema.getGelInstructionTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbGelCallObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbGelCallObj lockGelCall( CFGenKbGelInstructionPKey pkey ) {
		ICFGenKbGelCallObj locked = null;
		CFGenKbGelCallBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFGenKbGelCallObj)schema.getGelInstructionTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbGelCallObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockGelCall", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbGelCallObj> readAllGelCall() {
		return( readAllGelCall( false ) );
	}

	public List<ICFGenKbGelCallObj> readAllGelCall( boolean forceRead ) {
		final String S_ProcName = "readAllGelCall";
		if( ( allGelCall == null ) || forceRead ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> map = new HashMap<CFGenKbGelInstructionPKey,ICFGenKbGelCallObj>();
			allGelCall = map;
			CFGenKbGelCallBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().readAllDerived( schema.getAuthorization() );
			CFGenKbGelCallBuff buff;
			ICFGenKbGelCallObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelCallObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelCallObj realised = (ICFGenKbGelCallObj)obj.realise();
			}
		}
		int len = allGelCall.size();
		ICFGenKbGelCallObj arr[] = new ICFGenKbGelCallObj[len];
		Iterator<ICFGenKbGelCallObj> valIter = allGelCall.values().iterator();
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
		ArrayList<ICFGenKbGelCallObj> arrayList = new ArrayList<ICFGenKbGelCallObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelCallObj> cmp = new Comparator<ICFGenKbGelCallObj>() {
			public int compare( ICFGenKbGelCallObj lhs, ICFGenKbGelCallObj rhs ) {
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
		List<ICFGenKbGelCallObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGelCallObj readGelCallByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		return( readGelCallByPIdx( TenantId,
			GelCacheId,
			GelInstId,
			false ) );
	}

	public ICFGenKbGelCallObj readGelCallByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId, boolean forceRead )
	{
		CFGenKbGelInstructionPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredGelCacheId( GelCacheId );
		pkey.setRequiredGelInstId( GelInstId );
		ICFGenKbGelCallObj obj = readGelCall( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbGelCallObj> readGelCallByTenantIdx( long TenantId )
	{
		return( readGelCallByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFGenKbGelCallObj> readGelCallByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelCallByTenantIdx";
		CFGenKbGelInstructionByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGelInstructionByTenantIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj>();
			ICFGenKbGelInstructionObj obj;
			CFGenKbGelInstructionBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFGenKbGelInstructionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelCallObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelCallObj realised = (ICFGenKbGelCallObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelCallObj arr[] = new ICFGenKbGelCallObj[len];
		Iterator<ICFGenKbGelCallObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelCallObj> arrayList = new ArrayList<ICFGenKbGelCallObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelCallObj> cmp = new Comparator<ICFGenKbGelCallObj>() {
			public int compare( ICFGenKbGelCallObj lhs, ICFGenKbGelCallObj rhs ) {
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
		List<ICFGenKbGelCallObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelCallObj> readGelCallByGelCacheIdx( long TenantId,
		long GelCacheId )
	{
		return( readGelCallByGelCacheIdx( TenantId,
			GelCacheId,
			false ) );
	}

	public List<ICFGenKbGelCallObj> readGelCallByGelCacheIdx( long TenantId,
		long GelCacheId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelCallByGelCacheIdx";
		CFGenKbGelInstructionByGelCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> dict;
		if( indexByGelCacheIdx == null ) {
			indexByGelCacheIdx = new HashMap< CFGenKbGelInstructionByGelCacheIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > >();
		}
		if( ( ! forceRead ) && indexByGelCacheIdx.containsKey( key ) ) {
			dict = indexByGelCacheIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj>();
			ICFGenKbGelInstructionObj obj;
			CFGenKbGelInstructionBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByGelCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
			CFGenKbGelInstructionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelCallObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelCallObj realised = (ICFGenKbGelCallObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGelCacheIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelCallObj arr[] = new ICFGenKbGelCallObj[len];
		Iterator<ICFGenKbGelCallObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelCallObj> arrayList = new ArrayList<ICFGenKbGelCallObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelCallObj> cmp = new Comparator<ICFGenKbGelCallObj>() {
			public int compare( ICFGenKbGelCallObj lhs, ICFGenKbGelCallObj rhs ) {
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
		List<ICFGenKbGelCallObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelCallObj> readGelCallByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		return( readGelCallByChainIdx( ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId,
			false ) );
	}

	public List<ICFGenKbGelCallObj> readGelCallByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelCallByChainIdx";
		CFGenKbGelInstructionByChainIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> dict;
		if( indexByChainIdx == null ) {
			indexByChainIdx = new HashMap< CFGenKbGelInstructionByChainIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > >();
		}
		if( ( ! forceRead ) && indexByChainIdx.containsKey( key ) ) {
			dict = indexByChainIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj>();
			ICFGenKbGelInstructionObj obj;
			CFGenKbGelInstructionBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByChainIdx( schema.getAuthorization(),
				ChainInstTenantId,
				ChainInstGelCacheId,
				ChainInstGelInstId );
			CFGenKbGelInstructionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelCallObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelCallObj realised = (ICFGenKbGelCallObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByChainIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelCallObj arr[] = new ICFGenKbGelCallObj[len];
		Iterator<ICFGenKbGelCallObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelCallObj> arrayList = new ArrayList<ICFGenKbGelCallObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelCallObj> cmp = new Comparator<ICFGenKbGelCallObj>() {
			public int compare( ICFGenKbGelCallObj lhs, ICFGenKbGelCallObj rhs ) {
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
		List<ICFGenKbGelCallObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelCallObj> readGelCallByCacheIdx( long TenantId,
		long GelCacheId )
	{
		return( readGelCallByCacheIdx( TenantId,
			GelCacheId,
			false ) );
	}

	public List<ICFGenKbGelCallObj> readGelCallByCacheIdx( long TenantId,
		long GelCacheId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelCallByCacheIdx";
		CFGenKbGelCallByCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> dict;
		if( indexByCacheIdx == null ) {
			indexByCacheIdx = new HashMap< CFGenKbGelCallByCacheIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > >();
		}
		if( ( ! forceRead ) && indexByCacheIdx.containsKey( key ) ) {
			dict = indexByCacheIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj>();
			ICFGenKbGelCallObj obj;
			CFGenKbGelCallBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().readDerivedByCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
			CFGenKbGelCallBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelCallObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelCallObj realised = (ICFGenKbGelCallObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByCacheIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelCallObj arr[] = new ICFGenKbGelCallObj[len];
		Iterator<ICFGenKbGelCallObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelCallObj> arrayList = new ArrayList<ICFGenKbGelCallObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelCallObj> cmp = new Comparator<ICFGenKbGelCallObj>() {
			public int compare( ICFGenKbGelCallObj lhs, ICFGenKbGelCallObj rhs ) {
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
		List<ICFGenKbGelCallObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelCallObj> readGelCallBySeqIdx( Long SeqInstTenantId,
		Long SeqInstGelCacheId,
		Long SeqInstId )
	{
		return( readGelCallBySeqIdx( SeqInstTenantId,
			SeqInstGelCacheId,
			SeqInstId,
			false ) );
	}

	public List<ICFGenKbGelCallObj> readGelCallBySeqIdx( Long SeqInstTenantId,
		Long SeqInstGelCacheId,
		Long SeqInstId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelCallBySeqIdx";
		CFGenKbGelCallBySeqIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newSeqIdxKey();
		key.setOptionalSeqInstTenantId( SeqInstTenantId );
		key.setOptionalSeqInstGelCacheId( SeqInstGelCacheId );
		key.setOptionalSeqInstId( SeqInstId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> dict;
		if( indexBySeqIdx == null ) {
			indexBySeqIdx = new HashMap< CFGenKbGelCallBySeqIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > >();
		}
		if( ( ! forceRead ) && indexBySeqIdx.containsKey( key ) ) {
			dict = indexBySeqIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj>();
			ICFGenKbGelCallObj obj;
			CFGenKbGelCallBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().readDerivedBySeqIdx( schema.getAuthorization(),
				SeqInstTenantId,
				SeqInstGelCacheId,
				SeqInstId );
			CFGenKbGelCallBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelCallObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelCallObj realised = (ICFGenKbGelCallObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySeqIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelCallObj arr[] = new ICFGenKbGelCallObj[len];
		Iterator<ICFGenKbGelCallObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelCallObj> arrayList = new ArrayList<ICFGenKbGelCallObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelCallObj> cmp = new Comparator<ICFGenKbGelCallObj>() {
			public int compare( ICFGenKbGelCallObj lhs, ICFGenKbGelCallObj rhs ) {
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
		List<ICFGenKbGelCallObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelCallObj> readGelCallByCallInstIdx( Long CallInstTenantId,
		Long CallInstGelCacheId,
		Long CallInstId )
	{
		return( readGelCallByCallInstIdx( CallInstTenantId,
			CallInstGelCacheId,
			CallInstId,
			false ) );
	}

	public List<ICFGenKbGelCallObj> readGelCallByCallInstIdx( Long CallInstTenantId,
		Long CallInstGelCacheId,
		Long CallInstId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelCallByCallInstIdx";
		CFGenKbGelCallByCallInstIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newCallInstIdxKey();
		key.setOptionalCallInstTenantId( CallInstTenantId );
		key.setOptionalCallInstGelCacheId( CallInstGelCacheId );
		key.setOptionalCallInstId( CallInstId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> dict;
		if( indexByCallInstIdx == null ) {
			indexByCallInstIdx = new HashMap< CFGenKbGelCallByCallInstIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > >();
		}
		if( ( ! forceRead ) && indexByCallInstIdx.containsKey( key ) ) {
			dict = indexByCallInstIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj>();
			ICFGenKbGelCallObj obj;
			CFGenKbGelCallBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().readDerivedByCallInstIdx( schema.getAuthorization(),
				CallInstTenantId,
				CallInstGelCacheId,
				CallInstId );
			CFGenKbGelCallBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelCallObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelCallObj realised = (ICFGenKbGelCallObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByCallInstIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelCallObj arr[] = new ICFGenKbGelCallObj[len];
		Iterator<ICFGenKbGelCallObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelCallObj> arrayList = new ArrayList<ICFGenKbGelCallObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelCallObj> cmp = new Comparator<ICFGenKbGelCallObj>() {
			public int compare( ICFGenKbGelCallObj lhs, ICFGenKbGelCallObj rhs ) {
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
		List<ICFGenKbGelCallObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelCallObj> readGelCallByPrevInstIdx( Long PrevInstTenantId,
		Long PrevInstGelCacheId,
		Long PrevInstGelInstId )
	{
		return( readGelCallByPrevInstIdx( PrevInstTenantId,
			PrevInstGelCacheId,
			PrevInstGelInstId,
			false ) );
	}

	public List<ICFGenKbGelCallObj> readGelCallByPrevInstIdx( Long PrevInstTenantId,
		Long PrevInstGelCacheId,
		Long PrevInstGelInstId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelCallByPrevInstIdx";
		CFGenKbGelCallByPrevInstIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newPrevInstIdxKey();
		key.setOptionalPrevInstTenantId( PrevInstTenantId );
		key.setOptionalPrevInstGelCacheId( PrevInstGelCacheId );
		key.setOptionalPrevInstGelInstId( PrevInstGelInstId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> dict;
		if( indexByPrevInstIdx == null ) {
			indexByPrevInstIdx = new HashMap< CFGenKbGelCallByPrevInstIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > >();
		}
		if( ( ! forceRead ) && indexByPrevInstIdx.containsKey( key ) ) {
			dict = indexByPrevInstIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj>();
			ICFGenKbGelCallObj obj;
			CFGenKbGelCallBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().readDerivedByPrevInstIdx( schema.getAuthorization(),
				PrevInstTenantId,
				PrevInstGelCacheId,
				PrevInstGelInstId );
			CFGenKbGelCallBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelCallObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelCallObj realised = (ICFGenKbGelCallObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevInstIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelCallObj arr[] = new ICFGenKbGelCallObj[len];
		Iterator<ICFGenKbGelCallObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelCallObj> arrayList = new ArrayList<ICFGenKbGelCallObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelCallObj> cmp = new Comparator<ICFGenKbGelCallObj>() {
			public int compare( ICFGenKbGelCallObj lhs, ICFGenKbGelCallObj rhs ) {
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
		List<ICFGenKbGelCallObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelCallObj> readGelCallByNextInstIdx( Long NextInstTenantId,
		Long NextInstGelCacheId,
		Long NextInstGelInstId )
	{
		return( readGelCallByNextInstIdx( NextInstTenantId,
			NextInstGelCacheId,
			NextInstGelInstId,
			false ) );
	}

	public List<ICFGenKbGelCallObj> readGelCallByNextInstIdx( Long NextInstTenantId,
		Long NextInstGelCacheId,
		Long NextInstGelInstId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelCallByNextInstIdx";
		CFGenKbGelCallByNextInstIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newNextInstIdxKey();
		key.setOptionalNextInstTenantId( NextInstTenantId );
		key.setOptionalNextInstGelCacheId( NextInstGelCacheId );
		key.setOptionalNextInstGelInstId( NextInstGelInstId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> dict;
		if( indexByNextInstIdx == null ) {
			indexByNextInstIdx = new HashMap< CFGenKbGelCallByNextInstIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > >();
		}
		if( ( ! forceRead ) && indexByNextInstIdx.containsKey( key ) ) {
			dict = indexByNextInstIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj>();
			ICFGenKbGelCallObj obj;
			CFGenKbGelCallBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().readDerivedByNextInstIdx( schema.getAuthorization(),
				NextInstTenantId,
				NextInstGelCacheId,
				NextInstGelInstId );
			CFGenKbGelCallBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelCallObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelCallObj realised = (ICFGenKbGelCallObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextInstIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelCallObj arr[] = new ICFGenKbGelCallObj[len];
		Iterator<ICFGenKbGelCallObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelCallObj> arrayList = new ArrayList<ICFGenKbGelCallObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelCallObj> cmp = new Comparator<ICFGenKbGelCallObj>() {
			public int compare( ICFGenKbGelCallObj lhs, ICFGenKbGelCallObj rhs ) {
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
		List<ICFGenKbGelCallObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGelCallObj updateGelCall( ICFGenKbGelCallObj Obj ) {
		ICFGenKbGelCallObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().updateGelCall( schema.getAuthorization(),
			Obj.getGelCallBuff() );
		if( Obj.getClassCode().equals( "GCAL" ) ) {
			obj = (ICFGenKbGelCallObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteGelCall( ICFGenKbGelCallObj Obj ) {
		ICFGenKbGelCallObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().deleteGelCall( schema.getAuthorization(),
			obj.getGelCallBuff() );
		obj.forget( true );
	}

	public void deleteGelCallByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		CFGenKbGelInstructionPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredGelCacheId( GelCacheId );
		pkey.setRequiredGelInstId( GelInstId );
		ICFGenKbGelCallObj obj = readGelCall( pkey );
		if( obj != null ) {
			ICFGenKbGelCallEditObj editObj = (ICFGenKbGelCallEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbGelCallEditObj)obj.beginEdit();
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

	public void deleteGelCallByTenantIdx( long TenantId )
	{
		CFGenKbGelInstructionByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGelInstructionByTenantIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> dict = indexByTenantIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().deleteGelCallByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFGenKbGelCallObj> iter = dict.values().iterator();
			ICFGenKbGelCallObj obj;
			List<ICFGenKbGelCallObj> toForget = new LinkedList<ICFGenKbGelCallObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().deleteGelCallByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteGelCallByGelCacheIdx( long TenantId,
		long GelCacheId )
	{
		CFGenKbGelInstructionByGelCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		if( indexByGelCacheIdx == null ) {
			indexByGelCacheIdx = new HashMap< CFGenKbGelInstructionByGelCacheIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > >();
		}
		if( indexByGelCacheIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> dict = indexByGelCacheIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().deleteGelCallByGelCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
			Iterator<ICFGenKbGelCallObj> iter = dict.values().iterator();
			ICFGenKbGelCallObj obj;
			List<ICFGenKbGelCallObj> toForget = new LinkedList<ICFGenKbGelCallObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().deleteGelCallByGelCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
		}
	}

	public void deleteGelCallByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		CFGenKbGelInstructionByChainIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );
		if( indexByChainIdx == null ) {
			indexByChainIdx = new HashMap< CFGenKbGelInstructionByChainIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > >();
		}
		if( indexByChainIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> dict = indexByChainIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().deleteGelCallByChainIdx( schema.getAuthorization(),
				ChainInstTenantId,
				ChainInstGelCacheId,
				ChainInstGelInstId );
			Iterator<ICFGenKbGelCallObj> iter = dict.values().iterator();
			ICFGenKbGelCallObj obj;
			List<ICFGenKbGelCallObj> toForget = new LinkedList<ICFGenKbGelCallObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().deleteGelCallByChainIdx( schema.getAuthorization(),
				ChainInstTenantId,
				ChainInstGelCacheId,
				ChainInstGelInstId );
		}
	}

	public void deleteGelCallByCacheIdx( long TenantId,
		long GelCacheId )
	{
		CFGenKbGelCallByCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		if( indexByCacheIdx == null ) {
			indexByCacheIdx = new HashMap< CFGenKbGelCallByCacheIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > >();
		}
		if( indexByCacheIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> dict = indexByCacheIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().deleteGelCallByCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
			Iterator<ICFGenKbGelCallObj> iter = dict.values().iterator();
			ICFGenKbGelCallObj obj;
			List<ICFGenKbGelCallObj> toForget = new LinkedList<ICFGenKbGelCallObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByCacheIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().deleteGelCallByCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
		}
	}

	public void deleteGelCallBySeqIdx( Long SeqInstTenantId,
		Long SeqInstGelCacheId,
		Long SeqInstId )
	{
		CFGenKbGelCallBySeqIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newSeqIdxKey();
		key.setOptionalSeqInstTenantId( SeqInstTenantId );
		key.setOptionalSeqInstGelCacheId( SeqInstGelCacheId );
		key.setOptionalSeqInstId( SeqInstId );
		if( indexBySeqIdx == null ) {
			indexBySeqIdx = new HashMap< CFGenKbGelCallBySeqIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > >();
		}
		if( indexBySeqIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> dict = indexBySeqIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().deleteGelCallBySeqIdx( schema.getAuthorization(),
				SeqInstTenantId,
				SeqInstGelCacheId,
				SeqInstId );
			Iterator<ICFGenKbGelCallObj> iter = dict.values().iterator();
			ICFGenKbGelCallObj obj;
			List<ICFGenKbGelCallObj> toForget = new LinkedList<ICFGenKbGelCallObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexBySeqIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().deleteGelCallBySeqIdx( schema.getAuthorization(),
				SeqInstTenantId,
				SeqInstGelCacheId,
				SeqInstId );
		}
	}

	public void deleteGelCallByCallInstIdx( Long CallInstTenantId,
		Long CallInstGelCacheId,
		Long CallInstId )
	{
		CFGenKbGelCallByCallInstIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newCallInstIdxKey();
		key.setOptionalCallInstTenantId( CallInstTenantId );
		key.setOptionalCallInstGelCacheId( CallInstGelCacheId );
		key.setOptionalCallInstId( CallInstId );
		if( indexByCallInstIdx == null ) {
			indexByCallInstIdx = new HashMap< CFGenKbGelCallByCallInstIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > >();
		}
		if( indexByCallInstIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> dict = indexByCallInstIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().deleteGelCallByCallInstIdx( schema.getAuthorization(),
				CallInstTenantId,
				CallInstGelCacheId,
				CallInstId );
			Iterator<ICFGenKbGelCallObj> iter = dict.values().iterator();
			ICFGenKbGelCallObj obj;
			List<ICFGenKbGelCallObj> toForget = new LinkedList<ICFGenKbGelCallObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByCallInstIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().deleteGelCallByCallInstIdx( schema.getAuthorization(),
				CallInstTenantId,
				CallInstGelCacheId,
				CallInstId );
		}
	}

	public void deleteGelCallByPrevInstIdx( Long PrevInstTenantId,
		Long PrevInstGelCacheId,
		Long PrevInstGelInstId )
	{
		CFGenKbGelCallByPrevInstIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newPrevInstIdxKey();
		key.setOptionalPrevInstTenantId( PrevInstTenantId );
		key.setOptionalPrevInstGelCacheId( PrevInstGelCacheId );
		key.setOptionalPrevInstGelInstId( PrevInstGelInstId );
		if( indexByPrevInstIdx == null ) {
			indexByPrevInstIdx = new HashMap< CFGenKbGelCallByPrevInstIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > >();
		}
		if( indexByPrevInstIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> dict = indexByPrevInstIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().deleteGelCallByPrevInstIdx( schema.getAuthorization(),
				PrevInstTenantId,
				PrevInstGelCacheId,
				PrevInstGelInstId );
			Iterator<ICFGenKbGelCallObj> iter = dict.values().iterator();
			ICFGenKbGelCallObj obj;
			List<ICFGenKbGelCallObj> toForget = new LinkedList<ICFGenKbGelCallObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByPrevInstIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().deleteGelCallByPrevInstIdx( schema.getAuthorization(),
				PrevInstTenantId,
				PrevInstGelCacheId,
				PrevInstGelInstId );
		}
	}

	public void deleteGelCallByNextInstIdx( Long NextInstTenantId,
		Long NextInstGelCacheId,
		Long NextInstGelInstId )
	{
		CFGenKbGelCallByNextInstIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelCall().newNextInstIdxKey();
		key.setOptionalNextInstTenantId( NextInstTenantId );
		key.setOptionalNextInstGelCacheId( NextInstGelCacheId );
		key.setOptionalNextInstGelInstId( NextInstGelInstId );
		if( indexByNextInstIdx == null ) {
			indexByNextInstIdx = new HashMap< CFGenKbGelCallByNextInstIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCallObj > >();
		}
		if( indexByNextInstIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCallObj> dict = indexByNextInstIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().deleteGelCallByNextInstIdx( schema.getAuthorization(),
				NextInstTenantId,
				NextInstGelCacheId,
				NextInstGelInstId );
			Iterator<ICFGenKbGelCallObj> iter = dict.values().iterator();
			ICFGenKbGelCallObj obj;
			List<ICFGenKbGelCallObj> toForget = new LinkedList<ICFGenKbGelCallObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByNextInstIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCall().deleteGelCallByNextInstIdx( schema.getAuthorization(),
				NextInstTenantId,
				NextInstGelCacheId,
				NextInstGelInstId );
		}
	}
}
