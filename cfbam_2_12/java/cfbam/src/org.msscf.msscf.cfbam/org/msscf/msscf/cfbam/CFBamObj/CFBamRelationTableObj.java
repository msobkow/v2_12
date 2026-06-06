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

public class CFBamRelationTableObj
	implements ICFBamRelationTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamRelationObj> members;
	private Map<CFBamScopePKey, ICFBamRelationObj> allRelation;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamRelationObj > > indexByTenantIdx;
	private Map< CFBamRelationByUNameIdxKey,
		ICFBamRelationObj > indexByUNameIdx;
	private Map< CFBamRelationByRelnTenantIdxKey,
		Map<CFBamScopePKey, ICFBamRelationObj > > indexByRelnTenantIdx;
	private Map< CFBamRelationByRelTableIdxKey,
		Map<CFBamScopePKey, ICFBamRelationObj > > indexByRelTableIdx;
	private Map< CFBamRelationByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamRelationObj > > indexByDefSchemaIdx;
	private Map< CFBamRelationByFromKeyIdxKey,
		Map<CFBamScopePKey, ICFBamRelationObj > > indexByFromKeyIdx;
	private Map< CFBamRelationByToTblIdxKey,
		Map<CFBamScopePKey, ICFBamRelationObj > > indexByToTblIdx;
	private Map< CFBamRelationByToKeyIdxKey,
		Map<CFBamScopePKey, ICFBamRelationObj > > indexByToKeyIdx;
	private Map< CFBamRelationByNarrowedIdxKey,
		Map<CFBamScopePKey, ICFBamRelationObj > > indexByNarrowedIdx;
	public static String TABLE_NAME = "Relation";
	public static String TABLE_DBNAME = "reldef";

	public CFBamRelationTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
		allRelation = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByRelnTenantIdx = null;
		indexByRelTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByFromKeyIdx = null;
		indexByToTblIdx = null;
		indexByToKeyIdx = null;
		indexByNarrowedIdx = null;
	}

	public CFBamRelationTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
		allRelation = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByRelnTenantIdx = null;
		indexByRelTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByFromKeyIdx = null;
		indexByToTblIdx = null;
		indexByToKeyIdx = null;
		indexByNarrowedIdx = null;
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
		allRelation = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByRelnTenantIdx = null;
		indexByRelTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByFromKeyIdx = null;
		indexByToTblIdx = null;
		indexByToKeyIdx = null;
		indexByNarrowedIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamRelationObj.
	 */
	public ICFBamRelationObj newInstance() {
		ICFBamRelationObj inst = new CFBamRelationObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamRelationObj.
	 */
	public ICFBamRelationEditObj newEditInstance( ICFBamRelationObj orig ) {
		ICFBamRelationEditObj edit = new CFBamRelationEditObj( orig );
		return( edit );
	}

	public ICFBamRelationObj realiseRelation( ICFBamRelationObj Obj ) {
		ICFBamRelationObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamRelationObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamRelationObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamRelationObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamRelationByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByRelnTenantIdx != null ) {
				CFBamRelationByRelnTenantIdxKey keyRelnTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newRelnTenantIdxKey();
				keyRelnTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapRelnTenantIdx = indexByRelnTenantIdx.get( keyRelnTenantIdx );
				if( mapRelnTenantIdx != null ) {
					mapRelnTenantIdx.remove( keepObj.getPKey() );
					if( mapRelnTenantIdx.size() <= 0 ) {
						indexByRelnTenantIdx.remove( keyRelnTenantIdx );
					}
				}
			}

			if( indexByRelTableIdx != null ) {
				CFBamRelationByRelTableIdxKey keyRelTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newRelTableIdxKey();
				keyRelTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyRelTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapRelTableIdx = indexByRelTableIdx.get( keyRelTableIdx );
				if( mapRelTableIdx != null ) {
					mapRelTableIdx.remove( keepObj.getPKey() );
					if( mapRelTableIdx.size() <= 0 ) {
						indexByRelTableIdx.remove( keyRelTableIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamRelationByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByFromKeyIdx != null ) {
				CFBamRelationByFromKeyIdxKey keyFromKeyIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newFromKeyIdxKey();
				keyFromKeyIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyFromKeyIdx.setRequiredFromIndexId( keepObj.getRequiredFromIndexId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapFromKeyIdx = indexByFromKeyIdx.get( keyFromKeyIdx );
				if( mapFromKeyIdx != null ) {
					mapFromKeyIdx.remove( keepObj.getPKey() );
					if( mapFromKeyIdx.size() <= 0 ) {
						indexByFromKeyIdx.remove( keyFromKeyIdx );
					}
				}
			}

			if( indexByToTblIdx != null ) {
				CFBamRelationByToTblIdxKey keyToTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newToTblIdxKey();
				keyToTblIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToTblIdx.setRequiredToTableId( keepObj.getRequiredToTableId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapToTblIdx = indexByToTblIdx.get( keyToTblIdx );
				if( mapToTblIdx != null ) {
					mapToTblIdx.remove( keepObj.getPKey() );
					if( mapToTblIdx.size() <= 0 ) {
						indexByToTblIdx.remove( keyToTblIdx );
					}
				}
			}

			if( indexByToKeyIdx != null ) {
				CFBamRelationByToKeyIdxKey keyToKeyIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newToKeyIdxKey();
				keyToKeyIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToKeyIdx.setRequiredToIndexId( keepObj.getRequiredToIndexId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapToKeyIdx = indexByToKeyIdx.get( keyToKeyIdx );
				if( mapToKeyIdx != null ) {
					mapToKeyIdx.remove( keepObj.getPKey() );
					if( mapToKeyIdx.size() <= 0 ) {
						indexByToKeyIdx.remove( keyToKeyIdx );
					}
				}
			}

			if( indexByNarrowedIdx != null ) {
				CFBamRelationByNarrowedIdxKey keyNarrowedIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newNarrowedIdxKey();
				keyNarrowedIdx.setOptionalNarrowedTenantId( keepObj.getOptionalNarrowedTenantId() );
				keyNarrowedIdx.setOptionalNarrowedId( keepObj.getOptionalNarrowedId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapNarrowedIdx = indexByNarrowedIdx.get( keyNarrowedIdx );
				if( mapNarrowedIdx != null ) {
					mapNarrowedIdx.remove( keepObj.getPKey() );
					if( mapNarrowedIdx.size() <= 0 ) {
						indexByNarrowedIdx.remove( keyNarrowedIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamRelationObj)schema.getScopeTableObj().realiseScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamRelationByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByRelnTenantIdx != null ) {
				CFBamRelationByRelnTenantIdxKey keyRelnTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newRelnTenantIdxKey();
				keyRelnTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapRelnTenantIdx = indexByRelnTenantIdx.get( keyRelnTenantIdx );
				if( mapRelnTenantIdx != null ) {
					mapRelnTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelTableIdx != null ) {
				CFBamRelationByRelTableIdxKey keyRelTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newRelTableIdxKey();
				keyRelTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyRelTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapRelTableIdx = indexByRelTableIdx.get( keyRelTableIdx );
				if( mapRelTableIdx != null ) {
					mapRelTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamRelationByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByFromKeyIdx != null ) {
				CFBamRelationByFromKeyIdxKey keyFromKeyIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newFromKeyIdxKey();
				keyFromKeyIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyFromKeyIdx.setRequiredFromIndexId( keepObj.getRequiredFromIndexId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapFromKeyIdx = indexByFromKeyIdx.get( keyFromKeyIdx );
				if( mapFromKeyIdx != null ) {
					mapFromKeyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToTblIdx != null ) {
				CFBamRelationByToTblIdxKey keyToTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newToTblIdxKey();
				keyToTblIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToTblIdx.setRequiredToTableId( keepObj.getRequiredToTableId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapToTblIdx = indexByToTblIdx.get( keyToTblIdx );
				if( mapToTblIdx != null ) {
					mapToTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToKeyIdx != null ) {
				CFBamRelationByToKeyIdxKey keyToKeyIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newToKeyIdxKey();
				keyToKeyIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToKeyIdx.setRequiredToIndexId( keepObj.getRequiredToIndexId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapToKeyIdx = indexByToKeyIdx.get( keyToKeyIdx );
				if( mapToKeyIdx != null ) {
					mapToKeyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNarrowedIdx != null ) {
				CFBamRelationByNarrowedIdxKey keyNarrowedIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newNarrowedIdxKey();
				keyNarrowedIdx.setOptionalNarrowedTenantId( keepObj.getOptionalNarrowedTenantId() );
				keyNarrowedIdx.setOptionalNarrowedId( keepObj.getOptionalNarrowedId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapNarrowedIdx = indexByNarrowedIdx.get( keyNarrowedIdx );
				if( mapNarrowedIdx != null ) {
					mapNarrowedIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allRelation != null ) {
				allRelation.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamRelationObj)schema.getScopeTableObj().realiseScope( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allRelation != null ) {
				allRelation.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamRelationByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByRelnTenantIdx != null ) {
				CFBamRelationByRelnTenantIdxKey keyRelnTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newRelnTenantIdxKey();
				keyRelnTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapRelnTenantIdx = indexByRelnTenantIdx.get( keyRelnTenantIdx );
				if( mapRelnTenantIdx != null ) {
					mapRelnTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelTableIdx != null ) {
				CFBamRelationByRelTableIdxKey keyRelTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newRelTableIdxKey();
				keyRelTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyRelTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapRelTableIdx = indexByRelTableIdx.get( keyRelTableIdx );
				if( mapRelTableIdx != null ) {
					mapRelTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamRelationByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByFromKeyIdx != null ) {
				CFBamRelationByFromKeyIdxKey keyFromKeyIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newFromKeyIdxKey();
				keyFromKeyIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyFromKeyIdx.setRequiredFromIndexId( keepObj.getRequiredFromIndexId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapFromKeyIdx = indexByFromKeyIdx.get( keyFromKeyIdx );
				if( mapFromKeyIdx != null ) {
					mapFromKeyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToTblIdx != null ) {
				CFBamRelationByToTblIdxKey keyToTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newToTblIdxKey();
				keyToTblIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToTblIdx.setRequiredToTableId( keepObj.getRequiredToTableId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapToTblIdx = indexByToTblIdx.get( keyToTblIdx );
				if( mapToTblIdx != null ) {
					mapToTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToKeyIdx != null ) {
				CFBamRelationByToKeyIdxKey keyToKeyIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newToKeyIdxKey();
				keyToKeyIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToKeyIdx.setRequiredToIndexId( keepObj.getRequiredToIndexId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapToKeyIdx = indexByToKeyIdx.get( keyToKeyIdx );
				if( mapToKeyIdx != null ) {
					mapToKeyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNarrowedIdx != null ) {
				CFBamRelationByNarrowedIdxKey keyNarrowedIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newNarrowedIdxKey();
				keyNarrowedIdx.setOptionalNarrowedTenantId( keepObj.getOptionalNarrowedTenantId() );
				keyNarrowedIdx.setOptionalNarrowedId( keepObj.getOptionalNarrowedId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapNarrowedIdx = indexByNarrowedIdx.get( keyNarrowedIdx );
				if( mapNarrowedIdx != null ) {
					mapNarrowedIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetRelation( ICFBamRelationObj Obj ) {
		forgetRelation( Obj, false );
	}

	public void forgetRelation( ICFBamRelationObj Obj, boolean forgetSubObjects ) {
		ICFBamRelationObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamRelationObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamRelationByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByRelnTenantIdx != null ) {
				CFBamRelationByRelnTenantIdxKey keyRelnTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newRelnTenantIdxKey();
				keyRelnTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapRelnTenantIdx = indexByRelnTenantIdx.get( keyRelnTenantIdx );
				if( mapRelnTenantIdx != null ) {
					mapRelnTenantIdx.remove( keepObj.getPKey() );
					if( mapRelnTenantIdx.size() <= 0 ) {
						indexByRelnTenantIdx.remove( keyRelnTenantIdx );
					}
				}
			}

			if( indexByRelTableIdx != null ) {
				CFBamRelationByRelTableIdxKey keyRelTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newRelTableIdxKey();
				keyRelTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyRelTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapRelTableIdx = indexByRelTableIdx.get( keyRelTableIdx );
				if( mapRelTableIdx != null ) {
					mapRelTableIdx.remove( keepObj.getPKey() );
					if( mapRelTableIdx.size() <= 0 ) {
						indexByRelTableIdx.remove( keyRelTableIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamRelationByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByFromKeyIdx != null ) {
				CFBamRelationByFromKeyIdxKey keyFromKeyIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newFromKeyIdxKey();
				keyFromKeyIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyFromKeyIdx.setRequiredFromIndexId( keepObj.getRequiredFromIndexId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapFromKeyIdx = indexByFromKeyIdx.get( keyFromKeyIdx );
				if( mapFromKeyIdx != null ) {
					mapFromKeyIdx.remove( keepObj.getPKey() );
					if( mapFromKeyIdx.size() <= 0 ) {
						indexByFromKeyIdx.remove( keyFromKeyIdx );
					}
				}
			}

			if( indexByToTblIdx != null ) {
				CFBamRelationByToTblIdxKey keyToTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newToTblIdxKey();
				keyToTblIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToTblIdx.setRequiredToTableId( keepObj.getRequiredToTableId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapToTblIdx = indexByToTblIdx.get( keyToTblIdx );
				if( mapToTblIdx != null ) {
					mapToTblIdx.remove( keepObj.getPKey() );
					if( mapToTblIdx.size() <= 0 ) {
						indexByToTblIdx.remove( keyToTblIdx );
					}
				}
			}

			if( indexByToKeyIdx != null ) {
				CFBamRelationByToKeyIdxKey keyToKeyIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newToKeyIdxKey();
				keyToKeyIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToKeyIdx.setRequiredToIndexId( keepObj.getRequiredToIndexId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapToKeyIdx = indexByToKeyIdx.get( keyToKeyIdx );
				if( mapToKeyIdx != null ) {
					mapToKeyIdx.remove( keepObj.getPKey() );
					if( mapToKeyIdx.size() <= 0 ) {
						indexByToKeyIdx.remove( keyToKeyIdx );
					}
				}
			}

			if( indexByNarrowedIdx != null ) {
				CFBamRelationByNarrowedIdxKey keyNarrowedIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newNarrowedIdxKey();
				keyNarrowedIdx.setOptionalNarrowedTenantId( keepObj.getOptionalNarrowedTenantId() );
				keyNarrowedIdx.setOptionalNarrowedId( keepObj.getOptionalNarrowedId() );
				Map<CFBamScopePKey, ICFBamRelationObj > mapNarrowedIdx = indexByNarrowedIdx.get( keyNarrowedIdx );
				if( mapNarrowedIdx != null ) {
					mapNarrowedIdx.remove( keepObj.getPKey() );
					if( mapNarrowedIdx.size() <= 0 ) {
						indexByNarrowedIdx.remove( keyNarrowedIdx );
					}
				}
			}

			if( allRelation != null ) {
				allRelation.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFBamSchemaObj)schema).getRelationColTableObj().forgetRelationColByRelationIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				((ICFBamSchemaObj)schema).getPopTopDepTableObj().forgetPopTopDepByContRelIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		((ICFBamSchemaObj)schema).getScopeTableObj().forgetScope( obj );
	}

	public void forgetRelationByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamRelationObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetRelationByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
		ICFBamRelationObj cur = null;
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamRelationObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamRelationObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamRelationObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetRelationByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
		ICFBamRelationObj cur = null;
		CFBamRelationByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamRelationObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetRelationByRelnTenantIdx( long TenantId )
	{
		if( indexByRelnTenantIdx == null ) {
			return;
		}
		List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
		ICFBamRelationObj cur = null;
		CFBamRelationByRelnTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newRelnTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByRelnTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj > mapRelnTenantIdx = indexByRelnTenantIdx.get( key );
			if( mapRelnTenantIdx != null ) {
				Iterator<ICFBamRelationObj> iterDup = mapRelnTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRelnTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamRelationObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamRelationObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetRelationByRelTableIdx( long TenantId,
		long TableId )
	{
		if( indexByRelTableIdx == null ) {
			return;
		}
		List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
		ICFBamRelationObj cur = null;
		CFBamRelationByRelTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newRelTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByRelTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj > mapRelTableIdx = indexByRelTableIdx.get( key );
			if( mapRelTableIdx != null ) {
				Iterator<ICFBamRelationObj> iterDup = mapRelTableIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRelTableIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamRelationObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamRelationObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetRelationByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
		ICFBamRelationObj cur = null;
		CFBamRelationByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamRelationObj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamRelationObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamRelationObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetRelationByFromKeyIdx( long TenantId,
		long FromIndexId )
	{
		if( indexByFromKeyIdx == null ) {
			return;
		}
		List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
		ICFBamRelationObj cur = null;
		CFBamRelationByFromKeyIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newFromKeyIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredFromIndexId( FromIndexId );
		if( indexByFromKeyIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj > mapFromKeyIdx = indexByFromKeyIdx.get( key );
			if( mapFromKeyIdx != null ) {
				Iterator<ICFBamRelationObj> iterDup = mapFromKeyIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByFromKeyIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamRelationObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamRelationObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetRelationByToTblIdx( long TenantId,
		long ToTableId )
	{
		if( indexByToTblIdx == null ) {
			return;
		}
		List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
		ICFBamRelationObj cur = null;
		CFBamRelationByToTblIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newToTblIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToTableId( ToTableId );
		if( indexByToTblIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj > mapToTblIdx = indexByToTblIdx.get( key );
			if( mapToTblIdx != null ) {
				Iterator<ICFBamRelationObj> iterDup = mapToTblIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByToTblIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamRelationObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamRelationObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetRelationByToKeyIdx( long TenantId,
		long ToIndexId )
	{
		if( indexByToKeyIdx == null ) {
			return;
		}
		List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
		ICFBamRelationObj cur = null;
		CFBamRelationByToKeyIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newToKeyIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToIndexId( ToIndexId );
		if( indexByToKeyIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj > mapToKeyIdx = indexByToKeyIdx.get( key );
			if( mapToKeyIdx != null ) {
				Iterator<ICFBamRelationObj> iterDup = mapToKeyIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByToKeyIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamRelationObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamRelationObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetRelationByNarrowedIdx( Long NarrowedTenantId,
		Long NarrowedId )
	{
		if( indexByNarrowedIdx == null ) {
			return;
		}
		List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
		ICFBamRelationObj cur = null;
		CFBamRelationByNarrowedIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newNarrowedIdxKey();
		key.setOptionalNarrowedTenantId( NarrowedTenantId );
		key.setOptionalNarrowedId( NarrowedId );
		if( indexByNarrowedIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj > mapNarrowedIdx = indexByNarrowedIdx.get( key );
			if( mapNarrowedIdx != null ) {
				Iterator<ICFBamRelationObj> iterDup = mapNarrowedIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByNarrowedIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamRelationObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamRelationObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamRelationObj createRelation( ICFBamRelationObj Obj ) {
		ICFBamRelationObj obj = Obj;
		CFBamRelationBuff buff = obj.getRelationBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableRelation().createRelation(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "RELD" ) ) {
			obj = (ICFBamRelationObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamRelationObj readRelation( CFBamScopePKey pkey ) {
		return( readRelation( pkey, false ) );
	}

	public ICFBamRelationObj readRelation( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamRelationObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamRelationBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableRelation().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamRelationObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamRelationObj lockRelation( CFBamScopePKey pkey ) {
		ICFBamRelationObj locked = null;
		CFBamRelationBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableRelation().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamRelationObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockRelation", pkey );
		}
		return( locked );
	}

	public List<ICFBamRelationObj> readAllRelation() {
		return( readAllRelation( false ) );
	}

	public List<ICFBamRelationObj> readAllRelation( boolean forceRead ) {
		final String S_ProcName = "readAllRelation";
		if( ( allRelation == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamRelationObj> map = new HashMap<CFBamScopePKey,ICFBamRelationObj>();
			allRelation = map;
			CFBamRelationBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableRelation().readAllDerived( schema.getAuthorization() );
			CFBamRelationBuff buff;
			ICFBamRelationObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realised = (ICFBamRelationObj)obj.realise();
			}
		}
		int len = allRelation.size();
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = allRelation.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamRelationObj readRelationByIdIdx( long TenantId,
		long Id )
	{
		return( readRelationByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamRelationObj readRelationByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamRelationObj obj = readRelation( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamRelationObj> readRelationByTenantIdx( long TenantId )
	{
		return( readRelationByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamRelationObj> readRelationByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByTenantIdx";
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamRelationObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realised = (ICFBamRelationObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamRelationObj readRelationByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		return( readRelationByUNameIdx( TenantId,
			TableId,
			Name,
			false ) );
	}

	public ICFBamRelationObj readRelationByUNameIdx( long TenantId,
		long TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamRelationByUNameIdxKey,
				ICFBamRelationObj >();
		}
		CFBamRelationByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamRelationObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamRelationBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableRelation().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
			if( buff != null ) {
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamRelationObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFBamRelationObj> readRelationByRelnTenantIdx( long TenantId )
	{
		return( readRelationByRelnTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamRelationObj> readRelationByRelnTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByRelnTenantIdx";
		CFBamRelationByRelnTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newRelnTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamRelationObj> dict;
		if( indexByRelnTenantIdx == null ) {
			indexByRelnTenantIdx = new HashMap< CFBamRelationByRelnTenantIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( ( ! forceRead ) && indexByRelnTenantIdx.containsKey( key ) ) {
			dict = indexByRelnTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
			ICFBamRelationObj obj;
			CFBamRelationBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableRelation().readDerivedByRelnTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamRelationBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realised = (ICFBamRelationObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRelnTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationObj> readRelationByRelTableIdx( long TenantId,
		long TableId )
	{
		return( readRelationByRelTableIdx( TenantId,
			TableId,
			false ) );
	}

	public List<ICFBamRelationObj> readRelationByRelTableIdx( long TenantId,
		long TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByRelTableIdx";
		CFBamRelationByRelTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newRelTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		Map<CFBamScopePKey, ICFBamRelationObj> dict;
		if( indexByRelTableIdx == null ) {
			indexByRelTableIdx = new HashMap< CFBamRelationByRelTableIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( ( ! forceRead ) && indexByRelTableIdx.containsKey( key ) ) {
			dict = indexByRelTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
			ICFBamRelationObj obj;
			CFBamRelationBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableRelation().readDerivedByRelTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			CFBamRelationBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realised = (ICFBamRelationObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRelTableIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationObj> readRelationByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readRelationByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamRelationObj> readRelationByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByDefSchemaIdx";
		CFBamRelationByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamRelationObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamRelationByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
			ICFBamRelationObj obj;
			CFBamRelationBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableRelation().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamRelationBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realised = (ICFBamRelationObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationObj> readRelationByFromKeyIdx( long TenantId,
		long FromIndexId )
	{
		return( readRelationByFromKeyIdx( TenantId,
			FromIndexId,
			false ) );
	}

	public List<ICFBamRelationObj> readRelationByFromKeyIdx( long TenantId,
		long FromIndexId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByFromKeyIdx";
		CFBamRelationByFromKeyIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newFromKeyIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredFromIndexId( FromIndexId );
		Map<CFBamScopePKey, ICFBamRelationObj> dict;
		if( indexByFromKeyIdx == null ) {
			indexByFromKeyIdx = new HashMap< CFBamRelationByFromKeyIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( ( ! forceRead ) && indexByFromKeyIdx.containsKey( key ) ) {
			dict = indexByFromKeyIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
			ICFBamRelationObj obj;
			CFBamRelationBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableRelation().readDerivedByFromKeyIdx( schema.getAuthorization(),
				TenantId,
				FromIndexId );
			CFBamRelationBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realised = (ICFBamRelationObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByFromKeyIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationObj> readRelationByToTblIdx( long TenantId,
		long ToTableId )
	{
		return( readRelationByToTblIdx( TenantId,
			ToTableId,
			false ) );
	}

	public List<ICFBamRelationObj> readRelationByToTblIdx( long TenantId,
		long ToTableId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByToTblIdx";
		CFBamRelationByToTblIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newToTblIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToTableId( ToTableId );
		Map<CFBamScopePKey, ICFBamRelationObj> dict;
		if( indexByToTblIdx == null ) {
			indexByToTblIdx = new HashMap< CFBamRelationByToTblIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( ( ! forceRead ) && indexByToTblIdx.containsKey( key ) ) {
			dict = indexByToTblIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
			ICFBamRelationObj obj;
			CFBamRelationBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableRelation().readDerivedByToTblIdx( schema.getAuthorization(),
				TenantId,
				ToTableId );
			CFBamRelationBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realised = (ICFBamRelationObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByToTblIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationObj> readRelationByToKeyIdx( long TenantId,
		long ToIndexId )
	{
		return( readRelationByToKeyIdx( TenantId,
			ToIndexId,
			false ) );
	}

	public List<ICFBamRelationObj> readRelationByToKeyIdx( long TenantId,
		long ToIndexId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByToKeyIdx";
		CFBamRelationByToKeyIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newToKeyIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToIndexId( ToIndexId );
		Map<CFBamScopePKey, ICFBamRelationObj> dict;
		if( indexByToKeyIdx == null ) {
			indexByToKeyIdx = new HashMap< CFBamRelationByToKeyIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( ( ! forceRead ) && indexByToKeyIdx.containsKey( key ) ) {
			dict = indexByToKeyIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
			ICFBamRelationObj obj;
			CFBamRelationBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableRelation().readDerivedByToKeyIdx( schema.getAuthorization(),
				TenantId,
				ToIndexId );
			CFBamRelationBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realised = (ICFBamRelationObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByToKeyIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationObj> readRelationByNarrowedIdx( Long NarrowedTenantId,
		Long NarrowedId )
	{
		return( readRelationByNarrowedIdx( NarrowedTenantId,
			NarrowedId,
			false ) );
	}

	public List<ICFBamRelationObj> readRelationByNarrowedIdx( Long NarrowedTenantId,
		Long NarrowedId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByNarrowedIdx";
		CFBamRelationByNarrowedIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newNarrowedIdxKey();
		key.setOptionalNarrowedTenantId( NarrowedTenantId );
		key.setOptionalNarrowedId( NarrowedId );
		Map<CFBamScopePKey, ICFBamRelationObj> dict;
		if( indexByNarrowedIdx == null ) {
			indexByNarrowedIdx = new HashMap< CFBamRelationByNarrowedIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( ( ! forceRead ) && indexByNarrowedIdx.containsKey( key ) ) {
			dict = indexByNarrowedIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamRelationObj>();
			ICFBamRelationObj obj;
			CFBamRelationBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableRelation().readDerivedByNarrowedIdx( schema.getAuthorization(),
				NarrowedTenantId,
				NarrowedId );
			CFBamRelationBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamRelationObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationObj realised = (ICFBamRelationObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNarrowedIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamRelationObj arr[] = new ICFBamRelationObj[len];
		Iterator<ICFBamRelationObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationObj> arrayList = new ArrayList<ICFBamRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationObj> cmp = new Comparator<ICFBamRelationObj>() {
			public int compare( ICFBamRelationObj lhs, ICFBamRelationObj rhs ) {
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
		List<ICFBamRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamRelationObj updateRelation( ICFBamRelationObj Obj ) {
		ICFBamRelationObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableRelation().updateRelation( schema.getAuthorization(),
			Obj.getRelationBuff() );
		if( Obj.getClassCode().equals( "RELD" ) ) {
			obj = (ICFBamRelationObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteRelation( ICFBamRelationObj Obj ) {
		ICFBamRelationObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelation( schema.getAuthorization(),
			obj.getRelationBuff() );
		obj.forget( true );
	}

	public void deleteRelationByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamRelationObj obj = readRelation( pkey );
		if( obj != null ) {
			ICFBamRelationEditObj editObj = (ICFBamRelationEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamRelationEditObj)obj.beginEdit();
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

	public void deleteRelationByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelationByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamRelationObj> iter = dict.values().iterator();
			ICFBamRelationObj obj;
			List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelationByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteRelationByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamRelationByUNameIdxKey,
				ICFBamRelationObj >();
		}
		CFBamRelationByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamRelationObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelationByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelationByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
		}
	}

	public void deleteRelationByRelnTenantIdx( long TenantId )
	{
		CFBamRelationByRelnTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newRelnTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByRelnTenantIdx == null ) {
			indexByRelnTenantIdx = new HashMap< CFBamRelationByRelnTenantIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( indexByRelnTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj> dict = indexByRelnTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelationByRelnTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamRelationObj> iter = dict.values().iterator();
			ICFBamRelationObj obj;
			List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByRelnTenantIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelationByRelnTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteRelationByRelTableIdx( long TenantId,
		long TableId )
	{
		CFBamRelationByRelTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newRelTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByRelTableIdx == null ) {
			indexByRelTableIdx = new HashMap< CFBamRelationByRelTableIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( indexByRelTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj> dict = indexByRelTableIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelationByRelTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			Iterator<ICFBamRelationObj> iter = dict.values().iterator();
			ICFBamRelationObj obj;
			List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByRelTableIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelationByRelTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
		}
	}

	public void deleteRelationByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamRelationByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamRelationByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelationByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamRelationObj> iter = dict.values().iterator();
			ICFBamRelationObj obj;
			List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelationByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteRelationByFromKeyIdx( long TenantId,
		long FromIndexId )
	{
		CFBamRelationByFromKeyIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newFromKeyIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredFromIndexId( FromIndexId );
		if( indexByFromKeyIdx == null ) {
			indexByFromKeyIdx = new HashMap< CFBamRelationByFromKeyIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( indexByFromKeyIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj> dict = indexByFromKeyIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelationByFromKeyIdx( schema.getAuthorization(),
				TenantId,
				FromIndexId );
			Iterator<ICFBamRelationObj> iter = dict.values().iterator();
			ICFBamRelationObj obj;
			List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByFromKeyIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelationByFromKeyIdx( schema.getAuthorization(),
				TenantId,
				FromIndexId );
		}
	}

	public void deleteRelationByToTblIdx( long TenantId,
		long ToTableId )
	{
		CFBamRelationByToTblIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newToTblIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToTableId( ToTableId );
		if( indexByToTblIdx == null ) {
			indexByToTblIdx = new HashMap< CFBamRelationByToTblIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( indexByToTblIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj> dict = indexByToTblIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelationByToTblIdx( schema.getAuthorization(),
				TenantId,
				ToTableId );
			Iterator<ICFBamRelationObj> iter = dict.values().iterator();
			ICFBamRelationObj obj;
			List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByToTblIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelationByToTblIdx( schema.getAuthorization(),
				TenantId,
				ToTableId );
		}
	}

	public void deleteRelationByToKeyIdx( long TenantId,
		long ToIndexId )
	{
		CFBamRelationByToKeyIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newToKeyIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToIndexId( ToIndexId );
		if( indexByToKeyIdx == null ) {
			indexByToKeyIdx = new HashMap< CFBamRelationByToKeyIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( indexByToKeyIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj> dict = indexByToKeyIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelationByToKeyIdx( schema.getAuthorization(),
				TenantId,
				ToIndexId );
			Iterator<ICFBamRelationObj> iter = dict.values().iterator();
			ICFBamRelationObj obj;
			List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByToKeyIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelationByToKeyIdx( schema.getAuthorization(),
				TenantId,
				ToIndexId );
		}
	}

	public void deleteRelationByNarrowedIdx( Long NarrowedTenantId,
		Long NarrowedId )
	{
		CFBamRelationByNarrowedIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newNarrowedIdxKey();
		key.setOptionalNarrowedTenantId( NarrowedTenantId );
		key.setOptionalNarrowedId( NarrowedId );
		if( indexByNarrowedIdx == null ) {
			indexByNarrowedIdx = new HashMap< CFBamRelationByNarrowedIdxKey,
				Map< CFBamScopePKey, ICFBamRelationObj > >();
		}
		if( indexByNarrowedIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamRelationObj> dict = indexByNarrowedIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelationByNarrowedIdx( schema.getAuthorization(),
				NarrowedTenantId,
				NarrowedId );
			Iterator<ICFBamRelationObj> iter = dict.values().iterator();
			ICFBamRelationObj obj;
			List<ICFBamRelationObj> toForget = new LinkedList<ICFBamRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByNarrowedIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableRelation().deleteRelationByNarrowedIdx( schema.getAuthorization(),
				NarrowedTenantId,
				NarrowedId );
		}
	}
}
