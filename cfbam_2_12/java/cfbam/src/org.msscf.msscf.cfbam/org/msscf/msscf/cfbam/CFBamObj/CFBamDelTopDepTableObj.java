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

public class CFBamDelTopDepTableObj
	implements ICFBamDelTopDepTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamDelTopDepObj> members;
	private Map<CFBamScopePKey, ICFBamDelTopDepObj> allDelTopDep;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamDelTopDepObj > > indexByTenantIdx;
	private Map< CFBamDelDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamDelTopDepObj > > indexByDefSchemaIdx;
	private Map< CFBamDelDepByDelDepIdxKey,
		Map<CFBamScopePKey, ICFBamDelTopDepObj > > indexByDelDepIdx;
	private Map< CFBamDelTopDepByDelTopDepTblIdxKey,
		Map<CFBamScopePKey, ICFBamDelTopDepObj > > indexByDelTopDepTblIdx;
	private Map< CFBamDelTopDepByUNameIdxKey,
		ICFBamDelTopDepObj > indexByUNameIdx;
	private Map< CFBamDelTopDepByPrevIdxKey,
		Map<CFBamScopePKey, ICFBamDelTopDepObj > > indexByPrevIdx;
	private Map< CFBamDelTopDepByNextIdxKey,
		Map<CFBamScopePKey, ICFBamDelTopDepObj > > indexByNextIdx;
	public static String TABLE_NAME = "DelTopDep";
	public static String TABLE_DBNAME = "del_topdep";

	public CFBamDelTopDepTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamDelTopDepObj>();
		allDelTopDep = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
		indexByDelTopDepTblIdx = null;
		indexByUNameIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
	}

	public CFBamDelTopDepTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamDelTopDepObj>();
		allDelTopDep = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
		indexByDelTopDepTblIdx = null;
		indexByUNameIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
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
		allDelTopDep = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
		indexByDelTopDepTblIdx = null;
		indexByUNameIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDelTopDepObj.
	 */
	public ICFBamDelTopDepObj newInstance() {
		ICFBamDelTopDepObj inst = new CFBamDelTopDepObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDelTopDepObj.
	 */
	public ICFBamDelTopDepEditObj newEditInstance( ICFBamDelTopDepObj orig ) {
		ICFBamDelTopDepEditObj edit = new CFBamDelTopDepEditObj( orig );
		return( edit );
	}

	public ICFBamDelTopDepObj realiseDelTopDep( ICFBamDelTopDepObj Obj ) {
		ICFBamDelTopDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamDelTopDepObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamDelTopDepObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByDelDepIdx != null ) {
				CFBamDelDepByDelDepIdxKey keyDelDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					indexByDelDepIdx.remove( keyDelDepIdx );
				}
			}

			if( indexByDelTopDepTblIdx != null ) {
				CFBamDelTopDepByDelTopDepTblIdxKey keyDelTopDepTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newDelTopDepTblIdxKey();
				keyDelTopDepTblIdx.setRequiredTableTenantId( keepObj.getRequiredTableTenantId() );
				keyDelTopDepTblIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDelTopDepTblIdx = indexByDelTopDepTblIdx.get( keyDelTopDepTblIdx );
				if( mapDelTopDepTblIdx != null ) {
					mapDelTopDepTblIdx.remove( keepObj.getPKey() );
					if( mapDelTopDepTblIdx.size() <= 0 ) {
						indexByDelTopDepTblIdx.remove( keyDelTopDepTblIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelTopDepByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredTableTenantId( keepObj.getRequiredTableTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByPrevIdx != null ) {
				CFBamDelTopDepByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				CFBamDelTopDepByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
					if( mapNextIdx.size() <= 0 ) {
						indexByNextIdx.remove( keyNextIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamDelTopDepObj)schema.getDelDepTableObj().realiseDelDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelDepIdx != null ) {
				CFBamDelDepByDelDepIdxKey keyDelDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					mapDelDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelTopDepTblIdx != null ) {
				CFBamDelTopDepByDelTopDepTblIdxKey keyDelTopDepTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newDelTopDepTblIdxKey();
				keyDelTopDepTblIdx.setRequiredTableTenantId( keepObj.getRequiredTableTenantId() );
				keyDelTopDepTblIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDelTopDepTblIdx = indexByDelTopDepTblIdx.get( keyDelTopDepTblIdx );
				if( mapDelTopDepTblIdx != null ) {
					mapDelTopDepTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelTopDepByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredTableTenantId( keepObj.getRequiredTableTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByPrevIdx != null ) {
				CFBamDelTopDepByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamDelTopDepByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allDelTopDep != null ) {
				allDelTopDep.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamDelTopDepObj)schema.getDelDepTableObj().realiseDelDep( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allDelTopDep != null ) {
				allDelTopDep.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelDepIdx != null ) {
				CFBamDelDepByDelDepIdxKey keyDelDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					mapDelDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelTopDepTblIdx != null ) {
				CFBamDelTopDepByDelTopDepTblIdxKey keyDelTopDepTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newDelTopDepTblIdxKey();
				keyDelTopDepTblIdx.setRequiredTableTenantId( keepObj.getRequiredTableTenantId() );
				keyDelTopDepTblIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDelTopDepTblIdx = indexByDelTopDepTblIdx.get( keyDelTopDepTblIdx );
				if( mapDelTopDepTblIdx != null ) {
					mapDelTopDepTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelTopDepByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredTableTenantId( keepObj.getRequiredTableTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByPrevIdx != null ) {
				CFBamDelTopDepByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamDelTopDepByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetDelTopDep( ICFBamDelTopDepObj Obj ) {
		forgetDelTopDep( Obj, false );
	}

	public void forgetDelTopDep( ICFBamDelTopDepObj Obj, boolean forgetSubObjects ) {
		ICFBamDelTopDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamDelTopDepObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByDelDepIdx != null ) {
				CFBamDelDepByDelDepIdxKey keyDelDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationTenantId( keepObj.getRequiredRelationTenantId() );
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					indexByDelDepIdx.remove( keyDelDepIdx );
				}
			}

			if( indexByDelTopDepTblIdx != null ) {
				CFBamDelTopDepByDelTopDepTblIdxKey keyDelTopDepTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newDelTopDepTblIdxKey();
				keyDelTopDepTblIdx.setRequiredTableTenantId( keepObj.getRequiredTableTenantId() );
				keyDelTopDepTblIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDelTopDepTblIdx = indexByDelTopDepTblIdx.get( keyDelTopDepTblIdx );
				if( mapDelTopDepTblIdx != null ) {
					mapDelTopDepTblIdx.remove( keepObj.getPKey() );
					if( mapDelTopDepTblIdx.size() <= 0 ) {
						indexByDelTopDepTblIdx.remove( keyDelTopDepTblIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamDelTopDepByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredTableTenantId( keepObj.getRequiredTableTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByPrevIdx != null ) {
				CFBamDelTopDepByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				CFBamDelTopDepByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamScopePKey, ICFBamDelTopDepObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
					if( mapNextIdx.size() <= 0 ) {
						indexByNextIdx.remove( keyNextIdx );
					}
				}
			}

			if( allDelTopDep != null ) {
				allDelTopDep.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFBamSchemaObj)schema).getDelSubDep1TableObj().forgetDelSubDep1ByDelTopDepIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		((ICFBamSchemaObj)schema).getDelDepTableObj().forgetDelDep( obj );
	}

	public void forgetDelTopDepByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamDelTopDepObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetDelTopDepByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
		ICFBamDelTopDepObj cur = null;
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamDelTopDepObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamDelTopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamDelTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetDelTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
		ICFBamDelTopDepObj cur = null;
		CFBamDelDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamDelTopDepObj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamDelTopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamDelTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetDelTopDepByDelDepIdx( long RelationTenantId,
		long RelationId )
	{
		if( indexByDelDepIdx == null ) {
			return;
		}
		List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
		ICFBamDelTopDepObj cur = null;
		CFBamDelDepByDelDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByDelDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDelDepIdx = indexByDelDepIdx.get( key );
			if( mapDelDepIdx != null ) {
				Iterator<ICFBamDelTopDepObj> iterDup = mapDelDepIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDelDepIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamDelTopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamDelTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetDelTopDepByDelTopDepTblIdx( long TableTenantId,
		long TableId )
	{
		if( indexByDelTopDepTblIdx == null ) {
			return;
		}
		List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
		ICFBamDelTopDepObj cur = null;
		CFBamDelTopDepByDelTopDepTblIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newDelTopDepTblIdxKey();
		key.setRequiredTableTenantId( TableTenantId );
		key.setRequiredTableId( TableId );
		if( indexByDelTopDepTblIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj > mapDelTopDepTblIdx = indexByDelTopDepTblIdx.get( key );
			if( mapDelTopDepTblIdx != null ) {
				Iterator<ICFBamDelTopDepObj> iterDup = mapDelTopDepTblIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDelTopDepTblIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamDelTopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamDelTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetDelTopDepByUNameIdx( long TableTenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
		ICFBamDelTopDepObj cur = null;
		CFBamDelTopDepByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newUNameIdxKey();
		key.setRequiredTableTenantId( TableTenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamDelTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetDelTopDepByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		if( indexByPrevIdx == null ) {
			return;
		}
		List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
		ICFBamDelTopDepObj cur = null;
		CFBamDelTopDepByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj > mapPrevIdx = indexByPrevIdx.get( key );
			if( mapPrevIdx != null ) {
				Iterator<ICFBamDelTopDepObj> iterDup = mapPrevIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByPrevIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamDelTopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamDelTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetDelTopDepByNextIdx( Long NextTenantId,
		Long NextId )
	{
		if( indexByNextIdx == null ) {
			return;
		}
		List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
		ICFBamDelTopDepObj cur = null;
		CFBamDelTopDepByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj > mapNextIdx = indexByNextIdx.get( key );
			if( mapNextIdx != null ) {
				Iterator<ICFBamDelTopDepObj> iterDup = mapNextIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByNextIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamDelTopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamDelTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamDelTopDepObj createDelTopDep( ICFBamDelTopDepObj Obj ) {
		ICFBamDelTopDepObj obj = Obj;
		CFBamDelTopDepBuff buff = obj.getDelTopDepBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().createDelTopDep(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "DELT" ) ) {
			obj = (ICFBamDelTopDepObj)(obj.realise());
		}
		ICFBamDelTopDepObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamDelTopDepObj readDelTopDep( CFBamScopePKey pkey ) {
		return( readDelTopDep( pkey, false ) );
	}

	public ICFBamDelTopDepObj readDelTopDep( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamDelTopDepObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamDelTopDepBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamDelTopDepObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamDelTopDepObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamDelTopDepObj lockDelTopDep( CFBamScopePKey pkey ) {
		ICFBamDelTopDepObj locked = null;
		CFBamDelTopDepBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamDelTopDepObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamDelTopDepObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockDelTopDep", pkey );
		}
		return( locked );
	}

	public List<ICFBamDelTopDepObj> readAllDelTopDep() {
		return( readAllDelTopDep( false ) );
	}

	public List<ICFBamDelTopDepObj> readAllDelTopDep( boolean forceRead ) {
		final String S_ProcName = "readAllDelTopDep";
		if( ( allDelTopDep == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj> map = new HashMap<CFBamScopePKey,ICFBamDelTopDepObj>();
			allDelTopDep = map;
			CFBamDelTopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().readAllDerived( schema.getAuthorization() );
			CFBamDelTopDepBuff buff;
			ICFBamDelTopDepObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelTopDepObj realised = (ICFBamDelTopDepObj)obj.realise();
			}
		}
		int len = allDelTopDep.size();
		ICFBamDelTopDepObj arr[] = new ICFBamDelTopDepObj[len];
		Iterator<ICFBamDelTopDepObj> valIter = allDelTopDep.values().iterator();
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
		ArrayList<ICFBamDelTopDepObj> arrayList = new ArrayList<ICFBamDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamDelTopDepObj> cmp = new Comparator<ICFBamDelTopDepObj>() {
			public int compare( ICFBamDelTopDepObj lhs, ICFBamDelTopDepObj rhs ) {
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
		List<ICFBamDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDelTopDepObj readDelTopDepByIdIdx( long TenantId,
		long Id )
	{
		return( readDelTopDepByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamDelTopDepObj readDelTopDepByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDelTopDepObj obj = readDelTopDep( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByTenantIdx( long TenantId )
	{
		return( readDelTopDepByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelTopDepByTenantIdx";
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamDelTopDepObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelTopDepObj>();
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelTopDepObj realised = (ICFBamDelTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamDelTopDepObj arr[] = new ICFBamDelTopDepObj[len];
		Iterator<ICFBamDelTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelTopDepObj> arrayList = new ArrayList<ICFBamDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamDelTopDepObj> cmp = new Comparator<ICFBamDelTopDepObj>() {
			public int compare( ICFBamDelTopDepObj lhs, ICFBamDelTopDepObj rhs ) {
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
		List<ICFBamDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readDelTopDepByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelTopDepByDefSchemaIdx";
		CFBamDelDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamDelTopDepObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamDelDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelTopDepObj>();
			ICFBamDelDepObj obj;
			CFBamDelDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableDelDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamDelDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelTopDepObj realised = (ICFBamDelTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamDelTopDepObj arr[] = new ICFBamDelTopDepObj[len];
		Iterator<ICFBamDelTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelTopDepObj> arrayList = new ArrayList<ICFBamDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamDelTopDepObj> cmp = new Comparator<ICFBamDelTopDepObj>() {
			public int compare( ICFBamDelTopDepObj lhs, ICFBamDelTopDepObj rhs ) {
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
		List<ICFBamDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByDelDepIdx( long RelationTenantId,
		long RelationId )
	{
		return( readDelTopDepByDelDepIdx( RelationTenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByDelDepIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelTopDepByDelDepIdx";
		CFBamDelDepByDelDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamDelTopDepObj> dict;
		if( indexByDelDepIdx == null ) {
			indexByDelDepIdx = new HashMap< CFBamDelDepByDelDepIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByDelDepIdx.containsKey( key ) ) {
			dict = indexByDelDepIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelTopDepObj>();
			ICFBamDelDepObj obj;
			CFBamDelDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableDelDep().readDerivedByDelDepIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			CFBamDelDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelTopDepObj realised = (ICFBamDelTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDelDepIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamDelTopDepObj arr[] = new ICFBamDelTopDepObj[len];
		Iterator<ICFBamDelTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelTopDepObj> arrayList = new ArrayList<ICFBamDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamDelTopDepObj> cmp = new Comparator<ICFBamDelTopDepObj>() {
			public int compare( ICFBamDelTopDepObj lhs, ICFBamDelTopDepObj rhs ) {
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
		List<ICFBamDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByDelTopDepTblIdx( long TableTenantId,
		long TableId )
	{
		return( readDelTopDepByDelTopDepTblIdx( TableTenantId,
			TableId,
			false ) );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByDelTopDepTblIdx( long TableTenantId,
		long TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelTopDepByDelTopDepTblIdx";
		CFBamDelTopDepByDelTopDepTblIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newDelTopDepTblIdxKey();
		key.setRequiredTableTenantId( TableTenantId );
		key.setRequiredTableId( TableId );
		Map<CFBamScopePKey, ICFBamDelTopDepObj> dict;
		if( indexByDelTopDepTblIdx == null ) {
			indexByDelTopDepTblIdx = new HashMap< CFBamDelTopDepByDelTopDepTblIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByDelTopDepTblIdx.containsKey( key ) ) {
			dict = indexByDelTopDepTblIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelTopDepObj>();
			ICFBamDelTopDepObj obj;
			CFBamDelTopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().readDerivedByDelTopDepTblIdx( schema.getAuthorization(),
				TableTenantId,
				TableId );
			CFBamDelTopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelTopDepObj realised = (ICFBamDelTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDelTopDepTblIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamDelTopDepObj arr[] = new ICFBamDelTopDepObj[len];
		Iterator<ICFBamDelTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelTopDepObj> arrayList = new ArrayList<ICFBamDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamDelTopDepObj> cmp = new Comparator<ICFBamDelTopDepObj>() {
			public int compare( ICFBamDelTopDepObj lhs, ICFBamDelTopDepObj rhs ) {
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
		List<ICFBamDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDelTopDepObj readDelTopDepByUNameIdx( long TableTenantId,
		long TableId,
		String Name )
	{
		return( readDelTopDepByUNameIdx( TableTenantId,
			TableId,
			Name,
			false ) );
	}

	public ICFBamDelTopDepObj readDelTopDepByUNameIdx( long TableTenantId,
		long TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamDelTopDepByUNameIdxKey,
				ICFBamDelTopDepObj >();
		}
		CFBamDelTopDepByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newUNameIdxKey();
		key.setRequiredTableTenantId( TableTenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamDelTopDepObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamDelTopDepBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().readDerivedByUNameIdx( schema.getAuthorization(),
				TableTenantId,
				TableId,
				Name );
			if( buff != null ) {
				obj = (ICFBamDelTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamDelTopDepObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		return( readDelTopDepByPrevIdx( PrevTenantId,
			PrevId,
			false ) );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelTopDepByPrevIdx";
		CFBamDelTopDepByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamScopePKey, ICFBamDelTopDepObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamDelTopDepByPrevIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelTopDepObj>();
			ICFBamDelTopDepObj obj;
			CFBamDelTopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().readDerivedByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			CFBamDelTopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelTopDepObj realised = (ICFBamDelTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamDelTopDepObj arr[] = new ICFBamDelTopDepObj[len];
		Iterator<ICFBamDelTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelTopDepObj> arrayList = new ArrayList<ICFBamDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamDelTopDepObj> cmp = new Comparator<ICFBamDelTopDepObj>() {
			public int compare( ICFBamDelTopDepObj lhs, ICFBamDelTopDepObj rhs ) {
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
		List<ICFBamDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByNextIdx( Long NextTenantId,
		Long NextId )
	{
		return( readDelTopDepByNextIdx( NextTenantId,
			NextId,
			false ) );
	}

	public List<ICFBamDelTopDepObj> readDelTopDepByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelTopDepByNextIdx";
		CFBamDelTopDepByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		Map<CFBamScopePKey, ICFBamDelTopDepObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamDelTopDepByNextIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamDelTopDepObj>();
			ICFBamDelTopDepObj obj;
			CFBamDelTopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().readDerivedByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			CFBamDelTopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDelTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamDelTopDepObj realised = (ICFBamDelTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamDelTopDepObj arr[] = new ICFBamDelTopDepObj[len];
		Iterator<ICFBamDelTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDelTopDepObj> arrayList = new ArrayList<ICFBamDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamDelTopDepObj> cmp = new Comparator<ICFBamDelTopDepObj>() {
			public int compare( ICFBamDelTopDepObj lhs, ICFBamDelTopDepObj rhs ) {
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
		List<ICFBamDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDelTopDepObj updateDelTopDep( ICFBamDelTopDepObj Obj ) {
		ICFBamDelTopDepObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().updateDelTopDep( schema.getAuthorization(),
			Obj.getDelTopDepBuff() );
		if( Obj.getClassCode().equals( "DELT" ) ) {
			obj = (ICFBamDelTopDepObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteDelTopDep( ICFBamDelTopDepObj Obj ) {
		ICFBamDelTopDepObj obj = Obj;
		ICFBamDelTopDepObj prev = obj.getOptionalLookupPrev();
		ICFBamDelTopDepObj next = obj.getOptionalLookupNext();
		((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().deleteDelTopDep( schema.getAuthorization(),
			obj.getDelTopDepBuff() );
		obj.forget( true );
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	public void deleteDelTopDepByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDelTopDepObj obj = readDelTopDep( pkey );
		if( obj != null ) {
			ICFBamDelTopDepEditObj editObj = (ICFBamDelTopDepEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamDelTopDepEditObj)obj.beginEdit();
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

	public void deleteDelTopDepByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().deleteDelTopDepByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamDelTopDepObj> iter = dict.values().iterator();
			ICFBamDelTopDepObj obj;
			List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().deleteDelTopDepByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteDelTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamDelDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamDelDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().deleteDelTopDepByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamDelTopDepObj> iter = dict.values().iterator();
			ICFBamDelTopDepObj obj;
			List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().deleteDelTopDepByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteDelTopDepByDelDepIdx( long RelationTenantId,
		long RelationId )
	{
		CFBamDelDepByDelDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelDep().newDelDepIdxKey();
		key.setRequiredRelationTenantId( RelationTenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByDelDepIdx == null ) {
			indexByDelDepIdx = new HashMap< CFBamDelDepByDelDepIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( indexByDelDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj> dict = indexByDelDepIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().deleteDelTopDepByDelDepIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
			Iterator<ICFBamDelTopDepObj> iter = dict.values().iterator();
			ICFBamDelTopDepObj obj;
			List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().deleteDelTopDepByDelDepIdx( schema.getAuthorization(),
				RelationTenantId,
				RelationId );
		}
	}

	public void deleteDelTopDepByDelTopDepTblIdx( long TableTenantId,
		long TableId )
	{
		CFBamDelTopDepByDelTopDepTblIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newDelTopDepTblIdxKey();
		key.setRequiredTableTenantId( TableTenantId );
		key.setRequiredTableId( TableId );
		if( indexByDelTopDepTblIdx == null ) {
			indexByDelTopDepTblIdx = new HashMap< CFBamDelTopDepByDelTopDepTblIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( indexByDelTopDepTblIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj> dict = indexByDelTopDepTblIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().deleteDelTopDepByDelTopDepTblIdx( schema.getAuthorization(),
				TableTenantId,
				TableId );
			Iterator<ICFBamDelTopDepObj> iter = dict.values().iterator();
			ICFBamDelTopDepObj obj;
			List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByDelTopDepTblIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().deleteDelTopDepByDelTopDepTblIdx( schema.getAuthorization(),
				TableTenantId,
				TableId );
		}
	}

	public void deleteDelTopDepByUNameIdx( long TableTenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamDelTopDepByUNameIdxKey,
				ICFBamDelTopDepObj >();
		}
		CFBamDelTopDepByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newUNameIdxKey();
		key.setRequiredTableTenantId( TableTenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamDelTopDepObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().deleteDelTopDepByUNameIdx( schema.getAuthorization(),
				TableTenantId,
				TableId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().deleteDelTopDepByUNameIdx( schema.getAuthorization(),
				TableTenantId,
				TableId,
				Name );
		}
	}

	public void deleteDelTopDepByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		CFBamDelTopDepByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamDelTopDepByPrevIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj> dict = indexByPrevIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().deleteDelTopDepByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			Iterator<ICFBamDelTopDepObj> iter = dict.values().iterator();
			ICFBamDelTopDepObj obj;
			List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByPrevIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().deleteDelTopDepByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
		}
	}

	public void deleteDelTopDepByNextIdx( Long NextTenantId,
		Long NextId )
	{
		CFBamDelTopDepByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamDelTopDepByNextIdxKey,
				Map< CFBamScopePKey, ICFBamDelTopDepObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamDelTopDepObj> dict = indexByNextIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().deleteDelTopDepByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			Iterator<ICFBamDelTopDepObj> iter = dict.values().iterator();
			ICFBamDelTopDepObj obj;
			List<ICFBamDelTopDepObj> toForget = new LinkedList<ICFBamDelTopDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByNextIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().deleteDelTopDepByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
		}
	}

	/**
	 *	Move the CFBamDelTopDepObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamDelTopDepObj refreshed cache instance.
	 */
	public ICFBamDelTopDepObj moveUpDelTopDep( ICFBamDelTopDepObj Obj ) {
		ICFBamDelTopDepObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveUpDelTopDep",
				"You cannot move an object that is being edited" );
		}
		CFBamDelTopDepBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().moveBuffUp( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getDelTopDepTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamDelTopDepObj)obj.realise();
			ICFBamDelTopDepObj prev = obj.getOptionalLookupPrev( true );
			ICFBamDelTopDepObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				ICFBamDelTopDepObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the CFBamDelTopDepObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamDelTopDepObj refreshed cache instance.
	 */
	public ICFBamDelTopDepObj moveDownDelTopDep( ICFBamDelTopDepObj Obj ) {
		ICFBamDelTopDepObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveDownDelTopDep",
				"You cannot move an object that is being edited" );
		}
		CFBamDelTopDepBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().moveBuffDown( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getDelTopDepTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamDelTopDepObj)obj.realise();
			ICFBamDelTopDepObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				ICFBamDelTopDepObj gprev = prev.getOptionalLookupPrev( true );
			}
			ICFBamDelTopDepObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}
