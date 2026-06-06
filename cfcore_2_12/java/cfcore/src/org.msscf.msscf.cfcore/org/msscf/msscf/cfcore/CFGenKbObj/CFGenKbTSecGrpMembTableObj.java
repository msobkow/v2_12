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

public class CFGenKbTSecGrpMembTableObj
	implements ICFGenKbTSecGrpMembTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj> members;
	private Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj> allTSecGrpMemb;
	private Map< CFGenKbTSecGrpMembByTenantIdxKey,
		Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > > indexByTenantIdx;
	private Map< CFGenKbTSecGrpMembByGroupIdxKey,
		Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > > indexByGroupIdx;
	private Map< CFGenKbTSecGrpMembByUserIdxKey,
		Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > > indexByUserIdx;
	private Map< CFGenKbTSecGrpMembByUUserIdxKey,
		ICFGenKbTSecGrpMembObj > indexByUUserIdx;
	public static String TABLE_NAME = "TSecGrpMemb";
	public static String TABLE_DBNAME = "tsecmemb";

	public CFGenKbTSecGrpMembTableObj() {
		schema = null;
		members = new HashMap<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj>();
		allTSecGrpMemb = null;
		indexByTenantIdx = null;
		indexByGroupIdx = null;
		indexByUserIdx = null;
		indexByUUserIdx = null;
	}

	public CFGenKbTSecGrpMembTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj>();
		allTSecGrpMemb = null;
		indexByTenantIdx = null;
		indexByGroupIdx = null;
		indexByUserIdx = null;
		indexByUUserIdx = null;
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
		allTSecGrpMemb = null;
		indexByTenantIdx = null;
		indexByGroupIdx = null;
		indexByUserIdx = null;
		indexByUUserIdx = null;
		List<ICFGenKbTSecGrpMembObj> toForget = new LinkedList<ICFGenKbTSecGrpMembObj>();
		ICFGenKbTSecGrpMembObj cur = null;
		Iterator<ICFGenKbTSecGrpMembObj> iter = members.values().iterator();
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
	 *	CFGenKbTSecGrpMembObj.
	 */
	public ICFGenKbTSecGrpMembObj newInstance() {
		ICFGenKbTSecGrpMembObj inst = new CFGenKbTSecGrpMembObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbTSecGrpMembObj.
	 */
	public ICFGenKbTSecGrpMembEditObj newEditInstance( ICFGenKbTSecGrpMembObj orig ) {
		ICFGenKbTSecGrpMembEditObj edit = new CFGenKbTSecGrpMembEditObj( orig );
		return( edit );
	}

	public ICFGenKbTSecGrpMembObj realiseTSecGrpMemb( ICFGenKbTSecGrpMembObj Obj ) {
		ICFGenKbTSecGrpMembObj obj = Obj;
		CFGenKbTSecGrpMembPKey pkey = obj.getPKey();
		ICFGenKbTSecGrpMembObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbTSecGrpMembObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFGenKbTSecGrpMembByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByGroupIdx != null ) {
				CFGenKbTSecGrpMembByGroupIdxKey keyGroupIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
					if( mapGroupIdx.size() <= 0 ) {
						indexByGroupIdx.remove( keyGroupIdx );
					}
				}
			}

			if( indexByUserIdx != null ) {
				CFGenKbTSecGrpMembByUserIdxKey keyUserIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.remove( keepObj.getPKey() );
					if( mapUserIdx.size() <= 0 ) {
						indexByUserIdx.remove( keyUserIdx );
					}
				}
			}

			if( indexByUUserIdx != null ) {
				CFGenKbTSecGrpMembByUUserIdxKey keyUUserIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUUserIdxKey();
				keyUUserIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUUserIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.remove( keyUUserIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFGenKbTSecGrpMembByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFGenKbTSecGrpMembByGroupIdxKey keyGroupIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUserIdx != null ) {
				CFGenKbTSecGrpMembByUserIdxKey keyUserIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUUserIdx != null ) {
				CFGenKbTSecGrpMembByUUserIdxKey keyUUserIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUUserIdxKey();
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
				CFGenKbTSecGrpMembByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFGenKbTSecGrpMembByGroupIdxKey keyGroupIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUserIdx != null ) {
				CFGenKbTSecGrpMembByUserIdxKey keyUserIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUUserIdx != null ) {
				CFGenKbTSecGrpMembByUUserIdxKey keyUUserIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUUserIdxKey();
				keyUUserIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUUserIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.put( keyUUserIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetTSecGrpMemb( ICFGenKbTSecGrpMembObj Obj ) {
		forgetTSecGrpMemb( Obj, false );
	}

	public void forgetTSecGrpMemb( ICFGenKbTSecGrpMembObj Obj, boolean forgetSubObjects ) {
		ICFGenKbTSecGrpMembObj obj = Obj;
		CFGenKbTSecGrpMembPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbTSecGrpMembObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFGenKbTSecGrpMembByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByGroupIdx != null ) {
				CFGenKbTSecGrpMembByGroupIdxKey keyGroupIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
					if( mapGroupIdx.size() <= 0 ) {
						indexByGroupIdx.remove( keyGroupIdx );
					}
				}
			}

			if( indexByUserIdx != null ) {
				CFGenKbTSecGrpMembByUserIdxKey keyUserIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.remove( keepObj.getPKey() );
					if( mapUserIdx.size() <= 0 ) {
						indexByUserIdx.remove( keyUserIdx );
					}
				}
			}

			if( indexByUUserIdx != null ) {
				CFGenKbTSecGrpMembByUUserIdxKey keyUUserIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUUserIdxKey();
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
		CFGenKbTSecGrpMembPKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGrpMembId( TSecGrpMembId );
		if( members.containsKey( key ) ) {
			ICFGenKbTSecGrpMembObj probed = members.get( key );
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
		List<ICFGenKbTSecGrpMembObj> toForget = new LinkedList<ICFGenKbTSecGrpMembObj>();
		ICFGenKbTSecGrpMembObj cur = null;
		CFGenKbTSecGrpMembByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFGenKbTSecGrpMembObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbTSecGrpMembObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbTSecGrpMembObj> iter = toForget.iterator();
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
		List<ICFGenKbTSecGrpMembObj> toForget = new LinkedList<ICFGenKbTSecGrpMembObj>();
		ICFGenKbTSecGrpMembObj cur = null;
		CFGenKbTSecGrpMembByGroupIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( key );
			if( mapGroupIdx != null ) {
				Iterator<ICFGenKbTSecGrpMembObj> iterDup = mapGroupIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGroupIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbTSecGrpMembObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbTSecGrpMembObj> iter = toForget.iterator();
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
		List<ICFGenKbTSecGrpMembObj> toForget = new LinkedList<ICFGenKbTSecGrpMembObj>();
		ICFGenKbTSecGrpMembObj cur = null;
		CFGenKbTSecGrpMembByUserIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexByUserIdx.containsKey( key ) ) {
			Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > mapUserIdx = indexByUserIdx.get( key );
			if( mapUserIdx != null ) {
				Iterator<ICFGenKbTSecGrpMembObj> iterDup = mapUserIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByUserIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbTSecGrpMembObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbTSecGrpMembObj> iter = toForget.iterator();
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
		List<ICFGenKbTSecGrpMembObj> toForget = new LinkedList<ICFGenKbTSecGrpMembObj>();
		ICFGenKbTSecGrpMembObj cur = null;
		CFGenKbTSecGrpMembByUUserIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUUserIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredSecUserId( SecUserId );
		if( indexByUUserIdx.containsKey( key ) ) {
			cur = indexByUUserIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFGenKbTSecGrpMembObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbTSecGrpMembObj createTSecGrpMemb( ICFGenKbTSecGrpMembObj Obj ) {
		ICFGenKbTSecGrpMembObj obj = Obj;
		CFGenKbTSecGrpMembBuff buff = obj.getTSecGrpMembBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().createTSecGrpMemb(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbTSecGrpMembObj readTSecGrpMemb( CFGenKbTSecGrpMembPKey pkey ) {
		return( readTSecGrpMemb( pkey, false ) );
	}

	public ICFGenKbTSecGrpMembObj readTSecGrpMemb( CFGenKbTSecGrpMembPKey pkey, boolean forceRead ) {
		ICFGenKbTSecGrpMembObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbTSecGrpMembBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredTSecGrpMembId() );
			if( readBuff != null ) {
				obj = schema.getTSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbTSecGrpMembObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbTSecGrpMembObj lockTSecGrpMemb( CFGenKbTSecGrpMembPKey pkey ) {
		ICFGenKbTSecGrpMembObj locked = null;
		CFGenKbTSecGrpMembBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getTSecGrpMembTableObj().newInstance();
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbTSecGrpMembObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockTSecGrpMemb", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbTSecGrpMembObj> readAllTSecGrpMemb() {
		return( readAllTSecGrpMemb( false ) );
	}

	public List<ICFGenKbTSecGrpMembObj> readAllTSecGrpMemb( boolean forceRead ) {
		final String S_ProcName = "readAllTSecGrpMemb";
		if( ( allTSecGrpMemb == null ) || forceRead ) {
			Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj> map = new HashMap<CFGenKbTSecGrpMembPKey,ICFGenKbTSecGrpMembObj>();
			allTSecGrpMemb = map;
			CFGenKbTSecGrpMembBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().readAllDerived( schema.getAuthorization() );
			CFGenKbTSecGrpMembBuff buff;
			ICFGenKbTSecGrpMembObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
				obj.setBuff( buff );
				ICFGenKbTSecGrpMembObj realised = (ICFGenKbTSecGrpMembObj)obj.realise();
			}
		}
		int len = allTSecGrpMemb.size();
		ICFGenKbTSecGrpMembObj arr[] = new ICFGenKbTSecGrpMembObj[len];
		Iterator<ICFGenKbTSecGrpMembObj> valIter = allTSecGrpMemb.values().iterator();
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
		ArrayList<ICFGenKbTSecGrpMembObj> arrayList = new ArrayList<ICFGenKbTSecGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbTSecGrpMembObj> cmp = new Comparator<ICFGenKbTSecGrpMembObj>() {
			public int compare( ICFGenKbTSecGrpMembObj lhs, ICFGenKbTSecGrpMembObj rhs ) {
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
					CFGenKbTSecGrpMembPKey lhsPKey = lhs.getPKey();
					CFGenKbTSecGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbTSecGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Return a sorted map of a page of the TSecGrpMemb-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbTSecGrpMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	public List<ICFGenKbTSecGrpMembObj> pageAllTSecGrpMemb(Long priorTenantId,
		Long priorTSecGrpMembId )
	{
		final String S_ProcName = "pageAllTSecGrpMemb";
		Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj> map = new HashMap<CFGenKbTSecGrpMembPKey,ICFGenKbTSecGrpMembObj>();
		CFGenKbTSecGrpMembBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().pageAllBuff( schema.getAuthorization(),
			priorTenantId,
			priorTSecGrpMembId );
		CFGenKbTSecGrpMembBuff buff;
		ICFGenKbTSecGrpMembObj obj;
		ICFGenKbTSecGrpMembObj realised;
		ArrayList<ICFGenKbTSecGrpMembObj> arrayList = new ArrayList<ICFGenKbTSecGrpMembObj>( buffList.length );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
			obj.setBuff( buff );
			realised = (ICFGenKbTSecGrpMembObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	public ICFGenKbTSecGrpMembObj readTSecGrpMembByIdIdx( long TenantId,
		long TSecGrpMembId )
	{
		return( readTSecGrpMembByIdIdx( TenantId,
			TSecGrpMembId,
			false ) );
	}

	public ICFGenKbTSecGrpMembObj readTSecGrpMembByIdIdx( long TenantId,
		long TSecGrpMembId, boolean forceRead )
	{
		CFGenKbTSecGrpMembPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredTSecGrpMembId( TSecGrpMembId );
		ICFGenKbTSecGrpMembObj obj = readTSecGrpMemb( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbTSecGrpMembObj> readTSecGrpMembByTenantIdx( long TenantId )
	{
		return( readTSecGrpMembByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFGenKbTSecGrpMembObj> readTSecGrpMembByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTSecGrpMembByTenantIdx";
		CFGenKbTSecGrpMembByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbTSecGrpMembByTenantIdxKey,
				Map< CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj>();
			ICFGenKbTSecGrpMembObj obj;
			CFGenKbTSecGrpMembBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFGenKbTSecGrpMembBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
				obj.setBuff( buff );
				ICFGenKbTSecGrpMembObj realised = (ICFGenKbTSecGrpMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbTSecGrpMembObj arr[] = new ICFGenKbTSecGrpMembObj[len];
		Iterator<ICFGenKbTSecGrpMembObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbTSecGrpMembObj> arrayList = new ArrayList<ICFGenKbTSecGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbTSecGrpMembObj> cmp = new Comparator<ICFGenKbTSecGrpMembObj>() {
			public int compare( ICFGenKbTSecGrpMembObj lhs, ICFGenKbTSecGrpMembObj rhs ) {
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
					CFGenKbTSecGrpMembPKey lhsPKey = lhs.getPKey();
					CFGenKbTSecGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbTSecGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbTSecGrpMembObj> readTSecGrpMembByGroupIdx( long TenantId,
		int TSecGroupId )
	{
		return( readTSecGrpMembByGroupIdx( TenantId,
			TSecGroupId,
			false ) );
	}

	public List<ICFGenKbTSecGrpMembObj> readTSecGrpMembByGroupIdx( long TenantId,
		int TSecGroupId,
		boolean forceRead )
	{
		final String S_ProcName = "readTSecGrpMembByGroupIdx";
		CFGenKbTSecGrpMembByGroupIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj> dict;
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFGenKbTSecGrpMembByGroupIdxKey,
				Map< CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > >();
		}
		if( ( ! forceRead ) && indexByGroupIdx.containsKey( key ) ) {
			dict = indexByGroupIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj>();
			ICFGenKbTSecGrpMembObj obj;
			CFGenKbTSecGrpMembBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().readDerivedByGroupIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId );
			CFGenKbTSecGrpMembBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
				obj.setBuff( buff );
				ICFGenKbTSecGrpMembObj realised = (ICFGenKbTSecGrpMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGroupIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbTSecGrpMembObj arr[] = new ICFGenKbTSecGrpMembObj[len];
		Iterator<ICFGenKbTSecGrpMembObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbTSecGrpMembObj> arrayList = new ArrayList<ICFGenKbTSecGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbTSecGrpMembObj> cmp = new Comparator<ICFGenKbTSecGrpMembObj>() {
			public int compare( ICFGenKbTSecGrpMembObj lhs, ICFGenKbTSecGrpMembObj rhs ) {
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
					CFGenKbTSecGrpMembPKey lhsPKey = lhs.getPKey();
					CFGenKbTSecGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbTSecGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbTSecGrpMembObj> readTSecGrpMembByUserIdx( UUID SecUserId )
	{
		return( readTSecGrpMembByUserIdx( SecUserId,
			false ) );
	}

	public List<ICFGenKbTSecGrpMembObj> readTSecGrpMembByUserIdx( UUID SecUserId,
		boolean forceRead )
	{
		final String S_ProcName = "readTSecGrpMembByUserIdx";
		CFGenKbTSecGrpMembByUserIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj> dict;
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< CFGenKbTSecGrpMembByUserIdxKey,
				Map< CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > >();
		}
		if( ( ! forceRead ) && indexByUserIdx.containsKey( key ) ) {
			dict = indexByUserIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj>();
			ICFGenKbTSecGrpMembObj obj;
			CFGenKbTSecGrpMembBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().readDerivedByUserIdx( schema.getAuthorization(),
				SecUserId );
			CFGenKbTSecGrpMembBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
				obj.setBuff( buff );
				ICFGenKbTSecGrpMembObj realised = (ICFGenKbTSecGrpMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByUserIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbTSecGrpMembObj arr[] = new ICFGenKbTSecGrpMembObj[len];
		Iterator<ICFGenKbTSecGrpMembObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbTSecGrpMembObj> arrayList = new ArrayList<ICFGenKbTSecGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbTSecGrpMembObj> cmp = new Comparator<ICFGenKbTSecGrpMembObj>() {
			public int compare( ICFGenKbTSecGrpMembObj lhs, ICFGenKbTSecGrpMembObj rhs ) {
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
					CFGenKbTSecGrpMembPKey lhsPKey = lhs.getPKey();
					CFGenKbTSecGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbTSecGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbTSecGrpMembObj readTSecGrpMembByUUserIdx( long TenantId,
		int TSecGroupId,
		UUID SecUserId )
	{
		return( readTSecGrpMembByUUserIdx( TenantId,
			TSecGroupId,
			SecUserId,
			false ) );
	}

	public ICFGenKbTSecGrpMembObj readTSecGrpMembByUUserIdx( long TenantId,
		int TSecGroupId,
		UUID SecUserId, boolean forceRead )
	{
		if( indexByUUserIdx == null ) {
			indexByUUserIdx = new HashMap< CFGenKbTSecGrpMembByUUserIdxKey,
				ICFGenKbTSecGrpMembObj >();
		}
		CFGenKbTSecGrpMembByUUserIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUUserIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredSecUserId( SecUserId );
		ICFGenKbTSecGrpMembObj obj = null;
		if( ( ! forceRead ) && indexByUUserIdx.containsKey( key ) ) {
			obj = indexByUUserIdx.get( key );
		}
		else {
			CFGenKbTSecGrpMembBuff buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().readDerivedByUUserIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId,
				SecUserId );
			if( buff != null ) {
				obj = schema.getTSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
				obj.setBuff( buff );
				obj = (ICFGenKbTSecGrpMembObj)obj.realise();
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
	public List<ICFGenKbTSecGrpMembObj> pageTSecGrpMembByTenantIdx( long TenantId,
		Long priorTenantId,
		Long priorTSecGrpMembId )
	{
		final String S_ProcName = "pageTSecGrpMembByTenantIdx";
		CFGenKbTSecGrpMembByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		List<ICFGenKbTSecGrpMembObj> retList = new LinkedList<ICFGenKbTSecGrpMembObj>();
		ICFGenKbTSecGrpMembObj obj;
		CFGenKbTSecGrpMembBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().pageBuffByTenantIdx( schema.getAuthorization(),
				TenantId,
			priorTenantId,
			priorTSecGrpMembId );
		CFGenKbTSecGrpMembBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getTSecGrpMembTableObj().newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
			obj.setBuff( buff );
			ICFGenKbTSecGrpMembObj realised = (ICFGenKbTSecGrpMembObj)obj.realise();
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
	public List<ICFGenKbTSecGrpMembObj> pageTSecGrpMembByGroupIdx( long TenantId,
		int TSecGroupId,
		Long priorTenantId,
		Long priorTSecGrpMembId )
	{
		final String S_ProcName = "pageTSecGrpMembByGroupIdx";
		CFGenKbTSecGrpMembByGroupIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		List<ICFGenKbTSecGrpMembObj> retList = new LinkedList<ICFGenKbTSecGrpMembObj>();
		ICFGenKbTSecGrpMembObj obj;
		CFGenKbTSecGrpMembBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().pageBuffByGroupIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId,
			priorTenantId,
			priorTSecGrpMembId );
		CFGenKbTSecGrpMembBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getTSecGrpMembTableObj().newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
			obj.setBuff( buff );
			ICFGenKbTSecGrpMembObj realised = (ICFGenKbTSecGrpMembObj)obj.realise();
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
	public List<ICFGenKbTSecGrpMembObj> pageTSecGrpMembByUserIdx( UUID SecUserId,
		Long priorTenantId,
		Long priorTSecGrpMembId )
	{
		final String S_ProcName = "pageTSecGrpMembByUserIdx";
		CFGenKbTSecGrpMembByUserIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		List<ICFGenKbTSecGrpMembObj> retList = new LinkedList<ICFGenKbTSecGrpMembObj>();
		ICFGenKbTSecGrpMembObj obj;
		CFGenKbTSecGrpMembBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().pageBuffByUserIdx( schema.getAuthorization(),
				SecUserId,
			priorTenantId,
			priorTSecGrpMembId );
		CFGenKbTSecGrpMembBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getTSecGrpMembTableObj().newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey() );
			obj.setBuff( buff );
			ICFGenKbTSecGrpMembObj realised = (ICFGenKbTSecGrpMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	public ICFGenKbTSecGrpMembObj updateTSecGrpMemb( ICFGenKbTSecGrpMembObj Obj ) {
		ICFGenKbTSecGrpMembObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().updateTSecGrpMemb( schema.getAuthorization(),
			Obj.getTSecGrpMembBuff() );
		obj = (ICFGenKbTSecGrpMembObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteTSecGrpMemb( ICFGenKbTSecGrpMembObj Obj ) {
		ICFGenKbTSecGrpMembObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().deleteTSecGrpMemb( schema.getAuthorization(),
			obj.getTSecGrpMembBuff() );
		obj.forget( true );
	}

	public void deleteTSecGrpMembByIdIdx( long TenantId,
		long TSecGrpMembId )
	{
		CFGenKbTSecGrpMembPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredTSecGrpMembId( TSecGrpMembId );
		ICFGenKbTSecGrpMembObj obj = readTSecGrpMemb( pkey );
		if( obj != null ) {
			ICFGenKbTSecGrpMembEditObj editObj = (ICFGenKbTSecGrpMembEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbTSecGrpMembEditObj)obj.beginEdit();
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
		CFGenKbTSecGrpMembByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbTSecGrpMembByTenantIdxKey,
				Map< CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj> dict = indexByTenantIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().deleteTSecGrpMembByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFGenKbTSecGrpMembObj> iter = dict.values().iterator();
			ICFGenKbTSecGrpMembObj obj;
			List<ICFGenKbTSecGrpMembObj> toForget = new LinkedList<ICFGenKbTSecGrpMembObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().deleteTSecGrpMembByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTSecGrpMembByGroupIdx( long TenantId,
		int TSecGroupId )
	{
		CFGenKbTSecGrpMembByGroupIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFGenKbTSecGrpMembByGroupIdxKey,
				Map< CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > >();
		}
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj> dict = indexByGroupIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().deleteTSecGrpMembByGroupIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId );
			Iterator<ICFGenKbTSecGrpMembObj> iter = dict.values().iterator();
			ICFGenKbTSecGrpMembObj obj;
			List<ICFGenKbTSecGrpMembObj> toForget = new LinkedList<ICFGenKbTSecGrpMembObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().deleteTSecGrpMembByGroupIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId );
		}
	}

	public void deleteTSecGrpMembByUserIdx( UUID SecUserId )
	{
		CFGenKbTSecGrpMembByUserIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< CFGenKbTSecGrpMembByUserIdxKey,
				Map< CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj > >();
		}
		if( indexByUserIdx.containsKey( key ) ) {
			Map<CFGenKbTSecGrpMembPKey, ICFGenKbTSecGrpMembObj> dict = indexByUserIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().deleteTSecGrpMembByUserIdx( schema.getAuthorization(),
				SecUserId );
			Iterator<ICFGenKbTSecGrpMembObj> iter = dict.values().iterator();
			ICFGenKbTSecGrpMembObj obj;
			List<ICFGenKbTSecGrpMembObj> toForget = new LinkedList<ICFGenKbTSecGrpMembObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().deleteTSecGrpMembByUserIdx( schema.getAuthorization(),
				SecUserId );
		}
	}

	public void deleteTSecGrpMembByUUserIdx( long TenantId,
		int TSecGroupId,
		UUID SecUserId )
	{
		if( indexByUUserIdx == null ) {
			indexByUUserIdx = new HashMap< CFGenKbTSecGrpMembByUUserIdxKey,
				ICFGenKbTSecGrpMembObj >();
		}
		CFGenKbTSecGrpMembByUUserIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newUUserIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredSecUserId( SecUserId );
		ICFGenKbTSecGrpMembObj obj = null;
		if( indexByUUserIdx.containsKey( key ) ) {
			obj = indexByUUserIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().deleteTSecGrpMembByUUserIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId,
				SecUserId );
			obj.forget( true );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().deleteTSecGrpMembByUUserIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId,
				SecUserId );
		}
	}
}
