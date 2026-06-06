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

public class CFBamInt16ColTableObj
	implements ICFBamInt16ColTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamValuePKey, ICFBamInt16ColObj> members;
	private Map<CFBamValuePKey, ICFBamInt16ColObj> allInt16Col;
	private Map< CFBamValueByUNameIdxKey,
		ICFBamInt16ColObj > indexByUNameIdx;
	private Map< CFBamValueByValTentIdxKey,
		Map<CFBamValuePKey, ICFBamInt16ColObj > > indexByValTentIdx;
	private Map< CFBamValueByScopeIdxKey,
		Map<CFBamValuePKey, ICFBamInt16ColObj > > indexByScopeIdx;
	private Map< CFBamValueByDefSchemaIdxKey,
		Map<CFBamValuePKey, ICFBamInt16ColObj > > indexByDefSchemaIdx;
	private Map< CFBamValueByPrevIdxKey,
		Map<CFBamValuePKey, ICFBamInt16ColObj > > indexByPrevIdx;
	private Map< CFBamValueByNextIdxKey,
		Map<CFBamValuePKey, ICFBamInt16ColObj > > indexByNextIdx;
	private Map< CFBamValueByContPrevIdxKey,
		Map<CFBamValuePKey, ICFBamInt16ColObj > > indexByContPrevIdx;
	private Map< CFBamValueByContNextIdxKey,
		Map<CFBamValuePKey, ICFBamInt16ColObj > > indexByContNextIdx;
	private Map< CFBamInt16ColByTableIdxKey,
		Map<CFBamValuePKey, ICFBamInt16ColObj > > indexByTableIdx;
	public static String TABLE_NAME = "Int16Col";
	public static String TABLE_DBNAME = "int16col";

	public CFBamInt16ColTableObj() {
		schema = null;
		members = new HashMap<CFBamValuePKey, ICFBamInt16ColObj>();
		allInt16Col = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexByTableIdx = null;
	}

	public CFBamInt16ColTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamValuePKey, ICFBamInt16ColObj>();
		allInt16Col = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexByTableIdx = null;
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
		allInt16Col = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexByTableIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamInt16ColObj.
	 */
	public ICFBamInt16ColObj newInstance() {
		ICFBamInt16ColObj inst = new CFBamInt16ColObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamInt16ColObj.
	 */
	public ICFBamInt16ColEditObj newEditInstance( ICFBamInt16ColObj orig ) {
		ICFBamInt16ColEditObj edit = new CFBamInt16ColEditObj( orig );
		return( edit );
	}

	public ICFBamInt16ColObj realiseInt16Col( ICFBamInt16ColObj Obj ) {
		ICFBamInt16ColObj obj = Obj;
		CFBamValuePKey pkey = obj.getPKey();
		ICFBamInt16ColObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamInt16ColObj existingObj = members.get( pkey );
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
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamInt16ColByTableIdxKey keyTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryInt16Col().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.remove( keepObj.getPKey() );
					if( mapTableIdx.size() <= 0 ) {
						indexByTableIdx.remove( keyTableIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamInt16ColObj)schema.getInt16DefTableObj().realiseInt16Def( Obj );

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
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamInt16ColByTableIdxKey keyTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryInt16Col().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allInt16Col != null ) {
				allInt16Col.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamInt16ColObj)schema.getInt16DefTableObj().realiseInt16Def( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allInt16Col != null ) {
				allInt16Col.put( keepObj.getPKey(), keepObj );
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
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamInt16ColByTableIdxKey keyTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryInt16Col().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetInt16Col( ICFBamInt16ColObj Obj ) {
		forgetInt16Col( Obj, false );
	}

	public void forgetInt16Col( ICFBamInt16ColObj Obj, boolean forgetSubObjects ) {
		ICFBamInt16ColObj obj = Obj;
		CFBamValuePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamInt16ColObj keepObj = members.get( pkey );
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
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamInt16ColByTableIdxKey keyTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryInt16Col().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamValuePKey, ICFBamInt16ColObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.remove( keepObj.getPKey() );
					if( mapTableIdx.size() <= 0 ) {
						indexByTableIdx.remove( keyTableIdx );
					}
				}
			}

			if( allInt16Col != null ) {
				allInt16Col.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		((ICFBamSchemaObj)schema).getInt16DefTableObj().forgetInt16Def( obj );
	}

	public void forgetInt16ColByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamValuePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamInt16ColObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetInt16ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamInt16ColObj> toForget = new LinkedList<ICFBamInt16ColObj>();
		ICFBamInt16ColObj cur = null;
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
		Iterator<ICFBamInt16ColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetInt16ColByValTentIdx( long TenantId )
	{
		if( indexByValTentIdx == null ) {
			return;
		}
		List<ICFBamInt16ColObj> toForget = new LinkedList<ICFBamInt16ColObj>();
		ICFBamInt16ColObj cur = null;
		CFBamValueByValTentIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16ColObj > mapValTentIdx = indexByValTentIdx.get( key );
			if( mapValTentIdx != null ) {
				Iterator<ICFBamInt16ColObj> iterDup = mapValTentIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByValTentIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamInt16ColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamInt16ColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetInt16ColByScopeIdx( long TenantId,
		long ScopeId )
	{
		if( indexByScopeIdx == null ) {
			return;
		}
		List<ICFBamInt16ColObj> toForget = new LinkedList<ICFBamInt16ColObj>();
		ICFBamInt16ColObj cur = null;
		CFBamValueByScopeIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16ColObj > mapScopeIdx = indexByScopeIdx.get( key );
			if( mapScopeIdx != null ) {
				Iterator<ICFBamInt16ColObj> iterDup = mapScopeIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByScopeIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamInt16ColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamInt16ColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetInt16ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamInt16ColObj> toForget = new LinkedList<ICFBamInt16ColObj>();
		ICFBamInt16ColObj cur = null;
		CFBamValueByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16ColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamInt16ColObj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamInt16ColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamInt16ColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetInt16ColByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		if( indexByPrevIdx == null ) {
			return;
		}
		List<ICFBamInt16ColObj> toForget = new LinkedList<ICFBamInt16ColObj>();
		ICFBamInt16ColObj cur = null;
		CFBamValueByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16ColObj > mapPrevIdx = indexByPrevIdx.get( key );
			if( mapPrevIdx != null ) {
				Iterator<ICFBamInt16ColObj> iterDup = mapPrevIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByPrevIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamInt16ColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamInt16ColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetInt16ColByNextIdx( Long NextTenantId,
		Long NextId )
	{
		if( indexByNextIdx == null ) {
			return;
		}
		List<ICFBamInt16ColObj> toForget = new LinkedList<ICFBamInt16ColObj>();
		ICFBamInt16ColObj cur = null;
		CFBamValueByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16ColObj > mapNextIdx = indexByNextIdx.get( key );
			if( mapNextIdx != null ) {
				Iterator<ICFBamInt16ColObj> iterDup = mapNextIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByNextIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamInt16ColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamInt16ColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetInt16ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		if( indexByContPrevIdx == null ) {
			return;
		}
		List<ICFBamInt16ColObj> toForget = new LinkedList<ICFBamInt16ColObj>();
		ICFBamInt16ColObj cur = null;
		CFBamValueByContPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16ColObj > mapContPrevIdx = indexByContPrevIdx.get( key );
			if( mapContPrevIdx != null ) {
				Iterator<ICFBamInt16ColObj> iterDup = mapContPrevIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByContPrevIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamInt16ColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamInt16ColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetInt16ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		if( indexByContNextIdx == null ) {
			return;
		}
		List<ICFBamInt16ColObj> toForget = new LinkedList<ICFBamInt16ColObj>();
		ICFBamInt16ColObj cur = null;
		CFBamValueByContNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16ColObj > mapContNextIdx = indexByContNextIdx.get( key );
			if( mapContNextIdx != null ) {
				Iterator<ICFBamInt16ColObj> iterDup = mapContNextIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByContNextIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamInt16ColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamInt16ColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetInt16ColByTableIdx( long TenantId,
		long TableId )
	{
		if( indexByTableIdx == null ) {
			return;
		}
		List<ICFBamInt16ColObj> toForget = new LinkedList<ICFBamInt16ColObj>();
		ICFBamInt16ColObj cur = null;
		CFBamInt16ColByTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryInt16Col().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16ColObj > mapTableIdx = indexByTableIdx.get( key );
			if( mapTableIdx != null ) {
				Iterator<ICFBamInt16ColObj> iterDup = mapTableIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTableIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamInt16ColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamInt16ColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamInt16ColObj createInt16Col( ICFBamInt16ColObj Obj ) {
		ICFBamInt16ColObj obj = Obj;
		CFBamInt16ColBuff buff = obj.getInt16ColBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().createInt16Col(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "I16C" ) ) {
			obj = (ICFBamInt16ColObj)(obj.realise());
		}
		ICFBamValueObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamInt16ColObj readInt16Col( CFBamValuePKey pkey ) {
		return( readInt16Col( pkey, false ) );
	}

	public ICFBamInt16ColObj readInt16Col( CFBamValuePKey pkey, boolean forceRead ) {
		ICFBamInt16ColObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamInt16ColBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamInt16ColObj)schema.getValueTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamInt16ColObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamInt16ColObj lockInt16Col( CFBamValuePKey pkey ) {
		ICFBamInt16ColObj locked = null;
		CFBamInt16ColBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamInt16ColObj)schema.getValueTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamInt16ColObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockInt16Col", pkey );
		}
		return( locked );
	}

	public List<ICFBamInt16ColObj> readAllInt16Col() {
		return( readAllInt16Col( false ) );
	}

	public List<ICFBamInt16ColObj> readAllInt16Col( boolean forceRead ) {
		final String S_ProcName = "readAllInt16Col";
		if( ( allInt16Col == null ) || forceRead ) {
			Map<CFBamValuePKey, ICFBamInt16ColObj> map = new HashMap<CFBamValuePKey,ICFBamInt16ColObj>();
			allInt16Col = map;
			CFBamInt16ColBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().readAllDerived( schema.getAuthorization() );
			CFBamInt16ColBuff buff;
			ICFBamInt16ColObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamInt16ColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamInt16ColObj realised = (ICFBamInt16ColObj)obj.realise();
			}
		}
		int len = allInt16Col.size();
		ICFBamInt16ColObj arr[] = new ICFBamInt16ColObj[len];
		Iterator<ICFBamInt16ColObj> valIter = allInt16Col.values().iterator();
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
		ArrayList<ICFBamInt16ColObj> arrayList = new ArrayList<ICFBamInt16ColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamInt16ColObj> cmp = new Comparator<ICFBamInt16ColObj>() {
			public int compare( ICFBamInt16ColObj lhs, ICFBamInt16ColObj rhs ) {
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
		List<ICFBamInt16ColObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamInt16ColObj readInt16ColByIdIdx( long TenantId,
		long Id )
	{
		return( readInt16ColByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamInt16ColObj readInt16ColByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamValuePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamInt16ColObj obj = readInt16Col( pkey, forceRead );
		return( obj );
	}

	public ICFBamInt16ColObj readInt16ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		return( readInt16ColByUNameIdx( TenantId,
			ScopeId,
			Name,
			false ) );
	}

	public ICFBamInt16ColObj readInt16ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamValueByUNameIdxKey,
				ICFBamInt16ColObj >();
		}
		CFBamValueByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		ICFBamInt16ColObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamValueBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
			if( buff != null ) {
				obj = (ICFBamInt16ColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamInt16ColObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFBamInt16ColObj> readInt16ColByValTentIdx( long TenantId )
	{
		return( readInt16ColByValTentIdx( TenantId,
			false ) );
	}

	public List<ICFBamInt16ColObj> readInt16ColByValTentIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readInt16ColByValTentIdx";
		CFBamValueByValTentIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamValuePKey, ICFBamInt16ColObj> dict;
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamValueByValTentIdxKey,
				Map< CFBamValuePKey, ICFBamInt16ColObj > >();
		}
		if( ( ! forceRead ) && indexByValTentIdx.containsKey( key ) ) {
			dict = indexByValTentIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamInt16ColObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByValTentIdx( schema.getAuthorization(),
				TenantId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamInt16ColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamInt16ColObj realised = (ICFBamInt16ColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByValTentIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamInt16ColObj arr[] = new ICFBamInt16ColObj[len];
		Iterator<ICFBamInt16ColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamInt16ColObj> arrayList = new ArrayList<ICFBamInt16ColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamInt16ColObj> cmp = new Comparator<ICFBamInt16ColObj>() {
			public int compare( ICFBamInt16ColObj lhs, ICFBamInt16ColObj rhs ) {
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
		List<ICFBamInt16ColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamInt16ColObj> readInt16ColByScopeIdx( long TenantId,
		long ScopeId )
	{
		return( readInt16ColByScopeIdx( TenantId,
			ScopeId,
			false ) );
	}

	public List<ICFBamInt16ColObj> readInt16ColByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readInt16ColByScopeIdx";
		CFBamValueByScopeIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		Map<CFBamValuePKey, ICFBamInt16ColObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFBamValueByScopeIdxKey,
				Map< CFBamValuePKey, ICFBamInt16ColObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamInt16ColObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamInt16ColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamInt16ColObj realised = (ICFBamInt16ColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamInt16ColObj arr[] = new ICFBamInt16ColObj[len];
		Iterator<ICFBamInt16ColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamInt16ColObj> arrayList = new ArrayList<ICFBamInt16ColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamInt16ColObj> cmp = new Comparator<ICFBamInt16ColObj>() {
			public int compare( ICFBamInt16ColObj lhs, ICFBamInt16ColObj rhs ) {
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
		List<ICFBamInt16ColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamInt16ColObj> readInt16ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readInt16ColByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamInt16ColObj> readInt16ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readInt16ColByDefSchemaIdx";
		CFBamValueByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamValuePKey, ICFBamInt16ColObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamValueByDefSchemaIdxKey,
				Map< CFBamValuePKey, ICFBamInt16ColObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamInt16ColObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamInt16ColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamInt16ColObj realised = (ICFBamInt16ColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamInt16ColObj arr[] = new ICFBamInt16ColObj[len];
		Iterator<ICFBamInt16ColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamInt16ColObj> arrayList = new ArrayList<ICFBamInt16ColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamInt16ColObj> cmp = new Comparator<ICFBamInt16ColObj>() {
			public int compare( ICFBamInt16ColObj lhs, ICFBamInt16ColObj rhs ) {
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
		List<ICFBamInt16ColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamInt16ColObj> readInt16ColByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		return( readInt16ColByPrevIdx( PrevTenantId,
			PrevId,
			false ) );
	}

	public List<ICFBamInt16ColObj> readInt16ColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readInt16ColByPrevIdx";
		CFBamValueByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamValuePKey, ICFBamInt16ColObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamValueByPrevIdxKey,
				Map< CFBamValuePKey, ICFBamInt16ColObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamInt16ColObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamInt16ColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamInt16ColObj realised = (ICFBamInt16ColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamInt16ColObj arr[] = new ICFBamInt16ColObj[len];
		Iterator<ICFBamInt16ColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamInt16ColObj> arrayList = new ArrayList<ICFBamInt16ColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamInt16ColObj> cmp = new Comparator<ICFBamInt16ColObj>() {
			public int compare( ICFBamInt16ColObj lhs, ICFBamInt16ColObj rhs ) {
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
		List<ICFBamInt16ColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamInt16ColObj> readInt16ColByNextIdx( Long NextTenantId,
		Long NextId )
	{
		return( readInt16ColByNextIdx( NextTenantId,
			NextId,
			false ) );
	}

	public List<ICFBamInt16ColObj> readInt16ColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readInt16ColByNextIdx";
		CFBamValueByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		Map<CFBamValuePKey, ICFBamInt16ColObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamValueByNextIdxKey,
				Map< CFBamValuePKey, ICFBamInt16ColObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamInt16ColObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamInt16ColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamInt16ColObj realised = (ICFBamInt16ColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamInt16ColObj arr[] = new ICFBamInt16ColObj[len];
		Iterator<ICFBamInt16ColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamInt16ColObj> arrayList = new ArrayList<ICFBamInt16ColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamInt16ColObj> cmp = new Comparator<ICFBamInt16ColObj>() {
			public int compare( ICFBamInt16ColObj lhs, ICFBamInt16ColObj rhs ) {
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
		List<ICFBamInt16ColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamInt16ColObj> readInt16ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		return( readInt16ColByContPrevIdx( TenantId,
			ScopeId,
			PrevId,
			false ) );
	}

	public List<ICFBamInt16ColObj> readInt16ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readInt16ColByContPrevIdx";
		CFBamValueByContPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamValuePKey, ICFBamInt16ColObj> dict;
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamValueByContPrevIdxKey,
				Map< CFBamValuePKey, ICFBamInt16ColObj > >();
		}
		if( ( ! forceRead ) && indexByContPrevIdx.containsKey( key ) ) {
			dict = indexByContPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamInt16ColObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamInt16ColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamInt16ColObj realised = (ICFBamInt16ColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContPrevIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamInt16ColObj arr[] = new ICFBamInt16ColObj[len];
		Iterator<ICFBamInt16ColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamInt16ColObj> arrayList = new ArrayList<ICFBamInt16ColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamInt16ColObj> cmp = new Comparator<ICFBamInt16ColObj>() {
			public int compare( ICFBamInt16ColObj lhs, ICFBamInt16ColObj rhs ) {
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
		List<ICFBamInt16ColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamInt16ColObj> readInt16ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		return( readInt16ColByContNextIdx( TenantId,
			ScopeId,
			NextId,
			false ) );
	}

	public List<ICFBamInt16ColObj> readInt16ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readInt16ColByContNextIdx";
		CFBamValueByContNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		Map<CFBamValuePKey, ICFBamInt16ColObj> dict;
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamValueByContNextIdxKey,
				Map< CFBamValuePKey, ICFBamInt16ColObj > >();
		}
		if( ( ! forceRead ) && indexByContNextIdx.containsKey( key ) ) {
			dict = indexByContNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamInt16ColObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamInt16ColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamInt16ColObj realised = (ICFBamInt16ColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContNextIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamInt16ColObj arr[] = new ICFBamInt16ColObj[len];
		Iterator<ICFBamInt16ColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamInt16ColObj> arrayList = new ArrayList<ICFBamInt16ColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamInt16ColObj> cmp = new Comparator<ICFBamInt16ColObj>() {
			public int compare( ICFBamInt16ColObj lhs, ICFBamInt16ColObj rhs ) {
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
		List<ICFBamInt16ColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamInt16ColObj> readInt16ColByTableIdx( long TenantId,
		long TableId )
	{
		return( readInt16ColByTableIdx( TenantId,
			TableId,
			false ) );
	}

	public List<ICFBamInt16ColObj> readInt16ColByTableIdx( long TenantId,
		long TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readInt16ColByTableIdx";
		CFBamInt16ColByTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryInt16Col().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		Map<CFBamValuePKey, ICFBamInt16ColObj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamInt16ColByTableIdxKey,
				Map< CFBamValuePKey, ICFBamInt16ColObj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamInt16ColObj>();
			ICFBamInt16ColObj obj;
			CFBamInt16ColBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().readDerivedByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			CFBamInt16ColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamInt16ColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamInt16ColObj realised = (ICFBamInt16ColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTableIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamInt16ColObj arr[] = new ICFBamInt16ColObj[len];
		Iterator<ICFBamInt16ColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamInt16ColObj> arrayList = new ArrayList<ICFBamInt16ColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamInt16ColObj> cmp = new Comparator<ICFBamInt16ColObj>() {
			public int compare( ICFBamInt16ColObj lhs, ICFBamInt16ColObj rhs ) {
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
		List<ICFBamInt16ColObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamInt16ColObj updateInt16Col( ICFBamInt16ColObj Obj ) {
		ICFBamInt16ColObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().updateInt16Col( schema.getAuthorization(),
			Obj.getInt16ColBuff() );
		if( Obj.getClassCode().equals( "I16C" ) ) {
			obj = (ICFBamInt16ColObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteInt16Col( ICFBamInt16ColObj Obj ) {
		ICFBamInt16ColObj obj = Obj;
		ICFBamValueObj prev = obj.getOptionalLookupPrev();
		ICFBamValueObj next = obj.getOptionalLookupNext();
		((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16Col( schema.getAuthorization(),
			obj.getInt16ColBuff() );
		obj.forget( true );
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	public void deleteInt16ColByIdIdx( long TenantId,
		long Id )
	{
		CFBamValuePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamInt16ColObj obj = readInt16Col( pkey );
		if( obj != null ) {
			ICFBamInt16ColEditObj editObj = (ICFBamInt16ColEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamInt16ColEditObj)obj.beginEdit();
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

	public void deleteInt16ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamValueByUNameIdxKey,
				ICFBamInt16ColObj >();
		}
		CFBamValueByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		ICFBamInt16ColObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16ColByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16ColByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
		}
	}

	public void deleteInt16ColByValTentIdx( long TenantId )
	{
		CFBamValueByValTentIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamValueByValTentIdxKey,
				Map< CFBamValuePKey, ICFBamInt16ColObj > >();
		}
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16ColObj> dict = indexByValTentIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16ColByValTentIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamInt16ColObj> iter = dict.values().iterator();
			ICFBamInt16ColObj obj;
			List<ICFBamInt16ColObj> toForget = new LinkedList<ICFBamInt16ColObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16ColByValTentIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteInt16ColByScopeIdx( long TenantId,
		long ScopeId )
	{
		CFBamValueByScopeIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFBamValueByScopeIdxKey,
				Map< CFBamValuePKey, ICFBamInt16ColObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16ColObj> dict = indexByScopeIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16ColByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
			Iterator<ICFBamInt16ColObj> iter = dict.values().iterator();
			ICFBamInt16ColObj obj;
			List<ICFBamInt16ColObj> toForget = new LinkedList<ICFBamInt16ColObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16ColByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
		}
	}

	public void deleteInt16ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamValueByDefSchemaIdxKey,
				Map< CFBamValuePKey, ICFBamInt16ColObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16ColObj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16ColByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamInt16ColObj> iter = dict.values().iterator();
			ICFBamInt16ColObj obj;
			List<ICFBamInt16ColObj> toForget = new LinkedList<ICFBamInt16ColObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16ColByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteInt16ColByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		CFBamValueByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamValueByPrevIdxKey,
				Map< CFBamValuePKey, ICFBamInt16ColObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16ColObj> dict = indexByPrevIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16ColByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			Iterator<ICFBamInt16ColObj> iter = dict.values().iterator();
			ICFBamInt16ColObj obj;
			List<ICFBamInt16ColObj> toForget = new LinkedList<ICFBamInt16ColObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16ColByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
		}
	}

	public void deleteInt16ColByNextIdx( Long NextTenantId,
		Long NextId )
	{
		CFBamValueByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamValueByNextIdxKey,
				Map< CFBamValuePKey, ICFBamInt16ColObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16ColObj> dict = indexByNextIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16ColByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			Iterator<ICFBamInt16ColObj> iter = dict.values().iterator();
			ICFBamInt16ColObj obj;
			List<ICFBamInt16ColObj> toForget = new LinkedList<ICFBamInt16ColObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16ColByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
		}
	}

	public void deleteInt16ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		CFBamValueByContPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamValueByContPrevIdxKey,
				Map< CFBamValuePKey, ICFBamInt16ColObj > >();
		}
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16ColObj> dict = indexByContPrevIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16ColByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
			Iterator<ICFBamInt16ColObj> iter = dict.values().iterator();
			ICFBamInt16ColObj obj;
			List<ICFBamInt16ColObj> toForget = new LinkedList<ICFBamInt16ColObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16ColByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
		}
	}

	public void deleteInt16ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		CFBamValueByContNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamValueByContNextIdxKey,
				Map< CFBamValuePKey, ICFBamInt16ColObj > >();
		}
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16ColObj> dict = indexByContNextIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16ColByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
			Iterator<ICFBamInt16ColObj> iter = dict.values().iterator();
			ICFBamInt16ColObj obj;
			List<ICFBamInt16ColObj> toForget = new LinkedList<ICFBamInt16ColObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16ColByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
		}
	}

	public void deleteInt16ColByTableIdx( long TenantId,
		long TableId )
	{
		CFBamInt16ColByTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryInt16Col().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamInt16ColByTableIdxKey,
				Map< CFBamValuePKey, ICFBamInt16ColObj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16ColObj> dict = indexByTableIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16ColByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			Iterator<ICFBamInt16ColObj> iter = dict.values().iterator();
			ICFBamInt16ColObj obj;
			List<ICFBamInt16ColObj> toForget = new LinkedList<ICFBamInt16ColObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().deleteInt16ColByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
		}
	}

	/**
	 *	Move the CFBamInt16ColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamInt16ColObj refreshed cache instance.
	 */
	public ICFBamInt16ColObj moveUpInt16Col( ICFBamInt16ColObj Obj ) {
		ICFBamInt16ColObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveUpInt16Col",
				"You cannot move an object that is being edited" );
		}
		CFBamInt16ColBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().moveBuffUp( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getInt16ColTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamInt16ColObj)obj.realise();
			ICFBamValueObj prev = obj.getOptionalLookupPrev( true );
			ICFBamValueObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				ICFBamValueObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the CFBamInt16ColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamInt16ColObj refreshed cache instance.
	 */
	public ICFBamInt16ColObj moveDownInt16Col( ICFBamInt16ColObj Obj ) {
		ICFBamInt16ColObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveDownInt16Col",
				"You cannot move an object that is being edited" );
		}
		CFBamInt16ColBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableInt16Col().moveBuffDown( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getInt16ColTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamInt16ColObj)obj.realise();
			ICFBamValueObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				ICFBamValueObj gprev = prev.getOptionalLookupPrev( true );
			}
			ICFBamValueObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}
