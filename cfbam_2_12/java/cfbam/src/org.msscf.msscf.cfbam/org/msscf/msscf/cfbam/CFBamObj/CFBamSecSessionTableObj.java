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

public class CFBamSecSessionTableObj
	implements ICFBamSecSessionTableObj
{
	protected ICFSecSchemaObj schema;
	private Map<CFSecSecSessionPKey, ICFSecSecSessionObj> members;
	private Map<CFSecSecSessionPKey, ICFSecSecSessionObj> allSecSession;
	private Map< CFSecSecSessionBySecUserIdxKey,
		Map<CFSecSecSessionPKey, ICFSecSecSessionObj > > indexBySecUserIdx;
	private Map< CFSecSecSessionBySecDevIdxKey,
		Map<CFSecSecSessionPKey, ICFSecSecSessionObj > > indexBySecDevIdx;
	private Map< CFSecSecSessionByStartIdxKey,
		ICFSecSecSessionObj > indexByStartIdx;
	private Map< CFSecSecSessionByFinishIdxKey,
		Map<CFSecSecSessionPKey, ICFSecSecSessionObj > > indexByFinishIdx;
	private Map< CFSecSecSessionBySecProxyIdxKey,
		Map<CFSecSecSessionPKey, ICFSecSecSessionObj > > indexBySecProxyIdx;
	public static String TABLE_NAME = "SecSession";
	public static String TABLE_DBNAME = "secsess";

	public CFBamSecSessionTableObj() {
		schema = null;
		members = new HashMap<CFSecSecSessionPKey, ICFSecSecSessionObj>();
		allSecSession = null;
		indexBySecUserIdx = null;
		indexBySecDevIdx = null;
		indexByStartIdx = null;
		indexByFinishIdx = null;
		indexBySecProxyIdx = null;
	}

	public CFBamSecSessionTableObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFSecSecSessionPKey, ICFSecSecSessionObj>();
		allSecSession = null;
		indexBySecUserIdx = null;
		indexBySecDevIdx = null;
		indexByStartIdx = null;
		indexByFinishIdx = null;
		indexBySecProxyIdx = null;
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
		allSecSession = null;
		indexBySecUserIdx = null;
		indexBySecDevIdx = null;
		indexByStartIdx = null;
		indexByFinishIdx = null;
		indexBySecProxyIdx = null;
		List<ICFSecSecSessionObj> toForget = new LinkedList<ICFSecSecSessionObj>();
		ICFSecSecSessionObj cur = null;
		Iterator<ICFSecSecSessionObj> iter = members.values().iterator();
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
	 *	CFBamSecSessionObj.
	 */
	public ICFSecSecSessionObj newInstance() {
		ICFSecSecSessionObj inst = new CFBamSecSessionObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSecSessionObj.
	 */
	public ICFSecSecSessionEditObj newEditInstance( ICFSecSecSessionObj orig ) {
		ICFSecSecSessionEditObj edit = new CFBamSecSessionEditObj( orig );
		return( edit );
	}

	public ICFSecSecSessionObj realiseSecSession( ICFSecSecSessionObj Obj ) {
		ICFSecSecSessionObj obj = Obj;
		CFSecSecSessionPKey pkey = obj.getPKey();
		ICFSecSecSessionObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFSecSecSessionObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexBySecUserIdx != null ) {
				CFSecSecSessionBySecUserIdxKey keySecUserIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecUserIdxKey();
				keySecUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapSecUserIdx = indexBySecUserIdx.get( keySecUserIdx );
				if( mapSecUserIdx != null ) {
					mapSecUserIdx.remove( keepObj.getPKey() );
					if( mapSecUserIdx.size() <= 0 ) {
						indexBySecUserIdx.remove( keySecUserIdx );
					}
				}
			}

			if( indexBySecDevIdx != null ) {
				CFSecSecSessionBySecDevIdxKey keySecDevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecDevIdxKey();
				keySecDevIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keySecDevIdx.setOptionalSecDevName( keepObj.getOptionalSecDevName() );
				Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapSecDevIdx = indexBySecDevIdx.get( keySecDevIdx );
				if( mapSecDevIdx != null ) {
					mapSecDevIdx.remove( keepObj.getPKey() );
					if( mapSecDevIdx.size() <= 0 ) {
						indexBySecDevIdx.remove( keySecDevIdx );
					}
				}
			}

			if( indexByStartIdx != null ) {
				CFSecSecSessionByStartIdxKey keyStartIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newStartIdxKey();
				keyStartIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyStartIdx.setRequiredStart( keepObj.getRequiredStart() );
				indexByStartIdx.remove( keyStartIdx );
			}

			if( indexByFinishIdx != null ) {
				CFSecSecSessionByFinishIdxKey keyFinishIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newFinishIdxKey();
				keyFinishIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyFinishIdx.setOptionalFinish( keepObj.getOptionalFinish() );
				Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapFinishIdx = indexByFinishIdx.get( keyFinishIdx );
				if( mapFinishIdx != null ) {
					mapFinishIdx.remove( keepObj.getPKey() );
					if( mapFinishIdx.size() <= 0 ) {
						indexByFinishIdx.remove( keyFinishIdx );
					}
				}
			}

			if( indexBySecProxyIdx != null ) {
				CFSecSecSessionBySecProxyIdxKey keySecProxyIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecProxyIdxKey();
				keySecProxyIdx.setOptionalSecProxyId( keepObj.getOptionalSecProxyId() );
				Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapSecProxyIdx = indexBySecProxyIdx.get( keySecProxyIdx );
				if( mapSecProxyIdx != null ) {
					mapSecProxyIdx.remove( keepObj.getPKey() );
					if( mapSecProxyIdx.size() <= 0 ) {
						indexBySecProxyIdx.remove( keySecProxyIdx );
					}
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexBySecUserIdx != null ) {
				CFSecSecSessionBySecUserIdxKey keySecUserIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecUserIdxKey();
				keySecUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapSecUserIdx = indexBySecUserIdx.get( keySecUserIdx );
				if( mapSecUserIdx != null ) {
					mapSecUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySecDevIdx != null ) {
				CFSecSecSessionBySecDevIdxKey keySecDevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecDevIdxKey();
				keySecDevIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keySecDevIdx.setOptionalSecDevName( keepObj.getOptionalSecDevName() );
				Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapSecDevIdx = indexBySecDevIdx.get( keySecDevIdx );
				if( mapSecDevIdx != null ) {
					mapSecDevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByStartIdx != null ) {
				CFSecSecSessionByStartIdxKey keyStartIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newStartIdxKey();
				keyStartIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyStartIdx.setRequiredStart( keepObj.getRequiredStart() );
				indexByStartIdx.put( keyStartIdx, keepObj );
			}

			if( indexByFinishIdx != null ) {
				CFSecSecSessionByFinishIdxKey keyFinishIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newFinishIdxKey();
				keyFinishIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyFinishIdx.setOptionalFinish( keepObj.getOptionalFinish() );
				Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapFinishIdx = indexByFinishIdx.get( keyFinishIdx );
				if( mapFinishIdx != null ) {
					mapFinishIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySecProxyIdx != null ) {
				CFSecSecSessionBySecProxyIdxKey keySecProxyIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecProxyIdxKey();
				keySecProxyIdx.setOptionalSecProxyId( keepObj.getOptionalSecProxyId() );
				Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapSecProxyIdx = indexBySecProxyIdx.get( keySecProxyIdx );
				if( mapSecProxyIdx != null ) {
					mapSecProxyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSecSession != null ) {
				allSecSession.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecSession != null ) {
				allSecSession.put( keepObj.getPKey(), keepObj );
			}

			if( indexBySecUserIdx != null ) {
				CFSecSecSessionBySecUserIdxKey keySecUserIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecUserIdxKey();
				keySecUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapSecUserIdx = indexBySecUserIdx.get( keySecUserIdx );
				if( mapSecUserIdx != null ) {
					mapSecUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySecDevIdx != null ) {
				CFSecSecSessionBySecDevIdxKey keySecDevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecDevIdxKey();
				keySecDevIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keySecDevIdx.setOptionalSecDevName( keepObj.getOptionalSecDevName() );
				Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapSecDevIdx = indexBySecDevIdx.get( keySecDevIdx );
				if( mapSecDevIdx != null ) {
					mapSecDevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByStartIdx != null ) {
				CFSecSecSessionByStartIdxKey keyStartIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newStartIdxKey();
				keyStartIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyStartIdx.setRequiredStart( keepObj.getRequiredStart() );
				indexByStartIdx.put( keyStartIdx, keepObj );
			}

			if( indexByFinishIdx != null ) {
				CFSecSecSessionByFinishIdxKey keyFinishIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newFinishIdxKey();
				keyFinishIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyFinishIdx.setOptionalFinish( keepObj.getOptionalFinish() );
				Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapFinishIdx = indexByFinishIdx.get( keyFinishIdx );
				if( mapFinishIdx != null ) {
					mapFinishIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySecProxyIdx != null ) {
				CFSecSecSessionBySecProxyIdxKey keySecProxyIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecProxyIdxKey();
				keySecProxyIdx.setOptionalSecProxyId( keepObj.getOptionalSecProxyId() );
				Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapSecProxyIdx = indexBySecProxyIdx.get( keySecProxyIdx );
				if( mapSecProxyIdx != null ) {
					mapSecProxyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetSecSession( ICFSecSecSessionObj Obj ) {
		forgetSecSession( Obj, false );
	}

	public void forgetSecSession( ICFSecSecSessionObj Obj, boolean forgetSubObjects ) {
		ICFSecSecSessionObj obj = Obj;
		CFSecSecSessionPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFSecSecSessionObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexBySecUserIdx != null ) {
				CFSecSecSessionBySecUserIdxKey keySecUserIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecUserIdxKey();
				keySecUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapSecUserIdx = indexBySecUserIdx.get( keySecUserIdx );
				if( mapSecUserIdx != null ) {
					mapSecUserIdx.remove( keepObj.getPKey() );
					if( mapSecUserIdx.size() <= 0 ) {
						indexBySecUserIdx.remove( keySecUserIdx );
					}
				}
			}

			if( indexBySecDevIdx != null ) {
				CFSecSecSessionBySecDevIdxKey keySecDevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecDevIdxKey();
				keySecDevIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keySecDevIdx.setOptionalSecDevName( keepObj.getOptionalSecDevName() );
				Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapSecDevIdx = indexBySecDevIdx.get( keySecDevIdx );
				if( mapSecDevIdx != null ) {
					mapSecDevIdx.remove( keepObj.getPKey() );
					if( mapSecDevIdx.size() <= 0 ) {
						indexBySecDevIdx.remove( keySecDevIdx );
					}
				}
			}

			if( indexByStartIdx != null ) {
				CFSecSecSessionByStartIdxKey keyStartIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newStartIdxKey();
				keyStartIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyStartIdx.setRequiredStart( keepObj.getRequiredStart() );
				indexByStartIdx.remove( keyStartIdx );
			}

			if( indexByFinishIdx != null ) {
				CFSecSecSessionByFinishIdxKey keyFinishIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newFinishIdxKey();
				keyFinishIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyFinishIdx.setOptionalFinish( keepObj.getOptionalFinish() );
				Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapFinishIdx = indexByFinishIdx.get( keyFinishIdx );
				if( mapFinishIdx != null ) {
					mapFinishIdx.remove( keepObj.getPKey() );
					if( mapFinishIdx.size() <= 0 ) {
						indexByFinishIdx.remove( keyFinishIdx );
					}
				}
			}

			if( indexBySecProxyIdx != null ) {
				CFSecSecSessionBySecProxyIdxKey keySecProxyIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecProxyIdxKey();
				keySecProxyIdx.setOptionalSecProxyId( keepObj.getOptionalSecProxyId() );
				Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapSecProxyIdx = indexBySecProxyIdx.get( keySecProxyIdx );
				if( mapSecProxyIdx != null ) {
					mapSecProxyIdx.remove( keepObj.getPKey() );
					if( mapSecProxyIdx.size() <= 0 ) {
						indexBySecProxyIdx.remove( keySecProxyIdx );
					}
				}
			}

			if( allSecSession != null ) {
				allSecSession.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetSecSessionByIdIdx( UUID SecSessionId )
	{
		if( members == null ) {
			return;
		}
		CFSecSecSessionPKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newPKey();
		key.setRequiredSecSessionId( SecSessionId );
		if( members.containsKey( key ) ) {
			ICFSecSecSessionObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecSessionBySecUserIdx( UUID SecUserId )
	{
		if( indexBySecUserIdx == null ) {
			return;
		}
		List<ICFSecSecSessionObj> toForget = new LinkedList<ICFSecSecSessionObj>();
		ICFSecSecSessionObj cur = null;
		CFSecSecSessionBySecUserIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexBySecUserIdx.containsKey( key ) ) {
			Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapSecUserIdx = indexBySecUserIdx.get( key );
			if( mapSecUserIdx != null ) {
				Iterator<ICFSecSecSessionObj> iterDup = mapSecUserIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexBySecUserIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecSessionObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecSessionObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecSessionBySecDevIdx( UUID SecUserId,
		String SecDevName )
	{
		if( indexBySecDevIdx == null ) {
			return;
		}
		List<ICFSecSecSessionObj> toForget = new LinkedList<ICFSecSecSessionObj>();
		ICFSecSecSessionObj cur = null;
		CFSecSecSessionBySecDevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecDevIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalSecDevName( SecDevName );
		if( indexBySecDevIdx.containsKey( key ) ) {
			Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapSecDevIdx = indexBySecDevIdx.get( key );
			if( mapSecDevIdx != null ) {
				Iterator<ICFSecSecSessionObj> iterDup = mapSecDevIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexBySecDevIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecSessionObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecSessionObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecSessionByStartIdx( UUID SecUserId,
		Calendar Start )
	{
		if( indexByStartIdx == null ) {
			return;
		}
		List<ICFSecSecSessionObj> toForget = new LinkedList<ICFSecSecSessionObj>();
		ICFSecSecSessionObj cur = null;
		CFSecSecSessionByStartIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newStartIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredStart( Start );
		if( indexByStartIdx.containsKey( key ) ) {
			cur = indexByStartIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFSecSecSessionObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecSessionByFinishIdx( UUID SecUserId,
		Calendar Finish )
	{
		if( indexByFinishIdx == null ) {
			return;
		}
		List<ICFSecSecSessionObj> toForget = new LinkedList<ICFSecSecSessionObj>();
		ICFSecSecSessionObj cur = null;
		CFSecSecSessionByFinishIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newFinishIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalFinish( Finish );
		if( indexByFinishIdx.containsKey( key ) ) {
			Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapFinishIdx = indexByFinishIdx.get( key );
			if( mapFinishIdx != null ) {
				Iterator<ICFSecSecSessionObj> iterDup = mapFinishIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByFinishIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecSessionObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecSessionObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecSessionBySecProxyIdx( UUID SecProxyId )
	{
		if( indexBySecProxyIdx == null ) {
			return;
		}
		List<ICFSecSecSessionObj> toForget = new LinkedList<ICFSecSecSessionObj>();
		ICFSecSecSessionObj cur = null;
		CFSecSecSessionBySecProxyIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecProxyIdxKey();
		key.setOptionalSecProxyId( SecProxyId );
		if( indexBySecProxyIdx.containsKey( key ) ) {
			Map<CFSecSecSessionPKey, ICFSecSecSessionObj > mapSecProxyIdx = indexBySecProxyIdx.get( key );
			if( mapSecProxyIdx != null ) {
				Iterator<ICFSecSecSessionObj> iterDup = mapSecProxyIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexBySecProxyIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecSessionObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecSessionObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFSecSecSessionObj createSecSession( ICFSecSecSessionObj Obj ) {
		ICFSecSecSessionObj obj = Obj;
		CFSecSecSessionBuff buff = obj.getSecSessionBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableSecSession().createSecSession(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFSecSecSessionObj readSecSession( CFSecSecSessionPKey pkey ) {
		return( readSecSession( pkey, false ) );
	}

	public ICFSecSecSessionObj readSecSession( CFSecSecSessionPKey pkey, boolean forceRead ) {
		ICFSecSecSessionObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFSecSecSessionBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableSecSession().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredSecSessionId() );
			if( readBuff != null ) {
				obj = schema.getSecSessionTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFSecSecSessionObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecSecSessionObj lockSecSession( CFSecSecSessionPKey pkey ) {
		ICFSecSecSessionObj locked = null;
		CFSecSecSessionBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableSecSession().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecSessionTableObj().newInstance();
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFSecSecSessionObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockSecSession", pkey );
		}
		return( locked );
	}

	public List<ICFSecSecSessionObj> readAllSecSession() {
		return( readAllSecSession( false ) );
	}

	public List<ICFSecSecSessionObj> readAllSecSession( boolean forceRead ) {
		final String S_ProcName = "readAllSecSession";
		if( ( allSecSession == null ) || forceRead ) {
			Map<CFSecSecSessionPKey, ICFSecSecSessionObj> map = new HashMap<CFSecSecSessionPKey,ICFSecSecSessionObj>();
			allSecSession = map;
			CFSecSecSessionBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecSession().readAllDerived( schema.getAuthorization() );
			CFSecSecSessionBuff buff;
			ICFSecSecSessionObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newPKey() );
				obj.setBuff( buff );
				ICFSecSecSessionObj realised = (ICFSecSecSessionObj)obj.realise();
			}
		}
		int len = allSecSession.size();
		ICFSecSecSessionObj arr[] = new ICFSecSecSessionObj[len];
		Iterator<ICFSecSecSessionObj> valIter = allSecSession.values().iterator();
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
		ArrayList<ICFSecSecSessionObj> arrayList = new ArrayList<ICFSecSecSessionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecSessionObj> cmp = new Comparator<ICFSecSecSessionObj>() {
			public int compare( ICFSecSecSessionObj lhs, ICFSecSecSessionObj rhs ) {
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
					CFSecSecSessionPKey lhsPKey = lhs.getPKey();
					CFSecSecSessionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecSessionObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Return a sorted map of a page of the SecSession-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecSessionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	public List<ICFSecSecSessionObj> pageAllSecSession(UUID priorSecSessionId )
	{
		final String S_ProcName = "pageAllSecSession";
		Map<CFSecSecSessionPKey, ICFSecSecSessionObj> map = new HashMap<CFSecSecSessionPKey,ICFSecSecSessionObj>();
		CFSecSecSessionBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecSession().pageAllBuff( schema.getAuthorization(),
			priorSecSessionId );
		CFSecSecSessionBuff buff;
		ICFSecSecSessionObj obj;
		ICFSecSecSessionObj realised;
		ArrayList<ICFSecSecSessionObj> arrayList = new ArrayList<ICFSecSecSessionObj>( buffList.length );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newPKey() );
			obj.setBuff( buff );
			realised = (ICFSecSecSessionObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	public ICFSecSecSessionObj readSecSessionByIdIdx( UUID SecSessionId )
	{
		return( readSecSessionByIdIdx( SecSessionId,
			false ) );
	}

	public ICFSecSecSessionObj readSecSessionByIdIdx( UUID SecSessionId, boolean forceRead )
	{
		CFSecSecSessionPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newPKey();
		pkey.setRequiredSecSessionId( SecSessionId );
		ICFSecSecSessionObj obj = readSecSession( pkey, forceRead );
		return( obj );
	}

	public List<ICFSecSecSessionObj> readSecSessionBySecUserIdx( UUID SecUserId )
	{
		return( readSecSessionBySecUserIdx( SecUserId,
			false ) );
	}

	public List<ICFSecSecSessionObj> readSecSessionBySecUserIdx( UUID SecUserId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecSessionBySecUserIdx";
		CFSecSecSessionBySecUserIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		Map<CFSecSecSessionPKey, ICFSecSecSessionObj> dict;
		if( indexBySecUserIdx == null ) {
			indexBySecUserIdx = new HashMap< CFSecSecSessionBySecUserIdxKey,
				Map< CFSecSecSessionPKey, ICFSecSecSessionObj > >();
		}
		if( ( ! forceRead ) && indexBySecUserIdx.containsKey( key ) ) {
			dict = indexBySecUserIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecSessionPKey, ICFSecSecSessionObj>();
			ICFSecSecSessionObj obj;
			CFSecSecSessionBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecSession().readDerivedBySecUserIdx( schema.getAuthorization(),
				SecUserId );
			CFSecSecSessionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecSessionTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newPKey() );
				obj.setBuff( buff );
				ICFSecSecSessionObj realised = (ICFSecSecSessionObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySecUserIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecSessionObj arr[] = new ICFSecSecSessionObj[len];
		Iterator<ICFSecSecSessionObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecSessionObj> arrayList = new ArrayList<ICFSecSecSessionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecSessionObj> cmp = new Comparator<ICFSecSecSessionObj>() {
			public int compare( ICFSecSecSessionObj lhs, ICFSecSecSessionObj rhs ) {
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
					CFSecSecSessionPKey lhsPKey = lhs.getPKey();
					CFSecSecSessionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecSessionObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFSecSecSessionObj> readSecSessionBySecDevIdx( UUID SecUserId,
		String SecDevName )
	{
		return( readSecSessionBySecDevIdx( SecUserId,
			SecDevName,
			false ) );
	}

	public List<ICFSecSecSessionObj> readSecSessionBySecDevIdx( UUID SecUserId,
		String SecDevName,
		boolean forceRead )
	{
		final String S_ProcName = "readSecSessionBySecDevIdx";
		CFSecSecSessionBySecDevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecDevIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalSecDevName( SecDevName );
		Map<CFSecSecSessionPKey, ICFSecSecSessionObj> dict;
		if( indexBySecDevIdx == null ) {
			indexBySecDevIdx = new HashMap< CFSecSecSessionBySecDevIdxKey,
				Map< CFSecSecSessionPKey, ICFSecSecSessionObj > >();
		}
		if( ( ! forceRead ) && indexBySecDevIdx.containsKey( key ) ) {
			dict = indexBySecDevIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecSessionPKey, ICFSecSecSessionObj>();
			ICFSecSecSessionObj obj;
			CFSecSecSessionBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecSession().readDerivedBySecDevIdx( schema.getAuthorization(),
				SecUserId,
				SecDevName );
			CFSecSecSessionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecSessionTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newPKey() );
				obj.setBuff( buff );
				ICFSecSecSessionObj realised = (ICFSecSecSessionObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySecDevIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecSessionObj arr[] = new ICFSecSecSessionObj[len];
		Iterator<ICFSecSecSessionObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecSessionObj> arrayList = new ArrayList<ICFSecSecSessionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecSessionObj> cmp = new Comparator<ICFSecSecSessionObj>() {
			public int compare( ICFSecSecSessionObj lhs, ICFSecSecSessionObj rhs ) {
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
					CFSecSecSessionPKey lhsPKey = lhs.getPKey();
					CFSecSecSessionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecSessionObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecSecSessionObj readSecSessionByStartIdx( UUID SecUserId,
		Calendar Start )
	{
		return( readSecSessionByStartIdx( SecUserId,
			Start,
			false ) );
	}

	public ICFSecSecSessionObj readSecSessionByStartIdx( UUID SecUserId,
		Calendar Start, boolean forceRead )
	{
		if( indexByStartIdx == null ) {
			indexByStartIdx = new HashMap< CFSecSecSessionByStartIdxKey,
				ICFSecSecSessionObj >();
		}
		CFSecSecSessionByStartIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newStartIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredStart( Start );
		ICFSecSecSessionObj obj = null;
		if( ( ! forceRead ) && indexByStartIdx.containsKey( key ) ) {
			obj = indexByStartIdx.get( key );
		}
		else {
			CFSecSecSessionBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableSecSession().readDerivedByStartIdx( schema.getAuthorization(),
				SecUserId,
				Start );
			if( buff != null ) {
				obj = schema.getSecSessionTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newPKey() );
				obj.setBuff( buff );
				obj = (ICFSecSecSessionObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFSecSecSessionObj> readSecSessionByFinishIdx( UUID SecUserId,
		Calendar Finish )
	{
		return( readSecSessionByFinishIdx( SecUserId,
			Finish,
			false ) );
	}

	public List<ICFSecSecSessionObj> readSecSessionByFinishIdx( UUID SecUserId,
		Calendar Finish,
		boolean forceRead )
	{
		final String S_ProcName = "readSecSessionByFinishIdx";
		CFSecSecSessionByFinishIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newFinishIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalFinish( Finish );
		Map<CFSecSecSessionPKey, ICFSecSecSessionObj> dict;
		if( indexByFinishIdx == null ) {
			indexByFinishIdx = new HashMap< CFSecSecSessionByFinishIdxKey,
				Map< CFSecSecSessionPKey, ICFSecSecSessionObj > >();
		}
		if( ( ! forceRead ) && indexByFinishIdx.containsKey( key ) ) {
			dict = indexByFinishIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecSessionPKey, ICFSecSecSessionObj>();
			ICFSecSecSessionObj obj;
			CFSecSecSessionBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecSession().readDerivedByFinishIdx( schema.getAuthorization(),
				SecUserId,
				Finish );
			CFSecSecSessionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecSessionTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newPKey() );
				obj.setBuff( buff );
				ICFSecSecSessionObj realised = (ICFSecSecSessionObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByFinishIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecSessionObj arr[] = new ICFSecSecSessionObj[len];
		Iterator<ICFSecSecSessionObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecSessionObj> arrayList = new ArrayList<ICFSecSecSessionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecSessionObj> cmp = new Comparator<ICFSecSecSessionObj>() {
			public int compare( ICFSecSecSessionObj lhs, ICFSecSecSessionObj rhs ) {
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
					CFSecSecSessionPKey lhsPKey = lhs.getPKey();
					CFSecSecSessionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecSessionObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFSecSecSessionObj> readSecSessionBySecProxyIdx( UUID SecProxyId )
	{
		return( readSecSessionBySecProxyIdx( SecProxyId,
			false ) );
	}

	public List<ICFSecSecSessionObj> readSecSessionBySecProxyIdx( UUID SecProxyId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecSessionBySecProxyIdx";
		CFSecSecSessionBySecProxyIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecProxyIdxKey();
		key.setOptionalSecProxyId( SecProxyId );
		Map<CFSecSecSessionPKey, ICFSecSecSessionObj> dict;
		if( indexBySecProxyIdx == null ) {
			indexBySecProxyIdx = new HashMap< CFSecSecSessionBySecProxyIdxKey,
				Map< CFSecSecSessionPKey, ICFSecSecSessionObj > >();
		}
		if( ( ! forceRead ) && indexBySecProxyIdx.containsKey( key ) ) {
			dict = indexBySecProxyIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecSessionPKey, ICFSecSecSessionObj>();
			ICFSecSecSessionObj obj;
			CFSecSecSessionBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecSession().readDerivedBySecProxyIdx( schema.getAuthorization(),
				SecProxyId );
			CFSecSecSessionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecSessionTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newPKey() );
				obj.setBuff( buff );
				ICFSecSecSessionObj realised = (ICFSecSecSessionObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySecProxyIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecSessionObj arr[] = new ICFSecSecSessionObj[len];
		Iterator<ICFSecSecSessionObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecSessionObj> arrayList = new ArrayList<ICFSecSecSessionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecSessionObj> cmp = new Comparator<ICFSecSecSessionObj>() {
			public int compare( ICFSecSecSessionObj lhs, ICFSecSecSessionObj rhs ) {
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
					CFSecSecSessionPKey lhsPKey = lhs.getPKey();
					CFSecSecSessionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecSessionObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Read a page of data as a List of SecSession-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SecUserIdx key attributes.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSession-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecSecSessionObj> pageSecSessionBySecUserIdx( UUID SecUserId,
		UUID priorSecSessionId )
	{
		final String S_ProcName = "pageSecSessionBySecUserIdx";
		CFSecSecSessionBySecUserIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		List<ICFSecSecSessionObj> retList = new LinkedList<ICFSecSecSessionObj>();
		ICFSecSecSessionObj obj;
		CFSecSecSessionBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecSession().pageBuffBySecUserIdx( schema.getAuthorization(),
				SecUserId,
			priorSecSessionId );
		CFSecSecSessionBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecSessionTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newPKey() );
			obj.setBuff( buff );
			ICFSecSecSessionObj realised = (ICFSecSecSessionObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecSession-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SecDevIdx key attributes.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	argSecDevName	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSession-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecSecSessionObj> pageSecSessionBySecDevIdx( UUID SecUserId,
		String SecDevName,
		UUID priorSecSessionId )
	{
		final String S_ProcName = "pageSecSessionBySecDevIdx";
		CFSecSecSessionBySecDevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecDevIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalSecDevName( SecDevName );
		List<ICFSecSecSessionObj> retList = new LinkedList<ICFSecSecSessionObj>();
		ICFSecSecSessionObj obj;
		CFSecSecSessionBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecSession().pageBuffBySecDevIdx( schema.getAuthorization(),
				SecUserId,
				SecDevName,
			priorSecSessionId );
		CFSecSecSessionBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecSessionTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newPKey() );
			obj.setBuff( buff );
			ICFSecSecSessionObj realised = (ICFSecSecSessionObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecSession-derived instances sorted by their primary keys,
	 *	as identified by the duplicate FinishIdx key attributes.
	 *
	 *	@param	argSecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	argFinish	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSession-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecSecSessionObj> pageSecSessionByFinishIdx( UUID SecUserId,
		Calendar Finish,
		UUID priorSecSessionId )
	{
		final String S_ProcName = "pageSecSessionByFinishIdx";
		CFSecSecSessionByFinishIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newFinishIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalFinish( Finish );
		List<ICFSecSecSessionObj> retList = new LinkedList<ICFSecSecSessionObj>();
		ICFSecSecSessionObj obj;
		CFSecSecSessionBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecSession().pageBuffByFinishIdx( schema.getAuthorization(),
				SecUserId,
				Finish,
			priorSecSessionId );
		CFSecSecSessionBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecSessionTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newPKey() );
			obj.setBuff( buff );
			ICFSecSecSessionObj realised = (ICFSecSecSessionObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecSession-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SecProxyIdx key attributes.
	 *
	 *	@param	argSecProxyId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSession-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecSecSessionObj> pageSecSessionBySecProxyIdx( UUID SecProxyId,
		UUID priorSecSessionId )
	{
		final String S_ProcName = "pageSecSessionBySecProxyIdx";
		CFSecSecSessionBySecProxyIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecProxyIdxKey();
		key.setOptionalSecProxyId( SecProxyId );
		List<ICFSecSecSessionObj> retList = new LinkedList<ICFSecSecSessionObj>();
		ICFSecSecSessionObj obj;
		CFSecSecSessionBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecSession().pageBuffBySecProxyIdx( schema.getAuthorization(),
				SecProxyId,
			priorSecSessionId );
		CFSecSecSessionBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecSessionTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newPKey() );
			obj.setBuff( buff );
			ICFSecSecSessionObj realised = (ICFSecSecSessionObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	public ICFSecSecSessionObj updateSecSession( ICFSecSecSessionObj Obj ) {
		ICFSecSecSessionObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableSecSession().updateSecSession( schema.getAuthorization(),
			Obj.getSecSessionBuff() );
		obj = (ICFSecSecSessionObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteSecSession( ICFSecSecSessionObj Obj ) {
		ICFSecSecSessionObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableSecSession().deleteSecSession( schema.getAuthorization(),
			obj.getSecSessionBuff() );
		obj.forget( true );
	}

	public void deleteSecSessionByIdIdx( UUID SecSessionId )
	{
		CFSecSecSessionPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newPKey();
		pkey.setRequiredSecSessionId( SecSessionId );
		ICFSecSecSessionObj obj = readSecSession( pkey );
		if( obj != null ) {
			ICFSecSecSessionEditObj editObj = (ICFSecSecSessionEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFSecSecSessionEditObj)obj.beginEdit();
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

	public void deleteSecSessionBySecUserIdx( UUID SecUserId )
	{
		CFSecSecSessionBySecUserIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexBySecUserIdx == null ) {
			indexBySecUserIdx = new HashMap< CFSecSecSessionBySecUserIdxKey,
				Map< CFSecSecSessionPKey, ICFSecSecSessionObj > >();
		}
		if( indexBySecUserIdx.containsKey( key ) ) {
			Map<CFSecSecSessionPKey, ICFSecSecSessionObj> dict = indexBySecUserIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSecSession().deleteSecSessionBySecUserIdx( schema.getAuthorization(),
				SecUserId );
			Iterator<ICFSecSecSessionObj> iter = dict.values().iterator();
			ICFSecSecSessionObj obj;
			List<ICFSecSecSessionObj> toForget = new LinkedList<ICFSecSecSessionObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexBySecUserIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSecSession().deleteSecSessionBySecUserIdx( schema.getAuthorization(),
				SecUserId );
		}
	}

	public void deleteSecSessionBySecDevIdx( UUID SecUserId,
		String SecDevName )
	{
		CFSecSecSessionBySecDevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecDevIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalSecDevName( SecDevName );
		if( indexBySecDevIdx == null ) {
			indexBySecDevIdx = new HashMap< CFSecSecSessionBySecDevIdxKey,
				Map< CFSecSecSessionPKey, ICFSecSecSessionObj > >();
		}
		if( indexBySecDevIdx.containsKey( key ) ) {
			Map<CFSecSecSessionPKey, ICFSecSecSessionObj> dict = indexBySecDevIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSecSession().deleteSecSessionBySecDevIdx( schema.getAuthorization(),
				SecUserId,
				SecDevName );
			Iterator<ICFSecSecSessionObj> iter = dict.values().iterator();
			ICFSecSecSessionObj obj;
			List<ICFSecSecSessionObj> toForget = new LinkedList<ICFSecSecSessionObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexBySecDevIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSecSession().deleteSecSessionBySecDevIdx( schema.getAuthorization(),
				SecUserId,
				SecDevName );
		}
	}

	public void deleteSecSessionByStartIdx( UUID SecUserId,
		Calendar Start )
	{
		if( indexByStartIdx == null ) {
			indexByStartIdx = new HashMap< CFSecSecSessionByStartIdxKey,
				ICFSecSecSessionObj >();
		}
		CFSecSecSessionByStartIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newStartIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredStart( Start );
		ICFSecSecSessionObj obj = null;
		if( indexByStartIdx.containsKey( key ) ) {
			obj = indexByStartIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSecSession().deleteSecSessionByStartIdx( schema.getAuthorization(),
				SecUserId,
				Start );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSecSession().deleteSecSessionByStartIdx( schema.getAuthorization(),
				SecUserId,
				Start );
		}
	}

	public void deleteSecSessionByFinishIdx( UUID SecUserId,
		Calendar Finish )
	{
		CFSecSecSessionByFinishIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newFinishIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalFinish( Finish );
		if( indexByFinishIdx == null ) {
			indexByFinishIdx = new HashMap< CFSecSecSessionByFinishIdxKey,
				Map< CFSecSecSessionPKey, ICFSecSecSessionObj > >();
		}
		if( indexByFinishIdx.containsKey( key ) ) {
			Map<CFSecSecSessionPKey, ICFSecSecSessionObj> dict = indexByFinishIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSecSession().deleteSecSessionByFinishIdx( schema.getAuthorization(),
				SecUserId,
				Finish );
			Iterator<ICFSecSecSessionObj> iter = dict.values().iterator();
			ICFSecSecSessionObj obj;
			List<ICFSecSecSessionObj> toForget = new LinkedList<ICFSecSecSessionObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByFinishIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSecSession().deleteSecSessionByFinishIdx( schema.getAuthorization(),
				SecUserId,
				Finish );
		}
	}

	public void deleteSecSessionBySecProxyIdx( UUID SecProxyId )
	{
		CFSecSecSessionBySecProxyIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecSession().newSecProxyIdxKey();
		key.setOptionalSecProxyId( SecProxyId );
		if( indexBySecProxyIdx == null ) {
			indexBySecProxyIdx = new HashMap< CFSecSecSessionBySecProxyIdxKey,
				Map< CFSecSecSessionPKey, ICFSecSecSessionObj > >();
		}
		if( indexBySecProxyIdx.containsKey( key ) ) {
			Map<CFSecSecSessionPKey, ICFSecSecSessionObj> dict = indexBySecProxyIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSecSession().deleteSecSessionBySecProxyIdx( schema.getAuthorization(),
				SecProxyId );
			Iterator<ICFSecSecSessionObj> iter = dict.values().iterator();
			ICFSecSecSessionObj obj;
			List<ICFSecSecSessionObj> toForget = new LinkedList<ICFSecSecSessionObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexBySecProxyIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSecSession().deleteSecSessionBySecProxyIdx( schema.getAuthorization(),
				SecProxyId );
		}
	}

	public ICFSecSecSessionObj getSystemSession() {
		boolean transactionStarted = schema.beginTransaction();
		ICFSecSecUserObj userObj;
		ICFSecSecSessionObj sessionObj;
		try {
			userObj = schema.getSecUserTableObj().getSystemUser();
			sessionObj = readSecSessionByStartIdx( userObj.getRequiredSecUserId(),
				Calendar.getInstance() );
			if( sessionObj == null ) {
				sessionObj = newInstance();
				ICFSecSecSessionEditObj sessionEdit = sessionObj.beginEdit();
				sessionEdit.setRequiredContainerSecUser( userObj );
				sessionEdit.setRequiredStart( Calendar.getInstance() );
				sessionEdit.setOptionalFinish( null );
				sessionObj = sessionEdit.create();
				sessionEdit = null;
			}
			if( transactionStarted ) {
				schema.commit();
			}
		}
		catch( RuntimeException e ) {
			if( transactionStarted ) {
				try {
					schema.rollback();
				}
				catch( Exception e2 ) {
				}
			}
			throw e;
		}
		return( sessionObj );
	}
}
