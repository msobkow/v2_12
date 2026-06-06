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

public class CFBamTZTimestampTypeTableObj
	implements ICFBamTZTimestampTypeTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> members;
	private Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> allTZTimestampType;
	private Map< CFBamValueByUNameIdxKey,
		ICFBamTZTimestampTypeObj > indexByUNameIdx;
	private Map< CFBamValueByValTentIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByValTentIdx;
	private Map< CFBamValueByScopeIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByScopeIdx;
	private Map< CFBamValueByDefSchemaIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByDefSchemaIdx;
	private Map< CFBamValueByPrevIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByPrevIdx;
	private Map< CFBamValueByNextIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByNextIdx;
	private Map< CFBamValueByContPrevIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByContPrevIdx;
	private Map< CFBamValueByContNextIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexByContNextIdx;
	private Map< CFBamTZTimestampTypeBySchemaIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > > indexBySchemaIdx;
	public static String TABLE_NAME = "TZTimestampType";
	public static String TABLE_DBNAME = "zstyp";

	public CFBamTZTimestampTypeTableObj() {
		schema = null;
		members = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
		allTZTimestampType = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexBySchemaIdx = null;
	}

	public CFBamTZTimestampTypeTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
		allTZTimestampType = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexBySchemaIdx = null;
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
		allTZTimestampType = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexBySchemaIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTZTimestampTypeObj.
	 */
	public ICFBamTZTimestampTypeObj newInstance() {
		ICFBamTZTimestampTypeObj inst = new CFBamTZTimestampTypeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTZTimestampTypeObj.
	 */
	public ICFBamTZTimestampTypeEditObj newEditInstance( ICFBamTZTimestampTypeObj orig ) {
		ICFBamTZTimestampTypeEditObj edit = new CFBamTZTimestampTypeEditObj( orig );
		return( edit );
	}

	public ICFBamTZTimestampTypeObj realiseTZTimestampType( ICFBamTZTimestampTypeObj Obj ) {
		ICFBamTZTimestampTypeObj obj = Obj;
		CFBamValuePKey pkey = obj.getPKey();
		ICFBamTZTimestampTypeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamTZTimestampTypeObj existingObj = members.get( pkey );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamTZTimestampTypeBySchemaIdxKey keySchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTZTimestampType().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.remove( keepObj.getPKey() );
					if( mapSchemaIdx.size() <= 0 ) {
						indexBySchemaIdx.remove( keySchemaIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamTZTimestampTypeObj)schema.getTZTimestampDefTableObj().realiseTZTimestampDef( Obj );

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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamTZTimestampTypeBySchemaIdxKey keySchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTZTimestampType().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allTZTimestampType != null ) {
				allTZTimestampType.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamTZTimestampTypeObj)schema.getTZTimestampDefTableObj().realiseTZTimestampDef( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTZTimestampType != null ) {
				allTZTimestampType.put( keepObj.getPKey(), keepObj );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamTZTimestampTypeBySchemaIdxKey keySchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTZTimestampType().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetTZTimestampType( ICFBamTZTimestampTypeObj Obj ) {
		forgetTZTimestampType( Obj, false );
	}

	public void forgetTZTimestampType( ICFBamTZTimestampTypeObj Obj, boolean forgetSubObjects ) {
		ICFBamTZTimestampTypeObj obj = Obj;
		CFBamValuePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamTZTimestampTypeObj keepObj = members.get( pkey );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamTZTimestampTypeBySchemaIdxKey keySchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTZTimestampType().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.remove( keepObj.getPKey() );
					if( mapSchemaIdx.size() <= 0 ) {
						indexBySchemaIdx.remove( keySchemaIdx );
					}
				}
			}

			if( allTZTimestampType != null ) {
				allTZTimestampType.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		((ICFBamSchemaObj)schema).getTZTimestampDefTableObj().forgetTZTimestampDef( obj );
	}

	public void forgetTZTimestampTypeByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamValuePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamTZTimestampTypeObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTZTimestampTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
		ICFBamTZTimestampTypeObj cur = null;
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
		Iterator<ICFBamTZTimestampTypeObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTZTimestampTypeByValTentIdx( long TenantId )
	{
		if( indexByValTentIdx == null ) {
			return;
		}
		List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
		ICFBamTZTimestampTypeObj cur = null;
		CFBamValueByValTentIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapValTentIdx = indexByValTentIdx.get( key );
			if( mapValTentIdx != null ) {
				Iterator<ICFBamTZTimestampTypeObj> iterDup = mapValTentIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByValTentIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTZTimestampTypeObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTZTimestampTypeObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTZTimestampTypeByScopeIdx( long TenantId,
		long ScopeId )
	{
		if( indexByScopeIdx == null ) {
			return;
		}
		List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
		ICFBamTZTimestampTypeObj cur = null;
		CFBamValueByScopeIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapScopeIdx = indexByScopeIdx.get( key );
			if( mapScopeIdx != null ) {
				Iterator<ICFBamTZTimestampTypeObj> iterDup = mapScopeIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByScopeIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTZTimestampTypeObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTZTimestampTypeObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTZTimestampTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
		ICFBamTZTimestampTypeObj cur = null;
		CFBamValueByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamTZTimestampTypeObj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTZTimestampTypeObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTZTimestampTypeObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTZTimestampTypeByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		if( indexByPrevIdx == null ) {
			return;
		}
		List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
		ICFBamTZTimestampTypeObj cur = null;
		CFBamValueByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapPrevIdx = indexByPrevIdx.get( key );
			if( mapPrevIdx != null ) {
				Iterator<ICFBamTZTimestampTypeObj> iterDup = mapPrevIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByPrevIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTZTimestampTypeObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTZTimestampTypeObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTZTimestampTypeByNextIdx( Long NextTenantId,
		Long NextId )
	{
		if( indexByNextIdx == null ) {
			return;
		}
		List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
		ICFBamTZTimestampTypeObj cur = null;
		CFBamValueByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapNextIdx = indexByNextIdx.get( key );
			if( mapNextIdx != null ) {
				Iterator<ICFBamTZTimestampTypeObj> iterDup = mapNextIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByNextIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTZTimestampTypeObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTZTimestampTypeObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTZTimestampTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		if( indexByContPrevIdx == null ) {
			return;
		}
		List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
		ICFBamTZTimestampTypeObj cur = null;
		CFBamValueByContPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContPrevIdx = indexByContPrevIdx.get( key );
			if( mapContPrevIdx != null ) {
				Iterator<ICFBamTZTimestampTypeObj> iterDup = mapContPrevIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByContPrevIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTZTimestampTypeObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTZTimestampTypeObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTZTimestampTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		if( indexByContNextIdx == null ) {
			return;
		}
		List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
		ICFBamTZTimestampTypeObj cur = null;
		CFBamValueByContNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapContNextIdx = indexByContNextIdx.get( key );
			if( mapContNextIdx != null ) {
				Iterator<ICFBamTZTimestampTypeObj> iterDup = mapContNextIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByContNextIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTZTimestampTypeObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTZTimestampTypeObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTZTimestampTypeBySchemaIdx( long TenantId,
		long SchemaDefId )
	{
		if( indexBySchemaIdx == null ) {
			return;
		}
		List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
		ICFBamTZTimestampTypeObj cur = null;
		CFBamTZTimestampTypeBySchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTZTimestampType().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		if( indexBySchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj > mapSchemaIdx = indexBySchemaIdx.get( key );
			if( mapSchemaIdx != null ) {
				Iterator<ICFBamTZTimestampTypeObj> iterDup = mapSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexBySchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamTZTimestampTypeObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamTZTimestampTypeObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamTZTimestampTypeObj createTZTimestampType( ICFBamTZTimestampTypeObj Obj ) {
		ICFBamTZTimestampTypeObj obj = Obj;
		CFBamTZTimestampTypeBuff buff = obj.getTZTimestampTypeBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().createTZTimestampType(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "ZSTT" ) ) {
			obj = (ICFBamTZTimestampTypeObj)(obj.realise());
		}
		ICFBamValueObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamTZTimestampTypeObj readTZTimestampType( CFBamValuePKey pkey ) {
		return( readTZTimestampType( pkey, false ) );
	}

	public ICFBamTZTimestampTypeObj readTZTimestampType( CFBamValuePKey pkey, boolean forceRead ) {
		ICFBamTZTimestampTypeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamTZTimestampTypeBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamTZTimestampTypeObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamTZTimestampTypeObj lockTZTimestampType( CFBamValuePKey pkey ) {
		ICFBamTZTimestampTypeObj locked = null;
		CFBamTZTimestampTypeBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamTZTimestampTypeObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockTZTimestampType", pkey );
		}
		return( locked );
	}

	public List<ICFBamTZTimestampTypeObj> readAllTZTimestampType() {
		return( readAllTZTimestampType( false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readAllTZTimestampType( boolean forceRead ) {
		final String S_ProcName = "readAllTZTimestampType";
		if( ( allTZTimestampType == null ) || forceRead ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> map = new HashMap<CFBamValuePKey,ICFBamTZTimestampTypeObj>();
			allTZTimestampType = map;
			CFBamTZTimestampTypeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().readAllDerived( schema.getAuthorization() );
			CFBamTZTimestampTypeBuff buff;
			ICFBamTZTimestampTypeObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realised = (ICFBamTZTimestampTypeObj)obj.realise();
			}
		}
		int len = allTZTimestampType.size();
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = allTZTimestampType.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTZTimestampTypeObj readTZTimestampTypeByIdIdx( long TenantId,
		long Id )
	{
		return( readTZTimestampTypeByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamTZTimestampTypeObj readTZTimestampTypeByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamValuePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamTZTimestampTypeObj obj = readTZTimestampType( pkey, forceRead );
		return( obj );
	}

	public ICFBamTZTimestampTypeObj readTZTimestampTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		return( readTZTimestampTypeByUNameIdx( TenantId,
			ScopeId,
			Name,
			false ) );
	}

	public ICFBamTZTimestampTypeObj readTZTimestampTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamValueByUNameIdxKey,
				ICFBamTZTimestampTypeObj >();
		}
		CFBamValueByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		ICFBamTZTimestampTypeObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamValueBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
			if( buff != null ) {
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamTZTimestampTypeObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByValTentIdx( long TenantId )
	{
		return( readTZTimestampTypeByValTentIdx( TenantId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByValTentIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByValTentIdx";
		CFBamValueByValTentIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamValueByValTentIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByValTentIdx.containsKey( key ) ) {
			dict = indexByValTentIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByValTentIdx( schema.getAuthorization(),
				TenantId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realised = (ICFBamTZTimestampTypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByValTentIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByScopeIdx( long TenantId,
		long ScopeId )
	{
		return( readTZTimestampTypeByScopeIdx( TenantId,
			ScopeId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByScopeIdx";
		CFBamValueByScopeIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFBamValueByScopeIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realised = (ICFBamTZTimestampTypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readTZTimestampTypeByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByDefSchemaIdx";
		CFBamValueByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamValueByDefSchemaIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realised = (ICFBamTZTimestampTypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		return( readTZTimestampTypeByPrevIdx( PrevTenantId,
			PrevId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByPrevIdx";
		CFBamValueByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamValueByPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realised = (ICFBamTZTimestampTypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByNextIdx( Long NextTenantId,
		Long NextId )
	{
		return( readTZTimestampTypeByNextIdx( NextTenantId,
			NextId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByNextIdx";
		CFBamValueByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamValueByNextIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realised = (ICFBamTZTimestampTypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		return( readTZTimestampTypeByContPrevIdx( TenantId,
			ScopeId,
			PrevId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByContPrevIdx";
		CFBamValueByContPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamValueByContPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByContPrevIdx.containsKey( key ) ) {
			dict = indexByContPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realised = (ICFBamTZTimestampTypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContPrevIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		return( readTZTimestampTypeByContNextIdx( TenantId,
			ScopeId,
			NextId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeByContNextIdx";
		CFBamValueByContNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamValueByContNextIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexByContNextIdx.containsKey( key ) ) {
			dict = indexByContNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realised = (ICFBamTZTimestampTypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContNextIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeBySchemaIdx( long TenantId,
		long SchemaDefId )
	{
		return( readTZTimestampTypeBySchemaIdx( TenantId,
			SchemaDefId,
			false ) );
	}

	public List<ICFBamTZTimestampTypeObj> readTZTimestampTypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampTypeBySchemaIdx";
		CFBamTZTimestampTypeBySchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTZTimestampType().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict;
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< CFBamTZTimestampTypeBySchemaIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( ( ! forceRead ) && indexBySchemaIdx.containsKey( key ) ) {
			dict = indexBySchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampTypeObj>();
			ICFBamTZTimestampTypeObj obj;
			CFBamTZTimestampTypeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().readDerivedBySchemaIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId );
			CFBamTZTimestampTypeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampTypeObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampTypeObj realised = (ICFBamTZTimestampTypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamTZTimestampTypeObj arr[] = new ICFBamTZTimestampTypeObj[len];
		Iterator<ICFBamTZTimestampTypeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampTypeObj> arrayList = new ArrayList<ICFBamTZTimestampTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamTZTimestampTypeObj> cmp = new Comparator<ICFBamTZTimestampTypeObj>() {
			public int compare( ICFBamTZTimestampTypeObj lhs, ICFBamTZTimestampTypeObj rhs ) {
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
		List<ICFBamTZTimestampTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTZTimestampTypeObj updateTZTimestampType( ICFBamTZTimestampTypeObj Obj ) {
		ICFBamTZTimestampTypeObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().updateTZTimestampType( schema.getAuthorization(),
			Obj.getTZTimestampTypeBuff() );
		if( Obj.getClassCode().equals( "ZSTT" ) ) {
			obj = (ICFBamTZTimestampTypeObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteTZTimestampType( ICFBamTZTimestampTypeObj Obj ) {
		ICFBamTZTimestampTypeObj obj = Obj;
		ICFBamValueObj prev = obj.getOptionalLookupPrev();
		ICFBamValueObj next = obj.getOptionalLookupNext();
		((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampType( schema.getAuthorization(),
			obj.getTZTimestampTypeBuff() );
		obj.forget( true );
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	public void deleteTZTimestampTypeByIdIdx( long TenantId,
		long Id )
	{
		CFBamValuePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamTZTimestampTypeObj obj = readTZTimestampType( pkey );
		if( obj != null ) {
			ICFBamTZTimestampTypeEditObj editObj = (ICFBamTZTimestampTypeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamTZTimestampTypeEditObj)obj.beginEdit();
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

	public void deleteTZTimestampTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamValueByUNameIdxKey,
				ICFBamTZTimestampTypeObj >();
		}
		CFBamValueByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		ICFBamTZTimestampTypeObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampTypeByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampTypeByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
		}
	}

	public void deleteTZTimestampTypeByValTentIdx( long TenantId )
	{
		CFBamValueByValTentIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamValueByValTentIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByValTentIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampTypeByValTentIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampTypeByValTentIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTZTimestampTypeByScopeIdx( long TenantId,
		long ScopeId )
	{
		CFBamValueByScopeIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFBamValueByScopeIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByScopeIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampTypeByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampTypeByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
		}
	}

	public void deleteTZTimestampTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamValueByDefSchemaIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampTypeByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampTypeByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteTZTimestampTypeByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		CFBamValueByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamValueByPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByPrevIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampTypeByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampTypeByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
		}
	}

	public void deleteTZTimestampTypeByNextIdx( Long NextTenantId,
		Long NextId )
	{
		CFBamValueByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamValueByNextIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByNextIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampTypeByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampTypeByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
		}
	}

	public void deleteTZTimestampTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		CFBamValueByContPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamValueByContPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByContPrevIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampTypeByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampTypeByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
		}
	}

	public void deleteTZTimestampTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		CFBamValueByContNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamValueByContNextIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexByContNextIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampTypeByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampTypeByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
		}
	}

	public void deleteTZTimestampTypeBySchemaIdx( long TenantId,
		long SchemaDefId )
	{
		CFBamTZTimestampTypeBySchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTZTimestampType().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< CFBamTZTimestampTypeBySchemaIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampTypeObj > >();
		}
		if( indexBySchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampTypeObj> dict = indexBySchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampTypeBySchemaIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId );
			Iterator<ICFBamTZTimestampTypeObj> iter = dict.values().iterator();
			ICFBamTZTimestampTypeObj obj;
			List<ICFBamTZTimestampTypeObj> toForget = new LinkedList<ICFBamTZTimestampTypeObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexBySchemaIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().deleteTZTimestampTypeBySchemaIdx( schema.getAuthorization(),
				TenantId,
				SchemaDefId );
		}
	}

	/**
	 *	Move the CFBamTZTimestampTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZTimestampTypeObj refreshed cache instance.
	 */
	public ICFBamTZTimestampTypeObj moveUpTZTimestampType( ICFBamTZTimestampTypeObj Obj ) {
		ICFBamTZTimestampTypeObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveUpTZTimestampType",
				"You cannot move an object that is being edited" );
		}
		CFBamTZTimestampTypeBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().moveBuffUp( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getTZTimestampTypeTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamTZTimestampTypeObj)obj.realise();
			ICFBamValueObj prev = obj.getOptionalLookupPrev( true );
			ICFBamValueObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				ICFBamValueObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the CFBamTZTimestampTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZTimestampTypeObj refreshed cache instance.
	 */
	public ICFBamTZTimestampTypeObj moveDownTZTimestampType( ICFBamTZTimestampTypeObj Obj ) {
		ICFBamTZTimestampTypeObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveDownTZTimestampType",
				"You cannot move an object that is being edited" );
		}
		CFBamTZTimestampTypeBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableTZTimestampType().moveBuffDown( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getTZTimestampTypeTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamTZTimestampTypeObj)obj.realise();
			ICFBamValueObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				ICFBamValueObj gprev = prev.getOptionalLookupPrev( true );
			}
			ICFBamValueObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}
