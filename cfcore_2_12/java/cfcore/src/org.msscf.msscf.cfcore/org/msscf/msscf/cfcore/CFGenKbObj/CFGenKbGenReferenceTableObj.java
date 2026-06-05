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

public class CFGenKbGenReferenceTableObj
	implements ICFGenKbGenReferenceTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> members;
	private Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> allGenReference;
	private Map< CFGenKbGenItemByTenantIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > > indexByTenantIdx;
	private Map< CFGenKbGenItemByCartIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > > indexByCartIdx;
	private Map< CFGenKbGenItemByRuleTypeIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > > indexByRuleTypeIdx;
	private Map< CFGenKbGenItemByToolSetIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > > indexByToolSetIdx;
	private Map< CFGenKbGenItemByScopeIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > > indexByScopeIdx;
	private Map< CFGenKbGenItemByGenDefIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > > indexByGenDefIdx;
	private Map< CFGenKbGenItemByAltIdxKey,
		ICFGenKbGenReferenceObj > indexByAltIdx;
	private Map< CFGenKbGenItemByGelExecIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > > indexByGelExecIdx;
	private Map< CFGenKbGenItemByProbeIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > > indexByProbeIdx;
	public static String TABLE_NAME = "GenReference";
	public static String TABLE_DBNAME = "kbgenref";

	public CFGenKbGenReferenceTableObj() {
		schema = null;
		members = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj>();
		allGenReference = null;
		indexByTenantIdx = null;
		indexByCartIdx = null;
		indexByRuleTypeIdx = null;
		indexByToolSetIdx = null;
		indexByScopeIdx = null;
		indexByGenDefIdx = null;
		indexByAltIdx = null;
		indexByGelExecIdx = null;
		indexByProbeIdx = null;
	}

	public CFGenKbGenReferenceTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj>();
		allGenReference = null;
		indexByTenantIdx = null;
		indexByCartIdx = null;
		indexByRuleTypeIdx = null;
		indexByToolSetIdx = null;
		indexByScopeIdx = null;
		indexByGenDefIdx = null;
		indexByAltIdx = null;
		indexByGelExecIdx = null;
		indexByProbeIdx = null;
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
		allGenReference = null;
		indexByTenantIdx = null;
		indexByCartIdx = null;
		indexByRuleTypeIdx = null;
		indexByToolSetIdx = null;
		indexByScopeIdx = null;
		indexByGenDefIdx = null;
		indexByAltIdx = null;
		indexByGelExecIdx = null;
		indexByProbeIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbGenReferenceObj.
	 */
	public ICFGenKbGenReferenceObj newInstance() {
		ICFGenKbGenReferenceObj inst = new CFGenKbGenReferenceObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbGenReferenceObj.
	 */
	public ICFGenKbGenReferenceEditObj newEditInstance( ICFGenKbGenReferenceObj orig ) {
		ICFGenKbGenReferenceEditObj edit = new CFGenKbGenReferenceEditObj( orig );
		return( edit );
	}

	public ICFGenKbGenReferenceObj realiseGenReference( ICFGenKbGenReferenceObj Obj ) {
		ICFGenKbGenReferenceObj obj = Obj;
		CFGenKbGenItemPKey pkey = obj.getPKey();
		ICFGenKbGenReferenceObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbGenReferenceObj existingObj = members.get( pkey );
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
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByCartIdx != null ) {
				CFGenKbGenItemByCartIdxKey keyCartIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
				keyCartIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyCartIdx.setRequiredCartridgeId( keepObj.getRequiredCartridgeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapCartIdx = indexByCartIdx.get( keyCartIdx );
				if( mapCartIdx != null ) {
					indexByCartIdx.remove( keyCartIdx );
				}
			}

			if( indexByRuleTypeIdx != null ) {
				CFGenKbGenItemByRuleTypeIdxKey keyRuleTypeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
				keyRuleTypeIdx.setRequiredRuleTypeId( keepObj.getRequiredRuleTypeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapRuleTypeIdx = indexByRuleTypeIdx.get( keyRuleTypeIdx );
				if( mapRuleTypeIdx != null ) {
					indexByRuleTypeIdx.remove( keyRuleTypeIdx );
				}
			}

			if( indexByToolSetIdx != null ) {
				CFGenKbGenItemByToolSetIdxKey keyToolSetIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
				keyToolSetIdx.setRequiredToolSetId( keepObj.getRequiredToolSetId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapToolSetIdx = indexByToolSetIdx.get( keyToolSetIdx );
				if( mapToolSetIdx != null ) {
					indexByToolSetIdx.remove( keyToolSetIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFGenKbGenItemByScopeIdxKey keyScopeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
				keyScopeIdx.setOptionalScopeDefId( keepObj.getOptionalScopeDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByGenDefIdx != null ) {
				CFGenKbGenItemByGenDefIdxKey keyGenDefIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
				keyGenDefIdx.setRequiredGenDefId( keepObj.getRequiredGenDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapGenDefIdx = indexByGenDefIdx.get( keyGenDefIdx );
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
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapGelExecIdx = indexByGelExecIdx.get( keyGelExecIdx );
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
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapProbeIdx = indexByProbeIdx.get( keyProbeIdx );
				if( mapProbeIdx != null ) {
					indexByProbeIdx.remove( keyProbeIdx );
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFGenKbGenReferenceObj)schema.getGenItemTableObj().realiseGenItem( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFGenKbGenItemByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCartIdx != null ) {
				CFGenKbGenItemByCartIdxKey keyCartIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
				keyCartIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyCartIdx.setRequiredCartridgeId( keepObj.getRequiredCartridgeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapCartIdx = indexByCartIdx.get( keyCartIdx );
				if( mapCartIdx != null ) {
					mapCartIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRuleTypeIdx != null ) {
				CFGenKbGenItemByRuleTypeIdxKey keyRuleTypeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
				keyRuleTypeIdx.setRequiredRuleTypeId( keepObj.getRequiredRuleTypeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapRuleTypeIdx = indexByRuleTypeIdx.get( keyRuleTypeIdx );
				if( mapRuleTypeIdx != null ) {
					mapRuleTypeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToolSetIdx != null ) {
				CFGenKbGenItemByToolSetIdxKey keyToolSetIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
				keyToolSetIdx.setRequiredToolSetId( keepObj.getRequiredToolSetId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapToolSetIdx = indexByToolSetIdx.get( keyToolSetIdx );
				if( mapToolSetIdx != null ) {
					mapToolSetIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFGenKbGenItemByScopeIdxKey keyScopeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
				keyScopeIdx.setOptionalScopeDefId( keepObj.getOptionalScopeDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGenDefIdx != null ) {
				CFGenKbGenItemByGenDefIdxKey keyGenDefIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
				keyGenDefIdx.setRequiredGenDefId( keepObj.getRequiredGenDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapGenDefIdx = indexByGenDefIdx.get( keyGenDefIdx );
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
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapGelExecIdx = indexByGelExecIdx.get( keyGelExecIdx );
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
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapProbeIdx = indexByProbeIdx.get( keyProbeIdx );
				if( mapProbeIdx != null ) {
					mapProbeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allGenReference != null ) {
				allGenReference.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFGenKbGenReferenceObj)schema.getGenItemTableObj().realiseGenItem( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allGenReference != null ) {
				allGenReference.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFGenKbGenItemByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCartIdx != null ) {
				CFGenKbGenItemByCartIdxKey keyCartIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
				keyCartIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyCartIdx.setRequiredCartridgeId( keepObj.getRequiredCartridgeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapCartIdx = indexByCartIdx.get( keyCartIdx );
				if( mapCartIdx != null ) {
					mapCartIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRuleTypeIdx != null ) {
				CFGenKbGenItemByRuleTypeIdxKey keyRuleTypeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
				keyRuleTypeIdx.setRequiredRuleTypeId( keepObj.getRequiredRuleTypeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapRuleTypeIdx = indexByRuleTypeIdx.get( keyRuleTypeIdx );
				if( mapRuleTypeIdx != null ) {
					mapRuleTypeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToolSetIdx != null ) {
				CFGenKbGenItemByToolSetIdxKey keyToolSetIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
				keyToolSetIdx.setRequiredToolSetId( keepObj.getRequiredToolSetId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapToolSetIdx = indexByToolSetIdx.get( keyToolSetIdx );
				if( mapToolSetIdx != null ) {
					mapToolSetIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFGenKbGenItemByScopeIdxKey keyScopeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
				keyScopeIdx.setOptionalScopeDefId( keepObj.getOptionalScopeDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGenDefIdx != null ) {
				CFGenKbGenItemByGenDefIdxKey keyGenDefIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
				keyGenDefIdx.setRequiredGenDefId( keepObj.getRequiredGenDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapGenDefIdx = indexByGenDefIdx.get( keyGenDefIdx );
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
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapGelExecIdx = indexByGelExecIdx.get( keyGelExecIdx );
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
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapProbeIdx = indexByProbeIdx.get( keyProbeIdx );
				if( mapProbeIdx != null ) {
					mapProbeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetGenReference( ICFGenKbGenReferenceObj Obj ) {
		forgetGenReference( Obj, false );
	}

	public void forgetGenReference( ICFGenKbGenReferenceObj Obj, boolean forgetSubObjects ) {
		ICFGenKbGenReferenceObj obj = Obj;
		CFGenKbGenItemPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbGenReferenceObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFGenKbGenItemByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByCartIdx != null ) {
				CFGenKbGenItemByCartIdxKey keyCartIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
				keyCartIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyCartIdx.setRequiredCartridgeId( keepObj.getRequiredCartridgeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapCartIdx = indexByCartIdx.get( keyCartIdx );
				if( mapCartIdx != null ) {
					indexByCartIdx.remove( keyCartIdx );
				}
			}

			if( indexByRuleTypeIdx != null ) {
				CFGenKbGenItemByRuleTypeIdxKey keyRuleTypeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
				keyRuleTypeIdx.setRequiredRuleTypeId( keepObj.getRequiredRuleTypeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapRuleTypeIdx = indexByRuleTypeIdx.get( keyRuleTypeIdx );
				if( mapRuleTypeIdx != null ) {
					indexByRuleTypeIdx.remove( keyRuleTypeIdx );
				}
			}

			if( indexByToolSetIdx != null ) {
				CFGenKbGenItemByToolSetIdxKey keyToolSetIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
				keyToolSetIdx.setRequiredToolSetId( keepObj.getRequiredToolSetId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapToolSetIdx = indexByToolSetIdx.get( keyToolSetIdx );
				if( mapToolSetIdx != null ) {
					indexByToolSetIdx.remove( keyToolSetIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFGenKbGenItemByScopeIdxKey keyScopeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
				keyScopeIdx.setOptionalScopeDefId( keepObj.getOptionalScopeDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByGenDefIdx != null ) {
				CFGenKbGenItemByGenDefIdxKey keyGenDefIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
				keyGenDefIdx.setRequiredGenDefId( keepObj.getRequiredGenDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapGenDefIdx = indexByGenDefIdx.get( keyGenDefIdx );
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
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapGelExecIdx = indexByGelExecIdx.get( keyGelExecIdx );
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
				Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapProbeIdx = indexByProbeIdx.get( keyProbeIdx );
				if( mapProbeIdx != null ) {
					indexByProbeIdx.remove( keyProbeIdx );
				}
			}

			if( allGenReference != null ) {
				allGenReference.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		((ICFGenKbSchemaObj)schema).getGenItemTableObj().forgetGenItem( obj );
	}

	public void forgetGenReferenceByItemIdIdx( long TenantId,
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
			ICFGenKbGenReferenceObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetGenReferenceByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFGenKbGenReferenceObj> toForget = new LinkedList<ICFGenKbGenReferenceObj>();
		ICFGenKbGenReferenceObj cur = null;
		CFGenKbGenItemByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFGenKbGenReferenceObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenReferenceObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenReferenceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenReferenceByCartIdx( long TenantId,
		long CartridgeId )
	{
		if( indexByCartIdx == null ) {
			return;
		}
		List<ICFGenKbGenReferenceObj> toForget = new LinkedList<ICFGenKbGenReferenceObj>();
		ICFGenKbGenReferenceObj cur = null;
		CFGenKbGenItemByCartIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCartridgeId( CartridgeId );
		if( indexByCartIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapCartIdx = indexByCartIdx.get( key );
			if( mapCartIdx != null ) {
				Iterator<ICFGenKbGenReferenceObj> iterDup = mapCartIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByCartIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenReferenceObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenReferenceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenReferenceByRuleTypeIdx( short RuleTypeId )
	{
		if( indexByRuleTypeIdx == null ) {
			return;
		}
		List<ICFGenKbGenReferenceObj> toForget = new LinkedList<ICFGenKbGenReferenceObj>();
		ICFGenKbGenReferenceObj cur = null;
		CFGenKbGenItemByRuleTypeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
		key.setRequiredRuleTypeId( RuleTypeId );
		if( indexByRuleTypeIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapRuleTypeIdx = indexByRuleTypeIdx.get( key );
			if( mapRuleTypeIdx != null ) {
				Iterator<ICFGenKbGenReferenceObj> iterDup = mapRuleTypeIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRuleTypeIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenReferenceObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenReferenceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenReferenceByToolSetIdx( short ToolSetId )
	{
		if( indexByToolSetIdx == null ) {
			return;
		}
		List<ICFGenKbGenReferenceObj> toForget = new LinkedList<ICFGenKbGenReferenceObj>();
		ICFGenKbGenReferenceObj cur = null;
		CFGenKbGenItemByToolSetIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
		key.setRequiredToolSetId( ToolSetId );
		if( indexByToolSetIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapToolSetIdx = indexByToolSetIdx.get( key );
			if( mapToolSetIdx != null ) {
				Iterator<ICFGenKbGenReferenceObj> iterDup = mapToolSetIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByToolSetIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenReferenceObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenReferenceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenReferenceByScopeIdx( Short ScopeDefId )
	{
		if( indexByScopeIdx == null ) {
			return;
		}
		List<ICFGenKbGenReferenceObj> toForget = new LinkedList<ICFGenKbGenReferenceObj>();
		ICFGenKbGenReferenceObj cur = null;
		CFGenKbGenItemByScopeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
		key.setOptionalScopeDefId( ScopeDefId );
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapScopeIdx = indexByScopeIdx.get( key );
			if( mapScopeIdx != null ) {
				Iterator<ICFGenKbGenReferenceObj> iterDup = mapScopeIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByScopeIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenReferenceObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenReferenceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenReferenceByGenDefIdx( short GenDefId )
	{
		if( indexByGenDefIdx == null ) {
			return;
		}
		List<ICFGenKbGenReferenceObj> toForget = new LinkedList<ICFGenKbGenReferenceObj>();
		ICFGenKbGenReferenceObj cur = null;
		CFGenKbGenItemByGenDefIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
		key.setRequiredGenDefId( GenDefId );
		if( indexByGenDefIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapGenDefIdx = indexByGenDefIdx.get( key );
			if( mapGenDefIdx != null ) {
				Iterator<ICFGenKbGenReferenceObj> iterDup = mapGenDefIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGenDefIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenReferenceObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenReferenceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenReferenceByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId )
	{
		if( indexByAltIdx == null ) {
			return;
		}
		List<ICFGenKbGenReferenceObj> toForget = new LinkedList<ICFGenKbGenReferenceObj>();
		ICFGenKbGenReferenceObj cur = null;
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
		Iterator<ICFGenKbGenReferenceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenReferenceByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId )
	{
		if( indexByGelExecIdx == null ) {
			return;
		}
		List<ICFGenKbGenReferenceObj> toForget = new LinkedList<ICFGenKbGenReferenceObj>();
		ICFGenKbGenReferenceObj cur = null;
		CFGenKbGenItemByGelExecIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGelExecIdxKey();
		key.setOptionalGelExecutableTenantId( GelExecutableTenantId );
		key.setOptionalGelExecutableGelCacheId( GelExecutableGelCacheId );
		key.setOptionalGelExecutableId( GelExecutableId );
		if( indexByGelExecIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapGelExecIdx = indexByGelExecIdx.get( key );
			if( mapGelExecIdx != null ) {
				Iterator<ICFGenKbGenReferenceObj> iterDup = mapGelExecIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGelExecIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenReferenceObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenReferenceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenReferenceByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId )
	{
		if( indexByProbeIdx == null ) {
			return;
		}
		List<ICFGenKbGenReferenceObj> toForget = new LinkedList<ICFGenKbGenReferenceObj>();
		ICFGenKbGenReferenceObj cur = null;
		CFGenKbGenItemByProbeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newProbeIdxKey();
		key.setOptionalProbeTenantId( ProbeTenantId );
		key.setOptionalProbeCartridgeId( ProbeCartridgeId );
		key.setOptionalProbeGenItemId( ProbeGenItemId );
		if( indexByProbeIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > mapProbeIdx = indexByProbeIdx.get( key );
			if( mapProbeIdx != null ) {
				Iterator<ICFGenKbGenReferenceObj> iterDup = mapProbeIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByProbeIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenReferenceObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenReferenceObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbGenReferenceObj createGenReference( ICFGenKbGenReferenceObj Obj ) {
		ICFGenKbGenReferenceObj obj = Obj;
		CFGenKbGenReferenceBuff buff = obj.getGenReferenceBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().createGenReference(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "REF" ) ) {
			obj = (ICFGenKbGenReferenceObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbGenReferenceObj readGenReference( CFGenKbGenItemPKey pkey ) {
		return( readGenReference( pkey, false ) );
	}

	public ICFGenKbGenReferenceObj readGenReference( CFGenKbGenItemPKey pkey, boolean forceRead ) {
		ICFGenKbGenReferenceObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbGenReferenceBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().readDerivedByItemIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredCartridgeId(),
				pkey.getRequiredItemId() );
			if( readBuff != null ) {
				obj = (ICFGenKbGenReferenceObj)schema.getGenItemTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbGenReferenceObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbGenReferenceObj lockGenReference( CFGenKbGenItemPKey pkey ) {
		ICFGenKbGenReferenceObj locked = null;
		CFGenKbGenReferenceBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFGenKbGenReferenceObj)schema.getGenItemTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbGenReferenceObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockGenReference", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbGenReferenceObj> readAllGenReference() {
		return( readAllGenReference( false ) );
	}

	public List<ICFGenKbGenReferenceObj> readAllGenReference( boolean forceRead ) {
		final String S_ProcName = "readAllGenReference";
		if( ( allGenReference == null ) || forceRead ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> map = new HashMap<CFGenKbGenItemPKey,ICFGenKbGenReferenceObj>();
			allGenReference = map;
			CFGenKbGenReferenceBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().readAllDerived( schema.getAuthorization() );
			CFGenKbGenReferenceBuff buff;
			ICFGenKbGenReferenceObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenReferenceObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenReferenceObj realised = (ICFGenKbGenReferenceObj)obj.realise();
			}
		}
		int len = allGenReference.size();
		ICFGenKbGenReferenceObj arr[] = new ICFGenKbGenReferenceObj[len];
		Iterator<ICFGenKbGenReferenceObj> valIter = allGenReference.values().iterator();
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
		ArrayList<ICFGenKbGenReferenceObj> arrayList = new ArrayList<ICFGenKbGenReferenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenReferenceObj> cmp = new Comparator<ICFGenKbGenReferenceObj>() {
			public int compare( ICFGenKbGenReferenceObj lhs, ICFGenKbGenReferenceObj rhs ) {
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
		List<ICFGenKbGenReferenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGenReferenceObj readGenReferenceByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId )
	{
		return( readGenReferenceByItemIdIdx( TenantId,
			CartridgeId,
			ItemId,
			false ) );
	}

	public ICFGenKbGenReferenceObj readGenReferenceByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId, boolean forceRead )
	{
		CFGenKbGenItemPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredCartridgeId( CartridgeId );
		pkey.setRequiredItemId( ItemId );
		ICFGenKbGenReferenceObj obj = readGenReference( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbGenReferenceObj> readGenReferenceByTenantIdx( long TenantId )
	{
		return( readGenReferenceByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFGenKbGenReferenceObj> readGenReferenceByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenReferenceByTenantIdx";
		CFGenKbGenItemByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGenItemByTenantIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenReferenceObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenReferenceObj realised = (ICFGenKbGenReferenceObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenReferenceObj arr[] = new ICFGenKbGenReferenceObj[len];
		Iterator<ICFGenKbGenReferenceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenReferenceObj> arrayList = new ArrayList<ICFGenKbGenReferenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenReferenceObj> cmp = new Comparator<ICFGenKbGenReferenceObj>() {
			public int compare( ICFGenKbGenReferenceObj lhs, ICFGenKbGenReferenceObj rhs ) {
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
		List<ICFGenKbGenReferenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenReferenceObj> readGenReferenceByCartIdx( long TenantId,
		long CartridgeId )
	{
		return( readGenReferenceByCartIdx( TenantId,
			CartridgeId,
			false ) );
	}

	public List<ICFGenKbGenReferenceObj> readGenReferenceByCartIdx( long TenantId,
		long CartridgeId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenReferenceByCartIdx";
		CFGenKbGenItemByCartIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCartridgeId( CartridgeId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> dict;
		if( indexByCartIdx == null ) {
			indexByCartIdx = new HashMap< CFGenKbGenItemByCartIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > >();
		}
		if( ( ! forceRead ) && indexByCartIdx.containsKey( key ) ) {
			dict = indexByCartIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByCartIdx( schema.getAuthorization(),
				TenantId,
				CartridgeId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenReferenceObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenReferenceObj realised = (ICFGenKbGenReferenceObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByCartIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenReferenceObj arr[] = new ICFGenKbGenReferenceObj[len];
		Iterator<ICFGenKbGenReferenceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenReferenceObj> arrayList = new ArrayList<ICFGenKbGenReferenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenReferenceObj> cmp = new Comparator<ICFGenKbGenReferenceObj>() {
			public int compare( ICFGenKbGenReferenceObj lhs, ICFGenKbGenReferenceObj rhs ) {
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
		List<ICFGenKbGenReferenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenReferenceObj> readGenReferenceByRuleTypeIdx( short RuleTypeId )
	{
		return( readGenReferenceByRuleTypeIdx( RuleTypeId,
			false ) );
	}

	public List<ICFGenKbGenReferenceObj> readGenReferenceByRuleTypeIdx( short RuleTypeId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenReferenceByRuleTypeIdx";
		CFGenKbGenItemByRuleTypeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
		key.setRequiredRuleTypeId( RuleTypeId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> dict;
		if( indexByRuleTypeIdx == null ) {
			indexByRuleTypeIdx = new HashMap< CFGenKbGenItemByRuleTypeIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > >();
		}
		if( ( ! forceRead ) && indexByRuleTypeIdx.containsKey( key ) ) {
			dict = indexByRuleTypeIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByRuleTypeIdx( schema.getAuthorization(),
				RuleTypeId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenReferenceObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenReferenceObj realised = (ICFGenKbGenReferenceObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRuleTypeIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenReferenceObj arr[] = new ICFGenKbGenReferenceObj[len];
		Iterator<ICFGenKbGenReferenceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenReferenceObj> arrayList = new ArrayList<ICFGenKbGenReferenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenReferenceObj> cmp = new Comparator<ICFGenKbGenReferenceObj>() {
			public int compare( ICFGenKbGenReferenceObj lhs, ICFGenKbGenReferenceObj rhs ) {
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
		List<ICFGenKbGenReferenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenReferenceObj> readGenReferenceByToolSetIdx( short ToolSetId )
	{
		return( readGenReferenceByToolSetIdx( ToolSetId,
			false ) );
	}

	public List<ICFGenKbGenReferenceObj> readGenReferenceByToolSetIdx( short ToolSetId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenReferenceByToolSetIdx";
		CFGenKbGenItemByToolSetIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
		key.setRequiredToolSetId( ToolSetId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> dict;
		if( indexByToolSetIdx == null ) {
			indexByToolSetIdx = new HashMap< CFGenKbGenItemByToolSetIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > >();
		}
		if( ( ! forceRead ) && indexByToolSetIdx.containsKey( key ) ) {
			dict = indexByToolSetIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByToolSetIdx( schema.getAuthorization(),
				ToolSetId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenReferenceObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenReferenceObj realised = (ICFGenKbGenReferenceObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByToolSetIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenReferenceObj arr[] = new ICFGenKbGenReferenceObj[len];
		Iterator<ICFGenKbGenReferenceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenReferenceObj> arrayList = new ArrayList<ICFGenKbGenReferenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenReferenceObj> cmp = new Comparator<ICFGenKbGenReferenceObj>() {
			public int compare( ICFGenKbGenReferenceObj lhs, ICFGenKbGenReferenceObj rhs ) {
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
		List<ICFGenKbGenReferenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenReferenceObj> readGenReferenceByScopeIdx( Short ScopeDefId )
	{
		return( readGenReferenceByScopeIdx( ScopeDefId,
			false ) );
	}

	public List<ICFGenKbGenReferenceObj> readGenReferenceByScopeIdx( Short ScopeDefId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenReferenceByScopeIdx";
		CFGenKbGenItemByScopeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
		key.setOptionalScopeDefId( ScopeDefId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFGenKbGenItemByScopeIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByScopeIdx( schema.getAuthorization(),
				ScopeDefId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenReferenceObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenReferenceObj realised = (ICFGenKbGenReferenceObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenReferenceObj arr[] = new ICFGenKbGenReferenceObj[len];
		Iterator<ICFGenKbGenReferenceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenReferenceObj> arrayList = new ArrayList<ICFGenKbGenReferenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenReferenceObj> cmp = new Comparator<ICFGenKbGenReferenceObj>() {
			public int compare( ICFGenKbGenReferenceObj lhs, ICFGenKbGenReferenceObj rhs ) {
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
		List<ICFGenKbGenReferenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenReferenceObj> readGenReferenceByGenDefIdx( short GenDefId )
	{
		return( readGenReferenceByGenDefIdx( GenDefId,
			false ) );
	}

	public List<ICFGenKbGenReferenceObj> readGenReferenceByGenDefIdx( short GenDefId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenReferenceByGenDefIdx";
		CFGenKbGenItemByGenDefIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
		key.setRequiredGenDefId( GenDefId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> dict;
		if( indexByGenDefIdx == null ) {
			indexByGenDefIdx = new HashMap< CFGenKbGenItemByGenDefIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > >();
		}
		if( ( ! forceRead ) && indexByGenDefIdx.containsKey( key ) ) {
			dict = indexByGenDefIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByGenDefIdx( schema.getAuthorization(),
				GenDefId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenReferenceObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenReferenceObj realised = (ICFGenKbGenReferenceObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGenDefIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenReferenceObj arr[] = new ICFGenKbGenReferenceObj[len];
		Iterator<ICFGenKbGenReferenceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenReferenceObj> arrayList = new ArrayList<ICFGenKbGenReferenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenReferenceObj> cmp = new Comparator<ICFGenKbGenReferenceObj>() {
			public int compare( ICFGenKbGenReferenceObj lhs, ICFGenKbGenReferenceObj rhs ) {
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
		List<ICFGenKbGenReferenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGenReferenceObj readGenReferenceByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId )
	{
		return( readGenReferenceByAltIdx( Name,
			ToolSetId,
			ScopeDefId,
			GenDefId,
			false ) );
	}

	public ICFGenKbGenReferenceObj readGenReferenceByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId, boolean forceRead )
	{
		if( indexByAltIdx == null ) {
			indexByAltIdx = new HashMap< CFGenKbGenItemByAltIdxKey,
				ICFGenKbGenReferenceObj >();
		}
		CFGenKbGenItemByAltIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newAltIdxKey();
		key.setRequiredName( Name );
		key.setRequiredToolSetId( ToolSetId );
		key.setOptionalScopeDefId( ScopeDefId );
		key.setRequiredGenDefId( GenDefId );
		ICFGenKbGenReferenceObj obj = null;
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
				obj = (ICFGenKbGenReferenceObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				obj = (ICFGenKbGenReferenceObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFGenKbGenReferenceObj> readGenReferenceByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId )
	{
		return( readGenReferenceByGelExecIdx( GelExecutableTenantId,
			GelExecutableGelCacheId,
			GelExecutableId,
			false ) );
	}

	public List<ICFGenKbGenReferenceObj> readGenReferenceByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenReferenceByGelExecIdx";
		CFGenKbGenItemByGelExecIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGelExecIdxKey();
		key.setOptionalGelExecutableTenantId( GelExecutableTenantId );
		key.setOptionalGelExecutableGelCacheId( GelExecutableGelCacheId );
		key.setOptionalGelExecutableId( GelExecutableId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> dict;
		if( indexByGelExecIdx == null ) {
			indexByGelExecIdx = new HashMap< CFGenKbGenItemByGelExecIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > >();
		}
		if( ( ! forceRead ) && indexByGelExecIdx.containsKey( key ) ) {
			dict = indexByGelExecIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByGelExecIdx( schema.getAuthorization(),
				GelExecutableTenantId,
				GelExecutableGelCacheId,
				GelExecutableId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenReferenceObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenReferenceObj realised = (ICFGenKbGenReferenceObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGelExecIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenReferenceObj arr[] = new ICFGenKbGenReferenceObj[len];
		Iterator<ICFGenKbGenReferenceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenReferenceObj> arrayList = new ArrayList<ICFGenKbGenReferenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenReferenceObj> cmp = new Comparator<ICFGenKbGenReferenceObj>() {
			public int compare( ICFGenKbGenReferenceObj lhs, ICFGenKbGenReferenceObj rhs ) {
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
		List<ICFGenKbGenReferenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenReferenceObj> readGenReferenceByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId )
	{
		return( readGenReferenceByProbeIdx( ProbeTenantId,
			ProbeCartridgeId,
			ProbeGenItemId,
			false ) );
	}

	public List<ICFGenKbGenReferenceObj> readGenReferenceByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenReferenceByProbeIdx";
		CFGenKbGenItemByProbeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newProbeIdxKey();
		key.setOptionalProbeTenantId( ProbeTenantId );
		key.setOptionalProbeCartridgeId( ProbeCartridgeId );
		key.setOptionalProbeGenItemId( ProbeGenItemId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> dict;
		if( indexByProbeIdx == null ) {
			indexByProbeIdx = new HashMap< CFGenKbGenItemByProbeIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > >();
		}
		if( ( ! forceRead ) && indexByProbeIdx.containsKey( key ) ) {
			dict = indexByProbeIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByProbeIdx( schema.getAuthorization(),
				ProbeTenantId,
				ProbeCartridgeId,
				ProbeGenItemId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenReferenceObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenReferenceObj realised = (ICFGenKbGenReferenceObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByProbeIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenReferenceObj arr[] = new ICFGenKbGenReferenceObj[len];
		Iterator<ICFGenKbGenReferenceObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenReferenceObj> arrayList = new ArrayList<ICFGenKbGenReferenceObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenReferenceObj> cmp = new Comparator<ICFGenKbGenReferenceObj>() {
			public int compare( ICFGenKbGenReferenceObj lhs, ICFGenKbGenReferenceObj rhs ) {
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
		List<ICFGenKbGenReferenceObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGenReferenceObj updateGenReference( ICFGenKbGenReferenceObj Obj ) {
		ICFGenKbGenReferenceObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().updateGenReference( schema.getAuthorization(),
			Obj.getGenReferenceBuff() );
		if( Obj.getClassCode().equals( "REF" ) ) {
			obj = (ICFGenKbGenReferenceObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteGenReference( ICFGenKbGenReferenceObj Obj ) {
		ICFGenKbGenReferenceObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReference( schema.getAuthorization(),
			obj.getGenReferenceBuff() );
		obj.forget( true );
	}

	public void deleteGenReferenceByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId )
	{
		CFGenKbGenItemPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredCartridgeId( CartridgeId );
		pkey.setRequiredItemId( ItemId );
		ICFGenKbGenReferenceObj obj = readGenReference( pkey );
		if( obj != null ) {
			ICFGenKbGenReferenceEditObj editObj = (ICFGenKbGenReferenceEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbGenReferenceEditObj)obj.beginEdit();
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

	public void deleteGenReferenceByTenantIdx( long TenantId )
	{
		CFGenKbGenItemByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGenItemByTenantIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> dict = indexByTenantIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReferenceByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFGenKbGenReferenceObj> iter = dict.values().iterator();
			ICFGenKbGenReferenceObj obj;
			List<ICFGenKbGenReferenceObj> toForget = new LinkedList<ICFGenKbGenReferenceObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReferenceByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteGenReferenceByCartIdx( long TenantId,
		long CartridgeId )
	{
		CFGenKbGenItemByCartIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCartridgeId( CartridgeId );
		if( indexByCartIdx == null ) {
			indexByCartIdx = new HashMap< CFGenKbGenItemByCartIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > >();
		}
		if( indexByCartIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> dict = indexByCartIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReferenceByCartIdx( schema.getAuthorization(),
				TenantId,
				CartridgeId );
			Iterator<ICFGenKbGenReferenceObj> iter = dict.values().iterator();
			ICFGenKbGenReferenceObj obj;
			List<ICFGenKbGenReferenceObj> toForget = new LinkedList<ICFGenKbGenReferenceObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReferenceByCartIdx( schema.getAuthorization(),
				TenantId,
				CartridgeId );
		}
	}

	public void deleteGenReferenceByRuleTypeIdx( short RuleTypeId )
	{
		CFGenKbGenItemByRuleTypeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
		key.setRequiredRuleTypeId( RuleTypeId );
		if( indexByRuleTypeIdx == null ) {
			indexByRuleTypeIdx = new HashMap< CFGenKbGenItemByRuleTypeIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > >();
		}
		if( indexByRuleTypeIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> dict = indexByRuleTypeIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReferenceByRuleTypeIdx( schema.getAuthorization(),
				RuleTypeId );
			Iterator<ICFGenKbGenReferenceObj> iter = dict.values().iterator();
			ICFGenKbGenReferenceObj obj;
			List<ICFGenKbGenReferenceObj> toForget = new LinkedList<ICFGenKbGenReferenceObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReferenceByRuleTypeIdx( schema.getAuthorization(),
				RuleTypeId );
		}
	}

	public void deleteGenReferenceByToolSetIdx( short ToolSetId )
	{
		CFGenKbGenItemByToolSetIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
		key.setRequiredToolSetId( ToolSetId );
		if( indexByToolSetIdx == null ) {
			indexByToolSetIdx = new HashMap< CFGenKbGenItemByToolSetIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > >();
		}
		if( indexByToolSetIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> dict = indexByToolSetIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReferenceByToolSetIdx( schema.getAuthorization(),
				ToolSetId );
			Iterator<ICFGenKbGenReferenceObj> iter = dict.values().iterator();
			ICFGenKbGenReferenceObj obj;
			List<ICFGenKbGenReferenceObj> toForget = new LinkedList<ICFGenKbGenReferenceObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReferenceByToolSetIdx( schema.getAuthorization(),
				ToolSetId );
		}
	}

	public void deleteGenReferenceByScopeIdx( Short ScopeDefId )
	{
		CFGenKbGenItemByScopeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
		key.setOptionalScopeDefId( ScopeDefId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFGenKbGenItemByScopeIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> dict = indexByScopeIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReferenceByScopeIdx( schema.getAuthorization(),
				ScopeDefId );
			Iterator<ICFGenKbGenReferenceObj> iter = dict.values().iterator();
			ICFGenKbGenReferenceObj obj;
			List<ICFGenKbGenReferenceObj> toForget = new LinkedList<ICFGenKbGenReferenceObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReferenceByScopeIdx( schema.getAuthorization(),
				ScopeDefId );
		}
	}

	public void deleteGenReferenceByGenDefIdx( short GenDefId )
	{
		CFGenKbGenItemByGenDefIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
		key.setRequiredGenDefId( GenDefId );
		if( indexByGenDefIdx == null ) {
			indexByGenDefIdx = new HashMap< CFGenKbGenItemByGenDefIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > >();
		}
		if( indexByGenDefIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> dict = indexByGenDefIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReferenceByGenDefIdx( schema.getAuthorization(),
				GenDefId );
			Iterator<ICFGenKbGenReferenceObj> iter = dict.values().iterator();
			ICFGenKbGenReferenceObj obj;
			List<ICFGenKbGenReferenceObj> toForget = new LinkedList<ICFGenKbGenReferenceObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReferenceByGenDefIdx( schema.getAuthorization(),
				GenDefId );
		}
	}

	public void deleteGenReferenceByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId )
	{
		if( indexByAltIdx == null ) {
			indexByAltIdx = new HashMap< CFGenKbGenItemByAltIdxKey,
				ICFGenKbGenReferenceObj >();
		}
		CFGenKbGenItemByAltIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newAltIdxKey();
		key.setRequiredName( Name );
		key.setRequiredToolSetId( ToolSetId );
		key.setOptionalScopeDefId( ScopeDefId );
		key.setRequiredGenDefId( GenDefId );
		ICFGenKbGenReferenceObj obj = null;
		if( indexByAltIdx.containsKey( key ) ) {
			obj = indexByAltIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReferenceByAltIdx( schema.getAuthorization(),
				Name,
				ToolSetId,
				ScopeDefId,
				GenDefId );
			obj.forget( true );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReferenceByAltIdx( schema.getAuthorization(),
				Name,
				ToolSetId,
				ScopeDefId,
				GenDefId );
		}
	}

	public void deleteGenReferenceByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId )
	{
		CFGenKbGenItemByGelExecIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGelExecIdxKey();
		key.setOptionalGelExecutableTenantId( GelExecutableTenantId );
		key.setOptionalGelExecutableGelCacheId( GelExecutableGelCacheId );
		key.setOptionalGelExecutableId( GelExecutableId );
		if( indexByGelExecIdx == null ) {
			indexByGelExecIdx = new HashMap< CFGenKbGenItemByGelExecIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > >();
		}
		if( indexByGelExecIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> dict = indexByGelExecIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReferenceByGelExecIdx( schema.getAuthorization(),
				GelExecutableTenantId,
				GelExecutableGelCacheId,
				GelExecutableId );
			Iterator<ICFGenKbGenReferenceObj> iter = dict.values().iterator();
			ICFGenKbGenReferenceObj obj;
			List<ICFGenKbGenReferenceObj> toForget = new LinkedList<ICFGenKbGenReferenceObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReferenceByGelExecIdx( schema.getAuthorization(),
				GelExecutableTenantId,
				GelExecutableGelCacheId,
				GelExecutableId );
		}
	}

	public void deleteGenReferenceByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId )
	{
		CFGenKbGenItemByProbeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newProbeIdxKey();
		key.setOptionalProbeTenantId( ProbeTenantId );
		key.setOptionalProbeCartridgeId( ProbeCartridgeId );
		key.setOptionalProbeGenItemId( ProbeGenItemId );
		if( indexByProbeIdx == null ) {
			indexByProbeIdx = new HashMap< CFGenKbGenItemByProbeIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenReferenceObj > >();
		}
		if( indexByProbeIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenReferenceObj> dict = indexByProbeIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReferenceByProbeIdx( schema.getAuthorization(),
				ProbeTenantId,
				ProbeCartridgeId,
				ProbeGenItemId );
			Iterator<ICFGenKbGenReferenceObj> iter = dict.values().iterator();
			ICFGenKbGenReferenceObj obj;
			List<ICFGenKbGenReferenceObj> toForget = new LinkedList<ICFGenKbGenReferenceObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenReference().deleteGenReferenceByProbeIdx( schema.getAuthorization(),
				ProbeTenantId,
				ProbeCartridgeId,
				ProbeGenItemId );
		}
	}
}
