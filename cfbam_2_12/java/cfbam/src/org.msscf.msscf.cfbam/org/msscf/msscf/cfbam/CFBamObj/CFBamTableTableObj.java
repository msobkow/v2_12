// Description: Java 11 Table Object implementation for CFBam.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamTableTableObj
	implements ICFBamTableTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamTableObj> members;
	private Map<CFBamScopePKey, ICFBamTableObj> allTable;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexByTenantIdx;
	private Map< CFBamTableBySchemaDefIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexBySchemaDefIdx;
	private Map< CFBamTableByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexByDefSchemaIdx;
	private Map< CFBamTableByUNameIdxKey,
		ICFBamTableObj > indexByUNameIdx;
	private Map< CFBamTableBySchemaCdIdxKey,
		ICFBamTableObj > indexBySchemaCdIdx;
	private Map< CFBamTableByPrimaryIndexIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexByPrimaryIndexIdx;
	private Map< CFBamTableByLookupIndexIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexByLookupIndexIdx;
	private Map< CFBamTableByAltIndexIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexByAltIndexIdx;
	private Map< CFBamTableByQualTableIdxKey,
		Map<CFBamScopePKey, ICFBamTableObj > > indexByQualTableIdx;
	public static String TABLE_NAME = "Table";
	public static String TABLE_DBNAME = "tbldef";

	public CFBamTableTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamTableObj>();
		allTable = null;
		indexByTenantIdx = null;
		indexBySchemaDefIdx = null;
		indexByDefSchemaIdx = null;
		indexByUNameIdx = null;
		indexBySchemaCdIdx = null;
		indexByPrimaryIndexIdx = null;
		indexByLookupIndexIdx = null;
		indexByAltIndexIdx = null;
		indexByQualTableIdx = null;
	}

	public CFBamTableTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamTableObj>();
		allTable = null;
		indexByTenantIdx = null;
		indexBySchemaDefIdx = null;
		indexByDefSchemaIdx = null;
		indexByUNameIdx = null;
		indexBySchemaCdIdx = null;
		indexByPrimaryIndexIdx = null;
		indexByLookupIndexIdx = null;
		indexByAltIndexIdx = null;
		indexByQualTableIdx = null;
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
		allTable = null;
		indexByTenantIdx = null;
		indexBySchemaDefIdx = null;
		indexByDefSchemaIdx = null;
		indexByUNameIdx = null;
		indexBySchemaCdIdx = null;
		indexByPrimaryIndexIdx = null;
		indexByLookupIndexIdx = null;
		indexByAltIndexIdx = null;
		indexByQualTableIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTableObj.
	 */
	public ICFBamTableObj newInstance() {
		ICFBamTableObj inst = new CFBamTableObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTableObj.
	 */
	public ICFBamTableEditObj newEditInstance( ICFBamTableObj orig ) {
		ICFBamTableEditObj edit = new CFBamTableEditObj( orig );
		return( edit );
	}

	public ICFBamTableObj realiseTable( ICFBamTableObj Obj ) {
		ICFBamTableObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamTableObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamTableObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamTableObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexBySchemaDefIdx != null ) {
				CFBamTableBySchemaDefIdxKey keySchemaDefIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newSchemaDefIdxKey();
				keySchemaDefIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaDefIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapSchemaDefIdx = indexBySchemaDefIdx.get( keySchemaDefIdx );
				if( mapSchemaDefIdx != null ) {
					mapSchemaDefIdx.remove( keepObj.getPKey() );
					if( mapSchemaDefIdx.size() <= 0 ) {
						indexBySchemaDefIdx.remove( keySchemaDefIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamTableByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamTableByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexBySchemaCdIdx != null ) {
				CFBamTableBySchemaCdIdxKey keySchemaCdIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newSchemaCdIdxKey();
				keySchemaCdIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaCdIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keySchemaCdIdx.setRequiredTableClassCode( keepObj.getRequiredTableClassCode() );
				indexBySchemaCdIdx.remove( keySchemaCdIdx );
			}

			if( indexByPrimaryIndexIdx != null ) {
				CFBamTableByPrimaryIndexIdxKey keyPrimaryIndexIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newPrimaryIndexIdxKey();
				keyPrimaryIndexIdx.setOptionalPrimaryIndexTenantId( keepObj.getOptionalPrimaryIndexTenantId() );
				keyPrimaryIndexIdx.setOptionalPrimaryIndexId( keepObj.getOptionalPrimaryIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapPrimaryIndexIdx = indexByPrimaryIndexIdx.get( keyPrimaryIndexIdx );
				if( mapPrimaryIndexIdx != null ) {
					mapPrimaryIndexIdx.remove( keepObj.getPKey() );
					if( mapPrimaryIndexIdx.size() <= 0 ) {
						indexByPrimaryIndexIdx.remove( keyPrimaryIndexIdx );
					}
				}
			}

			if( indexByLookupIndexIdx != null ) {
				CFBamTableByLookupIndexIdxKey keyLookupIndexIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newLookupIndexIdxKey();
				keyLookupIndexIdx.setOptionalLookupIndexTenantId( keepObj.getOptionalLookupIndexTenantId() );
				keyLookupIndexIdx.setOptionalLookupIndexId( keepObj.getOptionalLookupIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapLookupIndexIdx = indexByLookupIndexIdx.get( keyLookupIndexIdx );
				if( mapLookupIndexIdx != null ) {
					mapLookupIndexIdx.remove( keepObj.getPKey() );
					if( mapLookupIndexIdx.size() <= 0 ) {
						indexByLookupIndexIdx.remove( keyLookupIndexIdx );
					}
				}
			}

			if( indexByAltIndexIdx != null ) {
				CFBamTableByAltIndexIdxKey keyAltIndexIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newAltIndexIdxKey();
				keyAltIndexIdx.setOptionalAltIndexTenantId( keepObj.getOptionalAltIndexTenantId() );
				keyAltIndexIdx.setOptionalAltIndexId( keepObj.getOptionalAltIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapAltIndexIdx = indexByAltIndexIdx.get( keyAltIndexIdx );
				if( mapAltIndexIdx != null ) {
					mapAltIndexIdx.remove( keepObj.getPKey() );
					if( mapAltIndexIdx.size() <= 0 ) {
						indexByAltIndexIdx.remove( keyAltIndexIdx );
					}
				}
			}

			if( indexByQualTableIdx != null ) {
				CFBamTableByQualTableIdxKey keyQualTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newQualTableIdxKey();
				keyQualTableIdx.setOptionalQualifyingTenantId( keepObj.getOptionalQualifyingTenantId() );
				keyQualTableIdx.setOptionalQualifyingTableId( keepObj.getOptionalQualifyingTableId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapQualTableIdx = indexByQualTableIdx.get( keyQualTableIdx );
				if( mapQualTableIdx != null ) {
					mapQualTableIdx.remove( keepObj.getPKey() );
					if( mapQualTableIdx.size() <= 0 ) {
						indexByQualTableIdx.remove( keyQualTableIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamTableObj)schema.getScopeTableObj().realiseScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaDefIdx != null ) {
				CFBamTableBySchemaDefIdxKey keySchemaDefIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newSchemaDefIdxKey();
				keySchemaDefIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaDefIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapSchemaDefIdx = indexBySchemaDefIdx.get( keySchemaDefIdx );
				if( mapSchemaDefIdx != null ) {
					mapSchemaDefIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamTableByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamTableByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexBySchemaCdIdx != null ) {
				CFBamTableBySchemaCdIdxKey keySchemaCdIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newSchemaCdIdxKey();
				keySchemaCdIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaCdIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keySchemaCdIdx.setRequiredTableClassCode( keepObj.getRequiredTableClassCode() );
				indexBySchemaCdIdx.put( keySchemaCdIdx, keepObj );
			}

			if( indexByPrimaryIndexIdx != null ) {
				CFBamTableByPrimaryIndexIdxKey keyPrimaryIndexIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newPrimaryIndexIdxKey();
				keyPrimaryIndexIdx.setOptionalPrimaryIndexTenantId( keepObj.getOptionalPrimaryIndexTenantId() );
				keyPrimaryIndexIdx.setOptionalPrimaryIndexId( keepObj.getOptionalPrimaryIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapPrimaryIndexIdx = indexByPrimaryIndexIdx.get( keyPrimaryIndexIdx );
				if( mapPrimaryIndexIdx != null ) {
					mapPrimaryIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLookupIndexIdx != null ) {
				CFBamTableByLookupIndexIdxKey keyLookupIndexIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newLookupIndexIdxKey();
				keyLookupIndexIdx.setOptionalLookupIndexTenantId( keepObj.getOptionalLookupIndexTenantId() );
				keyLookupIndexIdx.setOptionalLookupIndexId( keepObj.getOptionalLookupIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapLookupIndexIdx = indexByLookupIndexIdx.get( keyLookupIndexIdx );
				if( mapLookupIndexIdx != null ) {
					mapLookupIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByAltIndexIdx != null ) {
				CFBamTableByAltIndexIdxKey keyAltIndexIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newAltIndexIdxKey();
				keyAltIndexIdx.setOptionalAltIndexTenantId( keepObj.getOptionalAltIndexTenantId() );
				keyAltIndexIdx.setOptionalAltIndexId( keepObj.getOptionalAltIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapAltIndexIdx = indexByAltIndexIdx.get( keyAltIndexIdx );
				if( mapAltIndexIdx != null ) {
					mapAltIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByQualTableIdx != null ) {
				CFBamTableByQualTableIdxKey keyQualTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newQualTableIdxKey();
				keyQualTableIdx.setOptionalQualifyingTenantId( keepObj.getOptionalQualifyingTenantId() );
				keyQualTableIdx.setOptionalQualifyingTableId( keepObj.getOptionalQualifyingTableId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapQualTableIdx = indexByQualTableIdx.get( keyQualTableIdx );
				if( mapQualTableIdx != null ) {
					mapQualTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allTable != null ) {
				allTable.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamTableObj)schema.getScopeTableObj().realiseScope( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTable != null ) {
				allTable.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaDefIdx != null ) {
				CFBamTableBySchemaDefIdxKey keySchemaDefIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newSchemaDefIdxKey();
				keySchemaDefIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaDefIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapSchemaDefIdx = indexBySchemaDefIdx.get( keySchemaDefIdx );
				if( mapSchemaDefIdx != null ) {
					mapSchemaDefIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamTableByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamTableByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexBySchemaCdIdx != null ) {
				CFBamTableBySchemaCdIdxKey keySchemaCdIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newSchemaCdIdxKey();
				keySchemaCdIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaCdIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keySchemaCdIdx.setRequiredTableClassCode( keepObj.getRequiredTableClassCode() );
				indexBySchemaCdIdx.put( keySchemaCdIdx, keepObj );
			}

			if( indexByPrimaryIndexIdx != null ) {
				CFBamTableByPrimaryIndexIdxKey keyPrimaryIndexIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newPrimaryIndexIdxKey();
				keyPrimaryIndexIdx.setOptionalPrimaryIndexTenantId( keepObj.getOptionalPrimaryIndexTenantId() );
				keyPrimaryIndexIdx.setOptionalPrimaryIndexId( keepObj.getOptionalPrimaryIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapPrimaryIndexIdx = indexByPrimaryIndexIdx.get( keyPrimaryIndexIdx );
				if( mapPrimaryIndexIdx != null ) {
					mapPrimaryIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLookupIndexIdx != null ) {
				CFBamTableByLookupIndexIdxKey keyLookupIndexIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newLookupIndexIdxKey();
				keyLookupIndexIdx.setOptionalLookupIndexTenantId( keepObj.getOptionalLookupIndexTenantId() );
				keyLookupIndexIdx.setOptionalLookupIndexId( keepObj.getOptionalLookupIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapLookupIndexIdx = indexByLookupIndexIdx.get( keyLookupIndexIdx );
				if( mapLookupIndexIdx != null ) {
					mapLookupIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByAltIndexIdx != null ) {
				CFBamTableByAltIndexIdxKey keyAltIndexIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newAltIndexIdxKey();
				keyAltIndexIdx.setOptionalAltIndexTenantId( keepObj.getOptionalAltIndexTenantId() );
				keyAltIndexIdx.setOptionalAltIndexId( keepObj.getOptionalAltIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapAltIndexIdx = indexByAltIndexIdx.get( keyAltIndexIdx );
				if( mapAltIndexIdx != null ) {
					mapAltIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByQualTableIdx != null ) {
				CFBamTableByQualTableIdxKey keyQualTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newQualTableIdxKey();
				keyQualTableIdx.setOptionalQualifyingTenantId( keepObj.getOptionalQualifyingTenantId() );
				keyQualTableIdx.setOptionalQualifyingTableId( keepObj.getOptionalQualifyingTableId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapQualTableIdx = indexByQualTableIdx.get( keyQualTableIdx );
				if( mapQualTableIdx != null ) {
					mapQualTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetTable( ICFBamTableObj Obj ) {
		forgetTable( Obj, false );
	}

	public void forgetTable( ICFBamTableObj Obj, boolean forgetSubObjects ) {
		ICFBamTableObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamTableObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexBySchemaDefIdx != null ) {
				CFBamTableBySchemaDefIdxKey keySchemaDefIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newSchemaDefIdxKey();
				keySchemaDefIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaDefIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapSchemaDefIdx = indexBySchemaDefIdx.get( keySchemaDefIdx );
				if( mapSchemaDefIdx != null ) {
					mapSchemaDefIdx.remove( keepObj.getPKey() );
					if( mapSchemaDefIdx.size() <= 0 ) {
						indexBySchemaDefIdx.remove( keySchemaDefIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamTableByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamTableByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexBySchemaCdIdx != null ) {
				CFBamTableBySchemaCdIdxKey keySchemaCdIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newSchemaCdIdxKey();
				keySchemaCdIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaCdIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keySchemaCdIdx.setRequiredTableClassCode( keepObj.getRequiredTableClassCode() );
				indexBySchemaCdIdx.remove( keySchemaCdIdx );
			}

			if( indexByPrimaryIndexIdx != null ) {
				CFBamTableByPrimaryIndexIdxKey keyPrimaryIndexIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newPrimaryIndexIdxKey();
				keyPrimaryIndexIdx.setOptionalPrimaryIndexTenantId( keepObj.getOptionalPrimaryIndexTenantId() );
				keyPrimaryIndexIdx.setOptionalPrimaryIndexId( keepObj.getOptionalPrimaryIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapPrimaryIndexIdx = indexByPrimaryIndexIdx.get( keyPrimaryIndexIdx );
				if( mapPrimaryIndexIdx != null ) {
					mapPrimaryIndexIdx.remove( keepObj.getPKey() );
					if( mapPrimaryIndexIdx.size() <= 0 ) {
						indexByPrimaryIndexIdx.remove( keyPrimaryIndexIdx );
					}
				}
			}

			if( indexByLookupIndexIdx != null ) {
				CFBamTableByLookupIndexIdxKey keyLookupIndexIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newLookupIndexIdxKey();
				keyLookupIndexIdx.setOptionalLookupIndexTenantId( keepObj.getOptionalLookupIndexTenantId() );
				keyLookupIndexIdx.setOptionalLookupIndexId( keepObj.getOptionalLookupIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapLookupIndexIdx = indexByLookupIndexIdx.get( keyLookupIndexIdx );
				if( mapLookupIndexIdx != null ) {
					mapLookupIndexIdx.remove( keepObj.getPKey() );
					if( mapLookupIndexIdx.size() <= 0 ) {
						indexByLookupIndexIdx.remove( keyLookupIndexIdx );
					}
				}
			}

			if( indexByAltIndexIdx != null ) {
				CFBamTableByAltIndexIdxKey keyAltIndexIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newAltIndexIdxKey();
				keyAltIndexIdx.setOptionalAltIndexTenantId( keepObj.getOptionalAltIndexTenantId() );
				keyAltIndexIdx.setOptionalAltIndexId( keepObj.getOptionalAltIndexId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapAltIndexIdx = indexByAltIndexIdx.get( keyAltIndexIdx );
				if( mapAltIndexIdx != null ) {
					mapAltIndexIdx.remove( keepObj.getPKey() );
					if( mapAltIndexIdx.size() <= 0 ) {
						indexByAltIndexIdx.remove( keyAltIndexIdx );
					}
				}
			}

			if( indexByQualTableIdx != null ) {
				CFBamTableByQualTableIdxKey keyQualTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newQualTableIdxKey();
				keyQualTableIdx.setOptionalQualifyingTenantId( keepObj.getOptionalQualifyingTenantId() );
				keyQualTableIdx.setOptionalQualifyingTableId( keepObj.getOptionalQualifyingTableId() );
				Map<CFBamScopePKey, ICFBamTableObj > mapQualTableIdx = indexByQualTableIdx.get( keyQualTableIdx );
				if( mapQualTableIdx != null ) {
					mapQualTableIdx.remove( keepObj.getPKey() );
					if( mapQualTableIdx.size() <= 0 ) {
						indexByQualTableIdx.remove( keyQualTableIdx );
					}
				}
			}

			if( allTable != null ) {
				allTable.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFBamSchemaObj)schema).getRelationTableObj().forgetRelationByRelTableIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				((ICFBamSchemaObj)schema).getIndexTableObj().forgetIndexByIdxTableIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				((ICFBamSchemaObj)schema).getValueTableObj().forgetValueByScopeIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				((ICFBamSchemaObj)schema).getRelationTableObj().forgetRelationByToTblIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				((ICFBamSchemaObj)schema).getChainTableObj().forgetChainByChainTableIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				((ICFBamSchemaObj)schema).getDelTopDepTableObj().forgetDelTopDepByDelTopDepTblIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				((ICFBamSchemaObj)schema).getClearTopDepTableObj().forgetClearTopDepByClrTopDepTblIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				((ICFBamSchemaObj)schema).getId16GenTableObj().forgetId16GenByDispIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				((ICFBamSchemaObj)schema).getId32GenTableObj().forgetId32GenByDispIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				((ICFBamSchemaObj)schema).getId64GenTableObj().forgetId64GenByDispIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				((ICFBamSchemaObj)schema).getServerMethodTableObj().forgetServerMethodByMethTableIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		((ICFBamSchemaObj)schema).getScopeTableObj().forgetScope( obj );
	}

	public void forgetTableByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamTableObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTableByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
		ICFBamTableObj cur = null;
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamTableObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTableObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTableObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTableBySchemaDefIdx( long TenantId,
		long SchemaDefId )
	{
		if( indexBySchemaDefIdx == null ) {
			return;
		}
		List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
		ICFBamTableObj cur = null;
		CFBamTableBySchemaDefIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newSchemaDefIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		if( indexBySchemaDefIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapSchemaDefIdx = indexBySchemaDefIdx.get( key );
			if( mapSchemaDefIdx != null ) {
				Iterator<ICFBamTableObj> iterDup = mapSchemaDefIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexBySchemaDefIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTableObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTableObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTableByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
		ICFBamTableObj cur = null;
		CFBamTableByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamTableObj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTableObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTableObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTableByUNameIdx( long TenantId,
		long SchemaDefId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
		ICFBamTableObj cur = null;
		CFBamTableByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamTableObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTableBySchemaCdIdx( long TenantId,
		long SchemaDefId,
		String TableClassCode )
	{
		if( indexBySchemaCdIdx == null ) {
			return;
		}
		List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
		ICFBamTableObj cur = null;
		CFBamTableBySchemaCdIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newSchemaCdIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredTableClassCode( TableClassCode );
		if( indexBySchemaCdIdx.containsKey( key ) ) {
			cur = indexBySchemaCdIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamTableObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTableByPrimaryIndexIdx( Long PrimaryIndexTenantId,
		Long PrimaryIndexId )
	{
		if( indexByPrimaryIndexIdx == null ) {
			return;
		}
		List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
		ICFBamTableObj cur = null;
		CFBamTableByPrimaryIndexIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newPrimaryIndexIdxKey();
		key.setOptionalPrimaryIndexTenantId( PrimaryIndexTenantId );
		key.setOptionalPrimaryIndexId( PrimaryIndexId );
		if( indexByPrimaryIndexIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapPrimaryIndexIdx = indexByPrimaryIndexIdx.get( key );
			if( mapPrimaryIndexIdx != null ) {
				Iterator<ICFBamTableObj> iterDup = mapPrimaryIndexIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByPrimaryIndexIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTableObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTableObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTableByLookupIndexIdx( Long LookupIndexTenantId,
		Long LookupIndexId )
	{
		if( indexByLookupIndexIdx == null ) {
			return;
		}
		List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
		ICFBamTableObj cur = null;
		CFBamTableByLookupIndexIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newLookupIndexIdxKey();
		key.setOptionalLookupIndexTenantId( LookupIndexTenantId );
		key.setOptionalLookupIndexId( LookupIndexId );
		if( indexByLookupIndexIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapLookupIndexIdx = indexByLookupIndexIdx.get( key );
			if( mapLookupIndexIdx != null ) {
				Iterator<ICFBamTableObj> iterDup = mapLookupIndexIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByLookupIndexIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTableObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTableObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTableByAltIndexIdx( Long AltIndexTenantId,
		Long AltIndexId )
	{
		if( indexByAltIndexIdx == null ) {
			return;
		}
		List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
		ICFBamTableObj cur = null;
		CFBamTableByAltIndexIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newAltIndexIdxKey();
		key.setOptionalAltIndexTenantId( AltIndexTenantId );
		key.setOptionalAltIndexId( AltIndexId );
		if( indexByAltIndexIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapAltIndexIdx = indexByAltIndexIdx.get( key );
			if( mapAltIndexIdx != null ) {
				Iterator<ICFBamTableObj> iterDup = mapAltIndexIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByAltIndexIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTableObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTableObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTableByQualTableIdx( Long QualifyingTenantId,
		Long QualifyingTableId )
	{
		if( indexByQualTableIdx == null ) {
			return;
		}
		List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
		ICFBamTableObj cur = null;
		CFBamTableByQualTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newQualTableIdxKey();
		key.setOptionalQualifyingTenantId( QualifyingTenantId );
		key.setOptionalQualifyingTableId( QualifyingTableId );
		if( indexByQualTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj > mapQualTableIdx = indexByQualTableIdx.get( key );
			if( mapQualTableIdx != null ) {
				Iterator<ICFBamTableObj> iterDup = mapQualTableIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByQualTableIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTableObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTableObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamTableObj createTable( ICFBamTableObj Obj ) {
		ICFBamTableObj obj = Obj;
		CFBamTableBuff buff = obj.getTableBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableTable().createTable(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "TBLD" ) ) {
			obj = (ICFBamTableObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamTableObj readTable( CFBamScopePKey pkey ) {
		return( readTable( pkey, false ) );
	}

	public ICFBamTableObj readTable( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamTableObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamTableBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableTable().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamTableObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamTableObj lockTable( CFBamScopePKey pkey ) {
		ICFBamTableObj locked = null;
		CFBamTableBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableTable().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamTableObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockTable", pkey );
		}
		return( locked );
	}

	public List<ICFBamTableObj> readAllTable() {
		return( readAllTable( false ) );
	}

	public List<ICFBamTableObj> readAllTable( boolean forceRead ) {
		final String S_ProcName = "readAllTable";
		if( ( allTable == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamTableObj> map = new HashMap<CFBamScopePKey,ICFBamTableObj>();
			allTable = map;
			CFBamTableBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTable().readAllDerived( schema.getAuthorization() );
			CFBamTableBuff buff;
			ICFBamTableObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realised = (ICFBamTableObj)obj.realise();
			}
		}
		int len = allTable.size();
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = allTable.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTableObj readTableByIdIdx( long TenantId,
		long Id )
	{
		return( readTableByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamTableObj readTableByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamTableObj obj = readTable( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamTableObj> readTableByTenantIdx( long TenantId )
	{
		return( readTableByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamTableObj> readTableByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByTenantIdx";
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realised = (ICFBamTableObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableObj> readTableBySchemaDefIdx( long TenantId,
		long SchemaDefId )
	{
		return( readTableBySchemaDefIdx( TenantId,
			SchemaDefId,
			false ) );
	}

	public List<ICFBamTableObj> readTableBySchemaDefIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableBySchemaDefIdx";
		CFBamTableBySchemaDefIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newSchemaDefIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexBySchemaDefIdx == null ) {
			indexBySchemaDefIdx = new HashMap< CFBamTableBySchemaDefIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexBySchemaDefIdx.containsKey( key ) ) {
			dict = indexBySchemaDefIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTable().readDerivedBySchemaDefIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realised = (ICFBamTableObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySchemaDefIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableObj> readTableByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readTableByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamTableObj> readTableByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByDefSchemaIdx";
		CFBamTableByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamTableByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTable().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realised = (ICFBamTableObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTableObj readTableByUNameIdx( long TenantId,
		long SchemaDefId,
		String Name )
	{
		return( readTableByUNameIdx( TenantId,
			SchemaDefId,
			Name,
			false ) );
	}

	public ICFBamTableObj readTableByUNameIdx( long TenantId,
		long SchemaDefId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamTableByUNameIdxKey,
				ICFBamTableObj >();
		}
		CFBamTableByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredName( Name );
		ICFBamTableObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamTableBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableTable().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId,
				Name );
			if( buff != null ) {
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamTableObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamTableObj readTableBySchemaCdIdx( long TenantId,
		long SchemaDefId,
		String TableClassCode )
	{
		return( readTableBySchemaCdIdx( TenantId,
			SchemaDefId,
			TableClassCode,
			false ) );
	}

	public ICFBamTableObj readTableBySchemaCdIdx( long TenantId,
		long SchemaDefId,
		String TableClassCode, boolean forceRead )
	{
		if( indexBySchemaCdIdx == null ) {
			indexBySchemaCdIdx = new HashMap< CFBamTableBySchemaCdIdxKey,
				ICFBamTableObj >();
		}
		CFBamTableBySchemaCdIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newSchemaCdIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredTableClassCode( TableClassCode );
		ICFBamTableObj obj = null;
		if( ( ! forceRead ) && indexBySchemaCdIdx.containsKey( key ) ) {
			obj = indexBySchemaCdIdx.get( key );
		}
		else {
			CFBamTableBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableTable().readDerivedBySchemaCdIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId,
				TableClassCode );
			if( buff != null ) {
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamTableObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFBamTableObj> readTableByPrimaryIndexIdx( Long PrimaryIndexTenantId,
		Long PrimaryIndexId )
	{
		return( readTableByPrimaryIndexIdx( PrimaryIndexTenantId,
			PrimaryIndexId,
			false ) );
	}

	public List<ICFBamTableObj> readTableByPrimaryIndexIdx( Long PrimaryIndexTenantId,
		Long PrimaryIndexId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByPrimaryIndexIdx";
		CFBamTableByPrimaryIndexIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newPrimaryIndexIdxKey();
		key.setOptionalPrimaryIndexTenantId( PrimaryIndexTenantId );
		key.setOptionalPrimaryIndexId( PrimaryIndexId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexByPrimaryIndexIdx == null ) {
			indexByPrimaryIndexIdx = new HashMap< CFBamTableByPrimaryIndexIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexByPrimaryIndexIdx.containsKey( key ) ) {
			dict = indexByPrimaryIndexIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTable().readDerivedByPrimaryIndexIdx( schema.getAuthorization(),
				PrimaryIndexTenantId,
				PrimaryIndexId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realised = (ICFBamTableObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrimaryIndexIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableObj> readTableByLookupIndexIdx( Long LookupIndexTenantId,
		Long LookupIndexId )
	{
		return( readTableByLookupIndexIdx( LookupIndexTenantId,
			LookupIndexId,
			false ) );
	}

	public List<ICFBamTableObj> readTableByLookupIndexIdx( Long LookupIndexTenantId,
		Long LookupIndexId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByLookupIndexIdx";
		CFBamTableByLookupIndexIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newLookupIndexIdxKey();
		key.setOptionalLookupIndexTenantId( LookupIndexTenantId );
		key.setOptionalLookupIndexId( LookupIndexId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexByLookupIndexIdx == null ) {
			indexByLookupIndexIdx = new HashMap< CFBamTableByLookupIndexIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexByLookupIndexIdx.containsKey( key ) ) {
			dict = indexByLookupIndexIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTable().readDerivedByLookupIndexIdx( schema.getAuthorization(),
				LookupIndexTenantId,
				LookupIndexId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realised = (ICFBamTableObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByLookupIndexIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableObj> readTableByAltIndexIdx( Long AltIndexTenantId,
		Long AltIndexId )
	{
		return( readTableByAltIndexIdx( AltIndexTenantId,
			AltIndexId,
			false ) );
	}

	public List<ICFBamTableObj> readTableByAltIndexIdx( Long AltIndexTenantId,
		Long AltIndexId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByAltIndexIdx";
		CFBamTableByAltIndexIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newAltIndexIdxKey();
		key.setOptionalAltIndexTenantId( AltIndexTenantId );
		key.setOptionalAltIndexId( AltIndexId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexByAltIndexIdx == null ) {
			indexByAltIndexIdx = new HashMap< CFBamTableByAltIndexIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexByAltIndexIdx.containsKey( key ) ) {
			dict = indexByAltIndexIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTable().readDerivedByAltIndexIdx( schema.getAuthorization(),
				AltIndexTenantId,
				AltIndexId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realised = (ICFBamTableObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByAltIndexIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableObj> readTableByQualTableIdx( Long QualifyingTenantId,
		Long QualifyingTableId )
	{
		return( readTableByQualTableIdx( QualifyingTenantId,
			QualifyingTableId,
			false ) );
	}

	public List<ICFBamTableObj> readTableByQualTableIdx( Long QualifyingTenantId,
		Long QualifyingTableId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByQualTableIdx";
		CFBamTableByQualTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newQualTableIdxKey();
		key.setOptionalQualifyingTenantId( QualifyingTenantId );
		key.setOptionalQualifyingTableId( QualifyingTableId );
		Map<CFBamScopePKey, ICFBamTableObj> dict;
		if( indexByQualTableIdx == null ) {
			indexByQualTableIdx = new HashMap< CFBamTableByQualTableIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( ( ! forceRead ) && indexByQualTableIdx.containsKey( key ) ) {
			dict = indexByQualTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamTableObj>();
			ICFBamTableObj obj;
			CFBamTableBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTable().readDerivedByQualTableIdx( schema.getAuthorization(),
				QualifyingTenantId,
				QualifyingTableId );
			CFBamTableBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamTableObj realised = (ICFBamTableObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByQualTableIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTableObj arr[] = new ICFBamTableObj[len];
		Iterator<ICFBamTableObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableObj> arrayList = new ArrayList<ICFBamTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTableObj> cmp = new Comparator<ICFBamTableObj>() {
			public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
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
		List<ICFBamTableObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTableObj updateTable( ICFBamTableObj Obj ) {
		ICFBamTableObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableTable().updateTable( schema.getAuthorization(),
			Obj.getTableBuff() );
		if( Obj.getClassCode().equals( "TBLD" ) ) {
			obj = (ICFBamTableObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteTable( ICFBamTableObj Obj ) {
		ICFBamTableObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTable( schema.getAuthorization(),
			obj.getTableBuff() );
		obj.forget( true );
	}

	public void deleteTableByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamTableObj obj = readTable( pkey );
		if( obj != null ) {
			ICFBamTableEditObj editObj = (ICFBamTableEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamTableEditObj)obj.beginEdit();
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

	public void deleteTableByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTableByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTableByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTableBySchemaDefIdx( long TenantId,
		long SchemaDefId )
	{
		CFBamTableBySchemaDefIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newSchemaDefIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		if( indexBySchemaDefIdx == null ) {
			indexBySchemaDefIdx = new HashMap< CFBamTableBySchemaDefIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexBySchemaDefIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexBySchemaDefIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTableBySchemaDefIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexBySchemaDefIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTableBySchemaDefIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId );
		}
	}

	public void deleteTableByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamTableByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamTableByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTableByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTableByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteTableByUNameIdx( long TenantId,
		long SchemaDefId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamTableByUNameIdxKey,
				ICFBamTableObj >();
		}
		CFBamTableByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredName( Name );
		ICFBamTableObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTableByUNameIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTableByUNameIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId,
				Name );
		}
	}

	public void deleteTableBySchemaCdIdx( long TenantId,
		long SchemaDefId,
		String TableClassCode )
	{
		if( indexBySchemaCdIdx == null ) {
			indexBySchemaCdIdx = new HashMap< CFBamTableBySchemaCdIdxKey,
				ICFBamTableObj >();
		}
		CFBamTableBySchemaCdIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newSchemaCdIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredTableClassCode( TableClassCode );
		ICFBamTableObj obj = null;
		if( indexBySchemaCdIdx.containsKey( key ) ) {
			obj = indexBySchemaCdIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTableBySchemaCdIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId,
				TableClassCode );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTableBySchemaCdIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId,
				TableClassCode );
		}
	}

	public void deleteTableByPrimaryIndexIdx( Long PrimaryIndexTenantId,
		Long PrimaryIndexId )
	{
		CFBamTableByPrimaryIndexIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newPrimaryIndexIdxKey();
		key.setOptionalPrimaryIndexTenantId( PrimaryIndexTenantId );
		key.setOptionalPrimaryIndexId( PrimaryIndexId );
		if( indexByPrimaryIndexIdx == null ) {
			indexByPrimaryIndexIdx = new HashMap< CFBamTableByPrimaryIndexIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexByPrimaryIndexIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexByPrimaryIndexIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTableByPrimaryIndexIdx( schema.getAuthorization(),
				PrimaryIndexTenantId,
				PrimaryIndexId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByPrimaryIndexIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTableByPrimaryIndexIdx( schema.getAuthorization(),
				PrimaryIndexTenantId,
				PrimaryIndexId );
		}
	}

	public void deleteTableByLookupIndexIdx( Long LookupIndexTenantId,
		Long LookupIndexId )
	{
		CFBamTableByLookupIndexIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newLookupIndexIdxKey();
		key.setOptionalLookupIndexTenantId( LookupIndexTenantId );
		key.setOptionalLookupIndexId( LookupIndexId );
		if( indexByLookupIndexIdx == null ) {
			indexByLookupIndexIdx = new HashMap< CFBamTableByLookupIndexIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexByLookupIndexIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexByLookupIndexIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTableByLookupIndexIdx( schema.getAuthorization(),
				LookupIndexTenantId,
				LookupIndexId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByLookupIndexIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTableByLookupIndexIdx( schema.getAuthorization(),
				LookupIndexTenantId,
				LookupIndexId );
		}
	}

	public void deleteTableByAltIndexIdx( Long AltIndexTenantId,
		Long AltIndexId )
	{
		CFBamTableByAltIndexIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newAltIndexIdxKey();
		key.setOptionalAltIndexTenantId( AltIndexTenantId );
		key.setOptionalAltIndexId( AltIndexId );
		if( indexByAltIndexIdx == null ) {
			indexByAltIndexIdx = new HashMap< CFBamTableByAltIndexIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexByAltIndexIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexByAltIndexIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTableByAltIndexIdx( schema.getAuthorization(),
				AltIndexTenantId,
				AltIndexId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByAltIndexIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTableByAltIndexIdx( schema.getAuthorization(),
				AltIndexTenantId,
				AltIndexId );
		}
	}

	public void deleteTableByQualTableIdx( Long QualifyingTenantId,
		Long QualifyingTableId )
	{
		CFBamTableByQualTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newQualTableIdxKey();
		key.setOptionalQualifyingTenantId( QualifyingTenantId );
		key.setOptionalQualifyingTableId( QualifyingTableId );
		if( indexByQualTableIdx == null ) {
			indexByQualTableIdx = new HashMap< CFBamTableByQualTableIdxKey,
				Map< CFBamScopePKey, ICFBamTableObj > >();
		}
		if( indexByQualTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamTableObj> dict = indexByQualTableIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTableByQualTableIdx( schema.getAuthorization(),
				QualifyingTenantId,
				QualifyingTableId );
			Iterator<ICFBamTableObj> iter = dict.values().iterator();
			ICFBamTableObj obj;
			List<ICFBamTableObj> toForget = new LinkedList<ICFBamTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByQualTableIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTable().deleteTableByQualTableIdx( schema.getAuthorization(),
				QualifyingTenantId,
				QualifyingTableId );
		}
	}
}
