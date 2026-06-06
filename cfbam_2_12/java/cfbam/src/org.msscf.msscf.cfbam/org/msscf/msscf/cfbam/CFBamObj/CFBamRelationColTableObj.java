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

public class CFBamRelationColTableObj
	implements ICFBamRelationColTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamRelationColPKey, ICFBamRelationColObj> members;
	private Map<CFBamRelationColPKey, ICFBamRelationColObj> allRelationCol;
	private Map< CFBamRelationColByUNameIdxKey,
		ICFBamRelationColObj > indexByUNameIdx;
	private Map< CFBamRelationColByRelColTenantIdxKey,
		Map<CFBamRelationColPKey, ICFBamRelationColObj > > indexByRelColTenantIdx;
	private Map< CFBamRelationColByRelationIdxKey,
		Map<CFBamRelationColPKey, ICFBamRelationColObj > > indexByRelationIdx;
	private Map< CFBamRelationColByDefSchemaIdxKey,
		Map<CFBamRelationColPKey, ICFBamRelationColObj > > indexByDefSchemaIdx;
	private Map< CFBamRelationColByFromColIdxKey,
		Map<CFBamRelationColPKey, ICFBamRelationColObj > > indexByFromColIdx;
	private Map< CFBamRelationColByToColIdxKey,
		Map<CFBamRelationColPKey, ICFBamRelationColObj > > indexByToColIdx;
	private Map< CFBamRelationColByPrevIdxKey,
		Map<CFBamRelationColPKey, ICFBamRelationColObj > > indexByPrevIdx;
	private Map< CFBamRelationColByNextIdxKey,
		Map<CFBamRelationColPKey, ICFBamRelationColObj > > indexByNextIdx;
	private Map< CFBamRelationColByRelPrevIdxKey,
		Map<CFBamRelationColPKey, ICFBamRelationColObj > > indexByRelPrevIdx;
	private Map< CFBamRelationColByRelNextIdxKey,
		Map<CFBamRelationColPKey, ICFBamRelationColObj > > indexByRelNextIdx;
	public static String TABLE_NAME = "RelationCol";
	public static String TABLE_DBNAME = "relcol";

	public CFBamRelationColTableObj() {
		schema = null;
		members = new HashMap<CFBamRelationColPKey, ICFBamRelationColObj>();
		allRelationCol = null;
		indexByUNameIdx = null;
		indexByRelColTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByFromColIdx = null;
		indexByToColIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByRelPrevIdx = null;
		indexByRelNextIdx = null;
	}

	public CFBamRelationColTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamRelationColPKey, ICFBamRelationColObj>();
		allRelationCol = null;
		indexByUNameIdx = null;
		indexByRelColTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByFromColIdx = null;
		indexByToColIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByRelPrevIdx = null;
		indexByRelNextIdx = null;
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
		allRelationCol = null;
		indexByUNameIdx = null;
		indexByRelColTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByFromColIdx = null;
		indexByToColIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByRelPrevIdx = null;
		indexByRelNextIdx = null;
		List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
		ICFBamRelationColObj cur = null;
		Iterator<ICFBamRelationColObj> iter = members.values().iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			toForget.add( cur );
		}
		iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget();
		}
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamRelationColObj.
	 */
	public ICFBamRelationColObj newInstance() {
		ICFBamRelationColObj inst = new CFBamRelationColObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamRelationColObj.
	 */
	public ICFBamRelationColEditObj newEditInstance( ICFBamRelationColObj orig ) {
		ICFBamRelationColEditObj edit = new CFBamRelationColEditObj( orig );
		return( edit );
	}

	public ICFBamRelationColObj realiseRelationCol( ICFBamRelationColObj Obj ) {
		ICFBamRelationColObj obj = Obj;
		CFBamRelationColPKey pkey = obj.getPKey();
		ICFBamRelationColObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamRelationColObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				CFBamRelationColByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByRelColTenantIdx != null ) {
				CFBamRelationColByRelColTenantIdxKey keyRelColTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelColTenantIdxKey();
				keyRelColTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelColTenantIdx = indexByRelColTenantIdx.get( keyRelColTenantIdx );
				if( mapRelColTenantIdx != null ) {
					mapRelColTenantIdx.remove( keepObj.getPKey() );
					if( mapRelColTenantIdx.size() <= 0 ) {
						indexByRelColTenantIdx.remove( keyRelColTenantIdx );
					}
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamRelationColByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelationIdxKey();
				keyRelationIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.remove( keepObj.getPKey() );
					if( mapRelationIdx.size() <= 0 ) {
						indexByRelationIdx.remove( keyRelationIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamRelationColByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByFromColIdx != null ) {
				CFBamRelationColByFromColIdxKey keyFromColIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newFromColIdxKey();
				keyFromColIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyFromColIdx.setRequiredFromColId( keepObj.getRequiredFromColId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapFromColIdx = indexByFromColIdx.get( keyFromColIdx );
				if( mapFromColIdx != null ) {
					mapFromColIdx.remove( keepObj.getPKey() );
					if( mapFromColIdx.size() <= 0 ) {
						indexByFromColIdx.remove( keyFromColIdx );
					}
				}
			}

			if( indexByToColIdx != null ) {
				CFBamRelationColByToColIdxKey keyToColIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newToColIdxKey();
				keyToColIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToColIdx.setRequiredToColId( keepObj.getRequiredToColId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapToColIdx = indexByToColIdx.get( keyToColIdx );
				if( mapToColIdx != null ) {
					mapToColIdx.remove( keepObj.getPKey() );
					if( mapToColIdx.size() <= 0 ) {
						indexByToColIdx.remove( keyToColIdx );
					}
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamRelationColByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				CFBamRelationColByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
					if( mapNextIdx.size() <= 0 ) {
						indexByNextIdx.remove( keyNextIdx );
					}
				}
			}

			if( indexByRelPrevIdx != null ) {
				CFBamRelationColByRelPrevIdxKey keyRelPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelPrevIdxKey();
				keyRelPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyRelPrevIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				keyRelPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelPrevIdx = indexByRelPrevIdx.get( keyRelPrevIdx );
				if( mapRelPrevIdx != null ) {
					mapRelPrevIdx.remove( keepObj.getPKey() );
					if( mapRelPrevIdx.size() <= 0 ) {
						indexByRelPrevIdx.remove( keyRelPrevIdx );
					}
				}
			}

			if( indexByRelNextIdx != null ) {
				CFBamRelationColByRelNextIdxKey keyRelNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelNextIdxKey();
				keyRelNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyRelNextIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				keyRelNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelNextIdx = indexByRelNextIdx.get( keyRelNextIdx );
				if( mapRelNextIdx != null ) {
					mapRelNextIdx.remove( keepObj.getPKey() );
					if( mapRelNextIdx.size() <= 0 ) {
						indexByRelNextIdx.remove( keyRelNextIdx );
					}
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				CFBamRelationColByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByRelColTenantIdx != null ) {
				CFBamRelationColByRelColTenantIdxKey keyRelColTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelColTenantIdxKey();
				keyRelColTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelColTenantIdx = indexByRelColTenantIdx.get( keyRelColTenantIdx );
				if( mapRelColTenantIdx != null ) {
					mapRelColTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamRelationColByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelationIdxKey();
				keyRelationIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamRelationColByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByFromColIdx != null ) {
				CFBamRelationColByFromColIdxKey keyFromColIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newFromColIdxKey();
				keyFromColIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyFromColIdx.setRequiredFromColId( keepObj.getRequiredFromColId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapFromColIdx = indexByFromColIdx.get( keyFromColIdx );
				if( mapFromColIdx != null ) {
					mapFromColIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToColIdx != null ) {
				CFBamRelationColByToColIdxKey keyToColIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newToColIdxKey();
				keyToColIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToColIdx.setRequiredToColId( keepObj.getRequiredToColId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapToColIdx = indexByToColIdx.get( keyToColIdx );
				if( mapToColIdx != null ) {
					mapToColIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamRelationColByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamRelationColByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelPrevIdx != null ) {
				CFBamRelationColByRelPrevIdxKey keyRelPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelPrevIdxKey();
				keyRelPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyRelPrevIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				keyRelPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelPrevIdx = indexByRelPrevIdx.get( keyRelPrevIdx );
				if( mapRelPrevIdx != null ) {
					mapRelPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelNextIdx != null ) {
				CFBamRelationColByRelNextIdxKey keyRelNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelNextIdxKey();
				keyRelNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyRelNextIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				keyRelNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelNextIdx = indexByRelNextIdx.get( keyRelNextIdx );
				if( mapRelNextIdx != null ) {
					mapRelNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allRelationCol != null ) {
				allRelationCol.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allRelationCol != null ) {
				allRelationCol.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				CFBamRelationColByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByRelColTenantIdx != null ) {
				CFBamRelationColByRelColTenantIdxKey keyRelColTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelColTenantIdxKey();
				keyRelColTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelColTenantIdx = indexByRelColTenantIdx.get( keyRelColTenantIdx );
				if( mapRelColTenantIdx != null ) {
					mapRelColTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamRelationColByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelationIdxKey();
				keyRelationIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamRelationColByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByFromColIdx != null ) {
				CFBamRelationColByFromColIdxKey keyFromColIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newFromColIdxKey();
				keyFromColIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyFromColIdx.setRequiredFromColId( keepObj.getRequiredFromColId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapFromColIdx = indexByFromColIdx.get( keyFromColIdx );
				if( mapFromColIdx != null ) {
					mapFromColIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToColIdx != null ) {
				CFBamRelationColByToColIdxKey keyToColIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newToColIdxKey();
				keyToColIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToColIdx.setRequiredToColId( keepObj.getRequiredToColId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapToColIdx = indexByToColIdx.get( keyToColIdx );
				if( mapToColIdx != null ) {
					mapToColIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamRelationColByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamRelationColByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelPrevIdx != null ) {
				CFBamRelationColByRelPrevIdxKey keyRelPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelPrevIdxKey();
				keyRelPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyRelPrevIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				keyRelPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelPrevIdx = indexByRelPrevIdx.get( keyRelPrevIdx );
				if( mapRelPrevIdx != null ) {
					mapRelPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelNextIdx != null ) {
				CFBamRelationColByRelNextIdxKey keyRelNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelNextIdxKey();
				keyRelNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyRelNextIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				keyRelNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelNextIdx = indexByRelNextIdx.get( keyRelNextIdx );
				if( mapRelNextIdx != null ) {
					mapRelNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetRelationCol( ICFBamRelationColObj Obj ) {
		forgetRelationCol( Obj, false );
	}

	public void forgetRelationCol( ICFBamRelationColObj Obj, boolean forgetSubObjects ) {
		ICFBamRelationColObj obj = Obj;
		CFBamRelationColPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamRelationColObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUNameIdx != null ) {
				CFBamRelationColByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByRelColTenantIdx != null ) {
				CFBamRelationColByRelColTenantIdxKey keyRelColTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelColTenantIdxKey();
				keyRelColTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelColTenantIdx = indexByRelColTenantIdx.get( keyRelColTenantIdx );
				if( mapRelColTenantIdx != null ) {
					mapRelColTenantIdx.remove( keepObj.getPKey() );
					if( mapRelColTenantIdx.size() <= 0 ) {
						indexByRelColTenantIdx.remove( keyRelColTenantIdx );
					}
				}
			}

			if( indexByRelationIdx != null ) {
				CFBamRelationColByRelationIdxKey keyRelationIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelationIdxKey();
				keyRelationIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.remove( keepObj.getPKey() );
					if( mapRelationIdx.size() <= 0 ) {
						indexByRelationIdx.remove( keyRelationIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamRelationColByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByFromColIdx != null ) {
				CFBamRelationColByFromColIdxKey keyFromColIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newFromColIdxKey();
				keyFromColIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyFromColIdx.setRequiredFromColId( keepObj.getRequiredFromColId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapFromColIdx = indexByFromColIdx.get( keyFromColIdx );
				if( mapFromColIdx != null ) {
					mapFromColIdx.remove( keepObj.getPKey() );
					if( mapFromColIdx.size() <= 0 ) {
						indexByFromColIdx.remove( keyFromColIdx );
					}
				}
			}

			if( indexByToColIdx != null ) {
				CFBamRelationColByToColIdxKey keyToColIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newToColIdxKey();
				keyToColIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyToColIdx.setRequiredToColId( keepObj.getRequiredToColId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapToColIdx = indexByToColIdx.get( keyToColIdx );
				if( mapToColIdx != null ) {
					mapToColIdx.remove( keepObj.getPKey() );
					if( mapToColIdx.size() <= 0 ) {
						indexByToColIdx.remove( keyToColIdx );
					}
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamRelationColByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				CFBamRelationColByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
					if( mapNextIdx.size() <= 0 ) {
						indexByNextIdx.remove( keyNextIdx );
					}
				}
			}

			if( indexByRelPrevIdx != null ) {
				CFBamRelationColByRelPrevIdxKey keyRelPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelPrevIdxKey();
				keyRelPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyRelPrevIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				keyRelPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelPrevIdx = indexByRelPrevIdx.get( keyRelPrevIdx );
				if( mapRelPrevIdx != null ) {
					mapRelPrevIdx.remove( keepObj.getPKey() );
					if( mapRelPrevIdx.size() <= 0 ) {
						indexByRelPrevIdx.remove( keyRelPrevIdx );
					}
				}
			}

			if( indexByRelNextIdx != null ) {
				CFBamRelationColByRelNextIdxKey keyRelNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelNextIdxKey();
				keyRelNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyRelNextIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				keyRelNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelNextIdx = indexByRelNextIdx.get( keyRelNextIdx );
				if( mapRelNextIdx != null ) {
					mapRelNextIdx.remove( keepObj.getPKey() );
					if( mapRelNextIdx.size() <= 0 ) {
						indexByRelNextIdx.remove( keyRelNextIdx );
					}
				}
			}

			if( allRelationCol != null ) {
				allRelationCol.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetRelationColByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamRelationColPKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamRelationColObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetRelationColByUNameIdx( long TenantId,
		long RelationId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
		ICFBamRelationColObj cur = null;
		CFBamRelationColByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamRelationColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetRelationColByRelColTenantIdx( long TenantId )
	{
		if( indexByRelColTenantIdx == null ) {
			return;
		}
		List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
		ICFBamRelationColObj cur = null;
		CFBamRelationColByRelColTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelColTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByRelColTenantIdx.containsKey( key ) ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelColTenantIdx = indexByRelColTenantIdx.get( key );
			if( mapRelColTenantIdx != null ) {
				Iterator<ICFBamRelationColObj> iterDup = mapRelColTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRelColTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamRelationColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamRelationColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetRelationColByRelationIdx( long TenantId,
		long RelationId )
	{
		if( indexByRelationIdx == null ) {
			return;
		}
		List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
		ICFBamRelationColObj cur = null;
		CFBamRelationColByRelationIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelationIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelationIdx = indexByRelationIdx.get( key );
			if( mapRelationIdx != null ) {
				Iterator<ICFBamRelationColObj> iterDup = mapRelationIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRelationIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamRelationColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamRelationColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetRelationColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
		ICFBamRelationColObj cur = null;
		CFBamRelationColByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamRelationColObj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamRelationColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamRelationColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetRelationColByFromColIdx( long TenantId,
		long FromColId )
	{
		if( indexByFromColIdx == null ) {
			return;
		}
		List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
		ICFBamRelationColObj cur = null;
		CFBamRelationColByFromColIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newFromColIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredFromColId( FromColId );
		if( indexByFromColIdx.containsKey( key ) ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj > mapFromColIdx = indexByFromColIdx.get( key );
			if( mapFromColIdx != null ) {
				Iterator<ICFBamRelationColObj> iterDup = mapFromColIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByFromColIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamRelationColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamRelationColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetRelationColByToColIdx( long TenantId,
		long ToColId )
	{
		if( indexByToColIdx == null ) {
			return;
		}
		List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
		ICFBamRelationColObj cur = null;
		CFBamRelationColByToColIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newToColIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToColId( ToColId );
		if( indexByToColIdx.containsKey( key ) ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj > mapToColIdx = indexByToColIdx.get( key );
			if( mapToColIdx != null ) {
				Iterator<ICFBamRelationColObj> iterDup = mapToColIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByToColIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamRelationColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamRelationColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetRelationColByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		if( indexByPrevIdx == null ) {
			return;
		}
		List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
		ICFBamRelationColObj cur = null;
		CFBamRelationColByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj > mapPrevIdx = indexByPrevIdx.get( key );
			if( mapPrevIdx != null ) {
				Iterator<ICFBamRelationColObj> iterDup = mapPrevIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByPrevIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamRelationColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamRelationColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetRelationColByNextIdx( Long NextTenantId,
		Long NextId )
	{
		if( indexByNextIdx == null ) {
			return;
		}
		List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
		ICFBamRelationColObj cur = null;
		CFBamRelationColByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj > mapNextIdx = indexByNextIdx.get( key );
			if( mapNextIdx != null ) {
				Iterator<ICFBamRelationColObj> iterDup = mapNextIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByNextIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamRelationColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamRelationColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetRelationColByRelPrevIdx( long TenantId,
		long RelationId,
		Long PrevId )
	{
		if( indexByRelPrevIdx == null ) {
			return;
		}
		List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
		ICFBamRelationColObj cur = null;
		CFBamRelationColByRelPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		key.setOptionalPrevId( PrevId );
		if( indexByRelPrevIdx.containsKey( key ) ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelPrevIdx = indexByRelPrevIdx.get( key );
			if( mapRelPrevIdx != null ) {
				Iterator<ICFBamRelationColObj> iterDup = mapRelPrevIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRelPrevIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamRelationColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamRelationColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetRelationColByRelNextIdx( long TenantId,
		long RelationId,
		Long NextId )
	{
		if( indexByRelNextIdx == null ) {
			return;
		}
		List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
		ICFBamRelationColObj cur = null;
		CFBamRelationColByRelNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		key.setOptionalNextId( NextId );
		if( indexByRelNextIdx.containsKey( key ) ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj > mapRelNextIdx = indexByRelNextIdx.get( key );
			if( mapRelNextIdx != null ) {
				Iterator<ICFBamRelationColObj> iterDup = mapRelNextIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRelNextIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamRelationColObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamRelationColObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamRelationColObj createRelationCol( ICFBamRelationColObj Obj ) {
		ICFBamRelationColObj obj = Obj;
		CFBamRelationColBuff buff = obj.getRelationColBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().createRelationCol(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		ICFBamRelationColObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamRelationColObj readRelationCol( CFBamRelationColPKey pkey ) {
		return( readRelationCol( pkey, false ) );
	}

	public ICFBamRelationColObj readRelationCol( CFBamRelationColPKey pkey, boolean forceRead ) {
		ICFBamRelationColObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamRelationColBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getRelationColTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamRelationColObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamRelationColObj lockRelationCol( CFBamRelationColPKey pkey ) {
		ICFBamRelationColObj locked = null;
		CFBamRelationColBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getRelationColTableObj().newInstance();
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamRelationColObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockRelationCol", pkey );
		}
		return( locked );
	}

	public List<ICFBamRelationColObj> readAllRelationCol() {
		return( readAllRelationCol( false ) );
	}

	public List<ICFBamRelationColObj> readAllRelationCol( boolean forceRead ) {
		final String S_ProcName = "readAllRelationCol";
		if( ( allRelationCol == null ) || forceRead ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj> map = new HashMap<CFBamRelationColPKey,ICFBamRelationColObj>();
			allRelationCol = map;
			CFBamRelationColBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().readAllDerived( schema.getAuthorization() );
			CFBamRelationColBuff buff;
			ICFBamRelationColObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationColObj realised = (ICFBamRelationColObj)obj.realise();
			}
		}
		int len = allRelationCol.size();
		ICFBamRelationColObj arr[] = new ICFBamRelationColObj[len];
		Iterator<ICFBamRelationColObj> valIter = allRelationCol.values().iterator();
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
		ArrayList<ICFBamRelationColObj> arrayList = new ArrayList<ICFBamRelationColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationColObj> cmp = new Comparator<ICFBamRelationColObj>() {
			public int compare( ICFBamRelationColObj lhs, ICFBamRelationColObj rhs ) {
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
					CFBamRelationColPKey lhsPKey = lhs.getPKey();
					CFBamRelationColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamRelationColObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamRelationColObj readRelationColByIdIdx( long TenantId,
		long Id )
	{
		return( readRelationColByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamRelationColObj readRelationColByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamRelationColPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamRelationColObj obj = readRelationCol( pkey, forceRead );
		return( obj );
	}

	public ICFBamRelationColObj readRelationColByUNameIdx( long TenantId,
		long RelationId,
		String Name )
	{
		return( readRelationColByUNameIdx( TenantId,
			RelationId,
			Name,
			false ) );
	}

	public ICFBamRelationColObj readRelationColByUNameIdx( long TenantId,
		long RelationId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamRelationColByUNameIdxKey,
				ICFBamRelationColObj >();
		}
		CFBamRelationColByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		key.setRequiredName( Name );
		ICFBamRelationColObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamRelationColBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				RelationId,
				Name );
			if( buff != null ) {
				obj = schema.getRelationColTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamRelationColObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFBamRelationColObj> readRelationColByRelColTenantIdx( long TenantId )
	{
		return( readRelationColByRelColTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamRelationColObj> readRelationColByRelColTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationColByRelColTenantIdx";
		CFBamRelationColByRelColTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelColTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamRelationColPKey, ICFBamRelationColObj> dict;
		if( indexByRelColTenantIdx == null ) {
			indexByRelColTenantIdx = new HashMap< CFBamRelationColByRelColTenantIdxKey,
				Map< CFBamRelationColPKey, ICFBamRelationColObj > >();
		}
		if( ( ! forceRead ) && indexByRelColTenantIdx.containsKey( key ) ) {
			dict = indexByRelColTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamRelationColPKey, ICFBamRelationColObj>();
			ICFBamRelationColObj obj;
			CFBamRelationColBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().readDerivedByRelColTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamRelationColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getRelationColTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationColObj realised = (ICFBamRelationColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRelColTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamRelationColObj arr[] = new ICFBamRelationColObj[len];
		Iterator<ICFBamRelationColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationColObj> arrayList = new ArrayList<ICFBamRelationColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationColObj> cmp = new Comparator<ICFBamRelationColObj>() {
			public int compare( ICFBamRelationColObj lhs, ICFBamRelationColObj rhs ) {
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
					CFBamRelationColPKey lhsPKey = lhs.getPKey();
					CFBamRelationColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamRelationColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationColObj> readRelationColByRelationIdx( long TenantId,
		long RelationId )
	{
		return( readRelationColByRelationIdx( TenantId,
			RelationId,
			false ) );
	}

	public List<ICFBamRelationColObj> readRelationColByRelationIdx( long TenantId,
		long RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationColByRelationIdx";
		CFBamRelationColByRelationIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelationIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		Map<CFBamRelationColPKey, ICFBamRelationColObj> dict;
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< CFBamRelationColByRelationIdxKey,
				Map< CFBamRelationColPKey, ICFBamRelationColObj > >();
		}
		if( ( ! forceRead ) && indexByRelationIdx.containsKey( key ) ) {
			dict = indexByRelationIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamRelationColPKey, ICFBamRelationColObj>();
			ICFBamRelationColObj obj;
			CFBamRelationColBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().readDerivedByRelationIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			CFBamRelationColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getRelationColTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationColObj realised = (ICFBamRelationColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRelationIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamRelationColObj arr[] = new ICFBamRelationColObj[len];
		Iterator<ICFBamRelationColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationColObj> arrayList = new ArrayList<ICFBamRelationColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationColObj> cmp = new Comparator<ICFBamRelationColObj>() {
			public int compare( ICFBamRelationColObj lhs, ICFBamRelationColObj rhs ) {
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
					CFBamRelationColPKey lhsPKey = lhs.getPKey();
					CFBamRelationColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamRelationColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationColObj> readRelationColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readRelationColByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamRelationColObj> readRelationColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationColByDefSchemaIdx";
		CFBamRelationColByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamRelationColPKey, ICFBamRelationColObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamRelationColByDefSchemaIdxKey,
				Map< CFBamRelationColPKey, ICFBamRelationColObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamRelationColPKey, ICFBamRelationColObj>();
			ICFBamRelationColObj obj;
			CFBamRelationColBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamRelationColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getRelationColTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationColObj realised = (ICFBamRelationColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamRelationColObj arr[] = new ICFBamRelationColObj[len];
		Iterator<ICFBamRelationColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationColObj> arrayList = new ArrayList<ICFBamRelationColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationColObj> cmp = new Comparator<ICFBamRelationColObj>() {
			public int compare( ICFBamRelationColObj lhs, ICFBamRelationColObj rhs ) {
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
					CFBamRelationColPKey lhsPKey = lhs.getPKey();
					CFBamRelationColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamRelationColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationColObj> readRelationColByFromColIdx( long TenantId,
		long FromColId )
	{
		return( readRelationColByFromColIdx( TenantId,
			FromColId,
			false ) );
	}

	public List<ICFBamRelationColObj> readRelationColByFromColIdx( long TenantId,
		long FromColId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationColByFromColIdx";
		CFBamRelationColByFromColIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newFromColIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredFromColId( FromColId );
		Map<CFBamRelationColPKey, ICFBamRelationColObj> dict;
		if( indexByFromColIdx == null ) {
			indexByFromColIdx = new HashMap< CFBamRelationColByFromColIdxKey,
				Map< CFBamRelationColPKey, ICFBamRelationColObj > >();
		}
		if( ( ! forceRead ) && indexByFromColIdx.containsKey( key ) ) {
			dict = indexByFromColIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamRelationColPKey, ICFBamRelationColObj>();
			ICFBamRelationColObj obj;
			CFBamRelationColBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().readDerivedByFromColIdx( schema.getAuthorization(),
				TenantId,
				FromColId );
			CFBamRelationColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getRelationColTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationColObj realised = (ICFBamRelationColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByFromColIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamRelationColObj arr[] = new ICFBamRelationColObj[len];
		Iterator<ICFBamRelationColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationColObj> arrayList = new ArrayList<ICFBamRelationColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationColObj> cmp = new Comparator<ICFBamRelationColObj>() {
			public int compare( ICFBamRelationColObj lhs, ICFBamRelationColObj rhs ) {
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
					CFBamRelationColPKey lhsPKey = lhs.getPKey();
					CFBamRelationColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamRelationColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationColObj> readRelationColByToColIdx( long TenantId,
		long ToColId )
	{
		return( readRelationColByToColIdx( TenantId,
			ToColId,
			false ) );
	}

	public List<ICFBamRelationColObj> readRelationColByToColIdx( long TenantId,
		long ToColId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationColByToColIdx";
		CFBamRelationColByToColIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newToColIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToColId( ToColId );
		Map<CFBamRelationColPKey, ICFBamRelationColObj> dict;
		if( indexByToColIdx == null ) {
			indexByToColIdx = new HashMap< CFBamRelationColByToColIdxKey,
				Map< CFBamRelationColPKey, ICFBamRelationColObj > >();
		}
		if( ( ! forceRead ) && indexByToColIdx.containsKey( key ) ) {
			dict = indexByToColIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamRelationColPKey, ICFBamRelationColObj>();
			ICFBamRelationColObj obj;
			CFBamRelationColBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().readDerivedByToColIdx( schema.getAuthorization(),
				TenantId,
				ToColId );
			CFBamRelationColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getRelationColTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationColObj realised = (ICFBamRelationColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByToColIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamRelationColObj arr[] = new ICFBamRelationColObj[len];
		Iterator<ICFBamRelationColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationColObj> arrayList = new ArrayList<ICFBamRelationColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationColObj> cmp = new Comparator<ICFBamRelationColObj>() {
			public int compare( ICFBamRelationColObj lhs, ICFBamRelationColObj rhs ) {
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
					CFBamRelationColPKey lhsPKey = lhs.getPKey();
					CFBamRelationColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamRelationColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationColObj> readRelationColByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		return( readRelationColByPrevIdx( PrevTenantId,
			PrevId,
			false ) );
	}

	public List<ICFBamRelationColObj> readRelationColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationColByPrevIdx";
		CFBamRelationColByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamRelationColPKey, ICFBamRelationColObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamRelationColByPrevIdxKey,
				Map< CFBamRelationColPKey, ICFBamRelationColObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamRelationColPKey, ICFBamRelationColObj>();
			ICFBamRelationColObj obj;
			CFBamRelationColBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().readDerivedByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			CFBamRelationColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getRelationColTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationColObj realised = (ICFBamRelationColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamRelationColObj arr[] = new ICFBamRelationColObj[len];
		Iterator<ICFBamRelationColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationColObj> arrayList = new ArrayList<ICFBamRelationColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationColObj> cmp = new Comparator<ICFBamRelationColObj>() {
			public int compare( ICFBamRelationColObj lhs, ICFBamRelationColObj rhs ) {
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
					CFBamRelationColPKey lhsPKey = lhs.getPKey();
					CFBamRelationColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamRelationColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationColObj> readRelationColByNextIdx( Long NextTenantId,
		Long NextId )
	{
		return( readRelationColByNextIdx( NextTenantId,
			NextId,
			false ) );
	}

	public List<ICFBamRelationColObj> readRelationColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationColByNextIdx";
		CFBamRelationColByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		Map<CFBamRelationColPKey, ICFBamRelationColObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamRelationColByNextIdxKey,
				Map< CFBamRelationColPKey, ICFBamRelationColObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamRelationColPKey, ICFBamRelationColObj>();
			ICFBamRelationColObj obj;
			CFBamRelationColBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().readDerivedByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			CFBamRelationColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getRelationColTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationColObj realised = (ICFBamRelationColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamRelationColObj arr[] = new ICFBamRelationColObj[len];
		Iterator<ICFBamRelationColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationColObj> arrayList = new ArrayList<ICFBamRelationColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationColObj> cmp = new Comparator<ICFBamRelationColObj>() {
			public int compare( ICFBamRelationColObj lhs, ICFBamRelationColObj rhs ) {
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
					CFBamRelationColPKey lhsPKey = lhs.getPKey();
					CFBamRelationColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamRelationColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationColObj> readRelationColByRelPrevIdx( long TenantId,
		long RelationId,
		Long PrevId )
	{
		return( readRelationColByRelPrevIdx( TenantId,
			RelationId,
			PrevId,
			false ) );
	}

	public List<ICFBamRelationColObj> readRelationColByRelPrevIdx( long TenantId,
		long RelationId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationColByRelPrevIdx";
		CFBamRelationColByRelPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamRelationColPKey, ICFBamRelationColObj> dict;
		if( indexByRelPrevIdx == null ) {
			indexByRelPrevIdx = new HashMap< CFBamRelationColByRelPrevIdxKey,
				Map< CFBamRelationColPKey, ICFBamRelationColObj > >();
		}
		if( ( ! forceRead ) && indexByRelPrevIdx.containsKey( key ) ) {
			dict = indexByRelPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamRelationColPKey, ICFBamRelationColObj>();
			ICFBamRelationColObj obj;
			CFBamRelationColBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().readDerivedByRelPrevIdx( schema.getAuthorization(),
				TenantId,
				RelationId,
				PrevId );
			CFBamRelationColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getRelationColTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationColObj realised = (ICFBamRelationColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRelPrevIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamRelationColObj arr[] = new ICFBamRelationColObj[len];
		Iterator<ICFBamRelationColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationColObj> arrayList = new ArrayList<ICFBamRelationColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationColObj> cmp = new Comparator<ICFBamRelationColObj>() {
			public int compare( ICFBamRelationColObj lhs, ICFBamRelationColObj rhs ) {
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
					CFBamRelationColPKey lhsPKey = lhs.getPKey();
					CFBamRelationColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamRelationColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamRelationColObj> readRelationColByRelNextIdx( long TenantId,
		long RelationId,
		Long NextId )
	{
		return( readRelationColByRelNextIdx( TenantId,
			RelationId,
			NextId,
			false ) );
	}

	public List<ICFBamRelationColObj> readRelationColByRelNextIdx( long TenantId,
		long RelationId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationColByRelNextIdx";
		CFBamRelationColByRelNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		key.setOptionalNextId( NextId );
		Map<CFBamRelationColPKey, ICFBamRelationColObj> dict;
		if( indexByRelNextIdx == null ) {
			indexByRelNextIdx = new HashMap< CFBamRelationColByRelNextIdxKey,
				Map< CFBamRelationColPKey, ICFBamRelationColObj > >();
		}
		if( ( ! forceRead ) && indexByRelNextIdx.containsKey( key ) ) {
			dict = indexByRelNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamRelationColPKey, ICFBamRelationColObj>();
			ICFBamRelationColObj obj;
			CFBamRelationColBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().readDerivedByRelNextIdx( schema.getAuthorization(),
				TenantId,
				RelationId,
				NextId );
			CFBamRelationColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getRelationColTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey() );
				obj.setBuff( buff );
				ICFBamRelationColObj realised = (ICFBamRelationColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRelNextIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamRelationColObj arr[] = new ICFBamRelationColObj[len];
		Iterator<ICFBamRelationColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamRelationColObj> arrayList = new ArrayList<ICFBamRelationColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamRelationColObj> cmp = new Comparator<ICFBamRelationColObj>() {
			public int compare( ICFBamRelationColObj lhs, ICFBamRelationColObj rhs ) {
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
					CFBamRelationColPKey lhsPKey = lhs.getPKey();
					CFBamRelationColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamRelationColObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamRelationColObj updateRelationCol( ICFBamRelationColObj Obj ) {
		ICFBamRelationColObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().updateRelationCol( schema.getAuthorization(),
			Obj.getRelationColBuff() );
		obj = (ICFBamRelationColObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteRelationCol( ICFBamRelationColObj Obj ) {
		ICFBamRelationColObj obj = Obj;
		ICFBamRelationColObj prev = obj.getOptionalLookupPrev();
		ICFBamRelationColObj next = obj.getOptionalLookupNext();
		((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationCol( schema.getAuthorization(),
			obj.getRelationColBuff() );
		obj.forget( true );
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	public void deleteRelationColByIdIdx( long TenantId,
		long Id )
	{
		CFBamRelationColPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamRelationColObj obj = readRelationCol( pkey );
		if( obj != null ) {
			ICFBamRelationColEditObj editObj = (ICFBamRelationColEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamRelationColEditObj)obj.beginEdit();
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

	public void deleteRelationColByUNameIdx( long TenantId,
		long RelationId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamRelationColByUNameIdxKey,
				ICFBamRelationColObj >();
		}
		CFBamRelationColByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		key.setRequiredName( Name );
		ICFBamRelationColObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByUNameIdx( schema.getAuthorization(),
				TenantId,
				RelationId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByUNameIdx( schema.getAuthorization(),
				TenantId,
				RelationId,
				Name );
		}
	}

	public void deleteRelationColByRelColTenantIdx( long TenantId )
	{
		CFBamRelationColByRelColTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelColTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByRelColTenantIdx == null ) {
			indexByRelColTenantIdx = new HashMap< CFBamRelationColByRelColTenantIdxKey,
				Map< CFBamRelationColPKey, ICFBamRelationColObj > >();
		}
		if( indexByRelColTenantIdx.containsKey( key ) ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj> dict = indexByRelColTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByRelColTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamRelationColObj> iter = dict.values().iterator();
			ICFBamRelationColObj obj;
			List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByRelColTenantIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByRelColTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteRelationColByRelationIdx( long TenantId,
		long RelationId )
	{
		CFBamRelationColByRelationIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelationIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< CFBamRelationColByRelationIdxKey,
				Map< CFBamRelationColPKey, ICFBamRelationColObj > >();
		}
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj> dict = indexByRelationIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByRelationIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
			Iterator<ICFBamRelationColObj> iter = dict.values().iterator();
			ICFBamRelationColObj obj;
			List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByRelationIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByRelationIdx( schema.getAuthorization(),
				TenantId,
				RelationId );
		}
	}

	public void deleteRelationColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamRelationColByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamRelationColByDefSchemaIdxKey,
				Map< CFBamRelationColPKey, ICFBamRelationColObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamRelationColObj> iter = dict.values().iterator();
			ICFBamRelationColObj obj;
			List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteRelationColByFromColIdx( long TenantId,
		long FromColId )
	{
		CFBamRelationColByFromColIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newFromColIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredFromColId( FromColId );
		if( indexByFromColIdx == null ) {
			indexByFromColIdx = new HashMap< CFBamRelationColByFromColIdxKey,
				Map< CFBamRelationColPKey, ICFBamRelationColObj > >();
		}
		if( indexByFromColIdx.containsKey( key ) ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj> dict = indexByFromColIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByFromColIdx( schema.getAuthorization(),
				TenantId,
				FromColId );
			Iterator<ICFBamRelationColObj> iter = dict.values().iterator();
			ICFBamRelationColObj obj;
			List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByFromColIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByFromColIdx( schema.getAuthorization(),
				TenantId,
				FromColId );
		}
	}

	public void deleteRelationColByToColIdx( long TenantId,
		long ToColId )
	{
		CFBamRelationColByToColIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newToColIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredToColId( ToColId );
		if( indexByToColIdx == null ) {
			indexByToColIdx = new HashMap< CFBamRelationColByToColIdxKey,
				Map< CFBamRelationColPKey, ICFBamRelationColObj > >();
		}
		if( indexByToColIdx.containsKey( key ) ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj> dict = indexByToColIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByToColIdx( schema.getAuthorization(),
				TenantId,
				ToColId );
			Iterator<ICFBamRelationColObj> iter = dict.values().iterator();
			ICFBamRelationColObj obj;
			List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByToColIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByToColIdx( schema.getAuthorization(),
				TenantId,
				ToColId );
		}
	}

	public void deleteRelationColByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		CFBamRelationColByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamRelationColByPrevIdxKey,
				Map< CFBamRelationColPKey, ICFBamRelationColObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj> dict = indexByPrevIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			Iterator<ICFBamRelationColObj> iter = dict.values().iterator();
			ICFBamRelationColObj obj;
			List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
		}
	}

	public void deleteRelationColByNextIdx( Long NextTenantId,
		Long NextId )
	{
		CFBamRelationColByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamRelationColByNextIdxKey,
				Map< CFBamRelationColPKey, ICFBamRelationColObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj> dict = indexByNextIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			Iterator<ICFBamRelationColObj> iter = dict.values().iterator();
			ICFBamRelationColObj obj;
			List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
		}
	}

	public void deleteRelationColByRelPrevIdx( long TenantId,
		long RelationId,
		Long PrevId )
	{
		CFBamRelationColByRelPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		key.setOptionalPrevId( PrevId );
		if( indexByRelPrevIdx == null ) {
			indexByRelPrevIdx = new HashMap< CFBamRelationColByRelPrevIdxKey,
				Map< CFBamRelationColPKey, ICFBamRelationColObj > >();
		}
		if( indexByRelPrevIdx.containsKey( key ) ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj> dict = indexByRelPrevIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByRelPrevIdx( schema.getAuthorization(),
				TenantId,
				RelationId,
				PrevId );
			Iterator<ICFBamRelationColObj> iter = dict.values().iterator();
			ICFBamRelationColObj obj;
			List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByRelPrevIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByRelPrevIdx( schema.getAuthorization(),
				TenantId,
				RelationId,
				PrevId );
		}
	}

	public void deleteRelationColByRelNextIdx( long TenantId,
		long RelationId,
		Long NextId )
	{
		CFBamRelationColByRelNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newRelNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredRelationId( RelationId );
		key.setOptionalNextId( NextId );
		if( indexByRelNextIdx == null ) {
			indexByRelNextIdx = new HashMap< CFBamRelationColByRelNextIdxKey,
				Map< CFBamRelationColPKey, ICFBamRelationColObj > >();
		}
		if( indexByRelNextIdx.containsKey( key ) ) {
			Map<CFBamRelationColPKey, ICFBamRelationColObj> dict = indexByRelNextIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByRelNextIdx( schema.getAuthorization(),
				TenantId,
				RelationId,
				NextId );
			Iterator<ICFBamRelationColObj> iter = dict.values().iterator();
			ICFBamRelationColObj obj;
			List<ICFBamRelationColObj> toForget = new LinkedList<ICFBamRelationColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByRelNextIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().deleteRelationColByRelNextIdx( schema.getAuthorization(),
				TenantId,
				RelationId,
				NextId );
		}
	}

	/**
	 *	Move the CFBamRelationColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamRelationColObj refreshed cache instance.
	 */
	public ICFBamRelationColObj moveUpRelationCol( ICFBamRelationColObj Obj ) {
		ICFBamRelationColObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveUpRelationCol",
				"You cannot move an object that is being edited" );
		}
		CFBamRelationColBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().moveBuffUp( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getRelationColTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamRelationColObj)obj.realise();
			ICFBamRelationColObj prev = obj.getOptionalLookupPrev( true );
			ICFBamRelationColObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				ICFBamRelationColObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the CFBamRelationColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamRelationColObj refreshed cache instance.
	 */
	public ICFBamRelationColObj moveDownRelationCol( ICFBamRelationColObj Obj ) {
		ICFBamRelationColObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveDownRelationCol",
				"You cannot move an object that is being edited" );
		}
		CFBamRelationColBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().moveBuffDown( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getRelationColTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamRelationColObj)obj.realise();
			ICFBamRelationColObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				ICFBamRelationColObj gprev = prev.getOptionalLookupPrev( true );
			}
			ICFBamRelationColObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}
