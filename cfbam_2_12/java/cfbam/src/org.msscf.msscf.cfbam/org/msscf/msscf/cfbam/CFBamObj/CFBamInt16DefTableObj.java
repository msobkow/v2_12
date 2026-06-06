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

public class CFBamInt16DefTableObj
	implements ICFBamInt16DefTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamValuePKey, ICFBamInt16DefObj> members;
	private Map<CFBamValuePKey, ICFBamInt16DefObj> allInt16Def;
	private Map< CFBamValueByUNameIdxKey,
		ICFBamInt16DefObj > indexByUNameIdx;
	private Map< CFBamValueByValTentIdxKey,
		Map<CFBamValuePKey, ICFBamInt16DefObj > > indexByValTentIdx;
	private Map< CFBamValueByScopeIdxKey,
		Map<CFBamValuePKey, ICFBamInt16DefObj > > indexByScopeIdx;
	private Map< CFBamValueByDefSchemaIdxKey,
		Map<CFBamValuePKey, ICFBamInt16DefObj > > indexByDefSchemaIdx;
	private Map< CFBamValueByPrevIdxKey,
		Map<CFBamValuePKey, ICFBamInt16DefObj > > indexByPrevIdx;
	private Map< CFBamValueByNextIdxKey,
		Map<CFBamValuePKey, ICFBamInt16DefObj > > indexByNextIdx;
	private Map< CFBamValueByContPrevIdxKey,
		Map<CFBamValuePKey, ICFBamInt16DefObj > > indexByContPrevIdx;
	private Map< CFBamValueByContNextIdxKey,
		Map<CFBamValuePKey, ICFBamInt16DefObj > > indexByContNextIdx;
	public static String TABLE_NAME = "Int16Def";
	public static String TABLE_DBNAME = "int16def";

	public CFBamInt16DefTableObj() {
		schema = null;
		members = new HashMap<CFBamValuePKey, ICFBamInt16DefObj>();
		allInt16Def = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
	}

	public CFBamInt16DefTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamValuePKey, ICFBamInt16DefObj>();
		allInt16Def = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
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
		allInt16Def = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamInt16DefObj.
	 */
	public ICFBamInt16DefObj newInstance() {
		ICFBamInt16DefObj inst = new CFBamInt16DefObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamInt16DefObj.
	 */
	public ICFBamInt16DefEditObj newEditInstance( ICFBamInt16DefObj orig ) {
		ICFBamInt16DefEditObj edit = new CFBamInt16DefEditObj( orig );
		return( edit );
	}

	public ICFBamInt16DefObj realiseInt16Def( ICFBamInt16DefObj Obj ) {
		ICFBamInt16DefObj obj = Obj;
		CFBamValuePKey pkey = obj.getPKey();
		ICFBamInt16DefObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamInt16DefObj existingObj = members.get( pkey );
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
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamInt16DefObj)schema.getAtomTableObj().realiseAtom( Obj );

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
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allInt16Def != null ) {
				allInt16Def.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamInt16DefObj)schema.getAtomTableObj().realiseAtom( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allInt16Def != null ) {
				allInt16Def.put( keepObj.getPKey(), keepObj );
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
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetInt16Def( ICFBamInt16DefObj Obj ) {
		forgetInt16Def( Obj, false );
	}

	public void forgetInt16Def( ICFBamInt16DefObj Obj, boolean forgetSubObjects ) {
		ICFBamInt16DefObj obj = Obj;
		CFBamValuePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamInt16DefObj keepObj = members.get( pkey );
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
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamInt16DefObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( allInt16Def != null ) {
				allInt16Def.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		((ICFBamSchemaObj)schema).getAtomTableObj().forgetAtom( obj );
	}

	public void forgetInt16DefByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamValuePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamInt16DefObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetInt16DefByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamInt16DefObj> toForget = new LinkedList<ICFBamInt16DefObj>();
		ICFBamInt16DefObj cur = null;
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
		Iterator<ICFBamInt16DefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetInt16DefByValTentIdx( long TenantId )
	{
		if( indexByValTentIdx == null ) {
			return;
		}
		List<ICFBamInt16DefObj> toForget = new LinkedList<ICFBamInt16DefObj>();
		ICFBamInt16DefObj cur = null;
		CFBamValueByValTentIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16DefObj > mapValTentIdx = indexByValTentIdx.get( key );
			if( mapValTentIdx != null ) {
				Iterator<ICFBamInt16DefObj> iterDup = mapValTentIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByValTentIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamInt16DefObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamInt16DefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetInt16DefByScopeIdx( long TenantId,
		long ScopeId )
	{
		if( indexByScopeIdx == null ) {
			return;
		}
		List<ICFBamInt16DefObj> toForget = new LinkedList<ICFBamInt16DefObj>();
		ICFBamInt16DefObj cur = null;
		CFBamValueByScopeIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16DefObj > mapScopeIdx = indexByScopeIdx.get( key );
			if( mapScopeIdx != null ) {
				Iterator<ICFBamInt16DefObj> iterDup = mapScopeIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByScopeIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamInt16DefObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamInt16DefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetInt16DefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamInt16DefObj> toForget = new LinkedList<ICFBamInt16DefObj>();
		ICFBamInt16DefObj cur = null;
		CFBamValueByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16DefObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamInt16DefObj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamInt16DefObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamInt16DefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetInt16DefByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		if( indexByPrevIdx == null ) {
			return;
		}
		List<ICFBamInt16DefObj> toForget = new LinkedList<ICFBamInt16DefObj>();
		ICFBamInt16DefObj cur = null;
		CFBamValueByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16DefObj > mapPrevIdx = indexByPrevIdx.get( key );
			if( mapPrevIdx != null ) {
				Iterator<ICFBamInt16DefObj> iterDup = mapPrevIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByPrevIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamInt16DefObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamInt16DefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetInt16DefByNextIdx( Long NextTenantId,
		Long NextId )
	{
		if( indexByNextIdx == null ) {
			return;
		}
		List<ICFBamInt16DefObj> toForget = new LinkedList<ICFBamInt16DefObj>();
		ICFBamInt16DefObj cur = null;
		CFBamValueByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16DefObj > mapNextIdx = indexByNextIdx.get( key );
			if( mapNextIdx != null ) {
				Iterator<ICFBamInt16DefObj> iterDup = mapNextIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByNextIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamInt16DefObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamInt16DefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetInt16DefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		if( indexByContPrevIdx == null ) {
			return;
		}
		List<ICFBamInt16DefObj> toForget = new LinkedList<ICFBamInt16DefObj>();
		ICFBamInt16DefObj cur = null;
		CFBamValueByContPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16DefObj > mapContPrevIdx = indexByContPrevIdx.get( key );
			if( mapContPrevIdx != null ) {
				Iterator<ICFBamInt16DefObj> iterDup = mapContPrevIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByContPrevIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamInt16DefObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamInt16DefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetInt16DefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		if( indexByContNextIdx == null ) {
			return;
		}
		List<ICFBamInt16DefObj> toForget = new LinkedList<ICFBamInt16DefObj>();
		ICFBamInt16DefObj cur = null;
		CFBamValueByContNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16DefObj > mapContNextIdx = indexByContNextIdx.get( key );
			if( mapContNextIdx != null ) {
				Iterator<ICFBamInt16DefObj> iterDup = mapContNextIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByContNextIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamInt16DefObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamInt16DefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamInt16DefObj createInt16Def( ICFBamInt16DefObj Obj ) {
		ICFBamInt16DefObj obj = Obj;
		CFBamInt16DefBuff buff = obj.getInt16DefBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().createInt16Def(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "I16D" ) ) {
			obj = (ICFBamInt16DefObj)(obj.realise());
		}
		ICFBamValueObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamInt16DefObj readInt16Def( CFBamValuePKey pkey ) {
		return( readInt16Def( pkey, false ) );
	}

	public ICFBamInt16DefObj readInt16Def( CFBamValuePKey pkey, boolean forceRead ) {
		ICFBamInt16DefObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamInt16DefBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamInt16DefObj)schema.getValueTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamInt16DefObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamInt16DefObj lockInt16Def( CFBamValuePKey pkey ) {
		ICFBamInt16DefObj locked = null;
		CFBamInt16DefBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamInt16DefObj)schema.getValueTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamInt16DefObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockInt16Def", pkey );
		}
		return( locked );
	}

	public List<ICFBamInt16DefObj> readAllInt16Def() {
		return( readAllInt16Def( false ) );
	}

	public List<ICFBamInt16DefObj> readAllInt16Def( boolean forceRead ) {
		final String S_ProcName = "readAllInt16Def";
		if( ( allInt16Def == null ) || forceRead ) {
			Map<CFBamValuePKey, ICFBamInt16DefObj> map = new HashMap<CFBamValuePKey,ICFBamInt16DefObj>();
			allInt16Def = map;
			CFBamInt16DefBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().readAllDerived( schema.getAuthorization() );
			CFBamInt16DefBuff buff;
			ICFBamInt16DefObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamInt16DefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamInt16DefObj realised = (ICFBamInt16DefObj)obj.realise();
			}
		}
		int len = allInt16Def.size();
		ICFBamInt16DefObj arr[] = new ICFBamInt16DefObj[len];
		Iterator<ICFBamInt16DefObj> valIter = allInt16Def.values().iterator();
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
		ArrayList<ICFBamInt16DefObj> arrayList = new ArrayList<ICFBamInt16DefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamInt16DefObj> cmp = new Comparator<ICFBamInt16DefObj>() {
			public int compare( ICFBamInt16DefObj lhs, ICFBamInt16DefObj rhs ) {
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
		List<ICFBamInt16DefObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamInt16DefObj readInt16DefByIdIdx( long TenantId,
		long Id )
	{
		return( readInt16DefByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamInt16DefObj readInt16DefByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamValuePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamInt16DefObj obj = readInt16Def( pkey, forceRead );
		return( obj );
	}

	public ICFBamInt16DefObj readInt16DefByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		return( readInt16DefByUNameIdx( TenantId,
			ScopeId,
			Name,
			false ) );
	}

	public ICFBamInt16DefObj readInt16DefByUNameIdx( long TenantId,
		long ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamValueByUNameIdxKey,
				ICFBamInt16DefObj >();
		}
		CFBamValueByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		ICFBamInt16DefObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamValueBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
			if( buff != null ) {
				obj = (ICFBamInt16DefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamInt16DefObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFBamInt16DefObj> readInt16DefByValTentIdx( long TenantId )
	{
		return( readInt16DefByValTentIdx( TenantId,
			false ) );
	}

	public List<ICFBamInt16DefObj> readInt16DefByValTentIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readInt16DefByValTentIdx";
		CFBamValueByValTentIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamValuePKey, ICFBamInt16DefObj> dict;
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamValueByValTentIdxKey,
				Map< CFBamValuePKey, ICFBamInt16DefObj > >();
		}
		if( ( ! forceRead ) && indexByValTentIdx.containsKey( key ) ) {
			dict = indexByValTentIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamInt16DefObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByValTentIdx( schema.getAuthorization(),
				TenantId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamInt16DefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamInt16DefObj realised = (ICFBamInt16DefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByValTentIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamInt16DefObj arr[] = new ICFBamInt16DefObj[len];
		Iterator<ICFBamInt16DefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamInt16DefObj> arrayList = new ArrayList<ICFBamInt16DefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamInt16DefObj> cmp = new Comparator<ICFBamInt16DefObj>() {
			public int compare( ICFBamInt16DefObj lhs, ICFBamInt16DefObj rhs ) {
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
		List<ICFBamInt16DefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamInt16DefObj> readInt16DefByScopeIdx( long TenantId,
		long ScopeId )
	{
		return( readInt16DefByScopeIdx( TenantId,
			ScopeId,
			false ) );
	}

	public List<ICFBamInt16DefObj> readInt16DefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readInt16DefByScopeIdx";
		CFBamValueByScopeIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		Map<CFBamValuePKey, ICFBamInt16DefObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFBamValueByScopeIdxKey,
				Map< CFBamValuePKey, ICFBamInt16DefObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamInt16DefObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamInt16DefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamInt16DefObj realised = (ICFBamInt16DefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamInt16DefObj arr[] = new ICFBamInt16DefObj[len];
		Iterator<ICFBamInt16DefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamInt16DefObj> arrayList = new ArrayList<ICFBamInt16DefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamInt16DefObj> cmp = new Comparator<ICFBamInt16DefObj>() {
			public int compare( ICFBamInt16DefObj lhs, ICFBamInt16DefObj rhs ) {
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
		List<ICFBamInt16DefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamInt16DefObj> readInt16DefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readInt16DefByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamInt16DefObj> readInt16DefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readInt16DefByDefSchemaIdx";
		CFBamValueByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamValuePKey, ICFBamInt16DefObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamValueByDefSchemaIdxKey,
				Map< CFBamValuePKey, ICFBamInt16DefObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamInt16DefObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamInt16DefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamInt16DefObj realised = (ICFBamInt16DefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamInt16DefObj arr[] = new ICFBamInt16DefObj[len];
		Iterator<ICFBamInt16DefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamInt16DefObj> arrayList = new ArrayList<ICFBamInt16DefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamInt16DefObj> cmp = new Comparator<ICFBamInt16DefObj>() {
			public int compare( ICFBamInt16DefObj lhs, ICFBamInt16DefObj rhs ) {
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
		List<ICFBamInt16DefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamInt16DefObj> readInt16DefByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		return( readInt16DefByPrevIdx( PrevTenantId,
			PrevId,
			false ) );
	}

	public List<ICFBamInt16DefObj> readInt16DefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readInt16DefByPrevIdx";
		CFBamValueByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamValuePKey, ICFBamInt16DefObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamValueByPrevIdxKey,
				Map< CFBamValuePKey, ICFBamInt16DefObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamInt16DefObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamInt16DefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamInt16DefObj realised = (ICFBamInt16DefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamInt16DefObj arr[] = new ICFBamInt16DefObj[len];
		Iterator<ICFBamInt16DefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamInt16DefObj> arrayList = new ArrayList<ICFBamInt16DefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamInt16DefObj> cmp = new Comparator<ICFBamInt16DefObj>() {
			public int compare( ICFBamInt16DefObj lhs, ICFBamInt16DefObj rhs ) {
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
		List<ICFBamInt16DefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamInt16DefObj> readInt16DefByNextIdx( Long NextTenantId,
		Long NextId )
	{
		return( readInt16DefByNextIdx( NextTenantId,
			NextId,
			false ) );
	}

	public List<ICFBamInt16DefObj> readInt16DefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readInt16DefByNextIdx";
		CFBamValueByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		Map<CFBamValuePKey, ICFBamInt16DefObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamValueByNextIdxKey,
				Map< CFBamValuePKey, ICFBamInt16DefObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamInt16DefObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamInt16DefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamInt16DefObj realised = (ICFBamInt16DefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamInt16DefObj arr[] = new ICFBamInt16DefObj[len];
		Iterator<ICFBamInt16DefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamInt16DefObj> arrayList = new ArrayList<ICFBamInt16DefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamInt16DefObj> cmp = new Comparator<ICFBamInt16DefObj>() {
			public int compare( ICFBamInt16DefObj lhs, ICFBamInt16DefObj rhs ) {
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
		List<ICFBamInt16DefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamInt16DefObj> readInt16DefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		return( readInt16DefByContPrevIdx( TenantId,
			ScopeId,
			PrevId,
			false ) );
	}

	public List<ICFBamInt16DefObj> readInt16DefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readInt16DefByContPrevIdx";
		CFBamValueByContPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamValuePKey, ICFBamInt16DefObj> dict;
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamValueByContPrevIdxKey,
				Map< CFBamValuePKey, ICFBamInt16DefObj > >();
		}
		if( ( ! forceRead ) && indexByContPrevIdx.containsKey( key ) ) {
			dict = indexByContPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamInt16DefObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamInt16DefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamInt16DefObj realised = (ICFBamInt16DefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContPrevIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamInt16DefObj arr[] = new ICFBamInt16DefObj[len];
		Iterator<ICFBamInt16DefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamInt16DefObj> arrayList = new ArrayList<ICFBamInt16DefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamInt16DefObj> cmp = new Comparator<ICFBamInt16DefObj>() {
			public int compare( ICFBamInt16DefObj lhs, ICFBamInt16DefObj rhs ) {
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
		List<ICFBamInt16DefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamInt16DefObj> readInt16DefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		return( readInt16DefByContNextIdx( TenantId,
			ScopeId,
			NextId,
			false ) );
	}

	public List<ICFBamInt16DefObj> readInt16DefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readInt16DefByContNextIdx";
		CFBamValueByContNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		Map<CFBamValuePKey, ICFBamInt16DefObj> dict;
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamValueByContNextIdxKey,
				Map< CFBamValuePKey, ICFBamInt16DefObj > >();
		}
		if( ( ! forceRead ) && indexByContNextIdx.containsKey( key ) ) {
			dict = indexByContNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamInt16DefObj>();
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamInt16DefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamInt16DefObj realised = (ICFBamInt16DefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContNextIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamInt16DefObj arr[] = new ICFBamInt16DefObj[len];
		Iterator<ICFBamInt16DefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamInt16DefObj> arrayList = new ArrayList<ICFBamInt16DefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamInt16DefObj> cmp = new Comparator<ICFBamInt16DefObj>() {
			public int compare( ICFBamInt16DefObj lhs, ICFBamInt16DefObj rhs ) {
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
		List<ICFBamInt16DefObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamInt16DefObj updateInt16Def( ICFBamInt16DefObj Obj ) {
		ICFBamInt16DefObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().updateInt16Def( schema.getAuthorization(),
			Obj.getInt16DefBuff() );
		if( Obj.getClassCode().equals( "I16D" ) ) {
			obj = (ICFBamInt16DefObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteInt16Def( ICFBamInt16DefObj Obj ) {
		ICFBamInt16DefObj obj = Obj;
		ICFBamValueObj prev = obj.getOptionalLookupPrev();
		ICFBamValueObj next = obj.getOptionalLookupNext();
		((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().deleteInt16Def( schema.getAuthorization(),
			obj.getInt16DefBuff() );
		obj.forget( true );
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	public void deleteInt16DefByIdIdx( long TenantId,
		long Id )
	{
		CFBamValuePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamInt16DefObj obj = readInt16Def( pkey );
		if( obj != null ) {
			ICFBamInt16DefEditObj editObj = (ICFBamInt16DefEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamInt16DefEditObj)obj.beginEdit();
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

	public void deleteInt16DefByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamValueByUNameIdxKey,
				ICFBamInt16DefObj >();
		}
		CFBamValueByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		ICFBamInt16DefObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().deleteInt16DefByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().deleteInt16DefByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
		}
	}

	public void deleteInt16DefByValTentIdx( long TenantId )
	{
		CFBamValueByValTentIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamValueByValTentIdxKey,
				Map< CFBamValuePKey, ICFBamInt16DefObj > >();
		}
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16DefObj> dict = indexByValTentIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().deleteInt16DefByValTentIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamInt16DefObj> iter = dict.values().iterator();
			ICFBamInt16DefObj obj;
			List<ICFBamInt16DefObj> toForget = new LinkedList<ICFBamInt16DefObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().deleteInt16DefByValTentIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteInt16DefByScopeIdx( long TenantId,
		long ScopeId )
	{
		CFBamValueByScopeIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFBamValueByScopeIdxKey,
				Map< CFBamValuePKey, ICFBamInt16DefObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16DefObj> dict = indexByScopeIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().deleteInt16DefByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
			Iterator<ICFBamInt16DefObj> iter = dict.values().iterator();
			ICFBamInt16DefObj obj;
			List<ICFBamInt16DefObj> toForget = new LinkedList<ICFBamInt16DefObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().deleteInt16DefByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
		}
	}

	public void deleteInt16DefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamValueByDefSchemaIdxKey,
				Map< CFBamValuePKey, ICFBamInt16DefObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16DefObj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().deleteInt16DefByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamInt16DefObj> iter = dict.values().iterator();
			ICFBamInt16DefObj obj;
			List<ICFBamInt16DefObj> toForget = new LinkedList<ICFBamInt16DefObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().deleteInt16DefByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteInt16DefByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		CFBamValueByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamValueByPrevIdxKey,
				Map< CFBamValuePKey, ICFBamInt16DefObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16DefObj> dict = indexByPrevIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().deleteInt16DefByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			Iterator<ICFBamInt16DefObj> iter = dict.values().iterator();
			ICFBamInt16DefObj obj;
			List<ICFBamInt16DefObj> toForget = new LinkedList<ICFBamInt16DefObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().deleteInt16DefByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
		}
	}

	public void deleteInt16DefByNextIdx( Long NextTenantId,
		Long NextId )
	{
		CFBamValueByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamValueByNextIdxKey,
				Map< CFBamValuePKey, ICFBamInt16DefObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16DefObj> dict = indexByNextIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().deleteInt16DefByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			Iterator<ICFBamInt16DefObj> iter = dict.values().iterator();
			ICFBamInt16DefObj obj;
			List<ICFBamInt16DefObj> toForget = new LinkedList<ICFBamInt16DefObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().deleteInt16DefByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
		}
	}

	public void deleteInt16DefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		CFBamValueByContPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamValueByContPrevIdxKey,
				Map< CFBamValuePKey, ICFBamInt16DefObj > >();
		}
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16DefObj> dict = indexByContPrevIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().deleteInt16DefByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
			Iterator<ICFBamInt16DefObj> iter = dict.values().iterator();
			ICFBamInt16DefObj obj;
			List<ICFBamInt16DefObj> toForget = new LinkedList<ICFBamInt16DefObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().deleteInt16DefByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
		}
	}

	public void deleteInt16DefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		CFBamValueByContNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamValueByContNextIdxKey,
				Map< CFBamValuePKey, ICFBamInt16DefObj > >();
		}
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamInt16DefObj> dict = indexByContNextIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().deleteInt16DefByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
			Iterator<ICFBamInt16DefObj> iter = dict.values().iterator();
			ICFBamInt16DefObj obj;
			List<ICFBamInt16DefObj> toForget = new LinkedList<ICFBamInt16DefObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().deleteInt16DefByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
		}
	}

	/**
	 *	Move the CFBamInt16DefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamInt16DefObj refreshed cache instance.
	 */
	public ICFBamInt16DefObj moveUpInt16Def( ICFBamInt16DefObj Obj ) {
		ICFBamInt16DefObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveUpInt16Def",
				"You cannot move an object that is being edited" );
		}
		CFBamInt16DefBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().moveBuffUp( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getInt16DefTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamInt16DefObj)obj.realise();
			ICFBamValueObj prev = obj.getOptionalLookupPrev( true );
			ICFBamValueObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				ICFBamValueObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the CFBamInt16DefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamInt16DefObj refreshed cache instance.
	 */
	public ICFBamInt16DefObj moveDownInt16Def( ICFBamInt16DefObj Obj ) {
		ICFBamInt16DefObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveDownInt16Def",
				"You cannot move an object that is being edited" );
		}
		CFBamInt16DefBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableInt16Def().moveBuffDown( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getInt16DefTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamInt16DefObj)obj.realise();
			ICFBamValueObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				ICFBamValueObj gprev = prev.getOptionalLookupPrev( true );
			}
			ICFBamValueObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}
