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

public class CFBamParamTableObj
	implements ICFBamParamTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamParamPKey, ICFBamParamObj> members;
	private Map<CFBamParamPKey, ICFBamParamObj> allParam;
	private Map< CFBamParamByUNameIdxKey,
		ICFBamParamObj > indexByUNameIdx;
	private Map< CFBamParamByValTentIdxKey,
		Map<CFBamParamPKey, ICFBamParamObj > > indexByValTentIdx;
	private Map< CFBamParamByServerMethodIdxKey,
		Map<CFBamParamPKey, ICFBamParamObj > > indexByServerMethodIdx;
	private Map< CFBamParamByDefSchemaIdxKey,
		Map<CFBamParamPKey, ICFBamParamObj > > indexByDefSchemaIdx;
	private Map< CFBamParamByServerTypeIdxKey,
		Map<CFBamParamPKey, ICFBamParamObj > > indexByServerTypeIdx;
	private Map< CFBamParamByPrevIdxKey,
		Map<CFBamParamPKey, ICFBamParamObj > > indexByPrevIdx;
	private Map< CFBamParamByNextIdxKey,
		Map<CFBamParamPKey, ICFBamParamObj > > indexByNextIdx;
	private Map< CFBamParamByContPrevIdxKey,
		Map<CFBamParamPKey, ICFBamParamObj > > indexByContPrevIdx;
	private Map< CFBamParamByContNextIdxKey,
		Map<CFBamParamPKey, ICFBamParamObj > > indexByContNextIdx;
	public static String TABLE_NAME = "Param";
	public static String TABLE_DBNAME = "srvprm";

	public CFBamParamTableObj() {
		schema = null;
		members = new HashMap<CFBamParamPKey, ICFBamParamObj>();
		allParam = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByServerMethodIdx = null;
		indexByDefSchemaIdx = null;
		indexByServerTypeIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
	}

	public CFBamParamTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamParamPKey, ICFBamParamObj>();
		allParam = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByServerMethodIdx = null;
		indexByDefSchemaIdx = null;
		indexByServerTypeIdx = null;
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
		allParam = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByServerMethodIdx = null;
		indexByDefSchemaIdx = null;
		indexByServerTypeIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
		ICFBamParamObj cur = null;
		Iterator<ICFBamParamObj> iter = members.values().iterator();
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
	 *	CFBamParamObj.
	 */
	public ICFBamParamObj newInstance() {
		ICFBamParamObj inst = new CFBamParamObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamParamObj.
	 */
	public ICFBamParamEditObj newEditInstance( ICFBamParamObj orig ) {
		ICFBamParamEditObj edit = new CFBamParamEditObj( orig );
		return( edit );
	}

	public ICFBamParamObj realiseParam( ICFBamParamObj Obj ) {
		ICFBamParamObj obj = Obj;
		CFBamParamPKey pkey = obj.getPKey();
		ICFBamParamObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamParamObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				CFBamParamByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByValTentIdx != null ) {
				CFBamParamByValTentIdxKey keyValTentIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.remove( keepObj.getPKey() );
					if( mapValTentIdx.size() <= 0 ) {
						indexByValTentIdx.remove( keyValTentIdx );
					}
				}
			}

			if( indexByServerMethodIdx != null ) {
				CFBamParamByServerMethodIdxKey keyServerMethodIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newServerMethodIdxKey();
				keyServerMethodIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyServerMethodIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapServerMethodIdx = indexByServerMethodIdx.get( keyServerMethodIdx );
				if( mapServerMethodIdx != null ) {
					mapServerMethodIdx.remove( keepObj.getPKey() );
					if( mapServerMethodIdx.size() <= 0 ) {
						indexByServerMethodIdx.remove( keyServerMethodIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamParamByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByServerTypeIdx != null ) {
				CFBamParamByServerTypeIdxKey keyServerTypeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newServerTypeIdxKey();
				keyServerTypeIdx.setOptionalTypeTenantId( keepObj.getOptionalTypeTenantId() );
				keyServerTypeIdx.setOptionalTypeId( keepObj.getOptionalTypeId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapServerTypeIdx = indexByServerTypeIdx.get( keyServerTypeIdx );
				if( mapServerTypeIdx != null ) {
					mapServerTypeIdx.remove( keepObj.getPKey() );
					if( mapServerTypeIdx.size() <= 0 ) {
						indexByServerTypeIdx.remove( keyServerTypeIdx );
					}
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamParamByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				CFBamParamByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
					if( mapNextIdx.size() <= 0 ) {
						indexByNextIdx.remove( keyNextIdx );
					}
				}
			}

			if( indexByContPrevIdx != null ) {
				CFBamParamByContPrevIdxKey keyContPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newContPrevIdxKey();
				keyContPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContPrevIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.remove( keepObj.getPKey() );
					if( mapContPrevIdx.size() <= 0 ) {
						indexByContPrevIdx.remove( keyContPrevIdx );
					}
				}
			}

			if( indexByContNextIdx != null ) {
				CFBamParamByContNextIdxKey keyContNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newContNextIdxKey();
				keyContNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContNextIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.remove( keepObj.getPKey() );
					if( mapContNextIdx.size() <= 0 ) {
						indexByContNextIdx.remove( keyContNextIdx );
					}
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				CFBamParamByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByValTentIdx != null ) {
				CFBamParamByValTentIdxKey keyValTentIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByServerMethodIdx != null ) {
				CFBamParamByServerMethodIdxKey keyServerMethodIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newServerMethodIdxKey();
				keyServerMethodIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyServerMethodIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapServerMethodIdx = indexByServerMethodIdx.get( keyServerMethodIdx );
				if( mapServerMethodIdx != null ) {
					mapServerMethodIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamParamByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByServerTypeIdx != null ) {
				CFBamParamByServerTypeIdxKey keyServerTypeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newServerTypeIdxKey();
				keyServerTypeIdx.setOptionalTypeTenantId( keepObj.getOptionalTypeTenantId() );
				keyServerTypeIdx.setOptionalTypeId( keepObj.getOptionalTypeId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapServerTypeIdx = indexByServerTypeIdx.get( keyServerTypeIdx );
				if( mapServerTypeIdx != null ) {
					mapServerTypeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamParamByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamParamByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				CFBamParamByContPrevIdxKey keyContPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newContPrevIdxKey();
				keyContPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContPrevIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				CFBamParamByContNextIdxKey keyContNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newContNextIdxKey();
				keyContNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContNextIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allParam != null ) {
				allParam.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allParam != null ) {
				allParam.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				CFBamParamByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByValTentIdx != null ) {
				CFBamParamByValTentIdxKey keyValTentIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByServerMethodIdx != null ) {
				CFBamParamByServerMethodIdxKey keyServerMethodIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newServerMethodIdxKey();
				keyServerMethodIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyServerMethodIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapServerMethodIdx = indexByServerMethodIdx.get( keyServerMethodIdx );
				if( mapServerMethodIdx != null ) {
					mapServerMethodIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamParamByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByServerTypeIdx != null ) {
				CFBamParamByServerTypeIdxKey keyServerTypeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newServerTypeIdxKey();
				keyServerTypeIdx.setOptionalTypeTenantId( keepObj.getOptionalTypeTenantId() );
				keyServerTypeIdx.setOptionalTypeId( keepObj.getOptionalTypeId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapServerTypeIdx = indexByServerTypeIdx.get( keyServerTypeIdx );
				if( mapServerTypeIdx != null ) {
					mapServerTypeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamParamByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamParamByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				CFBamParamByContPrevIdxKey keyContPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newContPrevIdxKey();
				keyContPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContPrevIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				CFBamParamByContNextIdxKey keyContNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newContNextIdxKey();
				keyContNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContNextIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetParam( ICFBamParamObj Obj ) {
		forgetParam( Obj, false );
	}

	public void forgetParam( ICFBamParamObj Obj, boolean forgetSubObjects ) {
		ICFBamParamObj obj = Obj;
		CFBamParamPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamParamObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUNameIdx != null ) {
				CFBamParamByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByValTentIdx != null ) {
				CFBamParamByValTentIdxKey keyValTentIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.remove( keepObj.getPKey() );
					if( mapValTentIdx.size() <= 0 ) {
						indexByValTentIdx.remove( keyValTentIdx );
					}
				}
			}

			if( indexByServerMethodIdx != null ) {
				CFBamParamByServerMethodIdxKey keyServerMethodIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newServerMethodIdxKey();
				keyServerMethodIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyServerMethodIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapServerMethodIdx = indexByServerMethodIdx.get( keyServerMethodIdx );
				if( mapServerMethodIdx != null ) {
					mapServerMethodIdx.remove( keepObj.getPKey() );
					if( mapServerMethodIdx.size() <= 0 ) {
						indexByServerMethodIdx.remove( keyServerMethodIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamParamByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByServerTypeIdx != null ) {
				CFBamParamByServerTypeIdxKey keyServerTypeIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newServerTypeIdxKey();
				keyServerTypeIdx.setOptionalTypeTenantId( keepObj.getOptionalTypeTenantId() );
				keyServerTypeIdx.setOptionalTypeId( keepObj.getOptionalTypeId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapServerTypeIdx = indexByServerTypeIdx.get( keyServerTypeIdx );
				if( mapServerTypeIdx != null ) {
					mapServerTypeIdx.remove( keepObj.getPKey() );
					if( mapServerTypeIdx.size() <= 0 ) {
						indexByServerTypeIdx.remove( keyServerTypeIdx );
					}
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamParamByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				CFBamParamByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
					if( mapNextIdx.size() <= 0 ) {
						indexByNextIdx.remove( keyNextIdx );
					}
				}
			}

			if( indexByContPrevIdx != null ) {
				CFBamParamByContPrevIdxKey keyContPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newContPrevIdxKey();
				keyContPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContPrevIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.remove( keepObj.getPKey() );
					if( mapContPrevIdx.size() <= 0 ) {
						indexByContPrevIdx.remove( keyContPrevIdx );
					}
				}
			}

			if( indexByContNextIdx != null ) {
				CFBamParamByContNextIdxKey keyContNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newContNextIdxKey();
				keyContNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContNextIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.remove( keepObj.getPKey() );
					if( mapContNextIdx.size() <= 0 ) {
						indexByContNextIdx.remove( keyContNextIdx );
					}
				}
			}

			if( allParam != null ) {
				allParam.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetParamByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamParamPKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamParamObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetParamByUNameIdx( long TenantId,
		long ServerMethodId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
		ICFBamParamObj cur = null;
		CFBamParamByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamParamObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetParamByValTentIdx( long TenantId )
	{
		if( indexByValTentIdx == null ) {
			return;
		}
		List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
		ICFBamParamObj cur = null;
		CFBamParamByValTentIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj > mapValTentIdx = indexByValTentIdx.get( key );
			if( mapValTentIdx != null ) {
				Iterator<ICFBamParamObj> iterDup = mapValTentIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByValTentIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamParamObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamParamObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetParamByServerMethodIdx( long TenantId,
		long ServerMethodId )
	{
		if( indexByServerMethodIdx == null ) {
			return;
		}
		List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
		ICFBamParamObj cur = null;
		CFBamParamByServerMethodIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newServerMethodIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		if( indexByServerMethodIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj > mapServerMethodIdx = indexByServerMethodIdx.get( key );
			if( mapServerMethodIdx != null ) {
				Iterator<ICFBamParamObj> iterDup = mapServerMethodIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByServerMethodIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamParamObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamParamObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetParamByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
		ICFBamParamObj cur = null;
		CFBamParamByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamParamObj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamParamObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamParamObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetParamByServerTypeIdx( Long TypeTenantId,
		Long TypeId )
	{
		if( indexByServerTypeIdx == null ) {
			return;
		}
		List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
		ICFBamParamObj cur = null;
		CFBamParamByServerTypeIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newServerTypeIdxKey();
		key.setOptionalTypeTenantId( TypeTenantId );
		key.setOptionalTypeId( TypeId );
		if( indexByServerTypeIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj > mapServerTypeIdx = indexByServerTypeIdx.get( key );
			if( mapServerTypeIdx != null ) {
				Iterator<ICFBamParamObj> iterDup = mapServerTypeIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByServerTypeIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamParamObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamParamObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetParamByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		if( indexByPrevIdx == null ) {
			return;
		}
		List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
		ICFBamParamObj cur = null;
		CFBamParamByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj > mapPrevIdx = indexByPrevIdx.get( key );
			if( mapPrevIdx != null ) {
				Iterator<ICFBamParamObj> iterDup = mapPrevIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByPrevIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamParamObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamParamObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetParamByNextIdx( Long NextTenantId,
		Long NextId )
	{
		if( indexByNextIdx == null ) {
			return;
		}
		List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
		ICFBamParamObj cur = null;
		CFBamParamByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj > mapNextIdx = indexByNextIdx.get( key );
			if( mapNextIdx != null ) {
				Iterator<ICFBamParamObj> iterDup = mapNextIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByNextIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamParamObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamParamObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetParamByContPrevIdx( long TenantId,
		long ServerMethodId,
		Long PrevId )
	{
		if( indexByContPrevIdx == null ) {
			return;
		}
		List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
		ICFBamParamObj cur = null;
		CFBamParamByContPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj > mapContPrevIdx = indexByContPrevIdx.get( key );
			if( mapContPrevIdx != null ) {
				Iterator<ICFBamParamObj> iterDup = mapContPrevIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByContPrevIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamParamObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamParamObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetParamByContNextIdx( long TenantId,
		long ServerMethodId,
		Long NextId )
	{
		if( indexByContNextIdx == null ) {
			return;
		}
		List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
		ICFBamParamObj cur = null;
		CFBamParamByContNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj > mapContNextIdx = indexByContNextIdx.get( key );
			if( mapContNextIdx != null ) {
				Iterator<ICFBamParamObj> iterDup = mapContNextIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByContNextIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamParamObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamParamObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamParamObj createParam( ICFBamParamObj Obj ) {
		ICFBamParamObj obj = Obj;
		CFBamParamBuff buff = obj.getParamBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableParam().createParam(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		ICFBamParamObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamParamObj readParam( CFBamParamPKey pkey ) {
		return( readParam( pkey, false ) );
	}

	public ICFBamParamObj readParam( CFBamParamPKey pkey, boolean forceRead ) {
		ICFBamParamObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamParamBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableParam().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamParamObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamParamObj lockParam( CFBamParamPKey pkey ) {
		ICFBamParamObj locked = null;
		CFBamParamBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableParam().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getParamTableObj().newInstance();
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamParamObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockParam", pkey );
		}
		return( locked );
	}

	public List<ICFBamParamObj> readAllParam() {
		return( readAllParam( false ) );
	}

	public List<ICFBamParamObj> readAllParam( boolean forceRead ) {
		final String S_ProcName = "readAllParam";
		if( ( allParam == null ) || forceRead ) {
			Map<CFBamParamPKey, ICFBamParamObj> map = new HashMap<CFBamParamPKey,ICFBamParamObj>();
			allParam = map;
			CFBamParamBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableParam().readAllDerived( schema.getAuthorization() );
			CFBamParamBuff buff;
			ICFBamParamObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPKey() );
				obj.setBuff( buff );
				ICFBamParamObj realised = (ICFBamParamObj)obj.realise();
			}
		}
		int len = allParam.size();
		ICFBamParamObj arr[] = new ICFBamParamObj[len];
		Iterator<ICFBamParamObj> valIter = allParam.values().iterator();
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
		ArrayList<ICFBamParamObj> arrayList = new ArrayList<ICFBamParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamParamObj> cmp = new Comparator<ICFBamParamObj>() {
			public int compare( ICFBamParamObj lhs, ICFBamParamObj rhs ) {
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
					CFBamParamPKey lhsPKey = lhs.getPKey();
					CFBamParamPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamParamObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamParamObj readParamByIdIdx( long TenantId,
		long Id )
	{
		return( readParamByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamParamObj readParamByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamParamPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamParamObj obj = readParam( pkey, forceRead );
		return( obj );
	}

	public ICFBamParamObj readParamByUNameIdx( long TenantId,
		long ServerMethodId,
		String Name )
	{
		return( readParamByUNameIdx( TenantId,
			ServerMethodId,
			Name,
			false ) );
	}

	public ICFBamParamObj readParamByUNameIdx( long TenantId,
		long ServerMethodId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamParamByUNameIdxKey,
				ICFBamParamObj >();
		}
		CFBamParamByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setRequiredName( Name );
		ICFBamParamObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamParamBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableParam().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId,
				Name );
			if( buff != null ) {
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamParamObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFBamParamObj> readParamByValTentIdx( long TenantId )
	{
		return( readParamByValTentIdx( TenantId,
			false ) );
	}

	public List<ICFBamParamObj> readParamByValTentIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByValTentIdx";
		CFBamParamByValTentIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamParamPKey, ICFBamParamObj> dict;
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamParamByValTentIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( ( ! forceRead ) && indexByValTentIdx.containsKey( key ) ) {
			dict = indexByValTentIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamParamPKey, ICFBamParamObj>();
			ICFBamParamObj obj;
			CFBamParamBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableParam().readDerivedByValTentIdx( schema.getAuthorization(),
				TenantId );
			CFBamParamBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPKey() );
				obj.setBuff( buff );
				ICFBamParamObj realised = (ICFBamParamObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByValTentIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamParamObj arr[] = new ICFBamParamObj[len];
		Iterator<ICFBamParamObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamParamObj> arrayList = new ArrayList<ICFBamParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamParamObj> cmp = new Comparator<ICFBamParamObj>() {
			public int compare( ICFBamParamObj lhs, ICFBamParamObj rhs ) {
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
					CFBamParamPKey lhsPKey = lhs.getPKey();
					CFBamParamPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamParamObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamParamObj> readParamByServerMethodIdx( long TenantId,
		long ServerMethodId )
	{
		return( readParamByServerMethodIdx( TenantId,
			ServerMethodId,
			false ) );
	}

	public List<ICFBamParamObj> readParamByServerMethodIdx( long TenantId,
		long ServerMethodId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByServerMethodIdx";
		CFBamParamByServerMethodIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newServerMethodIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		Map<CFBamParamPKey, ICFBamParamObj> dict;
		if( indexByServerMethodIdx == null ) {
			indexByServerMethodIdx = new HashMap< CFBamParamByServerMethodIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( ( ! forceRead ) && indexByServerMethodIdx.containsKey( key ) ) {
			dict = indexByServerMethodIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamParamPKey, ICFBamParamObj>();
			ICFBamParamObj obj;
			CFBamParamBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableParam().readDerivedByServerMethodIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId );
			CFBamParamBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPKey() );
				obj.setBuff( buff );
				ICFBamParamObj realised = (ICFBamParamObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByServerMethodIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamParamObj arr[] = new ICFBamParamObj[len];
		Iterator<ICFBamParamObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamParamObj> arrayList = new ArrayList<ICFBamParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamParamObj> cmp = new Comparator<ICFBamParamObj>() {
			public int compare( ICFBamParamObj lhs, ICFBamParamObj rhs ) {
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
					CFBamParamPKey lhsPKey = lhs.getPKey();
					CFBamParamPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamParamObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamParamObj> readParamByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readParamByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamParamObj> readParamByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByDefSchemaIdx";
		CFBamParamByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamParamPKey, ICFBamParamObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamParamByDefSchemaIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamParamPKey, ICFBamParamObj>();
			ICFBamParamObj obj;
			CFBamParamBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableParam().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamParamBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPKey() );
				obj.setBuff( buff );
				ICFBamParamObj realised = (ICFBamParamObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamParamObj arr[] = new ICFBamParamObj[len];
		Iterator<ICFBamParamObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamParamObj> arrayList = new ArrayList<ICFBamParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamParamObj> cmp = new Comparator<ICFBamParamObj>() {
			public int compare( ICFBamParamObj lhs, ICFBamParamObj rhs ) {
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
					CFBamParamPKey lhsPKey = lhs.getPKey();
					CFBamParamPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamParamObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamParamObj> readParamByServerTypeIdx( Long TypeTenantId,
		Long TypeId )
	{
		return( readParamByServerTypeIdx( TypeTenantId,
			TypeId,
			false ) );
	}

	public List<ICFBamParamObj> readParamByServerTypeIdx( Long TypeTenantId,
		Long TypeId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByServerTypeIdx";
		CFBamParamByServerTypeIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newServerTypeIdxKey();
		key.setOptionalTypeTenantId( TypeTenantId );
		key.setOptionalTypeId( TypeId );
		Map<CFBamParamPKey, ICFBamParamObj> dict;
		if( indexByServerTypeIdx == null ) {
			indexByServerTypeIdx = new HashMap< CFBamParamByServerTypeIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( ( ! forceRead ) && indexByServerTypeIdx.containsKey( key ) ) {
			dict = indexByServerTypeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamParamPKey, ICFBamParamObj>();
			ICFBamParamObj obj;
			CFBamParamBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableParam().readDerivedByServerTypeIdx( schema.getAuthorization(),
				TypeTenantId,
				TypeId );
			CFBamParamBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPKey() );
				obj.setBuff( buff );
				ICFBamParamObj realised = (ICFBamParamObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByServerTypeIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamParamObj arr[] = new ICFBamParamObj[len];
		Iterator<ICFBamParamObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamParamObj> arrayList = new ArrayList<ICFBamParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamParamObj> cmp = new Comparator<ICFBamParamObj>() {
			public int compare( ICFBamParamObj lhs, ICFBamParamObj rhs ) {
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
					CFBamParamPKey lhsPKey = lhs.getPKey();
					CFBamParamPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamParamObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamParamObj> readParamByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		return( readParamByPrevIdx( PrevTenantId,
			PrevId,
			false ) );
	}

	public List<ICFBamParamObj> readParamByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByPrevIdx";
		CFBamParamByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamParamPKey, ICFBamParamObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamParamByPrevIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamParamPKey, ICFBamParamObj>();
			ICFBamParamObj obj;
			CFBamParamBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableParam().readDerivedByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			CFBamParamBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPKey() );
				obj.setBuff( buff );
				ICFBamParamObj realised = (ICFBamParamObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamParamObj arr[] = new ICFBamParamObj[len];
		Iterator<ICFBamParamObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamParamObj> arrayList = new ArrayList<ICFBamParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamParamObj> cmp = new Comparator<ICFBamParamObj>() {
			public int compare( ICFBamParamObj lhs, ICFBamParamObj rhs ) {
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
					CFBamParamPKey lhsPKey = lhs.getPKey();
					CFBamParamPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamParamObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamParamObj> readParamByNextIdx( Long NextTenantId,
		Long NextId )
	{
		return( readParamByNextIdx( NextTenantId,
			NextId,
			false ) );
	}

	public List<ICFBamParamObj> readParamByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByNextIdx";
		CFBamParamByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		Map<CFBamParamPKey, ICFBamParamObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamParamByNextIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamParamPKey, ICFBamParamObj>();
			ICFBamParamObj obj;
			CFBamParamBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableParam().readDerivedByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			CFBamParamBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPKey() );
				obj.setBuff( buff );
				ICFBamParamObj realised = (ICFBamParamObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamParamObj arr[] = new ICFBamParamObj[len];
		Iterator<ICFBamParamObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamParamObj> arrayList = new ArrayList<ICFBamParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamParamObj> cmp = new Comparator<ICFBamParamObj>() {
			public int compare( ICFBamParamObj lhs, ICFBamParamObj rhs ) {
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
					CFBamParamPKey lhsPKey = lhs.getPKey();
					CFBamParamPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamParamObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamParamObj> readParamByContPrevIdx( long TenantId,
		long ServerMethodId,
		Long PrevId )
	{
		return( readParamByContPrevIdx( TenantId,
			ServerMethodId,
			PrevId,
			false ) );
	}

	public List<ICFBamParamObj> readParamByContPrevIdx( long TenantId,
		long ServerMethodId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByContPrevIdx";
		CFBamParamByContPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamParamPKey, ICFBamParamObj> dict;
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamParamByContPrevIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( ( ! forceRead ) && indexByContPrevIdx.containsKey( key ) ) {
			dict = indexByContPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamParamPKey, ICFBamParamObj>();
			ICFBamParamObj obj;
			CFBamParamBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableParam().readDerivedByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId,
				PrevId );
			CFBamParamBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPKey() );
				obj.setBuff( buff );
				ICFBamParamObj realised = (ICFBamParamObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContPrevIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamParamObj arr[] = new ICFBamParamObj[len];
		Iterator<ICFBamParamObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamParamObj> arrayList = new ArrayList<ICFBamParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamParamObj> cmp = new Comparator<ICFBamParamObj>() {
			public int compare( ICFBamParamObj lhs, ICFBamParamObj rhs ) {
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
					CFBamParamPKey lhsPKey = lhs.getPKey();
					CFBamParamPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamParamObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamParamObj> readParamByContNextIdx( long TenantId,
		long ServerMethodId,
		Long NextId )
	{
		return( readParamByContNextIdx( TenantId,
			ServerMethodId,
			NextId,
			false ) );
	}

	public List<ICFBamParamObj> readParamByContNextIdx( long TenantId,
		long ServerMethodId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByContNextIdx";
		CFBamParamByContNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalNextId( NextId );
		Map<CFBamParamPKey, ICFBamParamObj> dict;
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamParamByContNextIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( ( ! forceRead ) && indexByContNextIdx.containsKey( key ) ) {
			dict = indexByContNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamParamPKey, ICFBamParamObj>();
			ICFBamParamObj obj;
			CFBamParamBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableParam().readDerivedByContNextIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId,
				NextId );
			CFBamParamBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPKey() );
				obj.setBuff( buff );
				ICFBamParamObj realised = (ICFBamParamObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContNextIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamParamObj arr[] = new ICFBamParamObj[len];
		Iterator<ICFBamParamObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamParamObj> arrayList = new ArrayList<ICFBamParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamParamObj> cmp = new Comparator<ICFBamParamObj>() {
			public int compare( ICFBamParamObj lhs, ICFBamParamObj rhs ) {
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
					CFBamParamPKey lhsPKey = lhs.getPKey();
					CFBamParamPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamParamObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamParamObj updateParam( ICFBamParamObj Obj ) {
		ICFBamParamObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableParam().updateParam( schema.getAuthorization(),
			Obj.getParamBuff() );
		obj = (ICFBamParamObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteParam( ICFBamParamObj Obj ) {
		ICFBamParamObj obj = Obj;
		ICFBamParamObj prev = obj.getOptionalLookupPrev();
		ICFBamParamObj next = obj.getOptionalLookupNext();
		((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParam( schema.getAuthorization(),
			obj.getParamBuff() );
		obj.forget( true );
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	public void deleteParamByIdIdx( long TenantId,
		long Id )
	{
		CFBamParamPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamParamObj obj = readParam( pkey );
		if( obj != null ) {
			ICFBamParamEditObj editObj = (ICFBamParamEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamParamEditObj)obj.beginEdit();
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

	public void deleteParamByUNameIdx( long TenantId,
		long ServerMethodId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamParamByUNameIdxKey,
				ICFBamParamObj >();
		}
		CFBamParamByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setRequiredName( Name );
		ICFBamParamObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParamByUNameIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParamByUNameIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId,
				Name );
		}
	}

	public void deleteParamByValTentIdx( long TenantId )
	{
		CFBamParamByValTentIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamParamByValTentIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj> dict = indexByValTentIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParamByValTentIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamParamObj> iter = dict.values().iterator();
			ICFBamParamObj obj;
			List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParamByValTentIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteParamByServerMethodIdx( long TenantId,
		long ServerMethodId )
	{
		CFBamParamByServerMethodIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newServerMethodIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		if( indexByServerMethodIdx == null ) {
			indexByServerMethodIdx = new HashMap< CFBamParamByServerMethodIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( indexByServerMethodIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj> dict = indexByServerMethodIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParamByServerMethodIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId );
			Iterator<ICFBamParamObj> iter = dict.values().iterator();
			ICFBamParamObj obj;
			List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByServerMethodIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParamByServerMethodIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId );
		}
	}

	public void deleteParamByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamParamByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamParamByDefSchemaIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParamByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamParamObj> iter = dict.values().iterator();
			ICFBamParamObj obj;
			List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParamByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteParamByServerTypeIdx( Long TypeTenantId,
		Long TypeId )
	{
		CFBamParamByServerTypeIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newServerTypeIdxKey();
		key.setOptionalTypeTenantId( TypeTenantId );
		key.setOptionalTypeId( TypeId );
		if( indexByServerTypeIdx == null ) {
			indexByServerTypeIdx = new HashMap< CFBamParamByServerTypeIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( indexByServerTypeIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj> dict = indexByServerTypeIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParamByServerTypeIdx( schema.getAuthorization(),
				TypeTenantId,
				TypeId );
			Iterator<ICFBamParamObj> iter = dict.values().iterator();
			ICFBamParamObj obj;
			List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByServerTypeIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParamByServerTypeIdx( schema.getAuthorization(),
				TypeTenantId,
				TypeId );
		}
	}

	public void deleteParamByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		CFBamParamByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamParamByPrevIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj> dict = indexByPrevIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParamByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			Iterator<ICFBamParamObj> iter = dict.values().iterator();
			ICFBamParamObj obj;
			List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParamByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
		}
	}

	public void deleteParamByNextIdx( Long NextTenantId,
		Long NextId )
	{
		CFBamParamByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamParamByNextIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj> dict = indexByNextIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParamByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			Iterator<ICFBamParamObj> iter = dict.values().iterator();
			ICFBamParamObj obj;
			List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParamByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
		}
	}

	public void deleteParamByContPrevIdx( long TenantId,
		long ServerMethodId,
		Long PrevId )
	{
		CFBamParamByContPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamParamByContPrevIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj> dict = indexByContPrevIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParamByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId,
				PrevId );
			Iterator<ICFBamParamObj> iter = dict.values().iterator();
			ICFBamParamObj obj;
			List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParamByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId,
				PrevId );
		}
	}

	public void deleteParamByContNextIdx( long TenantId,
		long ServerMethodId,
		Long NextId )
	{
		CFBamParamByContNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamParamByContNextIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj> dict = indexByContNextIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParamByContNextIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId,
				NextId );
			Iterator<ICFBamParamObj> iter = dict.values().iterator();
			ICFBamParamObj obj;
			List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableParam().deleteParamByContNextIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId,
				NextId );
		}
	}

	/**
	 *	Move the CFBamParamObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamParamObj refreshed cache instance.
	 */
	public ICFBamParamObj moveUpParam( ICFBamParamObj Obj ) {
		ICFBamParamObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveUpParam",
				"You cannot move an object that is being edited" );
		}
		CFBamParamBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableParam().moveBuffUp( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getParamTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamParamObj)obj.realise();
			ICFBamParamObj prev = obj.getOptionalLookupPrev( true );
			ICFBamParamObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				ICFBamParamObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the CFBamParamObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamParamObj refreshed cache instance.
	 */
	public ICFBamParamObj moveDownParam( ICFBamParamObj Obj ) {
		ICFBamParamObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveDownParam",
				"You cannot move an object that is being edited" );
		}
		CFBamParamBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableParam().moveBuffDown( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getParamTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamParamObj)obj.realise();
			ICFBamParamObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				ICFBamParamObj gprev = prev.getOptionalLookupPrev( true );
			}
			ICFBamParamObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}
