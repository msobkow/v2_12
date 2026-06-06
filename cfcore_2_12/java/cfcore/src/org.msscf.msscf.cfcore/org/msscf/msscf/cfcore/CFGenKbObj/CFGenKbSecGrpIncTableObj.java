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

public class CFGenKbSecGrpIncTableObj
	implements ICFGenKbSecGrpIncTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj> members;
	private Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj> allSecGrpInc;
	private Map< CFGenKbSecGrpIncByClusterIdxKey,
		Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > > indexByClusterIdx;
	private Map< CFGenKbSecGrpIncByGroupIdxKey,
		Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > > indexByGroupIdx;
	private Map< CFGenKbSecGrpIncByIncludeIdxKey,
		Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > > indexByIncludeIdx;
	private Map< CFGenKbSecGrpIncByUIncludeIdxKey,
		ICFGenKbSecGrpIncObj > indexByUIncludeIdx;
	public static String TABLE_NAME = "SecGrpInc";
	public static String TABLE_DBNAME = "secinc";

	public CFGenKbSecGrpIncTableObj() {
		schema = null;
		members = new HashMap<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj>();
		allSecGrpInc = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByIncludeIdx = null;
		indexByUIncludeIdx = null;
	}

	public CFGenKbSecGrpIncTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj>();
		allSecGrpInc = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByIncludeIdx = null;
		indexByUIncludeIdx = null;
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
		allSecGrpInc = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByIncludeIdx = null;
		indexByUIncludeIdx = null;
		List<ICFGenKbSecGrpIncObj> toForget = new LinkedList<ICFGenKbSecGrpIncObj>();
		ICFGenKbSecGrpIncObj cur = null;
		Iterator<ICFGenKbSecGrpIncObj> iter = members.values().iterator();
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
	 *	CFGenKbSecGrpIncObj.
	 */
	public ICFGenKbSecGrpIncObj newInstance() {
		ICFGenKbSecGrpIncObj inst = new CFGenKbSecGrpIncObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbSecGrpIncObj.
	 */
	public ICFGenKbSecGrpIncEditObj newEditInstance( ICFGenKbSecGrpIncObj orig ) {
		ICFGenKbSecGrpIncEditObj edit = new CFGenKbSecGrpIncEditObj( orig );
		return( edit );
	}

	public ICFGenKbSecGrpIncObj realiseSecGrpInc( ICFGenKbSecGrpIncObj Obj ) {
		ICFGenKbSecGrpIncObj obj = Obj;
		CFGenKbSecGrpIncPKey pkey = obj.getPKey();
		ICFGenKbSecGrpIncObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbSecGrpIncObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFGenKbSecGrpIncByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByGroupIdx != null ) {
				CFGenKbSecGrpIncByGroupIdxKey keyGroupIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
					if( mapGroupIdx.size() <= 0 ) {
						indexByGroupIdx.remove( keyGroupIdx );
					}
				}
			}

			if( indexByIncludeIdx != null ) {
				CFGenKbSecGrpIncByIncludeIdxKey keyIncludeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newIncludeIdxKey();
				keyIncludeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > mapIncludeIdx = indexByIncludeIdx.get( keyIncludeIdx );
				if( mapIncludeIdx != null ) {
					mapIncludeIdx.remove( keepObj.getPKey() );
					if( mapIncludeIdx.size() <= 0 ) {
						indexByIncludeIdx.remove( keyIncludeIdx );
					}
				}
			}

			if( indexByUIncludeIdx != null ) {
				CFGenKbSecGrpIncByUIncludeIdxKey keyUIncludeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newUIncludeIdxKey();
				keyUIncludeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUIncludeIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				indexByUIncludeIdx.remove( keyUIncludeIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFGenKbSecGrpIncByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFGenKbSecGrpIncByGroupIdxKey keyGroupIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIncludeIdx != null ) {
				CFGenKbSecGrpIncByIncludeIdxKey keyIncludeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newIncludeIdxKey();
				keyIncludeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > mapIncludeIdx = indexByIncludeIdx.get( keyIncludeIdx );
				if( mapIncludeIdx != null ) {
					mapIncludeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUIncludeIdx != null ) {
				CFGenKbSecGrpIncByUIncludeIdxKey keyUIncludeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newUIncludeIdxKey();
				keyUIncludeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUIncludeIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				indexByUIncludeIdx.put( keyUIncludeIdx, keepObj );
			}

			if( allSecGrpInc != null ) {
				allSecGrpInc.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecGrpInc != null ) {
				allSecGrpInc.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				CFGenKbSecGrpIncByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFGenKbSecGrpIncByGroupIdxKey keyGroupIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIncludeIdx != null ) {
				CFGenKbSecGrpIncByIncludeIdxKey keyIncludeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newIncludeIdxKey();
				keyIncludeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > mapIncludeIdx = indexByIncludeIdx.get( keyIncludeIdx );
				if( mapIncludeIdx != null ) {
					mapIncludeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUIncludeIdx != null ) {
				CFGenKbSecGrpIncByUIncludeIdxKey keyUIncludeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newUIncludeIdxKey();
				keyUIncludeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUIncludeIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				indexByUIncludeIdx.put( keyUIncludeIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetSecGrpInc( ICFGenKbSecGrpIncObj Obj ) {
		forgetSecGrpInc( Obj, false );
	}

	public void forgetSecGrpInc( ICFGenKbSecGrpIncObj Obj, boolean forgetSubObjects ) {
		ICFGenKbSecGrpIncObj obj = Obj;
		CFGenKbSecGrpIncPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbSecGrpIncObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFGenKbSecGrpIncByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByGroupIdx != null ) {
				CFGenKbSecGrpIncByGroupIdxKey keyGroupIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
					if( mapGroupIdx.size() <= 0 ) {
						indexByGroupIdx.remove( keyGroupIdx );
					}
				}
			}

			if( indexByIncludeIdx != null ) {
				CFGenKbSecGrpIncByIncludeIdxKey keyIncludeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newIncludeIdxKey();
				keyIncludeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > mapIncludeIdx = indexByIncludeIdx.get( keyIncludeIdx );
				if( mapIncludeIdx != null ) {
					mapIncludeIdx.remove( keepObj.getPKey() );
					if( mapIncludeIdx.size() <= 0 ) {
						indexByIncludeIdx.remove( keyIncludeIdx );
					}
				}
			}

			if( indexByUIncludeIdx != null ) {
				CFGenKbSecGrpIncByUIncludeIdxKey keyUIncludeIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newUIncludeIdxKey();
				keyUIncludeIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUIncludeIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				indexByUIncludeIdx.remove( keyUIncludeIdx );
			}

			if( allSecGrpInc != null ) {
				allSecGrpInc.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetSecGrpIncByIdIdx( long ClusterId,
		long SecGrpIncId )
	{
		if( members == null ) {
			return;
		}
		CFGenKbSecGrpIncPKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGrpIncId( SecGrpIncId );
		if( members.containsKey( key ) ) {
			ICFGenKbSecGrpIncObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecGrpIncByClusterIdx( long ClusterId )
	{
		if( indexByClusterIdx == null ) {
			return;
		}
		List<ICFGenKbSecGrpIncObj> toForget = new LinkedList<ICFGenKbSecGrpIncObj>();
		ICFGenKbSecGrpIncObj cur = null;
		CFGenKbSecGrpIncByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				Iterator<ICFGenKbSecGrpIncObj> iterDup = mapClusterIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClusterIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbSecGrpIncObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbSecGrpIncObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecGrpIncByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		if( indexByGroupIdx == null ) {
			return;
		}
		List<ICFGenKbSecGrpIncObj> toForget = new LinkedList<ICFGenKbSecGrpIncObj>();
		ICFGenKbSecGrpIncObj cur = null;
		CFGenKbSecGrpIncByGroupIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > mapGroupIdx = indexByGroupIdx.get( key );
			if( mapGroupIdx != null ) {
				Iterator<ICFGenKbSecGrpIncObj> iterDup = mapGroupIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGroupIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbSecGrpIncObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbSecGrpIncObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecGrpIncByIncludeIdx( long ClusterId,
		int IncludeGroupId )
	{
		if( indexByIncludeIdx == null ) {
			return;
		}
		List<ICFGenKbSecGrpIncObj> toForget = new LinkedList<ICFGenKbSecGrpIncObj>();
		ICFGenKbSecGrpIncObj cur = null;
		CFGenKbSecGrpIncByIncludeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newIncludeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		if( indexByIncludeIdx.containsKey( key ) ) {
			Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > mapIncludeIdx = indexByIncludeIdx.get( key );
			if( mapIncludeIdx != null ) {
				Iterator<ICFGenKbSecGrpIncObj> iterDup = mapIncludeIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByIncludeIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbSecGrpIncObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbSecGrpIncObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecGrpIncByUIncludeIdx( long ClusterId,
		int SecGroupId,
		int IncludeGroupId )
	{
		if( indexByUIncludeIdx == null ) {
			return;
		}
		List<ICFGenKbSecGrpIncObj> toForget = new LinkedList<ICFGenKbSecGrpIncObj>();
		ICFGenKbSecGrpIncObj cur = null;
		CFGenKbSecGrpIncByUIncludeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newUIncludeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		if( indexByUIncludeIdx.containsKey( key ) ) {
			cur = indexByUIncludeIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFGenKbSecGrpIncObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbSecGrpIncObj createSecGrpInc( ICFGenKbSecGrpIncObj Obj ) {
		ICFGenKbSecGrpIncObj obj = Obj;
		CFGenKbSecGrpIncBuff buff = obj.getSecGrpIncBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().createSecGrpInc(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbSecGrpIncObj readSecGrpInc( CFGenKbSecGrpIncPKey pkey ) {
		return( readSecGrpInc( pkey, false ) );
	}

	public ICFGenKbSecGrpIncObj readSecGrpInc( CFGenKbSecGrpIncPKey pkey, boolean forceRead ) {
		ICFGenKbSecGrpIncObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbSecGrpIncBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredClusterId(),
				pkey.getRequiredSecGrpIncId() );
			if( readBuff != null ) {
				obj = schema.getSecGrpIncTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbSecGrpIncObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbSecGrpIncObj lockSecGrpInc( CFGenKbSecGrpIncPKey pkey ) {
		ICFGenKbSecGrpIncObj locked = null;
		CFGenKbSecGrpIncBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecGrpIncTableObj().newInstance();
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbSecGrpIncObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockSecGrpInc", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbSecGrpIncObj> readAllSecGrpInc() {
		return( readAllSecGrpInc( false ) );
	}

	public List<ICFGenKbSecGrpIncObj> readAllSecGrpInc( boolean forceRead ) {
		final String S_ProcName = "readAllSecGrpInc";
		if( ( allSecGrpInc == null ) || forceRead ) {
			Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj> map = new HashMap<CFGenKbSecGrpIncPKey,ICFGenKbSecGrpIncObj>();
			allSecGrpInc = map;
			CFGenKbSecGrpIncBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().readAllDerived( schema.getAuthorization() );
			CFGenKbSecGrpIncBuff buff;
			ICFGenKbSecGrpIncObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newPKey() );
				obj.setBuff( buff );
				ICFGenKbSecGrpIncObj realised = (ICFGenKbSecGrpIncObj)obj.realise();
			}
		}
		int len = allSecGrpInc.size();
		ICFGenKbSecGrpIncObj arr[] = new ICFGenKbSecGrpIncObj[len];
		Iterator<ICFGenKbSecGrpIncObj> valIter = allSecGrpInc.values().iterator();
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
		ArrayList<ICFGenKbSecGrpIncObj> arrayList = new ArrayList<ICFGenKbSecGrpIncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbSecGrpIncObj> cmp = new Comparator<ICFGenKbSecGrpIncObj>() {
			public int compare( ICFGenKbSecGrpIncObj lhs, ICFGenKbSecGrpIncObj rhs ) {
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
					CFGenKbSecGrpIncPKey lhsPKey = lhs.getPKey();
					CFGenKbSecGrpIncPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbSecGrpIncObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Return a sorted map of a page of the SecGrpInc-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecGrpIncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	public List<ICFGenKbSecGrpIncObj> pageAllSecGrpInc(Long priorClusterId,
		Long priorSecGrpIncId )
	{
		final String S_ProcName = "pageAllSecGrpInc";
		Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj> map = new HashMap<CFGenKbSecGrpIncPKey,ICFGenKbSecGrpIncObj>();
		CFGenKbSecGrpIncBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().pageAllBuff( schema.getAuthorization(),
			priorClusterId,
			priorSecGrpIncId );
		CFGenKbSecGrpIncBuff buff;
		ICFGenKbSecGrpIncObj obj;
		ICFGenKbSecGrpIncObj realised;
		ArrayList<ICFGenKbSecGrpIncObj> arrayList = new ArrayList<ICFGenKbSecGrpIncObj>( buffList.length );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newPKey() );
			obj.setBuff( buff );
			realised = (ICFGenKbSecGrpIncObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	public ICFGenKbSecGrpIncObj readSecGrpIncByIdIdx( long ClusterId,
		long SecGrpIncId )
	{
		return( readSecGrpIncByIdIdx( ClusterId,
			SecGrpIncId,
			false ) );
	}

	public ICFGenKbSecGrpIncObj readSecGrpIncByIdIdx( long ClusterId,
		long SecGrpIncId, boolean forceRead )
	{
		CFGenKbSecGrpIncPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGrpIncId( SecGrpIncId );
		ICFGenKbSecGrpIncObj obj = readSecGrpInc( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbSecGrpIncObj> readSecGrpIncByClusterIdx( long ClusterId )
	{
		return( readSecGrpIncByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFGenKbSecGrpIncObj> readSecGrpIncByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGrpIncByClusterIdx";
		CFGenKbSecGrpIncByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFGenKbSecGrpIncByClusterIdxKey,
				Map< CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj>();
			ICFGenKbSecGrpIncObj obj;
			CFGenKbSecGrpIncBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFGenKbSecGrpIncBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGrpIncTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newPKey() );
				obj.setBuff( buff );
				ICFGenKbSecGrpIncObj realised = (ICFGenKbSecGrpIncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusterIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbSecGrpIncObj arr[] = new ICFGenKbSecGrpIncObj[len];
		Iterator<ICFGenKbSecGrpIncObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbSecGrpIncObj> arrayList = new ArrayList<ICFGenKbSecGrpIncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbSecGrpIncObj> cmp = new Comparator<ICFGenKbSecGrpIncObj>() {
			public int compare( ICFGenKbSecGrpIncObj lhs, ICFGenKbSecGrpIncObj rhs ) {
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
					CFGenKbSecGrpIncPKey lhsPKey = lhs.getPKey();
					CFGenKbSecGrpIncPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbSecGrpIncObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbSecGrpIncObj> readSecGrpIncByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		return( readSecGrpIncByGroupIdx( ClusterId,
			SecGroupId,
			false ) );
	}

	public List<ICFGenKbSecGrpIncObj> readSecGrpIncByGroupIdx( long ClusterId,
		int SecGroupId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGrpIncByGroupIdx";
		CFGenKbSecGrpIncByGroupIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj> dict;
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFGenKbSecGrpIncByGroupIdxKey,
				Map< CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > >();
		}
		if( ( ! forceRead ) && indexByGroupIdx.containsKey( key ) ) {
			dict = indexByGroupIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj>();
			ICFGenKbSecGrpIncObj obj;
			CFGenKbSecGrpIncBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().readDerivedByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
			CFGenKbSecGrpIncBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGrpIncTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newPKey() );
				obj.setBuff( buff );
				ICFGenKbSecGrpIncObj realised = (ICFGenKbSecGrpIncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGroupIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbSecGrpIncObj arr[] = new ICFGenKbSecGrpIncObj[len];
		Iterator<ICFGenKbSecGrpIncObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbSecGrpIncObj> arrayList = new ArrayList<ICFGenKbSecGrpIncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbSecGrpIncObj> cmp = new Comparator<ICFGenKbSecGrpIncObj>() {
			public int compare( ICFGenKbSecGrpIncObj lhs, ICFGenKbSecGrpIncObj rhs ) {
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
					CFGenKbSecGrpIncPKey lhsPKey = lhs.getPKey();
					CFGenKbSecGrpIncPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbSecGrpIncObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbSecGrpIncObj> readSecGrpIncByIncludeIdx( long ClusterId,
		int IncludeGroupId )
	{
		return( readSecGrpIncByIncludeIdx( ClusterId,
			IncludeGroupId,
			false ) );
	}

	public List<ICFGenKbSecGrpIncObj> readSecGrpIncByIncludeIdx( long ClusterId,
		int IncludeGroupId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGrpIncByIncludeIdx";
		CFGenKbSecGrpIncByIncludeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newIncludeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj> dict;
		if( indexByIncludeIdx == null ) {
			indexByIncludeIdx = new HashMap< CFGenKbSecGrpIncByIncludeIdxKey,
				Map< CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > >();
		}
		if( ( ! forceRead ) && indexByIncludeIdx.containsKey( key ) ) {
			dict = indexByIncludeIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj>();
			ICFGenKbSecGrpIncObj obj;
			CFGenKbSecGrpIncBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().readDerivedByIncludeIdx( schema.getAuthorization(),
				ClusterId,
				IncludeGroupId );
			CFGenKbSecGrpIncBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGrpIncTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newPKey() );
				obj.setBuff( buff );
				ICFGenKbSecGrpIncObj realised = (ICFGenKbSecGrpIncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByIncludeIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbSecGrpIncObj arr[] = new ICFGenKbSecGrpIncObj[len];
		Iterator<ICFGenKbSecGrpIncObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbSecGrpIncObj> arrayList = new ArrayList<ICFGenKbSecGrpIncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbSecGrpIncObj> cmp = new Comparator<ICFGenKbSecGrpIncObj>() {
			public int compare( ICFGenKbSecGrpIncObj lhs, ICFGenKbSecGrpIncObj rhs ) {
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
					CFGenKbSecGrpIncPKey lhsPKey = lhs.getPKey();
					CFGenKbSecGrpIncPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbSecGrpIncObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbSecGrpIncObj readSecGrpIncByUIncludeIdx( long ClusterId,
		int SecGroupId,
		int IncludeGroupId )
	{
		return( readSecGrpIncByUIncludeIdx( ClusterId,
			SecGroupId,
			IncludeGroupId,
			false ) );
	}

	public ICFGenKbSecGrpIncObj readSecGrpIncByUIncludeIdx( long ClusterId,
		int SecGroupId,
		int IncludeGroupId, boolean forceRead )
	{
		if( indexByUIncludeIdx == null ) {
			indexByUIncludeIdx = new HashMap< CFGenKbSecGrpIncByUIncludeIdxKey,
				ICFGenKbSecGrpIncObj >();
		}
		CFGenKbSecGrpIncByUIncludeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newUIncludeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		ICFGenKbSecGrpIncObj obj = null;
		if( ( ! forceRead ) && indexByUIncludeIdx.containsKey( key ) ) {
			obj = indexByUIncludeIdx.get( key );
		}
		else {
			CFGenKbSecGrpIncBuff buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().readDerivedByUIncludeIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				IncludeGroupId );
			if( buff != null ) {
				obj = schema.getSecGrpIncTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newPKey() );
				obj.setBuff( buff );
				obj = (ICFGenKbSecGrpIncObj)obj.realise();
			}
		}
		return( obj );
	}

	/**
	 *	Read a page of data as a List of SecGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFGenKbSecGrpIncObj> pageSecGrpIncByClusterIdx( long ClusterId,
		Long priorClusterId,
		Long priorSecGrpIncId )
	{
		final String S_ProcName = "pageSecGrpIncByClusterIdx";
		CFGenKbSecGrpIncByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		List<ICFGenKbSecGrpIncObj> retList = new LinkedList<ICFGenKbSecGrpIncObj>();
		ICFGenKbSecGrpIncObj obj;
		CFGenKbSecGrpIncBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().pageBuffByClusterIdx( schema.getAuthorization(),
				ClusterId,
			priorClusterId,
			priorSecGrpIncId );
		CFGenKbSecGrpIncBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecGrpIncTableObj().newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newPKey() );
			obj.setBuff( buff );
			ICFGenKbSecGrpIncObj realised = (ICFGenKbSecGrpIncObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate GroupIdx key attributes.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFGenKbSecGrpIncObj> pageSecGrpIncByGroupIdx( long ClusterId,
		int SecGroupId,
		Long priorClusterId,
		Long priorSecGrpIncId )
	{
		final String S_ProcName = "pageSecGrpIncByGroupIdx";
		CFGenKbSecGrpIncByGroupIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		List<ICFGenKbSecGrpIncObj> retList = new LinkedList<ICFGenKbSecGrpIncObj>();
		ICFGenKbSecGrpIncObj obj;
		CFGenKbSecGrpIncBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().pageBuffByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
			priorClusterId,
			priorSecGrpIncId );
		CFGenKbSecGrpIncBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecGrpIncTableObj().newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newPKey() );
			obj.setBuff( buff );
			ICFGenKbSecGrpIncObj realised = (ICFGenKbSecGrpIncObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate IncludeIdx key attributes.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFGenKbSecGrpIncObj> pageSecGrpIncByIncludeIdx( long ClusterId,
		int IncludeGroupId,
		Long priorClusterId,
		Long priorSecGrpIncId )
	{
		final String S_ProcName = "pageSecGrpIncByIncludeIdx";
		CFGenKbSecGrpIncByIncludeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newIncludeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		List<ICFGenKbSecGrpIncObj> retList = new LinkedList<ICFGenKbSecGrpIncObj>();
		ICFGenKbSecGrpIncObj obj;
		CFGenKbSecGrpIncBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().pageBuffByIncludeIdx( schema.getAuthorization(),
				ClusterId,
				IncludeGroupId,
			priorClusterId,
			priorSecGrpIncId );
		CFGenKbSecGrpIncBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecGrpIncTableObj().newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newPKey() );
			obj.setBuff( buff );
			ICFGenKbSecGrpIncObj realised = (ICFGenKbSecGrpIncObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	public ICFGenKbSecGrpIncObj updateSecGrpInc( ICFGenKbSecGrpIncObj Obj ) {
		ICFGenKbSecGrpIncObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().updateSecGrpInc( schema.getAuthorization(),
			Obj.getSecGrpIncBuff() );
		obj = (ICFGenKbSecGrpIncObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteSecGrpInc( ICFGenKbSecGrpIncObj Obj ) {
		ICFGenKbSecGrpIncObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().deleteSecGrpInc( schema.getAuthorization(),
			obj.getSecGrpIncBuff() );
		obj.forget( true );
	}

	public void deleteSecGrpIncByIdIdx( long ClusterId,
		long SecGrpIncId )
	{
		CFGenKbSecGrpIncPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGrpIncId( SecGrpIncId );
		ICFGenKbSecGrpIncObj obj = readSecGrpInc( pkey );
		if( obj != null ) {
			ICFGenKbSecGrpIncEditObj editObj = (ICFGenKbSecGrpIncEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbSecGrpIncEditObj)obj.beginEdit();
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

	public void deleteSecGrpIncByClusterIdx( long ClusterId )
	{
		CFGenKbSecGrpIncByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFGenKbSecGrpIncByClusterIdxKey,
				Map< CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj> dict = indexByClusterIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().deleteSecGrpIncByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFGenKbSecGrpIncObj> iter = dict.values().iterator();
			ICFGenKbSecGrpIncObj obj;
			List<ICFGenKbSecGrpIncObj> toForget = new LinkedList<ICFGenKbSecGrpIncObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().deleteSecGrpIncByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteSecGrpIncByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		CFGenKbSecGrpIncByGroupIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFGenKbSecGrpIncByGroupIdxKey,
				Map< CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > >();
		}
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj> dict = indexByGroupIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().deleteSecGrpIncByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
			Iterator<ICFGenKbSecGrpIncObj> iter = dict.values().iterator();
			ICFGenKbSecGrpIncObj obj;
			List<ICFGenKbSecGrpIncObj> toForget = new LinkedList<ICFGenKbSecGrpIncObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().deleteSecGrpIncByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
		}
	}

	public void deleteSecGrpIncByIncludeIdx( long ClusterId,
		int IncludeGroupId )
	{
		CFGenKbSecGrpIncByIncludeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newIncludeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		if( indexByIncludeIdx == null ) {
			indexByIncludeIdx = new HashMap< CFGenKbSecGrpIncByIncludeIdxKey,
				Map< CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj > >();
		}
		if( indexByIncludeIdx.containsKey( key ) ) {
			Map<CFGenKbSecGrpIncPKey, ICFGenKbSecGrpIncObj> dict = indexByIncludeIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().deleteSecGrpIncByIncludeIdx( schema.getAuthorization(),
				ClusterId,
				IncludeGroupId );
			Iterator<ICFGenKbSecGrpIncObj> iter = dict.values().iterator();
			ICFGenKbSecGrpIncObj obj;
			List<ICFGenKbSecGrpIncObj> toForget = new LinkedList<ICFGenKbSecGrpIncObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByIncludeIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().deleteSecGrpIncByIncludeIdx( schema.getAuthorization(),
				ClusterId,
				IncludeGroupId );
		}
	}

	public void deleteSecGrpIncByUIncludeIdx( long ClusterId,
		int SecGroupId,
		int IncludeGroupId )
	{
		if( indexByUIncludeIdx == null ) {
			indexByUIncludeIdx = new HashMap< CFGenKbSecGrpIncByUIncludeIdxKey,
				ICFGenKbSecGrpIncObj >();
		}
		CFGenKbSecGrpIncByUIncludeIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGrpInc().newUIncludeIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		ICFGenKbSecGrpIncObj obj = null;
		if( indexByUIncludeIdx.containsKey( key ) ) {
			obj = indexByUIncludeIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().deleteSecGrpIncByUIncludeIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				IncludeGroupId );
			obj.forget( true );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGrpInc().deleteSecGrpIncByUIncludeIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				IncludeGroupId );
		}
	}
}
