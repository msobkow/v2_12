// Description: Java 11 Table Object implementation for CFGenKb.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public class CFGenKbGenItemTableObj
	implements ICFGenKbGenItemTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> members;
	private Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> allGenItem;
	private Map< CFGenKbGenItemByTenantIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > > indexByTenantIdx;
	private Map< CFGenKbGenItemByCartIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > > indexByCartIdx;
	private Map< CFGenKbGenItemByRuleTypeIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > > indexByRuleTypeIdx;
	private Map< CFGenKbGenItemByToolSetIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > > indexByToolSetIdx;
	private Map< CFGenKbGenItemByScopeIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > > indexByScopeIdx;
	private Map< CFGenKbGenItemByGenDefIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > > indexByGenDefIdx;
	private Map< CFGenKbGenItemByAltIdxKey,
		ICFGenKbGenItemObj > indexByAltIdx;
	private Map< CFGenKbGenItemByGelExecIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > > indexByGelExecIdx;
	private Map< CFGenKbGenItemByProbeIdxKey,
		Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > > indexByProbeIdx;
	public static String TABLE_NAME = "GenItem";
	public static String TABLE_DBNAME = "kbgenitem";

	public CFGenKbGenItemTableObj() {
		schema = null;
		members = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenItemObj>();
		allGenItem = null;
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

	public CFGenKbGenItemTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenItemObj>();
		allGenItem = null;
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
		allGenItem = null;
		indexByTenantIdx = null;
		indexByCartIdx = null;
		indexByRuleTypeIdx = null;
		indexByToolSetIdx = null;
		indexByScopeIdx = null;
		indexByGenDefIdx = null;
		indexByAltIdx = null;
		indexByGelExecIdx = null;
		indexByProbeIdx = null;
		List<ICFGenKbGenItemObj> toForget = new LinkedList<ICFGenKbGenItemObj>();
		ICFGenKbGenItemObj cur = null;
		Iterator<ICFGenKbGenItemObj> iter = members.values().iterator();
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
	 *	CFGenKbGenItemObj.
	 */
	public ICFGenKbGenItemObj newInstance() {
		ICFGenKbGenItemObj inst = new CFGenKbGenItemObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbGenItemObj.
	 */
	public ICFGenKbGenItemEditObj newEditInstance( ICFGenKbGenItemObj orig ) {
		ICFGenKbGenItemEditObj edit = new CFGenKbGenItemEditObj( orig );
		return( edit );
	}

	public ICFGenKbGenItemObj constructByClassCode( String argClassCode ) {
		ICFGenKbGenItemObj obj = null;
		if( argClassCode.equals( "ITM" ) ) {
			obj = ((ICFGenKbSchemaObj)schema).getGenItemTableObj().newInstance();
		}
		else if( argClassCode.equals( "ITR" ) ) {
			obj = ((ICFGenKbSchemaObj)schema).getGenIteratorTableObj().newInstance();
		}
		else if( argClassCode.equals( "REF" ) ) {
			obj = ((ICFGenKbSchemaObj)schema).getGenReferenceTableObj().newInstance();
		}
		else if( argClassCode.equals( "RUL" ) ) {
			obj = ((ICFGenKbSchemaObj)schema).getGenRuleTableObj().newInstance();
		}
		else if( argClassCode.equals( "TRC" ) ) {
			obj = ((ICFGenKbSchemaObj)schema).getGenTruncTableObj().newInstance();
		}
		else if( argClassCode.equals( "FIL" ) ) {
			obj = ((ICFGenKbSchemaObj)schema).getGenFileTableObj().newInstance();
		}
		else if( argClassCode.equals( "BND" ) ) {
			obj = ((ICFGenKbSchemaObj)schema).getGenBindTableObj().newInstance();
		}
		return( obj );
	}

	public ICFGenKbGenItemObj realiseGenItem( ICFGenKbGenItemObj Obj ) {
		ICFGenKbGenItemObj obj = Obj;
		CFGenKbGenItemPKey pkey = obj.getPKey();
		ICFGenKbGenItemObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbGenItemObj existingObj = members.get( pkey );
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
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByCartIdx != null ) {
				CFGenKbGenItemByCartIdxKey keyCartIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
				keyCartIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyCartIdx.setRequiredCartridgeId( keepObj.getRequiredCartridgeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapCartIdx = indexByCartIdx.get( keyCartIdx );
				if( mapCartIdx != null ) {
					mapCartIdx.remove( keepObj.getPKey() );
					if( mapCartIdx.size() <= 0 ) {
						indexByCartIdx.remove( keyCartIdx );
					}
				}
			}

			if( indexByRuleTypeIdx != null ) {
				CFGenKbGenItemByRuleTypeIdxKey keyRuleTypeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
				keyRuleTypeIdx.setRequiredRuleTypeId( keepObj.getRequiredRuleTypeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapRuleTypeIdx = indexByRuleTypeIdx.get( keyRuleTypeIdx );
				if( mapRuleTypeIdx != null ) {
					mapRuleTypeIdx.remove( keepObj.getPKey() );
					if( mapRuleTypeIdx.size() <= 0 ) {
						indexByRuleTypeIdx.remove( keyRuleTypeIdx );
					}
				}
			}

			if( indexByToolSetIdx != null ) {
				CFGenKbGenItemByToolSetIdxKey keyToolSetIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
				keyToolSetIdx.setRequiredToolSetId( keepObj.getRequiredToolSetId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapToolSetIdx = indexByToolSetIdx.get( keyToolSetIdx );
				if( mapToolSetIdx != null ) {
					mapToolSetIdx.remove( keepObj.getPKey() );
					if( mapToolSetIdx.size() <= 0 ) {
						indexByToolSetIdx.remove( keyToolSetIdx );
					}
				}
			}

			if( indexByScopeIdx != null ) {
				CFGenKbGenItemByScopeIdxKey keyScopeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
				keyScopeIdx.setOptionalScopeDefId( keepObj.getOptionalScopeDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.remove( keepObj.getPKey() );
					if( mapScopeIdx.size() <= 0 ) {
						indexByScopeIdx.remove( keyScopeIdx );
					}
				}
			}

			if( indexByGenDefIdx != null ) {
				CFGenKbGenItemByGenDefIdxKey keyGenDefIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
				keyGenDefIdx.setRequiredGenDefId( keepObj.getRequiredGenDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapGenDefIdx = indexByGenDefIdx.get( keyGenDefIdx );
				if( mapGenDefIdx != null ) {
					mapGenDefIdx.remove( keepObj.getPKey() );
					if( mapGenDefIdx.size() <= 0 ) {
						indexByGenDefIdx.remove( keyGenDefIdx );
					}
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
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapGelExecIdx = indexByGelExecIdx.get( keyGelExecIdx );
				if( mapGelExecIdx != null ) {
					mapGelExecIdx.remove( keepObj.getPKey() );
					if( mapGelExecIdx.size() <= 0 ) {
						indexByGelExecIdx.remove( keyGelExecIdx );
					}
				}
			}

			if( indexByProbeIdx != null ) {
				CFGenKbGenItemByProbeIdxKey keyProbeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newProbeIdxKey();
				keyProbeIdx.setOptionalProbeTenantId( keepObj.getOptionalProbeTenantId() );
				keyProbeIdx.setOptionalProbeCartridgeId( keepObj.getOptionalProbeCartridgeId() );
				keyProbeIdx.setOptionalProbeGenItemId( keepObj.getOptionalProbeGenItemId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapProbeIdx = indexByProbeIdx.get( keyProbeIdx );
				if( mapProbeIdx != null ) {
					mapProbeIdx.remove( keepObj.getPKey() );
					if( mapProbeIdx.size() <= 0 ) {
						indexByProbeIdx.remove( keyProbeIdx );
					}
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFGenKbGenItemByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCartIdx != null ) {
				CFGenKbGenItemByCartIdxKey keyCartIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
				keyCartIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyCartIdx.setRequiredCartridgeId( keepObj.getRequiredCartridgeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapCartIdx = indexByCartIdx.get( keyCartIdx );
				if( mapCartIdx != null ) {
					mapCartIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRuleTypeIdx != null ) {
				CFGenKbGenItemByRuleTypeIdxKey keyRuleTypeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
				keyRuleTypeIdx.setRequiredRuleTypeId( keepObj.getRequiredRuleTypeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapRuleTypeIdx = indexByRuleTypeIdx.get( keyRuleTypeIdx );
				if( mapRuleTypeIdx != null ) {
					mapRuleTypeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToolSetIdx != null ) {
				CFGenKbGenItemByToolSetIdxKey keyToolSetIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
				keyToolSetIdx.setRequiredToolSetId( keepObj.getRequiredToolSetId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapToolSetIdx = indexByToolSetIdx.get( keyToolSetIdx );
				if( mapToolSetIdx != null ) {
					mapToolSetIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFGenKbGenItemByScopeIdxKey keyScopeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
				keyScopeIdx.setOptionalScopeDefId( keepObj.getOptionalScopeDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGenDefIdx != null ) {
				CFGenKbGenItemByGenDefIdxKey keyGenDefIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
				keyGenDefIdx.setRequiredGenDefId( keepObj.getRequiredGenDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapGenDefIdx = indexByGenDefIdx.get( keyGenDefIdx );
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
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapGelExecIdx = indexByGelExecIdx.get( keyGelExecIdx );
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
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapProbeIdx = indexByProbeIdx.get( keyProbeIdx );
				if( mapProbeIdx != null ) {
					mapProbeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allGenItem != null ) {
				allGenItem.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allGenItem != null ) {
				allGenItem.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFGenKbGenItemByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCartIdx != null ) {
				CFGenKbGenItemByCartIdxKey keyCartIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
				keyCartIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyCartIdx.setRequiredCartridgeId( keepObj.getRequiredCartridgeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapCartIdx = indexByCartIdx.get( keyCartIdx );
				if( mapCartIdx != null ) {
					mapCartIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRuleTypeIdx != null ) {
				CFGenKbGenItemByRuleTypeIdxKey keyRuleTypeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
				keyRuleTypeIdx.setRequiredRuleTypeId( keepObj.getRequiredRuleTypeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapRuleTypeIdx = indexByRuleTypeIdx.get( keyRuleTypeIdx );
				if( mapRuleTypeIdx != null ) {
					mapRuleTypeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToolSetIdx != null ) {
				CFGenKbGenItemByToolSetIdxKey keyToolSetIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
				keyToolSetIdx.setRequiredToolSetId( keepObj.getRequiredToolSetId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapToolSetIdx = indexByToolSetIdx.get( keyToolSetIdx );
				if( mapToolSetIdx != null ) {
					mapToolSetIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFGenKbGenItemByScopeIdxKey keyScopeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
				keyScopeIdx.setOptionalScopeDefId( keepObj.getOptionalScopeDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGenDefIdx != null ) {
				CFGenKbGenItemByGenDefIdxKey keyGenDefIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
				keyGenDefIdx.setRequiredGenDefId( keepObj.getRequiredGenDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapGenDefIdx = indexByGenDefIdx.get( keyGenDefIdx );
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
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapGelExecIdx = indexByGelExecIdx.get( keyGelExecIdx );
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
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapProbeIdx = indexByProbeIdx.get( keyProbeIdx );
				if( mapProbeIdx != null ) {
					mapProbeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetGenItem( ICFGenKbGenItemObj Obj ) {
		forgetGenItem( Obj, false );
	}

	public void forgetGenItem( ICFGenKbGenItemObj Obj, boolean forgetSubObjects ) {
		ICFGenKbGenItemObj obj = Obj;
		CFGenKbGenItemPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbGenItemObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFGenKbGenItemByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByCartIdx != null ) {
				CFGenKbGenItemByCartIdxKey keyCartIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
				keyCartIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyCartIdx.setRequiredCartridgeId( keepObj.getRequiredCartridgeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapCartIdx = indexByCartIdx.get( keyCartIdx );
				if( mapCartIdx != null ) {
					mapCartIdx.remove( keepObj.getPKey() );
					if( mapCartIdx.size() <= 0 ) {
						indexByCartIdx.remove( keyCartIdx );
					}
				}
			}

			if( indexByRuleTypeIdx != null ) {
				CFGenKbGenItemByRuleTypeIdxKey keyRuleTypeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
				keyRuleTypeIdx.setRequiredRuleTypeId( keepObj.getRequiredRuleTypeId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapRuleTypeIdx = indexByRuleTypeIdx.get( keyRuleTypeIdx );
				if( mapRuleTypeIdx != null ) {
					mapRuleTypeIdx.remove( keepObj.getPKey() );
					if( mapRuleTypeIdx.size() <= 0 ) {
						indexByRuleTypeIdx.remove( keyRuleTypeIdx );
					}
				}
			}

			if( indexByToolSetIdx != null ) {
				CFGenKbGenItemByToolSetIdxKey keyToolSetIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
				keyToolSetIdx.setRequiredToolSetId( keepObj.getRequiredToolSetId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapToolSetIdx = indexByToolSetIdx.get( keyToolSetIdx );
				if( mapToolSetIdx != null ) {
					mapToolSetIdx.remove( keepObj.getPKey() );
					if( mapToolSetIdx.size() <= 0 ) {
						indexByToolSetIdx.remove( keyToolSetIdx );
					}
				}
			}

			if( indexByScopeIdx != null ) {
				CFGenKbGenItemByScopeIdxKey keyScopeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
				keyScopeIdx.setOptionalScopeDefId( keepObj.getOptionalScopeDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.remove( keepObj.getPKey() );
					if( mapScopeIdx.size() <= 0 ) {
						indexByScopeIdx.remove( keyScopeIdx );
					}
				}
			}

			if( indexByGenDefIdx != null ) {
				CFGenKbGenItemByGenDefIdxKey keyGenDefIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
				keyGenDefIdx.setRequiredGenDefId( keepObj.getRequiredGenDefId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapGenDefIdx = indexByGenDefIdx.get( keyGenDefIdx );
				if( mapGenDefIdx != null ) {
					mapGenDefIdx.remove( keepObj.getPKey() );
					if( mapGenDefIdx.size() <= 0 ) {
						indexByGenDefIdx.remove( keyGenDefIdx );
					}
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
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapGelExecIdx = indexByGelExecIdx.get( keyGelExecIdx );
				if( mapGelExecIdx != null ) {
					mapGelExecIdx.remove( keepObj.getPKey() );
					if( mapGelExecIdx.size() <= 0 ) {
						indexByGelExecIdx.remove( keyGelExecIdx );
					}
				}
			}

			if( indexByProbeIdx != null ) {
				CFGenKbGenItemByProbeIdxKey keyProbeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newProbeIdxKey();
				keyProbeIdx.setOptionalProbeTenantId( keepObj.getOptionalProbeTenantId() );
				keyProbeIdx.setOptionalProbeCartridgeId( keepObj.getOptionalProbeCartridgeId() );
				keyProbeIdx.setOptionalProbeGenItemId( keepObj.getOptionalProbeGenItemId() );
				Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapProbeIdx = indexByProbeIdx.get( keyProbeIdx );
				if( mapProbeIdx != null ) {
					mapProbeIdx.remove( keepObj.getPKey() );
					if( mapProbeIdx.size() <= 0 ) {
						indexByProbeIdx.remove( keyProbeIdx );
					}
				}
			}

			if( allGenItem != null ) {
				allGenItem.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFGenKbSchemaObj)schema).getGelExecutableTableObj().forgetGelExecutableByPIdx( keepObj.getOptionalGelExecutableTenantId(),
					keepObj.getOptionalGelExecutableGelCacheId(),
					keepObj.getOptionalGelExecutableId() );
			}
		}
	}

	public void forgetGenItemByItemIdIdx( long TenantId,
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
			ICFGenKbGenItemObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetGenItemByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFGenKbGenItemObj> toForget = new LinkedList<ICFGenKbGenItemObj>();
		ICFGenKbGenItemObj cur = null;
		CFGenKbGenItemByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFGenKbGenItemObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenItemObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenItemObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenItemByCartIdx( long TenantId,
		long CartridgeId )
	{
		if( indexByCartIdx == null ) {
			return;
		}
		List<ICFGenKbGenItemObj> toForget = new LinkedList<ICFGenKbGenItemObj>();
		ICFGenKbGenItemObj cur = null;
		CFGenKbGenItemByCartIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCartridgeId( CartridgeId );
		if( indexByCartIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapCartIdx = indexByCartIdx.get( key );
			if( mapCartIdx != null ) {
				Iterator<ICFGenKbGenItemObj> iterDup = mapCartIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByCartIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenItemObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenItemObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenItemByRuleTypeIdx( short RuleTypeId )
	{
		if( indexByRuleTypeIdx == null ) {
			return;
		}
		List<ICFGenKbGenItemObj> toForget = new LinkedList<ICFGenKbGenItemObj>();
		ICFGenKbGenItemObj cur = null;
		CFGenKbGenItemByRuleTypeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
		key.setRequiredRuleTypeId( RuleTypeId );
		if( indexByRuleTypeIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapRuleTypeIdx = indexByRuleTypeIdx.get( key );
			if( mapRuleTypeIdx != null ) {
				Iterator<ICFGenKbGenItemObj> iterDup = mapRuleTypeIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRuleTypeIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenItemObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenItemObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenItemByToolSetIdx( short ToolSetId )
	{
		if( indexByToolSetIdx == null ) {
			return;
		}
		List<ICFGenKbGenItemObj> toForget = new LinkedList<ICFGenKbGenItemObj>();
		ICFGenKbGenItemObj cur = null;
		CFGenKbGenItemByToolSetIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
		key.setRequiredToolSetId( ToolSetId );
		if( indexByToolSetIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapToolSetIdx = indexByToolSetIdx.get( key );
			if( mapToolSetIdx != null ) {
				Iterator<ICFGenKbGenItemObj> iterDup = mapToolSetIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByToolSetIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenItemObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenItemObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenItemByScopeIdx( Short ScopeDefId )
	{
		if( indexByScopeIdx == null ) {
			return;
		}
		List<ICFGenKbGenItemObj> toForget = new LinkedList<ICFGenKbGenItemObj>();
		ICFGenKbGenItemObj cur = null;
		CFGenKbGenItemByScopeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
		key.setOptionalScopeDefId( ScopeDefId );
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapScopeIdx = indexByScopeIdx.get( key );
			if( mapScopeIdx != null ) {
				Iterator<ICFGenKbGenItemObj> iterDup = mapScopeIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByScopeIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenItemObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenItemObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenItemByGenDefIdx( short GenDefId )
	{
		if( indexByGenDefIdx == null ) {
			return;
		}
		List<ICFGenKbGenItemObj> toForget = new LinkedList<ICFGenKbGenItemObj>();
		ICFGenKbGenItemObj cur = null;
		CFGenKbGenItemByGenDefIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
		key.setRequiredGenDefId( GenDefId );
		if( indexByGenDefIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapGenDefIdx = indexByGenDefIdx.get( key );
			if( mapGenDefIdx != null ) {
				Iterator<ICFGenKbGenItemObj> iterDup = mapGenDefIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGenDefIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenItemObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenItemObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenItemByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId )
	{
		if( indexByAltIdx == null ) {
			return;
		}
		List<ICFGenKbGenItemObj> toForget = new LinkedList<ICFGenKbGenItemObj>();
		ICFGenKbGenItemObj cur = null;
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
		Iterator<ICFGenKbGenItemObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenItemByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId )
	{
		if( indexByGelExecIdx == null ) {
			return;
		}
		List<ICFGenKbGenItemObj> toForget = new LinkedList<ICFGenKbGenItemObj>();
		ICFGenKbGenItemObj cur = null;
		CFGenKbGenItemByGelExecIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGelExecIdxKey();
		key.setOptionalGelExecutableTenantId( GelExecutableTenantId );
		key.setOptionalGelExecutableGelCacheId( GelExecutableGelCacheId );
		key.setOptionalGelExecutableId( GelExecutableId );
		if( indexByGelExecIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapGelExecIdx = indexByGelExecIdx.get( key );
			if( mapGelExecIdx != null ) {
				Iterator<ICFGenKbGenItemObj> iterDup = mapGelExecIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGelExecIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenItemObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenItemObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGenItemByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId )
	{
		if( indexByProbeIdx == null ) {
			return;
		}
		List<ICFGenKbGenItemObj> toForget = new LinkedList<ICFGenKbGenItemObj>();
		ICFGenKbGenItemObj cur = null;
		CFGenKbGenItemByProbeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newProbeIdxKey();
		key.setOptionalProbeTenantId( ProbeTenantId );
		key.setOptionalProbeCartridgeId( ProbeCartridgeId );
		key.setOptionalProbeGenItemId( ProbeGenItemId );
		if( indexByProbeIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj > mapProbeIdx = indexByProbeIdx.get( key );
			if( mapProbeIdx != null ) {
				Iterator<ICFGenKbGenItemObj> iterDup = mapProbeIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByProbeIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGenItemObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGenItemObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbGenItemObj createGenItem( ICFGenKbGenItemObj Obj ) {
		ICFGenKbGenItemObj obj = Obj;
		CFGenKbGenItemBuff buff = obj.getGenItemBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().createGenItem(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "ITM" ) ) {
			obj = (ICFGenKbGenItemObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbGenItemObj readGenItem( CFGenKbGenItemPKey pkey ) {
		return( readGenItem( pkey, false ) );
	}

	public ICFGenKbGenItemObj readGenItem( CFGenKbGenItemPKey pkey, boolean forceRead ) {
		ICFGenKbGenItemObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbGenItemBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByItemIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredCartridgeId(),
				pkey.getRequiredItemId() );
			if( readBuff != null ) {
				obj = (ICFGenKbGenItemObj)schema.getGenItemTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbGenItemObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbGenItemObj lockGenItem( CFGenKbGenItemPKey pkey ) {
		ICFGenKbGenItemObj locked = null;
		CFGenKbGenItemBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFGenKbGenItemObj)schema.getGenItemTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbGenItemObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockGenItem", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbGenItemObj> readAllGenItem() {
		return( readAllGenItem( false ) );
	}

	public List<ICFGenKbGenItemObj> readAllGenItem( boolean forceRead ) {
		final String S_ProcName = "readAllGenItem";
		if( ( allGenItem == null ) || forceRead ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> map = new HashMap<CFGenKbGenItemPKey,ICFGenKbGenItemObj>();
			allGenItem = map;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readAllDerived( schema.getAuthorization() );
			CFGenKbGenItemBuff buff;
			ICFGenKbGenItemObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenItemObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenItemObj realised = (ICFGenKbGenItemObj)obj.realise();
			}
		}
		int len = allGenItem.size();
		ICFGenKbGenItemObj arr[] = new ICFGenKbGenItemObj[len];
		Iterator<ICFGenKbGenItemObj> valIter = allGenItem.values().iterator();
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
		ArrayList<ICFGenKbGenItemObj> arrayList = new ArrayList<ICFGenKbGenItemObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenItemObj> cmp = new Comparator<ICFGenKbGenItemObj>() {
			public int compare( ICFGenKbGenItemObj lhs, ICFGenKbGenItemObj rhs ) {
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
		List<ICFGenKbGenItemObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGenItemObj readGenItemByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId )
	{
		return( readGenItemByItemIdIdx( TenantId,
			CartridgeId,
			ItemId,
			false ) );
	}

	public ICFGenKbGenItemObj readGenItemByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId, boolean forceRead )
	{
		CFGenKbGenItemPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredCartridgeId( CartridgeId );
		pkey.setRequiredItemId( ItemId );
		ICFGenKbGenItemObj obj = readGenItem( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbGenItemObj> readGenItemByTenantIdx( long TenantId )
	{
		return( readGenItemByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFGenKbGenItemObj> readGenItemByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenItemByTenantIdx";
		CFGenKbGenItemByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGenItemByTenantIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenItemObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenItemObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenItemObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenItemObj realised = (ICFGenKbGenItemObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenItemObj arr[] = new ICFGenKbGenItemObj[len];
		Iterator<ICFGenKbGenItemObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenItemObj> arrayList = new ArrayList<ICFGenKbGenItemObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenItemObj> cmp = new Comparator<ICFGenKbGenItemObj>() {
			public int compare( ICFGenKbGenItemObj lhs, ICFGenKbGenItemObj rhs ) {
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
		List<ICFGenKbGenItemObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenItemObj> readGenItemByCartIdx( long TenantId,
		long CartridgeId )
	{
		return( readGenItemByCartIdx( TenantId,
			CartridgeId,
			false ) );
	}

	public List<ICFGenKbGenItemObj> readGenItemByCartIdx( long TenantId,
		long CartridgeId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenItemByCartIdx";
		CFGenKbGenItemByCartIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCartridgeId( CartridgeId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> dict;
		if( indexByCartIdx == null ) {
			indexByCartIdx = new HashMap< CFGenKbGenItemByCartIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenItemObj > >();
		}
		if( ( ! forceRead ) && indexByCartIdx.containsKey( key ) ) {
			dict = indexByCartIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenItemObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByCartIdx( schema.getAuthorization(),
				TenantId,
				CartridgeId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenItemObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenItemObj realised = (ICFGenKbGenItemObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByCartIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenItemObj arr[] = new ICFGenKbGenItemObj[len];
		Iterator<ICFGenKbGenItemObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenItemObj> arrayList = new ArrayList<ICFGenKbGenItemObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenItemObj> cmp = new Comparator<ICFGenKbGenItemObj>() {
			public int compare( ICFGenKbGenItemObj lhs, ICFGenKbGenItemObj rhs ) {
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
		List<ICFGenKbGenItemObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenItemObj> readGenItemByRuleTypeIdx( short RuleTypeId )
	{
		return( readGenItemByRuleTypeIdx( RuleTypeId,
			false ) );
	}

	public List<ICFGenKbGenItemObj> readGenItemByRuleTypeIdx( short RuleTypeId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenItemByRuleTypeIdx";
		CFGenKbGenItemByRuleTypeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
		key.setRequiredRuleTypeId( RuleTypeId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> dict;
		if( indexByRuleTypeIdx == null ) {
			indexByRuleTypeIdx = new HashMap< CFGenKbGenItemByRuleTypeIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenItemObj > >();
		}
		if( ( ! forceRead ) && indexByRuleTypeIdx.containsKey( key ) ) {
			dict = indexByRuleTypeIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenItemObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByRuleTypeIdx( schema.getAuthorization(),
				RuleTypeId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenItemObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenItemObj realised = (ICFGenKbGenItemObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRuleTypeIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenItemObj arr[] = new ICFGenKbGenItemObj[len];
		Iterator<ICFGenKbGenItemObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenItemObj> arrayList = new ArrayList<ICFGenKbGenItemObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenItemObj> cmp = new Comparator<ICFGenKbGenItemObj>() {
			public int compare( ICFGenKbGenItemObj lhs, ICFGenKbGenItemObj rhs ) {
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
		List<ICFGenKbGenItemObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenItemObj> readGenItemByToolSetIdx( short ToolSetId )
	{
		return( readGenItemByToolSetIdx( ToolSetId,
			false ) );
	}

	public List<ICFGenKbGenItemObj> readGenItemByToolSetIdx( short ToolSetId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenItemByToolSetIdx";
		CFGenKbGenItemByToolSetIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
		key.setRequiredToolSetId( ToolSetId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> dict;
		if( indexByToolSetIdx == null ) {
			indexByToolSetIdx = new HashMap< CFGenKbGenItemByToolSetIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenItemObj > >();
		}
		if( ( ! forceRead ) && indexByToolSetIdx.containsKey( key ) ) {
			dict = indexByToolSetIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenItemObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByToolSetIdx( schema.getAuthorization(),
				ToolSetId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenItemObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenItemObj realised = (ICFGenKbGenItemObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByToolSetIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenItemObj arr[] = new ICFGenKbGenItemObj[len];
		Iterator<ICFGenKbGenItemObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenItemObj> arrayList = new ArrayList<ICFGenKbGenItemObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenItemObj> cmp = new Comparator<ICFGenKbGenItemObj>() {
			public int compare( ICFGenKbGenItemObj lhs, ICFGenKbGenItemObj rhs ) {
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
		List<ICFGenKbGenItemObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenItemObj> readGenItemByScopeIdx( Short ScopeDefId )
	{
		return( readGenItemByScopeIdx( ScopeDefId,
			false ) );
	}

	public List<ICFGenKbGenItemObj> readGenItemByScopeIdx( Short ScopeDefId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenItemByScopeIdx";
		CFGenKbGenItemByScopeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
		key.setOptionalScopeDefId( ScopeDefId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFGenKbGenItemByScopeIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenItemObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenItemObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByScopeIdx( schema.getAuthorization(),
				ScopeDefId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenItemObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenItemObj realised = (ICFGenKbGenItemObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenItemObj arr[] = new ICFGenKbGenItemObj[len];
		Iterator<ICFGenKbGenItemObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenItemObj> arrayList = new ArrayList<ICFGenKbGenItemObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenItemObj> cmp = new Comparator<ICFGenKbGenItemObj>() {
			public int compare( ICFGenKbGenItemObj lhs, ICFGenKbGenItemObj rhs ) {
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
		List<ICFGenKbGenItemObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenItemObj> readGenItemByGenDefIdx( short GenDefId )
	{
		return( readGenItemByGenDefIdx( GenDefId,
			false ) );
	}

	public List<ICFGenKbGenItemObj> readGenItemByGenDefIdx( short GenDefId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenItemByGenDefIdx";
		CFGenKbGenItemByGenDefIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
		key.setRequiredGenDefId( GenDefId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> dict;
		if( indexByGenDefIdx == null ) {
			indexByGenDefIdx = new HashMap< CFGenKbGenItemByGenDefIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenItemObj > >();
		}
		if( ( ! forceRead ) && indexByGenDefIdx.containsKey( key ) ) {
			dict = indexByGenDefIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenItemObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByGenDefIdx( schema.getAuthorization(),
				GenDefId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenItemObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenItemObj realised = (ICFGenKbGenItemObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGenDefIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenItemObj arr[] = new ICFGenKbGenItemObj[len];
		Iterator<ICFGenKbGenItemObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenItemObj> arrayList = new ArrayList<ICFGenKbGenItemObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenItemObj> cmp = new Comparator<ICFGenKbGenItemObj>() {
			public int compare( ICFGenKbGenItemObj lhs, ICFGenKbGenItemObj rhs ) {
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
		List<ICFGenKbGenItemObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGenItemObj readGenItemByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId )
	{
		return( readGenItemByAltIdx( Name,
			ToolSetId,
			ScopeDefId,
			GenDefId,
			false ) );
	}

	public ICFGenKbGenItemObj readGenItemByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId, boolean forceRead )
	{
		if( indexByAltIdx == null ) {
			indexByAltIdx = new HashMap< CFGenKbGenItemByAltIdxKey,
				ICFGenKbGenItemObj >();
		}
		CFGenKbGenItemByAltIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newAltIdxKey();
		key.setRequiredName( Name );
		key.setRequiredToolSetId( ToolSetId );
		key.setOptionalScopeDefId( ScopeDefId );
		key.setRequiredGenDefId( GenDefId );
		ICFGenKbGenItemObj obj = null;
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
				obj = (ICFGenKbGenItemObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				obj = (ICFGenKbGenItemObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFGenKbGenItemObj> readGenItemByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId )
	{
		return( readGenItemByGelExecIdx( GelExecutableTenantId,
			GelExecutableGelCacheId,
			GelExecutableId,
			false ) );
	}

	public List<ICFGenKbGenItemObj> readGenItemByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenItemByGelExecIdx";
		CFGenKbGenItemByGelExecIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGelExecIdxKey();
		key.setOptionalGelExecutableTenantId( GelExecutableTenantId );
		key.setOptionalGelExecutableGelCacheId( GelExecutableGelCacheId );
		key.setOptionalGelExecutableId( GelExecutableId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> dict;
		if( indexByGelExecIdx == null ) {
			indexByGelExecIdx = new HashMap< CFGenKbGenItemByGelExecIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenItemObj > >();
		}
		if( ( ! forceRead ) && indexByGelExecIdx.containsKey( key ) ) {
			dict = indexByGelExecIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenItemObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByGelExecIdx( schema.getAuthorization(),
				GelExecutableTenantId,
				GelExecutableGelCacheId,
				GelExecutableId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenItemObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenItemObj realised = (ICFGenKbGenItemObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGelExecIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenItemObj arr[] = new ICFGenKbGenItemObj[len];
		Iterator<ICFGenKbGenItemObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenItemObj> arrayList = new ArrayList<ICFGenKbGenItemObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenItemObj> cmp = new Comparator<ICFGenKbGenItemObj>() {
			public int compare( ICFGenKbGenItemObj lhs, ICFGenKbGenItemObj rhs ) {
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
		List<ICFGenKbGenItemObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGenItemObj> readGenItemByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId )
	{
		return( readGenItemByProbeIdx( ProbeTenantId,
			ProbeCartridgeId,
			ProbeGenItemId,
			false ) );
	}

	public List<ICFGenKbGenItemObj> readGenItemByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId,
		boolean forceRead )
	{
		final String S_ProcName = "readGenItemByProbeIdx";
		CFGenKbGenItemByProbeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newProbeIdxKey();
		key.setOptionalProbeTenantId( ProbeTenantId );
		key.setOptionalProbeCartridgeId( ProbeCartridgeId );
		key.setOptionalProbeGenItemId( ProbeGenItemId );
		Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> dict;
		if( indexByProbeIdx == null ) {
			indexByProbeIdx = new HashMap< CFGenKbGenItemByProbeIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenItemObj > >();
		}
		if( ( ! forceRead ) && indexByProbeIdx.containsKey( key ) ) {
			dict = indexByProbeIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGenItemPKey, ICFGenKbGenItemObj>();
			ICFGenKbGenItemObj obj;
			CFGenKbGenItemBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByProbeIdx( schema.getAuthorization(),
				ProbeTenantId,
				ProbeCartridgeId,
				ProbeGenItemId );
			CFGenKbGenItemBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGenItemObj)schema.getGenItemTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGenItemObj realised = (ICFGenKbGenItemObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByProbeIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGenItemObj arr[] = new ICFGenKbGenItemObj[len];
		Iterator<ICFGenKbGenItemObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGenItemObj> arrayList = new ArrayList<ICFGenKbGenItemObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGenItemObj> cmp = new Comparator<ICFGenKbGenItemObj>() {
			public int compare( ICFGenKbGenItemObj lhs, ICFGenKbGenItemObj rhs ) {
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
		List<ICFGenKbGenItemObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGenItemObj updateGenItem( ICFGenKbGenItemObj Obj ) {
		ICFGenKbGenItemObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().updateGenItem( schema.getAuthorization(),
			Obj.getGenItemBuff() );
		if( Obj.getClassCode().equals( "ITM" ) ) {
			obj = (ICFGenKbGenItemObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteGenItem( ICFGenKbGenItemObj Obj ) {
		ICFGenKbGenItemObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItem( schema.getAuthorization(),
			obj.getGenItemBuff() );
		obj.forget( true );
	}

	public void deleteGenItemByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId )
	{
		CFGenKbGenItemPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredCartridgeId( CartridgeId );
		pkey.setRequiredItemId( ItemId );
		ICFGenKbGenItemObj obj = readGenItem( pkey );
		if( obj != null ) {
			ICFGenKbGenItemEditObj editObj = (ICFGenKbGenItemEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbGenItemEditObj)obj.beginEdit();
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

	public void deleteGenItemByTenantIdx( long TenantId )
	{
		CFGenKbGenItemByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGenItemByTenantIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenItemObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> dict = indexByTenantIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItemByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFGenKbGenItemObj> iter = dict.values().iterator();
			ICFGenKbGenItemObj obj;
			List<ICFGenKbGenItemObj> toForget = new LinkedList<ICFGenKbGenItemObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItemByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteGenItemByCartIdx( long TenantId,
		long CartridgeId )
	{
		CFGenKbGenItemByCartIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newCartIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredCartridgeId( CartridgeId );
		if( indexByCartIdx == null ) {
			indexByCartIdx = new HashMap< CFGenKbGenItemByCartIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenItemObj > >();
		}
		if( indexByCartIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> dict = indexByCartIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItemByCartIdx( schema.getAuthorization(),
				TenantId,
				CartridgeId );
			Iterator<ICFGenKbGenItemObj> iter = dict.values().iterator();
			ICFGenKbGenItemObj obj;
			List<ICFGenKbGenItemObj> toForget = new LinkedList<ICFGenKbGenItemObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItemByCartIdx( schema.getAuthorization(),
				TenantId,
				CartridgeId );
		}
	}

	public void deleteGenItemByRuleTypeIdx( short RuleTypeId )
	{
		CFGenKbGenItemByRuleTypeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newRuleTypeIdxKey();
		key.setRequiredRuleTypeId( RuleTypeId );
		if( indexByRuleTypeIdx == null ) {
			indexByRuleTypeIdx = new HashMap< CFGenKbGenItemByRuleTypeIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenItemObj > >();
		}
		if( indexByRuleTypeIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> dict = indexByRuleTypeIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItemByRuleTypeIdx( schema.getAuthorization(),
				RuleTypeId );
			Iterator<ICFGenKbGenItemObj> iter = dict.values().iterator();
			ICFGenKbGenItemObj obj;
			List<ICFGenKbGenItemObj> toForget = new LinkedList<ICFGenKbGenItemObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItemByRuleTypeIdx( schema.getAuthorization(),
				RuleTypeId );
		}
	}

	public void deleteGenItemByToolSetIdx( short ToolSetId )
	{
		CFGenKbGenItemByToolSetIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newToolSetIdxKey();
		key.setRequiredToolSetId( ToolSetId );
		if( indexByToolSetIdx == null ) {
			indexByToolSetIdx = new HashMap< CFGenKbGenItemByToolSetIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenItemObj > >();
		}
		if( indexByToolSetIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> dict = indexByToolSetIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItemByToolSetIdx( schema.getAuthorization(),
				ToolSetId );
			Iterator<ICFGenKbGenItemObj> iter = dict.values().iterator();
			ICFGenKbGenItemObj obj;
			List<ICFGenKbGenItemObj> toForget = new LinkedList<ICFGenKbGenItemObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItemByToolSetIdx( schema.getAuthorization(),
				ToolSetId );
		}
	}

	public void deleteGenItemByScopeIdx( Short ScopeDefId )
	{
		CFGenKbGenItemByScopeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newScopeIdxKey();
		key.setOptionalScopeDefId( ScopeDefId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFGenKbGenItemByScopeIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenItemObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> dict = indexByScopeIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItemByScopeIdx( schema.getAuthorization(),
				ScopeDefId );
			Iterator<ICFGenKbGenItemObj> iter = dict.values().iterator();
			ICFGenKbGenItemObj obj;
			List<ICFGenKbGenItemObj> toForget = new LinkedList<ICFGenKbGenItemObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItemByScopeIdx( schema.getAuthorization(),
				ScopeDefId );
		}
	}

	public void deleteGenItemByGenDefIdx( short GenDefId )
	{
		CFGenKbGenItemByGenDefIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGenDefIdxKey();
		key.setRequiredGenDefId( GenDefId );
		if( indexByGenDefIdx == null ) {
			indexByGenDefIdx = new HashMap< CFGenKbGenItemByGenDefIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenItemObj > >();
		}
		if( indexByGenDefIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> dict = indexByGenDefIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItemByGenDefIdx( schema.getAuthorization(),
				GenDefId );
			Iterator<ICFGenKbGenItemObj> iter = dict.values().iterator();
			ICFGenKbGenItemObj obj;
			List<ICFGenKbGenItemObj> toForget = new LinkedList<ICFGenKbGenItemObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItemByGenDefIdx( schema.getAuthorization(),
				GenDefId );
		}
	}

	public void deleteGenItemByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId )
	{
		if( indexByAltIdx == null ) {
			indexByAltIdx = new HashMap< CFGenKbGenItemByAltIdxKey,
				ICFGenKbGenItemObj >();
		}
		CFGenKbGenItemByAltIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newAltIdxKey();
		key.setRequiredName( Name );
		key.setRequiredToolSetId( ToolSetId );
		key.setOptionalScopeDefId( ScopeDefId );
		key.setRequiredGenDefId( GenDefId );
		ICFGenKbGenItemObj obj = null;
		if( indexByAltIdx.containsKey( key ) ) {
			obj = indexByAltIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItemByAltIdx( schema.getAuthorization(),
				Name,
				ToolSetId,
				ScopeDefId,
				GenDefId );
			obj.forget( true );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItemByAltIdx( schema.getAuthorization(),
				Name,
				ToolSetId,
				ScopeDefId,
				GenDefId );
		}
	}

	public void deleteGenItemByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId )
	{
		CFGenKbGenItemByGelExecIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newGelExecIdxKey();
		key.setOptionalGelExecutableTenantId( GelExecutableTenantId );
		key.setOptionalGelExecutableGelCacheId( GelExecutableGelCacheId );
		key.setOptionalGelExecutableId( GelExecutableId );
		if( indexByGelExecIdx == null ) {
			indexByGelExecIdx = new HashMap< CFGenKbGenItemByGelExecIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenItemObj > >();
		}
		if( indexByGelExecIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> dict = indexByGelExecIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItemByGelExecIdx( schema.getAuthorization(),
				GelExecutableTenantId,
				GelExecutableGelCacheId,
				GelExecutableId );
			Iterator<ICFGenKbGenItemObj> iter = dict.values().iterator();
			ICFGenKbGenItemObj obj;
			List<ICFGenKbGenItemObj> toForget = new LinkedList<ICFGenKbGenItemObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItemByGelExecIdx( schema.getAuthorization(),
				GelExecutableTenantId,
				GelExecutableGelCacheId,
				GelExecutableId );
		}
	}

	public void deleteGenItemByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId )
	{
		CFGenKbGenItemByProbeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newProbeIdxKey();
		key.setOptionalProbeTenantId( ProbeTenantId );
		key.setOptionalProbeCartridgeId( ProbeCartridgeId );
		key.setOptionalProbeGenItemId( ProbeGenItemId );
		if( indexByProbeIdx == null ) {
			indexByProbeIdx = new HashMap< CFGenKbGenItemByProbeIdxKey,
				Map< CFGenKbGenItemPKey, ICFGenKbGenItemObj > >();
		}
		if( indexByProbeIdx.containsKey( key ) ) {
			Map<CFGenKbGenItemPKey, ICFGenKbGenItemObj> dict = indexByProbeIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItemByProbeIdx( schema.getAuthorization(),
				ProbeTenantId,
				ProbeCartridgeId,
				ProbeGenItemId );
			Iterator<ICFGenKbGenItemObj> iter = dict.values().iterator();
			ICFGenKbGenItemObj obj;
			List<ICFGenKbGenItemObj> toForget = new LinkedList<ICFGenKbGenItemObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().deleteGenItemByProbeIdx( schema.getAuthorization(),
				ProbeTenantId,
				ProbeCartridgeId,
				ProbeGenItemId );
		}
	}
}
