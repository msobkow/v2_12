// Description: Java 11 Table Object implementation for CFSec.

/*
 *	org.msscf.msscf.CFSec
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

package org.msscf.msscf.cfsec.CFSecObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;

public class CFSecSecGrpMembTableObj
	implements ICFSecSecGrpMembTableObj
{
	protected ICFSecSchemaObj schema;
	private Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj> members;
	private Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj> allSecGrpMemb;
	private Map< CFSecSecGrpMembByClusterIdxKey,
		Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > > indexByClusterIdx;
	private Map< CFSecSecGrpMembByGroupIdxKey,
		Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > > indexByGroupIdx;
	private Map< CFSecSecGrpMembByUserIdxKey,
		Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > > indexByUserIdx;
	private Map< CFSecSecGrpMembByUUserIdxKey,
		ICFSecSecGrpMembObj > indexByUUserIdx;
	public static String TABLE_NAME = "SecGrpMemb";
	public static String TABLE_DBNAME = "secmemb";

	public CFSecSecGrpMembTableObj() {
		schema = null;
		members = new HashMap<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj>();
		allSecGrpMemb = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByUserIdx = null;
		indexByUUserIdx = null;
	}

	public CFSecSecGrpMembTableObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj>();
		allSecGrpMemb = null;
		indexByClusterIdx = null;
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
		allSecGrpMemb = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByUserIdx = null;
		indexByUUserIdx = null;
		List<ICFSecSecGrpMembObj> toForget = new LinkedList<ICFSecSecGrpMembObj>();
		ICFSecSecGrpMembObj cur = null;
		Iterator<ICFSecSecGrpMembObj> iter = members.values().iterator();
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
	 *	CFSecSecGrpMembObj.
	 */
	public ICFSecSecGrpMembObj newInstance() {
		ICFSecSecGrpMembObj inst = new CFSecSecGrpMembObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFSecSecGrpMembObj.
	 */
	public ICFSecSecGrpMembEditObj newEditInstance( ICFSecSecGrpMembObj orig ) {
		ICFSecSecGrpMembEditObj edit = new CFSecSecGrpMembEditObj( orig );
		return( edit );
	}

	public ICFSecSecGrpMembObj realiseSecGrpMemb( ICFSecSecGrpMembObj Obj ) {
		ICFSecSecGrpMembObj obj = Obj;
		CFSecSecGrpMembPKey pkey = obj.getPKey();
		ICFSecSecGrpMembObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFSecSecGrpMembObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFSecSecGrpMembByClusterIdxKey keyClusterIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByGroupIdx != null ) {
				CFSecSecGrpMembByGroupIdxKey keyGroupIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
					if( mapGroupIdx.size() <= 0 ) {
						indexByGroupIdx.remove( keyGroupIdx );
					}
				}
			}

			if( indexByUserIdx != null ) {
				CFSecSecGrpMembByUserIdxKey keyUserIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.remove( keepObj.getPKey() );
					if( mapUserIdx.size() <= 0 ) {
						indexByUserIdx.remove( keyUserIdx );
					}
				}
			}

			if( indexByUUserIdx != null ) {
				CFSecSecGrpMembByUUserIdxKey keyUUserIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUUserIdxKey();
				keyUUserIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUUserIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.remove( keyUUserIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFSecSecGrpMembByClusterIdxKey keyClusterIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFSecSecGrpMembByGroupIdxKey keyGroupIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUserIdx != null ) {
				CFSecSecGrpMembByUserIdxKey keyUserIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUUserIdx != null ) {
				CFSecSecGrpMembByUUserIdxKey keyUUserIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUUserIdxKey();
				keyUUserIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUUserIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.put( keyUUserIdx, keepObj );
			}

			if( allSecGrpMemb != null ) {
				allSecGrpMemb.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecGrpMemb != null ) {
				allSecGrpMemb.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				CFSecSecGrpMembByClusterIdxKey keyClusterIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFSecSecGrpMembByGroupIdxKey keyGroupIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUserIdx != null ) {
				CFSecSecGrpMembByUserIdxKey keyUserIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUUserIdx != null ) {
				CFSecSecGrpMembByUUserIdxKey keyUUserIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUUserIdxKey();
				keyUUserIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUUserIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.put( keyUUserIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetSecGrpMemb( ICFSecSecGrpMembObj Obj ) {
		forgetSecGrpMemb( Obj, false );
	}

	public void forgetSecGrpMemb( ICFSecSecGrpMembObj Obj, boolean forgetSubObjects ) {
		ICFSecSecGrpMembObj obj = Obj;
		CFSecSecGrpMembPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFSecSecGrpMembObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFSecSecGrpMembByClusterIdxKey keyClusterIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByGroupIdx != null ) {
				CFSecSecGrpMembByGroupIdxKey keyGroupIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
					if( mapGroupIdx.size() <= 0 ) {
						indexByGroupIdx.remove( keyGroupIdx );
					}
				}
			}

			if( indexByUserIdx != null ) {
				CFSecSecGrpMembByUserIdxKey keyUserIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.remove( keepObj.getPKey() );
					if( mapUserIdx.size() <= 0 ) {
						indexByUserIdx.remove( keyUserIdx );
					}
				}
			}

			if( indexByUUserIdx != null ) {
				CFSecSecGrpMembByUUserIdxKey keyUUserIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUUserIdxKey();
				keyUUserIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUUserIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.remove( keyUUserIdx );
			}

			if( allSecGrpMemb != null ) {
				allSecGrpMemb.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetSecGrpMembByIdIdx( long ClusterId,
		long SecGrpMembId )
	{
		if( members == null ) {
			return;
		}
		CFSecSecGrpMembPKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGrpMembId( SecGrpMembId );
		if( members.containsKey( key ) ) {
			ICFSecSecGrpMembObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecGrpMembByClusterIdx( long ClusterId )
	{
		if( indexByClusterIdx == null ) {
			return;
		}
		List<ICFSecSecGrpMembObj> toForget = new LinkedList<ICFSecSecGrpMembObj>();
		ICFSecSecGrpMembObj cur = null;
		CFSecSecGrpMembByClusterIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				Iterator<ICFSecSecGrpMembObj> iterDup = mapClusterIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClusterIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecGrpMembObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecGrpMembObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecGrpMembByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		if( indexByGroupIdx == null ) {
			return;
		}
		List<ICFSecSecGrpMembObj> toForget = new LinkedList<ICFSecSecGrpMembObj>();
		ICFSecSecGrpMembObj cur = null;
		CFSecSecGrpMembByGroupIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( key );
			if( mapGroupIdx != null ) {
				Iterator<ICFSecSecGrpMembObj> iterDup = mapGroupIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGroupIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecGrpMembObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecGrpMembObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecGrpMembByUserIdx( UUID SecUserId )
	{
		if( indexByUserIdx == null ) {
			return;
		}
		List<ICFSecSecGrpMembObj> toForget = new LinkedList<ICFSecSecGrpMembObj>();
		ICFSecSecGrpMembObj cur = null;
		CFSecSecGrpMembByUserIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexByUserIdx.containsKey( key ) ) {
			Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > mapUserIdx = indexByUserIdx.get( key );
			if( mapUserIdx != null ) {
				Iterator<ICFSecSecGrpMembObj> iterDup = mapUserIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByUserIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecGrpMembObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecGrpMembObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecGrpMembByUUserIdx( long ClusterId,
		int SecGroupId,
		UUID SecUserId )
	{
		if( indexByUUserIdx == null ) {
			return;
		}
		List<ICFSecSecGrpMembObj> toForget = new LinkedList<ICFSecSecGrpMembObj>();
		ICFSecSecGrpMembObj cur = null;
		CFSecSecGrpMembByUUserIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUUserIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecUserId( SecUserId );
		if( indexByUUserIdx.containsKey( key ) ) {
			cur = indexByUUserIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFSecSecGrpMembObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFSecSecGrpMembObj createSecGrpMemb( ICFSecSecGrpMembObj Obj ) {
		ICFSecSecGrpMembObj obj = Obj;
		CFSecSecGrpMembBuff buff = obj.getSecGrpMembBuff();
		((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().createSecGrpMemb(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFSecSecGrpMembObj readSecGrpMemb( CFSecSecGrpMembPKey pkey ) {
		return( readSecGrpMemb( pkey, false ) );
	}

	public ICFSecSecGrpMembObj readSecGrpMemb( CFSecSecGrpMembPKey pkey, boolean forceRead ) {
		ICFSecSecGrpMembObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFSecSecGrpMembBuff readBuff = ((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredClusterId(),
				pkey.getRequiredSecGrpMembId() );
			if( readBuff != null ) {
				obj = schema.getSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFSecSecGrpMembObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecSecGrpMembObj lockSecGrpMemb( CFSecSecGrpMembPKey pkey ) {
		ICFSecSecGrpMembObj locked = null;
		CFSecSecGrpMembBuff lockBuff = ((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecGrpMembTableObj().newInstance();
			locked.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFSecSecGrpMembObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockSecGrpMemb", pkey );
		}
		return( locked );
	}

	public List<ICFSecSecGrpMembObj> readAllSecGrpMemb() {
		return( readAllSecGrpMemb( false ) );
	}

	public List<ICFSecSecGrpMembObj> readAllSecGrpMemb( boolean forceRead ) {
		final String S_ProcName = "readAllSecGrpMemb";
		if( ( allSecGrpMemb == null ) || forceRead ) {
			Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj> map = new HashMap<CFSecSecGrpMembPKey,ICFSecSecGrpMembObj>();
			allSecGrpMemb = map;
			CFSecSecGrpMembBuff[] buffList = ((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().readAllDerived( schema.getAuthorization() );
			CFSecSecGrpMembBuff buff;
			ICFSecSecGrpMembObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
				obj.setBuff( buff );
				ICFSecSecGrpMembObj realised = (ICFSecSecGrpMembObj)obj.realise();
			}
		}
		int len = allSecGrpMemb.size();
		ICFSecSecGrpMembObj arr[] = new ICFSecSecGrpMembObj[len];
		Iterator<ICFSecSecGrpMembObj> valIter = allSecGrpMemb.values().iterator();
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
		ArrayList<ICFSecSecGrpMembObj> arrayList = new ArrayList<ICFSecSecGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecGrpMembObj> cmp = new Comparator<ICFSecSecGrpMembObj>() {
			public int compare( ICFSecSecGrpMembObj lhs, ICFSecSecGrpMembObj rhs ) {
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
					CFSecSecGrpMembPKey lhsPKey = lhs.getPKey();
					CFSecSecGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Return a sorted map of a page of the SecGrpMemb-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecGrpMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	public List<ICFSecSecGrpMembObj> pageAllSecGrpMemb(Long priorClusterId,
		Long priorSecGrpMembId )
	{
		final String S_ProcName = "pageAllSecGrpMemb";
		Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj> map = new HashMap<CFSecSecGrpMembPKey,ICFSecSecGrpMembObj>();
		CFSecSecGrpMembBuff[] buffList = ((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().pageAllBuff( schema.getAuthorization(),
			priorClusterId,
			priorSecGrpMembId );
		CFSecSecGrpMembBuff buff;
		ICFSecSecGrpMembObj obj;
		ICFSecSecGrpMembObj realised;
		ArrayList<ICFSecSecGrpMembObj> arrayList = new ArrayList<ICFSecSecGrpMembObj>( buffList.length );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = newInstance();
			obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
			obj.setBuff( buff );
			realised = (ICFSecSecGrpMembObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	public ICFSecSecGrpMembObj readSecGrpMembByIdIdx( long ClusterId,
		long SecGrpMembId )
	{
		return( readSecGrpMembByIdIdx( ClusterId,
			SecGrpMembId,
			false ) );
	}

	public ICFSecSecGrpMembObj readSecGrpMembByIdIdx( long ClusterId,
		long SecGrpMembId, boolean forceRead )
	{
		CFSecSecGrpMembPKey pkey = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGrpMembId( SecGrpMembId );
		ICFSecSecGrpMembObj obj = readSecGrpMemb( pkey, forceRead );
		return( obj );
	}

	public List<ICFSecSecGrpMembObj> readSecGrpMembByClusterIdx( long ClusterId )
	{
		return( readSecGrpMembByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFSecSecGrpMembObj> readSecGrpMembByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGrpMembByClusterIdx";
		CFSecSecGrpMembByClusterIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFSecSecGrpMembByClusterIdxKey,
				Map< CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj>();
			ICFSecSecGrpMembObj obj;
			CFSecSecGrpMembBuff[] buffList = ((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFSecSecGrpMembBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
				obj.setBuff( buff );
				ICFSecSecGrpMembObj realised = (ICFSecSecGrpMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusterIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecGrpMembObj arr[] = new ICFSecSecGrpMembObj[len];
		Iterator<ICFSecSecGrpMembObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecGrpMembObj> arrayList = new ArrayList<ICFSecSecGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecGrpMembObj> cmp = new Comparator<ICFSecSecGrpMembObj>() {
			public int compare( ICFSecSecGrpMembObj lhs, ICFSecSecGrpMembObj rhs ) {
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
					CFSecSecGrpMembPKey lhsPKey = lhs.getPKey();
					CFSecSecGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFSecSecGrpMembObj> readSecGrpMembByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		return( readSecGrpMembByGroupIdx( ClusterId,
			SecGroupId,
			false ) );
	}

	public List<ICFSecSecGrpMembObj> readSecGrpMembByGroupIdx( long ClusterId,
		int SecGroupId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGrpMembByGroupIdx";
		CFSecSecGrpMembByGroupIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj> dict;
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFSecSecGrpMembByGroupIdxKey,
				Map< CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > >();
		}
		if( ( ! forceRead ) && indexByGroupIdx.containsKey( key ) ) {
			dict = indexByGroupIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj>();
			ICFSecSecGrpMembObj obj;
			CFSecSecGrpMembBuff[] buffList = ((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().readDerivedByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
			CFSecSecGrpMembBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
				obj.setBuff( buff );
				ICFSecSecGrpMembObj realised = (ICFSecSecGrpMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGroupIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecGrpMembObj arr[] = new ICFSecSecGrpMembObj[len];
		Iterator<ICFSecSecGrpMembObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecGrpMembObj> arrayList = new ArrayList<ICFSecSecGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecGrpMembObj> cmp = new Comparator<ICFSecSecGrpMembObj>() {
			public int compare( ICFSecSecGrpMembObj lhs, ICFSecSecGrpMembObj rhs ) {
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
					CFSecSecGrpMembPKey lhsPKey = lhs.getPKey();
					CFSecSecGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFSecSecGrpMembObj> readSecGrpMembByUserIdx( UUID SecUserId )
	{
		return( readSecGrpMembByUserIdx( SecUserId,
			false ) );
	}

	public List<ICFSecSecGrpMembObj> readSecGrpMembByUserIdx( UUID SecUserId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGrpMembByUserIdx";
		CFSecSecGrpMembByUserIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj> dict;
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< CFSecSecGrpMembByUserIdxKey,
				Map< CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > >();
		}
		if( ( ! forceRead ) && indexByUserIdx.containsKey( key ) ) {
			dict = indexByUserIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj>();
			ICFSecSecGrpMembObj obj;
			CFSecSecGrpMembBuff[] buffList = ((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().readDerivedByUserIdx( schema.getAuthorization(),
				SecUserId );
			CFSecSecGrpMembBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
				obj.setBuff( buff );
				ICFSecSecGrpMembObj realised = (ICFSecSecGrpMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByUserIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecGrpMembObj arr[] = new ICFSecSecGrpMembObj[len];
		Iterator<ICFSecSecGrpMembObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecGrpMembObj> arrayList = new ArrayList<ICFSecSecGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecGrpMembObj> cmp = new Comparator<ICFSecSecGrpMembObj>() {
			public int compare( ICFSecSecGrpMembObj lhs, ICFSecSecGrpMembObj rhs ) {
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
					CFSecSecGrpMembPKey lhsPKey = lhs.getPKey();
					CFSecSecGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecSecGrpMembObj readSecGrpMembByUUserIdx( long ClusterId,
		int SecGroupId,
		UUID SecUserId )
	{
		return( readSecGrpMembByUUserIdx( ClusterId,
			SecGroupId,
			SecUserId,
			false ) );
	}

	public ICFSecSecGrpMembObj readSecGrpMembByUUserIdx( long ClusterId,
		int SecGroupId,
		UUID SecUserId, boolean forceRead )
	{
		if( indexByUUserIdx == null ) {
			indexByUUserIdx = new HashMap< CFSecSecGrpMembByUUserIdxKey,
				ICFSecSecGrpMembObj >();
		}
		CFSecSecGrpMembByUUserIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUUserIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecUserId( SecUserId );
		ICFSecSecGrpMembObj obj = null;
		if( ( ! forceRead ) && indexByUUserIdx.containsKey( key ) ) {
			obj = indexByUUserIdx.get( key );
		}
		else {
			CFSecSecGrpMembBuff buff = ((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().readDerivedByUUserIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				SecUserId );
			if( buff != null ) {
				obj = schema.getSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
				obj.setBuff( buff );
				obj = (ICFSecSecGrpMembObj)obj.realise();
			}
		}
		return( obj );
	}

	/**
	 *	Read a page of data as a List of SecGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	argClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecSecGrpMembObj> pageSecGrpMembByClusterIdx( long ClusterId,
		Long priorClusterId,
		Long priorSecGrpMembId )
	{
		final String S_ProcName = "pageSecGrpMembByClusterIdx";
		CFSecSecGrpMembByClusterIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		List<ICFSecSecGrpMembObj> retList = new LinkedList<ICFSecSecGrpMembObj>();
		ICFSecSecGrpMembObj obj;
		CFSecSecGrpMembBuff[] buffList = ((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().pageBuffByClusterIdx( schema.getAuthorization(),
				ClusterId,
			priorClusterId,
			priorSecGrpMembId );
		CFSecSecGrpMembBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecGrpMembTableObj().newInstance();
			obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
			obj.setBuff( buff );
			ICFSecSecGrpMembObj realised = (ICFSecSecGrpMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate GroupIdx key attributes.
	 *
	 *	@param	argClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecSecGrpMembObj> pageSecGrpMembByGroupIdx( long ClusterId,
		int SecGroupId,
		Long priorClusterId,
		Long priorSecGrpMembId )
	{
		final String S_ProcName = "pageSecGrpMembByGroupIdx";
		CFSecSecGrpMembByGroupIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		List<ICFSecSecGrpMembObj> retList = new LinkedList<ICFSecSecGrpMembObj>();
		ICFSecSecGrpMembObj obj;
		CFSecSecGrpMembBuff[] buffList = ((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().pageBuffByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
			priorClusterId,
			priorSecGrpMembId );
		CFSecSecGrpMembBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecGrpMembTableObj().newInstance();
			obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
			obj.setBuff( buff );
			ICFSecSecGrpMembObj realised = (ICFSecSecGrpMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate UserIdx key attributes.
	 *
	 *	@param	argSecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecSecGrpMembObj> pageSecGrpMembByUserIdx( UUID SecUserId,
		Long priorClusterId,
		Long priorSecGrpMembId )
	{
		final String S_ProcName = "pageSecGrpMembByUserIdx";
		CFSecSecGrpMembByUserIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		List<ICFSecSecGrpMembObj> retList = new LinkedList<ICFSecSecGrpMembObj>();
		ICFSecSecGrpMembObj obj;
		CFSecSecGrpMembBuff[] buffList = ((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().pageBuffByUserIdx( schema.getAuthorization(),
				SecUserId,
			priorClusterId,
			priorSecGrpMembId );
		CFSecSecGrpMembBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecGrpMembTableObj().newInstance();
			obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
			obj.setBuff( buff );
			ICFSecSecGrpMembObj realised = (ICFSecSecGrpMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	public ICFSecSecGrpMembObj updateSecGrpMemb( ICFSecSecGrpMembObj Obj ) {
		ICFSecSecGrpMembObj obj = Obj;
		((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().updateSecGrpMemb( schema.getAuthorization(),
			Obj.getSecGrpMembBuff() );
		obj = (ICFSecSecGrpMembObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteSecGrpMemb( ICFSecSecGrpMembObj Obj ) {
		ICFSecSecGrpMembObj obj = Obj;
		((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().deleteSecGrpMemb( schema.getAuthorization(),
			obj.getSecGrpMembBuff() );
		obj.forget( true );
	}

	public void deleteSecGrpMembByIdIdx( long ClusterId,
		long SecGrpMembId )
	{
		CFSecSecGrpMembPKey pkey = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGrpMembId( SecGrpMembId );
		ICFSecSecGrpMembObj obj = readSecGrpMemb( pkey );
		if( obj != null ) {
			ICFSecSecGrpMembEditObj editObj = (ICFSecSecGrpMembEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFSecSecGrpMembEditObj)obj.beginEdit();
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

	public void deleteSecGrpMembByClusterIdx( long ClusterId )
	{
		CFSecSecGrpMembByClusterIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFSecSecGrpMembByClusterIdxKey,
				Map< CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj> dict = indexByClusterIdx.get( key );
			((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().deleteSecGrpMembByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFSecSecGrpMembObj> iter = dict.values().iterator();
			ICFSecSecGrpMembObj obj;
			List<ICFSecSecGrpMembObj> toForget = new LinkedList<ICFSecSecGrpMembObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByClusterIdx.remove( key );
		}
		else {
			((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().deleteSecGrpMembByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteSecGrpMembByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		CFSecSecGrpMembByGroupIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFSecSecGrpMembByGroupIdxKey,
				Map< CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > >();
		}
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj> dict = indexByGroupIdx.get( key );
			((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().deleteSecGrpMembByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
			Iterator<ICFSecSecGrpMembObj> iter = dict.values().iterator();
			ICFSecSecGrpMembObj obj;
			List<ICFSecSecGrpMembObj> toForget = new LinkedList<ICFSecSecGrpMembObj>();
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
			((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().deleteSecGrpMembByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
		}
	}

	public void deleteSecGrpMembByUserIdx( UUID SecUserId )
	{
		CFSecSecGrpMembByUserIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< CFSecSecGrpMembByUserIdxKey,
				Map< CFSecSecGrpMembPKey, ICFSecSecGrpMembObj > >();
		}
		if( indexByUserIdx.containsKey( key ) ) {
			Map<CFSecSecGrpMembPKey, ICFSecSecGrpMembObj> dict = indexByUserIdx.get( key );
			((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().deleteSecGrpMembByUserIdx( schema.getAuthorization(),
				SecUserId );
			Iterator<ICFSecSecGrpMembObj> iter = dict.values().iterator();
			ICFSecSecGrpMembObj obj;
			List<ICFSecSecGrpMembObj> toForget = new LinkedList<ICFSecSecGrpMembObj>();
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
			((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().deleteSecGrpMembByUserIdx( schema.getAuthorization(),
				SecUserId );
		}
	}

	public void deleteSecGrpMembByUUserIdx( long ClusterId,
		int SecGroupId,
		UUID SecUserId )
	{
		if( indexByUUserIdx == null ) {
			indexByUUserIdx = new HashMap< CFSecSecGrpMembByUUserIdxKey,
				ICFSecSecGrpMembObj >();
		}
		CFSecSecGrpMembByUUserIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUUserIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecUserId( SecUserId );
		ICFSecSecGrpMembObj obj = null;
		if( indexByUUserIdx.containsKey( key ) ) {
			obj = indexByUUserIdx.get( key );
			((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().deleteSecGrpMembByUUserIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				SecUserId );
			obj.forget( true );
		}
		else {
			((ICFSecSchema)schema.getBackingStore()).getTableSecGrpMemb().deleteSecGrpMembByUUserIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				SecUserId );
		}
	}
}
