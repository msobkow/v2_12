// Description: Java 11 Table Object implementation for CFGenKb.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public class CFGenKbGenRuleTableObj
	implements ICFGenKbGenRuleTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> members;
	private Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> allGenRule;
	private Map< CFGenKbGenItemByTenantIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > > indexByTenantIdx;
	private Map< CFGenKbGenItemByCartIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > > indexByCartIdx;
	private Map< CFGenKbGenItemByRuleTypeIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > > indexByRuleTypeIdx;
	private Map< CFGenKbGenItemByToolSetIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > > indexByToolSetIdx;
	private Map< CFGenKbGenItemByScopeIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > > indexByScopeIdx;
	private Map< CFGenKbGenItemByGenDefIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > > indexByGenDefIdx;
	private Map< CFGenKbGenItemByAltIdxKey,
		ICFGenKbGenRuleObj > indexByAltIdx;
	private Map< CFGenKbGenItemByGelExecIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > > indexByGelExecIdx;
	private Map< CFGenKbGenItemByProbeIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > > indexByProbeIdx;
	private Map< CFGenKbGenRuleByBodyIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > > indexByBodyIdx;
	public static String TABLE_NAME = "GenRule";
	public static String TABLE_DBNAME = "kbgenrule";

	public CFGenKbGenRuleTableObj() {
		schema = null;
		members = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenRuleObj>();
		allGenRule = null;
		indexByTenantIdx = null;
		indexByCartIdx = null;
		indexByRuleTypeIdx = null;
		indexByToolSetIdx = null;
		indexByScopeIdx = null;
		indexByGenDefIdx = null;
		indexByAltIdx = null;
		indexByGelExecIdx = null;
		indexByProbeIdx = null;
		indexByBodyIdx = null;
	}

	public CFGenKbGenRuleTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenRuleObj>();
		allGenRule = null;
		indexByTenantIdx = null;
		indexByCartIdx = null;
		indexByRuleTypeIdx = null;
		indexByToolSetIdx = null;
		indexByScopeIdx = null;
		indexByGenDefIdx = null;
		indexByAltIdx = null;
		indexByGelExecIdx = null;
		indexByProbeIdx = null;
		indexByBodyIdx = null;
	}

	public ICFGenKbSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFGenKbSchemaObj value ) {
		schema = value;
	}

	public String getTableName() {
		return( TABLE_NAME );
	}

	public String getTableDbName() {
		return( TABLE_DBNAME );
	}

	public Class getObjQualifyingClass() {
		return( null );
	}


	public void minimizeMemory() {
		allGenRule = null;
		indexByTenantIdx = null;
		indexByCartIdx = null;
		indexByRuleTypeIdx = null;
		indexByToolSetIdx = null;
		indexByScopeIdx = null;
		indexByGenDefIdx = null;
		indexByAltIdx = null;
		indexByGelExecIdx = null;
		indexByProbeIdx = null;
		indexByBodyIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbGenRuleObj.
	 */
	public ICFGenKbGenRuleObj newInstance() {
		ICFGenKbGenRuleObj inst = new CFGenKbGenRuleObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbGenRuleObj.
	 */
	public ICFGenKbGenRuleEditObj newEditInstance( ICFGenKbGenRuleObj orig ) {
		ICFGenKbGenRuleEditObj edit = new CFGenKbGenRuleEditObj( orig );
		return( edit );
	}

	public ICFGenKbGenRuleObj realiseGenRule( ICFGenKbGenRuleObj Obj ) {
		ICFGenKbGenRuleObj obj = Obj;
		CFGenKbGenItemPKey pkey = obj.getPKey();
		ICFGenKbGenRuleObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbGenRuleObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFGenKbGenItemByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByCartIdx != null ) {
				CFGenKbGenItemByCartIdxKey keyCartIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
				keyCartIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyCartIdx.setRequiredCartridgeId( keepObj.getRequiredCartridgeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapCartIdx = indexByCartIdx.get( keyCartIdx );
				if( mapCartIdx != null ) {
					indexByCartIdx.remove( keyCartIdx );
				}
			}

			if( indexByRuleTypeIdx != null ) {
				CFGenKbGenItemByRuleTypeIdxKey keyRuleTypeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
				keyRuleTypeIdx.setRequiredRuleTypeId( keepObj.getRequiredRuleTypeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapRuleTypeIdx = indexByRuleTypeIdx.get( keyRuleTypeIdx );
				if( mapRuleTypeIdx != null ) {
					indexByRuleTypeIdx.remove( keyRuleTypeIdx );
				}
			}

			if( indexByToolSetIdx != null ) {
				CFGenKbGenItemByToolSetIdxKey keyToolSetIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
				keyToolSetIdx.setRequiredToolSetId( keepObj.getRequiredToolSetId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapToolSetIdx = indexByToolSetIdx.get( keyToolSetIdx );
				if( mapToolSetIdx != null ) {
					indexByToolSetIdx.remove( keyToolSetIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFGenKbGenItemByScopeIdxKey keyScopeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
				keyScopeIdx.setOptionalScopeDefId( keepObj.getOptionalScopeDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByGenDefIdx != null ) {
				CFGenKbGenItemByGenDefIdxKey keyGenDefIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
				keyGenDefIdx.setRequiredGenDefId( keepObj.getRequiredGenDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapGenDefIdx = indexByGenDefIdx.get( keyGenDefIdx );
				if( mapGenDefIdx != null ) {
					indexByGenDefIdx.remove( keyGenDefIdx );
				}
			}

			if( indexByAltIdx != null ) {
				CFGenKbGenItemByAltIdxKey keyAltIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newAltIdxKey();
				keyAltIdx.setRequiredName( keepObj.getRequiredName() );
				keyAltIdx.setRequiredToolSetId( keepObj.getRequiredToolSetId() );
				keyAltIdx.setOptionalScopeDefId( keepObj.getOptionalScopeDefId() );
				keyAltIdx.setRequiredGenDefId( keepObj.getRequiredGenDefId() );
				indexByAltIdx.remove( keyAltIdx );
			}

			if( indexByGelExecIdx != null ) {
				CFGenKbGenItemByGelExecIdxKey keyGelExecIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGelExecIdxKey();
				keyGelExecIdx.setOptionalGelExecutableTenantId( keepObj.getOptionalGelExecutableTenantId() );
				keyGelExecIdx.setOptionalGelExecutableGelCacheId( keepObj.getOptionalGelExecutableGelCacheId() );
				keyGelExecIdx.setOptionalGelExecutableId( keepObj.getOptionalGelExecutableId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapGelExecIdx = indexByGelExecIdx.get( keyGelExecIdx );
				if( mapGelExecIdx != null ) {
					indexByGelExecIdx.remove( keyGelExecIdx );
				}
			}

			if( indexByProbeIdx != null ) {
				CFGenKbGenItemByProbeIdxKey keyProbeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newProbeIdxKey();
				keyProbeIdx.setOptionalProbeTenantId( keepObj.getOptionalProbeTenantId() );
				keyProbeIdx.setOptionalProbeCartridgeId( keepObj.getOptionalProbeCartridgeId() );
				keyProbeIdx.setOptionalProbeGenItemId( keepObj.getOptionalProbeGenItemId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapProbeIdx = indexByProbeIdx.get( keyProbeIdx );
				if( mapProbeIdx != null ) {
					indexByProbeIdx.remove( keyProbeIdx );
				}
			}

			if( indexByBodyIdx != null ) {
				CFGenKbGenRuleByBodyIdxKey keyBodyIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenRule().newBodyIdxKey();
				keyBodyIdx.setOptionalBodyTenantId( keepObj.getOptionalBodyTenantId() );
				keyBodyIdx.setOptionalBodyGelCacheId( keepObj.getOptionalBodyGelCacheId() );
				keyBodyIdx.setOptionalBodyGelId( keepObj.getOptionalBodyGelId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapBodyIdx = indexByBodyIdx.get( keyBodyIdx );
				if( mapBodyIdx != null ) {
					mapBodyIdx.remove( keepObj.getPKey() );
					if( mapBodyIdx.size() <= 0 ) {
						indexByBodyIdx.remove( keyBodyIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFGenKbGenRuleObj)schema.getGenItemTableObj().realiseGenItem( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFGenKbGenItemByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCartIdx != null ) {
				CFGenKbGenItemByCartIdxKey keyCartIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
				keyCartIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyCartIdx.setRequiredCartridgeId( keepObj.getRequiredCartridgeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapCartIdx = indexByCartIdx.get( keyCartIdx );
				if( mapCartIdx != null ) {
					mapCartIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRuleTypeIdx != null ) {
				CFGenKbGenItemByRuleTypeIdxKey keyRuleTypeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
				keyRuleTypeIdx.setRequiredRuleTypeId( keepObj.getRequiredRuleTypeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapRuleTypeIdx = indexByRuleTypeIdx.get( keyRuleTypeIdx );
				if( mapRuleTypeIdx != null ) {
					mapRuleTypeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToolSetIdx != null ) {
				CFGenKbGenItemByToolSetIdxKey keyToolSetIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
				keyToolSetIdx.setRequiredToolSetId( keepObj.getRequiredToolSetId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapToolSetIdx = indexByToolSetIdx.get( keyToolSetIdx );
				if( mapToolSetIdx != null ) {
					mapToolSetIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFGenKbGenItemByScopeIdxKey keyScopeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
				keyScopeIdx.setOptionalScopeDefId( keepObj.getOptionalScopeDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGenDefIdx != null ) {
				CFGenKbGenItemByGenDefIdxKey keyGenDefIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
				keyGenDefIdx.setRequiredGenDefId( keepObj.getRequiredGenDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapGenDefIdx = indexByGenDefIdx.get( keyGenDefIdx );
				if( mapGenDefIdx != null ) {
					mapGenDefIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByAltIdx != null ) {
				CFGenKbGenItemByAltIdxKey keyAltIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newAltIdxKey();
				keyAltIdx.setRequiredName( keepObj.getRequiredName() );
				keyAltIdx.setRequiredToolSetId( keepObj.getRequiredToolSetId() );
				keyAltIdx.setOptionalScopeDefId( keepObj.getOptionalScopeDefId() );
				keyAltIdx.setRequiredGenDefId( keepObj.getRequiredGenDefId() );
				indexByAltIdx.put( keyAltIdx, keepObj );
			}

			if( indexByGelExecIdx != null ) {
				CFGenKbGenItemByGelExecIdxKey keyGelExecIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGelExecIdxKey();
				keyGelExecIdx.setOptionalGelExecutableTenantId( keepObj.getOptionalGelExecutableTenantId() );
				keyGelExecIdx.setOptionalGelExecutableGelCacheId( keepObj.getOptionalGelExecutableGelCacheId() );
				keyGelExecIdx.setOptionalGelExecutableId( keepObj.getOptionalGelExecutableId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapGelExecIdx = indexByGelExecIdx.get( keyGelExecIdx );
				if( mapGelExecIdx != null ) {
					mapGelExecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByProbeIdx != null ) {
				CFGenKbGenItemByProbeIdxKey keyProbeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newProbeIdxKey();
				keyProbeIdx.setOptionalProbeTenantId( keepObj.getOptionalProbeTenantId() );
				keyProbeIdx.setOptionalProbeCartridgeId( keepObj.getOptionalProbeCartridgeId() );
				keyProbeIdx.setOptionalProbeGenItemId( keepObj.getOptionalProbeGenItemId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapProbeIdx = indexByProbeIdx.get( keyProbeIdx );
				if( mapProbeIdx != null ) {
					mapProbeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByBodyIdx != null ) {
				CFGenKbGenRuleByBodyIdxKey keyBodyIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenRule().newBodyIdxKey();
				keyBodyIdx.setOptionalBodyTenantId( keepObj.getOptionalBodyTenantId() );
				keyBodyIdx.setOptionalBodyGelCacheId( keepObj.getOptionalBodyGelCacheId() );
				keyBodyIdx.setOptionalBodyGelId( keepObj.getOptionalBodyGelId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapBodyIdx = indexByBodyIdx.get( keyBodyIdx );
				if( mapBodyIdx != null ) {
					mapBodyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allGenRule != null ) {
				allGenRule.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFGenKbGenRuleObj)schema.getGenItemTableObj().realiseGenItem( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allGenRule != null ) {
				allGenRule.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFGenKbGenItemByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCartIdx != null ) {
				CFGenKbGenItemByCartIdxKey keyCartIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
				keyCartIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyCartIdx.setRequiredCartridgeId( keepObj.getRequiredCartridgeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapCartIdx = indexByCartIdx.get( keyCartIdx );
				if( mapCartIdx != null ) {
					mapCartIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRuleTypeIdx != null ) {
				CFGenKbGenItemByRuleTypeIdxKey keyRuleTypeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
				keyRuleTypeIdx.setRequiredRuleTypeId( keepObj.getRequiredRuleTypeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapRuleTypeIdx = indexByRuleTypeIdx.get( keyRuleTypeIdx );
				if( mapRuleTypeIdx != null ) {
					mapRuleTypeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToolSetIdx != null ) {
				CFGenKbGenItemByToolSetIdxKey keyToolSetIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
				keyToolSetIdx.setRequiredToolSetId( keepObj.getRequiredToolSetId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapToolSetIdx = indexByToolSetIdx.get( keyToolSetIdx );
				if( mapToolSetIdx != null ) {
					mapToolSetIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFGenKbGenItemByScopeIdxKey keyScopeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
				keyScopeIdx.setOptionalScopeDefId( keepObj.getOptionalScopeDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGenDefIdx != null ) {
				CFGenKbGenItemByGenDefIdxKey keyGenDefIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
				keyGenDefIdx.setRequiredGenDefId( keepObj.getRequiredGenDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapGenDefIdx = indexByGenDefIdx.get( keyGenDefIdx );
				if( mapGenDefIdx != null ) {
					mapGenDefIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByAltIdx != null ) {
				CFGenKbGenItemByAltIdxKey keyAltIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newAltIdxKey();
				keyAltIdx.setRequiredName( keepObj.getRequiredName() );
				keyAltIdx.setRequiredToolSetId( keepObj.getRequiredToolSetId() );
				keyAltIdx.setOptionalScopeDefId( keepObj.getOptionalScopeDefId() );
				keyAltIdx.setRequiredGenDefId( keepObj.getRequiredGenDefId() );
				indexByAltIdx.put( keyAltIdx, keepObj );
			}

			if( indexByGelExecIdx != null ) {
				CFGenKbGenItemByGelExecIdxKey keyGelExecIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGelExecIdxKey();
				keyGelExecIdx.setOptionalGelExecutableTenantId( keepObj.getOptionalGelExecutableTenantId() );
				keyGelExecIdx.setOptionalGelExecutableGelCacheId( keepObj.getOptionalGelExecutableGelCacheId() );
				keyGelExecIdx.setOptionalGelExecutableId( keepObj.getOptionalGelExecutableId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapGelExecIdx = indexByGelExecIdx.get( keyGelExecIdx );
				if( mapGelExecIdx != null ) {
					mapGelExecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByProbeIdx != null ) {
				CFGenKbGenItemByProbeIdxKey keyProbeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newProbeIdxKey();
				keyProbeIdx.setOptionalProbeTenantId( keepObj.getOptionalProbeTenantId() );
				keyProbeIdx.setOptionalProbeCartridgeId( keepObj.getOptionalProbeCartridgeId() );
				keyProbeIdx.setOptionalProbeGenItemId( keepObj.getOptionalProbeGenItemId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapProbeIdx = indexByProbeIdx.get( keyProbeIdx );
				if( mapProbeIdx != null ) {
					mapProbeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByBodyIdx != null ) {
				CFGenKbGenRuleByBodyIdxKey keyBodyIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenRule().newBodyIdxKey();
				keyBodyIdx.setOptionalBodyTenantId( keepObj.getOptionalBodyTenantId() );
				keyBodyIdx.setOptionalBodyGelCacheId( keepObj.getOptionalBodyGelCacheId() );
				keyBodyIdx.setOptionalBodyGelId( keepObj.getOptionalBodyGelId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapBodyIdx = indexByBodyIdx.get( keyBodyIdx );
				if( mapBodyIdx != null ) {
					mapBodyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetGenRule( ICFGenKbGenRuleObj Obj ) {
		forgetGenRule( Obj, false );
	}

	public void forgetGenRule( ICFGenKbGenRuleObj Obj, boolean forgetSubObjects ) {
		ICFGenKbGenRuleObj obj = Obj;
		CFGenKbGenItemPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbGenRuleObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFGenKbGenItemByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByCartIdx != null ) {
				CFGenKbGenItemByCartIdxKey keyCartIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
				keyCartIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyCartIdx.setRequiredCartridgeId( keepObj.getRequiredCartridgeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapCartIdx = indexByCartIdx.get( keyCartIdx );
				if( mapCartIdx != null ) {
					indexByCartIdx.remove( keyCartIdx );
				}
			}

			if( indexByRuleTypeIdx != null ) {
				CFGenKbGenItemByRuleTypeIdxKey keyRuleTypeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
				keyRuleTypeIdx.setRequiredRuleTypeId( keepObj.getRequiredRuleTypeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapRuleTypeIdx = indexByRuleTypeIdx.get( keyRuleTypeIdx );
				if( mapRuleTypeIdx != null ) {
					indexByRuleTypeIdx.remove( keyRuleTypeIdx );
				}
			}

			if( indexByToolSetIdx != null ) {
				CFGenKbGenItemByToolSetIdxKey keyToolSetIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
				keyToolSetIdx.setRequiredToolSetId( keepObj.getRequiredToolSetId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapToolSetIdx = indexByToolSetIdx.get( keyToolSetIdx );
				if( mapToolSetIdx != null ) {
					indexByToolSetIdx.remove( keyToolSetIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFGenKbGenItemByScopeIdxKey keyScopeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
				keyScopeIdx.setOptionalScopeDefId( keepObj.getOptionalScopeDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByGenDefIdx != null ) {
				CFGenKbGenItemByGenDefIdxKey keyGenDefIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
				keyGenDefIdx.setRequiredGenDefId( keepObj.getRequiredGenDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapGenDefIdx = indexByGenDefIdx.get( keyGenDefIdx );
				if( mapGenDefIdx != null ) {
					indexByGenDefIdx.remove( keyGenDefIdx );
				}
			}

			if( indexByAltIdx != null ) {
				CFGenKbGenItemByAltIdxKey keyAltIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newAltIdxKey();
				keyAltIdx.setRequiredName( keepObj.getRequiredName() );
				keyAltIdx.setRequiredToolSetId( keepObj.getRequiredToolSetId() );
				keyAltIdx.setOptionalScopeDefId( keepObj.getOptionalScopeDefId() );
				keyAltIdx.setRequiredGenDefId( keepObj.getRequiredGenDefId() );
				indexByAltIdx.remove( keyAltIdx );
			}

			if( indexByGelExecIdx != null ) {
				CFGenKbGenItemByGelExecIdxKey keyGelExecIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGelExecIdxKey();
				keyGelExecIdx.setOptionalGelExecutableTenantId( keepObj.getOptionalGelExecutableTenantId() );
				keyGelExecIdx.setOptionalGelExecutableGelCacheId( keepObj.getOptionalGelExecutableGelCacheId() );
				keyGelExecIdx.setOptionalGelExecutableId( keepObj.getOptionalGelExecutableId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapGelExecIdx = indexByGelExecIdx.get( keyGelExecIdx );
				if( mapGelExecIdx != null ) {
					indexByGelExecIdx.remove( keyGelExecIdx );
				}
			}

			if( indexByProbeIdx != null ) {
				CFGenKbGenItemByProbeIdxKey keyProbeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newProbeIdxKey();
				keyProbeIdx.setOptionalProbeTenantId( keepObj.getOptionalProbeTenantId() );
				keyProbeIdx.setOptionalProbeCartridgeId( keepObj.getOptionalProbeCartridgeId() );
				keyProbeIdx.setOptionalProbeGenItemId( keepObj.getOptionalProbeGenItemId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapProbeIdx = indexByProbeIdx.get( keyProbeIdx );
				if( mapProbeIdx != null ) {
					indexByProbeIdx.remove( keyProbeIdx );
				}
			}

			if( indexByBodyIdx != null ) {
				CFGenKbGenRuleByBodyIdxKey keyBodyIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenRule().newBodyIdxKey();
				keyBodyIdx.setOptionalBodyTenantId( keepObj.getOptionalBodyTenantId() );
				keyBodyIdx.setOptionalBodyGelCacheId( keepObj.getOptionalBodyGelCacheId() );
				keyBodyIdx.setOptionalBodyGelId( keepObj.getOptionalBodyGelId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapBodyIdx = indexByBodyIdx.get( keyBodyIdx );
				if( mapBodyIdx != null ) {
					mapBodyIdx.remove( keepObj.getPKey() );
					if( mapBodyIdx.size() <= 0 ) {
						indexByBodyIdx.remove( keyBodyIdx );
					}
				}
			}

			if( allGenRule != null ) {
				allGenRule.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFGenKbSchemaObj)schema).getGelExecutableTableObj().forgetGelExecutableByPIdx( keepObj.getOptionalBodyTenantId(),
					keepObj.getOptionalBodyGelCacheId(),
					keepObj.getOptionalBodyGelId() );
			}
		}
		((ICFGenKbSchemaObj)schema).getGenItemTableObj().forgetGenItem( obj );
	}

	public void forgetGenRuleByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId )
	{
		if( members == null ) {
			return;
		}
		CFGenKbGenItemPKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCartridgeId( CartridgeId );
		key.setRequiredItemId( ItemId );
		if( members.containsKey( key ) ) {
			ICFGenKbGenRuleObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetGenRuleByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
		ICFGenKbGenRuleObj cur = null;
		CFGenKbGenItemByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFGenKbGenRuleObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenRuleObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenRuleObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenRuleByCartIdx( long TenantId,
		long CartridgeId )
	{
		if( indexByCartIdx == null ) {
			return;
		}
		List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
		ICFGenKbGenRuleObj cur = null;
		CFGenKbGenItemByCartIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCartridgeId( CartridgeId );
		if( indexByCartIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapCartIdx = indexByCartIdx.get( key );
			if( mapCartIdx != null ) {
				Iterator<ICFGenKbGenRuleObj> iterDup = mapCartIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByCartIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenRuleObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenRuleObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenRuleByRuleTypeIdx( short RuleTypeId )
	{
		if( indexByRuleTypeIdx == null ) {
			return;
		}
		List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
		ICFGenKbGenRuleObj cur = null;
		CFGenKbGenItemByRuleTypeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
		key.setRequiredRuleTypeId( RuleTypeId );
		if( indexByRuleTypeIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapRuleTypeIdx = indexByRuleTypeIdx.get( key );
			if( mapRuleTypeIdx != null ) {
				Iterator<ICFGenKbGenRuleObj> iterDup = mapRuleTypeIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRuleTypeIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenRuleObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenRuleObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenRuleByToolSetIdx( short ToolSetId )
	{
		if( indexByToolSetIdx == null ) {
			return;
		}
		List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
		ICFGenKbGenRuleObj cur = null;
		CFGenKbGenItemByToolSetIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
		key.setRequiredToolSetId( ToolSetId );
		if( indexByToolSetIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapToolSetIdx = indexByToolSetIdx.get( key );
			if( mapToolSetIdx != null ) {
				Iterator<ICFGenKbGenRuleObj> iterDup = mapToolSetIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByToolSetIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenRuleObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenRuleObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenRuleByScopeIdx( Short ScopeDefId )
	{
		if( indexByScopeIdx == null ) {
			return;
		}
		List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
		ICFGenKbGenRuleObj cur = null;
		CFGenKbGenItemByScopeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
		key.setOptionalScopeDefId( ScopeDefId );
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapScopeIdx = indexByScopeIdx.get( key );
			if( mapScopeIdx != null ) {
				Iterator<ICFGenKbGenRuleObj> iterDup = mapScopeIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByScopeIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenRuleObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenRuleObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenRuleByGenDefIdx( short GenDefId )
	{
		if( indexByGenDefIdx == null ) {
			return;
		}
		List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
		ICFGenKbGenRuleObj cur = null;
		CFGenKbGenItemByGenDefIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
		key.setRequiredGenDefId( GenDefId );
		if( indexByGenDefIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapGenDefIdx = indexByGenDefIdx.get( key );
			if( mapGenDefIdx != null ) {
				Iterator<ICFGenKbGenRuleObj> iterDup = mapGenDefIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGenDefIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenRuleObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenRuleObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenRuleByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId )
	{
		if( indexByAltIdx == null ) {
			return;
		}
		List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
		ICFGenKbGenRuleObj cur = null;
		CFGenKbGenItemByAltIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newAltIdxKey();
		key.setRequiredName( Name );
		key.setRequiredToolSetId( ToolSetId );
		key.setOptionalScopeDefId( ScopeDefId );
		key.setRequiredGenDefId( GenDefId );
		if( indexByAltIdx.containsKey( key ) ) {
			cur = indexByAltIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFGenKbGenRuleObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenRuleByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId )
	{
		if( indexByGelExecIdx == null ) {
			return;
		}
		List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
		ICFGenKbGenRuleObj cur = null;
		CFGenKbGenItemByGelExecIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGelExecIdxKey();
		key.setOptionalGelExecutableTenantId( GelExecutableTenantId );
		key.setOptionalGelExecutableGelCacheId( GelExecutableGelCacheId );
		key.setOptionalGelExecutableId( GelExecutableId );
		if( indexByGelExecIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapGelExecIdx = indexByGelExecIdx.get( key );
			if( mapGelExecIdx != null ) {
				Iterator<ICFGenKbGenRuleObj> iterDup = mapGelExecIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGelExecIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenRuleObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenRuleObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenRuleByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId )
	{
		if( indexByProbeIdx == null ) {
			return;
		}
		List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
		ICFGenKbGenRuleObj cur = null;
		CFGenKbGenItemByProbeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newProbeIdxKey();
		key.setOptionalProbeTenantId( ProbeTenantId );
		key.setOptionalProbeCartridgeId( ProbeCartridgeId );
		key.setOptionalProbeGenItemId( ProbeGenItemId );
		if( indexByProbeIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapProbeIdx = indexByProbeIdx.get( key );
			if( mapProbeIdx != null ) {
				Iterator<ICFGenKbGenRuleObj> iterDup = mapProbeIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByProbeIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenRuleObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenRuleObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenRuleByBodyIdx( Long BodyTenantId,
		Long BodyGelCacheId,
		Long BodyGelId )
	{
		if( indexByBodyIdx == null ) {
			return;
		}
		List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
		ICFGenKbGenRuleObj cur = null;
		CFGenKbGenRuleByBodyIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenRule().newBodyIdxKey();
		key.setOptionalBodyTenantId( BodyTenantId );
		key.setOptionalBodyGelCacheId( BodyGelCacheId );
		key.setOptionalBodyGelId( BodyGelId );
		if( indexByBodyIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj > mapBodyIdx = indexByBodyIdx.get( key );
			if( mapBodyIdx != null ) {
				Iterator<ICFGenKbGenRuleObj> iterDup = mapBodyIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByBodyIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenRuleObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenRuleObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbGenRuleObj createGenRule( ICFGenKbGenRuleObj Obj ) {
		ICFGenKbGenRuleObj obj = Obj;
		CFGenKbGenRuleBuff buff = obj.getGenRuleBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().createGenRule(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "RUL" ) ) {
			obj = (ICFGenKbGenRuleObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbGenRuleObj readGenRule( CFGenKbGenItemPKey pkey ) {
		return( readGenRule( pkey, false ) );
	}

	public ICFGenKbGenRuleObj readGenRule( CFGenKbGenItemPKey pkey, boolean forceRead ) {
		ICFGenKbGenRuleObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbGenRuleBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().readDerivedByItemIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredCartridgeId(),
				pkey.getRequiredItemId() );
			if( readBuff != null ) {
				obj = (ICFGenKbGenRuleObj)schema.getGenItemTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbGenRuleObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbGenRuleObj lockGenRule( CFGenKbGenItemPKey pkey ) {
		ICFGenKbGenRuleObj locked = null;
		CFGenKbGenRuleBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFGenKbGenRuleObj)schema.getGenItemTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbGenRuleObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockGenRule", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbGenRuleObj> readAllGenRule() {
		return( readAllGenRule( false ) );
	}

	public List<ICFGenKbGenRuleObj> readAllGenRule( boolean forceRead ) {
		final String S_ProcName = "readAllGenRule";
		if( ( allGenRule == null ) || forceRead ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> map = new HashMap<CFGenKbGenItemPKey,ICFGenKbGenRuleObj>();
			allGenRule = map;
			CFGenKbGenRuleBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().readAllDerived( schema.getAuthorization() );
			CFGenKbGenRuleBuff buff;
			ICFGenKbGenRuleObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenRuleObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenRuleObj realised = (ICFGenKbGenRuleObj)obj.realise();
			}
		}
		int len = allGenRule.size();
		ICFGenKbGenRuleObj arr[] = new ICFGenKbGenRuleObj[len];
		Iterator<ICFGenKbGenRuleObj> valIter = allGenRule.values().iterator();
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
		ArrayList<ICFGenKbGenRuleObj> arrayList = new ArrayList<ICFGenKbGenRuleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenRuleObj> cmp = new Comparator<ICFGenKbGenRuleObj>() {
			public int compare( ICFGenKbGenRuleObj lhs, ICFGenKbGenRuleObj rhs ) {
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
					CFGenKbGenItemPKey lhsPKey = lhs.getPKey();
					CFGenKbGenItemPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGenRuleObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGenRuleObj readGenRuleByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId )
	{
		return( readGenRuleByItemIdIdx( TenantId,
			CartridgeId,
			ItemId,
			false ) );
	}

	public ICFGenKbGenRuleObj readGenRuleByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId, boolean forceRead )
	{
		CFGenKbGenItemPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredCartridgeId( CartridgeId );
		pkey.setRequiredItemId( ItemId );
		ICFGenKbGenRuleObj obj = readGenRule( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbGenRuleObj> readGenRuleByTenantIdx( long TenantId )
	{
		return( readGenRuleByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFGenKbGenRuleObj> readGenRuleByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenRuleByTenantIdx";
		CFGenKbGenItemByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGenItemByTenantIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenRuleObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenRuleObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenRuleObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenRuleObj realised = (ICFGenKbGenRuleObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenRuleObj arr[] = new ICFGenKbGenRuleObj[len];
		Iterator<ICFGenKbGenRuleObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenRuleObj> arrayList = new ArrayList<ICFGenKbGenRuleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenRuleObj> cmp = new Comparator<ICFGenKbGenRuleObj>() {
			public int compare( ICFGenKbGenRuleObj lhs, ICFGenKbGenRuleObj rhs ) {
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
					CFGenKbGenItemPKey lhsPKey = lhs.getPKey();
					CFGenKbGenItemPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGenRuleObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenRuleObj> readGenRuleByCartIdx( long TenantId,
		long CartridgeId )
	{
		return( readGenRuleByCartIdx( TenantId,
			CartridgeId,
			false ) );
	}

	public List<ICFGenKbGenRuleObj> readGenRuleByCartIdx( long TenantId,
		long CartridgeId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenRuleByCartIdx";
		CFGenKbGenItemByCartIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCartridgeId( CartridgeId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> dict;
		if( indexByCartIdx == null ) {
			indexByCartIdx = new HashMap< CFGenKbGenItemByCartIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenRuleObj > >();
		}
		if( ( ! forceRead ) && indexByCartIdx.containsKey( key ) ) {
			dict = indexByCartIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenRuleObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByCartIdx( schema.getAuthorization(),
				TenantId,
				CartridgeId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenRuleObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenRuleObj realised = (ICFGenKbGenRuleObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByCartIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenRuleObj arr[] = new ICFGenKbGenRuleObj[len];
		Iterator<ICFGenKbGenRuleObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenRuleObj> arrayList = new ArrayList<ICFGenKbGenRuleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenRuleObj> cmp = new Comparator<ICFGenKbGenRuleObj>() {
			public int compare( ICFGenKbGenRuleObj lhs, ICFGenKbGenRuleObj rhs ) {
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
					CFGenKbGenItemPKey lhsPKey = lhs.getPKey();
					CFGenKbGenItemPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGenRuleObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenRuleObj> readGenRuleByRuleTypeIdx( short RuleTypeId )
	{
		return( readGenRuleByRuleTypeIdx( RuleTypeId,
			false ) );
	}

	public List<ICFGenKbGenRuleObj> readGenRuleByRuleTypeIdx( short RuleTypeId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenRuleByRuleTypeIdx";
		CFGenKbGenItemByRuleTypeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
		key.setRequiredRuleTypeId( RuleTypeId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> dict;
		if( indexByRuleTypeIdx == null ) {
			indexByRuleTypeIdx = new HashMap< CFGenKbGenItemByRuleTypeIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenRuleObj > >();
		}
		if( ( ! forceRead ) && indexByRuleTypeIdx.containsKey( key ) ) {
			dict = indexByRuleTypeIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenRuleObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByRuleTypeIdx( schema.getAuthorization(),
				RuleTypeId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenRuleObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenRuleObj realised = (ICFGenKbGenRuleObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRuleTypeIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenRuleObj arr[] = new ICFGenKbGenRuleObj[len];
		Iterator<ICFGenKbGenRuleObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenRuleObj> arrayList = new ArrayList<ICFGenKbGenRuleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenRuleObj> cmp = new Comparator<ICFGenKbGenRuleObj>() {
			public int compare( ICFGenKbGenRuleObj lhs, ICFGenKbGenRuleObj rhs ) {
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
					CFGenKbGenItemPKey lhsPKey = lhs.getPKey();
					CFGenKbGenItemPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGenRuleObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenRuleObj> readGenRuleByToolSetIdx( short ToolSetId )
	{
		return( readGenRuleByToolSetIdx( ToolSetId,
			false ) );
	}

	public List<ICFGenKbGenRuleObj> readGenRuleByToolSetIdx( short ToolSetId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenRuleByToolSetIdx";
		CFGenKbGenItemByToolSetIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
		key.setRequiredToolSetId( ToolSetId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> dict;
		if( indexByToolSetIdx == null ) {
			indexByToolSetIdx = new HashMap< CFGenKbGenItemByToolSetIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenRuleObj > >();
		}
		if( ( ! forceRead ) && indexByToolSetIdx.containsKey( key ) ) {
			dict = indexByToolSetIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenRuleObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByToolSetIdx( schema.getAuthorization(),
				ToolSetId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenRuleObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenRuleObj realised = (ICFGenKbGenRuleObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByToolSetIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenRuleObj arr[] = new ICFGenKbGenRuleObj[len];
		Iterator<ICFGenKbGenRuleObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenRuleObj> arrayList = new ArrayList<ICFGenKbGenRuleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenRuleObj> cmp = new Comparator<ICFGenKbGenRuleObj>() {
			public int compare( ICFGenKbGenRuleObj lhs, ICFGenKbGenRuleObj rhs ) {
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
					CFGenKbGenItemPKey lhsPKey = lhs.getPKey();
					CFGenKbGenItemPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGenRuleObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenRuleObj> readGenRuleByScopeIdx( Short ScopeDefId )
	{
		return( readGenRuleByScopeIdx( ScopeDefId,
			false ) );
	}

	public List<ICFGenKbGenRuleObj> readGenRuleByScopeIdx( Short ScopeDefId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenRuleByScopeIdx";
		CFGenKbGenItemByScopeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
		key.setOptionalScopeDefId( ScopeDefId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFGenKbGenItemByScopeIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenRuleObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenRuleObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByScopeIdx( schema.getAuthorization(),
				ScopeDefId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenRuleObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenRuleObj realised = (ICFGenKbGenRuleObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenRuleObj arr[] = new ICFGenKbGenRuleObj[len];
		Iterator<ICFGenKbGenRuleObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenRuleObj> arrayList = new ArrayList<ICFGenKbGenRuleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenRuleObj> cmp = new Comparator<ICFGenKbGenRuleObj>() {
			public int compare( ICFGenKbGenRuleObj lhs, ICFGenKbGenRuleObj rhs ) {
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
					CFGenKbGenItemPKey lhsPKey = lhs.getPKey();
					CFGenKbGenItemPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGenRuleObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenRuleObj> readGenRuleByGenDefIdx( short GenDefId )
	{
		return( readGenRuleByGenDefIdx( GenDefId,
			false ) );
	}

	public List<ICFGenKbGenRuleObj> readGenRuleByGenDefIdx( short GenDefId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenRuleByGenDefIdx";
		CFGenKbGenItemByGenDefIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
		key.setRequiredGenDefId( GenDefId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> dict;
		if( indexByGenDefIdx == null ) {
			indexByGenDefIdx = new HashMap< CFGenKbGenItemByGenDefIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenRuleObj > >();
		}
		if( ( ! forceRead ) && indexByGenDefIdx.containsKey( key ) ) {
			dict = indexByGenDefIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenRuleObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByGenDefIdx( schema.getAuthorization(),
				GenDefId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenRuleObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenRuleObj realised = (ICFGenKbGenRuleObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGenDefIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenRuleObj arr[] = new ICFGenKbGenRuleObj[len];
		Iterator<ICFGenKbGenRuleObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenRuleObj> arrayList = new ArrayList<ICFGenKbGenRuleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenRuleObj> cmp = new Comparator<ICFGenKbGenRuleObj>() {
			public int compare( ICFGenKbGenRuleObj lhs, ICFGenKbGenRuleObj rhs ) {
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
					CFGenKbGenItemPKey lhsPKey = lhs.getPKey();
					CFGenKbGenItemPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGenRuleObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGenRuleObj readGenRuleByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId )
	{
		return( readGenRuleByAltIdx( Name,
			ToolSetId,
			ScopeDefId,
			GenDefId,
			false ) );
	}

	public ICFGenKbGenRuleObj readGenRuleByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId, boolean forceRead )
	{
		if( indexByAltIdx == null ) {
			indexByAltIdx = new HashMap< CFGenKbGenItemByAltIdxKey,
				ICFGenKbGenRuleObj >();
		}
		CFGenKbGenItemByAltIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newAltIdxKey();
		key.setRequiredName( Name );
		key.setRequiredToolSetId( ToolSetId );
		key.setOptionalScopeDefId( ScopeDefId );
		key.setRequiredGenDefId( GenDefId );
		ICFGenKbGenRuleObj obj = null;
		if( ( ! forceRead ) && indexByAltIdx.containsKey( key ) ) {
			obj = indexByAltIdx.get( key );
		}
		else {
			CFGenKbGenItemBuff buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByAltIdx( schema.getAuthorization(),
				Name,
				ToolSetId,
				ScopeDefId,
				GenDefId );
			if( buff != null ) {
				obj = (ICFGenKbGenRuleObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				obj = (ICFGenKbGenRuleObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFGenKbGenRuleObj> readGenRuleByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId )
	{
		return( readGenRuleByGelExecIdx( GelExecutableTenantId,
			GelExecutableGelCacheId,
			GelExecutableId,
			false ) );
	}

	public List<ICFGenKbGenRuleObj> readGenRuleByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenRuleByGelExecIdx";
		CFGenKbGenItemByGelExecIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGelExecIdxKey();
		key.setOptionalGelExecutableTenantId( GelExecutableTenantId );
		key.setOptionalGelExecutableGelCacheId( GelExecutableGelCacheId );
		key.setOptionalGelExecutableId( GelExecutableId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> dict;
		if( indexByGelExecIdx == null ) {
			indexByGelExecIdx = new HashMap< CFGenKbGenItemByGelExecIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenRuleObj > >();
		}
		if( ( ! forceRead ) && indexByGelExecIdx.containsKey( key ) ) {
			dict = indexByGelExecIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenRuleObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByGelExecIdx( schema.getAuthorization(),
				GelExecutableTenantId,
				GelExecutableGelCacheId,
				GelExecutableId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenRuleObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenRuleObj realised = (ICFGenKbGenRuleObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGelExecIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenRuleObj arr[] = new ICFGenKbGenRuleObj[len];
		Iterator<ICFGenKbGenRuleObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenRuleObj> arrayList = new ArrayList<ICFGenKbGenRuleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenRuleObj> cmp = new Comparator<ICFGenKbGenRuleObj>() {
			public int compare( ICFGenKbGenRuleObj lhs, ICFGenKbGenRuleObj rhs ) {
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
					CFGenKbGenItemPKey lhsPKey = lhs.getPKey();
					CFGenKbGenItemPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGenRuleObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenRuleObj> readGenRuleByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId )
	{
		return( readGenRuleByProbeIdx( ProbeTenantId,
			ProbeCartridgeId,
			ProbeGenItemId,
			false ) );
	}

	public List<ICFGenKbGenRuleObj> readGenRuleByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenRuleByProbeIdx";
		CFGenKbGenItemByProbeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newProbeIdxKey();
		key.setOptionalProbeTenantId( ProbeTenantId );
		key.setOptionalProbeCartridgeId( ProbeCartridgeId );
		key.setOptionalProbeGenItemId( ProbeGenItemId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> dict;
		if( indexByProbeIdx == null ) {
			indexByProbeIdx = new HashMap< CFGenKbGenItemByProbeIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenRuleObj > >();
		}
		if( ( ! forceRead ) && indexByProbeIdx.containsKey( key ) ) {
			dict = indexByProbeIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenRuleObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByProbeIdx( schema.getAuthorization(),
				ProbeTenantId,
				ProbeCartridgeId,
				ProbeGenItemId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenRuleObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenRuleObj realised = (ICFGenKbGenRuleObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByProbeIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenRuleObj arr[] = new ICFGenKbGenRuleObj[len];
		Iterator<ICFGenKbGenRuleObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenRuleObj> arrayList = new ArrayList<ICFGenKbGenRuleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenRuleObj> cmp = new Comparator<ICFGenKbGenRuleObj>() {
			public int compare( ICFGenKbGenRuleObj lhs, ICFGenKbGenRuleObj rhs ) {
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
					CFGenKbGenItemPKey lhsPKey = lhs.getPKey();
					CFGenKbGenItemPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGenRuleObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenRuleObj> readGenRuleByBodyIdx( Long BodyTenantId,
		Long BodyGelCacheId,
		Long BodyGelId )
	{
		return( readGenRuleByBodyIdx( BodyTenantId,
			BodyGelCacheId,
			BodyGelId,
			false ) );
	}

	public List<ICFGenKbGenRuleObj> readGenRuleByBodyIdx( Long BodyTenantId,
		Long BodyGelCacheId,
		Long BodyGelId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenRuleByBodyIdx";
		CFGenKbGenRuleByBodyIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenRule().newBodyIdxKey();
		key.setOptionalBodyTenantId( BodyTenantId );
		key.setOptionalBodyGelCacheId( BodyGelCacheId );
		key.setOptionalBodyGelId( BodyGelId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> dict;
		if( indexByBodyIdx == null ) {
			indexByBodyIdx = new HashMap< CFGenKbGenRuleByBodyIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenRuleObj > >();
		}
		if( ( ! forceRead ) && indexByBodyIdx.containsKey( key ) ) {
			dict = indexByBodyIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenRuleObj>();
			ICFGenKbGenRuleObj obj;
			CFGenKbGenRuleBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().readDerivedByBodyIdx( schema.getAuthorization(),
				BodyTenantId,
				BodyGelCacheId,
				BodyGelId );
			CFGenKbGenRuleBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenRuleObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenRuleObj realised = (ICFGenKbGenRuleObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByBodyIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenRuleObj arr[] = new ICFGenKbGenRuleObj[len];
		Iterator<ICFGenKbGenRuleObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenRuleObj> arrayList = new ArrayList<ICFGenKbGenRuleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenRuleObj> cmp = new Comparator<ICFGenKbGenRuleObj>() {
			public int compare( ICFGenKbGenRuleObj lhs, ICFGenKbGenRuleObj rhs ) {
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
					CFGenKbGenItemPKey lhsPKey = lhs.getPKey();
					CFGenKbGenItemPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGenRuleObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGenRuleObj updateGenRule( ICFGenKbGenRuleObj Obj ) {
		ICFGenKbGenRuleObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().updateGenRule( schema.getAuthorization(),
			Obj.getGenRuleBuff() );
		if( Obj.getClassCode().equals( "RUL" ) ) {
			obj = (ICFGenKbGenRuleObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteGenRule( ICFGenKbGenRuleObj Obj ) {
		ICFGenKbGenRuleObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRule( schema.getAuthorization(),
			obj.getGenRuleBuff() );
		obj.forget( true );
	}

	public void deleteGenRuleByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId )
	{
		CFGenKbGenItemPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredCartridgeId( CartridgeId );
		pkey.setRequiredItemId( ItemId );
		ICFGenKbGenRuleObj obj = readGenRule( pkey );
		if( obj != null ) {
			ICFGenKbGenRuleEditObj editObj = (ICFGenKbGenRuleEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbGenRuleEditObj)obj.beginEdit();
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

	public void deleteGenRuleByTenantIdx( long TenantId )
	{
		CFGenKbGenItemByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGenItemByTenantIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenRuleObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> dict = indexByTenantIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFGenKbGenRuleObj> iter = dict.values().iterator();
			ICFGenKbGenRuleObj obj;
			List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteGenRuleByCartIdx( long TenantId,
		long CartridgeId )
	{
		CFGenKbGenItemByCartIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCartridgeId( CartridgeId );
		if( indexByCartIdx == null ) {
			indexByCartIdx = new HashMap< CFGenKbGenItemByCartIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenRuleObj > >();
		}
		if( indexByCartIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> dict = indexByCartIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByCartIdx( schema.getAuthorization(),
				TenantId,
				CartridgeId );
			Iterator<ICFGenKbGenRuleObj> iter = dict.values().iterator();
			ICFGenKbGenRuleObj obj;
			List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByCartIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByCartIdx( schema.getAuthorization(),
				TenantId,
				CartridgeId );
		}
	}

	public void deleteGenRuleByRuleTypeIdx( short RuleTypeId )
	{
		CFGenKbGenItemByRuleTypeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
		key.setRequiredRuleTypeId( RuleTypeId );
		if( indexByRuleTypeIdx == null ) {
			indexByRuleTypeIdx = new HashMap< CFGenKbGenItemByRuleTypeIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenRuleObj > >();
		}
		if( indexByRuleTypeIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> dict = indexByRuleTypeIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByRuleTypeIdx( schema.getAuthorization(),
				RuleTypeId );
			Iterator<ICFGenKbGenRuleObj> iter = dict.values().iterator();
			ICFGenKbGenRuleObj obj;
			List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByRuleTypeIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByRuleTypeIdx( schema.getAuthorization(),
				RuleTypeId );
		}
	}

	public void deleteGenRuleByToolSetIdx( short ToolSetId )
	{
		CFGenKbGenItemByToolSetIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
		key.setRequiredToolSetId( ToolSetId );
		if( indexByToolSetIdx == null ) {
			indexByToolSetIdx = new HashMap< CFGenKbGenItemByToolSetIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenRuleObj > >();
		}
		if( indexByToolSetIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> dict = indexByToolSetIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByToolSetIdx( schema.getAuthorization(),
				ToolSetId );
			Iterator<ICFGenKbGenRuleObj> iter = dict.values().iterator();
			ICFGenKbGenRuleObj obj;
			List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByToolSetIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByToolSetIdx( schema.getAuthorization(),
				ToolSetId );
		}
	}

	public void deleteGenRuleByScopeIdx( Short ScopeDefId )
	{
		CFGenKbGenItemByScopeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
		key.setOptionalScopeDefId( ScopeDefId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFGenKbGenItemByScopeIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenRuleObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> dict = indexByScopeIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByScopeIdx( schema.getAuthorization(),
				ScopeDefId );
			Iterator<ICFGenKbGenRuleObj> iter = dict.values().iterator();
			ICFGenKbGenRuleObj obj;
			List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByScopeIdx( schema.getAuthorization(),
				ScopeDefId );
		}
	}

	public void deleteGenRuleByGenDefIdx( short GenDefId )
	{
		CFGenKbGenItemByGenDefIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
		key.setRequiredGenDefId( GenDefId );
		if( indexByGenDefIdx == null ) {
			indexByGenDefIdx = new HashMap< CFGenKbGenItemByGenDefIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenRuleObj > >();
		}
		if( indexByGenDefIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> dict = indexByGenDefIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByGenDefIdx( schema.getAuthorization(),
				GenDefId );
			Iterator<ICFGenKbGenRuleObj> iter = dict.values().iterator();
			ICFGenKbGenRuleObj obj;
			List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByGenDefIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByGenDefIdx( schema.getAuthorization(),
				GenDefId );
		}
	}

	public void deleteGenRuleByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId )
	{
		if( indexByAltIdx == null ) {
			indexByAltIdx = new HashMap< CFGenKbGenItemByAltIdxKey,
				ICFGenKbGenRuleObj >();
		}
		CFGenKbGenItemByAltIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newAltIdxKey();
		key.setRequiredName( Name );
		key.setRequiredToolSetId( ToolSetId );
		key.setOptionalScopeDefId( ScopeDefId );
		key.setRequiredGenDefId( GenDefId );
		ICFGenKbGenRuleObj obj = null;
		if( indexByAltIdx.containsKey( key ) ) {
			obj = indexByAltIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByAltIdx( schema.getAuthorization(),
				Name,
				ToolSetId,
				ScopeDefId,
				GenDefId );
			obj.forget( true );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByAltIdx( schema.getAuthorization(),
				Name,
				ToolSetId,
				ScopeDefId,
				GenDefId );
		}
	}

	public void deleteGenRuleByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId )
	{
		CFGenKbGenItemByGelExecIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGelExecIdxKey();
		key.setOptionalGelExecutableTenantId( GelExecutableTenantId );
		key.setOptionalGelExecutableGelCacheId( GelExecutableGelCacheId );
		key.setOptionalGelExecutableId( GelExecutableId );
		if( indexByGelExecIdx == null ) {
			indexByGelExecIdx = new HashMap< CFGenKbGenItemByGelExecIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenRuleObj > >();
		}
		if( indexByGelExecIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> dict = indexByGelExecIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByGelExecIdx( schema.getAuthorization(),
				GelExecutableTenantId,
				GelExecutableGelCacheId,
				GelExecutableId );
			Iterator<ICFGenKbGenRuleObj> iter = dict.values().iterator();
			ICFGenKbGenRuleObj obj;
			List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByGelExecIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByGelExecIdx( schema.getAuthorization(),
				GelExecutableTenantId,
				GelExecutableGelCacheId,
				GelExecutableId );
		}
	}

	public void deleteGenRuleByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId )
	{
		CFGenKbGenItemByProbeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newProbeIdxKey();
		key.setOptionalProbeTenantId( ProbeTenantId );
		key.setOptionalProbeCartridgeId( ProbeCartridgeId );
		key.setOptionalProbeGenItemId( ProbeGenItemId );
		if( indexByProbeIdx == null ) {
			indexByProbeIdx = new HashMap< CFGenKbGenItemByProbeIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenRuleObj > >();
		}
		if( indexByProbeIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> dict = indexByProbeIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByProbeIdx( schema.getAuthorization(),
				ProbeTenantId,
				ProbeCartridgeId,
				ProbeGenItemId );
			Iterator<ICFGenKbGenRuleObj> iter = dict.values().iterator();
			ICFGenKbGenRuleObj obj;
			List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByProbeIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByProbeIdx( schema.getAuthorization(),
				ProbeTenantId,
				ProbeCartridgeId,
				ProbeGenItemId );
		}
	}

	public void deleteGenRuleByBodyIdx( Long BodyTenantId,
		Long BodyGelCacheId,
		Long BodyGelId )
	{
		CFGenKbGenRuleByBodyIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenRule().newBodyIdxKey();
		key.setOptionalBodyTenantId( BodyTenantId );
		key.setOptionalBodyGelCacheId( BodyGelCacheId );
		key.setOptionalBodyGelId( BodyGelId );
		if( indexByBodyIdx == null ) {
			indexByBodyIdx = new HashMap< CFGenKbGenRuleByBodyIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenRuleObj > >();
		}
		if( indexByBodyIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenRuleObj> dict = indexByBodyIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByBodyIdx( schema.getAuthorization(),
				BodyTenantId,
				BodyGelCacheId,
				BodyGelId );
			Iterator<ICFGenKbGenRuleObj> iter = dict.values().iterator();
			ICFGenKbGenRuleObj obj;
			List<ICFGenKbGenRuleObj> toForget = new LinkedList<ICFGenKbGenRuleObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByBodyIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().deleteGenRuleByBodyIdx( schema.getAuthorization(),
				BodyTenantId,
				BodyGelCacheId,
				BodyGelId );
		}
	}
}
