// Description: Java 11 Table Object implementation for CFInt.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;

public class CFIntSecUserTableObj
	implements ICFIntSecUserTableObj
{
	protected ICFSecSchemaObj schema;
	private Map<CFSecSecUserPKey, ICFSecSecUserObj> members;
	private Map<CFSecSecUserPKey, ICFSecSecUserObj> allSecUser;
	private Map< CFSecSecUserByULoginIdxKey,
		ICFSecSecUserObj > indexByULoginIdx;
	private Map< CFSecSecUserByEMConfIdxKey,
		Map<CFSecSecUserPKey, ICFSecSecUserObj > > indexByEMConfIdx;
	private Map< CFSecSecUserByPwdResetIdxKey,
		Map<CFSecSecUserPKey, ICFSecSecUserObj > > indexByPwdResetIdx;
	private Map< CFSecSecUserByDefDevIdxKey,
		Map<CFSecSecUserPKey, ICFSecSecUserObj > > indexByDefDevIdx;
	public static String TABLE_NAME = "SecUser";
	public static String TABLE_DBNAME = "secuser";

	public CFIntSecUserTableObj() {
		schema = null;
		members = new HashMap<CFSecSecUserPKey, ICFSecSecUserObj>();
		allSecUser = null;
		indexByULoginIdx = null;
		indexByEMConfIdx = null;
		indexByPwdResetIdx = null;
		indexByDefDevIdx = null;
	}

	public CFIntSecUserTableObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFSecSecUserPKey, ICFSecSecUserObj>();
		allSecUser = null;
		indexByULoginIdx = null;
		indexByEMConfIdx = null;
		indexByPwdResetIdx = null;
		indexByDefDevIdx = null;
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
		allSecUser = null;
		indexByULoginIdx = null;
		indexByEMConfIdx = null;
		indexByPwdResetIdx = null;
		indexByDefDevIdx = null;
		List<ICFSecSecUserObj> toForget = new LinkedList<ICFSecSecUserObj>();
		ICFSecSecUserObj cur = null;
		Iterator<ICFSecSecUserObj> iter = members.values().iterator();
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
	 *	CFIntSecUserObj.
	 */
	public ICFSecSecUserObj newInstance() {
		ICFSecSecUserObj inst = new CFIntSecUserObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFIntSecUserObj.
	 */
	public ICFSecSecUserEditObj newEditInstance( ICFSecSecUserObj orig ) {
		ICFSecSecUserEditObj edit = new CFIntSecUserEditObj( orig );
		return( edit );
	}

	public ICFSecSecUserObj realiseSecUser( ICFSecSecUserObj Obj ) {
		ICFSecSecUserObj obj = Obj;
		CFSecSecUserPKey pkey = obj.getPKey();
		ICFSecSecUserObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFSecSecUserObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByULoginIdx != null ) {
				CFSecSecUserByULoginIdxKey keyULoginIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newULoginIdxKey();
				keyULoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				indexByULoginIdx.remove( keyULoginIdx );
			}

			if( indexByEMConfIdx != null ) {
				CFSecSecUserByEMConfIdxKey keyEMConfIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newEMConfIdxKey();
				keyEMConfIdx.setOptionalEMailConfirmUuid( keepObj.getOptionalEMailConfirmUuid() );
				Map<CFSecSecUserPKey, ICFSecSecUserObj > mapEMConfIdx = indexByEMConfIdx.get( keyEMConfIdx );
				if( mapEMConfIdx != null ) {
					mapEMConfIdx.remove( keepObj.getPKey() );
					if( mapEMConfIdx.size() <= 0 ) {
						indexByEMConfIdx.remove( keyEMConfIdx );
					}
				}
			}

			if( indexByPwdResetIdx != null ) {
				CFSecSecUserByPwdResetIdxKey keyPwdResetIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPwdResetIdxKey();
				keyPwdResetIdx.setOptionalPasswordResetUuid( keepObj.getOptionalPasswordResetUuid() );
				Map<CFSecSecUserPKey, ICFSecSecUserObj > mapPwdResetIdx = indexByPwdResetIdx.get( keyPwdResetIdx );
				if( mapPwdResetIdx != null ) {
					mapPwdResetIdx.remove( keepObj.getPKey() );
					if( mapPwdResetIdx.size() <= 0 ) {
						indexByPwdResetIdx.remove( keyPwdResetIdx );
					}
				}
			}

			if( indexByDefDevIdx != null ) {
				CFSecSecUserByDefDevIdxKey keyDefDevIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newDefDevIdxKey();
				keyDefDevIdx.setOptionalDfltDevUserId( keepObj.getOptionalDfltDevUserId() );
				keyDefDevIdx.setOptionalDfltDevName( keepObj.getOptionalDfltDevName() );
				Map<CFSecSecUserPKey, ICFSecSecUserObj > mapDefDevIdx = indexByDefDevIdx.get( keyDefDevIdx );
				if( mapDefDevIdx != null ) {
					mapDefDevIdx.remove( keepObj.getPKey() );
					if( mapDefDevIdx.size() <= 0 ) {
						indexByDefDevIdx.remove( keyDefDevIdx );
					}
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByULoginIdx != null ) {
				CFSecSecUserByULoginIdxKey keyULoginIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newULoginIdxKey();
				keyULoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				indexByULoginIdx.put( keyULoginIdx, keepObj );
			}

			if( indexByEMConfIdx != null ) {
				CFSecSecUserByEMConfIdxKey keyEMConfIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newEMConfIdxKey();
				keyEMConfIdx.setOptionalEMailConfirmUuid( keepObj.getOptionalEMailConfirmUuid() );
				Map<CFSecSecUserPKey, ICFSecSecUserObj > mapEMConfIdx = indexByEMConfIdx.get( keyEMConfIdx );
				if( mapEMConfIdx != null ) {
					mapEMConfIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPwdResetIdx != null ) {
				CFSecSecUserByPwdResetIdxKey keyPwdResetIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPwdResetIdxKey();
				keyPwdResetIdx.setOptionalPasswordResetUuid( keepObj.getOptionalPasswordResetUuid() );
				Map<CFSecSecUserPKey, ICFSecSecUserObj > mapPwdResetIdx = indexByPwdResetIdx.get( keyPwdResetIdx );
				if( mapPwdResetIdx != null ) {
					mapPwdResetIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefDevIdx != null ) {
				CFSecSecUserByDefDevIdxKey keyDefDevIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newDefDevIdxKey();
				keyDefDevIdx.setOptionalDfltDevUserId( keepObj.getOptionalDfltDevUserId() );
				keyDefDevIdx.setOptionalDfltDevName( keepObj.getOptionalDfltDevName() );
				Map<CFSecSecUserPKey, ICFSecSecUserObj > mapDefDevIdx = indexByDefDevIdx.get( keyDefDevIdx );
				if( mapDefDevIdx != null ) {
					mapDefDevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSecUser != null ) {
				allSecUser.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecUser != null ) {
				allSecUser.put( keepObj.getPKey(), keepObj );
			}

			if( indexByULoginIdx != null ) {
				CFSecSecUserByULoginIdxKey keyULoginIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newULoginIdxKey();
				keyULoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				indexByULoginIdx.put( keyULoginIdx, keepObj );
			}

			if( indexByEMConfIdx != null ) {
				CFSecSecUserByEMConfIdxKey keyEMConfIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newEMConfIdxKey();
				keyEMConfIdx.setOptionalEMailConfirmUuid( keepObj.getOptionalEMailConfirmUuid() );
				Map<CFSecSecUserPKey, ICFSecSecUserObj > mapEMConfIdx = indexByEMConfIdx.get( keyEMConfIdx );
				if( mapEMConfIdx != null ) {
					mapEMConfIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPwdResetIdx != null ) {
				CFSecSecUserByPwdResetIdxKey keyPwdResetIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPwdResetIdxKey();
				keyPwdResetIdx.setOptionalPasswordResetUuid( keepObj.getOptionalPasswordResetUuid() );
				Map<CFSecSecUserPKey, ICFSecSecUserObj > mapPwdResetIdx = indexByPwdResetIdx.get( keyPwdResetIdx );
				if( mapPwdResetIdx != null ) {
					mapPwdResetIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefDevIdx != null ) {
				CFSecSecUserByDefDevIdxKey keyDefDevIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newDefDevIdxKey();
				keyDefDevIdx.setOptionalDfltDevUserId( keepObj.getOptionalDfltDevUserId() );
				keyDefDevIdx.setOptionalDfltDevName( keepObj.getOptionalDfltDevName() );
				Map<CFSecSecUserPKey, ICFSecSecUserObj > mapDefDevIdx = indexByDefDevIdx.get( keyDefDevIdx );
				if( mapDefDevIdx != null ) {
					mapDefDevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetSecUser( ICFSecSecUserObj Obj ) {
		forgetSecUser( Obj, false );
	}

	public void forgetSecUser( ICFSecSecUserObj Obj, boolean forgetSubObjects ) {
		ICFSecSecUserObj obj = Obj;
		CFSecSecUserPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFSecSecUserObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByULoginIdx != null ) {
				CFSecSecUserByULoginIdxKey keyULoginIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newULoginIdxKey();
				keyULoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				indexByULoginIdx.remove( keyULoginIdx );
			}

			if( indexByEMConfIdx != null ) {
				CFSecSecUserByEMConfIdxKey keyEMConfIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newEMConfIdxKey();
				keyEMConfIdx.setOptionalEMailConfirmUuid( keepObj.getOptionalEMailConfirmUuid() );
				Map<CFSecSecUserPKey, ICFSecSecUserObj > mapEMConfIdx = indexByEMConfIdx.get( keyEMConfIdx );
				if( mapEMConfIdx != null ) {
					mapEMConfIdx.remove( keepObj.getPKey() );
					if( mapEMConfIdx.size() <= 0 ) {
						indexByEMConfIdx.remove( keyEMConfIdx );
					}
				}
			}

			if( indexByPwdResetIdx != null ) {
				CFSecSecUserByPwdResetIdxKey keyPwdResetIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPwdResetIdxKey();
				keyPwdResetIdx.setOptionalPasswordResetUuid( keepObj.getOptionalPasswordResetUuid() );
				Map<CFSecSecUserPKey, ICFSecSecUserObj > mapPwdResetIdx = indexByPwdResetIdx.get( keyPwdResetIdx );
				if( mapPwdResetIdx != null ) {
					mapPwdResetIdx.remove( keepObj.getPKey() );
					if( mapPwdResetIdx.size() <= 0 ) {
						indexByPwdResetIdx.remove( keyPwdResetIdx );
					}
				}
			}

			if( indexByDefDevIdx != null ) {
				CFSecSecUserByDefDevIdxKey keyDefDevIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newDefDevIdxKey();
				keyDefDevIdx.setOptionalDfltDevUserId( keepObj.getOptionalDfltDevUserId() );
				keyDefDevIdx.setOptionalDfltDevName( keepObj.getOptionalDfltDevName() );
				Map<CFSecSecUserPKey, ICFSecSecUserObj > mapDefDevIdx = indexByDefDevIdx.get( keyDefDevIdx );
				if( mapDefDevIdx != null ) {
					mapDefDevIdx.remove( keepObj.getPKey() );
					if( mapDefDevIdx.size() <= 0 ) {
						indexByDefDevIdx.remove( keyDefDevIdx );
					}
				}
			}

			if( allSecUser != null ) {
				allSecUser.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFSecSchemaObj)schema).getSecDeviceTableObj().forgetSecDeviceByUserIdx( keepObj.getRequiredSecUserId() );
				((ICFSecSchemaObj)schema).getSecSessionTableObj().forgetSecSessionBySecUserIdx( keepObj.getRequiredSecUserId() );
				((ICFSecSchemaObj)schema).getSecSessionTableObj().forgetSecSessionBySecProxyIdx( keepObj.getRequiredSecUserId() );
				((ICFSecSchemaObj)schema).getSecGrpMembTableObj().forgetSecGrpMembByUserIdx( keepObj.getRequiredSecUserId() );
				((ICFSecSchemaObj)schema).getTSecGrpMembTableObj().forgetTSecGrpMembByUserIdx( keepObj.getRequiredSecUserId() );
			}
		}
	}

	public void forgetSecUserByIdIdx( UUID SecUserId )
	{
		if( members == null ) {
			return;
		}
		CFSecSecUserPKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPKey();
		key.setRequiredSecUserId( SecUserId );
		if( members.containsKey( key ) ) {
			ICFSecSecUserObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecUserByULoginIdx( String LoginId )
	{
		if( indexByULoginIdx == null ) {
			return;
		}
		List<ICFSecSecUserObj> toForget = new LinkedList<ICFSecSecUserObj>();
		ICFSecSecUserObj cur = null;
		CFSecSecUserByULoginIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newULoginIdxKey();
		key.setRequiredLoginId( LoginId );
		if( indexByULoginIdx.containsKey( key ) ) {
			cur = indexByULoginIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFSecSecUserObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecUserByEMConfIdx( UUID EMailConfirmUuid )
	{
		if( indexByEMConfIdx == null ) {
			return;
		}
		List<ICFSecSecUserObj> toForget = new LinkedList<ICFSecSecUserObj>();
		ICFSecSecUserObj cur = null;
		CFSecSecUserByEMConfIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newEMConfIdxKey();
		key.setOptionalEMailConfirmUuid( EMailConfirmUuid );
		if( indexByEMConfIdx.containsKey( key ) ) {
			Map<CFSecSecUserPKey, ICFSecSecUserObj > mapEMConfIdx = indexByEMConfIdx.get( key );
			if( mapEMConfIdx != null ) {
				Iterator<ICFSecSecUserObj> iterDup = mapEMConfIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByEMConfIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecUserObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecUserObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecUserByPwdResetIdx( UUID PasswordResetUuid )
	{
		if( indexByPwdResetIdx == null ) {
			return;
		}
		List<ICFSecSecUserObj> toForget = new LinkedList<ICFSecSecUserObj>();
		ICFSecSecUserObj cur = null;
		CFSecSecUserByPwdResetIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPwdResetIdxKey();
		key.setOptionalPasswordResetUuid( PasswordResetUuid );
		if( indexByPwdResetIdx.containsKey( key ) ) {
			Map<CFSecSecUserPKey, ICFSecSecUserObj > mapPwdResetIdx = indexByPwdResetIdx.get( key );
			if( mapPwdResetIdx != null ) {
				Iterator<ICFSecSecUserObj> iterDup = mapPwdResetIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByPwdResetIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecUserObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecUserObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecUserByDefDevIdx( UUID DfltDevUserId,
		String DfltDevName )
	{
		if( indexByDefDevIdx == null ) {
			return;
		}
		List<ICFSecSecUserObj> toForget = new LinkedList<ICFSecSecUserObj>();
		ICFSecSecUserObj cur = null;
		CFSecSecUserByDefDevIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newDefDevIdxKey();
		key.setOptionalDfltDevUserId( DfltDevUserId );
		key.setOptionalDfltDevName( DfltDevName );
		if( indexByDefDevIdx.containsKey( key ) ) {
			Map<CFSecSecUserPKey, ICFSecSecUserObj > mapDefDevIdx = indexByDefDevIdx.get( key );
			if( mapDefDevIdx != null ) {
				Iterator<ICFSecSecUserObj> iterDup = mapDefDevIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefDevIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecUserObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecUserObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFSecSecUserObj createSecUser( ICFSecSecUserObj Obj ) {
		ICFSecSecUserObj obj = Obj;
		CFSecSecUserBuff buff = obj.getSecUserBuff();
		((ICFIntSchema)schema.getBackingStore()).getTableSecUser().createSecUser(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFSecSecUserObj readSecUser( CFSecSecUserPKey pkey ) {
		return( readSecUser( pkey, false ) );
	}

	public ICFSecSecUserObj readSecUser( CFSecSecUserPKey pkey, boolean forceRead ) {
		ICFSecSecUserObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFSecSecUserBuff readBuff = ((ICFIntSchema)schema.getBackingStore()).getTableSecUser().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredSecUserId() );
			if( readBuff != null ) {
				obj = schema.getSecUserTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFSecSecUserObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecSecUserObj lockSecUser( CFSecSecUserPKey pkey ) {
		ICFSecSecUserObj locked = null;
		CFSecSecUserBuff lockBuff = ((ICFIntSchema)schema.getBackingStore()).getTableSecUser().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecUserTableObj().newInstance();
			locked.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFSecSecUserObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockSecUser", pkey );
		}
		return( locked );
	}

	public List<ICFSecSecUserObj> readAllSecUser() {
		return( readAllSecUser( false ) );
	}

	public List<ICFSecSecUserObj> readAllSecUser( boolean forceRead ) {
		final String S_ProcName = "readAllSecUser";
		if( ( allSecUser == null ) || forceRead ) {
			Map<CFSecSecUserPKey, ICFSecSecUserObj> map = new HashMap<CFSecSecUserPKey,ICFSecSecUserObj>();
			allSecUser = map;
			CFSecSecUserBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableSecUser().readAllDerived( schema.getAuthorization() );
			CFSecSecUserBuff buff;
			ICFSecSecUserObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPKey() );
				obj.setBuff( buff );
				ICFSecSecUserObj realised = (ICFSecSecUserObj)obj.realise();
			}
		}
		int len = allSecUser.size();
		ICFSecSecUserObj arr[] = new ICFSecSecUserObj[len];
		Iterator<ICFSecSecUserObj> valIter = allSecUser.values().iterator();
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
		ArrayList<ICFSecSecUserObj> arrayList = new ArrayList<ICFSecSecUserObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecUserObj> cmp = new Comparator<ICFSecSecUserObj>() {
			public int compare( ICFSecSecUserObj lhs, ICFSecSecUserObj rhs ) {
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
					CFSecSecUserPKey lhsPKey = lhs.getPKey();
					CFSecSecUserPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecUserObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Return a sorted map of a page of the SecUser-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecUserObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	public List<ICFSecSecUserObj> pageAllSecUser(UUID priorSecUserId )
	{
		final String S_ProcName = "pageAllSecUser";
		Map<CFSecSecUserPKey, ICFSecSecUserObj> map = new HashMap<CFSecSecUserPKey,ICFSecSecUserObj>();
		CFSecSecUserBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableSecUser().pageAllBuff( schema.getAuthorization(),
			priorSecUserId );
		CFSecSecUserBuff buff;
		ICFSecSecUserObj obj;
		ICFSecSecUserObj realised;
		ArrayList<ICFSecSecUserObj> arrayList = new ArrayList<ICFSecSecUserObj>( buffList.length );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = newInstance();
			obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPKey() );
			obj.setBuff( buff );
			realised = (ICFSecSecUserObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	public ICFSecSecUserObj readSecUserByIdIdx( UUID SecUserId )
	{
		return( readSecUserByIdIdx( SecUserId,
			false ) );
	}

	public ICFSecSecUserObj readSecUserByIdIdx( UUID SecUserId, boolean forceRead )
	{
		CFSecSecUserPKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPKey();
		pkey.setRequiredSecUserId( SecUserId );
		ICFSecSecUserObj obj = readSecUser( pkey, forceRead );
		return( obj );
	}

	public ICFSecSecUserObj readSecUserByULoginIdx( String LoginId )
	{
		return( readSecUserByULoginIdx( LoginId,
			false ) );
	}

	public ICFSecSecUserObj readSecUserByULoginIdx( String LoginId, boolean forceRead )
	{
		if( indexByULoginIdx == null ) {
			indexByULoginIdx = new HashMap< CFSecSecUserByULoginIdxKey,
				ICFSecSecUserObj >();
		}
		CFSecSecUserByULoginIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newULoginIdxKey();
		key.setRequiredLoginId( LoginId );
		ICFSecSecUserObj obj = null;
		if( ( ! forceRead ) && indexByULoginIdx.containsKey( key ) ) {
			obj = indexByULoginIdx.get( key );
		}
		else {
			CFSecSecUserBuff buff = ((ICFIntSchema)schema.getBackingStore()).getTableSecUser().readDerivedByULoginIdx( schema.getAuthorization(),
				LoginId );
			if( buff != null ) {
				obj = schema.getSecUserTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPKey() );
				obj.setBuff( buff );
				obj = (ICFSecSecUserObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFSecSecUserObj> readSecUserByEMConfIdx( UUID EMailConfirmUuid )
	{
		return( readSecUserByEMConfIdx( EMailConfirmUuid,
			false ) );
	}

	public List<ICFSecSecUserObj> readSecUserByEMConfIdx( UUID EMailConfirmUuid,
		boolean forceRead )
	{
		final String S_ProcName = "readSecUserByEMConfIdx";
		CFSecSecUserByEMConfIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newEMConfIdxKey();
		key.setOptionalEMailConfirmUuid( EMailConfirmUuid );
		Map<CFSecSecUserPKey, ICFSecSecUserObj> dict;
		if( indexByEMConfIdx == null ) {
			indexByEMConfIdx = new HashMap< CFSecSecUserByEMConfIdxKey,
				Map< CFSecSecUserPKey, ICFSecSecUserObj > >();
		}
		if( ( ! forceRead ) && indexByEMConfIdx.containsKey( key ) ) {
			dict = indexByEMConfIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecUserPKey, ICFSecSecUserObj>();
			ICFSecSecUserObj obj;
			CFSecSecUserBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableSecUser().readDerivedByEMConfIdx( schema.getAuthorization(),
				EMailConfirmUuid );
			CFSecSecUserBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecUserTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPKey() );
				obj.setBuff( buff );
				ICFSecSecUserObj realised = (ICFSecSecUserObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByEMConfIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecUserObj arr[] = new ICFSecSecUserObj[len];
		Iterator<ICFSecSecUserObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecUserObj> arrayList = new ArrayList<ICFSecSecUserObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecUserObj> cmp = new Comparator<ICFSecSecUserObj>() {
			public int compare( ICFSecSecUserObj lhs, ICFSecSecUserObj rhs ) {
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
					CFSecSecUserPKey lhsPKey = lhs.getPKey();
					CFSecSecUserPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecUserObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFSecSecUserObj> readSecUserByPwdResetIdx( UUID PasswordResetUuid )
	{
		return( readSecUserByPwdResetIdx( PasswordResetUuid,
			false ) );
	}

	public List<ICFSecSecUserObj> readSecUserByPwdResetIdx( UUID PasswordResetUuid,
		boolean forceRead )
	{
		final String S_ProcName = "readSecUserByPwdResetIdx";
		CFSecSecUserByPwdResetIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPwdResetIdxKey();
		key.setOptionalPasswordResetUuid( PasswordResetUuid );
		Map<CFSecSecUserPKey, ICFSecSecUserObj> dict;
		if( indexByPwdResetIdx == null ) {
			indexByPwdResetIdx = new HashMap< CFSecSecUserByPwdResetIdxKey,
				Map< CFSecSecUserPKey, ICFSecSecUserObj > >();
		}
		if( ( ! forceRead ) && indexByPwdResetIdx.containsKey( key ) ) {
			dict = indexByPwdResetIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecUserPKey, ICFSecSecUserObj>();
			ICFSecSecUserObj obj;
			CFSecSecUserBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableSecUser().readDerivedByPwdResetIdx( schema.getAuthorization(),
				PasswordResetUuid );
			CFSecSecUserBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecUserTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPKey() );
				obj.setBuff( buff );
				ICFSecSecUserObj realised = (ICFSecSecUserObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPwdResetIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecUserObj arr[] = new ICFSecSecUserObj[len];
		Iterator<ICFSecSecUserObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecUserObj> arrayList = new ArrayList<ICFSecSecUserObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecUserObj> cmp = new Comparator<ICFSecSecUserObj>() {
			public int compare( ICFSecSecUserObj lhs, ICFSecSecUserObj rhs ) {
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
					CFSecSecUserPKey lhsPKey = lhs.getPKey();
					CFSecSecUserPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecUserObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFSecSecUserObj> readSecUserByDefDevIdx( UUID DfltDevUserId,
		String DfltDevName )
	{
		return( readSecUserByDefDevIdx( DfltDevUserId,
			DfltDevName,
			false ) );
	}

	public List<ICFSecSecUserObj> readSecUserByDefDevIdx( UUID DfltDevUserId,
		String DfltDevName,
		boolean forceRead )
	{
		final String S_ProcName = "readSecUserByDefDevIdx";
		CFSecSecUserByDefDevIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newDefDevIdxKey();
		key.setOptionalDfltDevUserId( DfltDevUserId );
		key.setOptionalDfltDevName( DfltDevName );
		Map<CFSecSecUserPKey, ICFSecSecUserObj> dict;
		if( indexByDefDevIdx == null ) {
			indexByDefDevIdx = new HashMap< CFSecSecUserByDefDevIdxKey,
				Map< CFSecSecUserPKey, ICFSecSecUserObj > >();
		}
		if( ( ! forceRead ) && indexByDefDevIdx.containsKey( key ) ) {
			dict = indexByDefDevIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecUserPKey, ICFSecSecUserObj>();
			ICFSecSecUserObj obj;
			CFSecSecUserBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableSecUser().readDerivedByDefDevIdx( schema.getAuthorization(),
				DfltDevUserId,
				DfltDevName );
			CFSecSecUserBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecUserTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPKey() );
				obj.setBuff( buff );
				ICFSecSecUserObj realised = (ICFSecSecUserObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefDevIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecUserObj arr[] = new ICFSecSecUserObj[len];
		Iterator<ICFSecSecUserObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecUserObj> arrayList = new ArrayList<ICFSecSecUserObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecUserObj> cmp = new Comparator<ICFSecSecUserObj>() {
			public int compare( ICFSecSecUserObj lhs, ICFSecSecUserObj rhs ) {
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
					CFSecSecUserPKey lhsPKey = lhs.getPKey();
					CFSecSecUserPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecUserObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Read a page of data as a List of SecUser-derived instances sorted by their primary keys,
	 *	as identified by the duplicate EMConfIdx key attributes.
	 *
	 *	@param	argEMailConfirmUuid	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecUser-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecSecUserObj> pageSecUserByEMConfIdx( UUID EMailConfirmUuid,
		UUID priorSecUserId )
	{
		final String S_ProcName = "pageSecUserByEMConfIdx";
		CFSecSecUserByEMConfIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newEMConfIdxKey();
		key.setOptionalEMailConfirmUuid( EMailConfirmUuid );
		List<ICFSecSecUserObj> retList = new LinkedList<ICFSecSecUserObj>();
		ICFSecSecUserObj obj;
		CFSecSecUserBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableSecUser().pageBuffByEMConfIdx( schema.getAuthorization(),
				EMailConfirmUuid,
			priorSecUserId );
		CFSecSecUserBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecUserTableObj().newInstance();
			obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPKey() );
			obj.setBuff( buff );
			ICFSecSecUserObj realised = (ICFSecSecUserObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecUser-derived instances sorted by their primary keys,
	 *	as identified by the duplicate PwdResetIdx key attributes.
	 *
	 *	@param	argPasswordResetUuid	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecUser-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecSecUserObj> pageSecUserByPwdResetIdx( UUID PasswordResetUuid,
		UUID priorSecUserId )
	{
		final String S_ProcName = "pageSecUserByPwdResetIdx";
		CFSecSecUserByPwdResetIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPwdResetIdxKey();
		key.setOptionalPasswordResetUuid( PasswordResetUuid );
		List<ICFSecSecUserObj> retList = new LinkedList<ICFSecSecUserObj>();
		ICFSecSecUserObj obj;
		CFSecSecUserBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableSecUser().pageBuffByPwdResetIdx( schema.getAuthorization(),
				PasswordResetUuid,
			priorSecUserId );
		CFSecSecUserBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecUserTableObj().newInstance();
			obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPKey() );
			obj.setBuff( buff );
			ICFSecSecUserObj realised = (ICFSecSecUserObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecUser-derived instances sorted by their primary keys,
	 *	as identified by the duplicate DefDevIdx key attributes.
	 *
	 *	@param	argDfltDevUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@param	argDfltDevName	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecUser-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecSecUserObj> pageSecUserByDefDevIdx( UUID DfltDevUserId,
		String DfltDevName,
		UUID priorSecUserId )
	{
		final String S_ProcName = "pageSecUserByDefDevIdx";
		CFSecSecUserByDefDevIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newDefDevIdxKey();
		key.setOptionalDfltDevUserId( DfltDevUserId );
		key.setOptionalDfltDevName( DfltDevName );
		List<ICFSecSecUserObj> retList = new LinkedList<ICFSecSecUserObj>();
		ICFSecSecUserObj obj;
		CFSecSecUserBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableSecUser().pageBuffByDefDevIdx( schema.getAuthorization(),
				DfltDevUserId,
				DfltDevName,
			priorSecUserId );
		CFSecSecUserBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecUserTableObj().newInstance();
			obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPKey() );
			obj.setBuff( buff );
			ICFSecSecUserObj realised = (ICFSecSecUserObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	public ICFSecSecUserObj updateSecUser( ICFSecSecUserObj Obj ) {
		ICFSecSecUserObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableSecUser().updateSecUser( schema.getAuthorization(),
			Obj.getSecUserBuff() );
		obj = (ICFSecSecUserObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteSecUser( ICFSecSecUserObj Obj ) {
		ICFSecSecUserObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableSecUser().deleteSecUser( schema.getAuthorization(),
			obj.getSecUserBuff() );
		obj.forget( true );
	}

	public void deleteSecUserByIdIdx( UUID SecUserId )
	{
		CFSecSecUserPKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPKey();
		pkey.setRequiredSecUserId( SecUserId );
		ICFSecSecUserObj obj = readSecUser( pkey );
		if( obj != null ) {
			ICFSecSecUserEditObj editObj = (ICFSecSecUserEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFSecSecUserEditObj)obj.beginEdit();
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

	public void deleteSecUserByULoginIdx( String LoginId )
	{
		if( indexByULoginIdx == null ) {
			indexByULoginIdx = new HashMap< CFSecSecUserByULoginIdxKey,
				ICFSecSecUserObj >();
		}
		CFSecSecUserByULoginIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newULoginIdxKey();
		key.setRequiredLoginId( LoginId );
		ICFSecSecUserObj obj = null;
		if( indexByULoginIdx.containsKey( key ) ) {
			obj = indexByULoginIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableSecUser().deleteSecUserByULoginIdx( schema.getAuthorization(),
				LoginId );
			obj.forget( true );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableSecUser().deleteSecUserByULoginIdx( schema.getAuthorization(),
				LoginId );
		}
	}

	public void deleteSecUserByEMConfIdx( UUID EMailConfirmUuid )
	{
		CFSecSecUserByEMConfIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newEMConfIdxKey();
		key.setOptionalEMailConfirmUuid( EMailConfirmUuid );
		if( indexByEMConfIdx == null ) {
			indexByEMConfIdx = new HashMap< CFSecSecUserByEMConfIdxKey,
				Map< CFSecSecUserPKey, ICFSecSecUserObj > >();
		}
		if( indexByEMConfIdx.containsKey( key ) ) {
			Map<CFSecSecUserPKey, ICFSecSecUserObj> dict = indexByEMConfIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableSecUser().deleteSecUserByEMConfIdx( schema.getAuthorization(),
				EMailConfirmUuid );
			Iterator<ICFSecSecUserObj> iter = dict.values().iterator();
			ICFSecSecUserObj obj;
			List<ICFSecSecUserObj> toForget = new LinkedList<ICFSecSecUserObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByEMConfIdx.remove( key );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableSecUser().deleteSecUserByEMConfIdx( schema.getAuthorization(),
				EMailConfirmUuid );
		}
	}

	public void deleteSecUserByPwdResetIdx( UUID PasswordResetUuid )
	{
		CFSecSecUserByPwdResetIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newPwdResetIdxKey();
		key.setOptionalPasswordResetUuid( PasswordResetUuid );
		if( indexByPwdResetIdx == null ) {
			indexByPwdResetIdx = new HashMap< CFSecSecUserByPwdResetIdxKey,
				Map< CFSecSecUserPKey, ICFSecSecUserObj > >();
		}
		if( indexByPwdResetIdx.containsKey( key ) ) {
			Map<CFSecSecUserPKey, ICFSecSecUserObj> dict = indexByPwdResetIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableSecUser().deleteSecUserByPwdResetIdx( schema.getAuthorization(),
				PasswordResetUuid );
			Iterator<ICFSecSecUserObj> iter = dict.values().iterator();
			ICFSecSecUserObj obj;
			List<ICFSecSecUserObj> toForget = new LinkedList<ICFSecSecUserObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByPwdResetIdx.remove( key );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableSecUser().deleteSecUserByPwdResetIdx( schema.getAuthorization(),
				PasswordResetUuid );
		}
	}

	public void deleteSecUserByDefDevIdx( UUID DfltDevUserId,
		String DfltDevName )
	{
		CFSecSecUserByDefDevIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecUser().newDefDevIdxKey();
		key.setOptionalDfltDevUserId( DfltDevUserId );
		key.setOptionalDfltDevName( DfltDevName );
		if( indexByDefDevIdx == null ) {
			indexByDefDevIdx = new HashMap< CFSecSecUserByDefDevIdxKey,
				Map< CFSecSecUserPKey, ICFSecSecUserObj > >();
		}
		if( indexByDefDevIdx.containsKey( key ) ) {
			Map<CFSecSecUserPKey, ICFSecSecUserObj> dict = indexByDefDevIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableSecUser().deleteSecUserByDefDevIdx( schema.getAuthorization(),
				DfltDevUserId,
				DfltDevName );
			Iterator<ICFSecSecUserObj> iter = dict.values().iterator();
			ICFSecSecUserObj obj;
			List<ICFSecSecUserObj> toForget = new LinkedList<ICFSecSecUserObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByDefDevIdx.remove( key );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableSecUser().deleteSecUserByDefDevIdx( schema.getAuthorization(),
				DfltDevUserId,
				DfltDevName );
		}
	}

	public ICFSecSecUserObj getSystemUser() {
		boolean transactionStarted = schema.beginTransaction();
		ICFSecSecUserObj secUserObj;
		try {
			secUserObj = schema.getSecUserTableObj().readSecUserByULoginIdx( "system" );
			if( secUserObj == null ) {
				secUserObj = newInstance();
				ICFSecSecUserEditObj secUserEdit = secUserObj.beginEdit();
				secUserEdit.setRequiredEMailAddress( "system" );
				secUserObj = secUserEdit.create();
				secUserEdit = null;
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
		return( secUserObj );
	}
}
