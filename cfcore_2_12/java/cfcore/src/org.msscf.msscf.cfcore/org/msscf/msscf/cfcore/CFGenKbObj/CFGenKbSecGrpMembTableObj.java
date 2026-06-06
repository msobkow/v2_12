// Description: Java 11 Table Object implementation for CFGenKb.

/*
 *	org.msscf.msscf.CFCore
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

public class CFGenKbSecGrpMembTableObj
	implements ICFGenKbSecGrpMembTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj> members;
	private Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj> allSecGrpMemb;
	private Map< CFGenKbSecGrpMembByClusterIdxKey,
		Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > > indexByClusterIdx;
	private Map< CFGenKbSecGrpMembByGroupIdxKey,
		Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > > indexByGroupIdx;
	private Map< CFGenKbSecGrpMembByUserIdxKey,
		Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > > indexByUserIdx;
	private Map< CFGenKbSecGrpMembByUUserIdxKey,
		ICFGenKbSecGrpMembObj > indexByUUserIdx;
	public static String TABLE_NAME = "SecGrpMemb";
	public static String TABLE_DBNAME = "secmemb";

	public CFGenKbSecGrpMembTableObj() {
		schema = null;
		members = new HashMap<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj>();
		allSecGrpMemb = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByUserIdx = null;
		indexByUUserIdx = null;
	}

	public CFGenKbSecGrpMembTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj>();
		allSecGrpMemb = null;
		indexByClusterIdx = null;
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
		allSecGrpMemb = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByUserIdx = null;
		indexByUUserIdx = null;
		List<ICFGenKbSecGrpMembObj> toForget = new LinkedList<ICFGenKbSecGrpMembObj>();
		ICFGenKbSecGrpMembObj cur = null;
		Iterator<ICFGenKbSecGrpMembObj> iter = members.values().iterator();
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
	 *	CFGenKbSecGrpMembObj.
	 */
	public ICFGenKbSecGrpMembObj newInstance() {
		ICFGenKbSecGrpMembObj inst = new CFGenKbSecGrpMembObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbSecGrpMembObj.
	 */
	public ICFGenKbSecGrpMembEditObj newEditInstance( ICFGenKbSecGrpMembObj orig ) {
		ICFGenKbSecGrpMembEditObj edit = new CFGenKbSecGrpMembEditObj( orig );
		return( edit );
	}

	public ICFGenKbSecGrpMembObj realiseSecGrpMemb( ICFGenKbSecGrpMembObj Obj ) {
		ICFGenKbSecGrpMembObj obj = Obj;
		CFGenKbSecGrpMembPKey pkey = obj.getPKey();
		ICFGenKbSecGrpMembObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbSecGrpMembObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFGenKbSecGrpMembByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByGroupIdx != null ) {
				CFGenKbSecGrpMembByGroupIdxKey keyGroupIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
					if( mapGroupIdx.size() <= 0 ) {
						indexByGroupIdx.remove( keyGroupIdx );
					}
				}
			}

			if( indexByUserIdx != null ) {
				CFGenKbSecGrpMembByUserIdxKey keyUserIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.remove( keepObj.getPKey() );
					if( mapUserIdx.size() <= 0 ) {
						indexByUserIdx.remove( keyUserIdx );
					}
				}
			}

			if( indexByUUserIdx != null ) {
				CFGenKbSecGrpMembByUUserIdxKey keyUUserIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUUserIdxKey();
				keyUUserIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUUserIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.remove( keyUUserIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFGenKbSecGrpMembByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFGenKbSecGrpMembByGroupIdxKey keyGroupIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUserIdx != null ) {
				CFGenKbSecGrpMembByUserIdxKey keyUserIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUUserIdx != null ) {
				CFGenKbSecGrpMembByUUserIdxKey keyUUserIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUUserIdxKey();
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
				CFGenKbSecGrpMembByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFGenKbSecGrpMembByGroupIdxKey keyGroupIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUserIdx != null ) {
				CFGenKbSecGrpMembByUserIdxKey keyUserIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUUserIdx != null ) {
				CFGenKbSecGrpMembByUUserIdxKey keyUUserIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUUserIdxKey();
				keyUUserIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUUserIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUUserIdx.put( keyUUserIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetSecGrpMemb( ICFGenKbSecGrpMembObj Obj ) {
		forgetSecGrpMemb( Obj, false );
	}

	public void forgetSecGrpMemb( ICFGenKbSecGrpMembObj Obj, boolean forgetSubObjects ) {
		ICFGenKbSecGrpMembObj obj = Obj;
		CFGenKbSecGrpMembPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbSecGrpMembObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFGenKbSecGrpMembByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByGroupIdx != null ) {
				CFGenKbSecGrpMembByGroupIdxKey keyGroupIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
					if( mapGroupIdx.size() <= 0 ) {
						indexByGroupIdx.remove( keyGroupIdx );
					}
				}
			}

			if( indexByUserIdx != null ) {
				CFGenKbSecGrpMembByUserIdxKey keyUserIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.remove( keepObj.getPKey() );
					if( mapUserIdx.size() <= 0 ) {
						indexByUserIdx.remove( keyUserIdx );
					}
				}
			}

			if( indexByUUserIdx != null ) {
				CFGenKbSecGrpMembByUUserIdxKey keyUUserIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUUserIdxKey();
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
		CFGenKbSecGrpMembPKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGrpMembId( SecGrpMembId );
		if( members.containsKey( key ) ) {
			ICFGenKbSecGrpMembObj probed = members.get( key );
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
		List<ICFGenKbSecGrpMembObj> toForget = new LinkedList<ICFGenKbSecGrpMembObj>();
		ICFGenKbSecGrpMembObj cur = null;
		CFGenKbSecGrpMembByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				Iterator<ICFGenKbSecGrpMembObj> iterDup = mapClusterIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClusterIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbSecGrpMembObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbSecGrpMembObj> iter = toForget.iterator();
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
		List<ICFGenKbSecGrpMembObj> toForget = new LinkedList<ICFGenKbSecGrpMembObj>();
		ICFGenKbSecGrpMembObj cur = null;
		CFGenKbSecGrpMembByGroupIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > mapGroupIdx = indexByGroupIdx.get( key );
			if( mapGroupIdx != null ) {
				Iterator<ICFGenKbSecGrpMembObj> iterDup = mapGroupIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGroupIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbSecGrpMembObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbSecGrpMembObj> iter = toForget.iterator();
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
		List<ICFGenKbSecGrpMembObj> toForget = new LinkedList<ICFGenKbSecGrpMembObj>();
		ICFGenKbSecGrpMembObj cur = null;
		CFGenKbSecGrpMembByUserIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexByUserIdx.containsKey( key ) ) {
			Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > mapUserIdx = indexByUserIdx.get( key );
			if( mapUserIdx != null ) {
				Iterator<ICFGenKbSecGrpMembObj> iterDup = mapUserIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByUserIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbSecGrpMembObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbSecGrpMembObj> iter = toForget.iterator();
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
		List<ICFGenKbSecGrpMembObj> toForget = new LinkedList<ICFGenKbSecGrpMembObj>();
		ICFGenKbSecGrpMembObj cur = null;
		CFGenKbSecGrpMembByUUserIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUUserIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecUserId( SecUserId );
		if( indexByUUserIdx.containsKey( key ) ) {
			cur = indexByUUserIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFGenKbSecGrpMembObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbSecGrpMembObj createSecGrpMemb( ICFGenKbSecGrpMembObj Obj ) {
		ICFGenKbSecGrpMembObj obj = Obj;
		CFGenKbSecGrpMembBuff buff = obj.getSecGrpMembBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().createSecGrpMemb(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbSecGrpMembObj readSecGrpMemb( CFGenKbSecGrpMembPKey pkey ) {
		return( readSecGrpMemb( pkey, false ) );
	}

	public ICFGenKbSecGrpMembObj readSecGrpMemb( CFGenKbSecGrpMembPKey pkey, boolean forceRead ) {
		ICFGenKbSecGrpMembObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbSecGrpMembBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredClusterId(),
				pkey.getRequiredSecGrpMembId() );
			if( readBuff != null ) {
				obj = schema.getSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbSecGrpMembObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbSecGrpMembObj lockSecGrpMemb( CFGenKbSecGrpMembPKey pkey ) {
		ICFGenKbSecGrpMembObj locked = null;
		CFGenKbSecGrpMembBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecGrpMembTableObj().newInstance();
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbSecGrpMembObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockSecGrpMemb", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbSecGrpMembObj> readAllSecGrpMemb() {
		return( readAllSecGrpMemb( false ) );
	}

	public List<ICFGenKbSecGrpMembObj> readAllSecGrpMemb( boolean forceRead ) {
		final String S_ProcName = "readAllSecGrpMemb";
		if( ( allSecGrpMemb == null ) || forceRead ) {
			Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj> map = new HashMap<CFGenKbSecGrpMembPKey,ICFGenKbSecGrpMembObj>();
			allSecGrpMemb = map;
			CFGenKbSecGrpMembBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().readAllDerived( schema.getAuthorization() );
			CFGenKbSecGrpMembBuff buff;
			ICFGenKbSecGrpMembObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
				obj.setBuff( buff );
				ICFGenKbSecGrpMembObj realised = (ICFGenKbSecGrpMembObj)obj.realise();
			}
		}
		int len = allSecGrpMemb.size();
		ICFGenKbSecGrpMembObj arr[] = new ICFGenKbSecGrpMembObj[len];
		Iterator<ICFGenKbSecGrpMembObj> valIter = allSecGrpMemb.values().iterator();
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
		ArrayList<ICFGenKbSecGrpMembObj> arrayList = new ArrayList<ICFGenKbSecGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbSecGrpMembObj> cmp = new Comparator<ICFGenKbSecGrpMembObj>() {
			public int compare( ICFGenKbSecGrpMembObj lhs, ICFGenKbSecGrpMembObj rhs ) {
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
					CFGenKbSecGrpMembPKey lhsPKey = lhs.getPKey();
					CFGenKbSecGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbSecGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Return a sorted map of a page of the SecGrpMemb-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecGrpMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	public List<ICFGenKbSecGrpMembObj> pageAllSecGrpMemb(Long priorClusterId,
		Long priorSecGrpMembId )
	{
		final String S_ProcName = "pageAllSecGrpMemb";
		Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj> map = new HashMap<CFGenKbSecGrpMembPKey,ICFGenKbSecGrpMembObj>();
		CFGenKbSecGrpMembBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().pageAllBuff( schema.getAuthorization(),
			priorClusterId,
			priorSecGrpMembId );
		CFGenKbSecGrpMembBuff buff;
		ICFGenKbSecGrpMembObj obj;
		ICFGenKbSecGrpMembObj realised;
		ArrayList<ICFGenKbSecGrpMembObj> arrayList = new ArrayList<ICFGenKbSecGrpMembObj>( buffList.length );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
			obj.setBuff( buff );
			realised = (ICFGenKbSecGrpMembObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	public ICFGenKbSecGrpMembObj readSecGrpMembByIdIdx( long ClusterId,
		long SecGrpMembId )
	{
		return( readSecGrpMembByIdIdx( ClusterId,
			SecGrpMembId,
			false ) );
	}

	public ICFGenKbSecGrpMembObj readSecGrpMembByIdIdx( long ClusterId,
		long SecGrpMembId, boolean forceRead )
	{
		CFGenKbSecGrpMembPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGrpMembId( SecGrpMembId );
		ICFGenKbSecGrpMembObj obj = readSecGrpMemb( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbSecGrpMembObj> readSecGrpMembByClusterIdx( long ClusterId )
	{
		return( readSecGrpMembByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFGenKbSecGrpMembObj> readSecGrpMembByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGrpMembByClusterIdx";
		CFGenKbSecGrpMembByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFGenKbSecGrpMembByClusterIdxKey,
				Map< CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj>();
			ICFGenKbSecGrpMembObj obj;
			CFGenKbSecGrpMembBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFGenKbSecGrpMembBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
				obj.setBuff( buff );
				ICFGenKbSecGrpMembObj realised = (ICFGenKbSecGrpMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusterIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbSecGrpMembObj arr[] = new ICFGenKbSecGrpMembObj[len];
		Iterator<ICFGenKbSecGrpMembObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbSecGrpMembObj> arrayList = new ArrayList<ICFGenKbSecGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbSecGrpMembObj> cmp = new Comparator<ICFGenKbSecGrpMembObj>() {
			public int compare( ICFGenKbSecGrpMembObj lhs, ICFGenKbSecGrpMembObj rhs ) {
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
					CFGenKbSecGrpMembPKey lhsPKey = lhs.getPKey();
					CFGenKbSecGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbSecGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbSecGrpMembObj> readSecGrpMembByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		return( readSecGrpMembByGroupIdx( ClusterId,
			SecGroupId,
			false ) );
	}

	public List<ICFGenKbSecGrpMembObj> readSecGrpMembByGroupIdx( long ClusterId,
		int SecGroupId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGrpMembByGroupIdx";
		CFGenKbSecGrpMembByGroupIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj> dict;
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFGenKbSecGrpMembByGroupIdxKey,
				Map< CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > >();
		}
		if( ( ! forceRead ) && indexByGroupIdx.containsKey( key ) ) {
			dict = indexByGroupIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj>();
			ICFGenKbSecGrpMembObj obj;
			CFGenKbSecGrpMembBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().readDerivedByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
			CFGenKbSecGrpMembBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
				obj.setBuff( buff );
				ICFGenKbSecGrpMembObj realised = (ICFGenKbSecGrpMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGroupIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbSecGrpMembObj arr[] = new ICFGenKbSecGrpMembObj[len];
		Iterator<ICFGenKbSecGrpMembObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbSecGrpMembObj> arrayList = new ArrayList<ICFGenKbSecGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbSecGrpMembObj> cmp = new Comparator<ICFGenKbSecGrpMembObj>() {
			public int compare( ICFGenKbSecGrpMembObj lhs, ICFGenKbSecGrpMembObj rhs ) {
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
					CFGenKbSecGrpMembPKey lhsPKey = lhs.getPKey();
					CFGenKbSecGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbSecGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbSecGrpMembObj> readSecGrpMembByUserIdx( UUID SecUserId )
	{
		return( readSecGrpMembByUserIdx( SecUserId,
			false ) );
	}

	public List<ICFGenKbSecGrpMembObj> readSecGrpMembByUserIdx( UUID SecUserId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGrpMembByUserIdx";
		CFGenKbSecGrpMembByUserIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj> dict;
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< CFGenKbSecGrpMembByUserIdxKey,
				Map< CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > >();
		}
		if( ( ! forceRead ) && indexByUserIdx.containsKey( key ) ) {
			dict = indexByUserIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj>();
			ICFGenKbSecGrpMembObj obj;
			CFGenKbSecGrpMembBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().readDerivedByUserIdx( schema.getAuthorization(),
				SecUserId );
			CFGenKbSecGrpMembBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
				obj.setBuff( buff );
				ICFGenKbSecGrpMembObj realised = (ICFGenKbSecGrpMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByUserIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbSecGrpMembObj arr[] = new ICFGenKbSecGrpMembObj[len];
		Iterator<ICFGenKbSecGrpMembObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbSecGrpMembObj> arrayList = new ArrayList<ICFGenKbSecGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbSecGrpMembObj> cmp = new Comparator<ICFGenKbSecGrpMembObj>() {
			public int compare( ICFGenKbSecGrpMembObj lhs, ICFGenKbSecGrpMembObj rhs ) {
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
					CFGenKbSecGrpMembPKey lhsPKey = lhs.getPKey();
					CFGenKbSecGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbSecGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbSecGrpMembObj readSecGrpMembByUUserIdx( long ClusterId,
		int SecGroupId,
		UUID SecUserId )
	{
		return( readSecGrpMembByUUserIdx( ClusterId,
			SecGroupId,
			SecUserId,
			false ) );
	}

	public ICFGenKbSecGrpMembObj readSecGrpMembByUUserIdx( long ClusterId,
		int SecGroupId,
		UUID SecUserId, boolean forceRead )
	{
		if( indexByUUserIdx == null ) {
			indexByUUserIdx = new HashMap< CFGenKbSecGrpMembByUUserIdxKey,
				ICFGenKbSecGrpMembObj >();
		}
		CFGenKbSecGrpMembByUUserIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUUserIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecUserId( SecUserId );
		ICFGenKbSecGrpMembObj obj = null;
		if( ( ! forceRead ) && indexByUUserIdx.containsKey( key ) ) {
			obj = indexByUUserIdx.get( key );
		}
		else {
			CFGenKbSecGrpMembBuff buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().readDerivedByUUserIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				SecUserId );
			if( buff != null ) {
				obj = schema.getSecGrpMembTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
				obj.setBuff( buff );
				obj = (ICFGenKbSecGrpMembObj)obj.realise();
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
	public List<ICFGenKbSecGrpMembObj> pageSecGrpMembByClusterIdx( long ClusterId,
		Long priorClusterId,
		Long priorSecGrpMembId )
	{
		final String S_ProcName = "pageSecGrpMembByClusterIdx";
		CFGenKbSecGrpMembByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		List<ICFGenKbSecGrpMembObj> retList = new LinkedList<ICFGenKbSecGrpMembObj>();
		ICFGenKbSecGrpMembObj obj;
		CFGenKbSecGrpMembBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().pageBuffByClusterIdx( schema.getAuthorization(),
				ClusterId,
			priorClusterId,
			priorSecGrpMembId );
		CFGenKbSecGrpMembBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecGrpMembTableObj().newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
			obj.setBuff( buff );
			ICFGenKbSecGrpMembObj realised = (ICFGenKbSecGrpMembObj)obj.realise();
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
	public List<ICFGenKbSecGrpMembObj> pageSecGrpMembByGroupIdx( long ClusterId,
		int SecGroupId,
		Long priorClusterId,
		Long priorSecGrpMembId )
	{
		final String S_ProcName = "pageSecGrpMembByGroupIdx";
		CFGenKbSecGrpMembByGroupIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		List<ICFGenKbSecGrpMembObj> retList = new LinkedList<ICFGenKbSecGrpMembObj>();
		ICFGenKbSecGrpMembObj obj;
		CFGenKbSecGrpMembBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().pageBuffByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
			priorClusterId,
			priorSecGrpMembId );
		CFGenKbSecGrpMembBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecGrpMembTableObj().newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
			obj.setBuff( buff );
			ICFGenKbSecGrpMembObj realised = (ICFGenKbSecGrpMembObj)obj.realise();
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
	public List<ICFGenKbSecGrpMembObj> pageSecGrpMembByUserIdx( UUID SecUserId,
		Long priorClusterId,
		Long priorSecGrpMembId )
	{
		final String S_ProcName = "pageSecGrpMembByUserIdx";
		CFGenKbSecGrpMembByUserIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		List<ICFGenKbSecGrpMembObj> retList = new LinkedList<ICFGenKbSecGrpMembObj>();
		ICFGenKbSecGrpMembObj obj;
		CFGenKbSecGrpMembBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().pageBuffByUserIdx( schema.getAuthorization(),
				SecUserId,
			priorClusterId,
			priorSecGrpMembId );
		CFGenKbSecGrpMembBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecGrpMembTableObj().newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey() );
			obj.setBuff( buff );
			ICFGenKbSecGrpMembObj realised = (ICFGenKbSecGrpMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	public ICFGenKbSecGrpMembObj updateSecGrpMemb( ICFGenKbSecGrpMembObj Obj ) {
		ICFGenKbSecGrpMembObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().updateSecGrpMemb( schema.getAuthorization(),
			Obj.getSecGrpMembBuff() );
		obj = (ICFGenKbSecGrpMembObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteSecGrpMemb( ICFGenKbSecGrpMembObj Obj ) {
		ICFGenKbSecGrpMembObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().deleteSecGrpMemb( schema.getAuthorization(),
			obj.getSecGrpMembBuff() );
		obj.forget( true );
	}

	public void deleteSecGrpMembByIdIdx( long ClusterId,
		long SecGrpMembId )
	{
		CFGenKbSecGrpMembPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGrpMembId( SecGrpMembId );
		ICFGenKbSecGrpMembObj obj = readSecGrpMemb( pkey );
		if( obj != null ) {
			ICFGenKbSecGrpMembEditObj editObj = (ICFGenKbSecGrpMembEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbSecGrpMembEditObj)obj.beginEdit();
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
		CFGenKbSecGrpMembByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFGenKbSecGrpMembByClusterIdxKey,
				Map< CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj> dict = indexByClusterIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().deleteSecGrpMembByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFGenKbSecGrpMembObj> iter = dict.values().iterator();
			ICFGenKbSecGrpMembObj obj;
			List<ICFGenKbSecGrpMembObj> toForget = new LinkedList<ICFGenKbSecGrpMembObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().deleteSecGrpMembByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteSecGrpMembByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		CFGenKbSecGrpMembByGroupIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFGenKbSecGrpMembByGroupIdxKey,
				Map< CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > >();
		}
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj> dict = indexByGroupIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().deleteSecGrpMembByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
			Iterator<ICFGenKbSecGrpMembObj> iter = dict.values().iterator();
			ICFGenKbSecGrpMembObj obj;
			List<ICFGenKbSecGrpMembObj> toForget = new LinkedList<ICFGenKbSecGrpMembObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().deleteSecGrpMembByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
		}
	}

	public void deleteSecGrpMembByUserIdx( UUID SecUserId )
	{
		CFGenKbSecGrpMembByUserIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< CFGenKbSecGrpMembByUserIdxKey,
				Map< CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj > >();
		}
		if( indexByUserIdx.containsKey( key ) ) {
			Map<CFGenKbSecGrpMembPKey, ICFGenKbSecGrpMembObj> dict = indexByUserIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().deleteSecGrpMembByUserIdx( schema.getAuthorization(),
				SecUserId );
			Iterator<ICFGenKbSecGrpMembObj> iter = dict.values().iterator();
			ICFGenKbSecGrpMembObj obj;
			List<ICFGenKbSecGrpMembObj> toForget = new LinkedList<ICFGenKbSecGrpMembObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().deleteSecGrpMembByUserIdx( schema.getAuthorization(),
				SecUserId );
		}
	}

	public void deleteSecGrpMembByUUserIdx( long ClusterId,
		int SecGroupId,
		UUID SecUserId )
	{
		if( indexByUUserIdx == null ) {
			indexByUUserIdx = new HashMap< CFGenKbSecGrpMembByUUserIdxKey,
				ICFGenKbSecGrpMembObj >();
		}
		CFGenKbSecGrpMembByUUserIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpMemb().newUUserIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecUserId( SecUserId );
		ICFGenKbSecGrpMembObj obj = null;
		if( indexByUUserIdx.containsKey( key ) ) {
			obj = indexByUUserIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().deleteSecGrpMembByUUserIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				SecUserId );
			obj.forget( true );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpMemb().deleteSecGrpMembByUUserIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				SecUserId );
		}
	}
}
