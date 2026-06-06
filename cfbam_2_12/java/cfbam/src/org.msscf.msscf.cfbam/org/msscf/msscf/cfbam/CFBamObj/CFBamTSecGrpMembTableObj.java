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

public class CFBamTSecGrpMembTableObj
	implements ICFBamTSecGrpMembTableObj
{
	protected ICFSecSchemaObj schema;
	private Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj> members;
	private Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj> allTSecGrpMemb;
	private Map< CFSecTSecGrpMembByTenantIdxKey,
		Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > > indexByTenantIdx;
	private Map< CFSecTSecGrpMembByGroupIdxKey,
		Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > > indexByGroupIdx;
	private Map< CFSecTSecGrpMembByUserIdxKey,
		Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > > indexByUserIdx;
	private Map< CFSecTSecGrpMembByUUserIdxKey,
		ICFSecTSecGrpMembObj > indexByUUserIdx;
	public static String TABLE_NAME = "TSecGrpMemb";
	public static String TABLE_DBNAME = "tsecmemb";

	public CFBamTSecGrpMembTableObj() {
		schema = null;
		members = new HashMap<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj>();
		allTSecGrpMemb = null;
		indexByTenantIdx = null;
		indexByGroupIdx = null;
		indexByUserIdx = null;
		indexByUUserIdx = null;
	}

	public CFBamTSecGrpMembTableObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj>();
		allTSecGrpMemb = null;
		indexByTenantIdx = null;
		indexByGroupIdx = null;
		indexByUserIdx = null;
		indexByUUserIdx = null;
	}

	public ICFSecSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFSecSchemaObj value ) {
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
		allTSecGrpMemb = null;
		indexByTenantIdx = null;
		indexByGroupIdx = null;
		indexByUserIdx = null;
		indexByUUserIdx = null;
		List<ICFSecTSecGrpMembObj> toForget = new LinkedList<ICFSecTSecGrpMembObj>();
		ICFSecTSecGrpMembObj cur = null;
		Iterator<ICFSecTSecGrpMembObj> iter = members.values().iterator();
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
	 *	CFBamTSecGrpMembObj.
	 */
	public ICFSecTSecGrpMembObj newInstance() {
		ICFSecTSecGrpMembObj inst = new CFBamTSecGrpMembObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTSecGrpMembObj.
	 */
	public ICFSecTSecGrpMembEditObj newEditInstance( ICFSecTSecGrpMembObj orig ) {
		ICFSecTSecGrpMembEditObj edit = new CFBamTSecGrpMembEditObj( orig );
		return( edit );
	}

	public ICFSecTSecGrpMembObj realiseTSecGrpMemb( ICFSecTSecGrpMembObj Obj ) {
		ICFSecTSecGrpMembObj obj = Obj;
		CFSecTSecGrpMembPKey pkey = obj.getPKey();
		ICFSecTSecGrpMembObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFSecTSecGrpMembObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFSecTSecGrpMembByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByGroupIdx != null ) {
				CFSecTSecGrpMembByGroupIdxKey keyGroupIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
					if( mapGroupIdx.size() <= 0 ) {
						indexByGroupIdx.remove( keyGroupIdx );
					}
				}
			}

			if( indexByUserIdx != null ) {
				CFSecTSecGrpMembByUserIdxKey keyUserIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.remove( keepObj.getPKey() );
					if( mapUserIdx.size() <= 0 ) {
						indexByUserIdx.remove( keyUserIdx );
					}
				}
			}

			if( indexByUUserIdx != null ) {
				CFSecTSecGrpMembByUUserIdxKey keyUUserIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUUserIdxKey();
				keyUUserIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUUserIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.remove( keyUUserIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFSecTSecGrpMembByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFSecTSecGrpMembByGroupIdxKey keyGroupIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUserIdx != null ) {
				CFSecTSecGrpMembByUserIdxKey keyUserIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUUserIdx != null ) {
				CFSecTSecGrpMembByUUserIdxKey keyUUserIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUUserIdxKey();
				keyUUserIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUUserIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.put( keyUUserIdx, keepObj );
			}

			if( allTSecGrpMemb != null ) {
				allTSecGrpMemb.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTSecGrpMemb != null ) {
				allTSecGrpMemb.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFSecTSecGrpMembByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFSecTSecGrpMembByGroupIdxKey keyGroupIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUserIdx != null ) {
				CFSecTSecGrpMembByUserIdxKey keyUserIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUUserIdx != null ) {
				CFSecTSecGrpMembByUUserIdxKey keyUUserIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUUserIdxKey();
				keyUUserIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUUserIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.put( keyUUserIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetTSecGrpMemb( ICFSecTSecGrpMembObj Obj ) {
		forgetTSecGrpMemb( Obj, false );
	}

	public void forgetTSecGrpMemb( ICFSecTSecGrpMembObj Obj, boolean forgetSubObjects ) {
		ICFSecTSecGrpMembObj obj = Obj;
		CFSecTSecGrpMembPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFSecTSecGrpMembObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFSecTSecGrpMembByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByGroupIdx != null ) {
				CFSecTSecGrpMembByGroupIdxKey keyGroupIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
					if( mapGroupIdx.size() <= 0 ) {
						indexByGroupIdx.remove( keyGroupIdx );
					}
				}
			}

			if( indexByUserIdx != null ) {
				CFSecTSecGrpMembByUserIdxKey keyUserIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.remove( keepObj.getPKey() );
					if( mapUserIdx.size() <= 0 ) {
						indexByUserIdx.remove( keyUserIdx );
					}
				}
			}

			if( indexByUUserIdx != null ) {
				CFSecTSecGrpMembByUUserIdxKey keyUUserIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUUserIdxKey();
				keyUUserIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUUserIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.remove( keyUUserIdx );
			}

			if( allTSecGrpMemb != null ) {
				allTSecGrpMemb.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetTSecGrpMembByIdIdx( long TenantId,
		long TSecGrpMembId )
	{
		if( members == null ) {
			return;
		}
		CFSecTSecGrpMembPKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGrpMembId( TSecGrpMembId );
		if( members.containsKey( key ) ) {
			ICFSecTSecGrpMembObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTSecGrpMembByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFSecTSecGrpMembObj> toForget = new LinkedList<ICFSecTSecGrpMembObj>();
		ICFSecTSecGrpMembObj cur = null;
		CFSecTSecGrpMembByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFSecTSecGrpMembObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecTSecGrpMembObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecTSecGrpMembObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTSecGrpMembByGroupIdx( long TenantId,
		int TSecGroupId )
	{
		if( indexByGroupIdx == null ) {
			return;
		}
		List<ICFSecTSecGrpMembObj> toForget = new LinkedList<ICFSecTSecGrpMembObj>();
		ICFSecTSecGrpMembObj cur = null;
		CFSecTSecGrpMembByGroupIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( key );
			if( mapGroupIdx != null ) {
				Iterator<ICFSecTSecGrpMembObj> iterDup = mapGroupIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGroupIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecTSecGrpMembObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecTSecGrpMembObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTSecGrpMembByUserIdx( UUID SecUserId )
	{
		if( indexByUserIdx == null ) {
			return;
		}
		List<ICFSecTSecGrpMembObj> toForget = new LinkedList<ICFSecTSecGrpMembObj>();
		ICFSecTSecGrpMembObj cur = null;
		CFSecTSecGrpMembByUserIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexByUserIdx.containsKey( key ) ) {
			Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > mapUserIdx = indexByUserIdx.get( key );
			if( mapUserIdx != null ) {
				Iterator<ICFSecTSecGrpMembObj> iterDup = mapUserIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByUserIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecTSecGrpMembObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecTSecGrpMembObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTSecGrpMembByUUserIdx( long TenantId,
		int TSecGroupId,
		UUID SecUserId )
	{
		if( indexByUUserIdx == null ) {
			return;
		}
		List<ICFSecTSecGrpMembObj> toForget = new LinkedList<ICFSecTSecGrpMembObj>();
		ICFSecTSecGrpMembObj cur = null;
		CFSecTSecGrpMembByUUserIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUUserIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredSecUserId( SecUserId );
		if( indexByUUserIdx.containsKey( key ) ) {
			cur = indexByUUserIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFSecTSecGrpMembObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFSecTSecGrpMembObj createTSecGrpMemb( ICFSecTSecGrpMembObj Obj ) {
		ICFSecTSecGrpMembObj obj = Obj;
		CFSecTSecGrpMembBuff buff = obj.getTSecGrpMembBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().createTSecGrpMemb(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFSecTSecGrpMembObj readTSecGrpMemb( CFSecTSecGrpMembPKey pkey ) {
		return( readTSecGrpMemb( pkey, false ) );
	}

	public ICFSecTSecGrpMembObj readTSecGrpMemb( CFSecTSecGrpMembPKey pkey, boolean forceRead ) {
		ICFSecTSecGrpMembObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFSecTSecGrpMembBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredTSecGrpMembId() );
			if( readBuff != null ) {
				obj = schema.getTSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFSecTSecGrpMembObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecTSecGrpMembObj lockTSecGrpMemb( CFSecTSecGrpMembPKey pkey ) {
		ICFSecTSecGrpMembObj locked = null;
		CFSecTSecGrpMembBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getTSecGrpMembTableObj().newInstance();
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFSecTSecGrpMembObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockTSecGrpMemb", pkey );
		}
		return( locked );
	}

	public List<ICFSecTSecGrpMembObj> readAllTSecGrpMemb() {
		return( readAllTSecGrpMemb( false ) );
	}

	public List<ICFSecTSecGrpMembObj> readAllTSecGrpMemb( boolean forceRead ) {
		final String S_ProcName = "readAllTSecGrpMemb";
		if( ( allTSecGrpMemb == null ) || forceRead ) {
			Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj> map = new HashMap<CFSecTSecGrpMembPKey,ICFSecTSecGrpMembObj>();
			allTSecGrpMemb = map;
			CFSecTSecGrpMembBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().readAllDerived( schema.getAuthorization() );
			CFSecTSecGrpMembBuff buff;
			ICFSecTSecGrpMembObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
				obj.setBuff( buff );
				ICFSecTSecGrpMembObj realised = (ICFSecTSecGrpMembObj)obj.realise();
			}
		}
		int len = allTSecGrpMemb.size();
		ICFSecTSecGrpMembObj arr[] = new ICFSecTSecGrpMembObj[len];
		Iterator<ICFSecTSecGrpMembObj> valIter = allTSecGrpMemb.values().iterator();
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
		ArrayList<ICFSecTSecGrpMembObj> arrayList = new ArrayList<ICFSecTSecGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecTSecGrpMembObj> cmp = new Comparator<ICFSecTSecGrpMembObj>() {
			public int compare( ICFSecTSecGrpMembObj lhs, ICFSecTSecGrpMembObj rhs ) {
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
					CFSecTSecGrpMembPKey lhsPKey = lhs.getPKey();
					CFSecTSecGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecTSecGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Return a sorted map of a page of the TSecGrpMemb-derived instances in the database.
	 *
	 *	@return	List of ICFSecTSecGrpMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	public List<ICFSecTSecGrpMembObj> pageAllTSecGrpMemb(Long priorTenantId,
		Long priorTSecGrpMembId )
	{
		final String S_ProcName = "pageAllTSecGrpMemb";
		Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj> map = new HashMap<CFSecTSecGrpMembPKey,ICFSecTSecGrpMembObj>();
		CFSecTSecGrpMembBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().pageAllBuff( schema.getAuthorization(),
			priorTenantId,
			priorTSecGrpMembId );
		CFSecTSecGrpMembBuff buff;
		ICFSecTSecGrpMembObj obj;
		ICFSecTSecGrpMembObj realised;
		ArrayList<ICFSecTSecGrpMembObj> arrayList = new ArrayList<ICFSecTSecGrpMembObj>( buffList.length );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
			obj.setBuff( buff );
			realised = (ICFSecTSecGrpMembObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	public ICFSecTSecGrpMembObj readTSecGrpMembByIdIdx( long TenantId,
		long TSecGrpMembId )
	{
		return( readTSecGrpMembByIdIdx( TenantId,
			TSecGrpMembId,
			false ) );
	}

	public ICFSecTSecGrpMembObj readTSecGrpMembByIdIdx( long TenantId,
		long TSecGrpMembId, boolean forceRead )
	{
		CFSecTSecGrpMembPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredTSecGrpMembId( TSecGrpMembId );
		ICFSecTSecGrpMembObj obj = readTSecGrpMemb( pkey, forceRead );
		return( obj );
	}

	public List<ICFSecTSecGrpMembObj> readTSecGrpMembByTenantIdx( long TenantId )
	{
		return( readTSecGrpMembByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFSecTSecGrpMembObj> readTSecGrpMembByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTSecGrpMembByTenantIdx";
		CFSecTSecGrpMembByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFSecTSecGrpMembByTenantIdxKey,
				Map< CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj>();
			ICFSecTSecGrpMembObj obj;
			CFSecTSecGrpMembBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFSecTSecGrpMembBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
				obj.setBuff( buff );
				ICFSecTSecGrpMembObj realised = (ICFSecTSecGrpMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecTSecGrpMembObj arr[] = new ICFSecTSecGrpMembObj[len];
		Iterator<ICFSecTSecGrpMembObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecTSecGrpMembObj> arrayList = new ArrayList<ICFSecTSecGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecTSecGrpMembObj> cmp = new Comparator<ICFSecTSecGrpMembObj>() {
			public int compare( ICFSecTSecGrpMembObj lhs, ICFSecTSecGrpMembObj rhs ) {
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
					CFSecTSecGrpMembPKey lhsPKey = lhs.getPKey();
					CFSecTSecGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecTSecGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFSecTSecGrpMembObj> readTSecGrpMembByGroupIdx( long TenantId,
		int TSecGroupId )
	{
		return( readTSecGrpMembByGroupIdx( TenantId,
			TSecGroupId,
			false ) );
	}

	public List<ICFSecTSecGrpMembObj> readTSecGrpMembByGroupIdx( long TenantId,
		int TSecGroupId,
		boolean forceRead )
	{
		final String S_ProcName = "readTSecGrpMembByGroupIdx";
		CFSecTSecGrpMembByGroupIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj> dict;
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFSecTSecGrpMembByGroupIdxKey,
				Map< CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > >();
		}
		if( ( ! forceRead ) && indexByGroupIdx.containsKey( key ) ) {
			dict = indexByGroupIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj>();
			ICFSecTSecGrpMembObj obj;
			CFSecTSecGrpMembBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().readDerivedByGroupIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId );
			CFSecTSecGrpMembBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
				obj.setBuff( buff );
				ICFSecTSecGrpMembObj realised = (ICFSecTSecGrpMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGroupIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecTSecGrpMembObj arr[] = new ICFSecTSecGrpMembObj[len];
		Iterator<ICFSecTSecGrpMembObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecTSecGrpMembObj> arrayList = new ArrayList<ICFSecTSecGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecTSecGrpMembObj> cmp = new Comparator<ICFSecTSecGrpMembObj>() {
			public int compare( ICFSecTSecGrpMembObj lhs, ICFSecTSecGrpMembObj rhs ) {
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
					CFSecTSecGrpMembPKey lhsPKey = lhs.getPKey();
					CFSecTSecGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecTSecGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFSecTSecGrpMembObj> readTSecGrpMembByUserIdx( UUID SecUserId )
	{
		return( readTSecGrpMembByUserIdx( SecUserId,
			false ) );
	}

	public List<ICFSecTSecGrpMembObj> readTSecGrpMembByUserIdx( UUID SecUserId,
		boolean forceRead )
	{
		final String S_ProcName = "readTSecGrpMembByUserIdx";
		CFSecTSecGrpMembByUserIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj> dict;
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< CFSecTSecGrpMembByUserIdxKey,
				Map< CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > >();
		}
		if( ( ! forceRead ) && indexByUserIdx.containsKey( key ) ) {
			dict = indexByUserIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj>();
			ICFSecTSecGrpMembObj obj;
			CFSecTSecGrpMembBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().readDerivedByUserIdx( schema.getAuthorization(),
				SecUserId );
			CFSecTSecGrpMembBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
				obj.setBuff( buff );
				ICFSecTSecGrpMembObj realised = (ICFSecTSecGrpMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByUserIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecTSecGrpMembObj arr[] = new ICFSecTSecGrpMembObj[len];
		Iterator<ICFSecTSecGrpMembObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecTSecGrpMembObj> arrayList = new ArrayList<ICFSecTSecGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecTSecGrpMembObj> cmp = new Comparator<ICFSecTSecGrpMembObj>() {
			public int compare( ICFSecTSecGrpMembObj lhs, ICFSecTSecGrpMembObj rhs ) {
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
					CFSecTSecGrpMembPKey lhsPKey = lhs.getPKey();
					CFSecTSecGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecTSecGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecTSecGrpMembObj readTSecGrpMembByUUserIdx( long TenantId,
		int TSecGroupId,
		UUID SecUserId )
	{
		return( readTSecGrpMembByUUserIdx( TenantId,
			TSecGroupId,
			SecUserId,
			false ) );
	}

	public ICFSecTSecGrpMembObj readTSecGrpMembByUUserIdx( long TenantId,
		int TSecGroupId,
		UUID SecUserId, boolean forceRead )
	{
		if( indexByUUserIdx == null ) {
			indexByUUserIdx = new HashMap< CFSecTSecGrpMembByUUserIdxKey,
				ICFSecTSecGrpMembObj >();
		}
		CFSecTSecGrpMembByUUserIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUUserIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredSecUserId( SecUserId );
		ICFSecTSecGrpMembObj obj = null;
		if( ( ! forceRead ) && indexByUUserIdx.containsKey( key ) ) {
			obj = indexByUUserIdx.get( key );
		}
		else {
			CFSecTSecGrpMembBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().readDerivedByUUserIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId,
				SecUserId );
			if( buff != null ) {
				obj = schema.getTSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
				obj.setBuff( buff );
				obj = (ICFSecTSecGrpMembObj)obj.realise();
			}
		}
		return( obj );
	}

	/**
	 *	Read a page of data as a List of TSecGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate TenantIdx key attributes.
	 *
	 *	@param	argTenantId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of TSecGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecTSecGrpMembObj> pageTSecGrpMembByTenantIdx( long TenantId,
		Long priorTenantId,
		Long priorTSecGrpMembId )
	{
		final String S_ProcName = "pageTSecGrpMembByTenantIdx";
		CFSecTSecGrpMembByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		List<ICFSecTSecGrpMembObj> retList = new LinkedList<ICFSecTSecGrpMembObj>();
		ICFSecTSecGrpMembObj obj;
		CFSecTSecGrpMembBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().pageBuffByTenantIdx( schema.getAuthorization(),
				TenantId,
			priorTenantId,
			priorTSecGrpMembId );
		CFSecTSecGrpMembBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getTSecGrpMembTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
			obj.setBuff( buff );
			ICFSecTSecGrpMembObj realised = (ICFSecTSecGrpMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of TSecGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate GroupIdx key attributes.
	 *
	 *	@param	argTenantId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of TSecGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecTSecGrpMembObj> pageTSecGrpMembByGroupIdx( long TenantId,
		int TSecGroupId,
		Long priorTenantId,
		Long priorTSecGrpMembId )
	{
		final String S_ProcName = "pageTSecGrpMembByGroupIdx";
		CFSecTSecGrpMembByGroupIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		List<ICFSecTSecGrpMembObj> retList = new LinkedList<ICFSecTSecGrpMembObj>();
		ICFSecTSecGrpMembObj obj;
		CFSecTSecGrpMembBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().pageBuffByGroupIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId,
			priorTenantId,
			priorTSecGrpMembId );
		CFSecTSecGrpMembBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getTSecGrpMembTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
			obj.setBuff( buff );
			ICFSecTSecGrpMembObj realised = (ICFSecTSecGrpMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of TSecGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate UserIdx key attributes.
	 *
	 *	@param	argSecUserId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of TSecGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecTSecGrpMembObj> pageTSecGrpMembByUserIdx( UUID SecUserId,
		Long priorTenantId,
		Long priorTSecGrpMembId )
	{
		final String S_ProcName = "pageTSecGrpMembByUserIdx";
		CFSecTSecGrpMembByUserIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		List<ICFSecTSecGrpMembObj> retList = new LinkedList<ICFSecTSecGrpMembObj>();
		ICFSecTSecGrpMembObj obj;
		CFSecTSecGrpMembBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().pageBuffByUserIdx( schema.getAuthorization(),
				SecUserId,
			priorTenantId,
			priorTSecGrpMembId );
		CFSecTSecGrpMembBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getTSecGrpMembTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
			obj.setBuff( buff );
			ICFSecTSecGrpMembObj realised = (ICFSecTSecGrpMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	public ICFSecTSecGrpMembObj updateTSecGrpMemb( ICFSecTSecGrpMembObj Obj ) {
		ICFSecTSecGrpMembObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().updateTSecGrpMemb( schema.getAuthorization(),
			Obj.getTSecGrpMembBuff() );
		obj = (ICFSecTSecGrpMembObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteTSecGrpMemb( ICFSecTSecGrpMembObj Obj ) {
		ICFSecTSecGrpMembObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().deleteTSecGrpMemb( schema.getAuthorization(),
			obj.getTSecGrpMembBuff() );
		obj.forget( true );
	}

	public void deleteTSecGrpMembByIdIdx( long TenantId,
		long TSecGrpMembId )
	{
		CFSecTSecGrpMembPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredTSecGrpMembId( TSecGrpMembId );
		ICFSecTSecGrpMembObj obj = readTSecGrpMemb( pkey );
		if( obj != null ) {
			ICFSecTSecGrpMembEditObj editObj = (ICFSecTSecGrpMembEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFSecTSecGrpMembEditObj)obj.beginEdit();
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

	public void deleteTSecGrpMembByTenantIdx( long TenantId )
	{
		CFSecTSecGrpMembByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFSecTSecGrpMembByTenantIdxKey,
				Map< CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().deleteTSecGrpMembByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFSecTSecGrpMembObj> iter = dict.values().iterator();
			ICFSecTSecGrpMembObj obj;
			List<ICFSecTSecGrpMembObj> toForget = new LinkedList<ICFSecTSecGrpMembObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().deleteTSecGrpMembByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTSecGrpMembByGroupIdx( long TenantId,
		int TSecGroupId )
	{
		CFSecTSecGrpMembByGroupIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFSecTSecGrpMembByGroupIdxKey,
				Map< CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > >();
		}
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj> dict = indexByGroupIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().deleteTSecGrpMembByGroupIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId );
			Iterator<ICFSecTSecGrpMembObj> iter = dict.values().iterator();
			ICFSecTSecGrpMembObj obj;
			List<ICFSecTSecGrpMembObj> toForget = new LinkedList<ICFSecTSecGrpMembObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByGroupIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().deleteTSecGrpMembByGroupIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId );
		}
	}

	public void deleteTSecGrpMembByUserIdx( UUID SecUserId )
	{
		CFSecTSecGrpMembByUserIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< CFSecTSecGrpMembByUserIdxKey,
				Map< CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj > >();
		}
		if( indexByUserIdx.containsKey( key ) ) {
			Map<CFSecTSecGrpMembPKey, ICFSecTSecGrpMembObj> dict = indexByUserIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().deleteTSecGrpMembByUserIdx( schema.getAuthorization(),
				SecUserId );
			Iterator<ICFSecTSecGrpMembObj> iter = dict.values().iterator();
			ICFSecTSecGrpMembObj obj;
			List<ICFSecTSecGrpMembObj> toForget = new LinkedList<ICFSecTSecGrpMembObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByUserIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().deleteTSecGrpMembByUserIdx( schema.getAuthorization(),
				SecUserId );
		}
	}

	public void deleteTSecGrpMembByUUserIdx( long TenantId,
		int TSecGroupId,
		UUID SecUserId )
	{
		if( indexByUUserIdx == null ) {
			indexByUUserIdx = new HashMap< CFSecTSecGrpMembByUUserIdxKey,
				ICFSecTSecGrpMembObj >();
		}
		CFSecTSecGrpMembByUUserIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUUserIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredSecUserId( SecUserId );
		ICFSecTSecGrpMembObj obj = null;
		if( indexByUUserIdx.containsKey( key ) ) {
			obj = indexByUUserIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().deleteTSecGrpMembByUUserIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId,
				SecUserId );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpMemb().deleteTSecGrpMembByUUserIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId,
				SecUserId );
		}
	}
}
