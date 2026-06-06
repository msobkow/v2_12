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

public class CFBamTableColTableObj
	implements ICFBamTableColTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamValuePKey, ICFBamTableColObj> members;
	private Map<CFBamValuePKey, ICFBamTableColObj> allTableCol;
	private Map< CFBamValueByUNameIdxKey,
		ICFBamTableColObj > indexByUNameIdx;
	private Map< CFBamValueByValTentIdxKey,
		Map<CFBamValuePKey, ICFBamTableColObj > > indexByValTentIdx;
	private Map< CFBamValueByScopeIdxKey,
		Map<CFBamValuePKey, ICFBamTableColObj > > indexByScopeIdx;
	private Map< CFBamValueByDefSchemaIdxKey,
		Map<CFBamValuePKey, ICFBamTableColObj > > indexByDefSchemaIdx;
	private Map< CFBamValueByPrevIdxKey,
		Map<CFBamValuePKey, ICFBamTableColObj > > indexByPrevIdx;
	private Map< CFBamValueByNextIdxKey,
		Map<CFBamValuePKey, ICFBamTableColObj > > indexByNextIdx;
	private Map< CFBamValueByContPrevIdxKey,
		Map<CFBamValuePKey, ICFBamTableColObj > > indexByContPrevIdx;
	private Map< CFBamValueByContNextIdxKey,
		Map<CFBamValuePKey, ICFBamTableColObj > > indexByContNextIdx;
	private Map< CFBamTableColByTableIdxKey,
		Map<CFBamValuePKey, ICFBamTableColObj > > indexByTableIdx;
	private Map< CFBamTableColByDataIdxKey,
		Map<CFBamValuePKey, ICFBamTableColObj > > indexByDataIdx;
	public static String TABLE_NAME = "TableCol";
	public static String TABLE_DBNAME = "tblcol";

	public CFBamTableColTableObj() {
		schema = null;
		members = new HashMap<CFBamValuePKey, ICFBamTableColObj>();
		allTableCol = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexByTableIdx = null;
		indexByDataIdx = null;
	}

	public CFBamTableColTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamValuePKey, ICFBamTableColObj>();
		allTableCol = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexByTableIdx = null;
		indexByDataIdx = null;
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
		allTableCol = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexByTableIdx = null;
		indexByDataIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTableColObj.
	 */
	public ICFBamTableColObj newInstance() {
		ICFBamTableColObj inst = new CFBamTableColObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTableColObj.
	 */
	public ICFBamTableColEditObj newEditInstance( ICFBamTableColObj orig ) {
		ICFBamTableColEditObj edit = new CFBamTableColEditObj( orig );
		return( edit );
	}

	public ICFBamTableColObj realiseTableCol( ICFBamTableColObj Obj ) {
		ICFBamTableColObj obj = Obj;
		CFBamValuePKey pkey = obj.getPKey();
		ICFBamTableColObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamTableColObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				CFBamValueByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByValTentIdx != null ) {
				CFBamValueByValTentIdxKey keyValTentIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					indexByNextIdx.remove( keyNextIdx );
				}
			}

			if( indexByContPrevIdx != null ) {
				CFBamValueByContPrevIdxKey keyContPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContPrevIdxKey();
				keyContPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					indexByContPrevIdx.remove( keyContPrevIdx );
				}
			}

			if( indexByContNextIdx != null ) {
				CFBamValueByContNextIdxKey keyContNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContNextIdxKey();
				keyContNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamTableColByTableIdxKey keyTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTableCol().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.remove( keepObj.getPKey() );
					if( mapTableIdx.size() <= 0 ) {
						indexByTableIdx.remove( keyTableIdx );
					}
				}
			}

			if( indexByDataIdx != null ) {
				CFBamTableColByDataIdxKey keyDataIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTableCol().newDataIdxKey();
				keyDataIdx.setOptionalDataTenantId( keepObj.getOptionalDataTenantId() );
				keyDataIdx.setOptionalDataId( keepObj.getOptionalDataId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapDataIdx = indexByDataIdx.get( keyDataIdx );
				if( mapDataIdx != null ) {
					mapDataIdx.remove( keepObj.getPKey() );
					if( mapDataIdx.size() <= 0 ) {
						indexByDataIdx.remove( keyDataIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamTableColObj)schema.getValueTableObj().realiseValue( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				CFBamValueByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByValTentIdx != null ) {
				CFBamValueByValTentIdxKey keyValTentIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				CFBamValueByContPrevIdxKey keyContPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContPrevIdxKey();
				keyContPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				CFBamValueByContNextIdxKey keyContNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContNextIdxKey();
				keyContNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamTableColByTableIdxKey keyTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTableCol().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDataIdx != null ) {
				CFBamTableColByDataIdxKey keyDataIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTableCol().newDataIdxKey();
				keyDataIdx.setOptionalDataTenantId( keepObj.getOptionalDataTenantId() );
				keyDataIdx.setOptionalDataId( keepObj.getOptionalDataId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapDataIdx = indexByDataIdx.get( keyDataIdx );
				if( mapDataIdx != null ) {
					mapDataIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allTableCol != null ) {
				allTableCol.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamTableColObj)schema.getValueTableObj().realiseValue( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTableCol != null ) {
				allTableCol.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				CFBamValueByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByValTentIdx != null ) {
				CFBamValueByValTentIdxKey keyValTentIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				CFBamValueByContPrevIdxKey keyContPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContPrevIdxKey();
				keyContPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				CFBamValueByContNextIdxKey keyContNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContNextIdxKey();
				keyContNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamTableColByTableIdxKey keyTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTableCol().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDataIdx != null ) {
				CFBamTableColByDataIdxKey keyDataIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTableCol().newDataIdxKey();
				keyDataIdx.setOptionalDataTenantId( keepObj.getOptionalDataTenantId() );
				keyDataIdx.setOptionalDataId( keepObj.getOptionalDataId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapDataIdx = indexByDataIdx.get( keyDataIdx );
				if( mapDataIdx != null ) {
					mapDataIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetTableCol( ICFBamTableColObj Obj ) {
		forgetTableCol( Obj, false );
	}

	public void forgetTableCol( ICFBamTableColObj Obj, boolean forgetSubObjects ) {
		ICFBamTableColObj obj = Obj;
		CFBamValuePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamTableColObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUNameIdx != null ) {
				CFBamValueByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByValTentIdx != null ) {
				CFBamValueByValTentIdxKey keyValTentIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					indexByNextIdx.remove( keyNextIdx );
				}
			}

			if( indexByContPrevIdx != null ) {
				CFBamValueByContPrevIdxKey keyContPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContPrevIdxKey();
				keyContPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					indexByContPrevIdx.remove( keyContPrevIdx );
				}
			}

			if( indexByContNextIdx != null ) {
				CFBamValueByContNextIdxKey keyContNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContNextIdxKey();
				keyContNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamTableColByTableIdxKey keyTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTableCol().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.remove( keepObj.getPKey() );
					if( mapTableIdx.size() <= 0 ) {
						indexByTableIdx.remove( keyTableIdx );
					}
				}
			}

			if( indexByDataIdx != null ) {
				CFBamTableColByDataIdxKey keyDataIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTableCol().newDataIdxKey();
				keyDataIdx.setOptionalDataTenantId( keepObj.getOptionalDataTenantId() );
				keyDataIdx.setOptionalDataId( keepObj.getOptionalDataId() );
				Map<CFBamValuePKey, ICFBamTableColObj > mapDataIdx = indexByDataIdx.get( keyDataIdx );
				if( mapDataIdx != null ) {
					mapDataIdx.remove( keepObj.getPKey() );
					if( mapDataIdx.size() <= 0 ) {
						indexByDataIdx.remove( keyDataIdx );
					}
				}
			}

			if( allTableCol != null ) {
				allTableCol.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		((ICFBamSchemaObj)schema).getValueTableObj().forgetValue( obj );
	}

	public void forgetTableColByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamValuePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamTableColObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTableColByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
		ICFBamTableColObj cur = null;
		CFBamValueByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamTableColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTableColByValTentIdx( long TenantId )
	{
		if( indexByValTentIdx == null ) {
			return;
		}
		List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
		ICFBamTableColObj cur = null;
		CFBamValueByValTentIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTableColObj > mapValTentIdx = indexByValTentIdx.get( key );
			if( mapValTentIdx != null ) {
				Iterator<ICFBamTableColObj> iterDup = mapValTentIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByValTentIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTableColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTableColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTableColByScopeIdx( long TenantId,
		long ScopeId )
	{
		if( indexByScopeIdx == null ) {
			return;
		}
		List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
		ICFBamTableColObj cur = null;
		CFBamValueByScopeIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTableColObj > mapScopeIdx = indexByScopeIdx.get( key );
			if( mapScopeIdx != null ) {
				Iterator<ICFBamTableColObj> iterDup = mapScopeIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByScopeIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTableColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTableColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTableColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
		ICFBamTableColObj cur = null;
		CFBamValueByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTableColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamTableColObj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTableColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTableColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTableColByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		if( indexByPrevIdx == null ) {
			return;
		}
		List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
		ICFBamTableColObj cur = null;
		CFBamValueByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTableColObj > mapPrevIdx = indexByPrevIdx.get( key );
			if( mapPrevIdx != null ) {
				Iterator<ICFBamTableColObj> iterDup = mapPrevIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByPrevIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTableColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTableColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTableColByNextIdx( Long NextTenantId,
		Long NextId )
	{
		if( indexByNextIdx == null ) {
			return;
		}
		List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
		ICFBamTableColObj cur = null;
		CFBamValueByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTableColObj > mapNextIdx = indexByNextIdx.get( key );
			if( mapNextIdx != null ) {
				Iterator<ICFBamTableColObj> iterDup = mapNextIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByNextIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTableColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTableColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTableColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		if( indexByContPrevIdx == null ) {
			return;
		}
		List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
		ICFBamTableColObj cur = null;
		CFBamValueByContPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTableColObj > mapContPrevIdx = indexByContPrevIdx.get( key );
			if( mapContPrevIdx != null ) {
				Iterator<ICFBamTableColObj> iterDup = mapContPrevIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByContPrevIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTableColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTableColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTableColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		if( indexByContNextIdx == null ) {
			return;
		}
		List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
		ICFBamTableColObj cur = null;
		CFBamValueByContNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTableColObj > mapContNextIdx = indexByContNextIdx.get( key );
			if( mapContNextIdx != null ) {
				Iterator<ICFBamTableColObj> iterDup = mapContNextIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByContNextIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTableColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTableColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTableColByTableIdx( long TenantId,
		long TableId )
	{
		if( indexByTableIdx == null ) {
			return;
		}
		List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
		ICFBamTableColObj cur = null;
		CFBamTableColByTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTableCol().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTableColObj > mapTableIdx = indexByTableIdx.get( key );
			if( mapTableIdx != null ) {
				Iterator<ICFBamTableColObj> iterDup = mapTableIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTableIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTableColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTableColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTableColByDataIdx( Long DataTenantId,
		Long DataId )
	{
		if( indexByDataIdx == null ) {
			return;
		}
		List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
		ICFBamTableColObj cur = null;
		CFBamTableColByDataIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTableCol().newDataIdxKey();
		key.setOptionalDataTenantId( DataTenantId );
		key.setOptionalDataId( DataId );
		if( indexByDataIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTableColObj > mapDataIdx = indexByDataIdx.get( key );
			if( mapDataIdx != null ) {
				Iterator<ICFBamTableColObj> iterDup = mapDataIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDataIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTableColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTableColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamTableColObj createTableCol( ICFBamTableColObj Obj ) {
		ICFBamTableColObj obj = Obj;
		CFBamTableColBuff buff = obj.getTableColBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableTableCol().createTableCol(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "TBLC" ) ) {
			obj = (ICFBamTableColObj)(obj.realise());
		}
		ICFBamValueObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamTableColObj readTableCol( CFBamValuePKey pkey ) {
		return( readTableCol( pkey, false ) );
	}

	public ICFBamTableColObj readTableCol( CFBamValuePKey pkey, boolean forceRead ) {
		ICFBamTableColObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamTableColBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableTableCol().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamTableColObj)schema.getValueTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamTableColObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamTableColObj lockTableCol( CFBamValuePKey pkey ) {
		ICFBamTableColObj locked = null;
		CFBamTableColBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableTableCol().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamTableColObj)schema.getValueTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamTableColObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockTableCol", pkey );
		}
		return( locked );
	}

	public List<ICFBamTableColObj> readAllTableCol() {
		return( readAllTableCol( false ) );
	}

	public List<ICFBamTableColObj> readAllTableCol( boolean forceRead ) {
		final String S_ProcName = "readAllTableCol";
		if( ( allTableCol == null ) || forceRead ) {
			Map<CFBamValuePKey, ICFBamTableColObj> map = new HashMap<CFBamValuePKey,ICFBamTableColObj>();
			allTableCol = map;
			CFBamTableColBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTableCol().readAllDerived( schema.getAuthorization() );
			CFBamTableColBuff buff;
			ICFBamTableColObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTableColObj realised = (ICFBamTableColObj)obj.realise();
			}
		}
		int len = allTableCol.size();
		ICFBamTableColObj arr[] = new ICFBamTableColObj[len];
		Iterator<ICFBamTableColObj> valIter = allTableCol.values().iterator();
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
		ArrayList<ICFBamTableColObj> arrayList = new ArrayList<ICFBamTableColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTableColObj> cmp = new Comparator<ICFBamTableColObj>() {
			public int compare( ICFBamTableColObj lhs, ICFBamTableColObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamTableColObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTableColObj readTableColByIdIdx( long TenantId,
		long Id )
	{
		return( readTableColByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamTableColObj readTableColByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamValuePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamTableColObj obj = readTableCol( pkey, forceRead );
		return( obj );
	}

	public ICFBamTableColObj readTableColByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		return( readTableColByUNameIdx( TenantId,
			ScopeId,
			Name,
			false ) );
	}

	public ICFBamTableColObj readTableColByUNameIdx( long TenantId,
		long ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamValueByUNameIdxKey,
				ICFBamTableColObj >();
		}
		CFBamValueByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		ICFBamTableColObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamValueBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
			if( buff != null ) {
				obj = (ICFBamTableColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamTableColObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFBamTableColObj> readTableColByValTentIdx( long TenantId )
	{
		return( readTableColByValTentIdx( TenantId,
			false ) );
	}

	public List<ICFBamTableColObj> readTableColByValTentIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableColByValTentIdx";
		CFBamValueByValTentIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamValuePKey, ICFBamTableColObj> dict;
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamValueByValTentIdxKey,
				Map< CFBamValuePKey, ICFBamTableColObj > >();
		}
		if( ( ! forceRead ) && indexByValTentIdx.containsKey( key ) ) {
			dict = indexByValTentIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTableColObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByValTentIdx( schema.getAuthorization(),
				TenantId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTableColObj realised = (ICFBamTableColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByValTentIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTableColObj arr[] = new ICFBamTableColObj[len];
		Iterator<ICFBamTableColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableColObj> arrayList = new ArrayList<ICFBamTableColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTableColObj> cmp = new Comparator<ICFBamTableColObj>() {
			public int compare( ICFBamTableColObj lhs, ICFBamTableColObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamTableColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableColObj> readTableColByScopeIdx( long TenantId,
		long ScopeId )
	{
		return( readTableColByScopeIdx( TenantId,
			ScopeId,
			false ) );
	}

	public List<ICFBamTableColObj> readTableColByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableColByScopeIdx";
		CFBamValueByScopeIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		Map<CFBamValuePKey, ICFBamTableColObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFBamValueByScopeIdxKey,
				Map< CFBamValuePKey, ICFBamTableColObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTableColObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTableColObj realised = (ICFBamTableColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTableColObj arr[] = new ICFBamTableColObj[len];
		Iterator<ICFBamTableColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableColObj> arrayList = new ArrayList<ICFBamTableColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTableColObj> cmp = new Comparator<ICFBamTableColObj>() {
			public int compare( ICFBamTableColObj lhs, ICFBamTableColObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamTableColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableColObj> readTableColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readTableColByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamTableColObj> readTableColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableColByDefSchemaIdx";
		CFBamValueByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamValuePKey, ICFBamTableColObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamValueByDefSchemaIdxKey,
				Map< CFBamValuePKey, ICFBamTableColObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTableColObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTableColObj realised = (ICFBamTableColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTableColObj arr[] = new ICFBamTableColObj[len];
		Iterator<ICFBamTableColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableColObj> arrayList = new ArrayList<ICFBamTableColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTableColObj> cmp = new Comparator<ICFBamTableColObj>() {
			public int compare( ICFBamTableColObj lhs, ICFBamTableColObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamTableColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableColObj> readTableColByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		return( readTableColByPrevIdx( PrevTenantId,
			PrevId,
			false ) );
	}

	public List<ICFBamTableColObj> readTableColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableColByPrevIdx";
		CFBamValueByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamValuePKey, ICFBamTableColObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamValueByPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTableColObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTableColObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTableColObj realised = (ICFBamTableColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTableColObj arr[] = new ICFBamTableColObj[len];
		Iterator<ICFBamTableColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableColObj> arrayList = new ArrayList<ICFBamTableColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTableColObj> cmp = new Comparator<ICFBamTableColObj>() {
			public int compare( ICFBamTableColObj lhs, ICFBamTableColObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamTableColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableColObj> readTableColByNextIdx( Long NextTenantId,
		Long NextId )
	{
		return( readTableColByNextIdx( NextTenantId,
			NextId,
			false ) );
	}

	public List<ICFBamTableColObj> readTableColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableColByNextIdx";
		CFBamValueByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		Map<CFBamValuePKey, ICFBamTableColObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamValueByNextIdxKey,
				Map< CFBamValuePKey, ICFBamTableColObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTableColObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTableColObj realised = (ICFBamTableColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTableColObj arr[] = new ICFBamTableColObj[len];
		Iterator<ICFBamTableColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableColObj> arrayList = new ArrayList<ICFBamTableColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTableColObj> cmp = new Comparator<ICFBamTableColObj>() {
			public int compare( ICFBamTableColObj lhs, ICFBamTableColObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamTableColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableColObj> readTableColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		return( readTableColByContPrevIdx( TenantId,
			ScopeId,
			PrevId,
			false ) );
	}

	public List<ICFBamTableColObj> readTableColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableColByContPrevIdx";
		CFBamValueByContPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamValuePKey, ICFBamTableColObj> dict;
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamValueByContPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTableColObj > >();
		}
		if( ( ! forceRead ) && indexByContPrevIdx.containsKey( key ) ) {
			dict = indexByContPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTableColObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTableColObj realised = (ICFBamTableColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContPrevIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTableColObj arr[] = new ICFBamTableColObj[len];
		Iterator<ICFBamTableColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableColObj> arrayList = new ArrayList<ICFBamTableColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTableColObj> cmp = new Comparator<ICFBamTableColObj>() {
			public int compare( ICFBamTableColObj lhs, ICFBamTableColObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamTableColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableColObj> readTableColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		return( readTableColByContNextIdx( TenantId,
			ScopeId,
			NextId,
			false ) );
	}

	public List<ICFBamTableColObj> readTableColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableColByContNextIdx";
		CFBamValueByContNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		Map<CFBamValuePKey, ICFBamTableColObj> dict;
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamValueByContNextIdxKey,
				Map< CFBamValuePKey, ICFBamTableColObj > >();
		}
		if( ( ! forceRead ) && indexByContNextIdx.containsKey( key ) ) {
			dict = indexByContNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTableColObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTableColObj realised = (ICFBamTableColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContNextIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTableColObj arr[] = new ICFBamTableColObj[len];
		Iterator<ICFBamTableColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableColObj> arrayList = new ArrayList<ICFBamTableColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTableColObj> cmp = new Comparator<ICFBamTableColObj>() {
			public int compare( ICFBamTableColObj lhs, ICFBamTableColObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamTableColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableColObj> readTableColByTableIdx( long TenantId,
		long TableId )
	{
		return( readTableColByTableIdx( TenantId,
			TableId,
			false ) );
	}

	public List<ICFBamTableColObj> readTableColByTableIdx( long TenantId,
		long TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableColByTableIdx";
		CFBamTableColByTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTableCol().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		Map<CFBamValuePKey, ICFBamTableColObj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamTableColByTableIdxKey,
				Map< CFBamValuePKey, ICFBamTableColObj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTableColObj>();
			ICFBamTableColObj obj;
			CFBamTableColBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTableCol().readDerivedByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			CFBamTableColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTableColObj realised = (ICFBamTableColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTableIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTableColObj arr[] = new ICFBamTableColObj[len];
		Iterator<ICFBamTableColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableColObj> arrayList = new ArrayList<ICFBamTableColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTableColObj> cmp = new Comparator<ICFBamTableColObj>() {
			public int compare( ICFBamTableColObj lhs, ICFBamTableColObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamTableColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTableColObj> readTableColByDataIdx( Long DataTenantId,
		Long DataId )
	{
		return( readTableColByDataIdx( DataTenantId,
			DataId,
			false ) );
	}

	public List<ICFBamTableColObj> readTableColByDataIdx( Long DataTenantId,
		Long DataId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableColByDataIdx";
		CFBamTableColByDataIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTableCol().newDataIdxKey();
		key.setOptionalDataTenantId( DataTenantId );
		key.setOptionalDataId( DataId );
		Map<CFBamValuePKey, ICFBamTableColObj> dict;
		if( indexByDataIdx == null ) {
			indexByDataIdx = new HashMap< CFBamTableColByDataIdxKey,
				Map< CFBamValuePKey, ICFBamTableColObj > >();
		}
		if( ( ! forceRead ) && indexByDataIdx.containsKey( key ) ) {
			dict = indexByDataIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTableColObj>();
			ICFBamTableColObj obj;
			CFBamTableColBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTableCol().readDerivedByDataIdx( schema.getAuthorization(),
				DataTenantId,
				DataId );
			CFBamTableColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTableColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTableColObj realised = (ICFBamTableColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDataIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTableColObj arr[] = new ICFBamTableColObj[len];
		Iterator<ICFBamTableColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTableColObj> arrayList = new ArrayList<ICFBamTableColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTableColObj> cmp = new Comparator<ICFBamTableColObj>() {
			public int compare( ICFBamTableColObj lhs, ICFBamTableColObj rhs ) {
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
					CFBamValuePKey lhsPKey = lhs.getPKey();
					CFBamValuePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamTableColObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTableColObj updateTableCol( ICFBamTableColObj Obj ) {
		ICFBamTableColObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableTableCol().updateTableCol( schema.getAuthorization(),
			Obj.getTableColBuff() );
		if( Obj.getClassCode().equals( "TBLC" ) ) {
			obj = (ICFBamTableColObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteTableCol( ICFBamTableColObj Obj ) {
		ICFBamTableColObj obj = Obj;
		ICFBamValueObj prev = obj.getOptionalLookupPrev();
		ICFBamValueObj next = obj.getOptionalLookupNext();
		((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableCol( schema.getAuthorization(),
			obj.getTableColBuff() );
		obj.forget( true );
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	public void deleteTableColByIdIdx( long TenantId,
		long Id )
	{
		CFBamValuePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamTableColObj obj = readTableCol( pkey );
		if( obj != null ) {
			ICFBamTableColEditObj editObj = (ICFBamTableColEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamTableColEditObj)obj.beginEdit();
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

	public void deleteTableColByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamValueByUNameIdxKey,
				ICFBamTableColObj >();
		}
		CFBamValueByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		ICFBamTableColObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
		}
	}

	public void deleteTableColByValTentIdx( long TenantId )
	{
		CFBamValueByValTentIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamValueByValTentIdxKey,
				Map< CFBamValuePKey, ICFBamTableColObj > >();
		}
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTableColObj> dict = indexByValTentIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByValTentIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamTableColObj> iter = dict.values().iterator();
			ICFBamTableColObj obj;
			List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByValTentIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByValTentIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTableColByScopeIdx( long TenantId,
		long ScopeId )
	{
		CFBamValueByScopeIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFBamValueByScopeIdxKey,
				Map< CFBamValuePKey, ICFBamTableColObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTableColObj> dict = indexByScopeIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
			Iterator<ICFBamTableColObj> iter = dict.values().iterator();
			ICFBamTableColObj obj;
			List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByScopeIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
		}
	}

	public void deleteTableColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamValueByDefSchemaIdxKey,
				Map< CFBamValuePKey, ICFBamTableColObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTableColObj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamTableColObj> iter = dict.values().iterator();
			ICFBamTableColObj obj;
			List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteTableColByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		CFBamValueByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamValueByPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTableColObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTableColObj> dict = indexByPrevIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			Iterator<ICFBamTableColObj> iter = dict.values().iterator();
			ICFBamTableColObj obj;
			List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
		}
	}

	public void deleteTableColByNextIdx( Long NextTenantId,
		Long NextId )
	{
		CFBamValueByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamValueByNextIdxKey,
				Map< CFBamValuePKey, ICFBamTableColObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTableColObj> dict = indexByNextIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			Iterator<ICFBamTableColObj> iter = dict.values().iterator();
			ICFBamTableColObj obj;
			List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
		}
	}

	public void deleteTableColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		CFBamValueByContPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamValueByContPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTableColObj > >();
		}
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTableColObj> dict = indexByContPrevIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
			Iterator<ICFBamTableColObj> iter = dict.values().iterator();
			ICFBamTableColObj obj;
			List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByContPrevIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
		}
	}

	public void deleteTableColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		CFBamValueByContNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamValueByContNextIdxKey,
				Map< CFBamValuePKey, ICFBamTableColObj > >();
		}
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTableColObj> dict = indexByContNextIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
			Iterator<ICFBamTableColObj> iter = dict.values().iterator();
			ICFBamTableColObj obj;
			List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByContNextIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
		}
	}

	public void deleteTableColByTableIdx( long TenantId,
		long TableId )
	{
		CFBamTableColByTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTableCol().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamTableColByTableIdxKey,
				Map< CFBamValuePKey, ICFBamTableColObj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTableColObj> dict = indexByTableIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			Iterator<ICFBamTableColObj> iter = dict.values().iterator();
			ICFBamTableColObj obj;
			List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByTableIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
		}
	}

	public void deleteTableColByDataIdx( Long DataTenantId,
		Long DataId )
	{
		CFBamTableColByDataIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTableCol().newDataIdxKey();
		key.setOptionalDataTenantId( DataTenantId );
		key.setOptionalDataId( DataId );
		if( indexByDataIdx == null ) {
			indexByDataIdx = new HashMap< CFBamTableColByDataIdxKey,
				Map< CFBamValuePKey, ICFBamTableColObj > >();
		}
		if( indexByDataIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTableColObj> dict = indexByDataIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByDataIdx( schema.getAuthorization(),
				DataTenantId,
				DataId );
			Iterator<ICFBamTableColObj> iter = dict.values().iterator();
			ICFBamTableColObj obj;
			List<ICFBamTableColObj> toForget = new LinkedList<ICFBamTableColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByDataIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTableCol().deleteTableColByDataIdx( schema.getAuthorization(),
				DataTenantId,
				DataId );
		}
	}

	/**
	 *	Move the CFBamTableColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTableColObj refreshed cache instance.
	 */
	public ICFBamTableColObj moveUpTableCol( ICFBamTableColObj Obj ) {
		ICFBamTableColObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveUpTableCol",
				"You cannot move an object that is being edited" );
		}
		CFBamTableColBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableTableCol().moveBuffUp( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getTableColTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamTableColObj)obj.realise();
			ICFBamValueObj prev = obj.getOptionalLookupPrev( true );
			ICFBamValueObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				ICFBamValueObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the CFBamTableColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTableColObj refreshed cache instance.
	 */
	public ICFBamTableColObj moveDownTableCol( ICFBamTableColObj Obj ) {
		ICFBamTableColObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveDownTableCol",
				"You cannot move an object that is being edited" );
		}
		CFBamTableColBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableTableCol().moveBuffDown( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getTableColTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamTableColObj)obj.realise();
			ICFBamValueObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				ICFBamValueObj gprev = prev.getOptionalLookupPrev( true );
			}
			ICFBamValueObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}
