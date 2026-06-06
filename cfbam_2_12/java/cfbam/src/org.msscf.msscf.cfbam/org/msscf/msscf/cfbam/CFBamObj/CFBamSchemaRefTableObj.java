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

public class CFBamSchemaRefTableObj
	implements ICFBamSchemaRefTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamSchemaRefObj> members;
	private Map<CFBamScopePKey, ICFBamSchemaRefObj> allSchemaRef;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaRefObj > > indexByTenantIdx;
	private Map< CFBamSchemaRefBySchemaIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaRefObj > > indexBySchemaIdx;
	private Map< CFBamSchemaRefByUNameIdxKey,
		ICFBamSchemaRefObj > indexByUNameIdx;
	private Map< CFBamSchemaRefByRefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaRefObj > > indexByRefSchemaIdx;
	private Map< CFBamSchemaRefByPrevIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaRefObj > > indexByPrevIdx;
	private Map< CFBamSchemaRefByNextIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaRefObj > > indexByNextIdx;
	public static String TABLE_NAME = "SchemaRef";
	public static String TABLE_DBNAME = "schema_ref";

	public CFBamSchemaRefTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamSchemaRefObj>();
		allSchemaRef = null;
		indexByTenantIdx = null;
		indexBySchemaIdx = null;
		indexByUNameIdx = null;
		indexByRefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
	}

	public CFBamSchemaRefTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamSchemaRefObj>();
		allSchemaRef = null;
		indexByTenantIdx = null;
		indexBySchemaIdx = null;
		indexByUNameIdx = null;
		indexByRefSchemaIdx = null;
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
		return( null );
	}


	public void minimizeMemory() {
		allSchemaRef = null;
		indexByTenantIdx = null;
		indexBySchemaIdx = null;
		indexByUNameIdx = null;
		indexByRefSchemaIdx = null;
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
	 *	CFBamSchemaRefObj.
	 */
	public ICFBamSchemaRefObj newInstance() {
		ICFBamSchemaRefObj inst = new CFBamSchemaRefObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSchemaRefObj.
	 */
	public ICFBamSchemaRefEditObj newEditInstance( ICFBamSchemaRefObj orig ) {
		ICFBamSchemaRefEditObj edit = new CFBamSchemaRefEditObj( orig );
		return( edit );
	}

	public ICFBamSchemaRefObj realiseSchemaRef( ICFBamSchemaRefObj Obj ) {
		ICFBamSchemaRefObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamSchemaRefObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamSchemaRefObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamSchemaRefBySchemaIdxKey keySchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.remove( keepObj.getPKey() );
					if( mapSchemaIdx.size() <= 0 ) {
						indexBySchemaIdx.remove( keySchemaIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSchemaRefByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByRefSchemaIdx != null ) {
				CFBamSchemaRefByRefSchemaIdxKey keyRefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newRefSchemaIdxKey();
				keyRefSchemaIdx.setOptionalRefSchemaTenantId( keepObj.getOptionalRefSchemaTenantId() );
				keyRefSchemaIdx.setOptionalRefSchemaId( keepObj.getOptionalRefSchemaId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapRefSchemaIdx = indexByRefSchemaIdx.get( keyRefSchemaIdx );
				if( mapRefSchemaIdx != null ) {
					mapRefSchemaIdx.remove( keepObj.getPKey() );
					if( mapRefSchemaIdx.size() <= 0 ) {
						indexByRefSchemaIdx.remove( keyRefSchemaIdx );
					}
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamSchemaRefByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				CFBamSchemaRefByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
			keepObj = (ICFBamSchemaRefObj)schema.getScopeTableObj().realiseScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamSchemaRefBySchemaIdxKey keySchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSchemaRefByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByRefSchemaIdx != null ) {
				CFBamSchemaRefByRefSchemaIdxKey keyRefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newRefSchemaIdxKey();
				keyRefSchemaIdx.setOptionalRefSchemaTenantId( keepObj.getOptionalRefSchemaTenantId() );
				keyRefSchemaIdx.setOptionalRefSchemaId( keepObj.getOptionalRefSchemaId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapRefSchemaIdx = indexByRefSchemaIdx.get( keyRefSchemaIdx );
				if( mapRefSchemaIdx != null ) {
					mapRefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamSchemaRefByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamSchemaRefByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSchemaRef != null ) {
				allSchemaRef.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamSchemaRefObj)schema.getScopeTableObj().realiseScope( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSchemaRef != null ) {
				allSchemaRef.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamSchemaRefBySchemaIdxKey keySchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSchemaRefByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByRefSchemaIdx != null ) {
				CFBamSchemaRefByRefSchemaIdxKey keyRefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newRefSchemaIdxKey();
				keyRefSchemaIdx.setOptionalRefSchemaTenantId( keepObj.getOptionalRefSchemaTenantId() );
				keyRefSchemaIdx.setOptionalRefSchemaId( keepObj.getOptionalRefSchemaId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapRefSchemaIdx = indexByRefSchemaIdx.get( keyRefSchemaIdx );
				if( mapRefSchemaIdx != null ) {
					mapRefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamSchemaRefByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamSchemaRefByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetSchemaRef( ICFBamSchemaRefObj Obj ) {
		forgetSchemaRef( Obj, false );
	}

	public void forgetSchemaRef( ICFBamSchemaRefObj Obj, boolean forgetSubObjects ) {
		ICFBamSchemaRefObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamSchemaRefObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamSchemaRefBySchemaIdxKey keySchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.remove( keepObj.getPKey() );
					if( mapSchemaIdx.size() <= 0 ) {
						indexBySchemaIdx.remove( keySchemaIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSchemaRefByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByRefSchemaIdx != null ) {
				CFBamSchemaRefByRefSchemaIdxKey keyRefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newRefSchemaIdxKey();
				keyRefSchemaIdx.setOptionalRefSchemaTenantId( keepObj.getOptionalRefSchemaTenantId() );
				keyRefSchemaIdx.setOptionalRefSchemaId( keepObj.getOptionalRefSchemaId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapRefSchemaIdx = indexByRefSchemaIdx.get( keyRefSchemaIdx );
				if( mapRefSchemaIdx != null ) {
					mapRefSchemaIdx.remove( keepObj.getPKey() );
					if( mapRefSchemaIdx.size() <= 0 ) {
						indexByRefSchemaIdx.remove( keyRefSchemaIdx );
					}
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamSchemaRefByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				CFBamSchemaRefByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
					if( mapNextIdx.size() <= 0 ) {
						indexByNextIdx.remove( keyNextIdx );
					}
				}
			}

			if( allSchemaRef != null ) {
				allSchemaRef.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		((ICFBamSchemaObj)schema).getScopeTableObj().forgetScope( obj );
	}

	public void forgetSchemaRefByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamSchemaRefObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSchemaRefByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamSchemaRefObj> toForget = new LinkedList<ICFBamSchemaRefObj>();
		ICFBamSchemaRefObj cur = null;
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaRefObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamSchemaRefObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamSchemaRefObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamSchemaRefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSchemaRefBySchemaIdx( long TenantId,
		long SchemaId )
	{
		if( indexBySchemaIdx == null ) {
			return;
		}
		List<ICFBamSchemaRefObj> toForget = new LinkedList<ICFBamSchemaRefObj>();
		ICFBamSchemaRefObj cur = null;
		CFBamSchemaRefBySchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaId( SchemaId );
		if( indexBySchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaRefObj > mapSchemaIdx = indexBySchemaIdx.get( key );
			if( mapSchemaIdx != null ) {
				Iterator<ICFBamSchemaRefObj> iterDup = mapSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexBySchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamSchemaRefObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamSchemaRefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSchemaRefByUNameIdx( long TenantId,
		long SchemaId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamSchemaRefObj> toForget = new LinkedList<ICFBamSchemaRefObj>();
		ICFBamSchemaRefObj cur = null;
		CFBamSchemaRefByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaId( SchemaId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamSchemaRefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSchemaRefByRefSchemaIdx( Long RefSchemaTenantId,
		Long RefSchemaId )
	{
		if( indexByRefSchemaIdx == null ) {
			return;
		}
		List<ICFBamSchemaRefObj> toForget = new LinkedList<ICFBamSchemaRefObj>();
		ICFBamSchemaRefObj cur = null;
		CFBamSchemaRefByRefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newRefSchemaIdxKey();
		key.setOptionalRefSchemaTenantId( RefSchemaTenantId );
		key.setOptionalRefSchemaId( RefSchemaId );
		if( indexByRefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaRefObj > mapRefSchemaIdx = indexByRefSchemaIdx.get( key );
			if( mapRefSchemaIdx != null ) {
				Iterator<ICFBamSchemaRefObj> iterDup = mapRefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByRefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamSchemaRefObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamSchemaRefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSchemaRefByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		if( indexByPrevIdx == null ) {
			return;
		}
		List<ICFBamSchemaRefObj> toForget = new LinkedList<ICFBamSchemaRefObj>();
		ICFBamSchemaRefObj cur = null;
		CFBamSchemaRefByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaRefObj > mapPrevIdx = indexByPrevIdx.get( key );
			if( mapPrevIdx != null ) {
				Iterator<ICFBamSchemaRefObj> iterDup = mapPrevIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByPrevIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamSchemaRefObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamSchemaRefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSchemaRefByNextIdx( Long NextTenantId,
		Long NextId )
	{
		if( indexByNextIdx == null ) {
			return;
		}
		List<ICFBamSchemaRefObj> toForget = new LinkedList<ICFBamSchemaRefObj>();
		ICFBamSchemaRefObj cur = null;
		CFBamSchemaRefByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaRefObj > mapNextIdx = indexByNextIdx.get( key );
			if( mapNextIdx != null ) {
				Iterator<ICFBamSchemaRefObj> iterDup = mapNextIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByNextIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamSchemaRefObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamSchemaRefObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamSchemaRefObj createSchemaRef( ICFBamSchemaRefObj Obj ) {
		ICFBamSchemaRefObj obj = Obj;
		CFBamSchemaRefBuff buff = obj.getSchemaRefBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().createSchemaRef(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "SCRF" ) ) {
			obj = (ICFBamSchemaRefObj)(obj.realise());
		}
		ICFBamSchemaRefObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamSchemaRefObj readSchemaRef( CFBamScopePKey pkey ) {
		return( readSchemaRef( pkey, false ) );
	}

	public ICFBamSchemaRefObj readSchemaRef( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamSchemaRefObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamSchemaRefBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamSchemaRefObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamSchemaRefObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamSchemaRefObj lockSchemaRef( CFBamScopePKey pkey ) {
		ICFBamSchemaRefObj locked = null;
		CFBamSchemaRefBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamSchemaRefObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamSchemaRefObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockSchemaRef", pkey );
		}
		return( locked );
	}

	public List<ICFBamSchemaRefObj> readAllSchemaRef() {
		return( readAllSchemaRef( false ) );
	}

	public List<ICFBamSchemaRefObj> readAllSchemaRef( boolean forceRead ) {
		final String S_ProcName = "readAllSchemaRef";
		if( ( allSchemaRef == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamSchemaRefObj> map = new HashMap<CFBamScopePKey,ICFBamSchemaRefObj>();
			allSchemaRef = map;
			CFBamSchemaRefBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().readAllDerived( schema.getAuthorization() );
			CFBamSchemaRefBuff buff;
			ICFBamSchemaRefObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaRefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaRefObj realised = (ICFBamSchemaRefObj)obj.realise();
			}
		}
		int len = allSchemaRef.size();
		ICFBamSchemaRefObj arr[] = new ICFBamSchemaRefObj[len];
		Iterator<ICFBamSchemaRefObj> valIter = allSchemaRef.values().iterator();
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
		ArrayList<ICFBamSchemaRefObj> arrayList = new ArrayList<ICFBamSchemaRefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamSchemaRefObj> cmp = new Comparator<ICFBamSchemaRefObj>() {
			public int compare( ICFBamSchemaRefObj lhs, ICFBamSchemaRefObj rhs ) {
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
		List<ICFBamSchemaRefObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSchemaRefObj readSchemaRefByIdIdx( long TenantId,
		long Id )
	{
		return( readSchemaRefByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamSchemaRefObj readSchemaRefByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamSchemaRefObj obj = readSchemaRef( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamSchemaRefObj> readSchemaRefByTenantIdx( long TenantId )
	{
		return( readSchemaRefByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamSchemaRefObj> readSchemaRefByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaRefByTenantIdx";
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamSchemaRefObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaRefObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaRefObj>();
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaRefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaRefObj realised = (ICFBamSchemaRefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamSchemaRefObj arr[] = new ICFBamSchemaRefObj[len];
		Iterator<ICFBamSchemaRefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaRefObj> arrayList = new ArrayList<ICFBamSchemaRefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamSchemaRefObj> cmp = new Comparator<ICFBamSchemaRefObj>() {
			public int compare( ICFBamSchemaRefObj lhs, ICFBamSchemaRefObj rhs ) {
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
		List<ICFBamSchemaRefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSchemaRefObj> readSchemaRefBySchemaIdx( long TenantId,
		long SchemaId )
	{
		return( readSchemaRefBySchemaIdx( TenantId,
			SchemaId,
			false ) );
	}

	public List<ICFBamSchemaRefObj> readSchemaRefBySchemaIdx( long TenantId,
		long SchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaRefBySchemaIdx";
		CFBamSchemaRefBySchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaId( SchemaId );
		Map<CFBamScopePKey, ICFBamSchemaRefObj> dict;
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< CFBamSchemaRefBySchemaIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaRefObj > >();
		}
		if( ( ! forceRead ) && indexBySchemaIdx.containsKey( key ) ) {
			dict = indexBySchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaRefObj>();
			ICFBamSchemaRefObj obj;
			CFBamSchemaRefBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().readDerivedBySchemaIdx( schema.getAuthorization(),
				TenantId,
				SchemaId );
			CFBamSchemaRefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaRefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaRefObj realised = (ICFBamSchemaRefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamSchemaRefObj arr[] = new ICFBamSchemaRefObj[len];
		Iterator<ICFBamSchemaRefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaRefObj> arrayList = new ArrayList<ICFBamSchemaRefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamSchemaRefObj> cmp = new Comparator<ICFBamSchemaRefObj>() {
			public int compare( ICFBamSchemaRefObj lhs, ICFBamSchemaRefObj rhs ) {
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
		List<ICFBamSchemaRefObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSchemaRefObj readSchemaRefByUNameIdx( long TenantId,
		long SchemaId,
		String Name )
	{
		return( readSchemaRefByUNameIdx( TenantId,
			SchemaId,
			Name,
			false ) );
	}

	public ICFBamSchemaRefObj readSchemaRefByUNameIdx( long TenantId,
		long SchemaId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamSchemaRefByUNameIdxKey,
				ICFBamSchemaRefObj >();
		}
		CFBamSchemaRefByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaId( SchemaId );
		key.setRequiredName( Name );
		ICFBamSchemaRefObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamSchemaRefBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				SchemaId,
				Name );
			if( buff != null ) {
				obj = (ICFBamSchemaRefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamSchemaRefObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFBamSchemaRefObj> readSchemaRefByRefSchemaIdx( Long RefSchemaTenantId,
		Long RefSchemaId )
	{
		return( readSchemaRefByRefSchemaIdx( RefSchemaTenantId,
			RefSchemaId,
			false ) );
	}

	public List<ICFBamSchemaRefObj> readSchemaRefByRefSchemaIdx( Long RefSchemaTenantId,
		Long RefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaRefByRefSchemaIdx";
		CFBamSchemaRefByRefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newRefSchemaIdxKey();
		key.setOptionalRefSchemaTenantId( RefSchemaTenantId );
		key.setOptionalRefSchemaId( RefSchemaId );
		Map<CFBamScopePKey, ICFBamSchemaRefObj> dict;
		if( indexByRefSchemaIdx == null ) {
			indexByRefSchemaIdx = new HashMap< CFBamSchemaRefByRefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaRefObj > >();
		}
		if( ( ! forceRead ) && indexByRefSchemaIdx.containsKey( key ) ) {
			dict = indexByRefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaRefObj>();
			ICFBamSchemaRefObj obj;
			CFBamSchemaRefBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().readDerivedByRefSchemaIdx( schema.getAuthorization(),
				RefSchemaTenantId,
				RefSchemaId );
			CFBamSchemaRefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaRefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaRefObj realised = (ICFBamSchemaRefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamSchemaRefObj arr[] = new ICFBamSchemaRefObj[len];
		Iterator<ICFBamSchemaRefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaRefObj> arrayList = new ArrayList<ICFBamSchemaRefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamSchemaRefObj> cmp = new Comparator<ICFBamSchemaRefObj>() {
			public int compare( ICFBamSchemaRefObj lhs, ICFBamSchemaRefObj rhs ) {
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
		List<ICFBamSchemaRefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSchemaRefObj> readSchemaRefByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		return( readSchemaRefByPrevIdx( PrevTenantId,
			PrevId,
			false ) );
	}

	public List<ICFBamSchemaRefObj> readSchemaRefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaRefByPrevIdx";
		CFBamSchemaRefByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamScopePKey, ICFBamSchemaRefObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamSchemaRefByPrevIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaRefObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaRefObj>();
			ICFBamSchemaRefObj obj;
			CFBamSchemaRefBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().readDerivedByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			CFBamSchemaRefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaRefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaRefObj realised = (ICFBamSchemaRefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamSchemaRefObj arr[] = new ICFBamSchemaRefObj[len];
		Iterator<ICFBamSchemaRefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaRefObj> arrayList = new ArrayList<ICFBamSchemaRefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamSchemaRefObj> cmp = new Comparator<ICFBamSchemaRefObj>() {
			public int compare( ICFBamSchemaRefObj lhs, ICFBamSchemaRefObj rhs ) {
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
		List<ICFBamSchemaRefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSchemaRefObj> readSchemaRefByNextIdx( Long NextTenantId,
		Long NextId )
	{
		return( readSchemaRefByNextIdx( NextTenantId,
			NextId,
			false ) );
	}

	public List<ICFBamSchemaRefObj> readSchemaRefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaRefByNextIdx";
		CFBamSchemaRefByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		Map<CFBamScopePKey, ICFBamSchemaRefObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamSchemaRefByNextIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaRefObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaRefObj>();
			ICFBamSchemaRefObj obj;
			CFBamSchemaRefBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().readDerivedByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			CFBamSchemaRefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaRefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaRefObj realised = (ICFBamSchemaRefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamSchemaRefObj arr[] = new ICFBamSchemaRefObj[len];
		Iterator<ICFBamSchemaRefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaRefObj> arrayList = new ArrayList<ICFBamSchemaRefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamSchemaRefObj> cmp = new Comparator<ICFBamSchemaRefObj>() {
			public int compare( ICFBamSchemaRefObj lhs, ICFBamSchemaRefObj rhs ) {
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
		List<ICFBamSchemaRefObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSchemaRefObj updateSchemaRef( ICFBamSchemaRefObj Obj ) {
		ICFBamSchemaRefObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().updateSchemaRef( schema.getAuthorization(),
			Obj.getSchemaRefBuff() );
		if( Obj.getClassCode().equals( "SCRF" ) ) {
			obj = (ICFBamSchemaRefObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteSchemaRef( ICFBamSchemaRefObj Obj ) {
		ICFBamSchemaRefObj obj = Obj;
		ICFBamSchemaRefObj prev = obj.getOptionalLookupPrev();
		ICFBamSchemaRefObj next = obj.getOptionalLookupNext();
		((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().deleteSchemaRef( schema.getAuthorization(),
			obj.getSchemaRefBuff() );
		obj.forget( true );
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	public void deleteSchemaRefByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamSchemaRefObj obj = readSchemaRef( pkey );
		if( obj != null ) {
			ICFBamSchemaRefEditObj editObj = (ICFBamSchemaRefEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamSchemaRefEditObj)obj.beginEdit();
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

	public void deleteSchemaRefByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaRefObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaRefObj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().deleteSchemaRefByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamSchemaRefObj> iter = dict.values().iterator();
			ICFBamSchemaRefObj obj;
			List<ICFBamSchemaRefObj> toForget = new LinkedList<ICFBamSchemaRefObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().deleteSchemaRefByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteSchemaRefBySchemaIdx( long TenantId,
		long SchemaId )
	{
		CFBamSchemaRefBySchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaId( SchemaId );
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< CFBamSchemaRefBySchemaIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaRefObj > >();
		}
		if( indexBySchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaRefObj> dict = indexBySchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().deleteSchemaRefBySchemaIdx( schema.getAuthorization(),
				TenantId,
				SchemaId );
			Iterator<ICFBamSchemaRefObj> iter = dict.values().iterator();
			ICFBamSchemaRefObj obj;
			List<ICFBamSchemaRefObj> toForget = new LinkedList<ICFBamSchemaRefObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().deleteSchemaRefBySchemaIdx( schema.getAuthorization(),
				TenantId,
				SchemaId );
		}
	}

	public void deleteSchemaRefByUNameIdx( long TenantId,
		long SchemaId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamSchemaRefByUNameIdxKey,
				ICFBamSchemaRefObj >();
		}
		CFBamSchemaRefByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaId( SchemaId );
		key.setRequiredName( Name );
		ICFBamSchemaRefObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().deleteSchemaRefByUNameIdx( schema.getAuthorization(),
				TenantId,
				SchemaId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().deleteSchemaRefByUNameIdx( schema.getAuthorization(),
				TenantId,
				SchemaId,
				Name );
		}
	}

	public void deleteSchemaRefByRefSchemaIdx( Long RefSchemaTenantId,
		Long RefSchemaId )
	{
		CFBamSchemaRefByRefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newRefSchemaIdxKey();
		key.setOptionalRefSchemaTenantId( RefSchemaTenantId );
		key.setOptionalRefSchemaId( RefSchemaId );
		if( indexByRefSchemaIdx == null ) {
			indexByRefSchemaIdx = new HashMap< CFBamSchemaRefByRefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaRefObj > >();
		}
		if( indexByRefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaRefObj> dict = indexByRefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().deleteSchemaRefByRefSchemaIdx( schema.getAuthorization(),
				RefSchemaTenantId,
				RefSchemaId );
			Iterator<ICFBamSchemaRefObj> iter = dict.values().iterator();
			ICFBamSchemaRefObj obj;
			List<ICFBamSchemaRefObj> toForget = new LinkedList<ICFBamSchemaRefObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByRefSchemaIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().deleteSchemaRefByRefSchemaIdx( schema.getAuthorization(),
				RefSchemaTenantId,
				RefSchemaId );
		}
	}

	public void deleteSchemaRefByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		CFBamSchemaRefByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamSchemaRefByPrevIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaRefObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaRefObj> dict = indexByPrevIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().deleteSchemaRefByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			Iterator<ICFBamSchemaRefObj> iter = dict.values().iterator();
			ICFBamSchemaRefObj obj;
			List<ICFBamSchemaRefObj> toForget = new LinkedList<ICFBamSchemaRefObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().deleteSchemaRefByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
		}
	}

	public void deleteSchemaRefByNextIdx( Long NextTenantId,
		Long NextId )
	{
		CFBamSchemaRefByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamSchemaRefByNextIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaRefObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaRefObj> dict = indexByNextIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().deleteSchemaRefByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			Iterator<ICFBamSchemaRefObj> iter = dict.values().iterator();
			ICFBamSchemaRefObj obj;
			List<ICFBamSchemaRefObj> toForget = new LinkedList<ICFBamSchemaRefObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().deleteSchemaRefByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
		}
	}

	/**
	 *	Move the CFBamSchemaRefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamSchemaRefObj refreshed cache instance.
	 */
	public ICFBamSchemaRefObj moveUpSchemaRef( ICFBamSchemaRefObj Obj ) {
		ICFBamSchemaRefObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveUpSchemaRef",
				"You cannot move an object that is being edited" );
		}
		CFBamSchemaRefBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().moveBuffUp( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getSchemaRefTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamSchemaRefObj)obj.realise();
			ICFBamSchemaRefObj prev = obj.getOptionalLookupPrev( true );
			ICFBamSchemaRefObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				ICFBamSchemaRefObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the CFBamSchemaRefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamSchemaRefObj refreshed cache instance.
	 */
	public ICFBamSchemaRefObj moveDownSchemaRef( ICFBamSchemaRefObj Obj ) {
		ICFBamSchemaRefObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveDownSchemaRef",
				"You cannot move an object that is being edited" );
		}
		CFBamSchemaRefBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().moveBuffDown( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getSchemaRefTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryScope().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamSchemaRefObj)obj.realise();
			ICFBamSchemaRefObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				ICFBamSchemaRefObj gprev = prev.getOptionalLookupPrev( true );
			}
			ICFBamSchemaRefObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}
