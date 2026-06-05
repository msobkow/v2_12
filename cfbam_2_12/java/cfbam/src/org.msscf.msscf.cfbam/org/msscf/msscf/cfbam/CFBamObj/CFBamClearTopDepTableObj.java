// Description: Java 11 Table Object implementation for CFBam.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamClearTopDepTableObj
	implements ICFBamClearTopDepTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamClearTopDepObj> members;
	private Map<CFBamScopePKey, ICFBamClearTopDepObj> allClearTopDep;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamClearTopDepObj > > indexByTenantIdx;
	private Map< CFBamClearDepByClearDepIdxKey,
		Map<CFBamScopePKey, ICFBamClearTopDepObj > > indexByClearDepIdx;
	private Map< CFBamClearDepByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamClearTopDepObj > > indexByDefSchemaIdx;
	private Map< CFBamClearTopDepByClrTopDepTblIdxKey,
		Map<CFBamScopePKey, ICFBamClearTopDepObj > > indexByClrTopDepTblIdx;
	private Map< CFBamClearTopDepByUNameIdxKey,
		ICFBamClearTopDepObj > indexByUNameIdx;
	private Map< CFBamClearTopDepByPrevIdxKey,
		Map<CFBamScopePKey, ICFBamClearTopDepObj > > indexByPrevIdx;
	private Map< CFBamClearTopDepByNextIdxKey,
		Map<CFBamScopePKey, ICFBamClearTopDepObj > > indexByNextIdx;
	public static String TABLE_NAME = "ClearTopDep";
	public static String TABLE_DBNAME = "clr_topdep";

	public CFBamClearTopDepTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamClearTopDepObj>();
		allClearTopDep = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		indexByClrTopDepTblIdx = null;
		indexByUNameIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
	}

	public CFBamClearTopDepTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamClearTopDepObj>();
		allClearTopDep = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		indexByClrTopDepTblIdx = null;
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
		allClearTopDep = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		indexByClrTopDepTblIdx = null;
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
	 *	CFBamClearTopDepObj.
	 */
	public ICFBamClearTopDepObj newInstance() {
		ICFBamClearTopDepObj inst = new CFBamClearTopDepObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClearTopDepObj.
	 */
	public ICFBamClearTopDepEditObj newEditInstance( ICFBamClearTopDepObj orig ) {
		ICFBamClearTopDepEditObj edit = new CFBamClearTopDepEditObj( orig );
		return( edit );
	}

	public ICFBamClearTopDepObj realiseClearTopDep( ICFBamClearTopDepObj Obj ) {
		ICFBamClearTopDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamClearTopDepObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamClearTopDepObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					indexByClearDepIdx.remove( keyClearDepIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByClrTopDepTblIdx != null ) {
				CFBamClearTopDepByClrTopDepTblIdxKey keyClrTopDepTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newClrTopDepTblIdxKey();
				keyClrTopDepTblIdx.setRequiredTableTenantId( keepObj.getRequiredTableTenantId() );
				keyClrTopDepTblIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapClrTopDepTblIdx = indexByClrTopDepTblIdx.get( keyClrTopDepTblIdx );
				if( mapClrTopDepTblIdx != null ) {
					mapClrTopDepTblIdx.remove( keepObj.getPKey() );
					if( mapClrTopDepTblIdx.size() <= 0 ) {
						indexByClrTopDepTblIdx.remove( keyClrTopDepTblIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearTopDepByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredTableTenantId( keepObj.getRequiredTableTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByPrevIdx != null ) {
				CFBamClearTopDepByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				CFBamClearTopDepByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
			keepObj = (ICFBamClearTopDepObj)schema.getClearDepTableObj().realiseClearDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClrTopDepTblIdx != null ) {
				CFBamClearTopDepByClrTopDepTblIdxKey keyClrTopDepTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newClrTopDepTblIdxKey();
				keyClrTopDepTblIdx.setRequiredTableTenantId( keepObj.getRequiredTableTenantId() );
				keyClrTopDepTblIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapClrTopDepTblIdx = indexByClrTopDepTblIdx.get( keyClrTopDepTblIdx );
				if( mapClrTopDepTblIdx != null ) {
					mapClrTopDepTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearTopDepByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredTableTenantId( keepObj.getRequiredTableTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByPrevIdx != null ) {
				CFBamClearTopDepByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamClearTopDepByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allClearTopDep != null ) {
				allClearTopDep.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamClearTopDepObj)schema.getClearDepTableObj().realiseClearDep( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allClearTopDep != null ) {
				allClearTopDep.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClrTopDepTblIdx != null ) {
				CFBamClearTopDepByClrTopDepTblIdxKey keyClrTopDepTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newClrTopDepTblIdxKey();
				keyClrTopDepTblIdx.setRequiredTableTenantId( keepObj.getRequiredTableTenantId() );
				keyClrTopDepTblIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapClrTopDepTblIdx = indexByClrTopDepTblIdx.get( keyClrTopDepTblIdx );
				if( mapClrTopDepTblIdx != null ) {
					mapClrTopDepTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearTopDepByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredTableTenantId( keepObj.getRequiredTableTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByPrevIdx != null ) {
				CFBamClearTopDepByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamClearTopDepByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetClearTopDep( ICFBamClearTopDepObj Obj ) {
		forgetClearTopDep( Obj, false );
	}

	public void forgetClearTopDep( ICFBamClearTopDepObj Obj, boolean forgetSubObjects ) {
		ICFBamClearTopDepObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamClearTopDepObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByClearDepIdx != null ) {
				CFBamClearDepByClearDepIdxKey keyClearDepIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
				keyClearDepIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					indexByClearDepIdx.remove( keyClearDepIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByClrTopDepTblIdx != null ) {
				CFBamClearTopDepByClrTopDepTblIdxKey keyClrTopDepTblIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newClrTopDepTblIdxKey();
				keyClrTopDepTblIdx.setRequiredTableTenantId( keepObj.getRequiredTableTenantId() );
				keyClrTopDepTblIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapClrTopDepTblIdx = indexByClrTopDepTblIdx.get( keyClrTopDepTblIdx );
				if( mapClrTopDepTblIdx != null ) {
					mapClrTopDepTblIdx.remove( keepObj.getPKey() );
					if( mapClrTopDepTblIdx.size() <= 0 ) {
						indexByClrTopDepTblIdx.remove( keyClrTopDepTblIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamClearTopDepByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newUNameIdxKey();
				keyUNameIdx.setRequiredTableTenantId( keepObj.getRequiredTableTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByPrevIdx != null ) {
				CFBamClearTopDepByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				CFBamClearTopDepByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamScopePKey, ICFBamClearTopDepObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
					if( mapNextIdx.size() <= 0 ) {
						indexByNextIdx.remove( keyNextIdx );
					}
				}
			}

			if( allClearTopDep != null ) {
				allClearTopDep.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFBamSchemaObj)schema).getClearSubDep1TableObj().forgetClearSubDep1ByClearTopDepIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		((ICFBamSchemaObj)schema).getClearDepTableObj().forgetClearDep( obj );
	}

	public void forgetClearTopDepByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamClearTopDepObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetClearTopDepByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
		ICFBamClearTopDepObj cur = null;
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamClearTopDepObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearTopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearTopDepByClearDepIdx( long TenantId,
		long RelationId )
	{
		if( indexByClearDepIdx == null ) {
			return;
		}
		List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
		ICFBamClearTopDepObj cur = null;
		CFBamClearDepByClearDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByClearDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj > mapClearDepIdx = indexByClearDepIdx.get( key );
			if( mapClearDepIdx != null ) {
				Iterator<ICFBamClearTopDepObj> iterDup = mapClearDepIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClearDepIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearTopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
		ICFBamClearTopDepObj cur = null;
		CFBamClearDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamClearTopDepObj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearTopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearTopDepByClrTopDepTblIdx( long TableTenantId,
		long TableId )
	{
		if( indexByClrTopDepTblIdx == null ) {
			return;
		}
		List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
		ICFBamClearTopDepObj cur = null;
		CFBamClearTopDepByClrTopDepTblIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newClrTopDepTblIdxKey();
		key.setRequiredTableTenantId( TableTenantId );
		key.setRequiredTableId( TableId );
		if( indexByClrTopDepTblIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj > mapClrTopDepTblIdx = indexByClrTopDepTblIdx.get( key );
			if( mapClrTopDepTblIdx != null ) {
				Iterator<ICFBamClearTopDepObj> iterDup = mapClrTopDepTblIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClrTopDepTblIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearTopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearTopDepByUNameIdx( long TableTenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
		ICFBamClearTopDepObj cur = null;
		CFBamClearTopDepByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newUNameIdxKey();
		key.setRequiredTableTenantId( TableTenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamClearTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearTopDepByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		if( indexByPrevIdx == null ) {
			return;
		}
		List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
		ICFBamClearTopDepObj cur = null;
		CFBamClearTopDepByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj > mapPrevIdx = indexByPrevIdx.get( key );
			if( mapPrevIdx != null ) {
				Iterator<ICFBamClearTopDepObj> iterDup = mapPrevIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByPrevIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearTopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetClearTopDepByNextIdx( Long NextTenantId,
		Long NextId )
	{
		if( indexByNextIdx == null ) {
			return;
		}
		List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
		ICFBamClearTopDepObj cur = null;
		CFBamClearTopDepByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj > mapNextIdx = indexByNextIdx.get( key );
			if( mapNextIdx != null ) {
				Iterator<ICFBamClearTopDepObj> iterDup = mapNextIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByNextIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamClearTopDepObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamClearTopDepObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamClearTopDepObj createClearTopDep( ICFBamClearTopDepObj Obj ) {
		ICFBamClearTopDepObj obj = Obj;
		CFBamClearTopDepBuff buff = obj.getClearTopDepBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().createClearTopDep(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "CLRT" ) ) {
			obj = (ICFBamClearTopDepObj)(obj.realise());
		}
		ICFBamClearTopDepObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamClearTopDepObj readClearTopDep( CFBamScopePKey pkey ) {
		return( readClearTopDep( pkey, false ) );
	}

	public ICFBamClearTopDepObj readClearTopDep( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamClearTopDepObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamClearTopDepBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamClearTopDepObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamClearTopDepObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamClearTopDepObj lockClearTopDep( CFBamScopePKey pkey ) {
		ICFBamClearTopDepObj locked = null;
		CFBamClearTopDepBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamClearTopDepObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamClearTopDepObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockClearTopDep", pkey );
		}
		return( locked );
	}

	public List<ICFBamClearTopDepObj> readAllClearTopDep() {
		return( readAllClearTopDep( false ) );
	}

	public List<ICFBamClearTopDepObj> readAllClearTopDep( boolean forceRead ) {
		final String S_ProcName = "readAllClearTopDep";
		if( ( allClearTopDep == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj> map = new HashMap<CFBamScopePKey,ICFBamClearTopDepObj>();
			allClearTopDep = map;
			CFBamClearTopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().readAllDerived( schema.getAuthorization() );
			CFBamClearTopDepBuff buff;
			ICFBamClearTopDepObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearTopDepObj realised = (ICFBamClearTopDepObj)obj.realise();
			}
		}
		int len = allClearTopDep.size();
		ICFBamClearTopDepObj arr[] = new ICFBamClearTopDepObj[len];
		Iterator<ICFBamClearTopDepObj> valIter = allClearTopDep.values().iterator();
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
		ArrayList<ICFBamClearTopDepObj> arrayList = new ArrayList<ICFBamClearTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearTopDepObj> cmp = new Comparator<ICFBamClearTopDepObj>() {
			public int compare( ICFBamClearTopDepObj lhs, ICFBamClearTopDepObj rhs ) {
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
		List<ICFBamClearTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearTopDepObj readClearTopDepByIdIdx( long TenantId,
		long Id )
	{
		return( readClearTopDepByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamClearTopDepObj readClearTopDepByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamClearTopDepObj obj = readClearTopDep( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamClearTopDepObj> readClearTopDepByTenantIdx( long TenantId )
	{
		return( readClearTopDepByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamClearTopDepObj> readClearTopDepByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearTopDepByTenantIdx";
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamClearTopDepObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearTopDepObj>();
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearTopDepObj realised = (ICFBamClearTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearTopDepObj arr[] = new ICFBamClearTopDepObj[len];
		Iterator<ICFBamClearTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearTopDepObj> arrayList = new ArrayList<ICFBamClearTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearTopDepObj> cmp = new Comparator<ICFBamClearTopDepObj>() {
			public int compare( ICFBamClearTopDepObj lhs, ICFBamClearTopDepObj rhs ) {
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
		List<ICFBamClearTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearTopDepObj> readClearTopDepByClearDepIdx( long TenantId,
		long RelationId )
	{
		return( readClearTopDepByClearDepIdx( TenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamClearTopDepObj> readClearTopDepByClearDepIdx( long TenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearTopDepByClearDepIdx";
		CFBamClearDepByClearDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamScopePKey, ICFBamClearTopDepObj> dict;
		if( indexByClearDepIdx == null ) {
			indexByClearDepIdx = new HashMap< CFBamClearDepByClearDepIdxKey,
				Map< CFBamScopePKey, ICFBamClearTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByClearDepIdx.containsKey( key ) ) {
			dict = indexByClearDepIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearTopDepObj>();
			ICFBamClearDepObj obj;
			CFBamClearDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearDep().readDerivedByClearDepIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			CFBamClearDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearTopDepObj realised = (ICFBamClearTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClearDepIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearTopDepObj arr[] = new ICFBamClearTopDepObj[len];
		Iterator<ICFBamClearTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearTopDepObj> arrayList = new ArrayList<ICFBamClearTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearTopDepObj> cmp = new Comparator<ICFBamClearTopDepObj>() {
			public int compare( ICFBamClearTopDepObj lhs, ICFBamClearTopDepObj rhs ) {
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
		List<ICFBamClearTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearTopDepObj> readClearTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readClearTopDepByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamClearTopDepObj> readClearTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearTopDepByDefSchemaIdx";
		CFBamClearDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamClearTopDepObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamClearDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamClearTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearTopDepObj>();
			ICFBamClearDepObj obj;
			CFBamClearDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearDep().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamClearDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearTopDepObj realised = (ICFBamClearTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearTopDepObj arr[] = new ICFBamClearTopDepObj[len];
		Iterator<ICFBamClearTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearTopDepObj> arrayList = new ArrayList<ICFBamClearTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearTopDepObj> cmp = new Comparator<ICFBamClearTopDepObj>() {
			public int compare( ICFBamClearTopDepObj lhs, ICFBamClearTopDepObj rhs ) {
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
		List<ICFBamClearTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearTopDepObj> readClearTopDepByClrTopDepTblIdx( long TableTenantId,
		long TableId )
	{
		return( readClearTopDepByClrTopDepTblIdx( TableTenantId,
			TableId,
			false ) );
	}

	public List<ICFBamClearTopDepObj> readClearTopDepByClrTopDepTblIdx( long TableTenantId,
		long TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearTopDepByClrTopDepTblIdx";
		CFBamClearTopDepByClrTopDepTblIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newClrTopDepTblIdxKey();
		key.setRequiredTableTenantId( TableTenantId );
		key.setRequiredTableId( TableId );
		Map<CFBamScopePKey, ICFBamClearTopDepObj> dict;
		if( indexByClrTopDepTblIdx == null ) {
			indexByClrTopDepTblIdx = new HashMap< CFBamClearTopDepByClrTopDepTblIdxKey,
				Map< CFBamScopePKey, ICFBamClearTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByClrTopDepTblIdx.containsKey( key ) ) {
			dict = indexByClrTopDepTblIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearTopDepObj>();
			ICFBamClearTopDepObj obj;
			CFBamClearTopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().readDerivedByClrTopDepTblIdx( schema.getAuthorization(),
				TableTenantId,
				TableId );
			CFBamClearTopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearTopDepObj realised = (ICFBamClearTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClrTopDepTblIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearTopDepObj arr[] = new ICFBamClearTopDepObj[len];
		Iterator<ICFBamClearTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearTopDepObj> arrayList = new ArrayList<ICFBamClearTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearTopDepObj> cmp = new Comparator<ICFBamClearTopDepObj>() {
			public int compare( ICFBamClearTopDepObj lhs, ICFBamClearTopDepObj rhs ) {
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
		List<ICFBamClearTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearTopDepObj readClearTopDepByUNameIdx( long TableTenantId,
		long TableId,
		String Name )
	{
		return( readClearTopDepByUNameIdx( TableTenantId,
			TableId,
			Name,
			false ) );
	}

	public ICFBamClearTopDepObj readClearTopDepByUNameIdx( long TableTenantId,
		long TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamClearTopDepByUNameIdxKey,
				ICFBamClearTopDepObj >();
		}
		CFBamClearTopDepByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newUNameIdxKey();
		key.setRequiredTableTenantId( TableTenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamClearTopDepObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamClearTopDepBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().readDerivedByUNameIdx( schema.getAuthorization(),
				TableTenantId,
				TableId,
				Name );
			if( buff != null ) {
				obj = (ICFBamClearTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamClearTopDepObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFBamClearTopDepObj> readClearTopDepByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		return( readClearTopDepByPrevIdx( PrevTenantId,
			PrevId,
			false ) );
	}

	public List<ICFBamClearTopDepObj> readClearTopDepByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearTopDepByPrevIdx";
		CFBamClearTopDepByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamScopePKey, ICFBamClearTopDepObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamClearTopDepByPrevIdxKey,
				Map< CFBamScopePKey, ICFBamClearTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearTopDepObj>();
			ICFBamClearTopDepObj obj;
			CFBamClearTopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().readDerivedByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			CFBamClearTopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearTopDepObj realised = (ICFBamClearTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearTopDepObj arr[] = new ICFBamClearTopDepObj[len];
		Iterator<ICFBamClearTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearTopDepObj> arrayList = new ArrayList<ICFBamClearTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearTopDepObj> cmp = new Comparator<ICFBamClearTopDepObj>() {
			public int compare( ICFBamClearTopDepObj lhs, ICFBamClearTopDepObj rhs ) {
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
		List<ICFBamClearTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamClearTopDepObj> readClearTopDepByNextIdx( Long NextTenantId,
		Long NextId )
	{
		return( readClearTopDepByNextIdx( NextTenantId,
			NextId,
			false ) );
	}

	public List<ICFBamClearTopDepObj> readClearTopDepByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearTopDepByNextIdx";
		CFBamClearTopDepByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		Map<CFBamScopePKey, ICFBamClearTopDepObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamClearTopDepByNextIdxKey,
				Map< CFBamScopePKey, ICFBamClearTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamClearTopDepObj>();
			ICFBamClearTopDepObj obj;
			CFBamClearTopDepBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().readDerivedByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			CFBamClearTopDepBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamClearTopDepObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamClearTopDepObj realised = (ICFBamClearTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamClearTopDepObj arr[] = new ICFBamClearTopDepObj[len];
		Iterator<ICFBamClearTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamClearTopDepObj> arrayList = new ArrayList<ICFBamClearTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamClearTopDepObj> cmp = new Comparator<ICFBamClearTopDepObj>() {
			public int compare( ICFBamClearTopDepObj lhs, ICFBamClearTopDepObj rhs ) {
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
		List<ICFBamClearTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClearTopDepObj updateClearTopDep( ICFBamClearTopDepObj Obj ) {
		ICFBamClearTopDepObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().updateClearTopDep( schema.getAuthorization(),
			Obj.getClearTopDepBuff() );
		if( Obj.getClassCode().equals( "CLRT" ) ) {
			obj = (ICFBamClearTopDepObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteClearTopDep( ICFBamClearTopDepObj Obj ) {
		ICFBamClearTopDepObj obj = Obj;
		ICFBamClearTopDepObj prev = obj.getOptionalLookupPrev();
		ICFBamClearTopDepObj next = obj.getOptionalLookupNext();
		((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().deleteClearTopDep( schema.getAuthorization(),
			obj.getClearTopDepBuff() );
		obj.forget( true );
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	public void deleteClearTopDepByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamClearTopDepObj obj = readClearTopDep( pkey );
		if( obj != null ) {
			ICFBamClearTopDepEditObj editObj = (ICFBamClearTopDepEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamClearTopDepEditObj)obj.beginEdit();
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

	public void deleteClearTopDepByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamClearTopDepObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().deleteClearTopDepByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamClearTopDepObj> iter = dict.values().iterator();
			ICFBamClearTopDepObj obj;
			List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().deleteClearTopDepByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteClearTopDepByClearDepIdx( long TenantId,
		long RelationId )
	{
		CFBamClearDepByClearDepIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newClearDepIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByClearDepIdx == null ) {
			indexByClearDepIdx = new HashMap< CFBamClearDepByClearDepIdxKey,
				Map< CFBamScopePKey, ICFBamClearTopDepObj > >();
		}
		if( indexByClearDepIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj> dict = indexByClearDepIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().deleteClearTopDepByClearDepIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			Iterator<ICFBamClearTopDepObj> iter = dict.values().iterator();
			ICFBamClearTopDepObj obj;
			List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByClearDepIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().deleteClearTopDepByClearDepIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
		}
	}

	public void deleteClearTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamClearDepByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearDep().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamClearDepByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamClearTopDepObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().deleteClearTopDepByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamClearTopDepObj> iter = dict.values().iterator();
			ICFBamClearTopDepObj obj;
			List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().deleteClearTopDepByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteClearTopDepByClrTopDepTblIdx( long TableTenantId,
		long TableId )
	{
		CFBamClearTopDepByClrTopDepTblIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newClrTopDepTblIdxKey();
		key.setRequiredTableTenantId( TableTenantId );
		key.setRequiredTableId( TableId );
		if( indexByClrTopDepTblIdx == null ) {
			indexByClrTopDepTblIdx = new HashMap< CFBamClearTopDepByClrTopDepTblIdxKey,
				Map< CFBamScopePKey, ICFBamClearTopDepObj > >();
		}
		if( indexByClrTopDepTblIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj> dict = indexByClrTopDepTblIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().deleteClearTopDepByClrTopDepTblIdx( schema.getAuthorization(),
				TableTenantId,
				TableId );
			Iterator<ICFBamClearTopDepObj> iter = dict.values().iterator();
			ICFBamClearTopDepObj obj;
			List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByClrTopDepTblIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().deleteClearTopDepByClrTopDepTblIdx( schema.getAuthorization(),
				TableTenantId,
				TableId );
		}
	}

	public void deleteClearTopDepByUNameIdx( long TableTenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamClearTopDepByUNameIdxKey,
				ICFBamClearTopDepObj >();
		}
		CFBamClearTopDepByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newUNameIdxKey();
		key.setRequiredTableTenantId( TableTenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamClearTopDepObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().deleteClearTopDepByUNameIdx( schema.getAuthorization(),
				TableTenantId,
				TableId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().deleteClearTopDepByUNameIdx( schema.getAuthorization(),
				TableTenantId,
				TableId,
				Name );
		}
	}

	public void deleteClearTopDepByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		CFBamClearTopDepByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamClearTopDepByPrevIdxKey,
				Map< CFBamScopePKey, ICFBamClearTopDepObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj> dict = indexByPrevIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().deleteClearTopDepByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			Iterator<ICFBamClearTopDepObj> iter = dict.values().iterator();
			ICFBamClearTopDepObj obj;
			List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().deleteClearTopDepByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
		}
	}

	public void deleteClearTopDepByNextIdx( Long NextTenantId,
		Long NextId )
	{
		CFBamClearTopDepByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamClearTopDepByNextIdxKey,
				Map< CFBamScopePKey, ICFBamClearTopDepObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamClearTopDepObj> dict = indexByNextIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().deleteClearTopDepByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			Iterator<ICFBamClearTopDepObj> iter = dict.values().iterator();
			ICFBamClearTopDepObj obj;
			List<ICFBamClearTopDepObj> toForget = new LinkedList<ICFBamClearTopDepObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().deleteClearTopDepByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
		}
	}

	/**
	 *	Move the CFBamClearTopDepObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamClearTopDepObj refreshed cache instance.
	 */
	public ICFBamClearTopDepObj moveUpClearTopDep( ICFBamClearTopDepObj Obj ) {
		ICFBamClearTopDepObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveUpClearTopDep",
				"You cannot move an object that is being edited" );
		}
		CFBamClearTopDepBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().moveBuffUp( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getClearTopDepTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamClearTopDepObj)obj.realise();
			ICFBamClearTopDepObj prev = obj.getOptionalLookupPrev( true );
			ICFBamClearTopDepObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				ICFBamClearTopDepObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the CFBamClearTopDepObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamClearTopDepObj refreshed cache instance.
	 */
	public ICFBamClearTopDepObj moveDownClearTopDep( ICFBamClearTopDepObj Obj ) {
		ICFBamClearTopDepObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveDownClearTopDep",
				"You cannot move an object that is being edited" );
		}
		CFBamClearTopDepBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().moveBuffDown( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getClearTopDepTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamClearTopDepObj)obj.realise();
			ICFBamClearTopDepObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				ICFBamClearTopDepObj gprev = prev.getOptionalLookupPrev( true );
			}
			ICFBamClearTopDepObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}
