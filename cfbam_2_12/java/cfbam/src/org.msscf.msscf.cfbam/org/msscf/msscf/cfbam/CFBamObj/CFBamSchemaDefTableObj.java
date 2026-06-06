// Description: Java 11 Table Object implementation for CFBam.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamSchemaDefTableObj
	implements ICFBamSchemaDefTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamSchemaDefObj> members;
	private Map<CFBamScopePKey, ICFBamSchemaDefObj> allSchemaDef;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaDefObj > > indexByTenantIdx;
	private Map< CFBamSchemaDefByCTenantIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaDefObj > > indexByCTenantIdx;
	private Map< CFBamSchemaDefByMinorVersionIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaDefObj > > indexByMinorVersionIdx;
	private Map< CFBamSchemaDefByUNameIdxKey,
		ICFBamSchemaDefObj > indexByUNameIdx;
	private Map< CFBamSchemaDefByDefLcnIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaDefObj > > indexByDefLcnIdx;
	private Map< CFBamSchemaDefByAuthEMailIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaDefObj > > indexByAuthEMailIdx;
	private Map< CFBamSchemaDefByProjectURLIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaDefObj > > indexByProjectURLIdx;
	private Map< CFBamSchemaDefByPubURIIdxKey,
		ICFBamSchemaDefObj > indexByPubURIIdx;
	public static String TABLE_NAME = "SchemaDef";
	public static String TABLE_DBNAME = "schemadef";

	public CFBamSchemaDefTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
		allSchemaDef = null;
		indexByTenantIdx = null;
		indexByCTenantIdx = null;
		indexByMinorVersionIdx = null;
		indexByUNameIdx = null;
		indexByDefLcnIdx = null;
		indexByAuthEMailIdx = null;
		indexByProjectURLIdx = null;
		indexByPubURIIdx = null;
	}

	public CFBamSchemaDefTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
		allSchemaDef = null;
		indexByTenantIdx = null;
		indexByCTenantIdx = null;
		indexByMinorVersionIdx = null;
		indexByUNameIdx = null;
		indexByDefLcnIdx = null;
		indexByAuthEMailIdx = null;
		indexByProjectURLIdx = null;
		indexByPubURIIdx = null;
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
		return( ICFBamSubProjectObj.class );
	}


	public void minimizeMemory() {
		allSchemaDef = null;
		indexByTenantIdx = null;
		indexByCTenantIdx = null;
		indexByMinorVersionIdx = null;
		indexByUNameIdx = null;
		indexByDefLcnIdx = null;
		indexByAuthEMailIdx = null;
		indexByProjectURLIdx = null;
		indexByPubURIIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSchemaDefObj.
	 */
	public ICFBamSchemaDefObj newInstance() {
		ICFBamSchemaDefObj inst = new CFBamSchemaDefObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSchemaDefObj.
	 */
	public ICFBamSchemaDefEditObj newEditInstance( ICFBamSchemaDefObj orig ) {
		ICFBamSchemaDefEditObj edit = new CFBamSchemaDefEditObj( orig );
		return( edit );
	}

	public ICFBamSchemaDefObj realiseSchemaDef( ICFBamSchemaDefObj Obj ) {
		ICFBamSchemaDefObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamSchemaDefObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamSchemaDefObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByCTenantIdx != null ) {
				CFBamSchemaDefByCTenantIdxKey keyCTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newCTenantIdxKey();
				keyCTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapCTenantIdx = indexByCTenantIdx.get( keyCTenantIdx );
				if( mapCTenantIdx != null ) {
					mapCTenantIdx.remove( keepObj.getPKey() );
					if( mapCTenantIdx.size() <= 0 ) {
						indexByCTenantIdx.remove( keyCTenantIdx );
					}
				}
			}

			if( indexByMinorVersionIdx != null ) {
				CFBamSchemaDefByMinorVersionIdxKey keyMinorVersionIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newMinorVersionIdxKey();
				keyMinorVersionIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyMinorVersionIdx.setRequiredMinorVersionId( keepObj.getRequiredMinorVersionId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapMinorVersionIdx = indexByMinorVersionIdx.get( keyMinorVersionIdx );
				if( mapMinorVersionIdx != null ) {
					mapMinorVersionIdx.remove( keepObj.getPKey() );
					if( mapMinorVersionIdx.size() <= 0 ) {
						indexByMinorVersionIdx.remove( keyMinorVersionIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSchemaDefByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredMinorVersionId( keepObj.getRequiredMinorVersionId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByDefLcnIdx != null ) {
				CFBamSchemaDefByDefLcnIdxKey keyDefLcnIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newDefLcnIdxKey();
				keyDefLcnIdx.setOptionalDefaultLicenseTenantId( keepObj.getOptionalDefaultLicenseTenantId() );
				keyDefLcnIdx.setOptionalDefaultLicenseId( keepObj.getOptionalDefaultLicenseId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDefLcnIdx = indexByDefLcnIdx.get( keyDefLcnIdx );
				if( mapDefLcnIdx != null ) {
					mapDefLcnIdx.remove( keepObj.getPKey() );
					if( mapDefLcnIdx.size() <= 0 ) {
						indexByDefLcnIdx.remove( keyDefLcnIdx );
					}
				}
			}

			if( indexByAuthEMailIdx != null ) {
				CFBamSchemaDefByAuthEMailIdxKey keyAuthEMailIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newAuthEMailIdxKey();
				keyAuthEMailIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyAuthEMailIdx.setRequiredAuthorEMail( keepObj.getRequiredAuthorEMail() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapAuthEMailIdx = indexByAuthEMailIdx.get( keyAuthEMailIdx );
				if( mapAuthEMailIdx != null ) {
					mapAuthEMailIdx.remove( keepObj.getPKey() );
					if( mapAuthEMailIdx.size() <= 0 ) {
						indexByAuthEMailIdx.remove( keyAuthEMailIdx );
					}
				}
			}

			if( indexByProjectURLIdx != null ) {
				CFBamSchemaDefByProjectURLIdxKey keyProjectURLIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newProjectURLIdxKey();
				keyProjectURLIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyProjectURLIdx.setRequiredProjectURL( keepObj.getRequiredProjectURL() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapProjectURLIdx = indexByProjectURLIdx.get( keyProjectURLIdx );
				if( mapProjectURLIdx != null ) {
					mapProjectURLIdx.remove( keepObj.getPKey() );
					if( mapProjectURLIdx.size() <= 0 ) {
						indexByProjectURLIdx.remove( keyProjectURLIdx );
					}
				}
			}

			if( indexByPubURIIdx != null ) {
				CFBamSchemaDefByPubURIIdxKey keyPubURIIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newPubURIIdxKey();
				keyPubURIIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyPubURIIdx.setRequiredPublishURI( keepObj.getRequiredPublishURI() );
				indexByPubURIIdx.remove( keyPubURIIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamSchemaDefObj)schema.getScopeTableObj().realiseScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCTenantIdx != null ) {
				CFBamSchemaDefByCTenantIdxKey keyCTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newCTenantIdxKey();
				keyCTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapCTenantIdx = indexByCTenantIdx.get( keyCTenantIdx );
				if( mapCTenantIdx != null ) {
					mapCTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMinorVersionIdx != null ) {
				CFBamSchemaDefByMinorVersionIdxKey keyMinorVersionIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newMinorVersionIdxKey();
				keyMinorVersionIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyMinorVersionIdx.setRequiredMinorVersionId( keepObj.getRequiredMinorVersionId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapMinorVersionIdx = indexByMinorVersionIdx.get( keyMinorVersionIdx );
				if( mapMinorVersionIdx != null ) {
					mapMinorVersionIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSchemaDefByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredMinorVersionId( keepObj.getRequiredMinorVersionId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByDefLcnIdx != null ) {
				CFBamSchemaDefByDefLcnIdxKey keyDefLcnIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newDefLcnIdxKey();
				keyDefLcnIdx.setOptionalDefaultLicenseTenantId( keepObj.getOptionalDefaultLicenseTenantId() );
				keyDefLcnIdx.setOptionalDefaultLicenseId( keepObj.getOptionalDefaultLicenseId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDefLcnIdx = indexByDefLcnIdx.get( keyDefLcnIdx );
				if( mapDefLcnIdx != null ) {
					mapDefLcnIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByAuthEMailIdx != null ) {
				CFBamSchemaDefByAuthEMailIdxKey keyAuthEMailIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newAuthEMailIdxKey();
				keyAuthEMailIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyAuthEMailIdx.setRequiredAuthorEMail( keepObj.getRequiredAuthorEMail() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapAuthEMailIdx = indexByAuthEMailIdx.get( keyAuthEMailIdx );
				if( mapAuthEMailIdx != null ) {
					mapAuthEMailIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByProjectURLIdx != null ) {
				CFBamSchemaDefByProjectURLIdxKey keyProjectURLIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newProjectURLIdxKey();
				keyProjectURLIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyProjectURLIdx.setRequiredProjectURL( keepObj.getRequiredProjectURL() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapProjectURLIdx = indexByProjectURLIdx.get( keyProjectURLIdx );
				if( mapProjectURLIdx != null ) {
					mapProjectURLIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPubURIIdx != null ) {
				CFBamSchemaDefByPubURIIdxKey keyPubURIIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newPubURIIdxKey();
				keyPubURIIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyPubURIIdx.setRequiredPublishURI( keepObj.getRequiredPublishURI() );
				indexByPubURIIdx.put( keyPubURIIdx, keepObj );
			}

			if( allSchemaDef != null ) {
				allSchemaDef.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamSchemaDefObj)schema.getScopeTableObj().realiseScope( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSchemaDef != null ) {
				allSchemaDef.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCTenantIdx != null ) {
				CFBamSchemaDefByCTenantIdxKey keyCTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newCTenantIdxKey();
				keyCTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapCTenantIdx = indexByCTenantIdx.get( keyCTenantIdx );
				if( mapCTenantIdx != null ) {
					mapCTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMinorVersionIdx != null ) {
				CFBamSchemaDefByMinorVersionIdxKey keyMinorVersionIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newMinorVersionIdxKey();
				keyMinorVersionIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyMinorVersionIdx.setRequiredMinorVersionId( keepObj.getRequiredMinorVersionId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapMinorVersionIdx = indexByMinorVersionIdx.get( keyMinorVersionIdx );
				if( mapMinorVersionIdx != null ) {
					mapMinorVersionIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSchemaDefByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredMinorVersionId( keepObj.getRequiredMinorVersionId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByDefLcnIdx != null ) {
				CFBamSchemaDefByDefLcnIdxKey keyDefLcnIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newDefLcnIdxKey();
				keyDefLcnIdx.setOptionalDefaultLicenseTenantId( keepObj.getOptionalDefaultLicenseTenantId() );
				keyDefLcnIdx.setOptionalDefaultLicenseId( keepObj.getOptionalDefaultLicenseId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDefLcnIdx = indexByDefLcnIdx.get( keyDefLcnIdx );
				if( mapDefLcnIdx != null ) {
					mapDefLcnIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByAuthEMailIdx != null ) {
				CFBamSchemaDefByAuthEMailIdxKey keyAuthEMailIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newAuthEMailIdxKey();
				keyAuthEMailIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyAuthEMailIdx.setRequiredAuthorEMail( keepObj.getRequiredAuthorEMail() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapAuthEMailIdx = indexByAuthEMailIdx.get( keyAuthEMailIdx );
				if( mapAuthEMailIdx != null ) {
					mapAuthEMailIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByProjectURLIdx != null ) {
				CFBamSchemaDefByProjectURLIdxKey keyProjectURLIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newProjectURLIdxKey();
				keyProjectURLIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyProjectURLIdx.setRequiredProjectURL( keepObj.getRequiredProjectURL() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapProjectURLIdx = indexByProjectURLIdx.get( keyProjectURLIdx );
				if( mapProjectURLIdx != null ) {
					mapProjectURLIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPubURIIdx != null ) {
				CFBamSchemaDefByPubURIIdxKey keyPubURIIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newPubURIIdxKey();
				keyPubURIIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyPubURIIdx.setRequiredPublishURI( keepObj.getRequiredPublishURI() );
				indexByPubURIIdx.put( keyPubURIIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetSchemaDef( ICFBamSchemaDefObj Obj ) {
		forgetSchemaDef( Obj, false );
	}

	public void forgetSchemaDef( ICFBamSchemaDefObj Obj, boolean forgetSubObjects ) {
		ICFBamSchemaDefObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamSchemaDefObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByCTenantIdx != null ) {
				CFBamSchemaDefByCTenantIdxKey keyCTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newCTenantIdxKey();
				keyCTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapCTenantIdx = indexByCTenantIdx.get( keyCTenantIdx );
				if( mapCTenantIdx != null ) {
					mapCTenantIdx.remove( keepObj.getPKey() );
					if( mapCTenantIdx.size() <= 0 ) {
						indexByCTenantIdx.remove( keyCTenantIdx );
					}
				}
			}

			if( indexByMinorVersionIdx != null ) {
				CFBamSchemaDefByMinorVersionIdxKey keyMinorVersionIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newMinorVersionIdxKey();
				keyMinorVersionIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyMinorVersionIdx.setRequiredMinorVersionId( keepObj.getRequiredMinorVersionId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapMinorVersionIdx = indexByMinorVersionIdx.get( keyMinorVersionIdx );
				if( mapMinorVersionIdx != null ) {
					mapMinorVersionIdx.remove( keepObj.getPKey() );
					if( mapMinorVersionIdx.size() <= 0 ) {
						indexByMinorVersionIdx.remove( keyMinorVersionIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSchemaDefByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredMinorVersionId( keepObj.getRequiredMinorVersionId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByDefLcnIdx != null ) {
				CFBamSchemaDefByDefLcnIdxKey keyDefLcnIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newDefLcnIdxKey();
				keyDefLcnIdx.setOptionalDefaultLicenseTenantId( keepObj.getOptionalDefaultLicenseTenantId() );
				keyDefLcnIdx.setOptionalDefaultLicenseId( keepObj.getOptionalDefaultLicenseId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDefLcnIdx = indexByDefLcnIdx.get( keyDefLcnIdx );
				if( mapDefLcnIdx != null ) {
					mapDefLcnIdx.remove( keepObj.getPKey() );
					if( mapDefLcnIdx.size() <= 0 ) {
						indexByDefLcnIdx.remove( keyDefLcnIdx );
					}
				}
			}

			if( indexByAuthEMailIdx != null ) {
				CFBamSchemaDefByAuthEMailIdxKey keyAuthEMailIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newAuthEMailIdxKey();
				keyAuthEMailIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyAuthEMailIdx.setRequiredAuthorEMail( keepObj.getRequiredAuthorEMail() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapAuthEMailIdx = indexByAuthEMailIdx.get( keyAuthEMailIdx );
				if( mapAuthEMailIdx != null ) {
					mapAuthEMailIdx.remove( keepObj.getPKey() );
					if( mapAuthEMailIdx.size() <= 0 ) {
						indexByAuthEMailIdx.remove( keyAuthEMailIdx );
					}
				}
			}

			if( indexByProjectURLIdx != null ) {
				CFBamSchemaDefByProjectURLIdxKey keyProjectURLIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newProjectURLIdxKey();
				keyProjectURLIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyProjectURLIdx.setRequiredProjectURL( keepObj.getRequiredProjectURL() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapProjectURLIdx = indexByProjectURLIdx.get( keyProjectURLIdx );
				if( mapProjectURLIdx != null ) {
					mapProjectURLIdx.remove( keepObj.getPKey() );
					if( mapProjectURLIdx.size() <= 0 ) {
						indexByProjectURLIdx.remove( keyProjectURLIdx );
					}
				}
			}

			if( indexByPubURIIdx != null ) {
				CFBamSchemaDefByPubURIIdxKey keyPubURIIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newPubURIIdxKey();
				keyPubURIIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyPubURIIdx.setRequiredPublishURI( keepObj.getRequiredPublishURI() );
				indexByPubURIIdx.remove( keyPubURIIdx );
			}

			if( allSchemaDef != null ) {
				allSchemaDef.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFBamSchemaObj)schema).getTableTableObj().forgetTableBySchemaDefIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				((ICFBamSchemaObj)schema).getValueTableObj().forgetValueByScopeIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				((ICFBamSchemaObj)schema).getSchemaRefTableObj().forgetSchemaRefBySchemaIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		((ICFBamSchemaObj)schema).getScopeTableObj().forgetScope( obj );
	}

	public void forgetSchemaDefByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamSchemaDefObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSchemaDefByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
		ICFBamSchemaDefObj cur = null;
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamSchemaDefObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamSchemaDefObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamSchemaDefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSchemaDefByCTenantIdx( long TenantId )
	{
		if( indexByCTenantIdx == null ) {
			return;
		}
		List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
		ICFBamSchemaDefObj cur = null;
		CFBamSchemaDefByCTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newCTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByCTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj > mapCTenantIdx = indexByCTenantIdx.get( key );
			if( mapCTenantIdx != null ) {
				Iterator<ICFBamSchemaDefObj> iterDup = mapCTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByCTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamSchemaDefObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamSchemaDefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSchemaDefByMinorVersionIdx( long TenantId,
		long MinorVersionId )
	{
		if( indexByMinorVersionIdx == null ) {
			return;
		}
		List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
		ICFBamSchemaDefObj cur = null;
		CFBamSchemaDefByMinorVersionIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newMinorVersionIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredMinorVersionId( MinorVersionId );
		if( indexByMinorVersionIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj > mapMinorVersionIdx = indexByMinorVersionIdx.get( key );
			if( mapMinorVersionIdx != null ) {
				Iterator<ICFBamSchemaDefObj> iterDup = mapMinorVersionIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByMinorVersionIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamSchemaDefObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamSchemaDefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSchemaDefByUNameIdx( long TenantId,
		long MinorVersionId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
		ICFBamSchemaDefObj cur = null;
		CFBamSchemaDefByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredMinorVersionId( MinorVersionId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamSchemaDefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSchemaDefByDefLcnIdx( Long DefaultLicenseTenantId,
		Long DefaultLicenseId )
	{
		if( indexByDefLcnIdx == null ) {
			return;
		}
		List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
		ICFBamSchemaDefObj cur = null;
		CFBamSchemaDefByDefLcnIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newDefLcnIdxKey();
		key.setOptionalDefaultLicenseTenantId( DefaultLicenseTenantId );
		key.setOptionalDefaultLicenseId( DefaultLicenseId );
		if( indexByDefLcnIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDefLcnIdx = indexByDefLcnIdx.get( key );
			if( mapDefLcnIdx != null ) {
				Iterator<ICFBamSchemaDefObj> iterDup = mapDefLcnIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefLcnIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamSchemaDefObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamSchemaDefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSchemaDefByAuthEMailIdx( long TenantId,
		String AuthorEMail )
	{
		if( indexByAuthEMailIdx == null ) {
			return;
		}
		List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
		ICFBamSchemaDefObj cur = null;
		CFBamSchemaDefByAuthEMailIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newAuthEMailIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredAuthorEMail( AuthorEMail );
		if( indexByAuthEMailIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj > mapAuthEMailIdx = indexByAuthEMailIdx.get( key );
			if( mapAuthEMailIdx != null ) {
				Iterator<ICFBamSchemaDefObj> iterDup = mapAuthEMailIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByAuthEMailIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamSchemaDefObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamSchemaDefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSchemaDefByProjectURLIdx( long TenantId,
		String ProjectURL )
	{
		if( indexByProjectURLIdx == null ) {
			return;
		}
		List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
		ICFBamSchemaDefObj cur = null;
		CFBamSchemaDefByProjectURLIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newProjectURLIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredProjectURL( ProjectURL );
		if( indexByProjectURLIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj > mapProjectURLIdx = indexByProjectURLIdx.get( key );
			if( mapProjectURLIdx != null ) {
				Iterator<ICFBamSchemaDefObj> iterDup = mapProjectURLIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByProjectURLIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamSchemaDefObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamSchemaDefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSchemaDefByPubURIIdx( long TenantId,
		String PublishURI )
	{
		if( indexByPubURIIdx == null ) {
			return;
		}
		List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
		ICFBamSchemaDefObj cur = null;
		CFBamSchemaDefByPubURIIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newPubURIIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredPublishURI( PublishURI );
		if( indexByPubURIIdx.containsKey( key ) ) {
			cur = indexByPubURIIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamSchemaDefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamSchemaDefObj createSchemaDef( ICFBamSchemaDefObj Obj ) {
		ICFBamSchemaDefObj obj = Obj;
		CFBamSchemaDefBuff buff = obj.getSchemaDefBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().createSchemaDef(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "SCHM" ) ) {
			obj = (ICFBamSchemaDefObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamSchemaDefObj readSchemaDef( CFBamScopePKey pkey ) {
		return( readSchemaDef( pkey, false ) );
	}

	public ICFBamSchemaDefObj readSchemaDef( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamSchemaDefObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamSchemaDefBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamSchemaDefObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamSchemaDefObj lockSchemaDef( CFBamScopePKey pkey ) {
		ICFBamSchemaDefObj locked = null;
		CFBamSchemaDefBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamSchemaDefObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockSchemaDef", pkey );
		}
		return( locked );
	}

	public List<ICFBamSchemaDefObj> readAllSchemaDef() {
		return( readAllSchemaDef( false ) );
	}

	public List<ICFBamSchemaDefObj> readAllSchemaDef( boolean forceRead ) {
		final String S_ProcName = "readAllSchemaDef";
		if( ( allSchemaDef == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj> map = new HashMap<CFBamScopePKey,ICFBamSchemaDefObj>();
			allSchemaDef = map;
			CFBamSchemaDefBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().readAllDerived( schema.getAuthorization() );
			CFBamSchemaDefBuff buff;
			ICFBamSchemaDefObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaDefObj realised = (ICFBamSchemaDefObj)obj.realise();
			}
		}
		int len = allSchemaDef.size();
		ICFBamSchemaDefObj arr[] = new ICFBamSchemaDefObj[len];
		Iterator<ICFBamSchemaDefObj> valIter = allSchemaDef.values().iterator();
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
		ArrayList<ICFBamSchemaDefObj> arrayList = new ArrayList<ICFBamSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamSchemaDefObj> cmp = new Comparator<ICFBamSchemaDefObj>() {
			public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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
		List<ICFBamSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSchemaDefObj readSchemaDefByIdIdx( long TenantId,
		long Id )
	{
		return( readSchemaDefByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamSchemaDefObj readSchemaDefByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamSchemaDefObj obj = readSchemaDef( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByTenantIdx( long TenantId )
	{
		return( readSchemaDefByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByTenantIdx";
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamSchemaDefObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaDefObj realised = (ICFBamSchemaDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamSchemaDefObj arr[] = new ICFBamSchemaDefObj[len];
		Iterator<ICFBamSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaDefObj> arrayList = new ArrayList<ICFBamSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamSchemaDefObj> cmp = new Comparator<ICFBamSchemaDefObj>() {
			public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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
		List<ICFBamSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByCTenantIdx( long TenantId )
	{
		return( readSchemaDefByCTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByCTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByCTenantIdx";
		CFBamSchemaDefByCTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newCTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamSchemaDefObj> dict;
		if( indexByCTenantIdx == null ) {
			indexByCTenantIdx = new HashMap< CFBamSchemaDefByCTenantIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByCTenantIdx.containsKey( key ) ) {
			dict = indexByCTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
			ICFBamSchemaDefObj obj;
			CFBamSchemaDefBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().readDerivedByCTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamSchemaDefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaDefObj realised = (ICFBamSchemaDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByCTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamSchemaDefObj arr[] = new ICFBamSchemaDefObj[len];
		Iterator<ICFBamSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaDefObj> arrayList = new ArrayList<ICFBamSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamSchemaDefObj> cmp = new Comparator<ICFBamSchemaDefObj>() {
			public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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
		List<ICFBamSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByMinorVersionIdx( long TenantId,
		long MinorVersionId )
	{
		return( readSchemaDefByMinorVersionIdx( TenantId,
			MinorVersionId,
			false ) );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByMinorVersionIdx( long TenantId,
		long MinorVersionId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByMinorVersionIdx";
		CFBamSchemaDefByMinorVersionIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newMinorVersionIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredMinorVersionId( MinorVersionId );
		Map<CFBamScopePKey, ICFBamSchemaDefObj> dict;
		if( indexByMinorVersionIdx == null ) {
			indexByMinorVersionIdx = new HashMap< CFBamSchemaDefByMinorVersionIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByMinorVersionIdx.containsKey( key ) ) {
			dict = indexByMinorVersionIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
			ICFBamSchemaDefObj obj;
			CFBamSchemaDefBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().readDerivedByMinorVersionIdx( schema.getAuthorization(),
				TenantId,
				MinorVersionId );
			CFBamSchemaDefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaDefObj realised = (ICFBamSchemaDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByMinorVersionIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamSchemaDefObj arr[] = new ICFBamSchemaDefObj[len];
		Iterator<ICFBamSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaDefObj> arrayList = new ArrayList<ICFBamSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamSchemaDefObj> cmp = new Comparator<ICFBamSchemaDefObj>() {
			public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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
		List<ICFBamSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSchemaDefObj readSchemaDefByUNameIdx( long TenantId,
		long MinorVersionId,
		String Name )
	{
		return( readSchemaDefByUNameIdx( TenantId,
			MinorVersionId,
			Name,
			false ) );
	}

	public ICFBamSchemaDefObj readSchemaDefByUNameIdx( long TenantId,
		long MinorVersionId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamSchemaDefByUNameIdxKey,
				ICFBamSchemaDefObj >();
		}
		CFBamSchemaDefByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredMinorVersionId( MinorVersionId );
		key.setRequiredName( Name );
		ICFBamSchemaDefObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamSchemaDefBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				MinorVersionId,
				Name );
			if( buff != null ) {
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamSchemaDefObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByDefLcnIdx( Long DefaultLicenseTenantId,
		Long DefaultLicenseId )
	{
		return( readSchemaDefByDefLcnIdx( DefaultLicenseTenantId,
			DefaultLicenseId,
			false ) );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByDefLcnIdx( Long DefaultLicenseTenantId,
		Long DefaultLicenseId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByDefLcnIdx";
		CFBamSchemaDefByDefLcnIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newDefLcnIdxKey();
		key.setOptionalDefaultLicenseTenantId( DefaultLicenseTenantId );
		key.setOptionalDefaultLicenseId( DefaultLicenseId );
		Map<CFBamScopePKey, ICFBamSchemaDefObj> dict;
		if( indexByDefLcnIdx == null ) {
			indexByDefLcnIdx = new HashMap< CFBamSchemaDefByDefLcnIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByDefLcnIdx.containsKey( key ) ) {
			dict = indexByDefLcnIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
			ICFBamSchemaDefObj obj;
			CFBamSchemaDefBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().readDerivedByDefLcnIdx( schema.getAuthorization(),
				DefaultLicenseTenantId,
				DefaultLicenseId );
			CFBamSchemaDefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaDefObj realised = (ICFBamSchemaDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefLcnIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamSchemaDefObj arr[] = new ICFBamSchemaDefObj[len];
		Iterator<ICFBamSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaDefObj> arrayList = new ArrayList<ICFBamSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamSchemaDefObj> cmp = new Comparator<ICFBamSchemaDefObj>() {
			public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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
		List<ICFBamSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByAuthEMailIdx( long TenantId,
		String AuthorEMail )
	{
		return( readSchemaDefByAuthEMailIdx( TenantId,
			AuthorEMail,
			false ) );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByAuthEMailIdx( long TenantId,
		String AuthorEMail,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByAuthEMailIdx";
		CFBamSchemaDefByAuthEMailIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newAuthEMailIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredAuthorEMail( AuthorEMail );
		Map<CFBamScopePKey, ICFBamSchemaDefObj> dict;
		if( indexByAuthEMailIdx == null ) {
			indexByAuthEMailIdx = new HashMap< CFBamSchemaDefByAuthEMailIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByAuthEMailIdx.containsKey( key ) ) {
			dict = indexByAuthEMailIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
			ICFBamSchemaDefObj obj;
			CFBamSchemaDefBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().readDerivedByAuthEMailIdx( schema.getAuthorization(),
				TenantId,
				AuthorEMail );
			CFBamSchemaDefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaDefObj realised = (ICFBamSchemaDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByAuthEMailIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamSchemaDefObj arr[] = new ICFBamSchemaDefObj[len];
		Iterator<ICFBamSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaDefObj> arrayList = new ArrayList<ICFBamSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamSchemaDefObj> cmp = new Comparator<ICFBamSchemaDefObj>() {
			public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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
		List<ICFBamSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByProjectURLIdx( long TenantId,
		String ProjectURL )
	{
		return( readSchemaDefByProjectURLIdx( TenantId,
			ProjectURL,
			false ) );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByProjectURLIdx( long TenantId,
		String ProjectURL,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByProjectURLIdx";
		CFBamSchemaDefByProjectURLIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newProjectURLIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredProjectURL( ProjectURL );
		Map<CFBamScopePKey, ICFBamSchemaDefObj> dict;
		if( indexByProjectURLIdx == null ) {
			indexByProjectURLIdx = new HashMap< CFBamSchemaDefByProjectURLIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByProjectURLIdx.containsKey( key ) ) {
			dict = indexByProjectURLIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
			ICFBamSchemaDefObj obj;
			CFBamSchemaDefBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().readDerivedByProjectURLIdx( schema.getAuthorization(),
				TenantId,
				ProjectURL );
			CFBamSchemaDefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaDefObj realised = (ICFBamSchemaDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByProjectURLIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamSchemaDefObj arr[] = new ICFBamSchemaDefObj[len];
		Iterator<ICFBamSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaDefObj> arrayList = new ArrayList<ICFBamSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamSchemaDefObj> cmp = new Comparator<ICFBamSchemaDefObj>() {
			public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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
		List<ICFBamSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSchemaDefObj readSchemaDefByPubURIIdx( long TenantId,
		String PublishURI )
	{
		return( readSchemaDefByPubURIIdx( TenantId,
			PublishURI,
			false ) );
	}

	public ICFBamSchemaDefObj readSchemaDefByPubURIIdx( long TenantId,
		String PublishURI, boolean forceRead )
	{
		if( indexByPubURIIdx == null ) {
			indexByPubURIIdx = new HashMap< CFBamSchemaDefByPubURIIdxKey,
				ICFBamSchemaDefObj >();
		}
		CFBamSchemaDefByPubURIIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newPubURIIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredPublishURI( PublishURI );
		ICFBamSchemaDefObj obj = null;
		if( ( ! forceRead ) && indexByPubURIIdx.containsKey( key ) ) {
			obj = indexByPubURIIdx.get( key );
		}
		else {
			CFBamSchemaDefBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().readDerivedByPubURIIdx( schema.getAuthorization(),
				TenantId,
				PublishURI );
			if( buff != null ) {
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamSchemaDefObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamSchemaDefObj updateSchemaDef( ICFBamSchemaDefObj Obj ) {
		ICFBamSchemaDefObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().updateSchemaDef( schema.getAuthorization(),
			Obj.getSchemaDefBuff() );
		if( Obj.getClassCode().equals( "SCHM" ) ) {
			obj = (ICFBamSchemaDefObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteSchemaDef( ICFBamSchemaDefObj Obj ) {
		ICFBamSchemaDefObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().deleteSchemaDef( schema.getAuthorization(),
			obj.getSchemaDefBuff() );
		obj.forget( true );
	}

	public void deleteSchemaDefByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamSchemaDefObj obj = readSchemaDef( pkey );
		if( obj != null ) {
			ICFBamSchemaDefEditObj editObj = (ICFBamSchemaDefEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamSchemaDefEditObj)obj.beginEdit();
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

	public void deleteSchemaDefByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().deleteSchemaDefByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamSchemaDefObj> iter = dict.values().iterator();
			ICFBamSchemaDefObj obj;
			List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().deleteSchemaDefByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteSchemaDefByCTenantIdx( long TenantId )
	{
		CFBamSchemaDefByCTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newCTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByCTenantIdx == null ) {
			indexByCTenantIdx = new HashMap< CFBamSchemaDefByCTenantIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( indexByCTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj> dict = indexByCTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().deleteSchemaDefByCTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamSchemaDefObj> iter = dict.values().iterator();
			ICFBamSchemaDefObj obj;
			List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByCTenantIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().deleteSchemaDefByCTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteSchemaDefByMinorVersionIdx( long TenantId,
		long MinorVersionId )
	{
		CFBamSchemaDefByMinorVersionIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newMinorVersionIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredMinorVersionId( MinorVersionId );
		if( indexByMinorVersionIdx == null ) {
			indexByMinorVersionIdx = new HashMap< CFBamSchemaDefByMinorVersionIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( indexByMinorVersionIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj> dict = indexByMinorVersionIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().deleteSchemaDefByMinorVersionIdx( schema.getAuthorization(),
				TenantId,
				MinorVersionId );
			Iterator<ICFBamSchemaDefObj> iter = dict.values().iterator();
			ICFBamSchemaDefObj obj;
			List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByMinorVersionIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().deleteSchemaDefByMinorVersionIdx( schema.getAuthorization(),
				TenantId,
				MinorVersionId );
		}
	}

	public void deleteSchemaDefByUNameIdx( long TenantId,
		long MinorVersionId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamSchemaDefByUNameIdxKey,
				ICFBamSchemaDefObj >();
		}
		CFBamSchemaDefByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredMinorVersionId( MinorVersionId );
		key.setRequiredName( Name );
		ICFBamSchemaDefObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().deleteSchemaDefByUNameIdx( schema.getAuthorization(),
				TenantId,
				MinorVersionId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().deleteSchemaDefByUNameIdx( schema.getAuthorization(),
				TenantId,
				MinorVersionId,
				Name );
		}
	}

	public void deleteSchemaDefByDefLcnIdx( Long DefaultLicenseTenantId,
		Long DefaultLicenseId )
	{
		CFBamSchemaDefByDefLcnIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newDefLcnIdxKey();
		key.setOptionalDefaultLicenseTenantId( DefaultLicenseTenantId );
		key.setOptionalDefaultLicenseId( DefaultLicenseId );
		if( indexByDefLcnIdx == null ) {
			indexByDefLcnIdx = new HashMap< CFBamSchemaDefByDefLcnIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( indexByDefLcnIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj> dict = indexByDefLcnIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().deleteSchemaDefByDefLcnIdx( schema.getAuthorization(),
				DefaultLicenseTenantId,
				DefaultLicenseId );
			Iterator<ICFBamSchemaDefObj> iter = dict.values().iterator();
			ICFBamSchemaDefObj obj;
			List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByDefLcnIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().deleteSchemaDefByDefLcnIdx( schema.getAuthorization(),
				DefaultLicenseTenantId,
				DefaultLicenseId );
		}
	}

	public void deleteSchemaDefByAuthEMailIdx( long TenantId,
		String AuthorEMail )
	{
		CFBamSchemaDefByAuthEMailIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newAuthEMailIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredAuthorEMail( AuthorEMail );
		if( indexByAuthEMailIdx == null ) {
			indexByAuthEMailIdx = new HashMap< CFBamSchemaDefByAuthEMailIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( indexByAuthEMailIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj> dict = indexByAuthEMailIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().deleteSchemaDefByAuthEMailIdx( schema.getAuthorization(),
				TenantId,
				AuthorEMail );
			Iterator<ICFBamSchemaDefObj> iter = dict.values().iterator();
			ICFBamSchemaDefObj obj;
			List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByAuthEMailIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().deleteSchemaDefByAuthEMailIdx( schema.getAuthorization(),
				TenantId,
				AuthorEMail );
		}
	}

	public void deleteSchemaDefByProjectURLIdx( long TenantId,
		String ProjectURL )
	{
		CFBamSchemaDefByProjectURLIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newProjectURLIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredProjectURL( ProjectURL );
		if( indexByProjectURLIdx == null ) {
			indexByProjectURLIdx = new HashMap< CFBamSchemaDefByProjectURLIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( indexByProjectURLIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj> dict = indexByProjectURLIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().deleteSchemaDefByProjectURLIdx( schema.getAuthorization(),
				TenantId,
				ProjectURL );
			Iterator<ICFBamSchemaDefObj> iter = dict.values().iterator();
			ICFBamSchemaDefObj obj;
			List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByProjectURLIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().deleteSchemaDefByProjectURLIdx( schema.getAuthorization(),
				TenantId,
				ProjectURL );
		}
	}

	public void deleteSchemaDefByPubURIIdx( long TenantId,
		String PublishURI )
	{
		if( indexByPubURIIdx == null ) {
			indexByPubURIIdx = new HashMap< CFBamSchemaDefByPubURIIdxKey,
				ICFBamSchemaDefObj >();
		}
		CFBamSchemaDefByPubURIIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newPubURIIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredPublishURI( PublishURI );
		ICFBamSchemaDefObj obj = null;
		if( indexByPubURIIdx.containsKey( key ) ) {
			obj = indexByPubURIIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().deleteSchemaDefByPubURIIdx( schema.getAuthorization(),
				TenantId,
				PublishURI );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().deleteSchemaDefByPubURIIdx( schema.getAuthorization(),
				TenantId,
				PublishURI );
		}
	}
}
